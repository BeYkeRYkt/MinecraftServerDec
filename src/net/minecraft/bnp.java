package net.minecraft;

import java.util.List;
import java.util.Random;

public class bnp extends bnn {

	public bnp() {
	}

	public bnp(bnk var1, int var2, Random var3, int var4, int var5) {
		super(var1, var2);
		this.m = UniverseDirection.HORIZONTAL.getRandomBlockFace(var3);
		switch (bmz.a[this.m.ordinal()]) {
			case 1:
			case 2:
				this.l = new CuboidArea(var4, 64, var5, var4 + 6 - 1, 78, var5 + 6 - 1);
				break;
			default:
				this.l = new CuboidArea(var4, 64, var5, var4 + 6 - 1, 78, var5 + 6 - 1);
		}

	}

	public void a(StructurePiece var1, List var2, Random var3) {
		bmy.b((bnk) var1, var2, var3, this.l.minX - 1, this.l.maxY - 4, this.l.minZ + 1, BlockFace.WEST, this.d());
		bmy.b((bnk) var1, var2, var3, this.l.maxX + 1, this.l.maxY - 4, this.l.minZ + 1, BlockFace.EAST, this.d());
		bmy.b((bnk) var1, var2, var3, this.l.minX + 1, this.l.maxY - 4, this.l.minZ - 1, BlockFace.NORTH, this.d());
		bmy.b((bnk) var1, var2, var3, this.l.minX + 1, this.l.maxY - 4, this.l.maxZ + 1, BlockFace.SOUTH, this.d());
	}

	public boolean a(World var1, Random var2, CuboidArea var3) {
		if (this.h < 0) {
			this.h = this.b(var1, var3);
			if (this.h < 0) {
				return true;
			}

			this.l.a(0, this.h - this.l.maxY + 3, 0);
		}

		this.a(var1, var3, 1, 0, 1, 4, 12, 4, Blocks.COBBLESTONE.getBlockState(), Blocks.FLOWING_WATER.getBlockState(), false);
		this.a(var1, Blocks.AIR.getBlockState(), 2, 12, 2, var3);
		this.a(var1, Blocks.AIR.getBlockState(), 3, 12, 2, var3);
		this.a(var1, Blocks.AIR.getBlockState(), 2, 12, 3, var3);
		this.a(var1, Blocks.AIR.getBlockState(), 3, 12, 3, var3);
		this.a(var1, Blocks.FENCE.getBlockState(), 1, 13, 1, var3);
		this.a(var1, Blocks.FENCE.getBlockState(), 1, 14, 1, var3);
		this.a(var1, Blocks.FENCE.getBlockState(), 4, 13, 1, var3);
		this.a(var1, Blocks.FENCE.getBlockState(), 4, 14, 1, var3);
		this.a(var1, Blocks.FENCE.getBlockState(), 1, 13, 4, var3);
		this.a(var1, Blocks.FENCE.getBlockState(), 1, 14, 4, var3);
		this.a(var1, Blocks.FENCE.getBlockState(), 4, 13, 4, var3);
		this.a(var1, Blocks.FENCE.getBlockState(), 4, 14, 4, var3);
		this.a(var1, var3, 1, 15, 1, 4, 15, 4, Blocks.COBBLESTONE.getBlockState(), Blocks.COBBLESTONE.getBlockState(), false);

		for (int var4 = 0; var4 <= 5; ++var4) {
			for (int var5 = 0; var5 <= 5; ++var5) {
				if (var5 == 0 || var5 == 5 || var4 == 0 || var4 == 5) {
					this.a(var1, Blocks.GRAVEL.getBlockState(), var5, 11, var4, var3);
					this.b(var1, var5, 12, var4, var3);
				}
			}
		}

		return true;
	}
}
