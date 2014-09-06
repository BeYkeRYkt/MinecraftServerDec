package net.minecraft;

public enum bcj {

	a("BASE", 0, "base", "b"), b("SQUARE_BOTTOM_LEFT", 1, "square_bottom_left", "bl", "   ", "   ", "#  "), c("SQUARE_BOTTOM_RIGHT", 2, "square_bottom_right", "br", "   ", "   ", "  #"), d("SQUARE_TOP_LEFT", 3, "square_top_left", "tl", "#  ", "   ", "   "), e("SQUARE_TOP_RIGHT", 4, "square_top_right", "tr", "  #", "   ", "   "), f("STRIPE_BOTTOM", 5, "stripe_bottom", "bs", "   ", "   ", "###"), g("STRIPE_TOP", 6, "stripe_top", "ts", "###", "   ", "   "), h("STRIPE_LEFT", 7, "stripe_left", "ls",
			"#  ", "#  ", "#  "), i("STRIPE_RIGHT", 8, "stripe_right", "rs", "  #", "  #", "  #"), j("STRIPE_CENTER", 9, "stripe_center", "cs", " # ", " # ", " # "), k("STRIPE_MIDDLE", 10, "stripe_middle", "ms", "   ", "###", "   "), l("STRIPE_DOWNRIGHT", 11, "stripe_downright", "drs", "#  ", " # ", "  #"), m("STRIPE_DOWNLEFT", 12, "stripe_downleft", "dls", "  #", " # ", "#  "), n("STRIPE_SMALL", 13, "small_stripes", "ss", "# #", "# #", "   "), o("CROSS", 14, "cross", "cr", "# #", " # ", "# #"), p(
			"STRAIGHT_CROSS", 15, "straight_cross", "sc", " # ", "###", " # "), q("TRIANGLE_BOTTOM", 16, "triangle_bottom", "bt", "   ", " # ", "# #"), r("TRIANGLE_TOP", 17, "triangle_top", "tt", "# #", " # ", "   "), s("TRIANGLES_BOTTOM", 18, "triangles_bottom", "bts", "   ", "# #", " # "), t("TRIANGLES_TOP", 19, "triangles_top", "tts", " # ", "# #", "   "), u("DIAGONAL_LEFT", 20, "diagonal_left", "ld", "## ", "#  ", "   "), v("DIAGONAL_RIGHT", 21, "diagonal_up_right", "rd", "   ", "  #",
			" ##"), w("DIAGONAL_LEFT_MIRROR", 22, "diagonal_up_left", "lud", "   ", "#  ", "## "), x("DIAGONAL_RIGHT_MIRROR", 23, "diagonal_right", "rud", " ##", "  #", "   "), y("CIRCLE_MIDDLE", 24, "circle", "mc", "   ", " # ", "   "), z("RHOMBUS_MIDDLE", 25, "rhombus", "mr", " # ", "# #", " # "), A("HALF_VERTICAL", 26, "half_vertical", "vh", "## ", "## ", "## "), B("HALF_HORIZONTAL", 27, "half_horizontal", "hh", "###", "###", "   "), C("HALF_VERTICAL_MIRROR", 28, "half_vertical_right",
			"vhr", " ##", " ##", " ##"), D("HALF_HORIZONTAL_MIRROR", 29, "half_horizontal_bottom", "hhb", "   ", "###", "###"), E("BORDER", 30, "border", "bo", "###", "# #", "###"), F("CURLY_BORDER", 31, "curly_border", "cbo", new ItemStack(Blocks.VINE)), G("CREEPER", 32, "creeper", "cre", new ItemStack(Items.bX, 1, 4)), H("GRADIENT", 33, "gradient", "gra", "# #", " # ", " # "), I("GRADIENT_UP", 34, "gradient_up", "gru", " # ", " # ", "# #"), J("BRICKS", 35, "bricks", "bri", new ItemStack(Blocks.BRICK_BLOCK)), K("SKULL", 36,
			"skull", "sku", new ItemStack(Items.bX, 1, 1)), L("FLOWER", 37, "flower", "flo", new ItemStack(Blocks.RED_FLOWER, 1, awa.j.b())), M("MOJANG", 38, "mojang", "moj", new ItemStack(Items.ao, 1, 1));
	private String N;
	private String O;
	private String[] P;
	private ItemStack Q;
	// $FF: synthetic field
	private static final bcj[] R = new bcj[] { a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M };

	private bcj(String var1, int var2, String var3, String var4) {
		this.P = new String[3];
		this.N = var3;
		this.O = var4;
	}

	private bcj(String var1, int var2, String var3, String var4, ItemStack var5) {
		this(var1, var2, var3, var4);
		this.Q = var5;
	}

	private bcj(String var1, int var2, String var3, String var4, String var5, String var6, String var7) {
		this(var1, var2, var3, var4);
		this.P[0] = var5;
		this.P[1] = var6;
		this.P[2] = var7;
	}

	public String b() {
		return this.O;
	}

	public String[] c() {
		return this.P;
	}

	public boolean d() {
		return this.Q != null || this.P[0] != null;
	}

	public boolean e() {
		return this.Q != null;
	}

	public ItemStack f() {
		return this.Q;
	}

}
