package net.minecraft;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import java.util.Collection;

public enum EnumFlowerType implements va {

	a("DANDELION", 0, EnumFlowerColor.a, 0, "dandelion"), b("POPPY", 1, EnumFlowerColor.b, 0, "poppy"), c("BLUE_ORCHID", 2, EnumFlowerColor.b, 1, "blue_orchid", "blueOrchid"), d("ALLIUM", 3, EnumFlowerColor.b, 2, "allium"), e("HOUSTONIA", 4, EnumFlowerColor.b, 3, "houstonia"), f("RED_TULIP", 5, EnumFlowerColor.b, 4, "red_tulip", "tulipRed"), g("ORANGE_TULIP", 6, EnumFlowerColor.b, 5, "orange_tulip", "tulipOrange"), h("WHITE_TULIP", 7, EnumFlowerColor.b, 6, "white_tulip", "tulipWhite"), i("PINK_TULIP", 8, EnumFlowerColor.b, 7, "pink_tulip", "tulipPink"), j("OXEYE_DAISY", 9, EnumFlowerColor.b, 8, "oxeye_daisy",
			"oxeyeDaisy");
	private static final EnumFlowerType[][] k = new EnumFlowerType[EnumFlowerColor.values().length][];
	private final EnumFlowerColor l;
	private final int m;
	private final String n;
	private final String o;
	// $FF: synthetic field
	private static final EnumFlowerType[] p = new EnumFlowerType[] { a, b, c, d, e, f, g, h, i, j };

	private EnumFlowerType(String var1, int var2, EnumFlowerColor var3, int var4, String var5) {
		this(var1, var2, var3, var4, var5, var5);
	}

	private EnumFlowerType(String var1, int var2, EnumFlowerColor var3, int var4, String var5, String var6) {
		this.l = var3;
		this.m = var4;
		this.n = var5;
		this.o = var6;
	}

	public EnumFlowerColor a() {
		return this.l;
	}

	public int b() {
		return this.m;
	}

	public static EnumFlowerType a(EnumFlowerColor var0, int var1) {
		EnumFlowerType[] var2 = k[var0.ordinal()];
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
		EnumFlowerColor[] var0 = EnumFlowerColor.values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			EnumFlowerColor var3 = var0[var2];
			Collection var4 = Collections2.filter(Lists.newArrayList((Object[]) values()), new awb(var3));
			k[var3.ordinal()] = (EnumFlowerType[]) var4.toArray(new EnumFlowerType[var4.size()]);
		}

	}
}
