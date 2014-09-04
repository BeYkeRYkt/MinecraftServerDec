package net.minecraft;

import com.google.common.base.Predicate;
import java.util.Random;

public class awj extends atg {

	public static final beu a = beu.a("facing", (Predicate) en.a);
	private final boolean b;
	private static boolean M;

	protected awj(boolean var1) {
		super(bof.e);
		this.j(this.L.b().a(a, ej.c));
		this.b = var1;
	}

	public alq a(bec var1, Random var2, int var3) {
		return alq.a(aty.al);
	}

	public void c(World var1, dt var2, bec var3) {
		this.e(var1, var2, var3);
	}

	private void e(World var1, dt var2, bec var3) {
		if (!var1.D) {
			atr var4 = var1.p(var2.c()).c();
			atr var5 = var1.p(var2.d()).c();
			atr var6 = var1.p(var2.e()).c();
			atr var7 = var1.p(var2.f()).c();
			ej var8 = (ej) var3.b(a);
			if (var8 == ej.c && var4.m() && !var5.m()) {
				var8 = ej.d;
			} else if (var8 == ej.d && var5.m() && !var4.m()) {
				var8 = ej.c;
			} else if (var8 == ej.e && var6.m() && !var7.m()) {
				var8 = ej.f;
			} else if (var8 == ej.f && var7.m() && !var6.m()) {
				var8 = ej.e;
			}

			var1.a(var2, var3.a(a, var8), 2);
		}
	}

	public boolean a(World var1, dt var2, bec var3, ahd var4, ej var5, float var6, float var7, float var8) {
		if (var1.D) {
			return true;
		} else {
			bcm var9 = var1.s(var2);
			if (var9 instanceof bdc) {
				var4.a((vq) ((bdc) var9));
			}

			return true;
		}
	}

	public static void a(boolean var0, World var1, dt var2) {
		bec var3 = var1.p(var2);
		bcm var4 = var1.s(var2);
		M = true;
		if (var0) {
			var1.a(var2, aty.am.P().a(a, var3.b(a)), 3);
			var1.a(var2, aty.am.P().a(a, var3.b(a)), 3);
		} else {
			var1.a(var2, aty.al.P().a(a, var3.b(a)), 3);
			var1.a(var2, aty.al.P().a(a, var3.b(a)), 3);
		}

		M = false;
		if (var4 != null) {
			var4.D();
			var1.a(var2, var4);
		}

	}

	public bcm a(World var1, int var2) {
		return new bdc();
	}

	public bec a(World var1, dt var2, ej var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		return this.P().a(a, var8.aO().d());
	}

	public void a(World var1, dt var2, bec var3, EntityLiving var4, amj var5) {
		var1.a(var2, var3.a(a, var4.aO().d()), 2);
		if (var5.s()) {
			bcm var6 = var1.s(var2);
			if (var6 instanceof bdc) {
				((bdc) var6).a(var5.q());
			}
		}

	}

	public void b(World var1, dt var2, bec var3) {
		if (!M) {
			bcm var4 = var1.s(var2);
			if (var4 instanceof bdc) {
				vs.a(var1, var2, (bdc) var4);
				var1.e(var2, this);
			}
		}

		super.b(var1, var2, var3);
	}

	public boolean N() {
		return true;
	}

	public int l(World var1, dt var2) {
		return aib.a(var1.s(var2));
	}

	public int b() {
		return 3;
	}

	public bec a(int var1) {
		ej var2 = ej.a(var1);
		if (var2.k() == el.b) {
			var2 = ej.c;
		}

		return this.P().a(a, var2);
	}

	public int c(bec var1) {
		return ((ej) var1.b(a)).a();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}
