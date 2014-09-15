package net.minecraft;

public class PacketPlayInClientStatus implements Packet<PlayInPacketListener> {

	private ClientStatusAction action;

	public PacketPlayInClientStatus() {
	}

	public PacketPlayInClientStatus(ClientStatusAction action) {
		this.action = action;
	}

	public void readData(PacketDataSerializer serializer) {
		this.action = (ClientStatusAction) serializer.readEnum(ClientStatusAction.class);
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeEnum(this.action);
	}

	public void handlePacket(PlayInPacketListener listener) {
		listener.handle(this);
	}

	public ClientStatusAction getAction() {
		return this.action;
	}

	public enum ClientStatusAction {
		PERFORM_RESPAWN, REQUEST_STATS, OPEN_INVENTORY_ACHIEVEMENT;
	}

}
