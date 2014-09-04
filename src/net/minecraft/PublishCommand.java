package net.minecraft;

import net.minecraft.server.MinecraftServer;

public class PublishCommand extends AbstractCommand {

	public String getName() {
		return "publish";
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.publish.usage";
	}

	public void a(CommandSenderInterface var1, String[] var2) {
		String var3 = MinecraftServer.getInstance().a(GameMode.SURVIVAL, false);
		if (var3 != null) {
			a(var1, this, "commands.publish.started", new Object[] { var3 });
		} else {
			a(var1, this, "commands.publish.failed", new Object[0]);
		}

	}
}
