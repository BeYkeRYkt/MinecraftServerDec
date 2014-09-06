package net.minecraft;

public class ChunkSection {

	private int yPos;
	private int nonEmptyBlockCount;
	private int c;
	private char[] blockIs;
	private NibbleArray emittedLight;
	private NibbleArray skyLight;

	public ChunkSection(int yPos, boolean hasSkyLight) {
		this.yPos = yPos;
		this.blockIs = new char[4096];
		this.emittedLight = new NibbleArray();
		if (hasSkyLight) {
			this.skyLight = new NibbleArray();
		}

	}

	public bec a(int var1, int var2, int var3) {
		bec var4 = (bec) Block.IDREGISTRY.getObject(this.blockIs[var2 << 8 | var3 << 4 | var1]);
		return var4 != null ? var4 : Blocks.AIR.P();
	}

	public void a(int var1, int var2, int var3, bec var4) {
		bec var5 = this.a(var1, var2, var3);
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
		return this.a(var1, var2, var3).getBlock();
	}

	public int c(int var1, int var2, int var3) {
		bec var4 = this.a(var1, var2, var3);
		return var4.getBlock().c(var4);
	}

	public boolean isEmpty() {
		return this.nonEmptyBlockCount == 0;
	}

	public boolean b() {
		return this.c > 0;
	}

	public int d() {
		return this.yPos;
	}

	public void a(int var1, int var2, int var3, int var4) {
		this.skyLight.a(var1, var2, var3, var4);
	}

	public int d(int var1, int var2, int var3) {
		return this.skyLight.a(var1, var2, var3);
	}

	public void b(int var1, int var2, int var3, int var4) {
		this.emittedLight.a(var1, var2, var3, var4);
	}

	public int e(int var1, int var2, int var3) {
		return this.emittedLight.a(var1, var2, var3);
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

	public NibbleArray getEmittedLight() {
		return this.emittedLight;
	}

	public NibbleArray getSkyLight() {
		return this.skyLight;
	}

	public void setEmittedLight(NibbleArray emittedLight) {
		this.emittedLight = emittedLight;
	}

	public void setSkyLight(NibbleArray skyLight) {
		this.skyLight = skyLight;
	}

}
