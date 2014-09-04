package net.minecraft;

import com.google.common.base.Predicate;

class acc implements Predicate {

	// $FF: synthetic field
	final acb a;

	acc(acb var1) {
		this.a = var1;
	}

	public boolean a(Entity var1) {
		return var1 instanceof acu;
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((Entity) var1);
	}
}
