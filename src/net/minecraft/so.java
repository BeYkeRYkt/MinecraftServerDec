package net.minecraft;

import net.minecraft.PacketOutWorldBorder.WorldBorderAction;

class so implements bez {

	// $FF: synthetic field
	final PlayerList a;

	so(PlayerList var1) {
		this.a = var1;
	}

	public void a(WorldBorder var1, double var2) {
		this.a.sendPacket((Packet) (new PacketOutWorldBorder(var1, WorldBorderAction.SET_SIZE)));
	}

	public void a(WorldBorder var1, double var2, double var4, long var6) {
		this.a.sendPacket((Packet) (new PacketOutWorldBorder(var1, WorldBorderAction.LERP_SIZE)));
	}

	public void a(WorldBorder var1, double var2, double var4) {
		this.a.sendPacket((Packet) (new PacketOutWorldBorder(var1, WorldBorderAction.SET_CENTER)));
	}

	public void a(WorldBorder var1, int var2) {
		this.a.sendPacket((Packet) (new PacketOutWorldBorder(var1, WorldBorderAction.SET_WARNING_TIME)));
	}

	public void b(WorldBorder var1, int var2) {
		this.a.sendPacket((Packet) (new PacketOutWorldBorder(var1, WorldBorderAction.SET_WARNING_BLOCKS)));
	}

	public void b(WorldBorder var1, double var2) {
	}

	public void c(WorldBorder var1, double var2) {
	}
}
