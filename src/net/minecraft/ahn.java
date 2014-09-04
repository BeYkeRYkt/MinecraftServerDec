package net.minecraft;

public class ahn extends ahl {

	public int e = 1;

	public ahn(World var1) {
		super(var1);
	}

	public ahn(World var1, EntityLiving var2, double var3, double var5, double var7) {
		super(var1, var2, var3, var5, var7);
	}

	protected void a(bru var1) {
		if (!this.o.D) {
			if (var1.d != null) {
				var1.d.a(wh.a((ahl) this, this.a), 6.0F);
				this.a(this.a, var1.d);
			}

			boolean var2 = this.o.Q().b("mobGriefing");
			this.o.a((Entity) null, this.s, this.t, this.u, (float) this.e, var2, var2);
			this.J();
		}

	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.put("ExplosionPower", this.e);
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		if (var1.b("ExplosionPower", 99)) {
			this.e = var1.f("ExplosionPower");
		}

	}
}
