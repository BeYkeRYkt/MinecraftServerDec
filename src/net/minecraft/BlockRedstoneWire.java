package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class BlockRedstoneWire extends Block {

	public static final bev a = bev.a("north", azu.class);
	public static final bev b = bev.a("east", azu.class);
	public static final bev M = bev.a("south", azu.class);
	public static final bev N = bev.a("west", azu.class);
	public static final bew O = bew.a("power", 0, 15);
	private boolean P = true;
	private final Set Q = Sets.newHashSet();

	public BlockRedstoneWire() {
		super(Material.ORIENTABLE);
		this.setBlockState(this.L.b().a(a, azu.c).a(b, azu.c).a(M, azu.c).a(N, azu.c).a(O, Integer.valueOf(0)));
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
	}

	public IBlockState a(IBlockState var1, ard var2, Position var3) {
		var1 = var1.a(N, this.c(var2, var3, BlockFace.WEST));
		var1 = var1.a(b, this.c(var2, var3, BlockFace.EAST));
		var1 = var1.a(a, this.c(var2, var3, BlockFace.NORTH));
		var1 = var1.a(M, this.c(var2, var3, BlockFace.SOUTH));
		return var1;
	}

	private azu c(ard var1, Position var2, BlockFace var3) {
		Position var4 = var2.getRelative(var3);
		Block var5 = var1.getBlockState(var2.getRelative(var3)).getBlock();
		if (!a(var1.getBlockState(var4), var3) && (var5.s() || !d(var1.getBlockState(var4.getDown())))) {
			Block var6 = var1.getBlockState(var2.getUp()).getBlock();
			return !var6.s() && var5.s() && d(var1.getBlockState(var4.getUp())) ? azu.a : azu.c;
		} else {
			return azu.b;
		}
	}

	public AxisAlignedBB a(World var1, Position var2, IBlockState var3) {
		return null;
	}

	public boolean c() {
		return false;
	}

	public boolean d() {
		return false;
	}

	public boolean c(World var1, Position var2) {
		return World.a((ard) var1, var2.getDown()) || var1.getBlockState(var2.getDown()).getBlock() == Blocks.GLOWSTONE;
	}

	private IBlockState e(World var1, Position var2, IBlockState var3) {
		var3 = this.a(var1, var2, var2, var3);
		ArrayList var4 = Lists.newArrayList((Iterable) this.Q);
		this.Q.clear();
		Iterator var5 = var4.iterator();

		while (var5.hasNext()) {
			Position var6 = (Position) var5.next();
			var1.c(var6, (Block) this);
		}

		return var3;
	}

	private IBlockState a(World var1, Position var2, Position var3, IBlockState var4) {
		IBlockState var5 = var4;
		int var6 = ((Integer) var4.b(O)).intValue();
		byte var7 = 0;
		int var14 = this.getPower(var1, var3, var7);
		this.P = false;
		int var8 = var1.getHighestNeighborSignal(var2);
		this.P = true;
		if (var8 > 0 && var8 > var14 - 1) {
			var14 = var8;
		}

		int var9 = 0;
		Iterator var10 = UniverseDirection.HORIZONTAL.iterator();

		while (var10.hasNext()) {
			BlockFace var11 = (BlockFace) var10.next();
			Position var12 = var2.getRelative(var11);
			boolean var13 = var12.getX() != var3.getX() || var12.getZ() != var3.getZ();
			if (var13) {
				var9 = this.getPower(var1, var12, var9);
			}

			if (var1.getBlockState(var12).getBlock().t() && !var1.getBlockState(var2.getUp()).getBlock().t()) {
				if (var13 && var2.getY() >= var3.getY()) {
					var9 = this.getPower(var1, var12.getUp(), var9);
				}
			} else if (!var1.getBlockState(var12).getBlock().t() && var13 && var2.getY() <= var3.getY()) {
				var9 = this.getPower(var1, var12.getDown(), var9);
			}
		}

		if (var9 > var14) {
			var14 = var9 - 1;
		} else if (var14 > 0) {
			--var14;
		} else {
			var14 = 0;
		}

		if (var8 > var14 - 1) {
			var14 = var8;
		}

		if (var6 != var14) {
			var4 = var4.a(O, Integer.valueOf(var14));
			if (var1.getBlockState(var2) == var5) {
				var1.setBlockAt(var2, var4, 2);
			}

			this.Q.add(var2);
			BlockFace[] var15 = BlockFace.values();
			int var16 = var15.length;

			for (int var17 = 0; var17 < var16; ++var17) {
				BlockFace var18 = var15[var17];
				this.Q.add(var2.getRelative(var18));
			}
		}

		return var4;
	}

	private void d(World var1, Position var2) {
		if (var1.getBlockState(var2).getBlock() == this) {
			var1.c(var2, (Block) this);
			BlockFace[] var3 = BlockFace.values();
			int var4 = var3.length;

			for (int var5 = 0; var5 < var4; ++var5) {
				BlockFace var6 = var3[var5];
				var1.c(var2.getRelative(var6), (Block) this);
			}

		}
	}

	public void onPlace(World var1, Position var2, IBlockState var3) {
		if (!var1.isStatic) {
			this.e(var1, var2, var3);
			Iterator var4 = UniverseDirection.VERTICAL.iterator();

			BlockFace var5;
			while (var4.hasNext()) {
				var5 = (BlockFace) var4.next();
				var1.c(var2.getRelative(var5), (Block) this);
			}

			var4 = UniverseDirection.HORIZONTAL.iterator();

			while (var4.hasNext()) {
				var5 = (BlockFace) var4.next();
				this.d(var1, var2.getRelative(var5));
			}

			var4 = UniverseDirection.HORIZONTAL.iterator();

			while (var4.hasNext()) {
				var5 = (BlockFace) var4.next();
				Position var6 = var2.getRelative(var5);
				if (var1.getBlockState(var6).getBlock().t()) {
					this.d(var1, var6.getUp());
				} else {
					this.d(var1, var6.getDown());
				}
			}

		}
	}

	public void remove(World var1, Position var2, IBlockState var3) {
		super.remove(var1, var2, var3);
		if (!var1.isStatic) {
			BlockFace[] var4 = BlockFace.values();
			int var5 = var4.length;

			for (int var6 = 0; var6 < var5; ++var6) {
				BlockFace var7 = var4[var6];
				var1.c(var2.getRelative(var7), (Block) this);
			}

			this.e(var1, var2, var3);
			Iterator var8 = UniverseDirection.HORIZONTAL.iterator();

			BlockFace var9;
			while (var8.hasNext()) {
				var9 = (BlockFace) var8.next();
				this.d(var1, var2.getRelative(var9));
			}

			var8 = UniverseDirection.HORIZONTAL.iterator();

			while (var8.hasNext()) {
				var9 = (BlockFace) var8.next();
				Position var10 = var2.getRelative(var9);
				if (var1.getBlockState(var10).getBlock().t()) {
					this.d(var1, var10.getUp());
				} else {
					this.d(var1, var10.getDown());
				}
			}

		}
	}

	public int getPower(World world, Position position, int minimum) {
		if (world.getBlockState(position).getBlock() != this) {
			return minimum;
		} else {
			int power = ((Integer) world.getBlockState(position).b(O)).intValue();
			return power > minimum ? power : minimum;
		}
	}

	public void a(World var1, Position var2, IBlockState var3, Block var4) {
		if (!var1.isStatic) {
			if (this.c(var1, var2)) {
				this.e(var1, var2, var3);
			} else {
				this.dropNaturally(var1, var2, var3, 0);
				var1.g(var2);
			}

		}
	}

	public Item getItemDrop(IBlockState var1, Random var2, int var3) {
		return Items.REDSTONE;
	}

	public int b(ard var1, Position var2, IBlockState var3, BlockFace var4) {
		return !this.P ? 0 : this.getPower(var1, var2, var3, var4);
	}

	public int getPower(ard var1, Position var2, IBlockState var3, BlockFace var4) {
		if (!this.P) {
			return 0;
		} else {
			int var5 = ((Integer) var3.b(O)).intValue();
			if (var5 == 0) {
				return 0;
			} else if (var4 == BlockFace.UP) {
				return var5;
			} else {
				EnumSet var6 = EnumSet.noneOf(BlockFace.class);
				Iterator var7 = UniverseDirection.HORIZONTAL.iterator();

				while (var7.hasNext()) {
					BlockFace var8 = (BlockFace) var7.next();
					if (this.d(var1, var2, var8)) {
						var6.add(var8);
					}
				}

				if (var4.k().c() && var6.isEmpty()) {
					return var5;
				} else if (var6.contains(var4) && !var6.contains(var4.f()) && !var6.contains(var4.e())) {
					return var5;
				} else {
					return 0;
				}
			}
		}
	}

	private boolean d(ard var1, Position var2, BlockFace var3) {
		Position var4 = var2.getRelative(var3);
		IBlockState var5 = var1.getBlockState(var4);
		Block var6 = var5.getBlock();
		boolean var7 = var6.t();
		boolean var8 = var1.getBlockState(var2.getUp()).getBlock().t();
		return !var8 && var7 && e(var1, var4.getUp()) ? true : (a(var5, var3) ? true : (var6 == Blocks.POWERED_REPEATER && var5.b(ava.N) == var3 ? true : !var7 && e(var1, var4.getDown())));
	}

	protected static boolean e(ard var0, Position var1) {
		return d(var0.getBlockState(var1));
	}

	protected static boolean d(IBlockState var0) {
		return a(var0, (BlockFace) null);
	}

	protected static boolean a(IBlockState var0, BlockFace var1) {
		Block var2 = var0.getBlock();
		if (var2 == Blocks.REDSTONE_WIRE) {
			return true;
		} else if (Blocks.UNPOWERED_REPEATER.e(var2)) {
			BlockFace var3 = (BlockFace) var0.b(BlockRepeater.N);
			return var3 == var1 || var3.getOpposite() == var1;
		} else {
			return var2.isTrappedChest() && var1 != null;
		}
	}

	public boolean isTrappedChest() {
		return this.P;
	}

	public IBlockState setData(int var1) {
		return this.getBlockState().a(O, Integer.valueOf(var1));
	}

	public int getData(IBlockState var1) {
		return ((Integer) var1.b(O)).intValue();
	}

	protected bed e() {
		return new bed(this, new bex[] { a, b, M, N, O });
	}

}
