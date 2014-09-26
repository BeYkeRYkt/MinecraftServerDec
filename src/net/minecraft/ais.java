package net.minecraft;

class ais extends Slot {

	// $FF: synthetic field
	final ContainerEnchantTable a;

	ais(ContainerEnchantTable var1, IInventory var2, int var3, int var4, int var5) {
		super(var2, var3, var4, var5);
		this.a = var1;
	}

	public boolean a(ItemStack var1) {
		return true;
	}

	public int a() {
		return 1;
	}
}
