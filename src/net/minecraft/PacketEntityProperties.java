package net.minecraft;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class PacketEntityProperties implements Packet<PlayPacketListener> {

	private int entityId;
	private final List<AttributeSnapshot> properties = Lists.newArrayList();

	public PacketEntityProperties() {
	}

	public PacketEntityProperties(int entityId, Collection<AttributeInstance> attributes) {
		this.entityId = entityId;

		for (AttributeInstance instance : attributes) {
			properties.add(new AttributeSnapshot(instance.a().a(), instance.b(), instance.c()));
		}

	}

	public void readData(PacketDataSerializer serializer) {
		this.entityId = serializer.readVarInt();
		int length = serializer.readInt();

		for (int i = 0; i < length; ++i) {
			String name = serializer.readString(64);
			double value = serializer.readDouble();
			ArrayList<AttributeModifier> list = Lists.newArrayList();
			int attributeModifiersLength = serializer.readVarInt();

			for (int j = 0; j < attributeModifiersLength; ++j) {
				UUID id = serializer.readUUID();
				list.add(new AttributeModifier(id, "Unknown synced attribute modifier", serializer.readDouble(), serializer.readByte()));
			}

			this.properties.add(new AttributeSnapshot(name, value, list));
		}

	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeVarInt(this.entityId);
		serializer.writeInt(this.properties.size());

		for (AttributeSnapshot snapshot : properties) {
			serializer.writeString(snapshot.getName());
			serializer.writeDouble(snapshot.getValue());
			serializer.writeVarInt(snapshot.getModifiers().size());

			for (AttributeModifier modifier : snapshot.getModifiers()) {
				serializer.writeUUID(modifier.getUUID());
				serializer.writeDouble(modifier.getAmount());
				serializer.writeByte(modifier.getOperation());
			}

		}

	}

	public void handlePacket(PlayPacketListener listener) {
		listener.handle(this);
	}

}
