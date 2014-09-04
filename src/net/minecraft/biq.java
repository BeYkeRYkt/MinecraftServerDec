package net.minecraft;

import java.util.Random;

public class biq extends bhp {

	private final bec a;

	public biq(bbi var1) {
		this.a = aty.H.P().a(bbh.a, var1);
	}

	public boolean b(World var1, Random var2, dt var3) {
		atr var4;
		while (((var4 = var1.p(var3).c()).r() == bof.a || var4.r() == bof.j) && var3.o() > 0) {
			var3 = var3.b();
		}

		for (int var5 = 0; var5 < 128; ++var5) {
			dt var6 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
			if (var1.d(var6) && aty.H.f(var1, var6, this.a)) {
				var1.a(var6, this.a, 2);
			}
		}

		return true;
	}
}
