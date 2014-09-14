package net.minecraft;

import java.util.List;

public class BlockPiston extends Block {

	public static final beu a = beu.a("facing");
	public static final bet b = bet.a("extended");
	private final boolean M;

	public BlockPiston(boolean var1) {
		super(Material.PISTON);
		this.setBlockState(this.L.b().a(a, BlockFace.NORTH).a(b, Boolean.valueOf(false)));
		this.M = var1;
		this.a(i);
		this.c(0.5F);
		this.a(CreativeModeTab.REDSTONE);
	}

	public boolean c() {
		return false;
	}

	public void a(World var1, Position var2, IBlockState var3, EntityLiving var4, ItemStack var5) {
		var1.setBlockAt(var2, var3.a(a, a(var1, var2, var4)), 2);
		if (!var1.isStatic) {
			this.e(var1, var2, var3);
		}

	}

	public void a(World var1, Position var2, IBlockState var3, Block var4) {
		if (!var1.isStatic) {
			this.e(var1, var2, var3);
		}

	}

	public void c(World var1, Position var2, IBlockState var3) {
		if (!var1.isStatic && var1.getTileEntity(var2) == null) {
			this.e(var1, var2, var3);
		}

	}

	public IBlockState a(World var1, Position var2, BlockFace var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		return this.getBlockState().a(a, a(var1, var2, var8)).a(b, Boolean.valueOf(false));
	}

	private void e(World var1, Position var2, IBlockState var3) {
		BlockFace var4 = (BlockFace) var3.b(a);
		boolean var5 = this.b(var1, var2, var4);
		if (var5 && !((Boolean) var3.b(b)).booleanValue()) {
			if ((new bdy(var1, var2, var4, true)).a()) {
				var1.c(var2, this, 0, var4.getId());
			}
		} else if (!var5 && ((Boolean) var3.b(b)).booleanValue()) {
			var1.setBlockAt(var2, var3.a(b, Boolean.valueOf(false)), 2);
			var1.c(var2, this, 1, var4.getId());
		}

	}

	private boolean b(World var1, Position var2, BlockFace var3) {
		BlockFace[] var4 = BlockFace.values();
		int var5 = var4.length;

		int var6;
		for (var6 = 0; var6 < var5; ++var6) {
			BlockFace var7 = var4[var6];
			if (var7 != var3 && var1.b(var2.a(var7), var7)) {
				return true;
			}
		}

		if (var1.b(var2, BlockFace.NORTH)) {
			return true;
		} else {
			Position var9 = var2.a();
			BlockFace[] var10 = BlockFace.values();
			var6 = var10.length;

			for (int var11 = 0; var11 < var6; ++var11) {
				BlockFace var8 = var10[var11];
				if (var8 != BlockFace.DOWN && var1.b(var9.a(var8), var8)) {
					return true;
				}
			}

			return false;
		}
	}

