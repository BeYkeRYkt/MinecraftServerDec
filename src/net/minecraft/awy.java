package net.minecraft;

import com.google.common.base.Predicate;

final class awy implements Predicate {

	public boolean a(PaintingDirection var1) {
		return var1 != PaintingDirection.b;
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((PaintingDirection) var1);
	}
}
