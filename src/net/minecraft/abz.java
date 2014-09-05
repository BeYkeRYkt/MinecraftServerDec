package net.minecraft;

import com.google.common.base.Predicate;

class abz implements Predicate {

	// $FF: synthetic field
	final aby a;

	abz(aby var1) {
		this.a = var1;
	}

	public boolean a(Entity var1) {
		return var1 instanceof EntityHuman;
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((Entity) var1);
	}
}
