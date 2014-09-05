package net.minecraft;

import com.google.common.base.Predicate;

class acs implements Predicate {

	// $FF: synthetic field
	final Predicate a;
	// $FF: synthetic field
	final EntityCreature b;
	// $FF: synthetic field
	final acr c;

	acs(acr var1, Predicate var2, EntityCreature var3) {
		this.c = var1;
		this.a = var2;
		this.b = var3;
	}

	public boolean a(EntityLiving var1) {
		if (this.a != null && !this.a.apply(var1)) {
			return false;
		} else if (var1 instanceof aep) {
			return false;
		} else {
			if (var1 instanceof EntityHuman) {
				double var2 = acr.a(this.c);
				if (var1.aw()) {
					var2 *= 0.800000011920929D;
				}

				if (var1.ay()) {
					float var4 = ((EntityHuman) var1).bX();
					if (var4 < 0.1F) {
						var4 = 0.1F;
					}

					var2 *= (double) (0.7F * var4);
				}

				if ((double) var1.g(this.b) > var2) {
					return false;
				}
			}

			return acr.a(this.c, var1, false);
		}
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((EntityLiving) var1);
	}
}
