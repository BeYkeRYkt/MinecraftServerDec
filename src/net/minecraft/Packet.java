package net.minecraft;

import java.io.IOException;

public interface Packet<T> {

	void readData(PacketDataSerializer var1) throws IOException;

	void writeData(PacketDataSerializer var1);

	void handlePacket(T var1);

}
