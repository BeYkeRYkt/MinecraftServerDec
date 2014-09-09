package net.minecraft;

import java.util.List;

public abstract class ahr extends Entity implements aho {

	private int c = -1;
	private int d = -1;
	private int e = -1;
	private Block f;
	protected boolean a;
	public int b;
	private EntityLiving g;
	private String h;
	private int i;
	private int ap;

	public ahr(World var1) {
		super(var1);
		this.a(0.25F, 0.25F);
	}

	protected void h() {
	}

	public ahr(World var1, EntityLiving var2) {
		super(var1);
		this.g = var2;
		this.a(0.25F, 0.25F);
		this.setPositionRotation(var2.locationX, var2.locationY + (double) var2.aR(), var2.locationZ, var2.yaw, var2.pitch);
		this.locationX -= (double) (DataTypesConverter.b(this.yaw / 180.0F * 3.1415927F) * 0.16F);
		this.locationY -= 0.10000000149011612D;
		this.locationZ -= (double) (DataTypesConverter.a(this.yaw / 180.0F * 3.1415927F) * 0.16F);
		this.b(this.locationX, this.locationY, this.locationZ);
		float var3 = 0.4F;
		this.motionX = (double) (-DataTypesConverter.a(this.yaw / 180.0F * 3.1415927F) * DataTypesConverter.b(this.pitch / 180.0F * 3.1415927F) * var3);
		this.motionZ = (double) (DataTypesConverter.b(this.yaw / 180.0F * 3.1415927F) * DataTypesConverter.b(this.pitch / 180.0F * 3.1415927F) * var3);
		this.motionY = (double) (-DataTypesConverter.a((this.pitch + this.l()) / 180.0F * 3.1415927F) * var3);
		this.c(this.motionX, this.motionY, this.motionZ, this.j(), 1.0F);
	}

	public ahr(World var1, double var2, double var4, double var6) {
		super(var1);
		this.i = 0;
		this.a(0.25F, 0.25F);
		this.b(var2, var4, var6);
	}

	protected float j() {
		return 1.5F;
	}

	protected float l() {
		return 0.0F;
	}

	public void c(double var1, double var3, double var5, float var7, float var8) {
		float var9 = DataTypesConverter.a(var1 * var1 + var3 * var3 + var5 * var5);
		var1 /= (double) var9;
		var3 /= (double) var9;
		var5 /= (double) var9;
		var1 += this.V.nextGaussian() * 0.007499999832361937D * (double) var8;
		var3 += this.V.nextGaussian() * 0.007499999832361937D * (double) var8;
		var5 += this.V.nextGaussian() * 0.007499999832361937D * (double) var8;
		var1 *= (double) var7;
		var3 *= (double) var7;
		var5 *= (double) var7;
		this.motionX = var1;
		this.motionY = var3;
		this.motionZ = var5;
		float var10 = DataTypesConverter.a(var1 * var1 + var5 * var5);
		this.A = this.yaw = (float) (Math.atan2(var1, var5) * 180.0D / 3.1415927410125732D);
		this.B = this.pitch = (float) (Math.atan2(var3, (double) var10) * 180.0D / 3.1415927410125732D);
		this.i = 0;
	}

