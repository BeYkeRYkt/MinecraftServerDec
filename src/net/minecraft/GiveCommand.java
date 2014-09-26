package net.minecraft;

import java.util.List;
import net.minecraft.server.MinecraftServer;

public class GiveCommand extends AbstractCommand {

	public String getName() {
		return "give";
	}

	public int a() {
		return 2;
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.give.usage";
	}

	public void executeCommand(CommandSenderInterface var1, String[] var2) throws di {
		if (var2.length < 2) {
			throw new dp("commands.give.usage", new Object[0]);
		} else {
			EntityPlayer var3 = a(var1, var2[0]);
			Item var4 = f(var1, var2[1]);
			int var5 = var2.length >= 3 ? a(var2[2], 1, 64) : 1;
			int var6 = var2.length >= 4 ? a(var2[3]) : 0;
			ItemStack var7 = new ItemStack(var4, var5, var6);
			if (var2.length >= 5) {
				String var8 = a(var1, var2, 4).getJsonMessage();

				try {
					var7.setTag(gg.a(var8));
				} catch (gf var10) {
					throw new di("commands.give.tagError", new Object[] { var10.getMessage() });
				}
			}

			boolean var11 = var3.playerInventory.pickup(var7);
			if (var11) {
				var3.world.a((Entity) var3, "random.pop", 0.2F, ((var3.bb().nextFloat() - var3.bb().nextFloat()) * 0.7F + 1.0F) * 2.0F);
				var3.defaultContainer.b();
			}

			EntityItem var9;
			if (var11 && var7.amount <= 0) {
				var7.amount = 1;
				var1.a(ag.d, var5);
				var9 = var3.dropItem(var7, false);
				if (var9 != null) {
					var9.v();
				}
			} else {
				var1.a(ag.d, var5 - var7.amount);
				var9 = var3.dropItem(var7, false);
				if (var9 != null) {
					var9.q();
					var9.b(var3.getName());
				}
			}

			a(var1, this, "commands.give.success", new Object[] { var7.C(), Integer.valueOf(var5), var3.getName() });
		}
	}

	public List getTabCompleteList(CommandSenderInterface var1, String[] var2, Position var3) {
		return var2.length == 1 ? a(var2, this.d()) : (var2.length == 2 ? a(var2, Item.REGISTRY.c()) : null);
	}

	protected String[] d() {
		return MinecraftServer.getInstance().I();
	}

	public boolean b(String[] var1, int var2) {
		return var2 == 0;
	}
}
