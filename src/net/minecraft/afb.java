package net.minecraft;

class afb extends zb {

	private afa a;

	public afb(afa var1) {
		this.a = var1;
		this.a(2);
	}

	public boolean a() {
		return true;
	}

	public void e() {
		if (this.a.u() == null) {
			this.a.aG = this.a.y = -((float) Math.atan2(this.a.v, this.a.x)) * 180.0F / 3.1415927F;
		} else {
			EntityLiving var1 = this.a.u();
			double var2 = 64.0D;
			if (var1.h(this.a) < var2 * var2) {
				double var4 = var1.s - this.a.s;
				double var6 = var1.u - this.a.u;
				this.a.aG = this.a.y = -((float) Math.atan2(var4, var6)) * 180.0F / 3.1415927F;
			}
		}

	}
}
