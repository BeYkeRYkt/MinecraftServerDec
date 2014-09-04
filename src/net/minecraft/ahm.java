package net.minecraft;

public class ahm extends Entity {

	private int a;
	private int b;

	public ahm(World var1) {
		super(var1);
		this.a(0.25F, 0.25F);
	}

	protected void h() {
		this.ac.a(8, 5);
	}

	public ahm(World var1, double var2, double var4, double var6, amj var8) {
		super(var1);
		this.a = 0;
		this.a(0.25F, 0.25F);
		this.b(var2, var4, var6);
		int var9 = 1;
		if (var8 != null && var8.n()) {
			this.ac.b(8, var8);
			NBTCompoundTag var10 = var8.o();
			NBTCompoundTag var11 = var10.m("Fireworks");
			if (var11 != null) {
				var9 += var11.d("Flight");
			}
		}

		this.v = this.V.nextGaussian() * 0.001D;
		this.x = this.V.nextGaussian() * 0.001D;
		this.w = 0.05D;
		this.b = 10 * var9 + this.V.nextInt(6) + this.V.nextInt(7);
	}

	public void s_() {
		this.P = this.s;
		this.Q = this.t;
		this.R = this.u;
		super.s_();
		this.v *= 1.15D;
		this.x *= 1.15D;
		this.w += 0.04D;
		this.d(this.v, this.w, this.x);
		float var1 = uv.a(this.v * this.v + this.x * this.x);
		this.y = (float) (Math.atan2(this.v, this.x) * 180.0D / 3.1415927410125732D);

		for (this.z = (float) (Math.atan2(this.w, (double) var1) * 180.0D / 3.1415927410125732D); this.z - this.B < -180.0F; this.B -= 360.0F) {
			;
		}

		while (this.z - this.B >= 180.0F) {
			this.B += 360.0F;
		}

		while (this.y - this.A < -180.0F) {
			this.A -= 360.0F;
		}

		while (this.y - this.A >= 180.0F) {
			this.A += 360.0F;
		}

		this.z = this.B + (this.z - this.B) * 0.2F;
		this.y = this.A + (this.y - this.A) * 0.2F;
		if (this.a == 0 && !this.R()) {
			this.o.a((Entity) this, "fireworks.launch", 3.0F, 1.0F);
		}

		++this.a;
		if (this.o.D && this.a % 2 < 2) {
			this.o.a(ew.d, this.s, this.t - 0.3D, this.u, this.V.nextGaussian() * 0.05D, -this.w * 0.5D, this.V.nextGaussian() * 0.05D, new int[0]);
		}

		if (!this.o.D && this.a > this.b) {
			this.o.a((Entity) this, (byte) 17);
			this.J();
		}

	}

	public void b(NBTCompoundTag var1) {
		var1.a("Life", this.a);
		var1.a("LifeTime", this.b);
		amj var2 = this.ac.f(8);
		if (var2 != null) {
			NBTCompoundTag var3 = new NBTCompoundTag();
			var2.b(var3);
			var1.a("FireworksItem", (NBTTag) var3);
		}

	}

	public void a(NBTCompoundTag var1) {
		this.a = var1.f("Life");
		this.b = var1.f("LifeTime");
		NBTCompoundTag var2 = var1.m("FireworksItem");
		if (var2 != null) {
			amj var3 = amj.a(var2);
			if (var3 != null) {
				this.ac.b(8, var3);
			}
		}

	}

	public float c(float var1) {
		return super.c(var1);
	}

	public boolean aE() {
		return false;
	}
}
