package net.minecraft;

public class mv implements Packet<ls> {

	public void readData(PacketDataSerializer var1) {
	}

	public void writeData(PacketDataSerializer var1) {
	}

	public void handlePacket(ls var1) {
		var1.a(this);
	}
}
