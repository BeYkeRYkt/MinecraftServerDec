package net.minecraft;

public enum azj implements va {

	a("ROUGH", 0, 0, "prismarine", "rough"), b("BRICKS", 1, 1, "prismarine_bricks", "bricks"), c("DARK", 2, 2, "dark_prismarine", "dark");
	private static final azj[] d = new azj[values().length];
	private final int e;
	private final String f;
	private final String g;
	// $FF: synthetic field
	private static final azj[] h = new azj[] { a, b, c };

	private azj(String var1, int var2, int var3, String var4, String var5) {
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

	public static azj a(int var0) {
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
		azj[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			azj var3 = var0[var2];
			d[var3.a()] = var3;
		}

	}
}
