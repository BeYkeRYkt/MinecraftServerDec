package net.minecraft;

import java.util.List;

public class EntityBoat extends Entity {

	private boolean a;
	private double b;
	private int c;
	private double d;
	private double e;
	private double f;
	private double g;
	private double h;

	public EntityBoat(World var1) {
		super(var1);
		this.a = true;
		this.b = 0.07D;
		this.k = true;
		this.a(1.5F, 0.6F);
	}

	protected boolean r_() {
		return false;
	}

	protected void h() {
		this.dataWatcher.a(17, new Integer(0));
		this.dataWatcher.a(18, new Integer(1));
		this.dataWatcher.a(19, new Float(0.0F));
	}

	public AxisAlignedBB j(Entity var1) {
		return var1.getBoundingBox();
	}

	public AxisAlignedBB S() {
		return this.getBoundingBox();
	}

	public boolean ae() {
		return true;
	}

	public EntityBoat(World var1, double var2, double var4, double var6) {
		this(var1);
		this.b(var2, var4, var6);
		this.motionX = 0.0D;
		this.motionY = 0.0D;
		this.motionZ = 0.0D;
		this.p = var2;
		this.q = var4;
		this.r = var6;
	}

	public double an() {
		return (double) this.K * 0.0D - 0.30000001192092896D;
	}

	public boolean a(DamageSource var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else if (!this.world.D && !this.dead) {
			if (this.l != null && this.l == var1.j() && var1 instanceof wj) {
				return false;
			} else {
				this.b(-this.m());
				this.a(10);
				this.a(this.j() + var2 * 10.0F);
				this.ac();
				boolean var3 = var1.j() instanceof EntityHuman && ((EntityHuman) var1.j()).playerProperties.instabuild;
				if (var3 || this.j() > 40.0F) {
					if (this.l != null) {
						this.l.a((Entity) this);
					}

					if (!var3) {
						this.a(Items.BOAT, 1, 0.0F);
					}

					this.die();
				}

				return true;
			}
		} else {
			return true;
		}
	}

	public boolean ad() {
		return !this.dead;
	}

