package net.minecraft;

import java.util.List;
import net.minecraft.server.MinecraftServer;

public class DifficultyCommand extends AbstractCommand {

	public String getName() {
		return "difficulty";
	}

	public int a() {
		return 2;
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.difficulty.usage";
	}

	public void executeCommand(CommandSenderInterface var1, String[] var2) throws dp, dk {
		if (var2.length <= 0) {
			throw new dp("commands.difficulty.usage", new Object[0]);
		} else {
			Difficulty var3 = this.e(var2[0]);
			MinecraftServer.getInstance().setWorldsDifficulty(var3);
			a(var1, this, "commands.difficulty.success", new Object[] { new ChatMessage(var3.getName(), new Object[0]) });
		}
	}

	protected Difficulty e(String var1) throws dk {
		return !var1.equalsIgnoreCase("peaceful") && !var1.equalsIgnoreCase("p") ? (!var1.equalsIgnoreCase("easy") && !var1.equalsIgnoreCase("e") ? (!var1.equalsIgnoreCase("normal") && !var1.equalsIgnoreCase("n") ? (!var1.equalsIgnoreCase("hard") && !var1.equalsIgnoreCase("h") ? Difficulty.clampAndGetById(a(var1, 0, 3)) : Difficulty.HARD) : Difficulty.NORMAL) : Difficulty.EASY) : Difficulty.PEACEFUL;
	}

	public List getTabCompleteList(CommandSenderInterface var1, String[] var2, Position var3) {
		return var2.length == 1 ? a(var2, new String[] { "peaceful", "easy", "normal", "hard" }) : null;
	}
}
