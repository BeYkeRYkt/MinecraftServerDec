package net.minecraft;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import java.util.Collection;

public enum awa implements va {

	a("DANDELION", 0, awc.a, 0, "dandelion"), b("POPPY", 1, awc.b, 0, "poppy"), c("BLUE_ORCHID", 2, awc.b, 1, "blue_orchid", "blueOrchid"), d("ALLIUM", 3, awc.b, 2, "allium"), e("HOUSTONIA", 4, awc.b, 3, "houstonia"), f("RED_TULIP", 5, awc.b, 4, "red_tulip", "tulipRed"), g("ORANGE_TULIP", 6, awc.b, 5, "orange_tulip", "tulipOrange"), h("WHITE_TULIP", 7, awc.b, 6, "white_tulip", "tulipWhite"), i("PINK_TULIP", 8, awc.b, 7, "pink_tulip", "tulipPink"), j("OXEYE_DAISY", 9, awc.b, 8, "oxeye_daisy",
			"oxeyeDaisy");
	private static final awa[][] k = new awa[awc.values().length][];
	private final awc l;
	private final int m;
	private final String n;
	private final String o;
	// $FF: synthetic field
	private static final awa[] p = new awa[] { a, b, c, d, e, f, g, h, i, j };

	private awa(String var1, int var2, awc var3, int var4, String var5) {
		this(var1, var2, var3, var4, var5, var5);
	}

	private awa(String var1, int var2, awc var3, int var4, String var5, String var6) {
		this.l = var3;
		this.m = var4;
		this.n = var5;
		this.o = var6;
	}

	public awc a() {
		return this.l;
	}

	public int b() {
		return this.m;
	}

	public static awa a(awc var0, int var1) {
		awa[] var2 = k[var0.ordinal()];
		if (var1 < 0 || var1 >= var2.length) {
			var1 = 0;
		}

		return var2[var1];
	}

	public String toString() {
		return this.n;
	}

	public String l() {
		return this.n;
	}

	public String d() {
		return this.o;
	}

	static {
		awc[] var0 = awc.values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			awc var3 = var0[var2];
			Collection var4 = Collections2.filter(Lists.newArrayList((Object[]) values()), new awb(var3));
			k[var3.ordinal()] = (awa[]) var4.toArray(new awa[var4.size()]);
		}

	}
}
