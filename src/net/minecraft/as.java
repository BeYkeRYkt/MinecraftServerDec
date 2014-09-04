package net.minecraft;

import com.google.common.base.Predicate;

final class as implements Predicate {

	// $FF: synthetic field
	final dt a;
	// $FF: synthetic field
	final int b;
	// $FF: synthetic field
	final int c;
	// $FF: synthetic field
	final int d;
	// $FF: synthetic field
	final int e;

	as(dt var1, int var2, int var3, int var4, int var5) {
		this.a = var1;
		this.b = var2;
		this.c = var3;
		this.d = var4;
		this.e = var5;
	}

	public boolean a(Entity var1) {
		int var2 = (int) var1.c(this.a);
		return (this.b < 0 || var2 >= this.c) && (this.d < 0 || var2 <= this.e);
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((Entity) var1);
	}
}
