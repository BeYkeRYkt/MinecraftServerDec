package net.minecraft;

import java.util.List;
import java.util.Random;

public class WorldGenStrongholdCrossing extends WorldGenStrongholdPiece {

	private boolean a;
	private boolean b;
	private boolean c;
	private boolean e;

	public WorldGenStrongholdCrossing() {
	}

	public WorldGenStrongholdCrossing(int var1, Random var2, CuboidArea var3, BlockFace var4) {
		super(var1);
		this.m = var4;
		this.d = this.a(var2);
		this.l = var3;
		this.a = var2.nextBoolean();
		this.b = var2.nextBoolean();
		this.c = var2.nextBoolean();
		this.e = var2.nextInt(3) > 0;
	}

	protected void a(NBTCompoundTag var1) {
		super.a(var1);
		var1.put("leftLow", this.a);
		var1.put("leftHigh", this.b);
		var1.put("rightLow", this.c);
		var1.put("rightHigh", this.e);
	}

	protected void b(NBTCompoundTag var1) {
		super.b(var1);
		this.a = var1.getBoolean("leftLow");
		this.b = var1.getBoolean("leftHigh");
		this.c = var1.getBoolean("rightLow");
		this.e = var1.getBoolean("rightHigh");
	}

	public void a(StructurePiece var1, List var2, Random var3) {
		int var4 = 3;
		int var5 = 5;
		if (this.m == BlockFace.WEST || this.m == BlockFace.NORTH) {
			var4 = 8 - var4;
			var5 = 8 - var5;
		}

		this.a((WorldGenStrongholdStart) var1, var2, var3, 5, 1);
		if (this.a) {
			this.b((WorldGenStrongholdStart) var1, var2, var3, var4, 1);
		}

		if (this.b) {
			this.b((WorldGenStrongholdStart) var1, var2, var3, var5, 7);
		}

		if (this.c) {
			this.c((WorldGenStrongholdStart) var1, var2, var3, var4, 1);
		}

		if (this.e) {
			this.c((WorldGenStrongholdStart) var1, var2, var3, var5, 7);
		}

	}

	public static WorldGenStrongholdCrossing a(List var0, Random var1, int var2, int var3, int var4, BlockFace var5, int var6) {
		CuboidArea var7 = CuboidArea.a(var2, var3, var4, -4, -3, 0, 10, 9, 11, var5);
		return a(var7) && StructurePiece.a(var0, var7) == null ? new WorldGenStrongholdCrossing(var6, var1, var7, var5) : null;
	}

	public boolean a(World var1, Random var2, CuboidArea var3) {
		if (this.a(var1, var3)) {
			return false;
		} else {
			this.a(var1, var3, 0, 0, 0, 9, 8, 10, true, var2, WorldGenStrongholdPieces.c());
			this.a(var1, var2, var3, this.d, 4, 3, 0);
			if (this.a) {
				this.a(var1, var3, 0, 3, 1, 0, 5, 3, Blocks.AIR.getBlockState(), Blocks.AIR.getBlockState(), false);
			}

			if (this.c) {
				this.a(var1, var3, 9, 3, 1, 9, 5, 3, Blocks.AIR.getBlockState(), Blocks.AIR.getBlockState(), false);
			}

			if (this.b) {
				this.a(var1, var3, 0, 5, 7, 0, 7, 9, Blocks.AIR.getBlockState(), Blocks.AIR.getBlockState(), false);
			}

			if (this.e) {
				this.a(var1, var3, 9, 5, 7, 9, 7, 9, Blocks.AIR.getBlockState(), Blocks.AIR.getBlockState(), false);
			}

			this.a(var1, var3, 5, 1, 10, 7, 3, 10, Blocks.AIR.getBlockState(), Blocks.AIR.getBlockState(), false);
			this.a(var1, var3, 1, 2, 1, 8, 2, 6, false, var2, WorldGenStrongholdPieces.c());
			this.a(var1, var3, 4, 1, 5, 4, 4, 9, false, var2, WorldGenStrongholdPieces.c());
			this.a(var1, var3, 8, 1, 5, 8, 4, 9, false, var2, WorldGenStrongholdPieces.c());
			this.a(var1, var3, 1, 4, 7, 3, 4, 9, false, var2, WorldGenStrongholdPieces.c());
			this.a(var1, var3, 1, 3, 5, 3, 3, 6, false, var2, WorldGenStrongholdPieces.c());
			this.a(var1, var3, 1, 3, 4, 3, 3, 4, Blocks.STONE_SLAB.getBlockState(), Blocks.STONE_SLAB.getBlockState(), false);
			this.a(var1, var3, 1, 4, 6, 3, 4, 6, Blocks.STONE_SLAB.getBlockState(), Blocks.STONE_SLAB.getBlockState(), false);
			this.a(var1, var3, 5, 1, 7, 7, 1, 8, false, var2, WorldGenStrongholdPieces.c());
			this.a(var1, var3, 5, 1, 9, 7, 1, 9, Blocks.STONE_SLAB.getBlockState(), Blocks.STONE_SLAB.getBlockState(), false);
			this.a(var1, var3, 5, 2, 7, 7, 2, 7, Blocks.STONE_SLAB.getBlockState(), Blocks.STONE_SLAB.getBlockState(), false);
			this.a(var1, var3, 4, 5, 7, 4, 5, 9, Blocks.STONE_SLAB.getBlockState(), Blocks.STONE_SLAB.getBlockState(), false);
			this.a(var1, var3, 8, 5, 7, 8, 5, 9, Blocks.STONE_SLAB.getBlockState(), Blocks.STONE_SLAB.getBlockState(), false);
			this.a(var1, var3, 5, 5, 7, 7, 5, 9, Blocks.DOUBLE_STONE_SLAB.getBlockState(), Blocks.DOUBLE_STONE_SLAB.getBlockState(), false);
			this.a(var1, Blocks.TORCH.getBlockState(), 6, 5, 6, var3);
			return true;
		}
	}
}
