package net.minecraft;

import java.util.List;
import java.util.Random;

public class bnb extends bnn {

	private Block a;
	private Block b;
	private Block c;
	private Block d;

	public bnb() {
	}

	public bnb(bnk var1, int var2, Random var3, bjb var4, BlockFace var5) {
		super(var1, var2);
		this.m = var5;
		this.l = var4;
		this.a = this.a(var3);
		this.b = this.a(var3);
		this.c = this.a(var3);
		this.d = this.a(var3);
	}

	protected void a(NBTCompoundTag var1) {
		super.a(var1);
		var1.put("CA", Block.BLOCKREGISTRY.getBlockId(this.a));
		var1.put("CB", Block.BLOCKREGISTRY.getBlockId(this.b));
		var1.put("CC", Block.BLOCKREGISTRY.getBlockId(this.c));
		var1.put("CD", Block.BLOCKREGISTRY.getBlockId(this.d));
	}

	protected void b(NBTCompoundTag var1) {
		super.b(var1);
		this.a = Block.c(var1.getInt("CA"));
		this.b = Block.c(var1.getInt("CB"));
		this.c = Block.c(var1.getInt("CC"));
		this.d = Block.c(var1.getInt("CD"));
	}

	private Block a(Random var1) {
		switch (var1.nextInt(5)) {
			case 0:
				return Blocks.CARROTS;
			case 1:
				return Blocks.POTATOES;
			default:
				return Blocks.WHEAT;
		}
	}

	public static bnb a(bnk var0, List var1, Random var2, int var3, int var4, int var5, BlockFace var6, int var7) {
		bjb var8 = bjb.a(var3, var4, var5, 0, 0, 0, 13, 4, 9, var6);
		return a(var8) && bms.a(var1, var8) == null ? new bnb(var0, var7, var2, var8, var6) : null;
	}

	public boolean a(World var1, Random var2, bjb var3) {
		if (this.h < 0) {
			this.h = this.b(var1, var3);
			if (this.h < 0) {
				return true;
			}

			this.l.a(0, this.h - this.l.e + 4 - 1, 0);
		}

		this.a(var1, var3, 0, 1, 0, 12, 4, 8, Blocks.AIR.getBlockState(), Blocks.AIR.getBlockState(), false);
		this.a(var1, var3, 1, 0, 1, 2, 0, 7, Blocks.FARMLAND.getBlockState(), Blocks.FARMLAND.getBlockState(), false);
		this.a(var1, var3, 4, 0, 1, 5, 0, 7, Blocks.FARMLAND.getBlockState(), Blocks.FARMLAND.getBlockState(), false);
		this.a(var1, var3, 7, 0, 1, 8, 0, 7, Blocks.FARMLAND.getBlockState(), Blocks.FARMLAND.getBlockState(), false);
		this.a(var1, var3, 10, 0, 1, 11, 0, 7, Blocks.FARMLAND.getBlockState(), Blocks.FARMLAND.getBlockState(), false);
		this.a(var1, var3, 0, 0, 0, 0, 0, 8, Blocks.LOG.getBlockState(), Blocks.LOG.getBlockState(), false);
		this.a(var1, var3, 6, 0, 0, 6, 0, 8, Blocks.LOG.getBlockState(), Blocks.LOG.getBlockState(), false);
		this.a(var1, var3, 12, 0, 0, 12, 0, 8, Blocks.LOG.getBlockState(), Blocks.LOG.getBlockState(), false);
		this.a(var1, var3, 1, 0, 0, 11, 0, 0, Blocks.LOG.getBlockState(), Blocks.LOG.getBlockState(), false);
		this.a(var1, var3, 1, 0, 8, 11, 0, 8, Blocks.LOG.getBlockState(), Blocks.LOG.getBlockState(), false);
		this.a(var1, var3, 3, 0, 1, 3, 0, 7, Blocks.WATER.getBlockState(), Blocks.WATER.getBlockState(), false);
		this.a(var1, var3, 9, 0, 1, 9, 0, 7, Blocks.WATER.getBlockState(), Blocks.WATER.getBlockState(), false);

		int var4;
		for (var4 = 1; var4 <= 7; ++var4) {
			this.a(var1, this.a.a(DataTypesConverter.a(var2, 2, 7)), 1, 1, var4, var3);
			this.a(var1, this.a.a(DataTypesConverter.a(var2, 2, 7)), 2, 1, var4, var3);
			this.a(var1, this.b.a(DataTypesConverter.a(var2, 2, 7)), 4, 1, var4, var3);
			this.a(var1, this.b.a(DataTypesConverter.a(var2, 2, 7)), 5, 1, var4, var3);
			this.a(var1, this.c.a(DataTypesConverter.a(var2, 2, 7)), 7, 1, var4, var3);
			this.a(var1, this.c.a(DataTypesConverter.a(var2, 2, 7)), 8, 1, var4, var3);
			this.a(var1, this.d.a(DataTypesConverter.a(var2, 2, 7)), 10, 1, var4, var3);
			this.a(var1, this.d.a(DataTypesConverter.a(var2, 2, 7)), 11, 1, var4, var3);
		}

		for (var4 = 0; var4 < 9; ++var4) {
			for (int var5 = 0; var5 < 13; ++var5) {
				this.b(var1, var5, 4, var4, var3);
				this.b(var1, Blocks.DIRT.getBlockState(), var5, -1, var4, var3);
			}
		}

		return true;
	}
}
