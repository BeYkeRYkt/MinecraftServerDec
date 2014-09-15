package net.minecraft;

public class EntitySnowman extends EntityGolem implements IRangedEntity {

	public EntitySnowman(World var1) {
		super(var1);
		this.a(0.7F, 1.9F);
		((aay) this.s()).a(true);
		this.i.a(1, new PathfinderGoalArrowAttack(this, 1.25D, 20, 10.0F));
		this.i.a(2, new PathfinderGoalRandomStroll(this, 1.0D));
		this.i.a(3, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 6.0F));
		this.i.a(4, new PathfinderGoalRandomLookaround(this));
		this.bg.a(1, new PathfinderGoalNearestAttackableTarget(this, EntityInsentient.class, 10, true, false, IMonster.d));
	}

	protected void aW() {
		super.aW();
		this.a(afs.a).a(4.0D);
		this.a(afs.d).a(0.20000000298023224D);
	}

	public void m() {
		super.m();
		if (!this.world.isStatic) {
			int var1 = MathHelper.toFixedPointInt(this.locationX);
			int var2 = MathHelper.toFixedPointInt(this.locationY);
			int var3 = MathHelper.toFixedPointInt(this.locationZ);
			if (this.U()) {
				this.damageEntity(DamageSource.DROWN, 1.0F);
			}

			if (this.world.b(new Position(var1, 0, var3)).a(new Position(var1, var2, var3)) > 1.0F) {
				this.damageEntity(DamageSource.BURN, 1.0F);
			}

			for (int var4 = 0; var4 < 4; ++var4) {
				var1 = MathHelper.toFixedPointInt(this.locationX + (double) ((float) (var4 % 2 * 2 - 1) * 0.25F));
				var2 = MathHelper.toFixedPointInt(this.locationY);
				var3 = MathHelper.toFixedPointInt(this.locationZ + (double) ((float) (var4 / 2 % 2 * 2 - 1) * 0.25F));
				if (this.world.getBlockState(new Position(var1, var2, var3)).getBlock().getMaterial() == Material.AIR && this.world.b(new Position(var1, 0, var3)).a(new Position(var1, var2, var3)) < 0.8F && Blocks.SNOW_LAYER.c(this.world, new Position(var1, var2, var3))) {
					this.world.a(new Position(var1, var2, var3), Blocks.SNOW_LAYER.getBlockState());
				}
			}
		}

	}

	protected Item getLoot() {
		return Items.SNOWBALL;
	}

	protected void dropDeathLoot(boolean var1, int var2) {
		int var3 = this.random.nextInt(16);

		for (int var4 = 0; var4 < var3; ++var4) {
			this.a(Items.SNOWBALL, 1);
		}

	}

	public void a(EntityLiving var1, float var2) {
		EntitySnowball var3 = new EntitySnowball(this.world, this);
		double var4 = var1.locationY + (double) var1.getHeadHeight() - 1.100000023841858D;
		double var6 = var1.locationX - this.locationX;
		double var8 = var4 - var3.locationY;
		double var10 = var1.locationZ - this.locationZ;
		float var12 = MathHelper.sqrt(var6 * var6 + var10 * var10) * 0.2F;
		var3.shoot(var6, var8 + (double) var12, var10, 1.6F, 12.0F);
		this.a("random.bow", 1.0F, 1.0F / (this.bb().nextFloat() * 0.4F + 0.8F));
		this.world.addEntity((Entity) var3);
	}

	public float getHeadHeight() {
		return 1.7F;
	}
}
