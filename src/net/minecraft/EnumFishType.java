package net.minecraft;

import com.google.common.collect.Maps;

import java.util.Map;

public enum EnumFishType {

	COD(0, "cod", 2, 0.1F, 5, 0.6F), 
	SALMON(1, "salmon", 2, 0.1F, 6, 0.8F), 
	CLOWNFISH(2, "clownfish", 1, 0.1F), 
	PUFFERFISH(3, "pufferfish", 1, 0.1F);
	
	private static final Map<Integer, EnumFishType> byData = Maps.newHashMap();

	static {
		for (EnumFishType type : values()) {
			byData.put(type.getData(), type);
		}

	}

	public static EnumFishType getByData(int data) {
		EnumFishType type = byData.get(data);
		return type == null ? COD : type;
	}

	public static EnumFishType getByItemStack(ItemStack itemStack) {
		return itemStack.getItem() instanceof ItemFish ? getByData(itemStack.getWearout()) : COD;
	}

	private final int data;
	private final String name;
	private final int h;
	private final float i;
	private final int j;
	private final float k;
	private boolean cookable = false;

	private EnumFishType(int data, String name, int var5, float var6, int var7, float var8) {
		this.data = data;
		this.name = name;
		this.h = var5;
		this.i = var6;
		this.j = var7;
		this.k = var8;
		this.cookable = true;
	}

	private EnumFishType(int data, String name, int var5, float var6) {
		this.data = data;
		this.name = name;
		this.h = var5;
		this.i = var6;
		this.j = 0;
		this.k = 0.0F;
		this.cookable = false;
	}

	public int getData() {
		return this.data;
	}

	public String getName() {
		return this.name;
	}

	public int c() {
		return this.h;
	}

	public float d() {
		return this.i;
	}

	public int e() {
		return this.j;
	}

	public float f() {
		return this.k;
	}

	public boolean isCookable() {
		return this.cookable;
	}

}
