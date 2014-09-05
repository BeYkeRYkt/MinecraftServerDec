package net.minecraft;

public class aee extends adx {

	private int c;
	public double a;
	public double b;

	public aee(World var1) {
		super(var1);
	}

	public aee(World var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
	}

	public adz s() {
		return adz.c;
	}

	protected void h() {
		super.h();
		this.dataWatcher.a(16, new Byte((byte) 0));
	}

	public void s_() {
		super.s_();
		if (this.c > 0) {
			--this.c;
		}

		if (this.c <= 0) {
			this.a = this.b = 0.0D;
		}

		this.i(this.c > 0);
		if (this.j() && this.V.nextInt(4) == 0) {
			this.o.a(ew.m, this.locationX, this.locationY + 0.8D, this.locationZ, 0.0D, 0.0D, 0.0D, new int[0]);
		}

	}

	protected double m() {
		return 0.2D;
	}

	public void a(wh var1) {
		super.a(var1);
		if (!var1.c()) {
			this.a(new ItemStack(aty.al, 1), 0.0F);
		}

	}

	protected void a(Position var1, bec var2) {
		super.a(var1, var2);
		double var3 = this.a * this.a + this.b * this.b;
		if (var3 > 1.0E-4D && this.motionX * this.motionX + this.motionZ * this.motionZ > 0.001D) {
			var3 = (double) DataTypesConverter.a(var3);
			this.a /= var3;
			this.b /= var3;
			if (this.a * this.motionX + this.b * this.motionZ < 0.0D) {
				this.a = 0.0D;
				this.b = 0.0D;
			} else {
				double var5 = var3 / this.m();
				this.a *= var5;
				this.b *= var5;
			}
		}

	}

	protected void o() {
		double var1 = this.a * this.a + this.b * this.b;
		if (var1 > 1.0E-4D) {
			var1 = (double) DataTypesConverter.a(var1);
			this.a /= var1;
			this.b /= var1;
			double var3 = 1.0D;
			this.motionX *= 0.800000011920929D;
			this.motionY *= 0.0D;
			this.motionZ *= 0.800000011920929D;
			this.motionX += this.a * var3;
			this.motionZ += this.b * var3;
		} else {
			this.motionX *= 0.9800000190734863D;
			this.motionY *= 0.0D;
			this.motionZ *= 0.9800000190734863D;
		}

		super.o();
	}

	public boolean e(EntityHuman var1) {
		ItemStack var2 = var1.playerInventory.getItemInHand();
		if (var2 != null && var2.getItem() == amk.h) {
			if (!var1.by.instabuild && --var2.b == 0) {
				var1.playerInventory.a(var1.playerInventory.c, (ItemStack) null);
			}

			this.c += 3600;
		}

		this.a = this.locationX - var1.locationX;
		this.b = this.locationZ - var1.locationZ;
		return true;
	}

	protected void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.put("PushX", this.a);
		var1.put("PushZ", this.b);
		var1.put("Fuel", (short) this.c);
	}

	protected void a(NBTCompoundTag var1) {
		super.a(var1);
		this.a = var1.getDouble("PushX");
		this.b = var1.getDouble("PushZ");
		this.c = var1.getShort("Fuel");
	}

	protected boolean j() {
		return (this.dataWatcher.a(16) & 1) != 0;
	}

	protected void i(boolean var1) {
		if (var1) {
			this.dataWatcher.b(16, Byte.valueOf((byte) (this.dataWatcher.a(16) | 1)));
		} else {
			this.dataWatcher.b(16, Byte.valueOf((byte) (this.dataWatcher.a(16) & -2)));
		}

	}

	public bec u() {
		return (this.j() ? aty.am : aty.al).P().a(BlockFurnace.a, PaintingDirection.c);
	}
}
