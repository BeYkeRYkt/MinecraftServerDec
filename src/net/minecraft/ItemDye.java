package net.minecraft;

public class ItemDye extends Item {

	public static final int[] a = new int[] { 1973019, 11743532, 3887386, 5320730, 2437522, 8073150, 2651799, 11250603, 4408131, 14188952, 4312372, 14602026, 6719955, 12801229, 15435844, 15790320 };

	public ItemDye() {
		this.a(true);
		this.setDurability(0);
		this.setCreativeModeTab(CreativeModeTab.MATERIALS);
	}

	public String getName(ItemStack var1) {
		int var2 = var1.getWearout();
		return super.getName() + "." + akv.a(var2).d();
	}

	public boolean a(ItemStack var1, EntityHuman var2, World var3, Position var4, BlockFace var5, float var6, float var7, float var8) {
		if (!var2.a(var4.a(var5), var5, var1)) {
			return false;
		} else {
			akv var9 = akv.a(var1.getWearout());
			if (var9 == akv.a) {
				if (a(var1, var3, var4)) {
					if (!var3.isStatic) {
						var3.b(2005, var4, 0);
					}

					return true;
				}
			} else if (var9 == akv.m) {
				IBlockState var10 = var3.getBlockState(var4);
				Block var11 = var10.getBlock();
				if (var11 == Blocks.LOG && var10.b(BlockWood.a) == EnumWoodType.d) {
					if (var5 == BlockFace.DOWN) {
						return false;
					}

					if (var5 == BlockFace.UP) {
						return false;
					}

					var4 = var4.a(var5);
					if (var3.d(var4)) {
						IBlockState var12 = Blocks.COCOA.a(var3, var4, var5, var6, var7, var8, 0, var2);
						var3.setBlockAt(var4, var12, 2);
						if (!var2.playerProperties.instabuild) {
							--var1.amount;
						}
					}

					return true;
				}
			}

			return false;
		}
	}

	public static boolean a(ItemStack var0, World var1, Position var2) {
		IBlockState var3 = var1.getBlockState(var2);
		if (var3.getBlock() instanceof atz) {
			atz var4 = (atz) var3.getBlock();
			if (var4.a(var1, var2, var3, var1.isStatic)) {
				if (!var1.isStatic) {
					if (var4.a(var1, var1.s, var2, var3)) {
						var4.b(var1, var1.s, var2, var3);
					}

					--var0.amount;
				}

				return true;
			}
		}

		return false;
	}

	public boolean a(ItemStack var1, EntityHuman var2, EntityLiving var3) {
		if (var3 instanceof EntitySheep) {
			EntitySheep var4 = (EntitySheep) var3;
			akv var5 = akv.a(var1.getWearout());
			if (!var4.ck() && var4.cj() != var5) {
				var4.b(var5);
				--var1.amount;
			}

			return true;
		} else {
			return false;
		}
	}

}
