package net.minecraft;

public enum EnumWoodType implements va {

	a("OAK", 0, 0, "oak"), b("SPRUCE", 1, 1, "spruce"), c("BIRCH", 2, 2, "birch"), d("JUNGLE", 3, 3, "jungle"), e("ACACIA", 4, 4, "acacia"), f("DARK_OAK", 5, 5, "dark_oak", "big_oak");
	private static final EnumWoodType[] g = new EnumWoodType[values().length];
	private final int h;
	private final String i;
	private final String j;
	// $FF: synthetic field
	private static final EnumWoodType[] k = new EnumWoodType[] { a, b, c, d, e, f };

	private EnumWoodType(String var1, int var2, int var3, String var4) {
		this(var1, var2, var3, var4, var4);
	}

	private EnumWoodType(String var1, int var2, int var3, String var4, String var5) {
		this.h = var3;
		this.i = var4;
		this.j = var5;
	}

	public int a() {
		return this.h;
	}

	public String toString() {
		return this.i;
	}

	public static EnumWoodType a(int var0) {
		if (var0 < 0 || var0 >= g.length) {
			var0 = 0;
		}

		return g[var0];
	}

	public String l() {
		return this.i;
	}

	public String c() {
		return this.j;
	}

	static {
		EnumWoodType[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			EnumWoodType var3 = var0[var2];
			g[var3.a()] = var3;
		}

	}
}
