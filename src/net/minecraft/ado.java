package net.minecraft;

import java.util.Arrays;
import java.util.List;

public class ado extends Entity {

	private static final List d = Arrays.asList(new adp[] { (new adp(new ItemStack(Items.T), 10)).a(0.9F), new adp(new ItemStack(Items.aF), 10), new adp(new ItemStack(Items.aX), 10), new adp(new ItemStack(Items.bz), 10), new adp(new ItemStack(Items.F), 5), (new adp(new ItemStack(Items.aR), 2)).a(0.9F), new adp(new ItemStack(Items.z), 10), new adp(new ItemStack(Items.y), 5), new adp(new ItemStack(Items.aW, 10, akv.p.b()), 1), new adp(new ItemStack(Blocks.bR), 10), new adp(new ItemStack(Items.bt), 10) });
	private static final List e = Arrays.asList(new adp[] { new adp(new ItemStack(Blocks.bx), 1), new adp(new ItemStack(Items.co), 1), new adp(new ItemStack(Items.aA), 1), (new adp(new ItemStack(Items.f), 1)).a(0.25F).a(), (new adp(new ItemStack(Items.aR), 1)).a(0.25F).a(), (new adp(new ItemStack(Items.aL), 1)).a() });
	private static final List f = Arrays.asList(new adp[] { new adp(new ItemStack(Items.aU, 1, ali.a.a()), 60), new adp(new ItemStack(Items.aU, 1, ali.b.a()), 25), new adp(new ItemStack(Items.aU, 1, ali.c.a()), 2), new adp(new ItemStack(Items.aU, 1, ali.d.a()), 13) });
	private int g = -1;
	private int h = -1;
	private int i = -1;
	private Block ap;
	private boolean aq;
	public int a;
	public EntityHuman b;
	private int ar;
	private int as;
	private int at;
	private int au;
	private int av;
	private float aw;
	public Entity c;
	private int ax;
	private double ay;
	private double az;
	private double aA;
	private double aB;
	private double aC;

	public static List j() {
		return f;
	}

	public ado(World var1) {
		super(var1);
		this.a(0.25F, 0.25F);
		this.ah = true;
	}

	public ado(World var1, EntityHuman var2) {
		super(var1);
		this.ah = true;
		this.b = var2;
		this.b.bE = this;
		this.a(0.25F, 0.25F);
		this.b(var2.locationX, var2.locationY + (double) var2.aR(), var2.locationZ, var2.yaw, var2.pitch);
		this.locationX -= (double) (DataTypesConverter.b(this.yaw / 180.0F * 3.1415927F) * 0.16F);
		this.locationY -= 0.10000000149011612D;
		this.locationZ -= (double) (DataTypesConverter.a(this.yaw / 180.0F * 3.1415927F) * 0.16F);
		this.b(this.locationX, this.locationY, this.locationZ);
		float var3 = 0.4F;
		this.motionX = (double) (-DataTypesConverter.a(this.yaw / 180.0F * 3.1415927F) * DataTypesConverter.b(this.pitch / 180.0F * 3.1415927F) * var3);
		this.motionZ = (double) (DataTypesConverter.b(this.yaw / 180.0F * 3.1415927F) * DataTypesConverter.b(this.pitch / 180.0F * 3.1415927F) * var3);
		this.motionY = (double) (-DataTypesConverter.a(this.pitch / 180.0F * 3.1415927F) * var3);
		this.c(this.motionX, this.motionY, this.motionZ, 1.5F, 1.0F);
	}

	protected void h() {
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
		this.ar = 0;
	}

