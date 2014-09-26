package net.minecraft;

public class EntitySpider extends EntityMonster {

	public EntitySpider(World var1) {
		super(var1);
		this.a(1.4F, 0.9F);
		this.i.a(1, new PathfinderGoalFloat(this));
		this.i.a(2, this.a);
		this.i.a(3, new zg(this, 0.4F));
		this.i.a(4, new agf(this, EntityHuman.class));
		this.i.a(4, new agf(this, EntityIronGolem.class));
		this.i.a(5, new PathfinderGoalRandomStroll(this, 0.8D));
		this.i.a(6, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
		this.i.a(6, new PathfinderGoalRandomLookaround(this));
		this.bg.a(1, new aal(this, false, new Class[0]));
		this.bg.a(2, new agh(this, EntityHuman.class));
		this.bg.a(3, new agh(this, EntityIronGolem.class));
	}

	protected aaz b(World var1) {
		return new aba(this, var1);
	}

	protected void h() {
		super.h();
		this.dataWatcher.a(16, new Byte((byte) 0));
	}

	public void doTick() {
		super.doTick();
		if (!this.world.isStatic) {
			this.a(this.positionChanged);
		}

	}

	protected void aW() {
		super.aW();
		this.a(afs.a).a(16.0D);
		this.a(afs.d).a(0.30000001192092896D);
	}

	protected String z() {
		return "mob.spider.say";
	}

	protected String bn() {
		return "mob.spider.say";
	}

	protected String bo() {
		return "mob.spider.death";
	}

	protected void a(Position var1, Block var2) {
		this.a("mob.spider.step", 0.15F, 1.0F);
	}

	protected Item getLoot() {
		return Items.STRING;
	}

	protected void dropDeathLoot(boolean var1, int var2) {
		super.dropDeathLoot(var1, var2);
		if (var1 && (this.random.nextInt(3) == 0 || this.random.nextInt(1 + var2) > 0)) {
			this.a(Items.SPIDER_EYE, 1);
		}

	}

	public boolean j_() {
		return this.n();
	}

	public void aB() {
	}

	public EnumMonsterType by() {
		return EnumMonsterType.c;
	}

	public boolean d(MobEffect var1) {
		return var1.getId() == MobEffectList.POISON.id ? false : super.d(var1);
	}

	public boolean n() {
		return (this.dataWatcher.a(16) & 1) != 0;
	}

	public void a(boolean var1) {
		byte var2 = this.dataWatcher.a(16);
		if (var1) {
			var2 = (byte) (var2 | 1);
		} else {
			var2 &= -2;
		}

		this.dataWatcher.b(16, Byte.valueOf(var2));
	}

	public xq a(vu var1, xq var2) {
		Object var4 = super.a(var1, var2);
		if (this.world.random.nextInt(100) == 0) {
			EntitySkeleton var3 = new EntitySkeleton(this.world);
			var3.setPositionRotation(this.locationX, this.locationY, this.locationZ, this.yaw, 0.0F);
			var3.a(var1, (xq) null);
			this.world.addEntity((Entity) var3);
			var3.mount((Entity) this);
		}

		if (var4 == null) {
			var4 = new agg();
			if (this.world.getDifficulty() == Difficulty.HARD && this.world.random.nextFloat() < 0.1F * var1.c()) {
				((agg) var4).a(this.world.random);
			}
		}

		if (var4 instanceof agg) {
			int var5 = ((agg) var4).a;
			if (var5 > 0 && MobEffectList.byId[var5] != null) {
				this.c(new MobEffect(var5, Integer.MAX_VALUE));
			}
		}

		return (xq) var4;
	}

	public float getHeadHeight() {
		return 0.65F;
	}
}
