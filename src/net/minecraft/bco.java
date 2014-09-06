package net.minecraft;

import java.util.concurrent.Callable;

class bco implements Callable {

	// $FF: synthetic field
	final TileEntity a;

	bco(TileEntity var1) {
		this.a = var1;
	}

	public String a() {
		int var1 = Block.getBlockId(this.a.world.p(this.a.position).getBlock());

		try {
			return String.format("ID #%d (%s // %s)", new Object[] { Integer.valueOf(var1), Block.c(var1).getName(), Block.c(var1).getClass().getCanonicalName() });
		} catch (Throwable var3) {
			return "ID #" + var1;
		}
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
