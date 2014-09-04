package net.minecraft;

import java.util.Iterator;
import java.util.Random;

public class auf extends atr {

	public static final bew a = bew.a("age", 0, 15);

	protected auf() {
		super(bof.A);
		this.j(this.L.b().a(a, Integer.valueOf(0)));
		this.a(true);
		this.a(akf.c);
	}

	public void b(World var1, dt var2, bec var3, Random var4) {
		dt var5 = var2.a();
		if (var1.d(var5)) {
			int var6;
			for (var6 = 1; var1.p(var2.c(var6)).c() == this; ++var6) {
				;
			}

			if (var6 < 3) {
				int var7 = ((Integer) var3.b(a)).intValue();
				if (var7 == 15) {
					var1.a(var5, this.P());
					bec var8 = var3.a(a, Integer.valueOf(0));
					var1.a(var2, var8, 4);
					this.a(var1, var5, var8, (atr) this);
				} else {
					var1.a(var2, var3.a(a, Integer.valueOf(var7 + 1)), 4);
				}

			}
		}
	}

	public brt a(World var1, dt var2, bec var3) {
		float var4 = 0.0625F;
		return new brt((double) ((float) var2.n() + var4), (double) var2.o(), (double) ((float) var2.p() + var4), (double) ((float) (var2.n() + 1) - var4), (double) ((float) (var2.o() + 1) - var4), (double) ((float) (var2.p() + 1) - var4));
	}

	public boolean d() {
		return false;
	}

	public boolean c() {
		return false;
	}

	public boolean c(World var1, dt var2) {
		return super.c(var1, var2) ? this.d(var1, var2) : false;
	}

	public void a(World var1, dt var2, bec var3, atr var4) {
		if (!this.d(var1, var2)) {
			var1.b(var2, true);
		}

	}

	public boolean d(World var1, dt var2) {
		Iterator var3 = en.a.iterator();

		while (var3.hasNext()) {
			ej var4 = (ej) var3.next();
			if (var1.p(var2.a(var4)).c().r().a()) {
				return false;
			}
		}

		atr var5 = var1.p(var2.b()).c();
		return var5 == aty.aK || var5 == aty.m;
	}

	public void a(World var1, dt var2, bec var3, Entity var4) {
		var4.a(wh.h, 1.0F);
	}

	public bec a(int var1) {
		return this.P().a(a, Integer.valueOf(var1));
	}

	public int c(bec var1) {
		return ((Integer) var1.b(a)).intValue();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}
