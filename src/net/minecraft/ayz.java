package net.minecraft;

public class ayz {

	private final World a;
	private final el b;
	private final ej c;
	private final ej d;
	private int e = 0;
	private Position f;
	private int g;
	private int h;

	public ayz(World var1, Position var2, el var3) {
		this.a = var1;
		this.b = var3;
		if (var3 == el.a) {
			this.d = ej.f;
			this.c = ej.e;
		} else {
			this.d = ej.c;
			this.c = ej.d;
		}

		for (Position var4 = var2; var2.o() > var4.o() - 21 && var2.o() > 0 && this.a(var1.p(var2.b()).c()); var2 = var2.b()) {
			;
		}

		int var5 = this.a(var2, this.d) - 1;
		if (var5 >= 0) {
			this.f = var2.a(this.d, var5);
			this.h = this.a(this.f, this.c);
			if (this.h < 2 || this.h > 21) {
				this.f = null;
				this.h = 0;
			}
		}

		if (this.f != null) {
			this.g = this.a();
		}

	}

	protected int a(Position var1, ej var2) {
		int var3;
		for (var3 = 0; var3 < 22; ++var3) {
			Position var4 = var1.a(var2, var3);
			if (!this.a(this.a.p(var4).c()) || this.a.p(var4.b()).c() != aty.Z) {
				break;
			}
		}

		Block var5 = this.a.p(var1.a(var2, var3)).c();
		return var5 == aty.Z ? var3 : 0;
	}

	protected int a() {
		int var1;
		label56: for (this.g = 0; this.g < 21; ++this.g) {
			for (var1 = 0; var1 < this.h; ++var1) {
				Position var2 = this.f.a(this.c, var1).b(this.g);
				Block var3 = this.a.p(var2).c();
				if (!this.a(var3)) {
					break label56;
				}

				if (var3 == aty.aY) {
					++this.e;
				}

				if (var1 == 0) {
					var3 = this.a.p(var2.a(this.d)).c();
					if (var3 != aty.Z) {
						break label56;
					}
				} else if (var1 == this.h - 1) {
					var3 = this.a.p(var2.a(this.c)).c();
					if (var3 != aty.Z) {
						break label56;
					}
				}
			}
		}

		for (var1 = 0; var1 < this.h; ++var1) {
			if (this.a.p(this.f.a(this.c, var1).b(this.g)).c() != aty.Z) {
				this.g = 0;
				break;
			}
		}

		if (this.g <= 21 && this.g >= 3) {
			return this.g;
		} else {
			this.f = null;
			this.h = 0;
			this.g = 0;
			return 0;
		}
	}

	protected boolean a(Block var1) {
		return var1.J == bof.a || var1 == aty.ab || var1 == aty.aY;
	}

	public boolean b() {
		return this.f != null && this.h >= 2 && this.h <= 21 && this.g >= 3 && this.g <= 21;
	}

	public void c() {
		for (int var1 = 0; var1 < this.h; ++var1) {
			Position var2 = this.f.a(this.c, var1);

			for (int var3 = 0; var3 < this.g; ++var3) {
				this.a.a(var2.b(var3), aty.aY.P().a(ayy.a, this.b), 2);
			}
		}

	}

	// $FF: synthetic method
	static int a(ayz var0) {
		return var0.e;
	}

	// $FF: synthetic method
	static int b(ayz var0) {
		return var0.h;
	}

	// $FF: synthetic method
	static int c(ayz var0) {
		return var0.g;
	}
}
