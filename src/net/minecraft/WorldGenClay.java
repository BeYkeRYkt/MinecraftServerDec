package net.minecraft;

import java.util.Random;

public class WorldGenClay extends WorldGenerator {

	private Block a;
	private int b;

	public WorldGenClay(int var1) {
		this.a = Blocks.CLAY;
		this.b = var1;
	}

	public boolean b(World var1, Random var2, Position var3) {
		if (var1.getBlockState(var3).getBlock().getMaterial() != Material.WATER) {
			return false;
		} else {
			int var4 = var2.nextInt(this.b - 2) + 2;
			byte var5 = 1;

			for (int var6 = var3.getX() - var4; var6 <= var3.getX() + var4; ++var6) {
				for (int var7 = var3.getZ() - var4; var7 <= var3.getZ() + var4; ++var7) {
					int var8 = var6 - var3.getX();
					int var9 = var7 - var3.getZ();
					if (var8 * var8 + var9 * var9 <= var4 * var4) {
						for (int var10 = var3.getY() - var5; var10 <= var3.getY() + var5; ++var10) {
							Position var11 = new Position(var6, var10, var7);
							Block var12 = var1.getBlockState(var11).getBlock();
							if (var12 == Blocks.DIRT || var12 == Blocks.CLAY) {
								var1.a(var11, this.a.getBlockState(), 2);
							}
						}
					}
				}
			}

			return true;
		}
	}
}
