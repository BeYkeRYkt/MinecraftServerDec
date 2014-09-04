package net.minecraft;

import com.mojang.authlib.GameProfile;
import java.util.List;
import net.minecraft.server.MinecraftServer;

public class DeopCommand extends AbstractCommand {

	public String getName() {
		return "deop";
	}

	public int a() {
		return 3;
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.deop.usage";
	}

	public void executeCommand(CommandSenderInterface var1, String[] var2) throws di {
		if (var2.length == 1 && var2[0].length() > 0) {
			MinecraftServer var3 = MinecraftServer.getInstance();
			GameProfile var4 = var3.getPlayerList().n().a(var2[0]);
			if (var4 == null) {
				throw new di("commands.deop.failed", new Object[] { var2[0] });
			} else {
				var3.getPlayerList().b(var4);
				a(var1, this, "commands.deop.success", new Object[] { var2[0] });
			}
		} else {
			throw new dp("commands.deop.usage", new Object[0]);
		}
	}

	public List getTabCompleteList(CommandSenderInterface var1, String[] var2, dt var3) {
		return var2.length == 1 ? a(var2, MinecraftServer.getInstance().getPlayerList().o()) : null;
	}
}
