package net.minecraft;

public class EntityEnderSignal extends Entity {

	private double a;
	private double b;
	private double c;
	private int d;
	private boolean e;

	public EntityEnderSignal(World var1) {
		super(var1);
		this.a(0.25F, 0.25F);
	}

	protected void h() {
	}

	public EntityEnderSignal(World var1, double var2, double var4, double var6) {
		super(var1);
		this.d = 0;
		this.a(0.25F, 0.25F);
		this.b(var2, var4, var6);
	}

	public void a(Position var1) {
		double var2 = (double) var1.getX();
		int var4 = var1.getY();
		double var5 = (double) var1.getZ();
		double var7 = var2 - this.locationX;
		double var9 = var5 - this.locationZ;
		float var11 = MathHelper.a(var7 * var7 + var9 * var9);
		if (var11 > 12.0F) {
			this.a = this.locationX + var7 / (double) var11 * 12.0D;
			this.c = this.locationZ + var9 / (double) var11 * 12.0D;
			this.b = this.locationY + 8.0D;
		} else {
			this.a = var2;
			this.b = (double) var4;
			this.c = var5;
		}

		this.d = 0;
		this.e = this.V.nextInt(5) > 0;
	}

	public void s_() {
		this.P = this.locationX;
		this.Q = this.locationY;
		this.R = this.locationZ;
		super.s_();
		this.locationX += this.motionX;
		this.locationY += this.motionY;
		this.locationZ += this.motionZ;
		float var1 = MathHelper.a(this.motionX * this.motionX + this.motionZ * this.motionZ);
		this.yaw = (float) (Math.atan2(this.motionX, this.motionZ) * 180.0D / 3.1415927410125732D);

		for (this.pitch = (float) (Math.atan2(this.motionY, (double) var1) * 180.0D / 3.1415927410125732D); this.pitch - this.B < -180.0F; this.B -= 360.0F) {
			;
		}

		while (this.pitch - this.B >= 180.0F) {
			this.B += 360.0F;
		}

		while (this.yaw - this.A < -180.0F) {
			this.A -= 360.0F;
		}

		while (this.yaw - this.A >= 180.0F) {
			this.A += 360.0F;
		}

		this.pitch = this.B + (this.pitch - this.B) * 0.2F;
		this.yaw = this.A + (this.yaw - this.A) * 0.2F;
		if (!this.world.isStatic) {
			double var2 = this.a - this.locationX;
			double var4 = this.c - this.locationZ;
			float var6 = (float) Math.sqrt(var2 * var2 + var4 * var4);
			float var7 = (float) Math.atan2(var4, var2);
			double var8 = (double) var1 + (double) (var6 - var1) * 0.0025D;
			if (var6 < 1.0F) {
				var8 *= 0.8D;
				this.motionY *= 0.8D;
			}

			this.motionX = Math.cos((double) var7) * var8;
			this.motionZ = Math.sin((double) var7) * var8;
			if (this.locationY < this.b) {
				this.motionY += (1.0D - this.motionY) * 0.014999999664723873D;
			} else {
				this.motionY += (-1.0D - this.motionY) * 0.014999999664723873D;
			}
		}

		float var10 = 0.25F;
		if (this.V()) {
			for (int var3 = 0; var3 < 4; ++var3) {
				this.world.a(Particle.e, this.locationX - this.motionX * (double) var10, this.locationY - this.motionY * (double) var10, this.locationZ - this.motionZ * (double) var10, this.motionX, this.motionY, this.motionZ, new int[0]);
			}
		} else {
			this.world.a(Particle.y, this.locationX - this.motionX * (double) var10 + this.V.nextDouble() * 0.6D - 0.3D, this.locationY - this.motionY * (double) var10 - 0.5D, this.locationZ - this.motionZ * (double) var10 + this.V.nextDouble() * 0.6D - 0.3D, this.motionX, this.motionY, this.motionZ, new int[0]);
		}

		if (!this.world.isStatic) {
			this.b(this.locationX, this.locationY, this.locationZ);
			++this.d;
			if (this.d > 80 && !this.world.isStatic) {
				this.die();
				if (this.e) {
					this.world.d((Entity) (new EntityItem(this.world, this.locationX, this.locationY, this.locationZ, new ItemStack(Items.ENDER_EYE))));
				} else {
					this.world.b(2003, new Position(this), 0);
				}
			}
		}

	}

	public void b(NBTCompoundTag var1) {
	}

	public void a(NBTCompoundTag var1) {
	}

	public float c(float var1) {
		return 1.0F;
	}

	public boolean aE() {
		return false;
	}
}
