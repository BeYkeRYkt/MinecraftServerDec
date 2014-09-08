package net.minecraft;

public class BlockSmoothBrick extends Block {

	public static final bev a = bev.a("variant", bbd.class);
	public static final int b = bbd.a.a();
	public static final int M = bbd.b.a();
	public static final int N = bbd.c.a();
	public static final int O = bbd.d.a();

	public BlockSmoothBrick() {
		super(Material.STONE);
		this.setBlockState(this.L.b().a(a, bbd.a));
		this.a(CreativeModeTab.BUILDING_BLOCKS);
	}

	public int a(BlockState var1) {
		return ((bbd) var1.b(a)).a();
	}

	public BlockState a(int var1) {
		return this.getBlockState().a(a, bbd.a(var1));
	}

	public int c(BlockState var1) {
		return ((bbd) var1.b(a)).a();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}
