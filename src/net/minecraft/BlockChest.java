package net.minecraft;

import com.google.common.base.Predicate;
import java.util.Iterator;
import java.util.Random;

public class BlockChest extends atg {

	public static final beu a = beu.a("facing", (Predicate) en.a);
	private final Random M = new Random();
	public final int chestType;

	protected BlockChest(int chestType) {
		super(Material.WOOD);
		this.setBlockState(this.L.b().a(a, BlockFace.NORTH));
		this.chestType = chestType;
		this.a(CreativeModeTab.DECORATIONS);
		this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
	}

	public boolean c() {
		return false;
	}

	public boolean d() {
		return false;
	}

	public int b() {
		return 2;
	}

	public void a(ard var1, Position var2) {
		if (var1.getBlockState(var2.c()).getBlock() == this) {
			this.a(0.0625F, 0.0F, 0.0F, 0.9375F, 0.875F, 0.9375F);
		} else if (var1.getBlockState(var2.d()).getBlock() == this) {
			this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 1.0F);
		} else if (var1.getBlockState(var2.e()).getBlock() == this) {
			this.a(0.0F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
		} else if (var1.getBlockState(var2.f()).getBlock() == this) {
			this.a(0.0625F, 0.0F, 0.0625F, 1.0F, 0.875F, 0.9375F);
		} else {
			this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
		}

	}

	public void c(World var1, Position var2, IBlockState var3) {
		this.e(var1, var2, var3);
		Iterator var4 = en.a.iterator();

		while (var4.hasNext()) {
			BlockFace var5 = (BlockFace) var4.next();
			Position var6 = var2.getRelative(var5);
			IBlockState var7 = var1.getBlockState(var6);
			if (var7.getBlock() == this) {
				this.e(var1, var6, var7);
			}
		}

	}

	public IBlockState a(World var1, Position var2, BlockFace var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		return this.getBlockState().a(a, var8.aO());
	}

	public void a(World var1, Position var2, IBlockState var3, EntityLiving var4, ItemStack var5) {
		BlockFace var6 = BlockFace.fromDirection(MathHelper.toFixedPointInt((double) (var4.yaw * 4.0F / 360.0F) + 0.5D) & 3).getOpposite();
		var3 = var3.a(a, var6);
		Position var7 = var2.c();
		Position var8 = var2.d();
		Position var9 = var2.e();
		Position var10 = var2.f();
		boolean var11 = this == var1.getBlockState(var7).getBlock();
		boolean var12 = this == var1.getBlockState(var8).getBlock();
		boolean var13 = this == var1.getBlockState(var9).getBlock();
		boolean var14 = this == var1.getBlockState(var10).getBlock();
		if (!var11 && !var12 && !var13 && !var14) {
			var1.setBlockAt(var2, var3, 3);
		} else if (var6.k() == el.a && (var11 || var12)) {
			if (var11) {
				var1.setBlockAt(var7, var3, 3);
			} else {
				var1.setBlockAt(var8, var3, 3);
			}

			var1.setBlockAt(var2, var3, 3);
		} else if (var6.k() == el.c && (var13 || var14)) {
			if (var13) {
				var1.setBlockAt(var9, var3, 3);
			} else {
				var1.setBlockAt(var10, var3, 3);
			}

			var1.setBlockAt(var2, var3, 3);
		}

		if (var5.hasDisplayName()) {
			TileEntity var15 = var1.getTileEntity(var2);
			if (var15 instanceof TileEntityChest) {
				((TileEntityChest) var15).setCustomName(var5.getDisplayName());
			}
		}

	}

