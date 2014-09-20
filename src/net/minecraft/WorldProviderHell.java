package net.minecraft;

public class WorldProviderHell extends WorldProvider {

	public void b() {
		this.chunkManager = new WorldChunkManagerHell(BiomeBase.HELL, 0.0F);
		this.d = true;
		this.noSkyLight = true;
		this.dimensionId = -1;
	}

	protected void a() {
		float var1 = 0.1F;

		for (int var2 = 0; var2 <= 15; ++var2) {
			float var3 = 1.0F - (float) var2 / 15.0F;
			this.f[var2] = (1.0F - var3) / (var3 * 3.0F + 1.0F) * (1.0F - var1) + var1;
		}

	}

	public IChunkProvider getChunkProvider() {
		return new ChunkProviderHell(this.world, this.world.getWorldData().isMapFeauturesEnabled(), this.world.getSeed());
	}

	public boolean canSpawn(int x, int z) {
		return false;
	}

	public float a(long var1, float var3) {
		return 0.5F;
	}

	public boolean isPrimaryWorld() {
		return false;
	}

	public boolean isSleepAllowed() {
		return false;
	}

	public String getWorldName() {
		return "Nether";
	}

	public String getWorldSuffix() {
		return "_nether";
	}

	public WorldBorder getWorldBorder() {
		return new WorldBorderHell();
	}

}
