package net.minecraft;

public class BiomeTemperature {

	public float a;
	public float b;

	public BiomeTemperature(float var1, float var2) {
		this.a = var1;
		this.b = var2;
	}

	public BiomeTemperature a() {
		return new BiomeTemperature(this.a * 0.8F, this.b * 0.6F);
	}
}
