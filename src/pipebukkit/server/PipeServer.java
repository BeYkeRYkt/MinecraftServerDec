package pipebukkit.server;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;

import net.minecraft.EntityPlayer;
import net.minecraft.server.MinecraftServer;

import org.bukkit.BanList;
import org.bukkit.BanList.Type;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.UnsafeValues;
import org.bukkit.Warning.WarningState;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.help.HelpMap;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.map.MapView;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.util.CachedServerIcon;

import pipebukkit.server.entity.PipePlayer;
import pipebukkit.server.metadata.EntityMetadataStorage;

import com.avaje.ebean.config.ServerConfig;

public class PipeServer implements Server {

	private List<Player> players;

	private EntityMetadataStorage entityMetadata = new EntityMetadataStorage();

	public PipeServer() {
		Bukkit.setServer(this);
		players = Collections.unmodifiableList(com.google.common.collect.Lists.transform(MinecraftServer.getInstance().getPlayerList().players, new com.google.common.base.Function<EntityPlayer, Player>() {
			@Override
			public Player apply(EntityPlayer player) {
				return player.getBukkitEntity(Player.class);
			}
		}));
	}

	public EntityMetadataStorage getEntityMetadataStorage() {
		return entityMetadata;
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
	public boolean addRecipe(Recipe arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void banIP(String arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public int broadcast(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int broadcastMessage(String arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clearRecipes() {
		// TODO Auto-generated method stub
	}

	@Override
	public void configureDbConfig(ServerConfig arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public Inventory createInventory(InventoryHolder arg0, InventoryType arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inventory createInventory(InventoryHolder arg0, int arg1) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inventory createInventory(InventoryHolder arg0, InventoryType arg1, String arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inventory createInventory(InventoryHolder arg0, int arg1, String arg2) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MapView createMap(World arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public World createWorld(WorldCreator arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean dispatchCommand(CommandSender arg0, String arg1) throws CommandException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getAllowEnd() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getAllowFlight() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getAllowNether() {
		return MinecraftServer.getInstance().isNetherAllowed();
	}

	@Override
	public int getAmbientSpawnLimit() {
		// TODO Auto-generated method stub
		return 15;
	}

	@Override
	public int getAnimalSpawnLimit() {
		// TODO Auto-generated method stub
		return 30;
	}

	@Override
	public BanList getBanList(Type arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<OfflinePlayer> getBannedPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBukkitVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String[]> getCommandAliases() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getConnectionThrottle() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ConsoleCommandSender getConsoleSender() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameMode getDefaultGameMode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getGenerateStructures() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HelpMap getHelpMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getIPBans() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getIdleTimeout() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getIp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemFactory getItemFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Logger getLogger() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MapView getMap(short arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMaxPlayers() {
		return MinecraftServer.getInstance().getPlayerList().getMaxPlayers();
	}

	@Override
	public Messenger getMessenger() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMonsterSpawnLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getMotd() {
		return MinecraftServer.getInstance().getMotd();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfflinePlayer getOfflinePlayer(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfflinePlayer getOfflinePlayer(UUID arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfflinePlayer[] getOfflinePlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getOnlineMode() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<? extends Player> getOnlinePlayers() {
		return players;
	}

	@Override
	public Set<OfflinePlayer> getOperators() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player getPlayer(String name) {
		for (Player player : players) {
			if (player.getName().equalsIgnoreCase(name)) {
				return player;
			} 
		}
		return null; 
	}

	@Override
	public Player getPlayer(UUID uuid) {
		return MinecraftServer.getInstance().getPlayerList().getPlayer(uuid).getBukkitEntity(PipePlayer.class);
	}

	@Override
	public Player getPlayerExact(String name) {
		for (Player player : players) {
			if (player.getName().equalsIgnoreCase(name)) {
				return player;
			} 
		}
		return null; 
	}

	@Override
	public PluginCommand getPluginCommand(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PluginManager getPluginManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPort() {
		return MinecraftServer.getInstance().getPort();
	}

	@Override
	public List<Recipe> getRecipesFor(ItemStack arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BukkitScheduler getScheduler() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScoreboardManager getScoreboardManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CachedServerIcon getServerIcon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServerId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServerName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServicesManager getServicesManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getShutdownMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSpawnRadius() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTicksPerAnimalSpawns() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTicksPerMonsterSpawns() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UnsafeValues getUnsafe() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUpdateFolder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File getUpdateFolderFile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getViewDistance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public WarningState getWarningState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getWaterAnimalSpawnLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Set<OfflinePlayer> getWhitelistedPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public World getWorld(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public World getWorld(UUID arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File getWorldContainer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getWorldType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<World> getWorlds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasWhitelist() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isHardcore() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPrimaryThread() {
		return MinecraftServer.getInstance().isMainThread();
	}

	@Override
	public CachedServerIcon loadServerIcon(File arg0) throws IllegalArgumentException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CachedServerIcon loadServerIcon(BufferedImage arg0) throws IllegalArgumentException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> matchPlayer(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Recipe> recipeIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reload() {
		// lol NOPE :D
	}

	@Override
	public void reloadWhitelist() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetRecipes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void savePlayers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDefaultGameMode(GameMode arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIdleTimeout(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSpawnRadius(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setWhitelist(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shutdown() {
		MinecraftServer.getInstance().stopTicking();
	}

	@Override
	public void unbanIP(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean unloadWorld(String arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unloadWorld(World arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean useExactLoginLocation() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Player[] _INVALID_getOnlinePlayers() {
		return players.toArray(new PipePlayer[0]);
	}

}
