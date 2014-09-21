package net.minecraft;

public class ChunkCoordIntPair {

	public final int chunkX;
	public final int chunkZ;

	public ChunkCoordIntPair(int chunkX, int chunkZ) {
		this.chunkX = chunkX;
		this.chunkZ = chunkZ;
	}

	public static long toLongHash(int chunkX, int chunkZ) {
		return (long) chunkX & 4294967295L | ((long) chunkZ & 4294967295L) << 32;
	}

	public int hashCode() {
		int hashX = 1664525 * this.chunkX + 1013904223;
		int hashZ = 1664525 * (this.chunkZ ^ -559038737) + 1013904223;
		return hashX ^ hashZ;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (!(obj instanceof ChunkCoordIntPair)) {
			return false;
		} else {
			ChunkCoordIntPair otherCoords = (ChunkCoordIntPair) obj;
			return this.chunkX == otherCoords.chunkX && this.chunkZ == otherCoords.chunkZ;
		}
	}

	public int getBlockCenterX() {
		return (this.chunkX << 4) + 8;
	}

	public int getBlockCenterZ() {
		return (this.chunkZ << 4) + 8;
	}

	public int getBlockMinX() {
		return this.chunkX << 4;
	}

	public int getBlockMinZ() {
		return this.chunkZ << 4;
	}

	public int getBlockMaxX() {
		return (this.chunkX << 4) + 15;
	}

	public int getBlockMaxZ() {
		return (this.chunkZ << 4) + 15;
	}

	public Position getPosition(int relX, int y, int relZ) {
		return new Position((this.chunkX << 4) + relX, y, (this.chunkZ << 4) + relZ);
	}

	public Position getPositionAtCenter(int y) {
		return new Position(this.getBlockCenterX(), y, this.getBlockCenterZ());
	}

	public String toString() {
		return "[" + this.chunkX + ", " + this.chunkZ + "]";
	}

}
