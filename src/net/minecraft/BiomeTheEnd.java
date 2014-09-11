package net.minecraft;

public class BiomeTheEnd extends BiomeBase {

	public BiomeTheEnd(int var1) {
		super(var1);
		this.at.clear();
		this.au.clear();
		this.av.clear();
		this.aw.clear();
		this.at.add(new BiomeMeta(EntityEnderman.class, 10, 4, 4));
		this.ak = Blocks.DIRT.getBlockState();
		this.al = Blocks.DIRT.getBlockState();
		this.as = new BiomeTheEndDecorator();
	}
}
