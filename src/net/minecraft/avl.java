package net.minecraft;

import java.util.Random;

public class avl extends Block {

	public avl() {
		super(bof.D);
		this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 1.0F, 0.9375F);
	}

	public void c(World var1, Position var2, bec var3) {
		var1.a(var2, (Block) this, this.a(var1));
	}

	public void a(World var1, Position var2, bec var3, Block var4) {
		var1.a(var2, (Block) this, this.a(var1));
	}

	public void b(World var1, Position var2, bec var3, Random var4) {
		this.d(var1, var2);
	}

	private void d(World var1, Position var2) {
		if (avt.d(var1, var2.b()) && var2.o() >= 0) {
			byte var3 = 32;
			if (!avt.M && var1.a(var2.a(-var3, -var3, -var3), var2.a(var3, var3, var3))) {
				var1.d((Entity) (new adv(var1, (double) ((float) var2.n() + 0.5F), (double) var2.o(), (double) ((float) var2.p() + 0.5F), this.P())));
			} else {
				var1.g(var2);

				Position var4;
				for (var4 = var2; avt.d(var1, var4) && var4.o() > 0; var4 = var4.b()) {
					;
				}

				if (var4.o() > 0) {
					var1.a(var4, this.P(), 2);
				}
			}

		}
	}

	public boolean a(World var1, Position var2, bec var3, EntityHuman var4, PaintingDirection var5, float var6, float var7, float var8) {
		this.e(var1, var2);
		return true;
	}

	public void a(World var1, Position var2, EntityHuman var3) {
		this.e(var1, var2);
	}

	private void e(World var1, Position var2) {
		bec var3 = var1.p(var2);
		if (var3.c() == this) {
			for (int var4 = 0; var4 < 1000; ++var4) {
				Position var5 = var2.a(var1.s.nextInt(16) - var1.s.nextInt(16), var1.s.nextInt(8) - var1.s.nextInt(8), var1.s.nextInt(16) - var1.s.nextInt(16));
				if (var1.p(var5).c().J == bof.a) {
					if (var1.D) {
						for (int var6 = 0; var6 < 128; ++var6) {
							double var7 = var1.s.nextDouble();
							float var9 = (var1.s.nextFloat() - 0.5F) * 0.2F;
							float var10 = (var1.s.nextFloat() - 0.5F) * 0.2F;
							float var11 = (var1.s.nextFloat() - 0.5F) * 0.2F;
							double var12 = (double) var5.n() + (double) (var2.n() - var5.n()) * var7 + (var1.s.nextDouble() - 0.5D) * 1.0D + 0.5D;
							double var14 = (double) var5.o() + (double) (var2.o() - var5.o()) * var7 + var1.s.nextDouble() * 1.0D - 0.5D;
							double var16 = (double) var5.p() + (double) (var2.p() - var5.p()) * var7 + (var1.s.nextDouble() - 0.5D) * 1.0D + 0.5D;
							var1.a(ew.y, var12, var14, var16, (double) var9, (double) var10, (double) var11, new int[0]);
						}
					} else {
						var1.a(var5, var3, 2);
						var1.g(var2);
					}

					return;
				}
			}

		}
	}

	public int a(World var1) {
		return 5;
	}

	public boolean c() {
		return false;
	}

	public boolean d() {
		return false;
	}
}
