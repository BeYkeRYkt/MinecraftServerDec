package net.minecraft;

import java.util.List;
import java.util.Random;

public class bjt extends bkb {

	public bjt() {
	}

	public bjt(int var1, Random var2, bjb var3, PaintingDirection var4) {
		super(var1);
		this.m = var4;
		this.l = var3;
	}

	public void a(bms var1, List var2, Random var3) {
		byte var4 = 1;
		if (this.m == PaintingDirection.e || this.m == PaintingDirection.c) {
			var4 = 5;
		}

		this.b((bkf) var1, var2, var3, 0, var4, var3.nextInt(8) > 0);
		this.c((bkf) var1, var2, var3, 0, var4, var3.nextInt(8) > 0);
	}

	public static bjt a(List var0, Random var1, int var2, int var3, int var4, PaintingDirection var5, int var6) {
		bjb var7 = bjb.a(var2, var3, var4, -3, 0, 0, 9, 7, 9, var5);
		return a(var7) && bms.a(var0, var7) == null ? new bjt(var6, var1, var7, var5) : null;
	}

	public boolean a(World var1, Random var2, bjb var3) {
		this.a(var1, var3, 0, 0, 0, 8, 1, 8, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
		this.a(var1, var3, 0, 2, 0, 8, 5, 8, Blocks.AIR.P(), Blocks.AIR.P(), false);
		this.a(var1, var3, 0, 6, 0, 8, 6, 5, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
		this.a(var1, var3, 0, 2, 0, 2, 5, 0, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
		this.a(var1, var3, 6, 2, 0, 8, 5, 0, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
		this.a(var1, var3, 1, 3, 0, 1, 4, 0, Blocks.NETHER_BRICK_FENCE.P(), Blocks.NETHER_BRICK_FENCE.P(), false);
		this.a(var1, var3, 7, 3, 0, 7, 4, 0, Blocks.NETHER_BRICK_FENCE.P(), Blocks.NETHER_BRICK_FENCE.P(), false);
		this.a(var1, var3, 0, 2, 4, 8, 2, 8, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
		this.a(var1, var3, 1, 1, 4, 2, 2, 4, Blocks.AIR.P(), Blocks.AIR.P(), false);
		this.a(var1, var3, 6, 1, 4, 7, 2, 4, Blocks.AIR.P(), Blocks.AIR.P(), false);
		this.a(var1, var3, 0, 3, 8, 8, 3, 8, Blocks.NETHER_BRICK_FENCE.P(), Blocks.NETHER_BRICK_FENCE.P(), false);
		this.a(var1, var3, 0, 3, 6, 0, 3, 7, Blocks.NETHER_BRICK_FENCE.P(), Blocks.NETHER_BRICK_FENCE.P(), false);
		this.a(var1, var3, 8, 3, 6, 8, 3, 7, Blocks.NETHER_BRICK_FENCE.P(), Blocks.NETHER_BRICK_FENCE.P(), false);
		this.a(var1, var3, 0, 3, 4, 0, 5, 5, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
		this.a(var1, var3, 8, 3, 4, 8, 5, 5, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
		this.a(var1, var3, 1, 3, 5, 2, 5, 5, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
		this.a(var1, var3, 6, 3, 5, 7, 5, 5, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
		this.a(var1, var3, 1, 4, 5, 1, 5, 5, Blocks.NETHER_BRICK_FENCE.P(), Blocks.NETHER_BRICK_FENCE.P(), false);
		this.a(var1, var3, 7, 4, 5, 7, 5, 5, Blocks.NETHER_BRICK_FENCE.P(), Blocks.NETHER_BRICK_FENCE.P(), false);

		for (int var4 = 0; var4 <= 5; ++var4) {
			for (int var5 = 0; var5 <= 8; ++var5) {
				this.b(var1, Blocks.NETHER_BRICK.P(), var5, -1, var4, var3);
			}
		}

		return true;
	}
}
