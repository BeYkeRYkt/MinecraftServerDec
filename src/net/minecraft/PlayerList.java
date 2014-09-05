package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.mojang.authlib.GameProfile;
import io.netty.buffer.Unpooled;
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
import net.minecraft.server.MinecraftServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class PlayerList {

	public static final File bannedPlayersFile = new File("banned-players.json");
	public static final File bannedIPsFile = new File("banned-ips.json");
	public static final File opsFile = new File("ops.json");
	public static final File whitelistFile = new File("whitelist.json");
	private final sv k;
	private final sd l;
	private final sp m;
	private final sx n;
	private static final Logger logger = LogManager.getLogger();
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd \'at\' HH:mm:ss z");
	private final MinecraftServer minecraftserver;
	public final List<EntityPlayer> players = Lists.newArrayList();
	public final Map<UUID, EntityPlayer> uuidToPlayerMap = Maps.newHashMap();
	private final Map<UUID, PlayerStatisticFile> playersStatistic = Maps.newHashMap();
	private brl p;
	private boolean q;
	protected int maxPlayers;
	private int r;
	private GameMode s;
	private boolean t;
	private int u;

	public PlayerList(MinecraftServer minecraftserver) {
		this.minecraftserver = minecraftserver;
		this.k = new sv(bannedPlayersFile);
		this.l = new sd(bannedIPsFile);
		this.m = new sp(opsFile);
		this.n = new sx(whitelistFile);
		this.k.a(false);
		this.l.a(false);
		this.maxPlayers = 8;
	}

	public void a(gr var1, EntityPlayer player) {
		GameProfile var3 = player.getGameProfile();
		UserCache var4 = this.minecraftserver.getUserCache();
		GameProfile var5 = var4.getProfile(var3.getId());
		String var6 = var5 == null ? var3.getName() : var5.getName();
		var4.saveProfile(var3);
		NBTCompoundTag var7 = this.a(player);
		player.a((World) this.minecraftserver.a(player.dimensionId));
		player.c.a((WorldServer) player.o);
		String var8 = "local";
		if (var1.b() != null) {
			var8 = var1.b().toString();
		}

		logger.info(player.d_() + "[" + var8 + "] logged in with entity id " + player.getId() + " at (" + player.locationX + ", " + player.locationY + ", " + player.locationZ + ")");
		WorldServer worldServer = this.minecraftserver.a(player.dimensionId);
		WorldData worldData = worldServer.P();
		Position var11 = worldServer.M();
		this.a(player, (EntityPlayer) null, worldServer);
		PlayerConnection var12 = new PlayerConnection(this.minecraftserver, var1, player);
		var12.sendPacket((Packet) (new PacketJoinGame(player.getId(), player.c.getGameMode(), worldData.isHardcore(), worldServer.worldProvider.getDimensionId(), worldServer.getDifficulty(), this.getMaxPlayers(), worldData.getLevelType(), worldServer.Q().b("reducedDebugInfo"))));
		var12.sendPacket((Packet) (new ji("MC|Brand", (new PacketDataSerializer(Unpooled.buffer())).writeString(this.c().getServerModName()))));
		var12.sendPacket((Packet) (new ix(worldData.getDifficulty(), worldData.z())));
		var12.sendPacket((Packet) (new PacketSpawnPosition(var11)));
		var12.sendPacket((Packet) (new kd(player.by)));
		var12.sendPacket((Packet) (new PacketHeldItemChange(player.playerInventory.c)));
		player.A().d();
		player.A().b(player);
		this.a((pk) worldServer.Z(), player);
		this.minecraftserver.aF();
		hz var13;
		if (!player.d_().equalsIgnoreCase(var6)) {
			var13 = new hz("multiplayer.player.joined.renamed", new Object[] { player.e_(), var6 });
		} else {
			var13 = new hz("multiplayer.player.joined", new Object[] { player.e_() });
		}

		var13.b().a(FormattingCode.o);
		this.a((IJSONComponent) var13);
		this.c(player);
		var12.a(player.locationX, player.locationY, player.locationZ, player.yaw, player.pitch);
		this.b(player, worldServer);
		if (this.minecraftserver.aa().length() > 0) {
			player.a(this.minecraftserver.aa(), this.minecraftserver.ab());
		}

		Iterator var14 = player.bk().iterator();

		while (var14.hasNext()) {
			MobEffect var15 = (MobEffect) var14.next();
			var12.sendPacket((Packet) (new PacketEntityEffect(player.getId(), var15)));
		}

		player.f_();
		if (var7 != null && var7.isTagAssignableFrom("Riding", 10)) {
			Entity var16 = EntityTypes.loadEntity(var7.getCompound("Riding"), (World) worldServer);
			if (var16 != null) {
				var16.n = true;
				worldServer.d(var16);
				player.a(var16);
				var16.n = false;
			}
		}

	}

	protected void a(pk var1, EntityPlayer var2) {
		HashSet var3 = Sets.newHashSet();
		Iterator var4 = var1.g().iterator();

		while (var4.hasNext()) {
			brz var5 = (brz) var4.next();
			var2.playerConncetion.sendPacket((Packet) (new le(var5, 0)));
		}

		for (int var9 = 0; var9 < 19; ++var9) {
			bry var10 = var1.a(var9);
			if (var10 != null && !var3.contains(var10)) {
				List var6 = var1.d(var10);
				Iterator var7 = var6.iterator();

				while (var7.hasNext()) {
					Packet var8 = (Packet) var7.next();
					var2.playerConncetion.sendPacket(var8);
				}

				var3.add(var10);
			}
		}

	}

	public void a(WorldServer[] var1) {
		this.p = var1[0].O().e();
		var1[0].af().a((bez) (new so(this)));
	}

	public void a(EntityPlayer var1, WorldServer var2) {
		WorldServer var3 = var1.u();
		if (var2 != null) {
			var2.t().c(var1);
		}

		var3.t().a(var1);
		var3.b.c((int) var1.locationX >> 4, (int) var1.locationZ >> 4);
	}

	public int d() {
		return qq.b(this.t());
	}

	public NBTCompoundTag a(EntityPlayer var1) {
		NBTCompoundTag var2 = this.minecraftserver.worlds[0].P().i();
		NBTCompoundTag var3;
		if (var1.d_().equals(this.minecraftserver.R()) && var2 != null) {
			var1.load(var2);
			var3 = var2;
			logger.debug("loading single player");
		} else {
			var3 = this.p.b(var1);
		}

		return var3;
	}

	protected void b(EntityPlayer var1) {
		this.p.a(var1);
		PlayerStatisticFile var2 = (PlayerStatisticFile) this.playersStatistic.get(var1.aJ());
		if (var2 != null) {
			var2.write();
		}

	}

	public void c(EntityPlayer var1) {
		this.players.add(var1);
		this.uuidToPlayerMap.put(var1.aJ(), var1);
		this.sendPacket((Packet) (new kh(kj.a, new EntityPlayer[] { var1 })));
		WorldServer var2 = this.minecraftserver.a(var1.dimensionId);
		var2.d(var1);
		this.a(var1, (WorldServer) null);

		for (int var3 = 0; var3 < this.players.size(); ++var3) {
			EntityPlayer var4 = (EntityPlayer) this.players.get(var3);
			var1.playerConncetion.sendPacket((Packet) (new kh(kj.a, new EntityPlayer[] { var4 })));
		}

	}

	public void d(EntityPlayer var1) {
		var1.u().t().d(var1);
	}

	public void e(EntityPlayer var1) {
		var1.b(StatisticList.f);
		this.b(var1);
		WorldServer var2 = var1.u();
		if (var1.m != null) {
			var2.f(var1.m);
			logger.debug("removing player mount");
		}

		var2.e(var1);
		var2.t().c(var1);
		this.players.remove(var1);
		this.uuidToPlayerMap.remove(var1.aJ());
		this.playersStatistic.remove(var1.aJ());
		this.sendPacket((Packet) (new kh(kj.e, new EntityPlayer[] { var1 })));
	}

	public String a(SocketAddress var1, GameProfile var2) {
		String var4;
		if (this.k.a(var2)) {
			sw var5 = (sw) this.k.b((Object) var2);
			var4 = "You are banned from this server!\nReason: " + var5.d();
			if (var5.c() != null) {
				var4 = var4 + "\nYour ban will be removed on " + dateFormat.format(var5.c());
			}

			return var4;
		} else if (!this.e(var2)) {
			return "You are not white-listed on this server!";
		} else if (this.l.a(var1)) {
			se var3 = this.l.b(var1);
			var4 = "Your IP address is banned from this server!\nReason: " + var3.d();
			if (var3.c() != null) {
				var4 = var4 + "\nYour ban will be removed on " + dateFormat.format(var3.c());
			}

			return var4;
		} else {
			return this.players.size() >= this.maxPlayers ? "The server is full!" : null;
		}
	}

	public EntityPlayer f(GameProfile var1) {
		UUID var2 = EntityHuman.a(var1);
		ArrayList var3 = Lists.newArrayList();

		EntityPlayer var5;
		for (int var4 = 0; var4 < this.players.size(); ++var4) {
			var5 = (EntityPlayer) this.players.get(var4);
			if (var5.aJ().equals(var2)) {
				var3.add(var5);
			}
		}

		Iterator var6 = var3.iterator();

		while (var6.hasNext()) {
			var5 = (EntityPlayer) var6.next();
			var5.playerConncetion.c("You logged in from another location");
		}

		Object var7;
		if (this.minecraftserver.W()) {
			var7 = new qk(this.minecraftserver.a(0));
		} else {
			var7 = new qx(this.minecraftserver.a(0));
		}

		return new EntityPlayer(this.minecraftserver, this.minecraftserver.a(0), var1, (qx) var7);
	}

	public EntityPlayer a(EntityPlayer var1, int var2, boolean var3) {
		var1.u().s().b(var1);
		var1.u().s().b((Entity) var1);
		var1.u().t().c(var1);
		this.players.remove(var1);
		this.minecraftserver.a(var1.dimensionId).f(var1);
		Position var4 = var1.cg();
		boolean var5 = var1.ch();
		var1.dimensionId = var2;
		Object var6;
		if (this.minecraftserver.W()) {
			var6 = new qk(this.minecraftserver.a(var1.dimensionId));
		} else {
			var6 = new qx(this.minecraftserver.a(var1.dimensionId));
		}

		EntityPlayer var7 = new EntityPlayer(this.minecraftserver, this.minecraftserver.a(var1.dimensionId), var1.getGameProfile(), (qx) var6);
		var7.playerConncetion = var1.playerConncetion;
		var7.a((EntityHuman) var1, var3);
		var7.d(var1.getId());
		var7.o(var1);
		WorldServer var8 = this.minecraftserver.a(var1.dimensionId);
		this.a(var7, var1, var8);
		Position var9;
		if (var4 != null) {
			var9 = EntityHuman.a(this.minecraftserver.a(var1.dimensionId), var4, var5);
			if (var9 != null) {
				var7.b((double) ((float) var9.n() + 0.5F), (double) ((float) var9.o() + 0.1F), (double) ((float) var9.p() + 0.5F), 0.0F, 0.0F);
				var7.a(var4, var5);
			} else {
				var7.playerConncetion.sendPacket((Packet) (new jo(0, 0.0F)));
			}
		}

		var8.b.c((int) var7.locationX >> 4, (int) var7.locationZ >> 4);

		while (!var8.a((Entity) var7, var7.aQ()).isEmpty() && var7.locationY < 256.0D) {
			var7.b(var7.locationX, var7.locationY + 1.0D, var7.locationZ);
		}

		var7.playerConncetion.sendPacket((Packet) (new PacketRespawn(var7.dimensionId, var7.o.getDifficulty(), var7.o.P().getLevelType(), var7.c.getGameMode())));
		var9 = var8.M();
		var7.playerConncetion.a(var7.locationX, var7.locationY, var7.locationZ, var7.yaw, var7.pitch);
		var7.playerConncetion.sendPacket((Packet) (new PacketSpawnPosition(var9)));
		var7.playerConncetion.sendPacket((Packet) (new PacketSetExpirience(var7.bB, var7.bA, var7.bz)));
		this.b(var7, var8);
		var8.t().a(var7);
		var8.d(var7);
		this.players.add(var7);
		this.uuidToPlayerMap.put(var7.aJ(), var7);
		var7.f_();
		var7.h(var7.bm());
		return var7;
	}

	public void a(EntityPlayer var1, int var2) {
		int var3 = var1.dimensionId;
		WorldServer var4 = this.minecraftserver.a(var1.dimensionId);
		var1.dimensionId = var2;
		WorldServer var5 = this.minecraftserver.a(var1.dimensionId);
		var1.playerConncetion.sendPacket((Packet) (new PacketRespawn(var1.dimensionId, var1.o.getDifficulty(), var1.o.P().getLevelType(), var1.c.getGameMode())));
		var4.f(var1);
		var1.I = false;
		this.a(var1, var3, var4, var5);
		this.a(var1, var4);
		var1.playerConncetion.a(var1.locationX, var1.locationY, var1.locationZ, var1.yaw, var1.pitch);
		var1.c.a(var5);
		this.b(var1, var5);
		this.f(var1);
		Iterator var6 = var1.bk().iterator();

		while (var6.hasNext()) {
			MobEffect var7 = (MobEffect) var6.next();
			var1.playerConncetion.sendPacket((Packet) (new PacketEntityEffect(var1.getId(), var7)));
		}

	}

	public void a(Entity var1, int var2, WorldServer var3, WorldServer var4) {
		double var5 = var1.locationX;
		double var7 = var1.locationZ;
		double var9 = 8.0D;
		float var11 = var1.yaw;
		var3.B.a("moving");
		if (var1.dimensionId == -1) {
			var5 = DataTypesConverter.a(var5 / var9, var4.af().b() + 16.0D, var4.af().d() - 16.0D);
			var7 = DataTypesConverter.a(var7 / var9, var4.af().c() + 16.0D, var4.af().e() - 16.0D);
			var1.b(var5, var1.locationY, var7, var1.yaw, var1.pitch);
			if (var1.ai()) {
				var3.a(var1, false);
			}
		} else if (var1.dimensionId == 0) {
			var5 = DataTypesConverter.a(var5 * var9, var4.af().b() + 16.0D, var4.af().d() - 16.0D);
			var7 = DataTypesConverter.a(var7 * var9, var4.af().c() + 16.0D, var4.af().e() - 16.0D);
			var1.b(var5, var1.locationY, var7, var1.yaw, var1.pitch);
			if (var1.ai()) {
				var3.a(var1, false);
			}
		} else {
			Position var12;
			if (var2 == 1) {
				var12 = var4.M();
			} else {
				var12 = var4.m();
			}

			var5 = (double) var12.n();
			var1.locationY = (double) var12.o();
			var7 = (double) var12.p();
			var1.b(var5, var1.locationY, var7, 90.0F, 0.0F);
			if (var1.ai()) {
				var3.a(var1, false);
			}
		}

		var3.B.b();
		if (var2 != 1) {
			var3.B.a("placing");
			var5 = (double) DataTypesConverter.a((int) var5, -29999872, 29999872);
			var7 = (double) DataTypesConverter.a((int) var7, -29999872, 29999872);
			if (var1.ai()) {
				var1.b(var5, var1.locationY, var7, var1.yaw, var1.pitch);
				var4.u().a(var1, var11);
				var4.d(var1);
				var4.a(var1, false);
			}

			var3.B.b();
		}

		var1.a((World) var4);
	}

	public void e() {
		if (++this.u > 600) {
			this.sendPacket((Packet) (new kh(kj.c, this.players)));
			this.u = 0;
		}

	}

	public void sendPacket(Packet var1) {
		for (EntityPlayer entity : this.players) {
			entity.playerConncetion.sendPacket(var1);
		}

	}

	public void sendPacket(Packet<?> var1, int dimensionId) {
		for (EntityPlayer entity : this.players) {
			if (entity.dimensionId == dimensionId) {
				entity.playerConncetion.sendPacket(var1);
			}
		}
	}

	public void a(EntityHuman var1, IJSONComponent var2) {
		bsf var3 = var1.bN();
		if (var3 != null) {
			Collection var4 = var3.d();
			Iterator var5 = var4.iterator();

			while (var5.hasNext()) {
				String var6 = (String) var5.next();
				EntityPlayer var7 = this.a(var6);
				if (var7 != null && var7 != var1) {
					var7.sendChatMessage(var2);
				}
			}

		}
	}

	public void b(EntityHuman var1, IJSONComponent var2) {
		bsf var3 = var1.bN();
		if (var3 == null) {
			this.a(var2);
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

			var1 = var1 + ((EntityPlayer) this.players.get(var2)).d_();
		}

		return var1;
	}

	public String[] g() {
		String[] var1 = new String[this.players.size()];

		for (int var2 = 0; var2 < this.players.size(); ++var2) {
			var1[var2] = ((EntityPlayer) this.players.get(var2)).d_();
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

	public sv i() {
		return this.k;
	}

	public sd j() {
		return this.l;
	}

	public void a(GameProfile var1) {
		this.m.a((sr) (new sq(var1, this.minecraftserver.getOpPermissionLevel())));
	}

	public void b(GameProfile var1) {
		this.m.c(var1);
	}

	public boolean e(GameProfile var1) {
		return !this.q || this.m.d(var1) || this.n.d(var1);
	}

	public boolean g(GameProfile var1) {
		return this.m.d(var1) || this.minecraftserver.isSinglePlayer() && this.minecraftserver.worlds[0].P().v() && this.minecraftserver.R().equalsIgnoreCase(var1.getName()) || this.t;
	}

	public EntityPlayer a(String var1) {
		Iterator var2 = this.players.iterator();

		EntityPlayer var3;
		do {
			if (!var2.hasNext()) {
				return null;
			}

			var3 = (EntityPlayer) var2.next();
		} while (!var3.d_().equalsIgnoreCase(var1));

		return var3;
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
					var13.playerConncetion.sendPacket(var11);
				}
			}
		}

	}

	public void k() {
		for (int var1 = 0; var1 < this.players.size(); ++var1) {
			this.b((EntityPlayer) this.players.get(var1));
		}

	}

	public void d(GameProfile var1) {
		this.n.a((sr) (new sy(var1)));
	}

	public void c(GameProfile var1) {
		this.n.c(var1);
	}

	public sx l() {
		return this.n;
	}

	public String[] m() {
		return this.n.a();
	}

	public sp n() {
		return this.m;
	}

	public String[] o() {
		return this.m.a();
	}

	public void a() {
	}

	public void b(EntityPlayer var1, WorldServer var2) {
		bfb var3 = this.minecraftserver.worlds[0].af();
		var1.playerConncetion.sendPacket((Packet) (new kr(var3, kt.d)));
		var1.playerConncetion.sendPacket((Packet) (new PacketTimeUpdate(var2.K(), var2.L(), var2.Q().b("doDaylightCycle"))));
		if (var2.S()) {
			var1.playerConncetion.sendPacket((Packet) (new jo(1, 0.0F)));
			var1.playerConncetion.sendPacket((Packet) (new jo(7, var2.j(1.0F))));
			var1.playerConncetion.sendPacket((Packet) (new jo(8, var2.h(1.0F))));
		}

	}

	public void f(EntityPlayer var1) {
		var1.a(var1.defaultContainer);
		var1.r();
		var1.playerConncetion.sendPacket((Packet) (new PacketHeldItemChange(var1.playerInventory.c)));
	}

	public int p() {
		return this.players.size();
	}

	public int getMaxPlayers() {
		return this.maxPlayers;
	}

	public String[] r() {
		return this.minecraftserver.worlds[0].O().e().f();
	}

	public boolean s() {
		return this.q;
	}

	public void a(boolean var1) {
		this.q = var1;
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
			var1.c.a(var2.c.getGameMode());
		} else if (this.s != null) {
			var1.c.a(this.s);
		}

		var1.c.b(var3.P().r());
	}

	public void v() {
		for (int var1 = 0; var1 < this.players.size(); ++var1) {
			((EntityPlayer) this.players.get(var1)).playerConncetion.c("Server closed");
		}

	}

	public void a(IJSONComponent var1, boolean var2) {
		this.minecraftserver.sendChatMessage(var1);
		int var3 = var2 ? 1 : 0;
		this.sendPacket((Packet) (new PacketChatMessage(var1, (byte) var3)));
	}

	public void a(IJSONComponent var1) {
		this.a(var1, true);
	}

	public PlayerStatisticFile getPLayerStatistic(EntityHuman var1) {
		UUID var2 = var1.aJ();
		PlayerStatisticFile var3 = var2 == null ? null : (PlayerStatisticFile) this.playersStatistic.get(var2);
		if (var3 == null) {
			File var4 = new File(this.minecraftserver.a(0).O().b(), "stats");
			File var5 = new File(var4, var2.toString() + ".json");
			if (!var5.exists()) {
				File var6 = new File(var4, var1.d_() + ".json");
				if (var6.exists() && var6.isFile()) {
					var6.renameTo(var5);
				}
			}

			var3 = new PlayerStatisticFile(this.minecraftserver, var5);
			var3.read();
			this.playersStatistic.put(var2, var3);
		}

		return var3;
	}

	public void a(int var1) {
		this.r = var1;
		if (this.minecraftserver.worlds != null) {
			WorldServer[] var2 = this.minecraftserver.worlds;
			int var3 = var2.length;

			for (int var4 = 0; var4 < var3; ++var4) {
				WorldServer var5 = var2[var4];
				if (var5 != null) {
					var5.t().a(var1);
				}
			}

		}
	}

	public EntityPlayer getPlayer(UUID uuid) {
		return uuidToPlayerMap.get(uuid);
	}

}
