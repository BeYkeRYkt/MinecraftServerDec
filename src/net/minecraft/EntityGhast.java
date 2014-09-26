package net.minecraft;

public class EntityGhast extends xl implements IMonster {

	private int a = 1;

	public EntityGhast(World var1) {
		super(var1);
		this.a(4.0F, 4.0F);
		this.fireProof = true;
		this.b_ = 5;
		this.f = new afc(this);
		this.i.a(5, new afe(this));
		this.i.a(7, new afb(this));
		this.i.a(7, new afd(this));
		this.bg.a(1, new aao(this));
	}

	public void a(boolean var1) {
		this.dataWatcher.b(16, Byte.valueOf((byte) (var1 ? 1 : 0)));
	}

	public int cd() {
		return this.a;
	}

	public void doTick() {
		super.doTick();
		if (!this.world.isStatic && this.world.getDifficulty() == Difficulty.PEACEFUL) {
			this.die();
		}

	}

	public boolean receiveDamage(DamageSource var1, float var2) {
		if (this.ignoresDamageType(var1)) {
			return false;
		} else if ("fireball".equals(var1.p()) && var1.getDamager() instanceof EntityHuman) {
			super.receiveDamage(var1, 1000.0F);
			((EntityHuman) var1.getDamager()).b((Statistic) AchievementList.z);
			return true;
		} else {
			return super.receiveDamage(var1, var2);
		}
	}

	protected void h() {
		super.h();
		this.dataWatcher.a(16, Byte.valueOf((byte) 0));
	}

	protected void aW() {
		super.aW();
		this.a(afs.a).a(10.0D);
		this.a(afs.b).a(100.0D);
	}

	protected String z() {
		return "mob.ghast.moan";
	}

	protected String bn() {
		return "mob.ghast.scream";
	}

	protected String bo() {
		return "mob.ghast.death";
	}

	protected Item getLoot() {
		return Items.GUNPOWDER;
	}

	protected void dropDeathLoot(boolean var1, int var2) {
		int var3 = this.random.nextInt(2) + this.random.nextInt(1 + var2);

		int var4;
		for (var4 = 0; var4 < var3; ++var4) {
			this.a(Items.GHAST_TEAR, 1);
		}

		var3 = this.random.nextInt(3) + this.random.nextInt(1 + var2);

		for (var4 = 0; var4 < var3; ++var4) {
			this.a(Items.GUNPOWDER, 1);
		}

	}

	protected float bA() {
		return 10.0F;
	}

	public boolean bQ() {
		return this.random.nextInt(20) == 0 && super.bQ() && this.world.getDifficulty() != Difficulty.PEACEFUL;
	}

	public int bU() {
		return 1;
	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.put("ExplosionPower", this.a);
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		if (var1.isTagAssignableFrom("ExplosionPower", 99)) {
			this.a = var1.getInt("ExplosionPower");
		}

	}

	public float getHeadHeight() {
		return 2.6F;
	}
}
