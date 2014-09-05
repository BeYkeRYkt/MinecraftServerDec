package net.minecraft;

public class ym {

	private EntityInsentient a;
	private float b;
	private float c;
	private boolean d;
	private double e;
	private double f;
	private double g;

	public ym(EntityInsentient var1) {
		this.a = var1;
	}

	public void a(Entity var1, float var2, float var3) {
		this.e = var1.locationX;
		if (var1 instanceof EntityLiving) {
			this.f = var1.locationY + (double) var1.aR();
		} else {
			this.f = (var1.aQ().b + var1.aQ().e) / 2.0D;
		}

		this.g = var1.locationZ;
		this.b = var2;
		this.c = var3;
		this.d = true;
	}

	public void a(double var1, double var3, double var5, float var7, float var8) {
		this.e = var1;
		this.f = var3;
		this.g = var5;
		this.b = var7;
		this.c = var8;
		this.d = true;
	}

	public void a() {
		this.a.pitch = 0.0F;
		if (this.d) {
			this.d = false;
			double var1 = this.e - this.a.locationX;
			double var3 = this.f - (this.a.locationY + (double) this.a.aR());
			double var5 = this.g - this.a.locationZ;
			double var7 = (double) DataTypesConverter.a(var1 * var1 + var5 * var5);
			float var9 = (float) (Math.atan2(var5, var1) * 180.0D / 3.1415927410125732D) - 90.0F;
			float var10 = (float) (-(Math.atan2(var3, var7) * 180.0D / 3.1415927410125732D));
			this.a.pitch = this.a(this.a.pitch, var10, this.c);
			this.a.headPitch = this.a(this.a.headPitch, var9, this.b);
		} else {
			this.a.headPitch = this.a(this.a.headPitch, this.a.aG, 10.0F);
		}

		float var11 = DataTypesConverter.g(this.a.headPitch - this.a.aG);
		if (!this.a.s().m()) {
			if (var11 < -75.0F) {
				this.a.headPitch = this.a.aG - 75.0F;
			}

			if (var11 > 75.0F) {
				this.a.headPitch = this.a.aG + 75.0F;
			}
		}

	}

	private float a(float var1, float var2, float var3) {
		float var4 = DataTypesConverter.g(var2 - var1);
		if (var4 > var3) {
			var4 = var3;
		}

		if (var4 < -var3) {
			var4 = -var3;
		}

		return var1 + var4;
	}

	public boolean b() {
		return this.d;
	}

	public double e() {
		return this.e;
	}

	public double f() {
		return this.f;
	}

	public double g() {
		return this.g;
	}
}
