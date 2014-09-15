package net.minecraft;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import net.minecraft.server.MinecraftServer;

public abstract class Entity implements CommandSenderInterface {

	private static final AxisAlignedBB a = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
	private static int b;

	private int entityId;
	public double j;
	public boolean k;
	public Entity passenger;
	public Entity vehicle;
	public boolean n;
	public World world;
	public double previousX;
	public double previousY;
	public double previousZ;
	public double locationX;
	public double locationY;
	public double locationZ;
	public double motionX;
	public double motionY;
	public double motionZ;
	public float yaw;
	public float pitch;
	public float lastYaw;
	public float lastPitch;
	private AxisAlignedBB boundingBox;
	public boolean onGround;
	public boolean positionChanged;
	public boolean E;
	public boolean F;
	public boolean velocityChanged;
	protected boolean H;
	private boolean g;
	public boolean dead;
	public float height;
	public float width;
	public float length;
	public float M;
	public float N;
	public float fallDistance;
	public int ttt;
	public double P;
	public double Q;
	public double R;
	public float S;
	public boolean T;
	public float U;
	protected Random random;
	public int ticksLived;
	public int maxFireTicks;
	public int fireTicks;
	protected boolean inWater;
	public int noDamageTicks;
	protected boolean justCreated;
	protected boolean fireProof;
	protected DataWatcher dataWatcher;
	private double ap;
	private double aq;
	public boolean ad;
	public int ae;
	public int af;
	public int ag;
	public boolean ah;
	public boolean ai;
	public int portalCooldown;
	protected boolean ak;
	protected int al;
	public int dimensionId;
	protected int an;
	private boolean invulnerable;
	protected UUID uuid;
	private final CommandBlockStatistic commandBlockStat;
	public boolean valid;

	public int getId() {
		return this.entityId;
	}

	public void setId(int entityId) {
		this.entityId = entityId;
	}

	public void setDead() {
		this.die();
	}

	public Entity(World var1) {
		this.entityId = b++;
		this.j = 1.0D;
		this.boundingBox = a;
		this.height = 0.6F;
		this.width = 1.8F;
		this.ttt = 1;
		this.random = new Random();
		this.maxFireTicks = 1;
		this.justCreated = true;
		this.uuid = MathHelper.a(this.random);
		this.commandBlockStat = new CommandBlockStatistic();
		this.world = var1;
		this.b(0.0D, 0.0D, 0.0D);
		if (var1 != null) {
			this.dimensionId = var1.worldProvider.getDimensionId();
		}

		this.dataWatcher = new DataWatcher(this);
		this.dataWatcher.a(0, Byte.valueOf((byte) 0));
		this.dataWatcher.a(1, Short.valueOf((short) 300));
		this.dataWatcher.a(3, Byte.valueOf((byte) 0));
		this.dataWatcher.a(2, "");
		this.dataWatcher.a(4, Byte.valueOf((byte) 0));
		this.h();
	}

	protected abstract void h();

	public DataWatcher getDataWatcher() {
		return this.dataWatcher;
	}

	public boolean equals(Object var1) {
		return var1 instanceof Entity ? ((Entity) var1).entityId == this.entityId : false;
	}

	public int hashCode() {
		return this.entityId;
	}

	public void die() {
		this.dead = true;
	}

	protected void a(float var1, float var2) {
		if (var1 != this.height || var2 != this.width) {
			float var3 = this.height;
			this.height = var1;
			this.width = var2;
			this.setBoundingBox(new AxisAlignedBB(this.getBoundingBox().minX, this.getBoundingBox().minY, this.getBoundingBox().minZ, this.getBoundingBox().minX + (double) this.height, this.getBoundingBox().minY + (double) this.width, this.getBoundingBox().minZ + (double) this.height));
			if (this.height > var3 && !this.justCreated && !this.world.isStatic) {
				this.move((double) (var3 - this.height), 0.0D, (double) (var3 - this.height));
			}
		}

	}

	protected void b(float var1, float var2) {
		this.yaw = var1 % 360.0F;
		this.pitch = var2 % 360.0F;
	}

	public void b(double var1, double var3, double var5) {
		this.locationX = var1;
		this.locationY = var3;
		this.locationZ = var5;
		float var7 = this.height / 2.0F;
		float var8 = this.width;
		this.setBoundingBox(new AxisAlignedBB(var1 - (double) var7, var3, var5 - (double) var7, var1 + (double) var7, var3 + (double) var8, var5 + (double) var7));
	}

	public void s_() {
		this.K();
	}

	public void K() {
		this.world.B.a("entityBaseTick");
		if (this.vehicle != null && this.vehicle.dead) {
			this.vehicle = null;
		}

		this.length = this.M;
		this.previousX = this.locationX;
		this.previousY = this.locationY;
		this.previousZ = this.locationZ;
		this.lastPitch = this.pitch;
		this.lastYaw = this.yaw;
		if (!this.world.isStatic && this.world instanceof WorldServer) {
			this.world.B.a("portal");
			MinecraftServer var1 = ((WorldServer) this.world).r();
			int var2 = this.L();
			if (this.ak) {
				if (var1.isNetherAllowed()) {
					if (this.vehicle == null && this.al++ >= var2) {
						this.al = var2;
						this.portalCooldown = this.ar();
						byte var3;
						if (this.world.worldProvider.getDimensionId() == -1) {
							var3 = 0;
						} else {
							var3 = -1;
						}

						this.c(var3);
					}

					this.ak = false;
				}
			} else {
				if (this.al > 0) {
					this.al -= 4;
				}

				if (this.al < 0) {
					this.al = 0;
				}
			}

			if (this.portalCooldown > 0) {
				--this.portalCooldown;
			}

			this.world.B.b();
		}

		this.Y();
		this.W();
		if (this.world.isStatic) {
			this.fireTicks = 0;
		} else if (this.fireTicks > 0) {
			if (this.fireProof) {
				this.fireTicks -= 4;
				if (this.fireTicks < 0) {
					this.fireTicks = 0;
				}
			} else {
				if (this.fireTicks % 20 == 0) {
					this.damageEntity(DamageSource.BURN, 1.0F);
				}

				--this.fireTicks;
			}
		}

		if (this.ab()) {
			this.M();
			this.fallDistance *= 0.5F;
		}

		if (this.locationY < -64.0D) {
			this.O();
		}

		if (!this.world.isStatic) {
			this.b(0, this.fireTicks > 0);
		}

		this.justCreated = false;
		this.world.B.b();
	}

	public int L() {
		return 0;
	}

