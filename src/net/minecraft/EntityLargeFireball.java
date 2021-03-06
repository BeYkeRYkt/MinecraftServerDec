package net.minecraft;

public class EntityLargeFireball extends EntityFireball {

	public int e = 1;

	public EntityLargeFireball(World var1) {
		super(var1);
	}

	public EntityLargeFireball(World var1, EntityLiving var2, double var3, double var5, double var7) {
		super(var1, var2, var3, var5, var7);
	}

	protected void a(MovingObjectPosition var1) {
		if (!this.world.isStatic) {
			if (var1.entity != null) {
				var1.entity.receiveDamage(DamageSource.fireball((EntityFireball) this, this.a), 6.0F);
				this.a(this.a, var1.entity);
			}

			boolean var2 = this.world.getGameRules().isGameRule("mobGriefing");
			this.world.createExplosion((Entity) null, this.locationX, this.locationY, this.locationZ, (float) this.e, var2, var2);
			this.die();
		}

	}

	public void writeAdditionalData(NBTCompoundTag var1) {
		super.writeAdditionalData(var1);
		var1.put("ExplosionPower", this.e);
	}

	public void readAdditionalData(NBTCompoundTag var1) {
		super.readAdditionalData(var1);
		if (var1.isTagAssignableFrom("ExplosionPower", 99)) {
			this.e = var1.getInt("ExplosionPower");
		}

	}
}
