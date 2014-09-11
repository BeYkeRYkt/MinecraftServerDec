package net.minecraft;

public class BiomeHell extends BiomeBase {

	public BiomeHell(int var1) {
		super(var1);
		this.at.clear();
		this.au.clear();
		this.av.clear();
		this.aw.clear();
		this.at.add(new BiomeMeta(EntityGhast.class, 50, 4, 4));
		this.at.add(new BiomeMeta(EntityPigZombie.class, 100, 4, 4));
		this.at.add(new BiomeMeta(EntityMagmaCube.class, 1, 4, 4));
	}
}
