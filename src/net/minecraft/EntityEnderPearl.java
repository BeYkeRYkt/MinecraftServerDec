package net.minecraft;

public class EntityEnderPearl extends ahr {

	public EntityEnderPearl(World var1, EntityLiving var2) {
		super(var1, var2);
	}

	protected void a(MovingObjectPosition var1) {
		EntityLiving var2 = this.n();
		if (var1.entity != null) {
			var1.entity.a(DamageSource.a((Entity) this, var2), 0.0F);
		}

		for (int var3 = 0; var3 < 32; ++var3) {
			this.world.a(Particle.y, this.locationX, this.locationY + this.V.nextDouble() * 2.0D, this.locationZ, this.V.nextGaussian(), 0.0D, this.V.nextGaussian(), new int[0]);
		}

		if (!this.world.isStatic) {
			if (var2 instanceof EntityPlayer) {
				EntityPlayer var5 = (EntityPlayer) var2;
				if (var5.playerConncetion.getNetworkManager().isConnected() && var5.world == this.world && !var5.isSleeping()) {
					if (this.V.nextFloat() < 0.05F && this.world.Q().b("doMobSpawning")) {
						EntityEndermite var4 = new EntityEndermite(this.world);
						var4.a(true);
						var4.setPositionRotation(var2.locationX, var2.locationY, var2.locationZ, var2.yaw, var2.pitch);
						this.world.d((Entity) var4);
					}

					if (var2.av()) {
						var2.mount((Entity) null);
					}

					var2.updatePosition(this.locationX, this.locationY, this.locationZ);
					var2.O = 0.0F;
					var2.a(DamageSource.i, 5.0F);
				}
			}

			this.die();
		}

	}

	public void s_() {
		EntityLiving var1 = this.n();
		if (var1 != null && var1 instanceof EntityHuman && !var1.isAlive()) {
			this.die();
		} else {
			super.s_();
		}

	}
}
