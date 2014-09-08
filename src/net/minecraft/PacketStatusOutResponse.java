package net.minecraft;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PacketStatusOutResponse implements Packet<StatusOutPacketListener> {

	private static final Gson response = 
		new GsonBuilder()
		.registerTypeAdapter(ServerPingServerData.class, new ServerPingServerDataSerializer())
		.registerTypeAdapter(ServerPingPlayerSample.class, new ServerPingPlayerSampleSerializer())
		.registerTypeAdapter(ServerPing.class, new ServerPingSerializer())
		.registerTypeHierarchyAdapter(IChatBaseComponent.class, new ChatSerializer())
		.registerTypeHierarchyAdapter(ChatModifier.class, new ChatModifierSerializer())
		.registerTypeAdapterFactory(new ChatTypeAdapterFactory())
		.create();
	private ServerPing serverPing;

	public PacketStatusOutResponse() {
	}

	public PacketStatusOutResponse(ServerPing serverPing) {
		this.serverPing = serverPing;
	}

	public void readData(PacketDataSerializer serializer) {
		this.serverPing = response.fromJson(serializer.readString(32767), ServerPing.class);
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeString(response.toJson(this.serverPing));
	}

	public void handlePacket(StatusOutPacketListener listener) {
		listener.handle(this);
	}

}
