package net.minecraft;

import java.util.Iterator;
import java.util.List;

public class bsj extends bsi {

	public bsj(String var1) {
		super(var1);
	}

	public int a(List var1) {
		float var2 = 0.0F;

		ahd var4;
		for (Iterator var3 = var1.iterator(); var3.hasNext(); var2 += var4.bm() + var4.bM()) {
			var4 = (ahd) var3.next();
		}

		if (var1.size() > 0) {
			var2 /= (float) var1.size();
		}

		return NumberConverter.f(var2);
	}

	public boolean b() {
		return true;
	}

	public bsl c() {
		return bsl.b;
	}
}
