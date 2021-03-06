package net.minecraft;

import java.util.Random;

public abstract class ava extends avb {

	protected final boolean M;

	protected ava(boolean var1) {
		super(Material.ORIENTABLE);
		this.M = var1;
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
	}

	public boolean d() {
		return false;
	}

	public boolean c(World var1, Position var2) {
		return World.a((ard) var1, var2.getDown()) ? super.c(var1, var2) : false;
	}

	public boolean d(World var1, Position var2) {
		return World.a((ard) var1, var2.getDown());
	}

	public void a(World var1, Position var2, IBlockState var3, Random var4) {
	}

	public void b(World var1, Position var2, IBlockState var3, Random var4) {
		if (!this.b((ard) var1, var2, var3)) {
			boolean var5 = this.e(var1, var2, var3);
			if (this.M && !var5) {
				var1.setBlockAt(var2, this.k(var3), 2);
			} else if (!this.M) {
				var1.setBlockAt(var2, this.e(var3), 2);
				if (!var5) {
					var1.a(var2, this.e(var3).getBlock(), this.m(var3), -1);
				}
			}

		}
	}

	protected boolean l(IBlockState var1) {
		return this.M;
	}

	public int b(ard var1, Position var2, IBlockState var3, BlockFace var4) {
		return this.getPower(var1, var2, var3, var4);
	}

	public int getPower(ard var1, Position var2, IBlockState var3, BlockFace var4) {
		return !this.l(var3) ? 0 : (var3.b(N) == var4 ? this.a(var1, var2, var3) : 0);
	}

	public void a(World var1, Position var2, IBlockState var3, Block var4) {
		if (this.d(var1, var2)) {
			this.g(var1, var2, var3);
		} else {
			this.dropNaturally(var1, var2, var3, 0);
			var1.g(var2);
			BlockFace[] var5 = BlockFace.values();
			int var6 = var5.length;

			for (int var7 = 0; var7 < var6; ++var7) {
				BlockFace var8 = var5[var7];
				var1.c(var2.getRelative(var8), (Block) this);
			}

		}
	}

	protected void g(World var1, Position var2, IBlockState var3) {
		if (!this.b((ard) var1, var2, var3)) {
			boolean var4 = this.e(var1, var2, var3);
			if ((this.M && !var4 || !this.M && var4) && !var1.a(var2, (Block) this)) {
				byte var5 = -1;
				if (this.i(var1, var2, var3)) {
					var5 = -3;
				} else if (this.M) {
					var5 = -2;
				}

				var1.a(var2, this, this.d(var3), var5);
			}

		}
	}

	public boolean b(ard var1, Position var2, IBlockState var3) {
		return false;
	}

	protected boolean e(World var1, Position var2, IBlockState var3) {
		return this.f(var1, var2, var3) > 0;
	}

	protected int f(World var1, Position var2, IBlockState var3) {
		BlockFace var4 = (BlockFace) var3.b(N);
		Position var5 = var2.getRelative(var4);
		int var6 = var1.getBlockFacePower(var5, var4);
		if (var6 >= 15) {
			return var6;
		} else {
			IBlockState var7 = var1.getBlockState(var5);
			return Math.max(var6, var7.getBlock() == Blocks.REDSTONE_WIRE ? ((Integer) var7.b(BlockRedstoneWire.O)).intValue() : 0);
		}
	}

	protected int c(ard var1, Position var2, IBlockState var3) {
		BlockFace var4 = (BlockFace) var3.b(N);
		BlockFace var5 = var4.e();
		BlockFace var6 = var4.f();
		return Math.max(this.c(var1, var2.getRelative(var5), var5), this.c(var1, var2.getRelative(var6), var6));
	}

	protected int c(ard var1, Position var2, BlockFace var3) {
		IBlockState var4 = var1.getBlockState(var2);
		Block var5 = var4.getBlock();
		return this.c(var5) ? (var5 == Blocks.REDSTONE_WIRE ? ((Integer) var4.b(BlockRedstoneWire.O)).intValue() : var1.getBlockPower(var2, var3)) : 0;
	}

	public boolean isTrappedChest() {
		return true;
	}

	public IBlockState a(World var1, Position var2, BlockFace var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		return this.getBlockState().a(N, var8.aO().getOpposite());
	}

	public void a(World var1, Position var2, IBlockState var3, EntityLiving var4, ItemStack var5) {
		if (this.e(var1, var2, var3)) {
			var1.a(var2, (Block) this, 1);
		}

	}

	public void onPlace(World var1, Position var2, IBlockState var3) {
		this.h(var1, var2, var3);
	}

	protected void h(World var1, Position var2, IBlockState var3) {
		BlockFace var4 = (BlockFace) var3.b(N);
		Position var5 = var2.getRelative(var4.getOpposite());
		var1.d(var5, this);
		var1.a(var5, (Block) this, var4);
	}

	public void d(World var1, Position var2, IBlockState var3) {
		if (this.M) {
			BlockFace[] var4 = BlockFace.values();
			int var5 = var4.length;

			for (int var6 = 0; var6 < var5; ++var6) {
				BlockFace var7 = var4[var6];
				var1.c(var2.getRelative(var7), (Block) this);
			}
		}

		super.d(var1, var2, var3);
	}

	public boolean c() {
		return false;
	}

	protected boolean c(Block var1) {
		return var1.isTrappedChest();
	}

	protected int a(ard var1, Position var2, IBlockState var3) {
		return 15;
	}

	public static boolean d(Block var0) {
		return Blocks.UNPOWERED_REPEATER.e(var0) || Blocks.UNPOWERED_COMPARATOR.e(var0);
	}

	public boolean e(Block var1) {
		return var1 == this.e(this.getBlockState()).getBlock() || var1 == this.k(this.getBlockState()).getBlock();
	}

	public boolean i(World var1, Position var2, IBlockState var3) {
		BlockFace var4 = ((BlockFace) var3.b(N)).getOpposite();
		Position var5 = var2.getRelative(var4);
		return d(var1.getBlockState(var5).getBlock()) ? var1.getBlockState(var5).b(N) != var4 : false;
	}

	protected int m(IBlockState var1) {
		return this.d(var1);
	}

	protected abstract int d(IBlockState var1);

	protected abstract IBlockState e(IBlockState var1);

	protected abstract IBlockState k(IBlockState var1);

	public boolean b(Block var1) {
		return this.e(var1);
	}
}
