package net.minecraft;

import java.util.Collection;

public class PacketOutMap implements Packet<PlayClientboundPacketListener> {

	private int itemDamage;
	private byte scale;
	private MapIcon[] icons;
	private int columns;
	private int rows;
	private int x;
	private int y;
	private byte[] data;

	public PacketOutMap() {
	}

	public PacketOutMap(int itemDamage, byte scale, Collection<MapIcon> icons, byte[] data, int columns, int rows, int x, int y) {
		this.itemDamage = itemDamage;
		this.scale = scale;
		this.icons = icons.toArray(new MapIcon[icons.size()]);
		this.columns = columns;
		this.rows = rows;
		this.x = x;
		this.y = y;
		this.data = new byte[x * y];

		for (int i = 0; i < x; ++i) {
			for (int j = 0; j < y; ++j) {
				this.data[i + j * x] = data[columns + i + (rows + j) * 128];
			}
		}

	}

	public void readData(PacketDataSerializer serializer) {
		this.itemDamage = serializer.readVarInt();
		this.scale = serializer.readByte();
		this.icons = new MapIcon[serializer.readVarInt()];

		for (int count = 0; count < this.icons.length; ++count) {
			short var = (short) serializer.readByte();
			this.icons[count] = new MapIcon((byte) (var >> 4 & 15), serializer.readByte(), serializer.readByte(), (byte) (var & 15));
		}

		this.x = serializer.readUnsignedByte();
		if (this.x > 0) {
			this.y = serializer.readUnsignedByte();
			this.columns = serializer.readUnsignedByte();
			this.rows = serializer.readUnsignedByte();
			this.data = serializer.readByteArray();
		}

	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeVarInt(this.itemDamage);
		serializer.writeByte(this.scale);
		serializer.writeVarInt(this.icons.length);

		for (MapIcon icon : icons) {
			serializer.writeByte((icon.getDirection() & 15) << 4 | icon.getType() & 15);
			serializer.writeByte(icon.getX());
			serializer.writeByte(icon.getZ());
		}

		serializer.writeByte(this.x);
		if (this.x > 0) {
			serializer.writeByte(this.y);
			serializer.writeByte(this.columns);
			serializer.writeByte(this.rows);
			serializer.writeByteArray(this.data);
		}

	}

	public void handlePacket(PlayClientboundPacketListener listener) {
		listener.handle(this);
	}

}
