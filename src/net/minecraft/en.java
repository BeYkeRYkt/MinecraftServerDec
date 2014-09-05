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

	public PaintingDirection[] a() {
		switch (ek.c[this.ordinal()]) {
			case 1:
				return new PaintingDirection[] { PaintingDirection.c, PaintingDirection.f, PaintingDirection.d, PaintingDirection.e };
			case 2:
				return new PaintingDirection[] { PaintingDirection.b, PaintingDirection.a };
			default:
				throw new Error("Someone\'s been tampering with the universe!");
		}
	}

	public PaintingDirection a(Random var1) {
		PaintingDirection[] var2 = this.a();
		return var2[var1.nextInt(var2.length)];
	}

	public boolean a(PaintingDirection var1) {
		return var1 != null && var1.k().d() == this;
	}

	public Iterator iterator() {
		return Iterators.forArray(this.a());
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((PaintingDirection) var1);
	}

}
