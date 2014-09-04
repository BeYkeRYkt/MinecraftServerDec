package net.minecraft;

public enum bbb implements va {

	a("STONE", 0, 0, "stone"), b("GRANITE", 1, 1, "granite"), c("GRANITE_SMOOTH", 2, 2, "smooth_granite", "graniteSmooth"), d("DIORITE", 3, 3, "diorite"), e("DIORITE_SMOOTH", 4, 4, "smooth_diorite", "dioriteSmooth"), f("ANDESITE", 5, 5, "andesite"), g("ANDESITE_SMOOTH", 6, 6, "smooth_andesite", "andesiteSmooth");
	private static final bbb[] h = new bbb[values().length];
	private final int i;
	private final String j;
	private final String k;
	// $FF: synthetic field
	private static final bbb[] l = new bbb[] { a, b, c, d, e, f, g };

	private bbb(String var1, int var2, int var3, String var4) {
		this(var1, var2, var3, var4, var4);
	}

	private bbb(String var1, int var2, int var3, String var4, String var5) {
		this.i = var3;
		this.j = var4;
		this.k = var5;
	}

	public int a() {
		return this.i;
	}

	public String toString() {
		return this.j;
	}

	public static bbb a(int var0) {
		if (var0 < 0 || var0 >= h.length) {
			var0 = 0;
		}

		return h[var0];
	}

	public String l() {
		return this.j;
	}

	public String c() {
		return this.k;
	}

	static {
		bbb[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			bbb var3 = var0[var2];
			h[var3.a()] = var3;
		}

	}
}
