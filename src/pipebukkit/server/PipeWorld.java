package pipebukkit.server;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import net.minecraft.ExceptionWorldConflict;
import net.minecraft.Position;
import net.minecraft.WorldNBTStorage;
import net.minecraft.WorldServer;
import net.minecraft.server.MinecraftServer;

import org.bukkit.BlockChangeDelegate;
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
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

@SuppressWarnings("deprecation")
public class PipeWorld implements World {
	
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
	public boolean createExplosion(Location arg0, float arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createExplosion(Location arg0, float arg1, boolean arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createExplosion(double arg0, double arg1, double arg2, float arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createExplosion(double arg0, double arg1, double arg2, float arg3, boolean arg4) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createExplosion(double arg0, double arg1, double arg2, float arg3, boolean arg4, boolean arg5) {
		// TODO Auto-generated method stub
		return false;
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
	public int getAnimalSpawnLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Biome getBiome(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
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
	public ChunkSnapshot getEmptyChunkSnapshot(int arg0, int arg1, boolean arg2, boolean arg3) {
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
	public String getGameRuleValue(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getGameRules() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChunkGenerator getGenerator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Block getHighestBlockAt(Location arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Block getHighestBlockAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getHighestBlockYAt(Location arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHighestBlockYAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getHumidity(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getKeepSpawnInMemory() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<LivingEntity> getLivingEntities() {
		return new ArrayList<LivingEntity>(getEntitiesByClass(LivingEntity.class));
	}

	@Override
	public Chunk[] getLoadedChunks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMaxHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMonsterSpawnLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		return nmsWorld.getWorldData().getLevelName();
	}

	@Override
	public boolean getPVP() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Player> getPlayers() {
		return new ArrayList<Player>(getEntitiesByClass(Player.class));
	}

	@Override
	public List<BlockPopulator> getPopulators() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSeaLevel() {
		// TODO Auto-generated method stub
		return 0;
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
	public double getTemperature(int arg0, int arg1) {
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
	public long getTime() {
		return nmsWorld.getWorldData().getDayTime();
	}

	@Override
	public UUID getUID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getWaterAnimalSpawnLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWeatherDuration() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public File getWorldFolder() {
		return ((WorldNBTStorage) nmsWorld.getDataManager()).getDirectory();
	}

	@Override
	public WorldType getWorldType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasStorm() {
		return nmsWorld.getWorldData().isRaining();
	}

	@Override
	public void setStorm(boolean storm) {
		nmsWorld.getWorldData().setRaining(storm);
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
		nmsWorld.getWorldData().setThundering(thunder);
	}

	@Override
	public boolean isAutoSave() {
		return !nmsWorld.savingDisabled;
	}

	@Override
	public boolean isChunkInUse(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
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
	public boolean isGameRule(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void loadChunk(Chunk chunk) {
		loadChunk(chunk.getX(), chunk.getZ());;
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
	public void playEffect(Location arg0, Effect arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> void playEffect(Location arg0, Effect arg1, T arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playEffect(Location arg0, Effect arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> void playEffect(Location arg0, Effect arg1, T arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playSound(Location arg0, Sound arg1, float arg2, float arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean refreshChunk(int arg0, int arg1) {
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
			nmsWorld.savingDisabled = oldSave;
		} catch (ExceptionWorldConflict ex) {
			ex.printStackTrace();
		}
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
	public void setAutoSave(boolean autosave) {
		nmsWorld.savingDisabled = !autosave;
	}

	@Override
	public void setBiome(int arg0, int arg1, Biome arg2) {
		// TODO Auto-generated method stub
		
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
	public boolean setGameRuleValue(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setKeepSpawnInMemory(boolean keep) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMonsterSpawnLimit(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPVP(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSpawnFlags(boolean arg0, boolean arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean setSpawnLocation(int x, int y, int z) {
		nmsWorld.setSpawn(new Position(x, y, z));
		return true;
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
	public void setTime(long dayTime) {
		nmsWorld.getWorldData().setDayTime(dayTime);
	}

	@Override
	public void setWaterAnimalSpawnLimit(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setWeatherDuration(int arg0) {
		// TODO Auto-generated method stub
		
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
	public boolean unloadChunk(Chunk arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unloadChunk(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unloadChunk(int arg0, int arg1, boolean arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unloadChunk(int arg0, int arg1, boolean arg2, boolean arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unloadChunkRequest(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unloadChunkRequest(int arg0, int arg1, boolean arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	public WorldServer getHandle() {
		return nmsWorld;
	}

}
