package net.minecraft;

import java.util.concurrent.Callable;
import net.minecraft.server.MinecraftServer;

public class WorldData {

	public static final Difficulty a = Difficulty.NORMAL;
	private long b;
	private LevelType c;
	private String d;
	private int e;
	private int f;
	private int g;
	private long h;
	private long i;
	private long j;
	private long k;
	private NBTCompoundTag l;
	private int m;
	private String n;
	private int o;
	private int p;
	private boolean q;
	private int r;
	private boolean s;
	private int t;
	private GameMode u;
	private boolean v;
	private boolean isHardcore;
	private boolean x;
	private boolean y;
	private Difficulty difficulty;
	private boolean A;
	private double B;
	private double C;
	private double D;
	private long E;
	private double F;
	private double G;
	private double H;
	private int I;
	private int J;
	private GameRuleRegistry K;

	protected WorldData() {
		this.c = LevelType.DEFAULT;
		this.d = "";
		this.B = 0.0D;
		this.C = 0.0D;
		this.D = 6.0E7D;
		this.E = 0L;
		this.F = 0.0D;
		this.G = 5.0D;
		this.H = 0.2D;
		this.I = 5;
		this.J = 15;
		this.K = new GameRuleRegistry();
	}

	public WorldData(NBTCompoundTag var1) {
		this.c = LevelType.DEFAULT;
		this.d = "";
		this.B = 0.0D;
		this.C = 0.0D;
		this.D = 6.0E7D;
		this.E = 0L;
		this.F = 0.0D;
		this.G = 5.0D;
		this.H = 0.2D;
		this.I = 5;
		this.J = 15;
		this.K = new GameRuleRegistry();
		this.b = var1.getLong("RandomSeed");
		if (var1.isTagAssignableFrom("generatorName", 8)) {
			String var2 = var1.getString("generatorName");
			this.c = LevelType.byName(var2);
			if (this.c == null) {
				this.c = LevelType.DEFAULT;
			} else if (this.c.f()) {
				int var3 = 0;
				if (var1.isTagAssignableFrom("generatorVersion", 99)) {
					var3 = var1.getInt("generatorVersion");
				}

				this.c = this.c.a(var3);
			}

			if (var1.isTagAssignableFrom("generatorOptions", 8)) {
				this.d = var1.getString("generatorOptions");
			}
		}

		this.u = GameMode.byId(var1.getInt("GameType"));
		if (var1.isTagAssignableFrom("MapFeatures", 99)) {
			this.v = var1.getBoolean("MapFeatures");
		} else {
			this.v = true;
		}

		this.e = var1.getInt("SpawnX");
		this.f = var1.getInt("SpawnY");
		this.g = var1.getInt("SpawnZ");
		this.h = var1.getLong("Time");
		if (var1.isTagAssignableFrom("DayTime", 99)) {
			this.i = var1.getLong("DayTime");
		} else {
			this.i = this.h;
		}

		this.j = var1.getLong("LastPlayed");
		this.k = var1.getLong("SizeOnDisk");
		this.n = var1.getString("LevelName");
		this.o = var1.getInt("version");
		this.p = var1.getInt("clearWeatherTime");
		this.r = var1.getInt("rainTime");
		this.q = var1.getBoolean("raining");
		this.t = var1.getInt("thunderTime");
		this.s = var1.getBoolean("thundering");
		this.isHardcore = var1.getBoolean("hardcore");
		if (var1.isTagAssignableFrom("initialized", 99)) {
			this.y = var1.getBoolean("initialized");
		} else {
			this.y = true;
		}

		if (var1.isTagAssignableFrom("allowCommands", 99)) {
			this.x = var1.getBoolean("allowCommands");
		} else {
			this.x = this.u == GameMode.CREATIVE;
		}

		if (var1.isTagAssignableFrom("Player", 10)) {
			this.l = var1.getCompound("Player");
			this.m = this.l.getInt("Dimension");
		}

		if (var1.isTagAssignableFrom("GameRules", 10)) {
			this.K.a(var1.getCompound("GameRules"));
		}

		if (var1.isTagAssignableFrom("Difficulty", 99)) {
			this.difficulty = Difficulty.clampAndGetById(var1.getByte("Difficulty"));
		}

		if (var1.isTagAssignableFrom("DifficultyLocked", 1)) {
			this.A = var1.getBoolean("DifficultyLocked");
		}

		if (var1.isTagAssignableFrom("BorderCenterX", 99)) {
			this.B = var1.getDouble("BorderCenterX");
		}

		if (var1.isTagAssignableFrom("BorderCenterZ", 99)) {
			this.C = var1.getDouble("BorderCenterZ");
		}

		if (var1.isTagAssignableFrom("BorderSize", 99)) {
			this.D = var1.getDouble("BorderSize");
		}

		if (var1.isTagAssignableFrom("BorderSizeLerpTime", 99)) {
			this.E = var1.getLong("BorderSizeLerpTime");
		}

		if (var1.isTagAssignableFrom("BorderSizeLerpTarget", 99)) {
			this.F = var1.getDouble("BorderSizeLerpTarget");
		}

		if (var1.isTagAssignableFrom("BorderSafeZone", 99)) {
			this.G = var1.getDouble("BorderSafeZone");
		}

		if (var1.isTagAssignableFrom("BorderDamagePerBlock", 99)) {
			this.H = var1.getDouble("BorderDamagePerBlock");
		}

		if (var1.isTagAssignableFrom("BorderWarningBlocks", 99)) {
			this.I = var1.getInt("BorderWarningBlocks");
		}

		if (var1.isTagAssignableFrom("BorderWarningTime", 99)) {
			this.J = var1.getInt("BorderWarningTime");
		}

	}

