package net.minecraft;

public class ahs extends ahr {

	public ahs(World var1) {
		super(var1);
	}

	public ahs(World var1, EntityLiving var2) {
		super(var1, var2);
	}

	public ahs(World var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
	}

	protected void a(bru var1) {
		if (var1.d != null) {
			var1.d.a(wh.a((Entity) this, this.n()), 0.0F);
		}

		if (!this.o.D && this.V.nextInt(8) == 0) {
			byte var2 = 1;
			if (this.V.nextInt(32) == 0) {
				var2 = 4;
			}

			for (int var3 = 0; var3 < var2; ++var3) {
				EntityChicken var4 = new EntityChicken(this.o);
				var4.b(-24000);
				var4.b(this.locationX, this.locationY, this.locationZ, this.yaw, 0.0F);
				this.o.d((Entity) var4);
			}
		}

		double var5 = 0.08D;

		for (int var6 = 0; var6 < 8; ++var6) {
			this.o.a(ew.K, this.locationX, this.locationY, this.locationZ, ((double) this.V.nextFloat() - 0.5D) * 0.08D, ((double) this.V.nextFloat() - 0.5D) * 0.08D, ((double) this.V.nextFloat() - 0.5D) * 0.08D, new int[] { Item.getId(amk.aP) });
		}

		if (!this.o.D) {
			this.J();
		}

	}
}
