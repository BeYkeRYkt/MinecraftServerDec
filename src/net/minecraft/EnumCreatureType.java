package net.minecraft;

public enum EnumCreatureType {

	MONSTER(IMonster.class, 70, Material.AIR, false, false), 
	CREATURE(EntityAnimal.class, 10, Material.AIR, true, true), 
	AMBIENT(EntityAmbient.class, 15, Material.AIR, true, false), 
	WATER_CREATURE(EntityWaterAnimal.class, 5, Material.WATER, true, false);

	private final Class<? extends IAnimal> creatureClass;
	private final int spawnLimit;
	private final boolean friendly;
	private final boolean friendlyAnimal;

	private EnumCreatureType(Class<? extends IAnimal> creatureClass, int spawnLimit, Material material, boolean friendly, boolean friendlyAnimal) {
		this.creatureClass = creatureClass;
		this.spawnLimit = spawnLimit;
		this.friendly = friendly;
		this.friendlyAnimal = friendlyAnimal;
	}

	public Class<? extends IAnimal> getCreatureClass() {
		return this.creatureClass;
	}

	public int getSpawnLimit() {
		return this.spawnLimit;
	}

	public boolean doesNotAttackPlayer() {
		return this.friendly;
	}

	public boolean isFriendlyAnimal() {
		return this.friendlyAnimal;
	}

}
