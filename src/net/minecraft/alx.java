package net.minecraft;

import com.google.common.base.Function;

final class alx implements Function {

	public String a(ItemStack var1) {
		return avk.a(var1.getDurability()).c();
	}

	// $FF: synthetic method
	public Object apply(Object var1) {
		return this.a((ItemStack) var1);
	}
}
