package net.minecraft;

class agc extends yn {

	private float g;
	private int h;
	private afy i;
	private boolean j;

	public agc(afy var1) {
		super(var1);
		this.i = var1;
	}

	public void a(float var1, boolean var2) {
		this.g = var1;
		this.j = var2;
	}

	public void a(double var1) {
		this.e = var1;
		this.f = true;
	}

	public void c() {
		this.a.yaw = this.a(this.a.yaw, this.g, 30.0F);
		this.a.aI = this.a.yaw;
		this.a.aG = this.a.yaw;
		if (!this.f) {
			this.a.m(0.0F);
		} else {
			this.f = false;
			if (this.a.C) {
				this.a.j((float) (this.e * this.a.a(afs.d).e()));
				if (this.h-- <= 0) {
					this.h = this.i.ce();
					if (this.j) {
						this.h /= 3;
					}

					this.i.r().a();
					if (this.i.cl()) {
						this.i.a(this.i.ci(), this.i.bA(), ((this.i.bb().nextFloat() - this.i.bb().nextFloat()) * 0.2F + 1.0F) * 0.8F);
					}
				} else {
					this.i.aX = this.i.aY = 0.0F;
					this.a.j(0.0F);
				}
			} else {
				this.a.j((float) (this.e * this.a.a(afs.d).e()));
			}

		}
	}
}
