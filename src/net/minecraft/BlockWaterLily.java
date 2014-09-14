package net.minecraft;

import java.util.List;

public class BlockWaterLily extends auc {

	protected BlockWaterLily() {
		float var1 = 0.5F;
		float var2 = 0.015625F;
		this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, var2, 0.5F + var1);
		this.a(CreativeModeTab.DECORATIONS);
	}

	public void a(World var1, Position var2, IBlockState var3, AxisAlignedBB var4, List var5, Entity var6) {
		if (var6 == null || !(var6 instanceof EntityBoat)) {
			super.a(var1, var2, var3, var4, var5, var6);
		}

	}

	public AxisAlignedBB a(World var1, Position var2, IBlockState var3) {
		return new AxisAlignedBB((double) var2.getX() + this.B, (double) var2.getY() + this.C, (double) var2.getZ() + this.D, (double) var2.getX() + this.E, (double) var2.getY() + this.F, (double) var2.getZ() + this.G);
	}

	protected boolean c(Block var1) {
		return var1 == Blocks.WATER;
	}

	public boolean f(World var1, Position var2, IBlockState var3) {
		if (var2.getY() >= 0 && var2.getY() < 256) {
			IBlockState var4 = var1.getBlockState(var2.b());
			return var4.getBlock().getMaterial() == Material.WATER && ((Integer) var4.b(axl.b)).intValue() == 0;
		} else {
			return false;
		}
	}

	public int getData(IBlockState var1) {
		return 0;
	}
}
