package net.minecraft;

public class lo implements id<ik> {

	private int a;
	private int b;
	private int c;
	private int d;
	private byte e;
	private byte f;
	private boolean g;

	public lo() {
	}

	public lo(Entity var1) {
		this.a = var1.F();
		this.b = NumberConverter.c(var1.s * 32.0D);
		this.c = NumberConverter.c(var1.t * 32.0D);
		this.d = NumberConverter.c(var1.u * 32.0D);
		this.e = (byte) ((int) (var1.y * 256.0F / 360.0F));
		this.f = (byte) ((int) (var1.z * 256.0F / 360.0F));
		this.g = var1.C;
	}

	public lo(int var1, int var2, int var3, int var4, byte var5, byte var6, boolean var7) {
		this.a = var1;
		this.b = var2;
		this.c = var3;
		this.d = var4;
		this.e = var5;
		this.f = var6;
		this.g = var7;
	}

	public void a(hd var1) {
		this.a = var1.e();
		this.b = var1.readInt();
		this.c = var1.readInt();
		this.d = var1.readInt();
		this.e = var1.readByte();
		this.f = var1.readByte();
		this.g = var1.readBoolean();
	}

	public void b(hd var1) {
		var1.b(this.a);
		var1.writeInt(this.b);
		var1.writeInt(this.c);
		var1.writeInt(this.d);
		var1.writeByte(this.e);
		var1.writeByte(this.f);
		var1.writeBoolean(this.g);
	}

	public void a(ik var1) {
		var1.a(this);
	}
}
