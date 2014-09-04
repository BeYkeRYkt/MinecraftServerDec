package net.minecraft;

class afi extends zb {

	private afg a;
	private int b;

	public afi(afg var1) {
		this.a = var1;
		this.a(3);
	}

	public boolean a() {
		EntityLiving var1 = this.a.u();
		return var1 != null && var1.ai();
	}

	public boolean b() {
		return super.b() && (this.a.cl() || this.a.h(this.a.u()) > 9.0D);
	}

	public void c() {
		this.b = -10;
		this.a.s().n();
		this.a.p().a(this.a.u(), 90.0F, 90.0F);
		this.a.ai = true;
	}

	public void d() {
		afg.a(this.a, 0);
		this.a.d((EntityLiving) null);
		afg.a(this.a).f();
	}

	public void e() {
		EntityLiving var1 = this.a.u();
		this.a.s().n();
		this.a.p().a(var1, 90.0F, 90.0F);
		if (!this.a.t(var1)) {
			this.a.d((EntityLiving) null);
		} else {
			++this.b;
			if (this.b == 0) {
				afg.a(this.a, this.a.u().F());
				this.a.o.a((Entity) this.a, (byte) 21);
			} else if (this.b >= this.a.ck()) {
				float var2 = 1.0F;
				if (this.a.o.aa() == Difficulty.HARD) {
					var2 += 2.0F;
				}

				if (this.a.cl()) {
					var2 += 2.0F;
				}

				var1.a(wh.b(this.a, this.a), var2);
				var1.a(wh.a((EntityLiving) this.a), (float) this.a.a(afs.e).e());
				this.a.d((EntityLiving) null);
			} else if (this.b >= 60 && this.b % 20 == 0) {
				;
			}

			super.e();
		}
	}
}
