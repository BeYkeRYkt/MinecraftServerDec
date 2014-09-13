package pipebukkit.server;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;

import net.minecraft.EntityPlayer;
import net.minecraft.server.MinecraftServer;

import org.apache.commons.lang.Validate;
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
import org.bukkit.command.Command;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.help.HelpMap;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.map.MapView;
import org.bukkit.permissions.Permissible;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.SimplePluginManager;
import org.bukkit.plugin.SimpleServicesManager;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.plugin.messaging.StandardMessenger;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.util.CachedServerIcon;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.SafeConstructor;

import pipebukkit.server.entity.PipePlayer;
import pipebukkit.server.metadata.EntityMetadataStorage;
import pipebukkit.server.metadata.PlayerMetadataStorage;

import com.avaje.ebean.config.DataSourceConfig;
import com.avaje.ebean.config.ServerConfig;
import com.avaje.ebean.config.dbplatform.SQLitePlatform;
import com.avaje.ebeaninternal.server.lib.sql.TransactionIsolation;

public class PipeServer implements Server {

	private List<Player> players;
	private LinkedHashMap<String, World> worlds = new LinkedHashMap<String, World>();
	private int monsterSpawn = -1;
	private int animalSpawn = -1;
	private int waterAnimalSpawn = -1;
	private int ambientSpawn = -1;

	private YamlConfiguration bukkitConfiguration;

	private SimpleCommandMap commandMap = new SimpleCommandMap(this);
	private StandardMessenger messenger = new StandardMessenger();
	private PluginManager pluginManager = new SimplePluginManager(this, commandMap);
	private ServicesManager servicesManager = new SimpleServicesManager();

	private EntityMetadataStorage entityMetadata = new EntityMetadataStorage();
	private PlayerMetadataStorage playerMetadata = new PlayerMetadataStorage();

	public PipeServer() {
		Bukkit.setServer(this);
		players = Collections.unmodifiableList(com.google.common.collect.Lists.transform(MinecraftServer.getInstance().getPlayerList().players, new com.google.common.base.Function<EntityPlayer, Player>() {
			@Override
			public Player apply(EntityPlayer player) {
				return player.getBukkitEntity(Player.class);
			}
		}));
		bukkitConfiguration = YamlConfiguration.loadConfiguration(new File("bukkit.yml"));
	}

	public EntityMetadataStorage getEntityMetadataStorage() {
		return entityMetadata;
	}

	public PlayerMetadataStorage getPlayerMetadataStorage() {
		return playerMetadata;
	}

	@Override
	public Set<String> getListeningPluginChannels() {
		Set<String> channels = new HashSet<String>();
		for (Player player : getOnlinePlayers()) {
			channels.addAll(player.getListeningPluginChannels());
		}
		return channels;
	}

	@Override
	public void sendPluginMessage(Plugin plugin, String channelName, byte[] message) {
		StandardMessenger.validatePluginMessage(getMessenger(), plugin, channelName, message);
		for (Player player : getOnlinePlayers()) {
			player.sendPluginMessage(plugin, channelName, message);
		}
	}

	@Override
	public boolean addRecipe(Recipe arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clearRecipes() {
		// TODO Auto-generated method stub
	}

	@Override
	public Iterator<Recipe> recipeIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Recipe> getRecipesFor(ItemStack arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void resetRecipes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int broadcast(String message, String permission) {
		int count = 0;
		Set<Permissible> permissibles = getPluginManager().getPermissionSubscriptions(permission);
		for (Permissible permissible : permissibles) {
			if (permissible instanceof CommandSender && permissible.hasPermission(permission)) {
				CommandSender user = (CommandSender) permissible;
				user.sendMessage(message);
				count++;
			}
		}
		return count;
	}

	@Override
	public int broadcastMessage(String message) {
		return broadcast(message, BROADCAST_CHANNEL_USERS);
	}

	@Override
	public void configureDbConfig(ServerConfig config) {
		Validate.notNull(config, "Config cannot be null");
		DataSourceConfig ds = new DataSourceConfig();
		ds.setDriver(bukkitConfiguration.getString("database.driver"));
		ds.setUrl(bukkitConfiguration.getString("database.url"));
		ds.setUsername(bukkitConfiguration.getString("database.username"));
		ds.setPassword(bukkitConfiguration.getString("database.password"));
		ds.setIsolationLevel(TransactionIsolation.getLevel(bukkitConfiguration.getString("database.isolation")));
		if (ds.getDriver().contains("sqlite")) {
			config.setDatabasePlatform(new SQLitePlatform());
			config.getDatabasePlatform().getDbDdlSyntax().setIdentity("");
		}
		config.setDataSourceConfig(ds);
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
	public World createWorld(WorldCreator creator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean dispatchCommand(CommandSender sender, String command) throws CommandException {
		Validate.notNull(sender, "Sender cannot be null");
		Validate.notNull(command, "Command cannot be null");
		if (commandMap.dispatch(sender, command)) {
			return true;
		}
		if (sender instanceof Player) {
			sender.sendMessage("Unknown command. Type \"/help\" for help.");
		} else {
			sender.sendMessage("Unknown command. Type \"help\" for help.");
		}
		return false;
	}

	@Override
	public boolean getAllowEnd() {
		return bukkitConfiguration.getBoolean("settings.allow-end");
	}

	@Override
	public boolean getAllowFlight() {
		return MinecraftServer.getInstance().isFlightAllowed();
	}

	@Override
	public boolean getAllowNether() {
		return MinecraftServer.getInstance().isNetherAllowed();
	}

	@Override
	public int getAmbientSpawnLimit() {
		return ambientSpawn;
	}

	@Override
	public int getAnimalSpawnLimit() {
		return animalSpawn;
	}

	@Override
	public int getMonsterSpawnLimit() {
		return monsterSpawn;
	}

	@Override
	public void banIP(String arg0) {
		// TODO Auto-generated method stub
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
	public Set<String> getIPBans() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void unbanIP(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, String[]> getCommandAliases() {
		return new HashMap<String, String[]>();
	}

	@Override
	public long getConnectionThrottle() {
		return -1;
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
		return MinecraftServer.getInstance().isStructureGenerationEnabled();
	}

	@Override
	public HelpMap getHelpMap() {
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
		return Logger.getLogger("Minecraft");
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
		return messenger;
	}

	@Override
	public String getMotd() {
		return MinecraftServer.getInstance().getMotd();
	}

	@Override
	public String getBukkitVersion() {
		return "1.7.10";
	}

	@Override
	public String getName() {
		return "PipeBukkit";
	}

	@Override
	public String getVersion() {
		return "indev (MC: 1.8)";
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
		return MinecraftServer.getInstance().isOnlineMode();
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
	public PluginCommand getPluginCommand(String commandName) {
		Command command = commandMap.getCommand(commandName);
		if (command instanceof PluginCommand) {
			return (PluginCommand) command;
		}
		return null;
	}

	@Override
	public PluginManager getPluginManager() {
		return pluginManager;
	}

	@Override
	public int getPort() {
		return MinecraftServer.getInstance().getPort();
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
		return servicesManager;
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
		return new ArrayList<World>(worlds.values());
	}

	@Override
	public boolean hasWhitelist() {
		return MinecraftServer.getInstance().getPlayerList().hasWhiteList;
	}

	@Override
	public boolean isHardcore() {
		return MinecraftServer.getInstance().isHardcore();
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
	public void reload() {
		// lol NOPE :D
	}

	@Override
	public void reloadWhitelist() {
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
