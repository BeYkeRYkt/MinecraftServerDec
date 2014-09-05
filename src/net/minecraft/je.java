package net.minecraft;

public class je implements Packet<PlayPacketListener> {

	private int a;
	private String b;
	private IJSONComponent c;
	private int d;
	private int e;

	public je() {
	}

	public je(int var1, String var2, IJSONComponent var3) {
		this(var1, var2, var3, 0);
	}

	public je(int var1, String var2, IJSONComponent var3, int var4) {
		this.a = var1;
		this.b = var2;
		this.c = var3;
		this.d = var4;
	}

	public je(int var1, String var2, IJSONComponent var3, int var4, int var5) {
		this(var1, var2, var3, var4);
		this.e = var5;
	}

	public void handlePacket(PlayPacketListener var1) {
		var1.a(this);
	}

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readUnsignedByte();
		this.b = var1.readString(32);
		this.c = var1.readJSONComponent();
		this.d = var1.readUnsignedByte();
		if (this.b.equals("EntityHorse")) {
			this.e = var1.readInt();
		}

	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeByte(this.a);
		var1.writeString(this.b);
		var1.writeJSONComponent(this.c);
		var1.writeByte(this.d);
		if (this.b.equals("EntityHorse")) {
			var1.writeInt(this.e);
		}

	}
}
