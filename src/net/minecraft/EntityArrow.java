package net.minecraft;

import java.util.List;

public class EntityArrow extends Entity implements aho {

	private int d = -1;
	private int e = -1;
	private int f = -1;
	private Block g;
	private int h;
	private boolean i;
	public int a;
	public int b;
	public Entity c;
	private int ap;
	private int aq;
	private double ar = 2.0D;
	private int as;

	public EntityArrow(World var1) {
		super(var1);
		this.j = 10.0D;
		this.a(0.5F, 0.5F);
	}

	public EntityArrow(World var1, double var2, double var4, double var6) {
		super(var1);
		this.j = 10.0D;
		this.a(0.5F, 0.5F);
		this.b(var2, var4, var6);
	}

	public EntityArrow(World var1, EntityLiving var2, EntityLiving var3, float var4, float var5) {
		super(var1);
		this.j = 10.0D;
		this.c = var2;
		if (var2 instanceof EntityHuman) {
			this.a = 1;
		}

		this.locationY = var2.locationY + (double) var2.aR() - 0.10000000149011612D;
		double var6 = var3.locationX - var2.locationX;
		double var8 = var3.aQ().b + (double) (var3.K / 3.0F) - this.locationY;
		double var10 = var3.locationZ - var2.locationZ;
		double var12 = (double) DataTypesConverter.a(var6 * var6 + var10 * var10);
		if (var12 >= 1.0E-7D) {
			float var14 = (float) (Math.atan2(var10, var6) * 180.0D / 3.1415927410125732D) - 90.0F;
			float var15 = (float) (-(Math.atan2(var8, var12) * 180.0D / 3.1415927410125732D));
			double var16 = var6 / var12;
			double var18 = var10 / var12;
			this.b(var2.locationX + var16, this.locationY, var2.locationZ + var18, var14, var15);
			float var20 = (float) (var12 * 0.20000000298023224D);
			this.c(var6, var8 + (double) var20, var10, var4, var5);
		}
	}

	public EntityArrow(World var1, EntityLiving var2, float var3) {
		super(var1);
		this.j = 10.0D;
		this.c = var2;
		if (var2 instanceof EntityHuman) {
			this.a = 1;
		}

		this.a(0.5F, 0.5F);
		this.b(var2.locationX, var2.locationY + (double) var2.aR(), var2.locationZ, var2.yaw, var2.pitch);
		this.locationX -= (double) (DataTypesConverter.b(this.yaw / 180.0F * 3.1415927F) * 0.16F);
		this.locationY -= 0.10000000149011612D;
		this.locationZ -= (double) (DataTypesConverter.a(this.yaw / 180.0F * 3.1415927F) * 0.16F);
		this.b(this.locationX, this.locationY, this.locationZ);
		this.motionX = (double) (-DataTypesConverter.a(this.yaw / 180.0F * 3.1415927F) * DataTypesConverter.b(this.pitch / 180.0F * 3.1415927F));
		this.motionZ = (double) (DataTypesConverter.b(this.yaw / 180.0F * 3.1415927F) * DataTypesConverter.b(this.pitch / 180.0F * 3.1415927F));
		this.motionY = (double) (-DataTypesConverter.a(this.pitch / 180.0F * 3.1415927F));
		this.c(this.motionX, this.motionY, this.motionZ, var3 * 1.5F, 1.0F);
	}

	protected void h() {
		this.dataWatcher.a(16, Byte.valueOf((byte) 0));
	}

