package net.minecraft;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class GameRuleRegistry {

	private TreeMap<String, GameRule> registry = new TreeMap<String, GameRule>();

	public GameRuleRegistry() {
		this.a("doFireTick", "true", GameRuleValue.BOOLEAN_VALUE);
		this.a("mobGriefing", "true", GameRuleValue.BOOLEAN_VALUE);
		this.a("keepInventory", "false", GameRuleValue.BOOLEAN_VALUE);
		this.a("doMobSpawning", "true", GameRuleValue.BOOLEAN_VALUE);
		this.a("doMobLoot", "true", GameRuleValue.BOOLEAN_VALUE);
		this.a("doTileDrops", "true", GameRuleValue.BOOLEAN_VALUE);
		this.a("commandBlockOutput", "true", GameRuleValue.BOOLEAN_VALUE);
		this.a("naturalRegeneration", "true", GameRuleValue.BOOLEAN_VALUE);
		this.a("doDaylightCycle", "true", GameRuleValue.BOOLEAN_VALUE);
		this.a("logAdminCommands", "true", GameRuleValue.BOOLEAN_VALUE);
		this.a("showDeathMessages", "true", GameRuleValue.BOOLEAN_VALUE);
		this.a("randomTickSpeed", "3", GameRuleValue.NUMERICAL_VALUE);
		this.a("sendCommandFeedback", "true", GameRuleValue.BOOLEAN_VALUE);
		this.a("reducedDebugInfo", "false", GameRuleValue.BOOLEAN_VALUE);
	}

	public void a(String gameRuleName, String defaultValue, GameRuleValue var3) {
		this.registry.put(gameRuleName, new GameRule(defaultValue, var3));
	}

	public void a(String var1, String var2) {
		GameRule var3 = (GameRule) this.registry.get(var1);
		if (var3 != null) {
			var3.a(var2);
		} else {
			this.a(var1, var2, GameRuleValue.ANY_VALUE);
		}

	}

	public String a(String var1) {
		GameRule var2 = (GameRule) this.registry.get(var1);
		return var2 != null ? var2.a() : "";
	}

	public boolean b(String var1) {
		GameRule var2 = (GameRule) this.registry.get(var1);
		return var2 != null ? var2.b() : false;
	}

	public int c(String var1) {
		GameRule var2 = (GameRule) this.registry.get(var1);
		return var2 != null ? var2.c() : 0;
	}

	public NBTCompoundTag a() {
		NBTCompoundTag var1 = new NBTCompoundTag();
		Iterator<String> var2 = this.registry.keySet().iterator();

		while (var2.hasNext()) {
			String var3 = (String) var2.next();
			GameRule var4 = (GameRule) this.registry.get(var3);
			var1.put(var3, var4.a());
		}

		return var1;
	}

	public void a(NBTCompoundTag var1) {
		Set<?> var2 = var1.getKeys();
		Iterator<?> var3 = var2.iterator();

		while (var3.hasNext()) {
			String var4 = (String) var3.next();
			String var6 = var1.getString(var4);
			this.a(var4, var6);
		}

	}

	public String[] getGameRules() {
		return (String[]) this.registry.keySet().toArray(new String[0]);
	}

	public boolean e(String var1) {
		return this.registry.containsKey(var1);
	}

	public boolean a(String var1, GameRuleValue var2) {
		GameRule var3 = (GameRule) this.registry.get(var1);
		return var3 != null && (var3.e() == var2 || var2 == GameRuleValue.ANY_VALUE);
	}
}