	protected void M() {
		if (!this.fireProof) {
			this.damageEntity(DamageSource.LAVA, 4.0F);
			this.e(15);
		}
	}

	public void e(int var1) {
		int var2 = var1 * 20;
		var2 = EnchantmentProtection.a(this, var2);
		if (this.fireTicks < var2) {
			this.fireTicks = var2;
		}

	}

	public void N() {
		this.fireTicks = 0;
	}

	protected void O() {
		this.die();
	}

	public boolean c(double var1, double var3, double var5) {
		AxisAlignedBB var7 = this.getBoundingBox().c(var1, var3, var5);
		return this.b(var7);
	}

	private boolean b(AxisAlignedBB var1) {
		return this.world.getCubes(this, var1).isEmpty() && !this.world.d(var1);
	}

	public void move(double var1, double var3, double var5) {
		if (this.T) {
			this.setBoundingBox(this.getBoundingBox().c(var1, var3, var5));
			this.m();
		} else {
			this.world.B.a("move");
			double var7 = this.locationX;
			double var9 = this.locationY;
			double var11 = this.locationZ;
			if (this.H) {
				this.H = false;
				var1 *= 0.25D;
				var3 *= 0.05000000074505806D;
				var5 *= 0.25D;
				this.motionX = 0.0D;
				this.motionY = 0.0D;
				this.motionZ = 0.0D;
			}

			double var13 = var1;
			double var15 = var3;
			double var17 = var5;
			boolean var19 = this.onGround && this.aw() && this instanceof EntityHuman;
			if (var19) {
				double var20;
				for (var20 = 0.05D; var1 != 0.0D && this.world.getCubes(this, this.getBoundingBox().c(var1, -1.0D, 0.0D)).isEmpty(); var13 = var1) {
					if (var1 < var20 && var1 >= -var20) {
						var1 = 0.0D;
					} else if (var1 > 0.0D) {
						var1 -= var20;
					} else {
						var1 += var20;
					}
				}

				for (; var5 != 0.0D && this.world.getCubes(this, this.getBoundingBox().c(0.0D, -1.0D, var5)).isEmpty(); var17 = var5) {
					if (var5 < var20 && var5 >= -var20) {
						var5 = 0.0D;
					} else if (var5 > 0.0D) {
						var5 -= var20;
					} else {
						var5 += var20;
					}
				}

				for (; var1 != 0.0D && var5 != 0.0D && this.world.getCubes(this, this.getBoundingBox().c(var1, -1.0D, var5)).isEmpty(); var17 = var5) {
					if (var1 < var20 && var1 >= -var20) {
						var1 = 0.0D;
					} else if (var1 > 0.0D) {
						var1 -= var20;
					} else {
						var1 += var20;
					}

					var13 = var1;
					if (var5 < var20 && var5 >= -var20) {
						var5 = 0.0D;
					} else if (var5 > 0.0D) {
						var5 -= var20;
					} else {
						var5 += var20;
					}
				}
			}

			List var53 = this.world.getCubes(this, this.getBoundingBox().a(var1, var3, var5));
			AxisAlignedBB var21 = this.getBoundingBox();

			AxisAlignedBB var23;
			for (Iterator var22 = var53.iterator(); var22.hasNext(); var3 = var23.b(this.getBoundingBox(), var3)) {
				var23 = (AxisAlignedBB) var22.next();
			}

			this.setBoundingBox(this.getBoundingBox().c(0.0D, var3, 0.0D));
			boolean var54 = this.onGround || var15 != var3 && var15 < 0.0D;

			AxisAlignedBB var24;
			Iterator var55;
			for (var55 = var53.iterator(); var55.hasNext(); var1 = var24.a(this.getBoundingBox(), var1)) {
				var24 = (AxisAlignedBB) var55.next();
			}

			this.setBoundingBox(this.getBoundingBox().c(var1, 0.0D, 0.0D));

			for (var55 = var53.iterator(); var55.hasNext(); var5 = var24.c(this.getBoundingBox(), var5)) {
				var24 = (AxisAlignedBB) var55.next();
			}

			this.setBoundingBox(this.getBoundingBox().c(0.0D, 0.0D, var5));
			if (this.S > 0.0F && var54 && (var13 != var1 || var17 != var5)) {
				double var56 = var1;
				double var25 = var3;
				double var27 = var5;
				AxisAlignedBB var29 = this.getBoundingBox();
				this.setBoundingBox(var21);
				var3 = (double) this.S;
				List var30 = this.world.getCubes(this, this.getBoundingBox().a(var13, var3, var17));
				AxisAlignedBB var31 = this.getBoundingBox();
				AxisAlignedBB var32 = var31.a(var13, 0.0D, var17);
				double var33 = var3;

				AxisAlignedBB var36;
				for (Iterator var35 = var30.iterator(); var35.hasNext(); var33 = var36.b(var32, var33)) {
					var36 = (AxisAlignedBB) var35.next();
				}

				var31 = var31.c(0.0D, var33, 0.0D);
				double var67 = var13;

				AxisAlignedBB var38;
				for (Iterator var37 = var30.iterator(); var37.hasNext(); var67 = var38.a(var31, var67)) {
					var38 = (AxisAlignedBB) var37.next();
				}

				var31 = var31.c(var67, 0.0D, 0.0D);
				double var68 = var17;

				AxisAlignedBB var40;
				for (Iterator var39 = var30.iterator(); var39.hasNext(); var68 = var40.c(var31, var68)) {
					var40 = (AxisAlignedBB) var39.next();
				}

				var31 = var31.c(0.0D, 0.0D, var68);
				AxisAlignedBB var69 = this.getBoundingBox();
				double var70 = var3;

				AxisAlignedBB var43;
				for (Iterator var42 = var30.iterator(); var42.hasNext(); var70 = var43.b(var69, var70)) {
					var43 = (AxisAlignedBB) var42.next();
				}

				var69 = var69.c(0.0D, var70, 0.0D);
				double var71 = var13;

				AxisAlignedBB var45;
				for (Iterator var44 = var30.iterator(); var44.hasNext(); var71 = var45.a(var69, var71)) {
					var45 = (AxisAlignedBB) var44.next();
				}

				var69 = var69.c(var71, 0.0D, 0.0D);
				double var72 = var17;

				AxisAlignedBB var47;
				for (Iterator var46 = var30.iterator(); var46.hasNext(); var72 = var47.c(var69, var72)) {
					var47 = (AxisAlignedBB) var46.next();
				}

				var69 = var69.c(0.0D, 0.0D, var72);
				double var73 = var67 * var67 + var68 * var68;
				double var48 = var71 * var71 + var72 * var72;
				if (var73 > var48) {
					var1 = var67;
					var5 = var68;
					this.setBoundingBox(var31);
				} else {
					var1 = var71;
					var5 = var72;
					this.setBoundingBox(var69);
				}

				var3 = (double) (-this.S);

				AxisAlignedBB var51;
				for (Iterator var50 = var30.iterator(); var50.hasNext(); var3 = var51.b(this.getBoundingBox(), var3)) {
					var51 = (AxisAlignedBB) var50.next();
				}

				this.setBoundingBox(this.getBoundingBox().c(0.0D, var3, 0.0D));
				if (var56 * var56 + var27 * var27 >= var1 * var1 + var5 * var5) {
					var1 = var56;
					var3 = var25;
					var5 = var27;
					this.setBoundingBox(var29);
				}
			}

			this.world.B.b();
			this.world.B.a("rest");
			this.m();
			this.positionChanged = var13 != var1 || var17 != var5;
			this.E = var15 != var3;
			this.onGround = this.E && var15 < 0.0D;
			this.F = this.positionChanged || this.E;
			int var57 = MathHelper.toFixedPointInt(this.locationX);
			int var58 = MathHelper.toFixedPointInt(this.locationY - 0.20000000298023224D);
			int var59 = MathHelper.toFixedPointInt(this.locationZ);
			Position var26 = new Position(var57, var58, var59);
			Block var60 = this.world.getBlockState(var26).getBlock();
			if (var60.getMaterial() == Material.AIR) {
				Block var28 = this.world.getBlockState(var26.b()).getBlock();
				if (var28 instanceof BlockFence || var28 instanceof BlockCobbleWall || var28 instanceof BlockFenceGate) {
					var60 = var28;
					var26 = var26.b();
				}
			}

			this.a(var3, this.onGround, var60, var26);
			if (var13 != var1) {
				this.motionX = 0.0D;
			}

			if (var17 != var5) {
				this.motionZ = 0.0D;
			}

			if (var15 != var3) {
				var60.a(this.world, this);
			}

			if (this.r_() && !var19 && this.vehicle == null) {
				double var61 = this.locationX - var7;
				double var64 = this.locationY - var9;
				double var66 = this.locationZ - var11;
				if (var60 != Blocks.LADDER) {
					var64 = 0.0D;
				}

				if (var60 != null && this.onGround) {
					var60.a(this.world, var26, this);
				}

				this.M = (float) ((double) this.M + (double) MathHelper.sqrt(var61 * var61 + var66 * var66) * 0.6D);
				this.N = (float) ((double) this.N + (double) MathHelper.sqrt(var61 * var61 + var64 * var64 + var66 * var66) * 0.6D);
				if (this.N > (float) this.ttt && var60.getMaterial() != Material.AIR) {
					this.ttt = (int) this.N + 1;
					if (this.V()) {
						float var34 = MathHelper.sqrt(this.motionX * this.motionX * 0.20000000298023224D + this.motionY * this.motionY + this.motionZ * this.motionZ * 0.20000000298023224D) * 0.35F;
						if (var34 > 1.0F) {
							var34 = 1.0F;
						}

						this.a(this.P(), var34, 1.0F + (this.random.nextFloat() - this.random.nextFloat()) * 0.4F);
					}

					this.a(var26, var60);
				}
			}

			try {
				this.Q();
			} catch (Throwable var52) {
				CrashReport var63 = CrashReport.generateCrashReport(var52, "Checking entity block collision");
				CrashReportSystemDetails var65 = var63.generateSystemDetails("Entity being checked for collision");
				this.a(var65);
				throw new ReportedException(var63);
			}

			boolean var62 = this.U();
			if (this.world.e(this.getBoundingBox().shrink(0.001D, 0.001D, 0.001D))) {
				this.f(1);
				if (!var62) {
					++this.fireTicks;
					if (this.fireTicks == 0) {
						this.e(8);
					}
				}
			} else if (this.fireTicks <= 0) {
				this.fireTicks = -this.maxFireTicks;
			}

			if (var62 && this.fireTicks > 0) {
				this.a("random.fizz", 0.7F, 1.6F + (this.random.nextFloat() - this.random.nextFloat()) * 0.4F);
				this.fireTicks = -this.maxFireTicks;
			}

			this.world.B.b();
		}
	}

