package net.minecraft;

import java.util.List;
import net.minecraft.server.MinecraftServer;

public class BanListCommand extends AbstractCommand {

	public String getName() {
		return "banlist";
	}

	public int a() {
		return 3;
	}

	public boolean a(CommandSenderInterface var1) {
		return (MinecraftServer.getInstance().an().j().b() || MinecraftServer.getInstance().an().i().b()) && super.a(var1);
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.banlist.usage";
	}

	public void a(CommandSenderInterface var1, String[] var2) {
		if (var2.length >= 1 && var2[0].equalsIgnoreCase("ips")) {
			var1.a(new hz("commands.banlist.ips", new Object[] { Integer.valueOf(MinecraftServer.getInstance().an().j().a().length) }));
			var1.a(new hy(a(MinecraftServer.getInstance().an().j().a())));
		} else {
			var1.a(new hz("commands.banlist.players", new Object[] { Integer.valueOf(MinecraftServer.getInstance().an().i().a().length) }));
			var1.a(new hy(a(MinecraftServer.getInstance().an().i().a())));
		}

	}

	public List getTabCompleteList(CommandSenderInterface var1, String[] var2, dt var3) {
		return var2.length == 1 ? a(var2, new String[] { "players", "ips" }) : null;
	}
}
