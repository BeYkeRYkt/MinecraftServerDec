package net.minecraft;

public class BlockSand extends BlockFalling {

	public static final bev a = bev.a("variant", bac.class);

	public BlockSand() {
		this.setBlockState(this.L.b().a(a, bac.a));
	}

	public int getItemDropData(IBlockState var1) {
		return ((bac) var1.b(a)).a();
	}

	public MaterialMapColor getMapColor(IBlockState var1) {
		return ((bac) var1.b(a)).c();
	}

	public IBlockState setData(int var1) {
		return this.getBlockState().a(a, bac.a(var1));
	}

	public int getData(IBlockState var1) {
		return ((bac) var1.b(a)).a();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}
