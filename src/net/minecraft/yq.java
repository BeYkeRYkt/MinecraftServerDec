package net.minecraft;

import com.google.common.base.Predicate;

class yq implements Predicate {

	// $FF: synthetic field
	final PathfinderGoalAvoidEntity a;

	yq(PathfinderGoalAvoidEntity var1) {
		this.a = var1;
	}

	public boolean a(Entity var1) {
		return var1.isAlive() && this.a.b.t().a(var1);
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((Entity) var1);
	}
}
