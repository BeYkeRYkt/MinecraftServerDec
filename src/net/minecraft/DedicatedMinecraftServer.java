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
			int gameMode = this.serverProperties.getInt("gamemode", GameMode.SURVIVAL.getId());
			this.serverGameMode = arb.a(gameMode);
			logger.info("Default game type: " + this.serverGameMode);
			InetAddress address = null;
			if (this.getIp().length() > 0) {
				address = InetAddress.getByName(this.getIp());
			}

			if (this.getPort() < 0) {
				this.setPort(this.serverProperties.getInt("server-port", 25565));
			}

			logger.info("Generating keypair");
			this.setKeyPair(ServerCryptoUtils.generateKeyPair());
			logger.info("Starting Minecraft server on " + (this.getIp().length() == 0 ? "*" : this.getIp()) + ":" + this.getPort());

			try {
				this.getServerConnection().bindToPort(address, this.getPort());
			} catch (Exception ex) {
				logger.warn("**** FAILED TO BIND TO PORT!");
				logger.warn("The exception was: {}", new Object[] { ex.toString() });
				logger.warn("Perhaps a server is already running on that port?");
				return false;
			}

			if (!this.isOnlineMode()) {
				logger.warn("**** SERVER IS RUNNING IN OFFLINE/INSECURE MODE!");
				logger.warn("The server will make no attempt to authenticate usernames. Beware.");
				logger.warn("While this makes the game possible to play without internet access, it also opens up the ability for hackers to connect with any username they choose.");
				logger.warn("To change this, set \"online-mode\" to \"true\" in the server.properties file.");
			}

			if (this.convertDataLists()) {
				this.getUserCache().dumpCache();
			}

			if (!sf.a(this.serverProperties)) {
				return false;
			} else {
				this.setPlayerList(new DedicatedPlayerList(this));
				long nanoTime = System.nanoTime();
				if (this.getLevelName() == null) {
					this.setLevelName(this.serverProperties.getString("level-name", "world"));
				}

				String seed = this.serverProperties.getString("level-seed", "");
				String type = this.serverProperties.getString("level-type", "DEFAULT");
				String gensettings = this.serverProperties.getString("generator-settings", "");
				long randomLong = (new Random()).nextLong();
				if (seed.length() > 0) {
					try {
						long longSeed = Long.parseLong(seed);
						if (longSeed != 0L) {
							randomLong = longSeed;
						}
					} catch (NumberFormatException var16) {
						randomLong = seed.hashCode();
					}
				}

				LevelType var18 = LevelType.byName(type);
				if (var18 == null) {
					var18 = LevelType.DEFAULT;
				}

				this.isAnnouncePlayerAchievmentsEnabled();
				this.isCommandBlockEnabled();
				this.getOpPermissionLevel();
				this.isSnooperEnabled();
				this.getCompressionThreshold();
				this.c(this.serverProperties.getInt("max-build-height", 256));
				this.c((this.al() + 8) / 16 * 16);
				this.c(DataTypesConverter.a(this.al(), 64, 256));
				this.serverProperties.setProperty("max-build-height", (Object) Integer.valueOf(this.al()));
				logger.info("Preparing level \"" + this.getLevelName() + "\"");
				this.a(this.getLevelName(), this.getLevelName(), randomLong, var18, gensettings);
				long var12 = System.nanoTime() - nanoTime;
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

				if (this.getMaxTickTime() > 0L) {
					Thread watchdog = new Thread(new ServerWatchdog(this));
					watchdog.setName("Server Watchdog");
					watchdog.setDaemon(true);
					watchdog.start();
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
			}
		}

	}

	public CrashReport b(CrashReport var1) {
		var1 = super.b(var1);
		var1.g().addDetails("Is Modded", (Callable<?>) (new pr(this)));
		var1.g().addDetails("Type", (Callable<?>) (new ps(this)));
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
		var1.a("whitelist_enabled", Boolean.valueOf(this.getDedicatedPlayerList().s()));
		var1.a("whitelist_count", Integer.valueOf(this.getDedicatedPlayerList().m().length));
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

	public DedicatedPlayerList getDedicatedPlayerList() {
		return (DedicatedPlayerList) super.getPlayerList();
	}

	public int getIntProperty(String path, int defaultValue) {
		return this.serverProperties.getInt(path, defaultValue);
	}

	public String getStringProperty(String path, String defaultValue) {
		return this.serverProperties.getString(path, defaultValue);
	}

	public boolean getBooleanProperty(String path, boolean defaultValue) {
		return this.serverProperties.getBoolean(path, defaultValue);
	}

	public void setProperty(String path, Object obj) {
		this.serverProperties.setProperty(path, obj);
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

	public boolean a(World var1, Position var2, EntityHuman var3) {
		if (var1.worldProvider.getDimensionId() != 0) {
			return false;
		} else if (this.getDedicatedPlayerList().n().d()) {
			return false;
		} else if (this.getDedicatedPlayerList().g(var3.getGameProfile())) {
			return false;
		} else if (this.isSpawnProtectionEnabled() <= 0) {
			return false;
		} else {
			Position var4 = var1.M();
			int var5 = DataTypesConverter.a(var2.n() - var4.n());
			int var6 = DataTypesConverter.a(var2.p() - var4.p());
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

	public boolean isAnnouncePlayerAchievmentsEnabled() {
		return this.serverProperties.getBoolean("announce-player-achievements", true);
	}

	public int getMaxWorldSize() {
		int maxsize = this.serverProperties.getInt("max-world-size", super.getMaxWorldSize());
		if (maxsize < 1) {
			maxsize = 1;
		} else if (maxsize > super.getMaxWorldSize()) {
			maxsize = super.getMaxWorldSize();
		}

		return maxsize;
	}

	public int getCompressionThreshold() {
		return this.serverProperties.getInt("network-compression-threshold", super.getCompressionThreshold());
	}

	protected boolean convertDataLists() {
		boolean succNameBans = false;

		int i;
		for (i = 0; !succNameBans && i <= 2; ++i) {
			if (i > 0) {
				logger.warn("Encountered a problem while converting the user banlist, retrying in a few seconds");
				this.sleep5Seconds();
			}

			succNameBans = sf.a((MinecraftServer) this);
		}

		boolean succIPBans = false;

		for (i = 0; !succIPBans && i <= 2; ++i) {
			if (i > 0) {
				logger.warn("Encountered a problem while converting the ip banlist, retrying in a few seconds");
				this.sleep5Seconds();
			}

			succIPBans = sf.b((MinecraftServer) this);
		}

		boolean succOP = false;

		for (i = 0; !succOP && i <= 2; ++i) {
			if (i > 0) {
				logger.warn("Encountered a problem while converting the op list, retrying in a few seconds");
				this.sleep5Seconds();
			}

			succOP = sf.c((MinecraftServer) this);
		}

		boolean succWhitelist = false;

		for (i = 0; !succWhitelist && i <= 2; ++i) {
			if (i > 0) {
				logger.warn("Encountered a problem while converting the whitelist, retrying in a few seconds");
				this.sleep5Seconds();
			}

			succWhitelist = sf.d((MinecraftServer) this);
		}

		boolean succSave = false;

		for (i = 0; !succSave && i <= 2; ++i) {
			if (i > 0) {
				logger.warn("Encountered a problem while converting the player save files, retrying in a few seconds");
				this.sleep5Seconds();
			}

			succSave = sf.a(this, this.serverProperties);
		}

		return succNameBans || succIPBans || succOP || succWhitelist || succSave;
	}

	private void sleep5Seconds() {
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException ex) {
		}
	}

	public long getMaxTickTime() {
		return this.serverProperties.getLong("max-tick-time", TimeUnit.MINUTES.toMillis(1L));
	}

	// $FF: synthetic method
	public PlayerList getPlayerList() {
		return this.getDedicatedPlayerList();
	}

	// $FF: synthetic method
	static Logger aR() {
		return logger;
	}

}
