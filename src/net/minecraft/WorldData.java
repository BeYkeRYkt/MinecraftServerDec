package net.minecraft;

import java.util.concurrent.Callable;

import net.minecraft.server.MinecraftServer;

public class WorldData {

	public static final Difficulty NORMAL_DIFFICULTY = Difficulty.NORMAL;

	private long seed;
	private LevelType levelType;
	private String generatorOptions;
	private int spawnX;
	private int spawnY;
	private int spawnZ;
	private long time;
	private long dayTime;
	private long lastPlayed;
	private long sizeOnDisk;
	private String levelName;
	private int version;
	private int clearWeatherTime;
	private boolean isRaining;
	private int rainTime;
	private boolean isThundering;
	private int thunderTime;
	private EnumGameMode gameMode;
	private boolean mapFeaturesEnabled;
	private boolean isHardcore;
	private boolean allowCommands;
	private boolean initialized;
	private Difficulty difficulty;
	private boolean isDifficultyLocked;
	private double borderX;
	private double borderZ;
	private double borderSize;
	private long borderLerpTime;
	private double borderSizeLerpTarget;
	private double borderSafeZone;
	private double borderDamagePerBlock;
	private int borderWarningBlocks;
	private int borderWarningTime;
	private GameRuleRegistry gameRules;

	protected WorldData() {
		this.levelType = LevelType.DEFAULT;
		this.generatorOptions = "";
		this.borderX = 0.0D;
		this.borderZ = 0.0D;
		this.borderSize = 6.0E7D;
		this.borderLerpTime = 0L;
		this.borderSizeLerpTarget = 0.0D;
		this.borderSafeZone = 5.0D;
		this.borderDamagePerBlock = 0.2D;
		this.borderWarningBlocks = 5;
		this.borderWarningTime = 15;
		this.gameRules = new GameRuleRegistry();
	}

