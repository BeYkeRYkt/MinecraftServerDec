package net.minecraft;

import java.util.List;
import java.util.Random;

public class bju extends bkb {

	public bju() {
	}

	public bju(int var1, Random var2, bjb var3, BlockFace var4) {
		super(var1);
		this.m = var4;
		this.l = var3;
	}

	public void a(bms var1, List var2, Random var3) {
		this.a((bkf) var1, var2, var3, 5, 3, true);
	}

	public static bju a(List var0, Random var1, int var2, int var3, int var4, BlockFace var5, int var6) {
		bjb var7 = bjb.a(var2, var3, var4, -5, -3, 0, 13, 14, 13, var5);
		return a(var7) && bms.a(var0, var7) == null ? new bju(var6, var1, var7, var5) : null;
	}

	public boolean a(World var1, Random var2, bjb var3) {
		this.a(var1, var3, 0, 3, 0, 12, 4, 12, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
		this.a(var1, var3, 0, 5, 0, 12, 13, 12, Blocks.AIR.P(), Blocks.AIR.P(), false);
		this.a(var1, var3, 0, 5, 0, 1, 12, 12, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
		this.a(var1, var3, 11, 5, 0, 12, 12, 12, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
		this.a(var1, var3, 2, 5, 11, 4, 12, 12, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
		this.a(var1, var3, 8, 5, 11, 10, 12, 12, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
		this.a(var1, var3, 5, 9, 11, 7, 12, 12, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
		this.a(var1, var3, 2, 5, 0, 4, 12, 1, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
		this.a(var1, var3, 8, 5, 0, 10, 12, 1, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
		this.a(var1, var3, 5, 9, 0, 7, 12, 1, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
		this.a(var1, var3, 2, 11, 2, 10, 12, 10, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
		this.a(var1, var3, 5, 8, 0, 7, 8, 0, Blocks.NETHER_BRICK_FENCE.P(), Blocks.NETHER_BRICK_FENCE.P(), false);

		int var4;
		for (var4 = 1; var4 <= 11; var4 += 2) {
			this.a(var1, var3, var4, 10, 0, var4, 11, 0, Blocks.NETHER_BRICK_FENCE.P(), Blocks.NETHER_BRICK_FENCE.P(), false);
			this.a(var1, var3, var4, 10, 12, var4, 11, 12, Blocks.NETHER_BRICK_FENCE.P(), Blocks.NETHER_BRICK_FENCE.P(), false);
			this.a(var1, var3, 0, 10, var4, 0, 11, var4, Blocks.NETHER_BRICK_FENCE.P(), Blocks.NETHER_BRICK_FENCE.P(), false);
			this.a(var1, var3, 12, 10, var4, 12, 11, var4, Blocks.NETHER_BRICK_FENCE.P(), Blocks.NETHER_BRICK_FENCE.P(), false);
			this.a(var1, Blocks.NETHER_BRICK.P(), var4, 13, 0, var3);
			this.a(var1, Blocks.NETHER_BRICK.P(), var4, 13, 12, var3);
			this.a(var1, Blocks.NETHER_BRICK.P(), 0, 13, var4, var3);
			this.a(var1, Blocks.NETHER_BRICK.P(), 12, 13, var4, var3);
			this.a(var1, Blocks.NETHER_BRICK_FENCE.P(), var4 + 1, 13, 0, var3);
			this.a(var1, Blocks.NETHER_BRICK_FENCE.P(), var4 + 1, 13, 12, var3);
			this.a(var1, Blocks.NETHER_BRICK_FENCE.P(), 0, 13, var4 + 1, var3);
			this.a(var1, Blocks.NETHER_BRICK_FENCE.P(), 12, 13, var4 + 1, var3);
		}

		this.a(var1, Blocks.NETHER_BRICK_FENCE.P(), 0, 13, 0, var3);
		this.a(var1, Blocks.NETHER_BRICK_FENCE.P(), 0, 13, 12, var3);
		this.a(var1, Blocks.NETHER_BRICK_FENCE.P(), 0, 13, 0, var3);
		this.a(var1, Blocks.NETHER_BRICK_FENCE.P(), 12, 13, 0, var3);

		for (var4 = 3; var4 <= 9; var4 += 2) {
			this.a(var1, var3, 1, 7, var4, 1, 8, var4, Blocks.NETHER_BRICK_FENCE.P(), Blocks.NETHER_BRICK_FENCE.P(), false);
			this.a(var1, var3, 11, 7, var4, 11, 8, var4, Blocks.NETHER_BRICK_FENCE.P(), Blocks.NETHER_BRICK_FENCE.P(), false);
		}

		this.a(var1, var3, 4, 2, 0, 8, 2, 12, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
		this.a(var1, var3, 0, 2, 4, 12, 2, 8, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
		this.a(var1, var3, 4, 0, 0, 8, 1, 3, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
		this.a(var1, var3, 4, 0, 9, 8, 1, 12, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
		this.a(var1, var3, 0, 0, 4, 3, 1, 8, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
		this.a(var1, var3, 9, 0, 4, 12, 1, 8, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);

		int var5;
		for (var4 = 4; var4 <= 8; ++var4) {
			for (var5 = 0; var5 <= 2; ++var5) {
				this.b(var1, Blocks.NETHER_BRICK.P(), var4, -1, var5, var3);
				this.b(var1, Blocks.NETHER_BRICK.P(), var4, -1, 12 - var5, var3);
			}
		}

		for (var4 = 0; var4 <= 2; ++var4) {
			for (var5 = 4; var5 <= 8; ++var5) {
				this.b(var1, Blocks.NETHER_BRICK.P(), var4, -1, var5, var3);
				this.b(var1, Blocks.NETHER_BRICK.P(), 12 - var4, -1, var5, var3);
			}
		}

		this.a(var1, var3, 5, 5, 5, 7, 5, 7, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
		this.a(var1, var3, 6, 1, 6, 6, 4, 6, Blocks.AIR.P(), Blocks.AIR.P(), false);
		this.a(var1, Blocks.NETHER_BRICK.P(), 6, 0, 6, var3);
		this.a(var1, Blocks.FLOWING_LAVA.P(), 6, 5, 6, var3);
		Position var6 = new Position(this.a(6, 6), this.d(5), this.b(6, 6));
		if (var3.b((fd) var6)) {
			var1.a((Block) Blocks.FLOWING_LAVA, var6, var2);
		}

		return true;
	}
}
