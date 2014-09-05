package net.minecraft;

final class ih implements Runnable {

	// $FF: synthetic field
	final Packet a;
	// $FF: synthetic field
	final PacketListener b;

	ih(Packet var1, PacketListener var2) {
		this.a = var1;
		this.b = var2;
	}

	public void run() {
		this.a.handlePacket(this.b);
	}
}
