package net.minecraft;

import java.util.Random;

class aet extends zb {

	private aer a;

	public aet(aer var1) {
		this.a = var1;
	}

	public boolean a() {
		return !this.a.o.Q().b("mobGriefing") ? false : (this.a.ck().c().r() == bof.a ? false : this.a.bb().nextInt(2000) == 0);
	}

	public void e() {
		Random var1 = this.a.bb();
		World var2 = this.a.o;
		int var3 = NumberConverter.c(this.a.s - 1.0D + var1.nextDouble() * 2.0D);
		int var4 = NumberConverter.c(this.a.t + var1.nextDouble() * 2.0D);
		int var5 = NumberConverter.c(this.a.u - 1.0D + var1.nextDouble() * 2.0D);
		dt var6 = new dt(var3, var4, var5);
		atr var7 = var2.p(var6).c();
		atr var8 = var2.p(var6.b()).c();
		if (this.a(var2, var6, this.a.ck().c(), var7, var8)) {
			var2.a(var6, this.a.ck(), 3);
			this.a.a(aty.a.P());
		}

	}

	private boolean a(World var1, dt var2, atr var3, atr var4, atr var5) {
		return !var3.c(var1, var2) ? false : (var4.r() != bof.a ? false : (var5.r() == bof.a ? false : var5.d()));
	}
}
