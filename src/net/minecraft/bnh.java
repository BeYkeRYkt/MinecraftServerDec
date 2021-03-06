package net.minecraft;

import java.util.List;
import java.util.Random;

public class bnh extends bnn {

	private boolean a;
	private int b;

	public bnh() {
	}

	public bnh(bnk var1, int var2, Random var3, CuboidArea var4, BlockFace var5) {
		super(var1, var2);
		this.m = var5;
		this.l = var4;
		this.a = var3.nextBoolean();
		this.b = var3.nextInt(3);
	}

	protected void a(NBTCompoundTag var1) {
		super.a(var1);
		var1.put("T", this.b);
		var1.put("C", this.a);
	}

	protected void b(NBTCompoundTag var1) {
		super.b(var1);
		this.b = var1.getInt("T");
		this.a = var1.getBoolean("C");
	}

	public static bnh a(bnk var0, List var1, Random var2, int var3, int var4, int var5, BlockFace var6, int var7) {
		CuboidArea var8 = CuboidArea.a(var3, var4, var5, 0, 0, 0, 4, 6, 5, var6);
		return a(var8) && StructurePiece.a(var1, var8) == null ? new bnh(var0, var7, var2, var8, var6) : null;
	}

	public boolean a(World var1, Random var2, CuboidArea var3) {
		if (this.h < 0) {
			this.h = this.b(var1, var3);
			if (this.h < 0) {
				return true;
			}

			this.l.a(0, this.h - this.l.maxY + 6 - 1, 0);
		}

		this.a(var1, var3, 1, 1, 1, 3, 5, 4, Blocks.AIR.getBlockState(), Blocks.AIR.getBlockState(), false);
		this.a(var1, var3, 0, 0, 0, 3, 0, 4, Blocks.COBBLESTONE.getBlockState(), Blocks.COBBLESTONE.getBlockState(), false);
		this.a(var1, var3, 1, 0, 1, 2, 0, 3, Blocks.DIRT.getBlockState(), Blocks.DIRT.getBlockState(), false);
		if (this.a) {
			this.a(var1, var3, 1, 4, 1, 2, 4, 3, Blocks.LOG.getBlockState(), Blocks.LOG.getBlockState(), false);
		} else {
			this.a(var1, var3, 1, 5, 1, 2, 5, 3, Blocks.LOG.getBlockState(), Blocks.LOG.getBlockState(), false);
		}

		this.a(var1, Blocks.LOG.getBlockState(), 1, 4, 0, var3);
		this.a(var1, Blocks.LOG.getBlockState(), 2, 4, 0, var3);
		this.a(var1, Blocks.LOG.getBlockState(), 1, 4, 4, var3);
		this.a(var1, Blocks.LOG.getBlockState(), 2, 4, 4, var3);
		this.a(var1, Blocks.LOG.getBlockState(), 0, 4, 1, var3);
		this.a(var1, Blocks.LOG.getBlockState(), 0, 4, 2, var3);
		this.a(var1, Blocks.LOG.getBlockState(), 0, 4, 3, var3);
		this.a(var1, Blocks.LOG.getBlockState(), 3, 4, 1, var3);
		this.a(var1, Blocks.LOG.getBlockState(), 3, 4, 2, var3);
		this.a(var1, Blocks.LOG.getBlockState(), 3, 4, 3, var3);
		this.a(var1, var3, 0, 1, 0, 0, 3, 0, Blocks.LOG.getBlockState(), Blocks.LOG.getBlockState(), false);
		this.a(var1, var3, 3, 1, 0, 3, 3, 0, Blocks.LOG.getBlockState(), Blocks.LOG.getBlockState(), false);
		this.a(var1, var3, 0, 1, 4, 0, 3, 4, Blocks.LOG.getBlockState(), Blocks.LOG.getBlockState(), false);
		this.a(var1, var3, 3, 1, 4, 3, 3, 4, Blocks.LOG.getBlockState(), Blocks.LOG.getBlockState(), false);
		this.a(var1, var3, 0, 1, 1, 0, 3, 3, Blocks.PLANKS.getBlockState(), Blocks.PLANKS.getBlockState(), false);
		this.a(var1, var3, 3, 1, 1, 3, 3, 3, Blocks.PLANKS.getBlockState(), Blocks.PLANKS.getBlockState(), false);
		this.a(var1, var3, 1, 1, 0, 2, 3, 0, Blocks.PLANKS.getBlockState(), Blocks.PLANKS.getBlockState(), false);
		this.a(var1, var3, 1, 1, 4, 2, 3, 4, Blocks.PLANKS.getBlockState(), Blocks.PLANKS.getBlockState(), false);
		this.a(var1, Blocks.GLASS_PANE.getBlockState(), 0, 2, 2, var3);
		this.a(var1, Blocks.GLASS_PANE.getBlockState(), 3, 2, 2, var3);
		if (this.b > 0) {
			this.a(var1, Blocks.FENCE.getBlockState(), this.b, 1, 3, var3);
			this.a(var1, Blocks.WOODEN_PRESSURE_PLATE.getBlockState(), this.b, 2, 3, var3);
		}

		this.a(var1, Blocks.AIR.getBlockState(), 1, 1, 0, var3);
		this.a(var1, Blocks.AIR.getBlockState(), 1, 2, 0, var3);
		this.a(var1, var3, var2, 1, 1, 0, BlockFace.fromDirection(this.a(Blocks.WOODEN_DOOR, 1)));
		if (this.a(var1, 1, 0, -1, var3).getBlock().getMaterial() == Material.AIR && this.a(var1, 1, -1, -1, var3).getBlock().getMaterial() != Material.AIR) {
			this.a(var1, Blocks.STONE_STAIRS.setData(this.a(Blocks.STONE_STAIRS, 3)), 1, 0, -1, var3);
		}

		for (int var4 = 0; var4 < 5; ++var4) {
			for (int var5 = 0; var5 < 4; ++var5) {
				this.b(var1, var5, 6, var4, var3);
				this.b(var1, Blocks.COBBLESTONE.getBlockState(), var5, -1, var4, var3);
			}
		}

		this.a(var1, var3, 1, 1, 2, 1);
		return true;
	}
}
