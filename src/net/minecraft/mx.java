package net.minecraft;

import java.io.IOException;

public class mx implements id<ls> {

	private static final dt a = new dt(-1, -1, -1);
	private dt b;
	private int c;
	private amj d;
	private float e;
	private float f;
	private float g;

	public mx() {
	}

	public mx(amj var1) {
		this(a, 255, var1, 0.0F, 0.0F, 0.0F);
	}

	public mx(dt var1, int var2, amj var3, float var4, float var5, float var6) {
		this.b = var1;
		this.c = var2;
		this.d = var3 != null ? var3.k() : null;
		this.e = var4;
		this.f = var5;
		this.g = var6;
	}

	public void a(hd var1) throws IOException {
		this.b = var1.c();
		this.c = var1.readUnsignedByte();
		this.d = var1.i();
		this.e = (float) var1.readUnsignedByte() / 16.0F;
		this.f = (float) var1.readUnsignedByte() / 16.0F;
		this.g = (float) var1.readUnsignedByte() / 16.0F;
	}

	public void b(hd var1) {
		var1.a(this.b);
		var1.writeByte(this.c);
		var1.a(this.d);
		var1.writeByte((int) (this.e * 16.0F));
		var1.writeByte((int) (this.f * 16.0F));
		var1.writeByte((int) (this.g * 16.0F));
	}

	public void a(ls var1) {
		var1.a(this);
	}

	public dt a() {
		return this.b;
	}

	public int b() {
		return this.c;
	}

	public amj c() {
		return this.d;
	}

	public float d() {
		return this.e;
	}

	public float e() {
		return this.f;
	}

	public float f() {
		return this.g;
	}

}
