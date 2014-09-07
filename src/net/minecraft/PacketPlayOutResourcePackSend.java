package net.minecraft;

public class PacketPlayOutResourcePackSend implements Packet<PlayOutPacketListener> {

	private String url;
	private String hash;

	public PacketPlayOutResourcePackSend() {
	}

	public PacketPlayOutResourcePackSend(String url, String hash) {
		this.url = url;
		this.hash = hash;
		if (hash.length() > 40) {
			throw new IllegalArgumentException("Hash is too long (max 40, was " + hash.length() + ")");
		}
	}

	public void readData(PacketDataSerializer serializer) {
		this.url = serializer.readString(32767);
		this.hash = serializer.readString(40);
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeString(this.url);
		serializer.writeString(this.hash);
	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}
