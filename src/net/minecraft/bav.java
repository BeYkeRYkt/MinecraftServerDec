package net.minecraft;

public enum bav implements va {

	a("STRAIGHT", 0, "straight"), b("INNER_LEFT", 1, "inner_left"), c("INNER_RIGHT", 2, "inner_right"), d("OUTER_LEFT", 3, "outer_left"), e("OUTER_RIGHT", 4, "outer_right");
	private final String f;
	// $FF: synthetic field
	private static final bav[] g = new bav[] { a, b, c, d, e };

	private bav(String var1, int var2, String var3) {
		this.f = var3;
	}

	public String toString() {
		return this.f;
	}

	public String l() {
		return this.f;
	}

}
