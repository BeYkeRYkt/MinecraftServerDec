package net.minecraft;

import java.util.Random;

public class WorldGenReed extends WorldGenerator {

	public boolean b(World var1, Random var2, Position var3) {
		for (int var4 = 0; var4 < 20; ++var4) {
			Position var5 = var3.a(var2.nextInt(4) - var2.nextInt(4), 0, var2.nextInt(4) - var2.nextInt(4));
			if (var1.d(var5)) {
				Position var6 = var5.getDown();
				if (var1.getBlockState(var6.e()).getBlock().getMaterial() == Material.WATER || var1.getBlockState(var6.f()).getBlock().getMaterial() == Material.WATER || var1.getBlockState(var6.c()).getBlock().getMaterial() == Material.WATER || var1.getBlockState(var6.d()).getBlock().getMaterial() == Material.WATER) {
					int var7 = 2 + var2.nextInt(var2.nextInt(3) + 1);

					for (int var8 = 0; var8 < var7; ++var8) {
						if (Blocks.REEDS.d(var1, var5)) {
							var1.setBlockAt(var5.b(var8), Blocks.REEDS.getBlockState(), 2);
						}
					}
				}
			}
		}

		return true;
	}
}
