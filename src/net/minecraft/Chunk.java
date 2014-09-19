package net.minecraft;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import com.google.common.collect.Queues;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pipebukkit.server.PipeChunk;

public class Chunk {

	private static final Logger logger = LogManager.getLogger();
	private final ChunkSection[] chunkSections;
	private final byte[] biomes;
	private final int[] f;
	private final boolean[] g;
	private boolean h;
	private final WorldServer worldServer;
	private final int[] heightMap;
	public final int x;
	public final int z;
	private boolean k;
	private final Map<Position, TileEntity> tileEntities;
	private final EntitySlice<Entity>[] entitySlices;
	private boolean terrainPopulated;
	private boolean lightPopulated;
	private boolean p;
	private boolean q;
	private boolean r;
	private long s;
	private int t;
	private long u;
	private int v;
	private ConcurrentLinkedQueue w;

	public Chunk(WorldServer world, int var2, int var3) {
		this.chunkSections = new ChunkSection[16];
		this.biomes = new byte[256];
		this.f = new int[256];
		this.g = new boolean[256];
		this.tileEntities = Maps.newHashMap();
		this.v = 4096;
		this.w = Queues.newConcurrentLinkedQueue();
		this.entitySlices = new EntitySlice[16];
		this.worldServer = world;
		this.x = var2;
		this.z = var3;
		this.heightMap = new int[256];

		for (int i = 0; i < this.entitySlices.length; ++i) {
			this.entitySlices[i] = new EntitySlice<Entity>(Entity.class);
		}

		Arrays.fill(this.f, -999);
		Arrays.fill(this.biomes, (byte) -1);
	}

	public Chunk(WorldServer var1, bgk var2, int var3, int var4) {
		this(var1, var3, var4);
		short var5 = 256;
		boolean var6 = !var1.worldProvider.noSkyLight();

		for (int var7 = 0; var7 < 16; ++var7) {
			for (int var8 = 0; var8 < 16; ++var8) {
				for (int var9 = 0; var9 < var5; ++var9) {
					int var10 = var7 * var5 * 16 | var8 * var5 | var9;
					IBlockState var11 = var2.a(var10);
					if (var11.getBlock().getMaterial() != Material.AIR) {
						int var12 = var9 >> 4;
						if (this.chunkSections[var12] == null) {
							this.chunkSections[var12] = new ChunkSection(var12 << 4, var6);
						}

						this.chunkSections[var12].setBlockState(var7, var9 & 15, var8, var11);
					}
				}
			}
		}

	}

	public boolean a(int var1, int var2) {
		return var1 == this.x && var2 == this.z;
	}

	public int f(Position var1) {
		return this.b(var1.getX() & 15, var1.getZ() & 15);
	}

	public int b(int var1, int var2) {
		return this.heightMap[var2 << 4 | var1];
	}

	public int g() {
		for (int var1 = this.chunkSections.length - 1; var1 >= 0; --var1) {
			if (this.chunkSections[var1] != null) {
				return this.chunkSections[var1].getYPos();
			}
		}

		return 0;
	}

	public ChunkSection[] getChunkSections() {
		return this.chunkSections;
	}

	public void b() {
		int var1 = this.g();
		this.t = Integer.MAX_VALUE;

		for (int var2 = 0; var2 < 16; ++var2) {
			int var3 = 0;

			while (var3 < 16) {
				this.f[var2 + (var3 << 4)] = -999;
				int var4 = var1 + 16;

				while (true) {
					if (var4 > 0) {
						if (this.e(var2, var4 - 1, var3) == 0) {
							--var4;
							continue;
						}

						this.heightMap[var3 << 4 | var2] = var4;
						if (var4 < this.t) {
							this.t = var4;
						}
					}

					if (!this.worldServer.worldProvider.noSkyLight()) {
						var4 = 15;
						int var5 = var1 + 16 - 1;

						do {
							int var6 = this.e(var2, var5, var3);
							if (var6 == 0 && var4 != 15) {
								var6 = 1;
							}

							var4 -= var6;
							if (var4 > 0) {
								ChunkSection var7 = this.chunkSections[var5 >> 4];
								if (var7 != null) {
									var7.setSkyLight(var2, var5 & 15, var3, var4);
									this.worldServer.n(new Position((this.x << 4) + var2, var5, (this.z << 4) + var3));
								}
							}

							--var5;
						} while (var5 > 0 && var4 > 0);
					}

					++var3;
					break;
				}
			}
		}

		this.q = true;
	}

