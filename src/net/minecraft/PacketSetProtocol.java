package net.minecraft;

public class PacketSetProtocol implements Packet<HandshakingPacketListener> {

	private int protocolVersion;
	private String serverAddress;
	private int getServerPort;
	private EnumProtocol nextState;

	public void readData(PacketDataSerializer serializer) {
		this.protocolVersion = serializer.readVarInt();
		this.serverAddress = serializer.readString(255);
		this.getServerPort = serializer.readUnsignedShort();
		this.nextState = EnumProtocol.getState(serializer.readVarInt());
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeVarInt(this.protocolVersion);
		serializer.writeString(this.serverAddress);
		serializer.writeShort(this.getServerPort);
		serializer.writeVarInt(this.nextState.getStateId());
	}

	public void handlePacket(HandshakingPacketListener listener) {
		listener.handle(this);
	}

	public EnumProtocol getNextState() {
		return this.nextState;
	}

	public int getProtocolVersion() {
		return this.protocolVersion;
	}

}
