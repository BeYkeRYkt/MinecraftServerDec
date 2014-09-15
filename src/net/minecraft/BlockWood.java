package net.minecraft;

public class BlockWood extends Block {

	public static final bev a = bev.a("variant", EnumWoodType.class);

	public BlockWood() {
		super(Material.WOOD);
		this.setBlockState(this.L.b().a(a, EnumWoodType.a));
		this.a(CreativeModeTab.BUILDING_BLOCKS);
	}

	public int a(IBlockState var1) {
		return ((EnumWoodType) var1.b(a)).a();
	}

	public IBlockState setData(int var1) {
		return this.getBlockState().a(a, EnumWoodType.a(var1));
	}

	public int getData(IBlockState var1) {
		return ((EnumWoodType) var1.b(a)).a();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}
