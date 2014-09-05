package net.minecraft;

import java.util.List;
import net.minecraft.server.MinecraftServer;

public class SayCommand extends AbstractCommand {

	public String getName() {
		return "say";
	}

	public int a() {
		return 1;
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.say.usage";
	}

	public void executeCommand(CommandSenderInterface var1, String[] var2) throws dp, dm {
		if (var2.length > 0 && var2[0].length() > 0) {
			IJSONComponent var3 = b(var1, var2, 0, true);
			MinecraftServer.getInstance().getPlayerList().a((IJSONComponent) (new hz("chat.type.announcement", new Object[] { var1.e_(), var3 })));
		} else {
			throw new dp("commands.say.usage", new Object[0]);
		}
	}

	public List getTabCompleteList(CommandSenderInterface var1, String[] var2, Position var3) {
		return var2.length >= 1 ? a(var2, MinecraftServer.getInstance().I()) : null;
	}
}
