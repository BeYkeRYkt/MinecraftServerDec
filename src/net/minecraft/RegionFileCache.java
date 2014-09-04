package net.minecraft;

import com.google.common.collect.Maps;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class RegionFileCache {

	private static final Map<File, RegionFile> cache = Maps.newHashMap();

	public static synchronized RegionFile getRegionFile(File worldfolder, int chunkX, int chunkZ) {
		File regionFolder = new File(worldfolder, "region");
		File file = new File(regionFolder, "r." + (chunkX >> 5) + "." + (chunkZ >> 5) + ".mca");
		RegionFile regionFile = (RegionFile) cache.get(file);
		if (regionFile != null) {
			return regionFile;
		} else {
			if (!regionFolder.exists()) {
				regionFolder.mkdirs();
			}

			if (cache.size() >= 256) {
				dumpCache();
			}

			RegionFile var6 = new RegionFile(file);
			cache.put(file, var6);
			return var6;
		}
	}

	public static synchronized void dumpCache() {
		for (RegionFile regionFile : cache.values()) {
			try {
				if (regionFile != null) {
					regionFile.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		cache.clear();
	}

	public static DataInputStream getInputStream(File file, int chunkX, int chunkZ) {
		RegionFile regionFile = getRegionFile(file, chunkX, chunkZ);
		return regionFile.a(chunkX & 31, chunkZ & 31);
	}

	public static DataOutputStream getOutputStream(File file, int chunkX, int chunkZ) {
		RegionFile regionFile = getRegionFile(file, chunkX, chunkZ);
		return regionFile.b(chunkX & 31, chunkZ & 31);
	}

}
