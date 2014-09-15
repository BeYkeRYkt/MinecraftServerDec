package net.minecraft;

import net.minecraft.server.MinecraftServer;

public class ListCommand extends AbstractCommand {

	public String getName() {
		return "list";
	}

	public int a() {
		return 0;
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.players.usage";
	}

	public void executeCommand(CommandSenderInterface var1, String[] var2) {
		int var3 = MinecraftServer.getInstance().getOnlinePlayersCount();
		var1.sendChatMessage(new ChatMessage("commands.players.list", new Object[] { Integer.valueOf(var3), Integer.valueOf(MinecraftServer.getInstance().getMaxPlayers()) }));
		var1.sendChatMessage(new ChatComponentText(MinecraftServer.getInstance().getPlayerList().f()));
		var1.a(ag.e, var3);
	}
}
