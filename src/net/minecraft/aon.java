package net.minecraft;

public class aon {

	private Object[][] a;

	public aon() {
		this.a = new Object[][] { { aty.R, new ItemStack(amk.k, 9) }, { aty.S, new ItemStack(amk.j, 9) }, { aty.ah, new ItemStack(amk.i, 9) }, { aty.bT, new ItemStack(amk.bO, 9) }, { aty.y, new ItemStack(amk.aW, 9, akv.l.b()) }, { aty.cn, new ItemStack(amk.aC, 9) }, { aty.cA, new ItemStack(amk.h, 9, 0) }, { aty.cx, new ItemStack(amk.O, 9) }, { aty.cE, new ItemStack(amk.aM, 9) } };
	}

	public void a(aop var1) {
		for (int var2 = 0; var2 < this.a.length; ++var2) {
			Block var3 = (Block) this.a[var2][0];
			ItemStack var4 = (ItemStack) this.a[var2][1];
			var1.a(new ItemStack(var3), new Object[] { "###", "###", "###", Character.valueOf('#'), var4 });
			var1.a(var4, new Object[] { "#", Character.valueOf('#'), var3 });
		}

		var1.a(new ItemStack(amk.k), new Object[] { "###", "###", "###", Character.valueOf('#'), amk.bx });
		var1.a(new ItemStack(amk.bx, 9), new Object[] { "#", Character.valueOf('#'), amk.k });
	}
}
