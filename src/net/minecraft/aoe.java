package net.minecraft;

class aoe implements IRecipe {

	private aoe() {
	}

	public boolean a(InventoryCrafting var1, World var2) {
		boolean var3 = false;

		for (int var4 = 0; var4 < var1.getSize(); ++var4) {
			ItemStack var5 = var1.getItem(var4);
			if (var5 != null && var5.getItem() == Items.BANNER) {
				if (var3) {
					return false;
				}

				if (TileEntityBanner.c(var5) >= 6) {
					return false;
				}

				var3 = true;
			}
		}

		if (!var3) {
			return false;
		} else {
			return this.c(var1) != null;
		}
	}

	public ItemStack getResult(InventoryCrafting var1) {
		ItemStack var2 = null;

		for (int var3 = 0; var3 < var1.getSize(); ++var3) {
			ItemStack var4 = var1.getItem(var3);
			if (var4 != null && var4.getItem() == Items.BANNER) {
				var2 = var4.getCopy();
				var2.amount = 1;
				break;
			}
		}

		bcj var8 = this.c(var1);
		if (var8 != null) {
			int var9 = 0;

			ItemStack var6;
			for (int var5 = 0; var5 < var1.getSize(); ++var5) {
				var6 = var1.getItem(var5);
				if (var6 != null && var6.getItem() == Items.DYE) {
					var9 = var6.getWearout();
					break;
				}
			}

			NBTCompoundTag var10 = var2.a("BlockEntityTag", true);
			var6 = null;
			NBTListTag var11;
			if (var10.isTagAssignableFrom("Patterns", 9)) {
				var11 = var10.getList("Patterns", 10);
			} else {
				var11 = new NBTListTag();
				var10.put("Patterns", (NBTTag) var11);
			}

			NBTCompoundTag var7 = new NBTCompoundTag();
			var7.put("Pattern", var8.b());
			var7.put("Color", var9);
			var11.addTag((NBTTag) var7);
		}

		return var2;
	}

	public int a() {
		return 10;
	}

	public ItemStack getResult() {
		return null;
	}

	public ItemStack[] b(InventoryCrafting var1) {
		ItemStack[] var2 = new ItemStack[var1.getSize()];

		for (int var3 = 0; var3 < var2.length; ++var3) {
			ItemStack var4 = var1.getItem(var3);
			if (var4 != null && var4.getItem().r()) {
				var2[var3] = new ItemStack(var4.getItem().getCraftingResult());
			}
		}

		return var2;
	}

	private bcj c(InventoryCrafting var1) {
		bcj[] var2 = bcj.values();
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			bcj var5 = var2[var4];
			if (var5.d()) {
				boolean var6 = true;
				int var9;
				if (var5.e()) {
					boolean var12 = false;
					boolean var13 = false;

					for (var9 = 0; var9 < var1.getSize() && var6; ++var9) {
						ItemStack var14 = var1.getItem(var9);
						if (var14 != null && var14.getItem() != Items.BANNER) {
							if (var14.getItem() == Items.DYE) {
								if (var13) {
									var6 = false;
									break;
								}

								var13 = true;
							} else {
								if (var12 || !var14.a(var5.f())) {
									var6 = false;
									break;
								}

								var12 = true;
							}
						}
					}

					if (!var12) {
						var6 = false;
					}
				} else if (var1.getSize() != var5.c().length * var5.c()[0].length()) {
					var6 = false;
				} else {
					int var7 = -1;

					for (int var8 = 0; var8 < var1.getSize() && var6; ++var8) {
						var9 = var8 / 3;
						int var10 = var8 % 3;
						ItemStack var11 = var1.getItem(var8);
						if (var11 != null && var11.getItem() != Items.BANNER) {
							if (var11.getItem() != Items.DYE) {
								var6 = false;
								break;
							}

							if (var7 != -1 && var7 != var11.getWearout()) {
								var6 = false;
								break;
							}

							if (var5.c()[var9].charAt(var10) == 32) {
								var6 = false;
								break;
							}

							var7 = var11.getWearout();
						} else if (var5.c()[var9].charAt(var10) != 32) {
							var6 = false;
							break;
						}
					}
				}

				if (var6) {
					return var5;
				}
			}
		}

		return null;
	}

	// $FF: synthetic method
	aoe(aod var1) {
		this();
	}
}
