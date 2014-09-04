package net.minecraft;

import com.google.common.base.Predicate;

final class ar implements Predicate {

	// $FF: synthetic field
	final String a;
	// $FF: synthetic field
	final boolean b;

	ar(String var1, boolean var2) {
		this.a = var1;
		this.b = var2;
	}

	public boolean a(Entity var1) {
		return var1.d_().equals(this.a) != this.b;
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((Entity) var1);
	}
}
