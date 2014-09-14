package net.minecraft;

public class BlockPressurePlateWeighted extends ath {

	public static final bew a = bew.a("power", 0, 15);
	private final int b;

	protected BlockPressurePlateWeighted(String var1, Material var2, int var3) {
		super(var2);
		this.setBlockState(this.L.b().a(a, Integer.valueOf(0)));
		this.b = var3;
	}

	protected int e(World var1, Position var2) {
		int var3 = Math.min(var1.a(Entity.class, this.a(var2)).size(), this.b);
		if (var3 > 0) {
			float var4 = (float) Math.min(this.b, var3) / (float) this.b;
			return MathHelper.f(var4 * 15.0F);
		} else {
			return 0;
		}
	}

	protected int e(IBlockState var1) {
		return ((Integer) var1.b(a)).intValue();
	}

	protected IBlockState a(IBlockState var1, int var2) {
		return var1.a(a, Integer.valueOf(var2));
	}

	public int a(World var1) {
		return 10;
	}

	public IBlockState a(int var1) {
		return this.getBlockState().a(a, Integer.valueOf(var1));
	}

	public int getData(IBlockState var1) {
		return ((Integer) var1.b(a)).intValue();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}
