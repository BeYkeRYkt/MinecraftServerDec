package net.minecraft;

public class PacketOutWorldBorder implements Packet<PlayClientboundPacketListener> {

	private WorldBorderAction action;
	private int b;
	private double c;
	private double d;
	private double e;
	private double f;
	private long g;
	private int h;
	private int i;

	public PacketOutWorldBorder() {
	}

	public PacketOutWorldBorder(WorldBorder var1, WorldBorderAction var2) {
		this.action = var2;
		this.c = var1.f();
		this.d = var1.g();
		this.f = var1.h();
		this.e = var1.j();
		this.g = var1.i();
		this.b = var1.l();
		this.i = var1.q();
		this.h = var1.p();
	}

	public void readData(PacketDataSerializer serializer) {
		this.action = (WorldBorderAction) serializer.readEnum(WorldBorderAction.class);
		switch (action.ordinal()) {
			case 1:
				this.e = serializer.readDouble();
				break;
			case 2:
				this.f = serializer.readDouble();
				this.e = serializer.readDouble();
				this.g = serializer.readVarLong();
				break;
			case 3:
				this.c = serializer.readDouble();
				this.d = serializer.readDouble();
				break;
			case 4:
				this.i = serializer.readVarInt();
				break;
			case 5:
				this.h = serializer.readVarInt();
				break;
			case 6:
				this.c = serializer.readDouble();
				this.d = serializer.readDouble();
				this.f = serializer.readDouble();
				this.e = serializer.readDouble();
				this.g = serializer.readVarLong();
				this.b = serializer.readVarInt();
				this.i = serializer.readVarInt();
				this.h = serializer.readVarInt();
		}

	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeEnum(this.action);
		switch (action.ordinal()) {
			case 1:
				serializer.writeDouble(this.e);
				break;
			case 2:
				serializer.writeDouble(this.f);
				serializer.writeDouble(this.e);
				serializer.writeVarLong(this.g);
				break;
			case 3:
				serializer.writeDouble(this.c);
				serializer.writeDouble(this.d);
				break;
			case 4:
				serializer.writeVarInt(this.i);
				break;
			case 5:
				serializer.writeVarInt(this.h);
				break;
			case 6:
				serializer.writeDouble(this.c);
				serializer.writeDouble(this.d);
				serializer.writeDouble(this.f);
				serializer.writeDouble(this.e);
				serializer.writeVarLong(this.g);
				serializer.writeVarInt(this.b);
				serializer.writeVarInt(this.i);
				serializer.writeVarInt(this.h);
		}

	}

	public void handlePacket(PlayClientboundPacketListener listener) {
		listener.handle(this);
	}

	public enum WorldBorderAction {
		SET_SIZE, LERP_SIZE, SET_CENTER, INITIALIZE, SET_WARNING_TIME, SET_WARNING_BLOCKS;
	}

}
