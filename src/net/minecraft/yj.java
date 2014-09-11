package net.minecraft;

public class yj {

	private EntityLiving a;
	private int b;
	private float c;

	public yj(EntityLiving var1) {
		this.a = var1;
	}

	public void a() {
		double var1 = this.a.locationX - this.a.p;
		double var3 = this.a.locationZ - this.a.r;
		if (var1 * var1 + var3 * var3 > 2.500000277905201E-7D) {
			this.a.aG = this.a.yaw;
			this.a.headPitch = this.a(this.a.aG, this.a.headPitch, 75.0F);
			this.c = this.a.headPitch;
			this.b = 0;
		} else {
			float var5 = 75.0F;
			if (Math.abs(this.a.headPitch - this.c) > 15.0F) {
				this.b = 0;
				this.c = this.a.headPitch;
			} else {
				++this.b;
				boolean var6 = true;
				if (this.b > 10) {
					var5 = Math.max(1.0F - (float) (this.b - 10) / 10.0F, 0.0F) * 75.0F;
				}
			}

			this.a.aG = this.a(this.a.headPitch, this.a.aG, var5);
		}
	}

	private float a(float var1, float var2, float var3) {
		float var4 = MathHelper.g(var1 - var2);
		if (var4 < -var3) {
			var4 = -var3;
		}

		if (var4 >= var3) {
			var4 = var3;
		}

		return var1 - var4;
	}
}
