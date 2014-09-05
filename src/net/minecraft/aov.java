package net.minecraft;

public class aov {

	private String[][] a = new String[][] { { "XXX", " # ", " # " }, { "X", "#", "#" }, { "XX", "X#", " #" }, { "XX", " #", " #" } };
	private Object[][] b;

	public aov() {
		this.b = new Object[][] { { aty.f, aty.e, amk.j, amk.i, amk.k }, { amk.o, amk.s, amk.b, amk.w, amk.D }, { amk.n, amk.r, amk.a, amk.v, amk.C }, { amk.p, amk.t, amk.c, amk.x, amk.E }, { amk.I, amk.J, amk.K, amk.L, amk.M } };
	}

	public void a(aop var1) {
		for (int var2 = 0; var2 < this.b[0].length; ++var2) {
			Object var3 = this.b[0][var2];

			for (int var4 = 0; var4 < this.b.length - 1; ++var4) {
				Item var5 = (Item) this.b[var4 + 1][var2];
				var1.a(new ItemStack(var5), new Object[] { this.a[var4], Character.valueOf('#'), amk.y, Character.valueOf('X'), var3 });
			}
		}

		var1.a(new ItemStack(amk.be), new Object[] { " #", "# ", Character.valueOf('#'), amk.j });
	}
}
