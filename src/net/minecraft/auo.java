package net.minecraft;

import java.util.Random;

public class auo extends atg {

	public static final bet a = bet.a("triggered");

	public auo() {
		super(bof.f);
		this.j(this.L.b().a(a, Boolean.valueOf(false)));
	}

	public bcm a(World var1, int var2) {
		return new bct();
	}

	public void a(World var1, dt var2, bec var3, atr var4) {
		if (!var1.D) {
			boolean var5 = var1.z(var2);
			boolean var6 = ((Boolean) var3.b(a)).booleanValue();
			if (var5 && !var6) {
				var1.a(var2, var3.a(a, Boolean.valueOf(true)), 4);
				var1.a(var2, (atr) this, this.a(var1));
			} else if (!var5 && var6) {
				var1.a(var2, var3.a(a, Boolean.valueOf(false)), 4);
			}
		}

	}

	public void b(World var1, dt var2, bec var3, Random var4) {
		bcm var5 = var1.s(var2);
		if (var5 instanceof bct) {
			((bct) var5).b().a(var1);
			var1.e(var2, this);
		}

	}

	public int a(World var1) {
		return 1;
	}

	public boolean a(World var1, dt var2, bec var3, ahd var4, ej var5, float var6, float var7, float var8) {
		bcm var9 = var1.s(var2);
		return var9 instanceof bct ? ((bct) var9).b().a(var4) : false;
	}

	public boolean N() {
		return true;
	}

	public int l(World var1, dt var2) {
		bcm var3 = var1.s(var2);
		return var3 instanceof bct ? ((bct) var3).b().j() : 0;
	}

	public void a(World var1, dt var2, bec var3, EntityLiving var4, amj var5) {
		bcm var6 = var1.s(var2);
		if (var6 instanceof bct) {
			aqf var7 = ((bct) var6).b();
			if (var5.s()) {
				var7.b(var5.q());
			}

			if (!var1.D) {
				var7.a(var1.Q().b("sendCommandFeedback"));
			}

		}
	}

	public int a(Random var1) {
		return 0;
	}

	public int b() {
		return 3;
	}

	public bec a(int var1) {
		return this.P().a(a, Boolean.valueOf((var1 & 1) > 0));
	}

	public int c(bec var1) {
		int var2 = 0;
		if (((Boolean) var1.b(a)).booleanValue()) {
			var2 |= 1;
		}

		return var2;
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

	public bec a(World var1, dt var2, ej var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		return this.P().a(a, Boolean.valueOf(false));
	}

}
