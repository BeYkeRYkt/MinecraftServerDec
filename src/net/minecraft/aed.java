package net.minecraft;

public abstract class aed extends adx implements vy {

	private ItemStack[] a = new ItemStack[36];
	private boolean b = true;

	public aed(World var1) {
		super(var1);
	}

	public aed(World var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
	}

	public void a(DamageSource var1) {
		super.a(var1);
		vs.a(this.world, (Entity) this, this);
	}

	public ItemStack a(int var1) {
		return this.a[var1];
	}

	public ItemStack a(int var1, int var2) {
		if (this.a[var1] != null) {
			ItemStack var3;
			if (this.a[var1].amount <= var2) {
				var3 = this.a[var1];
				this.a[var1] = null;
				return var3;
			} else {
				var3 = this.a[var1].a(var2);
				if (this.a[var1].amount == 0) {
					this.a[var1] = null;
				}

				return var3;
			}
		} else {
			return null;
		}
	}

	public ItemStack b(int var1) {
		if (this.a[var1] != null) {
			ItemStack var2 = this.a[var1];
			this.a[var1] = null;
			return var2;
		} else {
			return null;
		}
	}

	public void a(int var1, ItemStack var2) {
		this.a[var1] = var2;
		if (var2 != null && var2.amount > this.p_()) {
			var2.amount = this.p_();
		}

	}

	public void update() {
	}

	public boolean a(EntityHuman var1) {
		return this.dead ? false : var1.getDistanceSquared(this) <= 64.0D;
	}

	public void b(EntityHuman var1) {
	}

	public void c(EntityHuman var1) {
	}

	public boolean b(int var1, ItemStack var2) {
		return true;
	}

	public String getName() {
		return this.k_() ? this.getCustomName() : "container.minecart";
	}

	public int p_() {
		return 64;
	}

	public void c(int var1) {
		this.b = false;
		super.c(var1);
	}

	public void die() {
		if (this.b) {
			vs.a(this.world, (Entity) this, this);
		}

		super.die();
	}

	protected void b(NBTCompoundTag var1) {
		super.b(var1);
		NBTListTag var2 = new NBTListTag();

		for (int var3 = 0; var3 < this.a.length; ++var3) {
			if (this.a[var3] != null) {
				NBTCompoundTag var4 = new NBTCompoundTag();
				var4.put("Slot", (byte) var3);
				this.a[var3].write(var4);
				var2.addTag((NBTTag) var4);
			}
		}

		var1.put("Items", (NBTTag) var2);
	}

	protected void a(NBTCompoundTag var1) {
		super.a(var1);
		NBTListTag var2 = var1.getList("Items", 10);
		this.a = new ItemStack[this.n_()];

		for (int var3 = 0; var3 < var2.getSize(); ++var3) {
			NBTCompoundTag var4 = var2.getCompound(var3);
			int var5 = var4.getByte("Slot") & 255;
			if (var5 >= 0 && var5 < this.a.length) {
				this.a[var5] = ItemStack.a(var4);
			}
		}

	}

	public boolean e(EntityHuman var1) {
		if (!this.world.isStatic) {
			var1.a((IInventory) this);
		}

		return true;
	}

	protected void o() {
		int var1 = 15 - Container.b((IInventory) this);
		float var2 = 0.98F + (float) var1 * 0.001F;
		this.motionX *= (double) var2;
		this.motionY *= 0.0D;
		this.motionZ *= (double) var2;
	}

	public int a_(int var1) {
		return 0;
	}

	public void b(int var1, int var2) {
	}

	public int g() {
		return 0;
	}

	public boolean q_() {
		return false;
	}

	public void a(vx var1) {
	}

	public vx i() {
		return vx.a;
	}

	public void l() {
		for (int var1 = 0; var1 < this.a.length; ++var1) {
			this.a[var1] = null;
		}

	}
}
