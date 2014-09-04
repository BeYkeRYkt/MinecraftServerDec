package net.minecraft;

enum azu implements va {

	a("UP", 0, "up"), b("SIDE", 1, "side"), c("NONE", 2, "none");
	private final String d;
	// $FF: synthetic field
	private static final azu[] e = new azu[] { a, b, c };

	private azu(String var1, int var2, String var3) {
		this.d = var3;
	}

	public String toString() {
		return this.l();
	}

	public String l() {
		return this.d;
	}

}
