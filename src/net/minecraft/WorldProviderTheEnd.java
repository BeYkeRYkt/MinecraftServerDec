package net.minecraft;

public class WorldProviderTheEnd extends WorldProvider {

	public void b() {
		this.chunkManager = new WorldChunkManagerHell(BiomeBase.SKY, 0.0F);
		this.dimensionId = 1;
		this.noSkyLight = true;
	}

	public IChunkProvider getChunkProvider() {
		return new ChunkProviderTheEnd(this.world, this.world.J());
	}

	public float a(long var1, float var3) {
		return 0.0F;
	}

	public boolean isPrimaryWorld() {
		return false;
	}

	public boolean isSleepAllowed() {
		return false;
	}

	public boolean canSpawn(int var1, int var2) {
		return this.world.c(new Position(var1, 0, var2)).getMaterial().isSolid();
	}

	public Position h() {
		return new Position(100, 50, 0);
	}

	public int i() {
		return 50;
	}

	public String getWorldName() {
		return "The End";
	}

	public String getWorldSuffix() {
		return "_end";
	}
}
