package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import net.minecraft.util.com.mojang.authlib.GameProfile;
import net.minecraft.util.io.netty.buffer.Unpooled;

import java.io.File;
import java.net.SocketAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

import net.minecraft.PacketPlayOutListItem.ListItemAction;
import net.minecraft.PacketPlayOutWorldBorder.WorldBorderAction;
import net.minecraft.server.MinecraftServer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.event.player.PlayerQuitEvent;

public abstract class PlayerList {

	public static final File bannedPlayersFile = new File("banned-players.json");
	public static final File bannedIPsFile = new File("banned-ips.json");
	public static final File opsFile = new File("ops.json");
	public static final File whitelistFile = new File("whitelist.json");
	private final GameProfileBanList playerBanList;
	private final IpBanList ipBanList;
	private final OpList opList;
	private final WhiteList whiteList;
	private static final Logger logger = LogManager.getLogger();
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd \'at\' HH:mm:ss z");
	private final MinecraftServer minecraftserver;
	public final List<EntityPlayer> players = new CopyOnWriteArrayList<EntityPlayer>();
	public final Map<UUID, EntityPlayer> uuidToPlayerMap = Maps.newHashMap();
	private final Map<UUID, StatisticManager> playersStatistic = Maps.newHashMap();
	public IPlayerFileData playerFileData;
	public boolean hasWhiteList;
	protected int maxPlayers;
	private int r;
	private EnumGameMode s;
	private boolean everyoneIsOp;
	private int pingUpdateCounter;

	public PlayerList(MinecraftServer minecraftserver) {
		this.minecraftserver = minecraftserver;
		this.playerBanList = new GameProfileBanList(bannedPlayersFile);
		this.ipBanList = new IpBanList(bannedIPsFile);
		this.opList = new OpList(opsFile);
		this.whiteList = new WhiteList(whitelistFile);
		this.playerBanList.setEnabled(false);
		this.ipBanList.setEnabled(false);
		this.maxPlayers = 8;
	}

	public void join(NetworkManager networkManager, EntityPlayer player) {
		GameProfile var3 = player.getGameProfile();
		UserCache var4 = this.minecraftserver.getUserCache();
		GameProfile var5 = var4.getProfile(var3.getId());
		String var6 = var5 == null ? var3.getName() : var5.getName();
		var4.saveProfile(var3);
		NBTCompoundTag var7 = this.a(player);
		player.setWorld((World) this.minecraftserver.getWorldServer(player.dimensionId));
		player.playerInteractManager.setWorldServer((WorldServer) player.world);
		String var8 = "local";
		if (networkManager.getAddress() != null) {
			var8 = networkManager.getAddress().toString();
		}

		logger.info(player.getName() + "[" + var8 + "] logged in with entity id " + player.getId() + " at (" + player.locationX + ", " + player.locationY + ", " + player.locationZ + ")");
		WorldServer worldServer = this.minecraftserver.getWorldServer(player.dimensionId);
		WorldData worldData = worldServer.getWorldData();
		Position var11 = worldServer.getSpawnPosition();
		this.a(player, (EntityPlayer) null, worldServer);
		PlayerConnection var12 = new PlayerConnection(this.minecraftserver, networkManager, player);
		var12.sendPacket((new PacketPlayOutJoinGame(player.getId(), player.playerInteractManager.getGameMode(), worldData.isHardcore(), worldServer.worldProvider.getDimensionId(), worldServer.getDifficulty(), this.getMaxPlayers(), worldData.getLevelType(), worldServer.getGameRules().isGameRule("reducedDebugInfo"))));
		var12.sendPacket((new PacketPlayOutPluginMessage("MC|Brand", (new PacketDataSerializer(Unpooled.buffer())).writeString(this.c().getServerModName()))));
		var12.sendPacket((new PacketPlayOutServerDifficulty(worldData.getDifficulty(), worldData.isDifficultyLocked())));
		var12.sendPacket((new PacketPlayOutSpawnPosition(var11)));
		var12.sendPacket((new PacketPlayOutPlayerAbilities(player.playerProperties)));
		var12.sendPacket((new PacketPlayOutHeldItemChange(player.playerInventory.itemInHandIndex)));
		player.getStatisticManager().d();
		player.getStatisticManager().b(player);
		this.a((pk) worldServer.Z(), player);
		this.minecraftserver.requestServerPingRefresh();
		this.addPlayerToGame(player);
		var12.movePlayer(player.locationX, player.locationY, player.locationZ, player.yaw, player.pitch);
		this.updateWorldData(player, worldServer);
		if (this.minecraftserver.aa().length() > 0) {
			player.a(this.minecraftserver.aa(), this.minecraftserver.ab());
		}

		Iterator var14 = player.bk().iterator();

		while (var14.hasNext()) {
			MobEffect var15 = (MobEffect) var14.next();
			var12.sendPacket((new PacketPlayOutEntityEffect(player.getId(), var15)));
		}

		player.f_();
		if (var7 != null && var7.isTagAssignableFrom("Riding", 10)) {
			Entity var16 = EntityTypes.loadEntity(var7.getCompound("Riding"), (World) worldServer);
			if (var16 != null) {
				var16.n = true;
				worldServer.addEntity(var16);
				player.mount(var16);
				var16.n = false;
			}
		}

	}

