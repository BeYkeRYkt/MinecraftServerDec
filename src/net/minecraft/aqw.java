package net.minecraft;

import java.util.concurrent.Callable;

class aqw implements Callable {

	// $FF: synthetic field
	final Block a;
	// $FF: synthetic field
	final World b;

	aqw(World var1, Block var2) {
		this.b = var1;
		this.a = var2;
	}

	public String a() {
		try {
			return String.format("ID #%d (%s // %s)", new Object[] { Integer.valueOf(Block.getBlockId(this.a)), this.a.getName(), this.a.getClass().getCanonicalName() });
		} catch (Throwable var2) {
			return "ID #" + Block.getBlockId(this.a);
		}
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
