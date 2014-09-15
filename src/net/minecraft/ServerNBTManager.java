package net.minecraft;

import java.io.File;

public class ServerNBTManager extends WorldNBTStorage {

	public ServerNBTManager(File l, String var2, boolean var3) {
		super(l, var2, var3);
	}

	public IChunkLoader createChunkLoader(WorldProvider provider) {
		return new ChunkRegionLoader(getDirectory());
	}

	public void saveWorldData(WorldData worldData, NBTCompoundTag tag) {
		worldData.setVersion(19133);
		super.saveWorldData(worldData, tag);
	}

	public void saveData() {
		try {
			FileIOThread.getInstance().saveAllChunks();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}

		RegionFileCache.dumpCache();
	}

}
