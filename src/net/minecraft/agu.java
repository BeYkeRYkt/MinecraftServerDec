package net.minecraft;

import java.util.Random;

class agu implements agw {

	public amj a;
	public agx b;
	public amj c;
	public agx d;

	public agu(alq var1, agx var2, alq var3, agx var4) {
		this.a = new amj(var1);
		this.b = var2;
		this.c = new amj(var3);
		this.d = var4;
	}

	public void a(aqd var1, Random var2) {
		int var3 = 1;
		if (this.b != null) {
			var3 = this.b.a(var2);
		}

		int var4 = 1;
		if (this.d != null) {
			var4 = this.d.a(var2);
		}

		var1.add(new aqc(new amj(this.a.b(), var3, this.a.i()), new amj(amk.bO), new amj(this.c.b(), var4, this.c.i())));
	}
}
