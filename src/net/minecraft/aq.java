package net.minecraft;

import com.google.common.base.Predicate;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.server.MinecraftServer;

final class aq implements Predicate {

	// $FF: synthetic field
	final Map a;

	aq(Map var1) {
		this.a = var1;
	}

	public boolean a(Entity var1) {
		Scoreboard var2 = MinecraftServer.getInstance().a(0).Z();
		Iterator var3 = this.a.entrySet().iterator();

		Entry var4;
		boolean var6;
		int var10;
		do {
			if (!var3.hasNext()) {
				return true;
			}

			var4 = (Entry) var3.next();
			String var5 = (String) var4.getKey();
			var6 = false;
			if (var5.endsWith("_min") && var5.length() > 4) {
				var6 = true;
				var5 = var5.substring(0, var5.length() - 4);
			}

			ScoreboardObjective var7 = var2.b(var5);
			if (var7 == null) {
				return false;
			}

			String var8 = var1 instanceof EntityPlayer ? var1.d_() : var1.aJ().toString();
			if (!var2.b(var8, var7)) {
				return false;
			}

			ScoreboardScore var9 = var2.c(var8, var7);
			var10 = var9.getScore();
			if (var10 < ((Integer) var4.getValue()).intValue() && var6) {
				return false;
			}
		} while (var10 <= ((Integer) var4.getValue()).intValue() || var6);

		return false;
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((Entity) var1);
	}
}
