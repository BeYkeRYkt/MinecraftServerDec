package net.minecraft;

import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class is implements Packet<PlayPacketListener> {

	private Map a;

	public is() {
	}

	public is(Map var1) {
		this.a = var1;
	}

	public void handlePacket(PlayPacketListener var1) {
		var1.a(this);
	}

	public void readData(PacketDataSerializer var1) {
		int var2 = var1.readVarInt();
		this.a = Maps.newHashMap();

		for (int var3 = 0; var3 < var2; ++var3) {
			Statistic var4 = StatisticList.a(var1.readString(32767));
			int var5 = var1.readVarInt();
			if (var4 != null) {
				this.a.put(var4, Integer.valueOf(var5));
			}
		}

	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeVarInt(this.a.size());
		Iterator var2 = this.a.entrySet().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry) var2.next();
			var1.writeString(((Statistic) var3.getKey()).e);
			var1.writeVarInt(((Integer) var3.getValue()).intValue());
		}

	}
}
