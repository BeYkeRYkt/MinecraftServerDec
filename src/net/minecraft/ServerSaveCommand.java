package net.minecraft;

import net.minecraft.server.MinecraftServer;

public class ServerSaveCommand extends AbstractCommand {

	public String getName() {
		return "save-all";
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.save.usage";
	}

	public void executeCommand(CommandSenderInterface var1, String[] var2) {
		MinecraftServer var3 = MinecraftServer.getInstance();
		var1.sendChatMessage(new ChatMessage("commands.save.start", new Object[0]));
		if (var3.getPlayerList() != null) {
			var3.getPlayerList().savePlayers();
		}

		int var4;
		WorldServer var5;
		boolean var6;
		for (var4 = 0; var4 < var3.worlds.size(); ++var4) {
			if (var3.worlds.get(var4) != null) {
				var5 = var3.worlds.get(var4);
				var6 = var5.savingDisabled;
				var5.savingDisabled = false;
				try {
					var5.save(true, (IProgressUpdate) null);
				} catch (ExceptionWorldConflict e) {
					e.printStackTrace();
				}
				var5.savingDisabled = var6;
			}
		}

		if (var2.length > 0 && "flush".equals(var2[0])) {
			var1.sendChatMessage(new ChatMessage("commands.save.flushStart", new Object[0]));

			for (var4 = 0; var4 < var3.worlds.size(); ++var4) {
				if (var3.worlds.get(var4) != null) {
					var5 = var3.worlds.get(var4);
					var6 = var5.savingDisabled;
					var5.savingDisabled = false;
					var5.n();
					var5.savingDisabled = var6;
				}
			}

			var1.sendChatMessage(new ChatMessage("commands.save.flushEnd", new Object[0]));
		}

		a(var1, this, "commands.save.success", new Object[0]);
	}
}
