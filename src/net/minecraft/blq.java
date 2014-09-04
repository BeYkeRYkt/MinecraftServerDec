package net.minecraft;

import java.util.List;
import java.util.Random;

public class blq extends bmv {

	public blq() {
	}

	public blq(World var1, Random var2, int var3, int var4) {
		super(var3, var4);
		blr.b();
		bmh var5 = new bmh(0, var2, (var3 << 4) + 2, (var4 << 4) + 2);
		this.a.add(var5);
		var5.a(var5, this.a, var2);
		List var6 = var5.c;

		while (!var6.isEmpty()) {
			int var7 = var2.nextInt(var6.size());
			bms var8 = (bms) var6.remove(var7);
			var8.a((bms) var5, (List) this.a, var2);
		}

		this.c();
		this.a(var1, var2, 10);
	}
}
