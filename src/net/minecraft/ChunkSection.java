package net.minecraft;

public class ChunkSection {

	private int yPos;
	private int nonEmptyBlockCount;
	private int tickingBlockCount;
	private char[] blockIs;
	private ChunkNibbleArray emittedLight;
	private ChunkNibbleArray skyLight;

	public ChunkSection(int yPos, boolean hasSkyLight) {
		this.yPos = yPos;
		this.blockIs = new char[4096];
		this.emittedLight = new ChunkNibbleArray();
		if (hasSkyLight) {
			this.skyLight = new ChunkNibbleArray();
		}

	}

	public IBlockState getBlockState(int x, int y, int z) {
		IBlockState var4 = (IBlockState) Block.IDREGISTRY.getObject(this.blockIs[y << 8 | z << 4 | x]);
		return var4 != null ? var4 : Blocks.AIR.getBlockState();
	}

	public void setBlockState(int x, int y, int z, IBlockState blockState) {
		IBlockState oldBlockState = this.getBlockState(x, y, z);
		Block oldBlock = oldBlockState.getBlock();
		Block block = blockState.getBlock();
		if (oldBlock != Blocks.AIR) {
			--this.nonEmptyBlockCount;
			if (oldBlock.isTicking()) {
				--this.tickingBlockCount;
			}
		}

		if (block != Blocks.AIR) {
			++this.nonEmptyBlockCount;
			if (block.isTicking()) {
				++this.tickingBlockCount;
			}
		}

		this.blockIs[y << 8 | z << 4 | x] = (char) Block.IDREGISTRY.getId(blockState);
	}

	public Block getBlock(int x, int y, int z) {
		return this.getBlockState(x, y, z).getBlock();
	}

	public int getData(int x, int y, int z) {
		IBlockState blockState = this.getBlockState(x, y, z);
		return blockState.getBlock().getData(blockState);
	}

	public boolean isEmpty() {
		return this.nonEmptyBlockCount == 0;
	}

	public boolean shouldTick() {
		return this.tickingBlockCount > 0;
	}

	public int getYPos() {
		return this.yPos;
	}

	public void setSkyLight(int x, int y, int z, int value) {
		this.skyLight.setValue(x, y, z, value);
	}

	public int getSkyLight(int x, int y, int z) {
		return this.skyLight.getValue(x, y, z);
	}

	public void setBlockLight(int x, int y, int z, int value) {
		this.emittedLight.setValue(x, y, z, value);
	}

	public int getBlockLight(int x, int y, int z) {
		return this.emittedLight.getValue(x, y, z);
	}

	public void recalcBlockCounts() {
		this.nonEmptyBlockCount = 0;
		this.tickingBlockCount = 0;

		for (int x = 0; x < 16; ++x) {
			for (int y = 0; y < 16; ++y) {
				for (int z = 0; z < 16; ++z) {
					Block block = this.getBlock(x, y, z);
					if (block != Blocks.AIR) {
						++this.nonEmptyBlockCount;
						if (block.isTicking()) {
							++this.tickingBlockCount;
						}
					}
				}
			}
		}

	}

	public char[] getBlockIds() {
		return this.blockIs;
	}

	public void setBlockIds(char[] var1) {
		this.blockIs = var1;
	}

	public ChunkNibbleArray getEmittedLight() {
		return this.emittedLight;
	}

	public ChunkNibbleArray getSkyLight() {
		return this.skyLight;
	}

	public void setEmittedLight(ChunkNibbleArray emittedLight) {
		this.emittedLight = emittedLight;
	}

	public void setSkyLight(ChunkNibbleArray skyLight) {
		this.skyLight = skyLight;
	}

}
