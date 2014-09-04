package net.minecraft;

public enum azn implements va {

	a("DEFAULT", 0, 0, "default", "default"), b("CHISELED", 1, 1, "chiseled", "chiseled"), c("LINES_Y", 2, 2, "lines_y", "lines"), d("LINES_X", 3, 3, "lines_x", "lines"), e("LINES_Z", 4, 4, "lines_z", "lines");
	private static final azn[] f = new azn[values().length];
	private final int g;
	private final String h;
	private final String i;
	// $FF: synthetic field
	private static final azn[] j = new azn[] { a, b, c, d, e };

	private azn(String var1, int var2, int var3, String var4, String var5) {
		this.g = var3;
		this.h = var4;
		this.i = var5;
	}

	public int a() {
		return this.g;
	}

	public String toString() {
		return this.i;
	}

	public static azn a(int var0) {
		if (var0 < 0 || var0 >= f.length) {
			var0 = 0;
		}

		return f[var0];
	}

	public String l() {
		return this.h;
	}

	static {
		azn[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			azn var3 = var0[var2];
			f[var3.a()] = var3;
		}

	}
}
