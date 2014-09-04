package net.minecraft;

public enum bbd implements va {

	a("DEFAULT", 0, 0, "stonebrick", "default"), b("MOSSY", 1, 1, "mossy_stonebrick", "mossy"), c("CRACKED", 2, 2, "cracked_stonebrick", "cracked"), d("CHISELED", 3, 3, "chiseled_stonebrick", "chiseled");
	private static final bbd[] e = new bbd[values().length];
	private final int f;
	private final String g;
	private final String h;
	// $FF: synthetic field
	private static final bbd[] i = new bbd[] { a, b, c, d };

	private bbd(String var1, int var2, int var3, String var4, String var5) {
		this.f = var3;
		this.g = var4;
		this.h = var5;
	}

	public int a() {
		return this.f;
	}

	public String toString() {
		return this.g;
	}

	public static bbd a(int var0) {
		if (var0 < 0 || var0 >= e.length) {
			var0 = 0;
		}

		return e[var0];
	}

	public String l() {
		return this.g;
	}

	public String c() {
		return this.h;
	}

	static {
		bbd[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			bbd var3 = var0[var2];
			e[var3.a()] = var3;
		}

	}
}
