package net.minecraft;

import java.io.IOException;

public interface IChunkLoader {

	Chunk loadChunk(WorldServer var1, int var2, int var3) throws IOException;

	void requestChunkSave(WorldServer var1, Chunk var2) throws ExceptionWorldConflict;

	void saveAllChunks();
}
