package net.minecraft;

import net.minecraft.server.MinecraftServer;

public class SeedCommand extends AbstractCommand {

	public boolean a(CommandSenderInterface var1) {
		return MinecraftServer.getInstance().isSinglePlayer() || super.a(var1);
	}

	public String getName() {
		return "seed";
	}

	public int a() {
		return 2;
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.seed.usage";
	}

	public void executeCommand(CommandSenderInterface var1, String[] var2) {
		Object var3 = var1 instanceof EntityHuman ? ((EntityHuman) var1).o : MinecraftServer.getInstance().a(0);
		var1.a(new hz("commands.seed.success", new Object[] { Long.valueOf(((World) var3).J()) }));
	}
}
