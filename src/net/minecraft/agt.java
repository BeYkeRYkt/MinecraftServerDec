package net.minecraft;

import java.util.Random;

class agt implements agw {

	public amj a;
	public agx b;

	public agt(alq var1, agx var2) {
		this.a = new amj(var1);
		this.b = var2;
	}

	public void a(aqd var1, Random var2) {
		int var3 = 1;
		if (this.b != null) {
			var3 = this.b.a(var2);
		}

		amj var4 = new amj(amk.bO, var3, 0);
		amj var5 = new amj(this.a.b(), 1, this.a.i());
		var5 = aph.a(var2, var5, 5 + var2.nextInt(15));
		var1.add(new aqc(var4, var5));
	}
}
