package net.minecraft;

public class alm extends all {

	public alm(int var1, float var2, boolean var3) {
		super(var1, var2, var3);
		this.a(true);
	}

	public amx g(amj var1) {
		return var1.i() == 0 ? amx.c : amx.d;
	}

	protected void c(amj var1, World var2, ahd var3) {
		if (!var2.D) {
			var3.c(new wq(wp.x.H, 2400, 0));
		}

		if (var1.i() > 0) {
			if (!var2.D) {
				var3.c(new wq(wp.l.H, 600, 4));
				var3.c(new wq(wp.m.H, 6000, 0));
				var3.c(new wq(wp.n.H, 6000, 0));
			}
		} else {
			super.c(var1, var2, var3);
		}

	}
}
