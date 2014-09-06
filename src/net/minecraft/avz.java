package net.minecraft;

import com.google.common.base.Predicate;

class avz implements Predicate {

	// $FF: synthetic field
	final BlockFlowers a;

	avz(BlockFlowers var1) {
		this.a = var1;
	}

	public boolean a(awa var1) {
		return var1.a() == this.a.j();
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((awa) var1);
	}
}