	private void d(int var1, int var2) {
		this.g[var1 + var2 * 16] = true;
		this.k = true;
	}

	private void h(boolean var1) {
		this.worldServer.B.a("recheckGaps");
		if (this.worldServer.a(new Position(this.x * 16 + 8, 0, this.z * 16 + 8), (int) 16)) {
			for (int var2 = 0; var2 < 16; ++var2) {
				for (int var3 = 0; var3 < 16; ++var3) {
					if (this.g[var2 + var3 * 16]) {
						this.g[var2 + var3 * 16] = false;
						int var4 = this.b(var2, var3);
						int var5 = this.x * 16 + var2;
						int var6 = this.z * 16 + var3;
						int var7 = Integer.MAX_VALUE;

						Iterator var8;
						BlockFace var9;
						for (var8 = en.a.iterator(); var8.hasNext(); var7 = Math.min(var7, this.worldServer.b(var5 + var9.g(), var6 + var9.i()))) {
							var9 = (BlockFace) var8.next();
						}

						this.c(var5, var6, var7);
						var8 = en.a.iterator();

						while (var8.hasNext()) {
							var9 = (BlockFace) var8.next();
							this.c(var5 + var9.g(), var6 + var9.i(), var4);
						}

						if (var1) {
							this.worldServer.B.b();
							return;
						}
					}
				}
			}

			this.k = false;
		}

		this.worldServer.B.b();
	}

	private void c(int var1, int var2, int var3) {
		int var4 = this.worldServer.m(new Position(var1, 0, var2)).getY();
		if (var4 > var3) {
			this.a(var1, var2, var3, var4 + 1);
		} else if (var4 < var3) {
			this.a(var1, var2, var4, var3 + 1);
		}

	}

	private void a(int var1, int var2, int var3, int var4) {
		if (var4 > var3 && this.worldServer.a(new Position(var1, 0, var2), (int) 16)) {
			for (int var5 = var3; var5 < var4; ++var5) {
				this.worldServer.c(EnumSkyBlock.SKY, new Position(var1, var5, var2));
			}

			this.q = true;
		}

	}

	private void d(int var1, int var2, int var3) {
		int var4 = this.heightMap[var3 << 4 | var1] & 255;
		int var5 = var4;
		if (var2 > var4) {
			var5 = var2;
		}

		while (var5 > 0 && this.e(var1, var5 - 1, var3) == 0) {
			--var5;
		}

		if (var5 != var4) {
			this.worldServer.a(var1 + this.x * 16, var3 + this.z * 16, var5, var4);
			this.heightMap[var3 << 4 | var1] = var5;
			int var6 = this.x * 16 + var1;
			int var7 = this.z * 16 + var3;
			int var8;
			int var13;
			if (!this.worldServer.worldProvider.noSkyLight()) {
				ChunkSection var9;
				if (var5 < var4) {
					for (var8 = var5; var8 < var4; ++var8) {
						var9 = this.chunkSections[var8 >> 4];
						if (var9 != null) {
							var9.setSkyLight(var1, var8 & 15, var3, 15);
							this.worldServer.n(new Position((this.x << 4) + var1, var8, (this.z << 4) + var3));
						}
					}
				} else {
					for (var8 = var4; var8 < var5; ++var8) {
						var9 = this.chunkSections[var8 >> 4];
						if (var9 != null) {
							var9.setSkyLight(var1, var8 & 15, var3, 0);
							this.worldServer.n(new Position((this.x << 4) + var1, var8, (this.z << 4) + var3));
						}
					}
				}

				var8 = 15;

				while (var5 > 0 && var8 > 0) {
					--var5;
					var13 = this.e(var1, var5, var3);
					if (var13 == 0) {
						var13 = 1;
					}

					var8 -= var13;
					if (var8 < 0) {
						var8 = 0;
					}

					ChunkSection var10 = this.chunkSections[var5 >> 4];
					if (var10 != null) {
						var10.setSkyLight(var1, var5 & 15, var3, var8);
					}
				}
			}

			var8 = this.heightMap[var3 << 4 | var1];
			var13 = var4;
			int var14 = var8;
			if (var8 < var4) {
				var13 = var8;
				var14 = var4;
			}

			if (var8 < this.t) {
				this.t = var8;
			}

			if (!this.worldServer.worldProvider.noSkyLight()) {
				Iterator var11 = en.a.iterator();

				while (var11.hasNext()) {
					BlockFace var12 = (BlockFace) var11.next();
					this.a(var6 + var12.g(), var7 + var12.i(), var13, var14);
				}

				this.a(var6, var7, var13, var14);
			}

			this.q = true;
		}
	}

