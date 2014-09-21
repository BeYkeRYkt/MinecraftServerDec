package net.minecraft;

import com.google.common.base.Charsets;

import net.minecraft.util.com.mojang.authlib.GameProfile;

import java.net.InetSocketAddress;
import java.security.PrivateKey;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import javax.crypto.SecretKey;

import net.minecraft.server.MinecraftServer;

import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

public class LoginListener implements LoginServerboundPacketListener, ITickable {

	private static final AtomicInteger atomic = new AtomicInteger(0);
	private static final Logger logger = LogManager.getLogger();
	private static final Random rnd = new Random();

	private final byte[] verifyToken = new byte[4];
	private final MinecraftServer minecraftserver;
	public final NetworkManager networkManager;
	private EnumProtocolState state;
	private int time;
	private GameProfile profile;
	private String serverId;
	private SecretKey key;

	public LoginListener(MinecraftServer minecraftserver, NetworkManager networkManager) {
		this.state = EnumProtocolState.HELLO;
		this.serverId = "";
		this.minecraftserver = minecraftserver;
		this.networkManager = networkManager;
		rnd.nextBytes(this.verifyToken);
	}

	public void doTick() {
		if (this.state == EnumProtocolState.READY_TO_ACCEPT) {
			this.login();
		}

		if (this.time++ == 600) {
			this.disconnect("Took too long to log in");
		}

	}

	public void disconnect(String message) {
		try {
			logger.info("Disconnecting " + this.getName() + ": " + message);
			ChatComponentText kickMessage = new ChatComponentText(message);
			this.networkManager.handleSendPacket(new PacketLoginOutDisconnect(kickMessage));
			this.networkManager.disconnect(kickMessage);
		} catch (Exception e) {
			logger.error("Error whilst disconnecting player", e);
		}

	}

	public void login() {
		if (!this.profile.isComplete()) {
			this.profile = this.generateOfflineModeUUID(this.profile);
			this.state = EnumProtocolState.AUTHENTICATING;
			new ThreadPlayerLookupUUID(this, "User Authenticator #" + atomic.incrementAndGet(), false).start();
			return;
		}

		EntityPlayer player = new EntityPlayer(this.minecraftserver, this.minecraftserver.getWorldServer(0), profile, new PlayerInteractManager(this.minecraftserver.getWorldServer(0)));
		PlayerLoginEvent loginEvent = new PlayerLoginEvent(player.getBukkitEntity(Player.class), "", ((InetSocketAddress)networkManager.getAddress()).getAddress());
		Bukkit.getPluginManager().callEvent(loginEvent);
		if (loginEvent.getResult() != Result.ALLOWED) {
			this.disconnect(loginEvent.getKickMessage());
		} else {
			this.state = EnumProtocolState.ACCEPTED;
			if (this.minecraftserver.getCompressionThreshold() >= 0 && !this.networkManager.isLocal()) {
				this.networkManager.handleSendPacket(new PacketLoginOutSetCompression(this.minecraftserver.getCompressionThreshold()), new CompressionEnableListener(this));
			}
			this.networkManager.handleSendPacket(new PacketLoginOutLoginSuccess(this.profile));
			this.minecraftserver.getPlayerList().kickDuplicatePlayers(this.profile);
			this.minecraftserver.getPlayerList().join(this.networkManager, player);
		}
	}

	public void handle(IChatBaseComponent component) {
		logger.info(this.getName() + " lost connection: " + component.getJsonMessage());
	}

	public String getName() {
		return this.profile != null ? this.profile.toString() + " (" + this.networkManager.getAddress().toString() + ")" : String.valueOf(this.networkManager.getAddress());
	}

	public void handle(PacketLoginInLoginStart packet) {
		Validate.validState(this.state == EnumProtocolState.HELLO, "Unexpected hello packet", new Object[0]);
		this.profile = packet.getProfile();
		if (this.minecraftserver.isOnlineMode() && !this.networkManager.isLocal()) {
			this.state = EnumProtocolState.KEY;
			this.networkManager.handleSendPacket(new PacketLoginOutEncryptionRequest(this.serverId, this.minecraftserver.getKeyPair().getPublic(), this.verifyToken));
		} else {
			this.state = EnumProtocolState.READY_TO_ACCEPT;
		}
	}

	public void handle(PacketLoginInEncryptionResponse packet) {
		Validate.validState(this.state == EnumProtocolState.KEY, "Unexpected key packet", new Object[0]);
		PrivateKey privateKey = this.minecraftserver.getKeyPair().getPrivate();
		if (!Arrays.equals(this.verifyToken, packet.getVerifyToken(privateKey))) {
			throw new IllegalStateException("Invalid nonce!");
		} else {
			this.key = packet.getSharedKey(privateKey);
			this.state = EnumProtocolState.AUTHENTICATING;
			this.networkManager.setEncryption(this.key);
			new ThreadPlayerLookupUUID(this, "User Authenticator #" + atomic.incrementAndGet(), true).start();
		}
	}

	protected GameProfile generateOfflineModeUUID(GameProfile profile) {
		UUID uuid = UUID.nameUUIDFromBytes(("OfflinePlayer:" + profile.getName()).getBytes(Charsets.UTF_8));
		return new GameProfile(uuid, profile.getName());
	}

	protected Logger getLogger() {
		return logger;
	}

	protected GameProfile getGameProfile() {
		return profile;
	}

	protected void setProfile(GameProfile profile) {
		this.profile = profile;
	}

	protected void setState(EnumProtocolState newstate) {
		this.state = newstate;
	}

	protected SecretKey getKey() {
		return key;
	}

	protected String getServerId() {
		return serverId;
	}

}
