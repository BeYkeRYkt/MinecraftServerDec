package net.minecraft.server;

import net.minecraft.*;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;

import net.minecraft.util.com.mojang.authlib.GameProfile;
import net.minecraft.util.com.mojang.authlib.GameProfileRepository;
import net.minecraft.util.com.mojang.authlib.minecraft.MinecraftSessionService;
import net.minecraft.util.com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import net.minecraft.util.io.netty.buffer.ByteBuf;
import net.minecraft.util.io.netty.buffer.ByteBufOutputStream;
import net.minecraft.util.io.netty.buffer.Unpooled;
import net.minecraft.util.io.netty.handler.codec.base64.Base64;

import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.Proxy;
import java.net.UnknownHostException;
import java.security.KeyPair;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.world.WorldInitEvent;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.event.world.WorldSaveEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginLoadOrder;

import pipebukkit.server.PipeServer;
import pipebukkit.server.command.PipeServerCommandSender;
import pipebukkit.server.scheduler.PipeScheduler;

public abstract class MinecraftServer implements CommandSenderInterface, Runnable, ITaskScheduler, wd {

	private static final Logger logger = LogManager.getLogger();
	public static final File usercache = new File("usercache.json");
	private static MinecraftServer instance;
	private final Convertable convertable;
	private final Snooper snooper = new Snooper("server", this, getCurrentMillis());
	public final File universe;
	private final List<ITickable> o = Lists.newArrayList();
	private final ICommandHandler commandHandler;
	public final MethodProfiler profiler = new MethodProfiler();
	private final ServerConnection serverConnection;
	private final ServerPing serverPing = new ServerPing();
	private final Random rnd = new Random();
	private String ip;
	private int port = -1;
	public ArrayList<WorldServer> worlds;
	private PlayerList playerList;
	private boolean running = true;
	private boolean stopped;
	private int currentTick;
	protected final Proxy proxy;
	private boolean onlineMode;
	private boolean spawnAnimals;
	private boolean spawnNPCs;
	private boolean pvp;
	private boolean flightAllowed;
	private String motd;
	private int maxBuildHeight;
	private int idleTimeOut = 0;
	public final long[] g = new long[100];
	private KeyPair keyPair;
	private String levelName;
	private boolean N;
	private String O = "";
	private String P = "";
	private long R;
	private boolean T;
	private boolean forceGameMode;
	private final YggdrasilAuthenticationService authService;
	private final MinecraftSessionService minecraftSessionService;
	private long lastServerPingUpdate = 0L;
	private final GameProfileRepository gameProflieRepository;
	private final UserCache userCache;
	protected final Queue<ListenableFutureTask<?>> tasks = Queues.newArrayDeque();
	private Thread mainThread;
	private long lastTickTime = getCurrentMillis();

	private PipeServer pipeServer;
	public PipeServer getPipeServer() {
		return pipeServer;
	}
	private ConsoleCommandSender console;
	public ConsoleCommandSender getConsoleCommandSender() {
		return console;
	}

	public MinecraftServer(File universe, Proxy proxy, File usercache) {
		instance = this;
		this.proxy = proxy;
		this.universe = universe;
		this.serverConnection = new ServerConnection(this);
		this.userCache = new UserCache(this, usercache);
		this.commandHandler = this.createCommandsHandler();
		this.convertable = new WorldLoaderServer(universe);
		this.authService = new YggdrasilAuthenticationService(proxy, UUID.randomUUID().toString());
		this.minecraftSessionService = this.authService.createMinecraftSessionService();
		this.gameProflieRepository = this.authService.createProfileRepository();
	}

