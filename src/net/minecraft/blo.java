package net.minecraft;

import java.util.Random;

public class blo extends bln {

	private boolean e;

	public blo() {
	}

	public blo(Random var1, int var2, int var3) {
		super(var1, var2, 64, var3, 7, 5, 9);
	}

	protected void a(NBTCompoundTag var1) {
		super.a(var1);
		var1.put("Witch", this.e);
	}

	protected void b(NBTCompoundTag var1) {
		super.b(var1);
		this.e = var1.getBoolean("Witch");
	}

	public boolean a(World var1, Random var2, CuboidArea var3) {
		if (!this.a(var1, var3, 0)) {
			return false;
		} else {
			this.a(var1, var3, 1, 1, 1, 5, 1, 7, Blocks.PLANKS.a(EnumWoodType.b.a()), Blocks.PLANKS.a(EnumWoodType.b.a()), false);
			this.a(var1, var3, 1, 4, 2, 5, 4, 7, Blocks.PLANKS.a(EnumWoodType.b.a()), Blocks.PLANKS.a(EnumWoodType.b.a()), false);
			this.a(var1, var3, 2, 1, 0, 4, 1, 0, Blocks.PLANKS.a(EnumWoodType.b.a()), Blocks.PLANKS.a(EnumWoodType.b.a()), false);
			this.a(var1, var3, 2, 2, 2, 3, 3, 2, Blocks.PLANKS.a(EnumWoodType.b.a()), Blocks.PLANKS.a(EnumWoodType.b.a()), false);
			this.a(var1, var3, 1, 2, 3, 1, 3, 6, Blocks.PLANKS.a(EnumWoodType.b.a()), Blocks.PLANKS.a(EnumWoodType.b.a()), false);
			this.a(var1, var3, 5, 2, 3, 5, 3, 6, Blocks.PLANKS.a(EnumWoodType.b.a()), Blocks.PLANKS.a(EnumWoodType.b.a()), false);
			this.a(var1, var3, 2, 2, 7, 4, 3, 7, Blocks.PLANKS.a(EnumWoodType.b.a()), Blocks.PLANKS.a(EnumWoodType.b.a()), false);
			this.a(var1, var3, 1, 0, 2, 1, 3, 2, Blocks.LOG.getBlockState(), Blocks.LOG.getBlockState(), false);
			this.a(var1, var3, 5, 0, 2, 5, 3, 2, Blocks.LOG.getBlockState(), Blocks.LOG.getBlockState(), false);
			this.a(var1, var3, 1, 0, 7, 1, 3, 7, Blocks.LOG.getBlockState(), Blocks.LOG.getBlockState(), false);
			this.a(var1, var3, 5, 0, 7, 5, 3, 7, Blocks.LOG.getBlockState(), Blocks.LOG.getBlockState(), false);
			this.a(var1, Blocks.FENCE.getBlockState(), 2, 3, 2, var3);
			this.a(var1, Blocks.FENCE.getBlockState(), 3, 3, 7, var3);
			this.a(var1, Blocks.AIR.getBlockState(), 1, 3, 4, var3);
			this.a(var1, Blocks.AIR.getBlockState(), 5, 3, 4, var3);
			this.a(var1, Blocks.AIR.getBlockState(), 5, 3, 5, var3);
			this.a(var1, Blocks.FLOWER_POT.getBlockState().a(BlockFlowerPot.b, awf.r), 1, 3, 5, var3);
			this.a(var1, Blocks.CRAFTING_TABLE.getBlockState(), 3, 2, 6, var3);
			this.a(var1, Blocks.CAULDRON.getBlockState(), 4, 2, 6, var3);
			this.a(var1, Blocks.FENCE.getBlockState(), 1, 2, 1, var3);
			this.a(var1, Blocks.FENCE.getBlockState(), 5, 2, 1, var3);
			int var4 = this.a(Blocks.OAK_STAIRS, 3);
			int var5 = this.a(Blocks.OAK_STAIRS, 1);
			int var6 = this.a(Blocks.OAK_STAIRS, 0);
			int var7 = this.a(Blocks.OAK_STAIRS, 2);
			this.a(var1, var3, 0, 4, 1, 6, 4, 1, Blocks.SPRUCE_STAIRS.a(var4), Blocks.SPRUCE_STAIRS.a(var4), false);
			this.a(var1, var3, 0, 4, 2, 0, 4, 7, Blocks.SPRUCE_STAIRS.a(var6), Blocks.SPRUCE_STAIRS.a(var6), false);
			this.a(var1, var3, 6, 4, 2, 6, 4, 7, Blocks.SPRUCE_STAIRS.a(var5), Blocks.SPRUCE_STAIRS.a(var5), false);
			this.a(var1, var3, 0, 4, 8, 6, 4, 8, Blocks.SPRUCE_STAIRS.a(var7), Blocks.SPRUCE_STAIRS.a(var7), false);

			int var8;
			int var9;
			for (var8 = 2; var8 <= 7; var8 += 5) {
				for (var9 = 1; var9 <= 5; var9 += 4) {
					this.b(var1, Blocks.LOG.getBlockState(), var9, -1, var8, var3);
				}
			}

			if (!this.e) {
				var8 = this.a(2, 5);
				var9 = this.d(2);
				int var10 = this.b(2, 5);
				if (var3.b((fd) (new Position(var8, var9, var10)))) {
					this.e = true;
					EntityWitch var11 = new EntityWitch(var1);
					var11.setPositionRotation((double) var8 + 0.5D, (double) var9, (double) var10 + 0.5D, 0.0F, 0.0F);
					var11.a(var1.E(new Position(var8, var9, var10)), (xq) null);
					var1.addEntity((Entity) var11);
				}
			}

			return true;
		}
	}
}
