package net.minecraft;

import net.minecraft.util.com.mojang.authlib.GameProfile;
import java.util.UUID;

public class PacketLoginInLoginStart implements Packet<LoginServerboundPacketListener> {

	private GameProfile profile;

	public PacketLoginInLoginStart() {
	}

	public PacketLoginInLoginStart(GameProfile profile) {
		this.profile = profile;
	}

	public void readData(PacketDataSerializer serializer) {
		this.profile = new GameProfile((UUID) null, serializer.readString(16));
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeString(this.profile.getName());
	}

	public void handlePacket(LoginServerboundPacketListener listener) {
		listener.handle(this);
	}

	public GameProfile getProfile() {
		return this.profile;
	}

}
