package net.minecraft;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class yt extends zb {

	private abq d;
	World a;
	private abq e;
	int b;
	double c;

	public yt(abq var1, double var2) {
		this.d = var1;
		this.a = var1.o;
		this.c = var2;
		this.a(3);
	}

	public boolean a() {
		if (!this.d.cp()) {
			return false;
		} else {
			this.e = this.f();
			return this.e != null;
		}
	}

	public boolean b() {
		return this.e.ai() && this.e.cp() && this.b < 60;
	}

	public void d() {
		this.e = null;
		this.b = 0;
	}

	public void e() {
		this.d.p().a(this.e, 10.0F, (float) this.d.bP());
		this.d.s().a((Entity) this.e, this.c);
		++this.b;
		if (this.b >= 60 && this.d.h(this.e) < 9.0D) {
			this.g();
		}

	}

	private abq f() {
		float var1 = 8.0F;
		List var2 = this.a.a(this.d.getClass(), this.d.aQ().b((double) var1, (double) var1, (double) var1));
		double var3 = Double.MAX_VALUE;
		abq var5 = null;
		Iterator var6 = var2.iterator();

		while (var6.hasNext()) {
			abq var7 = (abq) var6.next();
			if (this.d.a(var7) && this.d.h(var7) < var3) {
				var5 = var7;
				var3 = this.d.h(var7);
			}
		}

		return var5;
	}

	private void g() {
		ws var1 = this.d.a((ws) this.e);
		if (var1 != null) {
			ahd var2 = this.d.co();
			if (var2 == null && this.e.co() != null) {
				var2 = this.e.co();
			}

			if (var2 != null) {
				var2.b(ty.A);
				if (this.d instanceof abs) {
					var2.b((PlayerStatistic) tl.H);
				}
			}

			this.d.b(6000);
			this.e.b(6000);
			this.d.cq();
			this.e.cq();
			var1.b(-24000);
			var1.b(this.d.s, this.d.t, this.d.u, 0.0F, 0.0F);
			this.a.d((Entity) var1);
			Random var3 = this.d.bb();

			for (int var4 = 0; var4 < 7; ++var4) {
				double var5 = var3.nextGaussian() * 0.02D;
				double var7 = var3.nextGaussian() * 0.02D;
				double var9 = var3.nextGaussian() * 0.02D;
				this.a.a(ew.I, this.d.s + (double) (var3.nextFloat() * this.d.J * 2.0F) - (double) this.d.J, this.d.t + 0.5D + (double) (var3.nextFloat() * this.d.K), this.d.u + (double) (var3.nextFloat() * this.d.J * 2.0F) - (double) this.d.J, var5, var7, var9, new int[0]);
			}

			if (this.a.Q().b("doMobLoot")) {
				this.a.d((Entity) (new xk(this.a, this.d.s, this.d.t, this.d.u, var3.nextInt(7) + 1)));
			}

		}
	}
}
