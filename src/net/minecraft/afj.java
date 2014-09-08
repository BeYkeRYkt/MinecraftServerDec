package net.minecraft;

import com.google.common.base.Predicate;

class afj implements Predicate {

	private EntityGuardian a;

	public afj(EntityGuardian var1) {
		this.a = var1;
	}

	public boolean a(EntityLiving var1) {
		return (var1 instanceof EntityHuman || var1 instanceof EntitySquid) && var1.getDistanceSquared(this.a) > 9.0D;
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((EntityLiving) var1);
	}
}