	public void s_() {
		super.s_();
		if (this.ax > 0) {
			double var28 = this.locationX + (this.ay - this.locationX) / (double) this.ax;
			double var29 = this.locationY + (this.az - this.locationY) / (double) this.ax;
			double var30 = this.locationZ + (this.aA - this.locationZ) / (double) this.ax;
			double var7 = DataTypesConverter.g(this.aB - (double) this.yaw);
			this.yaw = (float) ((double) this.yaw + var7 / (double) this.ax);
			this.pitch = (float) ((double) this.pitch + (this.aC - (double) this.pitch) / (double) this.ax);
			--this.ax;
			this.b(var28, var29, var30);
			this.b(this.yaw, this.pitch);
		} else {
			if (!this.o.D) {
				ItemStack var1 = this.b.bY();
				if (this.b.I || !this.b.ai() || var1 == null || var1.getItem() != Items.aR || this.h(this.b) > 1024.0D) {
					this.J();
					this.b.bE = null;
					return;
				}

				if (this.c != null) {
					if (!this.c.I) {
						this.locationX = this.c.locationX;
						double var10002 = (double) this.c.K;
						this.locationY = this.c.aQ().b + var10002 * 0.8D;
						this.locationZ = this.c.locationZ;
						return;
					}

					this.c = null;
				}
			}

			if (this.a > 0) {
				--this.a;
			}

			if (this.aq) {
				if (this.o.p(new Position(this.g, this.h, this.i)).getBlock() == this.ap) {
					++this.ar;
					if (this.ar == 1200) {
						this.J();
					}

					return;
				}

				this.aq = false;
				this.motionX *= (double) (this.V.nextFloat() * 0.2F);
				this.motionY *= (double) (this.V.nextFloat() * 0.2F);
				this.motionZ *= (double) (this.V.nextFloat() * 0.2F);
				this.ar = 0;
				this.as = 0;
			} else {
				++this.as;
			}

			Vec3D var27 = new Vec3D(this.locationX, this.locationY, this.locationZ);
			Vec3D var2 = new Vec3D(this.locationX + this.motionX, this.locationY + this.motionY, this.locationZ + this.motionZ);
			bru var3 = this.o.a(var27, var2);
			var27 = new Vec3D(this.locationX, this.locationY, this.locationZ);
			var2 = new Vec3D(this.locationX + this.motionX, this.locationY + this.motionY, this.locationZ + this.motionZ);
			if (var3 != null) {
				var2 = new Vec3D(var3.c.x, var3.c.y, var3.c.z);
			}

			Entity var4 = null;
			List var5 = this.o.b((Entity) this, this.aQ().a(this.motionX, this.motionY, this.motionZ).b(1.0D, 1.0D, 1.0D));
			double var6 = 0.0D;

			double var13;
			for (int var8 = 0; var8 < var5.size(); ++var8) {
				Entity var9 = (Entity) var5.get(var8);
				if (var9.ad() && (var9 != this.b || this.as >= 5)) {
					float var10 = 0.3F;
					brt var11 = var9.aQ().b((double) var10, (double) var10, (double) var10);
					bru var12 = var11.a(var27, var2);
					if (var12 != null) {
						var13 = var27.f(var12.c);
						if (var13 < var6 || var6 == 0.0D) {
							var4 = var9;
							var6 = var13;
						}
					}
				}
			}

			if (var4 != null) {
				var3 = new bru(var4);
			}

			if (var3 != null) {
				if (var3.d != null) {
					if (var3.d.a(DamageSource.a((Entity) this, this.b), 0.0F)) {
						this.c = var3.d;
					}
				} else {
					this.aq = true;
				}
			}

			if (!this.aq) {
				this.d(this.motionX, this.motionY, this.motionZ);
				float var31 = DataTypesConverter.a(this.motionX * this.motionX + this.motionZ * this.motionZ);
				this.yaw = (float) (Math.atan2(this.motionX, this.motionZ) * 180.0D / 3.1415927410125732D);

				for (this.pitch = (float) (Math.atan2(this.motionY, (double) var31) * 180.0D / 3.1415927410125732D); this.pitch - this.B < -180.0F; this.B -= 360.0F) {
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
				float var32 = 0.92F;
				if (this.onGround || this.D) {
					var32 = 0.5F;
				}

				byte var33 = 5;
				double var34 = 0.0D;

				double var19;
				for (int var35 = 0; var35 < var33; ++var35) {
					brt var14 = this.aQ();
					double var15 = var14.e - var14.b;
					double var17 = var14.b + var15 * (double) var35 / (double) var33;
					var19 = var14.b + var15 * (double) (var35 + 1) / (double) var33;
					brt var21 = new brt(var14.a, var17, var14.c, var14.d, var19, var14.f);
					if (this.o.b(var21, Material.WATER)) {
						var34 += 1.0D / (double) var33;
					}
				}

				if (!this.o.D && var34 > 0.0D) {
					WorldServer var36 = (WorldServer) this.o;
					int var37 = 1;
					Position var38 = (new Position(this)).a();
					if (this.V.nextFloat() < 0.25F && this.o.C(var38)) {
						var37 = 2;
					}

					if (this.V.nextFloat() < 0.5F && !this.o.i(var38)) {
						--var37;
					}

					if (this.at > 0) {
						--this.at;
						if (this.at <= 0) {
							this.au = 0;
							this.av = 0;
						}
					} else {
						float var16;
						float var18;
						double var23;
						float var39;
						double var40;
						if (this.av > 0) {
							this.av -= var37;
							if (this.av <= 0) {
								this.motionY -= 0.20000000298023224D;
								this.a("random.splash", 0.25F, 1.0F + (this.V.nextFloat() - this.V.nextFloat()) * 0.4F);
								var16 = (float) DataTypesConverter.toFixedPointInt(this.aQ().b);
								var36.a(Particle.e, this.locationX, (double) (var16 + 1.0F), this.locationZ, (int) (1.0F + this.J * 20.0F), (double) this.J, 0.0D, (double) this.J, 0.20000000298023224D, new int[0]);
								var36.a(Particle.g, this.locationX, (double) (var16 + 1.0F), this.locationZ, (int) (1.0F + this.J * 20.0F), (double) this.J, 0.0D, (double) this.J, 0.20000000298023224D, new int[0]);
								this.at = DataTypesConverter.a(this.V, 10, 30);
							} else {
								this.aw = (float) ((double) this.aw + this.V.nextGaussian() * 4.0D);
								var16 = this.aw * 0.017453292F;
								var39 = DataTypesConverter.a(var16);
								var18 = DataTypesConverter.b(var16);
								var19 = this.locationX + (double) (var39 * (float) this.av * 0.1F);
								var40 = (double) ((float) DataTypesConverter.toFixedPointInt(this.aQ().b) + 1.0F);
								var23 = this.locationZ + (double) (var18 * (float) this.av * 0.1F);
								if (this.V.nextFloat() < 0.15F) {
									var36.a(Particle.e, var19, var40 - 0.10000000149011612D, var23, 1, (double) var39, 0.1D, (double) var18, 0.0D, new int[0]);
								}

								float var25 = var39 * 0.04F;
								float var26 = var18 * 0.04F;
								var36.a(Particle.g, var19, var40, var23, 0, (double) var26, 0.01D, (double) (-var25), 1.0D, new int[0]);
								var36.a(Particle.g, var19, var40, var23, 0, (double) (-var26), 0.01D, (double) var25, 1.0D, new int[0]);
							}
						} else if (this.au > 0) {
							this.au -= var37;
							var16 = 0.15F;
							if (this.au < 20) {
								var16 = (float) ((double) var16 + (double) (20 - this.au) * 0.05D);
							} else if (this.au < 40) {
								var16 = (float) ((double) var16 + (double) (40 - this.au) * 0.02D);
							} else if (this.au < 60) {
								var16 = (float) ((double) var16 + (double) (60 - this.au) * 0.01D);
							}

							if (this.V.nextFloat() < var16) {
								var39 = DataTypesConverter.a(this.V, 0.0F, 360.0F) * 0.017453292F;
								var18 = DataTypesConverter.a(this.V, 25.0F, 60.0F);
								var19 = this.locationX + (double) (DataTypesConverter.a(var39) * var18 * 0.1F);
								var40 = (double) ((float) DataTypesConverter.toFixedPointInt(this.aQ().b) + 1.0F);
								var23 = this.locationZ + (double) (DataTypesConverter.b(var39) * var18 * 0.1F);
								var36.a(Particle.f, var19, var40, var23, 2 + this.V.nextInt(2), 0.10000000149011612D, 0.0D, 0.10000000149011612D, 0.0D, new int[0]);
							}

							if (this.au <= 0) {
								this.aw = DataTypesConverter.a(this.V, 0.0F, 360.0F);
								this.av = DataTypesConverter.a(this.V, 20, 80);
							}
						} else {
							this.au = DataTypesConverter.a(this.V, 100, 900);
							this.au -= aph.h(this.b) * 20 * 5;
						}
					}

					if (this.at > 0) {
						this.motionY -= (double) (this.V.nextFloat() * this.V.nextFloat() * this.V.nextFloat()) * 0.2D;
					}
				}

				var13 = var34 * 2.0D - 1.0D;
				this.motionY += 0.03999999910593033D * var13;
				if (var34 > 0.0D) {
					var32 = (float) ((double) var32 * 0.9D);
					this.motionY *= 0.8D;
				}

				this.motionX *= (double) var32;
				this.motionY *= (double) var32;
				this.motionZ *= (double) var32;
				this.b(this.locationX, this.locationY, this.locationZ);
			}
		}
	}

	public void b(NBTCompoundTag var1) {
		var1.put("xTile", (short) this.g);
		var1.put("yTile", (short) this.h);
		var1.put("zTile", (short) this.i);
		RegistryObjectName var2 = (RegistryObjectName) Block.BLOCKREGISTRY.c(this.ap);
		var1.put("inTile", var2 == null ? "" : var2.toString());
		var1.put("shake", (byte) this.a);
		var1.put("inGround", (byte) (this.aq ? 1 : 0));
	}

	public void a(NBTCompoundTag var1) {
		this.g = var1.getShort("xTile");
		this.h = var1.getShort("yTile");
		this.i = var1.getShort("zTile");
		if (var1.isTagAssignableFrom("inTile", 8)) {
			this.ap = Block.b(var1.getString("inTile"));
		} else {
			this.ap = Block.c(var1.getByte("inTile") & 255);
		}

		this.a = var1.getByte("shake") & 255;
		this.aq = var1.getByte("inGround") == 1;
	}

	public int l() {
		if (this.o.D) {
			return 0;
		} else {
			byte var1 = 0;
			if (this.c != null) {
				double var2 = this.b.locationX - this.locationX;
				double var4 = this.b.locationY - this.locationY;
				double var6 = this.b.locationZ - this.locationZ;
				double var8 = (double) DataTypesConverter.a(var2 * var2 + var4 * var4 + var6 * var6);
				double var10 = 0.1D;
				this.c.motionX += var2 * var10;
				this.c.motionY += var4 * var10 + (double) DataTypesConverter.a(var8) * 0.08D;
				this.c.motionZ += var6 * var10;
				var1 = 3;
			} else if (this.at > 0) {
				EntityItem var13 = new EntityItem(this.o, this.locationX, this.locationY, this.locationZ, this.m());
				double var3 = this.b.locationX - this.locationX;
				double var5 = this.b.locationY - this.locationY;
				double var7 = this.b.locationZ - this.locationZ;
				double var9 = (double) DataTypesConverter.a(var3 * var3 + var5 * var5 + var7 * var7);
				double var11 = 0.1D;
				var13.motionX = var3 * var11;
				var13.motionY = var5 * var11 + (double) DataTypesConverter.a(var9) * 0.08D;
				var13.motionZ = var7 * var11;
				this.o.d((Entity) var13);
				this.b.o.d((Entity) (new EntityExpirienceOrb(this.b.o, this.b.locationX, this.b.locationY + 0.5D, this.b.locationZ + 0.5D, this.V.nextInt(6) + 1)));
				var1 = 1;
			}

			if (this.aq) {
				var1 = 2;
			}

			this.J();
			this.b.bE = null;
			return var1;
		}
	}

	private ItemStack m() {
		float var1 = this.o.s.nextFloat();
		int var2 = aph.g(this.b);
		int var3 = aph.h(this.b);
		float var4 = 0.1F - (float) var2 * 0.025F - (float) var3 * 0.01F;
		float var5 = 0.05F + (float) var2 * 0.01F - (float) var3 * 0.01F;
		var4 = DataTypesConverter.a(var4, 0.0F, 1.0F);
		var5 = DataTypesConverter.a(var5, 0.0F, 1.0F);
		if (var1 < var4) {
			this.b.b(StatisticList.D);
			return ((adp) vj.a(this.V, d)).a(this.V);
		} else {
			var1 -= var4;
			if (var1 < var5) {
				this.b.b(StatisticList.E);
				return ((adp) vj.a(this.V, e)).a(this.V);
			} else {
				float var10000 = var1 - var5;
				this.b.b(StatisticList.C);
				return ((adp) vj.a(this.V, f)).a(this.V);
			}
		}
	}

	public void J() {
		super.J();
		if (this.b != null) {
			this.b.bE = null;
		}

	}

}
