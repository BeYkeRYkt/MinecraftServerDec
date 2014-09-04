package net.minecraft;

import net.minecraft.server.MinecraftServer;

public class ServerStopCommand extends AbstractCommand {

	public String getName() {
		return "stop";
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.stop.usage";
	}

	public void executeCommand(CommandSenderInterface var1, String[] var2) {
		if (MinecraftServer.getInstance().worlds != null) {
			a(var1, this, "commands.stop.start", new Object[0]);
		}

		MinecraftServer.getInstance().stopTicking();
	}
}
