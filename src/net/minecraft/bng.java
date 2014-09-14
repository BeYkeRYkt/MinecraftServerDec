package net.minecraft;

import java.util.List;
import java.util.Random;

public class bng extends bnn {

	private boolean a;

	public bng() {
	}

	public bng(bnk var1, int var2, Random var3, CuboidArea var4, BlockFace var5) {
		super(var1, var2);
		this.m = var5;
		this.l = var4;
		this.a = var3.nextBoolean();
	}

	protected void a(NBTCompoundTag var1) {
		super.a(var1);
		var1.put("Terrace", this.a);
	}

	protected void b(NBTCompoundTag var1) {
		super.b(var1);
		this.a = var1.getBoolean("Terrace");
	}

	public static bng a(bnk var0, List var1, Random var2, int var3, int var4, int var5, BlockFace var6, int var7) {
		CuboidArea var8 = CuboidArea.a(var3, var4, var5, 0, 0, 0, 5, 6, 5, var6);
		return StructurePiece.a(var1, var8) != null ? null : new bng(var0, var7, var2, var8, var6);
	}

	public boolean a(World var1, Random var2, CuboidArea var3) {
		if (this.h < 0) {
			this.h = this.b(var1, var3);
			if (this.h < 0) {
				return true;
			}

			this.l.a(0, this.h - this.l.maxY + 6 - 1, 0);
		}

		this.a(var1, var3, 0, 0, 0, 4, 0, 4, Blocks.COBBLESTONE.getBlockState(), Blocks.COBBLESTONE.getBlockState(), false);
		this.a(var1, var3, 0, 4, 0, 4, 4, 4, Blocks.LOG.getBlockState(), Blocks.LOG.getBlockState(), false);
		this.a(var1, var3, 1, 4, 1, 3, 4, 3, Blocks.PLANKS.getBlockState(), Blocks.PLANKS.getBlockState(), false);
		this.a(var1, Blocks.COBBLESTONE.getBlockState(), 0, 1, 0, var3);
		this.a(var1, Blocks.COBBLESTONE.getBlockState(), 0, 2, 0, var3);
		this.a(var1, Blocks.COBBLESTONE.getBlockState(), 0, 3, 0, var3);
		this.a(var1, Blocks.COBBLESTONE.getBlockState(), 4, 1, 0, var3);
		this.a(var1, Blocks.COBBLESTONE.getBlockState(), 4, 2, 0, var3);
		this.a(var1, Blocks.COBBLESTONE.getBlockState(), 4, 3, 0, var3);
		this.a(var1, Blocks.COBBLESTONE.getBlockState(), 0, 1, 4, var3);
		this.a(var1, Blocks.COBBLESTONE.getBlockState(), 0, 2, 4, var3);
		this.a(var1, Blocks.COBBLESTONE.getBlockState(), 0, 3, 4, var3);
		this.a(var1, Blocks.COBBLESTONE.getBlockState(), 4, 1, 4, var3);
		this.a(var1, Blocks.COBBLESTONE.getBlockState(), 4, 2, 4, var3);
		this.a(var1, Blocks.COBBLESTONE.getBlockState(), 4, 3, 4, var3);
		this.a(var1, var3, 0, 1, 1, 0, 3, 3, Blocks.PLANKS.getBlockState(), Blocks.PLANKS.getBlockState(), false);
		this.a(var1, var3, 4, 1, 1, 4, 3, 3, Blocks.PLANKS.getBlockState(), Blocks.PLANKS.getBlockState(), false);
		this.a(var1, var3, 1, 1, 4, 3, 3, 4, Blocks.PLANKS.getBlockState(), Blocks.PLANKS.getBlockState(), false);
		this.a(var1, Blocks.GLASS_PANE.getBlockState(), 0, 2, 2, var3);
		this.a(var1, Blocks.GLASS_PANE.getBlockState(), 2, 2, 4, var3);
		this.a(var1, Blocks.GLASS_PANE.getBlockState(), 4, 2, 2, var3);
		this.a(var1, Blocks.PLANKS.getBlockState(), 1, 1, 0, var3);
		this.a(var1, Blocks.PLANKS.getBlockState(), 1, 2, 0, var3);
		this.a(var1, Blocks.PLANKS.getBlockState(), 1, 3, 0, var3);
		this.a(var1, Blocks.PLANKS.getBlockState(), 2, 3, 0, var3);
		this.a(var1, Blocks.PLANKS.getBlockState(), 3, 3, 0, var3);
		this.a(var1, Blocks.PLANKS.getBlockState(), 3, 2, 0, var3);
		this.a(var1, Blocks.PLANKS.getBlockState(), 3, 1, 0, var3);
		if (this.a(var1, 2, 0, -1, var3).getBlock().getMaterial() == Material.AIR && this.a(var1, 2, -1, -1, var3).getBlock().getMaterial() != Material.AIR) {
			this.a(var1, Blocks.STONE_STAIRS.setData(this.a(Blocks.STONE_STAIRS, 3)), 2, 0, -1, var3);
		}

		this.a(var1, var3, 1, 1, 1, 3, 3, 3, Blocks.AIR.getBlockState(), Blocks.AIR.getBlockState(), false);
		if (this.a) {
			this.a(var1, Blocks.FENCE.getBlockState(), 0, 5, 0, var3);
			this.a(var1, Blocks.FENCE.getBlockState(), 1, 5, 0, var3);
			this.a(var1, Blocks.FENCE.getBlockState(), 2, 5, 0, var3);
			this.a(var1, Blocks.FENCE.getBlockState(), 3, 5, 0, var3);
			this.a(var1, Blocks.FENCE.getBlockState(), 4, 5, 0, var3);
			this.a(var1, Blocks.FENCE.getBlockState(), 0, 5, 4, var3);
			this.a(var1, Blocks.FENCE.getBlockState(), 1, 5, 4, var3);
			this.a(var1, Blocks.FENCE.getBlockState(), 2, 5, 4, var3);
			this.a(var1, Blocks.FENCE.getBlockState(), 3, 5, 4, var3);
			this.a(var1, Blocks.FENCE.getBlockState(), 4, 5, 4, var3);
			this.a(var1, Blocks.FENCE.getBlockState(), 4, 5, 1, var3);
			this.a(var1, Blocks.FENCE.getBlockState(), 4, 5, 2, var3);
			this.a(var1, Blocks.FENCE.getBlockState(), 4, 5, 3, var3);
			this.a(var1, Blocks.FENCE.getBlockState(), 0, 5, 1, var3);
			this.a(var1, Blocks.FENCE.getBlockState(), 0, 5, 2, var3);
			this.a(var1, Blocks.FENCE.getBlockState(), 0, 5, 3, var3);
		}

		int var4;
		if (this.a) {
			var4 = this.a(Blocks.LADDER, 3);
			this.a(var1, Blocks.LADDER.setData(var4), 3, 1, 3, var3);
			this.a(var1, Blocks.LADDER.setData(var4), 3, 2, 3, var3);
			this.a(var1, Blocks.LADDER.setData(var4), 3, 3, 3, var3);
			this.a(var1, Blocks.LADDER.setData(var4), 3, 4, 3, var3);
		}

		this.a(var1, Blocks.TORCH.getBlockState().a(BlockTorch.a, this.m), 2, 3, 1, var3);

		for (var4 = 0; var4 < 5; ++var4) {
			for (int var5 = 0; var5 < 5; ++var5) {
				this.b(var1, var5, 6, var4, var3);
				this.b(var1, Blocks.COBBLESTONE.getBlockState(), var5, -1, var4, var3);
			}
		}

		this.a(var1, var3, 1, 1, 2, 1);
		return true;
	}
}
