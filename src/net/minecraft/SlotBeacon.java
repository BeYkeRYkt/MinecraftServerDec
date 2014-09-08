package net.minecraft;

class SlotBeacon extends Slot {

	// $FF: synthetic field
	final ContainerBeacon a;

	public SlotBeacon(ContainerBeacon var1, IInventory var2, int var3, int var4, int var5) {
		super(var2, var3, var4, var5);
		this.a = var1;
	}

	public boolean a(ItemStack var1) {
		return var1 == null ? false : var1.getItem() == Items.EMERALD || var1.getItem() == Items.DIAMOND || var1.getItem() == Items.GOLD_INGOT || var1.getItem() == Items.IRON_INGOT;
	}

	public int a() {
		return 1;
	}
}