	public WorldData(arb var1, String var2) {
		this.c = LevelType.DEFAULT;
		this.d = "";
		this.B = 0.0D;
		this.C = 0.0D;
		this.D = 6.0E7D;
		this.E = 0L;
		this.F = 0.0D;
		this.G = 5.0D;
		this.H = 0.2D;
		this.I = 5;
		this.J = 15;
		this.K = new GameRuleRegistry();
		this.a(var1);
		this.n = var2;
		this.difficulty = a;
		this.y = false;
	}

	public void a(arb var1) {
		this.b = var1.d();
		this.u = var1.e();
		this.v = var1.g();
		this.isHardcore = var1.f();
		this.c = var1.h();
		this.d = var1.j();
		this.x = var1.i();
	}

	public WorldData(WorldData var1) {
		this.c = LevelType.DEFAULT;
		this.d = "";
		this.B = 0.0D;
		this.C = 0.0D;
		this.D = 6.0E7D;
		this.E = 0L;
		this.F = 0.0D;
		this.G = 5.0D;
		this.H = 0.2D;
		this.I = 5;
		this.J = 15;
		this.K = new GameRuleRegistry();
		this.b = var1.b;
		this.c = var1.c;
		this.d = var1.d;
		this.u = var1.u;
		this.v = var1.v;
		this.e = var1.e;
		this.f = var1.f;
		this.g = var1.g;
		this.h = var1.h;
		this.i = var1.i;
		this.j = var1.j;
		this.k = var1.k;
		this.l = var1.l;
		this.m = var1.m;
		this.n = var1.n;
		this.o = var1.o;
		this.r = var1.r;
		this.q = var1.q;
		this.t = var1.t;
		this.s = var1.s;
		this.isHardcore = var1.isHardcore;
		this.x = var1.x;
		this.y = var1.y;
		this.K = var1.K;
		this.difficulty = var1.difficulty;
		this.A = var1.A;
		this.B = var1.B;
		this.C = var1.C;
		this.D = var1.D;
		this.E = var1.E;
		this.F = var1.F;
		this.G = var1.G;
		this.H = var1.H;
		this.J = var1.J;
		this.I = var1.I;
	}