	public WorldData(NBTCompoundTag tag) {
		this.levelType = LevelType.DEFAULT;
		this.generatorOptions = "";
		this.borderX = 0.0D;
		this.borderZ = 0.0D;
		this.borderSize = 6.0E7D;
		this.borderLerpTime = 0L;
		this.borderSizeLerpTarget = 0.0D;
		this.borderSafeZone = 5.0D;
		this.borderDamagePerBlock = 0.2D;
		this.borderWarningBlocks = 5;
		this.borderWarningTime = 15;
		this.gameRules = new GameRuleRegistry();
		this.seed = tag.getLong("RandomSeed");
		if (tag.isTagAssignableFrom("generatorName", 8)) {
			String genName = tag.getString("generatorName");
			this.levelType = LevelType.getByName(genName);
			if (this.levelType == null) {
				this.levelType = LevelType.DEFAULT;
			} else if (this.levelType.isDefault()) {
				int genVerson = 0;
				if (tag.isTagAssignableFrom("generatorVersion", 99)) {
					genVerson = tag.getInt("generatorVersion");
				}

				this.levelType = this.levelType.levelByVersion(genVerson);
			}

			if (tag.isTagAssignableFrom("generatorOptions", 8)) {
				this.generatorOptions = tag.getString("generatorOptions");
			}
		}

		this.gameMode = EnumGameMode.getById(tag.getInt("GameType"));
		if (tag.isTagAssignableFrom("MapFeatures", 99)) {
			this.mapFeaturesEnabled = tag.getBoolean("MapFeatures");
		} else {
			this.mapFeaturesEnabled = true;
		}

		this.spawnX = tag.getInt("SpawnX");
		this.spawnY = tag.getInt("SpawnY");
		this.spawnZ = tag.getInt("SpawnZ");
		this.time = tag.getLong("Time");
		if (tag.isTagAssignableFrom("DayTime", 99)) {
			this.dayTime = tag.getLong("DayTime");
		} else {
			this.dayTime = this.time;
		}

		this.lastPlayed = tag.getLong("LastPlayed");
		this.sizeOnDisk = tag.getLong("SizeOnDisk");
		this.levelName = tag.getString("LevelName");
		this.version = tag.getInt("version");
		this.clearWeatherTime = tag.getInt("clearWeatherTime");
		this.rainTime = tag.getInt("rainTime");
		this.isRaining = tag.getBoolean("raining");
		this.thunderTime = tag.getInt("thunderTime");
		this.isThundering = tag.getBoolean("thundering");
		this.isHardcore = tag.getBoolean("hardcore");
		if (tag.isTagAssignableFrom("initialized", 99)) {
			this.initialized = tag.getBoolean("initialized");
		} else {
			this.initialized = true;
		}

		if (tag.isTagAssignableFrom("allowCommands", 99)) {
			this.allowCommands = tag.getBoolean("allowCommands");
		} else {
			this.allowCommands = this.gameMode == EnumGameMode.CREATIVE;
		}

		if (tag.isTagAssignableFrom("GameRules", 10)) {
			this.gameRules.read(tag.getCompound("GameRules"));
		}

		if (tag.isTagAssignableFrom("Difficulty", 99)) {
			this.difficulty = Difficulty.clampAndGetById(tag.getByte("Difficulty"));
		}

		if (tag.isTagAssignableFrom("DifficultyLocked", 1)) {
			this.isDifficultyLocked = tag.getBoolean("DifficultyLocked");
		}

		if (tag.isTagAssignableFrom("BorderCenterX", 99)) {
			this.borderX = tag.getDouble("BorderCenterX");
		}

		if (tag.isTagAssignableFrom("BorderCenterZ", 99)) {
			this.borderZ = tag.getDouble("BorderCenterZ");
		}

		if (tag.isTagAssignableFrom("BorderSize", 99)) {
			this.borderSize = tag.getDouble("BorderSize");
		}

		if (tag.isTagAssignableFrom("BorderSizeLerpTime", 99)) {
			this.borderLerpTime = tag.getLong("BorderSizeLerpTime");
		}

		if (tag.isTagAssignableFrom("BorderSizeLerpTarget", 99)) {
			this.borderSizeLerpTarget = tag.getDouble("BorderSizeLerpTarget");
		}

		if (tag.isTagAssignableFrom("BorderSafeZone", 99)) {
			this.borderSafeZone = tag.getDouble("BorderSafeZone");
		}

		if (tag.isTagAssignableFrom("BorderDamagePerBlock", 99)) {
			this.borderDamagePerBlock = tag.getDouble("BorderDamagePerBlock");
		}

		if (tag.isTagAssignableFrom("BorderWarningBlocks", 99)) {
			this.borderWarningBlocks = tag.getInt("BorderWarningBlocks");
		}

		if (tag.isTagAssignableFrom("BorderWarningTime", 99)) {
			this.borderWarningTime = tag.getInt("BorderWarningTime");
		}

	}

	public WorldData(WorldSettings worldSettings, String levelName) {
		this.levelType = LevelType.DEFAULT;
		this.generatorOptions = "";
		this.borderX = 0.0D;
		this.borderZ = 0.0D;
		this.borderSize = 6.0E7D;
		this.borderLerpTime = 0L;
		this.borderSizeLerpTarget = 0.0D;
		this.borderSafeZone = 5.0D;
		this.borderDamagePerBlock = 0.2D;
		this.borderWarningBlocks = 5;
		this.borderWarningTime = 15;
		this.gameRules = new GameRuleRegistry();
		this.applySettings(worldSettings);
		this.levelName = levelName;
		this.difficulty = NORMAL_DIFFICULTY;
		this.initialized = false;
	}

	public void applySettings(WorldSettings worldSetting) {
		this.seed = worldSetting.getSeed();
		this.gameMode = worldSetting.getGameMode();
		this.mapFeaturesEnabled = worldSetting.isMapFeaturesEnabled();
		this.isHardcore = worldSetting.isHardcore();
		this.levelType = worldSetting.getLevelType();
		this.generatorOptions = worldSetting.getGeneratorOptions();
		this.allowCommands = worldSetting.areCommandsAllowed();
	}

