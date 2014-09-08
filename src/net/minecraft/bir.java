package net.minecraft;

import java.util.Random;

public class bir extends bhc {

	private final int a;
	private final boolean b;
	private final int c;
	private final int d;

	public bir(boolean var1) {
		this(var1, 4, 0, 0, false);
	}

	public bir(boolean var1, int var2, int var3, int var4, boolean var5) {
		super(var1);
		this.a = var2;
		this.c = var3;
		this.d = var4;
		this.b = var5;
	}

	public boolean b(World var1, Random var2, Position var3) {
		int var4 = var2.nextInt(3) + this.a;
		boolean var5 = true;
		if (var3.getY() >= 1 && var3.getY() + var4 + 1 <= 256) {
			byte var7;
			int var9;
			for (int var6 = var3.getY(); var6 <= var3.getY() + 1 + var4; ++var6) {
				var7 = 1;
				if (var6 == var3.getY()) {
					var7 = 0;
				}

				if (var6 >= var3.getY() + 1 + var4 - 2) {
					var7 = 2;
				}

				for (int var8 = var3.getX() - var7; var8 <= var3.getX() + var7 && var5; ++var8) {
					for (var9 = var3.getZ() - var7; var9 <= var3.getZ() + var7 && var5; ++var9) {
						if (var6 >= 0 && var6 < 256) {
							if (!this.a(var1.getBlockState(new Position(var8, var6, var9)).getBlock())) {
								var5 = false;
							}
						} else {
							var5 = false;
						}
					}
				}
			}

			if (!var5) {
				return false;
			} else {
				Block var19 = var1.getBlockState(var3.b()).getBlock();
				if ((var19 == Blocks.GRASS || var19 == Blocks.DIRT || var19 == Blocks.FARMLAND) && var3.getY() < 256 - var4 - 1) {
					this.a(var1, var3.b());
					var7 = 3;
					byte var20 = 0;

					int var10;
					int var11;
					int var12;
					int var13;
					Position var16;
					for (var9 = var3.getY() - var7 + var4; var9 <= var3.getY() + var4; ++var9) {
						var10 = var9 - (var3.getY() + var4);
						var11 = var20 + 1 - var10 / 2;

						for (var12 = var3.getX() - var11; var12 <= var3.getX() + var11; ++var12) {
							var13 = var12 - var3.getX();

							for (int var14 = var3.getZ() - var11; var14 <= var3.getZ() + var11; ++var14) {
								int var15 = var14 - var3.getZ();
								if (Math.abs(var13) != var11 || Math.abs(var15) != var11 || var2.nextInt(2) != 0 && var10 != 0) {
									var16 = new Position(var12, var9, var14);
									Block var17 = var1.getBlockState(var16).getBlock();
									if (var17.getMaterial() == Material.AIR || var17.getMaterial() == Material.LEAVES || var17.getMaterial() == Material.REPLACEABLE_PLANT) {
										this.a(var1, var16, Blocks.LEAVES, this.d);
									}
								}
							}
						}
					}

					for (var9 = 0; var9 < var4; ++var9) {
						Block var21 = var1.getBlockState(var3.b(var9)).getBlock();
						if (var21.getMaterial() == Material.AIR || var21.getMaterial() == Material.LEAVES || var21.getMaterial() == Material.REPLACEABLE_PLANT) {
							this.a(var1, var3.b(var9), Blocks.LOG, this.c);
							if (this.b && var9 > 0) {
								if (var2.nextInt(3) > 0 && var1.d(var3.a(-1, var9, 0))) {
									this.a(var1, var3.a(-1, var9, 0), Blocks.VINE, BlockVine.S);
								}

								if (var2.nextInt(3) > 0 && var1.d(var3.a(1, var9, 0))) {
									this.a(var1, var3.a(1, var9, 0), Blocks.VINE, BlockVine.T);
								}

								if (var2.nextInt(3) > 0 && var1.d(var3.a(0, var9, -1))) {
									this.a(var1, var3.a(0, var9, -1), Blocks.VINE, BlockVine.Q);
								}

								if (var2.nextInt(3) > 0 && var1.d(var3.a(0, var9, 1))) {
									this.a(var1, var3.a(0, var9, 1), Blocks.VINE, BlockVine.R);
								}
							}
						}
					}

					if (this.b) {
						for (var9 = var3.getY() - 3 + var4; var9 <= var3.getY() + var4; ++var9) {
							var10 = var9 - (var3.getY() + var4);
							var11 = 2 - var10 / 2;

							for (var12 = var3.getX() - var11; var12 <= var3.getX() + var11; ++var12) {
								for (var13 = var3.getZ() - var11; var13 <= var3.getZ() + var11; ++var13) {
									Position var23 = new Position(var12, var9, var13);
									if (var1.getBlockState(var23).getBlock().getMaterial() == Material.LEAVES) {
										Position var24 = var23.e();
										var16 = var23.f();
										Position var25 = var23.c();
										Position var18 = var23.d();
										if (var2.nextInt(4) == 0 && var1.getBlockState(var24).getBlock().getMaterial() == Material.AIR) {
											this.a(var1, var24, BlockVine.S);
										}

										if (var2.nextInt(4) == 0 && var1.getBlockState(var16).getBlock().getMaterial() == Material.AIR) {
											this.a(var1, var16, BlockVine.T);
										}

										if (var2.nextInt(4) == 0 && var1.getBlockState(var25).getBlock().getMaterial() == Material.AIR) {
											this.a(var1, var25, BlockVine.Q);
										}

										if (var2.nextInt(4) == 0 && var1.getBlockState(var18).getBlock().getMaterial() == Material.AIR) {
											this.a(var1, var18, BlockVine.R);
										}
									}
								}
							}
						}

						if (var2.nextInt(5) == 0 && var4 > 5) {
							for (var9 = 0; var9 < 2; ++var9) {
								for (var10 = 0; var10 < 4; ++var10) {
									if (var2.nextInt(4 - var9) == 0) {
										var11 = var2.nextInt(3);
										BlockFace var22 = BlockFace.fromDirection(var10).getOpposite();
										this.a(var1, var3.a(var22.g(), var4 - 5 + var9, var22.i()), Blocks.COCOA, var11 << 2 | BlockFace.fromDirection(var10).toDirection());
									}
								}
							}
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

	private void a(World var1, Position var2, int var3) {
		this.a(var1, var2, Blocks.VINE, var3);
		int var4 = 4;

		for (var2 = var2.b(); var1.getBlockState(var2).getBlock().getMaterial() == Material.AIR && var4 > 0; --var4) {
			this.a(var1, var2, Blocks.VINE, var3);
			var2 = var2.b();
		}

	}
}
