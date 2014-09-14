package net.minecraft;

import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public abstract class EntityLiving extends Entity {

	private static final UUID a = UUID.fromString("662A6B8D-DA3E-4C1C-8813-96EA6097278D");
	private static final AttributeModifier b = (new AttributeModifier(a, "Sprinting speed boost", 0.30000001192092896D, 2)).setSerializable(false);
	private yc c;
	private final CombatTracker f = new CombatTracker(this);
	private final Map g = Maps.newHashMap();
	private final ItemStack[] h = new ItemStack[5];
	public boolean ap;
	public int aq;
	public int ar;
	public int as;
	public int at;
	public float au;
	public int av;
	public float aw;
	public float ax;
	public float ay;
	public float az;
	public float aA;
	public int aB = 20;
	public float aC;
	public float aD;
	public float aE;
	public float aF;
	public float aG;
	public float aH;
	public float headPitch;
	public float aJ;
	public float aK = 0.02F;
	protected EntityHuman aL;
	protected int aM;
	protected boolean aN;
	protected int aO;
	protected float aP;
	protected float aQ;
	protected float aR;
	protected float aS;
	protected float aT;
	protected int aU;
	protected float aV;
	protected boolean aW;
	public float aX;
	public float aY;
	protected float aZ;
	protected int ba;
	protected double bb;
	protected double bc;
	protected double bd;
	protected double be;
	protected double bf;
	private boolean i = true;
	private EntityLiving bg;
	private int bh;
	private EntityLiving bi;
	private int bj;
	private float bk;
	private int bl;
	private float bm;

	public void setDead() {
		this.damageEntity(DamageSource.OUT_OF_WORLD, Float.MAX_VALUE);
	}

	public EntityLiving(World var1) {
		super(var1);
		this.aW();
		this.h(this.bt());
		this.k = true;
		this.aF = (float) ((Math.random() + 1.0D) * 0.009999999776482582D);
		this.b(this.locationX, this.locationY, this.locationZ);
		this.aE = (float) Math.random() * 12398.0F;
		this.yaw = (float) (Math.random() * 3.1415927410125732D * 2.0D);
		this.headPitch = this.yaw;
		this.S = 0.6F;
	}

	protected void h() {
		this.dataWatcher.a(7, Integer.valueOf(0));
		this.dataWatcher.a(8, Byte.valueOf((byte) 0));
		this.dataWatcher.a(9, Byte.valueOf((byte) 0));
		this.dataWatcher.a(6, Float.valueOf(1.0F));
	}

	protected void aW() {
		this.bx().b(afs.a);
		this.bx().b(afs.c);
		this.bx().b(afs.d);
	}

	protected void a(double var1, boolean var3, Block var4, Position var5) {
		if (!this.V()) {
			this.W();
		}

		if (!this.world.isStatic && this.fallDistance > 3.0F && var3) {
			BlockState var6 = this.world.getBlockState(var5);
			Block var7 = var6.getBlock();
			float var8 = (float) MathHelper.f(this.fallDistance - 3.0F);
			if (var7.getMaterial() != Material.AIR) {
				double var9 = (double) Math.min(0.2F + var8 / 15.0F, 10.0F);
				if (var9 > 2.5D) {
					var9 = 2.5D;
				}

				int var11 = (int) (150.0D * var9);
				((WorldServer) this.world).a(Particle.M, this.locationX, this.locationY, this.locationZ, var11, 0.0D, 0.0D, 0.0D, 0.15000000596046448D, new int[] { Block.f(var6) });
			}
		}

		super.a(var1, var3, var4, var5);
	}

	public boolean aX() {
		return false;
	}

	public void K() {
		this.aw = this.ax;
		super.K();
		this.world.B.a("livingEntityBaseTick");
		boolean var1 = this instanceof EntityHuman;
		if (this.isAlive()) {
			if (this.aj()) {
				this.damageEntity(DamageSource.STUCK, 1.0F);
			} else if (var1 && !this.world.getWorldBorder().isInside(this.getBoundingBox())) {
				double var2 = this.world.getWorldBorder().getDistance((Entity) this) + this.world.getWorldBorder().getDamageBuffer();
				if (var2 < 0.0D) {
					this.damageEntity(DamageSource.STUCK, (float) Math.max(1, MathHelper.toFixedPointInt(-var2 * this.world.getWorldBorder().getDamageAmount())));
				}
			}
		}

		if (this.T() || this.world.isStatic) {
			this.N();
		}

		boolean var7 = var1 && ((EntityHuman) this).playerProperties.invulnerable;
		if (this.isAlive() && this.a(Material.WATER)) {
			if (!this.aX() && !this.k(MobEffectList.WATER_BREATHING.id) && !var7) {
				this.h(this.j(this.getAirTicks()));
				if (this.getAirTicks() == -20) {
					this.h(0);

					for (int var3 = 0; var3 < 8; ++var3) {
						float var4 = this.random.nextFloat() - this.random.nextFloat();
						float var5 = this.random.nextFloat() - this.random.nextFloat();
						float var6 = this.random.nextFloat() - this.random.nextFloat();
						this.world.a(Particle.e, this.locationX + (double) var4, this.locationY + (double) var5, this.locationZ + (double) var6, this.motionX, this.motionY, this.motionZ, new int[0]);
					}

					this.damageEntity(DamageSource.DROWN, 2.0F);
				}
			}

			if (!this.world.isStatic && this.av() && this.vehicle instanceof EntityLiving) {
				this.mount((Entity) null);
			}
		} else {
			this.h(300);
		}

		if (this.isAlive() && this.U()) {
			this.N();
		}

		this.aC = this.aD;
		if (this.as > 0) {
			--this.as;
		}

		if (this.noDamageTicks > 0 && !(this instanceof EntityPlayer)) {
			--this.noDamageTicks;
		}

		if (this.getHealth() <= 0.0F) {
			this.aY();
		}

		if (this.aM > 0) {
			--this.aM;
		} else {
			this.aL = null;
		}

		if (this.bi != null && !this.bi.isAlive()) {
			this.bi = null;
		}

		if (this.bg != null) {
			if (!this.bg.isAlive()) {
				this.b((EntityLiving) null);
			} else if (this.ticksLived - this.bh > 100) {
				this.b((EntityLiving) null);
			}
		}

		this.bh();
		this.aS = this.aR;
		this.aH = this.aG;
		this.aJ = this.headPitch;
		this.lastYaw = this.yaw;
		this.lastPitch = this.pitch;
		this.world.B.b();
	}

	public boolean i_() {
		return false;
	}

	protected void aY() {
		++this.av;
		if (this.av == 20) {
			int var1;
			if (!this.world.isStatic && (this.aM > 0 || this.ba()) && this.aZ() && this.world.getGameRules().b("doMobLoot")) {
				var1 = this.b(this.aL);

				while (var1 > 0) {
					int var2 = EntityExpirienceOrb.a(var1);
					var1 -= var2;
					this.world.addEntity((Entity) (new EntityExpirienceOrb(this.world, this.locationX, this.locationY, this.locationZ, var2)));
				}
			}

			this.die();

			for (var1 = 0; var1 < 20; ++var1) {
				double var8 = this.random.nextGaussian() * 0.02D;
				double var4 = this.random.nextGaussian() * 0.02D;
				double var6 = this.random.nextGaussian() * 0.02D;
				this.world.a(Particle.a, this.locationX + (double) (this.random.nextFloat() * this.height * 2.0F) - (double) this.height, this.locationY + (double) (this.random.nextFloat() * this.width), this.locationZ + (double) (this.random.nextFloat() * this.height * 2.0F) - (double) this.height, var8, var4, var6, new int[0]);
			}
		}

	}

	protected boolean aZ() {
		return !this.i_();
	}

	protected int j(int var1) {
		int var2 = aph.a((Entity) this);
		return var2 > 0 && this.random.nextInt(var2 + 1) > 0 ? var1 : var1 - 1;
	}

	protected int b(EntityHuman var1) {
		return 0;
	}

	protected boolean ba() {
		return false;
	}

	public Random bb() {
		return this.random;
	}

	public EntityLiving bc() {
		return this.bg;
	}

	public int bd() {
		return this.bh;
	}

	public void b(EntityLiving var1) {
		this.bg = var1;
		this.bh = this.ticksLived;
	}

	public EntityLiving be() {
		return this.bi;
	}

	public int bf() {
		return this.bj;
	}

	public void p(Entity var1) {
		if (var1 instanceof EntityLiving) {
			this.bi = (EntityLiving) var1;
		} else {
			this.bi = null;
		}

		this.bj = this.ticksLived;
	}

	public int bg() {
		return this.aO;
	}

	public void b(NBTCompoundTag var1) {
		var1.put("HealF", this.getHealth());
		var1.put("Health", (short) ((int) Math.ceil((double) this.getHealth())));
		var1.put("HurtTime", (short) this.as);
		var1.put("HurtByTimestamp", this.bh);
		var1.put("DeathTime", (short) this.av);
		var1.put("AbsorptionAmount", this.bM());
		ItemStack[] var2 = this.getArmorContents();
		int var3 = var2.length;

		int var4;
		ItemStack var5;
		for (var4 = 0; var4 < var3; ++var4) {
			var5 = var2[var4];
			if (var5 != null) {
				this.c.a(var5.B());
			}
		}

		var1.put("Attributes", (NBTTag) afs.a(this.bx()));
		var2 = this.getArmorContents();
		var3 = var2.length;

		for (var4 = 0; var4 < var3; ++var4) {
			var5 = var2[var4];
			if (var5 != null) {
				this.c.b(var5.B());
			}
		}

		if (!this.g.isEmpty()) {
			NBTListTag var6 = new NBTListTag();
			Iterator var7 = this.g.values().iterator();

			while (var7.hasNext()) {
				MobEffect var8 = (MobEffect) var7.next();
				var6.addTag((NBTTag) var8.save(new NBTCompoundTag()));
			}

			var1.put("ActiveEffects", (NBTTag) var6);
		}

	}

	public void a(NBTCompoundTag var1) {
		this.l(var1.getFloat("AbsorptionAmount"));
		if (var1.isTagAssignableFrom("Attributes", 9) && this.world != null && !this.world.isStatic) {
			afs.a(this.bx(), var1.getList("Attributes", 10));
		}

		if (var1.isTagAssignableFrom("ActiveEffects", 9)) {
			NBTListTag var2 = var1.getList("ActiveEffects", 10);

			for (int var3 = 0; var3 < var2.getSize(); ++var3) {
				NBTCompoundTag var4 = var2.getCompound(var3);
				MobEffect var5 = MobEffect.load(var4);
				if (var5 != null) {
					this.g.put(Integer.valueOf(var5.getId()), var5);
				}
			}
		}

		if (var1.isTagAssignableFrom("HealF", 99)) {
			this.h(var1.getFloat("HealF"));
		} else {
			NBTTag var6 = var1.getTag("Health");
			if (var6 == null) {
				this.h(this.bt());
			} else if (var6.getId() == 5) {
				this.h(((NBTFloatTag) var6).toFloat());
			} else if (var6.getId() == 2) {
				this.h((float) ((NBTShortTag) var6).toShort());
			}
		}

		this.as = var1.getShort("HurtTime");
		this.av = var1.getShort("DeathTime");
		this.bh = var1.getInt("HurtByTimestamp");
	}

	protected void bh() {
		Iterator var1 = this.g.keySet().iterator();

		while (var1.hasNext()) {
			Integer var2 = (Integer) var1.next();
			MobEffect var3 = (MobEffect) this.g.get(var2);
			if (!var3.tick(this)) {
				if (!this.world.isStatic) {
					var1.remove();
					this.b(var3);
				}
			} else if (var3.getDuration() % 600 == 0) {
				this.a(var3, false);
			}
		}

		if (this.i) {
			if (!this.world.isStatic) {
				this.B();
			}

			this.i = false;
		}

		int var11 = this.dataWatcher.c(7);
		boolean var12 = this.dataWatcher.a(8) > 0;
		if (var11 > 0) {
			boolean var4 = false;
			if (!this.ay()) {
				var4 = this.random.nextBoolean();
			} else {
				var4 = this.random.nextInt(15) == 0;
			}

			if (var12) {
				var4 &= this.random.nextInt(5) == 0;
			}

			if (var4 && var11 > 0) {
				double var5 = (double) (var11 >> 16 & 255) / 255.0D;
				double var7 = (double) (var11 >> 8 & 255) / 255.0D;
				double var9 = (double) (var11 >> 0 & 255) / 255.0D;
				this.world.a(var12 ? Particle.q : Particle.p, this.locationX + (this.random.nextDouble() - 0.5D) * (double) this.height, this.locationY + this.random.nextDouble() * (double) this.width, this.locationZ + (this.random.nextDouble() - 0.5D) * (double) this.height, var5, var7, var9, new int[0]);
			}
		}

	}

	protected void B() {
		if (this.g.isEmpty()) {
			this.bi();
			this.e(false);
		} else {
			int var1 = PotionBrewer.a(this.g.values());
			this.dataWatcher.b(8, Byte.valueOf((byte) (PotionBrewer.b(this.g.values()) ? 1 : 0)));
			this.dataWatcher.b(7, Integer.valueOf(var1));
			this.e(this.k(MobEffectList.INVISIBILITY.id));
		}

	}

	protected void bi() {
		this.dataWatcher.b(8, Byte.valueOf((byte) 0));
		this.dataWatcher.b(7, Integer.valueOf(0));
	}

	public void bj() {
		Iterator var1 = this.g.keySet().iterator();

		while (var1.hasNext()) {
			Integer var2 = (Integer) var1.next();
			MobEffect var3 = (MobEffect) this.g.get(var2);
			if (!this.world.isStatic) {
				var1.remove();
				this.b(var3);
			}
		}

	}

	public Collection bk() {
		return this.g.values();
	}

	public boolean k(int var1) {
		return this.g.containsKey(Integer.valueOf(var1));
	}

	public boolean a(MobEffectList var1) {
		return this.g.containsKey(Integer.valueOf(var1.id));
	}

	public MobEffect b(MobEffectList var1) {
		return (MobEffect) this.g.get(Integer.valueOf(var1.id));
	}

	public void c(MobEffect var1) {
		if (this.d(var1)) {
			if (this.g.containsKey(Integer.valueOf(var1.getId()))) {
				((MobEffect) this.g.get(Integer.valueOf(var1.getId()))).extend(var1);
				this.a((MobEffect) this.g.get(Integer.valueOf(var1.getId())), true);
			} else {
				this.g.put(Integer.valueOf(var1.getId()), var1);
				this.a(var1);
			}

		}
	}

	public boolean d(MobEffect var1) {
		if (this.by() == EnumMonsterType.b) {
			int var2 = var1.getId();
			if (var2 == MobEffectList.REGENERATION.id || var2 == MobEffectList.POISON.id) {
				return false;
			}
		}

		return true;
	}

	public boolean bl() {
		return this.by() == EnumMonsterType.b;
	}

	public void m(int var1) {
		MobEffect var2 = (MobEffect) this.g.remove(Integer.valueOf(var1));
		if (var2 != null) {
			this.b(var2);
		}

	}

	protected void a(MobEffect var1) {
		this.i = true;
		if (!this.world.isStatic) {
			MobEffectList.byId[var1.getId()].b(this, this.bx(), var1.getAmplifier());
		}

	}

	protected void a(MobEffect var1, boolean var2) {
		this.i = true;
		if (var2 && !this.world.isStatic) {
			MobEffectList.byId[var1.getId()].a(this, this.bx(), var1.getAmplifier());
			MobEffectList.byId[var1.getId()].b(this, this.bx(), var1.getAmplifier());
		}

	}

	protected void b(MobEffect var1) {
		this.i = true;
		if (!this.world.isStatic) {
			MobEffectList.byId[var1.getId()].a(this, this.bx(), var1.getAmplifier());
		}

	}

	public void g(float var1) {
		float var2 = this.getHealth();
		if (var2 > 0.0F) {
			this.h(var2 + var1);
		}

	}

	public final float getHealth() {
		return this.dataWatcher.getData(6);
	}

	public void h(float var1) {
		this.dataWatcher.b(6, Float.valueOf(MathHelper.a(var1, 0.0F, this.bt())));
	}

	public boolean damageEntity(DamageSource var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else if (this.world.isStatic) {
			return false;
		} else {
			this.aO = 0;
			if (this.getHealth() <= 0.0F) {
				return false;
			} else if (var1.o() && this.a(MobEffectList.FIRE_RESISTANCE)) {
				return false;
			} else {
				if ((var1 == DamageSource.ANVIL || var1 == DamageSource.FALLING_BLOCK) && this.p(4) != null) {
					this.p(4).a((int) (var2 * 4.0F + this.random.nextFloat() * var2 * 2.0F), this);
					var2 *= 0.75F;
				}

				this.az = 1.5F;
				boolean var3 = true;
				if ((float) this.noDamageTicks > (float) this.aB / 2.0F) {
					if (var2 <= this.aV) {
						return false;
					}

					this.d(var1, var2 - this.aV);
					this.aV = var2;
					var3 = false;
				} else {
					this.aV = var2;
					this.noDamageTicks = this.aB;
					this.d(var1, var2);
					this.as = this.at = 10;
				}

				this.au = 0.0F;
				Entity var4 = var1.j();
				if (var4 != null) {
					if (var4 instanceof EntityLiving) {
						this.b((EntityLiving) var4);
					}

					if (var4 instanceof EntityHuman) {
						this.aM = 100;
						this.aL = (EntityHuman) var4;
					} else if (var4 instanceof EntityWolf) {
						EntityWolf var5 = (EntityWolf) var4;
						if (var5.cj()) {
							this.aM = 100;
							this.aL = null;
						}
					}
				}

				if (var3) {
					this.world.broadcastEntityEffect((Entity) this, (byte) 2);
					if (var1 != DamageSource.DROWN) {
						this.ac();
					}

					if (var4 != null) {
						double var9 = var4.locationX - this.locationX;

						double var7;
						for (var7 = var4.locationZ - this.locationZ; var9 * var9 + var7 * var7 < 1.0E-4D; var7 = (Math.random() - Math.random()) * 0.01D) {
							var9 = (Math.random() - Math.random()) * 0.01D;
						}

						this.au = (float) (Math.atan2(var7, var9) * 180.0D / 3.1415927410125732D - (double) this.yaw);
						this.a(var4, var2, var9, var7);
					} else {
						this.au = (float) ((int) (Math.random() * 2.0D) * 180);
					}
				}

				String var10;
				if (this.getHealth() <= 0.0F) {
					var10 = this.bo();
					if (var3 && var10 != null) {
						this.a(var10, this.bA(), this.bB());
					}

					this.a(var1);
				} else {
					var10 = this.bn();
					if (var3 && var10 != null) {
						this.a(var10, this.bA(), this.bB());
					}
				}

				return true;
			}
		}
	}

	public void b(ItemStack var1) {
		this.a("random.break", 0.8F, 0.8F + this.world.s.nextFloat() * 0.4F);

		for (int var2 = 0; var2 < 5; ++var2) {
			Vec3D var3 = new Vec3D(((double) this.random.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, 0.0D);
			var3 = var3.a(-this.pitch * 3.1415927F / 180.0F);
			var3 = var3.b(-this.yaw * 3.1415927F / 180.0F);
			double var4 = (double) (-this.random.nextFloat()) * 0.6D - 0.3D;
			Vec3D var6 = new Vec3D(((double) this.random.nextFloat() - 0.5D) * 0.3D, var4, 0.6D);
			var6 = var6.a(-this.pitch * 3.1415927F / 180.0F);
			var6 = var6.b(-this.yaw * 3.1415927F / 180.0F);
			var6 = var6.b(this.locationX, this.locationY + (double) this.getHeadHeight(), this.locationZ);
			this.world.a(Particle.K, var6.x, var6.y, var6.z, var3.x, var3.y + 0.05D, var3.z, new int[] { Item.getId(var1.getItem()) });
		}

	}

	public void a(DamageSource var1) {
		Entity var2 = var1.j();
		EntityLiving var3 = this.getKiller();
		if (this.aU >= 0 && var3 != null) {
			var3.b(this, this.aU);
		}

		if (var2 != null) {
			var2.a(this);
		}

		this.aN = true;
		this.br().g();
		if (!this.world.isStatic) {
			int var4 = 0;
			if (var2 instanceof EntityHuman) {
				var4 = aph.i((EntityLiving) var2);
			}

			if (this.aZ() && this.world.getGameRules().b("doMobLoot")) {
				this.dropDeathLoot(this.aM > 0, var4);
				this.a(this.aM > 0, var4);
				if (this.aM > 0 && this.random.nextFloat() < 0.025F + (float) var4 * 0.01F) {
					this.bp();
				}
			}
		}

		this.world.broadcastEntityEffect((Entity) this, (byte) 3);
	}

	protected void a(boolean var1, int var2) {
	}

	public void a(Entity var1, float var2, double var3, double var5) {
		if (this.random.nextDouble() >= this.a(afs.c).e()) {
			this.ai = true;
			float var7 = MathHelper.sqrt(var3 * var3 + var5 * var5);
			float var8 = 0.4F;
			this.motionX /= 2.0D;
			this.motionY /= 2.0D;
			this.motionZ /= 2.0D;
			this.motionX -= var3 / (double) var7 * (double) var8;
			this.motionY += (double) var8;
			this.motionZ -= var5 / (double) var7 * (double) var8;
			if (this.motionY > 0.4000000059604645D) {
				this.motionY = 0.4000000059604645D;
			}

		}
	}

	protected String bn() {
		return "game.neutral.hurt";
	}

	protected String bo() {
		return "game.neutral.die";
	}

	protected void bp() {
	}

	protected void dropDeathLoot(boolean var1, int var2) {
	}

	public boolean j_() {
		int var1 = MathHelper.toFixedPointInt(this.locationX);
		int var2 = MathHelper.toFixedPointInt(this.getBoundingBox().minY);
		int var3 = MathHelper.toFixedPointInt(this.locationZ);
		Block var4 = this.world.getBlockState(new Position(var1, var2, var3)).getBlock();
		return (var4 == Blocks.LADDER || var4 == Blocks.VINE) && (!(this instanceof EntityHuman) || !((EntityHuman) this).isSpectator());
	}

	public boolean isAlive() {
		return !this.dead && this.getHealth() > 0.0F;
	}

	public void e(float var1, float var2) {
		super.e(var1, var2);
		MobEffect var3 = this.b(MobEffectList.JUMP);
		float var4 = var3 != null ? (float) (var3.getAmplifier() + 1) : 0.0F;
		int var5 = MathHelper.f((var1 - 3.0F - var4) * var2);
		if (var5 > 0) {
			this.a(this.n(var5), 1.0F, 1.0F);
			this.damageEntity(DamageSource.FALL, (float) var5);
			int var6 = MathHelper.toFixedPointInt(this.locationX);
			int var7 = MathHelper.toFixedPointInt(this.locationY - 0.20000000298023224D);
			int var8 = MathHelper.toFixedPointInt(this.locationZ);
			Block var9 = this.world.getBlockState(new Position(var6, var7, var8)).getBlock();
			if (var9.getMaterial() != Material.AIR) {
				BlockSound var10 = var9.H;
				this.a(var10.c(), var10.d() * 0.5F, var10.e() * 0.75F);
			}
		}

	}

	protected String n(int var1) {
		return var1 > 4 ? "game.neutral.hurt.fall.big" : "game.neutral.hurt.fall.small";
	}

	public int bq() {
		int var1 = 0;
		ItemStack[] var2 = this.getArmorContents();
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			ItemStack var5 = var2[var4];
			if (var5 != null && var5.getItem() instanceof ItemArmor) {
				int var6 = ((ItemArmor) var5.getItem()).c;
				var1 += var6;
			}
		}

		return var1;
	}

	protected void i(float var1) {
	}

	protected float b(DamageSource var1, float var2) {
		if (!var1.e()) {
			int var3 = 25 - this.bq();
			float var4 = var2 * (float) var3;
			this.i(var2);
			var2 = var4 / 25.0F;
		}

		return var2;
	}

	protected float c(DamageSource var1, float var2) {
		if (var1.h()) {
			return var2;
		} else {
			int var3;
			int var4;
			float var5;
			if (this.a(MobEffectList.RESISTANCE) && var1 != DamageSource.OUT_OF_WORLD) {
				var3 = (this.b(MobEffectList.RESISTANCE).getAmplifier() + 1) * 5;
				var4 = 25 - var3;
				var5 = var2 * (float) var4;
				var2 = var5 / 25.0F;
			}

			if (var2 <= 0.0F) {
				return 0.0F;
			} else {
				var3 = aph.a(this.getArmorContents(), var1);
				if (var3 > 20) {
					var3 = 20;
				}

				if (var3 > 0 && var3 <= 20) {
					var4 = 25 - var3;
					var5 = var2 * (float) var4;
					var2 = var5 / 25.0F;
				}

				return var2;
			}
		}
	}

	protected void d(DamageSource var1, float var2) {
		if (!this.b(var1)) {
			var2 = this.b(var1, var2);
			var2 = this.c(var1, var2);
			float var3 = var2;
			var2 = Math.max(var2 - this.bM(), 0.0F);
			this.l(this.bM() - (var3 - var2));
			if (var2 != 0.0F) {
				float var4 = this.getHealth();
				this.h(var4 - var2);
				this.br().a(var1, var4, var2);
				this.l(this.bM() - var2);
			}
		}
	}

	public CombatTracker br() {
		return this.f;
	}

	public EntityLiving getKiller() {
		return (EntityLiving) (this.f.getEntity() != null ? this.f.getEntity() : (this.aL != null ? this.aL : (this.bg != null ? this.bg : null)));
	}

	public final float bt() {
		return (float) this.a(afs.a).e();
	}

	public final int bu() {
		return this.dataWatcher.a(9);
	}

	public final void o(int var1) {
		this.dataWatcher.b(9, Byte.valueOf((byte) var1));
	}

	private int n() {
		return this.a(MobEffectList.FASTER_DIG) ? 6 - (1 + this.b(MobEffectList.FASTER_DIG).getAmplifier()) * 1 : (this.a(MobEffectList.SLOWER_DIG) ? 6 + (1 + this.b(MobEffectList.SLOWER_DIG).getAmplifier()) * 2 : 6);
	}

	public void performHandAnimation() {
		if (!this.ap || this.aq >= this.n() / 2 || this.aq < 0) {
			this.aq = -1;
			this.ap = true;
			if (this.world instanceof WorldServer) {
				((WorldServer) this.world).getEntityTracker().a((Entity) this, (new PacketPlayOutAnimation(this, 0)));
			}
		}

	}

	protected void O() {
		this.damageEntity(DamageSource.OUT_OF_WORLD, 4.0F);
	}

	protected void bw() {
		int var1 = this.n();
		if (this.ap) {
			++this.aq;
			if (this.aq >= var1) {
				this.aq = 0;
				this.ap = false;
			}
		} else {
			this.aq = 0;
		}

		this.ax = (float) this.aq / (float) var1;
	}

	public AttributeInstance a(xy var1) {
		return this.bx().a(var1);
	}

	public yc bx() {
		if (this.c == null) {
			this.c = new yf();
		}

		return this.c;
	}

	public EnumMonsterType by() {
		return EnumMonsterType.a;
	}

	public abstract ItemStack getItemInHand();

	public abstract ItemStack p(int var1);

	public abstract void setArmor(int var1, ItemStack var2);

	public void setSprinting(boolean flag) {
		super.setSprinting(flag);
		AttributeInstance instance = this.a(afs.d);
		if (instance.a(a) != null) {
			instance.c(b);
		}

		if (flag) {
			instance.b(b);
		}
	}

	public abstract ItemStack[] getArmorContents();

	protected float bA() {
		return 1.0F;
	}

	protected float bB() {
		return this.i_() ? (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.5F : (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F;
	}

	protected boolean bC() {
		return this.getHealth() <= 0.0F;
	}

	public void q(Entity var1) {
		double var3 = var1.locationX;
		double var5 = var1.getBoundingBox().minY + (double) var1.width;
		double var7 = var1.locationZ;
		byte var9 = 1;

		for (int var10 = -var9; var10 <= var9; ++var10) {
			for (int var11 = -var9; var11 < var9; ++var11) {
				if (var10 != 0 || var11 != 0) {
					int var12 = (int) (this.locationX + (double) var10);
					int var13 = (int) (this.locationZ + (double) var11);
					AxisAlignedBB var2 = this.getBoundingBox().c((double) var10, 1.0D, (double) var11);
					if (this.world.a(var2).isEmpty()) {
						if (World.a((ard) this.world, new Position(var12, (int) this.locationY, var13))) {
							this.updatePosition(this.locationX + (double) var10, this.locationY + 1.0D, this.locationZ + (double) var11);
							return;
						}

						if (World.a((ard) this.world, new Position(var12, (int) this.locationY - 1, var13)) || this.world.getBlockState(new Position(var12, (int) this.locationY - 1, var13)).getBlock().getMaterial() == Material.WATER) {
							var3 = this.locationX + (double) var10;
							var5 = this.locationY + 1.0D;
							var7 = this.locationZ + (double) var11;
						}
					}
				}
			}
		}

		this.updatePosition(var3, var5, var7);
	}

	protected float bD() {
		return 0.42F;
	}

	protected void jump() {
		this.motionY = (double) this.bD();
		if (this.a(MobEffectList.JUMP)) {
			this.motionY += (double) ((float) (this.b(MobEffectList.JUMP).getAmplifier() + 1) * 0.1F);
		}

		if (this.ax()) {
			float var1 = this.yaw * 0.017453292F;
			this.motionX -= (double) (MathHelper.a(var1) * 0.2F);
			this.motionZ += (double) (MathHelper.b(var1) * 0.2F);
		}

		this.ai = true;
	}

	protected void bF() {
		this.motionY += 0.03999999910593033D;
	}

	protected void bG() {
		this.motionY += 0.03999999910593033D;
	}

	public void g(float var1, float var2) {
		double var8;
		float var10;
		if (this.bL()) {
			float var5;
			float var6;
			if (this.V() && (!(this instanceof EntityHuman) || !((EntityHuman) this).playerProperties.flying)) {
				var8 = this.locationY;
				var5 = 0.8F;
				var6 = 0.02F;
				var10 = (float) aph.b((Entity) this);
				if (var10 > 3.0F) {
					var10 = 3.0F;
				}

				if (!this.onGround) {
					var10 *= 0.5F;
				}

				if (var10 > 0.0F) {
					var5 += (0.54600006F - var5) * var10 / 3.0F;
					var6 += (this.bH() * 1.0F - var6) * var10 / 3.0F;
				}

				this.a(var1, var2, var6);
				this.move(this.motionX, this.motionY, this.motionZ);
				this.motionX *= (double) var5;
				this.motionY *= 0.800000011920929D;
				this.motionZ *= (double) var5;
				this.motionY -= 0.02D;
				if (this.positionChanged && this.c(this.motionX, this.motionY + 0.6000000238418579D - this.locationY + var8, this.motionZ)) {
					this.motionY = 0.30000001192092896D;
				}
			} else if (this.ab() && (!(this instanceof EntityHuman) || !((EntityHuman) this).playerProperties.flying)) {
				var8 = this.locationY;
				this.a(var1, var2, 0.02F);
				this.move(this.motionX, this.motionY, this.motionZ);
				this.motionX *= 0.5D;
				this.motionY *= 0.5D;
				this.motionZ *= 0.5D;
				this.motionY -= 0.02D;
				if (this.positionChanged && this.c(this.motionX, this.motionY + 0.6000000238418579D - this.locationY + var8, this.motionZ)) {
					this.motionY = 0.30000001192092896D;
				}
			} else {
				float var3 = 0.91F;
				if (this.onGround) {
					var3 = this.world.getBlockState(new Position(MathHelper.toFixedPointInt(this.locationX), MathHelper.toFixedPointInt(this.getBoundingBox().minY) - 1, MathHelper.toFixedPointInt(this.locationZ))).getBlock().K * 0.91F;
				}

				float var4 = 0.16277136F / (var3 * var3 * var3);
				if (this.onGround) {
					var5 = this.bH() * var4;
				} else {
					var5 = this.aK;
				}

				this.a(var1, var2, var5);
				var3 = 0.91F;
				if (this.onGround) {
					var3 = this.world.getBlockState(new Position(MathHelper.toFixedPointInt(this.locationX), MathHelper.toFixedPointInt(this.getBoundingBox().minY) - 1, MathHelper.toFixedPointInt(this.locationZ))).getBlock().K * 0.91F;
				}

				if (this.j_()) {
					var6 = 0.15F;
					this.motionX = MathHelper.a(this.motionX, (double) (-var6), (double) var6);
					this.motionZ = MathHelper.a(this.motionZ, (double) (-var6), (double) var6);
					this.fallDistance = 0.0F;
					if (this.motionY < -0.15D) {
						this.motionY = -0.15D;
					}

					boolean var7 = this.aw() && this instanceof EntityHuman;
					if (var7 && this.motionY < 0.0D) {
						this.motionY = 0.0D;
					}
				}

				this.move(this.motionX, this.motionY, this.motionZ);
				if (this.positionChanged && this.j_()) {
					this.motionY = 0.2D;
				}

				if (this.world.isStatic && (!this.world.isLoaded(new Position((int) this.locationX, 0, (int) this.locationZ)) || !this.world.getChunk(new Position((int) this.locationX, 0, (int) this.locationZ)).o())) {
					if (this.locationY > 0.0D) {
						this.motionY = -0.1D;
					} else {
						this.motionY = 0.0D;
					}
				} else {
					this.motionY -= 0.08D;
				}

				this.motionY *= 0.9800000190734863D;
				this.motionX *= (double) var3;
				this.motionZ *= (double) var3;
			}
		}

		this.ay = this.az;
		var8 = this.locationX - this.previousX;
		double var9 = this.locationZ - this.previousZ;
		var10 = MathHelper.sqrt(var8 * var8 + var9 * var9) * 4.0F;
		if (var10 > 1.0F) {
			var10 = 1.0F;
		}

		this.az += (var10 - this.az) * 0.4F;
		this.aA += this.az;
	}

	public float bH() {
		return this.bk;
	}

	public void j(float var1) {
		this.bk = var1;
	}

	public boolean r(Entity var1) {
		this.p(var1);
		return false;
	}

	public boolean isSleeping() {
		return false;
	}

	public void s_() {
		super.s_();
		if (!this.world.isStatic) {
			int var1 = this.bu();
			if (var1 > 0) {
				if (this.ar <= 0) {
					this.ar = 20 * (30 - var1);
				}

				--this.ar;
				if (this.ar <= 0) {
					this.o(var1 - 1);
				}
			}

			for (int var2 = 0; var2 < 5; ++var2) {
				ItemStack var3 = this.h[var2];
				ItemStack var4 = this.p(var2);
				if (!ItemStack.matches(var4, var3)) {
					((WorldServer) this.world).getEntityTracker().a((Entity) this, (Packet) (new PacketPlayOutEntityEquipment(this.getId(), var2, var4)));
					if (var3 != null) {
						this.c.a(var3.B());
					}

					if (var4 != null) {
						this.c.b(var4.B());
					}

					this.h[var2] = var4 == null ? null : var4.getCopy();
				}
			}

			if (this.ticksLived % 20 == 0) {
				this.br().g();
			}
		}

		this.m();
		double var9 = this.locationX - this.previousX;
		double var10 = this.locationZ - this.previousZ;
		float var5 = (float) (var9 * var9 + var10 * var10);
		float var6 = this.aG;
		float var7 = 0.0F;
		this.aP = this.aQ;
		float var8 = 0.0F;
		if (var5 > 0.0025000002F) {
			var8 = 1.0F;
			var7 = (float) Math.sqrt((double) var5) * 3.0F;
			var6 = (float) Math.atan2(var10, var9) * 180.0F / 3.1415927F - 90.0F;
		}

		if (this.ax > 0.0F) {
			var6 = this.yaw;
		}

		if (!this.onGround) {
			var8 = 0.0F;
		}

		this.aQ += (var8 - this.aQ) * 0.3F;
		this.world.B.a("headTurn");
		var7 = this.h(var6, var7);
		this.world.B.b();
		this.world.B.a("rangeChecks");

		while (this.yaw - this.lastYaw < -180.0F) {
			this.lastYaw -= 360.0F;
		}

		while (this.yaw - this.lastYaw >= 180.0F) {
			this.lastYaw += 360.0F;
		}

		while (this.aG - this.aH < -180.0F) {
			this.aH -= 360.0F;
		}

		while (this.aG - this.aH >= 180.0F) {
			this.aH += 360.0F;
		}

		while (this.pitch - this.lastPitch < -180.0F) {
			this.lastPitch -= 360.0F;
		}

		while (this.pitch - this.lastPitch >= 180.0F) {
			this.lastPitch += 360.0F;
		}

		while (this.headPitch - this.aJ < -180.0F) {
			this.aJ -= 360.0F;
		}

		while (this.headPitch - this.aJ >= 180.0F) {
			this.aJ += 360.0F;
		}

		this.world.B.b();
		this.aR += var7;
	}

	protected float h(float var1, float var2) {
		float var3 = MathHelper.g(var1 - this.aG);
		this.aG += var3 * 0.3F;
		float var4 = MathHelper.g(this.yaw - this.aG);
		boolean var5 = var4 < -90.0F || var4 >= 90.0F;
		if (var4 < -75.0F) {
			var4 = -75.0F;
		}

		if (var4 >= 75.0F) {
			var4 = 75.0F;
		}

		this.aG = this.yaw - var4;
		if (var4 * var4 > 2500.0F) {
			this.aG += var4 * 0.2F;
		}

		if (var5) {
			var2 *= -1.0F;
		}

		return var2;
	}

	public void m() {
		if (this.bl > 0) {
			--this.bl;
		}

		if (this.ba > 0) {
			double var1 = this.locationX + (this.bb - this.locationX) / (double) this.ba;
			double var3 = this.locationY + (this.bc - this.locationY) / (double) this.ba;
			double var5 = this.locationZ + (this.bd - this.locationZ) / (double) this.ba;
			double var7 = MathHelper.g(this.be - (double) this.yaw);
			this.yaw = (float) ((double) this.yaw + var7 / (double) this.ba);
			this.pitch = (float) ((double) this.pitch + (this.bf - (double) this.pitch) / (double) this.ba);
			--this.ba;
			this.b(var1, var3, var5);
			this.b(this.yaw, this.pitch);
		} else if (!this.bL()) {
			this.motionX *= 0.98D;
			this.motionY *= 0.98D;
			this.motionZ *= 0.98D;
		}

		if (Math.abs(this.motionX) < 0.005D) {
			this.motionX = 0.0D;
		}

		if (Math.abs(this.motionY) < 0.005D) {
			this.motionY = 0.0D;
		}

		if (Math.abs(this.motionZ) < 0.005D) {
			this.motionZ = 0.0D;
		}

		this.world.B.a("ai");
		if (this.bC()) {
			this.aW = false;
			this.aX = 0.0F;
			this.aY = 0.0F;
			this.aZ = 0.0F;
		} else if (this.bL()) {
			this.world.B.a("newAi");
			this.bJ();
			this.world.B.b();
		}

		this.world.B.b();
		this.world.B.a("jump");
		if (this.aW) {
			if (this.V()) {
				this.bF();
			} else if (this.ab()) {
				this.bG();
			} else if (this.onGround && this.bl == 0) {
				this.jump();
				this.bl = 10;
			}
		} else {
			this.bl = 0;
		}

		this.world.B.b();
		this.world.B.a("travel");
		this.aX *= 0.98F;
		this.aY *= 0.98F;
		this.aZ *= 0.9F;
		this.g(this.aX, this.aY);
		this.world.B.b();
		this.world.B.a("push");
		if (!this.world.isStatic) {
			this.bK();
		}

		this.world.B.b();
	}

	protected void bJ() {
	}

	protected void bK() {
		List var1 = this.world.getEntities((Entity) this, this.getBoundingBox().grow(0.20000000298023224D, 0.0D, 0.20000000298023224D));
		if (var1 != null && !var1.isEmpty()) {
			for (int var2 = 0; var2 < var1.size(); ++var2) {
				Entity var3 = (Entity) var1.get(var2);
				if (var3.ae()) {
					this.s(var3);
				}
			}
		}

	}

	protected void s(Entity var1) {
		var1.i(this);
	}

	public void mount(Entity var1) {
		if (this.vehicle != null && var1 == null) {
			if (!this.world.isStatic) {
				this.q(this.vehicle);
			}

			if (this.vehicle != null) {
				this.vehicle.passenger = null;
			}

			this.vehicle = null;
		} else {
			super.mount(var1);
		}
	}

	public void ak() {
		super.ak();
		this.aP = this.aQ;
		this.aQ = 0.0F;
		this.fallDistance = 0.0F;
	}

	public void i(boolean var1) {
		this.aW = var1;
	}

	public void a(Entity var1, int var2) {
		if (!var1.dead && !this.world.isStatic) {
			EntityTracker var3 = ((WorldServer) this.world).getEntityTracker();
			if (var1 instanceof EntityItem) {
				var3.a(var1, (Packet) (new PacketPlayOutCollectItem(var1.getId(), this.getId())));
			}

			if (var1 instanceof EntityArrow) {
				var3.a(var1, (Packet) (new PacketPlayOutCollectItem(var1.getId(), this.getId())));
			}

			if (var1 instanceof EntityExpirienceOrb) {
				var3.a(var1, (Packet) (new PacketPlayOutCollectItem(var1.getId(), this.getId())));
			}
		}

	}

	public boolean t(Entity var1) {
		return this.world.a(new Vec3D(this.locationX, this.locationY + (double) this.getHeadHeight(), this.locationZ), new Vec3D(var1.locationX, var1.locationY + (double) var1.getHeadHeight(), var1.locationZ)) == null;
	}

	public Vec3D ap() {
		return this.d(1.0F);
	}

	public Vec3D d(float var1) {
		if (var1 == 1.0F) {
			return this.f(this.pitch, this.headPitch);
		} else {
			float var2 = this.lastPitch + (this.pitch - this.lastPitch) * var1;
			float var3 = this.aJ + (this.headPitch - this.aJ) * var1;
			return this.f(var2, var3);
		}
	}

	public boolean bL() {
		return !this.world.isStatic;
	}

	public boolean ad() {
		return !this.dead;
	}

	public boolean ae() {
		return !this.dead;
	}

	protected void ac() {
		this.velocityChanged = this.random.nextDouble() >= this.a(afs.c).e();
	}

	public float aD() {
		return this.headPitch;
	}

	public void f(float var1) {
		this.headPitch = var1;
	}

	public float bM() {
		return this.bm;
	}

	public void l(float var1) {
		if (var1 < 0.0F) {
			var1 = 0.0F;
		}

		this.bm = var1;
	}

	public ScoreboardTeamBase bN() {
		return this.world.Z().h(this.getUUID().toString());
	}

	public boolean c(EntityLiving var1) {
		return this.a(var1.bN());
	}

	public boolean a(ScoreboardTeamBase var1) {
		return this.bN() != null ? this.bN().a(var1) : false;
	}

	public void g_() {
	}

	public void j() {
	}

	protected void bO() {
		this.i = true;
	}

}