	public IBlockState e(World var1, Position var2, IBlockState var3) {
		if (var1.isStatic) {
			return var3;
		} else {
			IBlockState var4 = var1.getBlockState(var2.c());
			IBlockState var5 = var1.getBlockState(var2.d());
			IBlockState var6 = var1.getBlockState(var2.e());
			IBlockState var7 = var1.getBlockState(var2.f());
			BlockFace var8 = (BlockFace) var3.b(a);
			Block var9 = var4.getBlock();
			Block var10 = var5.getBlock();
			Block var11 = var6.getBlock();
			Block var12 = var7.getBlock();
			if (var9 != this && var10 != this) {
				boolean var21 = var9.m();
				boolean var22 = var10.m();
				if (var11 == this || var12 == this) {
					Position var23 = var11 == this ? var2.e() : var2.f();
					IBlockState var24 = var1.getBlockState(var23.c());
					IBlockState var25 = var1.getBlockState(var23.d());
					var8 = BlockFace.SOUTH;
					BlockFace var26;
					if (var11 == this) {
						var26 = (BlockFace) var6.b(a);
					} else {
						var26 = (BlockFace) var7.b(a);
					}

					if (var26 == BlockFace.NORTH) {
						var8 = BlockFace.NORTH;
					}

					Block var19 = var24.getBlock();
					Block var20 = var25.getBlock();
					if ((var21 || var19.m()) && !var22 && !var20.m()) {
						var8 = BlockFace.SOUTH;
					}

					if ((var22 || var20.m()) && !var21 && !var19.m()) {
						var8 = BlockFace.NORTH;
					}
				}
			} else {
				Position var13 = var9 == this ? var2.c() : var2.d();
				IBlockState var14 = var1.getBlockState(var13.e());
				IBlockState var15 = var1.getBlockState(var13.f());
				var8 = BlockFace.EAST;
				BlockFace var16;
				if (var9 == this) {
					var16 = (BlockFace) var4.b(a);
				} else {
					var16 = (BlockFace) var5.b(a);
				}

				if (var16 == BlockFace.WEST) {
					var8 = BlockFace.WEST;
				}

				Block var17 = var14.getBlock();
				Block var18 = var15.getBlock();
				if ((var11.m() || var17.m()) && !var12.m() && !var18.m()) {
					var8 = BlockFace.EAST;
				}

				if ((var12.m() || var18.m()) && !var11.m() && !var17.m()) {
					var8 = BlockFace.WEST;
				}
			}

			var3 = var3.a(a, var8);
			var1.setBlockAt(var2, var3, 3);
			return var3;
		}
	}

	public IBlockState f(World var1, Position var2, IBlockState var3) {
		BlockFace var4 = null;
		Iterator var5 = en.a.iterator();

		while (var5.hasNext()) {
			BlockFace var6 = (BlockFace) var5.next();
			IBlockState var7 = var1.getBlockState(var2.getRelative(var6));
			if (var7.getBlock() == this) {
				return var3;
			}

			if (var7.getBlock().m()) {
				if (var4 != null) {
					var4 = null;
					break;
				}

				var4 = var6;
			}
		}

		if (var4 != null) {
			return var3.a(a, var4.getOpposite());
		} else {
			BlockFace var8 = (BlockFace) var3.b(a);
			if (var1.getBlockState(var2.getRelative(var8)).getBlock().m()) {
				var8 = var8.getOpposite();
			}

			if (var1.getBlockState(var2.getRelative(var8)).getBlock().m()) {
				var8 = var8.e();
			}

			if (var1.getBlockState(var2.getRelative(var8)).getBlock().m()) {
				var8 = var8.getOpposite();
			}

			return var3.a(a, var8);
		}
	}

	public boolean c(World var1, Position var2) {
		int var3 = 0;
		Position var4 = var2.e();
		Position var5 = var2.f();
		Position var6 = var2.c();
		Position var7 = var2.d();
		if (var1.getBlockState(var4).getBlock() == this) {
			if (this.e(var1, var4)) {
				return false;
			}

			++var3;
		}

		if (var1.getBlockState(var5).getBlock() == this) {
			if (this.e(var1, var5)) {
				return false;
			}

			++var3;
		}

		if (var1.getBlockState(var6).getBlock() == this) {
			if (this.e(var1, var6)) {
				return false;
			}

			++var3;
		}

		if (var1.getBlockState(var7).getBlock() == this) {
			if (this.e(var1, var7)) {
				return false;
			}

			++var3;
		}

		return var3 <= 1;
	}

	private boolean e(World var1, Position var2) {
		if (var1.getBlockState(var2).getBlock() != this) {
			return false;
		} else {
			Iterator var3 = en.a.iterator();

			BlockFace var4;
			do {
				if (!var3.hasNext()) {
					return false;
				}

				var4 = (BlockFace) var3.next();
			} while (var1.getBlockState(var2.getRelative(var4)).getBlock() != this);

			return true;
		}
	}

