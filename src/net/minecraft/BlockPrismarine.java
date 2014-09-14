package net.minecraft;

public class BlockPrismarine extends Block {

	public static final bev a = bev.a("variant", azj.class);
	public static final int b = azj.a.a();
	public static final int M = azj.b.a();
	public static final int N = azj.c.a();

	public BlockPrismarine() {
		super(Material.STONE);
		this.setBlockState(this.L.b().a(a, azj.a));
		this.a(CreativeModeTab.BUILDING_BLOCKS);
	}

	public int a(IBlockState var1) {
		return ((azj) var1.b(a)).a();
	}

	public int getData(IBlockState var1) {
		return ((azj) var1.b(a)).a();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

	public IBlockState a(int var1) {
		return this.getBlockState().a(a, azj.a(var1));
	}

}
