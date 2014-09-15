package net.minecraft;

public class BiomeBeach extends BiomeBase {

	public BiomeBeach(int var1) {
		super(var1);
		this.au.clear();
		this.ak = Blocks.SAND.getBlockState();
		this.al = Blocks.SAND.getBlockState();
		this.as.A = -999;
		this.as.D = 0;
		this.as.F = 0;
		this.as.G = 0;
	}
}
