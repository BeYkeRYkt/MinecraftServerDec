package net.minecraft;

class aiz extends Slot {

	// $FF: synthetic field
	final aiy a;

	aiz(aiy var1, IInventory var2, int var3, int var4, int var5) {
		super(var2, var3, var4, var5);
		this.a = var1;
	}

	public boolean a(ItemStack var1) {
		return super.a(var1) && var1.getItem() == Items.SADDLE && !this.hasItem();
	}
}
