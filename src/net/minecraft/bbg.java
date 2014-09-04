package net.minecraft;

public enum bbg implements va {

	a("STONE", 0, 0, "stone"), b("SAND", 1, 1, "sandstone", "sand"), c("WOOD", 2, 2, "wood_old", "wood"), d("COBBLESTONE", 3, 3, "cobblestone", "cobble"), e("BRICK", 4, 4, "brick"), f("SMOOTHBRICK", 5, 5, "stone_brick", "smoothStoneBrick"), g("NETHERBRICK", 6, 6, "nether_brick", "netherBrick"), h("QUARTZ", 7, 7, "quartz");
	private static final bbg[] i = new bbg[values().length];
	private final int j;
	private final String k;
	private final String l;
	// $FF: synthetic field
	private static final bbg[] m = new bbg[] { a, b, c, d, e, f, g, h };

	private bbg(String var1, int var2, int var3, String var4) {
		this(var1, var2, var3, var4, var4);
	}

	private bbg(String var1, int var2, int var3, String var4, String var5) {
		this.j = var3;
		this.k = var4;
		this.l = var5;
	}

	public int a() {
		return this.j;
	}

	public String toString() {
		return this.k;
	}

	public static bbg a(int var0) {
		if (var0 < 0 || var0 >= i.length) {
			var0 = 0;
		}

		return i[var0];
	}

	public String l() {
		return this.k;
	}

	public String c() {
		return this.l;
	}

	static {
		bbg[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			bbg var3 = var0[var2];
			i[var3.a()] = var3;
		}

	}
}
