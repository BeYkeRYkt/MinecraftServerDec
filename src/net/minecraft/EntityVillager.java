package net.minecraft;

import java.util.Iterator;

public class EntityVillager extends ws implements ago, aqb {

	private int bl;
	private boolean bm;
	private boolean bn;
	abi bk;
	private EntityHuman bo;
	private aqd bp;
	private int bq;
	private boolean br;
	private boolean bs;
	private int bt;
	private String bu;
	private int bv;
	private int bw;
	private boolean bx;
	private boolean by;
	private wa bz;
	private static final agw[][][][] bA = new agw[][][][] {
			{
					{ { new agr(Items.WHEAT, new agx(18, 22)), new agr(Items.POTATO, new agx(15, 19)), new agr(Items.CARROT, new agx(15, 19)), new agv(Items.BREAD, new agx(-4, -2)) }, { new agr(Item.getItemOf(Blocks.PUMPKIN), new agx(8, 13)), new agv(Items.PUMPKIN_PIE, new agx(-3, -2)) }, { new agr(Item.getItemOf(Blocks.MELON_BLOCK), new agx(7, 12)), new agv(Items.APPLE, new agx(-5, -7)) }, { new agv(Items.COOKIE, new agx(-6, -10)), new agv(Items.CAKE, new agx(1, 1)) } },
					{ { new agr(Items.STRING, new agx(15, 20)), new agr(Items.COAL, new agx(16, 24)), new agu(Items.FISH, new agx(6, 6), Items.COOKED_FISH, new agx(6, 6)) }, { new agt(Items.FISHING_ROD, new agx(7, 8)) } },
					{
							{ new agr(Item.getItemOf(Blocks.WOOL), new agx(16, 22)), new agv(Items.SHEARS, new agx(3, 4)) },
							{ new agv(new ItemStack(Item.getItemOf(Blocks.WOOL), 1, 0), new agx(1, 2)), new agv(new ItemStack(Item.getItemOf(Blocks.WOOL), 1, 1), new agx(1, 2)), new agv(new ItemStack(Item.getItemOf(Blocks.WOOL), 1, 2), new agx(1, 2)), new agv(new ItemStack(Item.getItemOf(Blocks.WOOL), 1, 3), new agx(1, 2)), new agv(new ItemStack(Item.getItemOf(Blocks.WOOL), 1, 4), new agx(1, 2)), new agv(new ItemStack(Item.getItemOf(Blocks.WOOL), 1, 5), new agx(1, 2)), new agv(new ItemStack(Item.getItemOf(Blocks.WOOL), 1, 6), new agx(1, 2)), new agv(new ItemStack(Item.getItemOf(Blocks.WOOL), 1, 7), new agx(1, 2)),
									new agv(new ItemStack(Item.getItemOf(Blocks.WOOL), 1, 8), new agx(1, 2)), new agv(new ItemStack(Item.getItemOf(Blocks.WOOL), 1, 9), new agx(1, 2)), new agv(new ItemStack(Item.getItemOf(Blocks.WOOL), 1, 10), new agx(1, 2)), new agv(new ItemStack(Item.getItemOf(Blocks.WOOL), 1, 11), new agx(1, 2)), new agv(new ItemStack(Item.getItemOf(Blocks.WOOL), 1, 12), new agx(1, 2)), new agv(new ItemStack(Item.getItemOf(Blocks.WOOL), 1, 13), new agx(1, 2)), new agv(new ItemStack(Item.getItemOf(Blocks.WOOL), 1, 14), new agx(1, 2)), new agv(new ItemStack(Item.getItemOf(Blocks.WOOL), 1, 15), new agx(1, 2)) } },
					{ { new agr(Items.STRING, new agx(15, 20)), new agv(Items.ARROW, new agx(-12, -8)) }, { new agv(Items.BOW, new agx(2, 3)), new agu(Item.getItemOf(Blocks.GRAVEL), new agx(10, 10), Items.FLINT, new agx(6, 10)) } } },
			{ { { new agr(Items.PAPER, new agx(24, 36)), new ags() }, { new agr(Items.BOOK, new agx(8, 10)), new agv(Items.COMPASS, new agx(10, 12)), new agv(Item.getItemOf(Blocks.BOOKSHELF), new agx(3, 4)) }, { new agr(Items.WRITTEN_BOK, new agx(2, 2)), new agv(Items.CLOCK, new agx(10, 12)), new agv(Item.getItemOf(Blocks.GLASS), new agx(-5, -3)) }, { new ags() }, { new ags() }, { new agv(Items.NAMETAG, new agx(20, 22)) } } },
			{ { { new agr(Items.ROTTEN_FLESH, new agx(36, 40)), new agr(Items.GOLD_INGOT, new agx(8, 10)) }, { new agv(Items.REDSTONE, new agx(-4, -1)), new agv(new ItemStack(Items.DYE, 1, akv.l.b()), new agx(-2, -1)) }, { new agv(Items.ENDER_EYE, new agx(7, 11)), new agv(Item.getItemOf(Blocks.GLOWSTONE), new agx(-3, -1)) }, { new agv(Items.EXP_BOTTLE, new agx(3, 11)) } } },
			{ { { new agr(Items.COAL, new agx(16, 24)), new agv(Items.IRON_HELMET, new agx(4, 6)) }, { new agr(Items.IRON_INGOT, new agx(7, 9)), new agv(Items.IRON_CHESTPLATE, new agx(10, 14)) }, { new agr(Items.DIAMOND, new agx(3, 4)), new agt(Items.DIAMOND_CHESTPLATE, new agx(16, 19)) }, { new agv(Items.CHAINMAIL_BOOTS, new agx(5, 7)), new agv(Items.CHAINMAIL_LEGGINS, new agx(9, 11)), new agv(Items.CHAINMAIL_HELMET, new agx(5, 7)), new agv(Items.CHAINMAIL_CHESTPLATE, new agx(11, 15)) } },
					{ { new agr(Items.COAL, new agx(16, 24)), new agv(Items.IRON_AXE, new agx(6, 8)) }, { new agr(Items.IRON_INGOT, new agx(7, 9)), new agt(Items.IRON_SWORD, new agx(9, 10)) }, { new agr(Items.DIAMOND, new agx(3, 4)), new agt(Items.DIAMOND_SWORD, new agx(12, 15)), new agt(Items.DIAMOND_AXE, new agx(9, 12)) } }, { { new agr(Items.COAL, new agx(16, 24)), new agt(Items.IRON_SHOWEL, new agx(5, 7)) }, { new agr(Items.IRON_INGOT, new agx(7, 9)), new agt(Items.IRON_PICKAXE, new agx(9, 11)) }, { new agr(Items.DIAMOND, new agx(3, 4)), new agt(Items.DIAMOND_PICKAXE, new agx(12, 15)) } } },
			{ { { new agr(Items.PORKCHOP, new agx(14, 18)), new agr(Items.CHICKEN, new agx(14, 18)) }, { new agr(Items.COAL, new agx(16, 24)), new agv(Items.COOCKED_PORKCHOP, new agx(-7, -5)), new agv(Items.COOKED_CHICKEN, new agx(-8, -6)) } }, { { new agr(Items.LEATHER, new agx(9, 12)), new agv(Items.LEATHER_LEGGINS, new agx(2, 4)) }, { new agt(Items.LEATHER_CHESTPLATE, new agx(7, 12)) }, { new agv(Items.SADDLE, new agx(8, 10)) } } } };

