package net.minecraft;

public class BlockStandingSign extends bai {

	public static final bew a = bew.a("rotation", 0, 15);

	public BlockStandingSign() {
		this.setBlockState(this.L.b().a(a, Integer.valueOf(0)));
	}

	public void a(World var1, Position var2, IBlockState var3, Block var4) {
		if (!var1.getBlockState(var2.getDown()).getBlock().getMaterial().isBuildable()) {
			this.dropNaturally(var1, var2, var3, 0);
			var1.g(var2);
		}

		super.a(var1, var2, var3, var4);
	}

	public IBlockState setData(int var1) {
		return this.getBlockState().a(a, Integer.valueOf(var1));
	}

	public int getData(IBlockState var1) {
		return ((Integer) var1.b(a)).intValue();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}
