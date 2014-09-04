package net.minecraft;

public class aro {

	public float a;
	public float b;

	public aro(float var1, float var2) {
		this.a = var1;
		this.b = var2;
	}

	public aro a() {
		return new aro(this.a * 0.8F, this.b * 0.6F);
	}
}
