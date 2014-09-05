package net.minecraft;

import java.util.List;
import net.minecraft.server.MinecraftServer;

public class SpawnPointCommand extends AbstractCommand {

	public String getName() {
		return "spawnpoint";
	}

	public int a() {
		return 2;
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.spawnpoint.usage";
	}

	public void executeCommand(CommandSenderInterface var1, String[] var2) throws dp, dm, dk {
		if (var2.length > 0 && var2.length < 4) {
			throw new dp("commands.spawnpoint.usage", new Object[0]);
		} else {
			EntityPlayer var3 = var2.length > 0 ? a(var1, var2[0]) : b(var1);
			Position var4 = var2.length > 3 ? a(var1, var2, 1, true) : var3.c();
			if (var3.o != null) {
				var3.a(var4, true);
				a(var1, this, "commands.spawnpoint.success", new Object[] { var3.d_(), Integer.valueOf(var4.n()), Integer.valueOf(var4.o()), Integer.valueOf(var4.p()) });
			}

		}
	}

	public List getTabCompleteList(CommandSenderInterface var1, String[] var2, Position var3) {
		return var2.length == 1 ? a(var2, MinecraftServer.getInstance().I()) : (var2.length > 1 && var2.length <= 4 ? a(var2, 1, var3) : null);
	}

	public boolean b(String[] var1, int var2) {
		return var2 == 0;
	}
}
