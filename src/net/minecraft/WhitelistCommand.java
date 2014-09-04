package net.minecraft;

import com.mojang.authlib.GameProfile;
import java.util.List;
import net.minecraft.server.MinecraftServer;

public class WhitelistCommand extends AbstractCommand {

	public String getName() {
		return "whitelist";
	}

	public int a() {
		return 3;
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.whitelist.usage";
	}

	public void a(CommandSenderInterface var1, String[] var2) throws di {
		if (var2.length < 1) {
			throw new dp("commands.whitelist.usage", new Object[0]);
		} else {
			MinecraftServer var3 = MinecraftServer.getInstance();
			if (var2[0].equals("on")) {
				var3.getPlayerList().a(true);
				a(var1, this, "commands.whitelist.enabled", new Object[0]);
			} else if (var2[0].equals("off")) {
				var3.getPlayerList().a(false);
				a(var1, this, "commands.whitelist.disabled", new Object[0]);
			} else if (var2[0].equals("list")) {
				var1.a(new hz("commands.whitelist.list", new Object[] { Integer.valueOf(var3.getPlayerList().m().length), Integer.valueOf(var3.getPlayerList().r().length) }));
				String[] var4 = var3.getPlayerList().m();
				var1.a(new hy(a(var4)));
			} else {
				GameProfile var5;
				if (var2[0].equals("add")) {
					if (var2.length < 2) {
						throw new dp("commands.whitelist.add.usage", new Object[0]);
					}

					var5 = var3.aD().a(var2[1]);
					if (var5 == null) {
						throw new di("commands.whitelist.add.failed", new Object[] { var2[1] });
					}

					var3.getPlayerList().d(var5);
					a(var1, this, "commands.whitelist.add.success", new Object[] { var2[1] });
				} else if (var2[0].equals("remove")) {
					if (var2.length < 2) {
						throw new dp("commands.whitelist.remove.usage", new Object[0]);
					}

					var5 = var3.getPlayerList().l().a(var2[1]);
					if (var5 == null) {
						throw new di("commands.whitelist.remove.failed", new Object[] { var2[1] });
					}

					var3.getPlayerList().c(var5);
					a(var1, this, "commands.whitelist.remove.success", new Object[] { var2[1] });
				} else if (var2[0].equals("reload")) {
					var3.getPlayerList().a();
					a(var1, this, "commands.whitelist.reloaded", new Object[0]);
				}
			}

		}
	}

	public List getTabCompleteList(CommandSenderInterface var1, String[] var2, dt var3) {
		if (var2.length == 1) {
			return a(var2, new String[] { "on", "off", "list", "add", "remove", "reload" });
		} else {
			if (var2.length == 2) {
				if (var2[0].equals("remove")) {
					return a(var2, MinecraftServer.getInstance().getPlayerList().m());
				}

				if (var2[0].equals("add")) {
					return a(var2, MinecraftServer.getInstance().aD().a());
				}
			}

			return null;
		}
	}
}
