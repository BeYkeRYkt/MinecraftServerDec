package net.minecraft;

class agh extends PathfinderGoalNearestAttackableTarget {

	public agh(EntitySpider var1, Class var2) {
		super(var1, var2, true);
	}

	public boolean a() {
		float var1 = this.e.c(1.0F);
		return var1 >= 0.5F ? false : super.a();
	}
}