	protected void a(pk var1, EntityPlayer var2) {
		HashSet var3 = Sets.newHashSet();
		Iterator var4 = var1.g().iterator();

		while (var4.hasNext()) {
			ScoreboardTeam var5 = (ScoreboardTeam) var4.next();
			var2.playerConnection.sendPacket((Packet) (new PacketPlayOutScoreboardTeam(var5, 0)));
		}

		for (int var9 = 0; var9 < 19; ++var9) {
			ScoreboardObjective var10 = var1.a(var9);
			if (var10 != null && !var3.contains(var10)) {
				List var6 = var1.d(var10);
				Iterator var7 = var6.iterator();

				while (var7.hasNext()) {
					Packet var8 = (Packet) var7.next();
					var2.playerConnection.sendPacket(var8);
				}

				var3.add(var10);
			}
		}

	}

	public void setPlayerFileData(WorldServer[] worlds) {
		this.playerFileData = worlds[0].getDataManager().getPlayerFileData();
		worlds[0].getWorldBorder().addChangeListener(new PlayerUpdaterWorldBorderChangeListener(this));
	}

	public void a(EntityPlayer var1, WorldServer var2) {
		WorldServer var3 = var1.getWorldServer();
		if (var2 != null) {
			var2.getPlayerChunkMap().c(var1);
		}

		var3.getPlayerChunkMap().a(var1);
		var3.chunkProviderServer.getChunkAt((int) var1.locationX >> 4, (int) var1.locationZ >> 4);
	}

	public int d() {
		return PlayerChunkMap.b(this.t());
	}

	public NBTCompoundTag a(EntityPlayer var1) {
		NBTCompoundTag var3 = this.playerFileData.load(var1);
		return var3;
	}

	protected void savePlayerData(EntityPlayer player) {
		this.playerFileData.save(player);
		StatisticManager var2 = (StatisticManager) this.playersStatistic.get(player.getUUID());
		if (var2 != null) {
			var2.write();
		}

	}

	public void addPlayerToGame(EntityPlayer player) {
		this.players.add(player);
		this.uuidToPlayerMap.put(player.getUUID(), player);

		PlayerJoinEvent joinEvent = new PlayerJoinEvent(player.getBukkitEntity(Player.class), EnumChatFormat.YELLOW + player.getName() + " joined the game");
		Bukkit.getPluginManager().callEvent(joinEvent);
		if (joinEvent.getJoinMessage() != null && !joinEvent.getJoinMessage().isEmpty()) {
			ChatMessage chatMessage = new ChatMessage(joinEvent.getJoinMessage());
			this.minecraftserver.getPlayerList().sendMessage(chatMessage);
		}

		this.sendPacket(new PacketPlayOutListItem(ListItemAction.ADD_PLAYER, new EntityPlayer[] { player }));
		WorldServer worldServer = this.minecraftserver.getWorldServer(player.dimensionId);
		if (worldServer.getPlayer(player.getUUID()) == null) {
			worldServer.addEntity(player);
			this.a(player, (WorldServer) null);
		}

		for (int i = 0; i < this.players.size(); ++i) {
			EntityPlayer otherPlayer = (EntityPlayer) this.players.get(i);
			player.playerConnection.sendPacket(new PacketPlayOutListItem(ListItemAction.ADD_PLAYER, new EntityPlayer[] { otherPlayer }));
		}

	}

