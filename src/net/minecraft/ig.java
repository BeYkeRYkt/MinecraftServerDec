package net.minecraft;

public class ig {

	public static void a(Packet var0, PacketListener var1, vn var2) {
		if (!var2.isMainThread()) {
			var2.a(new ih(var0, var1));
			throw UhandledPacketException.instance;
		}
	}
}
