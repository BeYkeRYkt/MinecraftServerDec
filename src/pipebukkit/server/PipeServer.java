package pipebukkit.server;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
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
import net.minecraft.EnumGameMode;
import net.minecraft.JsonListEntry;
import net.minecraft.WorldNBTStorage;
import net.minecraft.server.MinecraftServer;

import org.apache.commons.lang.Validate;
import org.bukkit.BanEntry;
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

import pipebukkit.server.entity.PipePlayer;
import pipebukkit.server.metadata.EntityMetadataStorage;
import pipebukkit.server.metadata.PlayerMetadataStorage;

import com.avaje.ebean.config.DataSourceConfig;
import com.avaje.ebean.config.ServerConfig;
import com.avaje.ebean.config.dbplatform.SQLitePlatform;
import com.avaje.ebeaninternal.server.lib.sql.TransactionIsolation;
import com.mojang.authlib.GameProfile;

public class PipeServer implements Server {

	private List<Player> players;
	private LinkedHashMap<String, World> worlds = new LinkedHashMap<String, World>();
	private int monsterSpawn = -1;
	private int animalSpawn = -1;
	private int waterAnimalSpawn = -1;
	private int ambientSpawn = -1;

	private File bukkitConfigurationFile = new File("bukkit.yml");
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
		bukkitConfiguration = YamlConfiguration.loadConfiguration(bukkitConfigurationFile);
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
	public int getWaterAnimalSpawnLimit() {
		return waterAnimalSpawn;
	}

