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
import java.util.concurrent.FutureTask;

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
	private KeyPair H;
	private String I;
	private String J;
	private boolean L;
	private boolean M;
	private boolean N;
	private String O = "";
	private String P = "";
	private boolean Q;
	private long R;
	private String S;
	private boolean T;
	private boolean U;
	private final YggdrasilAuthenticationService V;
	private final MinecraftSessionService W;
	private long X = 0L;
	private final GameProfileRepository Y;
	private final ry Z;
	protected final Queue<ListenableFutureTask> i = Queues.newArrayDeque();
	private Thread aa;
	private long ab = getCurrentMillis();

	public MinecraftServer(File var1, Proxy var2, File var3) {
		this.proxy = var2;
		instance = this;
		this.universe = var1;
		this.serverConnection = new ServerConnection(this);
		this.Z = new ry(this, var3);
		this.commandHandler = this.h();
		this.convertable = new bqj(var1);
		this.V = new YggdrasilAuthenticationService(var2, UUID.randomUUID().toString());
		this.W = this.V.createMinecraftSessionService();
		this.Y = this.V.createProfileRepository();
	}

	protected cl h() {
		return new cl();
	}

	protected abstract boolean i() throws UnknownHostException;

	protected void a(String var1) {
		if (this.X().b(var1)) {
			logger.info("Converting map!");
			this.b("menu.convertingLevel");
			this.X().a(var1, new pd(this));
		}

	}

	protected synchronized void b(String var1) {
		this.S = var1;
	}

	protected void a(String var1, String var2, long var3, are var5, String var6) {
		this.a(var1);
		this.b("menu.loadingLevel");
		this.worlds = new WorldServer[3];
		this.h = new long[this.worlds.length][100];
		bqy var7 = this.convertable.a(var1, true);
		this.a(this.T(), var7);
		bqo var9 = var7.d();
		arb var8;
		if (var9 == null) {
			if (this.W()) {
				var8 = qj.a;
			} else {
				var8 = new arb(var3, this.m(), this.l(), this.o(), var5);
				var8.a(var6);
				if (this.M) {
					var8.a();
				}
			}

			var9 = new bqo(var8, var2);
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
					this.worlds[var10] = (WorldServer) (new qj(this, var7, var9, var11, this.profiler)).b();
				} else {
					this.worlds[var10] = (WorldServer) (new WorldServer(this, var7, var9, var11, this.profiler)).b();
				}

				this.worlds[var10].a(var8);
			} else {
				this.worlds[var10] = (WorldServer) (new ql(this, var7, var11, this.worlds[0], this.profiler)).b();
			}

			this.worlds[var10].a((ara) (new qp(this, this.worlds[var10])));
			if (!this.S()) {
				this.worlds[var10].P().a(this.m());
			}
		}

		this.playerList.a(this.worlds);
		this.a(this.n());
		this.k();
	}

	protected void k() {
		int var5 = 0;
		this.b("menu.generatingTerrain");
		byte var6 = 0;
		logger.info("Preparing start region for level " + var6);
		WorldServer var7 = this.worlds[var6];
		dt var8 = var7.M();
		long var9 = getCurrentMillis();

		for (int var11 = -192; var11 <= 192 && this.isTicking(); var11 += 16) {
			for (int var12 = -192; var12 <= 192 && this.isTicking(); var12 += 16) {
				long var13 = getCurrentMillis();
				if (var13 - var9 > 1000L) {
					this.a_("Preparing spawn area", var5 * 100 / 625);
					var9 = var13;
				}

				++var5;
				var7.b.c(var8.n() + var11 >> 4, var8.p() + var12 >> 4);
			}
		}
	}

	protected void a(String var1, bqy var2) {
		File var3 = new File(var2.b(), "resources.zip");
		if (var3.isFile()) {
			this.a_("level://" + var1 + "/" + var3.getName(), "");
		}

	}

	public abstract boolean l();

	public abstract arc m();

	public abstract vt n();

	public abstract boolean o();

	public abstract int p();

	protected void a_(String var1, int var2) {
		logger.info(var1 + ": " + var2 + "%");
	}

	protected void saveChunks(boolean silenced) {
		if (!this.N) {
			for (WorldServer world : worlds) {
				if (world != null) {
					if (!silenced) {
						logger.info("Saving chunks for level \'" + world.P().k() + "\'/" + world.t.k());
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
			if (this.ao() != null) {
				this.ao().b();
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
		try {
			if (this.i()) {
				this.ab = getCurrentMillis();
				long var1 = 0L;
				this.serverPing.a((ho) (new hy(this.E)));
				this.serverPing.a(new nt("1.8", 47));
				this.a(this.serverPing);

				while (this.running) {
					long var48 = getCurrentMillis();
					long var5 = var48 - this.ab;
					if (var5 > 2000L && this.ab - this.R >= 15000L) {
						logger.warn("Can\'t keep up! Did the system time change, or is the server overloaded? Running {}ms behind, skipping {} tick(s)", new Object[] { Long.valueOf(var5), Long.valueOf(var5 / 50L) });
						var5 = 2000L;
						this.R = this.ab;
					}

					if (var5 < 0L) {
						logger.warn("Time ran backwards! Did the system time change?");
						var5 = 0L;
					}

					var1 += var5;
					this.ab = var48;
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
					this.Q = true;
				}
			} else {
				this.a((CrashReport) null);
			}
		} catch (Throwable var46) {
			logger.error("Encountered an unexpected exception", var46);
			CrashReport var2 = null;
			if (var46 instanceof u) {
				var2 = this.b(((u) var46).a());
			} else {
				var2 = this.b(new CrashReport("Exception in server tick loop", var46));
			}

			File var3 = new File(new File(this.w(), "crash-reports"), "crash-" + (new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss")).format(new Date()) + "-server.txt");
			if (var2.a(var3)) {
				logger.error("This crash report has been saved to: " + var3.getAbsolutePath());
			} else {
				logger.error("We were unable to save this crash report to disk.");
			}

			this.a(var2);
		} finally {
			try {
				this.stop();
				this.stopped = true;
			} catch (Throwable var44) {
				logger.error("Exception stopping the server", var44);
			} finally {
				this.x();
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

	protected void a(CrashReport var1) {
	}

	protected void x() {
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
		this.z();
		if (var1 - this.X >= 5000000000L) {
			this.X = var1;
			this.serverPing.a(new nq(this.H(), this.G()));
			GameProfile[] var3 = new GameProfile[Math.min(this.G(), 12)];
			int var4 = uv.a(this.rnd, 0, this.G() - var3.length);

			for (int var5 = 0; var5 < var3.length; ++var5) {
				var3[var5] = ((qw) this.playerList.e.get(var4 + var5)).cc();
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

	public void z() {
		this.profiler.a("jobs");
		Queue<ListenableFutureTask> var1 = this.i;
		synchronized (this.i) {
			while (!this.i.isEmpty()) {
				try {
					((FutureTask) this.i.poll()).run();
				} catch (Throwable var9) {
					logger.fatal((Object) var9);
				}
			}
		}

		this.profiler.c("levels");

		int var11;
		for (var11 = 0; var11 < this.worlds.length; ++var11) {
			long var2 = System.nanoTime();
			if (var11 == 0 || this.A()) {
				WorldServer var4 = this.worlds[var11];
				this.profiler.a(var4.P().k());
				if (this.ticks % 20 == 0) {
					this.profiler.a("timeSync");
					this.playerList.a((id) (new li(var4.K(), var4.L(), var4.Q().b("doDaylightCycle"))), var4.t.q());
					this.profiler.b();
				}

				this.profiler.a("tick");

				CrashReport var6;
				try {
					var4.c();
				} catch (Throwable var8) {
					var6 = CrashReport.a(var8, "Exception ticking world");
					var4.a(var6);
					throw new u(var6);
				}

				try {
					var4.i();
				} catch (Throwable var7) {
					var6 = CrashReport.a(var7, "Exception ticking world entities");
					var4.a(var6);
					throw new u(var6);
				}

				this.profiler.b();
				this.profiler.a("tracker");
				var4.s().a();
				this.profiler.b();
				this.profiler.b();
			}

			this.h[var11][this.ticks % 100] = System.nanoTime() - var2;
		}

		this.profiler.c("connection");
		this.ao().c();
		this.profiler.c("players");
		this.playerList.e();
		this.profiler.c("tickables");

		for (var11 = 0; var11 < this.o.size(); ++var11) {
			((pm) this.o.get(var11)).c();
		}

		this.profiler.b();
	}

	public boolean A() {
		return true;
	}

	public void a(pm var1) {
		this.o.add(var1);
	}

	public static void main(String[] var0) {
		od.c();

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
				var15.k(var4);
			}

			if (var7 >= 0) {
				var15.b(var7);
			}

			if (var5) {
				var15.b(true);
			}

			if (var6) {
				var15.c(true);
			}

			if (var1 && !GraphicsEnvironment.isHeadless()) {
				var15.aO();
			}

			var15.B();
			Runtime.getRuntime().addShutdownHook(new ServerShutdownHook("Server Shutdown Thread", var15));
		} catch (Exception var14) {
			logger.fatal("Failed to start the minecraft server", (Throwable) var14);
		}

	}

	public void B() {
		this.aa = new Thread(this, "Server thread");
		this.aa.start();
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
		return this.playerList.q();
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
		var1.g().a("Profiler Position", (Callable) (new pf(this)));
		if (this.playerList != null) {
			var1.g().a("Player Count", (Callable) (new pg(this)));
		}

		return var1;
	}

	public List<String> a(CommandSenderInterface var1, String var2, dt var3) {
		ArrayList<String> var4 = Lists.newArrayList();
		if (var2.startsWith("/")) {
			var2 = var2.substring(1);
			boolean var11 = !var2.contains(" ");
			List var12 = this.commandHandler.a(var1, var2, var3);
			if (var12 != null) {
				Iterator var13 = var12.iterator();

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
				if (AbstractCommand.a(var6, var10)) {
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

	public void a(ho var1) {
		logger.info(var1.c());
	}

	public boolean a(int var1, String var2) {
		return true;
	}

	public CommandHandlerInterface getCommandHandler() {
		return this.commandHandler;
	}

	public KeyPair P() {
		return this.H;
	}

	public int Q() {
		return this.u;
	}

	public void b(int var1) {
		this.u = var1;
	}

	public String R() {
		return this.I;
	}

	public void j(String var1) {
		this.I = var1;
	}

	public boolean S() {
		return this.I != null;
	}

	public String T() {
		return this.J;
	}

	public void k(String var1) {
		this.J = var1;
	}

	public void a(KeyPair var1) {
		this.H = var1;
	}

	public void a(vt var1) {
		for (int var2 = 0; var2 < this.worlds.length; ++var2) {
			WorldServer var3 = this.worlds[var2];
			if (var3 != null) {
				if (var3.P().t()) {
					var3.P().a(vt.d);
					var3.a(true, true);
				} else if (this.S()) {
					var3.P().a(var1);
					var3.a(var3.aa() != vt.a, true);
				} else {
					var3.P().a(var1);
					var3.a(this.V(), this.spawnAnimals);
				}
			}
		}

	}

	protected boolean V() {
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

	public void a_(String var1, String var2) {
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
		var1.a("gui_state", this.aq() ? "enabled" : "disabled");
		var1.a("run_time", Long.valueOf((getCurrentMillis() - var1.g()) / 60L * 1000L));
		var1.a("avg_tick_ms", Integer.valueOf((int) (uv.a(this.g) * 1.0E-6D)));
		int var2 = 0;
		if (this.worlds != null) {
			for (int var3 = 0; var3 < this.worlds.length; ++var3) {
				if (this.worlds[var3] != null) {
					WorldServer var4 = this.worlds[var3];
					bqo var5 = var4.P();
					var1.a("world[" + var2 + "][dimension]", Integer.valueOf(var4.t.q()));
					var1.a("world[" + var2 + "][mode]", var5.r());
					var1.a("world[" + var2 + "][difficulty]", var4.aa());
					var1.a("world[" + var2 + "][hardcore]", Boolean.valueOf(var5.t()));
					var1.a("world[" + var2 + "][generator_name]", var5.u().a());
					var1.a("world[" + var2 + "][generator_version]", Integer.valueOf(var5.u().d()));
					var1.a("world[" + var2 + "][height]", Integer.valueOf(this.F));
					var1.a("world[" + var2 + "][chunks_loaded]", Integer.valueOf(var4.N().g()));
					++var2;
				}
			}
		}

		var1.a("worlds", Integer.valueOf(var2));
	}

	public void b(Snooper var1) {
		var1.b("singleplayer", Boolean.valueOf(this.S()));
		var1.b("server_brand", this.getServerModName());
		var1.b("gui_supported", GraphicsEnvironment.isHeadless() ? "headless" : "supported");
		var1.b("dedicated", Boolean.valueOf(this.ad()));
	}

	public boolean ac() {
		return true;
	}

	public abstract boolean ad();

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

	public abstract boolean aj();

	public String ak() {
		return this.E;
	}

	public void m(String var1) {
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

	public PlayerList an() {
		return this.playerList;
	}

	public void a(PlayerList var1) {
		this.playerList = var1;
	}

	public void a(arc var1) {
		for (int var2 = 0; var2 < this.worlds.length; ++var2) {
			getInstance().worlds[var2].P().a(var1);
		}

	}

	public ServerConnection ao() {
		return this.serverConnection;
	}

	public boolean aq() {
		return false;
	}

	public abstract String a(arc var1, boolean var2);

	public int ar() {
		return this.ticks;
	}

	public void as() {
		this.T = true;
	}

	public dt c() {
		return dt.a;
	}

	public brw d() {
		return new brw(0.0D, 0.0D, 0.0D);
	}

	public World e() {
		return this.worlds[0];
	}

	public Entity f() {
		return null;
	}

	public int au() {
		return 16;
	}

	public boolean a(World var1, dt var2, ahd var3) {
		return false;
	}

	public void i(boolean var1) {
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

	public void d(int var1) {
		this.G = var1;
	}

	public ho e_() {
		return new hy(this.d_());
	}

	public boolean az() {
		return true;
	}

	public MinecraftSessionService aB() {
		return this.W;
	}

	public GameProfileRepository aC() {
		return this.Y;
	}

	public ry aD() {
		return this.Z;
	}

	public ServerPing aE() {
		return this.serverPing;
	}

	public void aF() {
		this.X = 0L;
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

	public int aG() {
		return 29999984;
	}

	public ListenableFuture a(Callable var1) {
		Validate.notNull(var1);
		if (!this.aH()) {
			ListenableFutureTask var2 = ListenableFutureTask.create(var1);
			Queue var3 = this.i;
			synchronized (this.i) {
				this.i.add(var2);
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

	public ListenableFuture a(Runnable var1) {
		Validate.notNull(var1);
		return this.a(Executors.callable(var1));
	}

	public boolean aH() {
		return Thread.currentThread() == this.aa;
	}

	public int aI() {
		return 256;
	}

	public long aJ() {
		return this.ab;
	}

	public Thread aK() {
		return this.aa;
	}

	// $FF: synthetic method
	public static Logger getLogger() {
		return logger;
	}

	// $FF: synthetic method
	public static PlayerList a(MinecraftServer var0) {
		return var0.playerList;
	}

}
