package net.minecraft;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;

import pipebukkit.server.PipeWorld;
import net.minecraft.server.MinecraftServer;

public abstract class World implements ard {

	protected boolean e;
	public final List<Entity> f = Lists.newArrayList();
	protected final List g = Lists.newArrayList();
	public final List h = Lists.newArrayList();
	public final List i = Lists.newArrayList();
	private final List a = Lists.newArrayList();
	private final List b = Lists.newArrayList();
	public final List<Entity> j = Lists.newArrayList();
	public final List k = Lists.newArrayList();
	protected final IntHashMap l = new IntHashMap();
	private long c = 16777215L;
	private int d;
	protected int m = (new Random()).nextInt();
	protected final int n = 1013904223;
	protected float o;
	protected float p;
	protected float q;
	protected float r;
	private int I;
	public final Random random = new Random();
	public final WorldProvider worldProvider;
	protected List<IWorldAccess> u = Lists.newArrayList();
	protected IChunkProvider chunkProvider;
	protected final IDataManager dataManager;
	protected WorldData worldData;
	protected boolean isLoading;
	protected brn z;
	protected PersistentVillage A;
	public final MethodProfiler B;
	private final Calendar J = Calendar.getInstance();
	protected Scoreboard C = new Scoreboard();
	public final boolean isStatic;
	protected Set E = Sets.newHashSet();
	private int K;
	protected boolean F;
	protected boolean G;
	private boolean L;
	private final WorldBorder worldborder;
	int[] H;

	protected World(IDataManager var1, String levelName, WorldSettings settings, WorldProvider var3, MethodProfiler var4, boolean var5) {
		this.K = this.random.nextInt(12000);
		this.F = true;
		this.G = true;
		this.H = new int['\u8000'];
		this.dataManager = var1;
		this.B = var4;
		this.worldData = var1.getWorldData();
		if (worldData == null) {
			worldData = new WorldData(settings, levelName);
		}
		this.worldProvider = var3;
		this.isStatic = var5;
		this.worldborder = var3.getWorldBorder();
	}

	public World b() {
		return this;
	}

	public BiomeBase b(Position var1) {
		if (this.isLoaded(var1)) {
			Chunk var2 = this.getChunk(var1);

			try {
				return var2.a(var1, this.worldProvider.m());
			} catch (Throwable var6) {
				CrashReport var4 = CrashReport.generateCrashReport(var6, "Getting biome");
				CrashReportSystemDetails var5 = var4.generateSystemDetails("Coordinates of biome request");
				var5.addDetails("Location", (Callable) (new aqv(this, var1)));
				throw new ReportedException(var4);
			}
		} else {
			return this.worldProvider.m().a(var1, BiomeBase.PLAINS);
		}
	}

	public WorldChunkManager v() {
		return this.worldProvider.m();
	}

	protected abstract IChunkProvider getServerChunkProvider();

	public void applyWorldSettings(WorldSettings var1) {
		this.worldData.setInitialized(true);
	}

	public Block c(Position var1) {
		Position var2;
		for (var2 = new Position(var1.getX(), 63, var1.getZ()); !this.d(var2.getUp()); var2 = var2.getUp()) {
			;
		}

		return this.getBlockState(var2).getBlock();
	}

	private boolean a(Position var1) {
		return var1.getX() >= -30000000 && var1.getZ() >= -30000000 && var1.getX() < 30000000 && var1.getZ() < 30000000 && var1.getY() >= 0 && var1.getY() < 256;
	}

	public boolean d(Position var1) {
		return this.getBlockState(var1).getBlock().getMaterial() == Material.AIR;
	}

	public boolean isLoaded(Position var1) {
		return this.a(var1, true);
	}

	public boolean a(Position var1, boolean var2) {
		return !this.a(var1) ? false : this.a(var1.getX() >> 4, var1.getZ() >> 4, var2);
	}

	public boolean a(Position var1, int var2) {
		return this.a(var1, var2, true);
	}

	public boolean a(Position var1, int var2, boolean var3) {
		return this.a(var1.getX() - var2, var1.getY() - var2, var1.getZ() - var2, var1.getX() + var2, var1.getY() + var2, var1.getZ() + var2, var3);
	}

	public boolean a(Position var1, Position var2) {
		return this.a(var1, var2, true);
	}

	public boolean a(Position var1, Position var2, boolean var3) {
		return this.a(var1.getX(), var1.getY(), var1.getZ(), var2.getX(), var2.getY(), var2.getZ(), var3);
	}

	public boolean a(CuboidArea var1) {
		return this.b(var1, true);
	}

	public boolean b(CuboidArea var1, boolean var2) {
		return this.a(var1.minX, var1.minY, var1.minZ, var1.maxX, var1.maxY, var1.maxZ, var2);
	}

	private boolean a(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
		if (var5 >= 0 && var2 < 256) {
			var1 >>= 4;
			var3 >>= 4;
			var4 >>= 4;
			var6 >>= 4;

			for (int var8 = var1; var8 <= var4; ++var8) {
				for (int var9 = var3; var9 <= var6; ++var9) {
					if (!this.a(var8, var9, var7)) {
						return false;
					}
				}
			}

			return true;
		} else {
			return false;
		}
	}

	protected boolean a(int var1, int var2, boolean var3) {
		return this.chunkProvider.isChunkLoaded(var1, var2) && (var3 || !this.chunkProvider.getOrCreateChunk(var1, var2).f());
	}

	public Chunk getChunk(Position var1) {
		return this.a(var1.getX() >> 4, var1.getZ() >> 4);
	}

	public Chunk a(int var1, int var2) {
		return this.chunkProvider.getOrCreateChunk(var1, var2);
	}

	public boolean setBlockAt(Position position, IBlockState blockState, int notifyType) {
		if (!this.a(position)) {
			return false;
		} else if (!this.isStatic && this.worldData.getLevelType() == LevelType.DEBUG) {
			return false;
		} else {
			Chunk var4 = this.getChunk(position);
			Block var5 = blockState.getBlock();
			IBlockState var6 = var4.setBlockAt(position, blockState);
			if (var6 == null) {
				return false;
			} else {
				Block var7 = var6.getBlock();
				if (var5.n() != var7.n() || var5.p() != var7.p()) {
					this.B.a("checkLight");
					this.x(position);
					this.B.b();
				}

				if ((notifyType & 2) != 0 && (!this.isStatic || (notifyType & 4) == 0) && var4.i()) {
					this.notify(position);
				}

				if (!this.isStatic && (notifyType & 1) != 0) {
					this.b(position, var6.getBlock());
					if (var5.isComplexRedstone()) {
						this.e(position, var5);
					}
				}

				return true;
			}
		}
	}

	public boolean g(Position var1) {
		return this.setBlockAt(var1, Blocks.AIR.getBlockState(), 3);
	}

	public boolean b(Position var1, boolean var2) {
		IBlockState var3 = this.getBlockState(var1);
		Block var4 = var3.getBlock();
		if (var4.getMaterial() == Material.AIR) {
			return false;
		} else {
			this.triggerEffect(2001, var1, Block.getStateId(var3));
			if (var2) {
				var4.b(this, var1, var3, 0);
			}

			return this.setBlockAt(var1, Blocks.AIR.getBlockState(), 3);
		}
	}

	public boolean a(Position var1, IBlockState var2) {
		return this.setBlockAt(var1, var2, 3);
	}

	public void notify(Position var1) {
		for (int var2 = 0; var2 < this.u.size(); ++var2) {
			((IWorldAccess) this.u.get(var2)).a(var1);
		}

	}

	public void b(Position var1, Block var2) {
		if (this.worldData.getLevelType() != LevelType.DEBUG) {
			this.c(var1, var2);
		}

	}

	public void a(int var1, int var2, int var3, int var4) {
		int var5;
		if (var3 > var4) {
			var5 = var4;
			var4 = var3;
			var3 = var5;
		}

		if (!this.worldProvider.noSkyLight()) {
			for (var5 = var3; var5 <= var4; ++var5) {
				this.c(EnumSkyBlock.SKY, new Position(var1, var5, var2));
			}
		}

		this.b(var1, var3, var2, var1, var4, var2);
	}

	public void b(Position var1, Position var2) {
		this.b(var1.getX(), var1.getY(), var1.getZ(), var2.getX(), var2.getY(), var2.getZ());
	}

	public void b(int var1, int var2, int var3, int var4, int var5, int var6) {
		for (int var7 = 0; var7 < this.u.size(); ++var7) {
			((IWorldAccess) this.u.get(var7)).a(var1, var2, var3, var4, var5, var6);
		}

	}

	public void c(Position var1, Block var2) {
		this.d(var1.e(), var2);
		this.d(var1.f(), var2);
		this.d(var1.getDown(), var2);
		this.d(var1.getUp(), var2);
		this.d(var1.c(), var2);
		this.d(var1.d(), var2);
	}

	public void a(Position var1, Block var2, BlockFace var3) {
		if (var3 != BlockFace.WEST) {
			this.d(var1.e(), var2);
		}

		if (var3 != BlockFace.EAST) {
			this.d(var1.f(), var2);
		}

		if (var3 != BlockFace.DOWN) {
			this.d(var1.getDown(), var2);
		}

		if (var3 != BlockFace.UP) {
			this.d(var1.getUp(), var2);
		}

		if (var3 != BlockFace.NORTH) {
			this.d(var1.c(), var2);
		}

		if (var3 != BlockFace.SOUTH) {
			this.d(var1.d(), var2);
		}

	}

