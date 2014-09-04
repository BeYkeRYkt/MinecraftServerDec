package net.minecraft;

import java.util.concurrent.Callable;

class bmn implements Callable {

	// $FF: synthetic field
	final int a;
	// $FF: synthetic field
	final int b;
	// $FF: synthetic field
	final bmm c;

	bmn(bmm var1, int var2, int var3) {
		this.c = var1;
		this.a = var2;
		this.b = var3;
	}

	public String a() {
		return this.c.a(this.a, this.b) ? "True" : "False";
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
