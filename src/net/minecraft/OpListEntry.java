package net.minecraft;

import com.google.gson.JsonObject;
import com.mojang.authlib.GameProfile;
import java.util.UUID;

public class OpListEntry extends JsonListEntry<GameProfile> {

	private final int permLevel;

	public OpListEntry(GameProfile profile, int permLevel) {
		super(profile);
		this.permLevel = permLevel;
	}

	public OpListEntry(JsonObject jsonObject) {
		super(fromJsonObject(jsonObject), jsonObject);
		this.permLevel = jsonObject.has("level") ? jsonObject.get("level").getAsInt() : 0;
	}

	public int getPermissionLevel() {
		return this.permLevel;
	}

	protected void toJsonObject(JsonObject jsonObject) {
		if (this.getObject() != null) {
			jsonObject.addProperty("uuid", this.getObject().getId() == null ? "" : this.getObject().getId().toString());
			jsonObject.addProperty("name", this.getObject().getName());
			jsonObject.addProperty("level", (Number) Integer.valueOf(this.permLevel));
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
