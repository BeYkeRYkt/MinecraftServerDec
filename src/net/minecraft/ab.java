package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ab implements CommandHandlerInterface {

	private static final Logger a = LogManager.getLogger();
	private final Map b = Maps.newHashMap();
	private final Set c = Sets.newHashSet();

	public int a(CommandSenderInterface var1, String var2) {
		var2 = var2.trim();
		if (var2.startsWith("/")) {
			var2 = var2.substring(1);
		}

		String[] var3 = var2.split(" ");
		String var4 = var3[0];
		var3 = a(var3);
		CommandInterface var5 = (CommandInterface) this.b.get(var4);
		int var6 = this.a(var5, var3);
		int var7 = 0;
		hz var8;
		if (var5 == null) {
			var8 = new hz("commands.generic.notFound", new Object[0]);
			var8.b().a(FormattingCode.m);
			var1.a(var8);
		} else if (var5.a(var1)) {
			if (var6 > -1) {
				List var12 = ah.b(var1, var3[var6], Entity.class);
				String var9 = var3[var6];
				var1.a(ag.c, var12.size());
				Iterator var10 = var12.iterator();

				while (var10.hasNext()) {
					Entity var11 = (Entity) var10.next();
					var3[var6] = var11.aJ().toString();
					if (this.a(var1, var3, var5, var2)) {
						++var7;
					}
				}

				var3[var6] = var9;
			} else {
				var1.a(ag.c, 1);
				if (this.a(var1, var3, var5, var2)) {
					++var7;
				}
			}
		} else {
			var8 = new hz("commands.generic.permission", new Object[0]);
			var8.b().a(FormattingCode.m);
			var1.a(var8);
		}

		var1.a(ag.a, var7);
		return var7;
	}

	protected boolean a(CommandSenderInterface var1, String[] var2, CommandInterface var3, String var4) {
		hz var6;
		try {
			var3.a(var1, var2);
			return true;
		} catch (dp var7) {
			var6 = new hz("commands.generic.usage", new Object[] { new hz(var7.getMessage(), var7.a()) });
			var6.b().a(FormattingCode.m);
			var1.a(var6);
		} catch (di var8) {
			var6 = new hz(var8.getMessage(), var8.a());
			var6.b().a(FormattingCode.m);
			var1.a(var6);
		} catch (Throwable var9) {
			var6 = new hz("commands.generic.exception", new Object[0]);
			var6.b().a(FormattingCode.m);
			var1.a(var6);
			a.error("Couldn\'t process command: \'" + var4 + "\'", var9);
		}

		return false;
	}

	public CommandInterface a(CommandInterface var1) {
		this.b.put(var1.getName(), var1);
		this.c.add(var1);
		Iterator var2 = var1.getAliases().iterator();

		while (var2.hasNext()) {
			String var3 = (String) var2.next();
			CommandInterface var4 = (CommandInterface) this.b.get(var3);
			if (var4 == null || !var4.getName().equals(var3)) {
				this.b.put(var3, var1);
			}
		}

		return var1;
	}

	private static String[] a(String[] var0) {
		String[] var1 = new String[var0.length - 1];
		System.arraycopy(var0, 1, var1, 0, var0.length - 1);
		return var1;
	}

	public List a(CommandSenderInterface var1, String var2, dt var3) {
		String[] var4 = var2.split(" ", -1);
		String var5 = var4[0];
		if (var4.length == 1) {
			ArrayList var9 = Lists.newArrayList();
			Iterator var7 = this.b.entrySet().iterator();

			while (var7.hasNext()) {
				Entry var8 = (Entry) var7.next();
				if (AbstractCommand.startWith(var5, (String) var8.getKey()) && ((CommandInterface) var8.getValue()).a(var1)) {
					var9.add(var8.getKey());
				}
			}

			return var9;
		} else {
			if (var4.length > 1) {
				CommandInterface var6 = (CommandInterface) this.b.get(var5);
				if (var6 != null && var6.a(var1)) {
					return var6.getTabCompleteList(var1, a(var4), var3);
				}
			}

			return null;
		}
	}

	public List a(CommandSenderInterface var1) {
		ArrayList var2 = Lists.newArrayList();
		Iterator var3 = this.c.iterator();

		while (var3.hasNext()) {
			CommandInterface var4 = (CommandInterface) var3.next();
			if (var4.a(var1)) {
				var2.add(var4);
			}
		}

		return var2;
	}

	public Map a() {
		return this.b;
	}

	private int a(CommandInterface var1, String[] var2) {
		if (var1 == null) {
			return -1;
		} else {
			for (int var3 = 0; var3 < var2.length; ++var3) {
				if (var1.b(var2, var3) && ah.a(var2[var3])) {
					return var3;
				}
			}

			return -1;
		}
	}

}
