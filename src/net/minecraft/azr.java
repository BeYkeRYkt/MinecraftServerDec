package net.minecraft;

public enum azr implements va {

	a("DEFAULT", 0, 0, "red_sandstone", "default"), b("CHISELED", 1, 1, "chiseled_red_sandstone", "chiseled"), c("SMOOTH", 2, 2, "smooth_red_sandstone", "smooth");
	private static final azr[] d = new azr[values().length];
	private final int e;
	private final String f;
	private final String g;
	// $FF: synthetic field
	private static final azr[] h = new azr[] { a, b, c };

	private azr(String var1, int var2, int var3, String var4, String var5) {
		this.e = var3;
		this.f = var4;
		this.g = var5;
	}

	public int a() {
		return this.e;
	}

	public String toString() {
		return this.f;
	}

	public static azr a(int var0) {
		if (var0 < 0 || var0 >= d.length) {
			var0 = 0;
		}

		return d[var0];
	}

	public String l() {
		return this.f;
	}

	public String c() {
		return this.g;
	}

	static {
		azr[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			azr var3 = var0[var2];
			d[var3.a()] = var3;
		}

	}
}
