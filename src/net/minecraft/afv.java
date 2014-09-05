package net.minecraft;

import java.util.Random;

class afv extends zb {

	private aft a;
	private int b;

	public afv(aft var1) {
		this.a = var1;
	}

	public void f() {
		if (this.b == 0) {
			this.b = 20;
		}

	}

	public boolean a() {
		return this.b > 0;
	}

	public void e() {
		--this.b;
		if (this.b <= 0) {
			World var1 = this.a.o;
			Random var2 = this.a.bb();
			Position var3 = new Position(this.a);

			for (int var4 = 0; var4 <= 5 && var4 >= -5; var4 = var4 <= 0 ? 1 - var4 : 0 - var4) {
				for (int var5 = 0; var5 <= 10 && var5 >= -10; var5 = var5 <= 0 ? 1 - var5 : 0 - var5) {
					for (int var6 = 0; var6 <= 10 && var6 >= -10; var6 = var6 <= 0 ? 1 - var6 : 0 - var6) {
						Position var7 = var3.a(var5, var4, var6);
						bec var8 = var1.p(var7);
						if (var8.c() == aty.be) {
							if (var1.Q().b("mobGriefing")) {
								var1.b(var7, true);
							} else {
								var1.a(var7, ((axu) var8.b(BlockMonsterEggs.a)).d(), 3);
							}

							if (var2.nextBoolean()) {
								return;
							}
						}
					}
				}
			}
		}

	}
}
