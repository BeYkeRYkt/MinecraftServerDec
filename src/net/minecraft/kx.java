package net.minecraft;

import java.io.IOException;
import java.util.List;

public class kx implements Packet<PlayPacketListener> {

	private int a;
	private List b;

	public kx() {
	}

	public kx(int var1, DataWatcher var2, boolean var3) {
		this.a = var1;
		if (var3) {
			this.b = var2.c();
		} else {
			this.b = var2.b();
		}

	}

	public void readData(PacketDataSerializer var1) throws IOException {
		this.a = var1.readVarInt();
		this.b = DataWatcher.readData(var1);
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeVarInt(this.a);
		DataWatcher.a(this.b, var1);
	}

	public void handlePacket(PlayPacketListener var1) {
		var1.a(this);
	}
}
