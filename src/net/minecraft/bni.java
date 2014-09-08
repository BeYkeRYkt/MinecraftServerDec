package net.minecraft;

import java.util.List;
import java.util.Random;

public class bni extends bnn {

	public bni() {
	}

	public bni(bnk var1, int var2, Random var3, bjb var4, BlockFace var5) {
		super(var1, var2);
		this.m = var5;
		this.l = var4;
	}

	public static bni a(bnk var0, List var1, Random var2, int var3, int var4, int var5, BlockFace var6, int var7) {
		bjb var8 = bjb.a(var3, var4, var5, 0, 0, 0, 5, 12, 9, var6);
		return a(var8) && bms.a(var1, var8) == null ? new bni(var0, var7, var2, var8, var6) : null;
	}

	public boolean a(World var1, Random var2, bjb var3) {
		if (this.h < 0) {
			this.h = this.b(var1, var3);
			if (this.h < 0) {
				return true;
			}

			this.l.a(0, this.h - this.l.e + 12 - 1, 0);
		}

		this.a(var1, var3, 1, 1, 1, 3, 3, 7, Blocks.AIR.P(), Blocks.AIR.P(), false);
		this.a(var1, var3, 1, 5, 1, 3, 9, 3, Blocks.AIR.P(), Blocks.AIR.P(), false);
		this.a(var1, var3, 1, 0, 0, 3, 0, 8, Blocks.COBBLESTONE.P(), Blocks.COBBLESTONE.P(), false);
		this.a(var1, var3, 1, 1, 0, 3, 10, 0, Blocks.COBBLESTONE.P(), Blocks.COBBLESTONE.P(), false);
		this.a(var1, var3, 0, 1, 1, 0, 10, 3, Blocks.COBBLESTONE.P(), Blocks.COBBLESTONE.P(), false);
		this.a(var1, var3, 4, 1, 1, 4, 10, 3, Blocks.COBBLESTONE.P(), Blocks.COBBLESTONE.P(), false);
		this.a(var1, var3, 0, 0, 4, 0, 4, 7, Blocks.COBBLESTONE.P(), Blocks.COBBLESTONE.P(), false);
		this.a(var1, var3, 4, 0, 4, 4, 4, 7, Blocks.COBBLESTONE.P(), Blocks.COBBLESTONE.P(), false);
		this.a(var1, var3, 1, 1, 8, 3, 4, 8, Blocks.COBBLESTONE.P(), Blocks.COBBLESTONE.P(), false);
		this.a(var1, var3, 1, 5, 4, 3, 10, 4, Blocks.COBBLESTONE.P(), Blocks.COBBLESTONE.P(), false);
		this.a(var1, var3, 1, 5, 5, 3, 5, 7, Blocks.COBBLESTONE.P(), Blocks.COBBLESTONE.P(), false);
		this.a(var1, var3, 0, 9, 0, 4, 9, 4, Blocks.COBBLESTONE.P(), Blocks.COBBLESTONE.P(), false);
		this.a(var1, var3, 0, 4, 0, 4, 4, 4, Blocks.COBBLESTONE.P(), Blocks.COBBLESTONE.P(), false);
		this.a(var1, Blocks.COBBLESTONE.P(), 0, 11, 2, var3);
		this.a(var1, Blocks.COBBLESTONE.P(), 4, 11, 2, var3);
		this.a(var1, Blocks.COBBLESTONE.P(), 2, 11, 0, var3);
		this.a(var1, Blocks.COBBLESTONE.P(), 2, 11, 4, var3);
		this.a(var1, Blocks.COBBLESTONE.P(), 1, 1, 6, var3);
		this.a(var1, Blocks.COBBLESTONE.P(), 1, 1, 7, var3);
		this.a(var1, Blocks.COBBLESTONE.P(), 2, 1, 7, var3);
		this.a(var1, Blocks.COBBLESTONE.P(), 3, 1, 6, var3);
		this.a(var1, Blocks.COBBLESTONE.P(), 3, 1, 7, var3);
		this.a(var1, Blocks.STONE_STAIRS.a(this.a(Blocks.STONE_STAIRS, 3)), 1, 1, 5, var3);
		this.a(var1, Blocks.STONE_STAIRS.a(this.a(Blocks.STONE_STAIRS, 3)), 2, 1, 6, var3);
		this.a(var1, Blocks.STONE_STAIRS.a(this.a(Blocks.STONE_STAIRS, 3)), 3, 1, 5, var3);
		this.a(var1, Blocks.STONE_STAIRS.a(this.a(Blocks.STONE_STAIRS, 1)), 1, 2, 7, var3);
		this.a(var1, Blocks.STONE_STAIRS.a(this.a(Blocks.STONE_STAIRS, 0)), 3, 2, 7, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 0, 2, 2, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 0, 3, 2, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 4, 2, 2, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 4, 3, 2, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 0, 6, 2, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 0, 7, 2, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 4, 6, 2, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 4, 7, 2, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 2, 6, 0, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 2, 7, 0, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 2, 6, 4, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 2, 7, 4, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 0, 3, 6, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 4, 3, 6, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 2, 3, 8, var3);
		this.a(var1, Blocks.TORCH.P().a(BlockTorch.a, this.m.getOpposite()), 2, 4, 7, var3);
		this.a(var1, Blocks.TORCH.P().a(BlockTorch.a, this.m.e()), 1, 4, 6, var3);
		this.a(var1, Blocks.TORCH.P().a(BlockTorch.a, this.m.f()), 3, 4, 6, var3);
		this.a(var1, Blocks.TORCH.P().a(BlockTorch.a, this.m), 2, 4, 5, var3);
		int var4 = this.a(Blocks.LADDER, 4);

		int var5;
		for (var5 = 1; var5 <= 9; ++var5) {
			this.a(var1, Blocks.LADDER.a(var4), 3, var5, 3, var3);
		}

		this.a(var1, Blocks.AIR.P(), 2, 1, 0, var3);
		this.a(var1, Blocks.AIR.P(), 2, 2, 0, var3);
		this.a(var1, var3, var2, 2, 1, 0, BlockFace.fromDirection(this.a(Blocks.WOODEN_DOOR, 1)));
		if (this.a(var1, 2, 0, -1, var3).getBlock().r() == Material.AIR && this.a(var1, 2, -1, -1, var3).getBlock().r() != Material.AIR) {
			this.a(var1, Blocks.STONE_STAIRS.a(this.a(Blocks.STONE_STAIRS, 3)), 2, 0, -1, var3);
		}

		for (var5 = 0; var5 < 9; ++var5) {
			for (int var6 = 0; var6 < 5; ++var6) {
				this.b(var1, var6, 12, var5, var3);
				this.b(var1, Blocks.COBBLESTONE.P(), var6, -1, var5, var3);
			}
		}

		this.a(var1, var3, 2, 1, 2, 1);
		return true;
	}

	protected int c(int var1, int var2) {
		return 2;
	}
}
