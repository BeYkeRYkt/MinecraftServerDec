package net.minecraft;

class aja extends ajk {

	// $FF: synthetic field
	final abt a;
	// $FF: synthetic field
	final aiy b;

	aja(aiy var1, IInventory var2, int var3, int var4, int var5, abt var6) {
		super(var2, var3, var4, var5);
		this.b = var1;
		this.a = var6;
	}

	public boolean a(ItemStack var1) {
		return super.a(var1) && this.a.cM() && abt.a(var1.getItem());
	}
}
