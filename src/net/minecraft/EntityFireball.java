package net.minecraft;

import java.util.List;

public abstract class EntityFireball extends Entity {

	private int e = -1;
	private int f = -1;
	private int g = -1;
	private Block h;
	private boolean i;
	public EntityLiving a;
	private int ap;
	private int aq;
	public double b;
	public double c;
	public double d;

	public EntityFireball(World var1) {
		super(var1);
		this.a(1.0F, 1.0F);
	}

	protected void h() {
	}

	public EntityFireball(World var1, double var2, double var4, double var6, double var8, double var10, double var12) {
		super(var1);
		this.a(1.0F, 1.0F);
		this.setPositionRotation(var2, var4, var6, this.yaw, this.pitch);
		this.b(var2, var4, var6);
		double var14 = (double) MathHelper.sqrt(var8 * var8 + var10 * var10 + var12 * var12);
		this.b = var8 / var14 * 0.1D;
		this.c = var10 / var14 * 0.1D;
		this.d = var12 / var14 * 0.1D;
	}

	public EntityFireball(World var1, EntityLiving var2, double var3, double var5, double var7) {
		super(var1);
		this.a = var2;
		this.a(1.0F, 1.0F);
		this.setPositionRotation(var2.locationX, var2.locationY, var2.locationZ, var2.yaw, var2.pitch);
		this.b(this.locationX, this.locationY, this.locationZ);
		this.motionX = this.motionY = this.motionZ = 0.0D;
		var3 += this.V.nextGaussian() * 0.4D;
		var5 += this.V.nextGaussian() * 0.4D;
		var7 += this.V.nextGaussian() * 0.4D;
		double var9 = (double) MathHelper.sqrt(var3 * var3 + var5 * var5 + var7 * var7);
		this.b = var3 / var9 * 0.1D;
		this.c = var5 / var9 * 0.1D;
		this.d = var7 / var9 * 0.1D;
	}

	public void s_() {
		if (!this.world.isStatic && (this.a != null && this.a.dead || !this.world.isLoaded(new Position(this)))) {
			this.die();
		} else {
			super.s_();
			this.e(1);
			if (this.i) {
				if (this.world.getBlockState(new Position(this.e, this.f, this.g)).getBlock() == this.h) {
					++this.ap;
					if (this.ap == 600) {
						this.die();
					}

					return;
				}

				this.i = false;
				this.motionX *= (double) (this.V.nextFloat() * 0.2F);
				this.motionY *= (double) (this.V.nextFloat() * 0.2F);
				this.motionZ *= (double) (this.V.nextFloat() * 0.2F);
				this.ap = 0;
				this.aq = 0;
			} else {
				++this.aq;
			}

			Vec3D var1 = new Vec3D(this.locationX, this.locationY, this.locationZ);
			Vec3D var2 = new Vec3D(this.locationX + this.motionX, this.locationY + this.motionY, this.locationZ + this.motionZ);
			MovingObjectPosition var3 = this.world.a(var1, var2);
			var1 = new Vec3D(this.locationX, this.locationY, this.locationZ);
			var2 = new Vec3D(this.locationX + this.motionX, this.locationY + this.motionY, this.locationZ + this.motionZ);
			if (var3 != null) {
				var2 = new Vec3D(var3.vec.x, var3.vec.y, var3.vec.z);
			}

			Entity var4 = null;
			List var5 = this.world.b((Entity) this, this.getBoundingBox().a(this.motionX, this.motionY, this.motionZ).grow(1.0D, 1.0D, 1.0D));
			double var6 = 0.0D;

			for (int var8 = 0; var8 < var5.size(); ++var8) {
				Entity var9 = (Entity) var5.get(var8);
				if (var9.ad() && (!var9.k(this.a) || this.aq >= 25)) {
					float var10 = 0.3F;
					AxisAlignedBB var11 = var9.getBoundingBox().grow((double) var10, (double) var10, (double) var10);
					MovingObjectPosition var12 = var11.a(var1, var2);
					if (var12 != null) {
						double var13 = var1.f(var12.vec);
						if (var13 < var6 || var6 == 0.0D) {
							var4 = var9;
							var6 = var13;
						}
					}
				}
			}

			if (var4 != null) {
				var3 = new MovingObjectPosition(var4);
			}

			if (var3 != null) {
				this.a(var3);
			}

			this.locationX += this.motionX;
			this.locationY += this.motionY;
			this.locationZ += this.motionZ;
			float var15 = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
			this.yaw = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0D / 3.1415927410125732D) + 90.0F;

			for (this.pitch = (float) (Math.atan2((double) var15, this.motionY) * 180.0D / 3.1415927410125732D) - 90.0F; this.pitch - this.B < -180.0F; this.B -= 360.0F) {
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
			float var16 = this.j();
			if (this.V()) {
				for (int var17 = 0; var17 < 4; ++var17) {
					float var18 = 0.25F;
					this.world.a(Particle.e, this.locationX - this.motionX * (double) var18, this.locationY - this.motionY * (double) var18, this.locationZ - this.motionZ * (double) var18, this.motionX, this.motionY, this.motionZ, new int[0]);
				}

				var16 = 0.8F;
			}

			this.motionX += this.b;
			this.motionY += this.c;
			this.motionZ += this.d;
			this.motionX *= (double) var16;
			this.motionY *= (double) var16;
			this.motionZ *= (double) var16;
			this.world.a(Particle.l, this.locationX, this.locationY + 0.5D, this.locationZ, 0.0D, 0.0D, 0.0D, new int[0]);
			this.b(this.locationX, this.locationY, this.locationZ);
		}
	}

