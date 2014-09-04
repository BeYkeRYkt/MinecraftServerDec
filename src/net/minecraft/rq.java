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

public class rq implements nh, pm {

	private static final AtomicInteger b = new AtomicInteger(0);
	private static final Logger c = LogManager.getLogger();
	private static final Random d = new Random();
	private final byte[] e = new byte[4];
	private final MinecraftServer f;
	public final gr a;
	private rt g;
	private int h;
	private GameProfile i;
	private String j;
	private SecretKey k;

	public rq(MinecraftServer var1, gr var2) {
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
			hy var2 = new hy(var1);
			this.a.a((id) (new ng(var2)));
			this.a.a((ho) var2);
		} catch (Exception var3) {
			c.error("Error whilst disconnecting player", (Throwable) var3);
		}

	}

	public void b() {
		if (!this.i.isComplete()) {
			this.i = this.a(this.i);
		}

		String var1 = this.f.an().a(this.a.b(), this.i);
		if (var1 != null) {
			this.a(var1);
		} else {
			this.g = rt.e;
			if (this.f.aI() >= 0 && !this.a.c()) {
				this.a.a(new nf(this.f.aI()), new rr(this), new GenericFutureListener[0]);
			}

			this.a.a((id) (new nd(this.i)));
			this.f.an().a(this.a, this.f.an().f(this.i));
		}

	}

	public void a(ho var1) {
		c.info(this.d() + " lost connection: " + var1.c());
	}

	public String d() {
		return this.i != null ? this.i.toString() + " (" + this.a.b().toString() + ")" : String.valueOf(this.a.b());
	}

	public void a(ni var1) {
		Validate.validState(this.g == rt.a, "Unexpected hello packet", new Object[0]);
		this.i = var1.a();
		if (this.f.isOnlineMode() && !this.a.c()) {
			this.g = rt.b;
			this.a.a((id) (new ne(this.j, this.f.P().getPublic(), this.e)));
		} else {
			this.g = rt.d;
		}

	}

	public void a(nj var1) {
		Validate.validState(this.g == rt.b, "Unexpected key packet", new Object[0]);
		PrivateKey var2 = this.f.P().getPrivate();
		if (!Arrays.equals(this.e, var1.b(var2))) {
			throw new IllegalStateException("Invalid nonce!");
		} else {
			this.k = var1.a(var2);
			this.g = rt.c;
			this.a.a(this.k);
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
