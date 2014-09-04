package net.minecraft;

import com.google.common.base.Function;
import java.util.Arrays;
import java.util.List;

class ed implements Function {

	private ed() {
	}

	public List a(Object[] var1) {
		return Arrays.asList((Object[]) var1);
	}

	// $FF: synthetic method
	public Object apply(Object var1) {
		return this.a((Object[]) var1);
	}

	// $FF: synthetic method
	ed(ec var1) {
		this();
	}
}
