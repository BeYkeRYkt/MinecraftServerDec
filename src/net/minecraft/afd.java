package net.minecraft;

class afd extends PathfinderGoal {

	private EntityGhast b;
	public int a;

	public afd(EntityGhast var1) {
		this.b = var1;
	}

	public boolean a() {
		return this.b.u() != null;
	}

	public void c() {
		this.a = 0;
	}

	public void d() {
		this.b.a(false);
	}

	public void e() {
		EntityLiving var1 = this.b.u();
		double var2 = 64.0D;
		if (var1.getDistanceSquared(this.b) < var2 * var2 && this.b.t(var1)) {
			World var4 = this.b.world;
			++this.a;
			if (this.a == 10) {
				var4.a((EntityHuman) null, 1007, new Position(this.b), 0);
			}

			if (this.a == 20) {
				double var5 = 4.0D;
				Vec3D var7 = this.b.d(1.0F);
				double var8 = var1.locationX - (this.b.locationX + var7.x * var5);
				double var10 = var1.getBoundingBox().minY + (double) (var1.width / 2.0F) - (0.5D + this.b.locationY + (double) (this.b.width / 2.0F));
				double var12 = var1.locationZ - (this.b.locationZ + var7.z * var5);
				var4.a((EntityHuman) null, 1008, new Position(this.b), 0);
				EntityLargeFireball var14 = new EntityLargeFireball(var4, this.b, var8, var10, var12);
				var14.e = this.b.cd();
				var14.locationX = this.b.locationX + var7.x * var5;
				var14.locationY = this.b.locationY + (double) (this.b.width / 2.0F) + 0.5D;
				var14.locationZ = this.b.locationZ + var7.z * var5;
				var4.addEntity((Entity) var14);
				this.a = -40;
			}
		} else if (this.a > 0) {
			--this.a;
		}

		this.b.a(this.a > 10);
	}
}