	public void d(EntityPlayer var1) {
		var1.getWorldServer().getPlayerChunkMap().d(var1);
	}

	public void disconnect(EntityPlayer player) {
		InventoryCloseEvent closeEvent = new InventoryCloseEvent(player.getBukkitEntity(Player.class).getOpenInventory());
		Bukkit.getPluginManager().callEvent(closeEvent);
		player.removeWindow();
		PlayerQuitEvent quitEvent = new PlayerQuitEvent(player.getBukkitEntity(Player.class), EnumChatFormat.YELLOW + player.getName()+ " left the game");
		Bukkit.getPluginManager().callEvent(quitEvent);
		if (quitEvent.getQuitMessage() != null && !quitEvent.getQuitMessage().isEmpty()) {
			ChatMessage chatMessage = new ChatMessage(quitEvent.getQuitMessage());
			this.minecraftserver.getPlayerList().sendMessage(chatMessage);
		}
		player.b(StatisticList.f);
		this.savePlayerData(player);
		WorldServer worldServer = player.getWorldServer();
		if (player.vehicle != null) {
			worldServer.f(player.vehicle);
			logger.debug("removing player mount");
		}

		worldServer.e(player);
		worldServer.getPlayerChunkMap().c(player);
		this.players.remove(player);
		this.uuidToPlayerMap.remove(player.getUUID());
		this.playersStatistic.remove(player.getUUID());
		this.sendPacket(new PacketPlayOutListItem(ListItemAction.REMOVE_PLAYER, new EntityPlayer[] { player }));
	}

	public void checkPlayerJoin(PlayerLoginEvent event, SocketAddress address, GameProfile profile) {
		String message;
		if (this.playerBanList.isBanned(profile)) {
			GameProfileBanEntry entry = (GameProfileBanEntry) this.playerBanList.get(profile);
			message = "You are banned from this server!\nReason: " + entry.getSource();
			if (entry.getExpires() != null) {
				message = message + "\nYour ban will be removed on " + dateFormat.format(entry.getExpires());
			}

			event.disallow(Result.KICK_BANNED, message);
		} else if (!this.canJoin(profile)) {
			event.disallow(Result.KICK_WHITELIST, "You are not white-listed on this server!");
		} else if (this.ipBanList.isBanned(address)) {
			IpBanEntry entry = this.ipBanList.getBanEntry(address);
			message = "Your IP address is banned from this server!\nReason: " + entry.getSource();
			if (entry.getExpires() != null) {
				message = message + "\nYour ban will be removed on " + dateFormat.format(entry.getExpires());
			}

			event.disallow(Result.KICK_BANNED, message);
		} else {
			if (this.players.size() >= this.maxPlayers) {
				event.disallow(Result.KICK_FULL, "The server is full!");
			}
		}
	}

	public void kickDuplicatePlayers(GameProfile gameProfile) {
		UUID uuid = EntityHuman.a(gameProfile);

		ArrayList<EntityPlayer> toKick = Lists.newArrayList();
		for (EntityPlayer player : players) {
			if (player.getUUID().equals(uuid)) {
				toKick.add(player);
			}
		}

		for (EntityPlayer player : toKick) {
			player.playerConnection.disconnect("You logged in from another location");
		}
	}

