package net.minecraft;

public enum lk {

	a("TITLE", 0), b("SUBTITLE", 1), c("TIMES", 2), d("CLEAR", 3), e("RESET", 4);
	// $FF: synthetic field
	private static final lk[] f = new lk[] { a, b, c, d, e };

	private lk(String var1, int var2) {
	}

	public static lk a(String var0) {
		lk[] var1 = values();
		int var2 = var1.length;

		for (int var3 = 0; var3 < var2; ++var3) {
			lk var4 = var1[var3];
			if (var4.name().equalsIgnoreCase(var0)) {
				return var4;
			}
		}

		return a;
	}

	public static String[] a() {
		String[] var0 = new String[values().length];
		int var1 = 0;
		lk[] var2 = values();
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			lk var5 = var2[var4];
			var0[var1++] = var5.name().toLowerCase();
		}

		return var0;
	}

}
