package net.minecraft;

import com.google.common.base.Predicate;
import java.util.Iterator;
import java.util.List;

public class EntityGuardian extends EntityMonster {

	private float b;
	private float c;
	private float bk;
	private float bl;
	private float bm;
	private EntityLiving bn;
	private int bo;
	private boolean bp;
	private zy bq;

	public EntityGuardian(World var1) {
		super(var1);
		this.b_ = 10;
		this.a(0.85F, 0.85F);
		this.i.a(4, new afi(this));
		zo var2;
		this.i.a(5, var2 = new zo(this, 1.0D));
		this.i.a(7, this.bq = new zy(this, 1.0D, 80));
		this.i.a(8, new zh(this, EntityHuman.class, 8.0F));
		this.i.a(8, new zh(this, EntityGuardian.class, 12.0F, 0.01F));
		this.i.a(9, new zx(this));
		this.bq.a(3);
		var2.a(3);
		this.bg.a(1, new aaq(this, EntityLiving.class, 10, true, false, new afj(this)));
		this.f = new afk(this);
		this.c = this.b = this.V.nextFloat();
	}

	protected void aW() {
		super.aW();
		this.a(afs.e).a(6.0D);
		this.a(afs.d).a(0.5D);
		this.a(afs.b).a(16.0D);
		this.a(afs.a).a(30.0D);
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		this.a(var1.getBoolean("Elder"));
	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.put("Elder", this.cl());
	}

	protected aaz b(World var1) {
		return new abb(this, var1);
	}

	protected void h() {
		super.h();
		this.dataWatcher.a(16, Integer.valueOf(0));
		this.dataWatcher.a(17, Integer.valueOf(0));
	}

	private boolean a(int var1) {
		return (this.dataWatcher.c(16) & var1) != 0;
	}

	private void a(int var1, boolean var2) {
		int var3 = this.dataWatcher.c(16);
		if (var2) {
			this.dataWatcher.b(16, Integer.valueOf(var3 | var1));
		} else {
			this.dataWatcher.b(16, Integer.valueOf(var3 & ~var1));
		}

	}

	public boolean n() {
		return this.a(2);
	}

	private void l(boolean var1) {
		this.a(2, var1);
	}

	public int ck() {
		return this.cl() ? 60 : 80;
	}

	public boolean cl() {
		return this.a(4);
	}

	public void a(boolean var1) {
		this.a(4, var1);
		if (var1) {
			this.a(1.9975F, 1.9975F);
			this.a(afs.d).a(0.30000001192092896D);
			this.a(afs.e).a(8.0D);
			this.a(afs.a).a(80.0D);
			this.bW();
			this.bq.b(400);
		}

	}

	private void b(int var1) {
		this.dataWatcher.b(17, Integer.valueOf(var1));
	}

	public boolean cn() {
		return this.dataWatcher.c(17) != 0;
	}

	public EntityLiving co() {
		if (!this.cn()) {
			return null;
		} else if (this.o.D) {
			if (this.bn != null) {
				return this.bn;
			} else {
				Entity var1 = this.o.a(this.dataWatcher.c(17));
				if (var1 instanceof EntityLiving) {
					this.bn = (EntityLiving) var1;
					return this.bn;
				} else {
					return null;
				}
			}
		} else {
			return this.u();
		}
	}

	public void i(int var1) {
		super.i(var1);
		if (var1 == 16) {
			if (this.cl() && this.J < 1.0F) {
				this.a(1.9975F, 1.9975F);
			}
		} else if (var1 == 17) {
			this.bo = 0;
			this.bn = null;
		}

	}

	public int w() {
		return 160;
	}

	protected String z() {
		return !this.V() ? "mob.guardian.land.idle" : (this.cl() ? "mob.guardian.elder.idle" : "mob.guardian.idle");
	}

	protected String bn() {
		return !this.V() ? "mob.guardian.land.hit" : (this.cl() ? "mob.guardian.elder.hit" : "mob.guardian.hit");
	}

	protected String bo() {
		return !this.V() ? "mob.guardian.land.death" : (this.cl() ? "mob.guardian.elder.death" : "mob.guardian.death");
	}

	protected boolean r_() {
		return false;
	}

	public float aR() {
		return this.K * 0.5F;
	}

	public float a(Position var1) {
		return this.o.p(var1).getBlock().r() == Material.WATER ? 10.0F + this.o.o(var1) - 0.5F : super.a(var1);
	}

