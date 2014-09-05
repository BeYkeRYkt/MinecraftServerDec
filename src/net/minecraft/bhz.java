package net.minecraft;

import java.util.Random;

public class bhz extends bhp {

	public boolean b(World var1, Random var2, Position var3) {
		if (!var1.d(var3)) {
			return false;
		} else if (var1.p(var3.a()).c() != aty.aV) {
			return false;
		} else {
			var1.a(var3, aty.aX.P(), 2);

			for (int var4 = 0; var4 < 1500; ++var4) {
				Position var5 = var3.a(var2.nextInt(8) - var2.nextInt(8), -var2.nextInt(12), var2.nextInt(8) - var2.nextInt(8));
				if (var1.p(var5).c().r() == bof.a) {
					int var6 = 0;
					PaintingDirection[] var7 = PaintingDirection.values();
					int var8 = var7.length;

					for (int var9 = 0; var9 < var8; ++var9) {
						PaintingDirection var10 = var7[var9];
						if (var1.p(var5.a(var10)).c() == aty.aX) {
							++var6;
						}

						if (var6 > 1) {
							break;
						}
					}

					if (var6 == 1) {
						var1.a(var5, aty.aX.P(), 2);
					}
				}
			}

			return true;
		}
	}
}
