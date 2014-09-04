package net.minecraft;

import com.google.common.base.Predicate;

final class ap implements Predicate {

	// $FF: synthetic field
	final String a;
	// $FF: synthetic field
	final boolean b;

	ap(String var1, boolean var2) {
		this.a = var1;
		this.b = var2;
	}

	public boolean a(Entity var1) {
		if (!(var1 instanceof EntityLiving)) {
			return false;
		} else {
			EntityLiving var2 = (EntityLiving) var1;
			bsf var3 = var2.bN();
			String var4 = var3 == null ? "" : var3.b();
			return var4.equals(this.a) != this.b;
		}
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((Entity) var1);
	}
}
