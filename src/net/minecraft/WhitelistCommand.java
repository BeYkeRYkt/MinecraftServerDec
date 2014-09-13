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

	public void executeCommand(CommandSenderInterface sender, String[] args) throws di {
		if (args.length < 1) {
			throw new dp("commands.whitelist.usage", new Object[0]);
		} else {
			MinecraftServer minecraftserver = MinecraftServer.getInstance();
			if (args[0].equals("on")) {
				minecraftserver.getPlayerList().a(true);
				a(sender, this, "commands.whitelist.enabled", new Object[0]);
			} else if (args[0].equals("off")) {
				minecraftserver.getPlayerList().a(false);
				a(sender, this, "commands.whitelist.disabled", new Object[0]);
			} else if (args[0].equals("list")) {
				sender.sendChatMessage(new ChatMessage("commands.whitelist.list", new Object[] { Integer.valueOf(minecraftserver.getPlayerList().getWhitelisted().length), Integer.valueOf(minecraftserver.getPlayerList().r().length) }));
				String[] var4 = minecraftserver.getPlayerList().getWhitelisted();
				sender.sendChatMessage(new ChatComponentText(a(var4)));
			} else {
				GameProfile var5;
				if (args[0].equals("add")) {
					if (args.length < 2) {
						throw new dp("commands.whitelist.add.usage", new Object[0]);
					}

					var5 = minecraftserver.getUserCache().getProfile(args[1]);
					if (var5 == null) {
						throw new di("commands.whitelist.add.failed", new Object[] { args[1] });
					}

					minecraftserver.getPlayerList().addWhitelist(var5);
					a(sender, this, "commands.whitelist.add.success", new Object[] { args[1] });
				} else if (args[0].equals("remove")) {
					if (args.length < 2) {
						throw new dp("commands.whitelist.remove.usage", new Object[0]);
					}

					var5 = minecraftserver.getPlayerList().getWhitelist().getByName(args[1]);
					if (var5 == null) {
						throw new di("commands.whitelist.remove.failed", new Object[] { args[1] });
					}

					minecraftserver.getPlayerList().removeWhitelist(var5);
					a(sender, this, "commands.whitelist.remove.success", new Object[] { args[1] });
				} else if (args[0].equals("reload")) {
					minecraftserver.getPlayerList().a();
					a(sender, this, "commands.whitelist.reloaded", new Object[0]);
				}
			}

		}
	}

	public List<String> getTabCompleteList(CommandSenderInterface var1, String[] args, Position var3) {
		if (args.length == 1) {
			return a(args, new String[] { "on", "off", "list", "add", "remove", "reload" });
		} else {
			if (args.length == 2) {
				if (args[0].equals("remove")) {
					return a(args, MinecraftServer.getInstance().getPlayerList().getWhitelisted());
				}

				if (args[0].equals("add")) {
					return a(args, MinecraftServer.getInstance().getUserCache().getNames());
				}
			}

			return null;
		}
	}
}
