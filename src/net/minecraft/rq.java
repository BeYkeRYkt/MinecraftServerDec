package net.minecraft;

import com.google.common.base.Charsets;
import com.mojang.authlib.GameProfile;
import io.netty.util.concurrent.GenericFutureListener;
import java.security.PrivateKey;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import javax.crypto.SecretKey;
import net.minecraft.server.MinecraftServer;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class rq implements LoginServerboundPacketListener, pm {

	private static final AtomicInteger b = new AtomicInteger(0);
	private static final Logger c = LogManager.getLogger();
	private static final Random d = new Random();
	private final byte[] e = new byte[4];
	private final MinecraftServer f;
	public final NetworkManager a;
	private rt g;
	private int h;
	private GameProfile i;
	private String j;
	private SecretKey k;

	public rq(MinecraftServer var1, NetworkManager var2) {
		this.g = rt.a;
		this.j = "";
		this.f = var1;
		this.a = var2;
		d.nextBytes(this.e);
	}

	public void c() {
		if (this.g == rt.d) {
			this.b();
		}

		if (this.h++ == 600) {
			this.a("Took too long to log in");
		}

	}

	public void a(String var1) {
		try {
			c.info("Disconnecting " + this.d() + ": " + var1);
			ChatComponentText var2 = new ChatComponentText(var1);
			this.a.handleSendPacket((Packet) (new PacketLoginOutDisconnect(var2)));
			this.a.disconnect((IChatBaseComponent) var2);
		} catch (Exception var3) {
			c.error("Error whilst disconnecting player", (Throwable) var3);
		}

	}

	public void b() {
		if (!this.i.isComplete()) {
			this.i = this.a(this.i);
		}

		String var1 = this.f.getPlayerList().a(this.a.getAddress(), this.i);
		if (var1 != null) {
			this.a(var1);
		} else {
			this.g = rt.e;
			if (this.f.getCompressionThreshold() >= 0 && !this.a.isLocal()) {
				this.a.handleSendPacket(new PacketLoginOutSetCompression(this.f.getCompressionThreshold()), new rr(this));
			}

			this.a.handleSendPacket((Packet) (new PacketLoginOutLoginSuccess(this.i)));
			this.f.getPlayerList().a(this.a, this.f.getPlayerList().f(this.i));
		}

	}

	public void handle(IChatBaseComponent var1) {
		c.info(this.d() + " lost connection: " + var1.c());
	}

	public String d() {
		return this.i != null ? this.i.toString() + " (" + this.a.getAddress().toString() + ")" : String.valueOf(this.a.getAddress());
	}

	public void handle(PacketLoginInLoginStart var1) {
		Validate.validState(this.g == rt.a, "Unexpected hello packet", new Object[0]);
		this.i = var1.getProfile();
		if (this.f.isOnlineMode() && !this.a.isLocal()) {
			this.g = rt.b;
			this.a.handleSendPacket((Packet) (new PacketLoginOutEncryptionRequest(this.j, this.f.P().getPublic(), this.e)));
		} else {
			this.g = rt.d;
		}

	}

	public void handle(PacketLoginInEncryptionResponse var1) {
		Validate.validState(this.g == rt.b, "Unexpected key packet", new Object[0]);
		PrivateKey var2 = this.f.P().getPrivate();
		if (!Arrays.equals(this.e, var1.getVerifyToken(var2))) {
			throw new IllegalStateException("Invalid nonce!");
		} else {
			this.k = var1.getSharedKey(var2);
			this.g = rt.c;
			this.a.setEncryption(this.k);
			(new rs(this, "User Authenticator #" + b.incrementAndGet())).start();
		}
	}

	protected GameProfile a(GameProfile var1) {
		UUID var2 = UUID.nameUUIDFromBytes(("OfflinePlayer:" + var1.getName()).getBytes(Charsets.UTF_8));
		return new GameProfile(var2, var1.getName());
	}

	// $FF: synthetic method
	static MinecraftServer a(rq var0) {
		return var0.f;
	}

	// $FF: synthetic method
	static GameProfile b(rq var0) {
		return var0.i;
	}

	// $FF: synthetic method
	static String c(rq var0) {
		return var0.j;
	}

	// $FF: synthetic method
	static SecretKey d(rq var0) {
		return var0.k;
	}

	// $FF: synthetic method
	static GameProfile a(rq var0, GameProfile var1) {
		return var0.i = var1;
	}

	// $FF: synthetic method
	static Logger e() {
		return c;
	}

	// $FF: synthetic method
	static rt a(rq var0, rt var1) {
		return var0.g = var1;
	}

}
