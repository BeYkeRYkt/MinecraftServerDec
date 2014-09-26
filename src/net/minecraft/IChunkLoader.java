package net.minecraft;

import java.io.IOException;

public interface IChunkLoader {

	Chunk loadChunk(WorldServer worldServer, int chunkX, int chunkZ) throws IOException;

	void requestChunkSave(WorldServer worldServer, Chunk chunk) throws ExceptionWorldConflict;

	boolean isQueuedForSaving(Chunk chunk);

	void saveAllChunks();

}
