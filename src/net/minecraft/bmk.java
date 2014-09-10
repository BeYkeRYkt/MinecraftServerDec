package net.minecraft;

import java.util.List;
import java.util.Random;

abstract class bmk extends bms {

	protected bml d;

	public bmk() {
		this.d = bml.a;
	}

	protected bmk(int var1) {
		super(var1);
		this.d = bml.a;
	}

	protected void a(NBTCompoundTag var1) {
		var1.put("EntryDoor", this.d.name());
	}

	protected void b(NBTCompoundTag var1) {
		this.d = bml.valueOf(var1.getString("EntryDoor"));
	}

	protected void a(World var1, Random var2, CuboidArea var3, bml var4, int var5, int var6, int var7) {
		switch (blu.a[var4.ordinal()]) {
			case 1:
			default:
				this.a(var1, var3, var5, var6, var7, var5 + 3 - 1, var6 + 3 - 1, var7, Blocks.AIR.getBlockState(), Blocks.AIR.getBlockState(), false);
				break;
			case 2:
				this.a(var1, Blocks.STONEBRICK.getBlockState(), var5, var6, var7, var3);
				this.a(var1, Blocks.STONEBRICK.getBlockState(), var5, var6 + 1, var7, var3);
				this.a(var1, Blocks.STONEBRICK.getBlockState(), var5, var6 + 2, var7, var3);
				this.a(var1, Blocks.STONEBRICK.getBlockState(), var5 + 1, var6 + 2, var7, var3);
				this.a(var1, Blocks.STONEBRICK.getBlockState(), var5 + 2, var6 + 2, var7, var3);
				this.a(var1, Blocks.STONEBRICK.getBlockState(), var5 + 2, var6 + 1, var7, var3);
				this.a(var1, Blocks.STONEBRICK.getBlockState(), var5 + 2, var6, var7, var3);
				this.a(var1, Blocks.WOODEN_DOOR.getBlockState(), var5 + 1, var6, var7, var3);
				this.a(var1, Blocks.WOODEN_DOOR.a(8), var5 + 1, var6 + 1, var7, var3);
				break;
			case 3:
				this.a(var1, Blocks.AIR.getBlockState(), var5 + 1, var6, var7, var3);
				this.a(var1, Blocks.AIR.getBlockState(), var5 + 1, var6 + 1, var7, var3);
				this.a(var1, Blocks.IRON_BARS.getBlockState(), var5, var6, var7, var3);
				this.a(var1, Blocks.IRON_BARS.getBlockState(), var5, var6 + 1, var7, var3);
				this.a(var1, Blocks.IRON_BARS.getBlockState(), var5, var6 + 2, var7, var3);
				this.a(var1, Blocks.IRON_BARS.getBlockState(), var5 + 1, var6 + 2, var7, var3);
				this.a(var1, Blocks.IRON_BARS.getBlockState(), var5 + 2, var6 + 2, var7, var3);
				this.a(var1, Blocks.IRON_BARS.getBlockState(), var5 + 2, var6 + 1, var7, var3);
				this.a(var1, Blocks.IRON_BARS.getBlockState(), var5 + 2, var6, var7, var3);
				break;
			case 4:
				this.a(var1, Blocks.STONEBRICK.getBlockState(), var5, var6, var7, var3);
				this.a(var1, Blocks.STONEBRICK.getBlockState(), var5, var6 + 1, var7, var3);
				this.a(var1, Blocks.STONEBRICK.getBlockState(), var5, var6 + 2, var7, var3);
				this.a(var1, Blocks.STONEBRICK.getBlockState(), var5 + 1, var6 + 2, var7, var3);
				this.a(var1, Blocks.STONEBRICK.getBlockState(), var5 + 2, var6 + 2, var7, var3);
				this.a(var1, Blocks.STONEBRICK.getBlockState(), var5 + 2, var6 + 1, var7, var3);
				this.a(var1, Blocks.STONEBRICK.getBlockState(), var5 + 2, var6, var7, var3);
				this.a(var1, Blocks.IRON_DOOR.getBlockState(), var5 + 1, var6, var7, var3);
				this.a(var1, Blocks.IRON_DOOR.a(8), var5 + 1, var6 + 1, var7, var3);
				this.a(var1, Blocks.STONE_BUTTON.a(this.a(Blocks.STONE_BUTTON, 4)), var5 + 2, var6 + 1, var7 + 1, var3);
				this.a(var1, Blocks.STONE_BUTTON.a(this.a(Blocks.STONE_BUTTON, 3)), var5 + 2, var6 + 1, var7 - 1, var3);
		}

	}

	protected bml a(Random var1) {
		int var2 = var1.nextInt(5);
		switch (var2) {
			case 0:
			case 1:
			default:
				return bml.a;
			case 2:
				return bml.b;
			case 3:
				return bml.c;
			case 4:
				return bml.d;
		}
	}

	protected bms a(bmh var1, List var2, Random var3, int var4, int var5) {
		if (this.m != null) {
			switch (blu.b[this.m.ordinal()]) {
				case 1:
					return blr.a(var1, var2, var3, this.l.minX + var4, this.l.minY + var5, this.l.minZ - 1, this.m, this.d());
				case 2:
					return blr.a(var1, var2, var3, this.l.minX + var4, this.l.minY + var5, this.l.maxZ + 1, this.m, this.d());
				case 3:
					return blr.a(var1, var2, var3, this.l.minX - 1, this.l.minY + var5, this.l.minZ + var4, this.m, this.d());
				case 4:
					return blr.a(var1, var2, var3, this.l.maxX + 1, this.l.minY + var5, this.l.minZ + var4, this.m, this.d());
			}
		}

		return null;
	}

	protected bms b(bmh var1, List var2, Random var3, int var4, int var5) {
		if (this.m != null) {
			switch (blu.b[this.m.ordinal()]) {
				case 1:
					return blr.a(var1, var2, var3, this.l.minX - 1, this.l.minY + var4, this.l.minZ + var5, BlockFace.WEST, this.d());
				case 2:
					return blr.a(var1, var2, var3, this.l.minX - 1, this.l.minY + var4, this.l.minZ + var5, BlockFace.WEST, this.d());
				case 3:
					return blr.a(var1, var2, var3, this.l.minX + var5, this.l.minY + var4, this.l.minZ - 1, BlockFace.NORTH, this.d());
				case 4:
					return blr.a(var1, var2, var3, this.l.minX + var5, this.l.minY + var4, this.l.minZ - 1, BlockFace.NORTH, this.d());
			}
		}

		return null;
	}

	protected bms c(bmh var1, List var2, Random var3, int var4, int var5) {
		if (this.m != null) {
			switch (blu.b[this.m.ordinal()]) {
				case 1:
					return blr.a(var1, var2, var3, this.l.maxX + 1, this.l.minY + var4, this.l.minZ + var5, BlockFace.EAST, this.d());
				case 2:
					return blr.a(var1, var2, var3, this.l.maxX + 1, this.l.minY + var4, this.l.minZ + var5, BlockFace.EAST, this.d());
				case 3:
					return blr.a(var1, var2, var3, this.l.minX + var5, this.l.minY + var4, this.l.maxZ + 1, BlockFace.SOUTH, this.d());
				case 4:
					return blr.a(var1, var2, var3, this.l.minX + var5, this.l.minY + var4, this.l.maxZ + 1, BlockFace.SOUTH, this.d());
			}
		}

		return null;
	}

	protected static boolean a(CuboidArea var0) {
		return var0 != null && var0.minY > 10;
	}
}
