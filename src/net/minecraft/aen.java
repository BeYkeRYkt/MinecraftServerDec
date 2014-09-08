package net.minecraft;

class aen extends zb {

	private EntityBlaze a;
	private int b;
	private int c;

	public aen(EntityBlaze var1) {
		this.a = var1;
		this.a(3);
	}

	public boolean a() {
		EntityLiving var1 = this.a.u();
		return var1 != null && var1.isAlive();
	}

	public void c() {
		this.b = 0;
	}

	public void d() {
		this.a.a(false);
	}

	public void e() {
		--this.c;
		EntityLiving var1 = this.a.u();
		double var2 = this.a.getDistanceSquared(var1);
		if (var2 < 4.0D) {
			if (this.c <= 0) {
				this.c = 20;
				this.a.r(var1);
			}

			this.a.q().a(var1.locationX, var1.locationY, var1.locationZ, 1.0D);
		} else if (var2 < 256.0D) {
			double var4 = var1.locationX - this.a.locationX;
			double var6 = var1.aQ().minY + (double) (var1.K / 2.0F) - (this.a.locationY + (double) (this.a.K / 2.0F));
			double var8 = var1.locationZ - this.a.locationZ;
			if (this.c <= 0) {
				++this.b;
				if (this.b == 1) {
					this.c = 60;
					this.a.a(true);
				} else if (this.b <= 4) {
					this.c = 6;
				} else {
					this.c = 100;
					this.b = 0;
					this.a.a(false);
				}

				if (this.b > 1) {
					float var10 = DataTypesConverter.c(DataTypesConverter.a(var2)) * 0.5F;
					this.a.world.a((EntityHuman) null, 1009, new Position((int) this.a.locationX, (int) this.a.locationY, (int) this.a.locationZ), 0);

					for (int var11 = 0; var11 < 1; ++var11) {
						EntitySmallFireball var12 = new EntitySmallFireball(this.a.world, this.a, var4 + this.a.bb().nextGaussian() * (double) var10, var6, var8 + this.a.bb().nextGaussian() * (double) var10);
						var12.locationY = this.a.locationY + (double) (this.a.K / 2.0F) + 0.5D;
						this.a.world.d((Entity) var12);
					}
				}
			}

			this.a.p().a(var1, 10.0F, 10.0F);
		} else {
			this.a.s().n();
			this.a.q().a(var1.locationX, var1.locationY, var1.locationZ, 1.0D);
		}

		super.e();
	}
}
