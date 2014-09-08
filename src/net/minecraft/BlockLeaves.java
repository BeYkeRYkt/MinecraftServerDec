package net.minecraft;

import java.util.Random;

public abstract class BlockLeaves extends BlockTransparent {

	public static final bet a = bet.a("decayable");
	public static final bet b = bet.a("check_decay");
	int[] M;

	public BlockLeaves() {
		super(Material.LEAVES, false);
		this.a(true);
		this.a(CreativeModeTab.DECORATIONS);
		this.c(0.2F);
		this.e(1);
		this.a(h);
	}

	public void b(World var1, Position var2, BlockState var3) {
		byte var4 = 1;
		int var5 = var4 + 1;
		int var6 = var2.getX();
		int var7 = var2.getY();
		int var8 = var2.getZ();
		if (var1.a(new Position(var6 - var5, var7 - var5, var8 - var5), new Position(var6 + var5, var7 + var5, var8 + var5))) {
			for (int var9 = -var4; var9 <= var4; ++var9) {
				for (int var10 = -var4; var10 <= var4; ++var10) {
					for (int var11 = -var4; var11 <= var4; ++var11) {
						Position var12 = var2.a(var9, var10, var11);
						BlockState var13 = var1.getBlockState(var12);
						if (var13.getBlock().getMaterial() == Material.LEAVES && !((Boolean) var13.b(b)).booleanValue()) {
							var1.a(var12, var13.a(b, Boolean.valueOf(true)), 4);
						}
					}
				}
			}
		}

	}

	public void b(World var1, Position var2, BlockState var3, Random var4) {
		if (!var1.D) {
			if (((Boolean) var3.b(b)).booleanValue() && ((Boolean) var3.b(a)).booleanValue()) {
				byte var5 = 4;
				int var6 = var5 + 1;
				int var7 = var2.getX();
				int var8 = var2.getY();
				int var9 = var2.getZ();
				byte var10 = 32;
				int var11 = var10 * var10;
				int var12 = var10 / 2;
				if (this.M == null) {
					this.M = new int[var10 * var10 * var10];
				}

				int var13;
				if (var1.a(new Position(var7 - var6, var8 - var6, var9 - var6), new Position(var7 + var6, var8 + var6, var9 + var6))) {
					int var14;
					int var15;
					for (var13 = -var5; var13 <= var5; ++var13) {
						for (var14 = -var5; var14 <= var5; ++var14) {
							for (var15 = -var5; var15 <= var5; ++var15) {
								Block var16 = var1.getBlockState(new Position(var7 + var13, var8 + var14, var9 + var15)).getBlock();
								if (var16 != Blocks.LOG && var16 != Blocks.LOG2) {
									if (var16.getMaterial() == Material.LEAVES) {
										this.M[(var13 + var12) * var11 + (var14 + var12) * var10 + var15 + var12] = -2;
									} else {
										this.M[(var13 + var12) * var11 + (var14 + var12) * var10 + var15 + var12] = -1;
									}
								} else {
									this.M[(var13 + var12) * var11 + (var14 + var12) * var10 + var15 + var12] = 0;
								}
							}
						}
					}

					for (var13 = 1; var13 <= 4; ++var13) {
						for (var14 = -var5; var14 <= var5; ++var14) {
							for (var15 = -var5; var15 <= var5; ++var15) {
								for (int var17 = -var5; var17 <= var5; ++var17) {
									if (this.M[(var14 + var12) * var11 + (var15 + var12) * var10 + var17 + var12] == var13 - 1) {
										if (this.M[(var14 + var12 - 1) * var11 + (var15 + var12) * var10 + var17 + var12] == -2) {
											this.M[(var14 + var12 - 1) * var11 + (var15 + var12) * var10 + var17 + var12] = var13;
										}

										if (this.M[(var14 + var12 + 1) * var11 + (var15 + var12) * var10 + var17 + var12] == -2) {
											this.M[(var14 + var12 + 1) * var11 + (var15 + var12) * var10 + var17 + var12] = var13;
										}

										if (this.M[(var14 + var12) * var11 + (var15 + var12 - 1) * var10 + var17 + var12] == -2) {
											this.M[(var14 + var12) * var11 + (var15 + var12 - 1) * var10 + var17 + var12] = var13;
										}

										if (this.M[(var14 + var12) * var11 + (var15 + var12 + 1) * var10 + var17 + var12] == -2) {
											this.M[(var14 + var12) * var11 + (var15 + var12 + 1) * var10 + var17 + var12] = var13;
										}

										if (this.M[(var14 + var12) * var11 + (var15 + var12) * var10 + (var17 + var12 - 1)] == -2) {
											this.M[(var14 + var12) * var11 + (var15 + var12) * var10 + (var17 + var12 - 1)] = var13;
										}

										if (this.M[(var14 + var12) * var11 + (var15 + var12) * var10 + var17 + var12 + 1] == -2) {
											this.M[(var14 + var12) * var11 + (var15 + var12) * var10 + var17 + var12 + 1] = var13;
										}
									}
								}
							}
						}
					}
				}

				var13 = this.M[var12 * var11 + var12 * var10 + var12];
				if (var13 >= 0) {
					var1.a(var2, var3.a(b, Boolean.valueOf(false)), 4);
				} else {
					this.d(var1, var2);
				}
			}

		}
	}

	private void d(World var1, Position var2) {
		this.b(var1, var2, var1.getBlockState(var2), 0);
		var1.g(var2);
	}

	public int a(Random var1) {
		return var1.nextInt(20) == 0 ? 1 : 0;
	}

	public Item a(BlockState var1, Random var2, int var3) {
		return Item.getItemOf(Blocks.SAPLING);
	}

	public void a(World var1, Position var2, BlockState var3, float var4, int var5) {
		if (!var1.D) {
			int var6 = this.d(var3);
			if (var5 > 0) {
				var6 -= 2 << var5;
				if (var6 < 10) {
					var6 = 10;
				}
			}

			if (var1.s.nextInt(var6) == 0) {
				Item var7 = this.a(var3, var1.s, var5);
				a(var1, var2, new ItemStack(var7, 1, this.a(var3)));
			}

			var6 = 200;
			if (var5 > 0) {
				var6 -= 10 << var5;
				if (var6 < 40) {
					var6 = 40;
				}
			}

			this.a(var1, var2, var3, var6);
		}

	}

	protected void a(World var1, Position var2, BlockState var3, int var4) {
	}

	protected int d(BlockState var1) {
		return 20;
	}

	public boolean c() {
		return !this.Q;
	}

	public boolean u() {
		return false;
	}

	public abstract ayx b(int var1);

}
