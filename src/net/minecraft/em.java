package net.minecraft;

public enum em {

	a("POSITIVE", 0, 1, "Towards positive"), b("NEGATIVE", 1, -1, "Towards negative");
	private final int c;
	private final String d;
	// $FF: synthetic field
	private static final em[] e = new em[] { a, b };

	private em(String var1, int var2, int var3, String var4) {
		this.c = var3;
		this.d = var4;
	}

	public int a() {
		return this.c;
	}

	public String toString() {
		return this.d;
	}

}
