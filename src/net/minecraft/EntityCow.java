package net.minecraft;

public class EntityCow extends EntityAnimal {

	public EntityCow(World var1) {
		super(var1);
		this.a(0.9F, 1.3F);
		((aay) this.s()).a(true);
		this.i.a(0, new PathfinderGoalFloat(this));
		this.i.a(1, new zu(this, 2.0D));
		this.i.a(2, new yt(this, 1.0D));
		this.i.a(3, new aag(this, 1.25D, Items.WHEAT, false));
		this.i.a(4, new za(this, 1.25D));
		this.i.a(5, new PathfinderGoalRandomStroll(this, 1.0D));
		this.i.a(6, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 6.0F));
		this.i.a(7, new PathfinderGoalRandomLookaround(this));
	}

	protected void aW() {
		super.aW();
		this.a(afs.a).a(10.0D);
		this.a(afs.d).a(0.20000000298023224D);
	}

	protected String z() {
		return "mob.cow.say";
	}

	protected String bn() {
		return "mob.cow.hurt";
	}

	protected String bo() {
		return "mob.cow.hurt";
	}

	protected void a(Position var1, Block var2) {
		this.a("mob.cow.step", 0.15F, 1.0F);
	}

	protected float bA() {
		return 0.4F;
	}

	protected Item getLoot() {
		return Items.LEATHER;
	}

	protected void dropDeathLoot(boolean var1, int var2) {
		int var3 = this.random.nextInt(3) + this.random.nextInt(1 + var2);

		int var4;
		for (var4 = 0; var4 < var3; ++var4) {
			this.a(Items.LEATHER, 1);
		}

		var3 = this.random.nextInt(3) + 1 + this.random.nextInt(1 + var2);

		for (var4 = 0; var4 < var3; ++var4) {
			if (this.au()) {
				this.a(Items.COOKED_BEEF, 1);
			} else {
				this.a(Items.BEEF, 1);
			}
		}

	}

	public boolean a(EntityHuman var1) {
		ItemStack var2 = var1.playerInventory.getItemInHand();
		if (var2 != null && var2.getItem() == Items.BUCKET && !var1.playerProperties.instabuild) {
			if (var2.amount-- == 1) {
				var1.playerInventory.setItem(var1.playerInventory.itemInHandIndex, new ItemStack(Items.MILK_BUCKET));
			} else if (!var1.playerInventory.pickup(new ItemStack(Items.MILK_BUCKET))) {
				var1.dropItem(new ItemStack(Items.MILK_BUCKET, 1, 0), false);
			}

			return true;
		} else {
			return super.a(var1);
		}
	}

	public EntityCow b(EntityAgeable var1) {
		return new EntityCow(this.world);
	}

	public float getHeadHeight() {
		return this.width;
	}

	// $FF: synthetic method
	public EntityAgeable a(EntityAgeable var1) {
		return this.b(var1);
	}
}
