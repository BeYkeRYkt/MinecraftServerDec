package net.minecraft;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public abstract class EntityInsentient extends EntityLiving {

	public int a_;
	protected int b_;
	private ym a;
	protected yn f;
	protected yl g;
	private yj b;
	protected aaz h;
	protected final zc i;
	protected final zc bg;
	private EntityLiving c;
	private abd bi;
	private ItemStack[] bj = new ItemStack[5];
	protected float[] bh = new float[5];
	private boolean bk;
	private boolean bl;
	private boolean bm;
	private Entity bn;
	private NBTCompoundTag bo;

	public EntityInsentient(World var1) {
		super(var1);
		this.i = new zc(var1 != null && var1.B != null ? var1.B : null);
		this.bg = new zc(var1 != null && var1.B != null ? var1.B : null);
		this.a = new ym(this);
		this.f = new yn(this);
		this.g = new yl(this);
		this.b = new yj(this);
		this.h = this.b(var1);
		this.bi = new abd(this);

		for (int var2 = 0; var2 < this.bh.length; ++var2) {
			this.bh[var2] = 0.085F;
		}

	}

	protected void aW() {
		super.aW();
		this.bx().b(afs.b).a(16.0D);
	}

	protected aaz b(World var1) {
		return new aay(this, var1);
	}

	public ym p() {
		return this.a;
	}

	public yn q() {
		return this.f;
	}

	public yl r() {
		return this.g;
	}

	public aaz s() {
		return this.h;
	}

	public abd t() {
		return this.bi;
	}

	public EntityLiving u() {
		return this.c;
	}

	public void d(EntityLiving var1) {
		this.c = var1;
	}

	public boolean a(Class var1) {
		return var1 != EntityGhast.class;
	}

	public void v() {
	}

	protected void h() {
		super.h();
		this.dataWatcher.a(15, Byte.valueOf((byte) 0));
	}

	public int w() {
		return 80;
	}

	public void x() {
		String var1 = this.z();
		if (var1 != null) {
			this.a(var1, this.bA(), this.bB());
		}

	}

	public void K() {
		super.K();
		this.world.B.a("mobBaseTick");
		if (this.isAlive() && this.V.nextInt(1000) < this.a_++) {
			this.a_ = -this.w();
			this.x();
		}

		this.world.B.b();
	}

	protected int b(EntityHuman var1) {
		if (this.b_ > 0) {
			int var2 = this.b_;
			ItemStack[] var3 = this.getArmorContents();

			for (int var4 = 0; var4 < var3.length; ++var4) {
				if (var3[var4] != null && this.bh[var4] <= 1.0F) {
					var2 += 1 + this.V.nextInt(3);
				}
			}

			return var2;
		} else {
			return this.b_;
		}
	}

	public void y() {
		if (this.world.isStatic) {
			for (int var1 = 0; var1 < 20; ++var1) {
				double var2 = this.V.nextGaussian() * 0.02D;
				double var4 = this.V.nextGaussian() * 0.02D;
				double var6 = this.V.nextGaussian() * 0.02D;
				double var8 = 10.0D;
				this.world.a(Particle.a, this.locationX + (double) (this.V.nextFloat() * this.J * 2.0F) - (double) this.J - var2 * var8, this.locationY + (double) (this.V.nextFloat() * this.K) - var4 * var8, this.locationZ + (double) (this.V.nextFloat() * this.J * 2.0F) - (double) this.J - var6 * var8, var2, var4, var6, new int[0]);
			}
		} else {
			this.world.a((Entity) this, (byte) 20);
		}

	}

	public void s_() {
		super.s_();
		if (!this.world.isStatic) {
			this.bZ();
		}

	}

	protected float h(float var1, float var2) {
		this.b.a();
		return var2;
	}

	protected String z() {
		return null;
	}

	protected Item A() {
		return null;
	}

	protected void b(boolean var1, int var2) {
		Item var3 = this.A();
		if (var3 != null) {
			int var4 = this.V.nextInt(3);
			if (var2 > 0) {
				var4 += this.V.nextInt(var2 + 1);
			}

			for (int var5 = 0; var5 < var4; ++var5) {
				this.a(var3, 1);
			}
		}

	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.put("CanPickUpLoot", this.bX());
		var1.put("PersistenceRequired", this.bl);
		NBTListTag var2 = new NBTListTag();

		NBTCompoundTag var4;
		for (int var3 = 0; var3 < this.bj.length; ++var3) {
			var4 = new NBTCompoundTag();
			if (this.bj[var3] != null) {
				this.bj[var3].write(var4);
			}

			var2.addTag((NBTTag) var4);
		}

		var1.put("Equipment", (NBTTag) var2);
		NBTListTag var6 = new NBTListTag();

		for (int var7 = 0; var7 < this.bh.length; ++var7) {
			var6.addTag((NBTTag) (new NBTFloatTag(this.bh[var7])));
		}

		var1.put("DropChances", (NBTTag) var6);
		var1.put("Leashed", this.bm);
		if (this.bn != null) {
			var4 = new NBTCompoundTag();
			if (this.bn instanceof EntityLiving) {
				var4.put("UUIDMost", this.bn.aJ().getMostSignificantBits());
				var4.put("UUIDLeast", this.bn.aJ().getLeastSignificantBits());
			} else if (this.bn instanceof adj) {
				Position var5 = ((adj) this.bn).getPosition();
				var4.put("X", var5.getX());
				var4.put("Y", var5.getY());
				var4.put("Z", var5.getZ());
			}

			var1.put("Leash", (NBTTag) var4);
		}

		if (this.cd()) {
			var1.put("NoAI", this.cd());
		}

	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		if (var1.isTagAssignableFrom("CanPickUpLoot", 1)) {
			this.j(var1.getBoolean("CanPickUpLoot"));
		}

		this.bl = var1.getBoolean("PersistenceRequired");
		NBTListTag var2;
		int var3;
		if (var1.isTagAssignableFrom("Equipment", 9)) {
			var2 = var1.getList("Equipment", 10);

			for (var3 = 0; var3 < this.bj.length; ++var3) {
				this.bj[var3] = ItemStack.a(var2.getCompound(var3));
			}
		}

		if (var1.isTagAssignableFrom("DropChances", 9)) {
			var2 = var1.getList("DropChances", 5);

			for (var3 = 0; var3 < var2.getSize(); ++var3) {
				this.bh[var3] = var2.getFloat(var3);
			}
		}

		this.bm = var1.getBoolean("Leashed");
		if (this.bm && var1.isTagAssignableFrom("Leash", 10)) {
			this.bo = var1.getCompound("Leash");
		}

		this.k(var1.getBoolean("NoAI"));
	}

	public void m(float var1) {
		this.aY = var1;
	}

	public void j(float var1) {
		super.j(var1);
		this.m(var1);
	}

	public void m() {
		super.m();
		this.world.B.a("looting");
		if (!this.world.isStatic && this.bX() && !this.aN && this.world.Q().b("mobGriefing")) {
			List var1 = this.world.a(EntityItem.class, this.getBoundingBox().grow(1.0D, 0.0D, 1.0D));
			Iterator var2 = var1.iterator();

			while (var2.hasNext()) {
				EntityItem var3 = (EntityItem) var2.next();
				if (!var3.dead && var3.l() != null && !var3.s()) {
					this.a(var3);
				}
			}
		}

		this.world.B.b();
	}

	protected void a(EntityItem var1) {
		ItemStack var2 = var1.l();
		int var3 = c(var2);
		if (var3 > -1) {
			boolean var4 = true;
			ItemStack var5 = this.p(var3);
			if (var5 != null) {
				if (var3 == 0) {
					if (var2.getItem() instanceof ItemSword && !(var5.getItem() instanceof ItemSword)) {
						var4 = true;
					} else if (var2.getItem() instanceof ItemSword && var5.getItem() instanceof ItemSword) {
						ItemSword var6 = (ItemSword) var2.getItem();
						ItemSword var7 = (ItemSword) var5.getItem();
						if (var6.g() == var7.g()) {
							var4 = var2.getDurability() > var5.getDurability() || var2.hasTag() && !var5.hasTag();
						} else {
							var4 = var6.g() > var7.g();
						}
					} else if (var2.getItem() instanceof ItemBow && var5.getItem() instanceof ItemBow) {
						var4 = var2.hasTag() && !var5.hasTag();
					} else {
						var4 = false;
					}
				} else if (var2.getItem() instanceof ItemArmor && !(var5.getItem() instanceof ItemArmor)) {
					var4 = true;
				} else if (var2.getItem() instanceof ItemArmor && var5.getItem() instanceof ItemArmor) {
					ItemArmor var8 = (ItemArmor) var2.getItem();
					ItemArmor var10 = (ItemArmor) var5.getItem();
					if (var8.c == var10.c) {
						var4 = var2.getDurability() > var5.getDurability() || var2.hasTag() && !var5.hasTag();
					} else {
						var4 = var8.c > var10.c;
					}
				} else {
					var4 = false;
				}
			}

			if (var4 && this.a(var2)) {
				if (var5 != null && this.V.nextFloat() - 0.1F < this.bh[var3]) {
					this.a(var5, 0.0F);
				}

				if (var2.getItem() == Items.DIAMOND && var1.n() != null) {
					EntityHuman var9 = this.world.a(var1.n());
					if (var9 != null) {
						var9.b((Statistic) AchievementList.x);
					}
				}

				this.setArmor(var3, var2);
				this.bh[var3] = 2.0F;
				this.bl = true;
				this.a(var1, 1);
				var1.die();
			}
		}

	}

	protected boolean a(ItemStack var1) {
		return true;
	}

	protected boolean C() {
		return true;
	}

	protected void D() {
		if (this.bl) {
			this.aO = 0;
		} else {
			EntityHuman var1 = this.world.a(this, -1.0D);
			if (var1 != null) {
				double var2 = var1.locationX - this.locationX;
				double var4 = var1.locationY - this.locationY;
				double var6 = var1.locationZ - this.locationZ;
				double var8 = var2 * var2 + var4 * var4 + var6 * var6;
				if (this.C() && var8 > 16384.0D) {
					this.die();
				}

				if (this.aO > 600 && this.V.nextInt(800) == 0 && var8 > 1024.0D && this.C()) {
					this.die();
				} else if (var8 < 1024.0D) {
					this.aO = 0;
				}
			}

		}
	}

	protected final void bJ() {
		++this.aO;
		this.world.B.a("checkDespawn");
		this.D();
		this.world.B.b();
		this.world.B.a("sensing");
		this.bi.a();
		this.world.B.b();
		this.world.B.a("targetSelector");
		this.bg.a();
		this.world.B.b();
		this.world.B.a("goalSelector");
		this.i.a();
		this.world.B.b();
		this.world.B.a("navigation");
		this.h.k();
		this.world.B.b();
		this.world.B.a("mob tick");
		this.E();
		this.world.B.b();
		this.world.B.a("controls");
		this.world.B.a("move");
		this.f.c();
		this.world.B.c("look");
		this.a.a();
		this.world.B.c("jump");
		this.g.b();
		this.world.B.b();
		this.world.B.b();
	}

	protected void E() {
	}

	public int bP() {
		return 40;
	}

	public void a(Entity var1, float var2, float var3) {
		double var4 = var1.locationX - this.locationX;
		double var8 = var1.locationZ - this.locationZ;
		double var6;
		if (var1 instanceof EntityLiving) {
			EntityLiving var10 = (EntityLiving) var1;
			var6 = var10.locationY + (double) var10.aR() - (this.locationY + (double) this.aR());
		} else {
			var6 = (var1.getBoundingBox().minY + var1.getBoundingBox().maxY) / 2.0D - (this.locationY + (double) this.aR());
		}

		double var14 = (double) DataTypesConverter.a(var4 * var4 + var8 * var8);
		float var12 = (float) (Math.atan2(var8, var4) * 180.0D / 3.1415927410125732D) - 90.0F;
		float var13 = (float) (-(Math.atan2(var6, var14) * 180.0D / 3.1415927410125732D));
		this.pitch = this.b(this.pitch, var13, var3);
		this.yaw = this.b(this.yaw, var12, var2);
	}

	private float b(float var1, float var2, float var3) {
		float var4 = DataTypesConverter.g(var2 - var1);
		if (var4 > var3) {
			var4 = var3;
		}

		if (var4 < -var3) {
			var4 = -var3;
		}

		return var1 + var4;
	}

	public boolean bQ() {
		return true;
	}

	public boolean bR() {
		return this.world.a(this.getBoundingBox(), (Entity) this) && this.world.getCubes((Entity) this, this.getBoundingBox()).isEmpty() && !this.world.d(this.getBoundingBox());
	}

	public int bU() {
		return 4;
	}

	public int aF() {
		if (this.u() == null) {
			return 3;
		} else {
			int var1 = (int) (this.getHealth() - this.bt() * 0.33F);
			var1 -= (3 - this.world.getDifficulty().getId()) * 4;
			if (var1 < 0) {
				var1 = 0;
			}

			return var1 + 3;
		}
	}

	public ItemStack getItemInHand() {
		return this.bj[0];
	}

	public ItemStack p(int var1) {
		return this.bj[var1];
	}

	public ItemStack q(int var1) {
		return this.bj[var1 + 1];
	}

	public void setArmor(int var1, ItemStack var2) {
		this.bj[var1] = var2;
	}

	public ItemStack[] getArmorContents() {
		return this.bj;
	}

	protected void a(boolean var1, int var2) {
		for (int var3 = 0; var3 < this.getArmorContents().length; ++var3) {
			ItemStack var4 = this.p(var3);
			boolean var5 = this.bh[var3] > 1.0F;
			if (var4 != null && (var1 || var5) && this.V.nextFloat() - (float) var2 * 0.01F < this.bh[var3]) {
				if (!var5 && var4.e()) {
					int var6 = Math.max(var4.j() - 25, 1);
					int var7 = var4.j() - this.V.nextInt(this.V.nextInt(var6) + 1);
					if (var7 > var6) {
						var7 = var6;
					}

					if (var7 < 1) {
						var7 = 1;
					}

					var4.setDurability(var7);
				}

				this.a(var4, 0.0F);
			}
		}

	}

	protected void a(vu var1) {
		if (this.V.nextFloat() < 0.15F * var1.c()) {
			int var2 = this.V.nextInt(2);
			float var3 = this.world.getDifficulty() == Difficulty.HARD ? 0.1F : 0.25F;
			if (this.V.nextFloat() < 0.095F) {
				++var2;
			}

			if (this.V.nextFloat() < 0.095F) {
				++var2;
			}

			if (this.V.nextFloat() < 0.095F) {
				++var2;
			}

			for (int var4 = 3; var4 >= 0; --var4) {
				ItemStack var5 = this.q(var4);
				if (var4 < 3 && this.V.nextFloat() < var3) {
					break;
				}

				if (var5 == null) {
					Item var6 = a(var4 + 1, var2);
					if (var6 != null) {
						this.setArmor(var4 + 1, new ItemStack(var6));
					}
				}
			}
		}

	}

	public static int c(ItemStack var0) {
		if (var0.getItem() != Item.getItemOf(Blocks.PUMPKIN) && var0.getItem() != Items.SKULL) {
			if (var0.getItem() instanceof ItemArmor) {
				switch (((ItemArmor) var0.getItem()).b) {
					case 0:
						return 4;
					case 1:
						return 3;
					case 2:
						return 2;
					case 3:
						return 1;
				}
			}

			return 0;
		} else {
			return 4;
		}
	}

	public static Item a(int var0, int var1) {
		switch (var0) {
			case 4:
				if (var1 == 0) {
					return Items.LEATHER_HELMET;
				} else if (var1 == 1) {
					return Items.GOLD_HELMET;
				} else if (var1 == 2) {
					return Items.CHAINMAIL_HELMET;
				} else if (var1 == 3) {
					return Items.IRON_HELMET;
				} else if (var1 == 4) {
					return Items.DIAMOND_HELMET;
				}
			case 3:
				if (var1 == 0) {
					return Items.LEATHER_CHESTPLATE;
				} else if (var1 == 1) {
					return Items.GOLD_CHESTPLATE;
				} else if (var1 == 2) {
					return Items.CHAINMAIL_CHESTPLATE;
				} else if (var1 == 3) {
					return Items.IRON_CHESTPLATE;
				} else if (var1 == 4) {
					return Items.DIAMOND_CHESTPLATE;
				}
			case 2:
				if (var1 == 0) {
					return Items.LEATHER_LEGGINS;
				} else if (var1 == 1) {
					return Items.GOLD_LEGGINS;
				} else if (var1 == 2) {
					return Items.CHAINMAIL_LEGGINS;
				} else if (var1 == 3) {
					return Items.IRON_LEGGINS;
				} else if (var1 == 4) {
					return Items.DIAMOND_LEGGINS;
				}
			case 1:
				if (var1 == 0) {
					return Items.LEATHER_BOOTS;
				} else if (var1 == 1) {
					return Items.GOLD_BOOTS;
				} else if (var1 == 2) {
					return Items.CHAINMAIL_BOOTS;
				} else if (var1 == 3) {
					return Items.IRON_BOOTS;
				} else if (var1 == 4) {
					return Items.DIAMOND_BOOTS;
				}
			default:
				return null;
		}
	}

	protected void b(vu var1) {
		float var2 = var1.c();
		if (this.getItemInHand() != null && this.V.nextFloat() < 0.25F * var2) {
			aph.a(this.V, this.getItemInHand(), (int) (5.0F + var2 * (float) this.V.nextInt(18)));
		}

		for (int var3 = 0; var3 < 4; ++var3) {
			ItemStack var4 = this.q(var3);
			if (var4 != null && this.V.nextFloat() < 0.5F * var2) {
				aph.a(this.V, var4, (int) (5.0F + var2 * (float) this.V.nextInt(18)));
			}
		}

	}

	public xq a(vu var1, xq var2) {
		this.a(afs.b).b(new AttributeModifier("Random spawn bonus", this.V.nextGaussian() * 0.05D, 1));
		return var2;
	}

	public boolean bV() {
		return false;
	}

	public void bW() {
		this.bl = true;
	}

	public void a(int var1, float var2) {
		this.bh[var1] = var2;
	}

	public boolean bX() {
		return this.bk;
	}

	public void j(boolean var1) {
		this.bk = var1;
	}

	public boolean bY() {
		return this.bl;
	}

	public final boolean e(EntityHuman var1) {
		if (this.cb() && this.cc() == var1) {
			this.a(true, !var1.playerProperties.instabuild);
			return true;
		} else {
			ItemStack var2 = var1.playerInventory.getItemInHand();
			if (var2 != null && var2.getItem() == Items.LEAD && this.ca()) {
				if (!(this instanceof xx) || !((xx) this).cj()) {
					this.a(var1, true);
					--var2.amount;
					return true;
				}

				if (((xx) this).e(var1)) {
					this.a(var1, true);
					--var2.amount;
					return true;
				}
			}

			return this.a(var1) ? true : super.e(var1);
		}
	}

	protected boolean a(EntityHuman var1) {
		return false;
	}

	protected void bZ() {
		if (this.bo != null) {
			this.n();
		}

		if (this.bm) {
			if (!this.isAlive()) {
				this.a(true, true);
			}

			if (this.bn == null || this.bn.dead) {
				this.a(true, true);
			}
		}
	}

	public void a(boolean var1, boolean var2) {
		if (this.bm) {
			this.bm = false;
			this.bn = null;
			if (!this.world.isStatic && var2) {
				this.a(Items.LEAD, 1);
			}

			if (!this.world.isStatic && var1 && this.world instanceof WorldServer) {
				((WorldServer) this.world).s().a((Entity) this, (Packet) (new PacketPlayOutAttachEntity(1, this, (Entity) null)));
			}
		}

	}

	public boolean ca() {
		return !this.cb() && !(this instanceof IMonster);
	}

	public boolean cb() {
		return this.bm;
	}

	public Entity cc() {
		return this.bn;
	}

	public void a(Entity var1, boolean var2) {
		this.bm = true;
		this.bn = var1;
		if (!this.world.isStatic && var2 && this.world instanceof WorldServer) {
			((WorldServer) this.world).s().a((Entity) this, (Packet) (new PacketPlayOutAttachEntity(1, this, this.bn)));
		}

	}

	private void n() {
		if (this.bm && this.bo != null) {
			if (this.bo.isTagAssignableFrom("UUIDMost", 4) && this.bo.isTagAssignableFrom("UUIDLeast", 4)) {
				UUID var5 = new UUID(this.bo.getLong("UUIDMost"), this.bo.getLong("UUIDLeast"));
				List var6 = this.world.a(EntityLiving.class, this.getBoundingBox().grow(10.0D, 10.0D, 10.0D));
				Iterator var3 = var6.iterator();

				while (var3.hasNext()) {
					EntityLiving var4 = (EntityLiving) var3.next();
					if (var4.aJ().equals(var5)) {
						this.bn = var4;
						break;
					}
				}
			} else if (this.bo.isTagAssignableFrom("X", 99) && this.bo.isTagAssignableFrom("Y", 99) && this.bo.isTagAssignableFrom("Z", 99)) {
				Position var1 = new Position(this.bo.getInt("X"), this.bo.getInt("Y"), this.bo.getInt("Z"));
				EntityLeash var2 = EntityLeash.b(this.world, var1);
				if (var2 == null) {
					var2 = EntityLeash.a(this.world, var1);
				}

				this.bn = var2;
			} else {
				this.a(false, true);
			}
		}

		this.bo = null;
	}

	public boolean d(int var1, ItemStack var2) {
		int var3;
		if (var1 == 99) {
			var3 = 0;
		} else {
			var3 = var1 - 100 + 1;
			if (var3 < 0 || var3 >= this.bj.length) {
				return false;
			}
		}

		if (var2 != null && c(var2) != var3 && (var3 != 4 || !(var2.getItem() instanceof ItemBlock))) {
			return false;
		} else {
			this.setArmor(var3, var2);
			return true;
		}
	}

	public boolean bL() {
		return super.bL() && !this.cd();
	}

	protected void k(boolean var1) {
		this.dataWatcher.b(15, Byte.valueOf((byte) (var1 ? 1 : 0)));
	}

	private boolean cd() {
		return this.dataWatcher.a(15) != 0;
	}
}
