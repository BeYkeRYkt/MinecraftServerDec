package net.minecraft;

public class amo extends alq {

	public amo() {
		this.c(1);
		this.a(akf.f);
	}

	public amj b(amj var1, World var2, ahd var3) {
		if (!var3.by.instabuild) {
			--var1.b;
		}

		if (!var2.D) {
			var3.bj();
		}

		var3.b(ty.J[alq.b((alq) this)]);
		return var1.b <= 0 ? new amj(amk.aw) : var1;
	}

	public int d(amj var1) {
		return 32;
	}

	public ano e(amj var1) {
		return ano.c;
	}

	public amj a(amj var1, World var2, ahd var3) {
		var3.a(var1, this.d(var1));
		return var1;
	}
}
