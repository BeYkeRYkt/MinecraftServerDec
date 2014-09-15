package net.minecraft;

public class PacketPlayInResourcePackStatus implements Packet<PlayInPacketListener> {

	private String hash;
	private ResourcePackStatusStatus status;

	public void readData(PacketDataSerializer serializer) {
		this.hash = serializer.readString(40);
		this.status = (ResourcePackStatusStatus) serializer.readEnum(ResourcePackStatusStatus.class);
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeString(this.hash);
		serializer.writeEnum(this.status);
	}

	public void handlePacket(PlayInPacketListener listener) {
		listener.handle(this);
	}

	public enum ResourcePackStatusStatus {
		SUCCESSFULLY_LOADED, DECLINED, FAILED_DOWNLOAD, ACCEPTED;
	}

}
