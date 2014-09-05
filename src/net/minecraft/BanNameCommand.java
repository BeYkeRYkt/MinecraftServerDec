package net.minecraft;

import com.mojang.authlib.GameProfile;
import java.util.Date;
import java.util.List;
import net.minecraft.server.MinecraftServer;

public class BanNameCommand extends AbstractCommand {

	public String getName() {
		return "ban";
	}

	public int a() {
		return 3;
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.ban.usage";
	}

	public boolean a(CommandSenderInterface var1) {
		return MinecraftServer.getInstance().getPlayerList().i().b() && super.a(var1);
	}

	public void executeCommand(CommandSenderInterface var1, String[] var2) throws di {
		if (var2.length >= 1 && var2[0].length() > 0) {
			MinecraftServer var3 = MinecraftServer.getInstance();
			GameProfile var4 = var3.getUserCache().getProfile(var2[0]);
			if (var4 == null) {
				throw new di("commands.ban.failed", new Object[] { var2[0] });
			} else {
				String var5 = null;
				if (var2.length >= 2) {
					var5 = a(var1, var2, 1).c();
				}

				sw var6 = new sw(var4, (Date) null, var1.d_(), (Date) null, var5);
				var3.getPlayerList().i().a((sr) var6);
				EntityPlayer var7 = var3.getPlayerList().a(var2[0]);
				if (var7 != null) {
					var7.playerConncetion.c("You are banned from this server.");
				}

				a(var1, this, "commands.ban.success", new Object[] { var2[0] });
			}
		} else {
			throw new dp("commands.ban.usage", new Object[0]);
		}
	}

	public List getTabCompleteList(CommandSenderInterface var1, String[] var2, Position var3) {
		return var2.length >= 1 ? a(var2, MinecraftServer.getInstance().I()) : null;
	}
}
