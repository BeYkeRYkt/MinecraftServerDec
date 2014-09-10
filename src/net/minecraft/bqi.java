package net.minecraft;

import java.io.File;

public class bqi extends bqm {

	public bqi(File var1, String var2, boolean var3) {
		super(var1, var2, var3);
	}

	public IChunkLoader a(WorldProvider var1) {
		File var2 = this.b();
		File var3;
		if (var1 instanceof NetherWorldProvider) {
			var3 = new File(var2, "DIM-1");
			var3.mkdirs();
			return new ChunkRegionLoader(var3);
		} else if (var1 instanceof TheEndWorldProvider) {
			var3 = new File(var2, "DIM1");
			var3.mkdirs();
			return new ChunkRegionLoader(var3);
		} else {
			return new ChunkRegionLoader(var2);
		}
	}

	public void a(WorldData var1, NBTCompoundTag var2) {
		var1.e(19133);
		super.a(var1, var2);
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
