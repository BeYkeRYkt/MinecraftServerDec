package net.minecraft;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aot implements aoo {

	private final amj a;
	private final List b;

	public aot(amj var1, List var2) {
		this.a = var1;
		this.b = var2;
	}

	public amj b() {
		return this.a;
	}

	public amj[] b(ain var1) {
		amj[] var2 = new amj[var1.n_()];

		for (int var3 = 0; var3 < var2.length; ++var3) {
			amj var4 = var1.a(var3);
			if (var4 != null && var4.b().r()) {
				var2[var3] = new amj(var4.b().q());
			}
		}

		return var2;
	}

	public boolean a(ain var1, World var2) {
		ArrayList var3 = Lists.newArrayList((Iterable) this.b);

		for (int var4 = 0; var4 < var1.h(); ++var4) {
			for (int var5 = 0; var5 < var1.i(); ++var5) {
				amj var6 = var1.c(var5, var4);
				if (var6 != null) {
					boolean var7 = false;
					Iterator var8 = var3.iterator();

					while (var8.hasNext()) {
						amj var9 = (amj) var8.next();
						if (var6.b() == var9.b() && (var9.i() == 32767 || var6.i() == var9.i())) {
							var7 = true;
							var3.remove(var9);
							break;
						}
					}

					if (!var7) {
						return false;
					}
				}
			}
		}

		return var3.isEmpty();
	}

	public amj a(ain var1) {
		return this.a.k();
	}

	public int a() {
		return this.b.size();
	}
}
