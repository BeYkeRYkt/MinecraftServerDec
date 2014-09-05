package net.minecraft;

import java.util.List;

public class js implements Packet<PlayPacketListener> {

	private int[] a;
	private int[] b;
	private ChunkPacketData[] c;
	private boolean d;

	public js() {
	}

	public js(List var1) {
		int var2 = var1.size();
		this.a = new int[var2];
		this.b = new int[var2];
		this.c = new ChunkPacketData[var2];
		this.d = !((Chunk) var1.get(0)).getWorld().worldProvider.noSkyLight();

		for (int var3 = 0; var3 < var2; ++var3) {
			Chunk var4 = (Chunk) var1.get(var3);
			ChunkPacketData var5 = PacketChunkData.getChunkData(var4, true, this.d, '\uffff');
			this.a[var3] = var4.x;
			this.b[var3] = var4.y;
			this.c[var3] = var5;
		}

	}

	public void readData(PacketDataSerializer var1) {
		this.d = var1.readBoolean();
		int var2 = var1.readVarInt();
		this.a = new int[var2];
		this.b = new int[var2];
		this.c = new ChunkPacketData[var2];

		int var3;
		for (var3 = 0; var3 < var2; ++var3) {
			this.a[var3] = var1.readInt();
			this.b[var3] = var1.readInt();
			this.c[var3] = new ChunkPacketData();
			this.c[var3].bitMap = var1.readShort() & '\uffff';
			this.c[var3].blockData = new byte[PacketChunkData.calculateArraySize(Integer.bitCount(this.c[var3].bitMap), this.d, true)];
		}

		for (var3 = 0; var3 < var2; ++var3) {
			var1.readBytes(this.c[var3].blockData);
		}

	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeBoolean(this.d);
		var1.writeVarInt(this.c.length);

		int var2;
		for (var2 = 0; var2 < this.a.length; ++var2) {
			var1.writeInt(this.a[var2]);
			var1.writeInt(this.b[var2]);
			var1.writeShort((short) (this.c[var2].bitMap & '\uffff'));
		}

		for (var2 = 0; var2 < this.a.length; ++var2) {
			var1.writeBytes(this.c[var2].blockData);
		}

	}

	public void handlePacket(PlayPacketListener var1) {
		var1.a(this);
	}
}
