package net.minecraft;

class afp extends PathfinderGoalNearestAttackableTarget {

	public afp(EntityPigZombie var1) {
		super(var1, EntityHuman.class, true);
	}

	public boolean a() {
		return ((EntityPigZombie) this.e).ck() && super.a();
	}
}
