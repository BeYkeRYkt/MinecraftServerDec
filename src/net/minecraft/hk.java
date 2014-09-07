package net.minecraft;

import com.google.common.base.Function;
import java.util.Iterator;

final class hk implements Function {

	public Iterator a(IChatBaseComponent var1) {
		return var1.iterator();
	}

	// $FF: synthetic method
	public Object apply(Object var1) {
		return this.a((IChatBaseComponent) var1);
	}
}
