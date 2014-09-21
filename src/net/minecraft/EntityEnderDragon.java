package net.minecraft;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EntityEnderDragon extends EntityInsentient implements acy, IMonster {

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
		this.fireProof = true;
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
		if (this.getHealth() <= 0.0F) {
			var2 = 0.0F;
		}

		var2 = 1.0F - var2;
		int var3 = this.bj - var1 * 1 & 63;
		int var4 = this.bj - var1 * 1 - 1 & 63;
		double[] var5 = new double[3];
		double var6 = this.bi[var3][0];
		double var8 = MathHelper.g(this.bi[var4][0] - var6);
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
		if (this.world.isStatic) {
			var1 = MathHelper.b(this.bt * 3.1415927F * 2.0F);
			var2 = MathHelper.b(this.bs * 3.1415927F * 2.0F);
			if (var2 <= -0.3F && var1 >= -0.3F && !this.isSilent()) {
				this.world.a(this.locationX, this.locationY, this.locationZ, "mob.enderdragon.wings", 5.0F, 0.8F + this.random.nextFloat() * 0.3F, false);
			}
		}

		this.bs = this.bt;
		float var3;
		if (this.getHealth() <= 0.0F) {
			var1 = (this.random.nextFloat() - 0.5F) * 8.0F;
			var2 = (this.random.nextFloat() - 0.5F) * 4.0F;
			var3 = (this.random.nextFloat() - 0.5F) * 8.0F;
			this.world.addParticle(Particle.b, this.locationX + (double) var1, this.locationY + 2.0D + (double) var2, this.locationZ + (double) var3, 0.0D, 0.0D, 0.0D, new int[0]);
		} else {
			this.n();
			var1 = 0.2F / (MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ) * 10.0F + 1.0F);
			var1 *= (float) Math.pow(2.0D, this.motionY);
			if (this.bv) {
				this.bt += var1 * 0.5F;
			} else {
				this.bt += var1;
			}

			this.yaw = MathHelper.g(this.yaw);
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
			if (this.world.isStatic) {
				if (this.ba > 0) {
					var28 = this.locationX + (this.bb - this.locationX) / (double) this.ba;
					var4 = this.locationY + (this.bc - this.locationY) / (double) this.ba;
					var6 = this.locationZ + (this.bd - this.locationZ) / (double) this.ba;
					var8 = MathHelper.g(this.be - (double) this.yaw);
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

					this.b = this.by.getBoundingBox().minY + var16;
				} else {
					this.a += this.random.nextGaussian() * 2.0D;
					this.c += this.random.nextGaussian() * 2.0D;
				}

				if (this.bu || var8 < 100.0D || var8 > 22500.0D || this.positionChanged || this.E) {
					this.cd();
				}

				var4 /= (double) MathHelper.sqrt(var28 * var28 + var6 * var6);
				var33 = 0.6F;
				var4 = MathHelper.a(var4, (double) (-var33), (double) var33);
				this.motionY += var4 * 0.10000000149011612D;
				this.yaw = MathHelper.g(this.yaw);
				double var11 = 180.0D - Math.atan2(var28, var6) * 180.0D / 3.1415927410125732D;
				double var13 = MathHelper.g(var11 - (double) this.yaw);
				if (var13 > 50.0D) {
					var13 = 50.0D;
				}

				if (var13 < -50.0D) {
					var13 = -50.0D;
				}

				Vec3D var15 = (new Vec3D(this.a - this.locationX, this.b - this.locationY, this.c - this.locationZ)).a();
				var16 = (double) (-MathHelper.b(this.yaw * 3.1415927F / 180.0F));
				Vec3D var18 = (new Vec3D((double) MathHelper.a(this.yaw * 3.1415927F / 180.0F), this.motionY, var16)).a();
				float var19 = ((float) var18.b(var15) + 0.5F) / 1.5F;
				if (var19 < 0.0F) {
					var19 = 0.0F;
				}

				this.aZ *= 0.8F;
				float var20 = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ) * 1.0F + 1.0F;
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
					this.move(this.motionX * 0.800000011920929D, this.motionY * 0.800000011920929D, this.motionZ * 0.800000011920929D);
				} else {
					this.move(this.motionX, this.motionY, this.motionZ);
				}

				Vec3D var25 = (new Vec3D(this.motionX, this.motionY, this.motionZ)).a();
				float var26 = ((float) var25.b(var18) + 1.0F) / 2.0F;
				var26 = 0.8F + 0.15F * var26;
				this.motionX *= (double) var26;
				this.motionZ *= (double) var26;
				this.motionY *= 0.9100000262260437D;
			}

			this.aG = this.yaw;
			this.bl.height = this.bl.width = 3.0F;
			this.bn.height = this.bn.width = 2.0F;
			this.bo.height = this.bo.width = 2.0F;
			this.bp.height = this.bp.width = 2.0F;
			this.bm.width = 3.0F;
			this.bm.height = 5.0F;
			this.bq.width = 2.0F;
			this.bq.height = 4.0F;
			this.br.width = 3.0F;
			this.br.height = 4.0F;
			var2 = (float) (this.b(5, 1.0F)[1] - this.b(10, 1.0F)[1]) * 10.0F / 180.0F * 3.1415927F;
			var3 = MathHelper.b(var2);
			float var29 = -MathHelper.a(var2);
			float var5 = this.yaw * 3.1415927F / 180.0F;
			float var30 = MathHelper.a(var5);
			float var7 = MathHelper.b(var5);
			this.bm.s_();
			this.bm.setPositionRotation(this.locationX + (double) (var30 * 0.5F), this.locationY, this.locationZ - (double) (var7 * 0.5F), 0.0F, 0.0F);
			this.bq.s_();
			this.bq.setPositionRotation(this.locationX + (double) (var7 * 4.5F), this.locationY + 2.0D, this.locationZ + (double) (var30 * 4.5F), 0.0F, 0.0F);
			this.br.s_();
			this.br.setPositionRotation(this.locationX - (double) (var7 * 4.5F), this.locationY + 2.0D, this.locationZ - (double) (var30 * 4.5F), 0.0F, 0.0F);
			if (!this.world.isStatic && this.as == 0) {
				this.a(this.world.getEntities((Entity) this, this.bq.getBoundingBox().grow(4.0D, 2.0D, 4.0D).c(0.0D, -2.0D, 0.0D)));
				this.a(this.world.getEntities((Entity) this, this.br.getBoundingBox().grow(4.0D, 2.0D, 4.0D).c(0.0D, -2.0D, 0.0D)));
				this.b(this.world.getEntities((Entity) this, this.bl.getBoundingBox().grow(1.0D, 1.0D, 1.0D)));
			}

			double[] var31 = this.b(5, 1.0F);
			double[] var9 = this.b(0, 1.0F);
			var33 = MathHelper.a(this.yaw * 3.1415927F / 180.0F - this.aZ * 0.01F);
			float var35 = MathHelper.b(this.yaw * 3.1415927F / 180.0F - this.aZ * 0.01F);
			this.bl.s_();
			this.bl.setPositionRotation(this.locationX + (double) (var33 * 5.5F * var3), this.locationY + (var9[1] - var31[1]) * 1.0D + (double) (var29 * 5.5F), this.locationZ - (double) (var35 * 5.5F * var3), 0.0F, 0.0F);

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
				float var38 = MathHelper.a(var37);
				float var39 = MathHelper.b(var37);
				float var40 = 1.5F;
				float var41 = (float) (var32 + 1) * 2.0F;
				var34.s_();
				var34.setPositionRotation(this.locationX - (double) ((var30 * var40 + var38 * var41) * var3), this.locationY + (var36[1] - var31[1]) * 1.0D - (double) ((var41 + var40) * var29) + 1.5D, this.locationZ + (double) ((var7 * var40 + var39 * var41) * var3), 0.0F, 0.0F);
			}

			if (!this.world.isStatic) {
				this.bv = this.b(this.bl.getBoundingBox()) | this.b(this.bm.getBoundingBox());
			}

		}
	}

	private void n() {
		if (this.bx != null) {
			if (this.bx.dead) {
				if (!this.world.isStatic) {
					this.a(this.bl, DamageSource.explosion((Explosion) null), 10.0F);
				}

				this.bx = null;
			} else if (this.ticksLived % 10 == 0 && this.getHealth() < this.bt()) {
				this.h(this.getHealth() + 1.0F);
			}
		}

		if (this.random.nextInt(10) == 0) {
			float var1 = 32.0F;
			List var2 = this.world.getEntititesInAABB(EntityEnderCrystal.class, this.getBoundingBox().grow((double) var1, (double) var1, (double) var1));
			EntityEnderCrystal var3 = null;
			double var4 = Double.MAX_VALUE;
			Iterator var6 = var2.iterator();

			while (var6.hasNext()) {
				EntityEnderCrystal var7 = (EntityEnderCrystal) var6.next();
				double var8 = var7.getDistanceSquared(this);
				if (var8 < var4) {
					var4 = var8;
					var3 = var7;
				}
			}

			this.bx = var3;
		}

	}

	private void a(List var1) {
		double var2 = (this.bm.getBoundingBox().minX + this.bm.getBoundingBox().maxX) / 2.0D;
		double var4 = (this.bm.getBoundingBox().minZ + this.bm.getBoundingBox().maxZ) / 2.0D;
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
				var3.damageEntity(DamageSource.mobAttack((EntityLiving) this), 10.0F);
				this.a(this, var3);
			}
		}

	}

	private void cd() {
		this.bu = false;
		ArrayList var1 = Lists.newArrayList((Iterable) this.world.j);
		Iterator var2 = var1.iterator();

		while (var2.hasNext()) {
			if (((EntityHuman) var2.next()).isSpectator()) {
				var2.remove();
			}
		}

		if (this.random.nextInt(2) == 0 && !var1.isEmpty()) {
			this.by = (Entity) var1.get(this.random.nextInt(var1.size()));
		} else {
			boolean var3;
			do {
				this.a = 0.0D;
				this.b = (double) (70.0F + this.random.nextFloat() * 50.0F);
				this.c = 0.0D;
				this.a += (double) (this.random.nextFloat() * 120.0F - 60.0F);
				this.c += (double) (this.random.nextFloat() * 120.0F - 60.0F);
				double var4 = this.locationX - this.a;
				double var6 = this.locationY - this.b;
				double var8 = this.locationZ - this.c;
				var3 = var4 * var4 + var6 * var6 + var8 * var8 > 100.0D;
			} while (!var3);

			this.by = null;
		}

	}

	private float b(double var1) {
		return (float) MathHelper.g(var1);
	}

	private boolean b(AxisAlignedBB var1) {
		int var2 = MathHelper.toFixedPointInt(var1.minX);
		int var3 = MathHelper.toFixedPointInt(var1.minY);
		int var4 = MathHelper.toFixedPointInt(var1.minZ);
		int var5 = MathHelper.toFixedPointInt(var1.maxX);
		int var6 = MathHelper.toFixedPointInt(var1.maxY);
		int var7 = MathHelper.toFixedPointInt(var1.maxZ);
		boolean var8 = false;
		boolean var9 = false;

		for (int var10 = var2; var10 <= var5; ++var10) {
			for (int var11 = var3; var11 <= var6; ++var11) {
				for (int var12 = var4; var12 <= var7; ++var12) {
					Block var13 = this.world.getBlockState(new Position(var10, var11, var12)).getBlock();
					if (var13.getMaterial() != Material.AIR) {
						if (var13 != Blocks.BARRIER && var13 != Blocks.OBSIDIAN && var13 != Blocks.END_STONE && var13 != Blocks.BEDROCK && var13 != Blocks.COMMAND_BLOCK && this.world.getGameRules().isGameRule("mobGriefing")) {
							var9 = this.world.g(new Position(var10, var11, var12)) || var9;
						} else {
							var8 = true;
						}
					}
				}
			}
		}

		if (var9) {
			double var16 = var1.minX + (var1.maxX - var1.minX) * (double) this.random.nextFloat();
			double var17 = var1.minY + (var1.maxY - var1.minY) * (double) this.random.nextFloat();
			double var14 = var1.minZ + (var1.maxZ - var1.minZ) * (double) this.random.nextFloat();
			this.world.addParticle(Particle.b, var16, var17, var14, 0.0D, 0.0D, 0.0D, new int[0]);
		}

		return var8;
	}

	public boolean a(acz var1, DamageSource var2, float var3) {
		if (var1 != this.bl) {
			var3 = var3 / 4.0F + 1.0F;
		}

		float var4 = this.yaw * 3.1415927F / 180.0F;
		float var5 = MathHelper.a(var4);
		float var6 = MathHelper.b(var4);
		this.a = this.locationX + (double) (var5 * 5.0F) + (double) ((this.random.nextFloat() - 0.5F) * 2.0F);
		this.b = this.locationY + (double) (this.random.nextFloat() * 3.0F) + 1.0D;
		this.c = this.locationZ - (double) (var6 * 5.0F) + (double) ((this.random.nextFloat() - 0.5F) * 2.0F);
		this.by = null;
		if (var2.j() instanceof EntityHuman || var2.c()) {
			this.e(var2, var3);
		}

		return true;
	}

	public boolean damageEntity(DamageSource var1, float var2) {
		if (var1 instanceof EntityDamageSource && ((EntityDamageSource) var1).w()) {
			this.e(var1, var2);
		}

		return false;
	}

	protected boolean e(DamageSource var1, float var2) {
		return super.damageEntity(var1, var2);
	}

	public void setDead() {
		this.die();
	}

	protected void aY() {
		++this.bw;
		if (this.bw >= 180 && this.bw <= 200) {
			float var1 = (this.random.nextFloat() - 0.5F) * 8.0F;
			float var2 = (this.random.nextFloat() - 0.5F) * 4.0F;
			float var3 = (this.random.nextFloat() - 0.5F) * 8.0F;
			this.world.addParticle(Particle.c, this.locationX + (double) var1, this.locationY + 2.0D + (double) var2, this.locationZ + (double) var3, 0.0D, 0.0D, 0.0D, new int[0]);
		}

		int var4;
		int var5;
		if (!this.world.isStatic) {
			if (this.bw > 150 && this.bw % 5 == 0 && this.world.getGameRules().isGameRule("doMobLoot")) {
				var4 = 1000;

				while (var4 > 0) {
					var5 = EntityExpirienceOrb.a(var4);
					var4 -= var5;
					this.world.addEntity((Entity) (new EntityExpirienceOrb(this.world, this.locationX, this.locationY, this.locationZ, var5)));
				}
			}

			if (this.bw == 1) {
				this.world.a(1018, new Position(this), 0);
			}
		}

		this.move(0.0D, 0.10000000149011612D, 0.0D);
		this.aG = this.yaw += 20.0F;
		if (this.bw == 200 && !this.world.isStatic) {
			var4 = 2000;

			while (var4 > 0) {
				var5 = EntityExpirienceOrb.a(var4);
				var4 -= var5;
				this.world.addEntity((Entity) (new EntityExpirienceOrb(this.world, this.locationX, this.locationY, this.locationZ, var5)));
			}

			this.a(new Position(this.locationX, 64.0D, this.locationZ));
			this.die();
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
								this.world.a(var12, Blocks.BEDROCK.getBlockState());
							}
						} else if (var7 > 0) {
							this.world.a(var12, Blocks.AIR.getBlockState());
						} else if (var10 > 6.25D) {
							this.world.a(var12, Blocks.BEDROCK.getBlockState());
						} else {
							this.world.a(var12, Blocks.END_PORTAL.getBlockState());
						}
					}
				}
			}
		}

		this.world.a(var1, Blocks.BEDROCK.getBlockState());
		this.world.a(var1.getUp(), Blocks.BEDROCK.getBlockState());
		Position var13 = var1.getUp(2);
		this.world.a(var13, Blocks.BEDROCK.getBlockState());
		this.world.a(var13.getWest(), Blocks.TORCH.getBlockState().a(BlockTorch.a, BlockFace.EAST));
		this.world.a(var13.getEast(), Blocks.TORCH.getBlockState().a(BlockTorch.a, BlockFace.WEST));
		this.world.a(var13.getNorth(), Blocks.TORCH.getBlockState().a(BlockTorch.a, BlockFace.SOUTH));
		this.world.a(var13.getSouth(), Blocks.TORCH.getBlockState().a(BlockTorch.a, BlockFace.NORTH));
		this.world.a(var1.getUp(3), Blocks.BEDROCK.getBlockState());
		this.world.a(var1.getUp(4), Blocks.DRAGON_EGG.getBlockState());
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
		return this.world;
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
