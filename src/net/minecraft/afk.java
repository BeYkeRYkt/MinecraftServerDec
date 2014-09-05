package net.minecraft;

class afk extends yn {

	private EntityGuardian g;

	public afk(EntityGuardian var1) {
		super(var1);
		this.g = var1;
	}

	public void c() {
		if (this.f && !this.g.s().m()) {
			double var1 = this.b - this.g.locationX;
			double var3 = this.c - this.g.locationY;
			double var5 = this.d - this.g.locationZ;
			double var7 = var1 * var1 + var3 * var3 + var5 * var5;
			var7 = (double) DataTypesConverter.a(var7);
			var3 /= var7;
			float var9 = (float) (Math.atan2(var5, var1) * 180.0D / 3.1415927410125732D) - 90.0F;
			this.g.yaw = this.a(this.g.yaw, var9, 30.0F);
			this.g.aG = this.g.yaw;
			float var10 = (float) (this.e * this.g.a(afs.d).e());
			this.g.j(this.g.bH() + (var10 - this.g.bH()) * 0.125F);
			double var11 = Math.sin((double) (this.g.W + this.g.getId()) * 0.5D) * 0.05D;
			double var13 = Math.cos((double) (this.g.yaw * 3.1415927F / 180.0F));
			double var15 = Math.sin((double) (this.g.yaw * 3.1415927F / 180.0F));
			this.g.motionX += var11 * var13;
			this.g.motionZ += var11 * var15;
			var11 = Math.sin((double) (this.g.W + this.g.getId()) * 0.75D) * 0.05D;
			this.g.motionY += var11 * (var15 + var13) * 0.25D;
			this.g.motionY += (double) this.g.bH() * var3 * 0.1D;
			ym var17 = this.g.p();
			double var18 = this.g.locationX + var1 / var7 * 2.0D;
			double var20 = (double) this.g.aR() + this.g.locationY + var3 / var7 * 1.0D;
			double var22 = this.g.locationZ + var5 / var7 * 2.0D;
			double var24 = var17.e();
			double var26 = var17.f();
			double var28 = var17.g();
			if (!var17.b()) {
				var24 = var18;
				var26 = var20;
				var28 = var22;
			}

			this.g.p().a(var24 + (var18 - var24) * 0.125D, var26 + (var20 - var26) * 0.125D, var28 + (var22 - var28) * 0.125D, 10.0F, 40.0F);
			EntityGuardian.a(this.g, true);
		} else {
			this.g.j(0.0F);
			EntityGuardian.a(this.g, false);
		}
	}
}
