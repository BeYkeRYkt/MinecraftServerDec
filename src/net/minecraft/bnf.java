package net.minecraft;

import java.util.List;
import java.util.Random;

public class bnf extends bnn {

	public bnf() {
	}

	public bnf(bnk var1, int var2, Random var3, bjb var4, PaintingDirection var5) {
		super(var1, var2);
		this.m = var5;
		this.l = var4;
	}

	public static bnf a(bnk var0, List var1, Random var2, int var3, int var4, int var5, PaintingDirection var6, int var7) {
		bjb var8 = bjb.a(var3, var4, var5, 0, 0, 0, 9, 7, 11, var6);
		return a(var8) && bms.a(var1, var8) == null ? new bnf(var0, var7, var2, var8, var6) : null;
	}

	public boolean a(World var1, Random var2, bjb var3) {
		if (this.h < 0) {
			this.h = this.b(var1, var3);
			if (this.h < 0) {
				return true;
			}

			this.l.a(0, this.h - this.l.e + 7 - 1, 0);
		}

		this.a(var1, var3, 1, 1, 1, 7, 4, 4, Blocks.AIR.P(), Blocks.AIR.P(), false);
		this.a(var1, var3, 2, 1, 6, 8, 4, 10, Blocks.AIR.P(), Blocks.AIR.P(), false);
		this.a(var1, var3, 2, 0, 6, 8, 0, 10, Blocks.DIRT.P(), Blocks.DIRT.P(), false);
		this.a(var1, Blocks.COBBLESTONE.P(), 6, 0, 6, var3);
		this.a(var1, var3, 2, 1, 6, 2, 1, 10, Blocks.FENCE.P(), Blocks.FENCE.P(), false);
		this.a(var1, var3, 8, 1, 6, 8, 1, 10, Blocks.FENCE.P(), Blocks.FENCE.P(), false);
		this.a(var1, var3, 3, 1, 10, 7, 1, 10, Blocks.FENCE.P(), Blocks.FENCE.P(), false);
		this.a(var1, var3, 1, 0, 1, 7, 0, 4, Blocks.PLANKS.P(), Blocks.PLANKS.P(), false);
		this.a(var1, var3, 0, 0, 0, 0, 3, 5, Blocks.COBBLESTONE.P(), Blocks.COBBLESTONE.P(), false);
		this.a(var1, var3, 8, 0, 0, 8, 3, 5, Blocks.COBBLESTONE.P(), Blocks.COBBLESTONE.P(), false);
		this.a(var1, var3, 1, 0, 0, 7, 1, 0, Blocks.COBBLESTONE.P(), Blocks.COBBLESTONE.P(), false);
		this.a(var1, var3, 1, 0, 5, 7, 1, 5, Blocks.COBBLESTONE.P(), Blocks.COBBLESTONE.P(), false);
		this.a(var1, var3, 1, 2, 0, 7, 3, 0, Blocks.PLANKS.P(), Blocks.PLANKS.P(), false);
		this.a(var1, var3, 1, 2, 5, 7, 3, 5, Blocks.PLANKS.P(), Blocks.PLANKS.P(), false);
		this.a(var1, var3, 0, 4, 1, 8, 4, 1, Blocks.PLANKS.P(), Blocks.PLANKS.P(), false);
		this.a(var1, var3, 0, 4, 4, 8, 4, 4, Blocks.PLANKS.P(), Blocks.PLANKS.P(), false);
		this.a(var1, var3, 0, 5, 2, 8, 5, 3, Blocks.PLANKS.P(), Blocks.PLANKS.P(), false);
		this.a(var1, Blocks.PLANKS.P(), 0, 4, 2, var3);
		this.a(var1, Blocks.PLANKS.P(), 0, 4, 3, var3);
		this.a(var1, Blocks.PLANKS.P(), 8, 4, 2, var3);
		this.a(var1, Blocks.PLANKS.P(), 8, 4, 3, var3);
		int var4 = this.a(Blocks.OAK_STAIRS, 3);
		int var5 = this.a(Blocks.OAK_STAIRS, 2);

		int var6;
		int var7;
		for (var6 = -1; var6 <= 2; ++var6) {
			for (var7 = 0; var7 <= 8; ++var7) {
				this.a(var1, Blocks.OAK_STAIRS.a(var4), var7, 4 + var6, var6, var3);
				this.a(var1, Blocks.OAK_STAIRS.a(var5), var7, 4 + var6, 5 - var6, var3);
			}
		}

		this.a(var1, Blocks.LOG.P(), 0, 2, 1, var3);
		this.a(var1, Blocks.LOG.P(), 0, 2, 4, var3);
		this.a(var1, Blocks.LOG.P(), 8, 2, 1, var3);
		this.a(var1, Blocks.LOG.P(), 8, 2, 4, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 0, 2, 2, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 0, 2, 3, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 8, 2, 2, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 8, 2, 3, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 2, 2, 5, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 3, 2, 5, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 5, 2, 0, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 6, 2, 5, var3);
		this.a(var1, Blocks.FENCE.P(), 2, 1, 3, var3);
		this.a(var1, Blocks.WOODEN_PRESSURE_PLATE.P(), 2, 2, 3, var3);
		this.a(var1, Blocks.PLANKS.P(), 1, 1, 4, var3);
		this.a(var1, Blocks.OAK_STAIRS.a(this.a(Blocks.OAK_STAIRS, 3)), 2, 1, 4, var3);
		this.a(var1, Blocks.OAK_STAIRS.a(this.a(Blocks.OAK_STAIRS, 1)), 1, 1, 3, var3);
		this.a(var1, var3, 5, 0, 1, 7, 0, 3, Blocks.DOUBLE_STONE_SLAB.P(), Blocks.DOUBLE_STONE_SLAB.P(), false);
		this.a(var1, Blocks.DOUBLE_STONE_SLAB.P(), 6, 1, 1, var3);
		this.a(var1, Blocks.DOUBLE_STONE_SLAB.P(), 6, 1, 2, var3);
		this.a(var1, Blocks.AIR.P(), 2, 1, 0, var3);
		this.a(var1, Blocks.AIR.P(), 2, 2, 0, var3);
		this.a(var1, Blocks.TORCH.P().a(BlockTorch.a, this.m), 2, 3, 1, var3);
		this.a(var1, var3, var2, 2, 1, 0, PaintingDirection.fromByte(this.a(Blocks.WOODEN_DOOR, 1)));
		if (this.a(var1, 2, 0, -1, var3).getBlock().r() == Material.AIR && this.a(var1, 2, -1, -1, var3).getBlock().r() != Material.AIR) {
			this.a(var1, Blocks.STONE_STAIRS.a(this.a(Blocks.STONE_STAIRS, 3)), 2, 0, -1, var3);
		}

		this.a(var1, Blocks.AIR.P(), 6, 1, 5, var3);
		this.a(var1, Blocks.AIR.P(), 6, 2, 5, var3);
		this.a(var1, Blocks.TORCH.P().a(BlockTorch.a, this.m.d()), 6, 3, 4, var3);
		this.a(var1, var3, var2, 6, 1, 5, PaintingDirection.fromByte(this.a(Blocks.WOODEN_DOOR, 1)));

		for (var6 = 0; var6 < 5; ++var6) {
			for (var7 = 0; var7 < 9; ++var7) {
				this.b(var1, var7, 7, var6, var3);
				this.b(var1, Blocks.COBBLESTONE.P(), var7, -1, var6, var3);
			}
		}

		this.a(var1, var3, 4, 1, 2, 2);
		return true;
	}

	protected int c(int var1, int var2) {
		return var1 == 0 ? 4 : super.c(var1, var2);
	}
}
