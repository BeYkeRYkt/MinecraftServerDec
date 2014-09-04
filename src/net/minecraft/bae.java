package net.minecraft;

public enum bae implements va {

	a("DEFAULT", 0, 0, "sandstone", "default"), b("CHISELED", 1, 1, "chiseled_sandstone", "chiseled"), c("SMOOTH", 2, 2, "smooth_sandstone", "smooth");
	private static final bae[] d = new bae[values().length];
	private final int e;
	private final String f;
	private final String g;
	// $FF: synthetic field
	private static final bae[] h = new bae[] { a, b, c };

	private bae(String var1, int var2, int var3, String var4, String var5) {
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

	public static bae a(int var0) {
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
		bae[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			bae var3 = var0[var2];
			d[var3.a()] = var3;
		}

	}
}
