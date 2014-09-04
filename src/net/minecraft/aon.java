package net.minecraft;

public class aon {

	private Object[][] a;

	public aon() {
		this.a = new Object[][] { { aty.R, new amj(amk.k, 9) }, { aty.S, new amj(amk.j, 9) }, { aty.ah, new amj(amk.i, 9) }, { aty.bT, new amj(amk.bO, 9) }, { aty.y, new amj(amk.aW, 9, akv.l.b()) }, { aty.cn, new amj(amk.aC, 9) }, { aty.cA, new amj(amk.h, 9, 0) }, { aty.cx, new amj(amk.O, 9) }, { aty.cE, new amj(amk.aM, 9) } };
	}

	public void a(aop var1) {
		for (int var2 = 0; var2 < this.a.length; ++var2) {
			atr var3 = (atr) this.a[var2][0];
			amj var4 = (amj) this.a[var2][1];
			var1.a(new amj(var3), new Object[] { "###", "###", "###", Character.valueOf('#'), var4 });
			var1.a(var4, new Object[] { "#", Character.valueOf('#'), var3 });
		}

		var1.a(new amj(amk.k), new Object[] { "###", "###", "###", Character.valueOf('#'), amk.bx });
		var1.a(new amj(amk.bx, 9), new Object[] { "#", Character.valueOf('#'), amk.k });
	}
}
