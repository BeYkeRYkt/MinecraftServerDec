package net.minecraft;

import java.util.Random;

public class WorldGenCactus extends WorldGenerator {

	public boolean b(World var1, Random var2, Position var3) {
		for (int var4 = 0; var4 < 10; ++var4) {
			Position var5 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
			if (var1.d(var5)) {
				int var6 = 1 + var2.nextInt(var2.nextInt(3) + 1);

				for (int var7 = 0; var7 < var6; ++var7) {
					if (Blocks.CACTUS.d(var1, var5)) {
						var1.a(var5.b(var7), Blocks.CACTUS.getBlockState(), 2);
					}
				}
			}
		}

		return true;
	}
}