	public static void main(String[] args) {
		Bootstrap.load();

		try {
			String universe = ".";
			String world = null;
			int port = -1;

			for (int i = 0; i < args.length; ++i) {
				String argName = args[i];
				String argsValue = i == args.length - 1 ? null : args[i + 1];
				boolean hadArgValue = false;
				if (argName.equals("--port") && argsValue != null) {
					hadArgValue = true;

					try {
						port = Integer.parseInt(argsValue);
					} catch (NumberFormatException var13) {
					}
				} else if (argName.equals("--universe") && argsValue != null) {
					hadArgValue = true;
					universe = argsValue;
				} else if (argName.equals("--world") && argsValue != null) {
					hadArgValue = true;
					world = argsValue;
				}

				if (hadArgValue) {
					++i;
				}
			}

			DedicatedMinecraftServer dedicatedMinecraftServer = new DedicatedMinecraftServer(new File(universe));

			if (world != null) {
				dedicatedMinecraftServer.setLevelName(world);
			}

			if (port >= 0) {
				dedicatedMinecraftServer.setPort(port);
			}

			dedicatedMinecraftServer.startMainThread();
			Runtime.getRuntime().addShutdownHook(new ServerShutdownHook("Server Shutdown Thread", dedicatedMinecraftServer));
		} catch (Exception var14) {
			logger.fatal("Failed to start the minecraft server", var14);
		}

	}

	protected abstract boolean startServer() throws UnknownHostException;

