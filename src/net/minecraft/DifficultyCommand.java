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

	public void a(CommandSenderInterface var1, String[] var2) throws dp, dk {
		if (var2.length <= 0) {
			throw new dp("commands.difficulty.usage", new Object[0]);
		} else {
			vt var3 = this.e(var2[0]);
			MinecraftServer.getInstance().a(var3);
			a(var1, this, "commands.difficulty.success", new Object[] { new hz(var3.b(), new Object[0]) });
		}
	}

	protected vt e(String var1) throws dk {
		return !var1.equalsIgnoreCase("peaceful") && !var1.equalsIgnoreCase("p") ? (!var1.equalsIgnoreCase("easy") && !var1.equalsIgnoreCase("e") ? (!var1.equalsIgnoreCase("normal") && !var1.equalsIgnoreCase("n") ? (!var1.equalsIgnoreCase("hard") && !var1.equalsIgnoreCase("h") ? vt.a(a(var1, 0, 3)) : vt.d) : vt.c) : vt.b) : vt.a;
	}

	public List a(CommandSenderInterface var1, String[] var2, dt var3) {
		return var2.length == 1 ? a(var2, new String[] { "peaceful", "easy", "normal", "hard" }) : null;
	}
}
