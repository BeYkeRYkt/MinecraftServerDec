package net.minecraft;

public enum awf implements va {

	a("EMPTY", 0, "empty"), b("POPPY", 1, "rose"), c("BLUE_ORCHID", 2, "blue_orchid"), d("ALLIUM", 3, "allium"), e("HOUSTONIA", 4, "houstonia"), f("RED_TULIP", 5, "red_tulip"), g("ORANGE_TULIP", 6, "orange_tulip"), h("WHITE_TULIP", 7, "white_tulip"), i("PINK_TULIP", 8, "pink_tulip"), j("OXEYE_DAISY", 9, "oxeye_daisy"), k("DANDELION", 10, "dandelion"), l("OAK_SAPLING", 11, "oak_sapling"), m("SPRUCE_SAPLING", 12, "spruce_sapling"), n("BIRCH_SAPLING", 13, "birch_sapling"), o("JUNGLE_SAPLING", 14,
			"jungle_sapling"), p("ACACIA_SAPLING", 15, "acacia_sapling"), q("DARK_OAK_SAPLING", 16, "dark_oak_sapling"), r("MUSHROOM_RED", 17, "mushroom_red"), s("MUSHROOM_BROWN", 18, "mushroom_brown"), t("DEAD_BUSH", 19, "dead_bush"), u("FERN", 20, "fern"), v("CACTUS", 21, "cactus");
	private final String w;
	// $FF: synthetic field
	private static final awf[] x = new awf[] { a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v };

	private awf(String var1, int var2, String var3) {
		this.w = var3;
	}

	public String toString() {
		return this.w;
	}

	public String l() {
		return this.w;
	}

}
