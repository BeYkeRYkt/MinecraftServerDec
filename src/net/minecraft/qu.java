package net.minecraft;

import com.google.common.base.Predicate;

class qu implements Predicate {

	// $FF: synthetic field
	final WorldServer a;

	qu(WorldServer var1) {
		this.a = var1;
	}

	public boolean a(EntityLiving var1) {
		return var1 != null && var1.ai() && this.a.i(var1.c());
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((EntityLiving) var1);
	}
}
