package net.minecraft;

import com.google.common.base.Predicate;

final class xh implements Predicate {

	public boolean a(Entity var1) {
		return var1 instanceof vq && var1.ai();
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((Entity) var1);
	}
}
