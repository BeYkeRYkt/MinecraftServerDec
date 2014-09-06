package net.minecraft;

class ato implements Runnable {

	// $FF: synthetic field
	final Position a;
	// $FF: synthetic field
	final atn b;

	ato(atn var1, Position var2) {
		this.b = var1;
		this.a = var2;
	}

	public void run() {
		TileEntity var1 = this.b.a.s(this.a);
		if (var1 instanceof TileEntityBeacon) {
			((TileEntityBeacon) var1).m();
			this.b.a.c(this.a, aty.bY, 1, 0);
		}

	}
}
