package net.minecraft;

import java.util.List;
import java.util.Random;

public class WorldGenStrongholdLeftTurn extends WorldGenStrongholdPiece {

	public WorldGenStrongholdLeftTurn() {
	}

	public WorldGenStrongholdLeftTurn(int var1, Random var2, CuboidArea var3, BlockFace var4) {
		super(var1);
		this.m = var4;
		this.d = this.a(var2);
		this.l = var3;
	}

	public void a(StructurePiece var1, List var2, Random var3) {
		if (this.m != BlockFace.NORTH && this.m != BlockFace.EAST) {
			this.c((WorldGenStrongholdStart) var1, var2, var3, 1, 1);
		} else {
			this.b((WorldGenStrongholdStart) var1, var2, var3, 1, 1);
		}

	}

	public static WorldGenStrongholdLeftTurn a(List var0, Random var1, int var2, int var3, int var4, BlockFace var5, int var6) {
		CuboidArea var7 = CuboidArea.a(var2, var3, var4, -1, -1, 0, 5, 5, 5, var5);
		return a(var7) && StructurePiece.a(var0, var7) == null ? new WorldGenStrongholdLeftTurn(var6, var1, var7, var5) : null;
	}

	public boolean a(World var1, Random var2, CuboidArea var3) {
		if (this.a(var1, var3)) {
			return false;
		} else {
			this.a(var1, var3, 0, 0, 0, 4, 4, 4, true, var2, WorldGenStrongholdPieces.c());
			this.a(var1, var2, var3, this.d, 1, 1, 0);
			if (this.m != BlockFace.NORTH && this.m != BlockFace.EAST) {
				this.a(var1, var3, 4, 1, 1, 4, 3, 3, Blocks.AIR.getBlockState(), Blocks.AIR.getBlockState(), false);
			} else {
				this.a(var1, var3, 0, 1, 1, 0, 3, 3, Blocks.AIR.getBlockState(), Blocks.AIR.getBlockState(), false);
			}

			return true;
		}
	}
}
