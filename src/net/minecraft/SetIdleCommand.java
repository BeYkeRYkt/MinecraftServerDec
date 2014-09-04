package net.minecraft;

import net.minecraft.server.MinecraftServer;

public class SetIdleCommand extends AbstractCommand {

	public String getName() {
		return "setidletimeout";
	}

	public int a() {
		return 3;
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.setidletimeout.usage";
	}

	public void a(CommandSenderInterface var1, String[] var2) throws dp, dk {
		if (var2.length != 1) {
			throw new dp("commands.setidletimeout.usage", new Object[0]);
		} else {
			int var3 = a(var2[0], 0);
			MinecraftServer.getInstance().setIdleTimeout(var3);
			a(var1, this, "commands.setidletimeout.success", new Object[] { Integer.valueOf(var3) });
		}
	}
}
