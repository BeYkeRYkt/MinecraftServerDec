package net.minecraft;

import java.io.File;

public class ServerNBTManager extends WorldNBTStorage {

	public ServerNBTManager(File l, String var2, boolean var3) {
		super(l, var2, var3);
	}

	public IChunkLoader createChunkLoader(WorldProvider var1) {
		File baseDir = this.getDirectory();
		File worldDir;
		if (var1 instanceof WorldProviderHell) {
			worldDir = new File(baseDir, "DIM-1");
			worldDir.mkdirs();
			return new ChunkRegionLoader(worldDir);
		} else if (var1 instanceof WorldProviderTheEnd) {
			worldDir = new File(baseDir, "DIM1");
			worldDir.mkdirs();
			return new ChunkRegionLoader(worldDir);
		} else {
			return new ChunkRegionLoader(baseDir);
		}
	}

	public void saveWorldData(WorldData var1, NBTCompoundTag var2) {
		var1.setVersion(19133);
		super.saveWorldData(var1, var2);
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
