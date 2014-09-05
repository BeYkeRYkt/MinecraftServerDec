package net.minecraft;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class blr {

	private static final bma[] b = new bma[] { new bma(bmi.class, 40, 0), new bma(bmc.class, 5, 5), new bma(bly.class, 20, 0), new bma(bmd.class, 20, 0), new bma(bme.class, 10, 6), new bma(bmj.class, 5, 5), new bma(bmg.class, 5, 5), new bma(blx.class, 5, 4), new bma(blv.class, 5, 4), new bls(blz.class, 10, 2), new blt(bmb.class, 20, 1) };
	private static List c;
	private static Class d;
	static int a;
	private static final bmf e = new bmf((bls) null);

	public static void a() {
		bmq.a(blv.class, "SHCC");
		bmq.a(blw.class, "SHFC");
		bmq.a(blx.class, "SH5C");
		bmq.a(bly.class, "SHLT");
		bmq.a(blz.class, "SHLi");
		bmq.a(bmb.class, "SHPR");
		bmq.a(bmc.class, "SHPH");
		bmq.a(bmd.class, "SHRT");
		bmq.a(bme.class, "SHRC");
		bmq.a(bmg.class, "SHSD");
		bmq.a(bmh.class, "SHStart");
		bmq.a(bmi.class, "SHS");
		bmq.a(bmj.class, "SHSSD");
	}

	public static void b() {
		c = Lists.newArrayList();
		bma[] var0 = b;
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			bma var3 = var0[var2];
			var3.c = 0;
			c.add(var3);
		}

		d = null;
	}

	private static boolean d() {
		boolean var0 = false;
		a = 0;

		bma var2;
		for (Iterator var1 = c.iterator(); var1.hasNext(); a += var2.b) {
			var2 = (bma) var1.next();
			if (var2.d > 0 && var2.c < var2.d) {
				var0 = true;
			}
		}

		return var0;
	}

	private static bmk a(Class var0, List var1, Random var2, int var3, int var4, int var5, PaintingDirection var6, int var7) {
		Object var8 = null;
		if (var0 == bmi.class) {
			var8 = bmi.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var0 == bmc.class) {
			var8 = bmc.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var0 == bly.class) {
			var8 = bly.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var0 == bmd.class) {
			var8 = bmd.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var0 == bme.class) {
			var8 = bme.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var0 == bmj.class) {
			var8 = bmj.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var0 == bmg.class) {
			var8 = bmg.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var0 == blx.class) {
			var8 = blx.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var0 == blv.class) {
			var8 = blv.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var0 == blz.class) {
			var8 = blz.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var0 == bmb.class) {
			var8 = bmb.a(var1, var2, var3, var4, var5, var6, var7);
		}

		return (bmk) var8;
	}

	private static bmk b(bmh var0, List var1, Random var2, int var3, int var4, int var5, PaintingDirection var6, int var7) {
		if (!d()) {
			return null;
		} else {
			if (d != null) {
				bmk var8 = a(d, var1, var2, var3, var4, var5, var6, var7);
				d = null;
				if (var8 != null) {
					return var8;
				}
			}

			int var13 = 0;

			while (var13 < 5) {
				++var13;
				int var9 = var2.nextInt(a);
				Iterator var10 = c.iterator();

				while (var10.hasNext()) {
					bma var11 = (bma) var10.next();
					var9 -= var11.b;
					if (var9 < 0) {
						if (!var11.a(var7) || var11 == var0.a) {
							break;
						}

						bmk var12 = a(var11.a, var1, var2, var3, var4, var5, var6, var7);
						if (var12 != null) {
							++var11.c;
							var0.a = var11;
							if (!var11.a()) {
								c.remove(var11);
							}

							return var12;
						}
					}
				}
			}

			bjb var14 = blw.a(var1, var2, var3, var4, var5, var6);
			if (var14 != null && var14.b > 1) {
				return new blw(var7, var2, var14, var6);
			} else {
				return null;
			}
		}
	}

	private static bms c(bmh var0, List var1, Random var2, int var3, int var4, int var5, PaintingDirection var6, int var7) {
		if (var7 > 50) {
			return null;
		} else if (Math.abs(var3 - var0.c().a) <= 112 && Math.abs(var5 - var0.c().c) <= 112) {
			bmk var8 = b(var0, var1, var2, var3, var4, var5, var6, var7 + 1);
			if (var8 != null) {
				var1.add(var8);
				var0.c.add(var8);
			}

			return var8;
		} else {
			return null;
		}
	}

	// $FF: synthetic method
	static bms a(bmh var0, List var1, Random var2, int var3, int var4, int var5, PaintingDirection var6, int var7) {
		return c(var0, var1, var2, var3, var4, var5, var6, var7);
	}

	// $FF: synthetic method
	static Class a(Class var0) {
		d = var0;
		return var0;
	}

	// $FF: synthetic method
	static bmf c() {
		return e;
	}

}
