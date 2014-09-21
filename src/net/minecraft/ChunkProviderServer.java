package net.minecraft;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pipebukkit.util.LongObjectHashMap;

public class ChunkProviderServer implements IChunkProvider {

	private static final Logger logger = LogManager.getLogger();

	private Set<Long> unloadQueue = Collections.newSetFromMap(new ConcurrentHashMap<Long, Boolean>());
	private Chunk emptyChunk;
	private IChunkProvider chunkGenerator;
	private IChunkLoader chunkLoader;
	private LongObjectHashMap<Chunk> chunks = new LongObjectHashMap<Chunk>();
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

	public Iterable<Chunk> getChunkList() {
		return chunks;
	}

	public Chunk getChunkIfLoaded(int chunkX, int chunkZ) {
		return chunks.get(ChunkCoordIntPair.toLongHash(chunkX, chunkZ));
	}

	public Chunk getChunkAtWorldCoords(Position position) {
		return this.getOrCreateChunk(position.getX() >> 4, position.getZ() >> 4);
	}

	public Chunk getChunkAt(int chunkX, int chunkZ) {
		long longHash = ChunkCoordIntPair.toLongHash(chunkX, chunkZ);
		this.unloadQueue.remove(longHash);
		Chunk chunk = this.chunks.get(longHash);
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
			chunkLoadPostProcess(chunk);
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
		Chunk chunk = this.chunks.get(ChunkCoordIntPair.toLongHash(chunkX, chunkZ));
		return chunk == null ? this.getChunkAt(chunkX, chunkZ) : chunk;
	}

	public Chunk loadChunk(int chunkX, int chunkZ) {
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

	public void chunkLoadPostProcess(Chunk chunk) {
		this.chunks.put(ChunkCoordIntPair.toLongHash(chunk.x, chunk.z), chunk);
		chunk.addEntities();
		chunk.a(this, this, chunk.x, chunk.z);
	}

	public void queueUnload(int chunkX, int chunkZ) {
		if (this.worldServer.worldProvider.isPrimaryWorld()) {
			if (!this.worldServer.isSpawnChunk(chunkX, chunkZ) || !worldServer.getBukkitWorld().getKeepSpawnInMemory()) {
				this.unloadQueue.add(ChunkCoordIntPair.toLongHash(chunkX, chunkZ));
			}
		} else {
			this.unloadQueue.add(ChunkCoordIntPair.toLongHash(chunkX, chunkZ));
		}
	}

	public void queueUnloadAllChunks() {
		for (Chunk chunk : chunks) {
			queueUnload(chunk.x, chunk.z);
		}
	}

	public boolean unloadChunks() {
		if (!this.worldServer.savingDisabled) {
			for (int i = 0; i < 100; ++i) {
				if (!this.unloadQueue.isEmpty()) {
					long longHash = this.unloadQueue.iterator().next();
					Chunk chunk = this.chunks.get(longHash);
					if (chunk != null) {
						chunk.removeEntities();
						this.requestChunkSave(chunk);
						this.chunks.remove(longHash);
					}

					this.unloadQueue.remove(longHash);
				}
			}
		}

		return this.chunkGenerator.unloadChunks();
	}

	public void cancelChunkUnload(int chunkX, int chunkZ) {
		unloadQueue.remove(ChunkCoordIntPair.toLongHash(chunkX, chunkZ));
	}

	public void removeChunk(int chunkX, int chunkZ) {
		chunks.remove(ChunkCoordIntPair.toLongHash(chunkX, chunkZ));
	}

	public boolean isQueuedForSaving(Chunk chunk) {
		return chunkLoader.isQueuedForSaving(chunk);
	}

	public void requestChunkSave(Chunk chunk) {
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

		for (Chunk chunk : chunks) {
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
