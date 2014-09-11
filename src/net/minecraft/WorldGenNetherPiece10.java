package net.minecraft;

import java.util.List;
import java.util.Random;

public class WorldGenNetherPiece10 extends WorldGenNetherPiece {

	private boolean b;

	public WorldGenNetherPiece10() {
	}

	public WorldGenNetherPiece10(int var1, Random var2, CuboidArea var3, BlockFace var4) {
		super(var1);
		this.m = var4;
		this.l = var3;
		this.b = var2.nextInt(3) == 0;
	}

	protected void b(NBTCompoundTag var1) {
		super.b(var1);
		this.b = var1.getBoolean("Chest");
	}

	protected void a(NBTCompoundTag var1) {
		super.a(var1);
		var1.put("Chest", this.b);
	}

	public void a(StructurePiece var1, List var2, Random var3) {
		this.c((WorldGenNetherPiece15) var1, var2, var3, 0, 1, true);
	}

	public static WorldGenNetherPiece10 a(List var0, Random var1, int var2, int var3, int var4, BlockFace var5, int var6) {
		CuboidArea var7 = CuboidArea.a(var2, var3, var4, -1, 0, 0, 5, 7, 5, var5);
		return a(var7) && StructurePiece.a(var0, var7) == null ? new WorldGenNetherPiece10(var6, var1, var7, var5) : null;
	}

	public boolean a(World var1, Random var2, CuboidArea var3) {
		this.a(var1, var3, 0, 0, 0, 4, 1, 4, Blocks.NETHER_BRICK.getBlockState(), Blocks.NETHER_BRICK.getBlockState(), false);
		this.a(var1, var3, 0, 2, 0, 4, 5, 4, Blocks.AIR.getBlockState(), Blocks.AIR.getBlockState(), false);
		this.a(var1, var3, 0, 2, 0, 0, 5, 4, Blocks.NETHER_BRICK.getBlockState(), Blocks.NETHER_BRICK.getBlockState(), false);
		this.a(var1, var3, 0, 3, 1, 0, 4, 1, Blocks.NETHER_BRICK_FENCE.getBlockState(), Blocks.NETHER_BRICK_FENCE.getBlockState(), false);
		this.a(var1, var3, 0, 3, 3, 0, 4, 3, Blocks.NETHER_BRICK_FENCE.getBlockState(), Blocks.NETHER_BRICK_FENCE.getBlockState(), false);
		this.a(var1, var3, 4, 2, 0, 4, 5, 0, Blocks.NETHER_BRICK.getBlockState(), Blocks.NETHER_BRICK.getBlockState(), false);
		this.a(var1, var3, 1, 2, 4, 4, 5, 4, Blocks.NETHER_BRICK.getBlockState(), Blocks.NETHER_BRICK.getBlockState(), false);
		this.a(var1, var3, 1, 3, 4, 1, 4, 4, Blocks.NETHER_BRICK_FENCE.getBlockState(), Blocks.NETHER_BRICK.getBlockState(), false);
		this.a(var1, var3, 3, 3, 4, 3, 4, 4, Blocks.NETHER_BRICK_FENCE.getBlockState(), Blocks.NETHER_BRICK.getBlockState(), false);
		if (this.b && var3.b((fd) (new Position(this.a(1, 3), this.d(2), this.b(1, 3))))) {
			this.b = false;
			this.a(var1, var3, var2, 1, 2, 3, a, 2 + var2.nextInt(4));
		}

		this.a(var1, var3, 0, 6, 0, 4, 6, 4, Blocks.NETHER_BRICK.getBlockState(), Blocks.NETHER_BRICK.getBlockState(), false);

		for (int var4 = 0; var4 <= 4; ++var4) {
			for (int var5 = 0; var5 <= 4; ++var5) {
				this.b(var1, Blocks.NETHER_BRICK.getBlockState(), var4, -1, var5, var3);
			}
		}

		return true;
	}
}
