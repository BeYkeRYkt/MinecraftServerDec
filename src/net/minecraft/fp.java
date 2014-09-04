package net.minecraft;

import java.util.concurrent.Callable;

class fp implements Callable {

	// $FF: synthetic field
	final int a;
	// $FF: synthetic field
	final NBTCompoundTag b;

	fp(NBTCompoundTag var1, int var2) {
		this.b = var1;
		this.a = var2;
	}

	public String a() {
		return NBTTag.names[this.a];
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
