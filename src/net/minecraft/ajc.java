package net.minecraft;

class ajc extends ajk {

	// $FF: synthetic field
	final int a;
	// $FF: synthetic field
	final ajb b;

	ajc(ajb var1, IInventory var2, int var3, int var4, int var5, int var6) {
		super(var2, var3, var4, var5);
		this.b = var1;
		this.a = var6;
	}

	public int a() {
		return 1;
	}

	public boolean a(ItemStack var1) {
		return var1 == null ? false : (var1.getItem() instanceof ItemArmor ? ((ItemArmor) var1.getItem()).b == this.a : (var1.getItem() != Item.getItemOf(Blocks.PUMPKIN) && var1.getItem() != Items.SKULL ? false : this.a == 0));
	}
}
