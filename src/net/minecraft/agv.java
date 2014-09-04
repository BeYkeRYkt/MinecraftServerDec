package net.minecraft;

import java.util.Random;

class agv implements agw {

	public amj a;
	public agx b;

	public agv(alq var1, agx var2) {
		this.a = new amj(var1);
		this.b = var2;
	}

	public agv(amj var1, agx var2) {
		this.a = var1;
		this.b = var2;
	}

	public void a(aqd var1, Random var2) {
		int var3 = 1;
		if (this.b != null) {
			var3 = this.b.a(var2);
		}

		amj var4;
		amj var5;
		if (var3 < 0) {
			var4 = new amj(amk.bO, 1, 0);
			var5 = new amj(this.a.b(), -var3, this.a.i());
		} else {
			var4 = new amj(amk.bO, var3, 0);
			var5 = new amj(this.a.b(), 1, this.a.i());
		}

		var1.add(new aqc(var4, var5));
	}
}
