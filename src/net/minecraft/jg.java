package net.minecraft;

public class jg implements id<ik> {

	private int a;
	private int b;
	private int c;

	public jg() {
	}

	public jg(int var1, int var2, int var3) {
		this.a = var1;
		this.b = var2;
		this.c = var3;
	}

	public void a(ik var1) {
		var1.a(this);
	}

	public void a(hd var1) {
		this.a = var1.readUnsignedByte();
		this.b = var1.readShort();
		this.c = var1.readShort();
	}

	public void b(hd var1) {
		var1.writeByte(this.a);
		var1.writeShort(this.b);
		var1.writeShort(this.c);
	}
}
