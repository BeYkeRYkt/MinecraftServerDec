package net.minecraft;

public class EntityEndermite extends EntityMonster {

	private int b = 0;
	private boolean c = false;

	public EntityEndermite(World var1) {
		super(var1);
		this.b_ = 3;
		this.a(0.4F, 0.3F);
		this.i.a(1, new PathfinderGoalFloat(this));
		this.i.a(2, new zk(this, EntityHuman.class, 1.0D, false));
		this.i.a(3, new PathfinderGoalRandomStroll(this, 1.0D));
		this.i.a(7, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
		this.i.a(8, new PathfinderGoalRandomLookaround(this));
		this.bg.a(1, new aal(this, true, new Class[0]));
		this.bg.a(2, new PathfinderGoalNearestAttackableTarget(this, EntityHuman.class, true));
	}

	public float getHeadHeight() {
		return 0.1F;
	}

	protected void aW() {
		super.aW();
		this.a(afs.a).a(8.0D);
		this.a(afs.d).a(0.25D);
		this.a(afs.e).a(2.0D);
	}

	protected boolean r_() {
		return false;
	}

	protected String z() {
		return "mob.silverfish.say";
	}

	protected String bn() {
		return "mob.silverfish.hit";
	}

	protected String bo() {
		return "mob.silverfish.kill";
	}

	protected void a(Position var1, Block var2) {
		this.a("mob.silverfish.step", 0.15F, 1.0F);
	}

	protected Item getLoot() {
		return null;
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		this.b = var1.getInt("Lifetime");
		this.c = var1.getBoolean("PlayerSpawned");
	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.put("Lifetime", this.b);
		var1.put("PlayerSpawned", this.c);
	}

	public void s_() {
		this.aG = this.yaw;
		super.s_();
	}

	public boolean n() {
		return this.c;
	}

	public void a(boolean var1) {
		this.c = var1;
	}

	public void m() {
		super.m();
		if (this.world.isStatic) {
			for (int var1 = 0; var1 < 2; ++var1) {
				this.world.addParticle(Particle.y, this.locationX + (this.random.nextDouble() - 0.5D) * (double) this.height, this.locationY + this.random.nextDouble() * (double) this.width, this.locationZ + (this.random.nextDouble() - 0.5D) * (double) this.height, (this.random.nextDouble() - 0.5D) * 2.0D, -this.random.nextDouble(), (this.random.nextDouble() - 0.5D) * 2.0D, new int[0]);
			}
		} else {
			if (!this.bY()) {
				++this.b;
			}

			if (this.b >= 2400) {
				this.die();
			}
		}

	}

	protected boolean m_() {
		return true;
	}

	public boolean bQ() {
		if (super.bQ()) {
			EntityHuman var1 = this.world.findNearbyPlayer(this, 5.0D);
			return var1 == null;
		} else {
			return false;
		}
	}

	public EnumMonsterType by() {
		return EnumMonsterType.c;
	}
}