	public int b(Position var1) {
		return this.getBlockAtWorldCoords(var1).n();
	}

	private int e(int var1, int var2, int var3) {
		return this.getBlockAt(var1, var2, var3).n();
	}

	private Block getBlockAt(int var1, int var2, int var3) {
		Block var4 = Blocks.AIR;
		if (var2 >= 0 && var2 >> 4 < this.chunkSections.length) {
			ChunkSection var5 = this.chunkSections[var2 >> 4];
			if (var5 != null) {
				try {
					var4 = var5.getBlock(var1, var2 & 15, var3);
				} catch (Throwable var8) {
					CrashReport var7 = CrashReport.generateCrashReport(var8, "Getting block");
					throw new ReportedException(var7);
				}
			}
		}

		return var4;
	}

	public Block getBlockAtWorldCoords(int var1, int var2, int var3) {
		try {
			return this.getBlockAt(var1 & 15, var2, var3 & 15);
		} catch (ReportedException var6) {
			CrashReportSystemDetails var5 = var6.getCrashReport().generateSystemDetails("Block being got");
			var5.addDetails("Location", (Callable) (new bfi(this, var1, var2, var3)));
			throw var6;
		}
	}

	public Block getBlockAtWorldCoords(Position position) {
		try {
			return this.getBlockAt(position.getX() & 15, position.getY(), position.getZ() & 15);
		} catch (ReportedException var4) {
			CrashReportSystemDetails var3 = var4.getCrashReport().generateSystemDetails("Block being got");
			var3.addDetails("Location", (Callable) (new bfj(this, position)));
			throw var4;
		}
	}

	public IBlockState getBlockState(Position position) {
		if (this.worldServer.G() == LevelType.DEBUG) {
			IBlockState blockstate = null;
			if (position.getY() == 60) {
				blockstate = Blocks.BARRIER.getBlockState();
			}

			if (position.getY() == 70) {
				blockstate = ChunkProviderDebug.b(position.getX(), position.getZ());
			}

			return blockstate == null ? Blocks.AIR.getBlockState() : blockstate;
		} else {
			try {
				if (position.getY() >= 0 && position.getY() >> 4 < this.chunkSections.length) {
					ChunkSection var2 = this.chunkSections[position.getY() >> 4];
					if (var2 != null) {
						int var8 = position.getX() & 15;
						int var9 = position.getY() & 15;
						int var5 = position.getZ() & 15;
						return var2.getBlockState(var8, var9, var5);
					}
				}

				return Blocks.AIR.getBlockState();
			} catch (Throwable var6) {
				CrashReport var3 = CrashReport.generateCrashReport(var6, "Getting block state");
				CrashReportSystemDetails var4 = var3.generateSystemDetails("Block being got");
				var4.addDetails("Location", (Callable) (new bfk(this, position)));
				throw new ReportedException(var3);
			}
		}
	}

	private int getBlockDataAt(int x, int y, int z) {
		if (y >> 4 >= this.chunkSections.length) {
			return 0;
		} else {
			ChunkSection section = this.chunkSections[y >> 4];
			return section != null ? section.getData(x, y & 15, z) : 0;
		}
	}

	public int getBlockDataAt(Position position) {
		return this.getBlockDataAt(position.getX() & 15, position.getY(), position.getZ() & 15);
	}

