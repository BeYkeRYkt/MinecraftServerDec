package net.minecraft;

import net.minecraft.util.com.mojang.authlib.GameProfile;
import java.util.UUID;

public class PacketLoginOutLoginSuccess implements Packet<LoginClientboundPacketListener> {

	private GameProfile profile;

	public PacketLoginOutLoginSuccess() {
	}

	public PacketLoginOutLoginSuccess(GameProfile profile) {
		this.profile = profile;
	}

	public void readData(PacketDataSerializer serializer) {
		String var2 = serializer.readString(36);
		String var3 = serializer.readString(16);
		UUID var4 = UUID.fromString(var2);
		this.profile = new GameProfile(var4, var3);
	}

	public void writeData(PacketDataSerializer serializer) {
		UUID var2 = this.profile.getId();
		serializer.writeString(var2 == null ? "" : var2.toString());
		serializer.writeString(this.profile.getName());
	}

	public void handlePacket(LoginClientboundPacketListener listener) {
		listener.handle(this);
	}

}