	public void c(double var1, double var3, double var5, float var7, float var8) {
		float var9 = DataTypesConverter.a(var1 * var1 + var3 * var3 + var5 * var5);
		var1 /= (double) var9;
		var3 /= (double) var9;
		var5 /= (double) var9;
		var1 += this.V.nextGaussian() * (double) (this.V.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double) var8;
		var3 += this.V.nextGaussian() * (double) (this.V.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double) var8;
		var5 += this.V.nextGaussian() * (double) (this.V.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double) var8;
		var1 *= (double) var7;
		var3 *= (double) var7;
		var5 *= (double) var7;
		this.motionX = var1;
		this.motionY = var3;
		this.motionZ = var5;
		float var10 = DataTypesConverter.a(var1 * var1 + var5 * var5);
		this.A = this.yaw = (float) (Math.atan2(var1, var5) * 180.0D / 3.1415927410125732D);
		this.B = this.pitch = (float) (Math.atan2(var3, (double) var10) * 180.0D / 3.1415927410125732D);
		this.ap = 0;
	}

	public void s_() {
		super.s_();
		if (this.B == 0.0F && this.A == 0.0F) {
			float var1 = DataTypesConverter.a(this.motionX * this.motionX + this.motionZ * this.motionZ);
			this.A = this.yaw = (float) (Math.atan2(this.motionX, this.motionZ) * 180.0D / 3.1415927410125732D);
			this.B = this.pitch = (float) (Math.atan2(this.motionY, (double) var1) * 180.0D / 3.1415927410125732D);
		}

		Position var18 = new Position(this.d, this.e, this.f);
		bec var2 = this.o.p(var18);
		Block var3 = var2.getBlock();
		if (var3.r() != Material.AIR) {
			var3.a((ard) this.o, var18);
			brt var4 = var3.a(this.o, var18, var2);
			if (var4 != null && var4.a(new Vec3D(this.locationX, this.locationY, this.locationZ))) {
				this.i = true;
			}
		}

		if (this.b > 0) {
			--this.b;
		}

		if (this.i) {
			int var20 = var3.c(var2);
			if (var3 == this.g && var20 == this.h) {
				++this.ap;
				if (this.ap >= 1200) {
					this.J();
				}

			} else {
				this.i = false;
				this.motionX *= (double) (this.V.nextFloat() * 0.2F);
				this.motionY *= (double) (this.V.nextFloat() * 0.2F);
				this.motionZ *= (double) (this.V.nextFloat() * 0.2F);
				this.ap = 0;
				this.aq = 0;
			}
		} else {
			++this.aq;
			Vec3D var19 = new Vec3D(this.locationX, this.locationY, this.locationZ);
			Vec3D var5 = new Vec3D(this.locationX + this.motionX, this.locationY + this.motionY, this.locationZ + this.motionZ);
			bru var6 = this.o.a(var19, var5, false, true, false);
			var19 = new Vec3D(this.locationX, this.locationY, this.locationZ);
			var5 = new Vec3D(this.locationX + this.motionX, this.locationY + this.motionY, this.locationZ + this.motionZ);
			if (var6 != null) {
				var5 = new Vec3D(var6.c.x, var6.c.y, var6.c.z);
			}

			Entity var7 = null;
			List var8 = this.o.b((Entity) this, this.aQ().a(this.motionX, this.motionY, this.motionZ).b(1.0D, 1.0D, 1.0D));
			double var9 = 0.0D;

			int var11;
			float var13;
			for (var11 = 0; var11 < var8.size(); ++var11) {
				Entity var12 = (Entity) var8.get(var11);
				if (var12.ad() && (var12 != this.c || this.aq >= 5)) {
					var13 = 0.3F;
					brt var14 = var12.aQ().b((double) var13, (double) var13, (double) var13);
					bru var15 = var14.a(var19, var5);
					if (var15 != null) {
						double var16 = var19.f(var15.c);
						if (var16 < var9 || var9 == 0.0D) {
							var7 = var12;
							var9 = var16;
						}
					}
				}
			}

			if (var7 != null) {
				var6 = new bru(var7);
			}

			if (var6 != null && var6.d != null && var6.d instanceof EntityHuman) {
				EntityHuman var21 = (EntityHuman) var6.d;
				if (var21.by.invulnerable || this.c instanceof EntityHuman && !((EntityHuman) this.c).a(var21)) {
					var6 = null;
				}
			}

			float var22;
			float var25;
			float var29;
			if (var6 != null) {
				if (var6.d != null) {
					var22 = DataTypesConverter.a(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
					int var24 = DataTypesConverter.f((double) var22 * this.ar);
					if (this.l()) {
						var24 += this.V.nextInt(var24 / 2 + 2);
					}

					DamageSource var26;
					if (this.c == null) {
						var26 = DamageSource.a(this, this);
					} else {
						var26 = DamageSource.a(this, this.c);
					}

					if (this.au() && !(var6.d instanceof EntityEnderman)) {
						var6.d.e(5);
					}

					if (var6.d.a(var26, (float) var24)) {
						if (var6.d instanceof EntityLiving) {
							EntityLiving var27 = (EntityLiving) var6.d;
							if (!this.o.D) {
								var27.o(var27.bu() + 1);
							}

							if (this.as > 0) {
								var29 = DataTypesConverter.a(this.motionX * this.motionX + this.motionZ * this.motionZ);
								if (var29 > 0.0F) {
									var6.d.g(this.motionX * (double) this.as * 0.6000000238418579D / (double) var29, 0.1D, this.motionZ * (double) this.as * 0.6000000238418579D / (double) var29);
								}
							}

							if (this.c instanceof EntityLiving) {
								aph.a(var27, this.c);
								aph.b((EntityLiving) this.c, var27);
							}

							if (this.c != null && var6.d != this.c && var6.d instanceof EntityHuman && this.c instanceof EntityPlayer) {
								((EntityPlayer) this.c).playerConncetion.sendPacket((Packet) (new PacketOutChangeGameState(6, 0.0F)));
							}
						}

						this.a("random.bowhit", 1.0F, 1.2F / (this.V.nextFloat() * 0.2F + 0.9F));
						if (!(var6.d instanceof EntityEnderman)) {
							this.J();
						}
					} else {
						this.motionX *= -0.10000000149011612D;
						this.motionY *= -0.10000000149011612D;
						this.motionZ *= -0.10000000149011612D;
						this.yaw += 180.0F;
						this.A += 180.0F;
						this.aq = 0;
					}
				} else {
					Position var23 = var6.a();
					this.d = var23.getX();
					this.e = var23.getY();
					this.f = var23.getZ();
					var2 = this.o.p(var23);
					this.g = var2.getBlock();
					this.h = this.g.c(var2);
					this.motionX = (double) ((float) (var6.c.x - this.locationX));
					this.motionY = (double) ((float) (var6.c.y - this.locationY));
					this.motionZ = (double) ((float) (var6.c.z - this.locationZ));
					var25 = DataTypesConverter.a(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
					this.locationX -= this.motionX / (double) var25 * 0.05000000074505806D;
					this.locationY -= this.motionY / (double) var25 * 0.05000000074505806D;
					this.locationZ -= this.motionZ / (double) var25 * 0.05000000074505806D;
					this.a("random.bowhit", 1.0F, 1.2F / (this.V.nextFloat() * 0.2F + 0.9F));
					this.i = true;
					this.b = 7;
					this.a(false);
					if (this.g.r() != Material.AIR) {
						this.g.a(this.o, var23, var2, (Entity) this);
					}
				}
			}

			if (this.l()) {
				for (var11 = 0; var11 < 4; ++var11) {
					this.o.a(Particle.j, this.locationX + this.motionX * (double) var11 / 4.0D, this.locationY + this.motionY * (double) var11 / 4.0D, this.locationZ + this.motionZ * (double) var11 / 4.0D, -this.motionX, -this.motionY + 0.2D, -this.motionZ, new int[0]);
				}
			}

			this.locationX += this.motionX;
			this.locationY += this.motionY;
			this.locationZ += this.motionZ;
			var22 = DataTypesConverter.a(this.motionX * this.motionX + this.motionZ * this.motionZ);
			this.yaw = (float) (Math.atan2(this.motionX, this.motionZ) * 180.0D / 3.1415927410125732D);

			for (this.pitch = (float) (Math.atan2(this.motionY, (double) var22) * 180.0D / 3.1415927410125732D); this.pitch - this.B < -180.0F; this.B -= 360.0F) {
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
			var25 = 0.99F;
			var13 = 0.05F;
			if (this.V()) {
				for (int var28 = 0; var28 < 4; ++var28) {
					var29 = 0.25F;
					this.o.a(Particle.e, this.locationX - this.motionX * (double) var29, this.locationY - this.motionY * (double) var29, this.locationZ - this.motionZ * (double) var29, this.motionX, this.motionY, this.motionZ, new int[0]);
				}

				var25 = 0.6F;
			}

			if (this.U()) {
				this.N();
			}

			this.motionX *= (double) var25;
			this.motionY *= (double) var25;
			this.motionZ *= (double) var25;
			this.motionY -= (double) var13;
			this.b(this.locationX, this.locationY, this.locationZ);
			this.Q();
		}
	}

	public void b(NBTCompoundTag var1) {
		var1.put("xTile", (short) this.d);
		var1.put("yTile", (short) this.e);
		var1.put("zTile", (short) this.f);
		var1.put("life", (short) this.ap);
		RegistryObjectName var2 = (RegistryObjectName) Block.BLOCKREGISTRY.c(this.g);
		var1.put("inTile", var2 == null ? "" : var2.toString());
		var1.put("inData", (byte) this.h);
		var1.put("shake", (byte) this.b);
		var1.put("inGround", (byte) (this.i ? 1 : 0));
		var1.put("pickup", (byte) this.a);
		var1.put("damage", this.ar);
	}

	public void a(NBTCompoundTag var1) {
		this.d = var1.getShort("xTile");
		this.e = var1.getShort("yTile");
		this.f = var1.getShort("zTile");
		this.ap = var1.getShort("life");
		if (var1.isTagAssignableFrom("inTile", 8)) {
			this.g = Block.b(var1.getString("inTile"));
		} else {
			this.g = Block.c(var1.getByte("inTile") & 255);
		}

		this.h = var1.getByte("inData") & 255;
		this.b = var1.getByte("shake") & 255;
		this.i = var1.getByte("inGround") == 1;
		if (var1.isTagAssignableFrom("damage", 99)) {
			this.ar = var1.getDouble("damage");
		}

		if (var1.isTagAssignableFrom("pickup", 99)) {
			this.a = var1.getByte("pickup");
		} else if (var1.isTagAssignableFrom("player", 99)) {
			this.a = var1.getBoolean("player") ? 1 : 0;
		}

	}

	public void d(EntityHuman var1) {
		if (!this.o.D && this.i && this.b <= 0) {
			boolean var2 = this.a == 1 || this.a == 2 && var1.by.instabuild;
			if (this.a == 1 && !var1.playerInventory.a(new ItemStack(Items.ARROW, 1))) {
				var2 = false;
			}

			if (var2) {
				this.a("random.pop", 0.2F, ((this.V.nextFloat() - this.V.nextFloat()) * 0.7F + 1.0F) * 2.0F);
				var1.a((Entity) this, 1);
				this.J();
			}

		}
	}

	protected boolean r_() {
		return false;
	}

	public void b(double var1) {
		this.ar = var1;
	}

	public double j() {
		return this.ar;
	}

	public void a(int var1) {
		this.as = var1;
	}

	public boolean aE() {
		return false;
	}

	public void a(boolean var1) {
		byte var2 = this.dataWatcher.a(16);
		if (var1) {
			this.dataWatcher.b(16, Byte.valueOf((byte) (var2 | 1)));
		} else {
			this.dataWatcher.b(16, Byte.valueOf((byte) (var2 & -2)));
		}

	}

	public boolean l() {
		byte var1 = this.dataWatcher.a(16);
		return (var1 & 1) != 0;
	}
}
