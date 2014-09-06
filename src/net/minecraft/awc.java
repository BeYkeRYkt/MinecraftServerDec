package net.minecraft;

public enum awc {

	a("YELLOW", 0), b("RED", 1);
	// $FF: synthetic field
	private static final awc[] c = new awc[] { a, b };

	private awc(String var1, int var2) {
	}

	public BlockFlowers a() {
		return this == a ? Blocks.YELLOW_FLOWER : Blocks.RED_FLOWER;
	}

}
