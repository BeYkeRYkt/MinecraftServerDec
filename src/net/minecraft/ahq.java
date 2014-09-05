package net.minecraft;

public class ahq extends ahr {

	public ahq(World var1) {
		super(var1);
	}

	public ahq(World var1, EntityLiving var2) {
		super(var1, var2);
	}

	public ahq(World var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
	}

	protected void a(bru var1) {
		if (var1.d != null) {
			byte var2 = 0;
			if (var1.d instanceof aem) {
				var2 = 3;
			}

			var1.d.a(wh.a((Entity) this, this.n()), (float) var2);
		}

		for (int var3 = 0; var3 < 8; ++var3) {
			this.o.a(ew.F, this.locationX, this.locationY, this.locationZ, 0.0D, 0.0D, 0.0D, new int[0]);
		}

		if (!this.o.D) {
			this.J();
		}

	}
}
