package net.minecraft;

import java.util.Random;

public class bis extends bhp {

	public boolean b(World var1, Random var2, Position var3) {
		for (; var3.o() < 128; var3 = var3.a()) {
			if (var1.d(var3)) {
				PaintingDirection[] var4 = en.a.a();
				int var5 = var4.length;

				for (int var6 = 0; var6 < var5; ++var6) {
					PaintingDirection var7 = var4[var6];
					if (aty.bn.a(var1, var3, var7)) {
						bec var8 = aty.bn.P().a(bbv.b, Boolean.valueOf(var7 == PaintingDirection.c)).a(bbv.M, Boolean.valueOf(var7 == PaintingDirection.f)).a(bbv.N, Boolean.valueOf(var7 == PaintingDirection.d)).a(bbv.O, Boolean.valueOf(var7 == PaintingDirection.e));
						var1.a(var3, var8, 2);
						break;
					}
				}
			} else {
				var3 = var3.a(var2.nextInt(4) - var2.nextInt(4), 0, var2.nextInt(4) - var2.nextInt(4));
			}
		}

		return true;
	}
}
