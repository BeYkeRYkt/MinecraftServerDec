package net.minecraft;

public enum axo implements va {

	a("X", 0, "x"), b("Y", 1, "y"), c("Z", 2, "z"), d("NONE", 3, "none");
	private final String e;
	// $FF: synthetic field
	private static final axo[] f = new axo[] { a, b, c, d };

	private axo(String var1, int var2, String var3) {
		this.e = var3;
	}

	public String toString() {
		return this.e;
	}

	public static axo a(el var0) {
		switch (axn.a[var0.ordinal()]) {
			case 1:
				return a;
			case 2:
				return b;
			case 3:
				return c;
			default:
				return d;
		}
	}

	public String l() {
		return this.e;
	}

}