	public WorldData(WorldData var1) {
		this.levelType = LevelType.DEFAULT;
		this.generatorOptions = "";
		this.borderX = 0.0D;
		this.borderZ = 0.0D;
		this.borderSize = 6.0E7D;
		this.borderLerpTime = 0L;
		this.borderSizeLerpTarget = 0.0D;
		this.borderSafeZone = 5.0D;
		this.borderDamagePerBlock = 0.2D;
		this.borderWarningBlocks = 5;
		this.borderWarningTime = 15;
		this.gameRules = new GameRuleRegistry();
		this.seed = var1.seed;
		this.levelType = var1.levelType;
		this.generatorOptions = var1.generatorOptions;
		this.gameMode = var1.gameMode;
		this.mapFeaturesEnabled = var1.mapFeaturesEnabled;
		this.spawnX = var1.spawnX;
		this.spawnY = var1.spawnY;
		this.spawnZ = var1.spawnZ;
		this.time = var1.time;
		this.dayTime = var1.dayTime;
		this.lastPlayed = var1.lastPlayed;
		this.sizeOnDisk = var1.sizeOnDisk;
		this.levelName = var1.levelName;
		this.version = var1.version;
		this.rainTime = var1.rainTime;
		this.isRaining = var1.isRaining;
		this.thunderTime = var1.thunderTime;
		this.isThundering = var1.isThundering;
		this.isHardcore = var1.isHardcore;
		this.allowCommands = var1.allowCommands;
		this.initialized = var1.initialized;
		this.gameRules = var1.gameRules;
		this.difficulty = var1.difficulty;
		this.isDifficultyLocked = var1.isDifficultyLocked;
		this.borderX = var1.borderX;
		this.borderZ = var1.borderZ;
		this.borderSize = var1.borderSize;
		this.borderLerpTime = var1.borderLerpTime;
		this.borderSizeLerpTarget = var1.borderSizeLerpTarget;
		this.borderSafeZone = var1.borderSafeZone;
		this.borderDamagePerBlock = var1.borderDamagePerBlock;
		this.borderWarningTime = var1.borderWarningTime;
		this.borderWarningBlocks = var1.borderWarningBlocks;
	}

	public NBTCompoundTag getDataTag() {
		NBTCompoundTag dataTag = new NBTCompoundTag();
		this.write(dataTag, null);
		return dataTag;
	}

	public NBTCompoundTag getDataTag(NBTCompoundTag playerTag) {
		NBTCompoundTag dataTag = new NBTCompoundTag();
		this.write(dataTag, playerTag);
		return dataTag;
	}

	private void write(NBTCompoundTag dataTag, NBTCompoundTag playerTag) {
		dataTag.put("RandomSeed", this.seed);
		dataTag.put("generatorName", this.levelType.getName());
		dataTag.put("generatorVersion", this.levelType.getVersion());
		dataTag.put("generatorOptions", this.generatorOptions);
		dataTag.put("GameType", this.gameMode.getId());
		dataTag.put("MapFeatures", this.mapFeaturesEnabled);
		dataTag.put("SpawnX", this.spawnX);
		dataTag.put("SpawnY", this.spawnY);
		dataTag.put("SpawnZ", this.spawnZ);
		dataTag.put("Time", this.time);
		dataTag.put("DayTime", this.dayTime);
		dataTag.put("SizeOnDisk", this.sizeOnDisk);
		dataTag.put("LastPlayed", MinecraftServer.getCurrentMillis());
		dataTag.put("LevelName", this.levelName);
		dataTag.put("version", this.version);
		dataTag.put("clearWeatherTime", this.clearWeatherTime);
		dataTag.put("rainTime", this.rainTime);
		dataTag.put("raining", this.isRaining);
		dataTag.put("thunderTime", this.thunderTime);
		dataTag.put("thundering", this.isThundering);
		dataTag.put("hardcore", this.isHardcore);
		dataTag.put("allowCommands", this.allowCommands);
		dataTag.put("initialized", this.initialized);
		dataTag.put("BorderCenterX", this.borderX);
		dataTag.put("BorderCenterZ", this.borderZ);
		dataTag.put("BorderSize", this.borderSize);
		dataTag.put("BorderSizeLerpTime", this.borderLerpTime);
		dataTag.put("BorderSafeZone", this.borderSafeZone);
		dataTag.put("BorderDamagePerBlock", this.borderDamagePerBlock);
		dataTag.put("BorderSizeLerpTarget", this.borderSizeLerpTarget);
		dataTag.put("BorderWarningBlocks", (double) this.borderWarningBlocks);
		dataTag.put("BorderWarningTime", (double) this.borderWarningTime);
		if (this.difficulty != null) {
			dataTag.put("Difficulty", (byte) this.difficulty.getId());
		}

		dataTag.put("DifficultyLocked", this.isDifficultyLocked);
		dataTag.put("GameRules", (NBTTag) this.gameRules.write());
		if (playerTag != null) {
			dataTag.put("Player", (NBTTag) playerTag);
		}
	}

