package net.minecraft;

import net.minecraft.util.com.mojang.authlib.GameProfile;
import net.minecraft.util.com.mojang.authlib.exceptions.AuthenticationUnavailableException;

import java.math.BigInteger;
import java.net.InetSocketAddress;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result;

import net.minecraft.server.MinecraftServer;

class ThreadPlayerLookupUUID extends Thread {

	private final LoginListener loginListener;
	private boolean checkMojang;

	ThreadPlayerLookupUUID(LoginListener listener, String name, boolean checkMojang) {
		super(name);
		this.loginListener = listener;
		this.checkMojang = checkMojang;
	}

	public void run() {
		GameProfile gameProfile = loginListener.getGameProfile();
		if (checkMojang) {
			try {
				String s = new BigInteger(ServerCryptoUtils.a(loginListener.getServerId(), MinecraftServer.getInstance().getKeyPair().getPublic(), loginListener.getKey())).toString(16);
				loginListener.setProfile(MinecraftServer.getInstance().getMinecraftSessionService().hasJoinedServer(new GameProfile((UUID) null, gameProfile.getName()), s));
				if (loginListener.getGameProfile() != null) {
					login();
				} else {
					loginListener.disconnect("Failed to verify username!");
					loginListener.getLogger().error("Username \'" + loginListener.getGameProfile().getName() + "\' tried to join with an invalid session");
					return;
				}
			} catch (AuthenticationUnavailableException ex) {
				loginListener.disconnect("Authentication servers are down. Please try again later, sorry!");
				loginListener.getLogger().error("Couldn\'t verify username because servers are unavailable");
				return;
			}
		} else {
			login();
		}
	}

	private void login() {
		AsyncPlayerPreLoginEvent preloginEvent = new AsyncPlayerPreLoginEvent(loginListener.getGameProfile().getName(), ((InetSocketAddress)loginListener.networkManager.getAddress()).getAddress(), loginListener.getGameProfile().getId());
		Bukkit.getPluginManager().callEvent(preloginEvent);
		if (preloginEvent.getLoginResult() != Result.ALLOWED) {
			loginListener.disconnect(preloginEvent.getKickMessage());
		} else {

			loginListener.getLogger().info("UUID of player " + loginListener.getGameProfile().getName() + " is " + loginListener.getGameProfile().getId());
			loginListener.setState(EnumProtocolState.READY_TO_ACCEPT);
		}
	}

}
