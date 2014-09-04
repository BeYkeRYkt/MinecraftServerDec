package net.minecraft;

import com.google.gson.JsonParseException;
import java.util.List;
import net.minecraft.server.MinecraftServer;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TitleCommand extends AbstractCommand {

	private static final Logger a = LogManager.getLogger();

	public String getName() {
		return "title";
	}

	public int a() {
		return 2;
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.title.usage";
	}

	public void a(CommandSenderInterface var1, String[] var2) throws dk, dl, dm, dj {
		if (var2.length < 2) {
			throw new dp("commands.title.usage", new Object[0]);
		} else {
			if (var2.length < 3) {
				if ("title".equals(var2[1]) || "subtitle".equals(var2[1])) {
					throw new dp("commands.title.usage.title", new Object[0]);
				}

				if ("times".equals(var2[1])) {
					throw new dp("commands.title.usage.times", new Object[0]);
				}
			}

			qw var3 = a(var1, var2[0]);
			lk var4 = lk.a(var2[1]);
			if (var4 != lk.d && var4 != lk.e) {
				if (var4 == lk.c) {
					if (var2.length != 5) {
						throw new dp("commands.title.usage", new Object[0]);
					} else {
						int var11 = a(var2[2]);
						int var12 = a(var2[3]);
						int var13 = a(var2[4]);
						lj var14 = new lj(var11, var12, var13);
						var3.a.a((id) var14);
						a(var1, this, "commands.title.success", new Object[0]);
					}
				} else if (var2.length < 3) {
					throw new dp("commands.title.usage", new Object[0]);
				} else {
					String var10 = a(var2, 2);

					ho var6;
					try {
						var6 = hp.a(var10);
					} catch (JsonParseException var9) {
						Throwable var8 = ExceptionUtils.getRootCause(var9);
						throw new dl("commands.tellraw.jsonException", new Object[] { var8 == null ? "" : var8.getMessage() });
					}

					lj var7 = new lj(var4, hq.a(var1, var6, var3));
					var3.a.a((id) var7);
					a(var1, this, "commands.title.success", new Object[0]);
				}
			} else if (var2.length != 2) {
				throw new dp("commands.title.usage", new Object[0]);
			} else {
				lj var5 = new lj(var4, (ho) null);
				var3.a.a((id) var5);
				a(var1, this, "commands.title.success", new Object[0]);
			}
		}
	}

	public List a(CommandSenderInterface var1, String[] var2, dt var3) {
		return var2.length == 1 ? a(var2, MinecraftServer.getInstance().I()) : (var2.length == 2 ? a(var2, lk.a()) : null);
	}

	public boolean b(String[] var1, int var2) {
		return var2 == 0;
	}

}
