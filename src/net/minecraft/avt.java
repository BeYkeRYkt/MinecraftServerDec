package net.minecraft;

import java.util.Random;

public class avt extends Block {

	public static boolean M;

	public avt() {
		super(bof.p);
		this.a(CreativeModeTab.b);
	}

	public avt(bof var1) {
		super(var1);
	}

	public void c(World var1, Position var2, bec var3) {
		var1.a(var2, (Block) this, this.a(var1));
	}

	public void a(World var1, Position var2, bec var3, Block var4) {
		var1.a(var2, (Block) this, this.a(var1));
	}

	public void b(World var1, Position var2, bec var3, Random var4) {
		if (!var1.D) {
			this.e(var1, var2);
		}

	}

	private void e(World var1, Position var2) {
		if (d(var1, var2.b()) && var2.o() >= 0) {
			byte var3 = 32;
			if (!M && var1.a(var2.a(-var3, -var3, -var3), var2.a(var3, var3, var3))) {
				if (!var1.D) {
					adv var5 = new adv(var1, (double) var2.n() + 0.5D, (double) var2.o(), (double) var2.p() + 0.5D, var1.p(var2));
					this.a(var5);
					var1.d((Entity) var5);
				}
			} else {
				var1.g(var2);

				Position var4;
				for (var4 = var2.b(); d(var1, var4) && var4.o() > 0; var4 = var4.b()) {
					;
				}

				if (var4.o() > 0) {
					var1.a(var4.a(), this.P());
				}
			}

		}
	}

	protected void a(adv var1) {
	}

	public int a(World var1) {
		return 2;
	}

	public static boolean d(World var0, Position var1) {
		Block var2 = var0.p(var1).c();
		bof var3 = var2.J;
		return var2 == aty.ab || var3 == bof.a || var3 == bof.h || var3 == bof.i;
	}

	public void a_(World var1, Position var2) {
	}
}
