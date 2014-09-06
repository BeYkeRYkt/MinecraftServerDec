package net.minecraft;

import java.util.Calendar;

public class EntitySkeleton extends EntityMonster implements afr {

	private zz b = new zz(this, 1.0D, 20, 60, 15.0F);
	private zk c = new zk(this, EntityHuman.class, 1.2D, false);

	public EntitySkeleton(World var1) {
		super(var1);
		this.i.a(1, new yy(this));
		this.i.a(2, new aab(this));
		this.i.a(2, this.a);
		this.i.a(3, new yx(this, 1.0D));
		this.i.a(3, new yp(this, new afx(this), 6.0F, 1.0D, 1.2D));
		this.i.a(4, new zy(this, 1.0D));
		this.i.a(6, new zh(this, EntityHuman.class, 8.0F));
		this.i.a(6, new zx(this));
		this.bg.a(1, new aal(this, false, new Class[0]));
		this.bg.a(2, new aaq(this, EntityHuman.class, true));
		this.bg.a(3, new aaq(this, EntityIronGolem.class, true));
		if (var1 != null && !var1.D) {
			this.n();
		}

	}

	protected void aW() {
		super.aW();
		this.a(afs.d).a(0.25D);
	}

	protected void h() {
		super.h();
		this.dataWatcher.a(13, new Byte((byte) 0));
	}

	protected String z() {
		return "mob.skeleton.say";
	}

	protected String bn() {
		return "mob.skeleton.hurt";
	}

	protected String bo() {
		return "mob.skeleton.death";
	}

	protected void a(Position var1, Block var2) {
		this.a("mob.skeleton.step", 0.15F, 1.0F);
	}

	public boolean r(Entity var1) {
		if (super.r(var1)) {
			if (this.ck() == 1 && var1 instanceof EntityLiving) {
				((EntityLiving) var1).c(new MobEffect(MobEffectList.v.H, 200));
			}

			return true;
		} else {
			return false;
		}
	}

	public EnumMonsterType by() {
		return EnumMonsterType.b;
	}

	public void m() {
		if (this.o.w() && !this.o.D) {
			float var1 = this.c(1.0F);
			Position var2 = new Position(this.locationX, (double) Math.round(this.locationY), this.locationZ);
			if (var1 > 0.5F && this.V.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F && this.o.i(var2)) {
				boolean var3 = true;
				ItemStack var4 = this.p(4);
				if (var4 != null) {
					if (var4.e()) {
						var4.b(var4.h() + this.V.nextInt(2));
						if (var4.h() >= var4.j()) {
							this.b(var4);
							this.c(4, (ItemStack) null);
						}
					}

					var3 = false;
				}

				if (var3) {
					this.e(8);
				}
			}
		}

		if (this.o.D && this.ck() == 1) {
			this.a(0.72F, 2.535F);
		}

		super.m();
	}

	public void ak() {
		super.ak();
		if (this.m instanceof EntityCreature) {
			EntityCreature var1 = (EntityCreature) this.m;
			this.aG = var1.aG;
		}

	}

	public void a(DamageSource var1) {
		super.a(var1);
		if (var1.i() instanceof EntityArrow && var1.j() instanceof EntityHuman) {
			EntityHuman var2 = (EntityHuman) var1.j();
			double var3 = var2.locationX - this.locationX;
			double var5 = var2.locationZ - this.locationZ;
			if (var3 * var3 + var5 * var5 >= 2500.0D) {
				var2.b((Statistic) tl.v);
			}
		} else if (var1.j() instanceof EntityCreeper && ((EntityCreeper) var1.j()).n() && ((EntityCreeper) var1.j()).cn()) {
			((EntityCreeper) var1.j()).co();
			this.a(new ItemStack(Items.SKULL, 1, this.ck() == 1 ? 1 : 0), 0.0F);
		}

	}

	protected Item A() {
		return Items.ARROW;
	}

