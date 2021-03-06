package net.minecraft;

import java.util.List;
import java.util.Random;

public class WorldGenStrongholdStairs extends WorldGenStrongholdPiece {

	private boolean a;
	private boolean b;

	public WorldGenStrongholdStairs() {
	}

	public WorldGenStrongholdStairs(int var1, Random var2, CuboidArea var3, BlockFace var4) {
		super(var1);
		this.m = var4;
		this.d = this.a(var2);
		this.l = var3;
		this.a = var2.nextInt(2) == 0;
		this.b = var2.nextInt(2) == 0;
	}

	protected void a(NBTCompoundTag var1) {
		super.a(var1);
		var1.put("Left", this.a);
		var1.put("Right", this.b);
	}

	protected void b(NBTCompoundTag var1) {
		super.b(var1);
		this.a = var1.getBoolean("Left");
		this.b = var1.getBoolean("Right");
	}

	public void a(StructurePiece var1, List var2, Random var3) {
		this.a((WorldGenStrongholdStart) var1, var2, var3, 1, 1);
		if (this.a) {
			this.b((WorldGenStrongholdStart) var1, var2, var3, 1, 2);
		}

		if (this.b) {
			this.c((WorldGenStrongholdStart) var1, var2, var3, 1, 2);
		}

	}

	public static WorldGenStrongholdStairs a(List var0, Random var1, int var2, int var3, int var4, BlockFace var5, int var6) {
		CuboidArea var7 = CuboidArea.a(var2, var3, var4, -1, -1, 0, 5, 5, 7, var5);
		return a(var7) && StructurePiece.a(var0, var7) == null ? new WorldGenStrongholdStairs(var6, var1, var7, var5) : null;
	}

	public boolean a(World var1, Random var2, CuboidArea var3) {
		if (this.a(var1, var3)) {
			return false;
		} else {
			this.a(var1, var3, 0, 0, 0, 4, 4, 6, true, var2, WorldGenStrongholdPieces.c());
			this.a(var1, var2, var3, this.d, 1, 1, 0);
			this.a(var1, var2, var3, bml.a, 1, 1, 6);
			this.a(var1, var3, var2, 0.1F, 1, 2, 1, Blocks.TORCH.getBlockState());
			this.a(var1, var3, var2, 0.1F, 3, 2, 1, Blocks.TORCH.getBlockState());
			this.a(var1, var3, var2, 0.1F, 1, 2, 5, Blocks.TORCH.getBlockState());
			this.a(var1, var3, var2, 0.1F, 3, 2, 5, Blocks.TORCH.getBlockState());
			if (this.a) {
				this.a(var1, var3, 0, 1, 2, 0, 3, 4, Blocks.AIR.getBlockState(), Blocks.AIR.getBlockState(), false);
			}

			if (this.b) {
				this.a(var1, var3, 4, 1, 2, 4, 3, 4, Blocks.AIR.getBlockState(), Blocks.AIR.getBlockState(), false);
			}

			return true;
		}
	}
}