	public void d(Position var1, Block var2) {
		if (!this.isStatic) {
			IBlockState var3 = this.getBlockState(var1);

			try {
				var3.getBlock().a(this, var1, var3, var2);
			} catch (Throwable var7) {
				CrashReport var5 = CrashReport.generateCrashReport(var7, "Exception while updating neighbours");
				CrashReportSystemDetails var6 = var5.generateSystemDetails("Block being updated");
				var6.addDetails("Source block type", (Callable) (new aqw(this, var2)));
				net.minecraft.CrashReportSystemDetails.addBlockStateInfo(var6, var1, var3);
				throw new ReportedException(var5);
			}
		}
	}

	public boolean a(Position var1, Block var2) {
		return false;
	}

	public boolean i(Position var1) {
		return this.getChunk(var1).d(var1);
	}

	public boolean j(Position var1) {
		if (var1.getY() >= 63) {
			return this.i(var1);
		} else {
			Position var2 = new Position(var1.getX(), 63, var1.getZ());
			if (!this.i(var2)) {
				return false;
			} else {
				for (var2 = var2.getDown(); var2.getY() > var1.getY(); var2 = var2.getDown()) {
					Block var3 = this.getBlockState(var2).getBlock();
					if (var3.n() > 0 && !var3.getMaterial().isLiquid()) {
						return false;
					}
				}

				return true;
			}
		}
	}

	public int k(Position var1) {
		if (var1.getY() < 0) {
			return 0;
		} else {
			if (var1.getY() >= 256) {
				var1 = new Position(var1.getX(), 255, var1.getZ());
			}

			return this.getChunk(var1).a(var1, 0);
		}
	}

	public int l(Position var1) {
		return this.c(var1, true);
	}

	public int c(Position var1, boolean var2) {
		if (var1.getX() >= -30000000 && var1.getZ() >= -30000000 && var1.getX() < 30000000 && var1.getZ() < 30000000) {
			if (var2 && this.getBlockState(var1).getBlock().q()) {
				int var8 = this.c(var1.getUp(), false);
				int var4 = this.c(var1.f(), false);
				int var5 = this.c(var1.e(), false);
				int var6 = this.c(var1.d(), false);
				int var7 = this.c(var1.c(), false);
				if (var4 > var8) {
					var8 = var4;
				}

				if (var5 > var8) {
					var8 = var5;
				}

				if (var6 > var8) {
					var8 = var6;
				}

				if (var7 > var8) {
					var8 = var7;
				}

				return var8;
			} else if (var1.getY() < 0) {
				return 0;
			} else {
				if (var1.getY() >= 256) {
					var1 = new Position(var1.getX(), 255, var1.getZ());
				}

				Chunk var3 = this.getChunk(var1);
				return var3.a(var1, this.d);
			}
		} else {
			return 15;
		}
	}

	public Position m(Position var1) {
		int var2;
		if (var1.getX() >= -30000000 && var1.getZ() >= -30000000 && var1.getX() < 30000000 && var1.getZ() < 30000000) {
			if (this.a(var1.getX() >> 4, var1.getZ() >> 4, true)) {
				var2 = this.a(var1.getX() >> 4, var1.getZ() >> 4).b(var1.getX() & 15, var1.getZ() & 15);
			} else {
				var2 = 0;
			}
		} else {
			var2 = 64;
		}

		return new Position(var1.getX(), var2, var1.getZ());
	}

	public int b(int var1, int var2) {
		if (var1 >= -30000000 && var2 >= -30000000 && var1 < 30000000 && var2 < 30000000) {
			if (!this.a(var1 >> 4, var2 >> 4, true)) {
				return 0;
			} else {
				Chunk var3 = this.a(var1 >> 4, var2 >> 4);
				return var3.v();
			}
		} else {
			return 64;
		}
	}

	public int b(EnumSkyBlock var1, Position var2) {
		if (var2.getY() < 0) {
			var2 = new Position(var2.getX(), 0, var2.getZ());
		}

		if (!this.a(var2)) {
			return var1.lightLevel;
		} else if (!this.isLoaded(var2)) {
			return var1.lightLevel;
		} else {
			Chunk var3 = this.getChunk(var2);
			return var3.a(var1, var2);
		}
	}

	public void a(EnumSkyBlock var1, Position var2, int var3) {
		if (this.a(var2)) {
			if (this.isLoaded(var2)) {
				Chunk var4 = this.getChunk(var2);
				var4.a(var1, var2, var3);
				this.n(var2);
			}
		}
	}

	public void n(Position var1) {
		for (int var2 = 0; var2 < this.u.size(); ++var2) {
			((IWorldAccess) this.u.get(var2)).b(var1);
		}

	}

	public float o(Position var1) {
		return this.worldProvider.p()[this.l(var1)];
	}

	public IBlockState getBlockState(Position position) {
		if (!this.a(position)) {
			return Blocks.AIR.getBlockState();
		} else {
			Chunk chunk = this.getChunk(position);
			return chunk.getBlockState(position);
		}
	}

	public boolean w() {
		return this.d < 4;
	}

	public MovingObjectPosition a(Vec3D var1, Vec3D var2) {
		return this.a(var1, var2, false, false, false);
	}

	public MovingObjectPosition a(Vec3D var1, Vec3D var2, boolean var3) {
		return this.a(var1, var2, var3, false, false);
	}

