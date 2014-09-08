package net.minecraft;

import io.netty.buffer.ByteBuf;
import java.io.IOException;

public class mc implements Packet<PlayInPacketListener> {

	private String a;
	private PacketDataSerializer b;

	public void readData(PacketDataSerializer var1) throws IOException {
		this.a = var1.readString(20);
		int var2 = var1.readableBytes();
		if (var2 >= 0 && var2 <= 32767) {
			this.b = new PacketDataSerializer(var1.readBytes(var2));
		} else {
			throw new IOException("Payload may not be larger than 32767 bytes");
		}
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeString(this.a);
		var1.writeBytes((ByteBuf) this.b);
	}

	public void handlePacket(PlayInPacketListener var1) {
		var1.a(this);
	}

	public String a() {
		return this.a;
	}

	public PacketDataSerializer b() {
		return this.b;
	}
}
