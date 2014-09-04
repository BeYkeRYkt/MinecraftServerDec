package net.minecraft;

public class jk implements id<ik> {

	private int a;
	private byte b;

	public jk() {
	}

	public jk(Entity var1, byte var2) {
		this.a = var1.F();
		this.b = var2;
	}

	public void a(hd var1) {
		this.a = var1.readInt();
		this.b = var1.readByte();
	}

	public void b(hd var1) {
		var1.writeInt(this.a);
		var1.writeByte(this.b);
	}

	public void a(ik var1) {
		var1.a(this);
	}
}
