package net.minecraft;

import com.google.common.base.Predicate;

final class xg implements Predicate {

	public boolean a(Entity var1) {
		return var1.ai() && var1.l == null && var1.m == null;
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((Entity) var1);
	}
}
