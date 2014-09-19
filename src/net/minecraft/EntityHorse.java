package net.minecraft;

import com.google.common.base.Predicate;
import java.util.Iterator;
import java.util.List;

public class EntityHorse extends EntityAnimal implements IInventoryListener {

	private static final Predicate bq = new abu();
	private static final xy br = (new yg((xy) null, "horse.jumpStrength", 0.7D, 0.0D, 2.0D)).a("Jump Strength").a(true);
	private static final String[] bs = new String[] { null, "textures/entity/horse/armor/horse_armor_iron.png", "textures/entity/horse/armor/horse_armor_gold.png", "textures/entity/horse/armor/horse_armor_diamond.png" };
	private static final String[] bt = new String[] { "", "meo", "goo", "dio" };
	private static final int[] bu = new int[] { 0, 5, 7, 11 };
	private static final String[] bv = new String[] { "textures/entity/horse/horse_white.png", "textures/entity/horse/horse_creamy.png", "textures/entity/horse/horse_chestnut.png", "textures/entity/horse/horse_brown.png", "textures/entity/horse/horse_black.png", "textures/entity/horse/horse_gray.png", "textures/entity/horse/horse_darkbrown.png" };
	private static final String[] bw = new String[] { "hwh", "hcr", "hch", "hbr", "hbl", "hgr", "hdb" };
	private static final String[] bx = new String[] { null, "textures/entity/horse/horse_markings_white.png", "textures/entity/horse/horse_markings_whitefield.png", "textures/entity/horse/horse_markings_whitedots.png", "textures/entity/horse/horse_markings_blackdots.png" };
	private static final String[] by = new String[] { "", "wo_", "wmo", "wdo", "bdo" };
	private int bz;
	private int bA;
	private int bB;
	public int bk;
	public int bm;
	protected boolean bn;
	private InventoryHorseChest bC;
	private boolean bD;
	protected int bo;
	protected float bp;
	private boolean bE;
	private float bF;
	private float bG;
	private float bH;
	private float bI;
	private float bJ;
	private float bK;
	private int bL;
	private String bM;
	private String[] bN = new String[3];
	private boolean bO = false;

