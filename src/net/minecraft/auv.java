package net.minecraft;

import java.util.Random;

public class auv extends atg {

	public static final bew a = bew.a("power", 0, 15);
	private final boolean b;

	public auv(boolean var1) {
		super(bof.d);
		this.b = var1;
		this.j(this.L.b().a(a, Integer.valueOf(0)));
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.375F, 1.0F);
		this.a(akf.d);
		this.c(0.2F);
		this.a(f);
		this.c("daylightDetector");
	}

	public void a(ard var1, dt var2) {
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.375F, 1.0F);
	}

	public int a(ard var1, dt var2, bec var3, ej var4) {
		return ((Integer) var3.b(a)).intValue();
	}

	public void d(World var1, dt var2) {
		if (!var1.t.o()) {
			bec var3 = var1.p(var2);
			int var4 = var1.b(arf.a, var2) - var1.ab();
			float var5 = var1.d(1.0F);
			float var6 = var5 < 3.1415927F ? 0.0F : 6.2831855F;
			var5 += (var6 - var5) * 0.2F;
			var4 = Math.round((float) var4 * NumberConverter.b(var5));
			var4 = NumberConverter.a(var4, 0, 15);
			if (this.b) {
				var4 = 15 - var4;
			}

			if (((Integer) var3.b(a)).intValue() != var4) {
				var1.a(var2, var3.a(a, Integer.valueOf(var4)), 3);
			}

		}
	}

	public boolean a(World var1, dt var2, bec var3, ahd var4, ej var5, float var6, float var7, float var8) {
		if (var4.cm()) {
			if (var1.D) {
				return true;
			} else {
				if (this.b) {
					var1.a(var2, aty.cl.P().a(a, var3.b(a)), 4);
					aty.cl.d(var1, var2);
				} else {
					var1.a(var2, aty.cm.P().a(a, var3.b(a)), 4);
					aty.cm.d(var1, var2);
				}

				return true;
			}
		} else {
			return super.a(var1, var2, var3, var4, var5, var6, var7, var8);
		}
	}

	public alq a(bec var1, Random var2, int var3) {
		return alq.a((atr) aty.cl);
	}

	public boolean d() {
		return false;
	}

	public boolean c() {
		return false;
	}

	public int b() {
		return 3;
	}

	public boolean g() {
		return true;
	}

	public bcm a(World var1, int var2) {
		return new bcw();
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
