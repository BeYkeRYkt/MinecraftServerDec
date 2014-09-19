package net.minecraft;

public interface ISourceBlock extends ILocationSource {

	double getX();

	double getY();

	double getZ();

	Position getPosition();

	Block getBlock();

	int getData();

	TileEntity getTileEntity();
}
