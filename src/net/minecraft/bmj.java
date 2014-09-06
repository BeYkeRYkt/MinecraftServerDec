package net.minecraft;

import java.util.List;
import java.util.Random;

public class bmj extends bmk {

	public bmj() {
	}

	public bmj(int var1, Random var2, bjb var3, PaintingDirection var4) {
		super(var1);
		this.m = var4;
		this.d = this.a(var2);
		this.l = var3;
	}

	public void a(bms var1, List var2, Random var3) {
		this.a((bmh) var1, var2, var3, 1, 1);
	}

	public static bmj a(List var0, Random var1, int var2, int var3, int var4, PaintingDirection var5, int var6) {
		bjb var7 = bjb.a(var2, var3, var4, -1, -7, 0, 5, 11, 8, var5);
		return a(var7) && bms.a(var0, var7) == null ? new bmj(var6, var1, var7, var5) : null;
	}

	public boolean a(World var1, Random var2, bjb var3) {
		if (this.a(var1, var3)) {
			return false;
		} else {
			this.a(var1, var3, 0, 0, 0, 4, 10, 7, true, var2, blr.c());
			this.a(var1, var2, var3, this.d, 1, 7, 0);
			this.a(var1, var2, var3, bml.a, 1, 1, 7);
			int var4 = this.a(Blocks.STONE_STAIRS, 2);

			for (int var5 = 0; var5 < 6; ++var5) {
				this.a(var1, Blocks.STONE_STAIRS.a(var4), 1, 6 - var5, 1 + var5, var3);
				this.a(var1, Blocks.STONE_STAIRS.a(var4), 2, 6 - var5, 1 + var5, var3);
				this.a(var1, Blocks.STONE_STAIRS.a(var4), 3, 6 - var5, 1 + var5, var3);
				if (var5 < 5) {
					this.a(var1, Blocks.STONEBRICK.P(), 1, 5 - var5, 1 + var5, var3);
					this.a(var1, Blocks.STONEBRICK.P(), 2, 5 - var5, 1 + var5, var3);
					this.a(var1, Blocks.STONEBRICK.P(), 3, 5 - var5, 1 + var5, var3);
				}
			}

			return true;
		}
	}
}