	protected void b(boolean var1, int var2) {
		int var3;
		int var4;
		if (this.ck() == 1) {
			var3 = this.V.nextInt(3 + var2) - 1;

			for (var4 = 0; var4 < var3; ++var4) {
				this.a(Items.COAL, 1);
			}
		} else {
			var3 = this.V.nextInt(3 + var2);

			for (var4 = 0; var4 < var3; ++var4) {
				this.a(Items.ARROW, 1);
			}
		}

		var3 = this.V.nextInt(3 + var2);

		for (var4 = 0; var4 < var3; ++var4) {
			this.a(Items.BONE, 1);
		}

	}

	protected void bp() {
		if (this.ck() == 1) {
			this.a(new ItemStack(Items.SKULL, 1, 1), 0.0F);
		}

	}

	protected void a(vu var1) {
		super.a(var1);
		this.c(0, new ItemStack(Items.BOW));
	}

	public xq a(vu var1, xq var2) {
		var2 = super.a(var1, var2);
		if (this.o.worldProvider instanceof NetherWorldProvider && this.bb().nextInt(5) > 0) {
			this.i.a(4, this.c);
			this.a(1);
			this.c(0, new ItemStack(Items.STONE_SWORD));
			this.a(afs.e).a(4.0D);
		} else {
			this.i.a(4, this.b);
			this.a(var1);
			this.b(var1);
		}

		this.j(this.V.nextFloat() < 0.55F * var1.c());
		if (this.p(4) == null) {
			Calendar var3 = this.o.Y();
			if (var3.get(2) + 1 == 10 && var3.get(5) == 31 && this.V.nextFloat() < 0.25F) {
				this.c(4, new ItemStack(this.V.nextFloat() < 0.1F ? Blocks.LIT_PUMPKIN : Blocks.PUMPKIN));
				this.bh[4] = 0.0F;
			}
		}

		return var2;
	}

	public void n() {
		this.i.a((zb) this.c);
		this.i.a((zb) this.b);
		ItemStack var1 = this.bz();
		if (var1 != null && var1.getItem() == Items.BOW) {
			this.i.a(4, this.b);
		} else {
			this.i.a(4, this.c);
		}

	}

	public void a(EntityLiving var1, float var2) {
		EntityArrow var3 = new EntityArrow(this.o, this, var1, 1.6F, (float) (14 - this.o.getDifficulty().getId() * 4));
		int var4 = aph.a(Enchantment.ARROW_DAMAGE.id, this.bz());
		int var5 = aph.a(Enchantment.ARROW_KNOCKBACK.id, this.bz());
		var3.b((double) (var2 * 2.0F) + this.V.nextGaussian() * 0.25D + (double) ((float) this.o.getDifficulty().getId() * 0.11F));
		if (var4 > 0) {
			var3.b(var3.j() + (double) var4 * 0.5D + 0.5D);
		}

		if (var5 > 0) {
			var3.a(var5);
		}

		if (aph.a(Enchantment.ARROW_FIRE.id, this.bz()) > 0 || this.ck() == 1) {
			var3.e(100);
		}

		this.a("random.bow", 1.0F, 1.0F / (this.bb().nextFloat() * 0.4F + 0.8F));
		this.o.d((Entity) var3);
	}

	public int ck() {
		return this.dataWatcher.a(13);
	}

	public void a(int var1) {
		this.dataWatcher.b(13, Byte.valueOf((byte) var1));
		this.ab = var1 == 1;
		if (var1 == 1) {
			this.a(0.72F, 2.535F);
		} else {
			this.a(0.6F, 1.95F);
		}

	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		if (var1.isTagAssignableFrom("SkeletonType", 99)) {
			byte var2 = var1.getByte("SkeletonType");
			this.a(var2);
		}

		this.n();
	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.put("SkeletonType", (byte) this.ck());
	}

	public void c(int var1, ItemStack var2) {
		super.c(var1, var2);
		if (!this.o.D && var1 == 0) {
			this.n();
		}

	}

	public float aR() {
		return this.ck() == 1 ? super.aR() : 1.74F;
	}

	public double am() {
		return super.am() - 0.5D;
	}
}
