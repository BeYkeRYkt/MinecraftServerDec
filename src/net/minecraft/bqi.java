package net.minecraft;

import java.io.File;

public class bqi extends bqm {

	public bqi(File var1, String var2, boolean var3) {
		super(var1, var2, var3);
	}

	public bfq a(bgd var1) {
		File var2 = this.b();
		File var3;
		if (var1 instanceof bge) {
			var3 = new File(var2, "DIM-1");
			var3.mkdirs();
			return new bfy(var3);
		} else if (var1 instanceof bgh) {
			var3 = new File(var2, "DIM1");
			var3.mkdirs();
			return new bfy(var3);
		} else {
			return new bfy(var2);
		}
	}

	public void a(bqo var1, NBTCompoundTag var2) {
		var1.e(19133);
		super.a(var1, var2);
	}

	public void a() {
		try {
			FileIOThread.getInstance().b();
		} catch (InterruptedException var2) {
			var2.printStackTrace();
		}

		RegionFileCache.dumpCache();
	}
}
