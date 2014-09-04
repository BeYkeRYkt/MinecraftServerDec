package net.minecraft;

import com.google.common.base.Function;

final class bee implements Function {

	public String a(bex var1) {
		return var1 == null ? "<NULL>" : var1.a();
	}

	// $FF: synthetic method
	public Object apply(Object var1) {
		return this.a((bex) var1);
	}
}
