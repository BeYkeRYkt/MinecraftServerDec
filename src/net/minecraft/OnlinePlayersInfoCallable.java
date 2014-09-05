package net.minecraft;

import java.util.concurrent.Callable;

import net.minecraft.server.MinecraftServer;

public class OnlinePlayersInfoCallable implements Callable<String> {

	public String call() {
		return MinecraftServer.getInstance().getPlayerList().p() + " / " + MinecraftServer.getInstance().getPlayerList().getMaxPlayers() + "; " + MinecraftServer.getInstance().getPlayerList().players;
	}

}
