package net.minecraft;

import java.io.IOException;

public interface IChunkLoader {

	Chunk loadChunk(World var1, int var2, int var3) throws IOException;

	void requestChunkSave(World var1, Chunk var2) throws ExceptionWorldConflict;

	void saveAllChunks();
}
