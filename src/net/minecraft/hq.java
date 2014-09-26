package net.minecraft;

import java.util.Iterator;
import java.util.List;

public class hq {

	public static IChatBaseComponent a(CommandSenderInterface var0, IChatBaseComponent var1, Entity var2) throws dj {
		Object var3 = null;
		if (var1 instanceof ht) {
			ht var4 = (ht) var1;
			String var5 = var4.g();
			if (ah.b(var5)) {
				List var6 = ah.b(var0, var5, Entity.class);
				if (var6.size() != 1) {
					throw new dj();
				}

				var5 = ((Entity) var6.get(0)).getName();
			}

			var3 = var2 != null && var5.equals("*") ? new ht(var2.getName(), var4.h()) : new ht(var5, var4.h());
			((ht) var3).b(var4.getComponentVaue());
		} else if (var1 instanceof hu) {
			String var7 = ((hu) var1).g();
			var3 = ah.b(var0, var7);
			if (var3 == null) {
				var3 = new ChatComponentText("");
			}
		} else if (var1 instanceof ChatComponentText) {
			var3 = new ChatComponentText(((ChatComponentText) var1).g());
		} else {
			if (!(var1 instanceof ChatMessage)) {
				return var1;
			}

			Object[] var8 = ((ChatMessage) var1).j();

			for (int var10 = 0; var10 < var8.length; ++var10) {
				Object var12 = var8[var10];
				if (var12 instanceof IChatBaseComponent) {
					var8[var10] = a(var0, (IChatBaseComponent) var12, var2);
				}
			}

			var3 = new ChatMessage(((ChatMessage) var1).i(), var8);
		}

		ChatModifier var9 = var1.getChatModifier();
		if (var9 != null) {
			((IChatBaseComponent) var3).a(var9.m());
		}

		Iterator var11 = var1.a().iterator();

		while (var11.hasNext()) {
			IChatBaseComponent var13 = (IChatBaseComponent) var11.next();
			((IChatBaseComponent) var3).a(a(var0, var13, var2));
		}

		return (IChatBaseComponent) var3;
	}
}
