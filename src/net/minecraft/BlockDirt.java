package net.minecraft;

public class BlockDirt extends Block {

	public static final bev a = bev.a("variant", avd.class);
	public static final bet b = bet.a("snowy");

	protected BlockDirt() {
		super(Material.EARTH);
		this.setBlockState(this.L.b().a(a, avd.a).a(b, Boolean.valueOf(false)));
		this.a(CreativeModeTab.BUILDING_BLOCKS);
	}

	public IBlockState a(IBlockState var1, ard var2, Position var3) {
		if (var1.b(a) == avd.c) {
			Block var4 = var2.getBlockState(var3.a()).getBlock();
			var1 = var1.a(b, Boolean.valueOf(var4 == Blocks.SNOW || var4 == Blocks.SNOW_LAYER));
		}

		return var1;
	}

	public int j(World var1, Position var2) {
		IBlockState var3 = var1.getBlockState(var2);
		return var3.getBlock() != this ? 0 : ((avd) var3.b(a)).a();
	}

	public IBlockState a(int var1) {
		return this.getBlockState().a(a, avd.a(var1));
	}

	public int getData(IBlockState var1) {
		return ((avd) var1.b(a)).a();
	}

	protected bed e() {
		return new bed(this, new bex[] { a, b });
	}

	public int a(IBlockState var1) {
		avd var2 = (avd) var1.b(a);
		if (var2 == avd.c) {
			var2 = avd.a;
		}

		return var2.a();
	}

}
