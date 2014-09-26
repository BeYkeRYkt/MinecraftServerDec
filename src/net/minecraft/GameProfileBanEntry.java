package net.minecraft;

import com.google.gson.JsonObject;
import net.minecraft.util.com.mojang.authlib.GameProfile;
import java.util.Date;
import java.util.UUID;

public class GameProfileBanEntry extends BanEntry<GameProfile> {

	public GameProfileBanEntry(GameProfile profile) {
		this(profile, null, null, null, null);
	}

	public GameProfileBanEntry(GameProfile profile, Date date, String reason, Date expires, String source) {
		super(profile, expires, reason, expires, source);
	}

	public GameProfileBanEntry(JsonObject var1) {
		super(fromJsonObject(var1), var1);
	}

	protected void toJsonObject(JsonObject var1) {
		if (this.getObject() != null) {
			var1.addProperty("uuid", ((GameProfile) this.getObject()).getId() == null ? "" : ((GameProfile) this.getObject()).getId().toString());
			var1.addProperty("name", ((GameProfile) this.getObject()).getName());
			super.toJsonObject(var1);
		}
	}

	private static GameProfile fromJsonObject(JsonObject jsonObject) {
		if (jsonObject.has("uuid") && jsonObject.has("name")) {
			String uuidString = jsonObject.get("uuid").getAsString();

			UUID uuid;
			try {
				uuid = UUID.fromString(uuidString);
			} catch (Throwable t) {
				return null;
			}

			return new GameProfile(uuid, jsonObject.get("name").getAsString());
		} else {
			return null;
		}
	}

}