	private void m() {
		this.locationX = (this.getBoundingBox().minX + this.getBoundingBox().maxX) / 2.0D;
		this.locationY = this.getBoundingBox().minY;
		this.locationZ = (this.getBoundingBox().minZ + this.getBoundingBox().maxZ) / 2.0D;
	}

	protected String P() {
		return "game.neutral.swim";
	}

	protected void Q() {
		Position var1 = new Position(this.getBoundingBox().minX + 0.001D, this.getBoundingBox().minY + 0.001D, this.getBoundingBox().minZ + 0.001D);
		Position var2 = new Position(this.getBoundingBox().maxX - 0.001D, this.getBoundingBox().maxY - 0.001D, this.getBoundingBox().maxZ - 0.001D);
		if (this.world.a(var1, var2)) {
			for (int var3 = var1.getX(); var3 <= var2.getX(); ++var3) {
				for (int var4 = var1.getY(); var4 <= var2.getY(); ++var4) {
					for (int var5 = var1.getZ(); var5 <= var2.getZ(); ++var5) {
						Position var6 = new Position(var3, var4, var5);
						IBlockState var7 = this.world.getBlockState(var6);

						try {
							var7.getBlock().a(this.world, var6, var7, this);
						} catch (Throwable var11) {
							CrashReport var9 = CrashReport.generateCrashReport(var11, "Colliding entity with block");
							CrashReportSystemDetails var10 = var9.generateSystemDetails("Block being collided with");
							net.minecraft.CrashReportSystemDetails.a(var10, var6, var7);
							throw new ReportedException(var9);
						}
					}
				}
			}
		}

	}

	protected void a(Position var1, Block var2) {
		BlockSound var3 = var2.H;
		if (this.world.getBlockState(var1.a()).getBlock() == Blocks.SNOW_LAYER) {
			var3 = Blocks.SNOW_LAYER.H;
			this.a(var3.c(), var3.d() * 0.15F, var3.e());
		} else if (!var2.getMaterial().isLiquid()) {
			this.a(var3.c(), var3.d() * 0.15F, var3.e());
		}

	}

	public void a(String var1, float var2, float var3) {
		if (!this.isSilent()) {
			this.world.a(this, var1, var2, var3);
		}

	}

	public boolean isSilent() {
		return this.dataWatcher.a(4) == 1;
	}

