package net.minecraft;

import net.minecraft.util.com.mojang.authlib.GameProfile;
import net.minecraft.util.com.mojang.authlib.exceptions.AuthenticationUnavailableException;

import java.math.BigInteger;
import java.util.UUID;

import net.minecraft.server.MinecraftServer;

class ThreadPlayerLookupUUID extends Thread {

	private final LoginListener loginListener;

	ThreadPlayerLookupUUID(LoginListener listener, String name) {
		super(name);
		this.loginListener = listener;
	}

	public void run() {
		GameProfile gameProfile = loginListener.getGameProfile();
		try {
			String s = new BigInteger(ServerCryptoUtils.a(loginListener.getServerId(), MinecraftServer.getInstance().getKeyPair().getPublic(), loginListener.getKey())).toString(16);
			loginListener.setProfile(MinecraftServer.getInstance().getMinecraftSessionService().hasJoinedServer(new GameProfile((UUID) null, gameProfile.getName()), s));
			if (loginListener.getGameProfile() != null) {
				loginListener.getLogger().info("UUID of player " + loginListener.getGameProfile().getName() + " is " + loginListener.getGameProfile().getId());
				loginListener.setState(EnumProtocolState.READY_TO_ACCEPT);
			} else {
				loginListener.disconnect("Failed to verify username!");
				loginListener.getLogger().error("Username \'" + loginListener.getGameProfile().getName() + "\' tried to join with an invalid session");
			}
		} catch (AuthenticationUnavailableException ex) {
			loginListener.disconnect("Authentication servers are down. Please try again later, sorry!");
			loginListener.getLogger().error("Couldn\'t verify username because servers are unavailable");
		}
	}

}
