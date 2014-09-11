package net.minecraft;

public class BiomeStoneBeach extends BiomeBase {

	public BiomeStoneBeach(int var1) {
		super(var1);
		this.au.clear();
		this.ak = Blocks.STONE.getBlockState();
		this.al = Blocks.STONE.getBlockState();
		this.as.A = -999;
		this.as.D = 0;
		this.as.F = 0;
		this.as.G = 0;
	}
}
