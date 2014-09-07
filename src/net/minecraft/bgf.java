package net.minecraft;

class bgf extends WorldBorder {

	// $FF: synthetic field
	final NetherWorldProvider a;

	bgf(NetherWorldProvider var1) {
		this.a = var1;
	}

	public double getX() {
		return super.getX() / 8.0D;
	}

	public double getZ() {
		return super.getZ() / 8.0D;
	}
}
