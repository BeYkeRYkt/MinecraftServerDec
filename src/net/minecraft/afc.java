package net.minecraft;

class afc extends yn {

	private EntityGhast g;
	private int h;

	public afc(EntityGhast var1) {
		super(var1);
		this.g = var1;
	}

	public void c() {
		if (this.f) {
			double var1 = this.b - this.g.locationX;
			double var3 = this.c - this.g.locationY;
			double var5 = this.d - this.g.locationZ;
			double var7 = var1 * var1 + var3 * var3 + var5 * var5;
			if (this.h-- <= 0) {
				this.h += this.g.bb().nextInt(5) + 2;
				var7 = (double) DataTypesConverter.a(var7);
				if (this.b(this.b, this.c, this.d, var7)) {
					this.g.motionX += var1 / var7 * 0.1D;
					this.g.motionY += var3 / var7 * 0.1D;
					this.g.motionZ += var5 / var7 * 0.1D;
				} else {
					this.f = false;
				}
			}

		}
	}

	private boolean b(double var1, double var3, double var5, double var7) {
		double var9 = (var1 - this.g.locationX) / var7;
		double var11 = (var3 - this.g.locationY) / var7;
		double var13 = (var5 - this.g.locationZ) / var7;
		AxisAlignedBB var15 = this.g.aQ();

		for (int var16 = 1; (double) var16 < var7; ++var16) {
			var15 = var15.c(var9, var11, var13);
			if (!this.g.o.a((Entity) this.g, var15).isEmpty()) {
				return false;
			}
		}

		return true;
	}
}
