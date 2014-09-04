package net.minecraft;

import com.google.common.base.Predicate;

final class awb implements Predicate {

	// $FF: synthetic field
	final awc a;

	awb(awc var1) {
		this.a = var1;
	}

	public boolean a(awa var1) {
		return var1.a() == this.a;
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((awa) var1);
	}
}