	public void s_() {
		super.s_();
		if (this.l() > 0) {
			this.a(this.l() - 1);
		}

		if (this.j() > 0.0F) {
			this.a(this.j() - 1.0F);
		}

		this.p = this.locationX;
		this.q = this.locationY;
		this.r = this.locationZ;
		byte var1 = 5;
		double var2 = 0.0D;

		for (int var4 = 0; var4 < var1; ++var4) {
			double var5 = this.getBoundingBox().minY + (this.getBoundingBox().maxY - this.getBoundingBox().minY) * (double) (var4 + 0) / (double) var1 - 0.125D;
			double var7 = this.getBoundingBox().minY + (this.getBoundingBox().maxY - this.getBoundingBox().minY) * (double) (var4 + 1) / (double) var1 - 0.125D;
			AxisAlignedBB var9 = new AxisAlignedBB(this.getBoundingBox().minX, var5, this.getBoundingBox().minZ, this.getBoundingBox().maxX, var7, this.getBoundingBox().maxZ);
			if (this.world.b(var9, Material.WATER)) {
				var2 += 1.0D / (double) var1;
			}
		}

		double var19 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
		double var6;
		double var8;
		int var10;
		if (var19 > 0.2975D) {
			var6 = Math.cos((double) this.yaw * 3.141592653589793D / 180.0D);
			var8 = Math.sin((double) this.yaw * 3.141592653589793D / 180.0D);

			for (var10 = 0; (double) var10 < 1.0D + var19 * 60.0D; ++var10) {
				double var11 = (double) (this.V.nextFloat() * 2.0F - 1.0F);
				double var13 = (double) (this.V.nextInt(2) * 2 - 1) * 0.7D;
				double var15;
				double var17;
				if (this.V.nextBoolean()) {
					var15 = this.locationX - var6 * var11 * 0.8D + var8 * var13;
					var17 = this.locationZ - var8 * var11 * 0.8D - var6 * var13;
					this.world.a(Particle.f, var15, this.locationY - 0.125D, var17, this.motionX, this.motionY, this.motionZ, new int[0]);
				} else {
					var15 = this.locationX + var6 + var8 * var11 * 0.7D;
					var17 = this.locationZ + var8 - var6 * var11 * 0.7D;
					this.world.a(Particle.f, var15, this.locationY - 0.125D, var17, this.motionX, this.motionY, this.motionZ, new int[0]);
				}
			}
		}

		double var24;
		double var26;
		if (this.world.D && this.a) {
			if (this.c > 0) {
				var6 = this.locationX + (this.d - this.locationX) / (double) this.c;
				var8 = this.locationY + (this.e - this.locationY) / (double) this.c;
				var24 = this.locationZ + (this.f - this.locationZ) / (double) this.c;
				var26 = DataTypesConverter.g(this.g - (double) this.yaw);
				this.yaw = (float) ((double) this.yaw + var26 / (double) this.c);
				this.pitch = (float) ((double) this.pitch + (this.h - (double) this.pitch) / (double) this.c);
				--this.c;
				this.b(var6, var8, var24);
				this.b(this.yaw, this.pitch);
			} else {
				var6 = this.locationX + this.motionX;
				var8 = this.locationY + this.motionY;
				var24 = this.locationZ + this.motionZ;
				this.b(var6, var8, var24);
				if (this.onGround) {
					this.motionX *= 0.5D;
					this.motionY *= 0.5D;
					this.motionZ *= 0.5D;
				}

				this.motionX *= 0.9900000095367432D;
				this.motionY *= 0.949999988079071D;
				this.motionZ *= 0.9900000095367432D;
			}

		} else {
			if (var2 < 1.0D) {
				var6 = var2 * 2.0D - 1.0D;
				this.motionY += 0.03999999910593033D * var6;
			} else {
				if (this.motionY < 0.0D) {
					this.motionY /= 2.0D;
				}

				this.motionY += 0.007000000216066837D;
			}

			if (this.l instanceof EntityLiving) {
				EntityLiving var20 = (EntityLiving) this.l;
				float var21 = this.l.yaw + -var20.aX * 90.0F;
				this.motionX += -Math.sin((double) (var21 * 3.1415927F / 180.0F)) * this.b * (double) var20.aY * 0.05000000074505806D;
				this.motionZ += Math.cos((double) (var21 * 3.1415927F / 180.0F)) * this.b * (double) var20.aY * 0.05000000074505806D;
			}

			var6 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
			if (var6 > 0.35D) {
				var8 = 0.35D / var6;
				this.motionX *= var8;
				this.motionZ *= var8;
				var6 = 0.35D;
			}

			if (var6 > var19 && this.b < 0.35D) {
				this.b += (0.35D - this.b) / 35.0D;
				if (this.b > 0.35D) {
					this.b = 0.35D;
				}
			} else {
				this.b -= (this.b - 0.07D) / 35.0D;
				if (this.b < 0.07D) {
					this.b = 0.07D;
				}
			}

			int var22;
			for (var22 = 0; var22 < 4; ++var22) {
				int var23 = DataTypesConverter.toFixedPointInt(this.locationX + ((double) (var22 % 2) - 0.5D) * 0.8D);
				var10 = DataTypesConverter.toFixedPointInt(this.locationZ + ((double) (var22 / 2) - 0.5D) * 0.8D);

				for (int var25 = 0; var25 < 2; ++var25) {
					int var12 = DataTypesConverter.toFixedPointInt(this.locationY) + var25;
					Position var27 = new Position(var23, var12, var10);
					Block var14 = this.world.getBlockState(var27).getBlock();
					if (var14 == Blocks.SNOW_LAYER) {
						this.world.g(var27);
						this.D = false;
					} else if (var14 == Blocks.WATER_LILY) {
						this.world.b(var27, true);
						this.D = false;
					}
				}
			}

			if (this.onGround) {
				this.motionX *= 0.5D;
				this.motionY *= 0.5D;
				this.motionZ *= 0.5D;
			}

			this.move(this.motionX, this.motionY, this.motionZ);
			if (this.D && var19 > 0.2D) {
				if (!this.world.D && !this.dead) {
					this.die();

					for (var22 = 0; var22 < 3; ++var22) {
						this.a(Item.getItemOf(Blocks.PLANKS), 1, 0.0F);
					}

					for (var22 = 0; var22 < 2; ++var22) {
						this.a(Items.STICK, 1, 0.0F);
					}
				}
			} else {
				this.motionX *= 0.9900000095367432D;
				this.motionY *= 0.949999988079071D;
				this.motionZ *= 0.9900000095367432D;
			}

			this.pitch = 0.0F;
			var8 = (double) this.yaw;
			var24 = this.p - this.locationX;
			var26 = this.r - this.locationZ;
			if (var24 * var24 + var26 * var26 > 0.001D) {
				var8 = (double) ((float) (Math.atan2(var26, var24) * 180.0D / 3.141592653589793D));
			}

			double var28 = DataTypesConverter.g(var8 - (double) this.yaw);
			if (var28 > 20.0D) {
				var28 = 20.0D;
			}

			if (var28 < -20.0D) {
				var28 = -20.0D;
			}

			this.yaw = (float) ((double) this.yaw + var28);
			this.b(this.yaw, this.pitch);
			if (!this.world.D) {
				List var16 = this.world.b((Entity) this, this.getBoundingBox().grow(0.20000000298023224D, 0.0D, 0.20000000298023224D));
				if (var16 != null && !var16.isEmpty()) {
					for (int var29 = 0; var29 < var16.size(); ++var29) {
						Entity var18 = (Entity) var16.get(var29);
						if (var18 != this.l && var18.ae() && var18 instanceof EntityBoat) {
							var18.i(this);
						}
					}
				}

				if (this.l != null && this.l.dead) {
					this.l = null;
				}

			}
		}
	}

