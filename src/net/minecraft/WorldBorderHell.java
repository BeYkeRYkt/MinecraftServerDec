package net.minecraft;

class WorldBorderHell extends WorldBorder {

	public double getX() {
		return super.getX() / 8.0D;
	}

	public double getZ() {
		return super.getZ() / 8.0D;
	}

}
