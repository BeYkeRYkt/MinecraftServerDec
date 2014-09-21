package pipebukkit.server;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import net.minecraft.EmptyChunk;
import net.minecraft.ExceptionWorldConflict;
import net.minecraft.LevelType;
import net.minecraft.Position;
import net.minecraft.WorldNBTStorage;
import net.minecraft.WorldServer;
import net.minecraft.server.MinecraftServer;

import org.bukkit.BlockChangeDelegate;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.Difficulty;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.WorldType;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Item;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.weather.ThunderChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.world.WorldSaveEvent;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

@SuppressWarnings("deprecation")
public class PipeWorld implements World {

	private boolean keepSpawnInMemory;
	
	private final WorldServer nmsWorld;
	public PipeWorld(WorldServer nmsWorld) {
		this.nmsWorld = nmsWorld;
	}

	@Override
	public Set<String> getListeningPluginChannels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendPluginMessage(Plugin arg0, String arg1, byte[] arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MetadataValue> getMetadata(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasMetadata(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeMetadata(String arg0, Plugin arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMetadata(String arg0, MetadataValue arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean canGenerateStructures() {
		return MinecraftServer.getInstance().isStructureGenerationEnabled();
	}

	@Override
	public boolean createExplosion(Location location, float power) {
		return createExplosion(location, power, false);
	}

	@Override
	public boolean createExplosion(Location location, float power, boolean setFire) {
		return createExplosion(location.getX(), location.getY(), location.getZ(), power, setFire);
	}

	@Override
	public boolean createExplosion(double x, double y, double z, float power) {
		return createExplosion(x, y, z, power, false);
	}

	@Override
	public boolean createExplosion(double x, double y, double z, float power, boolean setFire) {
		return createExplosion(x, y, z, power, setFire, true);
	}

	@Override
	public boolean createExplosion(double x, double y, double z, float power, boolean setFire, boolean breakBlocks) {
		return nmsWorld.createExplosion(null, x, y, z, power, setFire, breakBlocks).isCancelled();
	}

	@Override
	public Item dropItem(Location arg0, ItemStack arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item dropItemNaturally(Location arg0, ItemStack arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean generateTree(Location arg0, TreeType arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean generateTree(Location arg0, TreeType arg1, BlockChangeDelegate arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Biome getBiome(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBiome(int arg0, int arg1, Biome arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getHumidity(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTemperature(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getBlockTypeIdAt(Location loc) {
		return getBlockTypeIdAt(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
	}

	@Override
	public int getBlockTypeIdAt(int x, int y, int z) {
		return getBlockAt(x, y, z).getTypeId();
	}

	@Override
	public Block getBlockAt(Location loc) {
		return getBlockAt(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
	}

	@Override
	public Block getBlockAt(int x, int y, int z) {
		return getChunkAt(x >> 4, y >> 4).getBlock(x & 0xF, y & 0xFF, z & 0xF);
	}

	@Override
	public Chunk getChunkAt(Location loc) {
		return getChunkAt(loc.getBlock());
	}

	@Override
	public Chunk getChunkAt(Block block) {
		return getChunkAt(block.getX() >> 4, block.getZ() >> 4);
	}

	@Override
	public Chunk getChunkAt(int chunkX, int chunkZ) {
		return nmsWorld.chunkProviderServer.getChunkAt(chunkX, chunkZ).getBukkitChunk();
	}

	@Override
	public Difficulty getDifficulty() {
		return Difficulty.getByValue(nmsWorld.getWorldData().getDifficulty().getId());
	}

	@Override
	public ChunkSnapshot getEmptyChunkSnapshot(int x, int z, boolean includeBiome, boolean includeBiomeTempRain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Entity> getEntities() {
		ArrayList<Entity> entites = new ArrayList<Entity>();
		for (net.minecraft.Entity nmsEntity : nmsWorld.entities.values()) {
			entites.add(nmsEntity.getBukkitEntity(Entity.class));
		}
		return entites;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Entity> Collection<T> getEntitiesByClass(Class<T>... classes) {
		return (Collection<T>) getEntitiesByClasses(classes);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Entity> Collection<T> getEntitiesByClass(Class<T> clazz) {
		return (Collection<T>) getEntitiesByClasses(clazz);
	}

	@Override
	public Collection<Entity> getEntitiesByClasses(Class<?>... classes) {
		ArrayList<Entity> entites = new ArrayList<Entity>();
		for (net.minecraft.Entity nmsEntity : nmsWorld.entities.values()) {
			Entity bukkitEntity = nmsEntity.getBukkitEntity(Entity.class);
			for (Class<?> clazz : classes) {
				if (clazz.isInstance(bukkitEntity)) {
					entites.add(bukkitEntity);
				}
			}
		}
		return entites;
	}

	@Override
	public Environment getEnvironment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getFullTime() {
		return nmsWorld.getWorldData().getTime();
	}

	@Override
	public String getGameRuleValue(String name) {
		return nmsWorld.getGameRules().getGameRuleData(name);
	}

	@Override
	public String[] getGameRules() {
		return nmsWorld.getGameRules().getGameRules();
	}

	@Override
	public ChunkGenerator getGenerator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Block getHighestBlockAt(Location location) {
		return getHighestBlockAt(location.getBlockX(), location.getBlockX());
	}

	@Override
	public Block getHighestBlockAt(int x, int z) {
		return getBlockAt(x, getHighestBlockYAt(x, z), z);
	}

	@Override
	public int getHighestBlockYAt(Location location) {
		return getHighestBlockYAt(location.getBlockX(), location.getBlockZ());
	}

	@Override
	public int getHighestBlockYAt(int x, int z) {
		return ((PipeChunk) getChunkAt(x >> 4, z >> 4)).getHandle().getHighestBlockYAt(x & 0xF, z & 0xF);
	}

	@Override
	public boolean getKeepSpawnInMemory() {
		return keepSpawnInMemory;
	}

	@Override
	public List<LivingEntity> getLivingEntities() {
		return new ArrayList<LivingEntity>(getEntitiesByClass(LivingEntity.class));
	}

	@Override
	public Chunk[] getLoadedChunks() {
		List<Chunk> chunks = new ArrayList<Chunk>();
		for (net.minecraft.Chunk chunk : nmsWorld.chunkProviderServer.getChunkList()) {
			chunks.add(chunk.getBukkitChunk());
		}
		return chunks.toArray(new Chunk[0]);
	}

	@Override
	public int getMaxHeight() {
		return nmsWorld.getHeight();
	}

	@Override
	public String getName() {
		return nmsWorld.getWorldData().getLevelName();
	}

	@Override
	public boolean getPVP() {
		return nmsWorld.pvpMode;
	}

	@Override
	public List<Player> getPlayers() {
		return new ArrayList<Player>(getEntitiesByClass(Player.class));
	}

	@Override
	public List<BlockPopulator> getPopulators() {
		return new ArrayList<BlockPopulator>();
	}

	@Override
	public int getSeaLevel() {
		return 64;
	}

	@Override
	public long getSeed() {
		return nmsWorld.getWorldData().getSeed();
	}

	@Override
	public Location getSpawnLocation() {
		Position position = nmsWorld.getSpawnPosition(); 
		return new Location(this, position.getX(), position.getY(), position.getZ());
	}

	@Override
	public long getTime() {
		return nmsWorld.getWorldData().getDayTime();
	}

	@Override
	public UUID getUID() {
		return nmsWorld.getDataManager().getUUID();
	}

	@Override
	public File getWorldFolder() {
		return ((WorldNBTStorage) nmsWorld.getDataManager()).getDirectory();
	}

	@Override
	public WorldType getWorldType() {
		LevelType worldType = nmsWorld.getWorldData().getLevelType();
		if (worldType.getId() == LevelType.DEFAULT.getId()) {
			return WorldType.NORMAL;
		} else if (worldType.getId() == LevelType.FLAT.getId()) {
			return WorldType.FLAT;
		} else if (worldType.getId() == LevelType.AMPLIFIED.getId()) {
			return WorldType.AMPLIFIED;
		} else if (worldType.getId() == LevelType.LARGE_BIOMES.getId()) {
			return WorldType.LARGE_BIOMES;
		} else if (worldType.getId() == LevelType.DEFAULT_1_1.getId()) {
			return WorldType.VERSION_1_1;
		}
		return WorldType.NORMAL;
	}

	@Override
	public int getWeatherDuration() {
		return nmsWorld.getWorldData().getClearWeatherTime();
	}

	@Override
	public void setWeatherDuration(int time) {
		nmsWorld.getWorldData().setClearWeatherTime(time);
	}

	@Override
	public boolean hasStorm() {
		return nmsWorld.getWorldData().isRaining();
	}

	@Override
	public void setStorm(boolean storm) {
		WeatherChangeEvent weatherEvent = new WeatherChangeEvent(this, storm);
		Bukkit.getPluginManager().callEvent(weatherEvent);
		if (weatherEvent.isCancelled()) {
			return;
		}
		nmsWorld.getWorldData().setRaining(storm);
		if (storm) {
			setWeatherDuration(new Random().nextInt(12000) + 12000);
		} else {
			setWeatherDuration(new Random().nextInt(168000) + 12000);
		}
	}

	@Override
	public boolean isThundering() {
		return nmsWorld.getWorldData().isThundering();
	}

	@Override
	public void setThunderDuration(int thunderTime) {
		nmsWorld.getWorldData().setThunderTime(thunderTime);
	}

	@Override
	public int getThunderDuration() {
		return nmsWorld.getWorldData().getThunderTime();
	}

	@Override
	public void setThundering(boolean thunder) {
		if (thunder && !hasStorm()) {
			setStorm(true);
		}
		ThunderChangeEvent thunderEvent = new ThunderChangeEvent(this, thunder);
		Bukkit.getPluginManager().callEvent(thunderEvent);
		if (thunderEvent.isCancelled()) {
			return;
		}
		nmsWorld.getWorldData().setThundering(thunder);
		if (thunder) {
			setThunderDuration(new Random().nextInt(12000) + 3600);
		} else {
			setThunderDuration(new Random().nextInt(168000) + 12000);
		}
	}

	@Override
	public boolean isAutoSave() {
		return !nmsWorld.savingDisabled;
	}

	@Override
	public boolean isChunkInUse(int x, int z) {
		return nmsWorld.getPlayerChunkMap().isChunkInUse(x, z);
	}

	@Override
	public boolean isChunkLoaded(Chunk chunk) {
		return isChunkLoaded(chunk.getX(), chunk.getZ());
	}

	@Override
	public boolean isChunkLoaded(int chunkX, int chunkZ) {
		return nmsWorld.chunkProviderServer.isChunkLoaded(chunkX, chunkZ);
	}

	@Override
	public boolean isGameRule(String name) {
		return nmsWorld.getGameRules().isGameRule(name);
	}

	@Override
	public void loadChunk(Chunk chunk) {
		loadChunk(chunk.getX(), chunk.getZ());
	}

	@Override
	public void loadChunk(int chunkX, int chunkZ) {
		loadChunk(chunkX, chunkZ, true);
	}

	@Override
	public boolean loadChunk(int chunkX, int chunkZ, boolean generate) {
		if (generate) {
			getChunkAt(chunkX, chunkZ);
			return true;
		}

		nmsWorld.chunkProviderServer.cancelChunkUnload(chunkX, chunkZ);

		net.minecraft.Chunk chunk = nmsWorld.chunkProviderServer.getChunkIfLoaded(chunkX, chunkZ);

		if (chunk == null) {
			chunk = nmsWorld.chunkProviderServer.loadChunk(chunkX, chunkZ);
			nmsWorld.chunkProviderServer.chunkLoadPostProcess(chunk);
		}
		return chunk != null;
	}

	@Override
	public void playEffect(Location location, Effect effect, int data) {
		playEffect(location, effect, data, 0);
	}

	@Override
	public <T> void playEffect(Location location, Effect effect, T data) {
		playEffect(location, effect, data, 64);
	}

	@Override
	public void playEffect(Location location, Effect effect, int data, int radius) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> void playEffect(Location location, Effect effect, T data, int radius) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playSound(Location location, Sound sound, float volume, float pitch) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean refreshChunk(int x, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean regenerateChunk(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void save() {
		try {
			boolean oldSave = nmsWorld.savingDisabled;
			nmsWorld.savingDisabled = false;
			nmsWorld.save(true, null);
			Bukkit.getPluginManager().callEvent(new WorldSaveEvent(this));
			nmsWorld.savingDisabled = oldSave;
		} catch (ExceptionWorldConflict ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public boolean getAllowAnimals() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getAllowMonsters() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getAmbientSpawnLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWaterAnimalSpawnLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAnimalSpawnLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMonsterSpawnLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getTicksPerAnimalSpawns() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getTicksPerMonsterSpawns() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setAmbientSpawnLimit(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAnimalSpawnLimit(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMonsterSpawnLimit(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setWaterAnimalSpawnLimit(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTicksPerAnimalSpawns(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTicksPerMonsterSpawns(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAutoSave(boolean autosave) {
		nmsWorld.savingDisabled = !autosave;
	}

	@Override
	public void setDifficulty(Difficulty difficulty) {
		nmsWorld.getWorldData().setDifficulty(net.minecraft.Difficulty.clampAndGetById(difficulty.getValue()));
	}

	@Override
	public void setFullTime(long time) {
		nmsWorld.getWorldData().setTime(time);
	}

	@Override
	public boolean setGameRuleValue(String name, String data) {
		nmsWorld.getGameRules().setOrAddGameRule(name, data);
		return true;
	}

	@Override
	public void setKeepSpawnInMemory(boolean keep) {
		keepSpawnInMemory = keep;
	}

	@Override
	public void setPVP(boolean pvp) {
		nmsWorld.pvpMode = pvp;
	}

	@Override
	public void setSpawnFlags(boolean allowMonsters, boolean allowAnimals) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean setSpawnLocation(int x, int y, int z) {
		nmsWorld.setSpawn(new Position(x, y, z));
		return true;
	}

	@Override
	public void setTime(long dayTime) {
		nmsWorld.getWorldData().setDayTime(dayTime);
	}

	@Override
	public <T extends Entity> T spawn(Location arg0, Class<T> arg1) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Arrow spawnArrow(Location arg0, Vector arg1, float arg2, float arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LivingEntity spawnCreature(Location arg0, EntityType arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LivingEntity spawnCreature(Location arg0, CreatureType arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entity spawnEntity(Location arg0, EntityType arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FallingBlock spawnFallingBlock(Location arg0, Material arg1, byte arg2) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FallingBlock spawnFallingBlock(Location arg0, int arg1, byte arg2) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LightningStrike strikeLightning(Location arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LightningStrike strikeLightningEffect(Location arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean unloadChunk(Chunk chunk) {
		return unloadChunk(chunk.getX(), chunk.getZ());
	}

	@Override
	public boolean unloadChunk(int x, int z) {
		return unloadChunk(x, z, true);
	}

	@Override
	public boolean unloadChunk(int x, int z, boolean save) {
		return unloadChunk(x, z, save, true);
	}

	@Override
	public boolean unloadChunk(int x, int z, boolean save, boolean safe) {
		if (safe & isChunkInUse(x, z)) {
			return false;
		}

		net.minecraft.Chunk nmsChunk = nmsWorld.chunkProviderServer.getOrCreateChunk(x, z);
		nmsChunk.removeEntities();
		if ((save || nmsWorld.chunkProviderServer.isQueuedForSaving(nmsChunk)) && !(nmsChunk instanceof EmptyChunk)) {
			nmsWorld.chunkProviderServer.requestChunkSave(nmsChunk);
		}
		nmsWorld.chunkProviderServer.cancelChunkUnload(x, z);
		nmsWorld.chunkProviderServer.removeChunk(x, z);

		return true;
	}

	@Override
	public boolean unloadChunkRequest(int x, int z) {
		return unloadChunkRequest(x, z, true);
	}

	@Override
	public boolean unloadChunkRequest(int x, int z, boolean safe) {
		if (safe & isChunkInUse(x, z)) {
			return false;
		}

		nmsWorld.chunkProviderServer.queueUnload(x, z);
		return true;
	}

	@Override
	public int hashCode() {
		return getUID().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
	if (obj == null) {
		return false;
	}
	if (!(obj instanceof PipeWorld)) {
		return false;
	}
	final PipeWorld other = (PipeWorld) obj;
		return this.getUID().equals(other.getUID());
	}

	public WorldServer getHandle() {
		return nmsWorld;
	}

}
