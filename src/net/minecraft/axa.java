package net.minecraft;

public enum axa implements va {

	a("NORTH_WEST", 0, 1, "north_west"), b("NORTH", 1, 2, "north"), c("NORTH_EAST", 2, 3, "north_east"), d("WEST", 3, 4, "west"), e("CENTER", 4, 5, "center"), f("EAST", 5, 6, "east"), g("SOUTH_WEST", 6, 7, "south_west"), h("SOUTH", 7, 8, "south"), i("SOUTH_EAST", 8, 9, "south_east"), j("STEM", 9, 10, "stem"), k("ALL_INSIDE", 10, 0, "all_inside"), l("ALL_OUTSIDE", 11, 14, "all_outside"), m("ALL_STEM", 12, 15, "all_stem");
	private static final axa[] n = new axa[16];
	private final int o;
	private final String p;
	// $FF: synthetic field
	private static final axa[] q = new axa[] { a, b, c, d, e, f, g, h, i, j, k, l, m };

	private axa(String var1, int var2, int var3, String var4) {
		this.o = var3;
		this.p = var4;
	}

	public int a() {
		return this.o;
	}

	public String toString() {
		return this.p;
	}

	public static axa a(int var0) {
		if (var0 < 0 || var0 >= n.length) {
			var0 = 0;
		}

		axa var1 = n[var0];
		return var1 == null ? n[0] : var1;
	}

	public String l() {
		return this.p;
	}

	static {
		axa[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			axa var3 = var0[var2];
			n[var3.a()] = var3;
		}

	}
}
