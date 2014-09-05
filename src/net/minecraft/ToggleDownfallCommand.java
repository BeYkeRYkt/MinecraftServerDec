package net.minecraft;

import net.minecraft.server.MinecraftServer;

public class ToggleDownfallCommand extends AbstractCommand {

	public String getName() {
		return "toggledownfall";
	}

	public int a() {
		return 2;
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.downfall.usage";
	}

	public void executeCommand(CommandSenderInterface var1, String[] var2) {
		this.d();
		a(var1, this, "commands.downfall.success", new Object[0]);
	}

	protected void d() {
		WorldData var1 = MinecraftServer.getInstance().worlds[0].P();
		var1.b(!var1.p());
	}
}
