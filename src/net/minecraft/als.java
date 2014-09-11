package net.minecraft;

import com.google.common.base.Function;

final class als implements Function {

	public String a(ItemStack var1) {
		return EnumFlowerType.a(EnumFlowerColor.a, var1.getDurability()).d();
	}

	// $FF: synthetic method
	public Object apply(Object var1) {
		return this.a((ItemStack) var1);
	}
}
