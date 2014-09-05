package net.minecraft;

import com.google.common.base.Predicate;

class agq implements Predicate {

	// $FF: synthetic field
	final EntityVillager a;

	agq(EntityVillager var1) {
		this.a = var1;
	}

	public boolean a(Entity var1) {
		return var1 instanceof EntityZombie;
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((Entity) var1);
	}
}
