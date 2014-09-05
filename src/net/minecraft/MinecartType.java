package net.minecraft;

import com.google.common.collect.Maps;

import java.util.Map;

public enum MinecartType {

	RIDEABLE(0, "MinecartRideable"), 
	CHEST(1, "MinecartChest"), 
	FURNACE(2, "MinecartFurnace"), 
	TNT(3, "MinecartTNT"), 
	SPAWNER(4, "MinecartSpawner"), 
	HOPPER(5, "MinecartHopper"), 
	COMMAND_BLOCK(6, "MinecartCommandBlock");

	private static final Map<Integer, MinecartType> byIdMap = Maps.newHashMap();

	static {
		for (MinecartType type : values()) {
			byIdMap.put(type.getId(), type);
		}
	}

	public static MinecartType byId(int id) {
		MinecartType minecart = byIdMap.get(id);
		return minecart == null ? RIDEABLE : minecart;
	}

	private final int id;
	private final String name;

	private MinecartType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

}
