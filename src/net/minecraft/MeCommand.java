package net.minecraft;

import java.util.List;
import net.minecraft.server.MinecraftServer;

public class MeCommand extends AbstractCommand {

	public String getName() {
		return "me";
	}

	public int a() {
		return 0;
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.me.usage";
	}

	public void executeCommand(CommandSenderInterface var1, String[] var2) throws dp, dm {
		if (var2.length <= 0) {
			throw new dp("commands.me.usage", new Object[0]);
		} else {
			IChatBaseComponent var3 = b(var1, var2, 0, !(var1 instanceof EntityHuman));
			MinecraftServer.getInstance().getPlayerList().sendMessage((IChatBaseComponent) (new ChatMessage("chat.type.emote", new Object[] { var1.getComponentName(), var3 })));
		}
	}

	public List getTabCompleteList(CommandSenderInterface var1, String[] var2, Position var3) {
		return a(var2, MinecraftServer.getInstance().I());
	}
}
