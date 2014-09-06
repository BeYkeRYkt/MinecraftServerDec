package net.minecraft;

public enum EnumToolMaterial {

	WOOD(0, 59, 2.0F, 0.0F, 15), 
	STONE(1, 131, 4.0F, 1.0F, 5), 
	IRON(2, 250, 6.0F, 2.0F, 14), 
	EMERALD(3, 1561, 8.0F, 3.0F, 10), 
	GOLD(0, 32, 12.0F, 0.0F, 22);

	private final int f;
	private final int g;
	private final float h;
	private final float i;
	private final int j;

	private EnumToolMaterial(int var3, int var4, float var5, float var6, int var7) {
		this.f = var3;
		this.g = var4;
		this.h = var5;
		this.i = var6;
		this.j = var7;
	}

	public int a() {
		return this.g;
	}

	public float b() {
		return this.h;
	}

	public float c() {
		return this.i;
	}

	public int d() {
		return this.f;
	}

	public int e() {
		return this.j;
	}

	public Item f() {
		return this == WOOD ? Item.getItemOf(Blocks.PLANKS) : (this == STONE ? Item.getItemOf(Blocks.COBBLESTONE) : (this == GOLD ? Items.GOLD_INGOT : (this == IRON ? Items.IRON_INGOT : (this == EMERALD ? Items.DIAMOND : null))));
	}

}
