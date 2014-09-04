package net.minecraft;

public enum avh implements va {

	a("LEFT", 0), b("RIGHT", 1);
	// $FF: synthetic field
	private static final avh[] c = new avh[] { a, b };

	private avh(String var1, int var2) {
	}

	public String toString() {
		return this.l();
	}

	public String l() {
		return this == a ? "left" : "right";
	}

}
