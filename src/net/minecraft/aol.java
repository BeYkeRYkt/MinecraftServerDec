package net.minecraft;

public class aol implements aoo {

	public boolean a(ain var1, World var2) {
		int var3 = 0;
		ItemStack var4 = null;

		for (int var5 = 0; var5 < var1.n_(); ++var5) {
			ItemStack var6 = var1.a(var5);
			if (var6 != null) {
				if (var6.getItem() == Items.FILLED_MAP) {
					if (var4 != null) {
						return false;
					}

					var4 = var6;
				} else {
					if (var6.getItem() != Items.MAP) {
						return false;
					}

					++var3;
				}
			}
		}

		return var4 != null && var3 > 0;
	}

	public ItemStack a(ain var1) {
		int var2 = 0;
		ItemStack var3 = null;

		for (int var4 = 0; var4 < var1.n_(); ++var4) {
			ItemStack var5 = var1.a(var4);
			if (var5 != null) {
				if (var5.getItem() == Items.FILLED_MAP) {
					if (var3 != null) {
						return null;
					}

					var3 = var5;
				} else {
					if (var5.getItem() != Items.MAP) {
						return null;
					}

					++var2;
				}
			}
		}

		if (var3 != null && var2 >= 1) {
			ItemStack var6 = new ItemStack(Items.FILLED_MAP, var2 + 1, var3.i());
			if (var3.s()) {
				var6.c(var3.q());
			}

			return var6;
		} else {
			return null;
		}
	}

	public int a() {
		return 9;
	}

	public ItemStack b() {
		return null;
	}

	public ItemStack[] b(ain var1) {
		ItemStack[] var2 = new ItemStack[var1.n_()];

		for (int var3 = 0; var3 < var2.length; ++var3) {
			ItemStack var4 = var1.a(var3);
			if (var4 != null && var4.getItem().r()) {
				var2[var3] = new ItemStack(var4.getItem().getCraftingResult());
			}
		}

		return var2;
	}
}
