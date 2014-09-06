package net.minecraft;

import org.apache.commons.lang3.Validate;

public class PacketOutSoundEffect implements Packet<PlayClientboundPacketListener> {

	private String soundName;
	private int x;
	private int y;
	private int z;
	private float volume;
	private int pitch;

	public PacketOutSoundEffect() {
	}

	public PacketOutSoundEffect(String soundName, double x, double y, double z, float volume, float pitch) {
		Validate.notNull(soundName, "name", new Object[0]);
		this.soundName = soundName;
		this.x = (int) (x * 8.0D);
		this.y = (int) (y * 8.0D);
		this.z = (int) (z * 8.0D);
		this.volume = volume;
		this.pitch = (int) (pitch * 63.0F);
		pitch = DataTypesConverter.a(pitch, 0.0F, 255.0F);
	}

	public void readData(PacketDataSerializer serializer) {
		this.soundName = serializer.readString(256);
		this.x = serializer.readInt();
		this.y = serializer.readInt();
		this.z = serializer.readInt();
		this.volume = serializer.readFloat();
		this.pitch = serializer.readUnsignedByte();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeString(this.soundName);
		serializer.writeInt(this.x);
		serializer.writeInt(this.y);
		serializer.writeInt(this.z);
		serializer.writeFloat(this.volume);
		serializer.writeByte(this.pitch);
	}

	public void handlePacket(PlayClientboundPacketListener listener) {
		listener.handle(this);
	}

}
