package net.minecraft;

public enum EnumSkyBlock {

	SKY(15), BLOCK(0);

	public final int lightLevel;

	private EnumSkyBlock(int lightLevel) {
		this.lightLevel = lightLevel;
	}

}
