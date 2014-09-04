package net.minecraft;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import java.util.Iterator;
import java.util.Random;

public enum en implements Predicate, Iterable {

	a("HORIZONTAL", 0), b("VERTICAL", 1);
	// $FF: synthetic field
	private static final en[] c = new en[] { a, b };

	private en(String var1, int var2) {
	}

	public ej[] a() {
		switch (ek.c[this.ordinal()]) {
			case 1:
				return new ej[] { ej.c, ej.f, ej.d, ej.e };
			case 2:
				return new ej[] { ej.b, ej.a };
			default:
				throw new Error("Someone\'s been tampering with the universe!");
		}
	}

	public ej a(Random var1) {
		ej[] var2 = this.a();
		return var2[var1.nextInt(var2.length)];
	}

	public boolean a(ej var1) {
		return var1 != null && var1.k().d() == this;
	}

	public Iterator iterator() {
		return Iterators.forArray(this.a());
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((ej) var1);
	}

}
