package net.minecraft;

import com.google.common.base.Predicate;

final class bbm implements Predicate {

	public boolean a(PaintingDirection var1) {
		return var1 != PaintingDirection.a;
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((PaintingDirection) var1);
	}
}
