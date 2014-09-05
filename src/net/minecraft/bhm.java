package net.minecraft;

import java.util.Random;

public class bhm extends bhp {

	public boolean b(World var1, Random var2, Position var3) {
		Block var4;
		while (((var4 = var1.p(var3).c()).r() == bof.a || var4.r() == bof.j) && var3.o() > 0) {
			var3 = var3.b();
		}

		for (int var5 = 0; var5 < 4; ++var5) {
			Position var6 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
			if (var1.d(var6) && aty.I.f(var1, var6, aty.I.P())) {
				var1.a(var6, aty.I.P(), 2);
			}
		}

		return true;
	}
}