	public EntityPlayer moveToWorld(EntityPlayer var1, int var2, boolean var3) {
		var1.getWorldServer().getEntityTracker().b(var1);
		var1.getWorldServer().getEntityTracker().b((Entity) var1);
		var1.getWorldServer().getPlayerChunkMap().c(var1);
		this.players.remove(var1);
		this.minecraftserver.getWorldServer(var1.dimensionId).f(var1);
		Position var4 = var1.cg();
		boolean var5 = var1.ch();
		var1.dimensionId = var2;

		EntityPlayer newEntityPlayer = new EntityPlayer(this.minecraftserver, this.minecraftserver.getWorldServer(var1.dimensionId), var1.getGameProfile(), new PlayerInteractManager(this.minecraftserver.getWorldServer(var1.dimensionId)));
		newEntityPlayer.playerConnection = var1.playerConnection;
		newEntityPlayer.a((EntityHuman) var1, var3);
		newEntityPlayer.setId(var1.getId());
		newEntityPlayer.o(var1);
		WorldServer var8 = this.minecraftserver.getWorldServer(var1.dimensionId);
		this.a(newEntityPlayer, var1, var8);
		Position var9;
		if (var4 != null) {
			var9 = EntityHuman.a(this.minecraftserver.getWorldServer(var1.dimensionId), var4, var5);
			if (var9 != null) {
				newEntityPlayer.setPositionRotation((double) ((float) var9.getX() + 0.5F), (double) ((float) var9.getY() + 0.1F), (double) ((float) var9.getZ() + 0.5F), 0.0F, 0.0F);
				newEntityPlayer.a(var4, var5);
			} else {
				newEntityPlayer.playerConnection.sendPacket((Packet) (new PacketPlayOutChangeGameState(0, 0.0F)));
			}
		}

		var8.chunkProviderServer.getChunkAt((int) newEntityPlayer.locationX >> 4, (int) newEntityPlayer.locationZ >> 4);

		while (!var8.getCubes((Entity) newEntityPlayer, newEntityPlayer.getBoundingBox()).isEmpty() && newEntityPlayer.locationY < 256.0D) {
			newEntityPlayer.b(newEntityPlayer.locationX, newEntityPlayer.locationY + 1.0D, newEntityPlayer.locationZ);
		}

		newEntityPlayer.playerConnection.sendPacket((Packet) (new PacketPlayOutRespawn(newEntityPlayer.dimensionId, newEntityPlayer.world.getDifficulty(), newEntityPlayer.world.getWorldData().getLevelType(), newEntityPlayer.playerInteractManager.getGameMode())));
		var9 = var8.getSpawnPosition();
		newEntityPlayer.playerConnection.movePlayer(newEntityPlayer.locationX, newEntityPlayer.locationY, newEntityPlayer.locationZ, newEntityPlayer.yaw, newEntityPlayer.pitch);
		newEntityPlayer.playerConnection.sendPacket((Packet) (new PacketPlayOutSpawnPosition(var9)));
		newEntityPlayer.playerConnection.sendPacket((Packet) (new PacketPlayOutSetExpirience(newEntityPlayer.xp, newEntityPlayer.xpTotal, newEntityPlayer.xpLevel)));
		this.updateWorldData(newEntityPlayer, var8);
		var8.getPlayerChunkMap().a(newEntityPlayer);
		var8.addEntity(newEntityPlayer);
		this.players.add(newEntityPlayer);
		this.uuidToPlayerMap.put(newEntityPlayer.getUUID(), newEntityPlayer);
		newEntityPlayer.f_();
		newEntityPlayer.h(newEntityPlayer.getHealth());
		return newEntityPlayer;
	}

	public void a(EntityPlayer var1, int var2) {
		int var3 = var1.dimensionId;
		WorldServer var4 = this.minecraftserver.getWorldServer(var1.dimensionId);
		var1.dimensionId = var2;
		WorldServer var5 = this.minecraftserver.getWorldServer(var1.dimensionId);
		var1.playerConnection.sendPacket((Packet) (new PacketPlayOutRespawn(var1.dimensionId, var1.world.getDifficulty(), var1.world.getWorldData().getLevelType(), var1.playerInteractManager.getGameMode())));
		var4.f(var1);
		var1.dead = false;
		this.a(var1, var3, var4, var5);
		this.a(var1, var4);
		var1.playerConnection.movePlayer(var1.locationX, var1.locationY, var1.locationZ, var1.yaw, var1.pitch);
		var1.playerInteractManager.setWorldServer(var5);
		this.updateWorldData(var1, var5);
		this.f(var1);
		Iterator var6 = var1.bk().iterator();

		while (var6.hasNext()) {
			MobEffect var7 = (MobEffect) var6.next();
			var1.playerConnection.sendPacket((Packet) (new PacketPlayOutEntityEffect(var1.getId(), var7)));
		}

	}

