package net.minecraft;

public class bpx extends bpu {

	public void a(ard var1, Entity var2) {
		super.a(var1, var2);
	}

	public void a() {
		super.a();
	}

	public bpt a(Entity var1) {
		return this.a(NumberConverter.c(var1.aQ().a), NumberConverter.c(var1.aQ().b + 0.5D), NumberConverter.c(var1.aQ().c));
	}

	public bpt a(Entity var1, double var2, double var4, double var6) {
		return this.a(NumberConverter.c(var2 - (double) (var1.J / 2.0F)), NumberConverter.c(var4 + 0.5D), NumberConverter.c(var6 - (double) (var1.J / 2.0F)));
	}

	public int a(bpt[] var1, Entity var2, bpt var3, bpt var4, float var5) {
		int var6 = 0;
		ej[] var7 = ej.values();
		int var8 = var7.length;

		for (int var9 = 0; var9 < var8; ++var9) {
			ej var10 = var7[var9];
			bpt var11 = this.a(var2, var3.a + var10.g(), var3.b + var10.h(), var3.c + var10.i());
			if (var11 != null && !var11.i && var11.a(var4) < var5) {
				var1[var6++] = var11;
			}
		}

		return var6;
	}

	private bpt a(Entity var1, int var2, int var3, int var4) {
		int var5 = this.b(var1, var2, var3, var4);
		return var5 == -1 ? this.a(var2, var3, var4) : null;
	}

	private int b(Entity var1, int var2, int var3, int var4) {
		for (int var5 = var2; var5 < var2 + this.c; ++var5) {
			for (int var6 = var3; var6 < var3 + this.d; ++var6) {
				for (int var7 = var4; var7 < var4 + this.e; ++var7) {
					dt var8 = new dt(var5, var6, var7);
					atr var9 = this.a.p(var8).c();
					if (var9.r() != bof.h) {
						return 0;
					}
				}
			}
		}

		return -1;
	}
}