	public void a(World var1, Position var2, IBlockState var3, Block var4) {
		super.a(var1, var2, var3, var4);
		TileEntity var5 = var1.getTileEntity(var2);
		if (var5 instanceof TileEntityChest) {
			var5.removeBlockData();
		}

	}

	public void remove(World var1, Position var2, IBlockState var3) {
		TileEntity var4 = var1.getTileEntity(var2);
		if (var4 instanceof IInventory) {
			vs.a(var1, var2, (IInventory) var4);
			var1.e(var2, this);
		}

		super.remove(var1, var2, var3);
	}

	public boolean interact(World var1, Position var2, IBlockState var3, EntityHuman var4, BlockFace var5, float var6, float var7, float var8) {
		if (var1.isStatic) {
			return true;
		} else {
			ILockable var9 = this.d(var1, var2);
			if (var9 != null) {
				var4.a((IInventory) var9);
			}

			return true;
		}
	}

	public ILockable d(World var1, Position var2) {
		TileEntity var3 = var1.getTileEntity(var2);
		if (!(var3 instanceof TileEntityChest)) {
			return null;
		} else {
			Object var4 = (TileEntityChest) var3;
			if (this.m(var1, var2)) {
				return null;
			} else {
				Iterator var5 = en.a.iterator();

				while (var5.hasNext()) {
					BlockFace var6 = (BlockFace) var5.next();
					Position var7 = var2.getRelative(var6);
					Block var8 = var1.getBlockState(var7).getBlock();
					if (var8 == this) {
						if (this.m(var1, var7)) {
							return null;
						}

						TileEntity var9 = var1.getTileEntity(var7);
						if (var9 instanceof TileEntityChest) {
							if (var6 != BlockFace.WEST && var6 != BlockFace.NORTH) {
								var4 = new InventoryLargeChest("container.chestDouble", (ILockable) var4, (TileEntityChest) var9);
							} else {
								var4 = new InventoryLargeChest("container.chestDouble", (TileEntityChest) var9, (ILockable) var4);
							}
						}
					}
				}

				return (ILockable) var4;
			}
		}
	}

	public TileEntity getTileEntity(World var1, int var2) {
		return new TileEntityChest();
	}

	public boolean isTrappedChest() {
		return this.chestType == 1;
	}

	public int a(ard var1, Position var2, IBlockState var3, BlockFace var4) {
		if (!this.isTrappedChest()) {
			return 0;
		} else {
			int var5 = 0;
			TileEntity var6 = var1.getTileEntity(var2);
			if (var6 instanceof TileEntityChest) {
				var5 = ((TileEntityChest) var6).getAllViewersCount();
			}

			return MathHelper.a(var5, 0, 15);
		}
	}

	public int b(ard var1, Position var2, IBlockState var3, BlockFace var4) {
		return var4 == BlockFace.UP ? this.a(var1, var2, var3, var4) : 0;
	}

	private boolean m(World var1, Position var2) {
		return this.n(var1, var2) || this.o(var1, var2);
	}

	private boolean n(World var1, Position var2) {
		return var1.getBlockState(var2.a()).getBlock().t();
	}

	private boolean o(World var1, Position var2) {
		Iterator var3 = var1.getEntititesInAABB(EntityOcelot.class, new AxisAlignedBB((double) var2.getX(), (double) (var2.getY() + 1), (double) var2.getZ(), (double) (var2.getX() + 1), (double) (var2.getY() + 2), (double) (var2.getZ() + 1))).iterator();

		EntityOcelot var5;
		do {
			if (!var3.hasNext()) {
				return false;
			}

			Entity var4 = (Entity) var3.next();
			var5 = (EntityOcelot) var4;
		} while (!var5.cl());

		return true;
	}

	public boolean isComplexRedstone() {
		return true;
	}

	public int l(World var1, Position var2) {
		return Container.b((IInventory) this.d(var1, var2));
	}

	public IBlockState setData(int var1) {
		BlockFace var2 = BlockFace.getById(var1);
		if (var2.k() == el.b) {
			var2 = BlockFace.NORTH;
		}

		return this.getBlockState().a(a, var2);
	}

	public int getData(IBlockState var1) {
		return ((BlockFace) var1.b(a)).getId();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}
