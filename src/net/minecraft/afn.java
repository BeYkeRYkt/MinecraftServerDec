package net.minecraft;

import com.google.common.base.Predicate;

class afn implements Predicate {

	// $FF: synthetic field
	final EntityMonster a;

	afn(EntityMonster var1) {
		this.a = var1;
	}

	public boolean a(Entity var1) {
		return var1 instanceof EntityCreeper && ((EntityCreeper) var1).ck() > 0;
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((Entity) var1);
	}
}
