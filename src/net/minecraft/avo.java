package net.minecraft;

public class avo extends atg {

	protected avo() {
		super(bof.e);
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
		this.e(0);
		this.a(akf.c);
	}

	public boolean d() {
		return false;
	}

	public boolean c() {
		return false;
	}

	public int b() {
		return 3;
	}

	public bcm a(World var1, int var2) {
		return new bcz();
	}

	public boolean a(World var1, dt var2, bec var3, ahd var4, ej var5, float var6, float var7, float var8) {
		if (var1.D) {
			return true;
		} else {
			bcm var9 = var1.s(var2);
			if (var9 instanceof bcz) {
				var4.a((vv) ((bcz) var9));
			}

			return true;
		}
	}

	public void a(World var1, dt var2, bec var3, EntityLiving var4, amj var5) {
		super.a(var1, var2, var3, var4, var5);
		if (var5.s()) {
			bcm var6 = var1.s(var2);
			if (var6 instanceof bcz) {
				((bcz) var6).a(var5.q());
			}
		}

	}
}
