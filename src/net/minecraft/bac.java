package net.minecraft;

public enum bac implements va {

	a("SAND", 0, 0, "sand", "default", MaterialMapColor.d), b("RED_SAND", 1, 1, "red_sand", "red", MaterialMapColor.l);
	private static final bac[] c = new bac[values().length];
	private final int d;
	private final String e;
	private final MaterialMapColor f;
	private final String g;
	// $FF: synthetic field
	private static final bac[] h = new bac[] { a, b };

	private bac(String var1, int var2, int var3, String var4, String var5, MaterialMapColor var6) {
		this.d = var3;
		this.e = var4;
		this.f = var6;
		this.g = var5;
	}

	public int a() {
		return this.d;
	}

	public String toString() {
		return this.e;
	}

	public MaterialMapColor c() {
		return this.f;
	}

	public static bac a(int var0) {
		if (var0 < 0 || var0 >= c.length) {
			var0 = 0;
		}

		return c[var0];
	}

	public String l() {
		return this.e;
	}

	public String d() {
		return this.g;
	}

	static {
		bac[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			bac var3 = var0[var2];
			c[var3.a()] = var3;
		}

	}
}
