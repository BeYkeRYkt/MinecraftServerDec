package net.minecraft;

public enum atl implements va {

	a("NORTH_SOUTH", 0, 0, "north_south"), b("EAST_WEST", 1, 1, "east_west"), c("ASCENDING_EAST", 2, 2, "ascending_east"), d("ASCENDING_WEST", 3, 3, "ascending_west"), e("ASCENDING_NORTH", 4, 4, "ascending_north"), f("ASCENDING_SOUTH", 5, 5, "ascending_south"), g("SOUTH_EAST", 6, 6, "south_east"), h("SOUTH_WEST", 7, 7, "south_west"), i("NORTH_WEST", 8, 8, "north_west"), j("NORTH_EAST", 9, 9, "north_east");
	private static final atl[] k = new atl[values().length];
	private final int l;
	private final String m;
	// $FF: synthetic field
	private static final atl[] n = new atl[] { a, b, c, d, e, f, g, h, i, j };

	private atl(String var1, int var2, int var3, String var4) {
		this.l = var3;
		this.m = var4;
	}

	public int a() {
		return this.l;
	}

	public String toString() {
		return this.m;
	}

	public boolean c() {
		return this == e || this == c || this == f || this == d;
	}

	public static atl a(int var0) {
		if (var0 < 0 || var0 >= k.length) {
			var0 = 0;
		}

		return k[var0];
	}

	public String l() {
		return this.m;
	}

	static {
		atl[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			atl var3 = var0[var2];
			k[var3.a()] = var3;
		}

	}
}