	public EntityVillager(World var1) {
		this(var1, 0);
	}

	public EntityVillager(World var1, int var2) {
		super(var1);
		this.bz = new wa("Items", false, 8);
		this.r(var2);
		this.a(0.6F, 1.8F);
		((aay) this.s()).b(true);
		((aay) this.s()).a(true);
		this.i.a(0, new yy(this));
		this.i.a(1, new yp(this, new agq(this), 8.0F, 0.6D, 0.6D));
		this.i.a(1, new aah(this));
		this.i.a(1, new zi(this));
		this.i.a(2, new zl(this));
		this.i.a(3, new aaa(this));
		this.i.a(4, new zt(this, true));
		this.i.a(5, new zo(this, 0.6D));
		this.i.a(6, new zj(this));
		this.i.a(7, new aaf(this));
		this.i.a(9, new zf(this, EntityHuman.class, 3.0F, 1.0F));
		this.i.a(9, new aai(this));
		this.i.a(9, new zy(this, 0.6D));
		this.i.a(10, new zh(this, EntityInsentient.class, 8.0F));
		this.j(true);
	}

	private void ct() {
		if (!this.by) {
			this.by = true;
			if (this.i_()) {
				this.i.a(8, new zv(this, 0.32D));
			} else if (this.cj() == 0) {
				this.i.a(6, new ze(this, 0.6D));
			}

		}
	}