	@Override
	public BanList getBanList(Type type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getIPBans() {
		Set<String> ips = new HashSet<String>();
		for (BanEntry entry : getBanList(Type.IP).getBanEntries()) {
			ips.add(entry.getTarget());
		}
		return ips;
	}

	@Override
	public void banIP(String ip) {
		Validate.notNull(ip, "Address cannot be null.");
		getBanList(Type.IP).addBan(ip, null, null, null);
	}

	@Override
	public void unbanIP(String ip) {
		Validate.notNull(ip, "Address cannot be null.");
		getBanList(Type.IP).pardon(ip);
	}

	@Override
	public Set<OfflinePlayer> getBannedPlayers() {
		Set<OfflinePlayer> players = new HashSet<OfflinePlayer>();
		for (JsonListEntry<GameProfile> banned : MinecraftServer.getInstance().getPlayerList().getProfileBans().getProfiles()) {
			players.add(new PipeOfflinePlayer(banned.getObject()));
		}
		return players;
	}

	@Override
	public Set<OfflinePlayer> getOperators() {
		Set<OfflinePlayer> players = new HashSet<OfflinePlayer>();
		for (JsonListEntry<GameProfile> banned : MinecraftServer.getInstance().getPlayerList().getOpList().getProfiles()) {
			players.add(new PipeOfflinePlayer(banned.getObject()));
		}
		return players;
	}

	@Override
	public Set<OfflinePlayer> getWhitelistedPlayers() {
		Set<OfflinePlayer> players = new HashSet<OfflinePlayer>();
		for (JsonListEntry<GameProfile> whitelisted : MinecraftServer.getInstance().getPlayerList().getWhitelist().getProfiles()) {
			players.add(new PipeOfflinePlayer(whitelisted.getObject()));
		}
		return players;
	}

	@Override
	public boolean hasWhitelist() {
		return MinecraftServer.getInstance().getPlayerList().hasWhiteList;
	}

	@Override
	public void setWhitelist(boolean whitelist) {
		MinecraftServer.getInstance().getPlayerList().hasWhiteList = whitelist;
	}

	@Override
	public void reloadWhitelist() {
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

	@SuppressWarnings("deprecation")
	@Override
	public GameMode getDefaultGameMode() {
		return GameMode.getByValue(MinecraftServer.getInstance().worlds[0].getWorldData().getGameMode().getId());
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
		return MinecraftServer.getInstance().getIdleTimeOut();
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
	public boolean getOnlineMode() {
		return MinecraftServer.getInstance().isOnlineMode();
	}

	@Override
	public Collection<? extends Player> getOnlinePlayers() {
		return players;
	}

	@Override
	public Player[] _INVALID_getOnlinePlayers() {
		return players.toArray(new PipePlayer[0]);
	}

	@Override
	public Player getPlayer(String name) {
		Validate.notNull(name, "Name cannot be null");
		Player found = null;
		String lowerName = name.toLowerCase();
		int delta = Integer.MAX_VALUE;
		for (Player player : getOnlinePlayers()) {
			if (player.getName().toLowerCase().startsWith(lowerName)) {
				int curDelta = player.getName().length() - lowerName.length();
				if (curDelta < delta) {
					found = player;
					delta = curDelta;
				}
				if (curDelta == 0) break;
			}
		}
		return found;
	}

	@Override
	public Player getPlayer(UUID uuid) {
		Validate.notNull(uuid, "UUID cannot be null");
		return MinecraftServer.getInstance().getPlayerList().getPlayer(uuid).getBukkitEntity(PipePlayer.class);
	}

	@Override
	public Player getPlayerExact(String name) {
		Validate.notNull(name, "Name cannot be null");
		for (Player player : players) {
			if (player.getName().equalsIgnoreCase(name)) {
				return player;
			} 
		}
		return null; 
	}

	@Override
	public List<Player> matchPlayer(String partialName) {
		Validate.notNull(partialName, "PartialName cannot be null");
		List<Player> matchedPlayers = new ArrayList<Player>();
		for (Player player : getOnlinePlayers()) {
			String playerName = player.getName();
			if (partialName.equalsIgnoreCase(playerName)) {
				matchedPlayers.clear();
				matchedPlayers.add(player);
				break;
			}
			if (playerName.toLowerCase().contains(partialName.toLowerCase())) {
				matchedPlayers.add(player);
			}
		}
		return matchedPlayers;
	}

	@Override
	public OfflinePlayer getOfflinePlayer(String name) {
		Validate.notNull(name, "Name cannot be null");
		OfflinePlayer result = getPlayerExact(name);
		if (result == null) {
			result = new PipeOfflinePlayer(MinecraftServer.getInstance().getUserCache().getProfile(name));
		}
		return result;
	}

	@Override
	public OfflinePlayer getOfflinePlayer(UUID uuid) {
		Validate.notNull(uuid, "UUID cannot be null");
		OfflinePlayer result = getPlayer(uuid);
		if (result == null) {
			result = new PipeOfflinePlayer(new GameProfile(uuid, null));
		}
		return result;
	}

	@Override
	public OfflinePlayer[] getOfflinePlayers() {
		WorldNBTStorage storage = (WorldNBTStorage) MinecraftServer.getInstance().worlds[0].getDataManager();
		String[] files = storage.getPlayerDir().list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".dat");
			}
		});
		Set<OfflinePlayer> players = new HashSet<OfflinePlayer>();
		for (String file : files) {
			try {
				players.add(getOfflinePlayer(UUID.fromString(file.substring(0, file.length() - 4))));
			} catch (IllegalArgumentException ex) {
			}
		}
		players.addAll(getOnlinePlayers());
		return players.toArray(new OfflinePlayer[players.size()]);
	}

	@Override
	public PluginManager getPluginManager() {
		return pluginManager;
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
		return bukkitConfiguration.getString("settings.update-folder", "update");
	}

	@Override
	public File getUpdateFolderFile() {
		return new File(getUpdateFolder());
	}

	@Override
	public int getViewDistance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public WarningState getWarningState() {
		return WarningState.DEFAULT;
	}

	@Override
	public World getWorld(String name) {
		return worlds.get(name);
	}

	@Override
	public World getWorld(UUID uuid) {
		for (World world : worlds.values()) {
			if (world.getUID().equals(uuid)) {
				return world;
			}
		}
		return null;
	}

	@Override
	public File getWorldContainer() {
		return MinecraftServer.getInstance().universe;
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
	public void savePlayers() {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void setDefaultGameMode(GameMode mode) {
		Validate.notNull(mode, "Mode cannot be null");
		MinecraftServer.getInstance().worlds[0].getWorldData().setGameMode(EnumGameMode.getById(mode.getValue()));
	}

	@Override
	public void setIdleTimeout(int timeout) {
		MinecraftServer.getInstance().setIdleTimeout(timeout);
	}

	@Override
	public void setSpawnRadius(int arg0) {
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
	public void reload() {
		// lol NOPE :D
	}

}
