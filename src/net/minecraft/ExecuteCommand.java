package net.minecraft;

import java.util.List;
import net.minecraft.server.MinecraftServer;

public class ExecuteCommand extends AbstractCommand {

	public String getName() {
		return "execute";
	}

	public int a() {
		return 2;
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.execute.usage";
	}

	public void executeCommand(CommandSenderInterface var1, String[] var2) throws di {
		if (var2.length < 5) {
			throw new dp("commands.execute.usage", new Object[0]);
		} else {
			Entity var3 = a(var1, var2[0], Entity.class);
			double var4 = b(var3.locationX, var2[1], false);
			double var6 = b(var3.locationY, var2[2], false);
			double var8 = b(var3.locationZ, var2[3], false);
			Position var10 = new Position(var4, var6, var8);
			byte var11 = 4;
			if ("detect".equals(var2[4]) && var2.length > 10) {
				World var12 = var1.e();
				double var13 = b(var4, var2[5], false);
				double var15 = b(var6, var2[6], false);
				double var17 = b(var8, var2[7], false);
				Block var19 = g(var1, var2[8]);
				int var20 = a(var2[9], -1, 15);
				Position var21 = new Position(var13, var15, var17);
				bec var22 = var12.p(var21);
				if (var22.c() != var19 || var20 >= 0 && var22.c().c(var22) != var20) {
					throw new di("commands.execute.failed", new Object[] { "detect", var3.d_() });
				}

				var11 = 10;
			}

			String var24 = a(var2, var11);
			bl var14 = new bl(this, var3, var1, var10, var4, var6, var8);
			CommandHandlerInterface var25 = MinecraftServer.getInstance().getCommandHandler();

			try {
				int var16 = var25.a(var14, var24);
				if (var16 < 1) {
					throw new di("commands.execute.allInvocationsFailed", new Object[] { var24 });
				}
			} catch (Throwable var23) {
				throw new di("commands.execute.failed", new Object[] { var24, var3.d_() });
			}
		}
	}

	public List getTabCompleteList(CommandSenderInterface var1, String[] var2, Position var3) {
		return var2.length == 1 ? a(var2, MinecraftServer.getInstance().I()) : (var2.length > 1 && var2.length <= 4 ? a(var2, 1, var3) : (var2.length > 5 && var2.length <= 8 && "detect".equals(var2[4]) ? a(var2, 5, var3) : (var2.length == 9 && "detect".equals(var2[4]) ? a(var2, Block.c.c()) : null)));
	}

	public boolean b(String[] var1, int var2) {
		return var2 == 0;
	}
}
