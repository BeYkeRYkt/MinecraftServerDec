package net.minecraft;

public class md implements id<ls> {

	private int a;
	private me b;
	private brw c;

	public void a(hd var1) {
		this.a = var1.e();
		this.b = (me) var1.a(me.class);
		if (this.b == me.c) {
			this.c = new brw((double) var1.readFloat(), (double) var1.readFloat(), (double) var1.readFloat());
		}

	}

	public void b(hd var1) {
		var1.b(this.a);
		var1.a((Enum) this.b);
		if (this.b == me.c) {
			var1.writeFloat((float) this.c.a);
			var1.writeFloat((float) this.c.b);
			var1.writeFloat((float) this.c.c);
		}

	}

	public void a(ls var1) {
		var1.a(this);
	}

	public Entity a(World var1) {
		return var1.a(this.a);
	}

	public me a() {
		return this.b;
	}

	public brw b() {
		return this.c;
	}
}
