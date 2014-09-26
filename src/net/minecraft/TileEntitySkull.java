package net.minecraft;

import net.minecraft.util.com.mojang.authlib.GameProfile;
import net.minecraft.util.com.mojang.authlib.properties.Property;
import net.minecraft.server.MinecraftServer;

import java.util.UUID;

public class TileEntitySkull extends TileEntity {

	public static GameProfile fillGameProfile(GameProfile gameProfile) {
		if (gameProfile != null && !UtilColor.isEmpty(gameProfile.getName())) {
			if (gameProfile.isComplete() && gameProfile.getProperties().containsKey("textures")) {
				return gameProfile;
			} else if (MinecraftServer.getInstance() == null) {
				return gameProfile;
			} else {
				GameProfile newGameProfile = MinecraftServer.getInstance().getUserCache().getProfile(gameProfile.getName());
				if (newGameProfile == null) {
					return gameProfile;
				} else {
					Property textures = newGameProfile.getProperties().get("textures").iterator().next();
					if (textures == null) {
						newGameProfile = MinecraftServer.getInstance().getMinecraftSessionService().fillProfileProperties(newGameProfile, true);
					}

					return newGameProfile;
				}
			}
		} else {
			return gameProfile;
		}
	}

	private int skullType;
	private int rotation;
	private GameProfile gameProfile = null;

	public void write(NBTCompoundTag tag) {
		super.write(tag);
		tag.put("SkullType", (byte) (this.skullType & 255));
		tag.put("Rot", (byte) (this.rotation & 255));
		if (this.gameProfile != null) {
			NBTCompoundTag var2 = new NBTCompoundTag();
			GameProfileSerializer.serialize(var2, this.gameProfile);
			tag.put("Owner", (NBTTag) var2);
		}

	}

	public void read(NBTCompoundTag tag) {
		super.read(tag);
		this.skullType = tag.getByte("SkullType");
		this.rotation = tag.getByte("Rot");
		if (this.skullType == 3) {
			if (tag.isTagAssignableFrom("Owner", 10)) {
				this.gameProfile = GameProfileSerializer.deserialize(tag.getCompound("Owner"));
			} else if (tag.isTagAssignableFrom("ExtraType", 8)) {
				String name = tag.getString("ExtraType");
				if (!UtilColor.isEmpty(name)) {
					this.gameProfile = new GameProfile((UUID) null, name);
					this.updatePlayerProfile();
				}
			}
		}

	}

	public GameProfile getGameProfile() {
		return this.gameProfile;
	}

	public Packet<?> getUpdatePacket() {
		NBTCompoundTag tag = new NBTCompoundTag();
		this.write(tag);
		return new PacketPlayOutUpdateBlockEntity(this.position, 4, tag);
	}

	public int getSkullType() {
		return this.skullType;
	}

	public void setSkullType(int type) {
		this.skullType = type;
		this.gameProfile = null;
	}

	public void setGameProfile(GameProfile gameProfile) {
		this.skullType = 3;
		this.gameProfile = gameProfile;
		this.updatePlayerProfile();
	}

	private void updatePlayerProfile() {
		this.gameProfile = fillGameProfile(this.gameProfile);
		this.update();
	}

	public int getRotation() {
		return rotation;
	}

	public void setRotation(int rotation) {
		this.rotation = rotation;
	}

}
