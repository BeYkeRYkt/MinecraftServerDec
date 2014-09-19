package net.minecraft;

import java.util.Random;

public class WorldGenTaiga1 extends WorldGenTreeAbstract {

	public WorldGenTaiga1() {
		super(false);
	}

	public boolean b(World var1, Random var2, Position var3) {
		int var4 = var2.nextInt(5) + 7;
		int var5 = var4 - var2.nextInt(2) - 3;
		int var6 = var4 - var5;
		int var7 = 1 + var2.nextInt(var6 + 1);
		boolean var8 = true;
		if (var3.getY() >= 1 && var3.getY() + var4 + 1 <= 256) {
			int var11;
			int var12;
			int var18;
			for (int var9 = var3.getY(); var9 <= var3.getY() + 1 + var4 && var8; ++var9) {
				boolean var10 = true;
				if (var9 - var3.getY() < var5) {
					var18 = 0;
				} else {
					var18 = var7;
				}

				for (var11 = var3.getX() - var18; var11 <= var3.getX() + var18 && var8; ++var11) {
					for (var12 = var3.getZ() - var18; var12 <= var3.getZ() + var18 && var8; ++var12) {
						if (var9 >= 0 && var9 < 256) {
							if (!this.a(var1.getBlockState(new Position(var11, var9, var12)).getBlock())) {
								var8 = false;
							}
						} else {
							var8 = false;
						}
					}
				}
			}

			if (!var8) {
				return false;
			} else {
				Block var17 = var1.getBlockState(var3.getDown()).getBlock();
				if ((var17 == Blocks.GRASS || var17 == Blocks.DIRT) && var3.getY() < 256 - var4 - 1) {
					this.a(var1, var3.getDown());
					var18 = 0;

					for (var11 = var3.getY() + var4; var11 >= var3.getY() + var5; --var11) {
						for (var12 = var3.getX() - var18; var12 <= var3.getX() + var18; ++var12) {
							int var13 = var12 - var3.getX();

							for (int var14 = var3.getZ() - var18; var14 <= var3.getZ() + var18; ++var14) {
								int var15 = var14 - var3.getZ();
								if (Math.abs(var13) != var18 || Math.abs(var15) != var18 || var18 <= 0) {
									Position var16 = new Position(var12, var11, var14);
									if (!var1.getBlockState(var16).getBlock().m()) {
										this.a(var1, var16, Blocks.LEAVES, EnumWoodType.b.a());
									}
								}
							}
						}

						if (var18 >= 1 && var11 == var3.getY() + var5 + 1) {
							--var18;
						} else if (var18 < var7) {
							++var18;
						}
					}

					for (var11 = 0; var11 < var4 - 1; ++var11) {
						Block var19 = var1.getBlockState(var3.b(var11)).getBlock();
						if (var19.getMaterial() == Material.AIR || var19.getMaterial() == Material.LEAVES) {
							this.a(var1, var3.b(var11), Blocks.LOG, EnumWoodType.b.a());
						}
					}

					return true;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
	}
}
