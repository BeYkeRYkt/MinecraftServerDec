package net.minecraft;

public abstract class WorldProvider {

	public static final float[] a = new float[] { 1.0F, 0.75F, 0.5F, 0.25F, 0.0F, 0.25F, 0.5F, 0.75F };
	protected World b;
	private LevelType h;
	private String i;
	protected arz c;
	protected boolean d;
	protected boolean noSkyLight;
	protected final float[] f = new float[16];
	protected int dimensionId;
	private final float[] j = new float[4];

	public final void a(World var1) {
		this.b = var1;
		this.h = var1.getWorldData().getLevelType();
		this.i = var1.getWorldData().B();
		this.b();
		this.a();
	}

	protected void a() {
		float var1 = 0.0F;

		for (int var2 = 0; var2 <= 15; ++var2) {
			float var3 = 1.0F - (float) var2 / 15.0F;
			this.f[var2] = (1.0F - var3) / (var3 * 3.0F + 1.0F) * (1.0F - var1) + var1;
		}

	}

	protected void b() {
		LevelType var1 = this.b.getWorldData().getLevelType();
		if (var1 == LevelType.FLAT) {
			biv var2 = biv.a(this.b.getWorldData().B());
			this.c = new asc(arm.a(var2.a(), arm.ad), 0.5F);
		} else if (var1 == LevelType.DEBUG) {
			this.c = new asc(arm.q, 0.0F);
		} else {
			this.c = new arz(this.b);
		}

	}

	public IChunkProvider c() {
		return (IChunkProvider) (this.h == LevelType.FLAT ? new bgq(this.b, this.b.J(), this.b.getWorldData().s(), this.i) : (this.h == LevelType.DEBUG ? new bgp(this.b) : (this.h == LevelType.CUSTOM ? new bgv(this.b, this.b.J(), this.b.getWorldData().s(), this.i) : new bgv(this.b, this.b.J(), this.b.getWorldData().s(), this.i))));
	}

	public boolean a(int var1, int var2) {
		return this.b.c(new Position(var1, 0, var2)) == Blocks.GRASS;
	}

	public float a(long var1, float var3) {
		int var4 = (int) (var1 % 24000L);
		float var5 = ((float) var4 + var3) / 24000.0F - 0.25F;
		if (var5 < 0.0F) {
			++var5;
		}

		if (var5 > 1.0F) {
			--var5;
		}

		float var6 = var5;
		var5 = 1.0F - (float) ((Math.cos((double) var5 * 3.141592653589793D) + 1.0D) / 2.0D);
		var5 = var6 + (var5 - var6) / 3.0F;
		return var5;
	}

	public int a(long var1) {
		return (int) (var1 / 24000L % 8L + 8L) % 8;
	}

	public boolean d() {
		return true;
	}

	public boolean e() {
		return true;
	}

	public static WorldProvider a(int var0) {
		return (WorldProvider) (var0 == -1 ? new NetherWorldProvider() : (var0 == 0 ? new NormalWorldProvider() : (var0 == 1 ? new TheEndWorldProvider() : null)));
	}

	public Position h() {
		return null;
	}

	public int i() {
		return this.h == LevelType.FLAT ? 4 : 64;
	}

	public abstract String k();

	public abstract String l();

	public arz m() {
		return this.c;
	}

	public boolean n() {
		return this.d;
	}

	public boolean noSkyLight() {
		return this.noSkyLight;
	}

	public float[] p() {
		return this.f;
	}

	public int getDimensionId() {
		return this.dimensionId;
	}

	public WorldBorder r() {
		return new WorldBorder();
	}

}
