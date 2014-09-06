package net.minecraft;

import java.util.Iterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EntityItem extends Entity {

	private static final Logger b = LogManager.getLogger();
	private int c;
	private int d;
	private int e;
	private String f;
	private String g;
	public float a;

	public EntityItem(World var1, double var2, double var4, double var6) {
		super(var1);
		this.e = 5;
		this.a = (float) (Math.random() * 3.141592653589793D * 2.0D);
		this.a(0.25F, 0.25F);
		this.b(var2, var4, var6);
		this.yaw = (float) (Math.random() * 360.0D);
		this.motionX = (double) ((float) (Math.random() * 0.20000000298023224D - 0.10000000149011612D));
		this.motionY = 0.20000000298023224D;
		this.motionZ = (double) ((float) (Math.random() * 0.20000000298023224D - 0.10000000149011612D));
	}

	public EntityItem(World var1, double var2, double var4, double var6, ItemStack var8) {
		this(var1, var2, var4, var6);
		this.a(var8);
	}

	protected boolean r_() {
		return false;
	}

	public EntityItem(World var1) {
		super(var1);
		this.e = 5;
		this.a = (float) (Math.random() * 3.141592653589793D * 2.0D);
		this.a(0.25F, 0.25F);
		this.a(new ItemStack(Blocks.AIR, 0));
	}

	protected void h() {
		this.getDataWatcher().a(10, 5);
	}

	public void s_() {
		if (this.l() == null) {
			this.J();
		} else {
			super.s_();
			if (this.d > 0 && this.d != 32767) {
				--this.d;
			}

			this.p = this.locationX;
			this.q = this.locationY;
			this.r = this.locationZ;
			this.motionY -= 0.03999999910593033D;
			this.T = this.j(this.locationX, (this.aQ().b + this.aQ().e) / 2.0D, this.locationZ);
			this.d(this.motionX, this.motionY, this.motionZ);
			boolean var1 = (int) this.p != (int) this.locationX || (int) this.q != (int) this.locationY || (int) this.r != (int) this.locationZ;
			if (var1 || this.W % 25 == 0) {
				if (this.o.p(new Position(this)).getBlock().r() == Material.LAVA) {
					this.motionY = 0.20000000298023224D;
					this.motionX = (double) ((this.V.nextFloat() - this.V.nextFloat()) * 0.2F);
					this.motionZ = (double) ((this.V.nextFloat() - this.V.nextFloat()) * 0.2F);
					this.a("random.fizz", 0.4F, 2.0F + this.V.nextFloat() * 0.4F);
				}

				if (!this.o.D) {
					this.w();
				}
			}

			float var2 = 0.98F;
			if (this.onGround) {
				var2 = this.o.p(new Position(DataTypesConverter.toFixedPointInt(this.locationX), DataTypesConverter.toFixedPointInt(this.aQ().b) - 1, DataTypesConverter.toFixedPointInt(this.locationZ))).getBlock().K * 0.98F;
			}

			this.motionX *= (double) var2;
			this.motionY *= 0.9800000190734863D;
			this.motionZ *= (double) var2;
			if (this.onGround) {
				this.motionY *= -0.5D;
			}

			if (this.c != -32768) {
				++this.c;
			}

			this.W();
			if (!this.o.D && this.c >= 6000) {
				this.J();
			}

		}
	}

	private void w() {
		Iterator var1 = this.o.a(EntityItem.class, this.aQ().b(0.5D, 0.0D, 0.5D)).iterator();

		while (var1.hasNext()) {
			EntityItem var2 = (EntityItem) var1.next();
			this.a(var2);
		}

	}

	private boolean a(EntityItem var1) {
		if (var1 == this) {
			return false;
		} else if (var1.ai() && this.ai()) {
			ItemStack var2 = this.l();
			ItemStack var3 = var1.l();
			if (this.d != 32767 && var1.d != 32767) {
				if (this.c != -32768 && var1.c != -32768) {
					if (var3.getItem() != var2.getItem()) {
						return false;
					} else if (var3.hasTag() ^ var2.hasTag()) {
						return false;
					} else if (var3.hasTag() && !var3.getTag().equals(var2.getTag())) {
						return false;
					} else if (var3.getItem() == null) {
						return false;
					} else if (var3.getItem().k() && var3.i() != var2.i()) {
						return false;
					} else if (var3.b < var2.b) {
						return var1.a(this);
					} else if (var3.b + var2.b > var3.c()) {
						return false;
					} else {
						var3.b += var2.b;
						var1.d = Math.max(var1.d, this.d);
						var1.c = Math.min(var1.c, this.c);
						var1.a(var3);
						this.J();
						return true;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public void j() {
		this.c = 4800;
	}

	public boolean W() {
		if (this.o.a(this.aQ(), Material.WATER, (Entity) this)) {
			if (!this.Y && !this.aa) {
				this.X();
			}

			this.Y = true;
		} else {
			this.Y = false;
		}

		return this.Y;
	}

	protected void f(int var1) {
		this.a(DamageSource.a, (float) var1);
	}

	public boolean a(DamageSource var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else if (this.l() != null && this.l().getItem() == Items.bZ && var1.c()) {
			return false;
		} else {
			this.ac();
			this.e = (int) ((float) this.e - var2);
			if (this.e <= 0) {
				this.J();
			}

			return false;
		}
	}

	public void b(NBTCompoundTag var1) {
		var1.put("Health", (short) ((byte) this.e));
		var1.put("Age", (short) this.c);
		var1.put("PickupDelay", (short) this.d);
		if (this.n() != null) {
			var1.put("Thrower", this.f);
		}

		if (this.m() != null) {
			var1.put("Owner", this.g);
		}

		if (this.l() != null) {
			var1.put("Item", (NBTTag) this.l().b(new NBTCompoundTag()));
		}

	}

	public void a(NBTCompoundTag var1) {
		this.e = var1.getShort("Health") & 255;
		this.c = var1.getShort("Age");
		if (var1.hasKey("PickupDelay")) {
			this.d = var1.getShort("PickupDelay");
		}

		if (var1.hasKey("Owner")) {
			this.g = var1.getString("Owner");
		}

		if (var1.hasKey("Thrower")) {
			this.f = var1.getString("Thrower");
		}

		NBTCompoundTag var2 = var1.getCompound("Item");
		this.a(ItemStack.a(var2));
		if (this.l() == null) {
			this.J();
		}

	}

	public void d(EntityHuman var1) {
		if (!this.o.D) {
			ItemStack var2 = this.l();
			int var3 = var2.b;
			if (this.d == 0 && (this.g == null || 6000 - this.c <= 200 || this.g.equals(var1.d_())) && var1.playerInventory.a(var2)) {
				if (var2.getItem() == Item.getItemOf(Blocks.LOG)) {
					var1.b((Statistic) tl.g);
				}

				if (var2.getItem() == Item.getItemOf(Blocks.LOG2)) {
					var1.b((Statistic) tl.g);
				}

				if (var2.getItem() == Items.aF) {
					var1.b((Statistic) tl.t);
				}

				if (var2.getItem() == Items.i) {
					var1.b((Statistic) tl.w);
				}

				if (var2.getItem() == Items.bv) {
					var1.b((Statistic) tl.A);
				}

				if (var2.getItem() == Items.i && this.n() != null) {
					EntityHuman var4 = this.o.a(this.n());
					if (var4 != null && var4 != var1) {
						var4.b((Statistic) tl.x);
					}
				}

				if (!this.R()) {
					this.o.a((Entity) var1, "random.pop", 0.2F, ((this.V.nextFloat() - this.V.nextFloat()) * 0.7F + 1.0F) * 2.0F);
				}

				var1.a((Entity) this, var3);
				if (var2.b <= 0) {
					this.J();
				}
			}

		}
	}

	public String d_() {
		return this.k_() ? this.aL() : LocaleI18n.get("item." + this.l().a());
	}

	public boolean aE() {
		return false;
	}

	public void c(int var1) {
		super.c(var1);
		if (!this.o.D) {
			this.w();
		}

	}

	public ItemStack l() {
		ItemStack var1 = this.getDataWatcher().f(10);
		if (var1 == null) {
			if (this.o != null) {
				b.error("Item entity " + this.getId() + " has no item?!");
			}

			return new ItemStack(Blocks.STONE);
		} else {
			return var1;
		}
	}

	public void a(ItemStack var1) {
		this.getDataWatcher().b(10, var1);
		this.getDataWatcher().i(10);
	}

	public String m() {
		return this.g;
	}

	public void b(String var1) {
		this.g = var1;
	}

	public String n() {
		return this.f;
	}

	public void c(String var1) {
		this.f = var1;
	}

	public void p() {
		this.d = 10;
	}

	public void q() {
		this.d = 0;
	}

	public void r() {
		this.d = 32767;
	}

	public void a(int var1) {
		this.d = var1;
	}

	public boolean s() {
		return this.d > 0;
	}

	public void u() {
		this.c = -6000;
	}

	public void v() {
		this.r();
		this.c = 5999;
	}

}
