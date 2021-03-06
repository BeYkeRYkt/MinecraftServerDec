package net.minecraft;

import java.util.Calendar;

public class EntityBat extends EntityAmbient {

	private Position a;

	public EntityBat(World var1) {
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
		return this.n() && this.random.nextInt(4) != 0 ? null : "mob.bat.idle";
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

	public void doTick() {
		super.doTick();
		if (this.n()) {
			this.motionX = this.motionY = this.motionZ = 0.0D;
			this.locationY = (double) MathHelper.toFixedPointInt(this.locationY) + 1.0D - (double) this.width;
		} else {
			this.motionY *= 0.6000000238418579D;
		}

	}

	protected void E() {
		super.E();
		Position var1 = new Position(this);
		Position var2 = var1.getUp();
		if (this.n()) {
			if (!this.world.getBlockState(var2).getBlock().t()) {
				this.a(false);
				this.world.a((EntityHuman) null, 1015, var1, 0);
			} else {
				if (this.random.nextInt(200) == 0) {
					this.headPitch = (float) this.random.nextInt(360);
				}

				if (this.world.findNearbyPlayer(this, 4.0D) != null) {
					this.a(false);
					this.world.a((EntityHuman) null, 1015, var1, 0);
				}
			}
		} else {
			if (this.a != null && (!this.world.d(this.a) || this.a.getY() < 1)) {
				this.a = null;
			}

			if (this.a == null || this.random.nextInt(30) == 0 || this.a.c((double) ((int) this.locationX), (double) ((int) this.locationY), (double) ((int) this.locationZ)) < 4.0D) {
				this.a = new Position((int) this.locationX + this.random.nextInt(7) - this.random.nextInt(7), (int) this.locationY + this.random.nextInt(6) - 2, (int) this.locationZ + this.random.nextInt(7) - this.random.nextInt(7));
			}

			double var3 = (double) this.a.getX() + 0.5D - this.locationX;
			double var5 = (double) this.a.getY() + 0.1D - this.locationY;
			double var7 = (double) this.a.getZ() + 0.5D - this.locationZ;
			this.motionX += (Math.signum(var3) * 0.5D - this.motionX) * 0.10000000149011612D;
			this.motionY += (Math.signum(var5) * 0.699999988079071D - this.motionY) * 0.10000000149011612D;
			this.motionZ += (Math.signum(var7) * 0.5D - this.motionZ) * 0.10000000149011612D;
			float var9 = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0D / 3.1415927410125732D) - 90.0F;
			float var10 = MathHelper.g(var9 - this.yaw);
			this.aY = 0.5F;
			this.yaw += var10;
			if (this.random.nextInt(100) == 0 && this.world.getBlockState(var2).getBlock().t()) {
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

	public boolean receiveDamage(DamageSource var1, float var2) {
		if (this.ignoresDamageType(var1)) {
			return false;
		} else {
			if (!this.world.isStatic && this.n()) {
				this.a(false);
			}

			return super.receiveDamage(var1, var2);
		}
	}

	public void readAdditionalData(NBTCompoundTag var1) {
		super.readAdditionalData(var1);
		this.dataWatcher.b(16, Byte.valueOf(var1.getByte("BatFlags")));
	}

	public void writeAdditionalData(NBTCompoundTag var1) {
		super.writeAdditionalData(var1);
		var1.put("BatFlags", this.dataWatcher.a(16));
	}

	public boolean bQ() {
		Position var1 = new Position(this.locationX, this.getBoundingBox().minY, this.locationZ);
		if (var1.getY() >= 63) {
			return false;
		} else {
			int var2 = this.world.getLightLevel(var1);
			byte var3 = 4;
			if (this.a(this.world.Y())) {
				var3 = 7;
			} else if (this.random.nextBoolean()) {
				return false;
			}

			return var2 > this.random.nextInt(var3) ? false : super.bQ();
		}
	}

	private boolean a(Calendar var1) {
		return var1.get(2) + 1 == 10 && var1.get(5) >= 20 || var1.get(2) + 1 == 11 && var1.get(5) <= 3;
	}

	public float getHeadHeight() {
		return this.width / 2.0F;
	}
}