	public IBlockState setBlockAt(Position position, IBlockState blockState) {
		int var3 = position.getX() & 15;
		int var4 = position.getY();
		int var5 = position.getZ() & 15;
		int var6 = var5 << 4 | var3;
		if (var4 >= this.f[var6] - 1) {
			this.f[var6] = -999;
		}

		int var7 = this.heightMap[var6];
		IBlockState var8 = this.getBlockState(position);
		if (var8 == blockState) {
			return null;
		} else {
			Block var9 = blockState.getBlock();
			Block var10 = var8.getBlock();
			ChunkSection var11 = this.chunkSections[var4 >> 4];
			boolean var12 = false;
			if (var11 == null) {
				if (var9 == Blocks.AIR) {
					return null;
				}

				var11 = this.chunkSections[var4 >> 4] = new ChunkSection(var4 >> 4 << 4, !this.worldServer.worldProvider.noSkyLight());
				var12 = var4 >= var7;
			}

			var11.setBlockState(var3, var4 & 15, var5, blockState);
			if (var10 != var9) {
				if (!this.worldServer.isStatic) {
					var10.remove(this.worldServer, position, var8);
				} else if (var10 instanceof avs) {
					this.worldServer.t(position);
				}
			}

			if (var11.getBlock(var3, var4 & 15, var5) != var9) {
				return null;
			} else {
				if (var12) {
					this.b();
				} else {
					int var13 = var9.n();
					int var14 = var10.n();
					if (var13 > 0) {
						if (var4 >= var7) {
							this.d(var3, var4 + 1, var5);
						}
					} else if (var4 == var7 - 1) {
						this.d(var3, var4, var5);
					}

					if (var13 != var14 && (var13 < var14 || this.a(EnumSkyBlock.SKY, position) > 0 || this.a(EnumSkyBlock.BLOCK, position) > 0)) {
						this.d(var3, var5);
					}
				}

				TileEntity var15;
				if (var10 instanceof avs) {
					var15 = this.a(position, bfl.c);
					if (var15 != null) {
						var15.removeBlockData();
					}
				}

				if (!this.worldServer.isStatic && var10 != var9) {
					var9.c(this.worldServer, position, blockState);
				}

				if (var9 instanceof avs) {
					var15 = this.a(position, bfl.c);
					if (var15 == null) {
						var15 = ((avs) var9).getTileEntity(this.worldServer, var9.getData(blockState));
						this.worldServer.a(position, var15);
					}

					if (var15 != null) {
						var15.removeBlockData();
					}
				}

				this.q = true;
				return var8;
			}
		}
	}

	public int a(EnumSkyBlock var1, Position var2) {
		int var3 = var2.getX() & 15;
		int var4 = var2.getY();
		int var5 = var2.getZ() & 15;
		ChunkSection var6 = this.chunkSections[var4 >> 4];
		return var6 == null ? (this.d(var2) ? var1.lightLevel : 0) : (var1 == EnumSkyBlock.SKY ? (this.worldServer.worldProvider.noSkyLight() ? 0 : var6.getSkyLight(var3, var4 & 15, var5)) : (var1 == EnumSkyBlock.BLOCK ? var6.getBlockLight(var3, var4 & 15, var5) : var1.lightLevel));
	}

	public void a(EnumSkyBlock var1, Position var2, int var3) {
		int var4 = var2.getX() & 15;
		int var5 = var2.getY();
		int var6 = var2.getZ() & 15;
		ChunkSection var7 = this.chunkSections[var5 >> 4];
		if (var7 == null) {
			var7 = this.chunkSections[var5 >> 4] = new ChunkSection(var5 >> 4 << 4, !this.worldServer.worldProvider.noSkyLight());
			this.b();
		}

		this.q = true;
		if (var1 == EnumSkyBlock.SKY) {
			if (!this.worldServer.worldProvider.noSkyLight()) {
				var7.setSkyLight(var4, var5 & 15, var6, var3);
			}
		} else if (var1 == EnumSkyBlock.BLOCK) {
			var7.setBlockLight(var4, var5 & 15, var6, var3);
		}

	}

	public int a(Position var1, int var2) {
		int var3 = var1.getX() & 15;
		int var4 = var1.getY();
		int var5 = var1.getZ() & 15;
		ChunkSection var6 = this.chunkSections[var4 >> 4];
		if (var6 == null) {
			return !this.worldServer.worldProvider.noSkyLight() && var2 < EnumSkyBlock.SKY.lightLevel ? EnumSkyBlock.SKY.lightLevel - var2 : 0;
		} else {
			int var7 = this.worldServer.worldProvider.noSkyLight() ? 0 : var6.getSkyLight(var3, var4 & 15, var5);
			var7 -= var2;
			int var8 = var6.getBlockLight(var3, var4 & 15, var5);
			if (var8 > var7) {
				var7 = var8;
			}

			return var7;
		}
	}

