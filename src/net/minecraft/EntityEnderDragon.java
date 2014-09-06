package net.minecraft;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EntityEnderDragon extends EntityInsentient implements acy, aex {

	public double a;
	public double b;
	public double c;
	public double[][] bi = new double[64][3];
	public int bj = -1;
	public acz[] bk;
	public acz bl;
	public acz bm;
	public acz bn;
	public acz bo;
	public acz bp;
	public acz bq;
	public acz br;
	public float bs;
	public float bt;
	public boolean bu;
	public boolean bv;
	private Entity by;
	public int bw;
	public EntityEnderCrystal bx;

	public EntityEnderDragon(World var1) {
		super(var1);
		this.bk = new acz[] { this.bl = new acz(this, "head", 6.0F, 6.0F), this.bm = new acz(this, "body", 8.0F, 8.0F), this.bn = new acz(this, "tail", 4.0F, 4.0F), this.bo = new acz(this, "tail", 4.0F, 4.0F), this.bp = new acz(this, "tail", 4.0F, 4.0F), this.bq = new acz(this, "wing", 4.0F, 4.0F), this.br = new acz(this, "wing", 4.0F, 4.0F) };
		this.h(this.bt());
		this.a(16.0F, 8.0F);
		this.T = true;
		this.ab = true;
		this.b = 100.0D;
		this.ah = true;
	}

	protected void aW() {
		super.aW();
		this.a(afs.a).a(200.0D);
	}

	protected void h() {
		super.h();
	}

	public double[] b(int var1, float var2) {
		if (this.bm() <= 0.0F) {
			var2 = 0.0F;
		}

		var2 = 1.0F - var2;
		int var3 = this.bj - var1 * 1 & 63;
		int var4 = this.bj - var1 * 1 - 1 & 63;
		double[] var5 = new double[3];
		double var6 = this.bi[var3][0];
		double var8 = DataTypesConverter.g(this.bi[var4][0] - var6);
		var5[0] = var6 + var8 * (double) var2;
		var6 = this.bi[var3][1];
		var8 = this.bi[var4][1] - var6;
		var5[1] = var6 + var8 * (double) var2;
		var5[2] = this.bi[var3][2] + (this.bi[var4][2] - this.bi[var3][2]) * (double) var2;
		return var5;
	}

	public void m() {
		float var1;
		float var2;
		if (this.o.D) {
			var1 = DataTypesConverter.b(this.bt * 3.1415927F * 2.0F);
			var2 = DataTypesConverter.b(this.bs * 3.1415927F * 2.0F);
			if (var2 <= -0.3F && var1 >= -0.3F && !this.R()) {
				this.o.a(this.locationX, this.locationY, this.locationZ, "mob.enderdragon.wings", 5.0F, 0.8F + this.V.nextFloat() * 0.3F, false);
			}
		}

		this.bs = this.bt;
		float var3;
		if (this.bm() <= 0.0F) {
			var1 = (this.V.nextFloat() - 0.5F) * 8.0F;
			var2 = (this.V.nextFloat() - 0.5F) * 4.0F;
			var3 = (this.V.nextFloat() - 0.5F) * 8.0F;
			this.o.a(Particle.b, this.locationX + (double) var1, this.locationY + 2.0D + (double) var2, this.locationZ + (double) var3, 0.0D, 0.0D, 0.0D, new int[0]);
		} else {
			this.n();
			var1 = 0.2F / (DataTypesConverter.a(this.motionX * this.motionX + this.motionZ * this.motionZ) * 10.0F + 1.0F);
			var1 *= (float) Math.pow(2.0D, this.motionY);
			if (this.bv) {
				this.bt += var1 * 0.5F;
			} else {
				this.bt += var1;
			}

			this.yaw = DataTypesConverter.g(this.yaw);
			if (this.bj < 0) {
				for (int var27 = 0; var27 < this.bi.length; ++var27) {
					this.bi[var27][0] = (double) this.yaw;
					this.bi[var27][1] = this.locationY;
				}
			}

			if (++this.bj == this.bi.length) {
				this.bj = 0;
			}

			this.bi[this.bj][0] = (double) this.yaw;
			this.bi[this.bj][1] = this.locationY;
			double var4;
			double var6;
			double var8;
			double var28;
			float var33;
			if (this.o.D) {
				if (this.ba > 0) {
					var28 = this.locationX + (this.bb - this.locationX) / (double) this.ba;
					var4 = this.locationY + (this.bc - this.locationY) / (double) this.ba;
					var6 = this.locationZ + (this.bd - this.locationZ) / (double) this.ba;
					var8 = DataTypesConverter.g(this.be - (double) this.yaw);
					this.yaw = (float) ((double) this.yaw + var8 / (double) this.ba);
					this.pitch = (float) ((double) this.pitch + (this.bf - (double) this.pitch) / (double) this.ba);
					--this.ba;
					this.b(var28, var4, var6);
					this.b(this.yaw, this.pitch);
				}
			} else {
				var28 = this.a - this.locationX;
				var4 = this.b - this.locationY;
				var6 = this.c - this.locationZ;
				var8 = var28 * var28 + var4 * var4 + var6 * var6;
				double var16;
				if (this.by != null) {
					this.a = this.by.locationX;
					this.c = this.by.locationZ;
					double var10 = this.a - this.locationX;
					double var12 = this.c - this.locationZ;
					double var14 = Math.sqrt(var10 * var10 + var12 * var12);
					var16 = 0.4000000059604645D + var14 / 80.0D - 1.0D;
					if (var16 > 10.0D) {
						var16 = 10.0D;
					}

					this.b = this.by.aQ().b + var16;
				} else {
					this.a += this.V.nextGaussian() * 2.0D;
					this.c += this.V.nextGaussian() * 2.0D;
				}

				if (this.bu || var8 < 100.0D || var8 > 22500.0D || this.D || this.E) {
					this.cd();
				}

				var4 /= (double) DataTypesConverter.a(var28 * var28 + var6 * var6);
				var33 = 0.6F;
				var4 = DataTypesConverter.a(var4, (double) (-var33), (double) var33);
				this.motionY += var4 * 0.10000000149011612D;
				this.yaw = DataTypesConverter.g(this.yaw);
				double var11 = 180.0D - Math.atan2(var28, var6) * 180.0D / 3.1415927410125732D;
				double var13 = DataTypesConverter.g(var11 - (double) this.yaw);
				if (var13 > 50.0D) {
					var13 = 50.0D;
				}

				if (var13 < -50.0D) {
					var13 = -50.0D;
				}

				Vec3D var15 = (new Vec3D(this.a - this.locationX, this.b - this.locationY, this.c - this.locationZ)).a();
				var16 = (double) (-DataTypesConverter.b(this.yaw * 3.1415927F / 180.0F));
				Vec3D var18 = (new Vec3D((double) DataTypesConverter.a(this.yaw * 3.1415927F / 180.0F), this.motionY, var16)).a();
				float var19 = ((float) var18.b(var15) + 0.5F) / 1.5F;
				if (var19 < 0.0F) {
					var19 = 0.0F;
				}

				this.aZ *= 0.8F;
				float var20 = DataTypesConverter.a(this.motionX * this.motionX + this.motionZ * this.motionZ) * 1.0F + 1.0F;
				double var21 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ) * 1.0D + 1.0D;
				if (var21 > 40.0D) {
					var21 = 40.0D;
				}

				this.aZ = (float) ((double) this.aZ + var13 * (0.699999988079071D / var21 / (double) var20));
				this.yaw += this.aZ * 0.1F;
				float var23 = (float) (2.0D / (var21 + 1.0D));
				float var24 = 0.06F;
				this.a(0.0F, -1.0F, var24 * (var19 * var23 + (1.0F - var23)));
				if (this.bv) {
					this.d(this.motionX * 0.800000011920929D, this.motionY * 0.800000011920929D, this.motionZ * 0.800000011920929D);
				} else {
					this.d(this.motionX, this.motionY, this.motionZ);
				}

				Vec3D var25 = (new Vec3D(this.motionX, this.motionY, this.motionZ)).a();
				float var26 = ((float) var25.b(var18) + 1.0F) / 2.0F;
				var26 = 0.8F + 0.15F * var26;
				this.motionX *= (double) var26;
				this.motionZ *= (double) var26;
				this.motionY *= 0.9100000262260437D;
			}

			this.aG = this.yaw;
			this.bl.J = this.bl.K = 3.0F;
			this.bn.J = this.bn.K = 2.0F;
			this.bo.J = this.bo.K = 2.0F;
			this.bp.J = this.bp.K = 2.0F;
			this.bm.K = 3.0F;
			this.bm.J = 5.0F;
			this.bq.K = 2.0F;
			this.bq.J = 4.0F;
			this.br.K = 3.0F;
			this.br.J = 4.0F;
			var2 = (float) (this.b(5, 1.0F)[1] - this.b(10, 1.0F)[1]) * 10.0F / 180.0F * 3.1415927F;
			var3 = DataTypesConverter.b(var2);
			float var29 = -DataTypesConverter.a(var2);
			float var5 = this.yaw * 3.1415927F / 180.0F;
			float var30 = DataTypesConverter.a(var5);
			float var7 = DataTypesConverter.b(var5);
			this.bm.s_();
			this.bm.b(this.locationX + (double) (var30 * 0.5F), this.locationY, this.locationZ - (double) (var7 * 0.5F), 0.0F, 0.0F);
			this.bq.s_();
			this.bq.b(this.locationX + (double) (var7 * 4.5F), this.locationY + 2.0D, this.locationZ + (double) (var30 * 4.5F), 0.0F, 0.0F);
			this.br.s_();
			this.br.b(this.locationX - (double) (var7 * 4.5F), this.locationY + 2.0D, this.locationZ - (double) (var30 * 4.5F), 0.0F, 0.0F);
			if (!this.o.D && this.as == 0) {
				this.a(this.o.b((Entity) this, this.bq.aQ().b(4.0D, 2.0D, 4.0D).c(0.0D, -2.0D, 0.0D)));
				this.a(this.o.b((Entity) this, this.br.aQ().b(4.0D, 2.0D, 4.0D).c(0.0D, -2.0D, 0.0D)));
				this.b(this.o.b((Entity) this, this.bl.aQ().b(1.0D, 1.0D, 1.0D)));
			}

			double[] var31 = this.b(5, 1.0F);
			double[] var9 = this.b(0, 1.0F);
			var33 = DataTypesConverter.a(this.yaw * 3.1415927F / 180.0F - this.aZ * 0.01F);
			float var35 = DataTypesConverter.b(this.yaw * 3.1415927F / 180.0F - this.aZ * 0.01F);
			this.bl.s_();
			this.bl.b(this.locationX + (double) (var33 * 5.5F * var3), this.locationY + (var9[1] - var31[1]) * 1.0D + (double) (var29 * 5.5F), this.locationZ - (double) (var35 * 5.5F * var3), 0.0F, 0.0F);

			for (int var32 = 0; var32 < 3; ++var32) {
				acz var34 = null;
				if (var32 == 0) {
					var34 = this.bn;
				}

				if (var32 == 1) {
					var34 = this.bo;
				}

				if (var32 == 2) {
					var34 = this.bp;
				}

				double[] var36 = this.b(12 + var32 * 2, 1.0F);
				float var37 = this.yaw * 3.1415927F / 180.0F + this.b(var36[0] - var31[0]) * 3.1415927F / 180.0F * 1.0F;
				float var38 = DataTypesConverter.a(var37);
				float var39 = DataTypesConverter.b(var37);
				float var40 = 1.5F;
				float var41 = (float) (var32 + 1) * 2.0F;
				var34.s_();
				var34.b(this.locationX - (double) ((var30 * var40 + var38 * var41) * var3), this.locationY + (var36[1] - var31[1]) * 1.0D - (double) ((var41 + var40) * var29) + 1.5D, this.locationZ + (double) ((var7 * var40 + var39 * var41) * var3), 0.0F, 0.0F);
			}

			if (!this.o.D) {
				this.bv = this.b(this.bl.aQ()) | this.b(this.bm.aQ());
			}

		}
	}

	private void n() {
		if (this.bx != null) {
			if (this.bx.I) {
				if (!this.o.D) {
					this.a(this.bl, wh.a((aqo) null), 10.0F);
				}

				this.bx = null;
			} else if (this.W % 10 == 0 && this.bm() < this.bt()) {
				this.h(this.bm() + 1.0F);
			}
		}

		if (this.V.nextInt(10) == 0) {
			float var1 = 32.0F;
			List var2 = this.o.a(EntityEnderCrystal.class, this.aQ().b((double) var1, (double) var1, (double) var1));
			EntityEnderCrystal var3 = null;
			double var4 = Double.MAX_VALUE;
			Iterator var6 = var2.iterator();

			while (var6.hasNext()) {
				EntityEnderCrystal var7 = (EntityEnderCrystal) var6.next();
				double var8 = var7.h(this);
				if (var8 < var4) {
					var4 = var8;
					var3 = var7;
				}
			}

			this.bx = var3;
		}

	}

	private void a(List var1) {
		double var2 = (this.bm.aQ().a + this.bm.aQ().d) / 2.0D;
		double var4 = (this.bm.aQ().c + this.bm.aQ().f) / 2.0D;
		Iterator var6 = var1.iterator();

		while (var6.hasNext()) {
			Entity var7 = (Entity) var6.next();
			if (var7 instanceof EntityLiving) {
				double var8 = var7.locationX - var2;
				double var10 = var7.locationZ - var4;
				double var12 = var8 * var8 + var10 * var10;
				var7.g(var8 / var12 * 4.0D, 0.20000000298023224D, var10 / var12 * 4.0D);
			}
		}

	}

	private void b(List var1) {
		for (int var2 = 0; var2 < var1.size(); ++var2) {
			Entity var3 = (Entity) var1.get(var2);
			if (var3 instanceof EntityLiving) {
				var3.a(wh.a((EntityLiving) this), 10.0F);
				this.a(this, var3);
			}
		}

	}

	private void cd() {
		this.bu = false;
		ArrayList var1 = Lists.newArrayList((Iterable) this.o.j);
		Iterator var2 = var1.iterator();

		while (var2.hasNext()) {
			if (((EntityHuman) var2.next()).v()) {
				var2.remove();
			}
		}

		if (this.V.nextInt(2) == 0 && !var1.isEmpty()) {
			this.by = (Entity) var1.get(this.V.nextInt(var1.size()));
		} else {
			boolean var3;
			do {
				this.a = 0.0D;
				this.b = (double) (70.0F + this.V.nextFloat() * 50.0F);
				this.c = 0.0D;
				this.a += (double) (this.V.nextFloat() * 120.0F - 60.0F);
				this.c += (double) (this.V.nextFloat() * 120.0F - 60.0F);
				double var4 = this.locationX - this.a;
				double var6 = this.locationY - this.b;
				double var8 = this.locationZ - this.c;
				var3 = var4 * var4 + var6 * var6 + var8 * var8 > 100.0D;
			} while (!var3);

			this.by = null;
		}

	}

	private float b(double var1) {
		return (float) DataTypesConverter.g(var1);
	}

	private boolean b(brt var1) {
		int var2 = DataTypesConverter.toFixedPointInt(var1.a);
		int var3 = DataTypesConverter.toFixedPointInt(var1.b);
		int var4 = DataTypesConverter.toFixedPointInt(var1.c);
		int var5 = DataTypesConverter.toFixedPointInt(var1.d);
		int var6 = DataTypesConverter.toFixedPointInt(var1.e);
		int var7 = DataTypesConverter.toFixedPointInt(var1.f);
		boolean var8 = false;
		boolean var9 = false;

		for (int var10 = var2; var10 <= var5; ++var10) {
			for (int var11 = var3; var11 <= var6; ++var11) {
				for (int var12 = var4; var12 <= var7; ++var12) {
					Block var13 = this.o.p(new Position(var10, var11, var12)).getBlock();
					if (var13.r() != Material.AIR) {
						if (var13 != aty.cv && var13 != aty.Z && var13 != aty.bH && var13 != aty.h && var13 != aty.bX && this.o.Q().b("mobGriefing")) {
							var9 = this.o.g(new Position(var10, var11, var12)) || var9;
						} else {
							var8 = true;
						}
					}
				}
			}
		}

		if (var9) {
			double var16 = var1.a + (var1.d - var1.a) * (double) this.V.nextFloat();
			double var17 = var1.b + (var1.e - var1.b) * (double) this.V.nextFloat();
			double var14 = var1.c + (var1.f - var1.c) * (double) this.V.nextFloat();
			this.o.a(Particle.b, var16, var17, var14, 0.0D, 0.0D, 0.0D, new int[0]);
		}

		return var8;
	}

	public boolean a(acz var1, wh var2, float var3) {
		if (var1 != this.bl) {
			var3 = var3 / 4.0F + 1.0F;
		}

		float var4 = this.yaw * 3.1415927F / 180.0F;
		float var5 = DataTypesConverter.a(var4);
		float var6 = DataTypesConverter.b(var4);
		this.a = this.locationX + (double) (var5 * 5.0F) + (double) ((this.V.nextFloat() - 0.5F) * 2.0F);
		this.b = this.locationY + (double) (this.V.nextFloat() * 3.0F) + 1.0D;
		this.c = this.locationZ - (double) (var6 * 5.0F) + (double) ((this.V.nextFloat() - 0.5F) * 2.0F);
		this.by = null;
		if (var2.j() instanceof EntityHuman || var2.c()) {
			this.e(var2, var3);
		}

		return true;
	}

	public boolean a(wh var1, float var2) {
		if (var1 instanceof wi && ((wi) var1).w()) {
			this.e(var1, var2);
		}

		return false;
	}

	protected boolean e(wh var1, float var2) {
		return super.a(var1, var2);
	}

	public void G() {
		this.J();
	}

	protected void aY() {
		++this.bw;
		if (this.bw >= 180 && this.bw <= 200) {
			float var1 = (this.V.nextFloat() - 0.5F) * 8.0F;
			float var2 = (this.V.nextFloat() - 0.5F) * 4.0F;
			float var3 = (this.V.nextFloat() - 0.5F) * 8.0F;
			this.o.a(Particle.c, this.locationX + (double) var1, this.locationY + 2.0D + (double) var2, this.locationZ + (double) var3, 0.0D, 0.0D, 0.0D, new int[0]);
		}

		int var4;
		int var5;
		if (!this.o.D) {
			if (this.bw > 150 && this.bw % 5 == 0 && this.o.Q().b("doMobLoot")) {
				var4 = 1000;

				while (var4 > 0) {
					var5 = EntityExpirienceOrb.a(var4);
					var4 -= var5;
					this.o.d((Entity) (new EntityExpirienceOrb(this.o, this.locationX, this.locationY, this.locationZ, var5)));
				}
			}

			if (this.bw == 1) {
				this.o.a(1018, new Position(this), 0);
			}
		}

		this.d(0.0D, 0.10000000149011612D, 0.0D);
		this.aG = this.yaw += 20.0F;
		if (this.bw == 200 && !this.o.D) {
			var4 = 2000;

			while (var4 > 0) {
				var5 = EntityExpirienceOrb.a(var4);
				var4 -= var5;
				this.o.d((Entity) (new EntityExpirienceOrb(this.o, this.locationX, this.locationY, this.locationZ, var5)));
			}

			this.a(new Position(this.locationX, 64.0D, this.locationZ));
			this.J();
		}

	}

	private void a(Position var1) {
		boolean var2 = true;
		double var3 = 12.25D;
		double var5 = 6.25D;

		for (int var7 = -1; var7 <= 32; ++var7) {
			for (int var8 = -4; var8 <= 4; ++var8) {
				for (int var9 = -4; var9 <= 4; ++var9) {
					double var10 = (double) (var8 * var8 + var9 * var9);
					if (var10 <= 12.25D) {
						Position var12 = var1.a(var8, var7, var9);
						if (var7 < 0) {
							if (var10 <= 6.25D) {
								this.o.a(var12, aty.h.P());
							}
						} else if (var7 > 0) {
							this.o.a(var12, aty.a.P());
						} else if (var10 > 6.25D) {
							this.o.a(var12, aty.h.P());
						} else {
							this.o.a(var12, aty.bF.P());
						}
					}
				}
			}
		}

		this.o.a(var1, aty.h.P());
		this.o.a(var1.a(), aty.h.P());
		Position var13 = var1.b(2);
		this.o.a(var13, aty.h.P());
		this.o.a(var13.e(), aty.aa.P().a(BlockTorch.a, PaintingDirection.f));
		this.o.a(var13.f(), aty.aa.P().a(BlockTorch.a, PaintingDirection.e));
		this.o.a(var13.c(), aty.aa.P().a(BlockTorch.a, PaintingDirection.d));
		this.o.a(var13.d(), aty.aa.P().a(BlockTorch.a, PaintingDirection.c));
		this.o.a(var1.b(3), aty.h.P());
		this.o.a(var1.b(4), aty.bI.P());
	}

	protected void D() {
	}

	public Entity[] aC() {
		return this.bk;
	}

	public boolean ad() {
		return false;
	}

	public World a() {
		return this.o;
	}

	protected String z() {
		return "mob.enderdragon.growl";
	}

	protected String bn() {
		return "mob.enderdragon.hit";
	}

	protected float bA() {
		return 5.0F;
	}
}
