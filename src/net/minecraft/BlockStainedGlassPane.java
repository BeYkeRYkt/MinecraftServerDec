package net.minecraft;

public class BlockStainedGlassPane extends BlockThin {

	public static final bev a = bev.a("color", akv.class);

	public BlockStainedGlassPane() {
		super(Material.SHATTERABLE, false);
		this.setBlockState(this.L.b().a(b, Boolean.valueOf(false)).a(M, Boolean.valueOf(false)).a(N, Boolean.valueOf(false)).a(O, Boolean.valueOf(false)).a(a, akv.a));
		this.a(CreativeModeTab.DECORATIONS);
	}

	public int a(BlockState var1) {
		return ((akv) var1.b(a)).a();
	}

	public BlockState a(int var1) {
		return this.getBlockState().a(a, akv.b(var1));
	}

	public int c(BlockState var1) {
		return ((akv) var1.b(a)).a();
	}

	protected bed e() {
		return new bed(this, new bex[] { b, M, O, N, a });
	}

	public void c(World var1, Position var2, BlockState var3) {
		if (!var1.D) {
			BlockBeacon.d(var1, var2);
		}

	}

	public void b(World var1, Position var2, BlockState var3) {
		if (!var1.D) {
			BlockBeacon.d(var1, var2);
		}

	}

}
