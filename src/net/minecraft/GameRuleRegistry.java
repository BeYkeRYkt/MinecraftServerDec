package net.minecraft;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class GameRuleRegistry {

	private TreeMap<String, GameRule> registry = new TreeMap<String, GameRule>();

	public GameRuleRegistry() {
		this.addGameRule("doFireTick", "true", GameRuleValue.BOOLEAN_VALUE);
		this.addGameRule("mobGriefing", "true", GameRuleValue.BOOLEAN_VALUE);
		this.addGameRule("keepInventory", "false", GameRuleValue.BOOLEAN_VALUE);
		this.addGameRule("doMobSpawning", "true", GameRuleValue.BOOLEAN_VALUE);
		this.addGameRule("doMobLoot", "true", GameRuleValue.BOOLEAN_VALUE);
		this.addGameRule("doTileDrops", "true", GameRuleValue.BOOLEAN_VALUE);
		this.addGameRule("commandBlockOutput", "true", GameRuleValue.BOOLEAN_VALUE);
		this.addGameRule("naturalRegeneration", "true", GameRuleValue.BOOLEAN_VALUE);
		this.addGameRule("doDaylightCycle", "true", GameRuleValue.BOOLEAN_VALUE);
		this.addGameRule("logAdminCommands", "true", GameRuleValue.BOOLEAN_VALUE);
		this.addGameRule("showDeathMessages", "true", GameRuleValue.BOOLEAN_VALUE);
		this.addGameRule("randomTickSpeed", "3", GameRuleValue.NUMERICAL_VALUE);
		this.addGameRule("sendCommandFeedback", "true", GameRuleValue.BOOLEAN_VALUE);
		this.addGameRule("reducedDebugInfo", "false", GameRuleValue.BOOLEAN_VALUE);
	}

	public void addGameRule(String gameRuleName, String data, GameRuleValue type) {
		this.registry.put(gameRuleName, new GameRule(data, type));
	}

	public void setOrAddGameRule(String gameRuleName, String data) {
		GameRule var3 = (GameRule) this.registry.get(gameRuleName);
		if (var3 != null) {
			var3.setRuleData(data);
		} else {
			this.addGameRule(gameRuleName, data, GameRuleValue.ANY_VALUE);
		}

	}

	public String getGameRuleData(String gameRuleName) {
		GameRule gameRule = (GameRule) this.registry.get(gameRuleName);
		return gameRule != null ? gameRule.getData() : "";
	}

	public boolean isGameRule(String gameRuleName) {
		GameRule gameRule = (GameRule) this.registry.get(gameRuleName);
		return gameRule != null ? gameRule.isTrue() : false;
	}

	public int getGameRule(String gameRuleName) {
		GameRule gameRule = (GameRule) this.registry.get(gameRuleName);
		return gameRule != null ? gameRule.getNumericalValue() : 0;
	}

	public NBTCompoundTag write() {
		NBTCompoundTag tag = new NBTCompoundTag();

		Iterator<String> iterator = this.registry.keySet().iterator();
		while (iterator.hasNext()) {
			String gameRuleName = (String) iterator.next();
			GameRule gameRule = (GameRule) this.registry.get(gameRuleName);
			tag.put(gameRuleName, gameRule.getData());
		}

		return tag;
	}

	public void read(NBTCompoundTag tag) {
		Set<?> keys = tag.getKeys();

		Iterator<?> iterator = keys.iterator();
		while (iterator.hasNext()) {
			String gameRuleName = (String) iterator.next();
			String data = tag.getString(gameRuleName);
			this.setOrAddGameRule(gameRuleName, data);
		}
	}

	public String[] getGameRules() {
		return (String[]) this.registry.keySet().toArray(new String[0]);
	}

	public boolean hasGameRule(String gameRuleName) {
		return this.registry.containsKey(gameRuleName);
	}

	public boolean isTypeOf(String gameRuleName, GameRuleValue type) {
		GameRule gameRule = (GameRule) this.registry.get(gameRuleName);
		return gameRule != null && (gameRule.getType() == type || type == GameRuleValue.ANY_VALUE);
	}

}
