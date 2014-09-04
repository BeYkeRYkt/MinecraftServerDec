package net.minecraft;

import java.util.List;

public class BlockDataCommand extends AbstractCommand {

	public String getName() {
		return "blockdata";
	}

	public int a() {
		return 2;
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.blockdata.usage";
	}

	public void executeCommand(CommandSenderInterface var1, String[] var2) throws di {
		if (var2.length < 4) {
			throw new dp("commands.blockdata.usage", new Object[0]);
		} else {
			var1.a(ag.b, 0);
			dt var3 = a(var1, var2, 0, false);
			World var4 = var1.e();
			if (!var4.e(var3)) {
				throw new di("commands.blockdata.outOfWorld", new Object[0]);
			} else {
				bcm var5 = var4.s(var3);
				if (var5 == null) {
					throw new di("commands.blockdata.notValid", new Object[0]);
				} else {
					NBTCompoundTag var6 = new NBTCompoundTag();
					var5.b(var6);
					NBTCompoundTag var7 = (NBTCompoundTag) var6.getCopy();

					NBTCompoundTag var8;
					try {
						var8 = gg.a(a(var1, var2, 3).c());
					} catch (gf var10) {
						throw new di("commands.blockdata.tagError", new Object[] { var10.getMessage() });
					}

					var6.a(var8);
					var6.a("x", var3.n());
					var6.a("y", var3.o());
					var6.a("z", var3.p());
					if (var6.equals(var7)) {
						throw new di("commands.blockdata.failed", new Object[] { var6.toString() });
					} else {
						var5.a(var6);
						var5.o_();
						var4.h(var3);
						var1.a(ag.b, 1);
						a(var1, this, "commands.blockdata.success", new Object[] { var6.toString() });
					}
				}
			}
		}
	}

	public List getTabCompleteList(CommandSenderInterface var1, String[] var2, dt var3) {
		return var2.length > 0 && var2.length <= 3 ? a(var2, 0, var3) : null;
	}
}
