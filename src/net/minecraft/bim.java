package net.minecraft;

import java.util.Random;

public class bim extends WorldGenerator {

	private Block a;

	public bim(Block var1) {
		this.a = var1;
	}

	public boolean b(World var1, Random var2, Position var3) {
		if (var1.d(var3) && var1.getBlockState(var3.b()).getBlock() == this.a) {
			int var4 = var2.nextInt(32) + 6;
			int var5 = var2.nextInt(4) + 1;

			int var6;
			int var7;
			int var8;
			int var9;
			for (var6 = var3.getX() - var5; var6 <= var3.getX() + var5; ++var6) {
				for (var7 = var3.getZ() - var5; var7 <= var3.getZ() + var5; ++var7) {
					var8 = var6 - var3.getX();
					var9 = var7 - var3.getZ();
					if (var8 * var8 + var9 * var9 <= var5 * var5 + 1 && var1.getBlockState(new Position(var6, var3.getY() - 1, var7)).getBlock() != this.a) {
						return false;
					}
				}
			}

			for (var6 = var3.getY(); var6 < var3.getY() + var4 && var6 < 256; ++var6) {
				for (var7 = var3.getX() - var5; var7 <= var3.getX() + var5; ++var7) {
					for (var8 = var3.getZ() - var5; var8 <= var3.getZ() + var5; ++var8) {
						var9 = var7 - var3.getX();
						int var10 = var8 - var3.getZ();
						if (var9 * var9 + var10 * var10 <= var5 * var5 + 1) {
							var1.a(new Position(var7, var6, var8), Blocks.OBSIDIAN.getBlockState(), 2);
						}
					}
				}
			}

			EntityEnderCrystal var11 = new EntityEnderCrystal(var1);
			var11.setPositionRotation((double) ((float) var3.getX() + 0.5F), (double) (var3.getY() + var4), (double) ((float) var3.getZ() + 0.5F), var2.nextFloat() * 360.0F, 0.0F);
			var1.d((Entity) var11);
			var1.a(var3.b(var4), Blocks.BEDROCK.getBlockState(), 2);
			return true;
		} else {
			return false;
		}
	}
}