	public NBTCompoundTag a() {
		NBTCompoundTag var1 = new NBTCompoundTag();
		this.a(var1, this.l);
		return var1;
	}

	public NBTCompoundTag a(NBTCompoundTag var1) {
		NBTCompoundTag var2 = new NBTCompoundTag();
		this.a(var2, var1);
		return var2;
	}

	private void a(NBTCompoundTag var1, NBTCompoundTag var2) {
		var1.put("RandomSeed", this.b);
		var1.put("generatorName", this.c.a());
		var1.put("generatorVersion", this.c.d());
		var1.put("generatorOptions", this.d);
		var1.put("GameType", this.u.getId());
		var1.put("MapFeatures", this.v);
		var1.put("SpawnX", this.e);
		var1.put("SpawnY", this.f);
		var1.put("SpawnZ", this.g);
		var1.put("Time", this.h);
		var1.put("DayTime", this.i);
		var1.put("SizeOnDisk", this.k);
		var1.put("LastPlayed", MinecraftServer.getCurrentMillis());
		var1.put("LevelName", this.n);
		var1.put("version", this.o);
		var1.put("clearWeatherTime", this.p);
		var1.put("rainTime", this.r);
		var1.put("raining", this.q);
		var1.put("thunderTime", this.t);
		var1.put("thundering", this.s);
		var1.put("hardcore", this.isHardcore);
		var1.put("allowCommands", this.x);
		var1.put("initialized", this.y);
		var1.put("BorderCenterX", this.B);
		var1.put("BorderCenterZ", this.C);
		var1.put("BorderSize", this.D);
		var1.put("BorderSizeLerpTime", this.E);
		var1.put("BorderSafeZone", this.G);
		var1.put("BorderDamagePerBlock", this.H);
		var1.put("BorderSizeLerpTarget", this.F);
		var1.put("BorderWarningBlocks", (double) this.I);
		var1.put("BorderWarningTime", (double) this.J);
		if (this.difficulty != null) {
			var1.put("Difficulty", (byte) this.difficulty.getId());
		}

		var1.put("DifficultyLocked", this.A);
		var1.put("GameRules", (NBTTag) this.K.a());
		if (var2 != null) {
			var1.put("Player", (NBTTag) var2);
		}

	}

	public long b() {
		return this.b;
	}

	public int c() {
		return this.e;
	}

	public int d() {
		return this.f;
	}

	public int e() {
		return this.g;
	}

	public long f() {
		return this.h;
	}

	public long g() {
		return this.i;
	}

	public NBTCompoundTag i() {
		return this.l;
	}

	public void b(long var1) {
		this.h = var1;
	}

	public void c(long var1) {
		this.i = var1;
	}

	public void a(Position var1) {
		this.e = var1.n();
		this.f = var1.o();
		this.g = var1.p();
	}

	public String k() {
		return this.n;
	}

	public void a(String var1) {
		this.n = var1;
	}

	public int l() {
		return this.o;
	}

	public void e(int var1) {
		this.o = var1;
	}

	public int A() {
		return this.p;
	}

	public void i(int var1) {
		this.p = var1;
	}

	public boolean n() {
		return this.s;
	}

	public void a(boolean var1) {
		this.s = var1;
	}

	public int o() {
		return this.t;
	}

	public void f(int var1) {
		this.t = var1;
	}

	public boolean p() {
		return this.q;
	}

	public void b(boolean var1) {
		this.q = var1;
	}

	public int q() {
		return this.r;
	}

	public void g(int var1) {
		this.r = var1;
	}

	public GameMode r() {
		return this.u;
	}

	public boolean s() {
		return this.v;
	}

	public void f(boolean var1) {
		this.v = var1;
	}

	public void a(GameMode var1) {
		this.u = var1;
	}

	public boolean isHardcore() {
		return this.isHardcore;
	}

	public void g(boolean var1) {
		this.isHardcore = var1;
	}

	public LevelType getLevelType() {
		return this.c;
	}

