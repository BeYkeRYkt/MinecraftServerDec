package net.minecraft;

public class zg extends zb {

	EntityInsentient a;
	EntityLiving b;
	float c;

	public zg(EntityInsentient var1, float var2) {
		this.a = var1;
		this.c = var2;
		this.a(5);
	}

	public boolean a() {
		this.b = this.a.u();
		if (this.b == null) {
			return false;
		} else {
			double var1 = this.a.getDistanceSquared(this.b);
			return var1 >= 4.0D && var1 <= 16.0D ? (!this.a.onGround ? false : this.a.bb().nextInt(5) == 0) : false;
		}
	}

	public boolean b() {
		return !this.a.onGround;
	}

	public void c() {
		double var1 = this.b.locationX - this.a.locationX;
		double var3 = this.b.locationZ - this.a.locationZ;
		float var5 = MathHelper.a(var1 * var1 + var3 * var3);
		this.a.motionX += var1 / (double) var5 * 0.5D * 0.800000011920929D + this.a.motionX * 0.20000000298023224D;
		this.a.motionZ += var3 / (double) var5 * 0.5D * 0.800000011920929D + this.a.motionZ * 0.20000000298023224D;
		this.a.motionY = (double) this.c;
	}
}