	public void addEntity(Entity entity) {
		this.r = true;
		int var2 = MathHelper.toFixedPointInt(entity.locationX / 16.0D);
		int var3 = MathHelper.toFixedPointInt(entity.locationZ / 16.0D);
		if (var2 != this.x || var3 != this.z) {
			logger.warn("Wrong location! (" + var2 + ", " + var3 + ") should be (" + this.x + ", " + this.z + "), " + entity, new Object[] { entity });
			entity.die();
		}

		int chunkColumnNumber = MathHelper.toFixedPointInt(entity.locationY / 16.0D);
		if (chunkColumnNumber < 0) {
			chunkColumnNumber = 0;
		}

		if (chunkColumnNumber >= this.entitySlices.length) {
			chunkColumnNumber = this.entitySlices.length - 1;
		}

		entity.ad = true;
		entity.ae = this.x;
		entity.af = chunkColumnNumber;
		entity.ag = this.z;
		this.entitySlices[chunkColumnNumber].add(entity);
	}

	public void b(Entity var1) {
		this.a(var1, var1.af);
	}

	public void a(Entity var1, int var2) {
		if (var2 < 0) {
			var2 = 0;
		}

		if (var2 >= this.entitySlices.length) {
			var2 = this.entitySlices.length - 1;
		}

		this.entitySlices[var2].remove(var1);
	}

	public boolean d(Position var1) {
		int var2 = var1.getX() & 15;
		int var3 = var1.getY();
		int var4 = var1.getZ() & 15;
		return var3 >= this.heightMap[var4 << 4 | var2];
	}

	private TileEntity i(Position var1) {
		Block var2 = this.getBlockAtWorldCoords(var1);
		return !var2.x() ? null : ((avs) var2).getTileEntity(this.worldServer, this.getBlockDataAt(var1));
	}

	public TileEntity a(Position var1, bfl var2) {
		TileEntity var3 = (TileEntity) this.tileEntities.get(var1);
		if (var3 == null) {
			if (var2 == bfl.a) {
				var3 = this.i(var1);
				this.worldServer.a(var1, var3);
			} else if (var2 == bfl.b) {
				this.w.add(var1);
			}
		} else if (var3.isInvalid()) {
			this.tileEntities.remove(var1);
			return null;
		}

		return var3;
	}

	public void a(TileEntity var1) {
		this.a(var1.getPosition(), var1);
		if (this.h) {
			this.worldServer.a(var1);
		}

	}

	public void a(Position var1, TileEntity var2) {
		var2.setWorld(this.worldServer);
		var2.setPosition(var1);
		if (this.getBlockAtWorldCoords(var1) instanceof avs) {
			if (this.tileEntities.containsKey(var1)) {
				((TileEntity) this.tileEntities.get(var1)).setValid();
			}

			var2.setInvalid();
			this.tileEntities.put(var1, var2);
		}
	}

	public void e(Position var1) {
		if (this.h) {
			TileEntity var2 = (TileEntity) this.tileEntities.remove(var1);
			if (var2 != null) {
				var2.setValid();
			}
		}

	}

	public void addEntities() {
		this.h = true;
		this.worldServer.a(this.tileEntities.values());

		for (int var1 = 0; var1 < this.entitySlices.length; ++var1) {
			Iterator var2 = this.entitySlices[var1].iterator();

			while (var2.hasNext()) {
				Entity var3 = (Entity) var2.next();
				var3.ah();
			}

			this.worldServer.b((Collection) this.entitySlices[var1]);
		}

	}

	public void removeEntities() {
		this.h = false;
		Iterator var1 = this.tileEntities.values().iterator();

		while (var1.hasNext()) {
			TileEntity var2 = (TileEntity) var1.next();
			this.worldServer.b(var2);
		}

		for (int var3 = 0; var3 < this.entitySlices.length; ++var3) {
			this.worldServer.c((Collection) this.entitySlices[var3]);
		}

	}

	public void e() {
		this.q = true;
	}

	public void a(Entity var1, AxisAlignedBB var2, List<Entity> var3, Predicate<Entity> var4) {
		int var5 = MathHelper.toFixedPointInt((var2.minY - 2.0D) / 16.0D);
		int var6 = MathHelper.toFixedPointInt((var2.maxY + 2.0D) / 16.0D);
		var5 = MathHelper.a(var5, 0, this.entitySlices.length - 1);
		var6 = MathHelper.a(var6, 0, this.entitySlices.length - 1);

		for (int var7 = var5; var7 <= var6; ++var7) {
			Iterator var8 = this.entitySlices[var7].iterator();

			while (var8.hasNext()) {
				Entity var9 = (Entity) var8.next();
				if (var9 != var1 && var9.getBoundingBox().b(var2) && (var4 == null || var4.apply(var9))) {
					var3.add(var9);
					Entity[] var10 = var9.aC();
					if (var10 != null) {
						for (int var11 = 0; var11 < var10.length; ++var11) {
							var9 = var10[var11];
							if (var9 != var1 && var9.getBoundingBox().b(var2) && (var4 == null || var4.apply(var9))) {
								var3.add(var9);
							}
						}
					}
				}
			}
		}

	}

