package net.minecraft;

import java.util.Random;

public class BlockStainedGlass extends awt {

	public static final bev a = bev.a("color", akv.class);

	public BlockStainedGlass(Material var1) {
		super(var1, false);
		this.setBlockState(this.L.b().a(a, akv.a));
		this.a(CreativeModeTab.BUILDING_BLOCKS);
	}

	public int a(IBlockState var1) {
		return ((akv) var1.b(a)).a();
	}

	public MaterialMapColor getMapColor(IBlockState var1) {
		return ((akv) var1.b(a)).e();
	}

	public int a(Random var1) {
		return 0;
	}

	protected boolean G() {
		return true;
	}

	public boolean d() {
		return false;
	}

	public IBlockState setData(int var1) {
		return this.getBlockState().a(a, akv.b(var1));
	}

	public void c(World var1, Position var2, IBlockState var3) {
		if (!var1.isStatic) {
			BlockBeacon.d(var1, var2);
		}

	}

	public void b(World var1, Position var2, IBlockState var3) {
		if (!var1.isStatic) {
			BlockBeacon.d(var1, var2);
		}

	}

	public int getData(IBlockState var1) {
		return ((akv) var1.b(a)).a();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}
