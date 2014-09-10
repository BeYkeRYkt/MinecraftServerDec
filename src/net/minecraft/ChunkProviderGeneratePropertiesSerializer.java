package net.minecraft;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class ChunkProviderGeneratePropertiesSerializer implements JsonDeserializer<ChunkProviderGeneratePropertiesHolder>, JsonSerializer<ChunkProviderGeneratePropertiesHolder> {

	public ChunkProviderGeneratePropertiesHolder deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) {
		JsonObject jsonObject = jsonElement.getAsJsonObject();
		ChunkProviderGeneratePropertiesHolder properties = new ChunkProviderGeneratePropertiesHolder();

		try {
			properties.coordinateScale = JSONParser.getFloat(jsonObject, "coordinateScale", properties.coordinateScale);
			properties.heightScale = JSONParser.getFloat(jsonObject, "heightScale", properties.heightScale);
			properties.lowerLimitScale = JSONParser.getFloat(jsonObject, "lowerLimitScale", properties.lowerLimitScale);
			properties.upperLimitScale = JSONParser.getFloat(jsonObject, "upperLimitScale", properties.upperLimitScale);
			properties.depthNoiseScaleX = JSONParser.getFloat(jsonObject, "depthNoiseScaleX", properties.depthNoiseScaleX);
			properties.depthNoiseScaleZ = JSONParser.getFloat(jsonObject, "depthNoiseScaleZ", properties.depthNoiseScaleZ);
			properties.depthNoiseScaleExponent = JSONParser.getFloat(jsonObject, "depthNoiseScaleExponent", properties.depthNoiseScaleExponent);
			properties.mainNoiseScaleX = JSONParser.getFloat(jsonObject, "mainNoiseScaleX", properties.mainNoiseScaleX);
			properties.mainNoiseScaleY = JSONParser.getFloat(jsonObject, "mainNoiseScaleY", properties.mainNoiseScaleY);
			properties.mainNoiseScaleZ = JSONParser.getFloat(jsonObject, "mainNoiseScaleZ", properties.mainNoiseScaleZ);
			properties.baseSize = JSONParser.getFloat(jsonObject, "baseSize", properties.baseSize);
			properties.stretchY = JSONParser.getFloat(jsonObject, "stretchY", properties.stretchY);
			properties.biomeDepthWeight = JSONParser.getFloat(jsonObject, "biomeDepthWeight", properties.biomeDepthWeight);
			properties.biomeDepthOffset = JSONParser.getFloat(jsonObject, "biomeDepthOffset", properties.biomeDepthOffset);
			properties.biomeScaleWeight = JSONParser.getFloat(jsonObject, "biomeScaleWeight", properties.biomeScaleWeight);
			properties.biomeScaleOffset = JSONParser.getFloat(jsonObject, "biomeScaleOffset", properties.biomeScaleOffset);
			properties.seaLevel = JSONParser.getInt(jsonObject, "seaLevel", properties.seaLevel);
			properties.useCaves = JSONParser.getBoolean(jsonObject, "useCaves", properties.useCaves);
			properties.useDungeons = JSONParser.getBoolean(jsonObject, "useDungeons", properties.useDungeons);
			properties.dungeonChance = JSONParser.getInt(jsonObject, "dungeonChance", properties.dungeonChance);
			properties.useStrongholds = JSONParser.getBoolean(jsonObject, "useStrongholds", properties.useStrongholds);
			properties.useVillages = JSONParser.getBoolean(jsonObject, "useVillages", properties.useVillages);
			properties.useMineShafts = JSONParser.getBoolean(jsonObject, "useMineShafts", properties.useMineShafts);
			properties.useTemples = JSONParser.getBoolean(jsonObject, "useTemples", properties.useTemples);
			properties.useMonuments = JSONParser.getBoolean(jsonObject, "useMonuments", properties.useMonuments);
			properties.useRavines = JSONParser.getBoolean(jsonObject, "useRavines", properties.useRavines);
			properties.useWaterLakes = JSONParser.getBoolean(jsonObject, "useWaterLakes", properties.useWaterLakes);
			properties.waterLakeChance = JSONParser.getInt(jsonObject, "waterLakeChance", properties.waterLakeChance);
			properties.useLavaLakes = JSONParser.getBoolean(jsonObject, "useLavaLakes", properties.useLavaLakes);
			properties.lavaLakeChance = JSONParser.getInt(jsonObject, "lavaLakeChance", properties.lavaLakeChance);
			properties.useLavaOceans = JSONParser.getBoolean(jsonObject, "useLavaOceans", properties.useLavaOceans);
			properties.fixedBiome = JSONParser.getInt(jsonObject, "fixedBiome", properties.fixedBiome);
			if (properties.fixedBiome < 38 && properties.fixedBiome >= -1) {
				if (properties.fixedBiome >= BiomeBase.x.az) {
					properties.fixedBiome += 2;
				}
			} else {
				properties.fixedBiome = -1;
			}

			properties.biomeSize = JSONParser.getInt(jsonObject, "biomeSize", properties.biomeSize);
			properties.riverSize = JSONParser.getInt(jsonObject, "riverSize", properties.riverSize);
			properties.dirtSize = JSONParser.getInt(jsonObject, "dirtSize", properties.dirtSize);
			properties.dirtCount = JSONParser.getInt(jsonObject, "dirtCount", properties.dirtCount);
			properties.dirtMinHeight = JSONParser.getInt(jsonObject, "dirtMinHeight", properties.dirtMinHeight);
			properties.dirtMaxHeight = JSONParser.getInt(jsonObject, "dirtMaxHeight", properties.dirtMaxHeight);
			properties.gravelSize = JSONParser.getInt(jsonObject, "gravelSize", properties.gravelSize);
			properties.gravelCount = JSONParser.getInt(jsonObject, "gravelCount", properties.gravelCount);
			properties.gravelMinHeight = JSONParser.getInt(jsonObject, "gravelMinHeight", properties.gravelMinHeight);
			properties.gravelMaxHeight = JSONParser.getInt(jsonObject, "gravelMaxHeight", properties.gravelMaxHeight);
			properties.graniteSize = JSONParser.getInt(jsonObject, "graniteSize", properties.graniteSize);
			properties.graniteCount = JSONParser.getInt(jsonObject, "graniteCount", properties.graniteCount);
			properties.graniteMinHeight = JSONParser.getInt(jsonObject, "graniteMinHeight", properties.graniteMinHeight);
			properties.graniteMaxHeight = JSONParser.getInt(jsonObject, "graniteMaxHeight", properties.graniteMaxHeight);
			properties.dioriteSize = JSONParser.getInt(jsonObject, "dioriteSize", properties.dioriteSize);
			properties.dioriteCount = JSONParser.getInt(jsonObject, "dioriteCount", properties.dioriteCount);
			properties.dioriteMinHeight = JSONParser.getInt(jsonObject, "dioriteMinHeight", properties.dioriteMinHeight);
			properties.dioriteMaxHeight = JSONParser.getInt(jsonObject, "dioriteMaxHeight", properties.dioriteMaxHeight);
			properties.andesiteSize = JSONParser.getInt(jsonObject, "andesiteSize", properties.andesiteSize);
			properties.andesiteCount = JSONParser.getInt(jsonObject, "andesiteCount", properties.andesiteCount);
			properties.andesiteMinHeight = JSONParser.getInt(jsonObject, "andesiteMinHeight", properties.andesiteMinHeight);
			properties.andesiteMaxHeight = JSONParser.getInt(jsonObject, "andesiteMaxHeight", properties.andesiteMaxHeight);
			properties.coalSize = JSONParser.getInt(jsonObject, "coalSize", properties.coalSize);
			properties.coalCount = JSONParser.getInt(jsonObject, "coalCount", properties.coalCount);
			properties.coalMinHeight = JSONParser.getInt(jsonObject, "coalMinHeight", properties.coalMinHeight);
			properties.coalMaxHeight = JSONParser.getInt(jsonObject, "coalMaxHeight", properties.coalMaxHeight);
			properties.ironSize = JSONParser.getInt(jsonObject, "ironSize", properties.ironSize);
			properties.ironCount = JSONParser.getInt(jsonObject, "ironCount", properties.ironCount);
			properties.ironMinHeight = JSONParser.getInt(jsonObject, "ironMinHeight", properties.ironMinHeight);
			properties.ironMaxHeight = JSONParser.getInt(jsonObject, "ironMaxHeight", properties.ironMaxHeight);
			properties.goldSize = JSONParser.getInt(jsonObject, "goldSize", properties.goldSize);
			properties.goldCount = JSONParser.getInt(jsonObject, "goldCount", properties.goldCount);
			properties.goldMinHeight = JSONParser.getInt(jsonObject, "goldMinHeight", properties.goldMinHeight);
			properties.goldMaxHeight = JSONParser.getInt(jsonObject, "goldMaxHeight", properties.goldMaxHeight);
			properties.redstoneSize = JSONParser.getInt(jsonObject, "redstoneSize", properties.redstoneSize);
			properties.redstoneCount = JSONParser.getInt(jsonObject, "redstoneCount", properties.redstoneCount);
			properties.redstoneMinHeight = JSONParser.getInt(jsonObject, "redstoneMinHeight", properties.redstoneMinHeight);
			properties.redstoneMaxHeight = JSONParser.getInt(jsonObject, "redstoneMaxHeight", properties.redstoneMaxHeight);
			properties.diamondSize = JSONParser.getInt(jsonObject, "diamondSize", properties.diamondSize);
			properties.diamondCount = JSONParser.getInt(jsonObject, "diamondCount", properties.diamondCount);
			properties.diamondMinHeight = JSONParser.getInt(jsonObject, "diamondMinHeight", properties.diamondMinHeight);
			properties.diamondMaxHeight = JSONParser.getInt(jsonObject, "diamondMaxHeight", properties.diamondMaxHeight);
			properties.lapisSize = JSONParser.getInt(jsonObject, "lapisSize", properties.lapisSize);
			properties.lapisCount = JSONParser.getInt(jsonObject, "lapisCount", properties.lapisCount);
			properties.lapisCenterHeight = JSONParser.getInt(jsonObject, "lapisCenterHeight", properties.lapisCenterHeight);
			properties.lapisSpread = JSONParser.getInt(jsonObject, "lapisSpread", properties.lapisSpread);
		} catch (Exception ex) {
		}

		return properties;
	}

	public JsonElement serialize(ChunkProviderGeneratePropertiesHolder properties, Type type, JsonSerializationContext context) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("coordinateScale", (Number) Float.valueOf(properties.coordinateScale));
		jsonObject.addProperty("heightScale", (Number) Float.valueOf(properties.heightScale));
		jsonObject.addProperty("lowerLimitScale", (Number) Float.valueOf(properties.lowerLimitScale));
		jsonObject.addProperty("upperLimitScale", (Number) Float.valueOf(properties.upperLimitScale));
		jsonObject.addProperty("depthNoiseScaleX", (Number) Float.valueOf(properties.depthNoiseScaleX));
		jsonObject.addProperty("depthNoiseScaleZ", (Number) Float.valueOf(properties.depthNoiseScaleZ));
		jsonObject.addProperty("depthNoiseScaleExponent", (Number) Float.valueOf(properties.depthNoiseScaleExponent));
		jsonObject.addProperty("mainNoiseScaleX", (Number) Float.valueOf(properties.mainNoiseScaleX));
		jsonObject.addProperty("mainNoiseScaleY", (Number) Float.valueOf(properties.mainNoiseScaleY));
		jsonObject.addProperty("mainNoiseScaleZ", (Number) Float.valueOf(properties.mainNoiseScaleZ));
		jsonObject.addProperty("baseSize", (Number) Float.valueOf(properties.baseSize));
		jsonObject.addProperty("stretchY", (Number) Float.valueOf(properties.stretchY));
		jsonObject.addProperty("biomeDepthWeight", (Number) Float.valueOf(properties.biomeDepthWeight));
		jsonObject.addProperty("biomeDepthOffset", (Number) Float.valueOf(properties.biomeDepthOffset));
		jsonObject.addProperty("biomeScaleWeight", (Number) Float.valueOf(properties.biomeScaleWeight));
		jsonObject.addProperty("biomeScaleOffset", (Number) Float.valueOf(properties.biomeScaleOffset));
		jsonObject.addProperty("seaLevel", (Number) Integer.valueOf(properties.seaLevel));
		jsonObject.addProperty("useCaves", Boolean.valueOf(properties.useCaves));
		jsonObject.addProperty("useDungeons", Boolean.valueOf(properties.useDungeons));
		jsonObject.addProperty("dungeonChance", (Number) Integer.valueOf(properties.dungeonChance));
		jsonObject.addProperty("useStrongholds", Boolean.valueOf(properties.useStrongholds));
		jsonObject.addProperty("useVillages", Boolean.valueOf(properties.useVillages));
		jsonObject.addProperty("useMineShafts", Boolean.valueOf(properties.useMineShafts));
		jsonObject.addProperty("useTemples", Boolean.valueOf(properties.useTemples));
		jsonObject.addProperty("useMonuments", Boolean.valueOf(properties.useMonuments));
		jsonObject.addProperty("useRavines", Boolean.valueOf(properties.useRavines));
		jsonObject.addProperty("useWaterLakes", Boolean.valueOf(properties.useWaterLakes));
		jsonObject.addProperty("waterLakeChance", (Number) Integer.valueOf(properties.waterLakeChance));
		jsonObject.addProperty("useLavaLakes", Boolean.valueOf(properties.useLavaLakes));
		jsonObject.addProperty("lavaLakeChance", (Number) Integer.valueOf(properties.lavaLakeChance));
		jsonObject.addProperty("useLavaOceans", Boolean.valueOf(properties.useLavaOceans));
		jsonObject.addProperty("fixedBiome", (Number) Integer.valueOf(properties.fixedBiome));
		jsonObject.addProperty("biomeSize", (Number) Integer.valueOf(properties.biomeSize));
		jsonObject.addProperty("riverSize", (Number) Integer.valueOf(properties.riverSize));
		jsonObject.addProperty("dirtSize", (Number) Integer.valueOf(properties.dirtSize));
		jsonObject.addProperty("dirtCount", (Number) Integer.valueOf(properties.dirtCount));
		jsonObject.addProperty("dirtMinHeight", (Number) Integer.valueOf(properties.dirtMinHeight));
		jsonObject.addProperty("dirtMaxHeight", (Number) Integer.valueOf(properties.dirtMaxHeight));
		jsonObject.addProperty("gravelSize", (Number) Integer.valueOf(properties.gravelSize));
		jsonObject.addProperty("gravelCount", (Number) Integer.valueOf(properties.gravelCount));
		jsonObject.addProperty("gravelMinHeight", (Number) Integer.valueOf(properties.gravelMinHeight));
		jsonObject.addProperty("gravelMaxHeight", (Number) Integer.valueOf(properties.gravelMaxHeight));
		jsonObject.addProperty("graniteSize", (Number) Integer.valueOf(properties.graniteSize));
		jsonObject.addProperty("graniteCount", (Number) Integer.valueOf(properties.graniteCount));
		jsonObject.addProperty("graniteMinHeight", (Number) Integer.valueOf(properties.graniteMinHeight));
		jsonObject.addProperty("graniteMaxHeight", (Number) Integer.valueOf(properties.graniteMaxHeight));
		jsonObject.addProperty("dioriteSize", (Number) Integer.valueOf(properties.dioriteSize));
		jsonObject.addProperty("dioriteCount", (Number) Integer.valueOf(properties.dioriteCount));
		jsonObject.addProperty("dioriteMinHeight", (Number) Integer.valueOf(properties.dioriteMinHeight));
		jsonObject.addProperty("dioriteMaxHeight", (Number) Integer.valueOf(properties.dioriteMaxHeight));
		jsonObject.addProperty("andesiteSize", (Number) Integer.valueOf(properties.andesiteSize));
		jsonObject.addProperty("andesiteCount", (Number) Integer.valueOf(properties.andesiteCount));
		jsonObject.addProperty("andesiteMinHeight", (Number) Integer.valueOf(properties.andesiteMinHeight));
		jsonObject.addProperty("andesiteMaxHeight", (Number) Integer.valueOf(properties.andesiteMaxHeight));
		jsonObject.addProperty("coalSize", (Number) Integer.valueOf(properties.coalSize));
		jsonObject.addProperty("coalCount", (Number) Integer.valueOf(properties.coalCount));
		jsonObject.addProperty("coalMinHeight", (Number) Integer.valueOf(properties.coalMinHeight));
		jsonObject.addProperty("coalMaxHeight", (Number) Integer.valueOf(properties.coalMaxHeight));
		jsonObject.addProperty("ironSize", (Number) Integer.valueOf(properties.ironSize));
		jsonObject.addProperty("ironCount", (Number) Integer.valueOf(properties.ironCount));
		jsonObject.addProperty("ironMinHeight", (Number) Integer.valueOf(properties.ironMinHeight));
		jsonObject.addProperty("ironMaxHeight", (Number) Integer.valueOf(properties.ironMaxHeight));
		jsonObject.addProperty("goldSize", (Number) Integer.valueOf(properties.goldSize));
		jsonObject.addProperty("goldCount", (Number) Integer.valueOf(properties.goldCount));
		jsonObject.addProperty("goldMinHeight", (Number) Integer.valueOf(properties.goldMinHeight));
		jsonObject.addProperty("goldMaxHeight", (Number) Integer.valueOf(properties.goldMaxHeight));
		jsonObject.addProperty("redstoneSize", (Number) Integer.valueOf(properties.redstoneSize));
		jsonObject.addProperty("redstoneCount", (Number) Integer.valueOf(properties.redstoneCount));
		jsonObject.addProperty("redstoneMinHeight", (Number) Integer.valueOf(properties.redstoneMinHeight));
		jsonObject.addProperty("redstoneMaxHeight", (Number) Integer.valueOf(properties.redstoneMaxHeight));
		jsonObject.addProperty("diamondSize", (Number) Integer.valueOf(properties.diamondSize));
		jsonObject.addProperty("diamondCount", (Number) Integer.valueOf(properties.diamondCount));
		jsonObject.addProperty("diamondMinHeight", (Number) Integer.valueOf(properties.diamondMinHeight));
		jsonObject.addProperty("diamondMaxHeight", (Number) Integer.valueOf(properties.diamondMaxHeight));
		jsonObject.addProperty("lapisSize", (Number) Integer.valueOf(properties.lapisSize));
		jsonObject.addProperty("lapisCount", (Number) Integer.valueOf(properties.lapisCount));
		jsonObject.addProperty("lapisCenterHeight", (Number) Integer.valueOf(properties.lapisCenterHeight));
		jsonObject.addProperty("lapisSpread", (Number) Integer.valueOf(properties.lapisSpread));
		return jsonObject;
	}

}
