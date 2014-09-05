package net.minecraft;

import java.util.Iterator;

final class dw implements Iterable {

	// $FF: synthetic field
	final Position a;
	// $FF: synthetic field
	final Position b;

	dw(Position var1, Position var2) {
		this.a = var1;
		this.b = var2;
	}

	public Iterator iterator() {
		return new dx(this);
	}
}
