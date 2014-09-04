package net.minecraft;

import com.google.common.base.Function;

final class amg implements Function {

	public String a(amj var1) {
		return (var1.i() & 1) == 1 ? "wet" : "dry";
	}

	// $FF: synthetic method
	public Object apply(Object var1) {
		return this.a((amj) var1);
	}
}