	public long getSeed() {
		return this.seed;
	}

	public int getSpawnX() {
		return this.spawnX;
	}

	public int getSpawnY() {
		return this.spawnY;
	}

	public int getSpawnZ() {
		return this.spawnZ;
	}

	public long getTime() {
		return this.time;
	}

	public long getDayTime() {
		return this.dayTime;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public void setDayTime(long dayTime) {
		this.dayTime = dayTime;
	}

	public void setSpawn(Position position) {
		this.spawnX = position.getX();
		this.spawnY = position.getY();
		this.spawnZ = position.getZ();
	}

	public String getLevelName() {
		return this.levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getClearWeatherTime() {
		return this.clearWeatherTime;
	}

	public void setClearWeatherTime(int clearWeatherTime) {
		this.clearWeatherTime = clearWeatherTime;
	}

	public boolean isThundering() {
		return this.isThundering;
	}

	public void setThundering(boolean isThundering) {
		this.isThundering = isThundering;
	}

	public int getThunderTime() {
		return this.thunderTime;
	}

	public void setThunderTime(int thunderTime) {
		this.thunderTime = thunderTime;
	}

	public boolean isRaining() {
		return this.isRaining;
	}

	public void setRaining(boolean isRaining) {
		this.isRaining = isRaining;
	}

	public int getRainTime() {
		return this.rainTime;
	}

	public void setRainTime(int rainTime) {
		this.rainTime = rainTime;
	}

	public EnumGameMode getGameMode() {
		return this.gameMode;
	}

	public boolean isMapFeauturesEnabled() {
		return this.mapFeaturesEnabled;
	}

	public void setMapFeaturesEnabled(boolean mapFeaturesEnabled) {
		this.mapFeaturesEnabled = mapFeaturesEnabled;
	}

	public void setGameMode(EnumGameMode gameMode) {
		this.gameMode = gameMode;
	}

	public boolean isHardcore() {
		return this.isHardcore;
	}

	public void setIsHardcore(boolean isHardcore) {
		this.isHardcore = isHardcore;
	}

	public LevelType getLevelType() {
		return this.levelType;
	}

	public void setLevelType(LevelType type) {
		this.levelType = type;
	}

	public String getGeneratorOptions() {
		return this.generatorOptions;
	}

	public boolean areCommandsAllowed() {
		return this.allowCommands;
	}

	public void setCommandsAllowed(boolean allowCommands) {
		this.allowCommands = allowCommands;
	}

	public boolean isInitialized() {
		return this.initialized;
	}

	public void setInitialized(boolean initialized) {
		this.initialized = initialized;
	}

	public GameRuleRegistry getGameRules() {
		return this.gameRules;
	}

	public double getBorderX() {
		return this.borderX;
	}

	public double getBorderZ() {
		return this.borderZ;
	}

	public double getBorderSize() {
		return this.borderSize;
	}

	public void setBorderSize(double borderSize) {
		this.borderSize = borderSize;
	}

	public long getBorderLerpTime() {
		return this.borderLerpTime;
	}

	public void setBorderLerpTime(long borderSize) {
		this.borderLerpTime = borderSize;
	}

	public double getBorderSizeLerpTarget() {
		return this.borderSizeLerpTarget;
	}

	public void setBorderSizeLerpTarget(double borderSizeLerpTarget) {
		this.borderSizeLerpTarget = borderSizeLerpTarget;
	}

	public void setBorderZ(double borderZ) {
		this.borderZ = borderZ;
	}

	public void setBorderX(double borderX) {
		this.borderX = borderX;
	}

	public double getBorderSafeZone() {
		return this.borderSafeZone;
	}

	public void setBorderSafeZone(double borderSafeZone) {
		this.borderSafeZone = borderSafeZone;
	}

	public double getBorderDamagePerBlock() {
		return this.borderDamagePerBlock;
	}

	public void setBorderDamagePerBlock(double borderDamagePerBlock) {
		this.borderDamagePerBlock = borderDamagePerBlock;
	}

	public int getBorderWarningBlocks() {
		return this.borderWarningBlocks;
	}

	public int getBorderWarningTime() {
		return this.borderWarningTime;
	}

	public void setBorderWarningBlocks(int borderWarningBlocks) {
		this.borderWarningBlocks = borderWarningBlocks;
	}

	public void setBorderWarningTime(int borderWarningTime) {
		this.borderWarningTime = borderWarningTime;
	}

	public Difficulty getDifficulty() {
		return this.difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public boolean isDifficultyLocked() {
		return this.isDifficultyLocked;
	}

	public void setDifficultyLocked(boolean isDifficultyLocked) {
		this.isDifficultyLocked = isDifficultyLocked;
	}

	public void addCrashReportDetails(CrashReportSystemDetails details) {
		details.addDetails("Level seed", new Callable<String>() {
			@Override
			public String call() throws Exception {
				return String.valueOf(getSeed());
			}
		});
		details.addDetails("Level generator", new Callable<String>() {
			@Override
			public String call() throws Exception {
				return String.format("ID %02d - %s, ver %d. Features enabled: %b", new Object[] { getLevelType().getId(), getLevelType().getName(), getLevelType().getVersion(), isMapFeauturesEnabled() });
			}
		});
		details.addDetails("Level generator options", new Callable<String>() {
			@Override
			public String call() throws Exception {
				return generatorOptions;
			}
		});
		details.addDetails("Level spawn location", new Callable<String>() {
			@Override
			public String call() throws Exception {
				return CrashReportSystemDetails.getPositionInfo(getSpawnX(), getSpawnY(), getSpawnZ());
			}
		});
		details.addDetails("Level time", new Callable<String>() {
			@Override
			public String call() throws Exception {
				return String.format("%d game time, %d day time", new Object[] { getTime(), getDayTime() });
			}
		});
		details.addDetails("Level storage version", new Callable<String>() {
			@Override
			public String call() throws Exception {
				String storage = "Unknown?";
				try {
					switch (getVersion()) {
						case 19132:
							storage = "McRegion";
							break;
						case 19133:
							storage = "Anvil";
					}
				} catch (Throwable t) {
				}
				return String.format("0x%05X - %s", new Object[] { getVersion(), storage });
			}
		});
		details.addDetails("Level weather", new Callable<String>() {
			@Override
			public String call() throws Exception {
				return String.format("Rain time: %d (now: %b), thunder time: %d (now: %b)", new Object[] { getRainTime(), isRaining(), getThunderTime(), isThundering() });
			}
		});
		details.addDetails("Level game mode", new Callable<String>() {
			@Override
			public String call() throws Exception {
				return String.format("Game mode: %s (ID %d). Hardcore: %b. Cheats: %b", new Object[] { getGameMode().getName(), getGameMode().getId(), isHardcore(), areCommandsAllowed() });
			}
		});
	}

}
