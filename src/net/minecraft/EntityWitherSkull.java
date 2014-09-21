package net.minecraft;

public class EntityWitherSkull extends EntityFireball {

	public EntityWitherSkull(World var1) {
		super(var1);
		this.a(0.3125F, 0.3125F);
	}

	public EntityWitherSkull(World var1, EntityLiving var2, double var3, double var5, double var7) {
		super(var1, var2, var3, var5, var7);
		this.a(0.3125F, 0.3125F);
	}

	protected float j() {
		return this.l() ? 0.73F : super.j();
	}

	public boolean au() {
		return false;
	}

	public float a(Explosion var1, World var2, Position var3, IBlockState var4) {
		float var5 = super.a(var1, var2, var3, var4);
		if (this.l() && var4.getBlock() != Blocks.BEDROCK && var4.getBlock() != Blocks.END_PORTAL && var4.getBlock() != Blocks.END_PORTAL_FRAME && var4.getBlock() != Blocks.COMMAND_BLOCK) {
			var5 = Math.min(0.8F, var5);
		}

		return var5;
	}

	protected void a(MovingObjectPosition var1) {
		if (!this.world.isStatic) {
			if (var1.entity != null) {
				if (this.a != null) {
					if (var1.entity.damageEntity(DamageSource.mobAttack(this.a), 8.0F)) {
						if (!var1.entity.isAlive()) {
							this.a.g(5.0F);
						} else {
							this.a(this.a, var1.entity);
						}
					}
				} else {
					var1.entity.damageEntity(DamageSource.MAGIC, 5.0F);
				}

				if (var1.entity instanceof EntityLiving) {
					byte var2 = 0;
					if (this.world.getDifficulty() == Difficulty.NORMAL) {
						var2 = 10;
					} else if (this.world.getDifficulty() == Difficulty.HARD) {
						var2 = 40;
					}

					if (var2 > 0) {
						((EntityLiving) var1.entity).c(new MobEffect(MobEffectList.WITHER.id, 20 * var2, 1));
					}
				}
			}

			this.world.a(this, this.locationX, this.locationY, this.locationZ, 1.0F, false, this.world.getGameRules().isGameRule("mobGriefing"));
			this.die();
		}

	}

	public boolean ad() {
		return false;
	}

	public boolean damageEntity(DamageSource var1, float var2) {
		return false;
	}

	protected void h() {
		this.dataWatcher.a(10, Byte.valueOf((byte) 0));
	}

	public boolean l() {
		return this.dataWatcher.a(10) == 1;
	}

	public void a(boolean var1) {
		this.dataWatcher.b(10, Byte.valueOf((byte) (var1 ? 1 : 0)));
	}
}
