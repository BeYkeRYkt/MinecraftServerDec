package net.minecraft;

import com.mojang.authlib.GameProfile;
import java.util.List;
import net.minecraft.server.MinecraftServer;

public class UnbanNameCommand extends AbstractCommand {

	public String getName() {
		return "pardon";
	}

	public int a() {
		return 3;
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.unban.usage";
	}

	public boolean a(CommandSenderInterface var1) {
		return MinecraftServer.getInstance().an().i().b() && super.a(var1);
	}

	public void a(CommandSenderInterface var1, String[] var2) throws di {
		if (var2.length == 1 && var2[0].length() > 0) {
			MinecraftServer var3 = MinecraftServer.getInstance();
			GameProfile var4 = var3.an().i().a(var2[0]);
			if (var4 == null) {
				throw new di("commands.unban.failed", new Object[] { var2[0] });
			} else {
				var3.an().i().c(var4);
				a(var1, this, "commands.unban.success", new Object[] { var2[0] });
			}
		} else {
			throw new dp("commands.unban.usage", new Object[0]);
		}
	}

	public List a(CommandSenderInterface var1, String[] var2, dt var3) {
		return var2.length == 1 ? a(var2, MinecraftServer.getInstance().an().i().a()) : null;
	}
}
