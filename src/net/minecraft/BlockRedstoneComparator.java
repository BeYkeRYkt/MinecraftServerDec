package net.minecraft;

import com.google.common.base.Predicate;

import java.util.List;
import java.util.Random;

public class BlockRedstoneComparator extends ava implements avs {

	public static final bet a = bet.a("powered");
	public static final bev b = bev.a("mode", aur.class);

	public BlockRedstoneComparator(boolean var1) {
		super(var1);
		this.setBlockState(this.L.b().a(N, BlockFace.NORTH).a(a, Boolean.valueOf(false)).a(b, aur.a));
		this.A = true;
	}

	public Item a(IBlockState var1, Random var2, int var3) {
		return Items.COMPARATOR;
	}

	protected int d(IBlockState var1) {
		return 2;
	}

	protected IBlockState e(IBlockState var1) {
		Boolean var2 = (Boolean) var1.b(a);
		aur var3 = (aur) var1.b(b);
		BlockFace var4 = (BlockFace) var1.b(N);
		return Blocks.POWERED_COMPARATOR.getBlockState().a(N, var4).a(a, var2).a(b, var3);
	}

	protected IBlockState k(IBlockState var1) {
		Boolean var2 = (Boolean) var1.b(a);
		aur var3 = (aur) var1.b(b);
		BlockFace var4 = (BlockFace) var1.b(N);
		return Blocks.UNPOWERED_COMPARATOR.getBlockState().a(N, var4).a(a, var2).a(b, var3);
	}

	protected boolean l(IBlockState var1) {
		return this.M || ((Boolean) var1.b(a)).booleanValue();
	}

	protected int a(ard var1, Position var2, IBlockState var3) {
		TileEntity var4 = var1.getTileEntity(var2);
		return var4 instanceof TileEntityComparator ? ((TileEntityComparator) var4).b() : 0;
	}

	private int j(World var1, Position var2, IBlockState var3) {
		return var3.b(b) == aur.b ? Math.max(this.f(var1, var2, var3) - this.c((ard) var1, var2, var3), 0) : this.f(var1, var2, var3);
	}

	protected boolean e(World var1, Position var2, IBlockState var3) {
		int var4 = this.f(var1, var2, var3);
		if (var4 >= 15) {
			return true;
		} else if (var4 == 0) {
			return false;
		} else {
			int var5 = this.c((ard) var1, var2, var3);
			return var5 == 0 ? true : var4 >= var5;
		}
	}

	protected int f(World var1, Position var2, IBlockState var3) {
		int var4 = super.f(var1, var2, var3);
		BlockFace var5 = (BlockFace) var3.b(N);
		Position var6 = var2.getRelative(var5);
		Block var7 = var1.getBlockState(var6).getBlock();
		if (var7.isComplexRedstone()) {
			var4 = var7.l(var1, var6);
		} else if (var4 < 15 && var7.t()) {
			var6 = var6.getRelative(var5);
			var7 = var1.getBlockState(var6).getBlock();
			if (var7.isComplexRedstone()) {
				var4 = var7.l(var1, var6);
			} else if (var7.getMaterial() == Material.AIR) {
				EntityItemFrame var8 = this.a(var1, var5, var6);
				if (var8 != null) {
					var4 = var8.q();
				}
			}
		}

		return var4;
	}

	private EntityItemFrame a(World var1, BlockFace var2, Position var3) {
		List var4 = var1.getEntititesInAABB(EntityItemFrame.class, new AxisAlignedBB((double) var3.getX(), (double) var3.getY(), (double) var3.getZ(), (double) (var3.getX() + 1), (double) (var3.getY() + 1), (double) (var3.getZ() + 1)), (Predicate) (new auq(this, var2)));
		return var4.size() == 1 ? (EntityItemFrame) var4.get(0) : null;
	}