	public boolean a(World var1, Position var2, IBlockState var3, int var4, int var5) {
		BlockFace var6 = (BlockFace) var3.b(a);
		if (!var1.isStatic) {
			boolean var7 = this.b(var1, var2, var6);
			if (var7 && var4 == 1) {
				var1.setBlockAt(var2, var3.a(b, Boolean.valueOf(true)), 2);
				return false;
			}

			if (!var7 && var4 == 0) {
				return false;
			}
		}

		if (var4 == 0) {
			if (!this.a(var1, var2, var6, true)) {
				return false;
			}

			var1.setBlockAt(var2, var3.a(b, Boolean.valueOf(true)), 2);
			var1.makeSound((double) var2.getX() + 0.5D, (double) var2.getY() + 0.5D, (double) var2.getZ() + 0.5D, "tile.piston.out", 0.5F, var1.s.nextFloat() * 0.25F + 0.6F);
		} else if (var4 == 1) {
			TileEntity var13 = var1.getTileEntity(var2.a(var6));
			if (var13 instanceof TileEntityPiston) {
				((TileEntityPiston) var13).h();
			}

			var1.setBlockAt(var2, Blocks.PISTON_EXTENSION.getBlockState().a(BlockPistonMoving.a, var6).a(BlockPistonMoving.b, this.M ? bdu.b : bdu.a), 3);
			var1.a(var2, BlockPistonMoving.a(this.setData(var5), var6, false, true));
			if (this.M) {
				Position var8 = var2.a(var6.g() * 2, var6.h() * 2, var6.i() * 2);
				Block var9 = var1.getBlockState(var8).getBlock();
				boolean var10 = false;
				if (var9 == Blocks.PISTON_EXTENSION) {
					TileEntity var11 = var1.getTileEntity(var8);
					if (var11 instanceof TileEntityPiston) {
						TileEntityPiston var12 = (TileEntityPiston) var11;
						if (var12.e() == var6 && var12.d()) {
							var12.h();
							var10 = true;
						}
					}
				}

				if (!var10 && var9.getMaterial() != Material.AIR && a(var9, var1, var8, var6.getOpposite(), false) && (var9.i() == 0 || var9 == Blocks.PISTON || var9 == Blocks.STICKY_PISTON)) {
					this.a(var1, var2, var6, false);
				}
			} else {
				var1.g(var2.a(var6));
			}

			var1.makeSound((double) var2.getX() + 0.5D, (double) var2.getY() + 0.5D, (double) var2.getZ() + 0.5D, "tile.piston.in", 0.5F, var1.s.nextFloat() * 0.15F + 0.6F);
		}

		return true;
	}

	public void a(ard var1, Position var2) {
		IBlockState var3 = var1.getBlockState(var2);
		if (var3.getBlock() == this && ((Boolean) var3.b(b)).booleanValue()) {
			float var4 = 0.25F;
			BlockFace var5 = (BlockFace) var3.b(a);
			if (var5 != null) {
				switch (bdr.a[var5.ordinal()]) {
					case 1:
						this.a(0.0F, 0.25F, 0.0F, 1.0F, 1.0F, 1.0F);
						break;
					case 2:
						this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
						break;
					case 3:
						this.a(0.0F, 0.0F, 0.25F, 1.0F, 1.0F, 1.0F);
						break;
					case 4:
						this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.75F);
						break;
					case 5:
						this.a(0.25F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
						break;
					case 6:
						this.a(0.0F, 0.0F, 0.0F, 0.75F, 1.0F, 1.0F);
				}
			}
		} else {
			this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}

	}