	public void a(Class var1, AxisAlignedBB var2, List var3, Predicate var4) {
		int var5 = MathHelper.toFixedPointInt((var2.minY - 2.0D) / 16.0D);
		int var6 = MathHelper.toFixedPointInt((var2.maxY + 2.0D) / 16.0D);
		var5 = MathHelper.a(var5, 0, this.entitySlices.length - 1);
		var6 = MathHelper.a(var6, 0, this.entitySlices.length - 1);

		for (int var7 = var5; var7 <= var6; ++var7) {
			Iterator var8 = this.entitySlices[var7].getValues(var1).iterator();

			while (var8.hasNext()) {
				Entity var9 = (Entity) var8.next();
				if (var9.getBoundingBox().b(var2) && (var4 == null || var4.apply(var9))) {
					var3.add(var9);
				}
			}
		}

	}

	public boolean a(boolean var1) {
		if (var1) {
			if (this.r && this.worldServer.getTime() != this.s || this.q) {
				return true;
			}
		} else if (this.r && this.worldServer.getTime() >= this.s + 600L) {
			return true;
		}

		return this.q;
	}

	public Random a(long var1) {
		return new Random(this.worldServer.J() + (long) (this.x * this.x * 4987142) + (long) (this.x * 5947611) + (long) (this.z * this.z) * 4392871L + (long) (this.z * 389711) ^ var1);
	}

	public boolean f() {
		return false;
	}

	public void a(IChunkProvider var1, IChunkProvider var2, int var3, int var4) {
		boolean var5 = var1.isChunkLoaded(var3, var4 - 1);
		boolean var6 = var1.isChunkLoaded(var3 + 1, var4);
		boolean var7 = var1.isChunkLoaded(var3, var4 + 1);
		boolean var8 = var1.isChunkLoaded(var3 - 1, var4);
		boolean var9 = var1.isChunkLoaded(var3 - 1, var4 - 1);
		boolean var10 = var1.isChunkLoaded(var3 + 1, var4 + 1);
		boolean var11 = var1.isChunkLoaded(var3 - 1, var4 + 1);
		boolean var12 = var1.isChunkLoaded(var3 + 1, var4 - 1);
		if (var6 && var7 && var10) {
			if (!this.terrainPopulated) {
				var1.getChunkAt(var2, var3, var4);
			} else {
				var1.ae(var2, this, var3, var4);
			}
		}

		Chunk var13;
		if (var8 && var7 && var11) {
			var13 = var1.getOrCreateChunk(var3 - 1, var4);
			if (!var13.terrainPopulated) {
				var1.getChunkAt(var2, var3 - 1, var4);
			} else {
				var1.ae(var2, var13, var3 - 1, var4);
			}
		}

		if (var5 && var6 && var12) {
			var13 = var1.getOrCreateChunk(var3, var4 - 1);
			if (!var13.terrainPopulated) {
				var1.getChunkAt(var2, var3, var4 - 1);
			} else {
				var1.ae(var2, var13, var3, var4 - 1);
			}
		}

		if (var9 && var5 && var8) {
			var13 = var1.getOrCreateChunk(var3 - 1, var4 - 1);
			if (!var13.terrainPopulated) {
				var1.getChunkAt(var2, var3 - 1, var4 - 1);
			} else {
				var1.ae(var2, var13, var3 - 1, var4 - 1);
			}
		}

	}

	public Position h(Position var1) {
		int var2 = var1.getX() & 15;
		int var3 = var1.getZ() & 15;
		int var4 = var2 | var3 << 4;
		Position var5 = new Position(var1.getX(), this.f[var4], var1.getZ());
		if (var5.getY() == -999) {
			int var6 = this.g() + 15;
			var5 = new Position(var1.getX(), var6, var1.getZ());
			int var7 = -1;

			while (var5.getY() > 0 && var7 == -1) {
				Block var8 = this.getBlockAtWorldCoords(var5);
				Material var9 = var8.getMaterial();
				if (!var9.isSolid() && !var9.isLiquid()) {
					var5 = var5.getDown();
				} else {
					var7 = var5.getY() + 1;
				}
			}

			this.f[var4] = var7;
		}

		return new Position(var1.getX(), this.f[var4], var1.getZ());
	}

