package net.minecraft;

public class ms implements id<ls> {

	private int a;

	public void a(hd var1) {
		this.a = var1.readShort();
	}

	public void b(hd var1) {
		var1.writeShort(this.a);
	}

	public void a(ls var1) {
		var1.a(this);
	}

	public int a() {
		return this.a;
	}
}
