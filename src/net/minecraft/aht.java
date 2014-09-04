package net.minecraft;

public class aht extends ahr {

	public aht(World var1, EntityLiving var2) {
		super(var1, var2);
	}

	protected void a(bru var1) {
		EntityLiving var2 = this.n();
		if (var1.d != null) {
			var1.d.a(wh.a((Entity) this, var2), 0.0F);
		}

		for (int var3 = 0; var3 < 32; ++var3) {
			this.o.a(ew.y, this.s, this.t + this.V.nextDouble() * 2.0D, this.u, this.V.nextGaussian(), 0.0D, this.V.nextGaussian(), new int[0]);
		}

		if (!this.o.D) {
			if (var2 instanceof qw) {
				qw var5 = (qw) var2;
				if (var5.a.a().g() && var5.o == this.o && !var5.bI()) {
					if (this.V.nextFloat() < 0.05F && this.o.Q().b("doMobSpawning")) {
						aew var4 = new aew(this.o);
						var4.a(true);
						var4.b(var2.s, var2.t, var2.u, var2.y, var2.z);
						this.o.d((Entity) var4);
					}

					if (var2.av()) {
						var2.a((Entity) null);
					}

					var2.a(this.s, this.t, this.u);
					var2.O = 0.0F;
					var2.a(wh.i, 5.0F);
				}
			}

			this.J();
		}

	}

	public void s_() {
		EntityLiving var1 = this.n();
		if (var1 != null && var1 instanceof ahd && !var1.ai()) {
			this.J();
		} else {
			super.s_();
		}

	}
}
