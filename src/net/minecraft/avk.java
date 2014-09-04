package net.minecraft;

public enum avk implements va {

	a("SUNFLOWER", 0, 0, "sunflower"), b("SYRINGA", 1, 1, "syringa"), c("GRASS", 2, 2, "double_grass", "grass"), d("FERN", 3, 3, "double_fern", "fern"), e("ROSE", 4, 4, "double_rose", "rose"), f("PAEONIA", 5, 5, "paeonia");
	private static final avk[] g = new avk[values().length];
	private final int h;
	private final String i;
	private final String j;
	// $FF: synthetic field
	private static final avk[] k = new avk[] { a, b, c, d, e, f };

	private avk(String var1, int var2, int var3, String var4) {
		this(var1, var2, var3, var4, var4);
	}

	private avk(String var1, int var2, int var3, String var4, String var5) {
		this.h = var3;
		this.i = var4;
		this.j = var5;
	}

	public int a() {
		return this.h;
	}

	public String toString() {
		return this.i;
	}

	public static avk a(int var0) {
		if (var0 < 0 || var0 >= g.length) {
			var0 = 0;
		}

		return g[var0];
	}

	public String l() {
		return this.i;
	}

	public String c() {
		return this.j;
	}

	static {
		avk[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			avk var3 = var0[var2];
			g[var3.a()] = var3;
		}

	}
}
