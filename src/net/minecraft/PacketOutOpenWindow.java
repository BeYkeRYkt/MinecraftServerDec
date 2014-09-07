package net.minecraft;

public class PacketOutOpenWindow implements Packet<PlayClientboundPacketListener> {

	private int windowId;
	private String type;
	private IChatBaseComponent title;
	private int slots;
	private int entityId;

	public PacketOutOpenWindow() {
	}

	public PacketOutOpenWindow(int windowId, String type, IChatBaseComponent title) {
		this(windowId, type, title, 0);
	}

	public PacketOutOpenWindow(int windowId, String type, IChatBaseComponent title, int slots) {
		this.windowId = windowId;
		this.type = type;
		this.title = title;
		this.slots = slots;
	}

	public PacketOutOpenWindow(int var1, String var2, IChatBaseComponent var3, int slots, int entityId) {
		this(var1, var2, var3, slots);
		this.entityId = entityId;
	}

	public void readData(PacketDataSerializer serializer) {
		this.windowId = serializer.readUnsignedByte();
		this.type = serializer.readString(32);
		this.title = serializer.readJSONComponent();
		this.slots = serializer.readUnsignedByte();
		if (this.type.equals("EntityHorse")) {
			this.entityId = serializer.readInt();
		}

	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeByte(this.windowId);
		serializer.writeString(this.type);
		serializer.writeJSONComponent(this.title);
		serializer.writeByte(this.slots);
		if (this.type.equals("EntityHorse")) {
			serializer.writeInt(this.entityId);
		}

	}

	public void handlePacket(PlayClientboundPacketListener listener) {
		listener.handle(this);
	}

}
