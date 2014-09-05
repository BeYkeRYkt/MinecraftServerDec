package net.minecraft;

import java.io.IOException;
import java.util.List;

public class io implements Packet<PlayPacketListener> {

	private int a;
	private int b;
	private int c;
	private int d;
	private int e;
	private int f;
	private int g;
	private int h;
	private byte i;
	private byte j;
	private byte k;
	private DataWatcher l;
	private List m;

	public io() {
	}

	public io(EntityLiving var1) {
		this.a = var1.getId();
		this.b = (byte) xb.a(var1);
		this.c = DataTypesConverter.toFixedPointInt(var1.locationX * 32.0D);
		this.d = DataTypesConverter.toFixedPointInt(var1.locationY * 32.0D);
		this.e = DataTypesConverter.toFixedPointInt(var1.locationZ * 32.0D);
		this.i = (byte) ((int) (var1.yaw * 256.0F / 360.0F));
		this.j = (byte) ((int) (var1.pitch * 256.0F / 360.0F));
		this.k = (byte) ((int) (var1.aI * 256.0F / 360.0F));
		double var2 = 3.9D;
		double var4 = var1.motionX;
		double var6 = var1.motionY;
		double var8 = var1.motionZ;
		if (var4 < -var2) {
			var4 = -var2;
		}

		if (var6 < -var2) {
			var6 = -var2;
		}

		if (var8 < -var2) {
			var8 = -var2;
		}

		if (var4 > var2) {
			var4 = var2;
		}

		if (var6 > var2) {
			var6 = var2;
		}

		if (var8 > var2) {
			var8 = var2;
		}

		this.f = (int) (var4 * 8000.0D);
		this.g = (int) (var6 * 8000.0D);
		this.h = (int) (var8 * 8000.0D);
		this.l = var1.getDataWatcher();
	}

	public void readData(PacketDataSerializer var1) throws IOException {
		this.a = var1.readVarInt();
		this.b = var1.readByte() & 255;
		this.c = var1.readInt();
		this.d = var1.readInt();
		this.e = var1.readInt();
		this.i = var1.readByte();
		this.j = var1.readByte();
		this.k = var1.readByte();
		this.f = var1.readShort();
		this.g = var1.readShort();
		this.h = var1.readShort();
		this.m = DataWatcher.readData(var1);
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeVarInt(this.a);
		var1.writeByte(this.b & 255);
		var1.writeInt(this.c);
		var1.writeInt(this.d);
		var1.writeInt(this.e);
		var1.writeByte(this.i);
		var1.writeByte(this.j);
		var1.writeByte(this.k);
		var1.writeShort(this.f);
		var1.writeShort(this.g);
		var1.writeShort(this.h);
		this.l.writeData(var1);
	}

	public void handlePacket(PlayPacketListener var1) {
		var1.a(this);
	}
}
