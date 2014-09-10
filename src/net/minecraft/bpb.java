package net.minecraft;

import java.util.concurrent.Callable;

final class bpb implements Callable {

	// $FF: synthetic field
	final BiomeBase a;

	bpb(BiomeBase var1) {
		this.a = var1;
	}

	public String a() {
		return String.valueOf(this.a);
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
