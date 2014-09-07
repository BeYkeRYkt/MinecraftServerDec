package net.minecraft;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Map.Entry;

public class PacketPlayOutStatistics implements Packet<PlayOutPacketListener> {

	private Map<Statistic, Integer> map;

	public PacketPlayOutStatistics() {
	}

	public PacketPlayOutStatistics(Map<Statistic, Integer> map) {
		this.map = map;
	}

	public void readData(PacketDataSerializer serializer) {
		int size = serializer.readVarInt();
		this.map = Maps.newHashMap();

		for (int i = 0; i < size; ++i) {
			Statistic stat = StatisticList.fromName(serializer.readString(32767));
			int value = serializer.readVarInt();
			if (stat != null) {
				this.map.put(stat, Integer.valueOf(value));
			}
		}
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeVarInt(this.map.size());
		for (Entry<Statistic, Integer> entry : map.entrySet()) {
			serializer.writeString(entry.getKey().name);
			serializer.writeInt(entry.getValue());
		}
	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}
