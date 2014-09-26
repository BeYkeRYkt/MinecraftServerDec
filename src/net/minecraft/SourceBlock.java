package net.minecraft;

public class SourceBlock implements ISourceBlock {

	private final World world;
	private final Position position;

	public SourceBlock(World world, Position position) {
		this.world = world;
		this.position = position;
	}

	public World getWorld() {
		return this.world;
	}

	public double getX() {
		return this.position.getX() + 0.5D;
	}

	public double getY() {
		return this.position.getY() + 0.5D;
	}

	public double getZ() {
		return this.position.getZ() + 0.5D;
	}

	public Position getPosition() {
		return this.position;
	}

	public Block getBlock() {
		return this.world.getBlockState(this.position).getBlock();
	}

	public int getData() {
		IBlockState blockState = this.world.getBlockState(this.position);
		return blockState.getBlock().getData(blockState);
	}

	public TileEntity getTileEntity() {
		return this.world.getTileEntity(this.position);
	}

}