	public void b(boolean var1) {
		this.dataWatcher.b(4, Byte.valueOf((byte) (var1 ? 1 : 0)));
	}

	protected boolean r_() {
		return true;
	}

	protected void a(double var1, boolean var3, Block var4, Position var5) {
		if (var3) {
			if (this.fallDistance > 0.0F) {
				if (var4 != null) {
					var4.a(this.world, var5, this, this.fallDistance);
				} else {
					this.e(this.fallDistance, 1.0F);
				}

				this.fallDistance = 0.0F;
			}
		} else if (var1 < 0.0D) {
			this.fallDistance = (float) ((double) this.fallDistance - var1);
		}

	}

	public AxisAlignedBB S() {
		return null;
	}

	protected void f(int var1) {
		if (!this.fireProof) {
			this.damageEntity(DamageSource.FIRE, (float) var1);
		}

	}

	public final boolean T() {
		return this.fireProof;
	}

	public void e(float var1, float var2) {
		if (this.passenger != null) {
			this.passenger.e(var1, var2);
		}

	}

	public boolean U() {
		return this.inWater || this.world.C(new Position(this.locationX, this.locationY, this.locationZ)) || this.world.C(new Position(this.locationX, this.locationY + (double) this.width, this.locationZ));
	}

	public boolean V() {
		return this.inWater;
	}

	public boolean W() {
		if (this.world.a(this.getBoundingBox().grow(0.0D, -0.4000000059604645D, 0.0D).shrink(0.001D, 0.001D, 0.001D), Material.WATER, this)) {
			if (!this.inWater && !this.justCreated) {
				this.X();
			}

			this.fallDistance = 0.0F;
			this.inWater = true;
			this.fireTicks = 0;
		} else {
			this.inWater = false;
		}

		return this.inWater;
	}

	protected void X() {
		float var1 = MathHelper.sqrt(this.motionX * this.motionX * 0.20000000298023224D + this.motionY * this.motionY + this.motionZ * this.motionZ * 0.20000000298023224D) * 0.2F;
		if (var1 > 1.0F) {
			var1 = 1.0F;
		}

		this.a(this.aa(), var1, 1.0F + (this.random.nextFloat() - this.random.nextFloat()) * 0.4F);
		float var2 = (float) MathHelper.toFixedPointInt(this.getBoundingBox().minY);

		int var3;
		float var4;
		float var5;
		for (var3 = 0; (float) var3 < 1.0F + this.height * 20.0F; ++var3) {
			var4 = (this.random.nextFloat() * 2.0F - 1.0F) * this.height;
			var5 = (this.random.nextFloat() * 2.0F - 1.0F) * this.height;
			this.world.a(Particle.e, this.locationX + (double) var4, (double) (var2 + 1.0F), this.locationZ + (double) var5, this.motionX, this.motionY - (double) (this.random.nextFloat() * 0.2F), this.motionZ, new int[0]);
		}

		for (var3 = 0; (float) var3 < 1.0F + this.height * 20.0F; ++var3) {
			var4 = (this.random.nextFloat() * 2.0F - 1.0F) * this.height;
			var5 = (this.random.nextFloat() * 2.0F - 1.0F) * this.height;
			this.world.a(Particle.f, this.locationX + (double) var4, (double) (var2 + 1.0F), this.locationZ + (double) var5, this.motionX, this.motionY, this.motionZ, new int[0]);
		}

	}

	public void Y() {
		if (this.ax() && !this.V()) {
			this.Z();
		}

	}

	protected void Z() {
		int var1 = MathHelper.toFixedPointInt(this.locationX);
		int var2 = MathHelper.toFixedPointInt(this.locationY - 0.20000000298023224D);
		int var3 = MathHelper.toFixedPointInt(this.locationZ);
		Position var4 = new Position(var1, var2, var3);
		IBlockState var5 = this.world.getBlockState(var4);
		Block var6 = var5.getBlock();
		if (var6.b() != -1) {
			this.world.a(Particle.L, this.locationX + ((double) this.random.nextFloat() - 0.5D) * (double) this.height, this.getBoundingBox().minY + 0.1D, this.locationZ + ((double) this.random.nextFloat() - 0.5D) * (double) this.height, -this.motionX * 4.0D, 1.5D, -this.motionZ * 4.0D, new int[] { Block.getStateId(var5) });
		}

	}

	protected String aa() {
		return "game.neutral.swim.splash";
	}

	public boolean a(Material var1) {
		double var2 = this.locationY + (double) this.getHeadHeight();
		Position var4 = new Position(this.locationX, var2, this.locationZ);
		IBlockState var5 = this.world.getBlockState(var4);
		Block var6 = var5.getBlock();
		if (var6.getMaterial() == var1) {
			float var7 = axl.b(var5.getBlock().getData(var5)) - 0.11111111F;
			float var8 = (float) (var4.getY() + 1) - var7;
			boolean var9 = var2 < (double) var8;
			return !var9 && this instanceof EntityHuman ? false : var9;
		} else {
			return false;
		}
	}

	public boolean ab() {
		return this.world.a(this.getBoundingBox().grow(-0.10000000149011612D, -0.4000000059604645D, -0.10000000149011612D), Material.LAVA);
	}

	public void a(float var1, float var2, float var3) {
		float var4 = var1 * var1 + var2 * var2;
		if (var4 >= 1.0E-4F) {
			var4 = MathHelper.c(var4);
			if (var4 < 1.0F) {
				var4 = 1.0F;
			}

			var4 = var3 / var4;
			var1 *= var4;
			var2 *= var4;
			float var5 = MathHelper.a(this.yaw * 3.1415927F / 180.0F);
			float var6 = MathHelper.b(this.yaw * 3.1415927F / 180.0F);
			this.motionX += (double) (var1 * var6 - var2 * var5);
			this.motionZ += (double) (var2 * var6 + var1 * var5);
		}
	}

