package net.minecraft;

import com.google.common.base.Predicate;

final class ao implements Predicate {

	// $FF: synthetic field
	final int a;

	ao(int var1) {
		this.a = var1;
	}

	public boolean a(Entity var1) {
		if (!(var1 instanceof qw)) {
			return false;
		} else {
			qw var2 = (qw) var1;
			return var2.c.b().a() == this.a;
		}
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((Entity) var1);
	}
}
