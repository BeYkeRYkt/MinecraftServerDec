package net.minecraft;

import java.util.concurrent.Callable;

class bmo implements Callable {

	// $FF: synthetic field
	final int a;
	// $FF: synthetic field
	final int b;
	// $FF: synthetic field
	final StructureGenerator c;

	bmo(StructureGenerator var1, int var2, int var3) {
		this.c = var1;
		this.a = var2;
		this.b = var3;
	}

	public String a() {
		return String.valueOf(ChunkCoordIntPair.toLongHash(this.a, this.b));
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