	public float c(float var1) {
		Position var2 = new Position(this.locationX, 0.0D, this.locationZ);
		if (this.world.isLoaded(var2)) {
			double var3 = (this.getBoundingBox().maxY - this.getBoundingBox().minY) * 0.66D;
			int var5 = MathHelper.toFixedPointInt(this.locationY + var3);
			return this.world.o(var2.b(var5));
		} else {
			return 0.0F;
		}
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public void setLocation(double var1, double var3, double var5, float var7, float var8) {
		this.previousX = this.locationX = var1;
		this.previousY = this.locationY = var3;
		this.previousZ = this.locationZ = var5;
		this.lastYaw = this.yaw = var7;
		this.lastPitch = this.pitch = var8;
		double var9 = (double) (this.lastYaw - var7);
		if (var9 < -180.0D) {
			this.lastYaw += 360.0F;
		}

		if (var9 >= 180.0D) {
			this.lastYaw -= 360.0F;
		}

		this.b(this.locationX, this.locationY, this.locationZ);
		this.b(var7, var8);
	}

	public void a(Position var1, float var2, float var3) {
		this.setPositionRotation((double) var1.getX() + 0.5D, (double) var1.getY(), (double) var1.getZ() + 0.5D, var2, var3);
	}

	public void setPositionRotation(double var1, double var3, double var5, float var7, float var8) {
		this.P = this.previousX = this.locationX = var1;
		this.Q = this.previousY = this.locationY = var3;
		this.R = this.previousZ = this.locationZ = var5;
		this.yaw = var7;
		this.pitch = var8;
		this.b(this.locationX, this.locationY, this.locationZ);
	}

	public float g(Entity var1) {
		float var2 = (float) (this.locationX - var1.locationX);
		float var3 = (float) (this.locationY - var1.locationY);
		float var4 = (float) (this.locationZ - var1.locationZ);
		return MathHelper.c(var2 * var2 + var3 * var3 + var4 * var4);
	}

	public double getDistanceSquared(double var1, double var3, double var5) {
		double var7 = this.locationX - var1;
		double var9 = this.locationY - var3;
		double var11 = this.locationZ - var5;
		return var7 * var7 + var9 * var9 + var11 * var11;
	}

	public double b(Position var1) {
		return var1.c(this.locationX, this.locationY, this.locationZ);
	}

	public double c(Position var1) {
		return var1.d(this.locationX, this.locationY, this.locationZ);
	}

	public double f(double var1, double var3, double var5) {
		double var7 = this.locationX - var1;
		double var9 = this.locationY - var3;
		double var11 = this.locationZ - var5;
		return (double) MathHelper.sqrt(var7 * var7 + var9 * var9 + var11 * var11);
	}

	public double getDistanceSquared(Entity var1) {
		double var2 = this.locationX - var1.locationX;
		double var4 = this.locationY - var1.locationY;
		double var6 = this.locationZ - var1.locationZ;
		return var2 * var2 + var4 * var4 + var6 * var6;
	}

	public void d(EntityHuman var1) {
	}

	public void i(Entity var1) {
		if (var1.passenger != this && var1.vehicle != this) {
			if (!var1.T && !this.T) {
				double var2 = var1.locationX - this.locationX;
				double var4 = var1.locationZ - this.locationZ;
				double var6 = MathHelper.a(var2, var4);
				if (var6 >= 0.009999999776482582D) {
					var6 = (double) MathHelper.sqrt(var6);
					var2 /= var6;
					var4 /= var6;
					double var8 = 1.0D / var6;
					if (var8 > 1.0D) {
						var8 = 1.0D;
					}

					var2 *= var8;
					var4 *= var8;
					var2 *= 0.05000000074505806D;
					var4 *= 0.05000000074505806D;
					var2 *= (double) (1.0F - this.U);
					var4 *= (double) (1.0F - this.U);
					if (this.passenger == null) {
						this.g(-var2, 0.0D, -var4);
					}

					if (var1.passenger == null) {
						var1.g(var2, 0.0D, var4);
					}
				}

			}
		}
	}

	public void g(double var1, double var3, double var5) {
		this.motionX += var1;
		this.motionY += var3;
		this.motionZ += var5;
		this.ai = true;
	}

	protected void ac() {
		this.velocityChanged = true;
	}

	public boolean damageEntity(DamageSource var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else {
			this.ac();
			return false;
		}
	}

	public Vec3D d(float var1) {
		if (var1 == 1.0F) {
			return this.f(this.pitch, this.yaw);
		} else {
			float var2 = this.lastPitch + (this.pitch - this.lastPitch) * var1;
			float var3 = this.lastYaw + (this.yaw - this.lastYaw) * var1;
			return this.f(var2, var3);
		}
	}

	protected final Vec3D f(float var1, float var2) {
		float var3 = MathHelper.b(-var2 * 0.017453292F - 3.1415927F);
		float var4 = MathHelper.a(-var2 * 0.017453292F - 3.1415927F);
		float var5 = -MathHelper.b(-var1 * 0.017453292F);
		float var6 = MathHelper.a(-var1 * 0.017453292F);
		return new Vec3D((double) (var4 * var5), (double) var6, (double) (var3 * var5));
	}

	public boolean ad() {
		return false;
	}

	public boolean ae() {
		return false;
	}

	public void b(Entity var1, int var2) {
	}

	public boolean c(NBTCompoundTag var1) {
		String var2 = this.ag();
		if (!this.dead && var2 != null) {
			var1.put("id", var2);
			this.write(var1);
			return true;
		} else {
			return false;
		}
	}

	public boolean writeIfNoPassenger(NBTCompoundTag var1) {
		String var2 = this.ag();
		if (!this.dead && var2 != null && this.passenger == null) {
			var1.put("id", var2);
			this.write(var1);
			return true;
		} else {
			return false;
		}
	}

	public void write(NBTCompoundTag tag) {
		try {
			tag.put("Pos", this.createDoubleListTag(new double[] { this.locationX, this.locationY, this.locationZ }));
			tag.put("Motion", this.createDoubleListTag(new double[] { this.motionX, this.motionY, this.motionZ }));
			tag.put("Rotation", this.createFloatListTag(new float[] { this.yaw, this.pitch }));
			tag.put("FallDistance", this.fallDistance);
			tag.put("Fire", (short) this.fireTicks);
			tag.put("Air", (short) this.getAirTicks());
			tag.put("OnGround", this.onGround);
			tag.put("Dimension", this.dimensionId);
			tag.put("Invulnerable", this.invulnerable);
			tag.put("PortalCooldown", this.portalCooldown);
			tag.put("UUIDMost", this.getUUID().getMostSignificantBits());
			tag.put("UUIDLeast", this.getUUID().getLeastSignificantBits());
			if (this.getCustomName() != null && this.getCustomName().length() > 0) {
				tag.put("CustomName", this.getCustomName());
				tag.put("CustomNameVisible", this.isCustomNameVisible());
			}

			this.commandBlockStat.write(tag);
			if (this.isSilent()) {
				tag.put("Silent", this.isSilent());
			}

			this.b(tag);
			if (this.vehicle != null) {
				NBTCompoundTag var2 = new NBTCompoundTag();
				if (this.vehicle.c(var2)) {
					tag.put("Riding", (NBTTag) var2);
				}
			}

		} catch (Throwable var5) {
			CrashReport var3 = CrashReport.generateCrashReport(var5, "Saving entity NBT");
			CrashReportSystemDetails var4 = var3.generateSystemDetails("Entity being saved");
			this.a(var4);
			throw new ReportedException(var3);
		}
	}

	public void load(NBTCompoundTag var1) {
		try {
			NBTListTag var2 = var1.getList("Pos", 6);
			NBTListTag var6 = var1.getList("Motion", 6);
			NBTListTag var7 = var1.getList("Rotation", 5);
			this.motionX = var6.getDouble(0);
			this.motionY = var6.getDouble(1);
			this.motionZ = var6.getDouble(2);
			if (Math.abs(this.motionX) > 10.0D) {
				this.motionX = 0.0D;
			}

			if (Math.abs(this.motionY) > 10.0D) {
				this.motionY = 0.0D;
			}

			if (Math.abs(this.motionZ) > 10.0D) {
				this.motionZ = 0.0D;
			}

			this.previousX = this.P = this.locationX = var2.getDouble(0);
			this.previousY = this.Q = this.locationY = var2.getDouble(1);
			this.previousZ = this.R = this.locationZ = var2.getDouble(2);
			this.lastYaw = this.yaw = var7.getFloat(0);
			this.lastPitch = this.pitch = var7.getFloat(1);
			this.fallDistance = var1.getFloat("FallDistance");
			this.fireTicks = var1.getShort("Fire");
			this.h(var1.getShort("Air"));
			this.onGround = var1.getBoolean("OnGround");
			this.dimensionId = var1.getInt("Dimension");
			this.invulnerable = var1.getBoolean("Invulnerable");
			this.portalCooldown = var1.getInt("PortalCooldown");
			if (var1.isTagAssignableFrom("UUIDMost", 4) && var1.isTagAssignableFrom("UUIDLeast", 4)) {
				this.uuid = new UUID(var1.getLong("UUIDMost"), var1.getLong("UUIDLeast"));
			} else if (var1.isTagAssignableFrom("UUID", 8)) {
				this.uuid = UUID.fromString(var1.getString("UUID"));
			}

			this.b(this.locationX, this.locationY, this.locationZ);
			this.b(this.yaw, this.pitch);
			if (var1.isTagAssignableFrom("CustomName", 8) && var1.getString("CustomName").length() > 0) {
				this.a(var1.getString("CustomName"));
			}

			this.g(var1.getBoolean("CustomNameVisible"));
			this.commandBlockStat.read(var1);
			this.b(var1.getBoolean("Silent"));
			this.a(var1);
			if (this.af()) {
				this.b(this.locationX, this.locationY, this.locationZ);
			}

		} catch (Throwable var5) {
			CrashReport var3 = CrashReport.generateCrashReport(var5, "Loading entity NBT");
			CrashReportSystemDetails var4 = var3.generateSystemDetails("Entity being loaded");
			this.a(var4);
			throw new ReportedException(var3);
		}
	}

	protected boolean af() {
		return true;
	}

	protected final String ag() {
		return EntityTypes.getNameByClass(this);
	}

	protected abstract void a(NBTCompoundTag var1);

	protected abstract void b(NBTCompoundTag var1);

	public void ah() {
	}

	protected NBTListTag createDoubleListTag(double... var1) {
		NBTListTag var2 = new NBTListTag();
		double[] var3 = var1;
		int var4 = var1.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			double var6 = var3[var5];
			var2.addTag((NBTTag) (new NBTDoubleTag(var6)));
		}

		return var2;
	}

