package net.minecraft;

import com.mojang.authlib.GameProfile;
import java.util.UUID;

public class nd implements Packet<nc> {

	private GameProfile a;

	public nd() {
	}

	public nd(GameProfile var1) {
		this.a = var1;
	}

	public void readData(PacketDataSerializer var1) {
		String var2 = var1.readString(36);
		String var3 = var1.readString(16);
		UUID var4 = UUID.fromString(var2);
		this.a = new GameProfile(var4, var3);
	}

	public void writeData(PacketDataSerializer var1) {
		UUID var2 = this.a.getId();
		var1.writeString(var2 == null ? "" : var2.toString());
		var1.writeString(this.a.getName());
	}

	public void handlePacket(nc var1) {
		var1.a(this);
	}
}
