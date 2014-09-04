package net.minecraft;

public enum avg implements va {

	a("UPPER", 0), b("LOWER", 1);
	// $FF: synthetic field
	private static final avg[] c = new avg[] { a, b };

	private avg(String var1, int var2) {
	}

	public String toString() {
		return this.l();
	}

	public String l() {
		return this == a ? "upper" : "lower";
	}

}
