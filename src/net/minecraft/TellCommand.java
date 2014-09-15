package net.minecraft;

import java.util.Arrays;
import java.util.List;
import net.minecraft.server.MinecraftServer;

public class TellCommand extends AbstractCommand {

	public List<String> getAliases() {
		return Arrays.asList(new String[] { "w", "msg" });
	}

	public String getName() {
		return "tell";
	}

	public int a() {
		return 0;
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.message.usage";
	}

	public void executeCommand(CommandSenderInterface var1, String[] var2) throws dp, dm {
		if (var2.length < 2) {
			throw new dp("commands.message.usage", new Object[0]);
		} else {
			EntityPlayer var3 = a(var1, var2[0]);
			if (var3 == var1) {
				throw new dm("commands.message.sameTarget", new Object[0]);
			} else {
				IChatBaseComponent var4 = b(var1, var2, 1, !(var1 instanceof EntityHuman));
				ChatMessage var5 = new ChatMessage("commands.message.display.incoming", new Object[] { var1.getComponentName(), var4.f() });
				ChatMessage var6 = new ChatMessage("commands.message.display.outgoing", new Object[] { var3.getComponentName(), var4.f() });
				var5.getChatModifier().setColor(EnumChatFormat.GRAY).b(Boolean.valueOf(true));
				var6.getChatModifier().setColor(EnumChatFormat.GRAY).b(Boolean.valueOf(true));
				var3.sendChatMessage((IChatBaseComponent) var5);
				var1.sendChatMessage(var6);
			}
		}
	}

	public List getTabCompleteList(CommandSenderInterface var1, String[] var2, Position var3) {
		return a(var2, MinecraftServer.getInstance().I());
	}

	public boolean b(String[] var1, int var2) {
		return var2 == 0;
	}
}
