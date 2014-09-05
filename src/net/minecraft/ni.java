package net.minecraft;

import com.mojang.authlib.GameProfile;
import java.util.UUID;

public class ni implements Packet<nh> {

	private GameProfile a;

	public ni() {
	}

	public ni(GameProfile var1) {
		this.a = var1;
	}

	public void readData(PacketDataSerializer var1) {
		this.a = new GameProfile((UUID) null, var1.readString(16));
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeString(this.a.getName());
	}

	public void handlePacket(nh var1) {
		var1.a(this);
	}

	public GameProfile a() {
		return this.a;
	}
}
