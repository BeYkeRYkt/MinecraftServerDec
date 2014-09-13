package net.minecraft;

import java.util.List;
import net.minecraft.server.MinecraftServer;

public class BanListCommand extends AbstractCommand {

	public String getName() {
		return "banlist";
	}

	public int a() {
		return 3;
	}

	public boolean a(CommandSenderInterface var1) {
		return (MinecraftServer.getInstance().getPlayerList().getIpBanList().isEnabled() || MinecraftServer.getInstance().getPlayerList().getProfileBans().isEnabled()) && super.a(var1);
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.banlist.usage";
	}

	public void executeCommand(CommandSenderInterface var1, String[] var2) {
		if (var2.length >= 1 && var2[0].equalsIgnoreCase("ips")) {
			var1.sendChatMessage(new ChatMessage("commands.banlist.ips", new Object[] { Integer.valueOf(MinecraftServer.getInstance().getPlayerList().getIpBanList().getEntries().length) }));
			var1.sendChatMessage(new ChatComponentText(a(MinecraftServer.getInstance().getPlayerList().getIpBanList().getEntries())));
		} else {
			var1.sendChatMessage(new ChatMessage("commands.banlist.players", new Object[] { Integer.valueOf(MinecraftServer.getInstance().getPlayerList().getProfileBans().getEntries().length) }));
			var1.sendChatMessage(new ChatComponentText(a(MinecraftServer.getInstance().getPlayerList().getProfileBans().getEntries())));
		}

	}

	public List getTabCompleteList(CommandSenderInterface var1, String[] var2, Position var3) {
		return var2.length == 1 ? a(var2, new String[] { "players", "ips" }) : null;
	}
}
