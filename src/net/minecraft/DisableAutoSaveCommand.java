package net.minecraft;

import net.minecraft.server.MinecraftServer;

public class DisableAutoSaveCommand extends AbstractCommand {

	public String getName() {
		return "save-off";
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.save-off.usage";
	}

	public void a(CommandSenderInterface var1, String[] var2) throws di {
		MinecraftServer var3 = MinecraftServer.getInstance();
		boolean var4 = false;

		for (int var5 = 0; var5 < var3.worlds.length; ++var5) {
			if (var3.worlds[var5] != null) {
				WorldServer var6 = var3.worlds[var5];
				if (!var6.c) {
					var6.c = true;
					var4 = true;
				}
			}
		}

		if (var4) {
			a(var1, this, "commands.save.disabled", new Object[0]);
		} else {
			throw new di("commands.save-off.alreadyOff", new Object[0]);
		}
	}
}
