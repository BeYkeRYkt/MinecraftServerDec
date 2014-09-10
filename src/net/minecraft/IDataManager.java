package net.minecraft;

import java.io.File;

public interface IDataManager {

	WorldData d();

	void checkSessionLock() throws aqz;

	IChunkLoader a(WorldProvider var1);

	void a(WorldData var1, NBTCompoundTag var2);

	void a(WorldData var1);

	brl e();

	void saveData();

	File b();

	File a(String var1);

	String g();
}
