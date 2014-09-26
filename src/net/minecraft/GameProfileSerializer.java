package net.minecraft;

import net.minecraft.util.com.mojang.authlib.GameProfile;
import net.minecraft.util.com.mojang.authlib.properties.Property;
import java.util.UUID;

public final class GameProfileSerializer {

	public static GameProfile deserialize(NBTCompoundTag tag) {
		String name = null;
		String id = null;
		if (tag.isTagAssignableFrom("Name", 8)) {
			name = tag.getString("Name");
		}

		if (tag.isTagAssignableFrom("Id", 8)) {
			id = tag.getString("Id");
		}

		if (UtilColor.isEmpty(name) && UtilColor.isEmpty(id)) {
			return null;
		} else {
			UUID uuid;
			try {
				uuid = UUID.fromString(id);
			} catch (Throwable t) {
				uuid = null;
			}

			GameProfile gameProfile = new GameProfile(uuid, name);
			if (tag.isTagAssignableFrom("Properties", 10)) {
				NBTCompoundTag propertiesTag = tag.getCompound("Properties");
				for (String key : propertiesTag.getKeys()) {
					NBTListTag listTag = propertiesTag.getList(key, 10);
					for (int i = 0; i < listTag.getSize(); ++i) {
						NBTCompoundTag propertyTag = listTag.getCompound(i);
						String value = propertyTag.getString("Value");
						if (propertyTag.isTagAssignableFrom("Signature", 8)) {
							gameProfile.getProperties().put(key, new Property(key, value, propertyTag.getString("Signature")));
						} else {
							gameProfile.getProperties().put(key, new Property(key, value));
						}
					}
				}
			}

			return gameProfile;
		}
	}

	public static NBTCompoundTag serialize(NBTCompoundTag tag, GameProfile gameProfile) {
		if (!UtilColor.isEmpty(gameProfile.getName())) {
			tag.put("Name", gameProfile.getName());
		}

		if (gameProfile.getId() != null) {
			tag.put("Id", gameProfile.getId().toString());
		}

		if (!gameProfile.getProperties().isEmpty()) {
			NBTCompoundTag propertiesTag = new NBTCompoundTag();
			for (String key : gameProfile.getProperties().keySet()) {
				NBTListTag listTag = new NBTListTag();
				for (Property property : gameProfile.getProperties().get(key)) {
					NBTCompoundTag propertyTag = new NBTCompoundTag();
					propertyTag.put("Value", property.getValue());
					if (property.hasSignature()) {
						propertyTag.put("Signature", property.getSignature());
					}
				}
				propertiesTag.put(key, listTag);
			}	

			tag.put("Properties", propertiesTag);
		}

		return tag;
	}

}