	public void a(Entity var1, int var2, WorldServer var3, WorldServer var4) {
		double var5 = var1.locationX;
		double var7 = var1.locationZ;
		double var9 = 8.0D;
		float var11 = var1.yaw;
		var3.B.a("moving");
		if (var1.dimensionId == -1) {
			var5 = MathHelper.a(var5 / var9, var4.getWorldBorder().getMinX() + 16.0D, var4.getWorldBorder().getMaxX() - 16.0D);
			var7 = MathHelper.a(var7 / var9, var4.getWorldBorder().getMinZ() + 16.0D, var4.getWorldBorder().getMaxZ() - 16.0D);
			var1.setPositionRotation(var5, var1.locationY, var7, var1.yaw, var1.pitch);
			if (var1.isAlive()) {
				var3.a(var1, false);
			}
		} else if (var1.dimensionId == 0) {
			var5 = MathHelper.a(var5 * var9, var4.getWorldBorder().getMinX() + 16.0D, var4.getWorldBorder().getMaxX() - 16.0D);
			var7 = MathHelper.a(var7 * var9, var4.getWorldBorder().getMinZ() + 16.0D, var4.getWorldBorder().getMaxZ() - 16.0D);
			var1.setPositionRotation(var5, var1.locationY, var7, var1.yaw, var1.pitch);
			if (var1.isAlive()) {
				var3.a(var1, false);
			}
		} else {
			Position var12;
			if (var2 == 1) {
				var12 = var4.getSpawnPosition();
			} else {
				var12 = var4.getDimensionSpawn();
			}

			var5 = (double) var12.getX();
			var1.locationY = (double) var12.getY();
			var7 = (double) var12.getZ();
			var1.setPositionRotation(var5, var1.locationY, var7, 90.0F, 0.0F);
			if (var1.isAlive()) {
				var3.a(var1, false);
			}
		}

		var3.B.b();
		if (var2 != 1) {
			var3.B.a("placing");
			var5 = (double) MathHelper.a((int) var5, -29999872, 29999872);
			var7 = (double) MathHelper.a((int) var7, -29999872, 29999872);
			if (var1.isAlive()) {
				var1.setPositionRotation(var5, var1.locationY, var7, var1.yaw, var1.pitch);
				var4.getPortalTravelAgent().a(var1, var11);
				var4.addEntity(var1);
				var4.a(var1, false);
			}

			var3.B.b();
		}

		var1.setWorld((World) var4);
	}

	public void e() {
		if (++this.pingUpdateCounter > 600) {
			this.sendPacket((Packet) (new PacketPlayOutListItem(ListItemAction.UPDATE_LATENCY, this.players)));
			this.pingUpdateCounter = 0;
		}

	}

	public void sendPacket(Packet<? extends PacketListener> var1) {
		for (EntityPlayer entity : this.players) {
			entity.playerConnection.sendPacket(var1);
		}

	}

	public void sendPacket(Packet<? extends PacketListener> var1, int dimensionId) {
		for (EntityPlayer entity : this.players) {
			if (entity.dimensionId == dimensionId) {
				entity.playerConnection.sendPacket(var1);
			}
		}
	}

	public void a(EntityHuman var1, IChatBaseComponent var2) {
		ScoreboardTeamBase var3 = var1.bN();
		if (var3 != null) {
			Collection var4 = var3.getPlayerNameSet();
			Iterator var5 = var4.iterator();

			while (var5.hasNext()) {
				String var6 = (String) var5.next();
				EntityPlayer var7 = this.getPlayer(var6);
				if (var7 != null && var7 != var1) {
					var7.sendChatMessage(var2);
				}
			}

		}
	}

