package net.minecraft;

import com.google.common.base.Predicate;

class aan implements Predicate {

	// $FF: synthetic field
	final aam a;

	aan(aam var1) {
		this.a = var1;
	}

	public boolean a(EntityLiving var1) {
		double var2 = this.a.f();
		if (var1.aw()) {
			var2 *= 0.800000011920929D;
		}

		return var1.ay() ? false : ((double) var1.g(aam.a(this.a)) > var2 ? false : aaw.a(aam.a(this.a), var1, false, true));
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((EntityLiving) var1);
	}
}
