package net.minecraft;

import java.util.Iterator;
import net.minecraft.server.MinecraftServer;

public abstract class adx extends Entity implements ICustomNameable {

	private boolean a;
	private String b;
	private static final int[][][] c = new int[][][] { { { 0, 0, -1 }, { 0, 0, 1 } }, { { -1, 0, 0 }, { 1, 0, 0 } }, { { -1, -1, 0 }, { 1, 0, 0 } }, { { -1, 0, 0 }, { 1, -1, 0 } }, { { 0, 0, -1 }, { 0, -1, 1 } }, { { 0, -1, -1 }, { 0, 0, 1 } }, { { 0, 0, 1 }, { 1, 0, 0 } }, { { 0, 0, 1 }, { -1, 0, 0 } }, { { 0, 0, -1 }, { -1, 0, 0 } }, { { 0, 0, -1 }, { 1, 0, 0 } } };
	private int d;
	private double e;
	private double f;
	private double g;
	private double h;
	private double i;

	public adx(World var1) {
		super(var1);
		this.k = true;
		this.a(0.98F, 0.7F);
	}

	public static adx a(World var0, double var1, double var3, double var5, MinecartType var7) {
		switch (ady.a[var7.ordinal()]) {
			case 1:
				return new EntityMinecartChest(var0, var1, var3, var5);
			case 2:
				return new EntityMinecartFurnace(var0, var1, var3, var5);
			case 3:
				return new EntityMinecartTNT(var0, var1, var3, var5);
			case 4:
				return new EntityMinecartMobSpawner(var0, var1, var3, var5);
			case 5:
				return new EntityMinecartHopper(var0, var1, var3, var5);
			case 6:
				return new EntityMinecartCommandBlock(var0, var1, var3, var5);
			default:
				return new EntityMinecartRideable(var0, var1, var3, var5);
		}
	}

	protected boolean r_() {
		return false;
	}

	protected void h() {
		this.dataWatcher.a(17, new Integer(0));
		this.dataWatcher.a(18, new Integer(1));
		this.dataWatcher.a(19, new Float(0.0F));
		this.dataWatcher.a(20, new Integer(0));
		this.dataWatcher.a(21, new Integer(6));
		this.dataWatcher.a(22, Byte.valueOf((byte) 0));
	}

	public AxisAlignedBB j(Entity var1) {
		return var1.ae() ? var1.getBoundingBox() : null;
	}

	public AxisAlignedBB S() {
		return null;
	}

	public boolean ae() {
		return true;
	}

	public adx(World var1, double var2, double var4, double var6) {
		this(var1);
		this.b(var2, var4, var6);
		this.motionX = 0.0D;
		this.motionY = 0.0D;
		this.motionZ = 0.0D;
		this.previousX = var2;
		this.previousY = var4;
		this.previousZ = var6;
	}

	public double an() {
		return (double) this.width * 0.5D - 0.20000000298023224D;
	}

	public boolean damageEntity(DamageSource var1, float var2) {
		if (!this.world.isStatic && !this.dead) {
			if (this.b(var1)) {
				return false;
			} else {
				this.k(-this.r());
				this.j(10);
				this.ac();
				this.a(this.p() + var2 * 10.0F);
				boolean var3 = var1.j() instanceof EntityHuman && ((EntityHuman) var1.j()).playerProperties.instabuild;
				if (var3 || this.p() > 40.0F) {
					if (this.passenger != null) {
						this.passenger.mount((Entity) null);
					}

					if (var3 && !this.hasCustomName()) {
						this.die();
					} else {
						this.a(var1);
					}
				}

				return true;
			}
		} else {
			return true;
		}
	}

	public void a(DamageSource var1) {
		this.die();
		ItemStack var2 = new ItemStack(Items.MINECART, 1);
		if (this.b != null) {
			var2.c(this.b);
		}

		this.a(var2, 0.0F);
	}

	public boolean ad() {
		return !this.dead;
	}

	public void die() {
		super.die();
	}