	protected void n() {
		if (this.cj() == 0) {
			this.i.a(8, new ze(this, 0.6D));
		}

		super.n();
	}

	protected void aW() {
		super.aW();
		this.a(afs.d).a(0.5D);
	}

	protected void E() {
		if (--this.bl <= 0) {
			Position var1 = new Position(this);
			this.o.ae().a(var1);
			this.bl = 70 + this.V.nextInt(50);
			this.bk = this.o.ae().a(var1, 32);
			if (this.bk == null) {
				this.ch();
			} else {
				Position var2 = this.bk.a();
				this.a(var2, (int) ((float) this.bk.b() * 1.0F));
				if (this.bx) {
					this.bx = false;
					this.bk.b(5);
				}
			}
		}

		if (!this.cm() && this.bq > 0) {
			--this.bq;
			if (this.bq <= 0) {
				if (this.br) {
					Iterator var3 = this.bp.iterator();

					while (var3.hasNext()) {
						aqc var4 = (aqc) var3.next();
						if (var4.h()) {
							var4.a(this.V.nextInt(6) + this.V.nextInt(6) + 2);
						}
					}

					this.cu();
					this.br = false;
					if (this.bk != null && this.bu != null) {
						this.o.a((Entity) this, (byte) 14);
						this.bk.a(this.bu, 1);
					}
				}

				this.c(new MobEffect(MobEffectList.l.H, 200, 0));
			}
		}

		super.E();
	}

	public boolean a(EntityHuman var1) {
		ItemStack var2 = var1.playerInventory.getItemInHand();
		boolean var3 = var2 != null && var2.getItem() == Items.SPAWNEGG;
		if (!var3 && this.ai() && !this.cm() && !this.i_()) {
			if (!this.o.D && (this.bp == null || this.bp.size() > 0)) {
				this.a_(var1);
				var1.a((aqb) this);
			}

			var1.b(StatisticList.F);
			return true;
		} else {
			return super.a(var1);
		}
	}

	protected void h() {
		super.h();
		this.dataWatcher.a(16, Integer.valueOf(0));
	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.put("Profession", this.cj());
		var1.put("Riches", this.bt);
		var1.put("Career", this.bv);
		var1.put("CareerLevel", this.bw);
		var1.put("Willing", this.bs);
		if (this.bp != null) {
			var1.put("Offers", (NBTTag) this.bp.a());
		}

		NBTListTag var2 = new NBTListTag();

		for (int var3 = 0; var3 < this.bz.n_(); ++var3) {
			ItemStack var4 = this.bz.a(var3);
			if (var4 != null) {
				var2.addTag((NBTTag) var4.b(new NBTCompoundTag()));
			}
		}

		var1.put("Inventory", (NBTTag) var2);
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		this.r(var1.getInt("Profession"));
		this.bt = var1.getInt("Riches");
		this.bv = var1.getInt("Career");
		this.bw = var1.getInt("CareerLevel");
		this.bs = var1.getBoolean("Willing");
		if (var1.isTagAssignableFrom("Offers", 10)) {
			NBTCompoundTag var2 = var1.getCompound("Offers");
			this.bp = new aqd(var2);
		}

		NBTListTag var5 = var1.getList("Inventory", 10);

		for (int var3 = 0; var3 < var5.getSize(); ++var3) {
			ItemStack var4 = ItemStack.a(var5.getCompound(var3));
			if (var4 != null) {
				this.bz.a(var4);
			}
		}

		this.j(true);
		this.ct();
	}

	protected boolean C() {
		return false;
	}

	protected String z() {
		return this.cm() ? "mob.villager.haggle" : "mob.villager.idle";
	}

	protected String bn() {
		return "mob.villager.hit";
	}

	protected String bo() {
		return "mob.villager.death";
	}

	public void r(int var1) {
		this.dataWatcher.b(16, Integer.valueOf(var1));
	}

	public int cj() {
		return Math.max(this.dataWatcher.c(16) % 5, 0);
	}

	public boolean ck() {
		return this.bm;
	}

	public void l(boolean var1) {
		this.bm = var1;
	}

