package net.minecraft;

import java.util.Collections;
import java.util.Iterator;

class ee implements Iterable {

	private final Class a;
	private final Iterable[] b;

	private ee(Class var1, Iterable[] var2) {
		this.a = var1;
		this.b = var2;
	}

	public Iterator iterator() {
		return (Iterator) (this.b.length <= 0 ? Collections.singletonList((Object[]) eb.a(this.a, 0)).iterator() : new ef(this.a, this.b, (ec) null));
	}

	// $FF: synthetic method
	ee(Class var1, Iterable[] var2, ec var3) {
		this(var1, var2);
	}
}
