package net.minecraft;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.server.MinecraftServer;

public class HelpCommand extends AbstractCommand {

	public String getName() {
		return "help";
	}

	public int a() {
		return 0;
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.help.usage";
	}

	public List<String> getAliases() {
		return Arrays.asList(new String[] { "?" });
	}

	public void executeCommand(CommandSenderInterface var1, String[] var2) throws dp, dk, dn {
		List var3 = this.d(var1);
		boolean var4 = true;
		int var5 = (var3.size() - 1) / 7;
		boolean var6 = false;

		int var13;
		try {
			var13 = var2.length == 0 ? 0 : a(var2[0], 1, var5 + 1) - 1;
		} catch (dk var12) {
			Map var8 = this.d();
			ICommand var9 = (ICommand) var8.get(var2[0]);
			if (var9 != null) {
				throw new dp(var9.getUsage(var1), new Object[0]);
			}

			if (MathHelper.a(var2[0], -1) != -1) {
				throw var12;
			}

			throw new dn();
		}

		int var7 = Math.min((var13 + 1) * 7, var3.size());
		ChatMessage var14 = new ChatMessage("commands.help.header", new Object[] { Integer.valueOf(var13 + 1), Integer.valueOf(var5 + 1) });
		var14.getChatModifier().setColor(EnumChatFormat.DARK_GREEN);
		var1.sendChatMessage(var14);

		for (int var15 = var13 * 7; var15 < var7; ++var15) {
			ICommand var10 = (ICommand) var3.get(var15);
			ChatMessage var11 = new ChatMessage(var10.getUsage(var1), new Object[0]);
			var11.getChatModifier().a(new hm(hn.e, "/" + var10.getName() + " "));
			var1.sendChatMessage(var11);
		}

		if (var13 == 0 && var1 instanceof EntityHuman) {
			ChatMessage var16 = new ChatMessage("commands.help.footer", new Object[0]);
			var16.getChatModifier().setColor(EnumChatFormat.GREEN);
			var1.sendChatMessage(var16);
		}

	}

	protected List d(CommandSenderInterface var1) {
		List var2 = MinecraftServer.getInstance().getCommandHandler().a(var1);
		Collections.sort(var2);
		return var2;
	}

	protected Map d() {
		return MinecraftServer.getInstance().getCommandHandler().a();
	}

	public List getTabCompleteList(CommandSenderInterface var1, String[] var2, Position var3) {
		if (var2.length == 1) {
			Set var4 = this.d().keySet();
			return a(var2, (String[]) var4.toArray(new String[var4.size()]));
		} else {
			return null;
		}
	}
}
