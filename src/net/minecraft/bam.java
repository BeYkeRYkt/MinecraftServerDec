package net.minecraft;

public class bam extends awt {

	public bam() {
		super(bof.B, false);
		this.a(akf.c);
		this.K = 0.8F;
	}

	public void a(World var1, dt var2, Entity var3, float var4) {
		if (var3.aw()) {
			super.a(var1, var2, var3, var4);
		} else {
			var3.e(var4, 0.0F);
		}

	}

	public void a(World var1, Entity var2) {
		if (var2.aw()) {
			super.a(var1, var2);
		} else if (var2.w < 0.0D) {
			var2.w = -var2.w;
		}

	}

	public void a(World var1, dt var2, Entity var3) {
		if (Math.abs(var3.w) < 0.1D && !var3.aw()) {
			double var4 = 0.4D + Math.abs(var3.w) * 0.2D;
			var3.v *= var4;
			var3.x *= var4;
		}

		super.a(var1, var2, var3);
	}
}
