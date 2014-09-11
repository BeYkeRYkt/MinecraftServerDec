package net.minecraft;

import java.util.List;
import java.util.Random;

public class WorldGenNetherPiece16 extends WorldGenNetherPiece {

	public WorldGenNetherPiece16() {
	}

	public WorldGenNetherPiece16(int var1, Random var2, CuboidArea var3, BlockFace var4) {
		super(var1);
		this.m = var4;
		this.l = var3;
	}

	public void a(StructurePiece var1, List var2, Random var3) {
		this.c((WorldGenNetherPiece15) var1, var2, var3, 6, 2, false);
	}

	public static WorldGenNetherPiece16 a(List var0, Random var1, int var2, int var3, int var4, int var5, BlockFace var6) {
		CuboidArea var7 = CuboidArea.a(var2, var3, var4, -2, 0, 0, 7, 11, 7, var6);
		return a(var7) && StructurePiece.a(var0, var7) == null ? new WorldGenNetherPiece16(var5, var1, var7, var6) : null;
	}

	public boolean a(World var1, Random var2, CuboidArea var3) {
		this.a(var1, var3, 0, 0, 0, 6, 1, 6, Blocks.NETHER_BRICK.getBlockState(), Blocks.NETHER_BRICK.getBlockState(), false);
		this.a(var1, var3, 0, 2, 0, 6, 10, 6, Blocks.AIR.getBlockState(), Blocks.AIR.getBlockState(), false);
		this.a(var1, var3, 0, 2, 0, 1, 8, 0, Blocks.NETHER_BRICK.getBlockState(), Blocks.NETHER_BRICK.getBlockState(), false);
		this.a(var1, var3, 5, 2, 0, 6, 8, 0, Blocks.NETHER_BRICK.getBlockState(), Blocks.NETHER_BRICK.getBlockState(), false);
		this.a(var1, var3, 0, 2, 1, 0, 8, 6, Blocks.NETHER_BRICK.getBlockState(), Blocks.NETHER_BRICK.getBlockState(), false);
		this.a(var1, var3, 6, 2, 1, 6, 8, 6, Blocks.NETHER_BRICK.getBlockState(), Blocks.NETHER_BRICK.getBlockState(), false);
		this.a(var1, var3, 1, 2, 6, 5, 8, 6, Blocks.NETHER_BRICK.getBlockState(), Blocks.NETHER_BRICK.getBlockState(), false);
		this.a(var1, var3, 0, 3, 2, 0, 5, 4, Blocks.NETHER_BRICK_FENCE.getBlockState(), Blocks.NETHER_BRICK_FENCE.getBlockState(), false);
		this.a(var1, var3, 6, 3, 2, 6, 5, 2, Blocks.NETHER_BRICK_FENCE.getBlockState(), Blocks.NETHER_BRICK_FENCE.getBlockState(), false);
		this.a(var1, var3, 6, 3, 4, 6, 5, 4, Blocks.NETHER_BRICK_FENCE.getBlockState(), Blocks.NETHER_BRICK_FENCE.getBlockState(), false);
		this.a(var1, Blocks.NETHER_BRICK.getBlockState(), 5, 2, 5, var3);
		this.a(var1, var3, 4, 2, 5, 4, 3, 5, Blocks.NETHER_BRICK.getBlockState(), Blocks.NETHER_BRICK.getBlockState(), false);
		this.a(var1, var3, 3, 2, 5, 3, 4, 5, Blocks.NETHER_BRICK.getBlockState(), Blocks.NETHER_BRICK.getBlockState(), false);
		this.a(var1, var3, 2, 2, 5, 2, 5, 5, Blocks.NETHER_BRICK.getBlockState(), Blocks.NETHER_BRICK.getBlockState(), false);
		this.a(var1, var3, 1, 2, 5, 1, 6, 5, Blocks.NETHER_BRICK.getBlockState(), Blocks.NETHER_BRICK.getBlockState(), false);
		this.a(var1, var3, 1, 7, 1, 5, 7, 4, Blocks.NETHER_BRICK.getBlockState(), Blocks.NETHER_BRICK.getBlockState(), false);
		this.a(var1, var3, 6, 8, 2, 6, 8, 4, Blocks.AIR.getBlockState(), Blocks.AIR.getBlockState(), false);
		this.a(var1, var3, 2, 6, 0, 4, 8, 0, Blocks.NETHER_BRICK.getBlockState(), Blocks.NETHER_BRICK.getBlockState(), false);
		this.a(var1, var3, 2, 5, 0, 4, 5, 0, Blocks.NETHER_BRICK_FENCE.getBlockState(), Blocks.NETHER_BRICK_FENCE.getBlockState(), false);

		for (int var4 = 0; var4 <= 6; ++var4) {
			for (int var5 = 0; var5 <= 6; ++var5) {
				this.b(var1, Blocks.NETHER_BRICK.getBlockState(), var4, -1, var5, var3);
			}
		}

		return true;
	}
}
