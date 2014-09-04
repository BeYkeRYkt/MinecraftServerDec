package net.minecraft;

public class abx extends abs {

	public abx(World var1) {
		super(var1);
		this.a(0.9F, 1.3F);
		this.bl = aty.bw;
	}

	public boolean a(ahd var1) {
		amj var2 = var1.bg.h();
		if (var2 != null && var2.b() == amk.z && this.l() >= 0) {
			if (var2.b == 1) {
				var1.bg.a(var1.bg.c, new amj(amk.A));
				return true;
			}

			if (var1.bg.a(new amj(amk.A)) && !var1.by.d) {
				var1.bg.a(var1.bg.c, 1);
				return true;
			}
		}

		if (var2 != null && var2.b() == amk.be && this.l() >= 0) {
			this.J();
			this.o.a(ew.b, this.s, this.t + (double) (this.K / 2.0F), this.u, 0.0D, 0.0D, 0.0D, new int[0]);
			if (!this.o.D) {
				abs var3 = new abs(this.o);
				var3.b(this.s, this.t, this.u, this.y, this.z);
				var3.h(this.bm());
				var3.aG = this.aG;
				if (this.k_()) {
					var3.a(this.aL());
				}

				this.o.d((Entity) var3);

				for (int var4 = 0; var4 < 5; ++var4) {
					this.o.d((Entity) (new adw(this.o, this.s, this.t + (double) this.K, this.u, new amj(aty.Q))));
				}

				var2.a(1, (EntityLiving) var1);
				this.a("mob.sheep.shear", 1.0F, 1.0F);
			}

			return true;
		} else {
			return super.a(var1);
		}
	}

	public abx c(ws var1) {
		return new abx(this.o);
	}

	// $FF: synthetic method
	public abs b(ws var1) {
		return this.c(var1);
	}

	// $FF: synthetic method
	public ws a(ws var1) {
		return this.c(var1);
	}
}
