package net.minecraft;

public class BlockSandStone extends Block {

	public static final bev a = bev.a("type", bae.class);

	public BlockSandStone() {
		super(Material.STONE);
		this.setBlockState(this.L.b().a(a, bae.a));
		this.a(CreativeModeTab.BUILDING_BLOCKS);
	}

	public int a(IBlockState var1) {
		return ((bae) var1.b(a)).a();
	}

	public IBlockState setData(int var1) {
		return this.getBlockState().a(a, bae.a(var1));
	}

	public int getData(IBlockState var1) {
		return ((bae) var1.b(a)).a();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}
