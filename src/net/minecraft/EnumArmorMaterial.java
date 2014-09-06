package net.minecraft;

public enum EnumArmorMaterial {

	LEATHER("leather", 5, new int[] { 1, 3, 2, 1 }, 15), 
	CHAIN("chainmail", 15, new int[] { 2, 5, 4, 1 }, 12), 
	IRON("iron", 15, new int[] { 2, 6, 5, 2 }, 9), 
	GOLD("gold", 7, new int[] { 2, 5, 3, 1 }, 25), 
	DIAMOND("diamond", 33, new int[] { 3, 8, 6, 3 }, 10);

	private final int g;
	private final int[] h;
	private final int i;

	private EnumArmorMaterial(String var3, int var4, int[] var5, int var6) {
		this.g = var4;
		this.h = var5;
		this.i = var6;
	}

	public int a(int var1) {
		return ItemArmor.d()[var1] * this.g;
	}

	public int b(int var1) {
		return this.h[var1];
	}

	public int a() {
		return this.i;
	}

	public Item b() {
		return this == LEATHER ? Items.LEATHER : (this == CHAIN ? Items.IRON_INGOT : (this == GOLD ? Items.GOLD_INGOT : (this == IRON ? Items.IRON_INGOT : (this == DIAMOND ? Items.DIAMOND : null))));
	}

}
