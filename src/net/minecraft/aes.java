package net.minecraft;

import com.google.common.base.Predicate;

class aes implements Predicate {

	// $FF: synthetic field
	final EntityEnderman a;

	aes(EntityEnderman var1) {
		this.a = var1;
	}

	public boolean a(EntityEndermite var1) {
		return var1.n();
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((EntityEndermite) var1);
	}
}
