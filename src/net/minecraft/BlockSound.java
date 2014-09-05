package net.minecraft;

public class BlockSound {

	public final String a;
	public final float b;
	public final float c;

	public BlockSound(String var1, float var2, float var3) {
		this.a = var1;
		this.b = var2;
		this.c = var3;
	}

	public float d() {
		return this.b;
	}

	public float e() {
		return this.c;
	}

	public String a() {
		return "dig." + this.a;
	}

	public String c() {
		return "step." + this.a;
	}

	public String b() {
		return this.a();
	}
}