	public void s_() {
		if (this.q() > 0) {
			this.j(this.q() - 1);
		}

		if (this.p() > 0.0F) {
			this.a(this.p() - 1.0F);
		}

		if (this.locationY < -64.0D) {
			this.O();
		}

		int var2;
		if (!this.world.isStatic && this.world instanceof WorldServer) {
			this.world.B.a("portal");
			MinecraftServer var1 = ((WorldServer) this.world).r();
			var2 = this.L();
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

		if (this.world.isStatic) {
			if (this.d > 0) {
				double var15 = this.locationX + (this.e - this.locationX) / (double) this.d;
				double var17 = this.locationY + (this.f - this.locationY) / (double) this.d;
				double var18 = this.locationZ + (this.g - this.locationZ) / (double) this.d;
				double var7 = MathHelper.g(this.h - (double) this.yaw);
				this.yaw = (float) ((double) this.yaw + var7 / (double) this.d);
				this.pitch = (float) ((double) this.pitch + (this.i - (double) this.pitch) / (double) this.d);
				--this.d;
				this.b(var15, var17, var18);
				this.b(this.yaw, this.pitch);
			} else {
				this.b(this.locationX, this.locationY, this.locationZ);
				this.b(this.yaw, this.pitch);
			}

		} else {
			this.previousX = this.locationX;
			this.previousY = this.locationY;
			this.previousZ = this.locationZ;
			this.motionY -= 0.03999999910593033D;
			int var14 = MathHelper.toFixedPointInt(this.locationX);
			var2 = MathHelper.toFixedPointInt(this.locationY);
			int var16 = MathHelper.toFixedPointInt(this.locationZ);
			if (ati.d(this.world, new Position(var14, var2 - 1, var16))) {
				--var2;
			}

			Position var4 = new Position(var14, var2, var16);
			IBlockState var5 = this.world.getBlockState(var4);
			if (ati.d(var5)) {
				this.a(var4, var5);
				if (var5.getBlock() == Blocks.ACTIVATOR_RAIL) {
					this.a(var14, var2, var16, ((Boolean) var5.b(BlockPoweredRail.M)).booleanValue());
				}
			} else {
				this.n();
			}

			this.Q();
			this.pitch = 0.0F;
			double var6 = this.previousX - this.locationX;
			double var8 = this.previousZ - this.locationZ;
			if (var6 * var6 + var8 * var8 > 0.001D) {
				this.yaw = (float) (Math.atan2(var8, var6) * 180.0D / 3.141592653589793D);
				if (this.a) {
					this.yaw += 180.0F;
				}
			}

			double var10 = (double) MathHelper.g(this.yaw - this.lastYaw);
			if (var10 < -170.0D || var10 >= 170.0D) {
				this.yaw += 180.0F;
				this.a = !this.a;
			}

			this.b(this.yaw, this.pitch);
			Iterator var12 = this.world.getEntities((Entity) this, this.getBoundingBox().grow(0.20000000298023224D, 0.0D, 0.20000000298023224D)).iterator();

			while (var12.hasNext()) {
				Entity var13 = (Entity) var12.next();
				if (var13 != this.passenger && var13.ae() && var13 instanceof adx) {
					var13.i(this);
				}
			}

			if (this.passenger != null && this.passenger.dead) {
				if (this.passenger.vehicle == this) {
					this.passenger.vehicle = null;
				}

				this.passenger = null;
			}

			this.W();
		}
	}

	protected double m() {
		return 0.4D;
	}

	public void a(int var1, int var2, int var3, boolean var4) {
	}

	protected void n() {
		double var1 = this.m();
		this.motionX = MathHelper.a(this.motionX, -var1, var1);
		this.motionZ = MathHelper.a(this.motionZ, -var1, var1);
		if (this.onGround) {
			this.motionX *= 0.5D;
			this.motionY *= 0.5D;
			this.motionZ *= 0.5D;
		}

		this.move(this.motionX, this.motionY, this.motionZ);
		if (!this.onGround) {
			this.motionX *= 0.949999988079071D;
			this.motionY *= 0.949999988079071D;
			this.motionZ *= 0.949999988079071D;
		}

	}

	protected void a(Position var1, IBlockState var2) {
		this.fallDistance = 0.0F;
		Vec3D var3 = this.k(this.locationX, this.locationY, this.locationZ);
		this.locationY = (double) var1.getY();
		boolean var4 = false;
		boolean var5 = false;
		ati var6 = (ati) var2.getBlock();
		if (var6 == Blocks.GOLDEN_RAIL) {
			var4 = ((Boolean) var2.b(BlockPoweredRail.M)).booleanValue();
			var5 = !var4;
		}

		double var7 = 0.0078125D;
		atl var9 = (atl) var2.b(var6.l());
		switch (ady.b[var9.ordinal()]) {
			case 1:
				this.motionX -= 0.0078125D;
				++this.locationY;
				break;
			case 2:
				this.motionX += 0.0078125D;
				++this.locationY;
				break;
			case 3:
				this.motionZ += 0.0078125D;
				++this.locationY;
				break;
			case 4:
				this.motionZ -= 0.0078125D;
				++this.locationY;
		}

		int[][] var10 = c[var9.a()];
		double var11 = (double) (var10[1][0] - var10[0][0]);
		double var13 = (double) (var10[1][2] - var10[0][2]);
		double var15 = Math.sqrt(var11 * var11 + var13 * var13);
		double var17 = this.motionX * var11 + this.motionZ * var13;
		if (var17 < 0.0D) {
			var11 = -var11;
			var13 = -var13;
		}

		double var19 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
		if (var19 > 2.0D) {
			var19 = 2.0D;
		}

		this.motionX = var19 * var11 / var15;
		this.motionZ = var19 * var13 / var15;
		double var21;
		double var23;
		double var25;
		double var27;
		if (this.passenger instanceof EntityLiving) {
			var21 = (double) ((EntityLiving) this.passenger).aY;
			if (var21 > 0.0D) {
				var23 = -Math.sin((double) (this.passenger.yaw * 3.1415927F / 180.0F));
				var25 = Math.cos((double) (this.passenger.yaw * 3.1415927F / 180.0F));
				var27 = this.motionX * this.motionX + this.motionZ * this.motionZ;
				if (var27 < 0.01D) {
					this.motionX += var23 * 0.1D;
					this.motionZ += var25 * 0.1D;
					var5 = false;
				}
			}
		}

		if (var5) {
			var21 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
			if (var21 < 0.03D) {
				this.motionX *= 0.0D;
				this.motionY *= 0.0D;
				this.motionZ *= 0.0D;
			} else {
				this.motionX *= 0.5D;
				this.motionY *= 0.0D;
				this.motionZ *= 0.5D;
			}
		}

		var21 = 0.0D;
		var23 = (double) var1.getX() + 0.5D + (double) var10[0][0] * 0.5D;
		var25 = (double) var1.getZ() + 0.5D + (double) var10[0][2] * 0.5D;
		var27 = (double) var1.getX() + 0.5D + (double) var10[1][0] * 0.5D;
		double var29 = (double) var1.getZ() + 0.5D + (double) var10[1][2] * 0.5D;
		var11 = var27 - var23;
		var13 = var29 - var25;
		double var31;
		double var33;
		if (var11 == 0.0D) {
			this.locationX = (double) var1.getX() + 0.5D;
			var21 = this.locationZ - (double) var1.getZ();
		} else if (var13 == 0.0D) {
			this.locationZ = (double) var1.getZ() + 0.5D;
			var21 = this.locationX - (double) var1.getX();
		} else {
			var31 = this.locationX - var23;
			var33 = this.locationZ - var25;
			var21 = (var31 * var11 + var33 * var13) * 2.0D;
		}

		this.locationX = var23 + var11 * var21;
		this.locationZ = var25 + var13 * var21;
		this.b(this.locationX, this.locationY, this.locationZ);
		var31 = this.motionX;
		var33 = this.motionZ;
		if (this.passenger != null) {
			var31 *= 0.75D;
			var33 *= 0.75D;
		}

		double var35 = this.m();
		var31 = MathHelper.a(var31, -var35, var35);
		var33 = MathHelper.a(var33, -var35, var35);
		this.move(var31, 0.0D, var33);
		if (var10[0][1] != 0 && MathHelper.toFixedPointInt(this.locationX) - var1.getX() == var10[0][0] && MathHelper.toFixedPointInt(this.locationZ) - var1.getZ() == var10[0][2]) {
			this.b(this.locationX, this.locationY + (double) var10[0][1], this.locationZ);
		} else if (var10[1][1] != 0 && MathHelper.toFixedPointInt(this.locationX) - var1.getX() == var10[1][0] && MathHelper.toFixedPointInt(this.locationZ) - var1.getZ() == var10[1][2]) {
			this.b(this.locationX, this.locationY + (double) var10[1][1], this.locationZ);
		}

		this.o();
		Vec3D var37 = this.k(this.locationX, this.locationY, this.locationZ);
		if (var37 != null && var3 != null) {
			double var38 = (var3.y - var37.y) * 0.05D;
			var19 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
			if (var19 > 0.0D) {
				this.motionX = this.motionX / var19 * (var19 + var38);
				this.motionZ = this.motionZ / var19 * (var19 + var38);
			}

			this.b(this.locationX, var37.y, this.locationZ);
		}

		int var44 = MathHelper.toFixedPointInt(this.locationX);
		int var39 = MathHelper.toFixedPointInt(this.locationZ);
		if (var44 != var1.getX() || var39 != var1.getZ()) {
			var19 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
			this.motionX = var19 * (double) (var44 - var1.getX());
			this.motionZ = var19 * (double) (var39 - var1.getZ());
		}

		if (var4) {
			double var40 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
			if (var40 > 0.01D) {
				double var42 = 0.06D;
				this.motionX += this.motionX / var40 * var42;
				this.motionZ += this.motionZ / var40 * var42;
			} else if (var9 == atl.b) {
				if (this.world.getBlockState(var1.e()).getBlock().t()) {
					this.motionX = 0.02D;
				} else if (this.world.getBlockState(var1.f()).getBlock().t()) {
					this.motionX = -0.02D;
				}
			} else if (var9 == atl.a) {
				if (this.world.getBlockState(var1.c()).getBlock().t()) {
					this.motionZ = 0.02D;
				} else if (this.world.getBlockState(var1.d()).getBlock().t()) {
					this.motionZ = -0.02D;
				}
			}
		}

	}

	protected void o() {
		if (this.passenger != null) {
			this.motionX *= 0.996999979019165D;
			this.motionY *= 0.0D;
			this.motionZ *= 0.996999979019165D;
		} else {
			this.motionX *= 0.9599999785423279D;
			this.motionY *= 0.0D;
			this.motionZ *= 0.9599999785423279D;
		}

	}

	public void b(double var1, double var3, double var5) {
		this.locationX = var1;
		this.locationY = var3;
		this.locationZ = var5;
		float var7 = this.height / 2.0F;
		float var8 = this.width;
		this.setBoundingBox(new AxisAlignedBB(var1 - (double) var7, var3, var5 - (double) var7, var1 + (double) var7, var3 + (double) var8, var5 + (double) var7));
	}

	public Vec3D k(double var1, double var3, double var5) {
		int var7 = MathHelper.toFixedPointInt(var1);
		int var8 = MathHelper.toFixedPointInt(var3);
		int var9 = MathHelper.toFixedPointInt(var5);
		if (ati.d(this.world, new Position(var7, var8 - 1, var9))) {
			--var8;
		}

		IBlockState var10 = this.world.getBlockState(new Position(var7, var8, var9));
		if (ati.d(var10)) {
			atl var11 = (atl) var10.b(((ati) var10.getBlock()).l());
			int[][] var12 = c[var11.a()];
			double var13 = 0.0D;
			double var15 = (double) var7 + 0.5D + (double) var12[0][0] * 0.5D;
			double var17 = (double) var8 + 0.0625D + (double) var12[0][1] * 0.5D;
			double var19 = (double) var9 + 0.5D + (double) var12[0][2] * 0.5D;
			double var21 = (double) var7 + 0.5D + (double) var12[1][0] * 0.5D;
			double var23 = (double) var8 + 0.0625D + (double) var12[1][1] * 0.5D;
			double var25 = (double) var9 + 0.5D + (double) var12[1][2] * 0.5D;
			double var27 = var21 - var15;
			double var29 = (var23 - var17) * 2.0D;
			double var31 = var25 - var19;
			if (var27 == 0.0D) {
				var1 = (double) var7 + 0.5D;
				var13 = var5 - (double) var9;
			} else if (var31 == 0.0D) {
				var5 = (double) var9 + 0.5D;
				var13 = var1 - (double) var7;
			} else {
				double var33 = var1 - var15;
				double var35 = var5 - var19;
				var13 = (var33 * var27 + var35 * var31) * 2.0D;
			}

			var1 = var15 + var27 * var13;
			var3 = var17 + var29 * var13;
			var5 = var19 + var31 * var13;
			if (var29 < 0.0D) {
				++var3;
			}

			if (var29 > 0.0D) {
				var3 += 0.5D;
			}

			return new Vec3D(var1, var3, var5);
		} else {
			return null;
		}
	}

	protected void a(NBTCompoundTag var1) {
		if (var1.getBoolean("CustomDisplayTile")) {
			int var2 = var1.getInt("DisplayData");
			Block var3;
			if (var1.isTagAssignableFrom("DisplayTile", 8)) {
				var3 = Block.getBlockByName(var1.getString("DisplayTile"));
				if (var3 == null) {
					this.a(Blocks.AIR.getBlockState());
				} else {
					this.a(var3.setData(var2));
				}
			} else {
				var3 = Block.getBlockById(var1.getInt("DisplayTile"));
				if (var3 == null) {
					this.a(Blocks.AIR.getBlockState());
				} else {
					this.a(var3.setData(var2));
				}
			}

			this.l(var1.getInt("DisplayOffset"));
		}

		if (var1.isTagAssignableFrom("CustomName", 8) && var1.getString("CustomName").length() > 0) {
			this.b = var1.getString("CustomName");
		}

	}

	protected void b(NBTCompoundTag var1) {
		if (this.x()) {
			var1.put("CustomDisplayTile", true);
			IBlockState var2 = this.t();
			RegistryObjectName var3 = (RegistryObjectName) Block.BLOCKREGISTRY.c(var2.getBlock());
			var1.put("DisplayTile", var3 == null ? "" : var3.toString());
			var1.put("DisplayData", var2.getBlock().getData(var2));
			var1.put("DisplayOffset", this.v());
		}

		if (this.b != null && this.b.length() > 0) {
			var1.put("CustomName", this.b);
		}

	}

	public void i(Entity var1) {
		if (!this.world.isStatic) {
			if (!var1.T && !this.T) {
				if (var1 != this.passenger) {
					if (var1 instanceof EntityLiving && !(var1 instanceof EntityHuman) && !(var1 instanceof EntityIronGolem) && this.s() == MinecartType.RIDEABLE && this.motionX * this.motionX + this.motionZ * this.motionZ > 0.01D && this.passenger == null && var1.vehicle == null) {
						var1.mount((Entity) this);
					}

					double var2 = var1.locationX - this.locationX;
					double var4 = var1.locationZ - this.locationZ;
					double var6 = var2 * var2 + var4 * var4;
					if (var6 >= 9.999999747378752E-5D) {
						var6 = (double) MathHelper.sqrt(var6);
						var2 /= var6;
						var4 /= var6;
						double var8 = 1.0D / var6;
						if (var8 > 1.0D) {
							var8 = 1.0D;
						}

						var2 *= var8;
						var4 *= var8;
						var2 *= 0.10000000149011612D;
						var4 *= 0.10000000149011612D;
						var2 *= (double) (1.0F - this.U);
						var4 *= (double) (1.0F - this.U);
						var2 *= 0.5D;
						var4 *= 0.5D;
						if (var1 instanceof adx) {
							double var10 = var1.locationX - this.locationX;
							double var12 = var1.locationZ - this.locationZ;
							Vec3D var14 = (new Vec3D(var10, 0.0D, var12)).a();
							Vec3D var15 = (new Vec3D((double) MathHelper.b(this.yaw * 3.1415927F / 180.0F), 0.0D, (double) MathHelper.a(this.yaw * 3.1415927F / 180.0F))).a();
							double var16 = Math.abs(var14.b(var15));
							if (var16 < 0.800000011920929D) {
								return;
							}

							double var18 = var1.motionX + this.motionX;
							double var20 = var1.motionZ + this.motionZ;
							if (((adx) var1).s() == MinecartType.FURNACE && this.s() != MinecartType.FURNACE) {
								this.motionX *= 0.20000000298023224D;
								this.motionZ *= 0.20000000298023224D;
								this.g(var1.motionX - var2, 0.0D, var1.motionZ - var4);
								var1.motionX *= 0.949999988079071D;
								var1.motionZ *= 0.949999988079071D;
							} else if (((adx) var1).s() != MinecartType.FURNACE && this.s() == MinecartType.FURNACE) {
								var1.motionX *= 0.20000000298023224D;
								var1.motionZ *= 0.20000000298023224D;
								var1.g(this.motionX + var2, 0.0D, this.motionZ + var4);
								this.motionX *= 0.949999988079071D;
								this.motionZ *= 0.949999988079071D;
							} else {
								var18 /= 2.0D;
								var20 /= 2.0D;
								this.motionX *= 0.20000000298023224D;
								this.motionZ *= 0.20000000298023224D;
								this.g(var18 - var2, 0.0D, var20 - var4);
								var1.motionX *= 0.20000000298023224D;
								var1.motionZ *= 0.20000000298023224D;
								var1.g(var18 + var2, 0.0D, var20 + var4);
							}
						} else {
							this.g(-var2, 0.0D, -var4);
							var1.g(var2 / 4.0D, 0.0D, var4 / 4.0D);
						}
					}

				}
			}
		}
	}

	public void a(float var1) {
		this.dataWatcher.b(19, Float.valueOf(var1));
	}

	public float p() {
		return this.dataWatcher.getData(19);
	}

	public void j(int var1) {
		this.dataWatcher.b(17, Integer.valueOf(var1));
	}

	public int q() {
		return this.dataWatcher.c(17);
	}

	public void k(int var1) {
		this.dataWatcher.b(18, Integer.valueOf(var1));
	}

	public int r() {
		return this.dataWatcher.c(18);
	}

	public abstract MinecartType s();

	public IBlockState t() {
		return !this.x() ? this.u() : Block.getStateById(this.getDataWatcher().c(20));
	}

	public IBlockState u() {
		return Blocks.AIR.getBlockState();
	}

	public int v() {
		return !this.x() ? this.w() : this.getDataWatcher().c(21);
	}

	public int w() {
		return 6;
	}

	public void a(IBlockState var1) {
		this.getDataWatcher().b(20, Integer.valueOf(Block.getStateId(var1)));
		this.a(true);
	}

	public void l(int var1) {
		this.getDataWatcher().b(21, Integer.valueOf(var1));
		this.a(true);
	}

	public boolean x() {
		return this.getDataWatcher().a(22) == 1;
	}

	public void a(boolean var1) {
		this.getDataWatcher().b(22, Byte.valueOf((byte) (var1 ? 1 : 0)));
	}

	public void a(String var1) {
		this.b = var1;
	}

	public String getName() {
		return this.b != null ? this.b : super.getName();
	}

	public boolean hasCustomName() {
		return this.b != null;
	}

	public String getCustomName() {
		return this.b;
	}

	public IChatBaseComponent getComponentName() {
		if (this.hasCustomName()) {
			ChatComponentText var2 = new ChatComponentText(this.b);
			var2.getChatModifier().a(this.aP());
			var2.getChatModifier().a(this.getUUID().toString());
			return var2;
		} else {
			ChatMessage var1 = new ChatMessage(this.getName(), new Object[0]);
			var1.getChatModifier().a(this.aP());
			var1.getChatModifier().a(this.getUUID().toString());
			return var1;
		}
	}

}
