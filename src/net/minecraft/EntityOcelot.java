package net.minecraft;

import com.google.common.base.Predicate;

public class EntityOcelot extends xx {

	private PathfinderGoalAvoidEntity bm;
	private aag bn;

	public EntityOcelot(World var1) {
		super(var1);
		this.a(0.6F, 0.7F);
		((aay) this.s()).a(true);
		this.i.a(1, new PathfinderGoalFloat(this));
		this.i.a(2, this.bk);
		this.i.a(3, this.bn = new aag(this, 0.6D, Items.FISH, true));
		this.i.a(5, new yz(this, 1.0D, 10.0F, 5.0F));
		this.i.a(6, new zr(this, 0.8D));
		this.i.a(7, new zg(this, 0.3F));
		this.i.a(8, new zq(this));
		this.i.a(9, new yt(this, 0.8D));
		this.i.a(10, new PathfinderGoalRandomStroll(this, 0.8D));
		this.i.a(11, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 10.0F));
		this.bg.a(1, new aat(this, EntityChicken.class, false, (Predicate) null));
	}

	protected void h() {
		super.h();
		this.dataWatcher.a(18, Byte.valueOf((byte) 0));
	}

	public void E() {
		if (this.q().a()) {
			double var1 = this.q().b();
			if (var1 == 0.6D) {
				this.setSneaking(true);
				this.setSprinting(false);
			} else if (var1 == 1.33D) {
				this.setSneaking(false);
				this.setSprinting(true);
			} else {
				this.setSneaking(false);
				this.setSprinting(false);
			}
		} else {
			this.setSneaking(false);
			this.setSprinting(false);
		}

	}

	protected boolean C() {
		return !this.cj() && this.ticksLived > 2400;
	}

	protected void aW() {
		super.aW();
		this.a(afs.a).a(10.0D);
		this.a(afs.d).a(0.30000001192092896D);
	}

	public void e(float var1, float var2) {
	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.put("CatType", this.cr());
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		this.r(var1.getInt("CatType"));
	}

	protected String z() {
		return this.cj() ? (this.cp() ? "mob.cat.purr" : (this.random.nextInt(4) == 0 ? "mob.cat.purreow" : "mob.cat.meow")) : "";
	}

	protected String bn() {
		return "mob.cat.hitt";
	}

	protected String bo() {
		return "mob.cat.hitt";
	}

	protected float bA() {
		return 0.4F;
	}

	protected Item getLoot() {
		return Items.LEATHER;
	}

	public boolean r(Entity var1) {
		return var1.receiveDamage(DamageSource.mobAttack((EntityLiving) this), 3.0F);
	}

	public boolean receiveDamage(DamageSource var1, float var2) {
		if (this.ignoresDamageType(var1)) {
			return false;
		} else {
			this.bk.a(false);
			return super.receiveDamage(var1, var2);
		}
	}

	protected void dropDeathLoot(boolean var1, int var2) {
	}

	public boolean a(EntityHuman var1) {
		ItemStack var2 = var1.playerInventory.getItemInHand();
		if (this.cj()) {
			if (this.e(var1) && !this.world.isStatic && !this.d(var2)) {
				this.bk.a(!this.cl());
			}
		} else if (this.bn.f() && var2 != null && var2.getItem() == Items.FISH && var1.getDistanceSquared(this) < 9.0D) {
			if (!var1.playerProperties.instabuild) {
				--var2.amount;
			}

			if (var2.amount <= 0) {
				var1.playerInventory.setItem(var1.playerInventory.itemInHandIndex, (ItemStack) null);
			}

			if (!this.world.isStatic) {
				if (this.random.nextInt(3) == 0) {
					this.m(true);
					this.r(1 + this.world.random.nextInt(3));
					this.b(var1.getUUID().toString());
					this.l(true);
					this.bk.a(true);
					this.world.broadcastEntityEffect((Entity) this, (byte) 7);
				} else {
					this.l(false);
					this.world.broadcastEntityEffect((Entity) this, (byte) 6);
				}
			}

			return true;
		}

		return super.a(var1);
	}

	public EntityOcelot b(EntityAgeable var1) {
		EntityOcelot var2 = new EntityOcelot(this.world);
		if (this.cj()) {
			var2.b(this.b());
			var2.m(true);
			var2.r(this.cr());
		}

		return var2;
	}

	public boolean d(ItemStack var1) {
		return var1 != null && var1.getItem() == Items.FISH;
	}

	public boolean a(EntityAnimal var1) {
		if (var1 == this) {
			return false;
		} else if (!this.cj()) {
			return false;
		} else if (!(var1 instanceof EntityOcelot)) {
			return false;
		} else {
			EntityOcelot var2 = (EntityOcelot) var1;
			return !var2.cj() ? false : this.cp() && var2.cp();
		}
	}

	public int cr() {
		return this.dataWatcher.a(18);
	}

	public void r(int var1) {
		this.dataWatcher.b(18, Byte.valueOf((byte) var1));
	}

	public boolean bQ() {
		return this.world.random.nextInt(3) != 0;
	}

	public boolean bR() {
		if (this.world.a(this.getBoundingBox(), (Entity) this) && this.world.getCubes((Entity) this, this.getBoundingBox()).isEmpty() && !this.world.d(this.getBoundingBox())) {
			Position var1 = new Position(this.locationX, this.getBoundingBox().minY, this.locationZ);
			if (var1.getY() < 63) {
				return false;
			}

			Block var2 = this.world.getBlockState(var1.getDown()).getBlock();
			if (var2 == Blocks.GRASS || var2.getMaterial() == Material.LEAVES) {
				return true;
			}
		}

		return false;
	}

	public String getName() {
		return this.hasCustomName() ? this.getCustomName() : (this.cj() ? LocaleI18n.get("entity.Cat.name") : super.getName());
	}

	public void m(boolean var1) {
		super.m(var1);
	}

	protected void ck() {
		if (this.bm == null) {
			this.bm = new PathfinderGoalAvoidEntity(this, new abz(this), 16.0F, 0.8D, 1.33D);
		}

		this.i.a((PathfinderGoal) this.bm);
		if (!this.cj()) {
			this.i.a(4, this.bm);
		}

	}

	public xq a(vu var1, xq var2) {
		var2 = super.a(var1, var2);
		if (this.world.random.nextInt(7) == 0) {
			for (int var3 = 0; var3 < 2; ++var3) {
				EntityOcelot var4 = new EntityOcelot(this.world);
				var4.setPositionRotation(this.locationX, this.locationY, this.locationZ, this.yaw, 0.0F);
				var4.b(-24000);
				this.world.addEntity((Entity) var4);
			}
		}

		return var2;
	}

	// $FF: synthetic method
	public EntityAgeable a(EntityAgeable var1) {
		return this.b(var1);
	}
}
