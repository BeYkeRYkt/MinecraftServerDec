package net.minecraft;

public enum ahg {

	a("FULL", 0, 0, "options.chat.visibility.full"), b("SYSTEM", 1, 1, "options.chat.visibility.system"), c("HIDDEN", 2, 2, "options.chat.visibility.hidden");
	private static final ahg[] d = new ahg[values().length];
	private final int e;
	private final String f;
	// $FF: synthetic field
	private static final ahg[] g = new ahg[] { a, b, c };

	private ahg(String var1, int var2, int var3, String var4) {
		this.e = var3;
		this.f = var4;
	}

	public int a() {
		return this.e;
	}

	public static ahg a(int var0) {
		return d[var0 % d.length];
	}

	static {
		ahg[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			ahg var3 = var0[var2];
			d[var3.e] = var3;
		}

	}
}
