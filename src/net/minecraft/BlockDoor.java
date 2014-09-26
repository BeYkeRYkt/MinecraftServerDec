package net.minecraft;

import com.google.common.base.Predicate;
import java.util.Random;

public class BlockDoor extends Block {

	public static final beu a = beu.a("facing", (Predicate) UniverseDirection.HORIZONTAL);
	public static final bet b = bet.a("open");
	public static final bev M = bev.a("hinge", avh.class);
	public static final bet N = bet.a("powered");
	public static final bev O = bev.a("half", avg.class);

	protected BlockDoor(Material var1) {
		super(var1);
		this.setBlockState(this.L.b().a(a, BlockFace.NORTH).a(b, Boolean.valueOf(false)).a(M, avh.a).a(N, Boolean.valueOf(false)).a(O, avg.b));
	}

	public boolean c() {
		return false;
	}

	public boolean b(ard var1, Position var2) {
		return g(e(var1, var2));
	}

	public boolean d() {
		return false;
	}

	public AxisAlignedBB a(World var1, Position var2, IBlockState var3) {
		this.a(var1, var2);
		return super.a(var1, var2, var3);
	}

	public void a(ard var1, Position var2) {
		this.k(e(var1, var2));
	}

	private void k(int var1) {
		float var2 = 0.1875F;
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
		BlockFace var3 = f(var1);
		boolean var4 = g(var1);
		boolean var5 = j(var1);
		if (var4) {
			if (var3 == BlockFace.EAST) {
				if (!var5) {
					this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
				} else {
					this.a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
				}
			} else if (var3 == BlockFace.SOUTH) {
				if (!var5) {
					this.a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				} else {
					this.a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
				}
			} else if (var3 == BlockFace.WEST) {
				if (!var5) {
					this.a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
				} else {
					this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
				}
			} else if (var3 == BlockFace.NORTH) {
				if (!var5) {
					this.a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
				} else {
					this.a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				}
			}
		} else if (var3 == BlockFace.EAST) {
			this.a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
		} else if (var3 == BlockFace.SOUTH) {
			this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
		} else if (var3 == BlockFace.WEST) {
			this.a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		} else if (var3 == BlockFace.NORTH) {
			this.a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
		}

	}

	public boolean interact(World var1, Position var2, IBlockState var3, EntityHuman var4, BlockFace var5, float var6, float var7, float var8) {
		if (this.material == Material.ORE) {
			return true;
		} else {
			Position var9 = var3.b(O) == avg.b ? var2 : var2.getDown();
			IBlockState var10 = var2.equals(var9) ? var3 : var1.getBlockState(var9);
			if (var10.getBlock() != this) {
				return false;
			} else {
				var3 = var10.a(b);
				var1.setBlockAt(var9, var3, 2);
				var1.b(var9, var2);
				var1.a(var4, ((Boolean) var3.b(b)).booleanValue() ? 1003 : 1006, var2, 0);
				return true;
			}
		}
	}

	public void a(World var1, Position var2, boolean var3) {
		IBlockState var4 = var1.getBlockState(var2);
		if (var4.getBlock() == this) {
			Position var5 = var4.b(O) == avg.b ? var2 : var2.getDown();
			IBlockState var6 = var2 == var5 ? var4 : var1.getBlockState(var5);
			if (var6.getBlock() == this && ((Boolean) var6.b(b)).booleanValue() != var3) {
				var1.setBlockAt(var5, var6.a(b, Boolean.valueOf(var3)), 2);
				var1.b(var5, var2);
				var1.a((EntityHuman) null, var3 ? 1003 : 1006, var2, 0);
			}

		}
	}

	public void a(World var1, Position var2, IBlockState var3, Block var4) {
		if (var3.b(O) == avg.a) {
			Position var5 = var2.getDown();
			IBlockState var6 = var1.getBlockState(var5);
			if (var6.getBlock() != this) {
				var1.g(var2);
			} else if (var4 != this) {
				this.a(var1, var5, var6, var4);
			}
		} else {
			boolean var9 = false;
			Position var10 = var2.getUp();
			IBlockState var7 = var1.getBlockState(var10);
			if (var7.getBlock() != this) {
				var1.g(var2);
				var9 = true;
			}

			if (!World.a((ard) var1, var2.getDown())) {
				var1.g(var2);
				var9 = true;
				if (var7.getBlock() == this) {
					var1.g(var10);
				}
			}

			if (var9) {
				if (!var1.isStatic) {
					this.dropNaturally(var1, var2, var3, 0);
				}
			} else {
				boolean var8 = var1.isBlockIndirectlyPowered(var2) || var1.isBlockIndirectlyPowered(var10);
				if ((var8 || var4.isTrappedChest()) && var4 != this && var8 != ((Boolean) var7.b(N)).booleanValue()) {
					var1.setBlockAt(var10, var7.a(N, Boolean.valueOf(var8)), 2);
					if (var8 != ((Boolean) var3.b(b)).booleanValue()) {
						var1.setBlockAt(var2, var3.a(b, Boolean.valueOf(var8)), 2);
						var1.b(var2, var2);
						var1.a((EntityHuman) null, var8 ? 1003 : 1006, var2, 0);
					}
				}
			}
		}

	}

