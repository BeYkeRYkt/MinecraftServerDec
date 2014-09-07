package net.minecraft;

public class PacketPlayOutListHeaderFooter implements Packet<PlayOutPacketListener> {

	private IChatBaseComponent header;
	private IChatBaseComponent footer;

	public PacketPlayOutListHeaderFooter() {
	}

	public PacketPlayOutListHeaderFooter(IChatBaseComponent header) {
		this.header = header;
	}

	public void readData(PacketDataSerializer serializer) {
		this.header = serializer.readJSONComponent();
		this.footer = serializer.readJSONComponent();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeJSONComponent(this.header);
		serializer.writeJSONComponent(this.footer);
	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}
