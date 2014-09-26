package net.minecraft;

class aof implements IRecipe {

	private aof() {
	}

	public boolean a(InventoryCrafting var1, World var2) {
		ItemStack var3 = null;
		ItemStack var4 = null;

		for (int var5 = 0; var5 < var1.getSize(); ++var5) {
			ItemStack var6 = var1.getItem(var5);
			if (var6 != null) {
				if (var6.getItem() != Items.BANNER) {
					return false;
				}

				if (var3 != null && var4 != null) {
					return false;
				}

				int var7 = TileEntityBanner.b(var6);
				boolean var8 = TileEntityBanner.c(var6) > 0;
				if (var3 != null) {
					if (var8) {
						return false;
					}

					if (var7 != TileEntityBanner.b(var3)) {
						return false;
					}

					var4 = var6;
				} else if (var4 != null) {
					if (!var8) {
						return false;
					}

					if (var7 != TileEntityBanner.b(var4)) {
						return false;
					}

					var3 = var6;
				} else if (var8) {
					var3 = var6;
				} else {
					var4 = var6;
				}
			}
		}

		return var3 != null && var4 != null;
	}

	public ItemStack getResult(InventoryCrafting var1) {
		for (int var2 = 0; var2 < var1.getSize(); ++var2) {
			ItemStack var3 = var1.getItem(var2);
			if (var3 != null && TileEntityBanner.c(var3) > 0) {
				ItemStack var4 = var3.getCopy();
				var4.amount = 1;
				return var4;
			}
		}

		return null;
	}

	public int a() {
		return 2;
	}

	public ItemStack getResult() {
		return null;
	}

	public ItemStack[] b(InventoryCrafting var1) {
		ItemStack[] var2 = new ItemStack[var1.getSize()];

		for (int var3 = 0; var3 < var2.length; ++var3) {
			ItemStack var4 = var1.getItem(var3);
			if (var4 != null) {
				if (var4.getItem().r()) {
					var2[var3] = new ItemStack(var4.getItem().getCraftingResult());
				} else if (var4.hasTag() && TileEntityBanner.c(var4) > 0) {
					var2[var3] = var4.getCopy();
					var2[var3].amount = 1;
				}
			}
		}

		return var2;
	}

	// $FF: synthetic method
	aof(aod var1) {
		this();
	}
}
