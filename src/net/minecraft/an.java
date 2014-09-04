package net.minecraft;

import com.google.common.base.Predicate;

final class an implements Predicate {

	// $FF: synthetic field
	final int a;
	// $FF: synthetic field
	final int b;

	an(int var1, int var2) {
		this.a = var1;
		this.b = var2;
	}

	public boolean a(Entity var1) {
		if (!(var1 instanceof qw)) {
			return false;
		} else {
			qw var2 = (qw) var1;
			return (this.a <= -1 || var2.bz >= this.a) && (this.b <= -1 || var2.bz <= this.b);
		}
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((Entity) var1);
	}
}
