package net.minecraft;

public abstract class xl extends xn {

	public xl(World var1) {
		super(var1);
	}

	public void e(float var1, float var2) {
	}

	protected void a(double var1, boolean var3, atr var4, dt var5) {
	}

	public void g(float var1, float var2) {
		if (this.V()) {
			this.a(var1, var2, 0.02F);
			this.d(this.v, this.w, this.x);
			this.v *= 0.800000011920929D;
			this.w *= 0.800000011920929D;
			this.x *= 0.800000011920929D;
		} else if (this.ab()) {
			this.a(var1, var2, 0.02F);
			this.d(this.v, this.w, this.x);
			this.v *= 0.5D;
			this.w *= 0.5D;
			this.x *= 0.5D;
		} else {
			float var3 = 0.91F;
			if (this.C) {
				var3 = this.o.p(new dt(NumberConverter.c(this.s), NumberConverter.c(this.aQ().b) - 1, NumberConverter.c(this.u))).c().K * 0.91F;
			}

			float var4 = 0.16277136F / (var3 * var3 * var3);
			this.a(var1, var2, this.C ? 0.1F * var4 : 0.02F);
			var3 = 0.91F;
			if (this.C) {
				var3 = this.o.p(new dt(NumberConverter.c(this.s), NumberConverter.c(this.aQ().b) - 1, NumberConverter.c(this.u))).c().K * 0.91F;
			}

			this.d(this.v, this.w, this.x);
			this.v *= (double) var3;
			this.w *= (double) var3;
			this.x *= (double) var3;
		}

		this.ay = this.az;
		double var8 = this.s - this.p;
		double var5 = this.u - this.r;
		float var7 = NumberConverter.a(var8 * var8 + var5 * var5) * 4.0F;
		if (var7 > 1.0F) {
			var7 = 1.0F;
		}

		this.az += (var7 - this.az) * 0.4F;
		this.aA += this.az;
	}

	public boolean j_() {
		return false;
	}
}
