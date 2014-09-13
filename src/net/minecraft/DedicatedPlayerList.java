package net.minecraft;

import com.mojang.authlib.GameProfile;
import java.io.IOException;
import net.minecraft.server.MinecraftServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DedicatedPlayerList extends PlayerList {

	private static final Logger h = LogManager.getLogger();

	public DedicatedPlayerList(DedicatedMinecraftServer var1) {
		super(var1);
		this.a(var1.getIntProperty("view-distance", 10));
		this.maxPlayers = var1.getIntProperty("max-players", 20);
		this.a(var1.getBooleanProperty("white-list", false));
		if (!var1.isSinglePlayer()) {
			this.getProfileBans().setEnabled(true);
			this.getIpBanList().setEnabled(true);
		}

		this.z();
		this.x();
		this.y();
		this.w();
		this.A();
		this.C();
		this.B();
		if (!this.getWhitelist().getFile().exists()) {
			this.D();
		}

	}

	public void a(boolean var1) {
		super.a(var1);
		this.b().setProperty("white-list", (Object) Boolean.valueOf(var1));
		this.b().saveProperties();
	}

	public void addOp(GameProfile var1) {
		super.addOp(var1);
		this.B();
	}

	public void removeOp(GameProfile var1) {
		super.removeOp(var1);
		this.B();
	}

	public void removeWhitelist(GameProfile var1) {
		super.removeWhitelist(var1);
		this.D();
	}

	public void addWhitelist(GameProfile var1) {
		super.addWhitelist(var1);
		this.D();
	}

	public void a() {
		this.C();
	}

	private void w() {
		try {
			this.getIpBanList().save();
		} catch (IOException var2) {
			h.warn("Failed to save ip banlist: ", (Throwable) var2);
		}

	}

	private void x() {
		try {
			this.getProfileBans().save();
		} catch (IOException var2) {
			h.warn("Failed to save user banlist: ", (Throwable) var2);
		}

	}

	private void y() {
		try {
			this.getIpBanList().load();
		} catch (IOException var2) {
			h.warn("Failed to load ip banlist: ", (Throwable) var2);
		}

	}

	private void z() {
		try {
			this.getProfileBans().load();
		} catch (IOException var2) {
			h.warn("Failed to load user banlist: ", (Throwable) var2);
		}

	}

	private void A() {
		try {
			this.getOpList().load();
		} catch (Exception var2) {
			h.warn("Failed to load operators list: ", (Throwable) var2);
		}

	}

	private void B() {
		try {
			this.getOpList().save();
		} catch (Exception var2) {
			h.warn("Failed to save operators list: ", (Throwable) var2);
		}

	}

	private void C() {
		try {
			this.getWhitelist().load();
		} catch (Exception var2) {
			h.warn("Failed to load white-list: ", (Throwable) var2);
		}

	}

	private void D() {
		try {
			this.getWhitelist().save();
		} catch (Exception var2) {
			h.warn("Failed to save white-list: ", (Throwable) var2);
		}

	}

	public boolean canJoin(GameProfile var1) {
		return !this.s() || this.isOp(var1) || this.getWhitelist().isWhitelisted(var1);
	}

	public DedicatedMinecraftServer b() {
		return (DedicatedMinecraftServer) super.c();
	}

	// $FF: synthetic method
	public MinecraftServer c() {
		return this.b();
	}

}
