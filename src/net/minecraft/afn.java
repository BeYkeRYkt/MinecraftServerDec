package net.minecraft;

import com.google.common.base.Predicate;

class afn implements Predicate {

	// $FF: synthetic field
	final afm a;

	afn(afm var1) {
		this.a = var1;
	}

	public boolean a(Entity var1) {
		return var1 instanceof aep && ((aep) var1).ck() > 0;
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((Entity) var1);
	}
}
