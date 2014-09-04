package net.minecraft;

import com.google.common.base.Predicate;

class aap implements Predicate {

	// $FF: synthetic field
	final aao a;

	aap(aao var1) {
		this.a = var1;
	}

	public boolean a(Entity var1) {
		if (!(var1 instanceof ahd)) {
			return false;
		} else {
			double var2 = this.a.f();
			if (var1.aw()) {
				var2 *= 0.800000011920929D;
			}

			if (var1.ay()) {
				float var4 = ((ahd) var1).bX();
				if (var4 < 0.1F) {
					var4 = 0.1F;
				}

				var2 *= (double) (0.7F * var4);
			}

			return (double) var1.g(aao.a(this.a)) > var2 ? false : aaw.a(aao.a(this.a), (EntityLiving) var1, false, true);
		}
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((Entity) var1);
	}
}
