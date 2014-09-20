package net.minecraft;

public class EntitySlime extends EntityInsentient implements IMonster {

	public float a;
	public float b;
	public float c;
	private boolean bi;

	public EntitySlime(World var1) {
		super(var1);
		this.f = new agc(this);
		this.i.a(1, new aga(this));
		this.i.a(2, new afz(this));
		this.i.a(3, new agd(this));
		this.i.a(5, new agb(this));
		this.bg.a(1, new aao(this));
		this.bg.a(3, new aam(this, EntityIronGolem.class));
	}

	protected void h() {
		super.h();
		this.dataWatcher.a(16, Byte.valueOf((byte) 1));
	}

	protected void a(int var1) {
		this.dataWatcher.b(16, Byte.valueOf((byte) var1));
		this.a(0.51000005F * (float) var1, 0.51000005F * (float) var1);
		this.b(this.locationX, this.locationY, this.locationZ);
		this.a(afs.a).a((double) (var1 * var1));
		this.a(afs.d).a((double) (0.2F + 0.1F * (float) var1));
		this.h(this.bt());
		this.b_ = var1;
	}

	public int ck() {
		return this.dataWatcher.a(16);
	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.put("Size", this.ck() - 1);
		var1.put("wasOnGround", this.bi);
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		int var2 = var1.getInt("Size");
		if (var2 < 0) {
			var2 = 0;
		}

		this.a(var2 + 1);
		this.bi = var1.getBoolean("wasOnGround");
	}

	protected Particle n() {
		return Particle.H;
	}

	protected String ci() {
		return "mob.slime." + (this.ck() > 1 ? "big" : "small");
	}

	public void s_() {
		if (!this.world.isStatic && this.world.getDifficulty() == Difficulty.PEACEFUL && this.ck() > 0) {
			this.dead = true;
		}

		this.b += (this.a - this.b) * 0.5F;
		this.c = this.b;
		super.s_();
		if (this.onGround && !this.bi) {
			int var1 = this.ck();

			for (int var2 = 0; var2 < var1 * 8; ++var2) {
				float var3 = this.random.nextFloat() * 3.1415927F * 2.0F;
				float var4 = this.random.nextFloat() * 0.5F + 0.5F;
				float var5 = MathHelper.a(var3) * (float) var1 * 0.5F * var4;
				float var6 = MathHelper.b(var3) * (float) var1 * 0.5F * var4;
				World var10000 = this.world;
				Particle var10001 = this.n();
				double var10002 = this.locationX + (double) var5;
				double var10004 = this.locationZ + (double) var6;
				var10000.addParticle(var10001, var10002, this.getBoundingBox().minY, var10004, 0.0D, 0.0D, 0.0D, new int[0]);
			}

			if (this.cj()) {
				this.a(this.ci(), this.bA(), ((this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F) / 0.8F);
			}

			this.a = -0.5F;
		} else if (!this.onGround && this.bi) {
			this.a = 1.0F;
		}

		this.bi = this.onGround;
		this.cf();
	}

	protected void cf() {
		this.a *= 0.6F;
	}

	protected int ce() {
		return this.random.nextInt(20) + 10;
	}

	protected EntitySlime cd() {
		return new EntitySlime(this.world);
	}

	public void i(int var1) {
		if (var1 == 16) {
			int var2 = this.ck();
			this.a(0.51000005F * (float) var2, 0.51000005F * (float) var2);
			this.yaw = this.headPitch;
			this.aG = this.headPitch;
			if (this.V() && this.random.nextInt(20) == 0) {
				this.X();
			}
		}

		super.i(var1);
	}

	public void die() {
		int var1 = this.ck();
		if (!this.world.isStatic && var1 > 1 && this.getHealth() <= 0.0F) {
			int var2 = 2 + this.random.nextInt(3);

			for (int var3 = 0; var3 < var2; ++var3) {
				float var4 = ((float) (var3 % 2) - 0.5F) * (float) var1 / 4.0F;
				float var5 = ((float) (var3 / 2) - 0.5F) * (float) var1 / 4.0F;
				EntitySlime var6 = this.cd();
				if (this.hasCustomName()) {
					var6.a(this.getCustomName());
				}

				if (this.bY()) {
					var6.bW();
				}

				var6.a(var1 / 2);
				var6.setPositionRotation(this.locationX + (double) var4, this.locationY + 0.5D, this.locationZ + (double) var5, this.random.nextFloat() * 360.0F, 0.0F);
				this.world.addEntity((Entity) var6);
			}
		}

		super.die();
	}

	public void i(Entity var1) {
		super.i(var1);
		if (var1 instanceof EntityIronGolem && this.cg()) {
			this.e((EntityLiving) var1);
		}

	}

	public void d(EntityHuman var1) {
		if (this.cg()) {
			this.e(var1);
		}

	}

	protected void e(EntityLiving var1) {
		int var2 = this.ck();
		if (this.t(var1) && this.getDistanceSquared(var1) < 0.6D * (double) var2 * 0.6D * (double) var2 && var1.damageEntity(DamageSource.mobAttack((EntityLiving) this), (float) this.ch())) {
			this.a("mob.attack", 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
			this.a(this, var1);
		}

	}

	public float getHeadHeight() {
		return 0.625F * this.width;
	}

	protected boolean cg() {
		return this.ck() > 1;
	}

	protected int ch() {
		return this.ck();
	}

	protected String bn() {
		return "mob.slime." + (this.ck() > 1 ? "big" : "small");
	}

	protected String bo() {
		return "mob.slime." + (this.ck() > 1 ? "big" : "small");
	}

	protected Item getLoot() {
		return this.ck() == 1 ? Items.SLIME_BALL : null;
	}

	public boolean bQ() {
		Chunk var1 = this.world.getChunk(new Position(MathHelper.toFixedPointInt(this.locationX), 0, MathHelper.toFixedPointInt(this.locationZ)));
		if (this.world.getWorldData().getLevelType() == LevelType.FLAT && this.random.nextInt(4) != 1) {
			return false;
		} else {
			if (this.world.getDifficulty() != Difficulty.PEACEFUL) {
				BiomeBase var2 = this.world.b(new Position(MathHelper.toFixedPointInt(this.locationX), 0, MathHelper.toFixedPointInt(this.locationZ)));
				if (var2 == BiomeBase.SWAMPLAND && this.locationY > 50.0D && this.locationY < 70.0D && this.random.nextFloat() < 0.5F && this.random.nextFloat() < this.world.y() && this.world.getLightLevel(new Position(this)) <= this.random.nextInt(8)) {
					return super.bQ();
				}

				if (this.random.nextInt(10) == 0 && var1.a(987234911L).nextInt(10) == 0 && this.locationY < 40.0D) {
					return super.bQ();
				}
			}

			return false;
		}
	}

	protected float bA() {
		return 0.4F * (float) this.ck();
	}

	public int bP() {
		return 0;
	}

	protected boolean cl() {
		return this.ck() > 0;
	}

	protected boolean cj() {
		return this.ck() > 2;
	}

	protected void jump() {
		this.motionY = 0.41999998688697815D;
		this.ai = true;
	}

	public xq a(vu var1, xq var2) {
		int var3 = this.random.nextInt(3);
		if (var3 < 2 && this.random.nextFloat() < 0.5F * var1.c()) {
			++var3;
		}

		int var4 = 1 << var3;
		this.a(var4);
		return super.a(var1, var2);
	}
}
