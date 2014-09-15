package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import net.minecraft.server.MinecraftServer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WorldServer extends World implements ITaskScheduler {

	private static final Logger logger = LogManager.getLogger();
	private final MinecraftServer minecraftserver;
	private final EntityTracker entityTracker;
	private final PlayerChunkMap playerChunkMap;
	private final Set<NextTickListEntry> nextTickHashSet = Sets.newHashSet();
	private final TreeSet<NextTickListEntry> nextTickTreeSet = new TreeSet<NextTickListEntry>();
	private List<NextTickListEntry> V = Lists.newArrayList();
	public final Map<UUID, Entity> entities = Maps.newHashMap();
	public ChunkProviderServer chunkProviderServer;
	public boolean savingDisabled;
	private boolean O;
	private int emptyTime;
	private final PortalTravelAgent portalTravelAgent;
	private final SpawnerCreature spawnerCreature = new SpawnerCreature();
	protected final abk d = new abk(this);
	private BlockActionDataList[] S = new BlockActionDataList[] { new BlockActionDataList((qu) null), new BlockActionDataList((qu) null) };
	private int T;
	private static final List U = Lists.newArrayList((Object[]) (new StructurePieceTreasure[] { new StructurePieceTreasure(Items.STICK, 0, 1, 3, 10), new StructurePieceTreasure(Item.getItemOf(Blocks.PLANKS), 0, 1, 3, 10), new StructurePieceTreasure(Item.getItemOf(Blocks.LOG), 0, 1, 3, 10), new StructurePieceTreasure(Items.STONE_AXE, 0, 1, 1, 3), new StructurePieceTreasure(Items.WOODEN_AXE, 0, 1, 1, 5), new StructurePieceTreasure(Items.STONE_PICKAXE, 0, 1, 1, 3), new StructurePieceTreasure(Items.WOODEN_PICKAXE, 0, 1, 1, 5), new StructurePieceTreasure(Items.APPLE, 0, 2, 3, 5), new StructurePieceTreasure(Items.BREAD, 0, 2, 3, 3), new StructurePieceTreasure(Item.getItemOf(Blocks.LOG2), 0, 1, 3, 10) }));

	public WorldServer(MinecraftServer minecraftserver, IDataManager dataManager, WorldData worldData, int dimension, MethodProfiler methodProfiler) {
		super(dataManager, worldData, WorldProvider.getById(dimension), methodProfiler, false);
		this.minecraftserver = minecraftserver;
		this.entityTracker = new EntityTracker(this);
		this.playerChunkMap = new PlayerChunkMap(this);
		this.worldProvider.setWorld(this);
		this.chunkProvider = this.getServerChunkProvider();
		this.portalTravelAgent = new PortalTravelAgent(this);
		this.B();
		this.C();
		this.getWorldBorder().setPortalTeleportBoundary(minecraftserver.getMaxWorldSize());
	}

	public WorldServer b() {
		this.z = new brn(this.dataManager);
		String var1 = PersistentVillage.a(this.worldProvider);
		PersistentVillage var2 = (PersistentVillage) this.z.a(PersistentVillage.class, var1);
		if (var2 == null) {
			this.A = new PersistentVillage(this);
			this.z.a(var1, (bqc) this.A);
		} else {
			this.A = var2;
			this.A.a((World) this);
		}

		this.C = new pk(this.minecraftserver);
		bse var3 = (bse) this.z.a(bse.class, "scoreboard");
		if (var3 == null) {
			var3 = new bse();
			this.z.a("scoreboard", (bqc) var3);
		}

		var3.a(this.C);
		((pk) this.C).a(var3);
		this.getWorldBorder().setCenter(this.worldData.getBorderX(), this.worldData.getBorderZ());
		this.getWorldBorder().setDamageAmount(this.worldData.getBorderDamagePerBlock());
		this.getWorldBorder().setDamageBuffer(this.worldData.getBorderSafeZone());
		this.getWorldBorder().setWarningBlocks(this.worldData.getBorderWarningBlocks());
		this.getWorldBorder().setWarningTime(this.worldData.getBorderWarningTime());
		if (this.worldData.getBorderLerpTime() > 0L) {
			this.getWorldBorder().changeSize(this.worldData.getBorderSize(), this.worldData.getBorderSizeLerpTarget(), this.worldData.getBorderLerpTime());
		} else {
			this.getWorldBorder().setSize(this.worldData.getBorderSize());
		}

		return this;
	}

	public void doTick() {
		super.doTick();
		if (this.getWorldData().isHardcore() && this.getDifficulty() != Difficulty.HARD) {
			this.getWorldData().setDifficulty(Difficulty.HARD);
		}

		this.worldProvider.m().b();
		if (this.f()) {
			if (this.getGameRules().b("doDaylightCycle")) {
				long var1 = this.worldData.getDayTime() + 24000L;
				this.worldData.setDayTime(var1 - var1 % 24000L);
			}

			this.e();
		}

		this.B.a("mobSpawner");
		if (this.getGameRules().b("doMobSpawning") && this.worldData.getLevelType() != LevelType.DEBUG) {
			this.spawnerCreature.a(this, this.F, this.G, this.worldData.getTime() % 400L == 0L);
		}

		this.B.c("chunkSource");
		this.chunkProvider.unloadChunks();
		int var3 = this.a(1.0F);
		if (var3 != this.ab()) {
			this.b(var3);
		}

		this.worldData.setTime(this.worldData.getTime() + 1L);
		if (this.getGameRules().b("doDaylightCycle")) {
			this.worldData.setDayTime(this.worldData.getDayTime() + 1L);
		}

		this.B.c("tickPending");
		this.a(false);
		this.B.c("tickBlocks");
		this.h();
		this.B.c("chunkMap");
		this.playerChunkMap.b();
		this.B.c("village");
		this.A.a();
		this.d.a();
		this.B.c("portalForcer");
		this.portalTravelAgent.a(this.getTime());
		this.B.b();
		this.ak();
	}

	public BiomeMeta a(EnumCreatureType var1, Position var2) {
		List var3 = this.getChunkProvider().getMobsFor(var1, var2);
		return var3 != null && !var3.isEmpty() ? (BiomeMeta) vj.a(this.s, var3) : null;
	}

	public boolean a(EnumCreatureType var1, BiomeMeta var2, Position var3) {
		List var4 = this.getChunkProvider().getMobsFor(var1, var3);
		return var4 != null && !var4.isEmpty() ? var4.contains(var2) : false;
	}

	public void d() {
		this.O = false;
		if (!this.j.isEmpty()) {
			int var1 = 0;
			int var2 = 0;
			Iterator var3 = this.j.iterator();

			while (var3.hasNext()) {
				EntityHuman var4 = (EntityHuman) var3.next();
				if (var4.isSpectator()) {
					++var1;
				} else if (var4.isSleeping()) {
					++var2;
				}
			}

			this.O = var2 > 0 && var2 >= this.j.size() - var1;
		}

	}

	protected void e() {
		this.O = false;
		Iterator var1 = this.j.iterator();

		while (var1.hasNext()) {
			EntityHuman var2 = (EntityHuman) var1.next();
			if (var2.isSleeping()) {
				var2.a(false, false, true);
			}
		}

		this.ag();
	}

	private void ag() {
		this.worldData.setRainTime(0);
		this.worldData.setRaining(false);
		this.worldData.setThunderTime(0);
		this.worldData.setThundering(false);
	}

	public boolean f() {
		if (this.O && !this.isStatic) {
			Iterator var1 = this.j.iterator();

			EntityHuman var2;
			do {
				if (!var1.hasNext()) {
					return true;
				}

				var2 = (EntityHuman) var1.next();
			} while (!var2.isSpectator() && var2.ce());

			return false;
		} else {
			return false;
		}
	}

	protected void h() {
		super.h();
		if (this.worldData.getLevelType() == LevelType.DEBUG) {
			Iterator var21 = this.E.iterator();

			while (var21.hasNext()) {
				ChunkCoordIntPair var22 = (ChunkCoordIntPair) var21.next();
				this.a(var22.chunkX, var22.chunkZ).b(false);
			}

		} else {
			int var1 = 0;
			int var2 = 0;

			for (Iterator var3 = this.E.iterator(); var3.hasNext(); this.B.b()) {
				ChunkCoordIntPair var4 = (ChunkCoordIntPair) var3.next();
				int var5 = var4.chunkX * 16;
				int var6 = var4.chunkZ * 16;
				this.B.a("getChunk");
				Chunk var7 = this.a(var4.chunkX, var4.chunkZ);
				this.a(var5, var6, var7);
				this.B.c("tickChunk");
				var7.b(false);
				this.B.c("thunder");
				int var8;
				Position var9;
				if (this.s.nextInt(100000) == 0 && this.S() && this.R()) {
					this.m = this.m * 3 + 1013904223;
					var8 = this.m >> 2;
					var9 = this.a(new Position(var5 + (var8 & 15), 0, var6 + (var8 >> 8 & 15)));
					if (this.C(var9)) {
						this.c(new EntityLightning(this, (double) var9.getX(), (double) var9.getY(), (double) var9.getZ()));
					}
				}

				this.B.c("iceandsnow");
				if (this.s.nextInt(16) == 0) {
					this.m = this.m * 3 + 1013904223;
					var8 = this.m >> 2;
					var9 = this.q(new Position(var5 + (var8 & 15), 0, var6 + (var8 >> 8 & 15)));
					Position var10 = var9.b();
					if (this.w(var10)) {
						this.a(var10, Blocks.ICE.getBlockState());
					}

					if (this.S() && this.f(var9, true)) {
						this.a(var9, Blocks.SNOW_LAYER.getBlockState());
					}

					if (this.S() && this.b(var10).e()) {
						this.getBlockState(var10).getBlock().k(this, var10);
					}
				}

				this.B.c("tickBlocks");
				var8 = this.getGameRules().c("randomTickSpeed");
				if (var8 > 0) {
					ChunkSection[] var23 = var7.getChunkSections();
					int var24 = var23.length;

					for (int var11 = 0; var11 < var24; ++var11) {
						ChunkSection var12 = var23[var11];
						if (var12 != null && var12.shouldTick()) {
							for (int var13 = 0; var13 < var8; ++var13) {
								this.m = this.m * 3 + 1013904223;
								int var14 = this.m >> 2;
								int var15 = var14 & 15;
								int var16 = var14 >> 8 & 15;
								int var17 = var14 >> 16 & 15;
								++var2;
								Position var18 = new Position(var15 + var5, var17 + var12.getYPos(), var16 + var6);
								IBlockState var19 = var12.getBlockState(var15, var17, var16);
								Block var20 = var19.getBlock();
								if (var20.isTicking()) {
									++var1;
									var20.a((World) this, var18, var19, this.s);
								}
							}
						}
					}
				}
			}

		}
	}

	protected Position a(Position var1) {
		Position var2 = this.q(var1);
		AxisAlignedBB var3 = (new AxisAlignedBB(var2, new Position(var2.getX(), this.U(), var2.getZ()))).grow(3.0D, 3.0D, 3.0D);
		List var4 = this.a(EntityLiving.class, var3, new qu(this));
		return !var4.isEmpty() ? ((EntityLiving) var4.get(this.s.nextInt(var4.size()))).getEntityPosition() : var2;
	}

	public boolean a(Position var1, Block var2) {
		NextTickListEntry var3 = new NextTickListEntry(var1, var2);
		return this.V.contains(var3);
	}

	public void a(Position var1, Block var2, int var3) {
		this.a(var1, var2, var3, 0);
	}

	public void a(Position var1, Block var2, int var3, int var4) {
		NextTickListEntry var5 = new NextTickListEntry(var1, var2);
		byte var6 = 0;
		if (this.e && var2.getMaterial() != Material.AIR) {
			if (var2.M()) {
				var6 = 8;
				if (this.a(var5.position.a(-var6, -var6, -var6), var5.position.a(var6, var6, var6))) {
					IBlockState var7 = this.getBlockState(var5.position);
					if (var7.getBlock().getMaterial() != Material.AIR && var7.getBlock() == var5.getBlock()) {
						var7.getBlock().b((World) this, var5.position, var7, this.s);
					}
				}

				return;
			}

			var3 = 1;
		}

		if (this.a(var1.a(-var6, -var6, -var6), var1.a(var6, var6, var6))) {
			if (var2.getMaterial() != Material.AIR) {
				var5.a((long) var3 + this.worldData.getTime());
				var5.a(var4);
			}

			if (!this.nextTickHashSet.contains(var5)) {
				this.nextTickHashSet.add(var5);
				this.nextTickTreeSet.add(var5);
			}
		}

	}

	public void addNextTickEntry(Position var1, Block var2, int var3, int var4) {
		NextTickListEntry var5 = new NextTickListEntry(var1, var2);
		var5.a(var4);
		if (var2.getMaterial() != Material.AIR) {
			var5.a((long) var3 + this.worldData.getTime());
		}

		if (!this.nextTickHashSet.contains(var5)) {
			this.nextTickHashSet.add(var5);
			this.nextTickTreeSet.add(var5);
		}

	}

	public void i() {
		if (this.j.isEmpty()) {
			if (this.emptyTime++ >= 1200) {
				return;
			}
		} else {
			this.j();
		}

		super.i();
	}

	public void j() {
		this.emptyTime = 0;
	}

	public boolean a(boolean var1) {
		if (this.worldData.getLevelType() == LevelType.DEBUG) {
			return false;
		} else {
			int var2 = this.nextTickTreeSet.size();
			if (var2 != this.nextTickHashSet.size()) {
				throw new IllegalStateException("TickNextTick list out of synch");
			} else {
				if (var2 > 1000) {
					var2 = 1000;
				}

				this.B.a("cleaning");

				NextTickListEntry var4;
				for (int var3 = 0; var3 < var2; ++var3) {
					var4 = (NextTickListEntry) this.nextTickTreeSet.first();
					if (!var1 && var4.b > this.worldData.getTime()) {
						break;
					}

					this.nextTickTreeSet.remove(var4);
					this.nextTickHashSet.remove(var4);
					this.V.add(var4);
				}

				this.B.b();
				this.B.a("ticking");
				Iterator var11 = this.V.iterator();

				while (var11.hasNext()) {
					var4 = (NextTickListEntry) var11.next();
					var11.remove();
					byte var5 = 0;
					if (this.a(var4.position.a(-var5, -var5, -var5), var4.position.a(var5, var5, var5))) {
						IBlockState var6 = this.getBlockState(var4.position);
						if (var6.getBlock().getMaterial() != Material.AIR && Block.a(var6.getBlock(), var4.getBlock())) {
							try {
								var6.getBlock().b((World) this, var4.position, var6, this.s);
							} catch (Throwable var10) {
								CrashReport var8 = CrashReport.generateCrashReport(var10, "Exception while ticking a block");
								CrashReportSystemDetails var9 = var8.generateSystemDetails("Block being ticked");
								net.minecraft.CrashReportSystemDetails.a(var9, var4.position, var6);
								throw new ReportedException(var8);
							}
						}
					} else {
						this.a(var4.position, var4.getBlock(), 0);
					}
				}

				this.B.b();
				this.V.clear();
				return !this.nextTickTreeSet.isEmpty();
			}
		}
	}

	public List<NextTickListEntry> getNextTickList(Chunk chunk, boolean var2) {
		ChunkCoordIntPair chunkCoords = chunk.getCoords();
		int minX = (chunkCoords.chunkX << 4) - 2;
		int maxX = minX + 16 + 2;
		int minZ = (chunkCoords.chunkZ << 4) - 2;
		int maxZ = minZ + 16 + 2;
		return this.getNextTickList(new CuboidArea(minX, 0, minZ, maxX, 256, maxZ), var2);
	}

	public List<NextTickListEntry> getNextTickList(CuboidArea cuboidArea, boolean var2) {
		ArrayList var3 = null;

		for (int var4 = 0; var4 < 2; ++var4) {
			Iterator var5;
			if (var4 == 0) {
				var5 = this.nextTickTreeSet.iterator();
			} else {
				var5 = this.V.iterator();
				if (!this.V.isEmpty()) {
					logger.debug("toBeTicked = " + this.V.size());
				}
			}

			while (var5.hasNext()) {
				NextTickListEntry var6 = (NextTickListEntry) var5.next();
				Position var7 = var6.position;
				if (var7.getX() >= cuboidArea.minX && var7.getX() < cuboidArea.maxX && var7.getZ() >= cuboidArea.minZ && var7.getZ() < cuboidArea.maxZ) {
					if (var2) {
						this.nextTickHashSet.remove(var6);
						var5.remove();
					}

					if (var3 == null) {
						var3 = Lists.newArrayList();
					}

					var3.add(var6);
				}
			}
		}

		return var3;
	}

	public void a(Entity var1, boolean var2) {
		if (!this.isAnimalSpawnEnabled() && (var1 instanceof EntityAnimal || var1 instanceof EntityWaterAnimal)) {
			var1.die();
		}

		if (!this.isNpcSpawnEnabled() && var1 instanceof NPC) {
			var1.die();
		}

		super.a(var1, var2);
	}

	private boolean isNpcSpawnEnabled() {
		return this.minecraftserver.isNPCSpawnEnabled();
	}

	private boolean isAnimalSpawnEnabled() {
		return this.minecraftserver.isAnimalSpawnEnabled();
	}

	protected IChunkProvider getServerChunkProvider() {
		IChunkLoader loader = this.dataManager.createChunkLoader(this.worldProvider);
		this.chunkProviderServer = new ChunkProviderServer(this, loader, this.worldProvider.getChunkProvider());
		return this.chunkProviderServer;
	}

	public List a(int var1, int var2, int var3, int var4, int var5, int var6) {
		ArrayList var7 = Lists.newArrayList();

		for (int var8 = 0; var8 < this.h.size(); ++var8) {
			TileEntity var9 = (TileEntity) this.h.get(var8);
			Position var10 = var9.v();
			if (var10.getX() >= var1 && var10.getY() >= var2 && var10.getZ() >= var3 && var10.getX() < var4 && var10.getY() < var5 && var10.getZ() < var6) {
				var7.add(var9);
			}
		}

		return var7;
	}

	public boolean a(EntityHuman var1, Position var2) {
		return !this.minecraftserver.isProtected((World) this, var2, var1) && this.getWorldBorder().isInside(var2);
	}

	public void applyWorldSettings(WorldSettings var1) {
		if (!this.worldData.isInitialized()) {
			try {
				this.b(var1);
				if (this.worldData.getLevelType() == LevelType.DEBUG) {
					this.aj();
				}

				super.applyWorldSettings(var1);
			} catch (Throwable var6) {
				CrashReport var3 = CrashReport.generateCrashReport(var6, "Exception initializing level");

				try {
					this.a(var3);
				} catch (Throwable var5) {
					;
				}

				throw new ReportedException(var3);
			}

			this.worldData.setInitialized(true);
		}

	}

	private void aj() {
		this.worldData.setMapFeaturesEnabled(false);
		this.worldData.setCommandsAllowed(true);
		this.worldData.setRaining(false);
		this.worldData.setThundering(false);
		this.worldData.setClearWeatherTime(1000000000);
		this.worldData.setDayTime(6000L);
		this.worldData.setGameMode(EnumGameMode.SPECTATOR);
		this.worldData.setIsHardcore(false);
		this.worldData.setDifficulty(Difficulty.PEACEFUL);
		this.worldData.setDifficultyLocked(true);
		this.getGameRules().a("doDaylightCycle", "false");
	}

	private void b(WorldSettings var1) {
		if (!this.worldProvider.isPrimaryWorld()) {
			this.worldData.setSpawn(Position.ZERO.b(this.worldProvider.i()));
		} else if (this.worldData.getLevelType() == LevelType.DEBUG) {
			this.worldData.setSpawn(Position.ZERO.a());
		} else {
			this.isLoading = true;
			WorldChunkManager var2 = this.worldProvider.m();
			List var3 = var2.a();
			Random var4 = new Random(this.J());
			Position var5 = var2.a(0, 0, 256, var3, var4);
			int var6 = 0;
			int var7 = this.worldProvider.i();
			int var8 = 0;
			if (var5 != null) {
				var6 = var5.getX();
				var8 = var5.getZ();
			} else {
				logger.warn("Unable to find spawn biome");
			}

			int var9 = 0;

			while (!this.worldProvider.canSpawn(var6, var8)) {
				var6 += var4.nextInt(64) - var4.nextInt(64);
				var8 += var4.nextInt(64) - var4.nextInt(64);
				++var9;
				if (var9 == 1000) {
					break;
				}
			}

			this.worldData.setSpawn(new Position(var6, var7, var8));
			this.isLoading = false;
		}
	}

	public Position getDimensionSpawn() {
		return this.worldProvider.h();
	}

	public void save(boolean var1, IProgressUpdate var2) throws ExceptionWorldConflict {
		if (this.chunkProvider.canSave()) {
			if (var2 != null) {
				var2.a("Saving level");
			}

			this.a();
			if (var2 != null) {
				var2.c("Saving chunks");
			}

			this.chunkProvider.requestChunksSave(var1, var2);
			for (Chunk chunk : chunkProviderServer.getChunkList()) {
				if (!this.playerChunkMap.a(chunk.x, chunk.z)) {
					this.chunkProviderServer.queueUnload(chunk.x, chunk.z);
				}
			}
		}
	}

	public void n() {
		if (this.chunkProvider.canSave()) {
			this.chunkProvider.saveChunks();
		}
	}

	protected void a() throws ExceptionWorldConflict {
		this.checkSessionLock();
		this.worldData.setBorderSize(this.getWorldBorder().getOldRadius());
		this.worldData.setBorderX(this.getWorldBorder().getX());
		this.worldData.setBorderZ(this.getWorldBorder().getZ());
		this.worldData.setBorderSafeZone(this.getWorldBorder().getDamageBuffer());
		this.worldData.setBorderDamagePerBlock(this.getWorldBorder().getDamageAmount());
		this.worldData.setBorderWarningBlocks(this.getWorldBorder().getWarningBlocks());
		this.worldData.setBorderWarningTime(this.getWorldBorder().getWarningTime());
		this.worldData.setBorderSizeLerpTarget(this.getWorldBorder().getCurrentRadius());
		this.worldData.setBorderLerpTime(this.getWorldBorder().getSpeed());
		this.dataManager.saveWorldData(this.worldData, this.minecraftserver.getPlayerList().u());
		this.z.a();
	}

	protected void a(Entity var1) {
		super.a(var1);
		this.l.a(var1.getId(), var1);
		this.entities.put(var1.getUUID(), var1);
		Entity[] var2 = var1.aC();
		if (var2 != null) {
			for (int var3 = 0; var3 < var2.length; ++var3) {
				this.l.a(var2[var3].getId(), var2[var3]);
			}
		}

	}

	protected void b(Entity var1) {
		super.b(var1);
		this.l.d(var1.getId());
		this.entities.remove(var1.getUUID());
		Entity[] var2 = var1.aC();
		if (var2 != null) {
			for (int var3 = 0; var3 < var2.length; ++var3) {
				this.l.d(var2[var3].getId());
			}
		}

	}

	public boolean c(Entity var1) {
		if (super.c(var1)) {
			this.minecraftserver.getPlayerList().a(var1.locationX, var1.locationY, var1.locationZ, 512.0D, this.worldProvider.getDimensionId(), new PacketPlayOutSpawnGlobalEntity(var1));
			return true;
		} else {
			return false;
		}
	}

	public void broadcastEntityEffect(Entity var1, byte var2) {
		this.getEntityTracker().b(var1, new PacketPlayOutEntityStatus(var1, var2));
	}

	public Explosion a(Entity var1, double var2, double var4, double var6, float var8, boolean var9, boolean var10) {
		Explosion var11 = new Explosion(this, var1, var2, var4, var6, var8, var9, var10);
		var11.a();
		var11.a(false);
		if (!var10) {
			var11.d();
		}

		Iterator var12 = this.j.iterator();

		while (var12.hasNext()) {
			EntityHuman var13 = (EntityHuman) var12.next();
			if (var13.getDistanceSquared(var2, var4, var6) < 4096.0D) {
				((EntityPlayer) var13).playerConnection.sendPacket((Packet) (new PacketPlayOutExplosion(var2, var4, var6, var8, var11.e(), (Vec3D) var11.b().get(var13))));
			}
		}

		return var11;
	}

	public void c(Position var1, Block var2, int var3, int var4) {
		aqk var5 = new aqk(var1, var2, var3, var4);
		Iterator var6 = this.S[this.T].iterator();

		aqk var7;
		do {
			if (!var6.hasNext()) {
				this.S[this.T].add(var5);
				return;
			}

			var7 = (aqk) var6.next();
		} while (!var7.equals(var5));

	}

	private void ak() {
		while (!this.S[this.T].isEmpty()) {
			int var1 = this.T;
			this.T ^= 1;
			Iterator var2 = this.S[var1].iterator();

			while (var2.hasNext()) {
				aqk var3 = (aqk) var2.next();
				if (this.a(var3)) {
					this.minecraftserver.getPlayerList().a((double) var3.a().getX(), (double) var3.a().getY(), (double) var3.a().getZ(), 64.0D, this.worldProvider.getDimensionId(), new PacketPlayOutBlockAction(var3.a(), var3.d(), var3.b(), var3.c()));
				}
			}

			this.S[var1].clear();
		}

	}

	private boolean a(aqk var1) {
		IBlockState var2 = this.getBlockState(var1.a());
		return var2.getBlock() == var1.d() ? var2.getBlock().a(this, var1.a(), var2, var1.b(), var1.c()) : false;
	}

	public void saveLevel() {
		this.dataManager.saveData();
	}

	protected void p() {
		boolean var1 = this.S();
		super.p();
		if (this.o != this.p) {
			this.minecraftserver.getPlayerList().sendPacket((Packet) (new PacketPlayOutChangeGameState(7, this.p)), this.worldProvider.getDimensionId());
		}

		if (this.q != this.r) {
			this.minecraftserver.getPlayerList().sendPacket((Packet) (new PacketPlayOutChangeGameState(8, this.r)), this.worldProvider.getDimensionId());
		}

		if (var1 != this.S()) {
			if (var1) {
				this.minecraftserver.getPlayerList().sendPacket((Packet) (new PacketPlayOutChangeGameState(2, 0.0F)));
			} else {
				this.minecraftserver.getPlayerList().sendPacket((Packet) (new PacketPlayOutChangeGameState(1, 0.0F)));
			}

			this.minecraftserver.getPlayerList().sendPacket((Packet) (new PacketPlayOutChangeGameState(7, this.p)));
			this.minecraftserver.getPlayerList().sendPacket((Packet) (new PacketPlayOutChangeGameState(8, this.r)));
		}

	}

	protected int q() {
		return this.minecraftserver.getPlayerList().t();
	}

	public MinecraftServer r() {
		return this.minecraftserver;
	}

	public EntityTracker getEntityTracker() {
		return this.entityTracker;
	}

	public PlayerChunkMap getPlayerChunkMap() {
		return this.playerChunkMap;
	}

	public PortalTravelAgent getPortalTravelAgent() {
		return this.portalTravelAgent;
	}

	public void a(Particle var1, double var2, double var4, double var6, int var8, double var9, double var11, double var13, double var15, int... var17) {
		this.a(var1, false, var2, var4, var6, var8, var9, var11, var13, var15, var17);
	}

	public void a(Particle var1, boolean var2, double var3, double var5, double var7, int var9, double var10, double var12, double var14, double var16, int... var18) {
		PacketPlayOutParticle var19 = new PacketPlayOutParticle(var1, var2, (float) var3, (float) var5, (float) var7, (float) var10, (float) var12, (float) var14, (float) var16, var9, var18);

		for (int var20 = 0; var20 < this.j.size(); ++var20) {
			EntityPlayer var21 = (EntityPlayer) this.j.get(var20);
			Position var22 = var21.getEntityPosition();
			double var23 = var22.c(var3, var5, var7);
			if (var23 <= 256.0D || var2 && var23 <= 65536.0D) {
				var21.playerConnection.sendPacket((Packet) var19);
			}
		}

	}

	public Entity getEntity(UUID uuid) {
		return this.entities.get(uuid);
	}

	public ListenableFuture<?> scheduleSyncTask(Runnable var1) {
		return this.minecraftserver.scheduleSyncTask(var1);
	}

	public boolean isMainThread() {
		return this.minecraftserver.isMainThread();
	}

}
