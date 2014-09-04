package net.minecraft;

public class ky implements id<ik> {

	private int a;
	private int b;
	private int c;

	public ky() {
	}

	public ky(int var1, Entity var2, Entity var3) {
		this.a = var1;
		this.b = var2.F();
		this.c = var3 != null ? var3.F() : -1;
	}

	public void a(hd var1) {
		this.b = var1.readInt();
		this.c = var1.readInt();
		this.a = var1.readUnsignedByte();
	}

	public void b(hd var1) {
		var1.writeInt(this.b);
		var1.writeInt(this.c);
		var1.writeByte(this.a);
	}

	public void a(ik var1) {
		var1.a(this);
	}
}
