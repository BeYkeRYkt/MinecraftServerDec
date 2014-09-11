package net.minecraft;

import java.util.List;
import java.util.Random;

public class bka extends bkb {

	private boolean b;

	public bka() {
	}

	public bka(int var1, Random var2, CuboidArea var3, BlockFace var4) {
		super(var1);
		this.m = var4;
		this.l = var3;
	}

	protected void b(NBTCompoundTag var1) {
		super.b(var1);
		this.b = var1.getBoolean("Mob");
	}

	protected void a(NBTCompoundTag var1) {
		super.a(var1);
		var1.put("Mob", this.b);
	}

	public static bka a(List var0, Random var1, int var2, int var3, int var4, int var5, BlockFace var6) {
		CuboidArea var7 = CuboidArea.a(var2, var3, var4, -2, 0, 0, 7, 8, 9, var6);
		return a(var7) && StructurePiece.a(var0, var7) == null ? new bka(var5, var1, var7, var6) : null;
	}

	public boolean a(World var1, Random var2, CuboidArea var3) {
		this.a(var1, var3, 0, 2, 0, 6, 7, 7, Blocks.AIR.getBlockState(), Blocks.AIR.getBlockState(), false);
		this.a(var1, var3, 1, 0, 0, 5, 1, 7, Blocks.NETHER_BRICK.getBlockState(), Blocks.NETHER_BRICK.getBlockState(), false);
		this.a(var1, var3, 1, 2, 1, 5, 2, 7, Blocks.NETHER_BRICK.getBlockState(), Blocks.NETHER_BRICK.getBlockState(), false);
		this.a(var1, var3, 1, 3, 2, 5, 3, 7, Blocks.NETHER_BRICK.getBlockState(), Blocks.NETHER_BRICK.getBlockState(), false);
		this.a(var1, var3, 1, 4, 3, 5, 4, 7, Blocks.NETHER_BRICK.getBlockState(), Blocks.NETHER_BRICK.getBlockState(), false);
		this.a(var1, var3, 1, 2, 0, 1, 4, 2, Blocks.NETHER_BRICK.getBlockState(), Blocks.NETHER_BRICK.getBlockState(), false);
		this.a(var1, var3, 5, 2, 0, 5, 4, 2, Blocks.NETHER_BRICK.getBlockState(), Blocks.NETHER_BRICK.getBlockState(), false);
		this.a(var1, var3, 1, 5, 2, 1, 5, 3, Blocks.NETHER_BRICK.getBlockState(), Blocks.NETHER_BRICK.getBlockState(), false);
		this.a(var1, var3, 5, 5, 2, 5, 5, 3, Blocks.NETHER_BRICK.getBlockState(), Blocks.NETHER_BRICK.getBlockState(), false);
		this.a(var1, var3, 0, 5, 3, 0, 5, 8, Blocks.NETHER_BRICK.getBlockState(), Blocks.NETHER_BRICK.getBlockState(), false);
		this.a(var1, var3, 6, 5, 3, 6, 5, 8, Blocks.NETHER_BRICK.getBlockState(), Blocks.NETHER_BRICK.getBlockState(), false);
		this.a(var1, var3, 1, 5, 8, 5, 5, 8, Blocks.NETHER_BRICK.getBlockState(), Blocks.NETHER_BRICK.getBlockState(), false);
		this.a(var1, Blocks.NETHER_BRICK_FENCE.getBlockState(), 1, 6, 3, var3);
		this.a(var1, Blocks.NETHER_BRICK_FENCE.getBlockState(), 5, 6, 3, var3);
		this.a(var1, var3, 0, 6, 3, 0, 6, 8, Blocks.NETHER_BRICK_FENCE.getBlockState(), Blocks.NETHER_BRICK_FENCE.getBlockState(), false);
		this.a(var1, var3, 6, 6, 3, 6, 6, 8, Blocks.NETHER_BRICK_FENCE.getBlockState(), Blocks.NETHER_BRICK_FENCE.getBlockState(), false);
		this.a(var1, var3, 1, 6, 8, 5, 7, 8, Blocks.NETHER_BRICK_FENCE.getBlockState(), Blocks.NETHER_BRICK_FENCE.getBlockState(), false);
		this.a(var1, var3, 2, 8, 8, 4, 8, 8, Blocks.NETHER_BRICK_FENCE.getBlockState(), Blocks.NETHER_BRICK_FENCE.getBlockState(), false);
		if (!this.b) {
			Position var4 = new Position(this.a(3, 5), this.d(5), this.b(3, 5));
			if (var3.b((fd) var4)) {
				this.b = true;
				var1.a(var4, Blocks.MOB_SPAWNER.getBlockState(), 2);
				TileEntity var5 = var1.getTileEntity(var4);
				if (var5 instanceof TileEntityMobSpawner) {
					((TileEntityMobSpawner) var5).b().a("Blaze");
				}
			}
		}

		for (int var6 = 0; var6 <= 6; ++var6) {
			for (int var7 = 0; var7 <= 6; ++var7) {
				this.b(var1, Blocks.NETHER_BRICK.getBlockState(), var6, -1, var7, var3);
			}
		}

		return true;
	}
}
