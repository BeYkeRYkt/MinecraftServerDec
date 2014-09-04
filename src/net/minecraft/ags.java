package net.minecraft;

import java.util.Random;

class ags implements agw {

	public void a(aqd var1, Random var2) {
		apf var3 = apf.b[var2.nextInt(apf.b.length)];
		int var4 = NumberConverter.a(var2, var3.e(), var3.b());
		amj var5 = amk.cd.a(new apo(var3, var4));
		int var6 = 2 + var2.nextInt(5 + var4 * 10) + 3 * var4;
		if (var6 > 64) {
			var6 = 64;
		}

		var1.add(new aqc(new amj(amk.aL), new amj(amk.bO, var6), var5));
	}
}
