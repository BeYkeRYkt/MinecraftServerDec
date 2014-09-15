package net.minecraft;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import net.minecraft.server.MinecraftServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WorldNBTStorage implements IDataManager, IPlayerFileData {

	private static final Logger logger = LogManager.getLogger();
	private final File baseDir;
	private final File playerDir;
	private final File dataDir;
	private final long sessionId = MinecraftServer.getCurrentMillis();
	private final String worldName;

	public WorldNBTStorage(File levelName, String worldName, boolean flag) {
		this.baseDir = new File(levelName, worldName);
		this.baseDir.mkdirs();
		this.playerDir = new File(this.baseDir, "playerdata");
		this.dataDir = new File(this.baseDir, "data");
		this.dataDir.mkdirs();
		this.worldName = worldName;
		if (flag) {
			this.playerDir.mkdirs();
		}

		this.createSessionLock();
	}

	private void createSessionLock() {
		try {
			File lock = new File(this.baseDir, "session.lock");
			DataOutputStream stream = new DataOutputStream(new FileOutputStream(lock));

			try {
				stream.writeLong(this.sessionId);
			} finally {
				stream.close();
			}

		} catch (IOException ex) {
			ex.printStackTrace();
			throw new RuntimeException("Failed to check session lock, aborting");
		}
	}

	public File getDirectory() {
		return this.baseDir;
	}

	public File getPlayerDir() {
		return this.playerDir;
	}

	public void checkSessionLock() throws ExceptionWorldConflict {
		try {
			File lock = new File(this.baseDir, "session.lock");
			DataInputStream stream = new DataInputStream(new FileInputStream(lock));

			try {
				if (stream.readLong() != this.sessionId) {
					throw new ExceptionWorldConflict("The save is being accessed from another location, aborting");
				}
			} finally {
				stream.close();
			}

		} catch (IOException ex) {
			throw new ExceptionWorldConflict("Failed to check session lock, aborting");
		}
	}

	public IChunkLoader createChunkLoader(WorldProvider provider) {
		throw new RuntimeException("Old Chunk Storage is no longer supported.");
	}

	public WorldData getWorldData() {
		File levelDataFile = new File(this.baseDir, "level.dat");
		NBTCompoundTag fileTag;
		NBTCompoundTag dataTag;
		if (levelDataFile.exists()) {
			try {
				fileTag = NBTCompressedStreamTools.readTag((InputStream) (new FileInputStream(levelDataFile)));
				dataTag = fileTag.getCompound("Data");
				return new WorldData(dataTag);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		levelDataFile = new File(this.baseDir, "level.dat_old");
		if (levelDataFile.exists()) {
			try {
				fileTag = NBTCompressedStreamTools.readTag((InputStream) (new FileInputStream(levelDataFile)));
				dataTag = fileTag.getCompound("Data");
				return new WorldData(dataTag);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return null;
	}

	public void saveWorldData(WorldData worldData, NBTCompoundTag tag) {
		NBTCompoundTag var3 = worldData.getDataTag(tag);
		NBTCompoundTag var4 = new NBTCompoundTag();
		var4.put("Data", (NBTTag) var3);

		try {
			File var5 = new File(this.baseDir, "level.dat_new");
			File var6 = new File(this.baseDir, "level.dat_old");
			File var7 = new File(this.baseDir, "level.dat");
			NBTCompressedStreamTools.writeTag(var4, (OutputStream) (new FileOutputStream(var5)));
			if (var6.exists()) {
				var6.delete();
			}

			var7.renameTo(var6);
			if (var7.exists()) {
				var7.delete();
			}

			var5.renameTo(var7);
			if (var5.exists()) {
				var5.delete();
			}
		} catch (Exception var8) {
			var8.printStackTrace();
		}

	}

	public void saveWorldData(WorldData worldData) {
		NBTCompoundTag var2 = worldData.getDataTag();
		NBTCompoundTag var3 = new NBTCompoundTag();
		var3.put("Data", (NBTTag) var2);

		try {
			File var4 = new File(this.baseDir, "level.dat_new");
			File var5 = new File(this.baseDir, "level.dat_old");
			File var6 = new File(this.baseDir, "level.dat");
			NBTCompressedStreamTools.writeTag(var3, (OutputStream) (new FileOutputStream(var4)));
			if (var5.exists()) {
				var5.delete();
			}

			var6.renameTo(var5);
			if (var6.exists()) {
				var6.delete();
			}

			var4.renameTo(var6);
			if (var4.exists()) {
				var4.delete();
			}
		} catch (Exception var7) {
			var7.printStackTrace();
		}

	}

	public void save(EntityHuman var1) {
		try {
			NBTCompoundTag var2 = new NBTCompoundTag();
			var1.write(var2);
			File var3 = new File(this.playerDir, var1.getUUID().toString() + ".dat.tmp");
			File var4 = new File(this.playerDir, var1.getUUID().toString() + ".dat");
			NBTCompressedStreamTools.writeTag(var2, (OutputStream) (new FileOutputStream(var3)));
			if (var4.exists()) {
				var4.delete();
			}

			var3.renameTo(var4);
		} catch (Exception var5) {
			logger.warn("Failed to save player data for " + var1.getName());
		}

	}

	public NBTCompoundTag load(EntityHuman var1) {
		NBTCompoundTag var2 = null;

		try {
			File var3 = new File(this.playerDir, var1.getUUID().toString() + ".dat");
			if (var3.exists() && var3.isFile()) {
				var2 = NBTCompressedStreamTools.readTag((InputStream) (new FileInputStream(var3)));
			}
		} catch (Exception var4) {
			logger.warn("Failed to load player data for " + var1.getName());
		}

		if (var2 != null) {
			var1.load(var2);
		}

		return var2;
	}

	public NBTCompoundTag getPlayerData(String uuidString) {
		try {
			File file = new File(this.playerDir, uuidString + ".dat");
			if (file.exists()) {
				return NBTCompressedStreamTools.readTag(new FileInputStream(file));
			}
		} catch (Exception exception) {
			logger.warn("Failed to load player data for " + uuidString);
		}
		return null;
	 }

	public IPlayerFileData getPlayerFileData() {
		return this;
	}

	public String[] getSeenPlayers() {
		String[] fileNames = this.playerDir.list();
		if (fileNames == null) {
			fileNames = new String[0];
		}

		for (int i = 0; i < fileNames.length; ++i) {
			if (fileNames[i].endsWith(".dat")) {
				fileNames[i] = fileNames[i].substring(0, fileNames[i].length() - 4);
			}
		}

		return fileNames;
	}

	public void saveData() {
	}

	public File a(String var1) {
		return new File(this.dataDir, var1 + ".dat");
	}

	public String g() {
		return this.worldName;
	}

}
