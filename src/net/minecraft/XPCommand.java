package net.minecraft;

import java.util.List;
import net.minecraft.server.MinecraftServer;

public class XPCommand extends AbstractCommand {

	public String getName() {
		return "xp";
	}

	public int a() {
		return 2;
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.xp.usage";
	}

	public void a(CommandSenderInterface var1, String[] var2) throws di {
		if (var2.length <= 0) {
			throw new dp("commands.xp.usage", new Object[0]);
		} else {
			String var3 = var2[0];
			boolean var4 = var3.endsWith("l") || var3.endsWith("L");
			if (var4 && var3.length() > 1) {
				var3 = var3.substring(0, var3.length() - 1);
			}

			int var5 = a(var3);
			boolean var6 = var5 < 0;
			if (var6) {
				var5 *= -1;
			}

			qw var7 = var2.length > 1 ? a(var1, var2[1]) : b(var1);
			if (var4) {
				var1.a(ag.e, var7.bz);
				if (var6) {
					var7.a(-var5);
					a(var1, this, "commands.xp.success.negative.levels", new Object[] { Integer.valueOf(var5), var7.d_() });
				} else {
					var7.a(var5);
					a(var1, this, "commands.xp.success.levels", new Object[] { Integer.valueOf(var5), var7.d_() });
				}
			} else {
				var1.a(ag.e, var7.bA);
				if (var6) {
					throw new di("commands.xp.failure.widthdrawXp", new Object[0]);
				}

				var7.u(var5);
				a(var1, this, "commands.xp.success", new Object[] { Integer.valueOf(var5), var7.d_() });
			}

		}
	}

	public List a(CommandSenderInterface var1, String[] var2, dt var3) {
		return var2.length == 2 ? a(var2, this.d()) : null;
	}

	protected String[] d() {
		return MinecraftServer.getInstance().I();
	}

	public boolean b(String[] var1, int var2) {
		return var2 == 1;
	}
}
