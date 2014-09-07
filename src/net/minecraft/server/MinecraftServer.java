package net.minecraft.server;

import net.minecraft.*;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.GameProfileRepository;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.base64.Base64;

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

public abstract class MinecraftServer implements CommandSenderInterface, Runnable, vn, wd {

	private static final Logger logger = LogManager.getLogger();
	public static final File usercache = new File("usercache.json");
	private static MinecraftServer instance;
	private final Convertable convertable;
	private final Snooper snooper = new Snooper("server", this, getCurrentMillis());
	private final File universe;
	private final List<pm> o = Lists.newArrayList();
	private final CommandHandlerInterface commandHandler;
	public final MethodProfiler profiler = new MethodProfiler();
	private final ServerConnection serverConnection;
	private final ServerPing serverPing = new ServerPing();
	private final Random rnd = new Random();
	private String ip;
	private int u = -1;
	public WorldServer[] worlds;
	private PlayerList playerList;
	private boolean running = true;
	private boolean stopped;
	private int ticks;
	protected final Proxy proxy;
	private boolean onlineMode;
	private boolean spawnAnimals;
	private boolean spawnNPCs;
	private boolean pvp;
	private boolean flightAllowed;
	private String E;
	private int F;
	private int G = 0;
	public final long[] g = new long[100];
	public long[][] h;
	private KeyPair keyPair;
	private String I;
	private String J;
	private boolean L;
	private boolean M;
	private boolean N;
	private String O = "";
	private String P = "";
	private long R;
	private boolean T;
	private boolean U;
	private final YggdrasilAuthenticationService authService;
	private final MinecraftSessionService minecraftSessionService;
	private long lastServerPingUpdate = 0L;
	private final GameProfileRepository gameProflieRepository;
	private final UserCache userCache;
	protected final Queue<ListenableFutureTask<?>> tasks = Queues.newArrayDeque();
	private Thread mainThread;
	private long lastTickTime = getCurrentMillis();

	public MinecraftServer(File universe, Proxy var2, File usercache) {
		this.proxy = var2;
		instance = this;
		this.universe = universe;
		this.serverConnection = new ServerConnection(this);
		this.userCache = new UserCache(this, usercache);
		this.commandHandler = this.h();
		this.convertable = new bqj(universe);
		this.authService = new YggdrasilAuthenticationService(var2, UUID.randomUUID().toString());
		this.minecraftSessionService = this.authService.createMinecraftSessionService();
		this.gameProflieRepository = this.authService.createProfileRepository();
	}

	protected cl h() {
		return new cl();
	}

	protected abstract boolean startServer() throws UnknownHostException;

	protected void a(String var1) {
		if (this.X().b(var1)) {
			logger.info("Converting map!");
			this.b("menu.convertingLevel");
			this.X().a(var1, new pd(this));
		}

	}

	protected synchronized void b(String var1) {
	}

	protected void a(String var1, String var2, long var3, LevelType var5, String var6) {
		this.a(var1);
		this.b("menu.loadingLevel");
		this.worlds = new WorldServer[3];
		this.h = new long[this.worlds.length][100];
		IDataManager var7 = this.convertable.a(var1, true);
		this.a(this.getLevelName(), var7);
		WorldData var9 = var7.d();
		arb var8;
		if (var9 == null) {
			if (this.W()) {
				var8 = DemoWorldServer.a;
			} else {
				var8 = new arb(var3, this.getServerGameMode(), this.isStructureGenerationEnabled(), this.isHardcore(), var5);
				var8.a(var6);
				if (this.M) {
					var8.a();
				}
			}

			var9 = new WorldData(var8, var2);
		} else {
			var9.a(var2);
			var8 = new arb(var9);
		}

		for (int var10 = 0; var10 < this.worlds.length; ++var10) {
			byte var11 = 0;
			if (var10 == 1) {
				var11 = -1;
			}

			if (var10 == 2) {
				var11 = 1;
			}

			if (var10 == 0) {
				if (this.W()) {
					this.worlds[var10] = (WorldServer) (new DemoWorldServer(this, var7, var9, var11, this.profiler)).b();
				} else {
					this.worlds[var10] = (WorldServer) (new WorldServer(this, var7, var9, var11, this.profiler)).b();
				}

				this.worlds[var10].a(var8);
			} else {
				this.worlds[var10] = (WorldServer) (new SecondaryWorldServer(this, var7, var11, this.worlds[0], this.profiler)).b();
			}

			this.worlds[var10].a((ara) (new qp(this, this.worlds[var10])));
			if (!this.isSinglePlayer()) {
				this.worlds[var10].P().a(this.getServerGameMode());
			}
		}

		this.playerList.a(this.worlds);
		this.a(this.getDifficulty());
		this.k();
	}

