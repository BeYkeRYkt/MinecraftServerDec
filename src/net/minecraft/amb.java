package net.minecraft;

import com.google.common.base.Function;

final class amb implements Function {

	public String a(ItemStack var1) {
		return ayx.a(var1.i()).c();
	}

	// $FF: synthetic method
	public Object apply(Object var1) {
		return this.a((ItemStack) var1);
	}
}
