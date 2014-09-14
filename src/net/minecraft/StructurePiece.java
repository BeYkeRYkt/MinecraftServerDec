package net.minecraft;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public abstract class StructurePiece {

	protected CuboidArea l;
	protected BlockFace m;
	protected int n;

	public StructurePiece() {
	}

	protected StructurePiece(int var1) {
		this.n = var1;
	}

	public NBTCompoundTag b() {
		NBTCompoundTag var1 = new NBTCompoundTag();
		var1.put("id", WorldGenFactory.a(this));
		var1.put("BB", (NBTTag) this.l.g());
		var1.put("O", this.m == null ? -1 : this.m.toDirection());
		var1.put("GD", this.n);
		this.a(var1);
		return var1;
	}

	protected abstract void a(NBTCompoundTag var1);

	public void a(World var1, NBTCompoundTag var2) {
		if (var2.hasKey("BB")) {
			this.l = new CuboidArea(var2.getIntArray("BB"));
		}

		int var3 = var2.getInt("O");
		this.m = var3 == -1 ? null : BlockFace.fromDirection(var3);
		this.n = var2.getInt("GD");
		this.b(var2);
	}

	protected abstract void b(NBTCompoundTag var1);

	public void a(StructurePiece var1, List var2, Random var3) {
	}

	public abstract boolean a(World var1, Random var2, CuboidArea var3);

	public CuboidArea c() {
		return this.l;
	}

	public int d() {
		return this.n;
	}

	public static StructurePiece a(List var0, CuboidArea var1) {
		Iterator var2 = var0.iterator();

		StructurePiece var3;
		do {
			if (!var2.hasNext()) {
				return null;
			}

			var3 = (StructurePiece) var2.next();
		} while (var3.c() == null || !var3.c().a(var1));

		return var3;
	}

	public Position a() {
		return new Position(this.l.f());
	}

	protected boolean a(World var1, CuboidArea var2) {
		int var3 = Math.max(this.l.minX - 1, var2.minX);
		int var4 = Math.max(this.l.minY - 1, var2.minY);
		int var5 = Math.max(this.l.minZ - 1, var2.minZ);
		int var6 = Math.min(this.l.maxX + 1, var2.maxX);
		int var7 = Math.min(this.l.maxY + 1, var2.maxY);
		int var8 = Math.min(this.l.maxZ + 1, var2.maxZ);

		int var9;
		int var10;
		for (var9 = var3; var9 <= var6; ++var9) {
			for (var10 = var5; var10 <= var8; ++var10) {
				if (var1.getBlockState(new Position(var9, var4, var10)).getBlock().getMaterial().isLiquid()) {
					return true;
				}

				if (var1.getBlockState(new Position(var9, var7, var10)).getBlock().getMaterial().isLiquid()) {
					return true;
				}
			}
		}

		for (var9 = var3; var9 <= var6; ++var9) {
			for (var10 = var4; var10 <= var7; ++var10) {
				if (var1.getBlockState(new Position(var9, var10, var5)).getBlock().getMaterial().isLiquid()) {
					return true;
				}

				if (var1.getBlockState(new Position(var9, var10, var8)).getBlock().getMaterial().isLiquid()) {
					return true;
				}
			}
		}

		for (var9 = var5; var9 <= var8; ++var9) {
			for (var10 = var4; var10 <= var7; ++var10) {
				if (var1.getBlockState(new Position(var3, var10, var9)).getBlock().getMaterial().isLiquid()) {
					return true;
				}

				if (var1.getBlockState(new Position(var6, var10, var9)).getBlock().getMaterial().isLiquid()) {
					return true;
				}
			}
		}

		return false;
	}

	protected int a(int var1, int var2) {
		if (this.m == null) {
			return var1;
		} else {
			switch (bmt.a[this.m.ordinal()]) {
				case 1:
				case 2:
					return this.l.minX + var1;
				case 3:
					return this.l.maxX - var2;
				case 4:
					return this.l.minX + var2;
				default:
					return var1;
			}
		}
	}

	protected int d(int var1) {
		return this.m == null ? var1 : var1 + this.l.minY;
	}

	protected int b(int var1, int var2) {
		if (this.m == null) {
			return var2;
		} else {
			switch (bmt.a[this.m.ordinal()]) {
				case 1:
					return this.l.maxZ - var2;
				case 2:
					return this.l.minZ + var2;
				case 3:
				case 4:
					return this.l.minZ + var1;
				default:
					return var2;
			}
		}
	}

	protected int a(Block var1, int var2) {
		if (var1 == Blocks.RAIL) {
			if (this.m == BlockFace.WEST || this.m == BlockFace.EAST) {
				if (var2 == 1) {
					return 0;
				}

				return 1;
			}
		} else if (var1 instanceof BlockDoor) {
			if (this.m == BlockFace.SOUTH) {
				if (var2 == 0) {
					return 2;
				}

				if (var2 == 2) {
					return 0;
				}
			} else {
				if (this.m == BlockFace.WEST) {
					return var2 + 1 & 3;
				}

				if (this.m == BlockFace.EAST) {
					return var2 + 3 & 3;
				}
			}
		} else if (var1 != Blocks.STONE_STAIRS && var1 != Blocks.OAK_STAIRS && var1 != Blocks.NETHER_BRICK_STAIRS && var1 != Blocks.STONE_BROCK_STAIRS && var1 != Blocks.SANDSTONE_STAIRS) {
			if (var1 == Blocks.LADDER) {
				if (this.m == BlockFace.SOUTH) {
					if (var2 == BlockFace.NORTH.getId()) {
						return BlockFace.SOUTH.getId();
					}

					if (var2 == BlockFace.SOUTH.getId()) {
						return BlockFace.NORTH.getId();
					}
				} else if (this.m == BlockFace.WEST) {
					if (var2 == BlockFace.NORTH.getId()) {
						return BlockFace.WEST.getId();
					}

					if (var2 == BlockFace.SOUTH.getId()) {
						return BlockFace.EAST.getId();
					}

					if (var2 == BlockFace.WEST.getId()) {
						return BlockFace.NORTH.getId();
					}

					if (var2 == BlockFace.EAST.getId()) {
						return BlockFace.SOUTH.getId();
					}
				} else if (this.m == BlockFace.EAST) {
					if (var2 == BlockFace.NORTH.getId()) {
						return BlockFace.EAST.getId();
					}

					if (var2 == BlockFace.SOUTH.getId()) {
						return BlockFace.WEST.getId();
					}

					if (var2 == BlockFace.WEST.getId()) {
						return BlockFace.NORTH.getId();
					}

					if (var2 == BlockFace.EAST.getId()) {
						return BlockFace.SOUTH.getId();
					}
				}
			} else if (var1 == Blocks.STONE_BUTTON) {
				if (this.m == BlockFace.SOUTH) {
					if (var2 == 3) {
						return 4;
					}

					if (var2 == 4) {
						return 3;
					}
				} else if (this.m == BlockFace.WEST) {
					if (var2 == 3) {
						return 1;
					}

					if (var2 == 4) {
						return 2;
					}

					if (var2 == 2) {
						return 3;
					}

					if (var2 == 1) {
						return 4;
					}
				} else if (this.m == BlockFace.EAST) {
					if (var2 == 3) {
						return 2;
					}

					if (var2 == 4) {
						return 1;
					}

					if (var2 == 2) {
						return 3;
					}

					if (var2 == 1) {
						return 4;
					}
				}
			} else if (var1 != Blocks.TRIPWIRE_HOOK && !(var1 instanceof avb)) {
				if (var1 == Blocks.PISTON || var1 == Blocks.STICKY_PISTON || var1 == Blocks.LEVER || var1 == Blocks.DISPENSER) {
					if (this.m == BlockFace.SOUTH) {
						if (var2 == BlockFace.NORTH.getId() || var2 == BlockFace.SOUTH.getId()) {
							return BlockFace.getById(var2).getOpposite().getId();
						}
					} else if (this.m == BlockFace.WEST) {
						if (var2 == BlockFace.NORTH.getId()) {
							return BlockFace.WEST.getId();
						}

						if (var2 == BlockFace.SOUTH.getId()) {
							return BlockFace.EAST.getId();
						}

						if (var2 == BlockFace.WEST.getId()) {
							return BlockFace.NORTH.getId();
						}

						if (var2 == BlockFace.EAST.getId()) {
							return BlockFace.SOUTH.getId();
						}
					} else if (this.m == BlockFace.EAST) {
						if (var2 == BlockFace.NORTH.getId()) {
							return BlockFace.EAST.getId();
						}

						if (var2 == BlockFace.SOUTH.getId()) {
							return BlockFace.WEST.getId();
						}

						if (var2 == BlockFace.WEST.getId()) {
							return BlockFace.NORTH.getId();
						}

						if (var2 == BlockFace.EAST.getId()) {
							return BlockFace.SOUTH.getId();
						}
					}
				}
			} else {
				BlockFace var3 = BlockFace.fromDirection(var2);
				if (this.m == BlockFace.SOUTH) {
					if (var3 == BlockFace.SOUTH || var3 == BlockFace.NORTH) {
						return var3.getOpposite().toDirection();
					}
				} else if (this.m == BlockFace.WEST) {
					if (var3 == BlockFace.NORTH) {
						return BlockFace.WEST.toDirection();
					}

					if (var3 == BlockFace.SOUTH) {
						return BlockFace.EAST.toDirection();
					}

					if (var3 == BlockFace.WEST) {
						return BlockFace.NORTH.toDirection();
					}

					if (var3 == BlockFace.EAST) {
						return BlockFace.SOUTH.toDirection();
					}
				} else if (this.m == BlockFace.EAST) {
					if (var3 == BlockFace.NORTH) {
						return BlockFace.EAST.toDirection();
					}

					if (var3 == BlockFace.SOUTH) {
						return BlockFace.WEST.toDirection();
					}

					if (var3 == BlockFace.WEST) {
						return BlockFace.NORTH.toDirection();
					}

					if (var3 == BlockFace.EAST) {
						return BlockFace.SOUTH.toDirection();
					}
				}
			}
		} else if (this.m == BlockFace.SOUTH) {
			if (var2 == 2) {
				return 3;
			}

			if (var2 == 3) {
				return 2;
			}
		} else if (this.m == BlockFace.WEST) {
			if (var2 == 0) {
				return 2;
			}

			if (var2 == 1) {
				return 3;
			}

			if (var2 == 2) {
				return 0;
			}

			if (var2 == 3) {
				return 1;
			}
		} else if (this.m == BlockFace.EAST) {
			if (var2 == 0) {
				return 2;
			}

			if (var2 == 1) {
				return 3;
			}

			if (var2 == 2) {
				return 1;
			}

			if (var2 == 3) {
				return 0;
			}
		}

		return var2;
	}

	protected void a(World var1, IBlockState var2, int var3, int var4, int var5, CuboidArea var6) {
		Position var7 = new Position(this.a(var3, var5), this.d(var4), this.b(var3, var5));
		if (var6.b((fd) var7)) {
			var1.setBlockAt(var7, var2, 2);
		}
	}

	protected IBlockState a(World var1, int var2, int var3, int var4, CuboidArea var5) {
		int var6 = this.a(var2, var4);
		int var7 = this.d(var3);
		int var8 = this.b(var2, var4);
		return !var5.b((fd) (new Position(var6, var7, var8))) ? Blocks.AIR.getBlockState() : var1.getBlockState(new Position(var6, var7, var8));
	}

	protected void a(World var1, CuboidArea var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		for (int var9 = var4; var9 <= var7; ++var9) {
			for (int var10 = var3; var10 <= var6; ++var10) {
				for (int var11 = var5; var11 <= var8; ++var11) {
					this.a(var1, Blocks.AIR.getBlockState(), var10, var9, var11, var2);
				}
			}
		}

	}

	protected void a(World var1, CuboidArea var2, int var3, int var4, int var5, int var6, int var7, int var8, IBlockState var9, IBlockState var10, boolean var11) {
		for (int var12 = var4; var12 <= var7; ++var12) {
			for (int var13 = var3; var13 <= var6; ++var13) {
				for (int var14 = var5; var14 <= var8; ++var14) {
					if (!var11 || this.a(var1, var13, var12, var14, var2).getBlock().getMaterial() != Material.AIR) {
						if (var12 != var4 && var12 != var7 && var13 != var3 && var13 != var6 && var14 != var5 && var14 != var8) {
							this.a(var1, var10, var13, var12, var14, var2);
						} else {
							this.a(var1, var9, var13, var12, var14, var2);
						}
					}
				}
			}
		}

	}

	protected void a(World var1, CuboidArea var2, int var3, int var4, int var5, int var6, int var7, int var8, boolean var9, Random var10, bmu var11) {
		for (int var12 = var4; var12 <= var7; ++var12) {
			for (int var13 = var3; var13 <= var6; ++var13) {
				for (int var14 = var5; var14 <= var8; ++var14) {
					if (!var9 || this.a(var1, var13, var12, var14, var2).getBlock().getMaterial() != Material.AIR) {
						var11.a(var10, var13, var12, var14, var12 == var4 || var12 == var7 || var13 == var3 || var13 == var6 || var14 == var5 || var14 == var8);
						this.a(var1, var11.a(), var13, var12, var14, var2);
					}
				}
			}
		}

	}

	protected void a(World var1, CuboidArea var2, Random var3, float var4, int var5, int var6, int var7, int var8, int var9, int var10, IBlockState var11, IBlockState var12, boolean var13) {
		for (int var14 = var6; var14 <= var9; ++var14) {
			for (int var15 = var5; var15 <= var8; ++var15) {
				for (int var16 = var7; var16 <= var10; ++var16) {
					if (var3.nextFloat() <= var4 && (!var13 || this.a(var1, var15, var14, var16, var2).getBlock().getMaterial() != Material.AIR)) {
						if (var14 != var6 && var14 != var9 && var15 != var5 && var15 != var8 && var16 != var7 && var16 != var10) {
							this.a(var1, var12, var15, var14, var16, var2);
						} else {
							this.a(var1, var11, var15, var14, var16, var2);
						}
					}
				}
			}
		}

	}

	protected void a(World var1, CuboidArea var2, Random var3, float var4, int var5, int var6, int var7, IBlockState var8) {
		if (var3.nextFloat() < var4) {
			this.a(var1, var8, var5, var6, var7, var2);
		}

	}

	protected void a(World var1, CuboidArea var2, int var3, int var4, int var5, int var6, int var7, int var8, IBlockState var9, boolean var10) {
		float var11 = (float) (var6 - var3 + 1);
		float var12 = (float) (var7 - var4 + 1);
		float var13 = (float) (var8 - var5 + 1);
		float var14 = (float) var3 + var11 / 2.0F;
		float var15 = (float) var5 + var13 / 2.0F;

		for (int var16 = var4; var16 <= var7; ++var16) {
			float var17 = (float) (var16 - var4) / var12;

			for (int var18 = var3; var18 <= var6; ++var18) {
				float var19 = ((float) var18 - var14) / (var11 * 0.5F);

				for (int var20 = var5; var20 <= var8; ++var20) {
					float var21 = ((float) var20 - var15) / (var13 * 0.5F);
					if (!var10 || this.a(var1, var18, var16, var20, var2).getBlock().getMaterial() != Material.AIR) {
						float var22 = var19 * var19 + var17 * var17 + var21 * var21;
						if (var22 <= 1.05F) {
							this.a(var1, var9, var18, var16, var20, var2);
						}
					}
				}
			}
		}

	}

	protected void b(World var1, int var2, int var3, int var4, CuboidArea var5) {
		Position var6 = new Position(this.a(var2, var4), this.d(var3), this.b(var2, var4));
		if (var5.b((fd) var6)) {
			while (!var1.d(var6) && var6.getY() < 255) {
				var1.setBlockAt(var6, Blocks.AIR.getBlockState(), 2);
				var6 = var6.a();
			}

		}
	}

	protected void b(World var1, IBlockState var2, int var3, int var4, int var5, CuboidArea var6) {
		int var7 = this.a(var3, var5);
		int var8 = this.d(var4);
		int var9 = this.b(var3, var5);
		if (var6.b((fd) (new Position(var7, var8, var9)))) {
			while ((var1.d(new Position(var7, var8, var9)) || var1.getBlockState(new Position(var7, var8, var9)).getBlock().getMaterial().isLiquid()) && var8 > 1) {
				var1.setBlockAt(new Position(var7, var8, var9), var2, 2);
				--var8;
			}

		}
	}

	protected boolean a(World var1, CuboidArea var2, Random var3, int var4, int var5, int var6, List var7, int var8) {
		Position var9 = new Position(this.a(var4, var6), this.d(var5), this.b(var4, var6));
		if (var2.b((fd) var9) && var1.getBlockState(var9).getBlock() != Blocks.CHEST) {
			IBlockState var10 = Blocks.CHEST.getBlockState();
			var1.setBlockAt(var9, Blocks.CHEST.f(var1, var9, var10), 2);
			TileEntity var11 = var1.getTileEntity(var9);
			if (var11 instanceof TileEntityChest) {
				StructurePieceTreasure.a(var3, var7, (IInventory) ((TileEntityChest) var11), var8);
			}

			return true;
		} else {
			return false;
		}
	}

	protected boolean a(World var1, CuboidArea var2, Random var3, int var4, int var5, int var6, int var7, List var8, int var9) {
		Position var10 = new Position(this.a(var4, var6), this.d(var5), this.b(var4, var6));
		if (var2.b((fd) var10) && var1.getBlockState(var10).getBlock() != Blocks.DISPENSER) {
			var1.setBlockAt(var10, Blocks.DISPENSER.a(this.a(Blocks.DISPENSER, var7)), 2);
			TileEntity var11 = var1.getTileEntity(var10);
			if (var11 instanceof TileEntityDispenser) {
				StructurePieceTreasure.a(var3, var8, (TileEntityDispenser) var11, var9);
			}

			return true;
		} else {
			return false;
		}
	}

	protected void a(World var1, CuboidArea var2, Random var3, int var4, int var5, int var6, BlockFace var7) {
		Position var8 = new Position(this.a(var4, var6), this.d(var5), this.b(var4, var6));
		if (var2.b((fd) var8)) {
			ItemDoor.a(var1, var8, var7.f(), Blocks.WOODEN_DOOR);
		}

	}
}
