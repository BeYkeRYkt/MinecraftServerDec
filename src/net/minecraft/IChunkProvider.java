package net.minecraft;

import java.util.List;

public interface IChunkProvider {

	boolean isChunkLoaded(int var1, int var2);

	Chunk getOrCreateChunk(int var1, int var2);

	Chunk getChunkAtWorldCoords(Position var1);

	void getChunkAt(IChunkProvider var1, int var2, int var3);

	boolean ae(IChunkProvider var1, Chunk var2, int var3, int var4);

	boolean requestChunksSave(boolean var1, IProgressUpdate var2);

	boolean unloadChunks();

	boolean canSave();

	String getName();

	List getMobsFor(EnumCreatureType var1, Position var2);

	Position findNearestMapFeature(World var1, String var2, Position var3);

	int getLoadedChunks();

	void recreateStructures(Chunk var1, int var2, int var3);

	void saveChunks();
}
