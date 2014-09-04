package net.minecraft;

import java.util.List;
import net.minecraft.server.MinecraftServer;

public class EnchantCommand extends AbstractCommand {

	public String getName() {
		return "enchant";
	}

	public int a() {
		return 2;
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.enchant.usage";
	}

	public void a(CommandSenderInterface var1, String[] var2) throws di {
		if (var2.length < 2) {
			throw new dp("commands.enchant.usage", new Object[0]);
		} else {
			EntityPlayer var3 = a(var1, var2[0]);
			var1.a(ag.d, 0);

			int var4;
			try {
				var4 = a(var2[1], 0);
			} catch (dk var12) {
				apf var6 = apf.b(var2[1]);
				if (var6 == null) {
					throw var12;
				}

				var4 = var6.B;
			}

			int var5 = 1;
			amj var13 = var3.bY();
			if (var13 == null) {
				throw new di("commands.enchant.noItem", new Object[0]);
			} else {
				apf var7 = apf.c(var4);
				if (var7 == null) {
					throw new dk("commands.enchant.notFound", new Object[] { Integer.valueOf(var4) });
				} else if (!var7.a(var13)) {
					throw new di("commands.enchant.cantEnchant", new Object[0]);
				} else {
					if (var2.length >= 3) {
						var5 = a(var2[2], var7.e(), var7.b());
					}

					if (var13.n()) {
						NBTListTag var8 = var13.p();
						if (var8 != null) {
							for (int var9 = 0; var9 < var8.c(); ++var9) {
								short var10 = var8.b(var9).e("id");
								if (apf.c(var10) != null) {
									apf var11 = apf.c(var10);
									if (!var11.a(var7)) {
										throw new di("commands.enchant.cantCombine", new Object[] { var7.d(var5), var11.d(var8.b(var9).e("lvl")) });
									}
								}
							}
						}
					}

					var13.a(var7, var5);
					a(var1, this, "commands.enchant.success", new Object[0]);
					var1.a(ag.d, 1);
				}
			}
		}
	}

	public List getTabCompleteList(CommandSenderInterface var1, String[] var2, dt var3) {
		return var2.length == 1 ? a(var2, this.d()) : (var2.length == 2 ? a(var2, apf.c()) : null);
	}

	protected String[] d() {
		return MinecraftServer.getInstance().I();
	}

	public boolean b(String[] var1, int var2) {
		return var2 == 0;
	}
}
