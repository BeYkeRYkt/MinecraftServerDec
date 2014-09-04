package net.minecraft;

public abstract class yb implements xy {

	private final xy a;
	private final String b;
	private final double c;
	private boolean d;

	protected yb(xy var1, String var2, double var3) {
		this.a = var1;
		this.b = var2;
		this.c = var3;
		if (var2 == null) {
			throw new IllegalArgumentException("Name cannot be null!");
		}
	}

	public String a() {
		return this.b;
	}

	public double b() {
		return this.c;
	}

	public boolean c() {
		return this.d;
	}

	public yb a(boolean var1) {
		this.d = var1;
		return this;
	}

	public xy d() {
		return this.a;
	}

	public int hashCode() {
		return this.b.hashCode();
	}

	public boolean equals(Object var1) {
		return var1 instanceof xy && this.b.equals(((xy) var1).a());
	}
}
