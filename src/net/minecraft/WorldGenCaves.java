package net.minecraft;

import com.google.common.base.Objects;
import java.util.Random;

public class WorldGenCaves extends WorldGenBase {

	protected void a(long var1, int var3, int var4, bgk var5, double var6, double var8, double var10) {
		this.a(var1, var3, var4, var5, var6, var8, var10, 1.0F + this.b.nextFloat() * 6.0F, 0.0F, 0.0F, -1, -1, 0.5D);
	}

	protected void a(long var1, int var3, int var4, bgk var5, double var6, double var8, double var10, float var12, float var13, float var14, int var15, int var16, double var17) {
		double var19 = (double) (var3 * 16 + 8);
		double var21 = (double) (var4 * 16 + 8);
		float var23 = 0.0F;
		float var24 = 0.0F;
		Random var25 = new Random(var1);
		if (var16 <= 0) {
			int var26 = this.a * 16 - 16;
			var16 = var26 - var25.nextInt(var26 / 4);
		}

		boolean var54 = false;
		if (var15 == -1) {
			var15 = var16 / 2;
			var54 = true;
		}

		int var27 = var25.nextInt(var16 / 2) + var16 / 4;

		for (boolean var28 = var25.nextInt(6) == 0; var15 < var16; ++var15) {
			double var29 = 1.5D + (double) (MathHelper.a((float) var15 * 3.1415927F / (float) var16) * var12 * 1.0F);
			double var31 = var29 * var17;
			float var33 = MathHelper.b(var14);
			float var34 = MathHelper.a(var14);
			var6 += (double) (MathHelper.b(var13) * var33);
			var8 += (double) var34;
			var10 += (double) (MathHelper.a(var13) * var33);
			if (var28) {
				var14 *= 0.92F;
			} else {
				var14 *= 0.7F;
			}

			var14 += var24 * 0.1F;
			var13 += var23 * 0.1F;
			var24 *= 0.9F;
			var23 *= 0.75F;
			var24 += (var25.nextFloat() - var25.nextFloat()) * var25.nextFloat() * 2.0F;
			var23 += (var25.nextFloat() - var25.nextFloat()) * var25.nextFloat() * 4.0F;
			if (!var54 && var15 == var27 && var12 > 1.0F && var16 > 0) {
				this.a(var25.nextLong(), var3, var4, var5, var6, var8, var10, var25.nextFloat() * 0.5F + 0.5F, var13 - 1.5707964F, var14 / 3.0F, var15, var16, 1.0D);
				this.a(var25.nextLong(), var3, var4, var5, var6, var8, var10, var25.nextFloat() * 0.5F + 0.5F, var13 + 1.5707964F, var14 / 3.0F, var15, var16, 1.0D);
				return;
			}

			if (var54 || var25.nextInt(4) != 0) {
				double var35 = var6 - var19;
				double var37 = var10 - var21;
				double var39 = (double) (var16 - var15);
				double var41 = (double) (var12 + 2.0F + 16.0F);
				if (var35 * var35 + var37 * var37 - var39 * var39 > var41 * var41) {
					return;
				}

				if (var6 >= var19 - 16.0D - var29 * 2.0D && var10 >= var21 - 16.0D - var29 * 2.0D && var6 <= var19 + 16.0D + var29 * 2.0D && var10 <= var21 + 16.0D + var29 * 2.0D) {
					int var55 = MathHelper.toFixedPointInt(var6 - var29) - var3 * 16 - 1;
					int var36 = MathHelper.toFixedPointInt(var6 + var29) - var3 * 16 + 1;
					int var56 = MathHelper.toFixedPointInt(var8 - var31) - 1;
					int var38 = MathHelper.toFixedPointInt(var8 + var31) + 1;
					int var57 = MathHelper.toFixedPointInt(var10 - var29) - var4 * 16 - 1;
					int var40 = MathHelper.toFixedPointInt(var10 + var29) - var4 * 16 + 1;
					if (var55 < 0) {
						var55 = 0;
					}

					if (var36 > 16) {
						var36 = 16;
					}

					if (var56 < 1) {
						var56 = 1;
					}

					if (var38 > 248) {
						var38 = 248;
					}

					if (var57 < 0) {
						var57 = 0;
					}

					if (var40 > 16) {
						var40 = 16;
					}

					boolean var58 = false;

					int var42;
					for (var42 = var55; !var58 && var42 < var36; ++var42) {
						for (int var43 = var57; !var58 && var43 < var40; ++var43) {
							for (int var44 = var38 + 1; !var58 && var44 >= var56 - 1; --var44) {
								if (var44 >= 0 && var44 < 256) {
									BlockState var45 = var5.a(var42, var44, var43);
									if (var45.getBlock() == Blocks.FLOWING_WATER || var45.getBlock() == Blocks.WATER) {
										var58 = true;
									}

									if (var44 != var56 - 1 && var42 != var55 && var42 != var36 - 1 && var43 != var57 && var43 != var40 - 1) {
										var44 = var56;
									}
								}
							}
						}
					}

					if (!var58) {
						for (var42 = var55; var42 < var36; ++var42) {
							double var59 = ((double) (var42 + var3 * 16) + 0.5D - var6) / var29;

							for (int var60 = var57; var60 < var40; ++var60) {
								double var46 = ((double) (var60 + var4 * 16) + 0.5D - var10) / var29;
								boolean var48 = false;
								if (var59 * var59 + var46 * var46 < 1.0D) {
									for (int var49 = var38; var49 > var56; --var49) {
										double var50 = ((double) (var49 - 1) + 0.5D - var8) / var31;
										if (var50 > -0.7D && var59 * var59 + var50 * var50 + var46 * var46 < 1.0D) {
											BlockState var52 = var5.a(var42, var49, var60);
											BlockState var53 = (BlockState) Objects.firstNonNull(var5.a(var42, var49 + 1, var60), Blocks.AIR.getBlockState());
											if (var52.getBlock() == Blocks.GRASS || var52.getBlock() == Blocks.MYCELIUM) {
												var48 = true;
											}

											if (this.a(var52, var53)) {
												if (var49 - 1 < 10) {
													var5.a(var42, var49, var60, Blocks.LAVA.getBlockState());
												} else {
													var5.a(var42, var49, var60, Blocks.AIR.getBlockState());
													if (var53.getBlock() == Blocks.SAND) {
														var5.a(var42, var49 + 1, var60, var53.b(BlockSand.a) == bac.b ? Blocks.RED_SANDSTONE.getBlockState() : Blocks.SANDSTONE.getBlockState());
													}

													if (var48 && var5.a(var42, var49 - 1, var60).getBlock() == Blocks.DIRT) {
														var5.a(var42, var49 - 1, var60, this.c.b(new Position(var42 + var3 * 16, 0, var60 + var4 * 16)).ak.getBlock().getBlockState());
													}
												}
											}
										}
									}
								}
							}
						}

						if (var54) {
							break;
						}
					}
				}
			}
		}

	}

