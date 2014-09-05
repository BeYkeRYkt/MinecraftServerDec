package net.minecraft;

public class zq extends zb {

	World a;
	xn b;
	EntityLiving c;
	int d;

	public zq(xn var1) {
		this.b = var1;
		this.a = var1.o;
		this.a(3);
	}

	public boolean a() {
		EntityLiving var1 = this.b.u();
		if (var1 == null) {
			return false;
		} else {
			this.c = var1;
			return true;
		}
	}

	public boolean b() {
		return !this.c.ai() ? false : (this.b.h(this.c) > 225.0D ? false : !this.b.s().m() || this.a());
	}

	public void d() {
		this.c = null;
		this.b.s().n();
	}

	public void e() {
		this.b.p().a(this.c, 30.0F, 30.0F);
		double var1 = (double) (this.b.J * 2.0F * this.b.J * 2.0F);
		double var3 = this.b.e(this.c.locationX, this.c.aQ().b, this.c.locationZ);
		double var5 = 0.8D;
		if (var3 > var1 && var3 < 16.0D) {
			var5 = 1.33D;
		} else if (var3 < 225.0D) {
			var5 = 0.6D;
		}

		this.b.s().a((Entity) this.c, var5);
		this.d = Math.max(this.d - 1, 0);
		if (var3 <= var1) {
			if (this.d <= 0) {
				this.d = 20;
				this.b.r(this.c);
			}
		}
	}
}
