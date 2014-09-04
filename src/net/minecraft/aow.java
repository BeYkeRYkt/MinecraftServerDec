package net.minecraft;

public class aow {

	private String[][] a = new String[][] { { "X", "X", "#" } };
	private Object[][] b;

	public aow() {
		this.b = new Object[][] { { aty.f, aty.e, amk.j, amk.i, amk.k }, { amk.m, amk.q, amk.l, amk.u, amk.B } };
	}

	public void a(aop var1) {
		for (int var2 = 0; var2 < this.b[0].length; ++var2) {
			Object var3 = this.b[0][var2];

			for (int var4 = 0; var4 < this.b.length - 1; ++var4) {
				alq var5 = (alq) this.b[var4 + 1][var2];
				var1.a(new amj(var5), new Object[] { this.a[var4], Character.valueOf('#'), amk.y, Character.valueOf('X'), var3 });
			}
		}

		var1.a(new amj(amk.f, 1), new Object[] { " #X", "# X", " #X", Character.valueOf('X'), amk.F, Character.valueOf('#'), amk.y });
		var1.a(new amj(amk.g, 4), new Object[] { "X", "#", "Y", Character.valueOf('Y'), amk.G, Character.valueOf('X'), amk.ak, Character.valueOf('#'), amk.y });
	}
}
