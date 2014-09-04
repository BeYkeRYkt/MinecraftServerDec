package net.minecraft;

public final class ux implements Comparable {

	public double a;
	public double b;
	public String c;

	public ux(String var1, double var2, double var4) {
		this.c = var1;
		this.a = var2;
		this.b = var4;
	}

	public int a(ux var1) {
		return var1.a < this.a ? -1 : (var1.a > this.a ? 1 : var1.c.compareTo(this.c));
	}

	// $FF: synthetic method
	public int compareTo(Object var1) {
		return this.a((ux) var1);
	}
}