	public EntityHorse(World var1) {
		super(var1);
		this.a(1.4F, 1.6F);
		this.fireProof = false;
		this.o(false);
		((aay) this.s()).a(true);
		this.i.a(0, new PathfinderGoalFloat(this));
		this.i.a(1, new zu(this, 1.2D));
		this.i.a(1, new aac(this, 1.2D));
		this.i.a(2, new yt(this, 1.0D));
		this.i.a(4, new za(this, 1.0D));
		this.i.a(6, new PathfinderGoalRandomStroll(this, 0.7D));
		this.i.a(7, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 6.0F));
		this.i.a(8, new PathfinderGoalRandomLookaround(this));
		this.cY();
	}

	protected void h() {
		super.h();
		this.dataWatcher.a(16, Integer.valueOf(0));
		this.dataWatcher.a(19, Byte.valueOf((byte) 0));
		this.dataWatcher.a(20, Integer.valueOf(0));
		this.dataWatcher.a(21, String.valueOf(""));
		this.dataWatcher.a(22, Integer.valueOf(0));
	}

	public void r(int var1) {
		this.dataWatcher.b(19, Byte.valueOf((byte) var1));
		this.da();
	}

	public int cj() {
		return this.dataWatcher.a(19);
	}

	public void s(int var1) {
		this.dataWatcher.b(20, Integer.valueOf(var1));
		this.da();
	}

	public int ck() {
		return this.dataWatcher.c(20);
	}

	public String getName() {
		if (this.hasCustomName()) {
			return this.getCustomName();
		} else {
			int var1 = this.cj();
			switch (var1) {
				case 0:
				default:
					return LocaleI18n.get("entity.horse.name");
				case 1:
					return LocaleI18n.get("entity.donkey.name");
				case 2:
					return LocaleI18n.get("entity.mule.name");
				case 3:
					return LocaleI18n.get("entity.zombiehorse.name");
				case 4:
					return LocaleI18n.get("entity.skeletonhorse.name");
			}
		}
	}

	private boolean w(int var1) {
		return (this.dataWatcher.c(16) & var1) != 0;
	}

	private void c(int var1, boolean var2) {
		int var3 = this.dataWatcher.c(16);
		if (var2) {
			this.dataWatcher.b(16, Integer.valueOf(var3 | var1));
		} else {
			this.dataWatcher.b(16, Integer.valueOf(var3 & ~var1));
		}

	}

	public boolean cl() {
		return !this.i_();
	}

	public boolean cm() {
		return this.w(2);
	}

	public boolean cn() {
		return this.cl();
	}

	public String cr() {
		return this.dataWatcher.e(21);
	}

	public void b(String var1) {
		this.dataWatcher.b(21, var1);
	}

	public float cs() {
		int var1 = this.l();
		return var1 >= 0 ? 1.0F : 0.5F + (float) (-24000 - var1) / -24000.0F * 0.5F;
	}

	public void a(boolean var1) {
		if (var1) {
			this.a(this.cs());
		} else {
			this.a(1.0F);
		}

	}

	public boolean ct() {
		return this.bn;
	}

	public void l(boolean var1) {
		this.c(2, var1);
	}

	public void m(boolean var1) {
		this.bn = var1;
	}

	public boolean ca() {
		return !this.cP() && super.ca();
	}

	protected void n(float var1) {
		if (var1 > 6.0F && this.cw()) {
			this.r(false);
		}

	}

	public boolean cu() {
		return this.w(8);
	}

	public int cv() {
		return this.dataWatcher.c(22);
	}

	private int f(ItemStack var1) {
		if (var1 == null) {
			return 0;
		} else {
			Item var2 = var1.getItem();
			return var2 == Items.IRON_HORSE_ARMOR ? 1 : (var2 == Items.GOLDEN_HORSE_ARMOR ? 2 : (var2 == Items.DIAMOND_HORSE_ARMOR ? 3 : 0));
		}
	}

	public boolean cw() {
		return this.w(32);
	}

	public boolean cx() {
		return this.w(64);
	}

	public boolean cy() {
		return this.w(16);
	}

	public boolean cz() {
		return this.bD;
	}

	public void e(ItemStack var1) {
		this.dataWatcher.b(22, Integer.valueOf(this.f(var1)));
		this.da();
	}

	public void n(boolean var1) {
		this.c(16, var1);
	}

	public void o(boolean var1) {
		this.c(8, var1);
	}

	public void p(boolean var1) {
		this.bD = var1;
	}

	public void q(boolean var1) {
		this.c(4, var1);
	}

	public int cA() {
		return this.bo;
	}

	public void t(int var1) {
		this.bo = var1;
	}

	public int u(int var1) {
		int var2 = MathHelper.a(this.cA() + var1, 0, this.cG());
		this.t(var2);
		return var2;
	}

	public boolean damageEntity(DamageSource var1, float var2) {
		Entity var3 = var1.j();
		return this.passenger != null && this.passenger.equals(var3) ? false : super.damageEntity(var1, var2);
	}

	public int bq() {
		return bu[this.cv()];
	}

	public boolean ae() {
		return this.passenger == null;
	}

	public boolean cB() {
		int var1 = MathHelper.toFixedPointInt(this.locationX);
		int var2 = MathHelper.toFixedPointInt(this.locationZ);
		this.world.b(new Position(var1, 0, var2));
		return true;
	}

	public void cC() {
		if (!this.world.isStatic && this.cu()) {
			this.a(Item.getItemOf((Block) Blocks.CHEST), 1);
			this.o(false);
		}
	}

	private void cW() {
		this.dd();
		if (!this.isSilent()) {
			this.world.a((Entity) this, "eating", 1.0F, 1.0F + (this.random.nextFloat() - this.random.nextFloat()) * 0.2F);
		}

	}

	public void e(float var1, float var2) {
		if (var1 > 1.0F) {
			this.a("mob.horse.land", 0.4F, 1.0F);
		}

		int var3 = MathHelper.f((var1 * 0.5F - 3.0F) * var2);
		if (var3 > 0) {
			this.damageEntity(DamageSource.FALL, (float) var3);
			if (this.passenger != null) {
				this.passenger.damageEntity(DamageSource.FALL, (float) var3);
			}

			Block var4 = this.world.getBlockState(new Position(this.locationX, this.locationY - 0.2D - (double) this.lastYaw, this.locationZ)).getBlock();
			if (var4.getMaterial() != Material.AIR && !this.isSilent()) {
				BlockSound var5 = var4.H;
				this.world.a((Entity) this, var5.c(), var5.d() * 0.5F, var5.e() * 0.75F);
			}

		}
	}

	private int cX() {
		int var1 = this.cj();
		return this.cu() && (var1 == 1 || var1 == 2) ? 17 : 2;
	}

	private void cY() {
		InventoryHorseChest var1 = this.bC;
		this.bC = new InventoryHorseChest("HorseChest", this.cX());
		this.bC.setCustomName(this.getName());
		if (var1 != null) {
			var1.removeInventoryListener(this);
			int var2 = Math.min(var1.getSize(), this.bC.getSize());

			for (int var3 = 0; var3 < var2; ++var3) {
				ItemStack var4 = var1.getItem(var3);
				if (var4 != null) {
					this.bC.setItem(var3, var4.getCopy());
				}
			}
		}

		this.bC.addInventoryListener(this);
		this.cZ();
	}

	private void cZ() {
		if (!this.world.isStatic) {
			this.q(this.bC.getItem(0) != null);
			if (this.cM()) {
				this.e(this.bC.getItem(1));
			}
		}

	}

	public void a(InventorySubcontainer var1) {
		int var2 = this.cv();
		boolean var3 = this.cE();
		this.cZ();
		if (this.ticksLived > 20) {
			if (var2 == 0 && var2 != this.cv()) {
				this.a("mob.horse.armor", 0.5F, 1.0F);
			} else if (var2 != this.cv()) {
				this.a("mob.horse.armor", 0.5F, 1.0F);
			}

			if (!var3 && this.cE()) {
				this.a("mob.horse.leather", 0.5F, 1.0F);
			}
		}

	}

	public boolean bQ() {
		this.cB();
		return super.bQ();
	}

	protected EntityHorse a(Entity var1, double var2) {
		double var4 = Double.MAX_VALUE;
		Entity var6 = null;
		List var7 = this.world.getEntities(var1, var1.getBoundingBox().a(var2, var2, var2), bq);
		Iterator var8 = var7.iterator();

		while (var8.hasNext()) {
			Entity var9 = (Entity) var8.next();
			double var10 = var9.getDistanceSquared(var1.locationX, var1.locationY, var1.locationZ);
			if (var10 < var4) {
				var6 = var9;
				var4 = var10;
			}
		}

		return (EntityHorse) var6;
	}

	public double cD() {
		return this.a(br).e();
	}

	protected String bo() {
		this.dd();
		int var1 = this.cj();
		return var1 == 3 ? "mob.horse.zombie.death" : (var1 == 4 ? "mob.horse.skeleton.death" : (var1 != 1 && var1 != 2 ? "mob.horse.death" : "mob.horse.donkey.death"));
	}

	protected Item getLoot() {
		boolean var1 = this.random.nextInt(4) == 0;
		int var2 = this.cj();
		return var2 == 4 ? Items.BONE : (var2 == 3 ? (var1 ? null : Items.ROTTEN_FLESH) : Items.LEATHER);
	}

	protected String bn() {
		this.dd();
		if (this.random.nextInt(3) == 0) {
			this.df();
		}

		int var1 = this.cj();
		return var1 == 3 ? "mob.horse.zombie.hit" : (var1 == 4 ? "mob.horse.skeleton.hit" : (var1 != 1 && var1 != 2 ? "mob.horse.hit" : "mob.horse.donkey.hit"));
	}

	public boolean cE() {
		return this.w(4);
	}

	protected String z() {
		this.dd();
		if (this.random.nextInt(10) == 0 && !this.bC()) {
			this.df();
		}

		int var1 = this.cj();
		return var1 == 3 ? "mob.horse.zombie.idle" : (var1 == 4 ? "mob.horse.skeleton.idle" : (var1 != 1 && var1 != 2 ? "mob.horse.idle" : "mob.horse.donkey.idle"));
	}

	protected String cF() {
		this.dd();
		this.df();
		int var1 = this.cj();
		return var1 != 3 && var1 != 4 ? (var1 != 1 && var1 != 2 ? "mob.horse.angry" : "mob.horse.donkey.angry") : null;
	}

	protected void a(Position var1, Block var2) {
		BlockSound var3 = var2.H;
		if (this.world.getBlockState(var1.getUp()).getBlock() == Blocks.SNOW_LAYER) {
			var3 = Blocks.SNOW_LAYER.H;
		}

		if (!var2.getMaterial().isLiquid()) {
			int var4 = this.cj();
			if (this.passenger != null && var4 != 1 && var4 != 2) {
				++this.bL;
				if (this.bL > 5 && this.bL % 3 == 0) {
					this.a("mob.horse.gallop", var3.d() * 0.15F, var3.e());
					if (var4 == 0 && this.random.nextInt(10) == 0) {
						this.a("mob.horse.breathe", var3.d() * 0.6F, var3.e());
					}
				} else if (this.bL <= 5) {
					this.a("mob.horse.wood", var3.d() * 0.15F, var3.e());
				}
			} else if (var3 == Block.f) {
				this.a("mob.horse.wood", var3.d() * 0.15F, var3.e());
			} else {
				this.a("mob.horse.soft", var3.d() * 0.15F, var3.e());
			}
		}

	}

	protected void aW() {
		super.aW();
		this.bx().b(br);
		this.a(afs.a).a(53.0D);
		this.a(afs.d).a(0.22499999403953552D);
	}

	public int bU() {
		return 6;
	}

	public int cG() {
		return 100;
	}

	protected float bA() {
		return 0.8F;
	}

	public int w() {
		return 400;
	}

	private void da() {
		this.bM = null;
	}

	public void openChest(EntityHuman human) {
		if (!this.world.isStatic && (this.passenger == null || this.passenger == human) && this.cm()) {
			this.bC.setCustomName(this.getName());
			human.a(this, this.bC);
		}

	}

	public boolean a(EntityHuman var1) {
		ItemStack var2 = var1.playerInventory.getItemInHand();
		if (var2 != null && var2.getItem() == Items.SPAWNEGG) {
			return super.a(var1);
		} else if (!this.cm() && this.cP()) {
			return false;
		} else if (this.cm() && this.cl() && var1.aw()) {
			this.openChest(var1);
			return true;
		} else if (this.cn() && this.passenger != null) {
			return super.a(var1);
		} else {
			if (var2 != null) {
				boolean var3 = false;
				if (this.cM()) {
					byte var4 = -1;
					if (var2.getItem() == Items.IRON_HORSE_ARMOR) {
						var4 = 1;
					} else if (var2.getItem() == Items.GOLDEN_HORSE_ARMOR) {
						var4 = 2;
					} else if (var2.getItem() == Items.DIAMOND_HORSE_ARMOR) {
						var4 = 3;
					}

					if (var4 >= 0) {
						if (!this.cm()) {
							this.cU();
							return true;
						}

						this.openChest(var1);
						return true;
					}
				}

				if (!var3 && !this.cP()) {
					float var7 = 0.0F;
					short var5 = 0;
					byte var6 = 0;
					if (var2.getItem() == Items.WHEAT) {
						var7 = 2.0F;
						var5 = 20;
						var6 = 3;
					} else if (var2.getItem() == Items.SUGAR) {
						var7 = 1.0F;
						var5 = 30;
						var6 = 3;
					} else if (Block.getBlockByItem(var2.getItem()) == Blocks.HAY_BLOCK) {
						var7 = 20.0F;
						var5 = 180;
					} else if (var2.getItem() == Items.APPLE) {
						var7 = 3.0F;
						var5 = 60;
						var6 = 3;
					} else if (var2.getItem() == Items.GOLDEN_CARROT) {
						var7 = 4.0F;
						var5 = 60;
						var6 = 5;
						if (this.cm() && this.l() == 0) {
							var3 = true;
							this.c(var1);
						}
					} else if (var2.getItem() == Items.GOLDEN_APPLE) {
						var7 = 10.0F;
						var5 = 240;
						var6 = 10;
						if (this.cm() && this.l() == 0) {
							var3 = true;
							this.c(var1);
						}
					}

					if (this.getHealth() < this.bt() && var7 > 0.0F) {
						this.g(var7);
						var3 = true;
					}

					if (!this.cl() && var5 > 0) {
						this.a(var5);
						var3 = true;
					}

					if (var6 > 0 && (var3 || !this.cm()) && var6 < this.cG()) {
						var3 = true;
						this.u(var6);
					}

					if (var3) {
						this.cW();
					}
				}

				if (!this.cm() && !var3) {
					if (var2 != null && var2.a(var1, (EntityLiving) this)) {
						return true;
					}

					this.cU();
					return true;
				}

				if (!var3 && this.cN() && !this.cu() && var2.getItem() == Item.getItemOf((Block) Blocks.CHEST)) {
					this.o(true);
					this.a("mob.chickenplop", 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
					var3 = true;
					this.cY();
				}

				if (!var3 && this.cn() && !this.cE() && var2.getItem() == Items.SADDLE) {
					this.openChest(var1);
					return true;
				}

				if (var3) {
					if (!var1.playerProperties.instabuild && --var2.amount == 0) {
						var1.playerInventory.setItem(var1.playerInventory.itemInHandIndex, (ItemStack) null);
					}

					return true;
				}
			}

			if (this.cn() && this.passenger == null) {
				if (var2 != null && var2.a(var1, (EntityLiving) this)) {
					return true;
				} else {
					this.i(var1);
					return true;
				}
			} else {
				return super.a(var1);
			}
		}
	}

	private void i(EntityHuman var1) {
		var1.yaw = this.yaw;
		var1.pitch = this.pitch;
		this.r(false);
		this.s(false);
		if (!this.world.isStatic) {
			var1.mount((Entity) this);
		}

	}

	public boolean cM() {
		return this.cj() == 0;
	}

	public boolean cN() {
		int var1 = this.cj();
		return var1 == 2 || var1 == 1;
	}

	protected boolean bC() {
		return this.passenger != null && this.cE() ? true : this.cw() || this.cx();
	}

	public boolean cP() {
		int var1 = this.cj();
		return var1 == 3 || var1 == 4;
	}

	public boolean cQ() {
		return this.cP() || this.cj() == 2;
	}

	public boolean d(ItemStack var1) {
		return false;
	}

	private void dc() {
		this.bk = 1;
	}

	public void a(DamageSource var1) {
		super.a(var1);
		if (!this.world.isStatic) {
			this.cV();
		}

	}

	public void m() {
		if (this.random.nextInt(200) == 0) {
			this.dc();
		}

		super.m();
		if (!this.world.isStatic) {
			if (this.random.nextInt(900) == 0 && this.av == 0) {
				this.g(1.0F);
			}

			if (!this.cw() && this.passenger == null && this.random.nextInt(300) == 0 && this.world.getBlockState(new Position(MathHelper.toFixedPointInt(this.locationX), MathHelper.toFixedPointInt(this.locationY) - 1, MathHelper.toFixedPointInt(this.locationZ))).getBlock() == Blocks.GRASS) {
				this.r(true);
			}

			if (this.cw() && ++this.bz > 50) {
				this.bz = 0;
				this.r(false);
			}

			if (this.cy() && !this.cl() && !this.cw()) {
				EntityHorse var1 = this.a(this, 16.0D);
				if (var1 != null && this.getDistanceSquared(var1) > 4.0D) {
					this.h.a((Entity) var1);
				}
			}
		}

	}

	public void s_() {
		super.s_();
		if (this.world.isStatic && this.dataWatcher.a()) {
			this.dataWatcher.e();
			this.da();
		}

		if (this.bA > 0 && ++this.bA > 30) {
			this.bA = 0;
			this.c(128, false);
		}

		if (!this.world.isStatic && this.bB > 0 && ++this.bB > 20) {
			this.bB = 0;
			this.s(false);
		}

		if (this.bk > 0 && ++this.bk > 8) {
			this.bk = 0;
		}

		if (this.bm > 0) {
			++this.bm;
			if (this.bm > 300) {
				this.bm = 0;
			}
		}

		this.bG = this.bF;
		if (this.cw()) {
			this.bF += (1.0F - this.bF) * 0.4F + 0.05F;
			if (this.bF > 1.0F) {
				this.bF = 1.0F;
			}
		} else {
			this.bF += (0.0F - this.bF) * 0.4F - 0.05F;
			if (this.bF < 0.0F) {
				this.bF = 0.0F;
			}
		}

		this.bI = this.bH;
		if (this.cx()) {
			this.bG = this.bF = 0.0F;
			this.bH += (1.0F - this.bH) * 0.4F + 0.05F;
			if (this.bH > 1.0F) {
				this.bH = 1.0F;
			}
		} else {
			this.bE = false;
			this.bH += (0.8F * this.bH * this.bH * this.bH - this.bH) * 0.6F - 0.05F;
			if (this.bH < 0.0F) {
				this.bH = 0.0F;
			}
		}

		this.bK = this.bJ;
		if (this.w(128)) {
			this.bJ += (1.0F - this.bJ) * 0.7F + 0.05F;
			if (this.bJ > 1.0F) {
				this.bJ = 1.0F;
			}
		} else {
			this.bJ += (0.0F - this.bJ) * 0.7F - 0.05F;
			if (this.bJ < 0.0F) {
				this.bJ = 0.0F;
			}
		}

	}

	private void dd() {
		if (!this.world.isStatic) {
			this.bA = 1;
			this.c(128, true);
		}

	}

	private boolean de() {
		return this.passenger == null && this.vehicle == null && this.cm() && this.cl() && !this.cQ() && this.getHealth() >= this.bt() && this.cp();
	}

	public void f(boolean var1) {
		this.c(32, var1);
	}

	public void r(boolean var1) {
		this.f(var1);
	}

	public void s(boolean var1) {
		if (var1) {
			this.r(false);
		}

		this.c(64, var1);
	}

	private void df() {
		if (!this.world.isStatic) {
			this.bB = 1;
			this.s(true);
		}

	}

	public void cU() {
		this.df();
		String var1 = this.cF();
		if (var1 != null) {
			this.a(var1, this.bA(), this.bB());
		}

	}

	public void cV() {
		this.a((Entity) this, this.bC);
		this.cC();
	}

	private void a(Entity var1, InventoryHorseChest var2) {
		if (var2 != null && !this.world.isStatic) {
			for (int var3 = 0; var3 < var2.getSize(); ++var3) {
				ItemStack var4 = var2.getItem(var3);
				if (var4 != null) {
					this.a(var4, 0.0F);
				}
			}

		}
	}

	public boolean h(EntityHuman var1) {
		this.b(var1.getUUID().toString());
		this.l(true);
		return true;
	}

	public void g(float var1, float var2) {
		if (this.passenger != null && this.passenger instanceof EntityLiving && this.cE()) {
			this.lastYaw = this.yaw = this.passenger.yaw;
			this.pitch = this.passenger.pitch * 0.5F;
			this.b(this.yaw, this.pitch);
			this.headPitch = this.aG = this.yaw;
			var1 = ((EntityLiving) this.passenger).aX * 0.5F;
			var2 = ((EntityLiving) this.passenger).aY;
			if (var2 <= 0.0F) {
				var2 *= 0.25F;
				this.bL = 0;
			}

			if (this.onGround && this.bp == 0.0F && this.cx() && !this.bE) {
				var1 = 0.0F;
				var2 = 0.0F;
			}

			if (this.bp > 0.0F && !this.ct() && this.onGround) {
				this.motionY = this.cD() * (double) this.bp;
				if (this.a(MobEffectList.JUMP)) {
					this.motionY += (double) ((float) (this.b(MobEffectList.JUMP).getAmplifier() + 1) * 0.1F);
				}

				this.m(true);
				this.ai = true;
				if (var2 > 0.0F) {
					float var3 = MathHelper.a(this.yaw * 3.1415927F / 180.0F);
					float var4 = MathHelper.b(this.yaw * 3.1415927F / 180.0F);
					this.motionX += (double) (-0.4F * var3 * this.bp);
					this.motionZ += (double) (0.4F * var4 * this.bp);
					this.a("mob.horse.jump", 0.4F, 1.0F);
				}

				this.bp = 0.0F;
			}

			this.S = 1.0F;
			this.aK = this.bH() * 0.1F;
			if (!this.world.isStatic) {
				this.j((float) this.a(afs.d).e());
				super.g(var1, var2);
			}

			if (this.onGround) {
				this.bp = 0.0F;
				this.m(false);
			}

			this.ay = this.az;
			double var8 = this.locationX - this.previousX;
			double var5 = this.locationZ - this.previousZ;
			float var7 = MathHelper.sqrt(var8 * var8 + var5 * var5) * 4.0F;
			if (var7 > 1.0F) {
				var7 = 1.0F;
			}

			this.az += (var7 - this.az) * 0.4F;
			this.aA += this.az;
		} else {
			this.S = 0.5F;
			this.aK = 0.02F;
			super.g(var1, var2);
		}
	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.put("EatingHaystack", this.cw());
		var1.put("ChestedHorse", this.cu());
		var1.put("HasReproduced", this.cz());
		var1.put("Bred", this.cy());
		var1.put("Type", this.cj());
		var1.put("Variant", this.ck());
		var1.put("Temper", this.cA());
		var1.put("Tame", this.cm());
		var1.put("OwnerUUID", this.cr());
		if (this.cu()) {
			NBTListTag var2 = new NBTListTag();

			for (int var3 = 2; var3 < this.bC.getSize(); ++var3) {
				ItemStack var4 = this.bC.getItem(var3);
				if (var4 != null) {
					NBTCompoundTag var5 = new NBTCompoundTag();
					var5.put("Slot", (byte) var3);
					var4.write(var5);
					var2.addTag((NBTTag) var5);
				}
			}

			var1.put("Items", (NBTTag) var2);
		}

		if (this.bC.getItem(1) != null) {
			var1.put("ArmorItem", (NBTTag) this.bC.getItem(1).write(new NBTCompoundTag()));
		}

		if (this.bC.getItem(0) != null) {
			var1.put("SaddleItem", (NBTTag) this.bC.getItem(0).write(new NBTCompoundTag()));
		}

	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		this.r(var1.getBoolean("EatingHaystack"));
		this.n(var1.getBoolean("Bred"));
		this.o(var1.getBoolean("ChestedHorse"));
		this.p(var1.getBoolean("HasReproduced"));
		this.r(var1.getInt("Type"));
		this.s(var1.getInt("Variant"));
		this.t(var1.getInt("Temper"));
		this.l(var1.getBoolean("Tame"));
		String var2 = "";
		if (var1.isTagAssignableFrom("OwnerUUID", 8)) {
			var2 = var1.getString("OwnerUUID");
		} else {
			String var3 = var1.getString("Owner");
			var2 = sf.a(var3);
		}

		if (var2.length() > 0) {
			this.b(var2);
		}

		AttributeInstance var8 = this.bx().a("Speed");
		if (var8 != null) {
			this.a(afs.d).a(var8.b() * 0.25D);
		}

		if (this.cu()) {
			NBTListTag var4 = var1.getList("Items", 10);
			this.cY();

			for (int var5 = 0; var5 < var4.getSize(); ++var5) {
				NBTCompoundTag var6 = var4.getCompound(var5);
				int var7 = var6.getByte("Slot") & 255;
				if (var7 >= 2 && var7 < this.bC.getSize()) {
					this.bC.setItem(var7, ItemStack.fromNBT(var6));
				}
			}
		}

		ItemStack var9;
		if (var1.isTagAssignableFrom("ArmorItem", 10)) {
			var9 = ItemStack.fromNBT(var1.getCompound("ArmorItem"));
			if (var9 != null && a(var9.getItem())) {
				this.bC.setItem(1, var9);
			}
		}

		if (var1.isTagAssignableFrom("SaddleItem", 10)) {
			var9 = ItemStack.fromNBT(var1.getCompound("SaddleItem"));
			if (var9 != null && var9.getItem() == Items.SADDLE) {
				this.bC.setItem(0, var9);
			}
		} else if (var1.getBoolean("Saddle")) {
			this.bC.setItem(0, new ItemStack(Items.SADDLE));
		}

		this.cZ();
	}

	public boolean a(EntityAnimal var1) {
		if (var1 == this) {
			return false;
		} else if (var1.getClass() != this.getClass()) {
			return false;
		} else {
			EntityHorse var2 = (EntityHorse) var1;
			if (this.de() && var2.de()) {
				int var3 = this.cj();
				int var4 = var2.cj();
				return var3 == var4 || var3 == 0 && var4 == 1 || var3 == 1 && var4 == 0;
			} else {
				return false;
			}
		}
	}

	public EntityAgeable a(EntityAgeable var1) {
		EntityHorse var2 = (EntityHorse) var1;
		EntityHorse var3 = new EntityHorse(this.world);
		int var4 = this.cj();
		int var5 = var2.cj();
		int var6 = 0;
		if (var4 == var5) {
			var6 = var4;
		} else if (var4 == 0 && var5 == 1 || var4 == 1 && var5 == 0) {
			var6 = 2;
		}

		if (var6 == 0) {
			int var8 = this.random.nextInt(9);
			int var7;
			if (var8 < 4) {
				var7 = this.ck() & 255;
			} else if (var8 < 8) {
				var7 = var2.ck() & 255;
			} else {
				var7 = this.random.nextInt(7);
			}

			int var9 = this.random.nextInt(5);
			if (var9 < 2) {
				var7 |= this.ck() & '\uff00';
			} else if (var9 < 4) {
				var7 |= var2.ck() & '\uff00';
			} else {
				var7 |= this.random.nextInt(5) << 8 & '\uff00';
			}

			var3.s(var7);
		}

		var3.r(var6);
		double var13 = this.a(afs.a).b() + var1.a(afs.a).b() + (double) this.dg();
		var3.a(afs.a).a(var13 / 3.0D);
		double var14 = this.a(br).b() + var1.a(br).b() + this.dh();
		var3.a(br).a(var14 / 3.0D);
		double var11 = this.a(afs.d).b() + var1.a(afs.d).b() + this.di();
		var3.a(afs.d).a(var11 / 3.0D);
		return var3;
	}

	public xq a(vu var1, xq var2) {
		Object var7 = super.a(var1, var2);
		boolean var3 = false;
		int var4 = 0;
		int var8;
		if (var7 instanceof abv) {
			var8 = ((abv) var7).a;
			var4 = ((abv) var7).b & 255 | this.random.nextInt(5) << 8;
		} else {
			if (this.random.nextInt(10) == 0) {
				var8 = 1;
			} else {
				int var5 = this.random.nextInt(7);
				int var6 = this.random.nextInt(5);
				var8 = 0;
				var4 = var5 | var6 << 8;
			}

			var7 = new abv(var8, var4);
		}

		this.r(var8);
		this.s(var4);
		if (this.random.nextInt(5) == 0) {
			this.b(-24000);
		}

		if (var8 != 4 && var8 != 3) {
			this.a(afs.a).a((double) this.dg());
			if (var8 == 0) {
				this.a(afs.d).a(this.di());
			} else {
				this.a(afs.d).a(0.17499999701976776D);
			}
		} else {
			this.a(afs.a).a(15.0D);
			this.a(afs.d).a(0.20000000298023224D);
		}

		if (var8 != 2 && var8 != 1) {
			this.a(br).a(this.dh());
		} else {
			this.a(br).a(0.5D);
		}

		this.h(this.bt());
		return (xq) var7;
	}

	public void jump(int boost) {
		if (this.cE()) {
			if (boost < 0) {
				boost = 0;
			} else {
				this.bE = true;
				this.df();
			}

			if (boost >= 90) {
				this.bp = 1.0F;
			} else {
				this.bp = 0.4F + 0.4F * (float) boost / 90.0F;
			}
		}

	}

	public void al() {
		super.al();
		if (this.bI > 0.0F) {
			float var1 = MathHelper.a(this.aG * 3.1415927F / 180.0F);
			float var2 = MathHelper.b(this.aG * 3.1415927F / 180.0F);
			float var3 = 0.7F * this.bI;
			float var4 = 0.15F * this.bI;
			this.passenger.b(this.locationX + (double) (var3 * var1), this.locationY + this.an() + this.passenger.am() + (double) var4, this.locationZ - (double) (var3 * var2));
			if (this.passenger instanceof EntityLiving) {
				((EntityLiving) this.passenger).aG = this.aG;
			}
		}

	}

	private float dg() {
		return 15.0F + (float) this.random.nextInt(8) + (float) this.random.nextInt(9);
	}

	private double dh() {
		return 0.4000000059604645D + this.random.nextDouble() * 0.2D + this.random.nextDouble() * 0.2D + this.random.nextDouble() * 0.2D;
	}

	private double di() {
		return (0.44999998807907104D + this.random.nextDouble() * 0.3D + this.random.nextDouble() * 0.3D + this.random.nextDouble() * 0.3D) * 0.25D;
	}

	public static boolean a(Item var0) {
		return var0 == Items.IRON_HORSE_ARMOR || var0 == Items.GOLDEN_HORSE_ARMOR || var0 == Items.DIAMOND_HORSE_ARMOR;
	}

	public boolean j_() {
		return false;
	}

	public float getHeadHeight() {
		return this.width;
	}

	public boolean d(int var1, ItemStack var2) {
		if (var1 == 499 && this.cN()) {
			if (var2 == null && this.cu()) {
				this.o(false);
				this.cY();
				return true;
			}

			if (var2 != null && var2.getItem() == Item.getItemOf((Block) Blocks.CHEST) && !this.cu()) {
				this.o(true);
				this.cY();
				return true;
			}
		}

		int var3 = var1 - 400;
		if (var3 >= 0 && var3 < 2 && var3 < this.bC.getSize()) {
			if (var3 == 0 && var2 != null && var2.getItem() != Items.SADDLE) {
				return false;
			} else if (var3 == 1 && (var2 != null && !a(var2.getItem()) || !this.cM())) {
				return false;
			} else {
				this.bC.setItem(var3, var2);
				this.cZ();
				return true;
			}
		} else {
			int var4 = var1 - 500 + 2;
			if (var4 >= 2 && var4 < this.bC.getSize()) {
				this.bC.setItem(var4, var2);
				return true;
			} else {
				return false;
			}
		}
	}

}
