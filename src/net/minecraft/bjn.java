package net.minecraft;

import java.util.List;
import java.util.Random;

public class bjn {

	private static final bkc[] a = new bkc[] { new bkc(bjr.class, 30, 0, true), new bkc(bjp.class, 10, 4), new bkc(bkd.class, 10, 4), new bkc(bke.class, 10, 3), new bkc(bka.class, 5, 2), new bkc(bju.class, 5, 1) };
	private static final bkc[] b = new bkc[] { new bkc(bjx.class, 25, 0, true), new bkc(bjv.class, 15, 5), new bkc(bjy.class, 5, 10), new bkc(bjw.class, 5, 10), new bkc(bjs.class, 10, 3, true), new bkc(bjt.class, 7, 2), new bkc(bjz.class, 5, 2) };

	public static void a() {
		WorldGenFactory.a(bjp.class, "NeBCr");
		WorldGenFactory.a(bjq.class, "NeBEF");
		WorldGenFactory.a(bjr.class, "NeBS");
		WorldGenFactory.a(bjs.class, "NeCCS");
		WorldGenFactory.a(bjt.class, "NeCTB");
		WorldGenFactory.a(bju.class, "NeCE");
		WorldGenFactory.a(bjv.class, "NeSCSC");
		WorldGenFactory.a(bjw.class, "NeSCLT");
		WorldGenFactory.a(bjx.class, "NeSC");
		WorldGenFactory.a(bjy.class, "NeSCRT");
		WorldGenFactory.a(bjz.class, "NeCSR");
		WorldGenFactory.a(bka.class, "NeMT");
		WorldGenFactory.a(bkd.class, "NeRC");
		WorldGenFactory.a(bke.class, "NeSR");
		WorldGenFactory.a(bkf.class, "NeStart");
	}

	private static bkb b(bkc var0, List var1, Random var2, int var3, int var4, int var5, BlockFace var6, int var7) {
		Class var8 = var0.a;
		Object var9 = null;
		if (var8 == bjr.class) {
			var9 = bjr.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var8 == bjp.class) {
			var9 = bjp.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var8 == bkd.class) {
			var9 = bkd.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var8 == bke.class) {
			var9 = bke.a(var1, var2, var3, var4, var5, var7, var6);
		} else if (var8 == bka.class) {
			var9 = bka.a(var1, var2, var3, var4, var5, var7, var6);
		} else if (var8 == bju.class) {
			var9 = bju.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var8 == bjx.class) {
			var9 = bjx.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var8 == bjy.class) {
			var9 = bjy.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var8 == bjw.class) {
			var9 = bjw.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var8 == bjs.class) {
			var9 = bjs.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var8 == bjt.class) {
			var9 = bjt.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var8 == bjv.class) {
			var9 = bjv.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var8 == bjz.class) {
			var9 = bjz.a(var1, var2, var3, var4, var5, var6, var7);
		}

		return (bkb) var9;
	}

	// $FF: synthetic method
	static bkb a(bkc var0, List var1, Random var2, int var3, int var4, int var5, BlockFace var6, int var7) {
		return b(var0, var1, var2, var3, var4, var5, var6, var7);
	}

	// $FF: synthetic method
	static bkc[] b() {
		return a;
	}

	// $FF: synthetic method
	static bkc[] c() {
		return b;
	}

}
