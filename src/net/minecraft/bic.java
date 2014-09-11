package net.minecraft;

import java.util.Random;

public abstract class bic extends WorldGenTreeAbstract {

	protected final int a;
	protected final int b;
	protected final int c;
	protected int d;

	public bic(boolean var1, int var2, int var3, int var4, int var5) {
		super(var1);
		this.a = var2;
		this.d = var3;
		this.b = var4;
		this.c = var5;
	}

	protected int a(Random var1) {
		int var2 = var1.nextInt(3) + this.a;
		if (this.d > 1) {
			var2 += var1.nextInt(this.d);
		}

		return var2;
	}

	private boolean c(World var1, Position var2, int var3) {
		boolean var4 = true;
		if (var2.getY() >= 1 && var2.getY() + var3 + 1 <= 256) {
			for (int var5 = 0; var5 <= 1 + var3; ++var5) {
				byte var6 = 2;
				if (var5 == 0) {
					var6 = 1;
				} else if (var5 >= 1 + var3 - 2) {
					var6 = 2;
				}

				for (int var7 = -var6; var7 <= var6 && var4; ++var7) {
					for (int var8 = -var6; var8 <= var6 && var4; ++var8) {
						if (var2.getY() + var5 < 0 || var2.getY() + var5 >= 256 || !this.a(var1.getBlockState(var2.a(var7, var5, var8)).getBlock())) {
							var4 = false;
						}
					}
				}
			}

			return var4;
		} else {
			return false;
		}
	}

	private boolean a(Position var1, World var2) {
		Position var3 = var1.b();
		Block var4 = var2.getBlockState(var3).getBlock();
		if ((var4 == Blocks.GRASS || var4 == Blocks.DIRT) && var1.getY() >= 2) {
			this.a(var2, var3);
			this.a(var2, var3.f());
			this.a(var2, var3.d());
			this.a(var2, var3.d().f());
			return true;
		} else {
			return false;
		}
	}

	protected boolean a(World var1, Random var2, Position var3, int var4) {
		return this.c(var1, var3, var4) && this.a(var3, var1);
	}

	protected void a(World var1, Position var2, int var3) {
		int var4 = var3 * var3;

		for (int var5 = -var3; var5 <= var3 + 1; ++var5) {
			for (int var6 = -var3; var6 <= var3 + 1; ++var6) {
				int var7 = var5 - 1;
				int var8 = var6 - 1;
				if (var5 * var5 + var6 * var6 <= var4 || var7 * var7 + var8 * var8 <= var4 || var5 * var5 + var8 * var8 <= var4 || var7 * var7 + var6 * var6 <= var4) {
					Position var9 = var2.a(var5, 0, var6);
					Material var10 = var1.getBlockState(var9).getBlock().getMaterial();
					if (var10 == Material.AIR || var10 == Material.LEAVES) {
						this.a(var1, var9, Blocks.LEAVES, this.c);
					}
				}
			}
		}

	}

	protected void b(World var1, Position var2, int var3) {
		int var4 = var3 * var3;

		for (int var5 = -var3; var5 <= var3; ++var5) {
			for (int var6 = -var3; var6 <= var3; ++var6) {
				if (var5 * var5 + var6 * var6 <= var4) {
					Position var7 = var2.a(var5, 0, var6);
					Material var8 = var1.getBlockState(var7).getBlock().getMaterial();
					if (var8 == Material.AIR || var8 == Material.LEAVES) {
						this.a(var1, var7, Blocks.LEAVES, this.c);
					}
				}
			}
		}

	}
}
