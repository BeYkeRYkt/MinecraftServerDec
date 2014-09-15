package net.minecraft;

class aij extends Slot {

	// $FF: synthetic field
	final aii a;

	public aij(aii var1, IInventory var2, int var3, int var4, int var5) {
		super(var2, var3, var4, var5);
		this.a = var1;
	}

	public boolean a(ItemStack var1) {
		return var1 != null ? var1.getItem().l(var1) : false;
	}

	public int a() {
		return 64;
	}
}
