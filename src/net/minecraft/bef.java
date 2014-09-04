package net.minecraft;

import java.util.Comparator;

class bef implements Comparator {

	// $FF: synthetic field
	final bed a;

	bef(bed var1) {
		this.a = var1;
	}

	public int a(bex var1, bex var2) {
		return var1.a().compareTo(var2.a());
	}

	// $FF: synthetic method
	public int compare(Object var1, Object var2) {
		return this.a((bex) var1, (bex) var2);
	}
}
