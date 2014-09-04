package net.minecraft;

import com.google.common.base.Predicate;

final class bej implements Predicate {

	// $FF: synthetic field
	final Predicate a;

	bej(Predicate var1) {
		this.a = var1;
	}

	public boolean a(bei var1) {
		return var1 != null && this.a.apply(var1.a());
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((bei) var1);
	}
}
