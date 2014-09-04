package net.minecraft;

import com.google.common.base.Predicate;

final class xi implements Predicate {

	public boolean a(Entity var1) {
		return !(var1 instanceof ahd) || !((ahd) var1).v();
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((Entity) var1);
	}
}
