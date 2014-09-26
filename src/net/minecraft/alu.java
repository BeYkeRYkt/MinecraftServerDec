package net.minecraft;

import com.google.common.base.Function;

final class alu implements Function {

	public String a(ItemStack var1) {
		return axu.a(var1.getWearout()).c();
	}

	// $FF: synthetic method
	public Object apply(Object var1) {
		return this.a((ItemStack) var1);
	}
}
