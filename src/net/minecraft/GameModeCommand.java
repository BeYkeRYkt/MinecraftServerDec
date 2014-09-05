package net.minecraft;

import java.util.List;
import net.minecraft.server.MinecraftServer;

public class GameModeCommand extends AbstractCommand {

	public String getName() {
		return "gamemode";
	}

	public int a() {
		return 2;
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.gamemode.usage";
	}

	public void executeCommand(CommandSenderInterface var1, String[] var2) throws dp, dm, dk {
		if (var2.length <= 0) {
			throw new dp("commands.gamemode.usage", new Object[0]);
		} else {
			GameMode var3 = this.h(var1, var2[0]);
			EntityPlayer var4 = var2.length >= 2 ? a(var1, var2[1]) : b(var1);
			var4.a(var3);
			var4.O = 0.0F;
			if (var1.e().Q().b("sendCommandFeedback")) {
				var4.sendChatMessage((IJSONComponent) (new hz("gameMode.changed", new Object[0])));
			}

			hz var5 = new hz("gameMode." + var3.getName(), new Object[0]);
			if (var4 != var1) {
				a(var1, this, 1, "commands.gamemode.success.other", new Object[] { var4.d_(), var5 });
			} else {
				a(var1, this, 1, "commands.gamemode.success.self", new Object[] { var5 });
			}

		}
	}

	protected GameMode h(CommandSenderInterface var1, String var2) throws dk {
		return !var2.equalsIgnoreCase(GameMode.SURVIVAL.getName()) && !var2.equalsIgnoreCase("s") ? (!var2.equalsIgnoreCase(GameMode.CREATIVE.getName()) && !var2.equalsIgnoreCase("c") ? (!var2.equalsIgnoreCase(GameMode.ADVENTURE.getName()) && !var2.equalsIgnoreCase("a") ? (!var2.equalsIgnoreCase(GameMode.SPECTATOR.getName()) && !var2.equalsIgnoreCase("sp") ? arb.a(a(var2, 0, GameMode.values().length - 2)) : GameMode.SPECTATOR) : GameMode.ADVENTURE) : GameMode.CREATIVE) : GameMode.SURVIVAL;
	}

	public List getTabCompleteList(CommandSenderInterface var1, String[] var2, Position var3) {
		return var2.length == 1 ? a(var2, new String[] { "survival", "creative", "adventure", "spectator" }) : (var2.length == 2 ? a(var2, this.d()) : null);
	}

	protected String[] d() {
		return MinecraftServer.getInstance().I();
	}

	public boolean b(String[] var1, int var2) {
		return var2 == 1;
	}
}
