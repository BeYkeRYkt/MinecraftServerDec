package net.minecraft;

import java.io.IOException;

public class mx implements Packet<ls> {

	private static final Position a = new Position(-1, -1, -1);
	private Position b;
	private int c;
	private ItemStack d;
	private float e;
	private float f;
	private float g;

	public mx() {
	}

	public mx(ItemStack var1) {
		this(a, 255, var1, 0.0F, 0.0F, 0.0F);
	}

	public mx(Position var1, int var2, ItemStack var3, float var4, float var5, float var6) {
		this.b = var1;
		this.c = var2;
		this.d = var3 != null ? var3.getCopy() : null;
		this.e = var4;
		this.f = var5;
		this.g = var6;
	}

	public void readData(PacketDataSerializer var1) throws IOException {
		this.b = var1.readPosition();
		this.c = var1.readUnsignedByte();
		this.d = var1.readItemStack();
		this.e = (float) var1.readUnsignedByte() / 16.0F;
		this.f = (float) var1.readUnsignedByte() / 16.0F;
		this.g = (float) var1.readUnsignedByte() / 16.0F;
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writePosition(this.b);
		var1.writeByte(this.c);
		var1.writeItemStack(this.d);
		var1.writeByte((int) (this.e * 16.0F));
		var1.writeByte((int) (this.f * 16.0F));
		var1.writeByte((int) (this.g * 16.0F));
	}

	public void handlePacket(ls var1) {
		var1.a(this);
	}

	public Position a() {
		return this.b;
	}

	public int b() {
		return this.c;
	}

	public ItemStack c() {
		return this.d;
	}

	public float d() {
		return this.e;
	}

	public float e() {
		return this.f;
	}

	public float f() {
		return this.g;
	}

}
