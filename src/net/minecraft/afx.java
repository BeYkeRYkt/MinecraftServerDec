package net.minecraft;

import com.google.common.base.Predicate;

class afx implements Predicate {

	// $FF: synthetic field
	final EntitySkeleton a;

	afx(EntitySkeleton var1) {
		this.a = var1;
	}

	public boolean a(Entity var1) {
		return var1 instanceof EntityWolf;
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((Entity) var1);
	}
}
