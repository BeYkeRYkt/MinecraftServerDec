package net.minecraft;

public abstract class WorldProvider {

	public static final float[] a = new float[] { 1.0F, 0.75F, 0.5F, 0.25F, 0.0F, 0.25F, 0.5F, 0.75F };

	public static WorldProvider getById(int id) {
		return (WorldProvider) (id == -1 ? new WorldProviderHell() : (id == 0 ? new WorldProviderNormal() : (id == 1 ? new WorldProviderTheEnd() : null)));
	}

	protected WorldServer world;
	private LevelType levelType;
	private String generatorOptions;
	protected WorldChunkManager chunkManager;
	protected boolean d;
	protected boolean noSkyLight;
	protected final float[] f = new float[16];
	protected int dimensionId;

	public final void setWorld(WorldServer world) {
		this.world = world;
		this.levelType = world.getWorldData().getLevelType();
		this.generatorOptions = world.getWorldData().getGeneratorOptions();
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
		LevelType var1 = this.world.getWorldData().getLevelType();
		if (var1 == LevelType.FLAT) {
			biv var2 = biv.a(this.world.getWorldData().getGeneratorOptions());
			this.chunkManager = new WorldChunkManagerHell(BiomeBase.a(var2.a(), BiomeBase.OCEAN), 0.5F);
		} else if (var1 == LevelType.DEBUG) {
			this.chunkManager = new WorldChunkManagerHell(BiomeBase.PLAINS, 0.0F);
		} else {
			this.chunkManager = new WorldChunkManager(this.world);
		}

	}

	public IChunkProvider getChunkProvider() {
		return (IChunkProvider) (this.levelType == LevelType.FLAT ? new ChunkProviderFlat(this.world, this.world.J(), this.world.getWorldData().isMapFeauturesEnabled(), this.generatorOptions) : (this.levelType == LevelType.DEBUG ? new ChunkProviderDebug(this.world) : (this.levelType == LevelType.CUSTOM ? new ChunkProviderGenerate(this.world, this.world.J(), this.world.getWorldData().isMapFeauturesEnabled(), this.generatorOptions) : new ChunkProviderGenerate(this.world, this.world.J(), this.world.getWorldData().isMapFeauturesEnabled(), this.generatorOptions))));
	}

	public boolean canSpawn(int x, int y) {
		return this.world.c(new Position(x, 0, y)) == Blocks.GRASS;
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

	public boolean isSleepAllowed() {
		return true;
	}

	public boolean isPrimaryWorld() {
		return true;
	}

	public Position h() {
		return null;
	}

	public int i() {
		return this.levelType == LevelType.FLAT ? 4 : 64;
	}

	public abstract String getWorldName();

	public abstract String getWorldSuffix();

	public WorldChunkManager m() {
		return this.chunkManager;
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

	public WorldBorder getWorldBorder() {
		return new WorldBorder();
	}

}
