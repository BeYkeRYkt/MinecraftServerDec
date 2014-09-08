package net.minecraft;

public class BlockCloth extends Block {

	public static final bev a = bev.a("color", akv.class);

	public BlockCloth(Material var1) {
		super(var1);
		this.setBlockState(this.L.b().a(a, akv.a));
		this.a(CreativeModeTab.BUILDING_BLOCKS);
	}

	public int a(BlockState var1) {
		return ((akv) var1.b(a)).a();
	}

	public MaterialMapColor g(BlockState var1) {
		return ((akv) var1.b(a)).e();
	}

	public BlockState a(int var1) {
		return this.getBlockState().a(a, akv.b(var1));
	}

	public int c(BlockState var1) {
		return ((akv) var1.b(a)).a();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}
