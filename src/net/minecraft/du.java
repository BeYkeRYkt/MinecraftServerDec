package net.minecraft;

import java.util.Iterator;

final class du implements Iterable {

	// $FF: synthetic field
	final dt a;
	// $FF: synthetic field
	final dt b;

	du(dt var1, dt var2) {
		this.a = var1;
		this.b = var2;
	}

	public Iterator iterator() {
		return new dv(this);
	}
}
