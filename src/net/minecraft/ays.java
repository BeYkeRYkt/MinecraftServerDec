package net.minecraft;

import com.google.common.base.Predicate;

final class ays implements Predicate {

	public boolean a(EnumWoodType var1) {
		return var1.a() < 4;
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((EnumWoodType) var1);
	}
}
