package net.minecraft;

public interface ard {

	TileEntity getTileEntity(Position var1);

	IBlockState getBlockState(Position var1);

	boolean d(Position var1);

	int getBlockPower(Position var1, BlockFace var2);
}
