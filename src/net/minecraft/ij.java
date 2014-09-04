package net.minecraft;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;

public enum ij {

	a("X", 0, 0), b("Y", 1, 1), c("Z", 2, 2), d("Y_ROT", 3, 3), e("X_ROT", 4, 4);
	private int f;
	// $FF: synthetic field
	private static final ij[] g = new ij[] { a, b, c, d, e };

	private ij(String var1, int var2, int var3) {
		this.f = var3;
	}

	private int a() {
		return 1 << this.f;
	}

	private boolean b(int var1) {
		return (var1 & this.a()) == this.a();
	}

	public static Set a(int var0) {
		EnumSet var1 = EnumSet.noneOf(ij.class);
		ij[] var2 = values();
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			ij var5 = var2[var4];
			if (var5.b(var0)) {
				var1.add(var5);
			}
		}

		return var1;
	}

	public static int a(Set var0) {
		int var1 = 0;

		ij var3;
		for (Iterator var2 = var0.iterator(); var2.hasNext(); var1 |= var3.a()) {
			var3 = (ij) var2.next();
		}

		return var1;
	}

}