	public void m(boolean var1) {
		this.bn = var1;
	}

	public boolean cl() {
		return this.bn;
	}

	public void b(EntityLiving var1) {
		super.b(var1);
		if (this.bk != null && var1 != null) {
			this.bk.a(var1);
			if (var1 instanceof EntityHuman) {
				byte var2 = -1;
				if (this.i_()) {
					var2 = -3;
				}

				this.bk.a(var1.d_(), var2);
				if (this.ai()) {
					this.o.a((Entity) this, (byte) 13);
				}
			}
		}

	}

	public void a(DamageSource var1) {
		if (this.bk != null) {
			Entity var2 = var1.j();
			if (var2 != null) {
				if (var2 instanceof EntityHuman) {
					this.bk.a(var2.d_(), -2);
				} else if (var2 instanceof aex) {
					this.bk.h();
				}
			} else {
				EntityHuman var3 = this.o.a(this, 16.0D);
				if (var3 != null) {
					this.bk.h();
				}
			}
		}

		super.a(var1);
	}

	public void a_(EntityHuman var1) {
		this.bo = var1;
	}

	public EntityHuman u_() {
		return this.bo;
	}

	public boolean cm() {
		return this.bo != null;
	}

	public boolean n(boolean var1) {
		if (!this.bs && var1 && this.cp()) {
			boolean var2 = false;

			for (int var3 = 0; var3 < this.bz.n_(); ++var3) {
				ItemStack var4 = this.bz.a(var3);
				if (var4 != null) {
					if (var4.getItem() == Items.BREAD && var4.b >= 3) {
						var2 = true;
						this.bz.a(var3, 3);
					} else if ((var4.getItem() == Items.POTATO || var4.getItem() == Items.CARROT) && var4.b >= 12) {
						var2 = true;
						this.bz.a(var3, 12);
					}
				}

				if (var2) {
					this.o.a((Entity) this, (byte) 18);
					this.bs = true;
					break;
				}
			}
		}

		return this.bs;
	}

	public void o(boolean var1) {
		this.bs = var1;
	}

	public void a(aqc var1) {
		var1.g();
		this.a_ = -this.w();
		this.a("mob.villager.yes", this.bA(), this.bB());
		int var2 = 3 + this.V.nextInt(4);
		if (var1.e() == 1 || this.V.nextInt(5) == 0) {
			this.bq = 40;
			this.br = true;
			this.bs = true;
			if (this.bo != null) {
				this.bu = this.bo.d_();
			} else {
				this.bu = null;
			}

			var2 += 5;
		}

		if (var1.a().getItem() == Items.EMERALD) {
			this.bt += var1.a().b;
		}

		if (var1.j()) {
			this.o.d((Entity) (new EntityExpirienceOrb(this.o, this.locationX, this.locationY + 0.5D, this.locationZ, var2)));
		}

	}

	public void a_(ItemStack var1) {
		if (!this.o.D && this.a_ > -this.w() + 20) {
			this.a_ = -this.w();
			if (var1 != null) {
				this.a("mob.villager.yes", this.bA(), this.bB());
			} else {
				this.a("mob.villager.no", this.bA(), this.bB());
			}
		}

	}

	public aqd b_(EntityHuman var1) {
		if (this.bp == null) {
			this.cu();
		}

		return this.bp;
	}

	private void cu() {
		agw[][][] var1 = bA[this.cj()];
		if (this.bv != 0 && this.bw != 0) {
			++this.bw;
		} else {
			this.bv = this.V.nextInt(var1.length) + 1;
			this.bw = 1;
		}

		if (this.bp == null) {
			this.bp = new aqd();
		}

		int var2 = this.bv - 1;
		int var3 = this.bw - 1;
		agw[][] var4 = var1[var2];
		if (var3 < var4.length) {
			agw[] var5 = var4[var3];
			agw[] var6 = var5;
			int var7 = var5.length;

			for (int var8 = 0; var8 < var7; ++var8) {
				agw var9 = var6[var8];
				var9.a(this.bp, this.V);
			}
		}

	}

