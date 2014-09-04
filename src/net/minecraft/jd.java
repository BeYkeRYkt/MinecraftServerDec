package net.minecraft;

public class jd implements id<ik> {

	private int a;

	public jd() {
	}

	public jd(int var1) {
		this.a = var1;
	}

	public void a(ik var1) {
		var1.a(this);
	}

	public void a(hd var1) {
		this.a = var1.readUnsignedByte();
	}

	public void b(hd var1) {
		var1.writeByte(this.a);
	}
}
