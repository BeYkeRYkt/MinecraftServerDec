package net.minecraft;

import java.util.List;
import java.util.Random;

public class BlockBrewingStand extends atg {

	public static final bet[] a = new bet[] { bet.a("has_bottle_0"), bet.a("has_bottle_1"), bet.a("has_bottle_2") };
	private final Random b = new Random();

	public BlockBrewingStand() {
		super(Material.ORE);
		this.setBlockState(this.L.b().a(a[0], Boolean.valueOf(false)).a(a[1], Boolean.valueOf(false)).a(a[2], Boolean.valueOf(false)));
	}

	public boolean c() {
		return false;
	}

	public int b() {
		return 3;
	}

	public TileEntity a(World var1, int var2) {
		return new TileEntityBrewingStand();
	}

	public boolean d() {
		return false;
	}

	public void a(World var1, Position var2, IBlockState var3, AxisAlignedBB var4, List var5, Entity var6) {
		this.a(0.4375F, 0.0F, 0.4375F, 0.5625F, 0.875F, 0.5625F);
		super.a(var1, var2, var3, var4, var5, var6);
		this.h();
		super.a(var1, var2, var3, var4, var5, var6);
	}

	public void h() {
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
	}

	public boolean a(World var1, Position var2, IBlockState var3, EntityHuman var4, BlockFace var5, float var6, float var7, float var8) {
		if (var1.isStatic) {
			return true;
		} else {
			TileEntity var9 = var1.getTileEntity(var2);
			if (var9 instanceof TileEntityBrewingStand) {
				var4.a((IInventory) ((TileEntityBrewingStand) var9));
			}

			return true;
		}
	}

	public void a(World var1, Position var2, IBlockState var3, EntityLiving var4, ItemStack var5) {
		if (var5.hasDisplayName()) {
			TileEntity var6 = var1.getTileEntity(var2);
			if (var6 instanceof TileEntityBrewingStand) {
				((TileEntityBrewingStand) var6).a(var5.getDisplayName());
			}
		}

	}

	public void b(World var1, Position var2, IBlockState var3) {
		TileEntity var4 = var1.getTileEntity(var2);
		if (var4 instanceof TileEntityBrewingStand) {
			vs.a(var1, var2, (TileEntityBrewingStand) var4);
		}

		super.b(var1, var2, var3);
	}

	public Item a(IBlockState var1, Random var2, int var3) {
		return Items.BREWING_STAND;
	}

	public boolean N() {
		return true;
	}

	public int l(World var1, Position var2) {
		return Container.a(var1.getTileEntity(var2));
	}

	public IBlockState setData(int var1) {
		IBlockState var2 = this.getBlockState();

		for (int var3 = 0; var3 < 3; ++var3) {
			var2 = var2.a(a[var3], Boolean.valueOf((var1 & 1 << var3) > 0));
		}

		return var2;
	}

	public int getData(IBlockState var1) {
		int var2 = 0;

		for (int var3 = 0; var3 < 3; ++var3) {
			if (((Boolean) var1.b(a[var3])).booleanValue()) {
				var2 |= 1 << var3;
			}
		}

		return var2;
	}

	protected bed e() {
		return new bed(this, new bex[] { a[0], a[1], a[2] });
	}

}
