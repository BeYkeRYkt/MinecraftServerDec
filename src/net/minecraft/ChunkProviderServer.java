package net.minecraft;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChunkProviderServer implements IChunkProvider {

	private static final Logger logger = LogManager.getLogger();

	private Set<Long> unloadQueue = Collections.newSetFromMap(new ConcurrentHashMap<Long, Boolean>());
	private Chunk emptyChunk;
	private IChunkProvider chunkGenerator;
	private IChunkLoader chunkLoader;
	public boolean forceChunkLoad = true;
	private LongHashMap chunks = new LongHashMap();
	private List<Chunk> chunkList = Lists.newArrayList();
	private WorldServer worldServer;

	public ChunkProviderServer(WorldServer worldServer, IChunkLoader chunkLoader, IChunkProvider chunkGenerator) {
		this.emptyChunk = new EmptyChunk(worldServer, 0, 0);
		this.worldServer = worldServer;
		this.chunkLoader = chunkLoader;
		this.chunkGenerator = chunkGenerator;
	}

	public boolean isChunkLoaded(int chunkX, int chunkZ) {
		return this.chunks.contains(ChunkCoordIntPair.toLongHash(chunkX, chunkZ));
	}

	public List<Chunk> getChunkList() {
		return this.chunkList;
	}

	public Chunk getChunkAtWorldCoords(Position position) {
		return this.getOrCreateChunk(position.getX() >> 4, position.getZ() >> 4);
	}

	public Chunk getChunkAt(int chunkX, int chunkZ) {
		long longHash = ChunkCoordIntPair.toLongHash(chunkX, chunkZ);
		this.unloadQueue.remove(Long.valueOf(longHash));
		Chunk chunk = (Chunk) this.chunks.getEntry(longHash);
		if (chunk == null) {
			chunk = this.loadChunk(chunkX, chunkZ);
			if (chunk == null) {
				if (this.chunkGenerator == null) {
					chunk = this.emptyChunk;
				} else {
					try {
						chunk = this.chunkGenerator.getOrCreateChunk(chunkX, chunkZ);
					} catch (Throwable t) {
						CrashReport crashReport = CrashReport.generateCrashReport(t, "Exception generating new chunk");
						CrashReportSystemDetails crashReportDetails = crashReport.generateSystemDetails("Chunk to be generated");
						crashReportDetails.addDetails("Location", String.format("%d,%d", new Object[] { Integer.valueOf(chunkX), Integer.valueOf(chunkZ) }));
						crashReportDetails.addDetails("Position hash", Long.valueOf(longHash));
						crashReportDetails.addDetails("Generator", this.chunkGenerator.getName());
						throw new ReportedException(crashReport);
					}
				}
			}

			this.chunks.put(longHash, chunk);
			this.chunkList.add(chunk);
			chunk.addEntities();
			chunk.a(this, this, chunkX, chunkZ);
		}

		return chunk;
	}

	public void getChunkAt(IChunkProvider provider, int chunkX, int chunkZ) {
		Chunk chunk = this.getOrCreateChunk(chunkX, chunkZ);
		if (!chunk.isTerrainPopulated()) {
			chunk.n();
			if (this.chunkGenerator != null) {
				this.chunkGenerator.getChunkAt(provider, chunkX, chunkZ);
				chunk.e();
			}
		}
	}

	public Chunk getOrCreateChunk(int chunkX, int chunkZ) {
		Chunk chunk = (Chunk) this.chunks.getEntry(ChunkCoordIntPair.toLongHash(chunkX, chunkZ));
		return chunk == null ? (!this.worldServer.isLoading() && !this.forceChunkLoad ? this.emptyChunk : this.getChunkAt(chunkX, chunkZ)) : chunk;
	}

	private Chunk loadChunk(int chunkX, int chunkZ) {
		if (this.chunkLoader == null) {
			return null;
		} else {
			try {
				Chunk chunk = this.chunkLoader.loadChunk(this.worldServer, chunkX, chunkZ);
				if (chunk != null) {
					chunk.b(this.worldServer.getTime());
					if (this.chunkGenerator != null) {
						this.chunkGenerator.recreateStructures(chunk, chunkX, chunkZ);
					}
				}

				return chunk;
			} catch (Exception ex) {
				logger.error("Couldn\'t load chunk", ex);
				return null;
			}
		}
	}

	public void queueUnload(int chunkX, int chunkZ) {
		if (this.worldServer.worldProvider.isPrimaryWorld()) {
			if (!this.worldServer.isSpawnChunk(chunkX, chunkZ)) {
				this.unloadQueue.add(Long.valueOf(ChunkCoordIntPair.toLongHash(chunkX, chunkZ)));
			}
		} else {
			this.unloadQueue.add(Long.valueOf(ChunkCoordIntPair.toLongHash(chunkX, chunkZ)));
		}
	}

	public void queueUnloadAllChunks() {
		Iterator<Chunk> iterator = this.chunkList.iterator();
		while (iterator.hasNext()) {
			Chunk chunk = iterator.next();
			this.queueUnload(chunk.x, chunk.y);
		}
	}

	public boolean unloadChunks() {
		if (!this.worldServer.savingDisabled) {
			for (int i = 0; i < 100; ++i) {
				if (!this.unloadQueue.isEmpty()) {
					Long longHash = this.unloadQueue.iterator().next();
					Chunk chunk = (Chunk) this.chunks.getEntry(longHash.longValue());
					if (chunk != null) {
						chunk.removeEntities();
						this.requestChunkSave(chunk);
						this.chunks.remove(longHash.longValue());
						this.chunkList.remove(chunk);
					}

					this.unloadQueue.remove(longHash);
				}
			}
		}

		return this.chunkGenerator.unloadChunks();
	}

	private void requestChunkSave(Chunk chunk) {
		if (this.chunkLoader != null) {
			try {
				chunk.b(this.worldServer.getTime());
				this.chunkLoader.requestChunkSave(this.worldServer, chunk);
			} catch (ExceptionWorldConflict ex) {
				logger.error("Couldn\'t save chunk; already in use by another instance of Minecraft?", ex);
			}

		}
	}

	public boolean requestChunksSave(boolean flag, IProgressUpdate progressUpdate) {
		int savedChunks = 0;

		for (int i = 0; i < this.chunkList.size(); ++i) {
			Chunk chunk = this.chunkList.get(i);
			if (chunk.a(flag)) {
				this.requestChunkSave(chunk);
				chunk.f(false);
				++savedChunks;
				if (savedChunks == 24 && !flag) {
					return false;
				}
			}
		}

		return true;
	}

	public void saveChunks() {
		if (this.chunkLoader != null) {
			this.chunkLoader.saveAllChunks();
		}
	}

	public boolean ae(IChunkProvider provider, Chunk chunk, int chunkX, int chunkZ) {
		if (this.chunkGenerator != null && this.chunkGenerator.ae(provider, chunk, chunkX, chunkZ)) {
			Chunk anotherChunk = this.getOrCreateChunk(chunkX, chunkZ);
			anotherChunk.e();
			return true;
		} else {
			return false;
		}
	}

	public boolean canSave() {
		return !this.worldServer.savingDisabled;
	}

	public String getName() {
		return "ServerChunkCache: " + this.chunks.count() + " Drop: " + this.unloadQueue.size();
	}

	public List<?> getMobsFor(EnumCreatureType creatureType, Position position) {
		return this.chunkGenerator.getMobsFor(creatureType, position);
	}

	public Position findNearestMapFeature(World world, String s, Position position) {
		return this.chunkGenerator.findNearestMapFeature(world, s, position);
	}

	public int getLoadedChunks() {
		return this.chunks.count();
	}

	public void recreateStructures(Chunk var1, int var2, int var3) {
	}

}
