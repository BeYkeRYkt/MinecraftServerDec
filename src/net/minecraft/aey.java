package net.minecraft;

import com.google.common.base.Predicate;

final class aey implements Predicate {

	public boolean a(Entity var1) {
		return var1 instanceof IMonster;
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((Entity) var1);
	}
}
