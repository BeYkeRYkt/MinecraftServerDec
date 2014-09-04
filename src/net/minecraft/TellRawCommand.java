package net.minecraft;

import com.google.gson.JsonParseException;
import java.util.List;
import net.minecraft.server.MinecraftServer;
import org.apache.commons.lang3.exception.ExceptionUtils;

public class TellRawCommand extends AbstractCommand {

	public String getName() {
		return "tellraw";
	}

	public int a() {
		return 2;
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.tellraw.usage";
	}

	public void a(CommandSenderInterface var1, String[] var2) throws dl, dm, dj {
		if (var2.length < 2) {
			throw new dp("commands.tellraw.usage", new Object[0]);
		} else {
			EntityPlayer var3 = a(var1, var2[0]);
			String var4 = a(var2, 1);

			try {
				ho var5 = hp.a(var4);
				var3.a(hq.a(var1, var5, var3));
			} catch (JsonParseException var7) {
				Throwable var6 = ExceptionUtils.getRootCause(var7);
				throw new dl("commands.tellraw.jsonException", new Object[] { var6 == null ? "" : var6.getMessage() });
			}
		}
	}

	public List getTabCompleteList(CommandSenderInterface var1, String[] var2, dt var3) {
		return var2.length == 1 ? a(var2, MinecraftServer.getInstance().I()) : null;
	}

	public boolean b(String[] var1, int var2) {
		return var2 == 0;
	}
}
