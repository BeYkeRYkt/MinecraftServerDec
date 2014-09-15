package net.minecraft;

import java.io.File;

public interface IDataManager {

	WorldData getWorldData();

	void checkSessionLock() throws ExceptionWorldConflict;

	IChunkLoader createChunkLoader(WorldProvider var1);

	void saveWorldData(WorldData var1, NBTCompoundTag var2);

	void saveWorldData(WorldData var1);

	IPlayerFileData getPlayerFileData();

	void saveData();

	File getDirectory();

	File a(String var1);

	String g();
}