	public void h() {
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	public void a(World var1, Position var2, IBlockState var3, AxisAlignedBB var4, List var5, Entity var6) {
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		super.a(var1, var2, var3, var4, var5, var6);
	}

	public AxisAlignedBB a(World var1, Position var2, IBlockState var3) {
		this.a(var1, var2);
		return super.a(var1, var2, var3);
	}

	public boolean d() {
		return false;
	}

	public static BlockFace b(int var0) {
		int var1 = var0 & 7;
		return var1 > 5 ? null : BlockFace.getById(var1);
	}

	public static BlockFace a(World var0, Position var1, EntityLiving var2) {
		if (MathHelper.e((float) var2.locationX - (float) var1.getX()) < 2.0F && MathHelper.e((float) var2.locationZ - (float) var1.getZ()) < 2.0F) {
			double var3 = var2.locationY + (double) var2.getHeadHeight();
			if (var3 - (double) var1.getY() > 2.0D) {
				return BlockFace.UP;
			}

			if ((double) var1.getY() - var3 > 0.0D) {
				return BlockFace.DOWN;
			}
		}

		return var2.aO().getOpposite();
	}

	public static boolean a(Block var0, World var1, Position var2, BlockFace var3, boolean var4) {
		if (var0 == Blocks.OBSIDIAN) {
			return false;
		} else if (!var1.getWorldBorder().isInside(var2)) {
			return false;
		} else if (var2.getY() >= 0 && (var3 != BlockFace.DOWN || var2.getY() != 0)) {
			if (var2.getY() <= var1.U() - 1 && (var3 != BlockFace.UP || var2.getY() != var1.U() - 1)) {
				if (var0 != Blocks.PISTON && var0 != Blocks.STICKY_PISTON) {
					if (var0.g(var1, var2) == -1.0F) {
						return false;
					}

					if (var0.i() == 2) {
						return false;
					}

					if (var0.i() == 1) {
						if (!var4) {
							return false;
						}

						return true;
					}
				} else if (((Boolean) var1.getBlockState(var2).b(b)).booleanValue()) {
					return false;
				}

				return !(var0 instanceof avs);
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	private boolean a(World var1, Position var2, BlockFace var3, boolean var4) {
		if (!var4) {
			var1.g(var2.a(var3));
		}

		bdy var5 = new bdy(var1, var2, var3, var4);
		List var6 = var5.c();
		List var7 = var5.d();
		if (!var5.a()) {
			return false;
		} else {
			int var8 = var6.size() + var7.size();
			Block[] var9 = new Block[var8];
			BlockFace var10 = var4 ? var3 : var3.getOpposite();

			int var11;
			Position var12;
			for (var11 = var7.size() - 1; var11 >= 0; --var11) {
				var12 = (Position) var7.get(var11);
				Block var13 = var1.getBlockState(var12).getBlock();
				var13.b(var1, var12, var1.getBlockState(var12), 0);
				var1.g(var12);
				--var8;
				var9[var8] = var13;
			}

			IBlockState var19;
			for (var11 = var6.size() - 1; var11 >= 0; --var11) {
				var12 = (Position) var6.get(var11);
				var19 = var1.getBlockState(var12);
				Block var14 = var19.getBlock();
				var14.getData(var19);
				var1.g(var12);
				var12 = var12.a(var10);
				var1.setBlockAt(var12, Blocks.PISTON_EXTENSION.getBlockState().a(a, var3), 4);
				var1.a(var12, BlockPistonMoving.a(var19, var3, var4, false));
				--var8;
				var9[var8] = var14;
			}

			Position var16 = var2.a(var3);
			if (var4) {
				bdu var17 = this.M ? bdu.b : bdu.a;
				var19 = Blocks.PISTON_HEAD.getBlockState().a(BlockPistonExtension.a, var3).a(BlockPistonExtension.b, var17);
				IBlockState var20 = Blocks.PISTON_EXTENSION.getBlockState().a(BlockPistonMoving.a, var3).a(BlockPistonMoving.b, this.M ? bdu.b : bdu.a);
				var1.setBlockAt(var16, var20, 4);
				var1.a(var16, BlockPistonMoving.a(var19, var3, true, false));
			}

			int var18;
			for (var18 = var7.size() - 1; var18 >= 0; --var18) {
				var1.c((Position) var7.get(var18), var9[var8++]);
			}

			for (var18 = var6.size() - 1; var18 >= 0; --var18) {
				var1.c((Position) var6.get(var18), var9[var8++]);
			}

			if (var4) {
				var1.c(var16, (Block) Blocks.PISTON_HEAD);
				var1.c(var2, (Block) this);
			}

			return true;
		}
	}

	public IBlockState setData(int var1) {
		return this.getBlockState().a(a, b(var1)).a(b, Boolean.valueOf((var1 & 8) > 0));
	}

	public int getData(IBlockState var1) {
		byte var2 = 0;
		int var3 = var2 | ((BlockFace) var1.b(a)).getId();
		if (((Boolean) var1.b(b)).booleanValue()) {
			var3 |= 8;
		}

		return var3;
	}

	protected bed e() {
		return new bed(this, new bex[] { a, b });
	}

}
