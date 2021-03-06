package net.minecraft;

import java.util.List;
import java.util.regex.Matcher;
import net.minecraft.server.MinecraftServer;

public class UnbanIPCommand extends AbstractCommand {

	public String getName() {
		return "pardon-ip";
	}

	public int a() {
		return 3;
	}

	public boolean a(CommandSenderInterface var1) {
		return MinecraftServer.getInstance().getPlayerList().getIpBanList().isEnabled() && super.a(var1);
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.unbanip.usage";
	}

	public void executeCommand(CommandSenderInterface var1, String[] var2) throws dl {
		if (var2.length == 1 && var2[0].length() > 1) {
			Matcher var3 = BanIPCommand.a.matcher(var2[0]);
			if (var3.matches()) {
				MinecraftServer.getInstance().getPlayerList().getIpBanList().remove(var2[0]);
				a(var1, this, "commands.unbanip.success", new Object[] { var2[0] });
			} else {
				throw new dl("commands.unbanip.invalid", new Object[0]);
			}
		} else {
			throw new dp("commands.unbanip.usage", new Object[0]);
		}
	}

	public List getTabCompleteList(CommandSenderInterface var1, String[] var2, Position var3) {
		return var2.length == 1 ? a(var2, MinecraftServer.getInstance().getPlayerList().getIpBanList().getEntries()) : null;
	}
}
