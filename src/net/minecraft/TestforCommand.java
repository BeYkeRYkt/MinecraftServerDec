package net.minecraft;

import java.util.List;
import net.minecraft.server.MinecraftServer;

public class TestforCommand extends AbstractCommand {

	public String getName() {
		return "testfor";
	}

	public int a() {
		return 2;
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.testfor.usage";
	}

	public void a(CommandSenderInterface var1, String[] var2) throws di {
		if (var2.length < 1) {
			throw new dp("commands.testfor.usage", new Object[0]);
		} else {
			Entity var3 = b(var1, var2[0]);
			NBTCompoundTag var4 = null;
			if (var2.length >= 2) {
				try {
					var4 = gg.a(a(var2, 1));
				} catch (gf var6) {
					throw new di("commands.testfor.tagError", new Object[] { var6.getMessage() });
				}
			}

			if (var4 != null) {
				NBTCompoundTag var5 = new NBTCompoundTag();
				var3.e(var5);
				if (!TestforBlockCommand.a(var4, var5, true)) {
					throw new di("commands.testfor.failure", new Object[] { var3.d_() });
				}
			}

			a(var1, this, "commands.testfor.success", new Object[] { var3.d_() });
		}
	}

	public boolean b(String[] var1, int var2) {
		return var2 == 0;
	}

	public List a(CommandSenderInterface var1, String[] var2, dt var3) {
		return var2.length == 1 ? a(var2, MinecraftServer.getInstance().I()) : null;
	}
}
