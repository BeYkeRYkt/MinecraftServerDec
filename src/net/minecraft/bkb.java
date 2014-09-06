package net.minecraft;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

abstract class bkb extends bms {

	protected static final List a = Lists.newArrayList((Object[]) (new vl[] { new vl(Items.DIAMOND, 0, 1, 3, 5), new vl(Items.IRON_INGOT, 0, 1, 5, 5), new vl(Items.GOLD_INGOT, 0, 1, 3, 15), new vl(Items.GOLDEN_SWORD, 0, 1, 1, 5), new vl(Items.GOLD_CHESTPLATE, 0, 1, 1, 5), new vl(Items.FLINT_AND_STEEL, 0, 1, 1, 5), new vl(Items.NETHER_WART, 0, 3, 7, 5), new vl(Items.SADDLE, 0, 1, 1, 10), new vl(Items.GOLDEN_HORSE_ARMOR, 0, 1, 1, 8), new vl(Items.IRON_HORSE_ARMOR, 0, 1, 1, 5), new vl(Items.DIAMOND_HORSE_ARMOR, 0, 1, 1, 3), new vl(Item.getItemOf(Blocks.OBSIDIAN), 0, 2, 4, 2) }));

	public bkb() {
	}

	protected bkb(int var1) {
		super(var1);
	}

	protected void b(NBTCompoundTag var1) {
	}

	protected void a(NBTCompoundTag var1) {
	}

	private int a(List var1) {
		boolean var2 = false;
		int var3 = 0;

		bkc var5;
		for (Iterator var4 = var1.iterator(); var4.hasNext(); var3 += var5.b) {
			var5 = (bkc) var4.next();
			if (var5.d > 0 && var5.c < var5.d) {
				var2 = true;
			}
		}

		return var2 ? var3 : -1;
	}

	private bkb a(bkf var1, List var2, List var3, Random var4, int var5, int var6, int var7, BlockFace var8, int var9) {
		int var10 = this.a(var2);
		boolean var11 = var10 > 0 && var9 <= 30;
		int var12 = 0;

		while (var12 < 5 && var11) {
			++var12;
			int var13 = var4.nextInt(var10);
			Iterator var14 = var2.iterator();

			while (var14.hasNext()) {
				bkc var15 = (bkc) var14.next();
				var13 -= var15.b;
				if (var13 < 0) {
					if (!var15.a(var9) || var15 == var1.b && !var15.e) {
						break;
					}

					bkb var16 = bjn.a(var15, var3, var4, var5, var6, var7, var8, var9);
					if (var16 != null) {
						++var15.c;
						var1.b = var15;
						if (!var15.a()) {
							var2.remove(var15);
						}

						return var16;
					}
				}
			}
		}

		return bjq.a(var3, var4, var5, var6, var7, var8, var9);
	}

	private bms a(bkf var1, List var2, Random var3, int var4, int var5, int var6, BlockFace var7, int var8, boolean var9) {
		if (Math.abs(var4 - var1.c().a) <= 112 && Math.abs(var6 - var1.c().c) <= 112) {
			List var10 = var1.c;
			if (var9) {
				var10 = var1.d;
			}

			bkb var11 = this.a(var1, var10, var2, var3, var4, var5, var6, var7, var8 + 1);
			if (var11 != null) {
				var2.add(var11);
				var1.e.add(var11);
			}

			return var11;
		} else {
			return bjq.a(var2, var3, var4, var5, var6, var7, var8);
		}
	}

	protected bms a(bkf var1, List var2, Random var3, int var4, int var5, boolean var6) {
		if (this.m != null) {
			switch (bjo.a[this.m.ordinal()]) {
				case 1:
					return this.a(var1, var2, var3, this.l.a + var4, this.l.b + var5, this.l.c - 1, this.m, this.d(), var6);
				case 2:
					return this.a(var1, var2, var3, this.l.a + var4, this.l.b + var5, this.l.f + 1, this.m, this.d(), var6);
				case 3:
					return this.a(var1, var2, var3, this.l.a - 1, this.l.b + var5, this.l.c + var4, this.m, this.d(), var6);
				case 4:
					return this.a(var1, var2, var3, this.l.d + 1, this.l.b + var5, this.l.c + var4, this.m, this.d(), var6);
			}
		}

		return null;
	}

	protected bms b(bkf var1, List var2, Random var3, int var4, int var5, boolean var6) {
		if (this.m != null) {
			switch (bjo.a[this.m.ordinal()]) {
				case 1:
					return this.a(var1, var2, var3, this.l.a - 1, this.l.b + var4, this.l.c + var5, BlockFace.e, this.d(), var6);
				case 2:
					return this.a(var1, var2, var3, this.l.a - 1, this.l.b + var4, this.l.c + var5, BlockFace.e, this.d(), var6);
				case 3:
					return this.a(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.c - 1, BlockFace.c, this.d(), var6);
				case 4:
					return this.a(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.c - 1, BlockFace.c, this.d(), var6);
			}
		}

		return null;
	}

	protected bms c(bkf var1, List var2, Random var3, int var4, int var5, boolean var6) {
		if (this.m != null) {
			switch (bjo.a[this.m.ordinal()]) {
				case 1:
					return this.a(var1, var2, var3, this.l.d + 1, this.l.b + var4, this.l.c + var5, BlockFace.f, this.d(), var6);
				case 2:
					return this.a(var1, var2, var3, this.l.d + 1, this.l.b + var4, this.l.c + var5, BlockFace.f, this.d(), var6);
				case 3:
					return this.a(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.f + 1, BlockFace.d, this.d(), var6);
				case 4:
					return this.a(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.f + 1, BlockFace.d, this.d(), var6);
			}
		}

		return null;
	}

	protected static boolean a(bjb var0) {
		return var0 != null && var0.b > 10;
	}

}