	public Item getItemDrop(IBlockState var1, Random var2, int var3) {
		return var1.b(O) == avg.a ? null : this.j();
	}

	public MovingObjectPosition a(World var1, Position var2, Vec3D var3, Vec3D var4) {
		this.a(var1, var2);
		return super.a(var1, var2, var3, var4);
	}

	public boolean c(World var1, Position var2) {
		return var2.getY() >= 255 ? false : World.a((ard) var1, var2.getDown()) && super.c(var1, var2) && super.c(var1, var2.getUp());
	}

	public int i() {
		return 1;
	}

	public static int e(ard var0, Position var1) {
		IBlockState var2 = var0.getBlockState(var1);
		int var3 = var2.getBlock().getData(var2);
		boolean var4 = i(var3);
		IBlockState var5 = var0.getBlockState(var1.getDown());
		int var6 = var5.getBlock().getData(var5);
		int var7 = var4 ? var6 : var3;
		IBlockState var8 = var0.getBlockState(var1.getUp());
		int var9 = var8.getBlock().getData(var8);
		int var10 = var4 ? var3 : var9;
		boolean var11 = (var10 & 1) != 0;
		boolean var12 = (var10 & 2) != 0;
		return b(var7) | (var4 ? 8 : 0) | (var11 ? 16 : 0) | (var12 ? 32 : 0);
	}

	private Item j() {
		return this == Blocks.IRON_DOOR ? Items.IRON_DOOR : (this == Blocks.SPRUCE_DOOR ? Items.SPRUCE_DOOR : (this == Blocks.BIRCH_DOOR ? Items.BIRCH_DOOR : (this == Blocks.JUNGLE_DOOR ? Items.JUNGLE_DOOR : (this == Blocks.ACACIA_DOOR ? Items.ACACIA_DOOR : (this == Blocks.DARK_OAK_DOOR ? Items.DARK_OAK_DOOR : Items.WOODEN_DOOR)))));
	}

	public void a(World var1, Position var2, IBlockState var3, EntityHuman var4) {
		Position var5 = var2.getDown();
		if (var4.playerProperties.instabuild && var3.b(O) == avg.a && var1.getBlockState(var5).getBlock() == this) {
			var1.g(var5);
		}

	}

	public IBlockState a(IBlockState var1, ard var2, Position var3) {
		IBlockState var4;
		if (var1.b(O) == avg.b) {
			var4 = var2.getBlockState(var3.getUp());
			if (var4.getBlock() == this) {
				var1 = var1.a(M, var4.b(M)).a(N, var4.b(N));
			}
		} else {
			var4 = var2.getBlockState(var3.getDown());
			if (var4.getBlock() == this) {
				var1 = var1.a(a, var4.b(a)).a(b, var4.b(b));
			}
		}

		return var1;
	}

	public IBlockState setData(int var1) {
		return (var1 & 8) > 0 ? this.getBlockState().a(O, avg.a).a(M, (var1 & 1) > 0 ? avh.b : avh.a).a(N, Boolean.valueOf((var1 & 2) > 0)) : this.getBlockState().a(O, avg.b).a(a, BlockFace.fromDirection(var1 & 3).f()).a(b, Boolean.valueOf((var1 & 4) > 0));
	}

	public int getData(IBlockState var1) {
		byte var2 = 0;
		int var3;
		if (var1.b(O) == avg.a) {
			var3 = var2 | 8;
			if (var1.b(M) == avh.b) {
				var3 |= 1;
			}

			if (((Boolean) var1.b(N)).booleanValue()) {
				var3 |= 2;
			}
		} else {
			var3 = var2 | ((BlockFace) var1.b(a)).e().toDirection();
			if (((Boolean) var1.b(b)).booleanValue()) {
				var3 |= 4;
			}
		}

		return var3;
	}

	protected static int b(int var0) {
		return var0 & 7;
	}

	public static boolean f(ard var0, Position var1) {
		return g(e(var0, var1));
	}

	public static BlockFace h(ard var0, Position var1) {
		return f(e(var0, var1));
	}

	public static BlockFace f(int var0) {
		return BlockFace.fromDirection(var0 & 3).f();
	}

	protected static boolean g(int var0) {
		return (var0 & 4) != 0;
	}

	protected static boolean i(int var0) {
		return (var0 & 8) != 0;
	}

	protected static boolean j(int var0) {
		return (var0 & 16) != 0;
	}

	protected bed e() {
		return new bed(this, new bex[] { O, a, b, M, N });
	}

}
