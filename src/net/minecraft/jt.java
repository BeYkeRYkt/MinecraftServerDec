package net.minecraft;

public class jt implements id<ik> {

	private int a;
	private dt b;
	private int c;
	private boolean d;

	public jt() {
	}

	public jt(int var1, dt var2, int var3, boolean var4) {
		this.a = var1;
		this.b = var2;
		this.c = var3;
		this.d = var4;
	}

	public void a(hd var1) {
		this.a = var1.readInt();
		this.b = var1.c();
		this.c = var1.readInt();
		this.d = var1.readBoolean();
	}

	public void b(hd var1) {
		var1.writeInt(this.a);
		var1.a(this.b);
		var1.writeInt(this.c);
		var1.writeBoolean(this.d);
	}

	public void a(ik var1) {
		var1.a(this);
	}
}