	public MovingObjectPosition a(Vec3D var1, Vec3D var2, boolean var3, boolean var4, boolean var5) {
		if (!Double.isNaN(var1.x) && !Double.isNaN(var1.y) && !Double.isNaN(var1.z)) {
			if (!Double.isNaN(var2.x) && !Double.isNaN(var2.y) && !Double.isNaN(var2.z)) {
				int var6 = MathHelper.toFixedPointInt(var2.x);
				int var7 = MathHelper.toFixedPointInt(var2.y);
				int var8 = MathHelper.toFixedPointInt(var2.z);
				int var9 = MathHelper.toFixedPointInt(var1.x);
				int var10 = MathHelper.toFixedPointInt(var1.y);
				int var11 = MathHelper.toFixedPointInt(var1.z);
				Position var12 = new Position(var9, var10, var11);
				new Position(var6, var7, var8);
				IBlockState var14 = this.getBlockState(var12);
				Block var15 = var14.getBlock();
				if ((!var4 || var15.a(this, var12, var14) != null) && var15.a(var14, var3)) {
					MovingObjectPosition var16 = var15.a(this, var12, var1, var2);
					if (var16 != null) {
						return var16;
					}
				}

				MovingObjectPosition var41 = null;
				int var42 = 200;

				while (var42-- >= 0) {
					if (Double.isNaN(var1.x) || Double.isNaN(var1.y) || Double.isNaN(var1.z)) {
						return null;
					}

					if (var9 == var6 && var10 == var7 && var11 == var8) {
						return var5 ? var41 : null;
					}

					boolean var43 = true;
					boolean var17 = true;
					boolean var18 = true;
					double var19 = 999.0D;
					double var21 = 999.0D;
					double var23 = 999.0D;
					if (var6 > var9) {
						var19 = (double) var9 + 1.0D;
					} else if (var6 < var9) {
						var19 = (double) var9 + 0.0D;
					} else {
						var43 = false;
					}

					if (var7 > var10) {
						var21 = (double) var10 + 1.0D;
					} else if (var7 < var10) {
						var21 = (double) var10 + 0.0D;
					} else {
						var17 = false;
					}

					if (var8 > var11) {
						var23 = (double) var11 + 1.0D;
					} else if (var8 < var11) {
						var23 = (double) var11 + 0.0D;
					} else {
						var18 = false;
					}

					double var25 = 999.0D;
					double var27 = 999.0D;
					double var29 = 999.0D;
					double var31 = var2.x - var1.x;
					double var33 = var2.y - var1.y;
					double var35 = var2.z - var1.z;
					if (var43) {
						var25 = (var19 - var1.x) / var31;
					}

					if (var17) {
						var27 = (var21 - var1.y) / var33;
					}

					if (var18) {
						var29 = (var23 - var1.z) / var35;
					}

					if (var25 == -0.0D) {
						var25 = -1.0E-4D;
					}

					if (var27 == -0.0D) {
						var27 = -1.0E-4D;
					}

					if (var29 == -0.0D) {
						var29 = -1.0E-4D;
					}

					BlockFace var37;
					if (var25 < var27 && var25 < var29) {
						var37 = var6 > var9 ? BlockFace.WEST : BlockFace.EAST;
						var1 = new Vec3D(var19, var1.y + var33 * var25, var1.z + var35 * var25);
					} else if (var27 < var29) {
						var37 = var7 > var10 ? BlockFace.DOWN : BlockFace.UP;
						var1 = new Vec3D(var1.x + var31 * var27, var21, var1.z + var35 * var27);
					} else {
						var37 = var8 > var11 ? BlockFace.NORTH : BlockFace.SOUTH;
						var1 = new Vec3D(var1.x + var31 * var29, var1.y + var33 * var29, var23);
					}

					var9 = MathHelper.toFixedPointInt(var1.x) - (var37 == BlockFace.EAST ? 1 : 0);
					var10 = MathHelper.toFixedPointInt(var1.y) - (var37 == BlockFace.UP ? 1 : 0);
					var11 = MathHelper.toFixedPointInt(var1.z) - (var37 == BlockFace.SOUTH ? 1 : 0);
					var12 = new Position(var9, var10, var11);
					IBlockState var38 = this.getBlockState(var12);
					Block var39 = var38.getBlock();
					if (!var4 || var39.a(this, var12, var38) != null) {
						if (var39.a(var38, var3)) {
							MovingObjectPosition var40 = var39.a(this, var12, var1, var2);
							if (var40 != null) {
								return var40;
							}
						} else {
							var41 = new MovingObjectPosition(EnumMovingObjectType.MISS, var1, var37, var12);
						}
					}
				}

				return var5 ? var41 : null;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	public void a(Entity var1, String var2, float var3, float var4) {
		for (int var5 = 0; var5 < this.u.size(); ++var5) {
			((IWorldAccess) this.u.get(var5)).a(var2, var1.locationX, var1.locationY, var1.locationZ, var3, var4);
		}

	}

	public void a(EntityHuman var1, String var2, float var3, float var4) {
		for (int var5 = 0; var5 < this.u.size(); ++var5) {
			((IWorldAccess) this.u.get(var5)).a(var1, var2, var1.locationX, var1.locationY, var1.locationZ, var3, var4);
		}

	}

	public void makeSound(double var1, double var3, double var5, String var7, float var8, float var9) {
		for (int var10 = 0; var10 < this.u.size(); ++var10) {
			((IWorldAccess) this.u.get(var10)).a(var7, var1, var3, var5, var8, var9);
		}

	}

	public void a(double var1, double var3, double var5, String var7, float var8, float var9, boolean var10) {
	}

	public void a(Position var1, String var2) {
		for (int var3 = 0; var3 < this.u.size(); ++var3) {
			((IWorldAccess) this.u.get(var3)).a(var2, var1);
		}

	}

	public void addParticle(Particle var1, double var2, double var4, double var6, double var8, double var10, double var12, int... var14) {
		this.a(var1.c(), var1.e(), var2, var4, var6, var8, var10, var12, var14);
	}

	private void a(int var1, boolean var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
		for (int var16 = 0; var16 < this.u.size(); ++var16) {
			((IWorldAccess) this.u.get(var16)).a(var1, var2, var3, var5, var7, var9, var11, var13, var15);
		}

	}

	public boolean c(Entity var1) {
		this.k.add(var1);
		return true;
	}

	public boolean addEntity(Entity var1) {
		int var2 = MathHelper.toFixedPointInt(var1.locationX / 16.0D);
		int var3 = MathHelper.toFixedPointInt(var1.locationZ / 16.0D);
		boolean var4 = var1.n;
		if (var1 instanceof EntityHuman) {
			var4 = true;
		}

		if (!var4 && !this.a(var2, var3, true)) {
			return false;
		} else {
			if (var1 instanceof EntityHuman) {
				EntityHuman var5 = (EntityHuman) var1;
				this.j.add(var5);
				this.d();
			}

			this.a(var2, var3).addEntity(var1);
			this.f.add(var1);
			this.a(var1);
			return true;
		}
	}

	protected void a(Entity entity) {
		for (int var2 = 0; var2 < this.u.size(); ++var2) {
			((IWorldAccess) this.u.get(var2)).a(entity);
		}
		entity.valid = true;
	}

	protected void b(Entity entity) {
		for (int var2 = 0; var2 < this.u.size(); ++var2) {
			((IWorldAccess) this.u.get(var2)).b(entity);
		}
		entity.valid = false;
	}

	public void e(Entity var1) {
		if (var1.passenger != null) {
			var1.passenger.mount((Entity) null);
		}

		if (var1.vehicle != null) {
			var1.mount((Entity) null);
		}

		var1.die();
		if (var1 instanceof EntityHuman) {
			this.j.remove(var1);
			this.d();
			this.b(var1);
		}

	}

	public void f(Entity var1) {
		var1.die();
		if (var1 instanceof EntityHuman) {
			this.j.remove(var1);
			this.d();
		}

		int var2 = var1.ae;
		int var3 = var1.ag;
		if (var1.ad && this.a(var2, var3, true)) {
			this.a(var2, var3).b(var1);
		}

		this.f.remove(var1);
		this.b(var1);
	}

	public void addIWorldAccess(IWorldAccess var1) {
		this.u.add(var1);
	}

	public List getCubes(Entity var1, AxisAlignedBB var2) {
		ArrayList var3 = Lists.newArrayList();
		int var4 = MathHelper.toFixedPointInt(var2.minX);
		int var5 = MathHelper.toFixedPointInt(var2.maxX + 1.0D);
		int var6 = MathHelper.toFixedPointInt(var2.minY);
		int var7 = MathHelper.toFixedPointInt(var2.maxY + 1.0D);
		int var8 = MathHelper.toFixedPointInt(var2.minZ);
		int var9 = MathHelper.toFixedPointInt(var2.maxZ + 1.0D);

		for (int var10 = var4; var10 < var5; ++var10) {
			for (int var11 = var8; var11 < var9; ++var11) {
				if (this.isLoaded(new Position(var10, 64, var11))) {
					for (int var12 = var6 - 1; var12 < var7; ++var12) {
						Position var13 = new Position(var10, var12, var11);
						boolean var14 = var1.aS();
						boolean var15 = this.a(this.getWorldBorder(), var1);
						if (var14 && var15) {
							var1.h(false);
						} else if (!var14 && !var15) {
							var1.h(true);
						}

						IBlockState var16;
						if (!this.getWorldBorder().isInside(var13) && var15) {
							var16 = Blocks.STONE.getBlockState();
						} else {
							var16 = this.getBlockState(var13);
						}

						var16.getBlock().a(this, var13, var16, var2, var3, var1);
					}
				}
			}
		}

		double var17 = 0.25D;
		List var18 = this.getEntities(var1, var2.grow(var17, var17, var17));

		for (int var19 = 0; var19 < var18.size(); ++var19) {
			if (var1.passenger != var18 && var1.vehicle != var18) {
				AxisAlignedBB var20 = ((Entity) var18.get(var19)).S();
				if (var20 != null && var20.b(var2)) {
					var3.add(var20);
				}

				var20 = var1.j((Entity) var18.get(var19));
				if (var20 != null && var20.b(var2)) {
					var3.add(var20);
				}
			}
		}

		return var3;
	}

	public boolean a(WorldBorder var1, Entity var2) {
		double var3 = var1.getMinX();
		double var5 = var1.getMinZ();
		double var7 = var1.getMaxX();
		double var9 = var1.getMaxZ();
		if (var2.aS()) {
			++var3;
			++var5;
			--var7;
			--var9;
		} else {
			--var3;
			--var5;
			++var7;
			++var9;
		}

		return var2.locationX > var3 && var2.locationX < var7 && var2.locationZ > var5 && var2.locationZ < var9;
	}

	public List a(AxisAlignedBB var1) {
		ArrayList var2 = Lists.newArrayList();
		int var3 = MathHelper.toFixedPointInt(var1.minX);
		int var4 = MathHelper.toFixedPointInt(var1.maxX + 1.0D);
		int var5 = MathHelper.toFixedPointInt(var1.minY);
		int var6 = MathHelper.toFixedPointInt(var1.maxY + 1.0D);
		int var7 = MathHelper.toFixedPointInt(var1.minZ);
		int var8 = MathHelper.toFixedPointInt(var1.maxZ + 1.0D);

		for (int var9 = var3; var9 < var4; ++var9) {
			for (int var10 = var7; var10 < var8; ++var10) {
				if (this.isLoaded(new Position(var9, 64, var10))) {
					for (int var11 = var5 - 1; var11 < var6; ++var11) {
						Position var13 = new Position(var9, var11, var10);
						IBlockState var12;
						if (var9 >= -30000000 && var9 < 30000000 && var10 >= -30000000 && var10 < 30000000) {
							var12 = this.getBlockState(var13);
						} else {
							var12 = Blocks.BEDROCK.getBlockState();
						}

						var12.getBlock().a(this, var13, var12, var1, var2, (Entity) null);
					}
				}
			}
		}

		return var2;
	}

	public int a(float var1) {
		float var2 = this.c(var1);
		float var3 = 1.0F - (MathHelper.b(var2 * 3.1415927F * 2.0F) * 2.0F + 0.5F);
		var3 = MathHelper.a(var3, 0.0F, 1.0F);
		var3 = 1.0F - var3;
		var3 = (float) ((double) var3 * (1.0D - (double) (this.j(var1) * 5.0F) / 16.0D));
		var3 = (float) ((double) var3 * (1.0D - (double) (this.h(var1) * 5.0F) / 16.0D));
		var3 = 1.0F - var3;
		return (int) (var3 * 11.0F);
	}

	public float c(float var1) {
		return this.worldProvider.a(this.worldData.getDayTime(), var1);
	}

	public float y() {
		return WorldProvider.a[this.worldProvider.a(this.worldData.getDayTime())];
	}

	public float d(float var1) {
		float var2 = this.c(var1);
		return var2 * 3.1415927F * 2.0F;
	}

	public Position q(Position var1) {
		return this.getChunk(var1).h(var1);
	}

	public Position r(Position var1) {
		Chunk var2 = this.getChunk(var1);

		Position var3;
		Position var4;
		for (var3 = new Position(var1.getX(), var2.g() + 16, var1.getZ()); var3.getY() >= 0; var3 = var4) {
			var4 = var3.getDown();
			Material var5 = var2.getBlockAtWorldCoords(var4).getMaterial();
			if (var5.isSolid() && var5 != Material.LEAVES) {
				break;
			}
		}

		return var3;
	}

	public void a(Position var1, Block var2, int var3) {
	}

	public void a(Position var1, Block var2, int var3, int var4) {
	}

	public void addNextTickEntry(Position var1, Block var2, int var3, int var4) {
	}

	public void i() {
		this.B.a("entities");
		this.B.a("global");

		int var1;
		Entity var2;
		CrashReport var4;
		CrashReportSystemDetails var5;
		for (var1 = 0; var1 < this.k.size(); ++var1) {
			var2 = (Entity) this.k.get(var1);

			try {
				++var2.ticksLived;
				var2.s_();
			} catch (Throwable var9) {
				var4 = CrashReport.generateCrashReport(var9, "Ticking entity");
				var5 = var4.generateSystemDetails("Entity being ticked");
				if (var2 == null) {
					var5.addDetails("Entity", (Object) "~~NULL~~");
				} else {
					var2.a(var5);
				}

				throw new ReportedException(var4);
			}

			if (var2.dead) {
				this.k.remove(var1--);
			}
		}

		this.B.c("remove");
		this.f.removeAll(this.g);

		int var3;
		int var15;
		for (var1 = 0; var1 < this.g.size(); ++var1) {
			var2 = (Entity) this.g.get(var1);
			var3 = var2.ae;
			var15 = var2.ag;
			if (var2.ad && this.a(var3, var15, true)) {
				this.a(var3, var15).b(var2);
			}
		}

		for (var1 = 0; var1 < this.g.size(); ++var1) {
			this.b((Entity) this.g.get(var1));
		}

		this.g.clear();
		this.B.c("regular");

		for (var1 = 0; var1 < this.f.size(); ++var1) {
			var2 = (Entity) this.f.get(var1);
			if (var2.vehicle != null) {
				if (!var2.vehicle.dead && var2.vehicle.passenger == var2) {
					continue;
				}

				var2.vehicle.passenger = null;
				var2.vehicle = null;
			}

			this.B.a("tick");
			if (!var2.dead) {
				try {
					this.playerJoinedWorld(var2);
				} catch (Throwable var8) {
					var4 = CrashReport.generateCrashReport(var8, "Ticking entity");
					var5 = var4.generateSystemDetails("Entity being ticked");
					var2.a(var5);
					throw new ReportedException(var4);
				}
			}

			this.B.b();
			this.B.a("remove");
			if (var2.dead) {
				var3 = var2.ae;
				var15 = var2.ag;
				if (var2.ad && this.a(var3, var15, true)) {
					this.a(var3, var15).b(var2);
				}

				this.f.remove(var1--);
				this.b(var2);
			}

			this.B.b();
		}

		this.B.c("blockEntities");
		this.L = true;
		Iterator var10 = this.i.iterator();

		while (var10.hasNext()) {
			TileEntity var11 = (TileEntity) var10.next();
			if (!var11.isInvalid() && var11.hasWorld()) {
				Position var13 = var11.getPosition();
				if (this.isLoaded(var13) && this.worldborder.isInside(var13)) {
					try {
						((ITickable) var11).doTick();
					} catch (Throwable var7) {
						CrashReport var16 = CrashReport.generateCrashReport(var7, "Ticking block entity");
						CrashReportSystemDetails var6 = var16.generateSystemDetails("Block entity being ticked");
						var11.addCrashReportDetails(var6);
						throw new ReportedException(var16);
					}
				}
			}

			if (var11.isInvalid()) {
				var10.remove();
				this.h.remove(var11);
				if (this.isLoaded(var11.getPosition())) {
					this.getChunk(var11.getPosition()).e(var11.getPosition());
				}
			}
		}

		this.L = false;
		if (!this.b.isEmpty()) {
			this.i.removeAll(this.b);
			this.h.removeAll(this.b);
			this.b.clear();
		}

		this.B.c("pendingBlockEntities");
		if (!this.a.isEmpty()) {
			for (int var12 = 0; var12 < this.a.size(); ++var12) {
				TileEntity var14 = (TileEntity) this.a.get(var12);
				if (!var14.isInvalid()) {
					if (!this.h.contains(var14)) {
						this.a(var14);
					}

					if (this.isLoaded(var14.getPosition())) {
						this.getChunk(var14.getPosition()).a(var14.getPosition(), var14);
					}

					this.notify(var14.getPosition());
				}
			}

			this.a.clear();
		}

		this.B.b();
		this.B.b();
	}

	public boolean a(TileEntity var1) {
		boolean var2 = this.h.add(var1);
		if (var2 && var1 instanceof ITickable) {
			this.i.add(var1);
		}

		return var2;
	}

	public void a(Collection var1) {
		if (this.L) {
			this.a.addAll(var1);
		} else {
			Iterator var2 = var1.iterator();

			while (var2.hasNext()) {
				TileEntity var3 = (TileEntity) var2.next();
				this.h.add(var3);
				if (var3 instanceof ITickable) {
					this.i.add(var3);
				}
			}
		}

	}

	public void playerJoinedWorld(Entity var1) {
		this.a(var1, true);
	}

	public void a(Entity var1, boolean var2) {
		int var3 = MathHelper.toFixedPointInt(var1.locationX);
		int var4 = MathHelper.toFixedPointInt(var1.locationZ);
		byte var5 = 32;
		if (!var2 || this.a(var3 - var5, 0, var4 - var5, var3 + var5, 0, var4 + var5, true)) {
			var1.P = var1.locationX;
			var1.Q = var1.locationY;
			var1.R = var1.locationZ;
			var1.lastYaw = var1.yaw;
			var1.lastPitch = var1.pitch;
			if (var2 && var1.ad) {
				++var1.ticksLived;
				if (var1.vehicle != null) {
					var1.ak();
				} else {
					var1.s_();
				}
			}

			this.B.a("chunkCheck");
			if (Double.isNaN(var1.locationX) || Double.isInfinite(var1.locationX)) {
				var1.locationX = var1.P;
			}

			if (Double.isNaN(var1.locationY) || Double.isInfinite(var1.locationY)) {
				var1.locationY = var1.Q;
			}

			if (Double.isNaN(var1.locationZ) || Double.isInfinite(var1.locationZ)) {
				var1.locationZ = var1.R;
			}

			if (Double.isNaN((double) var1.pitch) || Double.isInfinite((double) var1.pitch)) {
				var1.pitch = var1.lastPitch;
			}

			if (Double.isNaN((double) var1.yaw) || Double.isInfinite((double) var1.yaw)) {
				var1.yaw = var1.lastYaw;
			}

			int var6 = MathHelper.toFixedPointInt(var1.locationX / 16.0D);
			int var7 = MathHelper.toFixedPointInt(var1.locationY / 16.0D);
			int var8 = MathHelper.toFixedPointInt(var1.locationZ / 16.0D);
			if (!var1.ad || var1.ae != var6 || var1.af != var7 || var1.ag != var8) {
				if (var1.ad && this.a(var1.ae, var1.ag, true)) {
					this.a(var1.ae, var1.ag).a(var1, var1.af);
				}

				if (this.a(var6, var8, true)) {
					var1.ad = true;
					this.a(var6, var8).addEntity(var1);
				} else {
					var1.ad = false;
				}
			}

			this.B.b();
			if (var2 && var1.ad && var1.passenger != null) {
				if (!var1.passenger.dead && var1.passenger.vehicle == var1) {
					this.playerJoinedWorld(var1.passenger);
				} else {
					var1.passenger.vehicle = null;
					var1.passenger = null;
				}
			}

		}
	}

	public boolean b(AxisAlignedBB var1) {
		return this.a(var1, (Entity) null);
	}

	public boolean a(AxisAlignedBB var1, Entity var2) {
		List var3 = this.getEntities((Entity) null, var1);

		for (int var4 = 0; var4 < var3.size(); ++var4) {
			Entity var5 = (Entity) var3.get(var4);
			if (!var5.dead && var5.k && var5 != var2 && (var2 == null || var2.vehicle != var5 && var2.passenger != var5)) {
				return false;
			}
		}

		return true;
	}

	public boolean isOnGround(AxisAlignedBB var1) {
		int var2 = MathHelper.toFixedPointInt(var1.minX);
		int var3 = MathHelper.toFixedPointInt(var1.maxX);
		int var4 = MathHelper.toFixedPointInt(var1.minY);
		int var5 = MathHelper.toFixedPointInt(var1.maxY);
		int var6 = MathHelper.toFixedPointInt(var1.minZ);
		int var7 = MathHelper.toFixedPointInt(var1.maxZ);

		for (int var8 = var2; var8 <= var3; ++var8) {
			for (int var9 = var4; var9 <= var5; ++var9) {
				for (int var10 = var6; var10 <= var7; ++var10) {
					Block var11 = this.getBlockState(new Position(var8, var9, var10)).getBlock();
					if (var11.getMaterial() != Material.AIR) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public boolean d(AxisAlignedBB var1) {
		int var2 = MathHelper.toFixedPointInt(var1.minX);
		int var3 = MathHelper.toFixedPointInt(var1.maxX);
		int var4 = MathHelper.toFixedPointInt(var1.minY);
		int var5 = MathHelper.toFixedPointInt(var1.maxY);
		int var6 = MathHelper.toFixedPointInt(var1.minZ);
		int var7 = MathHelper.toFixedPointInt(var1.maxZ);

		for (int var8 = var2; var8 <= var3; ++var8) {
			for (int var9 = var4; var9 <= var5; ++var9) {
				for (int var10 = var6; var10 <= var7; ++var10) {
					Block var11 = this.getBlockState(new Position(var8, var9, var10)).getBlock();
					if (var11.getMaterial().isLiquid()) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public boolean e(AxisAlignedBB var1) {
		int var2 = MathHelper.toFixedPointInt(var1.minX);
		int var3 = MathHelper.toFixedPointInt(var1.maxX + 1.0D);
		int var4 = MathHelper.toFixedPointInt(var1.minY);
		int var5 = MathHelper.toFixedPointInt(var1.maxY + 1.0D);
		int var6 = MathHelper.toFixedPointInt(var1.minZ);
		int var7 = MathHelper.toFixedPointInt(var1.maxZ + 1.0D);
		if (this.a(var2, var4, var6, var3, var5, var7, true)) {
			for (int var8 = var2; var8 < var3; ++var8) {
				for (int var9 = var4; var9 < var5; ++var9) {
					for (int var10 = var6; var10 < var7; ++var10) {
						Block var11 = this.getBlockState(new Position(var8, var9, var10)).getBlock();
						if (var11 == Blocks.FIRE || var11 == Blocks.FLOWING_LAVA || var11 == Blocks.LAVA) {
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	public boolean a(AxisAlignedBB var1, Material var2, Entity var3) {
		int var4 = MathHelper.toFixedPointInt(var1.minX);
		int var5 = MathHelper.toFixedPointInt(var1.maxX + 1.0D);
		int var6 = MathHelper.toFixedPointInt(var1.minY);
		int var7 = MathHelper.toFixedPointInt(var1.maxY + 1.0D);
		int var8 = MathHelper.toFixedPointInt(var1.minZ);
		int var9 = MathHelper.toFixedPointInt(var1.maxZ + 1.0D);
		if (!this.a(var4, var6, var8, var5, var7, var9, true)) {
			return false;
		} else {
			boolean var10 = false;
			Vec3D var11 = new Vec3D(0.0D, 0.0D, 0.0D);

			for (int var12 = var4; var12 < var5; ++var12) {
				for (int var13 = var6; var13 < var7; ++var13) {
					for (int var14 = var8; var14 < var9; ++var14) {
						Position var15 = new Position(var12, var13, var14);
						IBlockState var16 = this.getBlockState(var15);
						Block var17 = var16.getBlock();
						if (var17.getMaterial() == var2) {
							double var18 = (double) ((float) (var13 + 1) - axl.b(((Integer) var16.b(axl.b)).intValue()));
							if ((double) var7 >= var18) {
								var10 = true;
								var11 = var17.a(this, var15, var3, var11);
							}
						}
					}
				}
			}

			if (var11.b() > 0.0D && var3.aK()) {
				var11 = var11.a();
				double var20 = 0.014D;
				var3.motionX += var11.x * var20;
				var3.motionY += var11.y * var20;
				var3.motionZ += var11.z * var20;
			}

			return var10;
		}
	}

	public boolean a(AxisAlignedBB var1, Material var2) {
		int var3 = MathHelper.toFixedPointInt(var1.minX);
		int var4 = MathHelper.toFixedPointInt(var1.maxX + 1.0D);
		int var5 = MathHelper.toFixedPointInt(var1.minY);
		int var6 = MathHelper.toFixedPointInt(var1.maxY + 1.0D);
		int var7 = MathHelper.toFixedPointInt(var1.minZ);
		int var8 = MathHelper.toFixedPointInt(var1.maxZ + 1.0D);

		for (int var9 = var3; var9 < var4; ++var9) {
			for (int var10 = var5; var10 < var6; ++var10) {
				for (int var11 = var7; var11 < var8; ++var11) {
					if (this.getBlockState(new Position(var9, var10, var11)).getBlock().getMaterial() == var2) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public boolean b(AxisAlignedBB var1, Material var2) {
		int var3 = MathHelper.toFixedPointInt(var1.minX);
		int var4 = MathHelper.toFixedPointInt(var1.maxX + 1.0D);
		int var5 = MathHelper.toFixedPointInt(var1.minY);
		int var6 = MathHelper.toFixedPointInt(var1.maxY + 1.0D);
		int var7 = MathHelper.toFixedPointInt(var1.minZ);
		int var8 = MathHelper.toFixedPointInt(var1.maxZ + 1.0D);

		for (int var9 = var3; var9 < var4; ++var9) {
			for (int var10 = var5; var10 < var6; ++var10) {
				for (int var11 = var7; var11 < var8; ++var11) {
					Position var12 = new Position(var9, var10, var11);
					IBlockState var13 = this.getBlockState(var12);
					Block var14 = var13.getBlock();
					if (var14.getMaterial() == var2) {
						int var15 = ((Integer) var13.b(axl.b)).intValue();
						double var16 = (double) (var10 + 1);
						if (var15 < 8) {
							var16 = (double) (var10 + 1) - (double) var15 / 8.0D;
						}

						if (var16 >= var1.minY) {
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	public Explosion a(Entity var1, double var2, double var4, double var6, float var8, boolean var9) {
		return this.a(var1, var2, var4, var6, var8, false, var9);
	}

	public Explosion a(Entity var1, double var2, double var4, double var6, float var8, boolean var9, boolean var10) {
		Explosion var11 = new Explosion(this, var1, var2, var4, var6, var8, var9, var10);
		var11.a();
		var11.a(true);
		return var11;
	}

	public float a(Vec3D var1, AxisAlignedBB var2) {
		double var3 = 1.0D / ((var2.maxX - var2.minX) * 2.0D + 1.0D);
		double var5 = 1.0D / ((var2.maxY - var2.minY) * 2.0D + 1.0D);
		double var7 = 1.0D / ((var2.maxZ - var2.minZ) * 2.0D + 1.0D);
		if (var3 >= 0.0D && var5 >= 0.0D && var7 >= 0.0D) {
			int var9 = 0;
			int var10 = 0;

			for (float var11 = 0.0F; var11 <= 1.0F; var11 = (float) ((double) var11 + var3)) {
				for (float var12 = 0.0F; var12 <= 1.0F; var12 = (float) ((double) var12 + var5)) {
					for (float var13 = 0.0F; var13 <= 1.0F; var13 = (float) ((double) var13 + var7)) {
						double var14 = var2.minX + (var2.maxX - var2.minX) * (double) var11;
						double var16 = var2.minY + (var2.maxY - var2.minY) * (double) var12;
						double var18 = var2.minZ + (var2.maxZ - var2.minZ) * (double) var13;
						if (this.a(new Vec3D(var14, var16, var18), var1) == null) {
							++var9;
						}

						++var10;
					}
				}
			}

			return (float) var9 / (float) var10;
		} else {
			return 0.0F;
		}
	}

	public boolean a(EntityHuman var1, Position var2, BlockFace var3) {
		var2 = var2.getRelative(var3);
		if (this.getBlockState(var2).getBlock() == Blocks.FIRE) {
			this.a(var1, 1004, var2, 0);
			this.g(var2);
			return true;
		} else {
			return false;
		}
	}

	public TileEntity getTileEntity(Position var1) {
		if (!this.a(var1)) {
			return null;
		} else {
			TileEntity var2 = null;
			int var3;
			TileEntity var4;
			if (this.L) {
				for (var3 = 0; var3 < this.a.size(); ++var3) {
					var4 = (TileEntity) this.a.get(var3);
					if (!var4.isInvalid() && var4.getPosition().equals(var1)) {
						var2 = var4;
						break;
					}
				}
			}

			if (var2 == null) {
				var2 = this.getChunk(var1).a(var1, bfl.a);
			}

			if (var2 == null) {
				for (var3 = 0; var3 < this.a.size(); ++var3) {
					var4 = (TileEntity) this.a.get(var3);
					if (!var4.isInvalid() && var4.getPosition().equals(var1)) {
						var2 = var4;
						break;
					}
				}
			}

			return var2;
		}
	}

	public void a(Position var1, TileEntity var2) {
		if (var2 != null && !var2.isInvalid()) {
			if (this.L) {
				var2.setPosition(var1);
				Iterator var3 = this.a.iterator();

				while (var3.hasNext()) {
					TileEntity var4 = (TileEntity) var3.next();
					if (var4.getPosition().equals(var1)) {
						var4.setValid();
						var3.remove();
					}
				}

				this.a.add(var2);
			} else {
				this.a(var2);
				this.getChunk(var1).a(var1, var2);
			}
		}

	}

	public void t(Position var1) {
		TileEntity var2 = this.getTileEntity(var1);
		if (var2 != null && this.L) {
			var2.setValid();
			this.a.remove(var2);
		} else {
			if (var2 != null) {
				this.a.remove(var2);
				this.h.remove(var2);
				this.i.remove(var2);
			}

			this.getChunk(var1).e(var1);
		}

	}

	public void b(TileEntity var1) {
		this.b.add(var1);
	}

	public boolean u(Position var1) {
		IBlockState var2 = this.getBlockState(var1);
		AxisAlignedBB var3 = var2.getBlock().a(this, var1, var2);
		return var3 != null && var3.a() >= 1.0D;
	}

	public static boolean a(ard var0, Position var1) {
		IBlockState var2 = var0.getBlockState(var1);
		Block var3 = var2.getBlock();
		return var3.getMaterial().k() && var3.d() ? true : (var3 instanceof BlockStairs ? var2.b(BlockStairs.b) == bau.a : (var3 instanceof BlockStepAbstract ? var2.b(BlockStepAbstract.a) == awr.a : (var3 instanceof BlockHopper ? true : (var3 instanceof BlockSnow ? ((Integer) var2.b(BlockSnow.a)).intValue() == 7 : false))));
	}

	public boolean d(Position var1, boolean var2) {
		if (!this.a(var1)) {
			return var2;
		} else {
			Chunk var3 = this.chunkProvider.getChunkAtWorldCoords(var1);
			if (var3.f()) {
				return var2;
			} else {
				Block var4 = this.getBlockState(var1).getBlock();
				return var4.getMaterial().k() && var4.d();
			}
		}
	}

	public void B() {
		int var1 = this.a(1.0F);
		if (var1 != this.d) {
			this.d = var1;
		}

	}

	public void a(boolean var1, boolean var2) {
		this.F = var1;
		this.G = var2;
	}

	public void doTick() {
		this.p();
	}

	protected void C() {
		if (this.worldData.isRaining()) {
			this.p = 1.0F;
			if (this.worldData.isThundering()) {
				this.r = 1.0F;
			}
		}

	}

	protected void p() {
		if (!this.worldProvider.noSkyLight()) {
			if (!this.isStatic) {
				int var1 = this.worldData.getClearWeatherTime();
				if (var1 > 0) {
					--var1;
					this.worldData.setClearWeatherTime(var1);
					this.worldData.setThunderTime(this.worldData.isThundering() ? 1 : 2);
					this.worldData.setRainTime(this.worldData.isRaining() ? 1 : 2);
				}

				int var2 = this.worldData.getThunderTime();
				if (var2 <= 0) {
					if (this.worldData.isThundering()) {
						this.worldData.setThunderTime(this.random.nextInt(12000) + 3600);
					} else {
						this.worldData.setThunderTime(this.random.nextInt(168000) + 12000);
					}
				} else {
					--var2;
					this.worldData.setThunderTime(var2);
					if (var2 <= 0) {
						this.worldData.setThundering(!this.worldData.isThundering());
					}
				}

				this.q = this.r;
				if (this.worldData.isThundering()) {
					this.r = (float) ((double) this.r + 0.01D);
				} else {
					this.r = (float) ((double) this.r - 0.01D);
				}

				this.r = MathHelper.a(this.r, 0.0F, 1.0F);
				int var3 = this.worldData.getRainTime();
				if (var3 <= 0) {
					if (this.worldData.isRaining()) {
						this.worldData.setRainTime(this.random.nextInt(12000) + 12000);
					} else {
						this.worldData.setRainTime(this.random.nextInt(168000) + 12000);
					}
				} else {
					--var3;
					this.worldData.setRainTime(var3);
					if (var3 <= 0) {
						this.worldData.setRaining(!this.worldData.isRaining());
					}
				}

				this.o = this.p;
				if (this.worldData.isRaining()) {
					this.p = (float) ((double) this.p + 0.01D);
				} else {
					this.p = (float) ((double) this.p - 0.01D);
				}

				this.p = MathHelper.a(this.p, 0.0F, 1.0F);
			}
		}
	}

	protected void D() {
		this.E.clear();
		this.B.a("buildList");

		int var1;
		EntityHuman var2;
		int var3;
		int var4;
		int var5;
		for (var1 = 0; var1 < this.j.size(); ++var1) {
			var2 = (EntityHuman) this.j.get(var1);
			var3 = MathHelper.toFixedPointInt(var2.locationX / 16.0D);
			var4 = MathHelper.toFixedPointInt(var2.locationZ / 16.0D);
			var5 = this.q();

			for (int var6 = -var5; var6 <= var5; ++var6) {
				for (int var7 = -var5; var7 <= var5; ++var7) {
					this.E.add(new ChunkCoordIntPair(var6 + var3, var7 + var4));
				}
			}
		}

		this.B.b();
		if (this.K > 0) {
			--this.K;
		}

		this.B.a("playerCheckLight");
		if (!this.j.isEmpty()) {
			var1 = this.random.nextInt(this.j.size());
			var2 = (EntityHuman) this.j.get(var1);
			var3 = MathHelper.toFixedPointInt(var2.locationX) + this.random.nextInt(11) - 5;
			var4 = MathHelper.toFixedPointInt(var2.locationY) + this.random.nextInt(11) - 5;
			var5 = MathHelper.toFixedPointInt(var2.locationZ) + this.random.nextInt(11) - 5;
			this.x(new Position(var3, var4, var5));
		}

		this.B.b();
	}

	protected abstract int q();

	protected void a(int var1, int var2, Chunk var3) {
		this.B.c("moodSound");
		if (this.K == 0 && !this.isStatic) {
			this.m = this.m * 3 + 1013904223;
			int var4 = this.m >> 2;
			int var5 = var4 & 15;
			int var6 = var4 >> 8 & 15;
			int var7 = var4 >> 16 & 255;
			Position var8 = new Position(var5, var7, var6);
			Block var9 = var3.getBlockAtWorldCoords(var8);
			var5 += var1;
			var6 += var2;
			if (var9.getMaterial() == Material.AIR && this.k(var8) <= this.random.nextInt(8) && this.b(EnumSkyBlock.SKY, var8) <= 0) {
				EntityHuman var10 = this.a((double) var5 + 0.5D, (double) var7 + 0.5D, (double) var6 + 0.5D, 8.0D);
				if (var10 != null && var10.getDistanceSquared((double) var5 + 0.5D, (double) var7 + 0.5D, (double) var6 + 0.5D) > 4.0D) {
					this.makeSound((double) var5 + 0.5D, (double) var7 + 0.5D, (double) var6 + 0.5D, "ambient.cave.cave", 0.7F, 0.8F + this.random.nextFloat() * 0.2F);
					this.K = this.random.nextInt(12000) + 6000;
				}
			}
		}

		this.B.c("checkLight");
		var3.m();
	}

	protected void h() {
		this.D();
	}

	public void a(Block var1, Position var2, Random var3) {
		this.e = true;
		var1.b(this, var2, this.getBlockState(var2), var3);
		this.e = false;
	}

	public boolean v(Position var1) {
		return this.e(var1, false);
	}

	public boolean w(Position var1) {
		return this.e(var1, true);
	}

	public boolean e(Position var1, boolean var2) {
		BiomeBase var3 = this.b(var1);
		float var4 = var3.a(var1);
		if (var4 > 0.15F) {
			return false;
		} else {
			if (var1.getY() >= 0 && var1.getY() < 256 && this.b(EnumSkyBlock.BLOCK, var1) < 10) {
				IBlockState var5 = this.getBlockState(var1);
				Block var6 = var5.getBlock();
				if ((var6 == Blocks.WATER || var6 == Blocks.FLOWING_WATER) && ((Integer) var5.b(axl.b)).intValue() == 0) {
					if (!var2) {
						return true;
					}

					boolean var7 = this.F(var1.e()) && this.F(var1.f()) && this.F(var1.c()) && this.F(var1.d());
					if (!var7) {
						return true;
					}
				}
			}

			return false;
		}
	}

	private boolean F(Position var1) {
		return this.getBlockState(var1).getBlock().getMaterial() == Material.WATER;
	}

	public boolean f(Position var1, boolean var2) {
		BiomeBase var3 = this.b(var1);
		float var4 = var3.a(var1);
		if (var4 > 0.15F) {
			return false;
		} else if (!var2) {
			return true;
		} else {
			if (var1.getY() >= 0 && var1.getY() < 256 && this.b(EnumSkyBlock.BLOCK, var1) < 10) {
				Block var5 = this.getBlockState(var1).getBlock();
				if (var5.getMaterial() == Material.AIR && Blocks.SNOW_LAYER.c(this, var1)) {
					return true;
				}
			}

			return false;
		}
	}

	public boolean x(Position var1) {
		boolean var2 = false;
		if (!this.worldProvider.noSkyLight()) {
			var2 |= this.c(EnumSkyBlock.SKY, var1);
		}

		var2 |= this.c(EnumSkyBlock.BLOCK, var1);
		return var2;
	}

	private int a(Position var1, EnumSkyBlock var2) {
		if (var2 == EnumSkyBlock.SKY && this.i(var1)) {
			return 15;
		} else {
			Block var3 = this.getBlockState(var1).getBlock();
			int var4 = var2 == EnumSkyBlock.SKY ? 0 : var3.p();
			int var5 = var3.n();
			if (var5 >= 15 && var3.p() > 0) {
				var5 = 1;
			}

			if (var5 < 1) {
				var5 = 1;
			}

			if (var5 >= 15) {
				return 0;
			} else if (var4 >= 14) {
				return var4;
			} else {
				BlockFace[] var6 = BlockFace.values();
				int var7 = var6.length;

				for (int var8 = 0; var8 < var7; ++var8) {
					BlockFace var9 = var6[var8];
					Position var10 = var1.getRelative(var9);
					int var11 = this.b(var2, var10) - var5;
					if (var11 > var4) {
						var4 = var11;
					}

					if (var4 >= 14) {
						return var4;
					}
				}

				return var4;
			}
		}
	}

	public boolean c(EnumSkyBlock var1, Position var2) {
		if (!this.a(var2, 17, false)) {
			return false;
		} else {
			int var3 = 0;
			int var4 = 0;
			this.B.a("getBrightness");
			int var5 = this.b(var1, var2);
			int var6 = this.a(var2, var1);
			int var7 = var2.getX();
			int var8 = var2.getY();
			int var9 = var2.getZ();
			int var10;
			int var11;
			int var12;
			int var13;
			int var16;
			int var17;
			int var18;
			int var19;
			if (var6 > var5) {
				this.H[var4++] = 133152;
			} else if (var6 < var5) {
				this.H[var4++] = 133152 | var5 << 18;

				while (var3 < var4) {
					var10 = this.H[var3++];
					var11 = (var10 & 63) - 32 + var7;
					var12 = (var10 >> 6 & 63) - 32 + var8;
					var13 = (var10 >> 12 & 63) - 32 + var9;
					int var14 = var10 >> 18 & 15;
					Position var15 = new Position(var11, var12, var13);
					var16 = this.b(var1, var15);
					if (var16 == var14) {
						this.a(var1, var15, 0);
						if (var14 > 0) {
							var17 = MathHelper.a(var11 - var7);
							var18 = MathHelper.a(var12 - var8);
							var19 = MathHelper.a(var13 - var9);
							if (var17 + var18 + var19 < 17) {
								BlockFace[] var20 = BlockFace.values();
								int var21 = var20.length;

								for (int var22 = 0; var22 < var21; ++var22) {
									BlockFace var23 = var20[var22];
									int var24 = var11 + var23.g();
									int var25 = var12 + var23.h();
									int var26 = var13 + var23.i();
									Position var27 = new Position(var24, var25, var26);
									int var28 = Math.max(1, this.getBlockState(var27).getBlock().n());
									var16 = this.b(var1, var27);
									if (var16 == var14 - var28 && var4 < this.H.length) {
										this.H[var4++] = var24 - var7 + 32 | var25 - var8 + 32 << 6 | var26 - var9 + 32 << 12 | var14 - var28 << 18;
									}
								}
							}
						}
					}
				}

				var3 = 0;
			}

			this.B.b();
			this.B.a("checkedPosition < toCheckCount");

			while (var3 < var4) {
				var10 = this.H[var3++];
				var11 = (var10 & 63) - 32 + var7;
				var12 = (var10 >> 6 & 63) - 32 + var8;
				var13 = (var10 >> 12 & 63) - 32 + var9;
				Position var29 = new Position(var11, var12, var13);
				int var30 = this.b(var1, var29);
				var16 = this.a(var29, var1);
				if (var16 != var30) {
					this.a(var1, var29, var16);
					if (var16 > var30) {
						var17 = Math.abs(var11 - var7);
						var18 = Math.abs(var12 - var8);
						var19 = Math.abs(var13 - var9);
						boolean var31 = var4 < this.H.length - 6;
						if (var17 + var18 + var19 < 17 && var31) {
							if (this.b(var1, var29.e()) < var16) {
								this.H[var4++] = var11 - 1 - var7 + 32 + (var12 - var8 + 32 << 6) + (var13 - var9 + 32 << 12);
							}

							if (this.b(var1, var29.f()) < var16) {
								this.H[var4++] = var11 + 1 - var7 + 32 + (var12 - var8 + 32 << 6) + (var13 - var9 + 32 << 12);
							}

							if (this.b(var1, var29.getDown()) < var16) {
								this.H[var4++] = var11 - var7 + 32 + (var12 - 1 - var8 + 32 << 6) + (var13 - var9 + 32 << 12);
							}

							if (this.b(var1, var29.getUp()) < var16) {
								this.H[var4++] = var11 - var7 + 32 + (var12 + 1 - var8 + 32 << 6) + (var13 - var9 + 32 << 12);
							}

							if (this.b(var1, var29.c()) < var16) {
								this.H[var4++] = var11 - var7 + 32 + (var12 - var8 + 32 << 6) + (var13 - 1 - var9 + 32 << 12);
							}

							if (this.b(var1, var29.d()) < var16) {
								this.H[var4++] = var11 - var7 + 32 + (var12 - var8 + 32 << 6) + (var13 + 1 - var9 + 32 << 12);
							}
						}
					}
				}
			}

			this.B.b();
			return true;
		}
	}

	public boolean a(boolean var1) {
		return false;
	}

	public List<NextTickListEntry> getNextTickList(Chunk chunk, boolean var2) {
		return null;
	}

	public List<NextTickListEntry> getNextTickList(CuboidArea cuboidArea, boolean var2) {
		return null;
	}

	public List<Entity> getEntities(Entity entity, AxisAlignedBB boundingBox) {
		return this.getEntities(entity, boundingBox, EntityPredicates.notSpectators);
	}

	public List<Entity> getEntities(Entity entity, AxisAlignedBB boundingBox, Predicate<Entity> predicate) {
		ArrayList<Entity> list = Lists.newArrayList();
		int var5 = MathHelper.toFixedPointInt((boundingBox.minX - 2.0D) / 16.0D);
		int var6 = MathHelper.toFixedPointInt((boundingBox.maxX + 2.0D) / 16.0D);
		int var7 = MathHelper.toFixedPointInt((boundingBox.minZ - 2.0D) / 16.0D);
		int var8 = MathHelper.toFixedPointInt((boundingBox.maxZ + 2.0D) / 16.0D);

		for (int i = var5; i <= var6; ++i) {
			for (int j = var7; j <= var8; ++j) {
				if (this.a(i, j, true)) {
					this.a(i, j).a(entity, boundingBox, list, predicate);
				}
			}
		}

		return list;
	}

	public List a(Class var1, Predicate var2) {
		ArrayList var3 = Lists.newArrayList();
		Iterator var4 = this.f.iterator();

		while (var4.hasNext()) {
			Entity var5 = (Entity) var4.next();
			if (var1.isAssignableFrom(var5.getClass()) && var2.apply(var5)) {
				var3.add(var5);
			}
		}

		return var3;
	}

	public List b(Class var1, Predicate var2) {
		ArrayList var3 = Lists.newArrayList();
		Iterator<Entity> var4 = this.j.iterator();

		while (var4.hasNext()) {
			Entity var5 = (Entity) var4.next();
			if (var1.isAssignableFrom(var5.getClass()) && var2.apply(var5)) {
				var3.add(var5);
			}
		}

		return var3;
	}

	public <T> List<T> getEntititesInAABB(Class<T> var1, AxisAlignedBB var2) {
		return this.getEntititesInAABB(var1, var2, EntityPredicates.notSpectators);
	}

	public <T> List<T> getEntititesInAABB(Class<T> var1, AxisAlignedBB var2, Predicate<?> var3) {
		int var4 = MathHelper.toFixedPointInt((var2.minX - 2.0D) / 16.0D);
		int var5 = MathHelper.toFixedPointInt((var2.maxX + 2.0D) / 16.0D);
		int var6 = MathHelper.toFixedPointInt((var2.minZ - 2.0D) / 16.0D);
		int var7 = MathHelper.toFixedPointInt((var2.maxZ + 2.0D) / 16.0D);
		ArrayList<T> var8 = Lists.newArrayList();

		for (int var9 = var4; var9 <= var5; ++var9) {
			for (int var10 = var6; var10 <= var7; ++var10) {
				if (this.a(var9, var10, true)) {
					this.a(var9, var10).a(var1, var2, var8, var3);
				}
			}
		}

		return var8;
	}

	public <T> Entity a(Class<T> var1, AxisAlignedBB var2, Entity var3) {
		List<T> var4 = this.getEntititesInAABB(var1, var2);
		Entity var5 = null;
		double var6 = Double.MAX_VALUE;

		for (int var8 = 0; var8 < var4.size(); ++var8) {
			Entity var9 = (Entity) var4.get(var8);
			if (var9 != var3 && EntityPredicates.notSpectators.apply(var9)) {
				double var10 = var3.getDistanceSquared(var9);
				if (var10 <= var6) {
					var5 = var9;
					var6 = var10;
				}
			}
		}

		return var5;
	}

	public Entity getEntity(int var1) {
		return (Entity) this.l.get(var1);
	}

	public void b(Position var1, TileEntity var2) {
		if (this.isLoaded(var1)) {
			this.getChunk(var1).e();
		}
	}

	public int a(Class var1) {
		int var2 = 0;
		Iterator var3 = this.f.iterator();

		while (var3.hasNext()) {
			Entity var4 = (Entity) var3.next();
			if ((!(var4 instanceof EntityInsentient) || !((EntityInsentient) var4).bY()) && var1.isAssignableFrom(var4.getClass())) {
				++var2;
			}
		}

		return var2;
	}

	public void b(Collection var1) {
		this.f.addAll(var1);
		Iterator var2 = var1.iterator();

		while (var2.hasNext()) {
			Entity var3 = (Entity) var2.next();
			this.a(var3);
		}

	}

	public void c(Collection var1) {
		this.g.addAll(var1);
	}

	public boolean a(Block var1, Position var2, boolean var3, BlockFace var4, Entity var5, ItemStack var6) {
		Block var7 = this.getBlockState(var2).getBlock();
		AxisAlignedBB var8 = var3 ? null : var1.a(this, var2, var1.getBlockState());
		return var8 != null && !this.a(var8, var5) ? false : (var7.getMaterial() == Material.ORIENTABLE && var1 == Blocks.ANVIL ? true : var7.getMaterial().j() && var1.a(this, var2, var4, var6));
	}

	public int a(Position var1, BlockFace var2) {
		IBlockState var3 = this.getBlockState(var1);
		return var3.getBlock().b((ard) this, var1, var3, var2);
	}

	public LevelType G() {
		return this.worldData.getLevelType();
	}

	public int y(Position var1) {
		byte var2 = 0;
		int var3 = Math.max(var2, this.a(var1.getDown(), BlockFace.DOWN));
		if (var3 >= 15) {
			return var3;
		} else {
			var3 = Math.max(var3, this.a(var1.getUp(), BlockFace.UP));
			if (var3 >= 15) {
				return var3;
			} else {
				var3 = Math.max(var3, this.a(var1.c(), BlockFace.NORTH));
				if (var3 >= 15) {
					return var3;
				} else {
					var3 = Math.max(var3, this.a(var1.d(), BlockFace.SOUTH));
					if (var3 >= 15) {
						return var3;
					} else {
						var3 = Math.max(var3, this.a(var1.e(), BlockFace.WEST));
						if (var3 >= 15) {
							return var3;
						} else {
							var3 = Math.max(var3, this.a(var1.f(), BlockFace.EAST));
							return var3 >= 15 ? var3 : var3;
						}
					}
				}
			}
		}
	}

	public boolean b(Position var1, BlockFace var2) {
		return this.c(var1, var2) > 0;
	}

	public int c(Position var1, BlockFace var2) {
		IBlockState var3 = this.getBlockState(var1);
		Block var4 = var3.getBlock();
		return var4.t() ? this.y(var1) : var4.a((ard) this, var1, var3, var2);
	}

	public boolean z(Position var1) {
		return this.c(var1.getDown(), BlockFace.DOWN) > 0 ? true : (this.c(var1.getUp(), BlockFace.UP) > 0 ? true : (this.c(var1.c(), BlockFace.NORTH) > 0 ? true : (this.c(var1.d(), BlockFace.SOUTH) > 0 ? true : (this.c(var1.e(), BlockFace.WEST) > 0 ? true : this.c(var1.f(), BlockFace.EAST) > 0))));
	}

	public int A(Position var1) {
		int var2 = 0;
		BlockFace[] var3 = BlockFace.values();
		int var4 = var3.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			BlockFace var6 = var3[var5];
			int var7 = this.c(var1.getRelative(var6), var6);
			if (var7 >= 15) {
				return 15;
			}

			if (var7 > var2) {
				var2 = var7;
			}
		}

		return var2;
	}

	public EntityHuman a(Entity var1, double var2) {
		return this.a(var1.locationX, var1.locationY, var1.locationZ, var2);
	}

	public EntityHuman a(double var1, double var3, double var5, double var7) {
		double var9 = -1.0D;
		EntityHuman var11 = null;

		for (int var12 = 0; var12 < this.j.size(); ++var12) {
			EntityHuman var13 = (EntityHuman) this.j.get(var12);
			if (EntityPredicates.notSpectators.apply(var13)) {
				double var14 = var13.getDistanceSquared(var1, var3, var5);
				if ((var7 < 0.0D || var14 < var7 * var7) && (var9 == -1.0D || var14 < var9)) {
					var9 = var14;
					var11 = var13;
				}
			}
		}

		return var11;
	}

	public boolean findNearbyPlayer(double var1, double var3, double var5, double var7) {
		for (int var9 = 0; var9 < this.j.size(); ++var9) {
			EntityHuman var10 = (EntityHuman) this.j.get(var9);
			if (EntityPredicates.notSpectators.apply(var10)) {
				double var11 = var10.getDistanceSquared(var1, var3, var5);
				if (var7 < 0.0D || var11 < var7 * var7) {
					return true;
				}
			}
		}

		return false;
	}

	public EntityHuman a(String var1) {
		for (int var2 = 0; var2 < this.j.size(); ++var2) {
			EntityHuman var3 = (EntityHuman) this.j.get(var2);
			if (var1.equals(var3.getName())) {
				return var3;
			}
		}

		return null;
	}

	public EntityHuman b(UUID var1) {
		for (int var2 = 0; var2 < this.j.size(); ++var2) {
			EntityHuman var3 = (EntityHuman) this.j.get(var2);
			if (var1.equals(var3.getUUID())) {
				return var3;
			}
		}

		return null;
	}

	public void checkSessionLock() throws ExceptionWorldConflict {
		this.dataManager.checkSessionLock();
	}

	public long J() {
		return this.worldData.getSeed();
	}

	public long getTime() {
		return this.worldData.getTime();
	}

	public long L() {
		return this.worldData.getDayTime();
	}

	public void b(long var1) {
		this.worldData.setDayTime(var1);
	}

	public Position getSpawnPosition() {
		Position spawnPosition = new Position(this.worldData.getSpawnX(), this.worldData.getSpawnY(), this.worldData.getSpawnZ());
		if (!this.getWorldBorder().isInside(spawnPosition)) {
			spawnPosition = this.m(new Position(this.getWorldBorder().getX(), 0.0D, this.getWorldBorder().getZ()));
		}

		return spawnPosition;
	}

	public void setSpawn(Position position) {
		this.worldData.setSpawn(position);
	}

	public boolean a(EntityHuman var1, Position var2) {
		return true;
	}

	public void broadcastEntityEffect(Entity entity, byte effect) {
	}

	public IChunkProvider getChunkProvider() {
		return this.chunkProvider;
	}

	public void playBlockAction(Position var1, Block var2, int var3, int var4) {
		var2.a(this, var1, this.getBlockState(var1), var3, var4);
	}

	public IDataManager getDataManager() {
		return this.dataManager;
	}

	public WorldData getWorldData() {
		return this.worldData;
	}

	public GameRuleRegistry getGameRules() {
		return this.worldData.getGameRules();
	}

	public void d() {
	}

	public float h(float var1) {
		return (this.q + (this.r - this.q) * var1) * this.j(var1);
	}

	public float j(float var1) {
		return this.o + (this.p - this.o) * var1;
	}

	public boolean R() {
		return (double) this.h(1.0F) > 0.9D;
	}

	public boolean S() {
		return (double) this.j(1.0F) > 0.2D;
	}

	public boolean C(Position var1) {
		if (!this.S()) {
			return false;
		} else if (!this.i(var1)) {
			return false;
		} else if (this.q(var1).getY() > var1.getY()) {
			return false;
		} else {
			BiomeBase var2 = this.b(var1);
			return var2.d() ? false : (this.f(var1, false) ? false : var2.e());
		}
	}

	public boolean D(Position var1) {
		BiomeBase var2 = this.b(var1);
		return var2.f();
	}

	public brn T() {
		return this.z;
	}

	public void a(String var1, bqc var2) {
		this.z.a(var1, var2);
	}

	public bqc a(Class var1, String var2) {
		return this.z.a(var1, var2);
	}

	public int b(String var1) {
		return this.z.a(var1);
	}

	public void a(int var1, Position var2, int var3) {
		for (int var4 = 0; var4 < this.u.size(); ++var4) {
			((IWorldAccess) this.u.get(var4)).a(var1, var2, var3);
		}

	}

	public void triggerEffect(int var1, Position var2, int var3) {
		this.a((EntityHuman) null, var1, var2, var3);
	}

	public void a(EntityHuman var1, int var2, Position var3, int var4) {
		try {
			for (int var5 = 0; var5 < this.u.size(); ++var5) {
				((IWorldAccess) this.u.get(var5)).a(var1, var2, var3, var4);
			}

		} catch (Throwable var8) {
			CrashReport var6 = CrashReport.generateCrashReport(var8, "Playing level event");
			CrashReportSystemDetails var7 = var6.generateSystemDetails("Level event being played");
			var7.addDetails("Block coordinates", (Object) net.minecraft.CrashReportSystemDetails.getPositionInfo(var3));
			var7.addDetails("Event source", (Object) var1);
			var7.addDetails("Event type", (Object) Integer.valueOf(var2));
			var7.addDetails("Event data", (Object) Integer.valueOf(var4));
			throw new ReportedException(var6);
		}
	}

	public int U() {
		return 256;
	}

	public int V() {
		return this.worldProvider.noSkyLight() ? 128 : 256;
	}

	public Random a(int var1, int var2, int var3) {
		long var4 = (long) var1 * 341873128712L + (long) var2 * 132897987541L + this.getWorldData().getSeed() + (long) var3;
		this.random.setSeed(var4);
		return this.random;
	}

	public Position a(String var1, Position var2) {
		return this.getChunkProvider().findNearestMapFeature(this, var1, var2);
	}

	public CrashReportSystemDetails a(CrashReport var1) {
		CrashReportSystemDetails var2 = var1.generateSystemDetails("Affected level", 1);
		var2.addDetails("Level name", (Object) (this.worldData == null ? "????" : this.worldData.getLevelName()));
		var2.addDetails("All players", (Callable) (new aqx(this)));
		var2.addDetails("Chunk stats", (Callable) (new aqy(this)));

		try {
			this.worldData.addCrashReportDetails(var2);
		} catch (Throwable var4) {
			var2.addDetails("Level Data Unobtainable", var4);
		}

		return var2;
	}

	public void c(int var1, Position var2, int var3) {
		for (int var4 = 0; var4 < this.u.size(); ++var4) {
			IWorldAccess var5 = (IWorldAccess) this.u.get(var4);
			var5.b(var1, var2, var3);
		}

	}

	public Calendar Y() {
		if (this.getTime() % 600L == 0L) {
			this.J.setTimeInMillis(MinecraftServer.getCurrentMillis());
		}

		return this.J;
	}

	public Scoreboard Z() {
		return this.C;
	}

	public void e(Position var1, Block var2) {
		Iterator var3 = UniverseDirection.HORIZONTAL.iterator();

		while (var3.hasNext()) {
			BlockFace var4 = (BlockFace) var3.next();
			Position var5 = var1.getRelative(var4);
			if (this.isLoaded(var5)) {
				IBlockState var6 = this.getBlockState(var5);
				if (Blocks.UNPOWERED_COMPARATOR.e(var6.getBlock())) {
					var6.getBlock().a(this, var5, var6, var2);
				} else if (var6.getBlock().t()) {
					var5 = var5.getRelative(var4);
					var6 = this.getBlockState(var5);
					if (Blocks.UNPOWERED_COMPARATOR.e(var6.getBlock())) {
						var6.getBlock().a(this, var5, var6, var2);
					}
				}
			}
		}

	}

	public vu E(Position var1) {
		long var2 = 0L;
		float var4 = 0.0F;
		if (this.isLoaded(var1)) {
			var4 = this.y();
			var2 = this.getChunk(var1).getInhabitedTime();
		}

		return new vu(this.getDifficulty(), this.L(), var2, var4);
	}

	public Difficulty getDifficulty() {
		return this.getWorldData().getDifficulty();
	}

	public int ab() {
		return this.d;
	}

	public void b(int var1) {
		this.d = var1;
	}

	public void c(int var1) {
		this.I = var1;
	}

	public boolean isLoading() {
		return this.isLoading;
	}

	public PersistentVillage ae() {
		return this.A;
	}

	public WorldBorder getWorldBorder() {
		return this.worldborder;
	}

	public boolean isSpawnChunk(int chunkX, int chunkZ) {
		Position position = this.getSpawnPosition();
		int xDistToSpawn = chunkX * 16 + 8 - position.getX();
		int zDistToSpawn = chunkZ * 16 + 8 - position.getZ();
		short minDist = 128;
		return xDistToSpawn >= -minDist && xDistToSpawn <= minDist && zDistToSpawn >= -minDist && zDistToSpawn <= minDist;
	}

	public WorldProvider getWorldProvider() {
		return worldProvider;
	}

}
