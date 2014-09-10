package net.minecraft;

import java.util.List;
import net.minecraft.server.MinecraftServer;

public class TimeCommand extends AbstractCommand {

	public String getName() {
		return "time";
	}

	public int a() {
		return 2;
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.time.usage";
	}

	public void executeCommand(CommandSenderInterface var1, String[] var2) throws dk, dp {
		if (var2.length > 1) {
			int var3;
			if (var2[0].equals("set")) {
				if (var2[1].equals("day")) {
					var3 = 1000;
				} else if (var2[1].equals("night")) {
					var3 = 13000;
				} else {
					var3 = a(var2[1], 0);
				}

				this.a(var1, var3);
				a(var1, this, "commands.time.set", new Object[] { Integer.valueOf(var3) });
				return;
			}

			if (var2[0].equals("add")) {
				var3 = a(var2[1], 0);
				this.b(var1, var3);
				a(var1, this, "commands.time.added", new Object[] { Integer.valueOf(var3) });
				return;
			}

			if (var2[0].equals("query")) {
				if (var2[1].equals("daytime")) {
					var3 = (int) (var1.getWorld().L() % 2147483647L);
					var1.a(ag.e, var3);
					a(var1, this, "commands.time.query", new Object[] { Integer.valueOf(var3) });
					return;
				}

				if (var2[1].equals("gametime")) {
					var3 = (int) (var1.getWorld().getTime() % 2147483647L);
					var1.a(ag.e, var3);
					a(var1, this, "commands.time.query", new Object[] { Integer.valueOf(var3) });
					return;
				}
			}
		}

		throw new dp("commands.time.usage", new Object[0]);
	}

	public List getTabCompleteList(CommandSenderInterface var1, String[] var2, Position var3) {
		return var2.length == 1 ? a(var2, new String[] { "set", "add", "query" }) : (var2.length == 2 && var2[0].equals("set") ? a(var2, new String[] { "day", "night" }) : (var2.length == 2 && var2[0].equals("query") ? a(var2, new String[] { "daytime", "gametime" }) : null));
	}

	protected void a(CommandSenderInterface var1, int var2) {
		for (int var3 = 0; var3 < MinecraftServer.getInstance().worlds.length; ++var3) {
			MinecraftServer.getInstance().worlds[var3].b((long) var2);
		}

	}

	protected void b(CommandSenderInterface var1, int var2) {
		for (int var3 = 0; var3 < MinecraftServer.getInstance().worlds.length; ++var3) {
			WorldServer var4 = MinecraftServer.getInstance().worlds[var3];
			var4.b(var4.L() + (long) var2);
		}

	}
}
