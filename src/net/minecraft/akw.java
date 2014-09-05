package net.minecraft;

public class akw extends Item {

	public static final int[] a = new int[] { 1973019, 11743532, 3887386, 5320730, 2437522, 8073150, 2651799, 11250603, 4408131, 14188952, 4312372, 14602026, 6719955, 12801229, 15435844, 15790320 };

	public akw() {
		this.a(true);
		this.d(0);
		this.a(CreativeModeTab.l);
	}

	public String e_(ItemStack var1) {
		int var2 = var1.i();
		return super.a() + "." + akv.a(var2).d();
	}

	public boolean a(ItemStack var1, EntityHuman var2, World var3, Position var4, PaintingDirection var5, float var6, float var7, float var8) {
		if (!var2.a(var4.a(var5), var5, var1)) {
			return false;
		} else {
			akv var9 = akv.a(var1.i());
			if (var9 == akv.a) {
				if (a(var1, var3, var4)) {
					if (!var3.D) {
						var3.b(2005, var4, 0);
					}

					return true;
				}
			} else if (var9 == akv.m) {
				bec var10 = var3.p(var4);
				Block var11 = var10.c();
				if (var11 == aty.r && var10.b(BlockWood.a) == ayx.d) {
					if (var5 == PaintingDirection.a) {
						return false;
					}

					if (var5 == PaintingDirection.b) {
						return false;
					}

					var4 = var4.a(var5);
					if (var3.d(var4)) {
						bec var12 = aty.bN.a(var3, var4, var5, var6, var7, var8, 0, var2);
						var3.a(var4, var12, 2);
						if (!var2.by.instabuild) {
							--var1.b;
						}
					}

					return true;
				}
			}

			return false;
		}
	}

	public static boolean a(ItemStack var0, World var1, Position var2) {
		bec var3 = var1.p(var2);
		if (var3.c() instanceof atz) {
			atz var4 = (atz) var3.c();
			if (var4.a(var1, var2, var3, var1.D)) {
				if (!var1.D) {
					if (var4.a(var1, var1.s, var2, var3)) {
						var4.b(var1, var1.s, var2, var3);
					}

					--var0.b;
				}

				return true;
			}
		}

		return false;
	}

	public boolean a(ItemStack var1, EntityHuman var2, EntityLiving var3) {
		if (var3 instanceof EntitySheep) {
			EntitySheep var4 = (EntitySheep) var3;
			akv var5 = akv.a(var1.i());
			if (!var4.ck() && var4.cj() != var5) {
				var4.b(var5);
				--var1.b;
			}

			return true;
		} else {
			return false;
		}
	}

}
