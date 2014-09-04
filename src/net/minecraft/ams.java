package net.minecraft;

import com.google.common.base.Function;

class ams implements Function {

	// $FF: synthetic field
	final String[] a;

	ams(String[] var1) {
		this.a = var1;
	}

	public String a(amj var1) {
		int var2 = var1.i();
		if (var2 < 0 || var2 >= this.a.length) {
			var2 = 0;
		}

		return this.a[var2];
	}

	// $FF: synthetic method
	public Object apply(Object var1) {
		return this.a((amj) var1);
	}
}