	public boolean interact(World var1, Position var2, IBlockState var3, EntityHuman var4, BlockFace var5, float var6, float var7, float var8) {
		if (!var4.playerProperties.maybuild) {
			return false;
		} else {
			var3 = var3.a(b);
			var1.makeSound((double) var2.getX() + 0.5D, (double) var2.getY() + 0.5D, (double) var2.getZ() + 0.5D, "random.click", 0.3F, var3.b(b) == aur.b ? 0.55F : 0.5F);
			var1.setBlockAt(var2, var3, 2);
			this.k(var1, var2, var3);
			return true;
		}
	}

	protected void g(World var1, Position var2, IBlockState var3) {
		if (!var1.a(var2, (Block) this)) {
			int var4 = this.j(var1, var2, var3);
			TileEntity var5 = var1.getTileEntity(var2);
			int var6 = var5 instanceof TileEntityComparator ? ((TileEntityComparator) var5).b() : 0;
			if (var4 != var6 || this.l(var3) != this.e(var1, var2, var3)) {
				if (this.i(var1, var2, var3)) {
					var1.a(var2, this, 2, -1);
				} else {
					var1.a(var2, this, 2, 0);
				}
			}

		}
	}

	private void k(World var1, Position var2, IBlockState var3) {
		int var4 = this.j(var1, var2, var3);
		TileEntity var5 = var1.getTileEntity(var2);
		int var6 = 0;
		if (var5 instanceof TileEntityComparator) {
			TileEntityComparator var7 = (TileEntityComparator) var5;
			var6 = var7.b();
			var7.a(var4);
		}

		if (var6 != var4 || var3.b(b) == aur.a) {
			boolean var9 = this.e(var1, var2, var3);
			boolean var8 = this.l(var3);
			if (var8 && !var9) {
				var1.setBlockAt(var2, var3.a(a, Boolean.valueOf(false)), 2);
			} else if (!var8 && var9) {
				var1.setBlockAt(var2, var3.a(a, Boolean.valueOf(true)), 2);
			}

			this.h(var1, var2, var3);
		}

	}

	public void b(World var1, Position var2, IBlockState var3, Random var4) {
		if (this.M) {
			var1.setBlockAt(var2, this.k(var3).a(a, Boolean.valueOf(true)), 4);
		}

		this.k(var1, var2, var3);
	}

	public void c(World var1, Position var2, IBlockState var3) {
		super.c(var1, var2, var3);
		var1.a(var2, this.getTileEntity(var1, 0));
	}

	public void remove(World var1, Position var2, IBlockState var3) {
		super.remove(var1, var2, var3);
		var1.t(var2);
		this.h(var1, var2, var3);
	}

	public boolean a(World var1, Position var2, IBlockState var3, int var4, int var5) {
		super.a(var1, var2, var3, var4, var5);
		TileEntity var6 = var1.getTileEntity(var2);
		return var6 == null ? false : var6.c(var4, var5);
	}

	public TileEntity getTileEntity(World var1, int var2) {
		return new TileEntityComparator();
	}

	public IBlockState setData(int var1) {
		return this.getBlockState().a(N, BlockFace.fromDirection(var1)).a(a, Boolean.valueOf((var1 & 8) > 0)).a(b, (var1 & 4) > 0 ? aur.b : aur.a);
	}

	public int getData(IBlockState var1) {
		byte var2 = 0;
		int var3 = var2 | ((BlockFace) var1.b(N)).toDirection();
		if (((Boolean) var1.b(a)).booleanValue()) {
			var3 |= 8;
		}

		if (var1.b(b) == aur.b) {
			var3 |= 4;
		}

		return var3;
	}

	protected bed e() {
		return new bed(this, new bex[] { N, b, a });
	}

	public IBlockState a(World var1, Position var2, BlockFace var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		return this.getBlockState().a(N, var8.aO().getOpposite()).a(a, Boolean.valueOf(false)).a(b, aur.a);
	}

}
