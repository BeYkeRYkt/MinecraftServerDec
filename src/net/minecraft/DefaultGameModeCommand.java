package net.minecraft;

import java.util.Iterator;
import net.minecraft.server.MinecraftServer;

public class DefaultGameModeCommand extends GameModeCommand {

	public String getName() {
		return "defaultgamemode";
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.defaultgamemode.usage";
	}

	public void a(CommandSenderInterface var1, String[] var2) throws dp, dk {
		if (var2.length <= 0) {
			throw new dp("commands.defaultgamemode.usage", new Object[0]);
		} else {
			arc var3 = this.h(var1, var2[0]);
			this.a(var3);
			a(var1, this, "commands.defaultgamemode.success", new Object[] { new hz("gameMode." + var3.b(), new Object[0]) });
		}
	}

	protected void a(arc var1) {
		MinecraftServer var2 = MinecraftServer.getInstance();
		var2.a(var1);
		qw var4;
		if (var2.av()) {
			for (Iterator var3 = MinecraftServer.getInstance().an().e.iterator(); var3.hasNext(); var4.O = 0.0F) {
				var4 = (qw) var3.next();
				var4.a(var1);
			}
		}

	}
}
