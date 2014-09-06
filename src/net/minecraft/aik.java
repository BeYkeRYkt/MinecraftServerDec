package net.minecraft;

class aik extends ajk {

	private EntityHuman a;

	public aik(EntityHuman var1, IInventory var2, int var3, int var4, int var5) {
		super(var2, var3, var4, var5);
		this.a = var1;
	}

	public boolean a(ItemStack var1) {
		return b_(var1);
	}

	public int a() {
		return 1;
	}

	public void a(EntityHuman var1, ItemStack var2) {
		if (var2.getItem() == Items.POTION && var2.i() > 0) {
			this.a.b((Statistic) tl.B);
		}

		super.a(var1, var2);
	}

	public static boolean b_(ItemStack var0) {
		return var0 != null && (var0.getItem() == Items.POTION || var0.getItem() == Items.GLASS_BOTTLE);
	}
}
