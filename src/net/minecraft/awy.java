package net.minecraft;

import com.google.common.base.Predicate;

final class awy implements Predicate {

	public boolean a(BlockFace var1) {
		return var1 != BlockFace.b;
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((BlockFace) var1);
	}
}
