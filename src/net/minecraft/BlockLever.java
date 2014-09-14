package net.minecraft;

import java.util.Iterator;

public class BlockLever extends Block {

	public static final bev a = bev.a("facing", axk.class);
	public static final bet b = bet.a("powered");

	protected BlockLever() {
		super(Material.ORIENTABLE);
		this.setBlockState(this.L.b().a(a, axk.e).a(b, Boolean.valueOf(false)));
		this.a(CreativeModeTab.REDSTONE);
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

	public boolean a(World var1, Position var2, BlockFace var3) {
		return var3 == BlockFace.UP && World.a((ard) var1, var2.b()) ? true : this.d(var1, var2.a(var3.getOpposite()));
	}

	public boolean c(World var1, Position var2) {
		return this.d(var1, var2.e()) ? true : (this.d(var1, var2.f()) ? true : (this.d(var1, var2.c()) ? true : (this.d(var1, var2.d()) ? true : (World.a((ard) var1, var2.b()) ? true : this.d(var1, var2.a())))));
	}

	protected boolean d(World var1, Position var2) {
		return var1.getBlockState(var2).getBlock().t();
	}

	public IBlockState a(World var1, Position var2, BlockFace var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		IBlockState var9 = this.getBlockState().a(b, Boolean.valueOf(false));
		if (this.d(var1, var2.a(var3.getOpposite()))) {
			return var9.a(a, axk.a(var3, var8.aO()));
		} else {
			Iterator var10 = en.a.iterator();

			BlockFace var11;
			do {
				if (!var10.hasNext()) {
					if (World.a((ard) var1, var2.b())) {
						return var9.a(a, axk.a(BlockFace.UP, var8.aO()));
					}

					return var9;
				}

				var11 = (BlockFace) var10.next();
			} while (var11 == var3 || !this.d(var1, var2.a(var11.getOpposite())));

			return var9.a(a, axk.a(var11, var8.aO()));
		}
	}

	public static int a(BlockFace var0) {
		switch (axj.a[var0.ordinal()]) {
			case 1:
				return 0;
			case 2:
				return 5;
			case 3:
				return 4;
			case 4:
				return 3;
			case 5:
				return 2;
			case 6:
				return 1;
			default:
				return -1;
		}
	}

	public void a(World var1, Position var2, IBlockState var3, Block var4) {
		if (this.e(var1, var2) && !this.d(var1, var2.a(((axk) var3.b(a)).c().getOpposite()))) {
			this.b(var1, var2, var3, 0);
			var1.g(var2);
		}

	}

	private boolean e(World var1, Position var2) {
		if (this.c(var1, var2)) {
			return true;
		} else {
			this.b(var1, var2, var1.getBlockState(var2), 0);
			var1.g(var2);
			return false;
		}
	}

	public void a(ard var1, Position var2) {
		float var3 = 0.1875F;
		switch (axj.b[((axk) var1.getBlockState(var2).b(a)).ordinal()]) {
			case 1:
				this.a(0.0F, 0.2F, 0.5F - var3, var3 * 2.0F, 0.8F, 0.5F + var3);
				break;
			case 2:
				this.a(1.0F - var3 * 2.0F, 0.2F, 0.5F - var3, 1.0F, 0.8F, 0.5F + var3);
				break;
			case 3:
				this.a(0.5F - var3, 0.2F, 0.0F, 0.5F + var3, 0.8F, var3 * 2.0F);
				break;
			case 4:
				this.a(0.5F - var3, 0.2F, 1.0F - var3 * 2.0F, 0.5F + var3, 0.8F, 1.0F);
				break;
			case 5:
			case 6:
				var3 = 0.25F;
				this.a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.6F, 0.5F + var3);
				break;
			case 7:
			case 8:
				var3 = 0.25F;
				this.a(0.5F - var3, 0.4F, 0.5F - var3, 0.5F + var3, 1.0F, 0.5F + var3);
		}

	}

	public boolean a(World var1, Position var2, IBlockState var3, EntityHuman var4, BlockFace var5, float var6, float var7, float var8) {
		if (var1.isStatic) {
			return true;
		} else {
			var3 = var3.a(b);
			var1.setBlockAt(var2, var3, 3);
			var1.makeSound((double) var2.getX() + 0.5D, (double) var2.getY() + 0.5D, (double) var2.getZ() + 0.5D, "random.click", 0.3F, ((Boolean) var3.b(b)).booleanValue() ? 0.6F : 0.5F);
			var1.c(var2, (Block) this);
			BlockFace var9 = ((axk) var3.b(a)).c();
			var1.c(var2.a(var9.getOpposite()), (Block) this);
			return true;
		}
	}

	public void b(World var1, Position var2, IBlockState var3) {
		if (((Boolean) var3.b(b)).booleanValue()) {
			var1.c(var2, (Block) this);
			BlockFace var4 = ((axk) var3.b(a)).c();
			var1.c(var2.a(var4.getOpposite()), (Block) this);
		}

		super.b(var1, var2, var3);
	}

	public int a(ard var1, Position var2, IBlockState var3, BlockFace var4) {
		return ((Boolean) var3.b(b)).booleanValue() ? 15 : 0;
	}

	public int b(ard var1, Position var2, IBlockState var3, BlockFace var4) {
		return !((Boolean) var3.b(b)).booleanValue() ? 0 : (((axk) var3.b(a)).c() == var4 ? 15 : 0);
	}

	public boolean g() {
		return true;
	}

	public IBlockState a(int var1) {
		return this.getBlockState().a(a, axk.a(var1 & 7)).a(b, Boolean.valueOf((var1 & 8) > 0));
	}

	public int getData(IBlockState var1) {
		byte var2 = 0;
		int var3 = var2 | ((axk) var1.b(a)).a();
		if (((Boolean) var1.b(b)).booleanValue()) {
			var3 |= 8;
		}

		return var3;
	}

	protected bed e() {
		return new bed(this, new bex[] { a, b });
	}

}
