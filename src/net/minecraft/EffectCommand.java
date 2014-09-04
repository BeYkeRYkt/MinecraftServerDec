package net.minecraft;

import java.util.List;
import net.minecraft.server.MinecraftServer;

public class EffectCommand extends AbstractCommand {

	public String getName() {
		return "effect";
	}

	public int a() {
		return 2;
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.effect.usage";
	}

	public void a(CommandSenderInterface var1, String[] var2) throws di {
		if (var2.length < 2) {
			throw new dp("commands.effect.usage", new Object[0]);
		} else {
			EntityLiving var3 = (EntityLiving) a(var1, var2[0], EntityLiving.class);
			if (var2[1].equals("clear")) {
				if (var3.bk().isEmpty()) {
					throw new di("commands.effect.failure.notActive.all", new Object[] { var3.d_() });
				} else {
					var3.bj();
					a(var1, this, "commands.effect.success.removed.all", new Object[] { var3.d_() });
				}
			} else {
				int var4;
				try {
					var4 = a(var2[1], 1);
				} catch (dk var11) {
					wp var6 = wp.b(var2[1]);
					if (var6 == null) {
						throw var11;
					}

					var4 = var6.H;
				}

				int var5 = 600;
				int var12 = 30;
				int var7 = 0;
				if (var4 >= 0 && var4 < wp.a.length && wp.a[var4] != null) {
					wp var8 = wp.a[var4];
					if (var2.length >= 3) {
						var12 = a(var2[2], 0, 1000000);
						if (var8.b()) {
							var5 = var12;
						} else {
							var5 = var12 * 20;
						}
					} else if (var8.b()) {
						var5 = 1;
					}

					if (var2.length >= 4) {
						var7 = a(var2[3], 0, 255);
					}

					boolean var9 = true;
					if (var2.length >= 5 && "true".equalsIgnoreCase(var2[4])) {
						var9 = false;
					}

					if (var12 > 0) {
						wq var10 = new wq(var4, var5, var7, false, var9);
						var3.c(var10);
						a(var1, this, "commands.effect.success", new Object[] { new hz(var10.g(), new Object[0]), Integer.valueOf(var4), Integer.valueOf(var7), var3.d_(), Integer.valueOf(var12) });
					} else if (var3.k(var4)) {
						var3.m(var4);
						a(var1, this, "commands.effect.success.removed", new Object[] { new hz(var8.a(), new Object[0]), var3.d_() });
					} else {
						throw new di("commands.effect.failure.notActive", new Object[] { new hz(var8.a(), new Object[0]), var3.d_() });
					}
				} else {
					throw new dk("commands.effect.notFound", new Object[] { Integer.valueOf(var4) });
				}
			}
		}
	}

	public List getTabCompleteList(CommandSenderInterface var1, String[] var2, dt var3) {
		return var2.length == 1 ? a(var2, this.d()) : (var2.length == 2 ? a(var2, wp.c()) : (var2.length == 5 ? a(var2, new String[] { "true", "false" }) : null));
	}

	protected String[] d() {
		return MinecraftServer.getInstance().I();
	}

	public boolean b(String[] var1, int var2) {
		return var2 == 0;
	}
}
