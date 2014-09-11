package net.minecraft;

public class BiomeMeta extends vk {

	public Class b;
	public int c;
	public int d;

	public BiomeMeta(Class var1, int var2, int var3, int var4) {
		super(var2);
		this.b = var1;
		this.c = var3;
		this.d = var4;
	}

	public String toString() {
		return this.b.getSimpleName() + "*(" + this.c + "-" + this.d + "):" + this.a;
	}
}
