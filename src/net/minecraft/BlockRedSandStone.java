package net.minecraft;

public class BlockRedSandStone extends Block {

	public static final bev a = bev.a("type", azr.class);

	public BlockRedSandStone() {
		super(Material.STONE);
		this.setBlockState(this.L.b().a(a, azr.a));
		this.a(CreativeModeTab.BUILDING_BLOCKS);
	}

	public int a(IBlockState var1) {
		return ((azr) var1.b(a)).a();
	}

	public IBlockState setData(int var1) {
		return this.getBlockState().a(a, azr.a(var1));
	}

	public int getData(IBlockState var1) {
		return ((azr) var1.b(a)).a();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}
