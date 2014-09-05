package net.minecraft;

public abstract class xl extends EntityInsentient {

	public xl(World var1) {
		super(var1);
	}

	public void e(float var1, float var2) {
	}

	protected void a(double var1, boolean var3, Block var4, Position var5) {
	}

	public void g(float var1, float var2) {
		if (this.V()) {
			this.a(var1, var2, 0.02F);
			this.d(this.motionX, this.motionY, this.motionZ);
			this.motionX *= 0.800000011920929D;
			this.motionY *= 0.800000011920929D;
			this.motionZ *= 0.800000011920929D;
		} else if (this.ab()) {
			this.a(var1, var2, 0.02F);
			this.d(this.motionX, this.motionY, this.motionZ);
			this.motionX *= 0.5D;
			this.motionY *= 0.5D;
			this.motionZ *= 0.5D;
		} else {
			float var3 = 0.91F;
			if (this.onGround) {
				var3 = this.o.p(new Position(DataTypesConverter.toFixedPointInt(this.locationX), DataTypesConverter.toFixedPointInt(this.aQ().b) - 1, DataTypesConverter.toFixedPointInt(this.locationZ))).c().K * 0.91F;
			}

			float var4 = 0.16277136F / (var3 * var3 * var3);
			this.a(var1, var2, this.onGround ? 0.1F * var4 : 0.02F);
			var3 = 0.91F;
			if (this.onGround) {
				var3 = this.o.p(new Position(DataTypesConverter.toFixedPointInt(this.locationX), DataTypesConverter.toFixedPointInt(this.aQ().b) - 1, DataTypesConverter.toFixedPointInt(this.locationZ))).c().K * 0.91F;
			}

			this.d(this.motionX, this.motionY, this.motionZ);
			this.motionX *= (double) var3;
			this.motionY *= (double) var3;
			this.motionZ *= (double) var3;
		}

		this.ay = this.az;
		double var8 = this.locationX - this.p;
		double var5 = this.locationZ - this.r;
		float var7 = DataTypesConverter.a(var8 * var8 + var5 * var5) * 4.0F;
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
