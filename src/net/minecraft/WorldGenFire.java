package net.minecraft;

import java.util.Random;

public class WorldGenFire extends WorldGenerator {

	public boolean b(World var1, Random var2, Position var3) {
		for (int var4 = 0; var4 < 64; ++var4) {
			Position var5 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
			if (var1.d(var5) && var1.getBlockState(var5.getDown()).getBlock() == Blocks.NETHERRACK) {
				var1.setBlockAt(var5, Blocks.FIRE.getBlockState(), 2);
			}
		}

		return true;
	}
}
