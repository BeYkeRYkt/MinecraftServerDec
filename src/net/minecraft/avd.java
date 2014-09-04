package net.minecraft;

public enum avd implements va {

	a("DIRT", 0, 0, "dirt", "default"), b("COARSE_DIRT", 1, 1, "coarse_dirt", "coarse"), c("PODZOL", 2, 2, "podzol");
	private static final avd[] d = new avd[values().length];
	private final int e;
	private final String f;
	private final String g;
	// $FF: synthetic field
	private static final avd[] h = new avd[] { a, b, c };

	private avd(String var1, int var2, int var3, String var4) {
		this(var1, var2, var3, var4, var4);
	}

	private avd(String var1, int var2, int var3, String var4, String var5) {
		this.e = var3;
		this.f = var4;
		this.g = var5;
	}

	public int a() {
		return this.e;
	}

	public String c() {
		return this.g;
	}

	public String toString() {
		return this.f;
	}

	public static avd a(int var0) {
		if (var0 < 0 || var0 >= d.length) {
			var0 = 0;
		}

		return d[var0];
	}

	public String l() {
		return this.f;
	}

	static {
		avd[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			avd var3 = var0[var2];
			d[var3.a()] = var3;
		}

	}
}
