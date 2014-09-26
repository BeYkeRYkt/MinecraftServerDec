package net.minecraft;

public class BlockAir extends Block {

	protected BlockAir() {
		super(Material.AIR);
	}

	public int b() {
		return -1;
	}

	public AxisAlignedBB a(World var1, Position var2, IBlockState var3) {
		return null;
	}

	public boolean c() {
		return false;
	}

	public boolean a(IBlockState var1, boolean var2) {
		return false;
	}

	public void dropNaturally(World var1, Position var2, IBlockState var3, float var4, int var5) {
	}
}
