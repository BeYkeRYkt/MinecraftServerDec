package net.minecraft;

import com.google.common.collect.Lists;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Proxy;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import net.minecraft.server.MinecraftServer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DedicatedMinecraftServer extends MinecraftServer implements pj {

	private static final Logger j = LogManager.getLogger();
	private final List k = Collections.synchronizedList(Lists.newArrayList());
	private tf l;
	private ti m;
	private pl n;
	private pb o;
	private boolean p;
	private arc q;
	private boolean r;

	public DedicatedMinecraftServer(File var1) {
		super(var1, Proxy.NO_PROXY, usercache);
		new pp(this, "Server Infinisleeper");
	}

	protected boolean i() throws UnknownHostException {
		pq var1 = new pq(this, "Server console handler");
		var1.setDaemon(true);
		var1.start();
		j.info("Starting minecraft server version 1.8");
		if (Runtime.getRuntime().maxMemory() / 1024L / 1024L < 512L) {
			j.warn("To start the server with more ram, launch it as \"java -Xmx1024M -Xms1024M -jar minecraft_server.jar\"");
		}

		j.info("Loading properties");
		this.n = new pl(new File("server.properties"));
		this.o = new pb(new File("eula.txt"));
		if (!this.o.a()) {
			j.info("You need to agree to the EULA in order to run the server. Go to eula.txt for more info.");
			this.o.b();
			return false;
		} else {
			if (this.S()) {
				this.setIp("127.0.0.1");
			} else {
				this.setOnlineMode(this.n.a("online-mode", true));
				this.setIp(this.n.a("server-ip", ""));
			}

			this.setAnimalSpawnEnabled(this.n.a("spawn-animals", true));
			this.setNPCSpawnEnabled(this.n.a("spawn-npcs", true));
			this.setPVP(this.n.a("pvp", true));
			this.setAllowFlight(this.n.a("allow-flight", false));
			this.a_(this.n.a("resource-pack", ""), this.n.a("resource-pack-hash", ""));
			this.m(this.n.a("motd", "A Minecraft Server"));
			this.i(this.n.a("force-gamemode", false));
			this.d(this.n.a("player-idle-timeout", 0));
			if (this.n.a("difficulty", 1) < 0) {
				this.n.a("difficulty", (Object) Integer.valueOf(0));
			} else if (this.n.a("difficulty", 1) > 3) {
				this.n.a("difficulty", (Object) Integer.valueOf(3));
			}

			this.p = this.n.a("generate-structures", true);
			int var2 = this.n.a("gamemode", arc.b.a());
			this.q = arb.a(var2);
			j.info("Default game type: " + this.q);
			InetAddress var3 = null;
			if (this.getIp().length() > 0) {
				var3 = InetAddress.getByName(this.getIp());
			}

			if (this.Q() < 0) {
				this.b(this.n.a("server-port", 25565));
			}

			j.info("Generating keypair");
			this.a(ug.b());
			j.info("Starting Minecraft server on " + (this.getIp().length() == 0 ? "*" : this.getIp()) + ":" + this.Q());

			try {
				this.ao().a(var3, this.Q());
			} catch (Exception var17) {
				j.warn("**** FAILED TO BIND TO PORT!");
				j.warn("The exception was: {}", new Object[] { var17.toString() });
				j.warn("Perhaps a server is already running on that port?");
				return false;
			}

			if (!this.isOnlineMode()) {
				j.warn("**** SERVER IS RUNNING IN OFFLINE/INSECURE MODE!");
				j.warn("The server will make no attempt to authenticate usernames. Beware.");
				j.warn("While this makes the game possible to play without internet access, it also opens up the ability for hackers to connect with any username they choose.");
				j.warn("To change this, set \"online-mode\" to \"true\" in the server.properties file.");
			}

			if (this.aP()) {
				this.aD().c();
			}

			if (!sf.a(this.n)) {
				return false;
			} else {
				this.a((PlayerList) (new pn(this)));
				long var4 = System.nanoTime();
				if (this.T() == null) {
					this.k(this.n.a("level-name", "world"));
				}

				String var6 = this.n.a("level-seed", "");
				String var7 = this.n.a("level-type", "DEFAULT");
				String var8 = this.n.a("generator-settings", "");
				long var9 = (new Random()).nextLong();
				if (var6.length() > 0) {
					try {
						long var11 = Long.parseLong(var6);
						if (var11 != 0L) {
							var9 = var11;
						}
					} catch (NumberFormatException var16) {
						var9 = (long) var6.hashCode();
					}
				}

				are var18 = are.a(var7);
				if (var18 == null) {
					var18 = are.b;
				}

				this.az();
				this.aj();
				this.p();
				this.ac();
				this.aI();
				this.c(this.n.a("max-build-height", 256));
				this.c((this.al() + 8) / 16 * 16);
				this.c(uv.a(this.al(), 64, 256));
				this.n.a("max-build-height", (Object) Integer.valueOf(this.al()));
				j.info("Preparing level \"" + this.T() + "\"");
				this.a(this.T(), this.T(), var9, var18, var8);
				long var12 = System.nanoTime() - var4;
				String var14 = String.format("%.3fs", new Object[] { Double.valueOf((double) var12 / 1.0E9D) });
				j.info("Done (" + var14 + ")! For help, type \"help\" or \"?\"");
				if (this.n.a("enable-query", false)) {
					j.info("Starting GS4 status listener");
					this.l = new tf(this);
					this.l.a();
				}

				if (this.n.a("enable-rcon", false)) {
					j.info("Starting remote control listener");
					this.m = new ti(this);
					this.m.a();
				}

				if (this.aQ() > 0L) {
					Thread var15 = new Thread(new ServerWatchdog(this));
					var15.setName("Server Watchdog");
					var15.setDaemon(true);
					var15.start();
				}

				return true;
			}
		}
	}

	public void a(arc var1) {
		super.a(var1);
		this.q = var1;
	}

	public boolean l() {
		return this.p;
	}

	public arc m() {
		return this.q;
	}

	public vt n() {
		return vt.a(this.n.a("difficulty", 1));
	}

	public boolean o() {
		return this.n.a("hardcore", false);
	}

	protected void a(CrashReport var1) {
		while (this.isTicking()) {
			this.aM();

			try {
				Thread.sleep(10L);
			} catch (InterruptedException var3) {
				;
			}
		}

	}

	public CrashReport b(CrashReport var1) {
		var1 = super.b(var1);
		var1.g().a("Is Modded", (Callable) (new pr(this)));
		var1.g().a("Type", (Callable) (new ps(this)));
		return var1;
	}

	protected void x() {
		System.exit(0);
	}

	public void z() {
		super.z();
		this.aM();
	}

	public boolean A() {
		return this.n.a("allow-nether", true);
	}

	public boolean V() {
		return this.n.a("spawn-monsters", true);
	}

	public void a(Snooper var1) {
		var1.a("whitelist_enabled", Boolean.valueOf(this.aN().s()));
		var1.a("whitelist_count", Integer.valueOf(this.aN().m().length));
		super.a(var1);
	}

	public boolean ac() {
		return this.n.a("snooper-enabled", true);
	}

	public void a(String var1, CommandSenderInterface var2) {
		this.k.add(new oz(var1, var2));
	}

	public void aM() {
		while (!this.k.isEmpty()) {
			oz var1 = (oz) this.k.remove(0);
			this.getCommandHandler().a(var1.b, var1.a);
		}

	}

	public boolean ad() {
		return true;
	}

	public pn aN() {
		return (pn) super.an();
	}

	public int a(String var1, int var2) {
		return this.n.a(var1, var2);
	}

	public String a(String var1, String var2) {
		return this.n.a(var1, var2);
	}

	public boolean a(String var1, boolean var2) {
		return this.n.a(var1, var2);
	}

	public void a(String var1, Object var2) {
		this.n.a(var1, var2);
	}

	public void a() {
		this.n.b();
	}

	public String b() {
		File var1 = this.n.c();
		return var1 != null ? var1.getAbsolutePath() : "No settings file";
	}

	public void aO() {
		pw.a(this);
		this.r = true;
	}

	public boolean aq() {
		return this.r;
	}

	public String a(arc var1, boolean var2) {
		return "";
	}

	public boolean aj() {
		return this.n.a("enable-command-block", false);
	}

	public int au() {
		return this.n.a("spawn-protection", super.au());
	}

	public boolean a(World var1, dt var2, ahd var3) {
		if (var1.t.q() != 0) {
			return false;
		} else if (this.aN().n().d()) {
			return false;
		} else if (this.aN().g(var3.cc())) {
			return false;
		} else if (this.au() <= 0) {
			return false;
		} else {
			dt var4 = var1.M();
			int var5 = uv.a(var2.n() - var4.n());
			int var6 = uv.a(var2.p() - var4.p());
			int var7 = Math.max(var5, var6);
			return var7 <= this.au();
		}
	}

	public int p() {
		return this.n.a("op-permission-level", 4);
	}

	public void d(int var1) {
		super.d(var1);
		this.n.a("player-idle-timeout", (Object) Integer.valueOf(var1));
		this.a();
	}

	public boolean az() {
		return this.n.a("announce-player-achievements", true);
	}

	public int aG() {
		int var1 = this.n.a("max-world-size", super.aG());
		if (var1 < 1) {
			var1 = 1;
		} else if (var1 > super.aG()) {
			var1 = super.aG();
		}

		return var1;
	}

	public int aI() {
		return this.n.a("network-compression-threshold", super.aI());
	}

	protected boolean aP() {
		boolean var2 = false;

		int var1;
		for (var1 = 0; !var2 && var1 <= 2; ++var1) {
			if (var1 > 0) {
				j.warn("Encountered a problem while converting the user banlist, retrying in a few seconds");
				this.aS();
			}

			var2 = sf.a((MinecraftServer) this);
		}

		boolean var3 = false;

		for (var1 = 0; !var3 && var1 <= 2; ++var1) {
			if (var1 > 0) {
				j.warn("Encountered a problem while converting the ip banlist, retrying in a few seconds");
				this.aS();
			}

			var3 = sf.b((MinecraftServer) this);
		}

		boolean var4 = false;

		for (var1 = 0; !var4 && var1 <= 2; ++var1) {
			if (var1 > 0) {
				j.warn("Encountered a problem while converting the op list, retrying in a few seconds");
				this.aS();
			}

			var4 = sf.c((MinecraftServer) this);
		}

		boolean var5 = false;

		for (var1 = 0; !var5 && var1 <= 2; ++var1) {
			if (var1 > 0) {
				j.warn("Encountered a problem while converting the whitelist, retrying in a few seconds");
				this.aS();
			}

			var5 = sf.d((MinecraftServer) this);
		}

		boolean var6 = false;

		for (var1 = 0; !var6 && var1 <= 2; ++var1) {
			if (var1 > 0) {
				j.warn("Encountered a problem while converting the player save files, retrying in a few seconds");
				this.aS();
			}

			var6 = sf.a(this, this.n);
		}

		return var2 || var3 || var4 || var5 || var6;
	}

	private void aS() {
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException var2) {
			;
		}
	}

	public long aQ() {
		return this.n.a("max-tick-time", TimeUnit.MINUTES.toMillis(1L));
	}

	// $FF: synthetic method
	public PlayerList an() {
		return this.aN();
	}

	// $FF: synthetic method
	static Logger aR() {
		return j;
	}

}
