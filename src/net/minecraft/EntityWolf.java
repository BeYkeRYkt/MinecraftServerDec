package net.minecraft;

public class EntityWolf extends xx {

	private float bm;
	private float bn;
	private boolean bo;
	private boolean bp;
	private float bq;
	private float br;

	public EntityWolf(World var1) {
		super(var1);
		this.a(0.6F, 0.8F);
		((aay) this.s()).a(true);
		this.i.a(1, new PathfinderGoalFloat(this));
		this.i.a(2, this.bk);
		this.i.a(3, new zg(this, 0.4F));
		this.i.a(4, new zk(this, 1.0D, true));
		this.i.a(5, new yz(this, 1.0D, 10.0F, 2.0F));
		this.i.a(6, new yt(this, 1.0D));
		this.i.a(7, new PathfinderGoalRandomStroll(this, 1.0D));
		this.i.a(8, new yr(this, 8.0F));
		this.i.a(9, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
		this.i.a(9, new PathfinderGoalRandomLookaround(this));
		this.bg.a(1, new aau(this));
		this.bg.a(2, new aav(this));
		this.bg.a(3, new aal(this, true, new Class[0]));
		this.bg.a(4, new aat(this, EntityAnimal.class, false, new acv(this)));
		this.bg.a(5, new PathfinderGoalNearestAttackableTarget(this, EntitySkeleton.class, false));
		this.m(false);
	}

	protected void aW() {
		super.aW();
		this.a(afs.d).a(0.30000001192092896D);
		if (this.cj()) {
			this.a(afs.a).a(20.0D);
		} else {
			this.a(afs.a).a(8.0D);
		}

		this.bx().b(afs.e);
		this.a(afs.e).a(2.0D);
	}

	public void d(EntityLiving var1) {
		super.d(var1);
		if (var1 == null) {
			this.o(false);
		} else if (!this.cj()) {
			this.o(true);
		}

	}

	protected void E() {
		this.dataWatcher.b(18, Float.valueOf(this.getHealth()));
	}

	protected void h() {
		super.h();
		this.dataWatcher.a(18, new Float(this.getHealth()));
		this.dataWatcher.a(19, new Byte((byte) 0));
		this.dataWatcher.a(20, new Byte((byte) akv.o.a()));
	}

	protected void a(Position var1, Block var2) {
		this.a("mob.wolf.step", 0.15F, 1.0F);
	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.put("Angry", this.ct());
		var1.put("CollarColor", (byte) this.cu().b());
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		this.o(var1.getBoolean("Angry"));
		if (var1.isTagAssignableFrom("CollarColor", 99)) {
			this.a(akv.a(var1.getByte("CollarColor")));
		}

	}

	protected String z() {
		return this.ct() ? "mob.wolf.growl" : (this.random.nextInt(3) == 0 ? (this.cj() && this.dataWatcher.getData(18) < 10.0F ? "mob.wolf.whine" : "mob.wolf.panting") : "mob.wolf.bark");
	}

	protected String bn() {
		return "mob.wolf.hurt";
	}

	protected String bo() {
		return "mob.wolf.death";
	}

	protected float bA() {
		return 0.4F;
	}

	protected Item getLoot() {
		return Item.getById(-1);
	}

	public void m() {
		super.m();
		if (!this.world.isStatic && this.bo && !this.bp && !this.cd() && this.onGround) {
			this.bp = true;
			this.bq = 0.0F;
			this.br = 0.0F;
			this.world.broadcastEntityEffect((Entity) this, (byte) 8);
		}

		if (!this.world.isStatic && this.u() == null && this.ct()) {
			this.o(false);
		}

	}

	public void doTick() {
		super.doTick();
		this.bn = this.bm;
		if (this.cv()) {
			this.bm += (1.0F - this.bm) * 0.4F;
		} else {
			this.bm += (0.0F - this.bm) * 0.4F;
		}

		if (this.U()) {
			this.bo = true;
			this.bp = false;
			this.bq = 0.0F;
			this.br = 0.0F;
		} else if ((this.bo || this.bp) && this.bp) {
			if (this.bq == 0.0F) {
				this.a("mob.wolf.shake", this.bA(), (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
			}

			this.br = this.bq;
			this.bq += 0.05F;
			if (this.br >= 2.0F) {
				this.bo = false;
				this.bp = false;
				this.br = 0.0F;
				this.bq = 0.0F;
			}

			if (this.bq > 0.4F) {
				float var1 = (float) this.getBoundingBox().minY;
				int var2 = (int) (MathHelper.a((this.bq - 0.4F) * 3.1415927F) * 7.0F);

				for (int var3 = 0; var3 < var2; ++var3) {
					float var4 = (this.random.nextFloat() * 2.0F - 1.0F) * this.height * 0.5F;
					float var5 = (this.random.nextFloat() * 2.0F - 1.0F) * this.height * 0.5F;
					this.world.addParticle(Particle.f, this.locationX + (double) var4, (double) (var1 + 0.8F), this.locationZ + (double) var5, this.motionX, this.motionY, this.motionZ, new int[0]);
				}
			}
		}

	}

	public float getHeadHeight() {
		return this.width * 0.8F;
	}

	public int bP() {
		return this.cl() ? 20 : super.bP();
	}

	public boolean receiveDamage(DamageSource var1, float var2) {
		if (this.ignoresDamageType(var1)) {
			return false;
		} else {
			Entity var3 = var1.getDamager();
			this.bk.a(false);
			if (var3 != null && !(var3 instanceof EntityHuman) && !(var3 instanceof EntityArrow)) {
				var2 = (var2 + 1.0F) / 2.0F;
			}

			return super.receiveDamage(var1, var2);
		}
	}

	public boolean r(Entity var1) {
		boolean var2 = var1.receiveDamage(DamageSource.mobAttack((EntityLiving) this), (float) ((int) this.a(afs.e).e()));
		if (var2) {
			this.a((EntityLiving) this, var1);
		}

		return var2;
	}

	public void m(boolean var1) {
		super.m(var1);
		if (var1) {
			this.a(afs.a).a(20.0D);
		} else {
			this.a(afs.a).a(8.0D);
		}

		this.a(afs.e).a(4.0D);
	}

	public boolean a(EntityHuman var1) {
		ItemStack var2 = var1.playerInventory.getItemInHand();
		if (this.cj()) {
			if (var2 != null) {
				if (var2.getItem() instanceof ItemFood) {
					ItemFood var3 = (ItemFood) var2.getItem();
					if (var3.g() && this.dataWatcher.getData(18) < 20.0F) {
						if (!var1.playerProperties.instabuild) {
							--var2.amount;
						}

						this.g((float) var3.h(var2));
						if (var2.amount <= 0) {
							var1.playerInventory.setItem(var1.playerInventory.itemInHandIndex, (ItemStack) null);
						}

						return true;
					}
				} else if (var2.getItem() == Items.DYE) {
					akv var4 = akv.a(var2.getWearout());
					if (var4 != this.cu()) {
						this.a(var4);
						if (!var1.playerProperties.instabuild && --var2.amount <= 0) {
							var1.playerInventory.setItem(var1.playerInventory.itemInHandIndex, (ItemStack) null);
						}

						return true;
					}
				}
			}

			if (this.e(var1) && !this.world.isStatic && !this.d(var2)) {
				this.bk.a(!this.cl());
				this.aW = false;
				this.h.n();
				this.d((EntityLiving) null);
			}
		} else if (var2 != null && var2.getItem() == Items.BONE && !this.ct()) {
			if (!var1.playerProperties.instabuild) {
				--var2.amount;
			}

			if (var2.amount <= 0) {
				var1.playerInventory.setItem(var1.playerInventory.itemInHandIndex, (ItemStack) null);
			}

			if (!this.world.isStatic) {
				if (this.random.nextInt(3) == 0) {
					this.m(true);
					this.h.n();
					this.d((EntityLiving) null);
					this.bk.a(true);
					this.h(20.0F);
					this.b(var1.getUUID().toString());
					this.l(true);
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

	public boolean d(ItemStack var1) {
		return var1 == null ? false : (!(var1.getItem() instanceof ItemFood) ? false : ((ItemFood) var1.getItem()).g());
	}

	public int bU() {
		return 8;
	}

	public boolean ct() {
		return (this.dataWatcher.a(16) & 2) != 0;
	}

	public void o(boolean var1) {
		byte var2 = this.dataWatcher.a(16);
		if (var1) {
			this.dataWatcher.b(16, Byte.valueOf((byte) (var2 | 2)));
		} else {
			this.dataWatcher.b(16, Byte.valueOf((byte) (var2 & -3)));
		}

	}

	public akv cu() {
		return akv.a(this.dataWatcher.a(20) & 15);
	}

	public void a(akv var1) {
		this.dataWatcher.b(20, Byte.valueOf((byte) (var1.b() & 15)));
	}

	public EntityWolf b(EntityAgeable var1) {
		EntityWolf var2 = new EntityWolf(this.world);
		String var3 = this.b();
		if (var3 != null && var3.trim().length() > 0) {
			var2.b(var3);
			var2.m(true);
		}

		return var2;
	}

	public void p(boolean var1) {
		if (var1) {
			this.dataWatcher.b(19, Byte.valueOf((byte) 1));
		} else {
			this.dataWatcher.b(19, Byte.valueOf((byte) 0));
		}

	}

	public boolean a(EntityAnimal var1) {
		if (var1 == this) {
			return false;
		} else if (!this.cj()) {
			return false;
		} else if (!(var1 instanceof EntityWolf)) {
			return false;
		} else {
			EntityWolf var2 = (EntityWolf) var1;
			return !var2.cj() ? false : (var2.cl() ? false : this.cp() && var2.cp());
		}
	}

	public boolean cv() {
		return this.dataWatcher.a(19) == 1;
	}

	protected boolean C() {
		return !this.cj() && this.ticksLived > 2400;
	}

	public boolean a(EntityLiving var1, EntityLiving var2) {
		if (!(var1 instanceof EntityCreeper) && !(var1 instanceof EntityGhast)) {
			if (var1 instanceof EntityWolf) {
				EntityWolf var3 = (EntityWolf) var1;
				if (var3.cj() && var3.cm() == var2) {
					return false;
				}
			}

			return var1 instanceof EntityHuman && var2 instanceof EntityHuman && !((EntityHuman) var2).canReveiveDamageFrom((EntityHuman) var1) ? false : !(var1 instanceof EntityHorse) || !((EntityHorse) var1).cm();
		} else {
			return false;
		}
	}

	public boolean ca() {
		return !this.ct() && super.ca();
	}

	// $FF: synthetic method
	public EntityAgeable a(EntityAgeable var1) {
		return this.b(var1);
	}
}