	protected boolean a(BlockState var1, BlockState var2) {
		return var1.getBlock() == Blocks.STONE ? true : (var1.getBlock() == Blocks.DIRT ? true : (var1.getBlock() == Blocks.GRASS ? true : (var1.getBlock() == Blocks.HARDENED_CLAY ? true : (var1.getBlock() == Blocks.STAINDED_HARDENED_CLAY ? true : (var1.getBlock() == Blocks.SANDSTONE ? true : (var1.getBlock() == Blocks.RED_SANDSTONE ? true : (var1.getBlock() == Blocks.MYCELIUM ? true : (var1.getBlock() == Blocks.SNOW_LAYER ? true : (var1.getBlock() == Blocks.SAND || var1.getBlock() == Blocks.GRAVEL) && var2.getBlock().getMaterial() != Material.WATER))))))));
	}

	protected void a(World var1, int var2, int var3, int var4, int var5, bgk var6) {
		int var7 = this.b.nextInt(this.b.nextInt(this.b.nextInt(15) + 1) + 1);
		if (this.b.nextInt(7) != 0) {
			var7 = 0;
		}

		for (int var8 = 0; var8 < var7; ++var8) {
			double var9 = (double) (var2 * 16 + this.b.nextInt(16));
			double var11 = (double) this.b.nextInt(this.b.nextInt(120) + 8);
			double var13 = (double) (var3 * 16 + this.b.nextInt(16));
			int var15 = 1;
			if (this.b.nextInt(4) == 0) {
				this.a(this.b.nextLong(), var4, var5, var6, var9, var11, var13);
				var15 += this.b.nextInt(4);
			}

			for (int var16 = 0; var16 < var15; ++var16) {
				float var17 = this.b.nextFloat() * 3.1415927F * 2.0F;
				float var18 = (this.b.nextFloat() - 0.5F) * 2.0F / 8.0F;
				float var19 = this.b.nextFloat() * 2.0F + this.b.nextFloat();
				if (this.b.nextInt(10) == 0) {
					var19 *= this.b.nextFloat() * this.b.nextFloat() * 3.0F + 1.0F;
				}

				this.a(this.b.nextLong(), var4, var5, var6, var9, var11, var13, var19, var17, var18, 0, 0, 1.0D);
			}
		}

	}
}