	public void m() {
		if (this.o.D) {
			this.c = this.b;
			if (!this.V()) {
				this.bk = 2.0F;
				if (this.motionY > 0.0D && this.bp && !this.R()) {
					this.o.a(this.locationX, this.locationY, this.locationZ, "mob.guardian.flop", 1.0F, 1.0F, false);
				}

				this.bp = this.motionY < 0.0D && this.o.d((new Position(this)).b(), false);
			} else if (this.n()) {
				if (this.bk < 0.5F) {
					this.bk = 4.0F;
				} else {
					this.bk += (0.5F - this.bk) * 0.1F;
				}
			} else {
				this.bk += (0.125F - this.bk) * 0.2F;
			}

			this.b += this.bk;
			this.bm = this.bl;
			if (!this.V()) {
				this.bl = this.V.nextFloat();
			} else if (this.n()) {
				this.bl += (0.0F - this.bl) * 0.25F;
			} else {
				this.bl += (1.0F - this.bl) * 0.06F;
			}

			if (this.n() && this.V()) {
				Vec3D var1 = this.d(0.0F);

				for (int var2 = 0; var2 < 2; ++var2) {
					this.o.a(Particle.e, this.locationX + (this.V.nextDouble() - 0.5D) * (double) this.J - var1.x * 1.5D, this.locationY + this.V.nextDouble() * (double) this.K - var1.y * 1.5D, this.locationZ + (this.V.nextDouble() - 0.5D) * (double) this.J - var1.z * 1.5D, 0.0D, 0.0D, 0.0D, new int[0]);
				}
			}

			if (this.cn()) {
				if (this.bo < this.ck()) {
					++this.bo;
				}

				EntityLiving var14 = this.co();
				if (var14 != null) {
					this.p().a(var14, 90.0F, 90.0F);
					this.p().a();
					double var15 = (double) this.p(0.0F);
					double var4 = var14.locationX - this.locationX;
					double var6 = var14.locationY + (double) (var14.K * 0.5F) - (this.locationY + (double) this.aR());
					double var8 = var14.locationZ - this.locationZ;
					double var10 = Math.sqrt(var4 * var4 + var6 * var6 + var8 * var8);
					var4 /= var10;
					var6 /= var10;
					var8 /= var10;
					double var12 = this.V.nextDouble();

					while (var12 < var10) {
						var12 += 1.8D - var15 + this.V.nextDouble() * (1.7D - var15);
						this.o.a(Particle.e, this.locationX + var4 * var12, this.locationY + var6 * var12 + (double) this.aR(), this.locationZ + var8 * var12, 0.0D, 0.0D, 0.0D, new int[0]);
					}
				}
			}
		}

		if (this.Y) {
			this.h(300);
		} else if (this.onGround) {
			this.motionY += 0.5D;
			this.motionX += (double) ((this.V.nextFloat() * 2.0F - 1.0F) * 0.4F);
			this.motionZ += (double) ((this.V.nextFloat() * 2.0F - 1.0F) * 0.4F);
			this.yaw = this.V.nextFloat() * 360.0F;
			this.onGround = false;
			this.ai = true;
		}

		if (this.cn()) {
			this.yaw = this.headPitch;
		}

		super.m();
	}

	public float p(float var1) {
		return ((float) this.bo + var1) / (float) this.ck();
	}

	protected void E() {
		super.E();
		if (this.cl()) {
			boolean var1 = true;
			boolean var2 = true;
			boolean var3 = true;
			boolean var4 = true;
			if ((this.W + this.getId()) % 1200 == 0) {
				MobEffectList var5 = MobEffectList.f;
				List var6 = this.o.b(EntityPlayer.class, (Predicate) (new afh(this)));
				Iterator var7 = var6.iterator();

				while (var7.hasNext()) {
					EntityPlayer var8 = (EntityPlayer) var7.next();
					if (!var8.a(var5) || var8.b(var5).getAmplifier() < 2 || var8.b(var5).getDuration() < 1200) {
						var8.playerConncetion.sendPacket((Packet) (new PacketOutChangeGameState(10, 0.0F)));
						var8.c(new MobEffect(var5.H, 6000, 2));
					}
				}
			}

			if (!this.ci()) {
				this.a(new Position(this), 16);
			}
		}

	}

	protected void b(boolean var1, int var2) {
		int var3 = this.V.nextInt(3) + this.V.nextInt(var2 + 1);
		if (var3 > 0) {
			this.a(new ItemStack(Items.PRISMARINE_SHARD, var3, 0), 1.0F);
		}

		if (this.V.nextInt(3 + var2) > 1) {
			this.a(new ItemStack(Items.FISH, 1, ali.a.a()), 1.0F);
		} else if (this.V.nextInt(3 + var2) > 1) {
			this.a(new ItemStack(Items.PRISMARINE_CRYSTALS, 1, 0), 1.0F);
		}

		if (var1 && this.cl()) {
			this.a(new ItemStack(Blocks.SPONGE, 1, 1), 1.0F);
		}

	}

	protected void bp() {
		ItemStack var1 = ((adp) vj.a(this.V, ado.j())).a(this.V);
		this.a(var1, 1.0F);
	}

	protected boolean m_() {
		return true;
	}

	public boolean bR() {
		return this.o.a(this.aQ(), (Entity) this) && this.o.a((Entity) this, this.aQ()).isEmpty();
	}

	public boolean bQ() {
		return (this.V.nextInt(20) == 0 || !this.o.j(new Position(this))) && super.bQ();
	}

	public boolean a(DamageSource var1, float var2) {
		if (!this.n() && !var1.s() && var1.i() instanceof EntityLiving) {
			EntityLiving var3 = (EntityLiving) var1.i();
			if (!var1.c()) {
				var3.a(DamageSource.a((Entity) this), 2.0F);
				var3.a("damage.thorns", 0.5F, 1.0F);
			}
		}

		this.bq.f();
		return super.a(var1, var2);
	}

	public int bP() {
		return 180;
	}

	public void g(float var1, float var2) {
		if (this.bL()) {
			if (this.V()) {
				this.a(var1, var2, 0.1F);
				this.d(this.motionX, this.motionY, this.motionZ);
				this.motionX *= 0.8999999761581421D;
				this.motionY *= 0.8999999761581421D;
				this.motionZ *= 0.8999999761581421D;
				if (!this.n() && this.u() == null) {
					this.motionY -= 0.005D;
				}
			} else {
				super.g(var1, var2);
			}
		} else {
			super.g(var1, var2);
		}

	}

	// $FF: synthetic method
	static void a(EntityGuardian var0, int var1) {
		var0.b(var1);
	}

	// $FF: synthetic method
	static zy a(EntityGuardian var0) {
		return var0.bq;
	}

	// $FF: synthetic method
	static void a(EntityGuardian var0, boolean var1) {
		var0.l(var1);
	}
}
