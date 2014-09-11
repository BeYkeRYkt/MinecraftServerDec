package net.minecraft;

import java.util.List;
import java.util.Random;

abstract class bnn extends StructurePiece {

	protected int h = -1;
	private int a;
	private boolean b;

	public bnn() {
	}

	protected bnn(bnk var1, int var2) {
		super(var2);
		if (var1 != null) {
			this.b = var1.b;
		}

	}

	protected void a(NBTCompoundTag var1) {
		var1.put("HPos", this.h);
		var1.put("VCount", this.a);
		var1.put("Desert", this.b);
	}

	protected void b(NBTCompoundTag var1) {
		this.h = var1.getInt("HPos");
		this.a = var1.getInt("VCount");
		this.b = var1.getBoolean("Desert");
	}

	protected StructurePiece a(bnk var1, List var2, Random var3, int var4, int var5) {
		if (this.m != null) {
			switch (bmz.a[this.m.ordinal()]) {
				case 1:
					return bmy.a(var1, var2, var3, this.l.minX - 1, this.l.minY + var4, this.l.minZ + var5, BlockFace.WEST, this.d());
				case 2:
					return bmy.a(var1, var2, var3, this.l.minX - 1, this.l.minY + var4, this.l.minZ + var5, BlockFace.WEST, this.d());
				case 3:
					return bmy.a(var1, var2, var3, this.l.minX + var5, this.l.minY + var4, this.l.minZ - 1, BlockFace.NORTH, this.d());
				case 4:
					return bmy.a(var1, var2, var3, this.l.minX + var5, this.l.minY + var4, this.l.minZ - 1, BlockFace.NORTH, this.d());
			}
		}

		return null;
	}

	protected StructurePiece b(bnk var1, List var2, Random var3, int var4, int var5) {
		if (this.m != null) {
			switch (bmz.a[this.m.ordinal()]) {
				case 1:
					return bmy.a(var1, var2, var3, this.l.maxX + 1, this.l.minY + var4, this.l.minZ + var5, BlockFace.EAST, this.d());
				case 2:
					return bmy.a(var1, var2, var3, this.l.maxX + 1, this.l.minY + var4, this.l.minZ + var5, BlockFace.EAST, this.d());
				case 3:
					return bmy.a(var1, var2, var3, this.l.minX + var5, this.l.minY + var4, this.l.maxZ + 1, BlockFace.SOUTH, this.d());
				case 4:
					return bmy.a(var1, var2, var3, this.l.minX + var5, this.l.minY + var4, this.l.maxZ + 1, BlockFace.SOUTH, this.d());
			}
		}

		return null;
	}

	protected int b(World var1, CuboidArea var2) {
		int var3 = 0;
		int var4 = 0;

		for (int var5 = this.l.minZ; var5 <= this.l.maxZ; ++var5) {
			for (int var6 = this.l.minX; var6 <= this.l.maxX; ++var6) {
				Position var7 = new Position(var6, 64, var5);
				if (var2.b((fd) var7)) {
					var3 += Math.max(var1.r(var7).getY(), var1.worldProvider.i());
					++var4;
				}
			}
		}

		if (var4 == 0) {
			return -1;
		} else {
			return var3 / var4;
		}
	}

	protected static boolean a(CuboidArea var0) {
		return var0 != null && var0.minY > 10;
	}

	protected void a(World var1, CuboidArea var2, int var3, int var4, int var5, int var6) {
		if (this.a < var6) {
			for (int var7 = this.a; var7 < var6; ++var7) {
				int var8 = this.a(var3 + var7, var5);
				int var9 = this.d(var4);
				int var10 = this.b(var3 + var7, var5);
				if (!var2.b((fd) (new Position(var8, var9, var10)))) {
					break;
				}

				++this.a;
				EntityVillager var11 = new EntityVillager(var1);
				var11.setPositionRotation((double) var8 + 0.5D, (double) var9, (double) var10 + 0.5D, 0.0F, 0.0F);
				var11.a(var1.E(new Position(var11)), (xq) null);
				var11.r(this.c(var7, var11.cj()));
				var1.d((Entity) var11);
			}

		}
	}

	protected int c(int var1, int var2) {
		return var2;
	}

	protected BlockState a(BlockState var1) {
		if (this.b) {
			if (var1.getBlock() == Blocks.LOG || var1.getBlock() == Blocks.LOG2) {
				return Blocks.SANDSTONE.getBlockState();
			}

			if (var1.getBlock() == Blocks.COBBLESTONE) {
				return Blocks.SANDSTONE.a(bae.a.a());
			}

			if (var1.getBlock() == Blocks.PLANKS) {
				return Blocks.SANDSTONE.a(bae.c.a());
			}

			if (var1.getBlock() == Blocks.OAK_STAIRS) {
				return Blocks.SANDSTONE_STAIRS.getBlockState().a(BlockStairs.a, var1.b(BlockStairs.a));
			}

			if (var1.getBlock() == Blocks.STONE_STAIRS) {
				return Blocks.SANDSTONE_STAIRS.getBlockState().a(BlockStairs.a, var1.b(BlockStairs.a));
			}

			if (var1.getBlock() == Blocks.GRAVEL) {
				return Blocks.SANDSTONE.getBlockState();
			}
		}

		return var1;
	}

	protected void a(World var1, BlockState var2, int var3, int var4, int var5, CuboidArea var6) {
		BlockState var7 = this.a(var2);
		super.a(var1, var7, var3, var4, var5, var6);
	}

	protected void a(World var1, CuboidArea var2, int var3, int var4, int var5, int var6, int var7, int var8, BlockState var9, BlockState var10, boolean var11) {
		BlockState var12 = this.a(var9);
		BlockState var13 = this.a(var10);
		super.a(var1, var2, var3, var4, var5, var6, var7, var8, var12, var13, var11);
	}

	protected void b(World var1, BlockState var2, int var3, int var4, int var5, CuboidArea var6) {
		BlockState var7 = this.a(var2);
		super.b(var1, var7, var3, var4, var5, var6);
	}

	protected void a(boolean var1) {
		this.b = var1;
	}
}
