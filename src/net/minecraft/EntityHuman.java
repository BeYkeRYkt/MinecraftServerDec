package net.minecraft;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import net.minecraft.util.com.mojang.authlib.GameProfile;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import net.minecraft.server.MinecraftServer;

public abstract class EntityHuman extends EntityLiving {

	public PlayerInventory playerInventory = new PlayerInventory(this);
	private InventoryEnderChest enderChest = new InventoryEnderChest();
	public Container defaultContainer;
	public Container activeContainer;
	protected FoodMetaData fooddata = new FoodMetaData();
	protected int bk;
	public float bl;
	public float bm;
	public int bn;
	public double bo;
	public double bp;
	public double bq;
	public double br;
	public double bs;
	public double bt;
	protected boolean isSleeping;
	public Position bv;
	private int sleepTimer;
	public float bw;
	public float bx;
	private Position c;
	private boolean isSpawnForced;
	private Position e;
	public PlayerProperties playerProperties = new PlayerProperties();
	public int xpLevel;
	public int xpTotal;
	public float xp;
	private int xpSeed;
	private ItemStack g;
	private int h;
	protected float bC = 0.1F;
	protected float bD = 0.02F;
	private int i;
	private final GameProfile gameProfile;
	private boolean bG = false;
	public ado bE;

	public EntityHuman(World var1, GameProfile var2) {
		super(var1);
		this.uuid = a(var2);
		this.gameProfile = var2;
		this.defaultContainer = new PlayerCraftingContainer(this.playerInventory, !var1.isStatic, this);
		this.activeContainer = this.defaultContainer;
		Position var3 = var1.getSpawnPosition();
		this.setPositionRotation((double) var3.getX() + 0.5D, (double) (var3.getY() + 1), (double) var3.getZ() + 0.5D, 0.0F, 0.0F);
		this.aT = 180.0F;
		this.maxFireTicks = 20;
	}

	protected void aW() {
		super.aW();
		this.bx().b(afs.e).a(1.0D);
		this.a(afs.d).a(0.10000000149011612D);
	}

	protected void h() {
		super.h();
		this.dataWatcher.a(16, Byte.valueOf((byte) 0));
		this.dataWatcher.a(17, Float.valueOf(0.0F));
		this.dataWatcher.a(18, Integer.valueOf(0));
		this.dataWatcher.a(10, Byte.valueOf((byte) 0));
	}

	public boolean bR() {
		return this.g != null;
	}

	public void bT() {
		if (this.g != null) {
			this.g.b(this.world, this, this.h);
		}

		this.bU();
	}

	public void bU() {
		this.g = null;
		this.h = 0;
		if (!this.world.isStatic) {
			this.f(false);
		}

	}

	public boolean bV() {
		return this.bR() && this.g.getItem().e(this.g) == ano.d;
	}

	public void s_() {
		this.T = this.isSpectator();
		if (this.isSpectator()) {
			this.onGround = false;
		}

		if (this.g != null) {
			ItemStack var1 = this.playerInventory.getItemInHand();
			if (var1 == this.g) {
				if (this.h <= 25 && this.h % 4 == 0) {
					this.b(var1, 5);
				}

				if (--this.h == 0 && !this.world.isStatic) {
					this.s();
				}
			} else {
				this.bU();
			}
		}

		if (this.bn > 0) {
			--this.bn;
		}

		if (this.isSleeping()) {
			++this.sleepTimer;
			if (this.sleepTimer > 100) {
				this.sleepTimer = 100;
			}

			if (!this.world.isStatic) {
				if (!this.p()) {
					this.a(true, true, false);
				} else if (this.world.w()) {
					this.a(false, true, true);
				}
			}
		} else if (this.sleepTimer > 0) {
			++this.sleepTimer;
			if (this.sleepTimer >= 110) {
				this.sleepTimer = 0;
			}
		}

		super.s_();
		if (!this.world.isStatic && this.activeContainer != null && !this.activeContainer.a(this)) {
			this.n();
			this.activeContainer = this.defaultContainer;
		}

		if (this.au() && this.playerProperties.invulnerable) {
			this.N();
		}

		this.bo = this.br;
		this.bp = this.bs;
		this.bq = this.bt;
		double var14 = this.locationX - this.br;
		double var3 = this.locationY - this.bs;
		double var5 = this.locationZ - this.bt;
		double var7 = 10.0D;
		if (var14 > var7) {
			this.bo = this.br = this.locationX;
		}

		if (var5 > var7) {
			this.bq = this.bt = this.locationZ;
		}

		if (var3 > var7) {
			this.bp = this.bs = this.locationY;
		}

		if (var14 < -var7) {
			this.bo = this.br = this.locationX;
		}

		if (var5 < -var7) {
			this.bq = this.bt = this.locationZ;
		}

		if (var3 < -var7) {
			this.bp = this.bs = this.locationY;
		}

		this.br += var14 * 0.25D;
		this.bt += var5 * 0.25D;
		this.bs += var3 * 0.25D;
		if (this.vehicle == null) {
			this.e = null;
		}

		if (!this.world.isStatic) {
			this.fooddata.a(this);
			this.b(StatisticList.g);
			if (this.isAlive()) {
				this.b(StatisticList.h);
			}
		}

		int var9 = 29999999;
		double var10 = MathHelper.a(this.locationX, -2.9999999E7D, 2.9999999E7D);
		double var12 = MathHelper.a(this.locationZ, -2.9999999E7D, 2.9999999E7D);
		if (var10 != this.locationX || var12 != this.locationZ) {
			this.b(var10, this.locationY, var12);
		}

	}

	public int L() {
		return this.playerProperties.invulnerable ? 0 : 80;
	}

