package net.minecraft;

import com.google.common.collect.Lists;
import java.util.List;

public class PacketOutExplosion implements Packet<PlayClientboundPacketListener> {

	private double x;
	private double y;
	private double z;
	private float radius;
	private List<Position> records;
	private float pMotX;
	private float pMotY;
	private float pMotZ;

	public PacketOutExplosion() {
	}

	public PacketOutExplosion(double x, double y, double z, float radius, List<Position> positions, Vec3D vec) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.radius = radius;
		this.records = Lists.newArrayList((Iterable<Position>) positions);
		if (vec != null) {
			this.pMotX = (float) vec.x;
			this.pMotY = (float) vec.y;
			this.pMotZ = (float) vec.z;
		}

	}

	public void readData(PacketDataSerializer serializer) {
		this.x = (double) serializer.readFloat();
		this.y = (double) serializer.readFloat();
		this.z = (double) serializer.readFloat();
		this.radius = serializer.readFloat();
		int count = serializer.readInt();
		this.records = Lists.newArrayListWithCapacity(count);
		int ix = (int) this.x;
		int iy = (int) this.y;
		int iz = (int) this.z;

		for (int i = 0; i < count; ++i) {
			int xCoord = serializer.readByte() + ix;
			int yCoord = serializer.readByte() + iy;
			int zCoord = serializer.readByte() + iz;
			this.records.add(new Position(xCoord, yCoord, zCoord));
		}

		this.pMotX = serializer.readFloat();
		this.pMotY = serializer.readFloat();
		this.pMotZ = serializer.readFloat();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeFloat((float) this.x);
		serializer.writeFloat((float) this.y);
		serializer.writeFloat((float) this.z);
		serializer.writeFloat(this.radius);
		serializer.writeInt(this.records.size());
		int ix = (int) this.x;
		int iy = (int) this.y;
		int iz = (int) this.z;

		for (Position position : records) {
			serializer.writeByte(position.getX() - ix);
			serializer.writeByte(position.getY() - iy);
			serializer.writeByte(position.getZ() - iz);
		}

		serializer.writeFloat(this.pMotX);
		serializer.writeFloat(this.pMotY);
		serializer.writeFloat(this.pMotZ);
	}

	public void handlePacket(PlayClientboundPacketListener listener) {
		listener.handle(this);
	}

}
