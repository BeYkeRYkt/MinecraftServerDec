package net.minecraft;

public class alb extends Item {

	public alb() {
		this.a(CreativeModeTab.f);
	}

	public boolean a(ItemStack var1, EntityHuman var2, World var3, Position var4, ej var5, float var6, float var7, float var8) {
		bec var9 = var3.p(var4);
		if (var2.a(var4.a(var5), var5, var1) && var9.c() == aty.bG && !((Boolean) var9.b(avq.b)).booleanValue()) {
			if (var3.D) {
				return true;
			} else {
				var3.a(var4, var9.a(avq.b, Boolean.valueOf(true)), 2);
				var3.e(var4, aty.bG);
				--var1.b;

				for (int var10 = 0; var10 < 16; ++var10) {
					double var11 = (double) ((float) var4.n() + (5.0F + rnd.nextFloat() * 6.0F) / 16.0F);
					double var13 = (double) ((float) var4.o() + 0.8125F);
					double var15 = (double) ((float) var4.p() + (5.0F + rnd.nextFloat() * 6.0F) / 16.0F);
					double var17 = 0.0D;
					double var19 = 0.0D;
					double var21 = 0.0D;
					var3.a(ew.l, var11, var13, var15, var17, var19, var21, new int[0]);
				}

				ej var23 = (ej) var9.b(avq.a);
				int var24 = 0;
				int var12 = 0;
				boolean var25 = false;
				boolean var14 = true;
				ej var26 = var23.e();

				for (int var16 = -2; var16 <= 2; ++var16) {
					Position var28 = var4.a(var26, var16);
					bec var18 = var3.p(var28);
					if (var18.c() == aty.bG) {
						if (!((Boolean) var18.b(avq.b)).booleanValue()) {
							var14 = false;
							break;
						}

						var12 = var16;
						if (!var25) {
							var24 = var16;
							var25 = true;
						}
					}
				}

				if (var14 && var12 == var24 + 2) {
					Position var27 = var4.a(var23, 4);

					int var29;
					for (var29 = var24; var29 <= var12; ++var29) {
						Position var30 = var27.a(var26, var29);
						bec var32 = var3.p(var30);
						if (var32.c() != aty.bG || !((Boolean) var32.b(avq.b)).booleanValue()) {
							var14 = false;
							break;
						}
					}

					int var31;
					Position var33;
					for (var29 = var24 - 1; var29 <= var12 + 1; var29 += 4) {
						var27 = var4.a(var26, var29);

						for (var31 = 1; var31 <= 3; ++var31) {
							var33 = var27.a(var23, var31);
							bec var20 = var3.p(var33);
							if (var20.c() != aty.bG || !((Boolean) var20.b(avq.b)).booleanValue()) {
								var14 = false;
								break;
							}
						}
					}

					if (var14) {
						for (var29 = var24; var29 <= var12; ++var29) {
							var27 = var4.a(var26, var29);

							for (var31 = 1; var31 <= 3; ++var31) {
								var33 = var27.a(var23, var31);
								var3.a(var33, aty.bF.P(), 2);
							}
						}
					}
				}

				return true;
			}
		} else {
			return false;
		}
	}

	public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
		bru var4 = this.a(var2, var3, false);
		if (var4 != null && var4.a == brv.b && var2.p(var4.a()).c() == aty.bG) {
			return var1;
		} else {
			if (!var2.D) {
				Position var5 = var2.a("Stronghold", new Position(var3));
				if (var5 != null) {
					ahk var6 = new ahk(var2, var3.locationX, var3.locationY, var3.locationZ);
					var6.a(var5);
					var2.d((Entity) var6);
					var2.a((Entity) var3, "random.bow", 0.5F, 0.4F / (rnd.nextFloat() * 0.4F + 0.8F));
					var2.a((EntityHuman) null, 1002, new Position(var3), 0);
					if (!var3.by.instabuild) {
						--var1.b;
					}

					var3.b(ty.J[Item.getId((Item) this)]);
				}
			}

			return var1;
		}
	}
}
