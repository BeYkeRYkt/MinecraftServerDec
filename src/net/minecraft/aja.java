package net.minecraft;

class aja extends Slot {

	// $FF: synthetic field
	final EntityHorse a;
	// $FF: synthetic field
	final ContainerHorse b;

	aja(ContainerHorse var1, IInventory var2, int var3, int var4, int var5, EntityHorse var6) {
		super(var2, var3, var4, var5);
		this.b = var1;
		this.a = var6;
	}

	public boolean a(ItemStack var1) {
		return super.a(var1) && this.a.cM() && EntityHorse.a(var1.getItem());
	}
}
