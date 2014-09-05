package net.minecraft;

public class jb {

	private final short b;
	private final bec c;
	// $FF: synthetic field
	final ja a;

	public jb(ja var1, short var2, bec var3) {
		this.a = var1;
		this.b = var2;
		this.c = var3;
	}

	public jb(ja var1, short var2, bfh var3) {
		this.a = var1;
		this.b = var2;
		this.c = var3.g(this.a());
	}

	public Position a() {
		return new Position(ja.a(this.a).a(this.b >> 12 & 15, this.b & 255, this.b >> 8 & 15));
	}

	public short b() {
		return this.b;
	}

	public bec c() {
		return this.c;
	}
}
