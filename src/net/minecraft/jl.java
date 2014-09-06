package net.minecraft;

import java.io.IOException;

public class jl implements Packet<PlayClientboundPacketListener> {

	private int a;
	private NBTCompoundTag b;

	public jl() {
	}

	public jl(int var1, NBTCompoundTag var2) {
		this.a = var1;
		this.b = var2;
	}

	public void readData(PacketDataSerializer var1) throws IOException {
		this.a = var1.readVarInt();
		this.b = var1.readCompound();
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeVarInt(this.a);
		var1.writeCompound(this.b);
	}

	public void handlePacket(PlayClientboundPacketListener var1) {
		var1.a(this);
	}
}
