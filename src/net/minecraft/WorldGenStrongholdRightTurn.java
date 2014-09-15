package net.minecraft;

import java.util.List;
import java.util.Random;

public class WorldGenStrongholdRightTurn extends WorldGenStrongholdLeftTurn {

	public void a(StructurePiece var1, List var2, Random var3) {
		if (this.m != BlockFace.NORTH && this.m != BlockFace.EAST) {
			this.b((WorldGenStrongholdStart) var1, var2, var3, 1, 1);
		} else {
			this.c((WorldGenStrongholdStart) var1, var2, var3, 1, 1);
		}

	}

	public boolean a(World var1, Random var2, CuboidArea var3) {
		if (this.a(var1, var3)) {
			return false;
		} else {
			this.a(var1, var3, 0, 0, 0, 4, 4, 4, true, var2, WorldGenStrongholdPieces.c());
			this.a(var1, var2, var3, this.d, 1, 1, 0);
			if (this.m != BlockFace.NORTH && this.m != BlockFace.EAST) {
				this.a(var1, var3, 0, 1, 1, 0, 3, 3, Blocks.AIR.getBlockState(), Blocks.AIR.getBlockState(), false);
			} else {
				this.a(var1, var3, 4, 1, 1, 4, 3, 3, Blocks.AIR.getBlockState(), Blocks.AIR.getBlockState(), false);
			}

			return true;
		}
	}
}
