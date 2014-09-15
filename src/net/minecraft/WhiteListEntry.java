package net.minecraft;

import com.google.gson.JsonObject;
import net.minecraft.util.com.mojang.authlib.GameProfile;
import java.util.UUID;

public class WhiteListEntry extends JsonListEntry<GameProfile> {

	public WhiteListEntry(GameProfile profile) {
		super(profile);
	}

	public WhiteListEntry(JsonObject var1) {
		super(fromJsonObject(var1), var1);
	}

	protected void toJsonObject(JsonObject jsonObject) {
		if (this.getObject() != null) {
			jsonObject.addProperty("uuid", ((GameProfile) this.getObject()).getId() == null ? "" : ((GameProfile) this.getObject()).getId().toString());
			jsonObject.addProperty("name", ((GameProfile) this.getObject()).getName());
			super.toJsonObject(jsonObject);
		}
	}

	private static GameProfile fromJsonObject(JsonObject jsonObject) {
		if (jsonObject.has("uuid") && jsonObject.has("name")) {
			String uuidString = jsonObject.get("uuid").getAsString();

			UUID uuid;
			try {
				uuid = UUID.fromString(uuidString);
			} catch (Throwable var4) {
				return null;
			}

			return new GameProfile(uuid, jsonObject.get("name").getAsString());
		} else {
			return null;
		}
	}

}
