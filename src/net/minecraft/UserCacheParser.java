package net.minecraft;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import net.minecraft.util.com.mojang.authlib.GameProfile;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

class UserCacheParser implements JsonDeserializer<UserData>, JsonSerializer<UserData> {

	public JsonElement toJson(UserData userdata, Type type, JsonSerializationContext context) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("name", userdata.getProfile().getName());
		UUID var5 = userdata.getProfile().getId();
		jsonObject.addProperty("uuid", var5 == null ? "" : var5.toString());
		jsonObject.addProperty("expiresOn", UserCache.dateFormat.format(userdata.getDate()));
		return jsonObject;
	}

	public UserData fromJson(JsonElement json, Type type, JsonDeserializationContext context) {
		if (json.isJsonObject()) {
			JsonObject jsonObject = json.getAsJsonObject();
			JsonElement jsonName = jsonObject.get("name");
			JsonElement jsonUUID = jsonObject.get("uuid");
			JsonElement jsonDate = jsonObject.get("expiresOn");
			if (jsonName != null && jsonUUID != null) {
				String uuidString = jsonUUID.getAsString();
				String nameString = jsonName.getAsString();
				Date date = null;
				if (jsonDate != null) {
					try {
						date = UserCache.dateFormat.parse(jsonDate.getAsString());
					} catch (ParseException var14) {
						date = null;
					}
				}

				if (nameString != null && uuidString != null) {
					UUID uuid;
					try {
						uuid = UUID.fromString(uuidString);
					} catch (Throwable var13) {
						return null;
					}

					UserData userdata = new UserData(new GameProfile(uuid, nameString), date);
					return userdata;
				} else {
					return null;
				}
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public JsonElement serialize(UserData userdata, Type type, JsonSerializationContext context) {
		return toJson(userdata, type, context);
	}

	@Override
	public UserData deserialize(JsonElement jsondata, Type type, JsonDeserializationContext context) throws JsonParseException {
		return fromJson(jsondata, type, context);
	}

}