	public void b(EntityHuman var1, IChatBaseComponent var2) {
		ScoreboardTeamBase var3 = var1.bN();
		if (var3 == null) {
			this.sendMessage(var2);
		} else {
			for (int var4 = 0; var4 < this.players.size(); ++var4) {
				EntityPlayer var5 = (EntityPlayer) this.players.get(var4);
				if (var5.bN() != var3) {
					var5.sendChatMessage(var2);
				}
			}

		}
	}

	public String f() {
		String var1 = "";

		for (int var2 = 0; var2 < this.players.size(); ++var2) {
			if (var2 > 0) {
				var1 = var1 + ", ";
			}

			var1 = var1 + ((EntityPlayer) this.players.get(var2)).getName();
		}

		return var1;
	}

	public String[] g() {
		String[] var1 = new String[this.players.size()];

		for (int var2 = 0; var2 < this.players.size(); ++var2) {
			var1[var2] = ((EntityPlayer) this.players.get(var2)).getName();
		}

		return var1;
	}

	public GameProfile[] h() {
		GameProfile[] var1 = new GameProfile[this.players.size()];

		for (int var2 = 0; var2 < this.players.size(); ++var2) {
			var1[var2] = ((EntityPlayer) this.players.get(var2)).getGameProfile();
		}

		return var1;
	}

	public void a(double var1, double var3, double var5, double var7, int var9, Packet var10) {
		this.a((EntityHuman) null, var1, var3, var5, var7, var9, var10);
	}

	public void a(EntityHuman var1, double var2, double var4, double var6, double var8, int var10, Packet var11) {
		for (int var12 = 0; var12 < this.players.size(); ++var12) {
			EntityPlayer var13 = (EntityPlayer) this.players.get(var12);
			if (var13 != var1 && var13.dimensionId == var10) {
				double var14 = var2 - var13.locationX;
				double var16 = var4 - var13.locationY;
				double var18 = var6 - var13.locationZ;
				if (var14 * var14 + var16 * var16 + var18 * var18 < var8 * var8) {
					var13.playerConnection.sendPacket(var11);
				}
			}
		}

	}

	public void savePlayers() {
		for (int var1 = 0; var1 < this.players.size(); ++var1) {
			this.savePlayerData((EntityPlayer) this.players.get(var1));
		}

	}

	public void a() {
	}

	public void updateWorldData(EntityPlayer var1, WorldServer var2) {
		WorldBorder var3 = this.minecraftserver.getWorld().getWorldBorder();
		var1.playerConnection.sendPacket((Packet) (new PacketPlayOutWorldBorder(var3, WorldBorderAction.INITIALIZE)));
		var1.playerConnection.sendPacket((Packet) (new PacketPlayOutTimeUpdate(var2.getTime(), var2.getDayTime(), var2.getGameRules().isGameRule("doDaylightCycle"))));
		if (var2.S()) {
			var1.playerConnection.sendPacket((Packet) (new PacketPlayOutChangeGameState(1, 0.0F)));
			var1.playerConnection.sendPacket((Packet) (new PacketPlayOutChangeGameState(7, var2.j(1.0F))));
			var1.playerConnection.sendPacket((Packet) (new PacketPlayOutChangeGameState(8, var2.h(1.0F))));
		}

	}

	public void f(EntityPlayer var1) {
		var1.sendContainerItems(var1.defaultContainer);
		var1.r();
		var1.playerConnection.sendPacket((Packet) (new PacketPlayOutHeldItemChange(var1.playerInventory.itemInHandIndex)));
	}

	public String[] r() {
		return this.minecraftserver.getWorld().getDataManager().getPlayerFileData().getSeenPlayers();
	}

	public boolean s() {
		return this.hasWhiteList;
	}

	public void a(boolean var1) {
		this.hasWhiteList = var1;
	}

	public List b(String var1) {
		ArrayList var2 = Lists.newArrayList();
		Iterator var3 = this.players.iterator();

		while (var3.hasNext()) {
			EntityPlayer var4 = (EntityPlayer) var3.next();
			if (var4.w().equals(var1)) {
				var2.add(var4);
			}
		}

		return var2;
	}

