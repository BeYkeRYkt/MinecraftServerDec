package net.minecraft;

import com.google.common.base.Predicate;

final class aj implements Predicate {

	// $FF: synthetic field
	final int a;
	// $FF: synthetic field
	final int b;

	aj(int var1, int var2) {
		this.a = var1;
		this.b = var2;
	}

	public boolean a(Entity var1) {
		int var2 = ah.a((int) Math.floor((double) var1.z));
		return this.a > this.b ? var2 >= this.a || var2 <= this.b : var2 >= this.a && var2 <= this.b;
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((Entity) var1);
	}
}
