package net.minecraft;

public class aob {

	private String[][] a = new String[][] { { "XXX", "X X" }, { "X X", "XXX", "XXX" }, { "XXX", "X X", "X X" }, { "X X", "X X" } };
	private alq[][] b;

	public aob() {
		this.b = new alq[][] { { amk.aF, amk.j, amk.i, amk.k }, { amk.Q, amk.Y, amk.ac, amk.ag }, { amk.R, amk.Z, amk.ad, amk.ah }, { amk.S, amk.aa, amk.ae, amk.ai }, { amk.T, amk.ab, amk.af, amk.aj } };
	}

	public void a(aop var1) {
		for (int var2 = 0; var2 < this.b[0].length; ++var2) {
			alq var3 = this.b[0][var2];

			for (int var4 = 0; var4 < this.b.length - 1; ++var4) {
				alq var5 = this.b[var4 + 1][var2];
				var1.a(new amj(var5), new Object[] { this.a[var4], Character.valueOf('X'), var3 });
			}
		}

	}
}
