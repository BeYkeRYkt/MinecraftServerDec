package net.minecraft;

import com.google.common.base.Function;

final class alr implements Function {

	public String a(ItemStack var1) {
		return bbb.a(var1.getDurability()).c();
	}

	// $FF: synthetic method
	public Object apply(Object var1) {
		return this.a((ItemStack) var1);
	}
}
