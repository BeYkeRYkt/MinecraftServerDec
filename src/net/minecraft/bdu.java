package net.minecraft;

public enum bdu implements va {

	a("DEFAULT", 0, "normal"), b("STICKY", 1, "sticky");
	private final String c;
	// $FF: synthetic field
	private static final bdu[] d = new bdu[] { a, b };

	private bdu(String var1, int var2, String var3) {
		this.c = var3;
	}

	public String toString() {
		return this.c;
	}

	public String l() {
		return this.c;
	}

}
