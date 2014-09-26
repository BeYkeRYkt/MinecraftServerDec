package net.minecraft;

public class EntitySilverfish extends EntityMonster {

	private afv b;

	public EntitySilverfish(World var1) {
		super(var1);
		this.a(0.4F, 0.3F);
		this.i.a(1, new PathfinderGoalFloat(this));
		this.i.a(3, this.b = new afv(this));
		this.i.a(4, new zk(this, EntityHuman.class, 1.0D, false));
		this.i.a(5, new afu(this));
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
		this.a(afs.e).a(1.0D);
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

	public boolean receiveDamage(DamageSource var1, float var2) {
		if (this.ignoresDamageType(var1)) {
			return false;
		} else {
			if (var1 instanceof EntityDamageSource || var1 == DamageSource.MAGIC) {
				this.b.f();
			}

			return super.receiveDamage(var1, var2);
		}
	}

	protected void a(Position var1, Block var2) {
		this.a("mob.silverfish.step", 0.15F, 1.0F);
	}

	protected Item getLoot() {
		return null;
	}

	public void doTick() {
		this.aG = this.yaw;
		super.doTick();
	}

	public float a(Position var1) {
		return this.world.getBlockState(var1.getDown()).getBlock() == Blocks.STONE ? 10.0F : super.a(var1);
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
