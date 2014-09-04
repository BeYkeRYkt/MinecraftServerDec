package net.minecraft;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.server.MinecraftServer;

public class BanIPCommand extends AbstractCommand {

	public static final Pattern a = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

	public String getName() {
		return "ban-ip";
	}

	public int a() {
		return 3;
	}

	public boolean a(CommandSenderInterface var1) {
		return MinecraftServer.getInstance().an().j().b() && super.a(var1);
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.banip.usage";
	}

	public void a(CommandSenderInterface var1, String[] var2) throws dm, dp {
		if (var2.length >= 1 && var2[0].length() > 1) {
			ho var3 = var2.length >= 2 ? a(var1, var2, 1) : null;
			Matcher var4 = a.matcher(var2[0]);
			if (var4.matches()) {
				this.a(var1, var2[0], var3 == null ? null : var3.c());
			} else {
				qw var5 = MinecraftServer.getInstance().an().a(var2[0]);
				if (var5 == null) {
					throw new dm("commands.banip.invalid", new Object[0]);
				}

				this.a(var1, var5.w(), var3 == null ? null : var3.c());
			}

		} else {
			throw new dp("commands.banip.usage", new Object[0]);
		}
	}

	public List a(CommandSenderInterface var1, String[] var2, dt var3) {
		return var2.length == 1 ? a(var2, MinecraftServer.getInstance().I()) : null;
	}

	protected void a(CommandSenderInterface var1, String var2, String var3) {
		se var4 = new se(var2, (Date) null, var1.d_(), (Date) null, var3);
		MinecraftServer.getInstance().an().j().a((sr) var4);
		List var5 = MinecraftServer.getInstance().an().b(var2);
		String[] var6 = new String[var5.size()];
		int var7 = 0;

		qw var9;
		for (Iterator var8 = var5.iterator(); var8.hasNext(); var6[var7++] = var9.d_()) {
			var9 = (qw) var8.next();
			var9.a.c("You have been IP banned.");
		}

		if (var5.isEmpty()) {
			a(var1, this, "commands.banip.success", new Object[] { var2 });
		} else {
			a(var1, this, "commands.banip.success.players", new Object[] { var2, a(var6) });
		}

	}

}
