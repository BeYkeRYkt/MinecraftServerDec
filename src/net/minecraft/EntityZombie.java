package net.minecraft;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class EntityZombie extends EntityMonster {

	protected static final xy b = (new yg((xy) null, "zombie.spawnReinforcements", 0.0D, 0.0D, 1.0D)).a("Spawn Reinforcements Chance");
	private static final UUID c = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");
	private static final AttributeModifier bk = new AttributeModifier(c, "Baby speed boost", 0.5D, 1);
	private final ys bl = new ys(this);
	private int bm;
	private boolean bn = false;
	private float bo = -1.0F;
	private float bp;

	public EntityZombie(World var1) {
		super(var1);
		((aay) this.s()).b(true);
		this.i.a(0, new PathfinderGoalFloat(this));
		this.i.a(2, new zk(this, EntityHuman.class, 1.0D, false));
		this.i.a(2, this.a);
		this.i.a(5, new PathfinderGoalMoveTowardsRestriction(this, 1.0D));
		this.i.a(7, new PathfinderGoalRandomStroll(this, 1.0D));
		this.i.a(8, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
		this.i.a(8, new PathfinderGoalRandomLookaround(this));
		this.n();
		this.a(0.6F, 1.95F);
	}

	protected void n() {
		this.i.a(4, new zk(this, EntityVillager.class, 1.0D, true));
		this.i.a(4, new zk(this, EntityIronGolem.class, 1.0D, true));
		this.i.a(6, new zm(this, 1.0D, false));
		this.bg.a(1, new aal(this, true, new Class[] { EntityPigZombie.class }));
		this.bg.a(2, new PathfinderGoalNearestAttackableTarget(this, EntityHuman.class, true));
		this.bg.a(2, new PathfinderGoalNearestAttackableTarget(this, EntityVillager.class, false));
		this.bg.a(2, new PathfinderGoalNearestAttackableTarget(this, EntityIronGolem.class, true));
	}

	protected void aW() {
		super.aW();
		this.a(afs.b).a(35.0D);
		this.a(afs.d).a(0.23000000417232513D);
		this.a(afs.e).a(3.0D);
		this.bx().b(b).a(this.random.nextDouble() * 0.10000000149011612D);
	}

	protected void h() {
		super.h();
		this.getDataWatcher().a(12, Byte.valueOf((byte) 0));
		this.getDataWatcher().a(13, Byte.valueOf((byte) 0));
		this.getDataWatcher().a(14, Byte.valueOf((byte) 0));
	}

	public int bq() {
		int var1 = super.bq() + 2;
		if (var1 > 20) {
			var1 = 20;
		}

		return var1;
	}

	public boolean cl() {
		return this.bn;
	}

	public void a(boolean var1) {
		if (this.bn != var1) {
			this.bn = var1;
			if (var1) {
				this.i.a(1, this.bl);
			} else {
				this.i.a((PathfinderGoal) this.bl);
			}
		}

	}

	public boolean i_() {
		return this.getDataWatcher().a(12) == 1;
	}

	protected int b(EntityHuman var1) {
		if (this.i_()) {
			this.b_ = (int) ((float) this.b_ * 2.5F);
		}

		return super.b(var1);
	}

	public void l(boolean var1) {
		this.getDataWatcher().b(12, Byte.valueOf((byte) (var1 ? 1 : 0)));
		if (this.world != null && !this.world.isStatic) {
			AttributeInstance var2 = this.a(afs.d);
			var2.c(bk);
			if (var1) {
				var2.b(bk);
			}
		}

		this.n(var1);
	}

	public boolean cm() {
		return this.getDataWatcher().a(13) == 1;
	}

	public void m(boolean var1) {
		this.getDataWatcher().b(13, Byte.valueOf((byte) (var1 ? 1 : 0)));
	}

	public void m() {
		if (this.world.w() && !this.world.isStatic && !this.i_()) {
			float var1 = this.c(1.0F);
			Position var2 = new Position(this.locationX, (double) Math.round(this.locationY), this.locationZ);
			if (var1 > 0.5F && this.random.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F && this.world.i(var2)) {
				boolean var3 = true;
				ItemStack var4 = this.p(4);
				if (var4 != null) {
					if (var4.e()) {
						var4.setWearout(var4.getWearout() + this.random.nextInt(2));
						if (var4.getWearout() >= var4.getMaxWearout()) {
							this.b(var4);
							this.setArmor(4, (ItemStack) null);
						}
					}

					var3 = false;
				}

				if (var3) {
					this.e(8);
				}
			}
		}

		if (this.av() && this.u() != null && this.vehicle instanceof EntityChicken) {
			((EntityInsentient) this.vehicle).s().a(this.s().j(), 1.5D);
		}

		super.m();
	}

	public boolean receiveDamage(DamageSource var1, float var2) {
		if (super.receiveDamage(var1, var2)) {
			EntityLiving var3 = this.u();
			if (var3 == null && var1.getDamager() instanceof EntityLiving) {
				var3 = (EntityLiving) var1.getDamager();
			}

			if (var3 != null && this.world.getDifficulty() == Difficulty.HARD && (double) this.random.nextFloat() < this.a(b).e()) {
				int var4 = MathHelper.toFixedPointInt(this.locationX);
				int var5 = MathHelper.toFixedPointInt(this.locationY);
				int var6 = MathHelper.toFixedPointInt(this.locationZ);
				EntityZombie var7 = new EntityZombie(this.world);

				for (int var8 = 0; var8 < 50; ++var8) {
					int var9 = var4 + MathHelper.a(this.random, 7, 40) * MathHelper.a(this.random, -1, 1);
					int var10 = var5 + MathHelper.a(this.random, 7, 40) * MathHelper.a(this.random, -1, 1);
					int var11 = var6 + MathHelper.a(this.random, 7, 40) * MathHelper.a(this.random, -1, 1);
					if (World.a((ard) this.world, new Position(var9, var10 - 1, var11)) && this.world.getLightLevel(new Position(var9, var10, var11)) < 10) {
						var7.b((double) var9, (double) var10, (double) var11);
						if (!this.world.hasNearbyPlayer((double) var9, (double) var10, (double) var11, 7.0D) && this.world.a(var7.getBoundingBox(), (Entity) var7) && this.world.getCubes((Entity) var7, var7.getBoundingBox()).isEmpty() && !this.world.d(var7.getBoundingBox())) {
							this.world.addEntity((Entity) var7);
							var7.d(var3);
							var7.a(this.world.E(new Position(var7)), (xq) null);
							this.a(b).b(new AttributeModifier("Zombie reinforcement caller charge", -0.05000000074505806D, 0));
							var7.a(b).b(new AttributeModifier("Zombie reinforcement callee charge", -0.05000000074505806D, 0));
							break;
						}
					}
				}
			}

			return true;
		} else {
			return false;
		}
	}

	public void doTick() {
		if (!this.world.isStatic && this.cn()) {
			int var1 = this.cp();
			this.bm -= var1;
			if (this.bm <= 0) {
				this.co();
			}
		}

		super.doTick();
	}

	public boolean r(Entity var1) {
		boolean var2 = super.r(var1);
		if (var2) {
			int var3 = this.world.getDifficulty().getId();
			if (this.getItemInHand() == null && this.au() && this.random.nextFloat() < (float) var3 * 0.3F) {
				var1.e(2 * var3);
			}
		}

		return var2;
	}

	protected String z() {
		return "mob.zombie.say";
	}

	protected String bn() {
		return "mob.zombie.hurt";
	}

	protected String bo() {
		return "mob.zombie.death";
	}

	protected void a(Position var1, Block var2) {
		this.a("mob.zombie.step", 0.15F, 1.0F);
	}

	protected Item getLoot() {
		return Items.ROTTEN_FLESH;
	}

	public EnumMonsterType by() {
		return EnumMonsterType.b;
	}

	protected void bp() {
		switch (this.random.nextInt(3)) {
			case 0:
				this.a(Items.IRON_INGOT, 1);
				break;
			case 1:
				this.a(Items.CARROT, 1);
				break;
			case 2:
				this.a(Items.POTATO, 1);
		}

	}

	protected void a(vu var1) {
		super.a(var1);
		if (this.random.nextFloat() < (this.world.getDifficulty() == Difficulty.HARD ? 0.05F : 0.01F)) {
			int var2 = this.random.nextInt(3);
			if (var2 == 0) {
				this.setArmor(0, new ItemStack(Items.IRON_SWORD));
			} else {
				this.setArmor(0, new ItemStack(Items.IRON_SHOWEL));
			}
		}

	}

	public void writeAdditionalData(NBTCompoundTag var1) {
		super.writeAdditionalData(var1);
		if (this.i_()) {
			var1.put("IsBaby", true);
		}

		if (this.cm()) {
			var1.put("IsVillager", true);
		}

		var1.put("ConversionTime", this.cn() ? this.bm : -1);
		var1.put("CanBreakDoors", this.cl());
	}

	public void readAdditionalData(NBTCompoundTag var1) {
		super.readAdditionalData(var1);
		if (var1.getBoolean("IsBaby")) {
			this.l(true);
		}

		if (var1.getBoolean("IsVillager")) {
			this.m(true);
		}

		if (var1.isTagAssignableFrom("ConversionTime", 99) && var1.getInt("ConversionTime") > -1) {
			this.a(var1.getInt("ConversionTime"));
		}

		this.a(var1.getBoolean("CanBreakDoors"));
	}

	public void a(EntityLiving var1) {
		super.a(var1);
		if ((this.world.getDifficulty() == Difficulty.NORMAL || this.world.getDifficulty() == Difficulty.HARD) && var1 instanceof EntityVillager) {
			if (this.world.getDifficulty() != Difficulty.HARD && this.random.nextBoolean()) {
				return;
			}

			EntityZombie var2 = new EntityZombie(this.world);
			var2.m(var1);
			this.world.e((Entity) var1);
			var2.a(this.world.E(new Position(var2)), (xq) null);
			var2.m(true);
			if (var1.i_()) {
				var2.l(true);
			}

			this.world.addEntity((Entity) var2);
			this.world.a((EntityHuman) null, 1016, new Position((int) this.locationX, (int) this.locationY, (int) this.locationZ), 0);
		}

	}

	public float getHeadHeight() {
		float var1 = 1.74F;
		if (this.i_()) {
			var1 = (float) ((double) var1 - 0.81D);
		}

		return var1;
	}

	protected boolean a(ItemStack var1) {
		return var1.getItem() == Items.EGG && this.i_() && this.av() ? false : super.a(var1);
	}

	public xq a(vu var1, xq var2) {
		Object var7 = super.a(var1, var2);
		float var3 = var1.c();
		this.j(this.random.nextFloat() < 0.55F * var3);
		if (var7 == null) {
			var7 = new agl(this, this.world.random.nextFloat() < 0.05F, this.world.random.nextFloat() < 0.05F, (agk) null);
		}

		if (var7 instanceof agl) {
			agl var4 = (agl) var7;
			if (var4.b) {
				this.m(true);
			}

			if (var4.a) {
				this.l(true);
				if ((double) this.world.random.nextFloat() < 0.05D) {
					List var5 = this.world.getEntititesInAABB(EntityChicken.class, this.getBoundingBox().grow(5.0D, 3.0D, 5.0D), EntityPredicates.b);
					if (!var5.isEmpty()) {
						EntityChicken var6 = (EntityChicken) var5.get(0);
						var6.l(true);
						this.mount((Entity) var6);
					}
				} else if ((double) this.world.random.nextFloat() < 0.05D) {
					EntityChicken var10 = new EntityChicken(this.world);
					var10.setPositionRotation(this.locationX, this.locationY, this.locationZ, this.yaw, 0.0F);
					var10.a(var1, (xq) null);
					var10.l(true);
					this.world.addEntity((Entity) var10);
					this.mount((Entity) var10);
				}
			}
		}

		this.a(this.random.nextFloat() < var3 * 0.1F);
		this.a(var1);
		this.b(var1);
		if (this.p(4) == null) {
			Calendar var8 = this.world.Y();
			if (var8.get(2) + 1 == 10 && var8.get(5) == 31 && this.random.nextFloat() < 0.25F) {
				this.setArmor(4, new ItemStack(this.random.nextFloat() < 0.1F ? Blocks.LIT_PUMPKIN : Blocks.PUMPKIN));
				this.bh[4] = 0.0F;
			}
		}

		this.a(afs.c).b(new AttributeModifier("Random spawn bonus", this.random.nextDouble() * 0.05000000074505806D, 0));
		double var9 = this.random.nextDouble() * 1.5D * (double) var3;
		if (var9 > 1.0D) {
			this.a(afs.b).b(new AttributeModifier("Random zombie-spawn bonus", var9, 2));
		}

		if (this.random.nextFloat() < var3 * 0.05F) {
			this.a(b).b(new AttributeModifier("Leader zombie bonus", this.random.nextDouble() * 0.25D + 0.5D, 0));
			this.a(afs.a).b(new AttributeModifier("Leader zombie bonus", this.random.nextDouble() * 3.0D + 1.0D, 2));
			this.a(true);
		}

		return (xq) var7;
	}

	public boolean a(EntityHuman var1) {
		ItemStack var2 = var1.bY();
		if (var2 != null && var2.getItem() == Items.GOLDEN_APPLE && var2.getWearout() == 0 && this.cm() && this.a(MobEffectList.WEAKNESS)) {
			if (!var1.playerProperties.instabuild) {
				--var2.amount;
			}

			if (var2.amount <= 0) {
				var1.playerInventory.setItem(var1.playerInventory.itemInHandIndex, (ItemStack) null);
			}

			if (!this.world.isStatic) {
				this.a(this.random.nextInt(2401) + 3600);
			}

			return true;
		} else {
			return false;
		}
	}

	protected void a(int var1) {
		this.bm = var1;
		this.getDataWatcher().b(14, Byte.valueOf((byte) 1));
		this.m(MobEffectList.WEAKNESS.id);
		this.c(new MobEffect(MobEffectList.INCREASE_DAMAGE.id, var1, Math.min(this.world.getDifficulty().getId() - 1, 0)));
		this.world.broadcastEntityEffect((Entity) this, (byte) 16);
	}

	protected boolean C() {
		return !this.cn();
	}

	public boolean cn() {
		return this.getDataWatcher().a(14) == 1;
	}

	protected void co() {
		EntityVillager var1 = new EntityVillager(this.world);
		var1.m(this);
		var1.a(this.world.E(new Position(var1)), (xq) null);
		var1.cn();
		if (this.i_()) {
			var1.b(-24000);
		}

		this.world.e((Entity) this);
		this.world.addEntity((Entity) var1);
		var1.c(new MobEffect(MobEffectList.CONFUSION.id, 200, 0));
		this.world.a((EntityHuman) null, 1017, new Position((int) this.locationX, (int) this.locationY, (int) this.locationZ), 0);
	}

	protected int cp() {
		int var1 = 1;
		if (this.random.nextFloat() < 0.01F) {
			int var2 = 0;

			for (int var3 = (int) this.locationX - 4; var3 < (int) this.locationX + 4 && var2 < 14; ++var3) {
				for (int var4 = (int) this.locationY - 4; var4 < (int) this.locationY + 4 && var2 < 14; ++var4) {
					for (int var5 = (int) this.locationZ - 4; var5 < (int) this.locationZ + 4 && var2 < 14; ++var5) {
						Block var6 = this.world.getBlockState(new Position(var3, var4, var5)).getBlock();
						if (var6 == Blocks.IRON_BARS || var6 == Blocks.BED) {
							if (this.random.nextFloat() < 0.3F) {
								++var1;
							}

							++var2;
						}
					}
				}
			}
		}

		return var1;
	}

	public void n(boolean var1) {
		this.a(var1 ? 0.5F : 1.0F);
	}

	protected final void a(float var1, float var2) {
		boolean var3 = this.bo > 0.0F && this.bp > 0.0F;
		this.bo = var1;
		this.bp = var2;
		if (!var3) {
			this.a(1.0F);
		}

	}

	protected final void a(float var1) {
		super.a(this.bo * var1, this.bp * var1);
	}

	public double am() {
		return super.am() - 0.5D;
	}

	public void die(DamageSource var1) {
		super.die(var1);
		if (var1.getDamager() instanceof EntityCreeper && !(this instanceof EntityPigZombie) && ((EntityCreeper) var1.getDamager()).n() && ((EntityCreeper) var1.getDamager()).cn()) {
			((EntityCreeper) var1.getDamager()).co();
			this.a(new ItemStack(Items.SKULL, 1, 2), 0.0F);
		}

	}

}
