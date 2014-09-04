package net.minecraft;

import com.google.common.base.Predicate;

class acr extends aaq {

	public acr(EntityCreature var1, Class var2, int var3, boolean var4, boolean var5, Predicate var6) {
		super(var1, var2, var3, var4, var5, var6);
		this.c = new acs(this, var6, var1);
	}

	// $FF: synthetic method
	static double a(acr var0) {
		return var0.f();
	}

	// $FF: synthetic method
	static boolean a(acr var0, EntityLiving var1, boolean var2) {
		return var0.a(var1, var2);
	}
}
