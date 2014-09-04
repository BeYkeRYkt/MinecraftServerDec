package net.minecraft;

import java.util.List;

public class bcb extends auc {

	protected bcb() {
		float var1 = 0.5F;
		float var2 = 0.015625F;
		this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, var2, 0.5F + var1);
		this.a(akf.c);
	}

	public void a(World var1, dt var2, bec var3, brt var4, List var5, Entity var6) {
		if (var6 == null || !(var6 instanceof adu)) {
			super.a(var1, var2, var3, var4, var5, var6);
		}

	}

	public brt a(World var1, dt var2, bec var3) {
		return new brt((double) var2.n() + this.B, (double) var2.o() + this.C, (double) var2.p() + this.D, (double) var2.n() + this.E, (double) var2.o() + this.F, (double) var2.p() + this.G);
	}

	protected boolean c(atr var1) {
		return var1 == aty.j;
	}

	public boolean f(World var1, dt var2, bec var3) {
		if (var2.o() >= 0 && var2.o() < 256) {
			bec var4 = var1.p(var2.b());
			return var4.c().r() == bof.h && ((Integer) var4.b(axl.b)).intValue() == 0;
		} else {
			return false;
		}
	}

	public int c(bec var1) {
		return 0;
	}
}
