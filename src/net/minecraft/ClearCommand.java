package net.minecraft;

import java.util.List;
import net.minecraft.server.MinecraftServer;

public class ClearCommand extends AbstractCommand {

	public String getName() {
		return "clear";
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.clear.usage";
	}

	public int a() {
		return 2;
	}

	public void a(CommandSenderInterface var1, String[] var2) throws di {
		qw var3 = var2.length == 0 ? b(var1) : a(var1, var2[0]);
		alq var4 = var2.length >= 2 ? f(var1, var2[1]) : null;
		int var5 = var2.length >= 3 ? a(var2[2], -1) : -1;
		int var6 = var2.length >= 4 ? a(var2[3], -1) : -1;
		NBTCompoundTag var7 = null;
		if (var2.length >= 5) {
			try {
				var7 = gg.a(a(var2, 4));
			} catch (gf var9) {
				throw new di("commands.clear.tagError", new Object[] { var9.getMessage() });
			}
		}

		if (var2.length >= 2 && var4 == null) {
			throw new di("commands.clear.failure", new Object[] { var3.d_() });
		} else {
			int var8 = var3.bg.a(var4, var5, var6, var7);
			var3.bh.b();
			if (!var3.by.d) {
				var3.o();
			}

			var1.a(ag.d, var8);
			if (var8 == 0) {
				throw new di("commands.clear.failure", new Object[] { var3.d_() });
			} else {
				if (var6 == 0) {
					var1.a(new hz("commands.clear.testing", new Object[] { var3.d_(), Integer.valueOf(var8) }));
				} else {
					a(var1, this, "commands.clear.success", new Object[] { var3.d_(), Integer.valueOf(var8) });
				}

			}
		}
	}

	public List a(CommandSenderInterface var1, String[] var2, dt var3) {
		return var2.length == 1 ? a(var2, this.d()) : (var2.length == 2 ? a(var2, alq.e.c()) : null);
	}

	protected String[] d() {
		return MinecraftServer.getInstance().I();
	}

	public boolean b(String[] var1, int var2) {
		return var2 == 0;
	}
}
