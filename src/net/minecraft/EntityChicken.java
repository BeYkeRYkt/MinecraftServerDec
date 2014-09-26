package net.minecraft;

public class EntityChicken extends EntityAnimal {

	public float bk;
	public float bm;
	public float bn;
	public float bo;
	public float bp = 1.0F;
	public int bq;
	public boolean br;

	public EntityChicken(World var1) {
		super(var1);
		this.a(0.4F, 0.7F);
		this.bq = this.random.nextInt(6000) + 6000;
		this.i.a(0, new PathfinderGoalFloat(this));
		this.i.a(1, new zu(this, 1.4D));
		this.i.a(2, new yt(this, 1.0D));
		this.i.a(3, new aag(this, 1.0D, Items.WHEAT_SEEDS, false));
		this.i.a(4, new za(this, 1.1D));
		this.i.a(5, new PathfinderGoalRandomStroll(this, 1.0D));
		this.i.a(6, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 6.0F));
		this.i.a(7, new PathfinderGoalRandomLookaround(this));
	}

	public float getHeadHeight() {
		return this.width;
	}

	protected void aW() {
		super.aW();
		this.a(afs.a).a(4.0D);
		this.a(afs.d).a(0.25D);
	}

	public void m() {
		super.m();
		this.bo = this.bk;
		this.bn = this.bm;
		this.bm = (float) ((double) this.bm + (double) (this.onGround ? -1 : 4) * 0.3D);
		this.bm = MathHelper.a(this.bm, 0.0F, 1.0F);
		if (!this.onGround && this.bp < 1.0F) {
			this.bp = 1.0F;
		}

		this.bp = (float) ((double) this.bp * 0.9D);
		if (!this.onGround && this.motionY < 0.0D) {
			this.motionY *= 0.6D;
		}

		this.bk += this.bp * 2.0F;
		if (!this.world.isStatic && !this.i_() && !this.cj() && --this.bq <= 0) {
			this.a("mob.chicken.plop", 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
			this.a(Items.EGG, 1);
			this.bq = this.random.nextInt(6000) + 6000;
		}

	}

	public void e(float var1, float var2) {
	}

	protected String z() {
		return "mob.chicken.say";
	}

	protected String bn() {
		return "mob.chicken.hurt";
	}

	protected String bo() {
		return "mob.chicken.hurt";
	}

	protected void a(Position var1, Block var2) {
		this.a("mob.chicken.step", 0.15F, 1.0F);
	}

	protected Item getLoot() {
		return Items.FEATHER;
	}

	protected void dropDeathLoot(boolean var1, int var2) {
		int var3 = this.random.nextInt(3) + this.random.nextInt(1 + var2);

		for (int var4 = 0; var4 < var3; ++var4) {
			this.a(Items.FEATHER, 1);
		}

		if (this.au()) {
			this.a(Items.COOKED_CHICKEN, 1);
		} else {
			this.a(Items.CHICKEN, 1);
		}

	}

	public EntityChicken b(EntityAgeable var1) {
		return new EntityChicken(this.world);
	}

	public boolean d(ItemStack var1) {
		return var1 != null && var1.getItem() == Items.WHEAT_SEEDS;
	}

	public void readAdditionalData(NBTCompoundTag var1) {
		super.readAdditionalData(var1);
		this.br = var1.getBoolean("IsChickenJockey");
		if (var1.hasKey("EggLayTime")) {
			this.bq = var1.getInt("EggLayTime");
		}

	}

	protected int b(EntityHuman var1) {
		return this.cj() ? 10 : super.b(var1);
	}

	public void writeAdditionalData(NBTCompoundTag var1) {
		super.writeAdditionalData(var1);
		var1.put("IsChickenJockey", this.br);
		var1.put("EggLayTime", this.bq);
	}

	protected boolean C() {
		return this.cj() && this.passenger == null;
	}

	public void al() {
		super.al();
		float var1 = MathHelper.a(this.aG * 3.1415927F / 180.0F);
		float var2 = MathHelper.b(this.aG * 3.1415927F / 180.0F);
		float var3 = 0.1F;
		float var4 = 0.0F;
		this.passenger.b(this.locationX + (double) (var3 * var1), this.locationY + (double) (this.width * 0.5F) + this.passenger.am() + (double) var4, this.locationZ - (double) (var3 * var2));
		if (this.passenger instanceof EntityLiving) {
			((EntityLiving) this.passenger).aG = this.aG;
		}

	}

	public boolean cj() {
		return this.br;
	}

	public void l(boolean var1) {
		this.br = var1;
	}

	// $FF: synthetic method
	public EntityAgeable a(EntityAgeable var1) {
		return this.b(var1);
	}
}
