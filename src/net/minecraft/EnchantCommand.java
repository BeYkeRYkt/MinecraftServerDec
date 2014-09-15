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

	public void executeCommand(CommandSenderInterface var1, String[] var2) throws di {
		if (var2.length < 2) {
			throw new dp("commands.enchant.usage", new Object[0]);
		} else {
			EntityPlayer var3 = a(var1, var2[0]);
			var1.a(ag.d, 0);

			int var4;
			try {
				var4 = a(var2[1], 0);
			} catch (dk var12) {
				Enchantment var6 = Enchantment.getByName(var2[1]);
				if (var6 == null) {
					throw var12;
				}

				var4 = var6.id;
			}

			int var5 = 1;
			ItemStack var13 = var3.bY();
			if (var13 == null) {
				throw new di("commands.enchant.noItem", new Object[0]);
			} else {
				Enchantment var7 = Enchantment.getById(var4);
				if (var7 == null) {
					throw new dk("commands.enchant.notFound", new Object[] { Integer.valueOf(var4) });
				} else if (!var7.canEnchant(var13)) {
					throw new di("commands.enchant.cantEnchant", new Object[0]);
				} else {
					if (var2.length >= 3) {
						var5 = a(var2[2], var7.getStartLevel(), var7.getMaxLevel());
					}

					if (var13.hasTag()) {
						NBTListTag var8 = var13.p();
						if (var8 != null) {
							for (int var9 = 0; var9 < var8.getSize(); ++var9) {
								short var10 = var8.getCompound(var9).getShort("id");
								if (Enchantment.getById(var10) != null) {
									Enchantment var11 = Enchantment.getById(var10);
									if (!var11.a(var7)) {
										throw new di("commands.enchant.cantCombine", new Object[] { var7.getName(var5), var11.getName(var8.getCompound(var9).getShort("lvl")) });
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

	public List getTabCompleteList(CommandSenderInterface var1, String[] var2, Position var3) {
		return var2.length == 1 ? a(var2, this.d()) : (var2.length == 2 ? a(var2, Enchantment.getEnchants()) : null);
	}

	protected String[] d() {
		return MinecraftServer.getInstance().I();
	}

	public boolean b(String[] var1, int var2) {
		return var2 == 0;
	}
}
