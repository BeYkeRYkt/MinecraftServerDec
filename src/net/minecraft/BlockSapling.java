package net.minecraft;

import java.util.Random;

public class BlockSapling extends auc implements atz {

	public static final bev a = bev.a("type", EnumWoodType.class);
	public static final bew b = bew.a("stage", 0, 1);

	protected BlockSapling() {
		this.setBlockState(this.L.b().a(a, EnumWoodType.a).a(b, Integer.valueOf(0)));
		float var1 = 0.4F;
		this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, var1 * 2.0F, 0.5F + var1);
		this.a(CreativeModeTab.DECORATIONS);
	}

	public void b(World var1, Position var2, BlockState var3, Random var4) {
		if (!var1.isStatic) {
			super.b(var1, var2, var3, var4);
			if (var1.l(var2.a()) >= 9 && var4.nextInt(7) == 0) {
				this.d(var1, var2, var3, var4);
			}

		}
	}

	public void d(World var1, Position var2, BlockState var3, Random var4) {
		if (((Integer) var3.b(b)).intValue() == 0) {
			var1.a(var2, var3.a(b), 4);
		} else {
			this.e(var1, var2, var3, var4);
		}

	}

	public void e(World var1, Position var2, BlockState var3, Random var4) {
		Object var5 = var4.nextInt(10) == 0 ? new WorldGenBigTree(true) : new WorldGenTrees(true);
		int var6 = 0;
		int var7 = 0;
		boolean var8 = false;
		switch (bag.a[((EnumWoodType) var3.b(a)).ordinal()]) {
			case 1:
				label78: for (var6 = 0; var6 >= -1; --var6) {
					for (var7 = 0; var7 >= -1; --var7) {
						if (this.a(var1, var2.a(var6, 0, var7), EnumWoodType.b) && this.a(var1, var2.a(var6 + 1, 0, var7), EnumWoodType.b) && this.a(var1, var2.a(var6, 0, var7 + 1), EnumWoodType.b) && this.a(var1, var2.a(var6 + 1, 0, var7 + 1), EnumWoodType.b)) {
							var5 = new WorldGenMegaTree(false, var4.nextBoolean());
							var8 = true;
							break label78;
						}
					}
				}

				if (!var8) {
					var7 = 0;
					var6 = 0;
					var5 = new WorldGenTaiga2(true);
				}
				break;
			case 2:
				var5 = new WorldGenForest(true, false);
				break;
			case 3:
				label93: for (var6 = 0; var6 >= -1; --var6) {
					for (var7 = 0; var7 >= -1; --var7) {
						if (this.a(var1, var2.a(var6, 0, var7), EnumWoodType.d) && this.a(var1, var2.a(var6 + 1, 0, var7), EnumWoodType.d) && this.a(var1, var2.a(var6, 0, var7 + 1), EnumWoodType.d) && this.a(var1, var2.a(var6 + 1, 0, var7 + 1), EnumWoodType.d)) {
							var5 = new WorldGenJungleTree(true, 10, 20, EnumWoodType.d.a(), EnumWoodType.d.a());
							var8 = true;
							break label93;
						}
					}
				}

				if (!var8) {
					var7 = 0;
					var6 = 0;
					var5 = new WorldGenTrees(true, 4 + var4.nextInt(7), EnumWoodType.d.a(), EnumWoodType.d.a(), false);
				}
				break;
			case 4:
				var5 = new WorldGenAcaciaTree(true);
				break;
			case 5:
				label108: for (var6 = 0; var6 >= -1; --var6) {
					for (var7 = 0; var7 >= -1; --var7) {
						if (this.a(var1, var2.a(var6, 0, var7), EnumWoodType.f) && this.a(var1, var2.a(var6 + 1, 0, var7), EnumWoodType.f) && this.a(var1, var2.a(var6, 0, var7 + 1), EnumWoodType.f) && this.a(var1, var2.a(var6 + 1, 0, var7 + 1), EnumWoodType.f)) {
							var5 = new WorldGenForestTree(true);
							var8 = true;
							break label108;
						}
					}
				}

				if (!var8) {
					return;
				}
			case 6:
		}

		BlockState var9 = Blocks.AIR.getBlockState();
		if (var8) {
			var1.a(var2.a(var6, 0, var7), var9, 4);
			var1.a(var2.a(var6 + 1, 0, var7), var9, 4);
			var1.a(var2.a(var6, 0, var7 + 1), var9, 4);
			var1.a(var2.a(var6 + 1, 0, var7 + 1), var9, 4);
		} else {
			var1.a(var2, var9, 4);
		}

		if (!((WorldGenerator) var5).b(var1, var4, var2.a(var6, 0, var7))) {
			if (var8) {
				var1.a(var2.a(var6, 0, var7), var3, 4);
				var1.a(var2.a(var6 + 1, 0, var7), var3, 4);
				var1.a(var2.a(var6, 0, var7 + 1), var3, 4);
				var1.a(var2.a(var6 + 1, 0, var7 + 1), var3, 4);
			} else {
				var1.a(var2, var3, 4);
			}
		}

	}

	public boolean a(World var1, Position var2, EnumWoodType var3) {
		BlockState var4 = var1.getBlockState(var2);
		return var4.getBlock() == this && var4.b(a) == var3;
	}

	public int a(BlockState var1) {
		return ((EnumWoodType) var1.b(a)).a();
	}

	public boolean a(World var1, Position var2, BlockState var3, boolean var4) {
		return true;
	}

	public boolean a(World var1, Random var2, Position var3, BlockState var4) {
		return (double) var1.s.nextFloat() < 0.45D;
	}

	public void b(World var1, Random var2, Position var3, BlockState var4) {
		this.d(var1, var3, var4, var2);
	}

	public BlockState a(int var1) {
		return this.getBlockState().a(a, EnumWoodType.a(var1 & 7)).a(b, Integer.valueOf((var1 & 8) >> 3));
	}

	public int c(BlockState var1) {
		byte var2 = 0;
		int var3 = var2 | ((EnumWoodType) var1.b(a)).a();
		var3 |= ((Integer) var1.b(b)).intValue() << 3;
		return var3;
	}

	protected bed e() {
		return new bed(this, new bex[] { a, b });
	}

}
