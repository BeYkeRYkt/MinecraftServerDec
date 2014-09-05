package net.minecraft;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class no implements Packet<nm> {

	private static final Gson a = (new GsonBuilder()).registerTypeAdapter(nt.class, new nu()).registerTypeAdapter(nq.class, new nr()).registerTypeAdapter(ServerPing.class, new ns()).registerTypeHierarchyAdapter(IJSONComponent.class, new JSONComponentFormat()).registerTypeHierarchyAdapter(hv.class, new hx()).registerTypeAdapterFactory(new ut()).create();
	private ServerPing b;

	public no() {
	}

	public no(ServerPing var1) {
		this.b = var1;
	}

	public void readData(PacketDataSerializer var1) {
		this.b = (ServerPing) a.fromJson(var1.readString(32767), ServerPing.class);
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeString(a.toJson((Object) this.b));
	}

	public void handlePacket(nm var1) {
		var1.a(this);
	}

}
