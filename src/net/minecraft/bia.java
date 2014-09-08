package net.minecraft;

import java.util.Random;

public class bia extends bic {

	public bia(boolean var1, int var2, int var3, int var4, int var5) {
		super(var1, var2, var3, var4, var5);
	}

	public boolean b(World var1, Random var2, Position var3) {
		int var4 = this.a(var2);
		if (!this.a(var1, var2, var3, var4)) {
			return false;
		} else {
			this.c(var1, var3.b(var4), 2);

			for (int var5 = var3.getY() + var4 - 2 - var2.nextInt(4); var5 > var3.getY() + var4 / 2; var5 -= 2 + var2.nextInt(4)) {
				float var6 = var2.nextFloat() * 3.1415927F * 2.0F;
				int var7 = var3.getX() + (int) (0.5F + DataTypesConverter.b(var6) * 4.0F);
				int var8 = var3.getZ() + (int) (0.5F + DataTypesConverter.a(var6) * 4.0F);

				int var9;
				for (var9 = 0; var9 < 5; ++var9) {
					var7 = var3.getX() + (int) (1.5F + DataTypesConverter.b(var6) * (float) var9);
					var8 = var3.getZ() + (int) (1.5F + DataTypesConverter.a(var6) * (float) var9);
					this.a(var1, new Position(var7, var5 - 3 + var9 / 2, var8), Blocks.LOG, this.b);
				}

				var9 = 1 + var2.nextInt(2);
				int var10 = var5;

				for (int var11 = var5 - var9; var11 <= var10; ++var11) {
					int var12 = var11 - var10;
					this.b(var1, new Position(var7, var11, var8), 1 - var12);
				}
			}

			for (int var13 = 0; var13 < var4; ++var13) {
				Position var14 = var3.b(var13);
				if (this.a(var1.getBlockState(var14).getBlock().getMaterial())) {
					this.a(var1, var14, Blocks.LOG, this.b);
					if (var13 > 0) {
						this.b(var1, var2, var14.e(), BlockVine.S);
						this.b(var1, var2, var14.c(), BlockVine.Q);
					}
				}

				if (var13 < var4 - 1) {
					Position var15 = var14.f();
					if (this.a(var1.getBlockState(var15).getBlock().getMaterial())) {
						this.a(var1, var15, Blocks.LOG, this.b);
						if (var13 > 0) {
							this.b(var1, var2, var15.f(), BlockVine.T);
							this.b(var1, var2, var15.c(), BlockVine.Q);
						}
					}

					Position var16 = var14.d().f();
					if (this.a(var1.getBlockState(var16).getBlock().getMaterial())) {
						this.a(var1, var16, Blocks.LOG, this.b);
						if (var13 > 0) {
							this.b(var1, var2, var16.f(), BlockVine.T);
							this.b(var1, var2, var16.d(), BlockVine.R);
						}
					}

					Position var17 = var14.d();
					if (this.a(var1.getBlockState(var17).getBlock().getMaterial())) {
						this.a(var1, var17, Blocks.LOG, this.b);
						if (var13 > 0) {
							this.b(var1, var2, var17.e(), BlockVine.S);
							this.b(var1, var2, var17.d(), BlockVine.R);
						}
					}
				}
			}

			return true;
		}
	}

	private boolean a(Material var1) {
		return var1 == Material.AIR || var1 == Material.LEAVES;
	}

	private void b(World var1, Random var2, Position var3, int var4) {
		if (var2.nextInt(3) > 0 && var1.d(var3)) {
			this.a(var1, var3, Blocks.VINE, var4);
		}

	}

	private void c(World var1, Position var2, int var3) {
		byte var4 = 2;

		for (int var5 = -var4; var5 <= 0; ++var5) {
			this.a(var1, var2.b(var5), var3 + 1 - var5);
		}

	}
}
