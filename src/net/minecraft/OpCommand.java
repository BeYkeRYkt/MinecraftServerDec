package net.minecraft;

import com.google.common.collect.Lists;
import com.mojang.authlib.GameProfile;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.server.MinecraftServer;

public class OpCommand extends AbstractCommand {

	public String getName() {
		return "op";
	}

	public int a() {
		return 3;
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.op.usage";
	}

	public void a(CommandSenderInterface var1, String[] var2) throws di {
		if (var2.length == 1 && var2[0].length() > 0) {
			MinecraftServer var3 = MinecraftServer.getInstance();
			GameProfile var4 = var3.aD().a(var2[0]);
			if (var4 == null) {
				throw new di("commands.op.failed", new Object[] { var2[0] });
			} else {
				var3.an().a(var4);
				a(var1, this, "commands.op.success", new Object[] { var2[0] });
			}
		} else {
			throw new dp("commands.op.usage", new Object[0]);
		}
	}

	public List a(CommandSenderInterface var1, String[] var2, dt var3) {
		if (var2.length == 1) {
			String var4 = var2[var2.length - 1];
			ArrayList var5 = Lists.newArrayList();
			GameProfile[] var6 = MinecraftServer.getInstance().J();
			int var7 = var6.length;

			for (int var8 = 0; var8 < var7; ++var8) {
				GameProfile var9 = var6[var8];
				if (!MinecraftServer.getInstance().an().g(var9) && a(var4, var9.getName())) {
					var5.add(var9.getName());
				}
			}

			return var5;
		} else {
			return null;
		}
	}
}
