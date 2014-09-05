package net.minecraft;

public class asg extends arm {

	public asg(int var1) {
		super(var1);
		this.at.clear();
		this.au.clear();
		this.av.clear();
		this.aw.clear();
		this.at.add(new arq(EntityGhast.class, 50, 4, 4));
		this.at.add(new arq(EntityPigZombie.class, 100, 4, 4));
		this.at.add(new arq(EntityMagmaCube.class, 1, 4, 4));
	}
}
