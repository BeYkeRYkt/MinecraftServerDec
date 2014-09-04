package net.minecraft;

import java.io.File;
import java.net.InetAddress;
import java.net.Proxy;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import net.minecraft.server.MinecraftServer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DedicatedMinecraftServer extends MinecraftServer implements pj {

	private static final Logger logger = LogManager.getLogger();
	private final List<PendingServerCommand> pendingCommands = Collections.synchronizedList(new ArrayList<PendingServerCommand>());
	private QueryListener query;
	private RconListener rcon;
	private ServerProperties serverProperties;
	private EulaAgreementChecker tehDramaDocument;
	private GameMode serverGameMode;
	private boolean generateStructures;
	private boolean guiEnabled;

	public DedicatedMinecraftServer(File var1) {
		super(var1, Proxy.NO_PROXY, usercache);
		new ServerInfiSleeper(this, "Server Infinisleeper");
	}

	protected boolean startServer() throws UnknownHostException {
		ServerConsoleReader reader = new ServerConsoleReader(this, "Server console handler");
		reader.setDaemon(true);
		reader.start();
		logger.info("Starting minecraft server version 1.8");
		if (Runtime.getRuntime().maxMemory() / 1024L / 1024L < 512L) {
			logger.warn("To start the server with more ram, launch it as \"java -Xmx1024M -Xms1024M -jar minecraft_server.jar\"");
		}

		logger.info("Loading properties");
		this.serverProperties = new ServerProperties(new File("server.properties"));
		this.tehDramaDocument = new EulaAgreementChecker(new File("eula.txt"));
		if (!this.tehDramaDocument.isAgreed()) {
			logger.info("You need to agree to the EULA in order to run the server. Go to eula.txt for more info.");
			this.tehDramaDocument.write();
			return false;
		} else {
			if (this.isSinglePlayer()) {
				this.setIp("127.0.0.1");
			} else {
				this.setOnlineMode(this.serverProperties.getBoolean("online-mode", true));
				this.setIp(this.serverProperties.getString("server-ip", ""));
			}

			this.setAnimalSpawnEnabled(this.serverProperties.getBoolean("spawn-animals", true));
			this.setNPCSpawnEnabled(this.serverProperties.getBoolean("spawn-npcs", true));
			this.setPVP(this.serverProperties.getBoolean("pvp", true));
			this.setAllowFlight(this.serverProperties.getBoolean("allow-flight", false));
			this.setResourcePack(this.serverProperties.getString("resource-pack", ""), this.serverProperties.getString("resource-pack-hash", ""));
			this.setMotd(this.serverProperties.getString("motd", "A Minecraft Server"));
			this.setForceGameModeEnabled(this.serverProperties.getBoolean("force-gamemode", false));
			this.setIdleTimeout(this.serverProperties.getInt("player-idle-timeout", 0));
			if (this.serverProperties.getInt("difficulty", 1) < 0) {
				this.serverProperties.setProperty("difficulty", Integer.valueOf(0));
			} else if (this.serverProperties.getInt("difficulty", 1) > 3) {
				this.serverProperties.setProperty("difficulty", Integer.valueOf(3));
			}

			this.generateStructures = this.serverProperties.getBoolean("generate-structures", true);
			int var2 = this.serverProperties.getInt("gamemode", GameMode.SURVIVAL.getId());
			this.serverGameMode = arb.a(var2);
			logger.info("Default game type: " + this.serverGameMode);
			InetAddress address = null;
			if (this.getIp().length() > 0) {
				address = InetAddress.getByName(this.getIp());
			}

			if (this.getPort() < 0) {
				this.setPort(this.serverProperties.getInt("server-port", 25565));
			}

			logger.info("Generating keypair");
			this.a(ug.b());
			logger.info("Starting Minecraft server on " + (this.getIp().length() == 0 ? "*" : this.getIp()) + ":" + this.getPort());

			try {
				this.ao().a(address, this.getPort());
			} catch (Exception var17) {
				logger.warn("**** FAILED TO BIND TO PORT!");
				logger.warn("The exception was: {}", new Object[] { var17.toString() });
				logger.warn("Perhaps a server is already running on that port?");
				return false;
			}

			if (!this.isOnlineMode()) {
				logger.warn("**** SERVER IS RUNNING IN OFFLINE/INSECURE MODE!");
				logger.warn("The server will make no attempt to authenticate usernames. Beware.");
				logger.warn("While this makes the game possible to play without internet access, it also opens up the ability for hackers to connect with any username they choose.");
				logger.warn("To change this, set \"online-mode\" to \"true\" in the server.properties file.");
			}

			if (this.aP()) {
				this.aD().c();
			}

			if (!sf.a(this.serverProperties)) {
				return false;
			} else {
				this.a((PlayerList) (new DedicatedPlayerList(this)));
				long var4 = System.nanoTime();
				if (this.T() == null) {
					this.k(this.serverProperties.getString("level-name", "world"));
				}

				String var6 = this.serverProperties.getString("level-seed", "");
				String var7 = this.serverProperties.getString("level-type", "DEFAULT");
				String var8 = this.serverProperties.getString("generator-settings", "");
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
				this.isCommandBlockEnabled();
				this.getOpPermissionLevel();
				this.isSnooperEnabled();
				this.aI();
				this.c(this.serverProperties.getInt("max-build-height", 256));
				this.c((this.al() + 8) / 16 * 16);
				this.c(uv.a(this.al(), 64, 256));
				this.serverProperties.setProperty("max-build-height", (Object) Integer.valueOf(this.al()));
				logger.info("Preparing level \"" + this.T() + "\"");
				this.a(this.T(), this.T(), var9, var18, var8);
				long var12 = System.nanoTime() - var4;
				String var14 = String.format("%.3fs", new Object[] { Double.valueOf((double) var12 / 1.0E9D) });
				logger.info("Done (" + var14 + ")! For help, type \"help\" or \"?\"");
				if (this.serverProperties.getBoolean("enable-query", false)) {
					logger.info("Starting GS4 status listener");
					this.query = new QueryListener(this);
					this.query.a();
				}

				if (this.serverProperties.getBoolean("enable-rcon", false)) {
					logger.info("Starting remote control listener");
					this.rcon = new RconListener(this);
					this.rcon.a();
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

	public void setServerGameMode(GameMode mode) {
		super.setServerGameMode(mode);
		this.serverGameMode = mode;
	}

	public boolean isStructureGenerationEnabled() {
		return this.generateStructures;
	}

	public GameMode getServerGameMode() {
		return this.serverGameMode;
	}

	public Difficulty getDifficulty() {
		return Difficulty.clampAndGetById(this.serverProperties.getInt("difficulty", 1));
	}

	public boolean isHardcore() {
		return this.serverProperties.getBoolean("hardcore", false);
	}

	protected void handleCommandsBecausePortBindingFailed(CrashReport var1) {
		while (this.isTicking()) {
			this.handlePendingCommands();

			try {
				Thread.sleep(10L);
			} catch (InterruptedException var3) {
				;
			}
		}

	}

	public CrashReport b(CrashReport var1) {
		var1 = super.b(var1);
		var1.g().a("Is Modded", (Callable<?>) (new pr(this)));
		var1.g().a("Type", (Callable<?>) (new ps(this)));
		return var1;
	}

	protected void exit() {
		System.exit(0);
	}

	public void z() {
		super.z();
		this.handlePendingCommands();
	}

	public boolean isNetherAllowed() {
		return this.serverProperties.getBoolean("allow-nether", true);
	}

	public boolean isMonsterSpawnEnabled() {
		return this.serverProperties.getBoolean("spawn-monsters", true);
	}

	public void a(Snooper var1) {
		var1.a("whitelist_enabled", Boolean.valueOf(this.aN().s()));
		var1.a("whitelist_count", Integer.valueOf(this.aN().m().length));
		super.a(var1);
	}

	public boolean isSnooperEnabled() {
		return this.serverProperties.getBoolean("snooper-enabled", true);
	}

	public void addPendingCommand(String var1, CommandSenderInterface var2) {
		this.pendingCommands.add(new PendingServerCommand(var1, var2));
	}

	public void handlePendingCommands() {
		while (!this.pendingCommands.isEmpty()) {
			PendingServerCommand var1 = (PendingServerCommand) this.pendingCommands.remove(0);
			this.getCommandHandler().a(var1.sender, var1.command);
		}

	}

	public boolean isDedicated() {
		return true;
	}

	public DedicatedPlayerList aN() {
		return (DedicatedPlayerList) super.getPlayerList();
	}

	public int a(String var1, int var2) {
		return this.serverProperties.getInt(var1, var2);
	}

	public String a(String var1, String var2) {
		return this.serverProperties.getString(var1, var2);
	}

	public boolean a(String var1, boolean var2) {
		return this.serverProperties.getBoolean(var1, var2);
	}

	public void a(String var1, Object var2) {
		this.serverProperties.setProperty(var1, var2);
	}

	public void saveProperties() {
		this.serverProperties.write();
	}

	public String b() {
		File var1 = this.serverProperties.getFile();
		return var1 != null ? var1.getAbsolutePath() : "No settings file";
	}

	public void enableGui() {
		ServerGUI.oper(this);
		this.guiEnabled = true;
	}

	public boolean isGuiEnabled() {
		return this.guiEnabled;
	}

	public String a(GameMode var1, boolean var2) {
		return "";
	}

	public boolean isCommandBlockEnabled() {
		return this.serverProperties.getBoolean("enable-command-block", false);
	}

	public int isSpawnProtectionEnabled() {
		return this.serverProperties.getInt("spawn-protection", super.isSpawnProtectionEnabled());
	}

	public boolean a(World var1, dt var2, ahd var3) {
		if (var1.t.q() != 0) {
			return false;
		} else if (this.aN().n().d()) {
			return false;
		} else if (this.aN().g(var3.cc())) {
			return false;
		} else if (this.isSpawnProtectionEnabled() <= 0) {
			return false;
		} else {
			dt var4 = var1.M();
			int var5 = uv.a(var2.n() - var4.n());
			int var6 = uv.a(var2.p() - var4.p());
			int var7 = Math.max(var5, var6);
			return var7 <= this.isSpawnProtectionEnabled();
		}
	}

	public int getOpPermissionLevel() {
		return this.serverProperties.getInt("op-permission-level", 4);
	}

	public void setIdleTimeout(int var1) {
		super.setIdleTimeout(var1);
		this.serverProperties.setProperty("player-idle-timeout", (Object) Integer.valueOf(var1));
		this.saveProperties();
	}

	public boolean az() {
		return this.serverProperties.getBoolean("announce-player-achievements", true);
	}

	public int aG() {
		int var1 = this.serverProperties.getInt("max-world-size", super.aG());
		if (var1 < 1) {
			var1 = 1;
		} else if (var1 > super.aG()) {
			var1 = super.aG();
		}

		return var1;
	}

	public int aI() {
		return this.serverProperties.getInt("network-compression-threshold", super.aI());
	}

	protected boolean aP() {
		boolean var2 = false;

		int var1;
		for (var1 = 0; !var2 && var1 <= 2; ++var1) {
			if (var1 > 0) {
				logger.warn("Encountered a problem while converting the user banlist, retrying in a few seconds");
				this.aS();
			}

			var2 = sf.a((MinecraftServer) this);
		}

		boolean var3 = false;

		for (var1 = 0; !var3 && var1 <= 2; ++var1) {
			if (var1 > 0) {
				logger.warn("Encountered a problem while converting the ip banlist, retrying in a few seconds");
				this.aS();
			}

			var3 = sf.b((MinecraftServer) this);
		}

		boolean var4 = false;

		for (var1 = 0; !var4 && var1 <= 2; ++var1) {
			if (var1 > 0) {
				logger.warn("Encountered a problem while converting the op list, retrying in a few seconds");
				this.aS();
			}

			var4 = sf.c((MinecraftServer) this);
		}

		boolean var5 = false;

		for (var1 = 0; !var5 && var1 <= 2; ++var1) {
			if (var1 > 0) {
				logger.warn("Encountered a problem while converting the whitelist, retrying in a few seconds");
				this.aS();
			}

			var5 = sf.d((MinecraftServer) this);
		}

		boolean var6 = false;

		for (var1 = 0; !var6 && var1 <= 2; ++var1) {
			if (var1 > 0) {
				logger.warn("Encountered a problem while converting the player save files, retrying in a few seconds");
				this.aS();
			}

			var6 = sf.a(this, this.serverProperties);
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
		return this.serverProperties.getLong("max-tick-time", TimeUnit.MINUTES.toMillis(1L));
	}

	// $FF: synthetic method
	public PlayerList getPlayerList() {
		return this.aN();
	}

	// $FF: synthetic method
	static Logger aR() {
		return logger;
	}

}
