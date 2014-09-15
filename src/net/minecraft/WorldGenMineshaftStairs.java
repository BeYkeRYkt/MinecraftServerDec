package net.minecraft;

import java.util.List;
import java.util.Random;

public class WorldGenMineshaftStairs extends StructurePiece {

	public WorldGenMineshaftStairs() {
	}

	public WorldGenMineshaftStairs(int var1, Random var2, CuboidArea var3, BlockFace var4) {
		super(var1);
		this.m = var4;
		this.l = var3;
	}

	protected void a(NBTCompoundTag var1) {
	}

	protected void b(NBTCompoundTag var1) {
	}

	public static CuboidArea a(List var0, Random var1, int var2, int var3, int var4, BlockFace var5) {
		CuboidArea var6 = new CuboidArea(var2, var3 - 5, var4, var2, var3 + 2, var4);
		switch (bjf.a[var5.ordinal()]) {
			case 1:
				var6.maxX = var2 + 2;
				var6.minZ = var4 - 8;
				break;
			case 2:
				var6.maxX = var2 + 2;
				var6.maxZ = var4 + 8;
				break;
			case 3:
				var6.minX = var2 - 8;
				var6.maxZ = var4 + 2;
				break;
			case 4:
				var6.maxX = var2 + 8;
				var6.maxZ = var4 + 2;
		}

		return StructurePiece.a(var0, var6) != null ? null : var6;
	}

	public void a(StructurePiece var1, List var2, Random var3) {
		int var4 = this.d();
		if (this.m != null) {
			switch (bjf.a[this.m.ordinal()]) {
				case 1:
					WorldGenMineshaftPieces.a(var1, var2, var3, this.l.minX, this.l.minY, this.l.minZ - 1, BlockFace.NORTH, var4);
					break;
				case 2:
					WorldGenMineshaftPieces.a(var1, var2, var3, this.l.minX, this.l.minY, this.l.maxZ + 1, BlockFace.SOUTH, var4);
					break;
				case 3:
					WorldGenMineshaftPieces.a(var1, var2, var3, this.l.minX - 1, this.l.minY, this.l.minZ, BlockFace.WEST, var4);
					break;
				case 4:
					WorldGenMineshaftPieces.a(var1, var2, var3, this.l.maxX + 1, this.l.minY, this.l.minZ, BlockFace.EAST, var4);
			}
		}

	}

	public boolean a(World var1, Random var2, CuboidArea var3) {
		if (this.a(var1, var3)) {
			return false;
		} else {
			this.a(var1, var3, 0, 5, 0, 2, 7, 1, Blocks.AIR.getBlockState(), Blocks.AIR.getBlockState(), false);
			this.a(var1, var3, 0, 0, 7, 2, 2, 8, Blocks.AIR.getBlockState(), Blocks.AIR.getBlockState(), false);

			for (int var4 = 0; var4 < 5; ++var4) {
				this.a(var1, var3, 0, 5 - var4 - (var4 < 4 ? 1 : 0), 2 + var4, 2, 7 - var4, 2 + var4, Blocks.AIR.getBlockState(), Blocks.AIR.getBlockState(), false);
			}

			return true;
		}
	}
}