	public void b(boolean var1) {
		if (this.k && !this.worldServer.worldProvider.noSkyLight() && !var1) {
			this.h(this.worldServer.isStatic);
		}

		this.p = true;
		if (!this.lightPopulated && this.terrainPopulated) {
			this.n();
		}

		while (!this.w.isEmpty()) {
			Position var2 = (Position) this.w.poll();
			if (this.a(var2, bfl.c) == null && this.getBlockAtWorldCoords(var2).x()) {
				TileEntity var3 = this.i(var2);
				this.worldServer.a(var2, var3);
				this.worldServer.b(var2, var2);
			}
		}

	}

	public boolean i() {
		return this.p && this.terrainPopulated && this.lightPopulated;
	}

	public ChunkCoordIntPair getCoords() {
		return new ChunkCoordIntPair(this.x, this.z);
	}

	public boolean c(int var1, int var2) {
		if (var1 < 0) {
			var1 = 0;
		}

		if (var2 >= 256) {
			var2 = 255;
		}

		for (int var3 = var1; var3 <= var2; var3 += 16) {
			ChunkSection var4 = this.chunkSections[var3 >> 4];
			if (var4 != null && !var4.isEmpty()) {
				return false;
			}
		}

		return true;
	}

	public void setSections(ChunkSection[] sections) {
		if (this.chunkSections.length != sections.length) {
			logger.warn("Could not set level chunk sections, array length is " + sections.length + " instead of " + this.chunkSections.length);
		} else {
			for (int i = 0; i < this.chunkSections.length; ++i) {
				this.chunkSections[i] = sections[i];
			}
		}
	}

	public BiomeBase a(Position var1, WorldChunkManager var2) {
		int var3 = var1.getX() & 15;
		int var4 = var1.getZ() & 15;
		int var5 = this.biomes[var4 << 4 | var3] & 255;
		BiomeBase var6;
		if (var5 == 255) {
			var6 = var2.a(var1, BiomeBase.PLAINS);
			var5 = var6.az;
			this.biomes[var4 << 4 | var3] = (byte) (var5 & 255);
		}

		var6 = BiomeBase.e(var5);
		return var6 == null ? BiomeBase.PLAINS : var6;
	}

	public byte[] getBiomes() {
		return this.biomes;
	}

	public void setBiomes(byte[] biomes) {
		if (this.biomes.length != biomes.length) {
			logger.warn("Could not set level chunk biomes, array length is " + biomes.length + " instead of " + this.biomes.length);
		} else {
			for (int i = 0; i < this.biomes.length; ++i) {
				this.biomes[i] = biomes[i];
			}

		}
	}

	public void l() {
		this.v = 0;
	}

	public void m() {
		Position var1 = new Position(this.x << 4, 0, this.z << 4);

		for (int var2 = 0; var2 < 8; ++var2) {
			if (this.v >= 4096) {
				return;
			}

			int var3 = this.v % 16;
			int var4 = this.v / 16 % 16;
			int var5 = this.v / 256;
			++this.v;

			for (int var6 = 0; var6 < 16; ++var6) {
				Position var7 = var1.a(var4, (var3 << 4) + var6, var5);
				boolean var8 = var6 == 0 || var6 == 15 || var4 == 0 || var4 == 15 || var5 == 0 || var5 == 15;
				if (this.chunkSections[var3] == null && var8 || this.chunkSections[var3] != null && this.chunkSections[var3].getBlock(var4, var6, var5).getMaterial() == Material.AIR) {
					BlockFace[] var9 = BlockFace.values();
					int var10 = var9.length;

					for (int var11 = 0; var11 < var10; ++var11) {
						BlockFace var12 = var9[var11];
						Position var13 = var7.getRelative(var12);
						if (this.worldServer.getBlockState(var13).getBlock().p() > 0) {
							this.worldServer.x(var13);
						}
					}

					this.worldServer.x(var7);
				}
			}
		}

	}

