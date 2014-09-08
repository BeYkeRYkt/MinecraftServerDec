package net.minecraft;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;
import net.minecraft.server.MinecraftServer;

public abstract class Entity implements CommandSenderInterface {

	private static final AxisAlignedBB a = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
	private static int b;
	private int entityId;
	public double j;
	public boolean k;
	public Entity l;
	public Entity m;
	public boolean n;
	public World o;
	public double p;
	public double q;
	public double r;
	public double locationX;
	public double locationY;
	public double locationZ;
	public double motionX;
	public double motionY;
	public double motionZ;
	public float yaw;
	public float pitch;
	public float A;
	public float B;
	private AxisAlignedBB f;
	public boolean onGround;
	public boolean D;
	public boolean E;
	public boolean F;
	public boolean G;
	protected boolean H;
	private boolean g;
	public boolean I;
	public float J;
	public float K;
	public float L;
	public float M;
	public float N;
	public float O;
	private int h;
	public double P;
	public double Q;
	public double R;
	public float S;
	public boolean T;
	public float U;
	protected Random V;
	public int W;
	public int X;
	private int i;
	protected boolean Y;
	public int Z;
	protected boolean aa;
	protected boolean ab;
	protected DataWatcher dataWatcher;
	private double ap;
	private double aq;
	public boolean ad;
	public int ae;
	public int af;
	public int ag;
	public boolean ah;
	public boolean ai;
	public int aj;
	protected boolean ak;
	protected int al;
	public int dimensionId;
	protected int an;
	private boolean ar;
	protected UUID ao;
	private final af as;

	public int getId() {
		return this.entityId;
	}

	public void d(int var1) {
		this.entityId = var1;
	}

	public void G() {
		this.J();
	}

