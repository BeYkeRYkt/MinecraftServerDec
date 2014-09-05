package net.minecraft;

public class EntitySmallFireball extends ahl {

	public EntitySmallFireball(World var1) {
		super(var1);
		this.a(0.3125F, 0.3125F);
	}

	public EntitySmallFireball(World var1, EntityLiving var2, double var3, double var5, double var7) {
		super(var1, var2, var3, var5, var7);
		this.a(0.3125F, 0.3125F);
	}

	public EntitySmallFireball(World var1, double var2, double var4, double var6, double var8, double var10, double var12) {
		super(var1, var2, var4, var6, var8, var10, var12);
		this.a(0.3125F, 0.3125F);
	}

	protected void a(bru var1) {
		if (!this.o.D) {
			boolean var2;
			if (var1.d != null) {
				var2 = var1.d.a(wh.a((ahl) this, this.a), 5.0F);
				if (var2) {
					this.a(this.a, var1.d);
					if (!var1.d.T()) {
						var1.d.e(5);
					}
				}
			} else {
				var2 = true;
				if (this.a != null && this.a instanceof EntityInsentient) {
					var2 = this.o.Q().b("mobGriefing");
				}

				if (var2) {
					Position var3 = var1.a().a(var1.b);
					if (this.o.d(var3)) {
						this.o.a(var3, aty.ab.P());
					}
				}
			}

			this.J();
		}

	}

	public boolean ad() {
		return false;
	}

	public boolean a(wh var1, float var2) {
		return false;
	}
}