	protected void k() {
		int var5 = 0;
		this.b("menu.generatingTerrain");
		byte var6 = 0;
		logger.info("Preparing start region for level " + var6);
		WorldServer var7 = this.worlds[var6];
		Position var8 = var7.M();
		long var9 = getCurrentMillis();

		for (int var11 = -192; var11 <= 192 && this.isTicking(); var11 += 16) {
			for (int var12 = -192; var12 <= 192 && this.isTicking(); var12 += 16) {
				long var13 = getCurrentMillis();
				if (var13 - var9 > 1000L) {
					this.a_("Preparing spawn area", var5 * 100 / 625);
					var9 = var13;
				}

				++var5;
				var7.b.c(var8.getX() + var11 >> 4, var8.getZ() + var12 >> 4);
			}
		}
	}

	protected void a(String var1, IDataManager var2) {
		File var3 = new File(var2.b(), "resources.zip");
		if (var3.isFile()) {
			this.setResourcePack("level://" + var1 + "/" + var3.getName(), "");
		}

	}

	public abstract boolean isStructureGenerationEnabled();

	public abstract GameMode getServerGameMode();

	public abstract Difficulty getDifficulty();

	public abstract boolean isHardcore();

	public abstract int getOpPermissionLevel();

	protected void a_(String var1, int var2) {
		logger.info(var1 + ": " + var2 + "%");
	}

	protected void saveChunks(boolean silenced) {
		if (!this.N) {
			for (WorldServer world : worlds) {
				if (world != null) {
					if (!silenced) {
						logger.info("Saving chunks for level \'" + world.P().k() + "\'/" + world.worldProvider.k());
					}

					try {
						world.save(true, (uy) null);
					} catch (aqz var7) {
						logger.warn(var7.getMessage());
					}
				}
			}

		}
	}

