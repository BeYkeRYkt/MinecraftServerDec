package net.minecraft;

import java.util.Comparator;

final class bsb implements Comparator {

	public int a(bsa var1, bsa var2) {
		return var1.c() > var2.c() ? 1 : (var1.c() < var2.c() ? -1 : var2.e().compareToIgnoreCase(var1.e()));
	}

	// $FF: synthetic method
	public int compare(Object var1, Object var2) {
		return this.a((bsa) var1, (bsa) var2);
	}
}