	protected String P() {
		return "game.player.swim";
	}

	protected String aa() {
		return "game.player.swim.splash";
	}

	public int ar() {
		return 10;
	}

	public void a(String var1, float var2, float var3) {
		this.world.a(this, var1, var2, var3);
	}

	protected void b(ItemStack var1, int var2) {
		if (var1.m() == ano.c) {
			this.a("random.drink", 0.5F, this.world.random.nextFloat() * 0.1F + 0.9F);
		}

		if (var1.m() == ano.b) {
			for (int var3 = 0; var3 < var2; ++var3) {
				Vec3D var4 = new Vec3D(((double) this.random.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, 0.0D);
				var4 = var4.a(-this.pitch * 3.1415927F / 180.0F);
				var4 = var4.b(-this.yaw * 3.1415927F / 180.0F);
				double var5 = (double) (-this.random.nextFloat()) * 0.6D - 0.3D;
				Vec3D var7 = new Vec3D(((double) this.random.nextFloat() - 0.5D) * 0.3D, var5, 0.6D);
				var7 = var7.a(-this.pitch * 3.1415927F / 180.0F);
				var7 = var7.b(-this.yaw * 3.1415927F / 180.0F);
				var7 = var7.b(this.locationX, this.locationY + (double) this.getHeadHeight(), this.locationZ);
				if (var1.f()) {
					this.world.a(Particle.K, var7.x, var7.y, var7.z, var4.x, var4.y + 0.05D, var4.z, new int[] { Item.getId(var1.getItem()), var1.getWearout() });
				} else {
					this.world.a(Particle.K, var7.x, var7.y, var7.z, var4.x, var4.y + 0.05D, var4.z, new int[] { Item.getId(var1.getItem()) });
				}
			}

			this.a("random.eat", 0.5F + 0.5F * (float) this.random.nextInt(2), (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
		}

	}

	protected void s() {
		if (this.g != null) {
			this.b(this.g, 16);
			int var1 = this.g.amount;
			ItemStack var2 = this.g.b(this.world, this);
			if (var2 != this.g || var2 != null && var2.amount != var1) {
				this.playerInventory.contents[this.playerInventory.itemInHandIndex] = var2;
				if (var2.amount == 0) {
					this.playerInventory.contents[this.playerInventory.itemInHandIndex] = null;
				}
			}

			this.bU();
		}

	}

	protected boolean bC() {
		return this.getHealth() <= 0.0F || this.isSleeping();
	}

	protected void n() {
		this.activeContainer = this.defaultContainer;
	}

	public void ak() {
		if (!this.world.isStatic && this.aw()) {
			this.mount((Entity) null);
			this.setSneaking(false);
		} else {
			double var1 = this.locationX;
			double var3 = this.locationY;
			double var5 = this.locationZ;
			float var7 = this.yaw;
			float var8 = this.pitch;
			super.ak();
			this.bl = this.bm;
			this.bm = 0.0F;
			this.l(this.locationX - var1, this.locationY - var3, this.locationZ - var5);
			if (this.vehicle instanceof EntityPig) {
				this.pitch = var8;
				this.yaw = var7;
				this.aG = ((EntityPig) this.vehicle).aG;
			}

		}
	}

	protected void bJ() {
		super.bJ();
		this.bw();
		this.headPitch = this.yaw;
	}

	public void m() {
		if (this.bk > 0) {
			--this.bk;
		}

		if (this.world.getDifficulty() == Difficulty.PEACEFUL && this.world.getGameRules().b("naturalRegeneration")) {
			if (this.getHealth() < this.bt() && this.ticksLived % 20 == 0) {
				this.g(1.0F);
			}

			if (this.fooddata.c() && this.ticksLived % 10 == 0) {
				this.fooddata.a(this.fooddata.a() + 1);
			}
		}

		this.playerInventory.k();
		this.bl = this.bm;
		super.m();
		AttributeInstance var1 = this.a(afs.d);
		if (!this.world.isStatic) {
			var1.a((double) this.playerProperties.getWalkSpeed());
		}

		this.aK = this.bD;
		if (this.ax()) {
			this.aK = (float) ((double) this.aK + (double) this.bD * 0.3D);
		}

		this.j((float) var1.e());
		float var2 = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
		float var3 = (float) (Math.atan(-this.motionY * 0.20000000298023224D) * 15.0D);
		if (var2 > 0.1F) {
			var2 = 0.1F;
		}

		if (!this.onGround || this.getHealth() <= 0.0F) {
			var2 = 0.0F;
		}

		if (this.onGround || this.getHealth() <= 0.0F) {
			var3 = 0.0F;
		}

		this.bm += (var2 - this.bm) * 0.4F;
		this.aD += (var3 - this.aD) * 0.8F;
		if (this.getHealth() > 0.0F && !this.isSpectator()) {
			AxisAlignedBB var4 = null;
			if (this.vehicle != null && !this.vehicle.dead) {
				var4 = this.getBoundingBox().a(this.vehicle.getBoundingBox()).grow(1.0D, 0.0D, 1.0D);
			} else {
				var4 = this.getBoundingBox().grow(1.0D, 0.5D, 1.0D);
			}

			List var5 = this.world.getEntities((Entity) this, var4);

			for (int var6 = 0; var6 < var5.size(); ++var6) {
				Entity var7 = (Entity) var5.get(var6);
				if (!var7.dead) {
					this.d(var7);
				}
			}
		}

	}

	private void d(Entity var1) {
		var1.d(this);
	}

	public int bW() {
		return this.dataWatcher.c(18);
	}

	public void r(int var1) {
		this.dataWatcher.b(18, Integer.valueOf(var1));
	}

	public void s(int var1) {
		int var2 = this.bW();
		this.dataWatcher.b(18, Integer.valueOf(var2 + var1));
	}

	public void a(DamageSource var1) {
		super.a(var1);
		this.a(0.2F, 0.2F);
		this.b(this.locationX, this.locationY, this.locationZ);
		this.motionY = 0.10000000149011612D;
		if (this.getName().equals("Notch")) {
			this.a(new ItemStack(Items.APPLE, 1), true, false);
		}

		if (!this.world.getGameRules().b("keepInventory")) {
			this.playerInventory.n();
		}

		if (var1 != null) {
			this.motionX = (double) (-MathHelper.b((this.au + this.yaw) * 3.1415927F / 180.0F) * 0.1F);
			this.motionZ = (double) (-MathHelper.a((this.au + this.yaw) * 3.1415927F / 180.0F) * 0.1F);
		} else {
			this.motionX = this.motionZ = 0.0D;
		}

		this.b(StatisticList.y);
		this.a(StatisticList.h);
	}

	protected String bn() {
		return "game.player.hurt";
	}

	protected String bo() {
		return "game.player.die";
	}

	public void b(Entity var1, int var2) {
		this.s(var2);
		Collection var3 = this.co().a(IScoreboardCriteria.totalKillCount);
		if (var1 instanceof EntityHuman) {
			this.b(StatisticList.B);
			var3.addAll(this.co().a(IScoreboardCriteria.playerKillCount));
			var3.addAll(this.e(var1));
		} else {
			this.b(StatisticList.z);
		}

		Iterator var4 = var3.iterator();

		while (var4.hasNext()) {
			ScoreboardObjective var5 = (ScoreboardObjective) var4.next();
			ScoreboardScore var6 = this.co().c(this.getName(), var5);
			var6.incrementScore();
		}

	}

	private Collection e(Entity var1) {
		ScoreboardTeam var2 = this.co().h(this.getName());
		if (var2 != null) {
			int var3 = var2.getColor().getId();
			if (var3 >= 0 && var3 < IScoreboardCriteria.killedByTeam.length) {
				Iterator var4 = this.co().a(IScoreboardCriteria.killedByTeam[var3]).iterator();

				while (var4.hasNext()) {
					ScoreboardObjective var5 = (ScoreboardObjective) var4.next();
					ScoreboardScore var6 = this.co().c(var1.getName(), var5);
					var6.incrementScore();
				}
			}
		}

		ScoreboardTeam var7 = this.co().h(var1.getName());
		if (var7 != null) {
			int var8 = var7.getColor().getId();
			if (var8 >= 0 && var8 < IScoreboardCriteria.teamKill.length) {
				return this.co().a(IScoreboardCriteria.teamKill[var8]);
			}
		}

		return Lists.newArrayList();
	}

	public EntityItem dropItemInHand(boolean all) {
		return this.a(this.playerInventory.splitStack(this.playerInventory.itemInHandIndex, all && this.playerInventory.getItemInHand() != null ? this.playerInventory.getItemInHand().amount : 1), false, true);
	}

	public EntityItem dropItem(ItemStack item, boolean var2) {
		return this.a(item, false, false);
	}

	public EntityItem a(ItemStack var1, boolean var2, boolean var3) {
		if (var1 == null) {
			return null;
		} else if (var1.amount == 0) {
			return null;
		} else {
			double var4 = this.locationY - 0.30000001192092896D + (double) this.getHeadHeight();
			EntityItem var6 = new EntityItem(this.world, this.locationX, var4, this.locationZ, var1);
			var6.a(40);
			if (var3) {
				var6.c(this.getName());
			}

			float var7;
			float var8;
			if (var2) {
				var7 = this.random.nextFloat() * 0.5F;
				var8 = this.random.nextFloat() * 3.1415927F * 2.0F;
				var6.motionX = (double) (-MathHelper.a(var8) * var7);
				var6.motionZ = (double) (MathHelper.b(var8) * var7);
				var6.motionY = 0.20000000298023224D;
			} else {
				var7 = 0.3F;
				var6.motionX = (double) (-MathHelper.a(this.yaw / 180.0F * 3.1415927F) * MathHelper.b(this.pitch / 180.0F * 3.1415927F) * var7);
				var6.motionZ = (double) (MathHelper.b(this.yaw / 180.0F * 3.1415927F) * MathHelper.b(this.pitch / 180.0F * 3.1415927F) * var7);
				var6.motionY = (double) (-MathHelper.a(this.pitch / 180.0F * 3.1415927F) * var7 + 0.1F);
				var8 = this.random.nextFloat() * 3.1415927F * 2.0F;
				var7 = 0.02F * this.random.nextFloat();
				var6.motionX += Math.cos((double) var8) * (double) var7;
				var6.motionY += (double) ((this.random.nextFloat() - this.random.nextFloat()) * 0.1F);
				var6.motionZ += Math.sin((double) var8) * (double) var7;
			}

			this.a(var6);
			if (var3) {
				this.b(StatisticList.v);
			}

			return var6;
		}
	}

	protected void a(EntityItem var1) {
		this.world.addEntity((Entity) var1);
	}

	public float a(Block var1) {
		float var2 = this.playerInventory.a(var1);
		if (var2 > 1.0F) {
			int var3 = aph.c(this);
			ItemStack var4 = this.playerInventory.getItemInHand();
			if (var3 > 0 && var4 != null) {
				var2 += (float) (var3 * var3 + 1);
			}
		}

		if (this.a(MobEffectList.FASTER_DIG)) {
			var2 *= 1.0F + (float) (this.b(MobEffectList.FASTER_DIG).getAmplifier() + 1) * 0.2F;
		}

		if (this.a(MobEffectList.SLOWER_DIG)) {
			float var5 = 1.0F;
			switch (this.b(MobEffectList.SLOWER_DIG).getAmplifier()) {
				case 0:
					var5 = 0.3F;
					break;
				case 1:
					var5 = 0.09F;
					break;
				case 2:
					var5 = 0.0027F;
					break;
				case 3:
				default:
					var5 = 8.1E-4F;
			}

			var2 *= var5;
		}

		if (this.a(Material.WATER) && !aph.j(this)) {
			var2 /= 5.0F;
		}

		if (!this.onGround) {
			var2 /= 5.0F;
		}

		return var2;
	}

	public boolean b(Block var1) {
		return this.playerInventory.b(var1);
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		this.uuid = a(this.gameProfile);
		NBTListTag var2 = var1.getList("Inventory", 10);
		this.playerInventory.read(var2);
		this.playerInventory.itemInHandIndex = var1.getInt("SelectedItemSlot");
		this.isSleeping = var1.getBoolean("Sleeping");
		this.sleepTimer = var1.getShort("SleepTimer");
		this.xp = var1.getFloat("XpP");
		this.xpLevel = var1.getInt("XpLevel");
		this.xpTotal = var1.getInt("XpTotal");
		this.xpSeed = var1.getInt("XpSeed");
		if (this.xpSeed == 0) {
			this.xpSeed = this.random.nextInt();
		}

		this.r(var1.getInt("Score"));
		if (this.isSleeping) {
			this.bv = new Position(this);
			this.a(true, true, false);
		}

		if (var1.isTagAssignableFrom("SpawnX", 99) && var1.isTagAssignableFrom("SpawnY", 99) && var1.isTagAssignableFrom("SpawnZ", 99)) {
			this.c = new Position(var1.getInt("SpawnX"), var1.getInt("SpawnY"), var1.getInt("SpawnZ"));
			this.isSpawnForced = var1.getBoolean("SpawnForced");
		}

		this.fooddata.a(var1);
		this.playerProperties.read(var1);
		if (var1.isTagAssignableFrom("EnderItems", 9)) {
			NBTListTag var3 = var1.getList("EnderItems", 10);
			this.enderChest.a(var3);
		}

	}

	public void b(NBTCompoundTag tag) {
		super.b(tag);
		tag.put("Inventory", (NBTTag) this.playerInventory.write(new NBTListTag()));
		tag.put("SelectedItemSlot", this.playerInventory.itemInHandIndex);
		tag.put("Sleeping", this.isSleeping);
		tag.put("SleepTimer", (short) this.sleepTimer);
		tag.put("XpP", this.xp);
		tag.put("XpLevel", this.xpLevel);
		tag.put("XpTotal", this.xpTotal);
		tag.put("XpSeed", this.xpSeed);
		tag.put("Score", this.bW());
		if (this.c != null) {
			tag.put("SpawnX", this.c.getX());
			tag.put("SpawnY", this.c.getY());
			tag.put("SpawnZ", this.c.getZ());
			tag.put("SpawnForced", this.isSpawnForced);
		}

		this.fooddata.b(tag);
		this.playerProperties.write(tag);
		tag.put("EnderItems", (NBTTag) this.enderChest.h());
		ItemStack item = this.playerInventory.getItemInHand();
		if (item != null && item.getItem() != null) {
			tag.put("SelectedItem", (NBTTag) item.write(new NBTCompoundTag()));
		}
	}

	public boolean damageEntity(DamageSource var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else if (this.playerProperties.invulnerable && !var1.g()) {
			return false;
		} else {
			this.aO = 0;
			if (this.getHealth() <= 0.0F) {
				return false;
			} else {
				if (this.isSleeping() && !this.world.isStatic) {
					this.a(true, true, false);
				}

				if (var1.r()) {
					if (this.world.getDifficulty() == Difficulty.PEACEFUL) {
						var2 = 0.0F;
					}

					if (this.world.getDifficulty() == Difficulty.EASY) {
						var2 = var2 / 2.0F + 1.0F;
					}

					if (this.world.getDifficulty() == Difficulty.HARD) {
						var2 = var2 * 3.0F / 2.0F;
					}
				}

				if (var2 == 0.0F) {
					return false;
				} else {
					Entity var3 = var1.j();
					if (var3 instanceof EntityArrow && ((EntityArrow) var3).c != null) {
						var3 = ((EntityArrow) var3).c;
					}

					return super.damageEntity(var1, var2);
				}
			}
		}
	}

	public boolean a(EntityHuman var1) {
		ScoreboardTeamBase var2 = this.bN();
		ScoreboardTeamBase var3 = var1.bN();
		return var2 == null ? true : (!var2.a(var3) ? true : var2.allowFriendlyFire());
	}

	protected void i(float var1) {
		this.playerInventory.a(var1);
	}

	public int bq() {
		return this.playerInventory.m();
	}

	public float bX() {
		int var1 = 0;
		ItemStack[] var2 = this.playerInventory.armor;
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			ItemStack var5 = var2[var4];
			if (var5 != null) {
				++var1;
			}
		}

		return (float) var1 / (float) this.playerInventory.armor.length;
	}

	protected void d(DamageSource var1, float var2) {
		if (!this.b(var1)) {
			if (!var1.e() && this.bV() && var2 > 0.0F) {
				var2 = (1.0F + var2) * 0.5F;
			}

			var2 = this.b(var1, var2);
			var2 = this.c(var1, var2);
			float var3 = var2;
			var2 = Math.max(var2 - this.bM(), 0.0F);
			this.l(this.bM() - (var3 - var2));
			if (var2 != 0.0F) {
				this.a(var1.f());
				float var4 = this.getHealth();
				this.h(this.getHealth() - var2);
				this.br().a(var1, var4, var2);
				if (var2 < 3.4028235E37F) {
					this.a(StatisticList.x, Math.round(var2 * 10.0F));
				}

			}
		}
	}

	public void a(TileEntitySign var1) {
	}

	public void a(CommandBlockListenerAbstract var1) {
	}

	public void a(IMerchant var1) {
	}

	public void a(IInventory var1) {
	}

	public void a(EntityHorse var1, IInventory var2) {
	}

	public void a(vv var1) {
	}

	public void a(ItemStack var1) {
	}

	public boolean useEntity(Entity var1) {
		if (this.isSpectator()) {
			if (var1 instanceof IInventory) {
				this.a((IInventory) var1);
			}

			return false;
		} else {
			ItemStack var2 = this.bY();
			ItemStack var3 = var2 != null ? var2.getCopy() : null;
			if (!var1.e(this)) {
				if (var2 != null && var1 instanceof EntityLiving) {
					if (this.playerProperties.instabuild) {
						var2 = var3;
					}

					if (var2.a(this, (EntityLiving) var1)) {
						if (var2.amount <= 0 && !this.playerProperties.instabuild) {
							this.bZ();
						}

						return true;
					}
				}

				return false;
			} else {
				if (var2 != null && var2 == this.bY()) {
					if (var2.amount <= 0 && !this.playerProperties.instabuild) {
						this.bZ();
					} else if (var2.amount < var3.amount && this.playerProperties.instabuild) {
						var2.amount = var3.amount;
					}
				}

				return true;
			}
		}
	}

	public ItemStack bY() {
		return this.playerInventory.getItemInHand();
	}

	public void bZ() {
		this.playerInventory.setItem(this.playerInventory.itemInHandIndex, (ItemStack) null);
	}

	public double am() {
		return -0.35D;
	}

	public void attackEntity(Entity var1) {
		if (var1.aE()) {
			if (!var1.l(this)) {
				float var2 = (float) this.a(afs.e).e();
				byte var3 = 0;
				float var4 = 0.0F;
				if (var1 instanceof EntityLiving) {
					var4 = aph.a(this.getItemInHand(), ((EntityLiving) var1).by());
				} else {
					var4 = aph.a(this.getItemInHand(), EnumMonsterType.a);
				}

				int var18 = var3 + aph.a((EntityLiving) this);
				if (this.ax()) {
					++var18;
				}

				if (var2 > 0.0F || var4 > 0.0F) {
					boolean var5 = this.fallDistance > 0.0F && !this.onGround && !this.j_() && !this.V() && !this.a(MobEffectList.BLINDNESS) && this.vehicle == null && var1 instanceof EntityLiving;
					if (var5 && var2 > 0.0F) {
						var2 *= 1.5F;
					}

					var2 += var4;
					boolean var6 = false;
					int var7 = aph.b((EntityLiving) this);
					if (var1 instanceof EntityLiving && var7 > 0 && !var1.au()) {
						var6 = true;
						var1.e(1);
					}

					double var8 = var1.motionX;
					double var10 = var1.motionY;
					double var12 = var1.motionZ;
					boolean var14 = var1.damageEntity(DamageSource.playerAttack(this), var2);
					if (var14) {
						if (var18 > 0) {
							var1.g((double) (-MathHelper.a(this.yaw * 3.1415927F / 180.0F) * (float) var18 * 0.5F), 0.1D, (double) (MathHelper.b(this.yaw * 3.1415927F / 180.0F) * (float) var18 * 0.5F));
							this.motionX *= 0.6D;
							this.motionZ *= 0.6D;
							this.setSprinting(false);
						}

						if (var1 instanceof EntityPlayer && var1.velocityChanged) {
							((EntityPlayer) var1).playerConnection.sendPacket((Packet) (new PacketPlayOutEntityVelocity(var1)));
							var1.velocityChanged = false;
							var1.motionX = var8;
							var1.motionY = var10;
							var1.motionZ = var12;
						}

						if (var5) {
							this.b(var1);
						}

						if (var4 > 0.0F) {
							this.c(var1);
						}

						if (var2 >= 18.0F) {
							this.b((Statistic) AchievementList.F);
						}

						this.p(var1);
						if (var1 instanceof EntityLiving) {
							aph.a((EntityLiving) var1, (Entity) this);
						}

						aph.b(this, var1);
						ItemStack var15 = this.bY();
						Object var16 = var1;
						if (var1 instanceof acz) {
							acy var17 = ((acz) var1).a;
							if (var17 instanceof EntityLiving) {
								var16 = (EntityLiving) var17;
							}
						}

						if (var15 != null && var16 instanceof EntityLiving) {
							var15.a((EntityLiving) var16, this);
							if (var15.amount <= 0) {
								this.bZ();
							}
						}

						if (var1 instanceof EntityLiving) {
							this.a(StatisticList.w, Math.round(var2 * 10.0F));
							if (var7 > 0) {
								var1.e(var7 * 4);
							}
						}

						this.a(0.3F);
					} else if (var6) {
						var1.N();
					}
				}

			}
		}
	}

	public void b(Entity var1) {
	}

	public void c(Entity var1) {
	}

	public void die() {
		super.die();
		this.defaultContainer.onClose(this);
		if (this.activeContainer != null) {
			this.activeContainer.onClose(this);
		}

	}

	public boolean aj() {
		return !this.isSleeping && super.aj();
	}

	public GameProfile getGameProfile() {
		return this.gameProfile;
	}

	public EnumBedResult a(Position position) {
		if (!this.world.isStatic) {
			if (this.isSleeping() || !this.isAlive()) {
				return EnumBedResult.OTHER_PROBLEM;
			}

			if (!this.world.worldProvider.isSleepAllowed()) {
				return EnumBedResult.NOT_POSSIBLE_HERE;
			}

			if (this.world.w()) {
				return EnumBedResult.NOT_POSSIBLE_NOW;
			}

			if (Math.abs(this.locationX - (double) position.getX()) > 3.0D || Math.abs(this.locationY - (double) position.getY()) > 2.0D || Math.abs(this.locationZ - (double) position.getZ()) > 3.0D) {
				return EnumBedResult.TOO_FAR_AWAY;
			}

			double var2 = 8.0D;
			double var4 = 5.0D;
			List var6 = this.world.a(EntityMonster.class, new AxisAlignedBB((double) position.getX() - var2, (double) position.getY() - var4, (double) position.getZ() - var2, (double) position.getX() + var2, (double) position.getY() + var4, (double) position.getZ() + var2));
			if (!var6.isEmpty()) {
				return EnumBedResult.NOT_SAFE;
			}
		}

		if (this.av()) {
			this.mount((Entity) null);
		}

		this.a(0.2F, 0.2F);
		if (this.world.isLoaded(position)) {
			BlockFace var7 = (BlockFace) this.world.getBlockState(position).b(avb.N);
			float var3 = 0.5F;
			float var8 = 0.5F;
			switch (ahe.a[var7.ordinal()]) {
				case 1:
					var8 = 0.9F;
					break;
				case 2:
					var8 = 0.1F;
					break;
				case 3:
					var3 = 0.1F;
					break;
				case 4:
					var3 = 0.9F;
			}

			this.a(var7);
			this.b((double) ((float) position.getX() + var3), (double) ((float) position.getY() + 0.6875F), (double) ((float) position.getZ() + var8));
		} else {
			this.b((double) ((float) position.getX() + 0.5F), (double) ((float) position.getY() + 0.6875F), (double) ((float) position.getZ() + 0.5F));
		}

		this.isSleeping = true;
		this.sleepTimer = 0;
		this.bv = position;
		this.motionX = this.motionZ = this.motionY = 0.0D;
		if (!this.world.isStatic) {
			this.world.d();
		}

		return EnumBedResult.OK;
	}

	private void a(BlockFace var1) {
		this.bw = 0.0F;
		this.bx = 0.0F;
		switch (ahe.a[var1.ordinal()]) {
			case 1:
				this.bx = -1.8F;
				break;
			case 2:
				this.bx = 1.8F;
				break;
			case 3:
				this.bw = 1.8F;
				break;
			case 4:
				this.bw = -1.8F;
		}

	}

	public void a(boolean var1, boolean var2, boolean var3) {
		this.a(0.6F, 1.8F);
		IBlockState var4 = this.world.getBlockState(this.bv);
		if (this.bv != null && var4.getBlock() == Blocks.BED) {
			this.world.setBlockAt(this.bv, var4.a(BlockBed.b, Boolean.valueOf(false)), 4);
			Position var5 = BlockBed.a(this.world, this.bv, 0);
			if (var5 == null) {
				var5 = this.bv.a();
			}

			this.b((double) ((float) var5.getX() + 0.5F), (double) ((float) var5.getY() + 0.1F), (double) ((float) var5.getZ() + 0.5F));
		}

		this.isSleeping = false;
		if (!this.world.isStatic && var2) {
			this.world.d();
		}

		this.sleepTimer = var1 ? 0 : 100;
		if (var3) {
			this.a(this.bv, false);
		}

	}

	private boolean p() {
		return this.world.getBlockState(this.bv).getBlock() == Blocks.BED;
	}

	public static Position a(World var0, Position var1, boolean var2) {
		if (var0.getBlockState(var1).getBlock() != Blocks.BED) {
			if (!var2) {
				return null;
			} else {
				Material var3 = var0.getBlockState(var1).getBlock().getMaterial();
				Material var4 = var0.getBlockState(var1.a()).getBlock().getMaterial();
				boolean var5 = !var3.isBuildable() && !var3.isLiquid();
				boolean var6 = !var4.isBuildable() && !var4.isLiquid();
				return var5 && var6 ? var1 : null;
			}
		} else {
			return BlockBed.a(var0, var1, 0);
		}
	}

	public boolean isSleeping() {
		return this.isSleeping;
	}

	public boolean ce() {
		return this.isSleeping && this.sleepTimer >= 100;
	}

	public void b(IChatBaseComponent var1) {
	}

	public Position cg() {
		return this.c;
	}

	public boolean ch() {
		return this.isSpawnForced;
	}

	public void a(Position var1, boolean var2) {
		if (var1 != null) {
			this.c = var1;
			this.isSpawnForced = var2;
		} else {
			this.c = null;
			this.isSpawnForced = false;
		}

	}

	public void b(Statistic var1) {
		this.a(var1, 1);
	}

	public void a(Statistic var1, int var2) {
	}

	public void a(Statistic var1) {
	}

	public void jump() {
		super.jump();
		this.b(StatisticList.u);
		if (this.ax()) {
			this.a(0.8F);
		} else {
			this.a(0.2F);
		}

	}

	public void g(float var1, float var2) {
		double var3 = this.locationX;
		double var5 = this.locationY;
		double var7 = this.locationZ;
		if (this.playerProperties.flying && this.vehicle == null) {
			double var9 = this.motionY;
			float var11 = this.aK;
			this.aK = this.playerProperties.getFlySpeed() * (float) (this.ax() ? 2 : 1);
			super.g(var1, var2);
			this.motionY = var9 * 0.6D;
			this.aK = var11;
		} else {
			super.g(var1, var2);
		}

		this.k(this.locationX - var3, this.locationY - var5, this.locationZ - var7);
	}

	public float bH() {
		return (float) this.a(afs.d).e();
	}

	public void k(double var1, double var3, double var5) {
		if (this.vehicle == null) {
			int var7;
			if (this.a(Material.WATER)) {
				var7 = Math.round(MathHelper.sqrt(var1 * var1 + var3 * var3 + var5 * var5) * 100.0F);
				if (var7 > 0) {
					this.a(StatisticList.p, var7);
					this.a(0.015F * (float) var7 * 0.01F);
				}
			} else if (this.V()) {
				var7 = Math.round(MathHelper.sqrt(var1 * var1 + var5 * var5) * 100.0F);
				if (var7 > 0) {
					this.a(StatisticList.l, var7);
					this.a(0.015F * (float) var7 * 0.01F);
				}
			} else if (this.j_()) {
				if (var3 > 0.0D) {
					this.a(StatisticList.n, (int) Math.round(var3 * 100.0D));
				}
			} else if (this.onGround) {
				var7 = Math.round(MathHelper.sqrt(var1 * var1 + var5 * var5) * 100.0F);
				if (var7 > 0) {
					this.a(StatisticList.i, var7);
					if (this.ax()) {
						this.a(StatisticList.k, var7);
						this.a(0.099999994F * (float) var7 * 0.01F);
					} else {
						if (this.aw()) {
							this.a(StatisticList.j, var7);
						}

						this.a(0.01F * (float) var7 * 0.01F);
					}
				}
			} else {
				var7 = Math.round(MathHelper.sqrt(var1 * var1 + var5 * var5) * 100.0F);
				if (var7 > 25) {
					this.a(StatisticList.o, var7);
				}
			}

		}
	}

	private void l(double var1, double var3, double var5) {
		if (this.vehicle != null) {
			int var7 = Math.round(MathHelper.sqrt(var1 * var1 + var3 * var3 + var5 * var5) * 100.0F);
			if (var7 > 0) {
				if (this.vehicle instanceof adx) {
					this.a(StatisticList.q, var7);
					if (this.e == null) {
						this.e = new Position(this);
					} else if (this.e.c((double) MathHelper.toFixedPointInt(this.locationX), (double) MathHelper.toFixedPointInt(this.locationY), (double) MathHelper.toFixedPointInt(this.locationZ)) >= 1000000.0D) {
						this.b((Statistic) AchievementList.q);
					}
				} else if (this.vehicle instanceof EntityBoat) {
					this.a(StatisticList.r, var7);
				} else if (this.vehicle instanceof EntityPig) {
					this.a(StatisticList.s, var7);
				} else if (this.vehicle instanceof EntityHorse) {
					this.a(StatisticList.t, var7);
				}
			}
		}

	}

	public void e(float var1, float var2) {
		if (!this.playerProperties.mayfly) {
			if (var1 >= 2.0F) {
				this.a(StatisticList.m, (int) Math.round((double) var1 * 100.0D));
			}

			super.e(var1, var2);
		}
	}

	protected void X() {
		if (!this.isSpectator()) {
			super.X();
		}

	}

	protected String n(int var1) {
		return var1 > 4 ? "game.player.hurt.fall.big" : "game.player.hurt.fall.small";
	}

	public void a(EntityLiving var1) {
		if (var1 instanceof IMonster) {
			this.b((Statistic) AchievementList.s);
		}

		MonsterEggInfo var2 = (MonsterEggInfo) EntityTypes.eggInfo.get(Integer.valueOf(EntityTypes.getFixedId(var1)));
		if (var2 != null) {
			this.b(var2.killEntityStatistic);
		}

	}

	public void aB() {
		if (!this.playerProperties.flying) {
			super.aB();
		}

	}

	public ItemStack q(int var1) {
		return this.playerInventory.e(var1);
	}

	public void u(int var1) {
		this.s(var1);
		int var2 = Integer.MAX_VALUE - this.xpTotal;
		if (var1 > var2) {
			var1 = var2;
		}

		this.xp += (float) var1 / (float) this.cj();

		for (this.xpTotal += var1; this.xp >= 1.0F; this.xp /= (float) this.cj()) {
			this.xp = (this.xp - 1.0F) * (float) this.cj();
			this.a(1);
		}

	}

	public int ci() {
		return this.xpSeed;
	}

	public void b(int var1) {
		this.xpLevel -= var1;
		if (this.xpLevel < 0) {
			this.xpLevel = 0;
			this.xp = 0.0F;
			this.xpTotal = 0;
		}

		this.xpSeed = this.random.nextInt();
	}

	public void a(int var1) {
		this.xpLevel += var1;
		if (this.xpLevel < 0) {
			this.xpLevel = 0;
			this.xp = 0.0F;
			this.xpTotal = 0;
		}

		if (var1 > 0 && this.xpLevel % 5 == 0 && (float) this.i < (float) this.ticksLived - 100.0F) {
			float var2 = this.xpLevel > 30 ? 1.0F : (float) this.xpLevel / 30.0F;
			this.world.a((Entity) this, "random.levelup", var2 * 0.75F, 1.0F);
			this.i = this.ticksLived;
		}

	}

	public int cj() {
		return this.xpLevel >= 30 ? 112 + (this.xpLevel - 30) * 9 : (this.xpLevel >= 15 ? 37 + (this.xpLevel - 15) * 5 : 7 + this.xpLevel * 2);
	}

	public void a(float var1) {
		if (!this.playerProperties.invulnerable) {
			if (!this.world.isStatic) {
				this.fooddata.a(var1);
			}

		}
	}

	public FoodMetaData ck() {
		return this.fooddata;
	}

	public boolean j(boolean var1) {
		return (var1 || this.fooddata.c()) && !this.playerProperties.invulnerable;
	}

	public boolean cl() {
		return this.getHealth() > 0.0F && this.getHealth() < this.bt();
	}

	public void a(ItemStack var1, int var2) {
		if (var1 != this.g) {
			this.g = var1;
			this.h = var2;
			if (!this.world.isStatic) {
				this.f(true);
			}

		}
	}

	public boolean cm() {
		return this.playerProperties.maybuild;
	}

	public boolean a(Position var1, BlockFace var2, ItemStack var3) {
		if (this.playerProperties.maybuild) {
			return true;
		} else if (var3 == null) {
			return false;
		} else {
			Position var4 = var1.getRelative(var2.getOpposite());
			Block var5 = this.world.getBlockState(var4).getBlock();
			return var3.d(var5) || var3.x();
		}
	}

	protected int b(EntityHuman var1) {
		if (this.world.getGameRules().b("keepInventory")) {
			return 0;
		} else {
			int var2 = this.xpLevel * 7;
			return var2 > 100 ? 100 : var2;
		}
	}

	protected boolean ba() {
		return true;
	}

	public void a(EntityHuman var1, boolean var2) {
		if (var2) {
			this.playerInventory.copyInventoryFrom(var1.playerInventory);
			this.h(var1.getHealth());
			this.fooddata = var1.fooddata;
			this.xpLevel = var1.xpLevel;
			this.xpTotal = var1.xpTotal;
			this.xp = var1.xp;
			this.r(var1.bW());
			this.an = var1.an;
		} else if (this.world.getGameRules().b("keepInventory")) {
			this.playerInventory.copyInventoryFrom(var1.playerInventory);
			this.xpLevel = var1.xpLevel;
			this.xpTotal = var1.xpTotal;
			this.xp = var1.xp;
			this.r(var1.bW());
		}

		this.enderChest = var1.enderChest;
		this.getDataWatcher().b(10, Byte.valueOf(var1.getDataWatcher().a(10)));
	}

	protected boolean r_() {
		return !this.playerProperties.flying;
	}

	public void t() {
	}

	public void a(EnumGameMode var1) {
	}

	public String getName() {
		return this.gameProfile.getName();
	}

	public InventoryEnderChest getEnderChest() {
		return this.enderChest;
	}

	public ItemStack p(int var1) {
		return var1 == 0 ? this.playerInventory.getItemInHand() : this.playerInventory.armor[var1 - 1];
	}

	public ItemStack getItemInHand() {
		return this.playerInventory.getItemInHand();
	}

	public void setArmor(int armorSlot, ItemStack item) {
		this.playerInventory.armor[armorSlot] = item;
	}

	public abstract boolean isSpectator();

	public ItemStack[] getArmorContents() {
		return this.playerInventory.armor;
	}

	public boolean aK() {
		return !this.playerProperties.flying;
	}

	public Scoreboard co() {
		return this.world.Z();
	}

	public ScoreboardTeamBase bN() {
		return this.co().h(this.getName());
	}

	public IChatBaseComponent getComponentName() {
		ChatComponentText var1 = new ChatComponentText(ScoreboardTeam.getPlayerDisplayName(this.bN(), this.getName()));
		var1.getChatModifier().a(new hm(hn.e, "/msg " + this.getName() + " "));
		var1.getChatModifier().a(this.aP());
		var1.getChatModifier().a(this.getName());
		return var1;
	}

	public float getHeadHeight() {
		float var1 = 1.62F;
		if (this.isSleeping()) {
			var1 = 0.2F;
		}

		if (this.aw()) {
			var1 -= 0.08F;
		}

		return var1;
	}

	public void l(float var1) {
		if (var1 < 0.0F) {
			var1 = 0.0F;
		}

		this.getDataWatcher().b(17, Float.valueOf(var1));
	}

	public float bM() {
		return this.getDataWatcher().getData(17);
	}

	public static UUID a(GameProfile var0) {
		UUID var1 = var0.getId();
		if (var1 == null) {
			var1 = b(var0.getName());
		}

		return var1;
	}

	public static UUID b(String var0) {
		return UUID.nameUUIDFromBytes(("OfflinePlayer:" + var0).getBytes(Charsets.UTF_8));
	}

	public boolean a(ContainerLock var1) {
		if (var1.isNotLocked()) {
			return true;
		} else {
			ItemStack var2 = this.bY();
			return var2 != null && var2.hasDisplayName() ? var2.getDisplayName().equals(var1.getUnlockingItemDisplayName()) : false;
		}
	}

	public boolean t_() {
		return MinecraftServer.getInstance().getWorld().getGameRules().b("sendCommandFeedback");
	}

	public boolean d(int var1, ItemStack var2) {
		if (var1 >= 0 && var1 < this.playerInventory.contents.length) {
			this.playerInventory.setItem(var1, var2);
			return true;
		} else {
			int var3 = var1 - 100;
			int var4;
			if (var3 >= 0 && var3 < this.playerInventory.armor.length) {
				var4 = var3 + 1;
				if (var2 != null && var2.getItem() != null) {
					if (var2.getItem() instanceof ItemArmor) {
						if (EntityInsentient.c(var2) != var4) {
							return false;
						}
					} else if (var4 != 4 || var2.getItem() != Items.SKULL && !(var2.getItem() instanceof ItemBlock)) {
						return false;
					}
				}

				this.playerInventory.setItem(var3 + this.playerInventory.contents.length, var2);
				return true;
			} else {
				var4 = var1 - 200;
				if (var4 >= 0 && var4 < this.enderChest.getSize()) {
					this.enderChest.setItem(var4, var2);
					return true;
				} else {
					return false;
				}
			}
		}
	}
}
