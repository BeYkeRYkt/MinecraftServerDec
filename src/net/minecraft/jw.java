package net.minecraft;

public class jw implements id<ik> {

	private int a;
	private boolean b;
	private arc c;
	private int d;
	private vt e;
	private int f;
	private are g;
	private boolean h;

	public jw() {
	}

	public jw(int var1, arc var2, boolean var3, int var4, vt var5, int var6, are var7, boolean var8) {
		this.a = var1;
		this.d = var4;
		this.e = var5;
		this.c = var2;
		this.f = var6;
		this.b = var3;
		this.g = var7;
		this.h = var8;
	}

	public void a(hd var1) {
		this.a = var1.readInt();
		short var2 = var1.readUnsignedByte();
		this.b = (var2 & 8) == 8;
		int var3 = var2 & -9;
		this.c = arc.a(var3);
		this.d = var1.readByte();
		this.e = vt.a(var1.readUnsignedByte());
		this.f = var1.readUnsignedByte();
		this.g = are.a(var1.c(16));
		if (this.g == null) {
			this.g = are.b;
		}

		this.h = var1.readBoolean();
	}

	public void b(hd var1) {
		var1.writeInt(this.a);
		int var2 = this.c.a();
		if (this.b) {
			var2 |= 8;
		}

		var1.writeByte(var2);
		var1.writeByte(this.d);
		var1.writeByte(this.e.a());
		var1.writeByte(this.f);
		var1.a(this.g.a());
		var1.writeBoolean(this.h);
	}

	public void a(ik var1) {
		var1.a(this);
	}
}
