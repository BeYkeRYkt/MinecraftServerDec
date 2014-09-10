package net.minecraft;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class bmy {

	public static void a() {
		bmq.a(bna.class, "ViBH");
		bmq.a(bnb.class, "ViDF");
		bmq.a(bnc.class, "ViF");
		bmq.a(bnd.class, "ViL");
		bmq.a(bnf.class, "ViPH");
		bmq.a(bng.class, "ViSH");
		bmq.a(bnh.class, "ViSmH");
		bmq.a(bni.class, "ViST");
		bmq.a(bnj.class, "ViS");
		bmq.a(bnk.class, "ViStart");
		bmq.a(bnl.class, "ViSR");
		bmq.a(bnm.class, "ViTRH");
		bmq.a(bnp.class, "ViW");
	}

	public static List a(Random var0, int var1) {
		ArrayList var2 = Lists.newArrayList();
		var2.add(new bne(bng.class, 4, DataTypesConverter.a(var0, 2 + var1, 4 + var1 * 2)));
		var2.add(new bne(bni.class, 20, DataTypesConverter.a(var0, 0 + var1, 1 + var1)));
		var2.add(new bne(bna.class, 20, DataTypesConverter.a(var0, 0 + var1, 2 + var1)));
		var2.add(new bne(bnh.class, 3, DataTypesConverter.a(var0, 2 + var1, 5 + var1 * 3)));
		var2.add(new bne(bnf.class, 15, DataTypesConverter.a(var0, 0 + var1, 2 + var1)));
		var2.add(new bne(bnb.class, 3, DataTypesConverter.a(var0, 1 + var1, 4 + var1)));
		var2.add(new bne(bnc.class, 3, DataTypesConverter.a(var0, 2 + var1, 4 + var1 * 2)));
		var2.add(new bne(bnj.class, 15, DataTypesConverter.a(var0, 0, 1 + var1)));
		var2.add(new bne(bnm.class, 8, DataTypesConverter.a(var0, 0 + var1, 3 + var1 * 2)));
		Iterator var3 = var2.iterator();

		while (var3.hasNext()) {
			if (((bne) var3.next()).d == 0) {
				var3.remove();
			}
		}

		return var2;
	}

	private static int a(List var0) {
		boolean var1 = false;
		int var2 = 0;

		bne var4;
		for (Iterator var3 = var0.iterator(); var3.hasNext(); var2 += var4.b) {
			var4 = (bne) var3.next();
			if (var4.d > 0 && var4.c < var4.d) {
				var1 = true;
			}
		}

		return var1 ? var2 : -1;
	}

	private static bnn a(bnk var0, bne var1, List var2, Random var3, int var4, int var5, int var6, BlockFace var7, int var8) {
		Class var9 = var1.a;
		Object var10 = null;
		if (var9 == bng.class) {
			var10 = bng.a(var0, var2, var3, var4, var5, var6, var7, var8);
		} else if (var9 == bni.class) {
			var10 = bni.a(var0, var2, var3, var4, var5, var6, var7, var8);
		} else if (var9 == bna.class) {
			var10 = bna.a(var0, var2, var3, var4, var5, var6, var7, var8);
		} else if (var9 == bnh.class) {
			var10 = bnh.a(var0, var2, var3, var4, var5, var6, var7, var8);
		} else if (var9 == bnf.class) {
			var10 = bnf.a(var0, var2, var3, var4, var5, var6, var7, var8);
		} else if (var9 == bnb.class) {
			var10 = bnb.a(var0, var2, var3, var4, var5, var6, var7, var8);
		} else if (var9 == bnc.class) {
			var10 = bnc.a(var0, var2, var3, var4, var5, var6, var7, var8);
		} else if (var9 == bnj.class) {
			var10 = bnj.a(var0, var2, var3, var4, var5, var6, var7, var8);
		} else if (var9 == bnm.class) {
			var10 = bnm.a(var0, var2, var3, var4, var5, var6, var7, var8);
		}

		return (bnn) var10;
	}

	private static bnn c(bnk var0, List var1, Random var2, int var3, int var4, int var5, BlockFace var6, int var7) {
		int var8 = a(var0.e);
		if (var8 <= 0) {
			return null;
		} else {
			int var9 = 0;

			while (var9 < 5) {
				++var9;
				int var10 = var2.nextInt(var8);
				Iterator var11 = var0.e.iterator();

				while (var11.hasNext()) {
					bne var12 = (bne) var11.next();
					var10 -= var12.b;
					if (var10 < 0) {
						if (!var12.a(var7) || var12 == var0.d && var0.e.size() > 1) {
							break;
						}

						bnn var13 = a(var0, var12, var1, var2, var3, var4, var5, var6, var7);
						if (var13 != null) {
							++var12.c;
							var0.d = var12;
							if (!var12.a()) {
								var0.e.remove(var12);
							}

							return var13;
						}
					}
				}
			}

			CuboidArea var14 = bnd.a(var0, var1, var2, var3, var4, var5, var6);
			if (var14 != null) {
				return new bnd(var0, var7, var2, var14, var6);
			} else {
				return null;
			}
		}
	}

	private static bms d(bnk var0, List var1, Random var2, int var3, int var4, int var5, BlockFace var6, int var7) {
		if (var7 > 50) {
			return null;
		} else if (Math.abs(var3 - var0.c().minX) <= 112 && Math.abs(var5 - var0.c().minZ) <= 112) {
			bnn var8 = c(var0, var1, var2, var3, var4, var5, var6, var7 + 1);
			if (var8 != null) {
				int var9 = (var8.l.minX + var8.l.maxX) / 2;
				int var10 = (var8.l.minZ + var8.l.maxZ) / 2;
				int var11 = var8.l.maxX - var8.l.minX;
				int var12 = var8.l.maxZ - var8.l.minZ;
				int var13 = var11 > var12 ? var11 : var12;
				if (var0.e().a(var9, var10, var13 / 2 + 4, WorldGenVillage.d)) {
					var1.add(var8);
					var0.f.add(var8);
					return var8;
				}
			}

			return null;
		} else {
			return null;
		}
	}

	private static bms e(bnk var0, List var1, Random var2, int var3, int var4, int var5, BlockFace var6, int var7) {
		if (var7 > 3 + var0.c) {
			return null;
		} else if (Math.abs(var3 - var0.c().minX) <= 112 && Math.abs(var5 - var0.c().minZ) <= 112) {
			CuboidArea var8 = bnl.a(var0, var1, var2, var3, var4, var5, var6);
			if (var8 != null && var8.minY > 10) {
				bnl var9 = new bnl(var0, var7, var2, var8, var6);
				int var10 = (var9.l.minX + var9.l.maxX) / 2;
				int var11 = (var9.l.minZ + var9.l.maxZ) / 2;
				int var12 = var9.l.maxX - var9.l.minX;
				int var13 = var9.l.maxZ - var9.l.minZ;
				int var14 = var12 > var13 ? var12 : var13;
				if (var0.e().a(var10, var11, var14 / 2 + 4, WorldGenVillage.d)) {
					var1.add(var9);
					var0.g.add(var9);
					return var9;
				}
			}

			return null;
		} else {
			return null;
		}
	}

	// $FF: synthetic method
	static bms a(bnk var0, List var1, Random var2, int var3, int var4, int var5, BlockFace var6, int var7) {
		return d(var0, var1, var2, var3, var4, var5, var6, var7);
	}

	// $FF: synthetic method
	static bms b(bnk var0, List var1, Random var2, int var3, int var4, int var5, BlockFace var6, int var7) {
		return e(var0, var1, var2, var3, var4, var5, var6, var7);
	}
}
