package net.minecraft;

public enum aym implements va {

	a("RED_SANDSTONE", 0, 0, "red_sandstone");
	private static final aym[] b = new aym[values().length];
	private final int c;
	private final String d;
	// $FF: synthetic field
	private static final aym[] e = new aym[] { a };

	private aym(String var1, int var2, int var3, String var4) {
		this.c = var3;
		this.d = var4;
	}

	public int a() {
		return this.c;
	}

	public String toString() {
		return this.d;
	}

	public static aym a(int var0) {
		if (var0 < 0 || var0 >= b.length) {
			var0 = 0;
		}

		return b[var0];
	}

	public String l() {
		return this.d;
	}

	public String c() {
		return this.d;
	}

	static {
		aym[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			aym var3 = var0[var2];
			b[var3.a()] = var3;
		}

	}
}
