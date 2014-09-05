package net.minecraft;

import com.google.common.base.Predicate;

class afj implements Predicate {

	private afg a;

	public afj(afg var1) {
		this.a = var1;
	}

	public boolean a(EntityLiving var1) {
		return (var1 instanceof EntityHuman || var1 instanceof aco) && var1.h(this.a) > 9.0D;
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((EntityLiving) var1);
	}
}
