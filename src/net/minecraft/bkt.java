package net.minecraft;

import java.util.Random;

public class bkt extends blb {

	public bkt() {
	}

	public bkt(BlockFace var1, blf var2, Random var3) {
		super(1, var1, var2, 2, 2, 2);
	}

	public boolean a(World var1, Random var2, CuboidArea var3) {
		this.a(var1, var3, 1, 8, 0, 14, 8, 14, a);
		byte var4 = 7;
		BlockState var5 = b;
		this.a(var1, var3, 0, var4, 0, 0, var4, 15, var5, var5, false);
		this.a(var1, var3, 15, var4, 0, 15, var4, 15, var5, var5, false);
		this.a(var1, var3, 1, var4, 0, 15, var4, 0, var5, var5, false);
		this.a(var1, var3, 1, var4, 15, 14, var4, 15, var5, var5, false);

		int var7;
		for (var7 = 1; var7 <= 6; ++var7) {
			var5 = b;
			if (var7 == 2 || var7 == 6) {
				var5 = a;
			}

			for (int var6 = 0; var6 <= 15; var6 += 15) {
				this.a(var1, var3, var6, var7, 0, var6, var7, 1, var5, var5, false);
				this.a(var1, var3, var6, var7, 6, var6, var7, 9, var5, var5, false);
				this.a(var1, var3, var6, var7, 14, var6, var7, 15, var5, var5, false);
			}

			this.a(var1, var3, 1, var7, 0, 1, var7, 0, var5, var5, false);
			this.a(var1, var3, 6, var7, 0, 9, var7, 0, var5, var5, false);
			this.a(var1, var3, 14, var7, 0, 14, var7, 0, var5, var5, false);
			this.a(var1, var3, 1, var7, 15, 14, var7, 15, var5, var5, false);
		}

		this.a(var1, var3, 6, 3, 6, 9, 6, 9, c, c, false);
		this.a(var1, var3, 7, 4, 7, 8, 5, 8, Blocks.GOLD_BLOCK.getBlockState(), Blocks.GOLD_BLOCK.getBlockState(), false);

		for (var7 = 3; var7 <= 6; var7 += 3) {
			for (int var8 = 6; var8 <= 9; var8 += 3) {
				this.a(var1, e, var8, var7, 6, var3);
				this.a(var1, e, var8, var7, 9, var3);
			}
		}

		this.a(var1, var3, 5, 1, 6, 5, 2, 6, b, b, false);
		this.a(var1, var3, 5, 1, 9, 5, 2, 9, b, b, false);
		this.a(var1, var3, 10, 1, 6, 10, 2, 6, b, b, false);
		this.a(var1, var3, 10, 1, 9, 10, 2, 9, b, b, false);
		this.a(var1, var3, 6, 1, 5, 6, 2, 5, b, b, false);
		this.a(var1, var3, 9, 1, 5, 9, 2, 5, b, b, false);
		this.a(var1, var3, 6, 1, 10, 6, 2, 10, b, b, false);
		this.a(var1, var3, 9, 1, 10, 9, 2, 10, b, b, false);
		this.a(var1, var3, 5, 2, 5, 5, 6, 5, b, b, false);
		this.a(var1, var3, 5, 2, 10, 5, 6, 10, b, b, false);
		this.a(var1, var3, 10, 2, 5, 10, 6, 5, b, b, false);
		this.a(var1, var3, 10, 2, 10, 10, 6, 10, b, b, false);
		this.a(var1, var3, 5, 7, 1, 5, 7, 6, b, b, false);
		this.a(var1, var3, 10, 7, 1, 10, 7, 6, b, b, false);
		this.a(var1, var3, 5, 7, 9, 5, 7, 14, b, b, false);
		this.a(var1, var3, 10, 7, 9, 10, 7, 14, b, b, false);
		this.a(var1, var3, 1, 7, 5, 6, 7, 5, b, b, false);
		this.a(var1, var3, 1, 7, 10, 6, 7, 10, b, b, false);
		this.a(var1, var3, 9, 7, 5, 14, 7, 5, b, b, false);
		this.a(var1, var3, 9, 7, 10, 14, 7, 10, b, b, false);
		this.a(var1, var3, 2, 1, 2, 2, 1, 3, b, b, false);
		this.a(var1, var3, 3, 1, 2, 3, 1, 2, b, b, false);
		this.a(var1, var3, 13, 1, 2, 13, 1, 3, b, b, false);
		this.a(var1, var3, 12, 1, 2, 12, 1, 2, b, b, false);
		this.a(var1, var3, 2, 1, 12, 2, 1, 13, b, b, false);
		this.a(var1, var3, 3, 1, 13, 3, 1, 13, b, b, false);
		this.a(var1, var3, 13, 1, 12, 13, 1, 13, b, b, false);
		this.a(var1, var3, 12, 1, 13, 12, 1, 13, b, b, false);
		return true;
	}
}
