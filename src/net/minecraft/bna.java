package net.minecraft;

import java.util.List;
import java.util.Random;

public class bna extends bnn {

	public bna() {
	}

	public bna(bnk var1, int var2, Random var3, bjb var4, PaintingDirection var5) {
		super(var1, var2);
		this.m = var5;
		this.l = var4;
	}

	public static bna a(bnk var0, List var1, Random var2, int var3, int var4, int var5, PaintingDirection var6, int var7) {
		bjb var8 = bjb.a(var3, var4, var5, 0, 0, 0, 9, 9, 6, var6);
		return a(var8) && bms.a(var1, var8) == null ? new bna(var0, var7, var2, var8, var6) : null;
	}

	public boolean a(World var1, Random var2, bjb var3) {
		if (this.h < 0) {
			this.h = this.b(var1, var3);
			if (this.h < 0) {
				return true;
			}

			this.l.a(0, this.h - this.l.e + 9 - 1, 0);
		}

		this.a(var1, var3, 1, 1, 1, 7, 5, 4, Blocks.AIR.P(), Blocks.AIR.P(), false);
		this.a(var1, var3, 0, 0, 0, 8, 0, 5, Blocks.COBBLESTONE.P(), Blocks.COBBLESTONE.P(), false);
		this.a(var1, var3, 0, 5, 0, 8, 5, 5, Blocks.COBBLESTONE.P(), Blocks.COBBLESTONE.P(), false);
		this.a(var1, var3, 0, 6, 1, 8, 6, 4, Blocks.COBBLESTONE.P(), Blocks.COBBLESTONE.P(), false);
		this.a(var1, var3, 0, 7, 2, 8, 7, 3, Blocks.COBBLESTONE.P(), Blocks.COBBLESTONE.P(), false);
		int var4 = this.a(Blocks.OAK_STAIRS, 3);
		int var5 = this.a(Blocks.OAK_STAIRS, 2);

		int var6;
		int var7;
		for (var6 = -1; var6 <= 2; ++var6) {
			for (var7 = 0; var7 <= 8; ++var7) {
				this.a(var1, Blocks.OAK_STAIRS.a(var4), var7, 6 + var6, var6, var3);
				this.a(var1, Blocks.OAK_STAIRS.a(var5), var7, 6 + var6, 5 - var6, var3);
			}
		}

		this.a(var1, var3, 0, 1, 0, 0, 1, 5, Blocks.COBBLESTONE.P(), Blocks.COBBLESTONE.P(), false);
		this.a(var1, var3, 1, 1, 5, 8, 1, 5, Blocks.COBBLESTONE.P(), Blocks.COBBLESTONE.P(), false);
		this.a(var1, var3, 8, 1, 0, 8, 1, 4, Blocks.COBBLESTONE.P(), Blocks.COBBLESTONE.P(), false);
		this.a(var1, var3, 2, 1, 0, 7, 1, 0, Blocks.COBBLESTONE.P(), Blocks.COBBLESTONE.P(), false);
		this.a(var1, var3, 0, 2, 0, 0, 4, 0, Blocks.COBBLESTONE.P(), Blocks.COBBLESTONE.P(), false);
		this.a(var1, var3, 0, 2, 5, 0, 4, 5, Blocks.COBBLESTONE.P(), Blocks.COBBLESTONE.P(), false);
		this.a(var1, var3, 8, 2, 5, 8, 4, 5, Blocks.COBBLESTONE.P(), Blocks.COBBLESTONE.P(), false);
		this.a(var1, var3, 8, 2, 0, 8, 4, 0, Blocks.COBBLESTONE.P(), Blocks.COBBLESTONE.P(), false);
		this.a(var1, var3, 0, 2, 1, 0, 4, 4, Blocks.PLANKS.P(), Blocks.PLANKS.P(), false);
		this.a(var1, var3, 1, 2, 5, 7, 4, 5, Blocks.PLANKS.P(), Blocks.PLANKS.P(), false);
		this.a(var1, var3, 8, 2, 1, 8, 4, 4, Blocks.PLANKS.P(), Blocks.PLANKS.P(), false);
		this.a(var1, var3, 1, 2, 0, 7, 4, 0, Blocks.PLANKS.P(), Blocks.PLANKS.P(), false);
		this.a(var1, Blocks.GLASS_PANE.P(), 4, 2, 0, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 5, 2, 0, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 6, 2, 0, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 4, 3, 0, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 5, 3, 0, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 6, 3, 0, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 0, 2, 2, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 0, 2, 3, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 0, 3, 2, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 0, 3, 3, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 8, 2, 2, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 8, 2, 3, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 8, 3, 2, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 8, 3, 3, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 2, 2, 5, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 3, 2, 5, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 5, 2, 5, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 6, 2, 5, var3);
		this.a(var1, var3, 1, 4, 1, 7, 4, 1, Blocks.PLANKS.P(), Blocks.PLANKS.P(), false);
		this.a(var1, var3, 1, 4, 4, 7, 4, 4, Blocks.PLANKS.P(), Blocks.PLANKS.P(), false);
		this.a(var1, var3, 1, 3, 4, 7, 3, 4, Blocks.BOOKSHELF.P(), Blocks.BOOKSHELF.P(), false);
		this.a(var1, Blocks.PLANKS.P(), 7, 1, 4, var3);
		this.a(var1, Blocks.OAK_STAIRS.a(this.a(Blocks.OAK_STAIRS, 0)), 7, 1, 3, var3);
		var6 = this.a(Blocks.OAK_STAIRS, 3);
		this.a(var1, Blocks.OAK_STAIRS.a(var6), 6, 1, 4, var3);
		this.a(var1, Blocks.OAK_STAIRS.a(var6), 5, 1, 4, var3);
		this.a(var1, Blocks.OAK_STAIRS.a(var6), 4, 1, 4, var3);
		this.a(var1, Blocks.OAK_STAIRS.a(var6), 3, 1, 4, var3);
		this.a(var1, Blocks.FENCE.P(), 6, 1, 3, var3);
		this.a(var1, Blocks.WOODEN_PRESSURE_PLATE.P(), 6, 2, 3, var3);
		this.a(var1, Blocks.FENCE.P(), 4, 1, 3, var3);
		this.a(var1, Blocks.WOODEN_PRESSURE_PLATE.P(), 4, 2, 3, var3);
		this.a(var1, Blocks.CRAFTING_TABLE.P(), 7, 1, 1, var3);
		this.a(var1, Blocks.AIR.P(), 1, 1, 0, var3);
		this.a(var1, Blocks.AIR.P(), 1, 2, 0, var3);
		this.a(var1, var3, var2, 1, 1, 0, PaintingDirection.fromByte(this.a(Blocks.WOODEN_DOOR, 1)));
		if (this.a(var1, 1, 0, -1, var3).getBlock().r() == Material.AIR && this.a(var1, 1, -1, -1, var3).getBlock().r() != Material.AIR) {
			this.a(var1, Blocks.STONE_STAIRS.a(this.a(Blocks.STONE_STAIRS, 3)), 1, 0, -1, var3);
		}

		for (var7 = 0; var7 < 6; ++var7) {
			for (int var8 = 0; var8 < 9; ++var8) {
				this.b(var1, var8, 9, var7, var3);
				this.b(var1, Blocks.COBBLESTONE.P(), var8, -1, var7, var3);
			}
		}

		this.a(var1, var3, 2, 1, 2, 1);
		return true;
	}

	protected int c(int var1, int var2) {
		return 1;
	}
}
