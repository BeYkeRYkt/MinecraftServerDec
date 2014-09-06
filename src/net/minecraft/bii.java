package net.minecraft;

import java.util.Random;

public class bii extends bhp {

	public boolean b(World var1, Random var2, Position var3) {
		for (int var4 = 0; var4 < 20; ++var4) {
			Position var5 = var3.a(var2.nextInt(4) - var2.nextInt(4), 0, var2.nextInt(4) - var2.nextInt(4));
			if (var1.d(var5)) {
				Position var6 = var5.b();
				if (var1.p(var6.e()).getBlock().r() == Material.WATER || var1.p(var6.f()).getBlock().r() == Material.WATER || var1.p(var6.c()).getBlock().r() == Material.WATER || var1.p(var6.d()).getBlock().r() == Material.WATER) {
					int var7 = 2 + var2.nextInt(var2.nextInt(3) + 1);

					for (int var8 = 0; var8 < var7; ++var8) {
						if (Blocks.aM.d(var1, var5)) {
							var1.a(var5.b(var8), Blocks.aM.P(), 2);
						}
					}
				}
			}
		}

		return true;
	}
}