	public void al() {
		if (this.l != null) {
			double var1 = Math.cos((double) this.yaw * 3.141592653589793D / 180.0D) * 0.4D;
			double var3 = Math.sin((double) this.yaw * 3.141592653589793D / 180.0D) * 0.4D;
			this.l.b(this.locationX + var1, this.locationY + this.an() + this.l.am(), this.locationZ + var3);
		}
	}

	protected void b(NBTCompoundTag var1) {
	}

	protected void a(NBTCompoundTag var1) {
	}

	public boolean e(EntityHuman var1) {
		if (this.l != null && this.l instanceof EntityHuman && this.l != var1) {
			return true;
		} else {
			if (!this.world.D) {
				var1.a((Entity) this);
			}

			return true;
		}
	}

	protected void a(double var1, boolean var3, Block var4, Position var5) {
		if (var3) {
			if (this.O > 3.0F) {
				this.e(this.O, 1.0F);
				if (!this.world.D && !this.dead) {
					this.die();

					int var6;
					for (var6 = 0; var6 < 3; ++var6) {
						this.a(Item.getItemOf(Blocks.PLANKS), 1, 0.0F);
					}

					for (var6 = 0; var6 < 2; ++var6) {
						this.a(Items.STICK, 1, 0.0F);
					}
				}

				this.O = 0.0F;
			}
		} else if (this.world.getBlockState((new Position(this)).b()).getBlock().getMaterial() != Material.WATER && var1 < 0.0D) {
			this.O = (float) ((double) this.O - var1);
		}

	}

	public void a(float var1) {
		this.dataWatcher.b(19, Float.valueOf(var1));
	}

	public float j() {
		return this.dataWatcher.getData(19);
	}

	public void a(int var1) {
		this.dataWatcher.b(17, Integer.valueOf(var1));
	}

	public int l() {
		return this.dataWatcher.c(17);
	}

	public void b(int var1) {
		this.dataWatcher.b(18, Integer.valueOf(var1));
	}

	public int m() {
		return this.dataWatcher.c(18);
	}
}
