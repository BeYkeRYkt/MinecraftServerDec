package net.minecraft;

import com.google.common.base.Predicate;

final class ai implements Predicate {

	// $FF: synthetic field
	final String a;
	// $FF: synthetic field
	final boolean b;

	ai(String var1, boolean var2) {
		this.a = var1;
		this.b = var2;
	}

	public boolean a(Entity var1) {
		return EntityTypes.isEntityOfThatType(var1, this.a) != this.b;
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((Entity) var1);
	}
}
