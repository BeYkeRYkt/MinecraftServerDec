package net.minecraft;

class afb extends PathfinderGoal {

	private EntityGhast a;

	public afb(EntityGhast var1) {
		this.a = var1;
		this.a(2);
	}

	public boolean a() {
		return true;
	}

	public void e() {
		if (this.a.u() == null) {
			this.a.aG = this.a.yaw = -((float) Math.atan2(this.a.motionX, this.a.motionZ)) * 180.0F / 3.1415927F;
		} else {
			EntityLiving var1 = this.a.u();
			double var2 = 64.0D;
			if (var1.getDistanceSquared(this.a) < var2 * var2) {
				double var4 = var1.locationX - this.a.locationX;
				double var6 = var1.locationZ - this.a.locationZ;
				this.a.aG = this.a.yaw = -((float) Math.atan2(var4, var6)) * 180.0F / 3.1415927F;
			}
		}

	}
}
