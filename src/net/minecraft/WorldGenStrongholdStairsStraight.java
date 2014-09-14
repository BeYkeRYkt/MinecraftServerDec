package net.minecraft;

import java.util.List;
import java.util.Random;

public class WorldGenStrongholdStairsStraight extends WorldGenStrongholdPiece {

	public WorldGenStrongholdStairsStraight() {
	}

	public WorldGenStrongholdStairsStraight(int var1, Random var2, CuboidArea var3, BlockFace var4) {
		super(var1);
		this.m = var4;
		this.d = this.a(var2);
		this.l = var3;
	}

	public void a(StructurePiece var1, List var2, Random var3) {
		this.a((WorldGenStrongholdStart) var1, var2, var3, 1, 1);
	}

	public static WorldGenStrongholdStairsStraight a(List var0, Random var1, int var2, int var3, int var4, BlockFace var5, int var6) {
		CuboidArea var7 = CuboidArea.a(var2, var3, var4, -1, -7, 0, 5, 11, 8, var5);
		return a(var7) && StructurePiece.a(var0, var7) == null ? new WorldGenStrongholdStairsStraight(var6, var1, var7, var5) : null;
	}

	public boolean a(World var1, Random var2, CuboidArea var3) {
		if (this.a(var1, var3)) {
			return false;
		} else {
			this.a(var1, var3, 0, 0, 0, 4, 10, 7, true, var2, WorldGenStrongholdPieces.c());
			this.a(var1, var2, var3, this.d, 1, 7, 0);
			this.a(var1, var2, var3, bml.a, 1, 1, 7);
			int var4 = this.a(Blocks.STONE_STAIRS, 2);

			for (int var5 = 0; var5 < 6; ++var5) {
				this.a(var1, Blocks.STONE_STAIRS.setData(var4), 1, 6 - var5, 1 + var5, var3);
				this.a(var1, Blocks.STONE_STAIRS.setData(var4), 2, 6 - var5, 1 + var5, var3);
				this.a(var1, Blocks.STONE_STAIRS.setData(var4), 3, 6 - var5, 1 + var5, var3);
				if (var5 < 5) {
					this.a(var1, Blocks.STONEBRICK.getBlockState(), 1, 5 - var5, 1 + var5, var3);
					this.a(var1, Blocks.STONEBRICK.getBlockState(), 2, 5 - var5, 1 + var5, var3);
					this.a(var1, Blocks.STONEBRICK.getBlockState(), 3, 5 - var5, 1 + var5, var3);
				}
			}

			return true;
		}
	}
}