	protected float j() {
		return 0.95F;
	}

	protected abstract void a(MovingObjectPosition var1);

	public void b(NBTCompoundTag var1) {
		var1.put("xTile", (short) this.e);
		var1.put("yTile", (short) this.f);
		var1.put("zTile", (short) this.g);
		RegistryObjectName var2 = (RegistryObjectName) Block.BLOCKREGISTRY.c(this.h);
		var1.put("inTile", var2 == null ? "" : var2.toString());
		var1.put("inGround", (byte) (this.i ? 1 : 0));
		var1.put("direction", (NBTTag) this.a(new double[] { this.motionX, this.motionY, this.motionZ }));
	}

	public void a(NBTCompoundTag var1) {
		this.e = var1.getShort("xTile");
		this.f = var1.getShort("yTile");
		this.g = var1.getShort("zTile");
		if (var1.isTagAssignableFrom("inTile", 8)) {
			this.h = Block.getByName(var1.getString("inTile"));
		} else {
			this.h = Block.getById(var1.getByte("inTile") & 255);
		}

		this.i = var1.getByte("inGround") == 1;
		if (var1.isTagAssignableFrom("direction", 9)) {
			NBTListTag var2 = var1.getList("direction", 6);
			this.motionX = var2.getDouble(0);
			this.motionY = var2.getDouble(1);
			this.motionZ = var2.getDouble(2);
		} else {
			this.die();
		}

	}

	public boolean ad() {
		return true;
	}

	public float ao() {
		return 1.0F;
	}

	public boolean damageEntity(DamageSource var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else {
			this.ac();
			if (var1.j() != null) {
				Vec3D var3 = var1.j().ap();
				if (var3 != null) {
					this.motionX = var3.x;
					this.motionY = var3.y;
					this.motionZ = var3.z;
					this.b = this.motionX * 0.1D;
					this.c = this.motionY * 0.1D;
					this.d = this.motionZ * 0.1D;
				}

				if (var1.j() instanceof EntityLiving) {
					this.a = (EntityLiving) var1.j();
				}

				return true;
			} else {
				return false;
			}
		}
	}

	public float c(float var1) {
		return 1.0F;
	}
}
