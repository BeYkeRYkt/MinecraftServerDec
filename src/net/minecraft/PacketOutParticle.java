package net.minecraft;

public class PacketOutParticle implements Packet<PlayClientboundPacketListener> {

	private Particle particle;
	private float x;
	private float y;
	private float z;
	private float offX;
	private float offY;
	private float offZ;
	private float particleData;
	private int count;
	private boolean longDistance;
	private int[] data;

	public PacketOutParticle() {
	}

	public PacketOutParticle(Particle particle, boolean longDistance, float x, float y, float z, float offX, float offY, float offZ, float particleData, int count, int... data) {
		this.particle = particle;
		this.longDistance = longDistance;
		this.x = x;
		this.y = y;
		this.z = z;
		this.offX = offX;
		this.offY = offY;
		this.offZ = offZ;
		this.particleData = particleData;
		this.count = count;
		this.data = data;
	}

	public void readData(PacketDataSerializer serializer) {
		this.particle = Particle.byId(serializer.readInt());
		if (this.particle == null) {
			this.particle = Particle.BARRIER;
		}

		this.longDistance = serializer.readBoolean();
		this.x = serializer.readFloat();
		this.y = serializer.readFloat();
		this.z = serializer.readFloat();
		this.offX = serializer.readFloat();
		this.offY = serializer.readFloat();
		this.offZ = serializer.readFloat();
		this.particleData = serializer.readFloat();
		this.count = serializer.readInt();

		int dataLength = this.particle.d();
		this.data = new int[dataLength];
		for (int i = 0; i < dataLength; ++i) {
			this.data[i] = serializer.readVarInt();
		}

	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeInt(this.particle.c());
		serializer.writeBoolean(this.longDistance);
		serializer.writeFloat(this.x);
		serializer.writeFloat(this.y);
		serializer.writeFloat(this.z);
		serializer.writeFloat(this.offX);
		serializer.writeFloat(this.offY);
		serializer.writeFloat(this.offZ);
		serializer.writeFloat(this.particleData);
		serializer.writeInt(this.count);

		int dataLength = this.particle.d();
		for (int i = 0; i < dataLength; ++i) {
			serializer.writeVarInt(this.data[i]);
		}

	}

	public void handlePacket(PlayClientboundPacketListener listener) {
		listener.handle(this);
	}

}