	protected NBTListTag createFloatListTag(float... var1) {
		NBTListTag var2 = new NBTListTag();
		float[] var3 = var1;
		int var4 = var1.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			float var6 = var3[var5];
			var2.addTag((NBTTag) (new NBTFloatTag(var6)));
		}

		return var2;
	}

	public EntityItem a(Item var1, int var2) {
		return this.a(var1, var2, 0.0F);
	}

	public EntityItem a(Item var1, int var2, float var3) {
		return this.a(new ItemStack(var1, var2, 0), var3);
	}

	public EntityItem a(ItemStack var1, float var2) {
		if (var1.amount != 0 && var1.getItem() != null) {
			EntityItem var3 = new EntityItem(this.world, this.locationX, this.locationY + (double) var2, this.locationZ, var1);
			var3.p();
			this.world.addEntity((Entity) var3);
			return var3;
		} else {
			return null;
		}
	}

	public boolean isAlive() {
		return !this.dead;
	}

	public boolean aj() {
		if (this.T) {
			return false;
		} else {
			for (int var1 = 0; var1 < 8; ++var1) {
				double var2 = this.locationX + (double) (((float) ((var1 >> 0) % 2) - 0.5F) * this.height * 0.8F);
				double var4 = this.locationY + (double) (((float) ((var1 >> 1) % 2) - 0.5F) * 0.1F);
				double var6 = this.locationZ + (double) (((float) ((var1 >> 2) % 2) - 0.5F) * this.height * 0.8F);
				if (this.world.getBlockState(new Position(var2, var4 + (double) this.getHeadHeight(), var6)).getBlock().u()) {
					return true;
				}
			}

			return false;
		}
	}

	public boolean e(EntityHuman var1) {
		return false;
	}

	public AxisAlignedBB j(Entity var1) {
		return null;
	}

	public void ak() {
		if (this.vehicle.dead) {
			this.vehicle = null;
		} else {
			this.motionX = 0.0D;
			this.motionY = 0.0D;
			this.motionZ = 0.0D;
			this.s_();
			if (this.vehicle != null) {
				this.vehicle.al();
				this.aq += (double) (this.vehicle.yaw - this.vehicle.lastYaw);

				for (this.ap += (double) (this.vehicle.pitch - this.vehicle.lastPitch); this.aq >= 180.0D; this.aq -= 360.0D) {
					;
				}

				while (this.aq < -180.0D) {
					this.aq += 360.0D;
				}

				while (this.ap >= 180.0D) {
					this.ap -= 360.0D;
				}

				while (this.ap < -180.0D) {
					this.ap += 360.0D;
				}

				double var1 = this.aq * 0.5D;
				double var3 = this.ap * 0.5D;
				float var5 = 10.0F;
				if (var1 > (double) var5) {
					var1 = (double) var5;
				}

				if (var1 < (double) (-var5)) {
					var1 = (double) (-var5);
				}

				if (var3 > (double) var5) {
					var3 = (double) var5;
				}

				if (var3 < (double) (-var5)) {
					var3 = (double) (-var5);
				}

				this.aq -= var1;
				this.ap -= var3;
			}
		}
	}

	public void al() {
		if (this.passenger != null) {
			this.passenger.b(this.locationX, this.locationY + this.an() + this.passenger.am(), this.locationZ);
		}
	}

	public double am() {
		return 0.0D;
	}

	public double an() {
		return (double) this.width * 0.75D;
	}

	public void mount(Entity vehicleEntity) {
		this.ap = 0.0D;
		this.aq = 0.0D;
		if (vehicleEntity == null) {
			if (this.vehicle != null) {
				this.setPositionRotation(this.vehicle.locationX, this.vehicle.getBoundingBox().minY + (double) this.vehicle.width, this.vehicle.locationZ, this.yaw, this.pitch);
				this.vehicle.passenger = null;
			}

			this.vehicle = null;
		} else {
			if (this.vehicle != null) {
				this.vehicle.passenger = null;
			}

			if (vehicleEntity != null) {
				for (Entity var2 = vehicleEntity.vehicle; var2 != null; var2 = var2.vehicle) {
					if (var2 == this) {
						return;
					}
				}
			}

			this.vehicle = vehicleEntity;
			vehicleEntity.passenger = this;
		}
	}

	public float ao() {
		return 0.1F;
	}

	public Vec3D ap() {
		return null;
	}

	public void aq() {
		if (this.portalCooldown > 0) {
			this.portalCooldown = this.ar();
		} else {
			double var1 = this.previousX - this.locationX;
			double var3 = this.previousZ - this.locationZ;
			if (!this.world.isStatic && !this.ak) {
				int var5;
				if (MathHelper.e((float) var1) > MathHelper.e((float) var3)) {
					var5 = var1 > 0.0D ? BlockFace.WEST.toDirection() : BlockFace.EAST.toDirection();
				} else {
					var5 = var3 > 0.0D ? BlockFace.NORTH.toDirection() : BlockFace.SOUTH.toDirection();
				}

				this.an = var5;
			}

			this.ak = true;
		}
	}

	public int ar() {
		return 300;
	}

	public ItemStack[] getArmorContents() {
		return null;
	}

	public void setArmor(int var1, ItemStack var2) {
	}

	public boolean au() {
		boolean var1 = this.world != null && this.world.isStatic;
		return !this.fireProof && (this.fireTicks > 0 || var1 && this.g(0));
	}

	public boolean av() {
		return this.vehicle != null;
	}

	public boolean aw() {
		return this.g(1);
	}

	public void setSneaking(boolean var1) {
		this.b(1, var1);
	}

	public boolean ax() {
		return this.g(3);
	}

	public void setSprinting(boolean var1) {
		this.b(3, var1);
	}

	public boolean ay() {
		return this.g(5);
	}

	public void e(boolean var1) {
		this.b(5, var1);
	}

	public void f(boolean var1) {
		this.b(4, var1);
	}

	protected boolean g(int var1) {
		return (this.dataWatcher.a(0) & 1 << var1) != 0;
	}

	protected void b(int var1, boolean var2) {
		byte var3 = this.dataWatcher.a(0);
		if (var2) {
			this.dataWatcher.b(0, Byte.valueOf((byte) (var3 | 1 << var1)));
		} else {
			this.dataWatcher.b(0, Byte.valueOf((byte) (var3 & ~(1 << var1))));
		}

	}

	public int getAirTicks() {
		return this.dataWatcher.b(1);
	}

	public void h(int var1) {
		this.dataWatcher.b(1, Short.valueOf((short) var1));
	}

	public void a(EntityLightning var1) {
		this.damageEntity(DamageSource.LIGHTNING, 5.0F);
		++this.fireTicks;
		if (this.fireTicks == 0) {
			this.e(8);
		}

	}

	public void a(EntityLiving var1) {
	}

	protected boolean j(double var1, double var3, double var5) {
		Position var7 = new Position(var1, var3, var5);
		double var8 = var1 - (double) var7.getX();
		double var10 = var3 - (double) var7.getY();
		double var12 = var5 - (double) var7.getZ();
		List var14 = this.world.a(this.getBoundingBox());
		if (var14.isEmpty() && !this.world.u(var7)) {
			return false;
		} else {
			byte var15 = 3;
			double var16 = 9999.0D;
			if (!this.world.u(var7.e()) && var8 < var16) {
				var16 = var8;
				var15 = 0;
			}

			if (!this.world.u(var7.f()) && 1.0D - var8 < var16) {
				var16 = 1.0D - var8;
				var15 = 1;
			}

			if (!this.world.u(var7.a()) && 1.0D - var10 < var16) {
				var16 = 1.0D - var10;
				var15 = 3;
			}

			if (!this.world.u(var7.c()) && var12 < var16) {
				var16 = var12;
				var15 = 4;
			}

			if (!this.world.u(var7.d()) && 1.0D - var12 < var16) {
				var16 = 1.0D - var12;
				var15 = 5;
			}

			float var18 = this.random.nextFloat() * 0.2F + 0.1F;
			if (var15 == 0) {
				this.motionX = (double) (-var18);
			}

			if (var15 == 1) {
				this.motionX = (double) var18;
			}

			if (var15 == 3) {
				this.motionY = (double) var18;
			}

			if (var15 == 4) {
				this.motionZ = (double) (-var18);
			}

			if (var15 == 5) {
				this.motionZ = (double) var18;
			}

			return true;
		}
	}

	public void aB() {
		this.H = true;
		this.fallDistance = 0.0F;
	}

	public String getName() {
		if (this.k_()) {
			return this.getCustomName();
		} else {
			String var1 = EntityTypes.getNameByClass(this);
			if (var1 == null) {
				var1 = "generic";
			}

			return LocaleI18n.get("entity." + var1 + ".name");
		}
	}

	public Entity[] aC() {
		return null;
	}

	public boolean k(Entity var1) {
		return this == var1;
	}

	public float aD() {
		return 0.0F;
	}

	public void f(float var1) {
	}

	public boolean aE() {
		return true;
	}

	public boolean l(Entity var1) {
		return false;
	}

	public String toString() {
		return String.format("%s[\'%s\'/%d, l=\'%s\', x=%.2f, y=%.2f, z=%.2f]", new Object[] { this.getClass().getSimpleName(), this.getName(), Integer.valueOf(this.entityId), this.world == null ? "~NULL~" : this.world.getWorldData().getLevelName(), Double.valueOf(this.locationX), Double.valueOf(this.locationY), Double.valueOf(this.locationZ) });
	}

	public boolean b(DamageSource var1) {
		return this.invulnerable && var1 != DamageSource.OUT_OF_WORLD && !var1.u();
	}

	public void m(Entity var1) {
		this.setPositionRotation(var1.locationX, var1.locationY, var1.locationZ, var1.yaw, var1.pitch);
	}

	public void n(Entity var1) {
		NBTCompoundTag var2 = new NBTCompoundTag();
		var1.write(var2);
		this.load(var2);
		this.portalCooldown = var1.portalCooldown;
		this.an = var1.an;
	}

	public void c(int var1) {
		if (!this.world.isStatic && !this.dead) {
			this.world.B.a("changeDimension");
			MinecraftServer var2 = MinecraftServer.getInstance();
			int var3 = this.dimensionId;
			WorldServer var4 = var2.getWorldServer(var3);
			WorldServer var5 = var2.getWorldServer(var1);
			this.dimensionId = var1;
			if (var3 == 1 && var1 == 1) {
				var5 = var2.getWorldServer(0);
				this.dimensionId = 0;
			}

			this.world.e(this);
			this.dead = false;
			this.world.B.a("reposition");
			var2.getPlayerList().a(this, var3, var4, var5);
			this.world.B.c("reloading");
			Entity var6 = EntityTypes.createEntity(EntityTypes.getNameByClass(this), (World) var5);
			if (var6 != null) {
				var6.n(this);
				if (var3 == 1 && var1 == 1) {
					Position var7 = this.world.r(var5.getSpawnPosition());
					var6.a(var7, var6.yaw, var6.pitch);
				}

				var5.addEntity(var6);
			}

			this.dead = true;
			this.world.B.b();
			var4.j();
			var5.j();
			this.world.B.b();
		}
	}

	public float a(Explosion var1, World var2, Position var3, IBlockState var4) {
		return var4.getBlock().a(this);
	}

	public boolean a(Explosion var1, World var2, Position var3, IBlockState var4, float var5) {
		return true;
	}

	public int aF() {
		return 3;
	}

	public int aG() {
		return this.an;
	}

	public boolean aH() {
		return false;
	}

	public void a(CrashReportSystemDetails var1) {
		var1.addDetails("Entity Type", EntityTypes.getNameByClass(Entity.this) + " (" + getClass().getCanonicalName() + ")");
		var1.addDetails("Entity ID", (Object) Integer.valueOf(this.entityId));
		var1.addDetails("Entity Name", this.getName());
		var1.addDetails("Entity\'s Exact location", (Object) String.format("%.2f, %.2f, %.2f", new Object[] { Double.valueOf(this.locationX), Double.valueOf(this.locationY), Double.valueOf(this.locationZ) }));
		var1.addDetails("Entity\'s Block location", (Object) net.minecraft.CrashReportSystemDetails.a((double) MathHelper.toFixedPointInt(this.locationX), (double) MathHelper.toFixedPointInt(this.locationY), (double) MathHelper.toFixedPointInt(this.locationZ)));
		var1.addDetails("Entity\'s Momentum", (Object) String.format("%.2f, %.2f, %.2f", new Object[] { Double.valueOf(this.motionX), Double.valueOf(this.motionY), Double.valueOf(this.motionZ) }));
		var1.addDetails("Entity\'s Rider", passenger.toString());
		var1.addDetails("Entity\'s Vehicle", vehicle.toString());
	}

	public UUID getUUID() {
		return this.uuid;
	}

	public boolean aK() {
		return true;
	}

	public IChatBaseComponent getComponentName() {
		ChatComponentText var1 = new ChatComponentText(this.getName());
		var1.getChatModifier().a(this.aP());
		var1.getChatModifier().a(this.getUUID().toString());
		return var1;
	}

	public void a(String var1) {
		this.dataWatcher.b(2, var1);
	}

	public String getCustomName() {
		return this.dataWatcher.e(2);
	}

	public boolean k_() {
		return this.dataWatcher.e(2).length() > 0;
	}

	public void g(boolean var1) {
		this.dataWatcher.b(3, Byte.valueOf((byte) (var1 ? 1 : 0)));
	}

	public boolean isCustomNameVisible() {
		return this.dataWatcher.a(3) == 1;
	}

	public void updatePosition(double var1, double var3, double var5) {
		this.setPositionRotation(var1, var3, var5, this.yaw, this.pitch);
	}

	public void i(int var1) {
	}

	public BlockFace aO() {
		return BlockFace.fromDirection(MathHelper.toFixedPointInt((double) (this.yaw * 4.0F / 360.0F) + 0.5D) & 3);
	}

	protected ChatHoverable aP() {
		NBTCompoundTag var1 = new NBTCompoundTag();
		String var2 = EntityTypes.getNameByClass(this);
		var1.put("id", this.getUUID().toString());
		if (var2 != null) {
			var1.put("type", var2);
		}

		var1.put("name", this.getName());
		return new ChatHoverable(EnumHoverAction.d, new ChatComponentText(var1.toString()));
	}

	public boolean a(EntityPlayer var1) {
		return true;
	}

	public AxisAlignedBB getBoundingBox() {
		return this.boundingBox;
	}

	public void setBoundingBox(AxisAlignedBB boundingBox) {
		this.boundingBox = boundingBox;
	}

	public float getHeadHeight() {
		return this.width * 0.85F;
	}

	public boolean aS() {
		return this.g;
	}

	public void h(boolean var1) {
		this.g = var1;
	}

	public boolean d(int var1, ItemStack var2) {
		return false;
	}

	public void sendChatMessage(IChatBaseComponent var1) {
	}

	public boolean canExecuteCommand(int var1, String var2) {
		return true;
	}

	public Position getEntityPosition() {
		return new Position(this.locationX, this.locationY + 0.5D, this.locationZ);
	}

	public Vec3D getCenter() {
		return new Vec3D(this.locationX, this.locationY, this.locationZ);
	}

	public World getPrimaryWorld() {
		return this.world;
	}

	public boolean t_() {
		return false;
	}

	public void a(ag var1, int var2) {
		this.commandBlockStat.a(this, var1, var2);
	}

	public CommandBlockStatistic aT() {
		return this.commandBlockStat;
	}

	public void o(Entity var1) {
		this.commandBlockStat.a(var1.aT());
	}

	public NBTCompoundTag aU() {
		return null;
	}

	public boolean interactAt(EntityHuman var1, Vec3D var2) {
		return false;
	}

	public boolean aV() {
		return false;
	}

	protected void a(EntityLiving var1, Entity var2) {
		if (var2 instanceof EntityLiving) {
			aph.a((EntityLiving) var2, (Entity) var1);
		}

		aph.b(var1, var2);
	}

	public <T> T getBukkitEntity(Class<T> returnType) {
		throw new AssertionError("Unknown entity " + getClass());
	}

}
