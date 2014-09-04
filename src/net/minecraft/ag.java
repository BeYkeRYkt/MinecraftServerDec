package net.minecraft;

public enum ag {

	a("SUCCESS_COUNT", 0, 0, "SuccessCount"), b("AFFECTED_BLOCKS", 1, 1, "AffectedBlocks"), c("AFFECTED_ENTITIES", 2, 2, "AffectedEntities"), d("AFFECTED_ITEMS", 3, 3, "AffectedItems"), e("QUERY_RESULT", 4, 4, "QueryResult");
	final int f;
	final String g;
	// $FF: synthetic field
	private static final ag[] h = new ag[] { a, b, c, d, e };

	private ag(String var1, int var2, int var3, String var4) {
		this.f = var3;
		this.g = var4;
	}

	public int a() {
		return this.f;
	}

	public String b() {
		return this.g;
	}

	public static String[] c() {
		String[] var0 = new String[values().length];
		int var1 = 0;
		ag[] var2 = values();
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			ag var5 = var2[var4];
			var0[var1++] = var5.b();
		}

		return var0;
	}

	public static ag a(String var0) {
		ag[] var1 = values();
		int var2 = var1.length;

		for (int var3 = 0; var3 < var2; ++var3) {
			ag var4 = var1[var3];
			if (var4.b().equals(var0)) {
				return var4;
			}
		}

		return null;
	}

}