	public void n() {
		this.terrainPopulated = true;
		this.lightPopulated = true;
		Position var1 = new Position(this.x << 4, 0, this.z << 4);
		if (!this.worldServer.worldProvider.noSkyLight()) {
			if (this.worldServer.a(var1.a(-1, 0, -1), var1.a(16, 63, 16))) {
				label42: for (int var2 = 0; var2 < 16; ++var2) {
					for (int var3 = 0; var3 < 16; ++var3) {
						if (!this.e(var2, var3)) {
							this.lightPopulated = false;
							break label42;
						}
					}
				}

				if (this.lightPopulated) {
					Iterator var5 = en.a.iterator();

					while (var5.hasNext()) {
						BlockFace var6 = (BlockFace) var5.next();
						int var4 = var6.c() == em.a ? 16 : 1;
						this.worldServer.getChunk(var1.a(var6, var4)).a(var6.getOpposite());
					}

					this.y();
				}
			} else {
				this.lightPopulated = false;
			}
		}
	}

	private void y() {
		for (int var1 = 0; var1 < this.g.length; ++var1) {
			this.g[var1] = true;
		}

		this.h(false);
	}

	private void a(BlockFace var1) {
		if (this.terrainPopulated) {
			int var2;
			if (var1 == BlockFace.EAST) {
				for (var2 = 0; var2 < 16; ++var2) {
					this.e(15, var2);
				}
			} else if (var1 == BlockFace.WEST) {
				for (var2 = 0; var2 < 16; ++var2) {
					this.e(0, var2);
				}
			} else if (var1 == BlockFace.SOUTH) {
				for (var2 = 0; var2 < 16; ++var2) {
					this.e(var2, 15);
				}
			} else if (var1 == BlockFace.NORTH) {
				for (var2 = 0; var2 < 16; ++var2) {
					this.e(var2, 0);
				}
			}

		}
	}

	private boolean e(int var1, int var2) {
		Position var3 = new Position(this.x << 4, 0, this.z << 4);
		int var4 = this.g();
		boolean var5 = false;
		boolean var6 = false;

		int var7;
		Position var8;
		for (var7 = var4 + 16 - 1; var7 > 63 || var7 > 0 && !var6; --var7) {
			var8 = var3.a(var1, var7, var2);
			int var9 = this.b(var8);
			if (var9 == 255 && var7 < 63) {
				var6 = true;
			}

			if (!var5 && var9 > 0) {
				var5 = true;
			} else if (var5 && var9 == 0 && !this.worldServer.x(var8)) {
				return false;
			}
		}

		for (; var7 > 0; --var7) {
			var8 = var3.a(var1, var7, var2);
			if (this.getBlockAtWorldCoords(var8).p() > 0) {
				this.worldServer.x(var8);
			}
		}

		return true;
	}

	public boolean o() {
		return this.h;
	}

	public WorldServer getWorld() {
		return this.worldServer;
	}

	public int[] getHeightMap() {
		return this.heightMap;
	}

	public void setHeightMap(int[] var1) {
		if (this.heightMap.length != var1.length) {
			logger.warn("Could not set level chunk heightmap, array length is " + var1.length + " instead of " + this.heightMap.length);
		} else {
			for (int var2 = 0; var2 < this.heightMap.length; ++var2) {
				this.heightMap[var2] = var1[var2];
			}

		}
	}

	public Map<Position, TileEntity> getTileEntites() {
		return this.tileEntities;
	}

	public EntitySlice<Entity>[] getEntitySlices() {
		return this.entitySlices;
	}

	public boolean isTerrainPopulated() {
		return this.terrainPopulated;
	}

	public void setTerrainPopulated(boolean terrainPopulated) {
		this.terrainPopulated = terrainPopulated;
	}

	public boolean isLightPopulated() {
		return this.lightPopulated;
	}

	public void setLightPopulated(boolean loghtPopulated) {
		this.lightPopulated = loghtPopulated;
	}

	public void f(boolean var1) {
		this.q = var1;
	}

	public void g(boolean var1) {
		this.r = var1;
	}

	public void b(long var1) {
		this.s = var1;
	}

	public int v() {
		return this.t;
	}

	public long getInhabitedTime() {
		return this.u;
	}

	public void setInhabitedTime(long var1) {
		this.u = var1;
	}

	private org.bukkit.Chunk bukkitChunk;
	public org.bukkit.Chunk getBukkitChunk() {
		if (bukkitChunk == null) {
			bukkitChunk = new PipeChunk(worldServer, x, z);
		}
		return bukkitChunk;
	}

}
