package net.minecraft;

import java.util.Calendar;

public class abo extends abn {

	private Position a;

	public abo(World var1) {
		super(var1);
		this.a(0.5F, 0.9F);
		this.a(true);
	}

	protected void h() {
		super.h();
		this.dataWatcher.a(16, new Byte((byte) 0));
	}

	protected float bA() {
		return 0.1F;
	}

	protected float bB() {
		return super.bB() * 0.95F;
	}

	protected String z() {
		return this.n() && this.V.nextInt(4) != 0 ? null : "mob.bat.idle";
	}

	protected String bn() {
		return "mob.bat.hurt";
	}

	protected String bo() {
		return "mob.bat.death";
	}

	public boolean ae() {
		return false;
	}

	protected void s(Entity var1) {
	}

	protected void bK() {
	}

	protected void aW() {
		super.aW();
		this.a(afs.a).a(6.0D);
	}

	public boolean n() {
		return (this.dataWatcher.a(16) & 1) != 0;
	}

	public void a(boolean var1) {
		byte var2 = this.dataWatcher.a(16);
		if (var1) {
			this.dataWatcher.b(16, Byte.valueOf((byte) (var2 | 1)));
		} else {
			this.dataWatcher.b(16, Byte.valueOf((byte) (var2 & -2)));
		}

	}

	public void s_() {
		super.s_();
		if (this.n()) {
			this.motionX = this.motionY = this.motionZ = 0.0D;
			this.locationY = (double) DataTypesConverter.toFixedPointInt(this.locationY) + 1.0D - (double) this.K;
		} else {
			this.motionY *= 0.6000000238418579D;
		}

	}

	protected void E() {
		super.E();
		Position var1 = new Position(this);
		Position var2 = var1.a();
		if (this.n()) {
			if (!this.o.p(var2).c().t()) {
				this.a(false);
				this.o.a((EntityHuman) null, 1015, var1, 0);
			} else {
				if (this.V.nextInt(200) == 0) {
					this.headPitch = (float) this.V.nextInt(360);
				}

				if (this.o.a(this, 4.0D) != null) {
					this.a(false);
					this.o.a((EntityHuman) null, 1015, var1, 0);
				}
			}
		} else {
			if (this.a != null && (!this.o.d(this.a) || this.a.o() < 1)) {
				this.a = null;
			}

			if (this.a == null || this.V.nextInt(30) == 0 || this.a.c((double) ((int) this.locationX), (double) ((int) this.locationY), (double) ((int) this.locationZ)) < 4.0D) {
				this.a = new Position((int) this.locationX + this.V.nextInt(7) - this.V.nextInt(7), (int) this.locationY + this.V.nextInt(6) - 2, (int) this.locationZ + this.V.nextInt(7) - this.V.nextInt(7));
			}

			double var3 = (double) this.a.n() + 0.5D - this.locationX;
			double var5 = (double) this.a.o() + 0.1D - this.locationY;
			double var7 = (double) this.a.p() + 0.5D - this.locationZ;
			this.motionX += (Math.signum(var3) * 0.5D - this.motionX) * 0.10000000149011612D;
			this.motionY += (Math.signum(var5) * 0.699999988079071D - this.motionY) * 0.10000000149011612D;
			this.motionZ += (Math.signum(var7) * 0.5D - this.motionZ) * 0.10000000149011612D;
			float var9 = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0D / 3.1415927410125732D) - 90.0F;
			float var10 = DataTypesConverter.g(var9 - this.yaw);
			this.aY = 0.5F;
			this.yaw += var10;
			if (this.V.nextInt(100) == 0 && this.o.p(var2).c().t()) {
				this.a(true);
			}
		}

	}

	protected boolean r_() {
		return false;
	}

	public void e(float var1, float var2) {
	}

	protected void a(double var1, boolean var3, Block var4, Position var5) {
	}

	public boolean aH() {
		return true;
	}

	public boolean a(wh var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else {
			if (!this.o.D && this.n()) {
				this.a(false);
			}

			return super.a(var1, var2);
		}
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		this.dataWatcher.b(16, Byte.valueOf(var1.getByte("BatFlags")));
	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.put("BatFlags", this.dataWatcher.a(16));
	}

	public boolean bQ() {
		Position var1 = new Position(this.locationX, this.aQ().b, this.locationZ);
		if (var1.o() >= 63) {
			return false;
		} else {
			int var2 = this.o.l(var1);
			byte var3 = 4;
			if (this.a(this.o.Y())) {
				var3 = 7;
			} else if (this.V.nextBoolean()) {
				return false;
			}

			return var2 > this.V.nextInt(var3) ? false : super.bQ();
		}
	}

	private boolean a(Calendar var1) {
		return var1.get(2) + 1 == 10 && var1.get(5) >= 20 || var1.get(2) + 1 == 11 && var1.get(5) <= 3;
	}

	public float aR() {
		return this.K / 2.0F;
	}
}
