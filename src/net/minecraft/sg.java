package net.minecraft;

import com.google.common.base.Predicate;

final class sg implements Predicate {

	public boolean a(String var1) {
		return !vb.b(var1);
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((String) var1);
	}
}
