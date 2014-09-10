package net.minecraft;

public class ChunkSection {

	private int yPos;
	private int nonEmptyBlockCount;
	private int c;
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

	public BlockState getBlockState(int x, int y, int z) {
		BlockState var4 = (BlockState) Block.IDREGISTRY.getObject(this.blockIs[y << 8 | z << 4 | x]);
		return var4 != null ? var4 : Blocks.AIR.getBlockState();
	}

	public void setBlockState(int var1, int var2, int var3, BlockState var4) {
		BlockState var5 = this.getBlockState(var1, var2, var3);
		Block var6 = var5.getBlock();
		Block var7 = var4.getBlock();
		if (var6 != Blocks.AIR) {
			--this.nonEmptyBlockCount;
			if (var6.w()) {
				--this.c;
			}
		}

		if (var7 != Blocks.AIR) {
			++this.nonEmptyBlockCount;
			if (var7.w()) {
				++this.c;
			}
		}

		this.blockIs[var2 << 8 | var3 << 4 | var1] = (char) Block.IDREGISTRY.getId(var4);
	}

	public Block b(int var1, int var2, int var3) {
		return this.getBlockState(var1, var2, var3).getBlock();
	}

	public int c(int var1, int var2, int var3) {
		BlockState var4 = this.getBlockState(var1, var2, var3);
		return var4.getBlock().c(var4);
	}

	public boolean isEmpty() {
		return this.nonEmptyBlockCount == 0;
	}

	public boolean b() {
		return this.c > 0;
	}

	public int getYPos() {
		return this.yPos;
	}

	public void a(int var1, int var2, int var3, int var4) {
		this.skyLight.setValue(var1, var2, var3, var4);
	}

	public int d(int var1, int var2, int var3) {
		return this.skyLight.getValue(var1, var2, var3);
	}

	public void b(int var1, int var2, int var3, int var4) {
		this.emittedLight.setValue(var1, var2, var3, var4);
	}

	public int e(int var1, int var2, int var3) {
		return this.emittedLight.getValue(var1, var2, var3);
	}

	public void e() {
		this.nonEmptyBlockCount = 0;
		this.c = 0;

		for (int var1 = 0; var1 < 16; ++var1) {
			for (int var2 = 0; var2 < 16; ++var2) {
				for (int var3 = 0; var3 < 16; ++var3) {
					Block var4 = this.b(var1, var2, var3);
					if (var4 != Blocks.AIR) {
						++this.nonEmptyBlockCount;
						if (var4.w()) {
							++this.c;
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
