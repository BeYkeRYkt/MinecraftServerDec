package net.minecraft;

import java.util.List;
import net.minecraft.server.MinecraftServer;

public class KickCommand extends AbstractCommand {

	public String getName() {
		return "kick";
	}

	public int a() {
		return 3;
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.kick.usage";
	}

	public void executeCommand(CommandSenderInterface var1, String[] var2) throws dm, dp {
		if (var2.length > 0 && var2[0].length() > 1) {
			EntityPlayer var3 = MinecraftServer.getInstance().getPlayerList().getPlayer(var2[0]);
			String var4 = "Kicked by an operator.";
			boolean var5 = false;
			if (var3 == null) {
				throw new dm();
			} else {
				if (var2.length >= 2) {
					var4 = a(var1, var2, 1).getStrippedMessage();
					var5 = true;
				}

				var3.playerConncetion.disconnect(var4);
				if (var5) {
					a(var1, this, "commands.kick.success.reason", new Object[] { var3.getName(), var4 });
				} else {
					a(var1, this, "commands.kick.success", new Object[] { var3.getName() });
				}

			}
		} else {
			throw new dp("commands.kick.usage", new Object[0]);
		}
	}

	public List getTabCompleteList(CommandSenderInterface var1, String[] var2, Position var3) {
		return var2.length >= 1 ? a(var2, MinecraftServer.getInstance().I()) : null;
	}
}
