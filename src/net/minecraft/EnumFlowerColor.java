package net.minecraft;

public enum EnumFlowerColor {

	a("YELLOW", 0), b("RED", 1);
	// $FF: synthetic field
	private static final EnumFlowerColor[] c = new EnumFlowerColor[] { a, b };

	private EnumFlowerColor(String var1, int var2) {
	}

	public BlockFlowers a() {
		return this == a ? Blocks.YELLOW_FLOWER : Blocks.RED_FLOWER;
	}

}