	public void a(LevelType var1) {
		this.c = var1;
	}

	public String B() {
		return this.d;
	}

	public boolean v() {
		return this.x;
	}

	public void c(boolean var1) {
		this.x = var1;
	}

	public boolean w() {
		return this.y;
	}

	public void d(boolean var1) {
		this.y = var1;
	}

	public GameRuleRegistry x() {
		return this.K;
	}

	public double C() {
		return this.B;
	}

	public double D() {
		return this.C;
	}

	public double E() {
		return this.D;
	}

	public void a(double var1) {
		this.D = var1;
	}

	public long F() {
		return this.E;
	}

	public void e(long var1) {
		this.E = var1;
	}

	public double G() {
		return this.F;
	}

	public void b(double var1) {
		this.F = var1;
	}

	public void c(double var1) {
		this.C = var1;
	}

	public void d(double var1) {
		this.B = var1;
	}

	public double H() {
		return this.G;
	}

	public void e(double var1) {
		this.G = var1;
	}

	public double I() {
		return this.H;
	}

	public void f(double var1) {
		this.H = var1;
	}

	public int J() {
		return this.I;
	}

	public int K() {
		return this.J;
	}

	public void j(int var1) {
		this.I = var1;
	}

	public void k(int var1) {
		this.J = var1;
	}

	public Difficulty getDifficulty() {
		return this.difficulty;
	}

	public void a(Difficulty var1) {
		this.difficulty = var1;
	}

	public boolean z() {
		return this.A;
	}

	public void e(boolean var1) {
		this.A = var1;
	}

	public void a(CrashReportSystemDetails var1) {
		var1.addDetails("Level seed", (Callable) (new bqp(this)));
		var1.addDetails("Level generator", (Callable) (new bqq(this)));
		var1.addDetails("Level generator options", (Callable) (new bqr(this)));
		var1.addDetails("Level spawn location", (Callable) (new bqs(this)));
		var1.addDetails("Level time", (Callable) (new bqt(this)));
		var1.addDetails("Level dimension", (Callable) (new bqu(this)));
		var1.addDetails("Level storage version", (Callable) (new bqv(this)));
		var1.addDetails("Level weather", (Callable) (new bqw(this)));
		var1.addDetails("Level game mode", (Callable) (new bqx(this)));
	}

	// $FF: synthetic method
	static LevelType a(WorldData var0) {
		return var0.c;
	}

	// $FF: synthetic method
	static boolean b(WorldData var0) {
		return var0.v;
	}

	// $FF: synthetic method
	static String c(WorldData var0) {
		return var0.d;
	}

	// $FF: synthetic method
	static int d(WorldData var0) {
		return var0.e;
	}

	// $FF: synthetic method
	static int e(WorldData var0) {
		return var0.f;
	}

	// $FF: synthetic method
	static int f(WorldData var0) {
		return var0.g;
	}

	// $FF: synthetic method
	static long g(WorldData var0) {
		return var0.h;
	}

	// $FF: synthetic method
	static long h(WorldData var0) {
		return var0.i;
	}

	// $FF: synthetic method
	static int i(WorldData var0) {
		return var0.m;
	}

	// $FF: synthetic method
	static int j(WorldData var0) {
		return var0.o;
	}

	// $FF: synthetic method
	static int k(WorldData var0) {
		return var0.r;
	}

	// $FF: synthetic method
	static boolean l(WorldData var0) {
		return var0.q;
	}

	// $FF: synthetic method
	static int m(WorldData var0) {
		return var0.t;
	}

	// $FF: synthetic method
	static boolean n(WorldData var0) {
		return var0.s;
	}

	// $FF: synthetic method
	static GameMode o(WorldData var0) {
		return var0.u;
	}

	// $FF: synthetic method
	static boolean p(WorldData var0) {
		return var0.isHardcore;
	}

	// $FF: synthetic method
	static boolean q(WorldData var0) {
		return var0.x;
	}

}
