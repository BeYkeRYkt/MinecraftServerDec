package net.minecraft;

import com.google.common.base.Predicate;

final class azd implements Predicate {

	public boolean a(atl var1) {
		return var1 != atl.j && var1 != atl.i && var1 != atl.g && var1 != atl.h;
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((atl) var1);
	}
}
