package net.minecraft;

import com.google.common.base.Function;

final class hl implements Function {

	public IChatBaseComponent a(IChatBaseComponent var1) {
		IChatBaseComponent var2 = var1.f();
		var2.a(var2.b().n());
		return var2;
	}

	// $FF: synthetic method
	public Object apply(Object var1) {
		return this.a((IChatBaseComponent) var1);
	}
}
