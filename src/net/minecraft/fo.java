package net.minecraft;

import java.util.concurrent.Callable;

class fo implements Callable {

	// $FF: synthetic field
	final String a;
	// $FF: synthetic field
	final NBTCompoundTag b;

	fo(NBTCompoundTag var1, String var2) {
		this.b = var1;
		this.a = var2;
	}

	public String a() {
		return NBTTag.names[((NBTTag) NBTCompoundTag.b(this.b).get(this.a)).getId()];
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
