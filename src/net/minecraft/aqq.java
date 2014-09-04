package net.minecraft;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class aqq {

	private TreeMap a = new TreeMap();

	public aqq() {
		this.a("doFireTick", "true", aqs.b);
		this.a("mobGriefing", "true", aqs.b);
		this.a("keepInventory", "false", aqs.b);
		this.a("doMobSpawning", "true", aqs.b);
		this.a("doMobLoot", "true", aqs.b);
		this.a("doTileDrops", "true", aqs.b);
		this.a("commandBlockOutput", "true", aqs.b);
		this.a("naturalRegeneration", "true", aqs.b);
		this.a("doDaylightCycle", "true", aqs.b);
		this.a("logAdminCommands", "true", aqs.b);
		this.a("showDeathMessages", "true", aqs.b);
		this.a("randomTickSpeed", "3", aqs.c);
		this.a("sendCommandFeedback", "true", aqs.b);
		this.a("reducedDebugInfo", "false", aqs.b);
	}

	public void a(String var1, String var2, aqs var3) {
		this.a.put(var1, new aqr(var2, var3));
	}

	public void a(String var1, String var2) {
		aqr var3 = (aqr) this.a.get(var1);
		if (var3 != null) {
			var3.a(var2);
		} else {
			this.a(var1, var2, aqs.a);
		}

	}

	public String a(String var1) {
		aqr var2 = (aqr) this.a.get(var1);
		return var2 != null ? var2.a() : "";
	}

	public boolean b(String var1) {
		aqr var2 = (aqr) this.a.get(var1);
		return var2 != null ? var2.b() : false;
	}

	public int c(String var1) {
		aqr var2 = (aqr) this.a.get(var1);
		return var2 != null ? var2.c() : 0;
	}

	public NBTCompoundTag a() {
		NBTCompoundTag var1 = new NBTCompoundTag();
		Iterator var2 = this.a.keySet().iterator();

		while (var2.hasNext()) {
			String var3 = (String) var2.next();
			aqr var4 = (aqr) this.a.get(var3);
			var1.put(var3, var4.a());
		}

		return var1;
	}

	public void a(NBTCompoundTag var1) {
		Set var2 = var1.getKeys();
		Iterator var3 = var2.iterator();

		while (var3.hasNext()) {
			String var4 = (String) var3.next();
			String var6 = var1.getString(var4);
			this.a(var4, var6);
		}

	}

	public String[] b() {
		return (String[]) this.a.keySet().toArray(new String[0]);
	}

	public boolean e(String var1) {
		return this.a.containsKey(var1);
	}

	public boolean a(String var1, aqs var2) {
		aqr var3 = (aqr) this.a.get(var1);
		return var3 != null && (var3.e() == var2 || var2 == aqs.a);
	}
}
