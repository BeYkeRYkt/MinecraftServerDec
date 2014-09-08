package net.minecraft;

import java.util.concurrent.Callable;

final class p implements Callable {

	// $FF: synthetic field
	final BlockState a;

	p(BlockState var1) {
		this.a = var1;
	}

	public String a() {
		return this.a.toString();
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