	public void stop() {
		if (!this.N) {
			logger.info("Stopping server");
			if (this.getServerConnection() != null) {
				this.getServerConnection().b();
			}

			if (this.playerList != null) {
				logger.info("Saving players");
				this.playerList.k();
				this.playerList.v();
			}

			if (this.worlds != null) {
				logger.info("Saving worlds");
				this.saveChunks(false);

				for (WorldServer world : worlds) {
					world.saveData();
				}
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

	public void run() {
		tick();
	}

	private void tick() {
		try {
			if (this.startServer()) {
				this.lastTickTime = getCurrentMillis();
				long var1 = 0L;
				this.serverPing.a((IChatBaseComponent) (new ChatComponentText(this.E)));
				this.serverPing.a(new nt("1.8", 47));
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
					if (this.worlds[0].f()) {
						this.y();
						var1 = 0L;
					} else {
						while (var1 > 50L) {
							var1 -= 50L;
							this.y();
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

	protected void y() {
		long var1 = System.nanoTime();
		++this.ticks;
		if (this.T) {
			this.T = false;
			this.profiler.a = true;
			this.profiler.a();
		}

		this.profiler.a("root");
		this.doTick();
		if (var1 - this.lastServerPingUpdate >= 5000000000L) {
			this.lastServerPingUpdate = var1;
			this.serverPing.a(new nq(this.H(), this.G()));
			GameProfile[] var3 = new GameProfile[Math.min(this.G(), 12)];
			int var4 = DataTypesConverter.a(this.rnd, 0, this.G() - var3.length);

			for (int var5 = 0; var5 < var3.length; ++var5) {
				var3[var5] = ((EntityPlayer) this.playerList.players.get(var4 + var5)).getGameProfile();
			}

			Collections.shuffle(Arrays.asList(var3));
			this.serverPing.b().a(var3);
		}

		if (this.ticks % 900 == 0) {
			this.profiler.a("save");
			this.playerList.k();
			this.saveChunks(true);
			this.profiler.b();
		}

		this.profiler.a("tallying");
		this.g[this.ticks % 100] = System.nanoTime() - var1;
		this.profiler.b();
		this.profiler.a("snooper");
		if (!this.snooper.d() && this.ticks > 100) {
			this.snooper.a();
		}

		if (this.ticks % 6000 == 0) {
			this.snooper.b();
		}

		this.profiler.b();
		this.profiler.b();
	}

	public void doTick() {
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
		for (i = 0; i < this.worlds.length; ++i) {
			long var2 = System.nanoTime();
			if (i == 0 || this.isNetherAllowed()) {
				WorldServer world = this.worlds[i];
				this.profiler.a(world.P().k());

				if (this.ticks % 20 == 0) {
					this.profiler.a("timeSync");
					this.playerList.sendPacket((Packet<?>) (new PacketPlayOutTimeUpdate(world.K(), world.L(), world.Q().b("doDaylightCycle"))), world.worldProvider.getDimensionId());
					this.profiler.b();
				}

				this.profiler.a("tick");

				CrashReport var6;
				try {
					world.c();
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
				world.s().a();
				this.profiler.b();
				this.profiler.b();
			}

			this.h[i][this.ticks % 100] = System.nanoTime() - var2;
		}

		this.profiler.c("connection");
		this.getServerConnection().c();
		this.profiler.c("players");
		this.playerList.e();
		this.profiler.c("tickables");

		for (i = 0; i < this.o.size(); ++i) {
			((pm) this.o.get(i)).c();
		}

		this.profiler.b();
	}

	public boolean isNetherAllowed() {
		return true;
	}

	public void a(pm var1) {
		this.o.add(var1);
	}

	public static void main(String[] var0) {
		Bootstrap.load();

		try {
			boolean var1 = true;
			String var2 = null;
			String var3 = ".";
			String var4 = null;
			boolean var5 = false;
			boolean var6 = false;
			int var7 = -1;

			for (int var8 = 0; var8 < var0.length; ++var8) {
				String var9 = var0[var8];
				String var10 = var8 == var0.length - 1 ? null : var0[var8 + 1];
				boolean var11 = false;
				if (!var9.equals("nogui") && !var9.equals("--nogui")) {
					if (var9.equals("--port") && var10 != null) {
						var11 = true;

						try {
							var7 = Integer.parseInt(var10);
						} catch (NumberFormatException var13) {
							;
						}
					} else if (var9.equals("--singleplayer") && var10 != null) {
						var11 = true;
						var2 = var10;
					} else if (var9.equals("--universe") && var10 != null) {
						var11 = true;
						var3 = var10;
					} else if (var9.equals("--world") && var10 != null) {
						var11 = true;
						var4 = var10;
					} else if (var9.equals("--demo")) {
						var5 = true;
					} else if (var9.equals("--bonusChest")) {
						var6 = true;
					}
				} else {
					var1 = false;
				}

				if (var11) {
					++var8;
				}
			}

			DedicatedMinecraftServer var15 = new DedicatedMinecraftServer(new File(var3));
			if (var2 != null) {
				var15.j(var2);
			}

			if (var4 != null) {
				var15.setLevelName(var4);
			}

			if (var7 >= 0) {
				var15.setPort(var7);
			}

			if (var5) {
				var15.b(true);
			}

			if (var6) {
				var15.c(true);
			}

			if (var1 && !GraphicsEnvironment.isHeadless()) {
				var15.enableGui();
			}

			var15.B();
			Runtime.getRuntime().addShutdownHook(new ServerShutdownHook("Server Shutdown Thread", var15));
		} catch (Exception var14) {
			logger.fatal("Failed to start the minecraft server", (Throwable) var14);
		}

	}

	public void B() {
		this.mainThread = new Thread(this, "Server thread");
		this.mainThread.start();
	}

	public File d(String var1) {
		return new File(this.w(), var1);
	}

	public void e(String var1) {
		logger.info(var1);
	}

	public void f(String var1) {
		logger.warn(var1);
	}

	public WorldServer a(int var1) {
		return var1 == -1 ? this.worlds[1] : (var1 == 1 ? this.worlds[2] : this.worlds[0]);
	}

	public String C() {
		return this.ip;
	}

	public int D() {
		return this.u;
	}

	public String E() {
		return this.E;
	}

	public String F() {
		return "1.8";
	}

	public int G() {
		return this.playerList.p();
	}

	public int H() {
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
		this.commandHandler.a(tc.h(), var1);
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

	public String d_() {
		return "Server";
	}

	public void sendChatMessage(IChatBaseComponent var1) {
		logger.info(var1.c());
	}

	public boolean a(int var1, String var2) {
		return true;
	}

	public CommandHandlerInterface getCommandHandler() {
		return this.commandHandler;
	}

	public KeyPair P() {
		return this.keyPair;
	}

	public int getPort() {
		return this.u;
	}

	public void setPort(int var1) {
		this.u = var1;
	}

	public String R() {
		return this.I;
	}

	public void j(String var1) {
		this.I = var1;
	}

	public boolean isSinglePlayer() {
		return this.I != null;
	}

	public String getLevelName() {
		return this.J;
	}

	public void setLevelName(String var1) {
		this.J = var1;
	}

	public void setKeyPair(KeyPair var1) {
		this.keyPair = var1;
	}

	public void a(Difficulty var1) {
		for (int var2 = 0; var2 < this.worlds.length; ++var2) {
			WorldServer var3 = this.worlds[var2];
			if (var3 != null) {
				if (var3.P().isHardcore()) {
					var3.P().a(Difficulty.HARD);
					var3.a(true, true);
				} else if (this.isSinglePlayer()) {
					var3.P().a(var1);
					var3.a(var3.getDifficulty() != Difficulty.PEACEFUL, true);
				} else {
					var3.P().a(var1);
					var3.a(this.isMonsterSpawnEnabled(), this.spawnAnimals);
				}
			}
		}

	}

	protected boolean isMonsterSpawnEnabled() {
		return true;
	}

	public boolean W() {
		return this.L;
	}

	public void b(boolean var1) {
		this.L = var1;
	}

	public void c(boolean var1) {
		this.M = var1;
	}

	public Convertable X() {
		return this.convertable;
	}

	public void Z() {
		this.N = true;
		this.X().d();

		for (int var1 = 0; var1 < this.worlds.length; ++var1) {
			WorldServer var2 = this.worlds[var1];
			if (var2 != null) {
				var2.saveData();
			}
		}

		this.X().e(this.worlds[0].O().g());
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
			var1.a("players_current", Integer.valueOf(this.G()));
			var1.a("players_max", Integer.valueOf(this.H()));
			var1.a("players_seen", Integer.valueOf(this.playerList.r().length));
		}

		var1.a("uses_auth", Boolean.valueOf(this.onlineMode));
		var1.a("gui_state", this.isGuiEnabled() ? "enabled" : "disabled");
		var1.a("run_time", Long.valueOf((getCurrentMillis() - var1.g()) / 60L * 1000L));
		var1.a("avg_tick_ms", Integer.valueOf((int) (DataTypesConverter.a(this.g) * 1.0E-6D)));
		int var2 = 0;
		if (this.worlds != null) {
			for (int var3 = 0; var3 < this.worlds.length; ++var3) {
				if (this.worlds[var3] != null) {
					WorldServer var4 = this.worlds[var3];
					WorldData var5 = var4.P();
					var1.a("world[" + var2 + "][dimension]", Integer.valueOf(var4.worldProvider.getDimensionId()));
					var1.a("world[" + var2 + "][mode]", var5.r());
					var1.a("world[" + var2 + "][difficulty]", var4.getDifficulty());
					var1.a("world[" + var2 + "][hardcore]", Boolean.valueOf(var5.isHardcore()));
					var1.a("world[" + var2 + "][generator_name]", var5.getLevelType().a());
					var1.a("world[" + var2 + "][generator_version]", Integer.valueOf(var5.getLevelType().d()));
					var1.a("world[" + var2 + "][height]", Integer.valueOf(this.F));
					var1.a("world[" + var2 + "][chunks_loaded]", Integer.valueOf(var4.N().g()));
					++var2;
				}
			}
		}

		var1.a("worlds", Integer.valueOf(var2));
	}

	public void b(Snooper var1) {
		var1.b("singleplayer", Boolean.valueOf(this.isSinglePlayer()));
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

	public String ak() {
		return this.E;
	}

	public void setMotd(String var1) {
		this.E = var1;
	}

	public int al() {
		return this.F;
	}

	public void c(int var1) {
		this.F = var1;
	}

	public boolean isStopped() {
		return this.stopped;
	}

	public PlayerList getPlayerList() {
		return this.playerList;
	}

	public void setPlayerList(PlayerList playerList) {
		this.playerList = playerList;
	}

	public void setServerGameMode(GameMode var1) {
		for (int i = 0; i < this.worlds.length; ++i) {
			getInstance().worlds[i].P().a(var1);
		}

	}

	public ServerConnection getServerConnection() {
		return this.serverConnection;
	}

	public boolean isGuiEnabled() {
		return false;
	}

	public abstract String a(GameMode var1, boolean var2);

	public int ar() {
		return this.ticks;
	}

	public void as() {
		this.T = true;
	}

	public Position c() {
		return Position.ZERO;
	}

	public Vec3D d() {
		return new Vec3D(0.0D, 0.0D, 0.0D);
	}

	public World e() {
		return this.worlds[0];
	}

	public Entity f() {
		return null;
	}

	public int isSpawnProtectionEnabled() {
		return 16;
	}

	public boolean a(World var1, Position var2, EntityHuman var3) {
		return false;
	}

	public void setForceGameModeEnabled(boolean var1) {
		this.U = var1;
	}

	public boolean av() {
		return this.U;
	}

	public Proxy getProxy() {
		return this.proxy;
	}

	public static long getCurrentMillis() {
		return System.currentTimeMillis();
	}

	public int ay() {
		return this.G;
	}

	public void setIdleTimeout(int var1) {
		this.G = var1;
	}

	public IChatBaseComponent e_() {
		return new ChatComponentText(this.d_());
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

	public void aF() {
		this.lastServerPingUpdate = 0L;
	}

	public Entity a(UUID var1) {
		WorldServer[] var2 = this.worlds;
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			WorldServer var5 = var2[var4];
			if (var5 != null) {
				Entity var6 = var5.a(var1);
				if (var6 != null) {
					return var6;
				}
			}
		}

		return null;
	}

	public boolean t_() {
		return getInstance().worlds[0].Q().b("sendCommandFeedback");
	}

	public void a(ag var1, int var2) {
	}

	public int getMaxWorldSize() {
		return 29999984;
	}

	public ListenableFuture<?> a(Callable<?> var1) {
		Validate.notNull(var1);
		if (!this.isMainThread()) {
			ListenableFutureTask<?> var2 = ListenableFutureTask.create(var1);
			synchronized (this.tasks) {
				this.tasks.add(var2);
				return var2;
			}
		} else {
			try {
				return Futures.immediateFuture(var1.call());
			} catch (Exception var6) {
				return Futures.immediateFailedCheckedFuture(var6);
			}
		}
	}

	public ListenableFuture<?> a(Runnable var1) {
		Validate.notNull(var1);
		return this.a(Executors.callable(var1));
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
