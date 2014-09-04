package net.minecraft;

import com.google.common.base.Function;
import java.util.Map.Entry;

final class beb implements Function {

	public String a(Entry var1) {
		if (var1 == null) {
			return "<NULL>";
		} else {
			bex var2 = (bex) var1.getKey();
			return var2.a() + "=" + var2.a((Comparable) var1.getValue());
		}
	}

	// $FF: synthetic method
	public Object apply(Object var1) {
		return this.a((Entry) var1);
	}
}
