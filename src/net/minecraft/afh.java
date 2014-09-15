package net.minecraft;

import com.google.common.base.Predicate;

class afh implements Predicate {

	// $FF: synthetic field
	final EntityGuardian a;

	afh(EntityGuardian var1) {
		this.a = var1;
	}

	public boolean a(EntityPlayer var1) {
		return this.a.getDistanceSquared(var1) < 2500.0D && var1.playerInteractManager.isSurvivalOrAdventure();
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((EntityPlayer) var1);
	}
}
