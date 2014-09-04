package net.minecraft;

import java.util.Random;

public class aye extends auc {

	public static final bew a = bew.a("age", 0, 3);

	protected aye() {
		this.j(this.L.b().a(a, Integer.valueOf(0)));
		this.a(true);
		float var1 = 0.5F;
		this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.25F, 0.5F + var1);
		this.a((akf) null);
	}

	protected boolean c(atr var1) {
		return var1 == aty.aW;
	}

	public boolean f(World var1, dt var2, bec var3) {
		return this.c(var1.p(var2.b()).c());
	}

	public void b(World var1, dt var2, bec var3, Random var4) {
		int var5 = ((Integer) var3.b(a)).intValue();
		if (var5 < 3 && var4.nextInt(10) == 0) {
			var3 = var3.a(a, Integer.valueOf(var5 + 1));
			var1.a(var2, var3, 2);
		}

		super.b(var1, var2, var3, var4);
	}

	public void a(World var1, dt var2, bec var3, float var4, int var5) {
		if (!var1.D) {
			int var6 = 1;
			if (((Integer) var3.b(a)).intValue() >= 3) {
				var6 = 2 + var1.s.nextInt(3);
				if (var5 > 0) {
					var6 += var1.s.nextInt(var5 + 1);
				}
			}

			for (int var7 = 0; var7 < var6; ++var7) {
				a(var1, var2, new amj(amk.by));
			}

		}
	}

	public alq a(bec var1, Random var2, int var3) {
		return null;
	}

	public int a(Random var1) {
		return 0;
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
