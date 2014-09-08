package net.minecraft;

import java.util.List;
import java.util.Random;

public abstract class aud extends Block {

	public static final beu a = beu.a("facing");
	public static final bet b = bet.a("powered");
	private final boolean M;

	protected aud(boolean var1) {
		super(Material.ORIENTABLE);
		this.setBlockState(this.L.b().a(a, BlockFace.NORTH).a(b, Boolean.valueOf(false)));
		this.a(true);
		this.a(CreativeModeTab.REDSTONE);
		this.M = var1;
	}

	public AxisAlignedBB a(World var1, Position var2, BlockState var3) {
		return null;
	}

	public int a(World var1) {
		return this.M ? 30 : 20;
	}

	public boolean c() {
		return false;
	}

	public boolean d() {
		return false;
	}

	public boolean a(World var1, Position var2, BlockFace var3) {
		return var1.getBlockState(var2.a(var3.getOpposite())).getBlock().t();
	}

	public boolean c(World var1, Position var2) {
		BlockFace[] var3 = BlockFace.values();
		int var4 = var3.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			BlockFace var6 = var3[var5];
			if (var1.getBlockState(var2.a(var6)).getBlock().t()) {
				return true;
			}
		}

		return false;
	}

	public BlockState a(World var1, Position var2, BlockFace var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		return var1.getBlockState(var2.a(var3.getOpposite())).getBlock().t() ? this.getBlockState().a(a, var3).a(b, Boolean.valueOf(false)) : this.getBlockState().a(a, BlockFace.DOWN).a(b, Boolean.valueOf(false));
	}

	public void a(World var1, Position var2, BlockState var3, Block var4) {
		if (this.e(var1, var2, var3)) {
			BlockFace var5 = (BlockFace) var3.b(a);
			if (!var1.getBlockState(var2.a(var5.getOpposite())).getBlock().t()) {
				this.b(var1, var2, var3, 0);
				var1.g(var2);
			}
		}

	}

	private boolean e(World var1, Position var2, BlockState var3) {
		if (!this.c(var1, var2)) {
			this.b(var1, var2, var3, 0);
			var1.g(var2);
			return false;
		} else {
			return true;
		}
	}

	public void a(ard var1, Position var2) {
		this.d(var1.getBlockState(var2));
	}

	private void d(BlockState var1) {
		BlockFace var2 = (BlockFace) var1.b(a);
		boolean var3 = ((Boolean) var1.b(b)).booleanValue();
		float var4 = 0.25F;
		float var5 = 0.375F;
		float var6 = (float) (var3 ? 1 : 2) / 16.0F;
		float var7 = 0.125F;
		float var8 = 0.1875F;
		switch (aue.a[var2.ordinal()]) {
			case 1:
				this.a(0.0F, 0.375F, 0.3125F, var6, 0.625F, 0.6875F);
				break;
			case 2:
				this.a(1.0F - var6, 0.375F, 0.3125F, 1.0F, 0.625F, 0.6875F);
				break;
			case 3:
				this.a(0.3125F, 0.375F, 0.0F, 0.6875F, 0.625F, var6);
				break;
			case 4:
				this.a(0.3125F, 0.375F, 1.0F - var6, 0.6875F, 0.625F, 1.0F);
				break;
			case 5:
				this.a(0.3125F, 0.0F, 0.375F, 0.6875F, 0.0F + var6, 0.625F);
				break;
			case 6:
				this.a(0.3125F, 1.0F - var6, 0.375F, 0.6875F, 1.0F, 0.625F);
		}

	}

	public boolean a(World var1, Position var2, BlockState var3, EntityHuman var4, BlockFace var5, float var6, float var7, float var8) {
		if (((Boolean) var3.b(b)).booleanValue()) {
			return true;
		} else {
			var1.a(var2, var3.a(b, Boolean.valueOf(true)), 3);
			var1.b(var2, var2);
			var1.makeSound((double) var2.getX() + 0.5D, (double) var2.getY() + 0.5D, (double) var2.getZ() + 0.5D, "random.click", 0.3F, 0.6F);
			this.b(var1, var2, (BlockFace) var3.b(a));
			var1.a(var2, (Block) this, this.a(var1));
			return true;
		}
	}

	public void b(World var1, Position var2, BlockState var3) {
		if (((Boolean) var3.b(b)).booleanValue()) {
			this.b(var1, var2, (BlockFace) var3.b(a));
		}

		super.b(var1, var2, var3);
	}

	public int a(ard var1, Position var2, BlockState var3, BlockFace var4) {
		return ((Boolean) var3.b(b)).booleanValue() ? 15 : 0;
	}

	public int b(ard var1, Position var2, BlockState var3, BlockFace var4) {
		return !((Boolean) var3.b(b)).booleanValue() ? 0 : (var3.b(a) == var4 ? 15 : 0);
	}

	public boolean g() {
		return true;
	}

	public void a(World var1, Position var2, BlockState var3, Random var4) {
	}

	public void b(World var1, Position var2, BlockState var3, Random var4) {
		if (!var1.D) {
			if (((Boolean) var3.b(b)).booleanValue()) {
				if (this.M) {
					this.f(var1, var2, var3);
				} else {
					var1.a(var2, var3.a(b, Boolean.valueOf(false)));
					this.b(var1, var2, (BlockFace) var3.b(a));
					var1.makeSound((double) var2.getX() + 0.5D, (double) var2.getY() + 0.5D, (double) var2.getZ() + 0.5D, "random.click", 0.3F, 0.5F);
					var1.b(var2, var2);
				}

			}
		}
	}

	public void h() {
		float var1 = 0.1875F;
		float var2 = 0.125F;
		float var3 = 0.125F;
		this.a(0.5F - var1, 0.5F - var2, 0.5F - var3, 0.5F + var1, 0.5F + var2, 0.5F + var3);
	}

	public void a(World var1, Position var2, BlockState var3, Entity var4) {
		if (!var1.D) {
			if (this.M) {
				if (!((Boolean) var3.b(b)).booleanValue()) {
					this.f(var1, var2, var3);
				}
			}
		}
	}

	private void f(World var1, Position var2, BlockState var3) {
		this.d(var3);
		List var4 = var1.a(EntityArrow.class, new AxisAlignedBB((double) var2.getX() + this.B, (double) var2.getY() + this.C, (double) var2.getZ() + this.D, (double) var2.getX() + this.E, (double) var2.getY() + this.F, (double) var2.getZ() + this.G));
		boolean var5 = !var4.isEmpty();
		boolean var6 = ((Boolean) var3.b(b)).booleanValue();
		if (var5 && !var6) {
			var1.a(var2, var3.a(b, Boolean.valueOf(true)));
			this.b(var1, var2, (BlockFace) var3.b(a));
			var1.b(var2, var2);
			var1.makeSound((double) var2.getX() + 0.5D, (double) var2.getY() + 0.5D, (double) var2.getZ() + 0.5D, "random.click", 0.3F, 0.6F);
		}

		if (!var5 && var6) {
			var1.a(var2, var3.a(b, Boolean.valueOf(false)));
			this.b(var1, var2, (BlockFace) var3.b(a));
			var1.b(var2, var2);
			var1.makeSound((double) var2.getX() + 0.5D, (double) var2.getY() + 0.5D, (double) var2.getZ() + 0.5D, "random.click", 0.3F, 0.5F);
		}

		if (var5) {
			var1.a(var2, (Block) this, this.a(var1));
		}

	}

	private void b(World var1, Position var2, BlockFace var3) {
		var1.c(var2, (Block) this);
		var1.c(var2.a(var3.getOpposite()), (Block) this);
	}

	public BlockState a(int var1) {
		BlockFace var2;
		switch (var1 & 7) {
			case 0:
				var2 = BlockFace.DOWN;
				break;
			case 1:
				var2 = BlockFace.EAST;
				break;
			case 2:
				var2 = BlockFace.WEST;
				break;
			case 3:
				var2 = BlockFace.SOUTH;
				break;
			case 4:
				var2 = BlockFace.NORTH;
				break;
			case 5:
			default:
				var2 = BlockFace.UP;
		}

		return this.getBlockState().a(a, var2).a(b, Boolean.valueOf((var1 & 8) > 0));
	}

	public int c(BlockState var1) {
		int var2;
		switch (aue.a[((BlockFace) var1.b(a)).ordinal()]) {
			case 1:
				var2 = 1;
				break;
			case 2:
				var2 = 2;
				break;
			case 3:
				var2 = 3;
				break;
			case 4:
				var2 = 4;
				break;
			case 5:
			default:
				var2 = 5;
				break;
			case 6:
				var2 = 0;
		}

		if (((Boolean) var1.b(b)).booleanValue()) {
			var2 |= 8;
		}

		return var2;
	}

	protected bed e() {
		return new bed(this, new bex[] { a, b });
	}

}
