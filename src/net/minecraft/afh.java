package net.minecraft;

import com.google.common.base.Predicate;

class afh implements Predicate {

	// $FF: synthetic field
	final afg a;

	afh(afg var1) {
		this.a = var1;
	}

	public boolean a(qw var1) {
		return this.a.h(var1) < 2500.0D && var1.c.c();
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((qw) var1);
	}
}
