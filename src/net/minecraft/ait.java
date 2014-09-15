package net.minecraft;

class ait extends Slot {

	// $FF: synthetic field
	final aiq a;

	ait(aiq var1, IInventory var2, int var3, int var4, int var5) {
		super(var2, var3, var4, var5);
		this.a = var1;
	}

	public boolean a(ItemStack var1) {
		return var1.getItem() == Items.DYE && akv.a(var1.getWearout()) == akv.l;
	}
}
