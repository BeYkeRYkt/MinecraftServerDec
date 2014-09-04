package net.minecraft;

public class mb implements id<ls> {

	private int a;

	public void a(ls var1) {
		var1.a(this);
	}

	public void a(hd var1) {
		this.a = var1.readByte();
	}

	public void b(hd var1) {
		var1.writeByte(this.a);
	}
}
