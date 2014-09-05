package net.minecraft;

import java.util.List;
import net.minecraft.server.MinecraftServer;

public class EntityDataCommand extends AbstractCommand {

	public String getName() {
		return "entitydata";
	}

	public int a() {
		return 2;
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.entitydata.usage";
	}

	public void executeCommand(CommandSenderInterface var1, String[] var2) throws di {
		if (var2.length < 2) {
			throw new dp("commands.entitydata.usage", new Object[0]);
		} else {
			Entity var3 = b(var1, var2[0]);
			if (var3 instanceof EntityHuman) {
				throw new di("commands.entitydata.noPlayers", new Object[] { var3.e_() });
			} else {
				NBTCompoundTag var4 = new NBTCompoundTag();
				var3.e(var4);
				NBTCompoundTag var5 = (NBTCompoundTag) var4.getCopy();

				NBTCompoundTag var6;
				try {
					var6 = gg.a(a(var1, var2, 1).c());
				} catch (gf var8) {
					throw new di("commands.entitydata.tagError", new Object[] { var8.getMessage() });
				}

				var6.remove("UUIDMost");
				var6.remove("UUIDLeast");
				var4.copyFrom(var6);
				if (var4.equals(var5)) {
					throw new di("commands.entitydata.failed", new Object[] { var4.toString() });
				} else {
					var3.f(var4);
					a(var1, this, "commands.entitydata.success", new Object[] { var4.toString() });
				}
			}
		}
	}

	public List getTabCompleteList(CommandSenderInterface var1, String[] var2, Position var3) {
		return var2.length == 1 ? a(var2, MinecraftServer.getInstance().I()) : null;
	}

	public boolean b(String[] var1, int var2) {
		return var2 == 0;
	}
}
