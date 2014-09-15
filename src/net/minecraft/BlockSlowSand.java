package net.minecraft;

public class BlockSlowSand extends Block {

	public BlockSlowSand() {
		super(Material.SAND);
		this.a(CreativeModeTab.BUILDING_BLOCKS);
	}

	public AxisAlignedBB a(World var1, Position var2, IBlockState var3) {
		float var4 = 0.125F;
		return new AxisAlignedBB((double) var2.getX(), (double) var2.getY(), (double) var2.getZ(), (double) (var2.getX() + 1), (double) ((float) (var2.getY() + 1) - var4), (double) (var2.getZ() + 1));
	}

	public void a(World var1, Position var2, IBlockState var3, Entity var4) {
		var4.motionX *= 0.4D;
		var4.motionZ *= 0.4D;
	}
}
