package net.minecraft;

public class ja implements id<ik> {

	private aqm a;
	private jb[] b;

	public ja() {
	}

	public ja(int var1, short[] var2, bfh var3) {
		this.a = new aqm(var3.a, var3.b);
		this.b = new jb[var1];

		for (int var4 = 0; var4 < this.b.length; ++var4) {
			this.b[var4] = new jb(this, var2[var4], var3);
		}

	}

	public void a(hd var1) {
		this.a = new aqm(var1.readInt(), var1.readInt());
		this.b = new jb[var1.e()];

		for (int var2 = 0; var2 < this.b.length; ++var2) {
			this.b[var2] = new jb(this, var1.readShort(), (bec) atr.d.a(var1.e()));
		}

	}

	public void b(hd var1) {
		var1.writeInt(this.a.a);
		var1.writeInt(this.a.b);
		var1.b(this.b.length);
		jb[] var2 = this.b;
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			jb var5 = var2[var4];
			var1.writeShort(var5.b());
			var1.b(atr.d.b(var5.c()));
		}

	}

	public void a(ik var1) {
		var1.a(this);
	}

	// $FF: synthetic method
	static aqm a(ja var0) {
		return var0.a;
	}
}
