package net.minecraft;

import com.google.common.base.Predicate;

class yq implements Predicate {

	// $FF: synthetic field
	final yp a;

	yq(yp var1) {
		this.a = var1;
	}

	public boolean a(Entity var1) {
		return var1.ai() && this.a.b.t().a(var1);
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((Entity) var1);
	}
}
