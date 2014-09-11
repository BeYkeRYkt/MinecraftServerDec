package net.minecraft;

import java.util.Random;

public class WorldGenVines extends WorldGenerator {

	public boolean b(World var1, Random var2, Position var3) {
		for (; var3.getY() < 128; var3 = var3.a()) {
			if (var1.d(var3)) {
				BlockFace[] var4 = en.a.a();
				int var5 = var4.length;

				for (int var6 = 0; var6 < var5; ++var6) {
					BlockFace var7 = var4[var6];
					if (Blocks.VINE.a(var1, var3, var7)) {
						BlockState var8 = Blocks.VINE.getBlockState().a(BlockVine.b, Boolean.valueOf(var7 == BlockFace.NORTH)).a(BlockVine.M, Boolean.valueOf(var7 == BlockFace.EAST)).a(BlockVine.N, Boolean.valueOf(var7 == BlockFace.SOUTH)).a(BlockVine.O, Boolean.valueOf(var7 == BlockFace.WEST));
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
