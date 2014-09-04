package net.minecraft;

import java.util.Iterator;
import java.util.Random;

public class bhg extends bhp {

	private final atr a;
	private final int b;

	public bhg(atr var1, int var2) {
		super(false);
		this.a = var1;
		this.b = var2;
	}

	public boolean b(World var1, Random var2, dt var3) {
		while (true) {
			if (var3.o() > 3) {
				label47: {
					if (!var1.d(var3.b())) {
						atr var4 = var1.p(var3.b()).c();
						if (var4 == aty.c || var4 == aty.d || var4 == aty.b) {
							break label47;
						}
					}

					var3 = var3.b();
					continue;
				}
			}

			if (var3.o() <= 3) {
				return false;
			}

			int var12 = this.b;

			for (int var5 = 0; var12 >= 0 && var5 < 3; ++var5) {
				int var6 = var12 + var2.nextInt(2);
				int var7 = var12 + var2.nextInt(2);
				int var8 = var12 + var2.nextInt(2);
				float var9 = (float) (var6 + var7 + var8) * 0.333F + 0.5F;
				Iterator var10 = dt.a(var3.a(-var6, -var7, -var8), var3.a(var6, var7, var8)).iterator();

				while (var10.hasNext()) {
					dt var11 = (dt) var10.next();
					if (var11.i(var3) <= (double) (var9 * var9)) {
						var1.a(var11, this.a.P(), 4);
					}
				}

				var3 = var3.a(-(var12 + 1) + var2.nextInt(2 + var12 * 2), 0 - var2.nextInt(2), -(var12 + 1) + var2.nextInt(2 + var12 * 2));
			}

			return true;
		}
	}
}
