package net.minecraft;

public enum bby implements va {

	a("NORMAL", 0, 0, "cobblestone", "normal"), b("MOSSY", 1, 1, "mossy_cobblestone", "mossy");
	private static final bby[] c = new bby[values().length];
	private final int d;
	private final String e;
	private String f;
	// $FF: synthetic field
	private static final bby[] g = new bby[] { a, b };

	private bby(String var1, int var2, int var3, String var4, String var5) {
		this.d = var3;
		this.e = var4;
		this.f = var5;
	}

	public int a() {
		return this.d;
	}

	public String toString() {
		return this.e;
	}

	public static bby a(int var0) {
		if (var0 < 0 || var0 >= c.length) {
			var0 = 0;
		}

		return c[var0];
	}

	public String l() {
		return this.e;
	}

	public String c() {
		return this.f;
	}

	static {
		bby[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			bby var3 = var0[var2];
			c[var3.a()] = var3;
		}

	}
}
