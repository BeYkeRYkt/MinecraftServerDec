package net.minecraft;

import org.apache.commons.lang3.StringUtils;

public class lt implements Packet<PlayInPacketListener> {

	private String a;
	private Position b;

	public lt() {
	}

	public lt(String var1) {
		this(var1, (Position) null);
	}

	public lt(String var1, Position var2) {
		this.a = var1;
		this.b = var2;
	}

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readString(32767);
		boolean var2 = var1.readBoolean();
		if (var2) {
			this.b = var1.readPosition();
		}

	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeString(StringUtils.substring(this.a, 0, 32767));
		boolean var2 = this.b != null;
		var1.writeBoolean(var2);
		if (var2) {
			var1.writePosition(this.b);
		}

	}

	public void handlePacket(PlayInPacketListener var1) {
		var1.a(this);
	}

	public String a() {
		return this.a;
	}

	public Position b() {
		return this.b;
	}
}
