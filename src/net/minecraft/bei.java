package net.minecraft;

import com.google.common.base.Predicate;

public class bei {

	private final World a;
	private final Position b;
	private bec c;
	private TileEntity d;
	private boolean e;

	public bei(World var1, Position var2) {
		this.a = var1;
		this.b = var2;
	}

	public bec a() {
		if (this.c == null && this.a.e(this.b)) {
			this.c = this.a.p(this.b);
		}

		return this.c;
	}

	public TileEntity b() {
		if (this.d == null && !this.e) {
			this.d = this.a.s(this.b);
			this.e = true;
		}

		return this.d;
	}

	public Position d() {
		return this.b;
	}

	public static Predicate a(Predicate var0) {
		return new bej(var0);
	}
}
