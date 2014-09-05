package net.minecraft;

import com.google.common.base.Predicate;

public class BlockWallSign extends bai {

	public static final beu a = beu.a("facing", (Predicate) en.a);

	public BlockWallSign() {
		this.j(this.L.b().a(a, PaintingDirection.c));
	}

	public void a(ard var1, Position var2) {
		PaintingDirection var3 = (PaintingDirection) var1.p(var2).b(a);
		float var4 = 0.28125F;
		float var5 = 0.78125F;
		float var6 = 0.0F;
		float var7 = 1.0F;
		float var8 = 0.125F;
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		switch (bca.a[var3.ordinal()]) {
			case 1:
				this.a(var6, var4, 1.0F - var8, var7, var5, 1.0F);
				break;
			case 2:
				this.a(var6, var4, 0.0F, var7, var5, var8);
				break;
			case 3:
				this.a(1.0F - var8, var4, var6, 1.0F, var5, var7);
				break;
			case 4:
				this.a(0.0F, var4, var6, var8, var5, var7);
		}

	}

	public void a(World var1, Position var2, bec var3, Block var4) {
		PaintingDirection var5 = (PaintingDirection) var3.b(a);
		if (!var1.p(var2.a(var5.d())).c().r().isBuildable()) {
			this.b(var1, var2, var3, 0);
			var1.g(var2);
		}

		super.a(var1, var2, var3, var4);
	}

	public bec a(int var1) {
		PaintingDirection var2 = PaintingDirection.a(var1);
		if (var2.k() == el.b) {
			var2 = PaintingDirection.c;
		}

		return this.P().a(a, var2);
	}

	public int c(bec var1) {
		return ((PaintingDirection) var1.b(a)).a();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}
