package net.minecraft;

public class ajz extends alq {

	public static final String[] a = new String[] { "pulling_0", "pulling_1", "pulling_2" };

	public ajz() {
		this.h = 1;
		this.d(384);
		this.a(akf.j);
	}

	public void a(amj var1, World var2, ahd var3, int var4) {
		boolean var5 = var3.by.instabuild || aph.a(apf.y.B, var1) > 0;
		if (var5 || var3.bg.b(amk.g)) {
			int var6 = this.d(var1) - var4;
			float var7 = (float) var6 / 20.0F;
			var7 = (var7 * var7 + var7 * 2.0F) / 3.0F;
			if ((double) var7 < 0.1D) {
				return;
			}

			if (var7 > 1.0F) {
				var7 = 1.0F;
			}

			ahj var8 = new ahj(var2, var3, var7 * 2.0F);
			if (var7 == 1.0F) {
				var8.a(true);
			}

			int var9 = aph.a(apf.v.B, var1);
			if (var9 > 0) {
				var8.b(var8.j() + (double) var9 * 0.5D + 0.5D);
			}

			int var10 = aph.a(apf.w.B, var1);
			if (var10 > 0) {
				var8.a(var10);
			}

			if (aph.a(apf.x.B, var1) > 0) {
				var8.e(100);
			}

			var1.a(1, (EntityLiving) var3);
			var2.a((Entity) var3, "random.bow", 1.0F, 1.0F / (g.nextFloat() * 0.4F + 1.2F) + var7 * 0.5F);
			if (var5) {
				var8.a = 2;
			} else {
				var3.bg.a(amk.g);
			}

			var3.b(ty.J[alq.b((alq) this)]);
			if (!var2.D) {
				var2.d((Entity) var8);
			}
		}

	}

	public amj b(amj var1, World var2, ahd var3) {
		return var1;
	}

	public int d(amj var1) {
		return 72000;
	}

	public ano e(amj var1) {
		return ano.e;
	}

	public amj a(amj var1, World var2, ahd var3) {
		if (var3.by.instabuild || var3.bg.b(amk.g)) {
			var3.a(var1, this.d(var1));
		}

		return var1;
	}

	public int b() {
		return 1;
	}

}
