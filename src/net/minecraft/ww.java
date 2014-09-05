package net.minecraft;

import java.util.concurrent.Callable;

class ww implements Callable {

	// $FF: synthetic field
	final Entity a;

	ww(Entity var1) {
		this.a = var1;
	}

	public String a() {
		return EntityTypes.b(this.a) + " (" + this.a.getClass().getCanonicalName() + ")";
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
