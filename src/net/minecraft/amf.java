package net.minecraft;

import com.google.common.base.Function;

final class amf implements Function {

	public String a(ItemStack var1) {
		return ayx.a(var1.getDurability() + 4).c();
	}

	// $FF: synthetic method
	public Object apply(Object var1) {
		return this.a((ItemStack) var1);
	}
}
