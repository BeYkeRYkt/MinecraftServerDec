package net.minecraft;

import java.util.Random;

public class WorldGenLightStone1 extends WorldGenerator {

	public boolean b(World var1, Random var2, Position var3) {
		if (!var1.d(var3)) {
			return false;
		} else if (var1.getBlockState(var3.getUp()).getBlock() != Blocks.NETHERRACK) {
			return false;
		} else {
			var1.setBlockAt(var3, Blocks.GLOWSTONE.getBlockState(), 2);

			for (int var4 = 0; var4 < 1500; ++var4) {
				Position var5 = var3.a(var2.nextInt(8) - var2.nextInt(8), -var2.nextInt(12), var2.nextInt(8) - var2.nextInt(8));
				if (var1.getBlockState(var5).getBlock().getMaterial() == Material.AIR) {
					int var6 = 0;
					BlockFace[] var7 = BlockFace.values();
					int var8 = var7.length;

					for (int var9 = 0; var9 < var8; ++var9) {
						BlockFace var10 = var7[var9];
						if (var1.getBlockState(var5.getRelative(var10)).getBlock() == Blocks.GLOWSTONE) {
							++var6;
						}

						if (var6 > 1) {
							break;
						}
					}

					if (var6 == 1) {
						var1.setBlockAt(var5, Blocks.GLOWSTONE.getBlockState(), 2);
					}
				}
			}

			return true;
		}
	}
}
