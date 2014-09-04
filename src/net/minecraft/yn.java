package net.minecraft;

public class yn {

	protected xn a;
	protected double b;
	protected double c;
	protected double d;
	protected double e;
	protected boolean f;

	public yn(xn var1) {
		this.a = var1;
		this.b = var1.s;
		this.c = var1.t;
		this.d = var1.u;
	}

	public boolean a() {
		return this.f;
	}

	public double b() {
		return this.e;
	}

	public void a(double var1, double var3, double var5, double var7) {
		this.b = var1;
		this.c = var3;
		this.d = var5;
		this.e = var7;
		this.f = true;
	}

	public void c() {
		this.a.m(0.0F);
		if (this.f) {
			this.f = false;
			int var1 = uv.c(this.a.aQ().b + 0.5D);
			double var2 = this.b - this.a.s;
			double var4 = this.d - this.a.u;
			double var6 = this.c - (double) var1;
			double var8 = var2 * var2 + var6 * var6 + var4 * var4;
			if (var8 >= 2.500000277905201E-7D) {
				float var10 = (float) (Math.atan2(var4, var2) * 180.0D / 3.1415927410125732D) - 90.0F;
				this.a.y = this.a(this.a.y, var10, 30.0F);
				this.a.j((float) (this.e * this.a.a(afs.d).e()));
				if (var6 > 0.0D && var2 * var2 + var4 * var4 < 1.0D) {
					this.a.r().a();
				}

			}
		}
	}

	protected float a(float var1, float var2, float var3) {
		float var4 = uv.g(var2 - var1);
		if (var4 > var3) {
			var4 = var3;
		}

		if (var4 < -var3) {
			var4 = -var3;
		}

		float var5 = var1 + var4;
		if (var5 < 0.0F) {
			var5 += 360.0F;
		} else if (var5 > 360.0F) {
			var5 -= 360.0F;
		}

		return var5;
	}

	public double d() {
		return this.b;
	}

	public double e() {
		return this.c;
	}

	public double f() {
		return this.d;
	}
}