	public int t() {
		return this.r;
	}

	public MinecraftServer c() {
		return this.minecraftserver;
	}

	public NBTCompoundTag u() {
		return null;
	}

	private void a(EntityPlayer var1, EntityPlayer var2, World var3) {
		if (var2 != null) {
			var1.playerInteractManager.setGameMode(var2.playerInteractManager.getGameMode());
		} else if (this.s != null) {
			var1.playerInteractManager.setGameMode(this.s);
		}

		var1.playerInteractManager.b(var3.getWorldData().getGameMode());
	}

	public void kickAll() {
		for (int i = 0; i < this.players.size(); ++i) {
			(this.players.get(i)).playerConnection.disconnect(Bukkit.getShutdownMessage() != null ? Bukkit.getShutdownMessage() : "Server closed");
		}
	}

	public void sendMessage(IChatBaseComponent var1, boolean var2) {
		this.minecraftserver.sendChatMessage(var1);
		int var3 = var2 ? 1 : 0;
		this.sendPacket((Packet) (new PacketPlayOutChatMessage(var1, (byte) var3)));
	}

	public void sendMessage(IChatBaseComponent var1) {
		this.sendMessage(var1, true);
	}

	public StatisticManager getPLayerStatistic(EntityHuman var1) {
		UUID var2 = var1.getUUID();
		StatisticManager var3 = var2 == null ? null : (StatisticManager) this.playersStatistic.get(var2);
		if (var3 == null) {
			File var4 = new File(this.minecraftserver.getWorldServer(0).getDataManager().getDirectory(), "stats");
			File var5 = new File(var4, var2.toString() + ".json");
			if (!var5.exists()) {
				File var6 = new File(var4, var1.getName() + ".json");
				if (var6.exists() && var6.isFile()) {
					var6.renameTo(var5);
				}
			}

			var3 = new StatisticManager(this.minecraftserver, var5);
			var3.read();
			this.playersStatistic.put(var2, var3);
		}

		return var3;
	}

	public void a(int var1) {
		this.r = var1;
		if (this.minecraftserver.worlds != null) {
			WorldServer[] var2 = this.minecraftserver.worlds.toArray(new WorldServer[0]);
			int var3 = var2.length;

			for (int var4 = 0; var4 < var3; ++var4) {
				WorldServer var5 = var2[var4];
				if (var5 != null) {
					var5.getPlayerChunkMap().a(var1);
				}
			}

		}
	}

	public EntityPlayer getPlayer(UUID uuid) {
		return uuidToPlayerMap.get(uuid);
	}

	public EntityPlayer getPlayer(String name) {
		for (EntityPlayer player : players) {
			if (player.getName().equalsIgnoreCase(name)) {
				return player;
			}
		}
		return null;
	}

	public OpList getOpList() {
		return this.opList;
	}

	public String[] getOps() {
		return this.opList.getEntries();
	}

	public void addOp(GameProfile profile) {
		this.opList.add(new OpListEntry(profile, this.minecraftserver.getOpPermissionLevel()));
	}

	public void removeOp(GameProfile profile) {
		this.opList.remove(profile);
	}

	public boolean isOp(GameProfile profile) {
		return this.opList.contains(profile) || this.everyoneIsOp;
	}

	public WhiteList getWhitelist() {
		return this.whiteList;
	}

	public String[] getWhitelisted() {
		return this.whiteList.getEntries();
	}

	public void addWhitelist(GameProfile profile) {
		this.whiteList.add(new WhiteListEntry(profile));
	}

	public void removeWhitelist(GameProfile profile) {
		this.whiteList.remove(profile);
	}

	public IpBanList getIpBanList() {
		return this.ipBanList;
	}

	public GameProfileBanList getProfileBans() {
		return this.playerBanList;
	}

	public boolean canJoin(GameProfile profile) {
		return !this.hasWhiteList || this.opList.contains(profile) || this.whiteList.contains(profile);
	}

	public int getPlayersCount() {
		return this.players.size();
	}

	public int getMaxPlayers() {
		return this.maxPlayers;
	}

}