	public Entity(World var1) {
		this.entityId = b++;
		this.j = 1.0D;
		this.f = a;
		this.J = 0.6F;
		this.K = 1.8F;
		this.h = 1;
		this.V = new Random();
		this.X = 1;
		this.aa = true;
		this.ao = DataTypesConverter.a(this.V);
		this.as = new af();
		this.o = var1;
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

	public void J() {
		this.I = true;
	}

	protected void a(float var1, float var2) {
		if (var1 != this.J || var2 != this.K) {
			float var3 = this.J;
			this.J = var1;
			this.K = var2;
			this.a(new AxisAlignedBB(this.aQ().minX, this.aQ().minY, this.aQ().minZ, this.aQ().minX + (double) this.J, this.aQ().minY + (double) this.K, this.aQ().minZ + (double) this.J));
			if (this.J > var3 && !this.aa && !this.o.D) {
				this.d((double) (var3 - this.J), 0.0D, (double) (var3 - this.J));
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
		float var7 = this.J / 2.0F;
		float var8 = this.K;
		this.a(new AxisAlignedBB(var1 - (double) var7, var3, var5 - (double) var7, var1 + (double) var7, var3 + (double) var8, var5 + (double) var7));
	}

	public void s_() {
		this.K();
	}

	public void K() {
		this.o.B.a("entityBaseTick");
		if (this.m != null && this.m.I) {
			this.m = null;
		}

		this.L = this.M;
		this.p = this.locationX;
		this.q = this.locationY;
		this.r = this.locationZ;
		this.B = this.pitch;
		this.A = this.yaw;
		if (!this.o.D && this.o instanceof WorldServer) {
			this.o.B.a("portal");
			MinecraftServer var1 = ((WorldServer) this.o).r();
			int var2 = this.L();
			if (this.ak) {
				if (var1.isNetherAllowed()) {
					if (this.m == null && this.al++ >= var2) {
						this.al = var2;
						this.aj = this.ar();
						byte var3;
						if (this.o.worldProvider.getDimensionId() == -1) {
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

			if (this.aj > 0) {
				--this.aj;
			}

			this.o.B.b();
		}

		this.Y();
		this.W();
		if (this.o.D) {
			this.i = 0;
		} else if (this.i > 0) {
			if (this.ab) {
				this.i -= 4;
				if (this.i < 0) {
					this.i = 0;
				}
			} else {
				if (this.i % 20 == 0) {
					this.a(DamageSource.c, 1.0F);
				}

				--this.i;
			}
		}

		if (this.ab()) {
			this.M();
			this.O *= 0.5F;
		}

		if (this.locationY < -64.0D) {
			this.O();
		}

		if (!this.o.D) {
			this.b(0, this.i > 0);
		}

		this.aa = false;
		this.o.B.b();
	}

	public int L() {
		return 0;
	}

	protected void M() {
		if (!this.ab) {
			this.a(DamageSource.d, 4.0F);
			this.e(15);
		}
	}

	public void e(int var1) {
		int var2 = var1 * 20;
		var2 = EnchantmentProtection.a(this, var2);
		if (this.i < var2) {
			this.i = var2;
		}

	}

	public void N() {
		this.i = 0;
	}

	protected void O() {
		this.J();
	}

	public boolean c(double var1, double var3, double var5) {
		AxisAlignedBB var7 = this.aQ().c(var1, var3, var5);
		return this.b(var7);
	}

	private boolean b(AxisAlignedBB var1) {
		return this.o.a(this, var1).isEmpty() && !this.o.d(var1);
	}

	public void d(double var1, double var3, double var5) {
		if (this.T) {
			this.a(this.aQ().c(var1, var3, var5));
			this.m();
		} else {
			this.o.B.a("move");
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
				for (var20 = 0.05D; var1 != 0.0D && this.o.a(this, this.aQ().c(var1, -1.0D, 0.0D)).isEmpty(); var13 = var1) {
					if (var1 < var20 && var1 >= -var20) {
						var1 = 0.0D;
					} else if (var1 > 0.0D) {
						var1 -= var20;
					} else {
						var1 += var20;
					}
				}

				for (; var5 != 0.0D && this.o.a(this, this.aQ().c(0.0D, -1.0D, var5)).isEmpty(); var17 = var5) {
					if (var5 < var20 && var5 >= -var20) {
						var5 = 0.0D;
					} else if (var5 > 0.0D) {
						var5 -= var20;
					} else {
						var5 += var20;
					}
				}

				for (; var1 != 0.0D && var5 != 0.0D && this.o.a(this, this.aQ().c(var1, -1.0D, var5)).isEmpty(); var17 = var5) {
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

			List var53 = this.o.a(this, this.aQ().a(var1, var3, var5));
			AxisAlignedBB var21 = this.aQ();

			AxisAlignedBB var23;
			for (Iterator var22 = var53.iterator(); var22.hasNext(); var3 = var23.b(this.aQ(), var3)) {
				var23 = (AxisAlignedBB) var22.next();
			}

			this.a(this.aQ().c(0.0D, var3, 0.0D));
			boolean var54 = this.onGround || var15 != var3 && var15 < 0.0D;

			AxisAlignedBB var24;
			Iterator var55;
			for (var55 = var53.iterator(); var55.hasNext(); var1 = var24.a(this.aQ(), var1)) {
				var24 = (AxisAlignedBB) var55.next();
			}

			this.a(this.aQ().c(var1, 0.0D, 0.0D));

			for (var55 = var53.iterator(); var55.hasNext(); var5 = var24.c(this.aQ(), var5)) {
				var24 = (AxisAlignedBB) var55.next();
			}

			this.a(this.aQ().c(0.0D, 0.0D, var5));
			if (this.S > 0.0F && var54 && (var13 != var1 || var17 != var5)) {
				double var56 = var1;
				double var25 = var3;
				double var27 = var5;
				AxisAlignedBB var29 = this.aQ();
				this.a(var21);
				var3 = (double) this.S;
				List var30 = this.o.a(this, this.aQ().a(var13, var3, var17));
				AxisAlignedBB var31 = this.aQ();
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
				AxisAlignedBB var69 = this.aQ();
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
					this.a(var31);
				} else {
					var1 = var71;
					var5 = var72;
					this.a(var69);
				}

				var3 = (double) (-this.S);

				AxisAlignedBB var51;
				for (Iterator var50 = var30.iterator(); var50.hasNext(); var3 = var51.b(this.aQ(), var3)) {
					var51 = (AxisAlignedBB) var50.next();
				}

				this.a(this.aQ().c(0.0D, var3, 0.0D));
				if (var56 * var56 + var27 * var27 >= var1 * var1 + var5 * var5) {
					var1 = var56;
					var3 = var25;
					var5 = var27;
					this.a(var29);
				}
			}

			this.o.B.b();
			this.o.B.a("rest");
			this.m();
			this.D = var13 != var1 || var17 != var5;
			this.E = var15 != var3;
			this.onGround = this.E && var15 < 0.0D;
			this.F = this.D || this.E;
			int var57 = DataTypesConverter.toFixedPointInt(this.locationX);
			int var58 = DataTypesConverter.toFixedPointInt(this.locationY - 0.20000000298023224D);
			int var59 = DataTypesConverter.toFixedPointInt(this.locationZ);
			Position var26 = new Position(var57, var58, var59);
			Block var60 = this.o.p(var26).getBlock();
			if (var60.r() == Material.AIR) {
				Block var28 = this.o.p(var26.b()).getBlock();
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
				var60.a(this.o, this);
			}

			if (this.r_() && !var19 && this.m == null) {
				double var61 = this.locationX - var7;
				double var64 = this.locationY - var9;
				double var66 = this.locationZ - var11;
				if (var60 != Blocks.LADDER) {
					var64 = 0.0D;
				}

				if (var60 != null && this.onGround) {
					var60.a(this.o, var26, this);
				}

				this.M = (float) ((double) this.M + (double) DataTypesConverter.a(var61 * var61 + var66 * var66) * 0.6D);
				this.N = (float) ((double) this.N + (double) DataTypesConverter.a(var61 * var61 + var64 * var64 + var66 * var66) * 0.6D);
				if (this.N > (float) this.h && var60.r() != Material.AIR) {
					this.h = (int) this.N + 1;
					if (this.V()) {
						float var34 = DataTypesConverter.a(this.motionX * this.motionX * 0.20000000298023224D + this.motionY * this.motionY + this.motionZ * this.motionZ * 0.20000000298023224D) * 0.35F;
						if (var34 > 1.0F) {
							var34 = 1.0F;
						}

						this.a(this.P(), var34, 1.0F + (this.V.nextFloat() - this.V.nextFloat()) * 0.4F);
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
			if (this.o.e(this.aQ().d(0.001D, 0.001D, 0.001D))) {
				this.f(1);
				if (!var62) {
					++this.i;
					if (this.i == 0) {
						this.e(8);
					}
				}
			} else if (this.i <= 0) {
				this.i = -this.X;
			}

			if (var62 && this.i > 0) {
				this.a("random.fizz", 0.7F, 1.6F + (this.V.nextFloat() - this.V.nextFloat()) * 0.4F);
				this.i = -this.X;
			}

			this.o.B.b();
		}
	}

	private void m() {
		this.locationX = (this.aQ().minX + this.aQ().maxX) / 2.0D;
		this.locationY = this.aQ().minY;
		this.locationZ = (this.aQ().minZ + this.aQ().maxZ) / 2.0D;
	}

	protected String P() {
		return "game.neutral.swim";
	}

	protected void Q() {
		Position var1 = new Position(this.aQ().minX + 0.001D, this.aQ().minY + 0.001D, this.aQ().minZ + 0.001D);
		Position var2 = new Position(this.aQ().maxX - 0.001D, this.aQ().maxY - 0.001D, this.aQ().maxZ - 0.001D);
		if (this.o.a(var1, var2)) {
			for (int var3 = var1.getX(); var3 <= var2.getX(); ++var3) {
				for (int var4 = var1.getY(); var4 <= var2.getY(); ++var4) {
					for (int var5 = var1.getZ(); var5 <= var2.getZ(); ++var5) {
						Position var6 = new Position(var3, var4, var5);
						bec var7 = this.o.p(var6);

						try {
							var7.getBlock().a(this.o, var6, var7, this);
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
		if (this.o.p(var1.a()).getBlock() == Blocks.SNOW_LAYER) {
			var3 = Blocks.SNOW_LAYER.H;
			this.a(var3.c(), var3.d() * 0.15F, var3.e());
		} else if (!var2.r().isLiquid()) {
			this.a(var3.c(), var3.d() * 0.15F, var3.e());
		}

	}

	public void a(String var1, float var2, float var3) {
		if (!this.R()) {
			this.o.a(this, var1, var2, var3);
		}

	}

	public boolean R() {
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
			if (this.O > 0.0F) {
				if (var4 != null) {
					var4.a(this.o, var5, this, this.O);
				} else {
					this.e(this.O, 1.0F);
				}

				this.O = 0.0F;
			}
		} else if (var1 < 0.0D) {
			this.O = (float) ((double) this.O - var1);
		}

	}

	public AxisAlignedBB S() {
		return null;
	}

	protected void f(int var1) {
		if (!this.ab) {
			this.a(DamageSource.a, (float) var1);
		}

	}

	public final boolean T() {
		return this.ab;
	}

	public void e(float var1, float var2) {
		if (this.l != null) {
			this.l.e(var1, var2);
		}

	}

	public boolean U() {
		return this.Y || this.o.C(new Position(this.locationX, this.locationY, this.locationZ)) || this.o.C(new Position(this.locationX, this.locationY + (double) this.K, this.locationZ));
	}

	public boolean V() {
		return this.Y;
	}

	public boolean W() {
		if (this.o.a(this.aQ().b(0.0D, -0.4000000059604645D, 0.0D).d(0.001D, 0.001D, 0.001D), Material.WATER, this)) {
			if (!this.Y && !this.aa) {
				this.X();
			}

			this.O = 0.0F;
			this.Y = true;
			this.i = 0;
		} else {
			this.Y = false;
		}

		return this.Y;
	}

	protected void X() {
		float var1 = DataTypesConverter.a(this.motionX * this.motionX * 0.20000000298023224D + this.motionY * this.motionY + this.motionZ * this.motionZ * 0.20000000298023224D) * 0.2F;
		if (var1 > 1.0F) {
			var1 = 1.0F;
		}

		this.a(this.aa(), var1, 1.0F + (this.V.nextFloat() - this.V.nextFloat()) * 0.4F);
		float var2 = (float) DataTypesConverter.toFixedPointInt(this.aQ().minY);

		int var3;
		float var4;
		float var5;
		for (var3 = 0; (float) var3 < 1.0F + this.J * 20.0F; ++var3) {
			var4 = (this.V.nextFloat() * 2.0F - 1.0F) * this.J;
			var5 = (this.V.nextFloat() * 2.0F - 1.0F) * this.J;
			this.o.a(Particle.e, this.locationX + (double) var4, (double) (var2 + 1.0F), this.locationZ + (double) var5, this.motionX, this.motionY - (double) (this.V.nextFloat() * 0.2F), this.motionZ, new int[0]);
		}

		for (var3 = 0; (float) var3 < 1.0F + this.J * 20.0F; ++var3) {
			var4 = (this.V.nextFloat() * 2.0F - 1.0F) * this.J;
			var5 = (this.V.nextFloat() * 2.0F - 1.0F) * this.J;
			this.o.a(Particle.f, this.locationX + (double) var4, (double) (var2 + 1.0F), this.locationZ + (double) var5, this.motionX, this.motionY, this.motionZ, new int[0]);
		}

	}

	public void Y() {
		if (this.ax() && !this.V()) {
			this.Z();
		}

	}

	protected void Z() {
		int var1 = DataTypesConverter.toFixedPointInt(this.locationX);
		int var2 = DataTypesConverter.toFixedPointInt(this.locationY - 0.20000000298023224D);
		int var3 = DataTypesConverter.toFixedPointInt(this.locationZ);
		Position var4 = new Position(var1, var2, var3);
		bec var5 = this.o.p(var4);
		Block var6 = var5.getBlock();
		if (var6.b() != -1) {
			this.o.a(Particle.L, this.locationX + ((double) this.V.nextFloat() - 0.5D) * (double) this.J, this.aQ().minY + 0.1D, this.locationZ + ((double) this.V.nextFloat() - 0.5D) * (double) this.J, -this.motionX * 4.0D, 1.5D, -this.motionZ * 4.0D, new int[] { Block.f(var5) });
		}

	}

	protected String aa() {
		return "game.neutral.swim.splash";
	}

	public boolean a(Material var1) {
		double var2 = this.locationY + (double) this.aR();
		Position var4 = new Position(this.locationX, var2, this.locationZ);
		bec var5 = this.o.p(var4);
		Block var6 = var5.getBlock();
		if (var6.r() == var1) {
			float var7 = axl.b(var5.getBlock().c(var5)) - 0.11111111F;
			float var8 = (float) (var4.getY() + 1) - var7;
			boolean var9 = var2 < (double) var8;
			return !var9 && this instanceof EntityHuman ? false : var9;
		} else {
			return false;
		}
	}

	public boolean ab() {
		return this.o.a(this.aQ().b(-0.10000000149011612D, -0.4000000059604645D, -0.10000000149011612D), Material.LAVA);
	}

	public void a(float var1, float var2, float var3) {
		float var4 = var1 * var1 + var2 * var2;
		if (var4 >= 1.0E-4F) {
			var4 = DataTypesConverter.c(var4);
			if (var4 < 1.0F) {
				var4 = 1.0F;
			}

			var4 = var3 / var4;
			var1 *= var4;
			var2 *= var4;
			float var5 = DataTypesConverter.a(this.yaw * 3.1415927F / 180.0F);
			float var6 = DataTypesConverter.b(this.yaw * 3.1415927F / 180.0F);
			this.motionX += (double) (var1 * var6 - var2 * var5);
			this.motionZ += (double) (var2 * var6 + var1 * var5);
		}
	}

	public float c(float var1) {
		Position var2 = new Position(this.locationX, 0.0D, this.locationZ);
		if (this.o.e(var2)) {
			double var3 = (this.aQ().maxY - this.aQ().minY) * 0.66D;
			int var5 = DataTypesConverter.toFixedPointInt(this.locationY + var3);
			return this.o.o(var2.b(var5));
		} else {
			return 0.0F;
		}
	}

	public void a(World var1) {
		this.o = var1;
	}

	public void a(double var1, double var3, double var5, float var7, float var8) {
		this.p = this.locationX = var1;
		this.q = this.locationY = var3;
		this.r = this.locationZ = var5;
		this.A = this.yaw = var7;
		this.B = this.pitch = var8;
		double var9 = (double) (this.A - var7);
		if (var9 < -180.0D) {
			this.A += 360.0F;
		}

		if (var9 >= 180.0D) {
			this.A -= 360.0F;
		}

		this.b(this.locationX, this.locationY, this.locationZ);
		this.b(var7, var8);
	}

	public void a(Position var1, float var2, float var3) {
		this.b((double) var1.getX() + 0.5D, (double) var1.getY(), (double) var1.getZ() + 0.5D, var2, var3);
	}

	public void b(double var1, double var3, double var5, float var7, float var8) {
		this.P = this.p = this.locationX = var1;
		this.Q = this.q = this.locationY = var3;
		this.R = this.r = this.locationZ = var5;
		this.yaw = var7;
		this.pitch = var8;
		this.b(this.locationX, this.locationY, this.locationZ);
	}

	public float g(Entity var1) {
		float var2 = (float) (this.locationX - var1.locationX);
		float var3 = (float) (this.locationY - var1.locationY);
		float var4 = (float) (this.locationZ - var1.locationZ);
		return DataTypesConverter.c(var2 * var2 + var3 * var3 + var4 * var4);
	}

	public double e(double var1, double var3, double var5) {
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
		return (double) DataTypesConverter.a(var7 * var7 + var9 * var9 + var11 * var11);
	}

	public double h(Entity var1) {
		double var2 = this.locationX - var1.locationX;
		double var4 = this.locationY - var1.locationY;
		double var6 = this.locationZ - var1.locationZ;
		return var2 * var2 + var4 * var4 + var6 * var6;
	}

	public void d(EntityHuman var1) {
	}

	public void i(Entity var1) {
		if (var1.l != this && var1.m != this) {
			if (!var1.T && !this.T) {
				double var2 = var1.locationX - this.locationX;
				double var4 = var1.locationZ - this.locationZ;
				double var6 = DataTypesConverter.a(var2, var4);
				if (var6 >= 0.009999999776482582D) {
					var6 = (double) DataTypesConverter.a(var6);
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
					if (this.l == null) {
						this.g(-var2, 0.0D, -var4);
					}

					if (var1.l == null) {
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
		this.G = true;
	}

	public boolean a(DamageSource var1, float var2) {
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
			float var2 = this.B + (this.pitch - this.B) * var1;
			float var3 = this.A + (this.yaw - this.A) * var1;
			return this.f(var2, var3);
		}
	}

	protected final Vec3D f(float var1, float var2) {
		float var3 = DataTypesConverter.b(-var2 * 0.017453292F - 3.1415927F);
		float var4 = DataTypesConverter.a(-var2 * 0.017453292F - 3.1415927F);
		float var5 = -DataTypesConverter.b(-var1 * 0.017453292F);
		float var6 = DataTypesConverter.a(-var1 * 0.017453292F);
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
		if (!this.I && var2 != null) {
			var1.put("id", var2);
			this.e(var1);
			return true;
		} else {
			return false;
		}
	}

	public boolean d(NBTCompoundTag var1) {
		String var2 = this.ag();
		if (!this.I && var2 != null && this.l == null) {
			var1.put("id", var2);
			this.e(var1);
			return true;
		} else {
			return false;
		}
	}

	public void e(NBTCompoundTag var1) {
		try {
			var1.put("Pos", (NBTTag) this.a(new double[] { this.locationX, this.locationY, this.locationZ }));
			var1.put("Motion", (NBTTag) this.a(new double[] { this.motionX, this.motionY, this.motionZ }));
			var1.put("Rotation", (NBTTag) this.a(new float[] { this.yaw, this.pitch }));
			var1.put("FallDistance", this.O);
			var1.put("Fire", (short) this.i);
			var1.put("Air", (short) this.aA());
			var1.put("OnGround", this.onGround);
			var1.put("Dimension", this.dimensionId);
			var1.put("Invulnerable", this.ar);
			var1.put("PortalCooldown", this.aj);
			var1.put("UUIDMost", this.aJ().getMostSignificantBits());
			var1.put("UUIDLeast", this.aJ().getLeastSignificantBits());
			if (this.aL() != null && this.aL().length() > 0) {
				var1.put("CustomName", this.aL());
				var1.put("CustomNameVisible", this.aM());
			}

			this.as.b(var1);
			if (this.R()) {
				var1.put("Silent", this.R());
			}

			this.b(var1);
			if (this.m != null) {
				NBTCompoundTag var2 = new NBTCompoundTag();
				if (this.m.c(var2)) {
					var1.put("Riding", (NBTTag) var2);
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

			this.p = this.P = this.locationX = var2.getDouble(0);
			this.q = this.Q = this.locationY = var2.getDouble(1);
			this.r = this.R = this.locationZ = var2.getDouble(2);
			this.A = this.yaw = var7.getFloat(0);
			this.B = this.pitch = var7.getFloat(1);
			this.O = var1.getFloat("FallDistance");
			this.i = var1.getShort("Fire");
			this.h(var1.getShort("Air"));
			this.onGround = var1.getBoolean("OnGround");
			this.dimensionId = var1.getInt("Dimension");
			this.ar = var1.getBoolean("Invulnerable");
			this.aj = var1.getInt("PortalCooldown");
			if (var1.isTagAssignableFrom("UUIDMost", 4) && var1.isTagAssignableFrom("UUIDLeast", 4)) {
				this.ao = new UUID(var1.getLong("UUIDMost"), var1.getLong("UUIDLeast"));
			} else if (var1.isTagAssignableFrom("UUID", 8)) {
				this.ao = UUID.fromString(var1.getString("UUID"));
			}

			this.b(this.locationX, this.locationY, this.locationZ);
			this.b(this.yaw, this.pitch);
			if (var1.isTagAssignableFrom("CustomName", 8) && var1.getString("CustomName").length() > 0) {
				this.a(var1.getString("CustomName"));
			}

			this.g(var1.getBoolean("CustomNameVisible"));
			this.as.a(var1);
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

	protected NBTListTag a(double... var1) {
		NBTListTag var2 = new NBTListTag();
		double[] var3 = var1;
		int var4 = var1.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			double var6 = var3[var5];
			var2.addTag((NBTTag) (new NBTDoubleTag(var6)));
		}

		return var2;
	}

	protected NBTListTag a(float... var1) {
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
		if (var1.b != 0 && var1.getItem() != null) {
			EntityItem var3 = new EntityItem(this.o, this.locationX, this.locationY + (double) var2, this.locationZ, var1);
			var3.p();
			this.o.d((Entity) var3);
			return var3;
		} else {
			return null;
		}
	}

	public boolean ai() {
		return !this.I;
	}

	public boolean aj() {
		if (this.T) {
			return false;
		} else {
			for (int var1 = 0; var1 < 8; ++var1) {
				double var2 = this.locationX + (double) (((float) ((var1 >> 0) % 2) - 0.5F) * this.J * 0.8F);
				double var4 = this.locationY + (double) (((float) ((var1 >> 1) % 2) - 0.5F) * 0.1F);
				double var6 = this.locationZ + (double) (((float) ((var1 >> 2) % 2) - 0.5F) * this.J * 0.8F);
				if (this.o.p(new Position(var2, var4 + (double) this.aR(), var6)).getBlock().u()) {
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
		if (this.m.I) {
			this.m = null;
		} else {
			this.motionX = 0.0D;
			this.motionY = 0.0D;
			this.motionZ = 0.0D;
			this.s_();
			if (this.m != null) {
				this.m.al();
				this.aq += (double) (this.m.yaw - this.m.A);

				for (this.ap += (double) (this.m.pitch - this.m.B); this.aq >= 180.0D; this.aq -= 360.0D) {
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
		if (this.l != null) {
			this.l.b(this.locationX, this.locationY + this.an() + this.l.am(), this.locationZ);
		}
	}

	public double am() {
		return 0.0D;
	}

	public double an() {
		return (double) this.K * 0.75D;
	}

	public void a(Entity var1) {
		this.ap = 0.0D;
		this.aq = 0.0D;
		if (var1 == null) {
			if (this.m != null) {
				this.b(this.m.locationX, this.m.aQ().minY + (double) this.m.K, this.m.locationZ, this.yaw, this.pitch);
				this.m.l = null;
			}

			this.m = null;
		} else {
			if (this.m != null) {
				this.m.l = null;
			}

			if (var1 != null) {
				for (Entity var2 = var1.m; var2 != null; var2 = var2.m) {
					if (var2 == this) {
						return;
					}
				}
			}

			this.m = var1;
			var1.l = this;
		}
	}

	public float ao() {
		return 0.1F;
	}

	public Vec3D ap() {
		return null;
	}

	public void aq() {
		if (this.aj > 0) {
			this.aj = this.ar();
		} else {
			double var1 = this.p - this.locationX;
			double var3 = this.r - this.locationZ;
			if (!this.o.D && !this.ak) {
				int var5;
				if (DataTypesConverter.e((float) var1) > DataTypesConverter.e((float) var3)) {
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

	public ItemStack[] at() {
		return null;
	}

	public void c(int var1, ItemStack var2) {
	}

	public boolean au() {
		boolean var1 = this.o != null && this.o.D;
		return !this.ab && (this.i > 0 || var1 && this.g(0));
	}

	public boolean av() {
		return this.m != null;
	}

	public boolean aw() {
		return this.g(1);
	}

	public void c(boolean var1) {
		this.b(1, var1);
	}

	public boolean ax() {
		return this.g(3);
	}

	public void d(boolean var1) {
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

	public int aA() {
		return this.dataWatcher.b(1);
	}

	public void h(int var1) {
		this.dataWatcher.b(1, Short.valueOf((short) var1));
	}

	public void a(EntityLightning var1) {
		this.a(DamageSource.b, 5.0F);
		++this.i;
		if (this.i == 0) {
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
		List var14 = this.o.a(this.aQ());
		if (var14.isEmpty() && !this.o.u(var7)) {
			return false;
		} else {
			byte var15 = 3;
			double var16 = 9999.0D;
			if (!this.o.u(var7.e()) && var8 < var16) {
				var16 = var8;
				var15 = 0;
			}

			if (!this.o.u(var7.f()) && 1.0D - var8 < var16) {
				var16 = 1.0D - var8;
				var15 = 1;
			}

			if (!this.o.u(var7.a()) && 1.0D - var10 < var16) {
				var16 = 1.0D - var10;
				var15 = 3;
			}

			if (!this.o.u(var7.c()) && var12 < var16) {
				var16 = var12;
				var15 = 4;
			}

			if (!this.o.u(var7.d()) && 1.0D - var12 < var16) {
				var16 = 1.0D - var12;
				var15 = 5;
			}

			float var18 = this.V.nextFloat() * 0.2F + 0.1F;
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
		this.O = 0.0F;
	}

	public String d_() {
		if (this.k_()) {
			return this.aL();
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
		return String.format("%s[\'%s\'/%d, l=\'%s\', x=%.2f, y=%.2f, z=%.2f]", new Object[] { this.getClass().getSimpleName(), this.d_(), Integer.valueOf(this.entityId), this.o == null ? "~NULL~" : this.o.P().k(), Double.valueOf(this.locationX), Double.valueOf(this.locationY), Double.valueOf(this.locationZ) });
	}

	public boolean b(DamageSource var1) {
		return this.ar && var1 != DamageSource.j && !var1.u();
	}

	public void m(Entity var1) {
		this.b(var1.locationX, var1.locationY, var1.locationZ, var1.yaw, var1.pitch);
	}

	public void n(Entity var1) {
		NBTCompoundTag var2 = new NBTCompoundTag();
		var1.e(var2);
		this.load(var2);
		this.aj = var1.aj;
		this.an = var1.an;
	}

	public void c(int var1) {
		if (!this.o.D && !this.I) {
			this.o.B.a("changeDimension");
			MinecraftServer var2 = MinecraftServer.getInstance();
			int var3 = this.dimensionId;
			WorldServer var4 = var2.getWorldServer(var3);
			WorldServer var5 = var2.getWorldServer(var1);
			this.dimensionId = var1;
			if (var3 == 1 && var1 == 1) {
				var5 = var2.getWorldServer(0);
				this.dimensionId = 0;
			}

			this.o.e(this);
			this.I = false;
			this.o.B.a("reposition");
			var2.getPlayerList().a(this, var3, var4, var5);
			this.o.B.c("reloading");
			Entity var6 = EntityTypes.createEntity(EntityTypes.getNameByClass(this), (World) var5);
			if (var6 != null) {
				var6.n(this);
				if (var3 == 1 && var1 == 1) {
					Position var7 = this.o.r(var5.M());
					var6.a(var7, var6.yaw, var6.pitch);
				}

				var5.d(var6);
			}

			this.I = true;
			this.o.B.b();
			var4.j();
			var5.j();
			this.o.B.b();
		}
	}

	public float a(aqo var1, World var2, Position var3, bec var4) {
		return var4.getBlock().a(this);
	}

	public boolean a(aqo var1, World var2, Position var3, bec var4, float var5) {
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
		var1.addDetails("Entity Type", (Callable) (new ww(this)));
		var1.addDetails("Entity ID", (Object) Integer.valueOf(this.entityId));
		var1.addDetails("Entity Name", (Callable) (new wx(this)));
		var1.addDetails("Entity\'s Exact location", (Object) String.format("%.2f, %.2f, %.2f", new Object[] { Double.valueOf(this.locationX), Double.valueOf(this.locationY), Double.valueOf(this.locationZ) }));
		var1.addDetails("Entity\'s Block location", (Object) net.minecraft.CrashReportSystemDetails.a((double) DataTypesConverter.toFixedPointInt(this.locationX), (double) DataTypesConverter.toFixedPointInt(this.locationY), (double) DataTypesConverter.toFixedPointInt(this.locationZ)));
		var1.addDetails("Entity\'s Momentum", (Object) String.format("%.2f, %.2f, %.2f", new Object[] { Double.valueOf(this.motionX), Double.valueOf(this.motionY), Double.valueOf(this.motionZ) }));
		var1.addDetails("Entity\'s Rider", (Callable) (new wy(this)));
		var1.addDetails("Entity\'s Vehicle", (Callable) (new wz(this)));
	}

	public UUID aJ() {
		return this.ao;
	}

	public boolean aK() {
		return true;
	}

	public IChatBaseComponent e_() {
		ChatComponentText var1 = new ChatComponentText(this.d_());
		var1.b().a(this.aP());
		var1.b().a(this.aJ().toString());
		return var1;
	}

	public void a(String var1) {
		this.dataWatcher.b(2, var1);
	}

	public String aL() {
		return this.dataWatcher.e(2);
	}

	public boolean k_() {
		return this.dataWatcher.e(2).length() > 0;
	}

	public void g(boolean var1) {
		this.dataWatcher.b(3, Byte.valueOf((byte) (var1 ? 1 : 0)));
	}

	public boolean aM() {
		return this.dataWatcher.a(3) == 1;
	}

	public void a(double var1, double var3, double var5) {
		this.b(var1, var3, var5, this.yaw, this.pitch);
	}

	public void i(int var1) {
	}

	public BlockFace aO() {
		return BlockFace.fromDirection(DataTypesConverter.toFixedPointInt((double) (this.yaw * 4.0F / 360.0F) + 0.5D) & 3);
	}

	protected ChatHoverable aP() {
		NBTCompoundTag var1 = new NBTCompoundTag();
		String var2 = EntityTypes.getNameByClass(this);
		var1.put("id", this.aJ().toString());
		if (var2 != null) {
			var1.put("type", var2);
		}

		var1.put("name", this.d_());
		return new ChatHoverable(EnumHoverAction.d, new ChatComponentText(var1.toString()));
	}

	public boolean a(EntityPlayer var1) {
		return true;
	}

	public AxisAlignedBB aQ() {
		return this.f;
	}

	public void a(AxisAlignedBB var1) {
		this.f = var1;
	}

	public float aR() {
		return this.K * 0.85F;
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

	public boolean a(int var1, String var2) {
		return true;
	}

	public Position c() {
		return new Position(this.locationX, this.locationY + 0.5D, this.locationZ);
	}

	public Vec3D d() {
		return new Vec3D(this.locationX, this.locationY, this.locationZ);
	}

	public World e() {
		return this.o;
	}

	public Entity f() {
		return this;
	}

	public boolean t_() {
		return false;
	}

	public void a(ag var1, int var2) {
		this.as.a(this, var1, var2);
	}

	public af aT() {
		return this.as;
	}

	public void o(Entity var1) {
		this.as.a(var1.aT());
	}

	public NBTCompoundTag aU() {
		return null;
	}

	public boolean a(EntityHuman var1, Vec3D var2) {
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

}