	public void run() {
		try {
			if (this.startServer()) {
				this.lastTickTime = getCurrentMillis();
				long var1 = 0L;
				this.serverPing.a((IChatBaseComponent) (new ChatComponentText(this.motd)));
				this.serverPing.a(new ServerPingServerData("1.8", 47));
				this.a(this.serverPing);

				while (this.running) {
					long var48 = getCurrentMillis();
					long var5 = var48 - this.lastTickTime;
					if (var5 > 2000L && this.lastTickTime - this.R >= 15000L) {
						logger.warn("Can\'t keep up! Did the system time change, or is the server overloaded? Running {}ms behind, skipping {} tick(s)", new Object[] { Long.valueOf(var5), Long.valueOf(var5 / 50L) });
						var5 = 2000L;
						this.R = this.lastTickTime;
					}

					if (var5 < 0L) {
						logger.warn("Time ran backwards! Did the system time change?");
						var5 = 0L;
					}

					var1 += var5;
					this.lastTickTime = var48;

					if (getWorld().f()) {
						this.doTick();
						var1 = 0L;
					} else {
						while (var1 > 50L) {
							var1 -= 50L;
							this.doTick();
						}
					}

					Thread.sleep(Math.max(1L, 50L - var1));
				}
			} else {
				this.handleCommandsBecausePortBindingFailed(null);
			}
		} catch (Throwable var46) {
			logger.error("Encountered an unexpected exception", var46);
			CrashReport var2 = null;
			if (var46 instanceof ReportedException) {
				var2 = this.b(((ReportedException) var46).getCrashReport());
			} else {
				var2 = this.b(new CrashReport("Exception in server tick loop", var46));
			}

			File var3 = new File(new File(this.w(), "crash-reports"), "crash-" + (new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss")).format(new Date()) + "-server.txt");
			if (var2.write(var3)) {
				logger.error("This crash report has been saved to: " + var3.getAbsolutePath());
			} else {
				logger.error("We were unable to save this crash report to disk.");
			}

			this.handleCommandsBecausePortBindingFailed(var2);
		} finally {
			try {
				this.stop();
				this.stopped = true;
			} catch (Throwable var44) {
				logger.error("Exception stopping the server", var44);
			} finally {
				this.exit();
			}

		}
	}

	public void doTick() {
		long var1 = System.nanoTime();
		++this.currentTick;

		((PipeScheduler) Bukkit.getScheduler()).doTick(currentTick);

		if (this.T) {
			this.T = false;
			this.profiler.a = true;
			this.profiler.a();
		}

		this.profiler.a("root");
		this.profiler.a("jobs");

		synchronized (this.tasks) {
			while (!this.tasks.isEmpty()) {
				try {
					this.tasks.poll().run();
				} catch (Throwable t) {
					logger.fatal((Object) t);
				}
			}
		}

		this.profiler.c("levels");

		int i;
		for (i = 0; i < this.worlds.size(); ++i) {
			long var2 = System.nanoTime();
			if (i == 0 || this.isNetherAllowed()) {
				WorldServer world = worlds.get(i);
				this.profiler.a(world.getWorldData().getLevelName());

				if (this.currentTick % 20 == 0) {
					this.profiler.a("timeSync");
					this.playerList.sendPacket((new PacketPlayOutTimeUpdate(world.getTime(), world.L(), world.getGameRules().b("doDaylightCycle"))), world.worldProvider.getDimensionId());
					this.profiler.b();
				}

				this.profiler.a("tick");

				CrashReport var6;
				try {
					world.doTick();
				} catch (Throwable var8) {
					var6 = CrashReport.generateCrashReport(var8, "Exception ticking world");
					world.a(var6);
					throw new ReportedException(var6);
				}

				try {
					world.i();
				} catch (Throwable var7) {
					var6 = CrashReport.generateCrashReport(var7, "Exception ticking world entities");
					world.a(var6);
					throw new ReportedException(var6);
				}

				this.profiler.b();
				this.profiler.a("tracker");
				world.getEntityTracker().a();
				this.profiler.b();
				this.profiler.b();
			}
		}

		this.profiler.c("connection");
		this.getServerConnection().doTick();
		this.profiler.c("players");
		this.playerList.e();
		this.profiler.c("tickables");

		for (i = 0; i < this.o.size(); ++i) {
			((ITickable) this.o.get(i)).doTick();
		}

		this.profiler.b();
		if (var1 - this.lastServerPingUpdate >= 5000000000L) {
			this.lastServerPingUpdate = var1;
			this.serverPing.a(new ServerPingPlayerSample(this.getMaxPlayers(), this.getOnlinePlayersCount()));
			GameProfile[] var3 = new GameProfile[Math.min(this.getOnlinePlayersCount(), 12)];
			int var4 = MathHelper.a(this.rnd, 0, this.getOnlinePlayersCount() - var3.length);

			for (int var5 = 0; var5 < var3.length; ++var5) {
				var3[var5] = ((EntityPlayer) this.playerList.players.get(var4 + var5)).getGameProfile();
			}

			Collections.shuffle(Arrays.asList(var3));
			this.serverPing.b().a(var3);
		}

		this.profiler.a("tallying");
		this.g[this.currentTick % 100] = System.nanoTime() - var1;
		this.profiler.b();
		this.profiler.a("snooper");
		if (!this.snooper.d() && this.currentTick > 100) {
			this.snooper.a();
		}

		if (this.currentTick % 6000 == 0) {
			this.snooper.b();
		}

		this.profiler.b();
		this.profiler.b();
	}

	public abstract ServerProperties getServerProperties();

	protected DedicatedServerCommandHandler createCommandsHandler() {
		return new DedicatedServerCommandHandler();
	}

	protected void loadWorlds(String levelname, long seed, LevelType levelType, String settings) {
		this.worlds = new ArrayList<WorldServer>();

		WorldSettings worldSettings = new WorldSettings(seed, this.getServerGameMode(), this.isStructureGenerationEnabled(), this.isHardcore(), levelType);

		for (int i = 0; i < 3; ++i) {
			byte dimension = 0;
			if (i == 1) {
				dimension = -1;
			}

			if (i == 2) {
				dimension = 1;
			}

			WorldServer worldServer = null;
			if (i == 0) {
				IDataManager datamanager = new ServerNBTManager(Bukkit.getWorldContainer(), levelname, true);
				worldServer = new WorldServer(this, datamanager, levelName, worldSettings, dimension, this.profiler).b();
				worldServer.applyWorldSettings(worldSettings);
			} else {
				String name = dimension == -1 ? levelname+"_nether" : levelname+"_the_end";
				IDataManager datamanager = new ServerNBTManager(Bukkit.getWorldContainer(), name, true);
				worldServer = new SecondaryWorldServer(this, datamanager, name, worldSettings, dimension, this.worlds.get(0), this.profiler).b();
			}

			worldServer.addIWorldAccess(new WorldManager(this, worldServer));
			worldServer.getWorldData().setGameMode(this.getServerGameMode());

			Bukkit.getPluginManager().callEvent(new WorldInitEvent(worldServer.getBukkitWorld()));

			worlds.add(worldServer);
			getPipeServer().addWorld(worldServer);

			generateTerrain(worldServer);

			Bukkit.getPluginManager().callEvent(new WorldLoadEvent(worldServer.getBukkitWorld()));
		}

		this.playerList.setPlayerFileData(this.worlds.toArray(new WorldServer[0]));
		this.setWorldsDifficulty(this.getDifficulty());

		getPipeServer().enablePlugins(PluginLoadOrder.POSTWORLD);
	}

	public void generateTerrain(WorldServer worldServer) {
		logger.info("Preparing start region for level " + worldServer.getWorldData().getLevelName());
		Position spawnPosition = worldServer.getSpawnPosition();
		long timeA = getCurrentMillis();
		int chunksLoaded = 0;
		for (int x = -192; x <= 192 && this.isTicking(); x += 16) {
			for (int z = -192; z <= 192 && this.isTicking(); z += 16) {
				long timeB = getCurrentMillis();
				if (timeB - timeA > 1000L) {
					logger.info("Preparing spawn area: " + chunksLoaded * 100 / 625+ "%");
					timeA = timeB;
				}

				++chunksLoaded;
				worldServer.chunkProviderServer.getChunkAt(spawnPosition.getX() + x >> 4, spawnPosition.getZ() + z >> 4);
			}
		}
	}

	public abstract boolean isStructureGenerationEnabled();

	public abstract EnumGameMode getServerGameMode();

	public abstract Difficulty getDifficulty();

	public abstract boolean isHardcore();

	public abstract int getOpPermissionLevel();

	protected void saveChunks(boolean silenced) {
		if (!this.N) {
			for (WorldServer world : worlds) {
				if (world != null) {
					if (!silenced) {
						logger.info("Saving chunks for level \'" + world.getWorldData().getLevelName() + "\'/" + world.worldProvider.getWorldName());
					}

					try {
						world.save(true, (IProgressUpdate) null);
					} catch (ExceptionWorldConflict ex) {
						logger.warn(ex.getMessage());
					}

					if (!silenced) {
						logger.info("Saved chunks for level \'" + world.getWorldData().getLevelName() + "\'/" + world.worldProvider.getWorldName());
					}

					Bukkit.getPluginManager().callEvent(new WorldSaveEvent(world.getBukkitWorld()));
				}
			}
		}
	}

	public void stop() {
		if (!this.N) {
			logger.info("Stopping server");
			if (this.getServerConnection() != null) {
				this.getServerConnection().closeChannels();
			}

			logger.info("Disabling plugins");
			Plugin[] plugins = Bukkit.getPluginManager().getPlugins();
			for (int i = plugins.length-1; i >=0; i--) {
				try {
					Bukkit.getPluginManager().disablePlugin(plugins[i]);
				} catch (Throwable t) {
					t.printStackTrace();
				}
			}

			if (this.playerList != null) {
				logger.info("Saving players");
				this.playerList.savePlayers();
				this.playerList.kickAll();
				logger.info("Saved players");
			}

			if (this.worlds != null) {
				logger.info("Saving worlds");
				this.saveChunks(false);

				for (WorldServer world : worlds) {
					world.saveLevel();
				}
				logger.info("Saved worlds");
			}

			if (this.snooper.d()) {
				this.snooper.e();
			}

		}
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public boolean isTicking() {
		return this.running;
	}

	public void stopTicking() {
		this.running = false;
	}

	

	private void a(ServerPing var1) {
		File var2 = this.d("server-icon.png");
		if (var2.isFile()) {
			ByteBuf var3 = Unpooled.buffer();

			try {
				BufferedImage var4 = ImageIO.read(var2);
				Validate.validState(var4.getWidth() == 64, "Must be 64 pixels wide", new Object[0]);
				Validate.validState(var4.getHeight() == 64, "Must be 64 pixels high", new Object[0]);
				ImageIO.write(var4, "PNG", new ByteBufOutputStream(var3));
				ByteBuf var5 = Base64.encode(var3);
				var1.a("data:image/png;base64," + var5.toString(Charsets.UTF_8));
			} catch (Exception var9) {
				logger.error("Couldn\'t load server icon", (Throwable) var9);
			} finally {
				var3.release();
			}
		}

	}

	public File w() {
		return new File(".");
	}

	protected void handleCommandsBecausePortBindingFailed(CrashReport var1) {
	}

	protected void exit() {
	}


	public boolean isNetherAllowed() {
		return true;
	}

	public void a(ITickable var1) {
		this.o.add(var1);
	}

	public void startMainThread() {
		this.mainThread = new Thread(this, "Server thread");
		this.mainThread.start();
	}

	public File d(String var1) {
		return new File(this.w(), var1);
	}

	public void logInfo(String message) {
		logger.info(message);
	}

	public void logWarning(String message) {
		logger.warn(message);
	}

	public WorldServer getWorldServer(int dimensionId) {
		return dimensionId == -1 ? this.worlds.get(1) : (dimensionId == 1 ? this.worlds.get(2) : this.worlds.get(0));
	}

	public String C() {
		return this.ip;
	}

	public int D() {
		return this.port;
	}

	public String getMotd() {
		return this.motd;
	}

	public String getGameVersion() {
		return "1.8";
	}

	public int getOnlinePlayersCount() {
		return this.playerList.getPlayersCount();
	}

	public int getMaxPlayers() {
		return this.playerList.getMaxPlayers();
	}

	public String[] I() {
		return this.playerList.g();
	}

	public GameProfile[] J() {
		return this.playerList.h();
	}

	public String K() {
		return "";
	}

	public String g(String var1) {
		tc.h().i();
		this.commandHandler.handleCommand(tc.h(), var1);
		return tc.h().j();
	}

	public boolean L() {
		return false;
	}

	public void h(String var1) {
		logger.error(var1);
	}

	public void i(String var1) {
		if (this.L()) {
			logger.info(var1);
		}

	}

	public String getServerModName() {
		return "vanilla";
	}

	public CrashReport b(CrashReport var1) {
		var1.g().addDetails("Profiler Position", (Callable<?>) (new pf(this)));
		if (this.playerList != null) {
			var1.g().addDetails("Player Count", new OnlinePlayersInfoCallable());
		}

		return var1;
	}

	public List<String> getTabCompleteList(CommandSenderInterface var1, String var2, Position var3) {
		ArrayList<String> var4 = Lists.newArrayList();
		if (var2.startsWith("/")) {
			var2 = var2.substring(1);
			boolean var11 = !var2.contains(" ");
			List<?> var12 = this.commandHandler.a(var1, var2, var3);
			if (var12 != null) {
				Iterator<?> var13 = var12.iterator();

				while (var13.hasNext()) {
					String var14 = (String) var13.next();
					if (var11) {
						var4.add("/" + var14);
					} else {
						var4.add(var14);
					}
				}
			}

			return var4;
		} else {
			String[] var5 = var2.split(" ", -1);
			String var6 = var5[var5.length - 1];
			String[] var7 = this.playerList.g();
			int var8 = var7.length;

			for (int var9 = 0; var9 < var8; ++var9) {
				String var10 = var7[var9];
				if (AbstractCommand.startWith(var6, var10)) {
					var4.add(var10);
				}
			}

			return var4;
		}
	}

	public static MinecraftServer getInstance() {
		return instance;
	}

	public boolean hasUniverse() {
		return this.universe != null;
	}

	public String getName() {
		return "Server";
	}

	public void sendChatMessage(IChatBaseComponent var1) {
		logger.info(var1.getStrippedMessage());
	}

	public boolean canExecuteCommand(int var1, String var2) {
		return true;
	}

	public ICommandHandler getCommandHandler() {
		return this.commandHandler;
	}

	public KeyPair getKeyPair() {
		return this.keyPair;
	}

	public int getPort() {
		return this.port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getLevelName() {
		return this.levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public void setKeyPair(KeyPair keyPair) {
		this.keyPair = keyPair;
	}

	public void setWorldsDifficulty(Difficulty var1) {
		for (int i = 0; i < this.worlds.size(); ++i) {
			WorldServer worldServer = worlds.get(i);
			if (worldServer != null) {
				if (worldServer.getWorldData().isHardcore()) {
					worldServer.getWorldData().setDifficulty(Difficulty.HARD);
					worldServer.a(true, true);
				} else {
					worldServer.getWorldData().setDifficulty(var1);
					worldServer.a(this.isMonsterSpawnEnabled(), this.spawnAnimals);
				}
			}
		}

	}

	protected boolean isMonsterSpawnEnabled() {
		return true;
	}

	public Convertable X() {
		return this.convertable;
	}

	public void stopSinglePlayerServer() {
		this.N = true;
		this.X().d();

		for (int var1 = 0; var1 < this.worlds.size(); ++var1) {
			WorldServer var2 = this.worlds.get(var1);
			if (var2 != null) {
				var2.saveLevel();
			}
		}

		this.X().e(this.worlds.get(0).getDataManager().g());
		this.stopTicking();
	}

	public String aa() {
		return this.O;
	}

	public String ab() {
		return this.P;
	}

	public void setResourcePack(String var1, String var2) {
		this.O = var1;
		this.P = var2;
	}

	public void a(Snooper var1) {
		var1.a("whitelist_enabled", Boolean.valueOf(false));
		var1.a("whitelist_count", Integer.valueOf(0));
		if (this.playerList != null) {
			var1.a("players_current", Integer.valueOf(this.getOnlinePlayersCount()));
			var1.a("players_max", Integer.valueOf(this.getMaxPlayers()));
			var1.a("players_seen", Integer.valueOf(this.playerList.r().length));
		}

		var1.a("uses_auth", Boolean.valueOf(this.onlineMode));
		var1.a("gui_state", this.isGuiEnabled() ? "enabled" : "disabled");
		var1.a("run_time", Long.valueOf((getCurrentMillis() - var1.g()) / 60L * 1000L));
		var1.a("avg_tick_ms", Integer.valueOf((int) (MathHelper.a(this.g) * 1.0E-6D)));
		int var2 = 0;
		if (this.worlds != null) {
			for (int var3 = 0; var3 < this.worlds.size(); ++var3) {
				if (this.worlds.get(var3) != null) {
					WorldServer var4 = this.worlds.get(var3);
					WorldData var5 = var4.getWorldData();
					var1.a("world[" + var2 + "][dimension]", Integer.valueOf(var4.worldProvider.getDimensionId()));
					var1.a("world[" + var2 + "][mode]", var5.getGameMode());
					var1.a("world[" + var2 + "][difficulty]", var4.getDifficulty());
					var1.a("world[" + var2 + "][hardcore]", Boolean.valueOf(var5.isHardcore()));
					var1.a("world[" + var2 + "][generator_name]", var5.getLevelType().getName());
					var1.a("world[" + var2 + "][generator_version]", Integer.valueOf(var5.getLevelType().getVersion()));
					var1.a("world[" + var2 + "][height]", Integer.valueOf(this.maxBuildHeight));
					var1.a("world[" + var2 + "][chunks_loaded]", Integer.valueOf(var4.getChunkProvider().getLoadedChunks()));
					++var2;
				}
			}
		}

		var1.a("worlds", Integer.valueOf(var2));
	}

	public void b(Snooper var1) {
		var1.b("singleplayer", false);
		var1.b("server_brand", this.getServerModName());
		var1.b("gui_supported", GraphicsEnvironment.isHeadless() ? "headless" : "supported");
		var1.b("dedicated", Boolean.valueOf(this.isDedicated()));
	}

	public boolean isSnooperEnabled() {
		return true;
	}

	public abstract boolean isDedicated();

	public boolean isOnlineMode() {
		return this.onlineMode;
	}

	public void setOnlineMode(boolean onlineMode) {
		this.onlineMode = onlineMode;
	}

	public boolean isAnimalSpawnEnabled() {
		return this.spawnAnimals;
	}

	public void setAnimalSpawnEnabled(boolean spawn) {
		this.spawnAnimals = spawn;
	}

	public boolean isNPCSpawnEnabled() {
		return this.spawnNPCs;
	}

	public void setNPCSpawnEnabled(boolean spawn) {
		this.spawnNPCs = spawn;
	}

	public boolean isPVPEnabled() {
		return this.pvp;
	}

	public void setPVP(boolean pvp) {
		this.pvp = pvp;
	}

	public boolean isFlightAllowed() {
		return this.flightAllowed;
	}

	public void setAllowFlight(boolean flightAllowed) {
		this.flightAllowed = flightAllowed;
	}

	public abstract boolean isCommandBlockEnabled();

	public void setMotd(String motd) {
		this.motd = motd;
	}

	public int getMaxBuildHeight() {
		return this.maxBuildHeight;
	}

	public void setMaxBuildHeight(int maxBuildHeight) {
		this.maxBuildHeight = maxBuildHeight;
	}

	public boolean isStopped() {
		return this.stopped;
	}

	public PlayerList getPlayerList() {
		return this.playerList;
	}

	public void setPlayerList(PlayerList playerList) {
		this.playerList = playerList;
		pipeServer = new PipeServer();
		console = new PipeServerCommandSender();
	}

	public void setServerGameMode(EnumGameMode var1) {
		for (int i = 0; i < this.worlds.size(); ++i) {
			getInstance().worlds.get(i).getWorldData().setGameMode(var1);
		}
	}

	public ServerConnection getServerConnection() {
		return this.serverConnection;
	}

	public boolean isGuiEnabled() {
		return false;
	}

	public abstract String a(EnumGameMode var1, boolean var2);

	public int getTicks() {
		return this.currentTick;
	}

	public void as() {
		this.T = true;
	}

	public Position getEntityPosition() {
		return Position.ZERO;
	}

	public Vec3D getCenter() {
		return new Vec3D(0.0D, 0.0D, 0.0D);
	}

	public WorldServer getWorld() {
		return this.worlds.get(0);
	}

	public Entity getEntity() {
		return null;
	}

	public int isSpawnProtectionEnabled() {
		return 16;
	}

	public boolean isProtected(World var1, Position var2, EntityHuman var3) {
		return false;
	}

	public void setForceGameModeEnabled(boolean forceGameMode) {
		this.forceGameMode = forceGameMode;
	}

	public boolean av() {
		return this.forceGameMode;
	}

	public Proxy getProxy() {
		return this.proxy;
	}

	public static long getCurrentMillis() {
		return System.currentTimeMillis();
	}

	public int getIdleTimeOut() {
		return this.idleTimeOut;
	}

	public void setIdleTimeout(int idleTimeOut) {
		this.idleTimeOut = idleTimeOut;
	}

	public IChatBaseComponent getComponentName() {
		return new ChatComponentText(this.getName());
	}

	public boolean isAnnouncePlayerAchievmentsEnabled() {
		return true;
	}

	public MinecraftSessionService getMinecraftSessionService() {
		return this.minecraftSessionService;
	}

	public GameProfileRepository getGameProfileRepository() {
		return this.gameProflieRepository;
	}

	public UserCache getUserCache() {
		return this.userCache;
	}

	public ServerPing getServerPing() {
		return this.serverPing;
	}

	public void requestServerPingRefresh() {
		this.lastServerPingUpdate = 0L;
	}

	public Entity a(UUID var1) {
		WorldServer[] var2 = this.worlds.toArray(new WorldServer[0]);
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			WorldServer var5 = var2[var4];
			if (var5 != null) {
				Entity var6 = var5.getEntity(var1);
				if (var6 != null) {
					return var6;
				}
			}
		}

		return null;
	}

	public boolean t_() {
		return getInstance().worlds.get(0).getGameRules().b("sendCommandFeedback");
	}

	public void a(ag var1, int var2) {
	}

	public int getMaxWorldSize() {
		return 29999984;
	}

	public ListenableFuture<?> scheduleSyncTask(Callable<?> callable) {
		Validate.notNull(callable);
		if (!this.isMainThread()) {
			ListenableFutureTask<?> future = ListenableFutureTask.create(callable);
			synchronized (this.tasks) {
				this.tasks.add(future);
				return future;
			}
		} else {
			try {
				return Futures.immediateFuture(callable.call());
			} catch (Exception ex) {
				return Futures.immediateFailedCheckedFuture(ex);
			}
		}
	}

	public ListenableFuture<?> scheduleSyncTask(Runnable runnable) {
		Validate.notNull(runnable);
		return this.scheduleSyncTask(Executors.callable(runnable));
	}

	public boolean isMainThread() {
		return Thread.currentThread() == this.mainThread;
	}

	public int getCompressionThreshold() {
		return 256;
	}

	public long getLastTickTime() {
		return this.lastTickTime;
	}

	public Thread getMainServerThread() {
		return this.mainThread;
	}

	public static Logger getLogger() {
		return logger;
	}

}
