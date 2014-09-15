package net.minecraft;

import java.util.concurrent.Callable;

class bcp implements Callable {

	// $FF: synthetic field
	final TileEntity a;

	bcp(TileEntity var1) {
		this.a = var1;
	}

	public String a() {
		IBlockState var1 = this.a.world.getBlockState(this.a.position);
		int var2 = var1.getBlock().getData(var1);
		if (var2 < 0) {
			return "Unknown? (Got " + var2 + ")";
		} else {
			String var3 = String.format("%4s", new Object[] { Integer.toBinaryString(var2) }).replace(" ", "0");
			return String.format("%1$d / 0x%1$X / 0b%2$s", new Object[] { Integer.valueOf(var2), var3 });
		}
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
