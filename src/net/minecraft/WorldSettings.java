package net.minecraft;

public final class WorldSettings {

	private final long seed;
	private final EnumGameMode gameMode;
	private final boolean mapFeaturesEnabled;
	private final boolean isHardcore;
	private final LevelType levelType;
	private boolean commandAllowed;
	private boolean bonusChestEnabled;
	private String generatorOptions;

	public WorldSettings(long seed, EnumGameMode gameMode, boolean mapFeaturesEnabled, boolean isHardcore, LevelType levelType) {
		this.generatorOptions = "";
		this.seed = seed;
		this.gameMode = gameMode;
		this.mapFeaturesEnabled = mapFeaturesEnabled;
		this.isHardcore = isHardcore;
		this.levelType = levelType;
	}

	public WorldSettings(WorldData worldData) {
		this(worldData.getSeed(), worldData.getGameMode(), worldData.isMapFeauturesEnabled(), worldData.isHardcore(), worldData.getLevelType());
	}

	public WorldSettings enableBonusChest() {
		this.bonusChestEnabled = true;
		return this;
	}

	public WorldSettings setGeneratorOptions(String generatorOptions) {
		this.generatorOptions = generatorOptions;
		return this;
	}

	public boolean isBonusChestEnabled() {
		return this.bonusChestEnabled;
	}

	public long getSeed() {
		return this.seed;
	}

	public EnumGameMode getGameMode() {
		return this.gameMode;
	}

	public boolean isHardcore() {
		return this.isHardcore;
	}

	public boolean isMapFeaturesEnabled() {
		return this.mapFeaturesEnabled;
	}

	public LevelType getLevelType() {
		return this.levelType;
	}

	public boolean areCommandsAllowed() {
		return this.commandAllowed;
	}

	public String getGeneratorOptions() {
		return this.generatorOptions;
	}

}
