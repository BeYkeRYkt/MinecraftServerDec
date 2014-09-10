package net.minecraft;

public class SecondaryWorldData extends WorldData {

	private final WorldData b;

	public SecondaryWorldData(WorldData var1) {
		this.b = var1;
	}

	public NBTCompoundTag getDataTag() {
		return this.b.getDataTag();
	}

	public NBTCompoundTag getDataTag(NBTCompoundTag var1) {
		return this.b.getDataTag(var1);
	}

	public long getSeed() {
		return this.b.getSeed();
	}

	public int getSpawnX() {
		return this.b.getSpawnX();
	}

	public int getSpawnY() {
		return this.b.getSpawnY();
	}

	public int getSpawnZ() {
		return this.b.getSpawnZ();
	}

	public long getTime() {
		return this.b.getTime();
	}

	public long getDayTime() {
		return this.b.getDayTime();
	}

	public NBTCompoundTag getPlayerData() {
		return this.b.getPlayerData();
	}

	public String getLevelName() {
		return this.b.getLevelName();
	}

	public int getVersion() {
		return this.b.getVersion();
	}

	public boolean isThundering() {
		return this.b.isThundering();
	}

	public int getThunderTime() {
		return this.b.getThunderTime();
	}

	public boolean isRaining() {
		return this.b.isRaining();
	}

	public int getRainTime() {
		return this.b.getRainTime();
	}

	public GameMode getGameMode() {
		return this.b.getGameMode();
	}

	public void setTime(long var1) {
	}

	public void setDayTime(long var1) {
	}

	public void setSpawn(Position var1) {
	}

	public void setLevelName(String var1) {
	}

	public void setVersion(int var1) {
	}

	public void setThundering(boolean var1) {
	}

	public void setThunderTime(int var1) {
	}

	public void setRaining(boolean var1) {
	}

	public void setRainTime(int var1) {
	}

	public boolean isMapFeauturesEnabled() {
		return this.b.isMapFeauturesEnabled();
	}

	public boolean isHardcore() {
		return this.b.isHardcore();
	}

	public LevelType getLevelType() {
		return this.b.getLevelType();
	}

	public void setLevelType(LevelType var1) {
	}

	public boolean areCommandsAllowed() {
		return this.b.areCommandsAllowed();
	}

	public void setCommandsAllowed(boolean var1) {
	}

	public boolean isInitialized() {
		return this.b.isInitialized();
	}

	public void setInitialized(boolean var1) {
	}

	public GameRuleRegistry getGameRules() {
		return this.b.getGameRules();
	}

	public Difficulty getDifficulty() {
		return this.b.getDifficulty();
	}

	public void setDifficulty(Difficulty var1) {
	}

	public boolean isDifficultyLocked() {
		return this.b.isDifficultyLocked();
	}

	public void setDifficultyLocked(boolean var1) {
	}
}
