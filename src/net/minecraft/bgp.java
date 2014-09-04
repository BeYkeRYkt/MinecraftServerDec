package net.minecraft;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public class bgp implements bfe {

	private static final List a = Lists.newArrayList();
	private static final int b;
	private final World c;

	public bgp(World var1) {
		this.c = var1;
	}

	public bfh d(int var1, int var2) {
		bgk var3 = new bgk();

		int var7;
		for (int var4 = 0; var4 < 16; ++var4) {
			for (int var5 = 0; var5 < 16; ++var5) {
				int var6 = var1 * 16 + var4;
				var7 = var2 * 16 + var5;
				var3.a(var4, 60, var5, aty.cv.P());
				bec var8 = b(var6, var7);
				if (var8 != null) {
					var3.a(var4, 70, var5, var8);
				}
			}
		}

		bfh var9 = new bfh(this.c, var3, var1, var2);
		var9.b();
		arm[] var10 = this.c.v().b((arm[]) null, var1 * 16, var2 * 16, 16, 16);
		byte[] var11 = var9.k();

		for (var7 = 0; var7 < var11.length; ++var7) {
			var11[var7] = (byte) var10[var7].az;
		}

		var9.b();
		return var9;
	}

	public static bec b(int var0, int var1) {
		bec var2 = null;
		if (var0 > 0 && var1 > 0 && var0 % 2 != 0 && var1 % 2 != 0) {
			var0 /= 2;
			var1 /= 2;
			if (var0 <= b && var1 <= b) {
				int var3 = uv.a(var0 * b + var1);
				if (var3 < a.size()) {
					var2 = (bec) a.get(var3);
				}
			}
		}

		return var2;
	}

	public boolean a(int var1, int var2) {
		return true;
	}

	public void a(bfe var1, int var2, int var3) {
	}

	public boolean a(bfe var1, bfh var2, int var3, int var4) {
		return false;
	}

	public boolean a(boolean var1, uy var2) {
		return true;
	}

	public void c() {
	}

	public boolean d() {
		return false;
	}

	public boolean e() {
		return true;
	}

	public String f() {
		return "DebugLevelSource";
	}

	public List a(xp var1, dt var2) {
		arm var3 = this.c.b(var2);
		return var3.a(var1);
	}

	public dt a(World var1, String var2, dt var3) {
		return null;
	}

	public int g() {
		return 0;
	}

	public void a(bfh var1, int var2, int var3) {
	}

	public bfh a(dt var1) {
		return this.d(var1.n() >> 4, var1.p() >> 4);
	}

	static {
		Iterator var0 = atr.c.iterator();

		while (var0.hasNext()) {
			atr var1 = (atr) var0.next();
			a.addAll(var1.O().a());
		}

		b = uv.f(uv.c((float) a.size()));
	}
}
