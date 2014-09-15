package net.minecraft;

import com.google.gson.JsonObject;
import net.minecraft.util.com.mojang.authlib.GameProfile;

import java.io.File;
import java.util.Collection;

public class OpList extends JsonList<GameProfile> {

	public OpList(File file) {
		super(file);
	}

	protected JsonListEntry<GameProfile> toListEntry(JsonObject var1) {
		return new OpListEntry(var1);
	}

	public String[] getEntries() {
		String[] entries = new String[this.getMap().size()];
		int i = 0;
		for (JsonListEntry<GameProfile> entry : getMap().values()) {
			entries[i++] = entry.getObject().getName();
		}
		return entries;
	}

	public Collection<JsonListEntry<GameProfile>> getProfiles() {
		return getMap().values();
	}

	public GameProfile getByName(String name) {
		for (JsonListEntry<GameProfile> entry : getMap().values()) {
			if (entry.getObject().getName().equalsIgnoreCase(name)) {
				return entry.getObject();
			}
		}
		return null;
	}

	protected String toString(GameProfile profile) {
		return profile.getId().toString();
	}

}