	public void s_() {
		this.P = this.locationX;
		this.Q = this.locationY;
		this.R = this.locationZ;
		super.s_();
		if (this.b > 0) {
			--this.b;
		}

		if (this.a) {
			if (this.world.getBlockState(new Position(this.c, this.d, this.e)).getBlock() == this.f) {
				++this.i;
				if (this.i == 1200) {
					this.die();
				}

				return;
			}

			this.a = false;
			this.motionX *= (double) (this.V.nextFloat() * 0.2F);
			this.motionY *= (double) (this.V.nextFloat() * 0.2F);
			this.motionZ *= (double) (this.V.nextFloat() * 0.2F);
			this.i = 0;
			this.ap = 0;
		} else {
			++this.ap;
		}

		Vec3D var1 = new Vec3D(this.locationX, this.locationY, this.locationZ);
		Vec3D var2 = new Vec3D(this.locationX + this.motionX, this.locationY + this.motionY, this.locationZ + this.motionZ);
		MovingObjectPosition var3 = this.world.a(var1, var2);
		var1 = new Vec3D(this.locationX, this.locationY, this.locationZ);
		var2 = new Vec3D(this.locationX + this.motionX, this.locationY + this.motionY, this.locationZ + this.motionZ);
		if (var3 != null) {
			var2 = new Vec3D(var3.vec.x, var3.vec.y, var3.vec.z);
		}

		if (!this.world.D) {
			Entity var4 = null;
			List var5 = this.world.b((Entity) this, this.getBoundingBox().a(this.motionX, this.motionY, this.motionZ).grow(1.0D, 1.0D, 1.0D));
			double var6 = 0.0D;
			EntityLiving var8 = this.n();

			for (int var9 = 0; var9 < var5.size(); ++var9) {
				Entity var10 = (Entity) var5.get(var9);
				if (var10.ad() && (var10 != var8 || this.ap >= 5)) {
					float var11 = 0.3F;
					AxisAlignedBB var12 = var10.getBoundingBox().grow((double) var11, (double) var11, (double) var11);
					MovingObjectPosition var13 = var12.a(var1, var2);
					if (var13 != null) {
						double var14 = var1.f(var13.vec);
						if (var14 < var6 || var6 == 0.0D) {
							var4 = var10;
							var6 = var14;
						}
					}
				}
			}

			if (var4 != null) {
				var3 = new MovingObjectPosition(var4);
			}
		}

		if (var3 != null) {
			if (var3.type == EnumMovingObjectType.BLOCK && this.world.getBlockState(var3.getPosition()).getBlock() == Blocks.PORTAL) {
				this.aq();
			} else {
				this.a(var3);
			}
		}

		this.locationX += this.motionX;
		this.locationY += this.motionY;
		this.locationZ += this.motionZ;
		float var16 = DataTypesConverter.a(this.motionX * this.motionX + this.motionZ * this.motionZ);
		this.yaw = (float) (Math.atan2(this.motionX, this.motionZ) * 180.0D / 3.1415927410125732D);

		for (this.pitch = (float) (Math.atan2(this.motionY, (double) var16) * 180.0D / 3.1415927410125732D); this.pitch - this.B < -180.0F; this.B -= 360.0F) {
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
		float var17 = 0.99F;
		float var18 = this.m();
		if (this.V()) {
			for (int var7 = 0; var7 < 4; ++var7) {
				float var19 = 0.25F;
				this.world.a(Particle.e, this.locationX - this.motionX * (double) var19, this.locationY - this.motionY * (double) var19, this.locationZ - this.motionZ * (double) var19, this.motionX, this.motionY, this.motionZ, new int[0]);
			}

			var17 = 0.8F;
		}

		this.motionX *= (double) var17;
		this.motionY *= (double) var17;
		this.motionZ *= (double) var17;
		this.motionY -= (double) var18;
		this.b(this.locationX, this.locationY, this.locationZ);
	}

	protected float m() {
		return 0.03F;
	}

	protected abstract void a(MovingObjectPosition var1);

	public void b(NBTCompoundTag var1) {
		var1.put("xTile", (short) this.c);
		var1.put("yTile", (short) this.d);
		var1.put("zTile", (short) this.e);
		RegistryObjectName var2 = (RegistryObjectName) Block.BLOCKREGISTRY.c(this.f);
		var1.put("inTile", var2 == null ? "" : var2.toString());
		var1.put("shake", (byte) this.b);
		var1.put("inGround", (byte) (this.a ? 1 : 0));
		if ((this.h == null || this.h.length() == 0) && this.g instanceof EntityHuman) {
			this.h = this.g.getName();
		}

		var1.put("ownerName", this.h == null ? "" : this.h);
	}

	public void a(NBTCompoundTag var1) {
		this.c = var1.getShort("xTile");
		this.d = var1.getShort("yTile");
		this.e = var1.getShort("zTile");
		if (var1.isTagAssignableFrom("inTile", 8)) {
			this.f = Block.b(var1.getString("inTile"));
		} else {
			this.f = Block.c(var1.getByte("inTile") & 255);
		}

		this.b = var1.getByte("shake") & 255;
		this.a = var1.getByte("inGround") == 1;
		this.h = var1.getString("ownerName");
		if (this.h != null && this.h.length() == 0) {
			this.h = null;
		}

	}

	public EntityLiving n() {
		if (this.g == null && this.h != null && this.h.length() > 0) {
			this.g = this.world.a(this.h);
		}

		return this.g;
	}
}
