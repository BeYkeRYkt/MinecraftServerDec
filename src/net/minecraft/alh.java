package net.minecraft;

public class alh extends all {

	private final boolean b;

	public alh(boolean var1) {
		super(0, 0.0F, false);
		this.b = var1;
	}

	public int h(amj var1) {
		ali var2 = ali.a(var1);
		return this.b && var2.g() ? var2.e() : var2.c();
	}

	public float i(amj var1) {
		ali var2 = ali.a(var1);
		return this.b && var2.g() ? var2.f() : var2.d();
	}

	public String j(amj var1) {
		return ali.a(var1) == ali.d ? ans.m : null;
	}

	protected void c(amj var1, World var2, ahd var3) {
		ali var4 = ali.a(var1);
		if (var4 == ali.d) {
			var3.c(new wq(wp.u.H, 1200, 3));
			var3.c(new wq(wp.s.H, 300, 2));
			var3.c(new wq(wp.k.H, 300, 1));
		}

		super.c(var1, var2, var3);
	}

	public String e_(amj var1) {
		ali var2 = ali.a(var1);
		return this.a() + "." + var2.b() + "." + (this.b && var2.g() ? "cooked" : "raw");
	}
}
