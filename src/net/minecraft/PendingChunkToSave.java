package net.minecraft;

class PendingChunkToSave {

	public final ChunkCoordIntPair coorPair;
	public final NBTCompoundTag tag;

	public PendingChunkToSave(ChunkCoordIntPair coorPair, NBTCompoundTag tag) {
		this.coorPair = coorPair;
		this.tag = tag;
	}

}