	public IChatBaseComponent e_() {
		String var1 = this.aL();
		if (var1 != null && var1.length() > 0) {
			return new ChatComponentText(var1);
		} else {
			if (this.bp == null) {
				this.cu();
			}

			String var2 = null;
			switch (this.cj()) {
				case 0:
					if (this.bv == 1) {
						var2 = "farmer";
					} else if (this.bv == 2) {
						var2 = "fisherman";
					} else if (this.bv == 3) {
						var2 = "shepherd";
					} else if (this.bv == 4) {
						var2 = "fletcher";
					}
					break;
				case 1:
					var2 = "librarian";
					break;
				case 2:
					var2 = "cleric";
					break;
				case 3:
					if (this.bv == 1) {
						var2 = "armor";
					} else if (this.bv == 2) {
						var2 = "weapon";
					} else if (this.bv == 3) {
						var2 = "tool";
					}
					break;
				case 4:
					if (this.bv == 1) {
						var2 = "butcher";
					} else if (this.bv == 2) {
						var2 = "leather";
					}
			}

			if (var2 != null) {
				ChatMessage var3 = new ChatMessage("entity.Villager." + var2, new Object[0]);
				var3.b().a(this.aP());
				var3.b().a(this.aJ().toString());
				return var3;
			} else {
				return super.e_();
			}
		}
	}

	public float aR() {
		float var1 = 1.62F;
		if (this.i_()) {
			var1 = (float) ((double) var1 - 0.81D);
		}

		return var1;
	}

	public xq a(vu var1, xq var2) {
		var2 = super.a(var1, var2);
		this.r(this.o.s.nextInt(5));
		this.ct();
		return var2;
	}

	public void cn() {
		this.bx = true;
	}

	public EntityVillager b(ws var1) {
		EntityVillager var2 = new EntityVillager(this.o);
		var2.a(this.o.E(new Position(var2)), (xq) null);
		return var2;
	}

	public boolean ca() {
		return false;
	}

	public void a(EntityLightning var1) {
		if (!this.o.D) {
			EntityWitch var2 = new EntityWitch(this.o);
			var2.b(this.locationX, this.locationY, this.locationZ, this.yaw, this.pitch);
			var2.a(this.o.E(new Position(var2)), (xq) null);
			this.o.d((Entity) var2);
			this.J();
		}
	}

	public wa co() {
		return this.bz;
	}

	protected void a(EntityItem var1) {
		ItemStack var2 = var1.l();
		Item var3 = var2.getItem();
		if (this.a(var3)) {
			ItemStack var4 = this.bz.a(var2);
			if (var4 == null) {
				var1.J();
			} else {
				var2.b = var4.b;
			}
		}

	}

	private boolean a(Item var1) {
		return var1 == Items.BREAD || var1 == Items.POTATO || var1 == Items.CARROT || var1 == Items.WHEAT || var1 == Items.WHEAT_SEEDS;
	}

	public boolean cp() {
		return this.s(1);
	}

	public boolean cq() {
		return this.s(2);
	}

	public boolean cr() {
		boolean var1 = this.cj() == 0;
		return var1 ? !this.s(5) : !this.s(1);
	}

	private boolean s(int var1) {
		boolean var2 = this.cj() == 0;

		for (int var3 = 0; var3 < this.bz.n_(); ++var3) {
			ItemStack var4 = this.bz.a(var3);
			if (var4 != null) {
				if (var4.getItem() == Items.BREAD && var4.b >= 3 * var1 || var4.getItem() == Items.POTATO && var4.b >= 12 * var1 || var4.getItem() == Items.CARROT && var4.b >= 12 * var1) {
					return true;
				}

				if (var2 && var4.getItem() == Items.WHEAT && var4.b >= 9 * var1) {
					return true;
				}
			}
		}

		return false;
	}

	public boolean cs() {
		for (int var1 = 0; var1 < this.bz.n_(); ++var1) {
			ItemStack var2 = this.bz.a(var1);
			if (var2 != null && (var2.getItem() == Items.WHEAT_SEEDS || var2.getItem() == Items.POTATO || var2.getItem() == Items.CARROT)) {
				return true;
			}
		}

		return false;
	}

	public boolean d(int var1, ItemStack var2) {
		if (super.d(var1, var2)) {
			return true;
		} else {
			int var3 = var1 - 300;
			if (var3 >= 0 && var3 < this.bz.n_()) {
				this.bz.a(var3, var2);
				return true;
			} else {
				return false;
			}
		}
	}

	// $FF: synthetic method
	public ws a(ws var1) {
		return this.b(var1);
	}

}
