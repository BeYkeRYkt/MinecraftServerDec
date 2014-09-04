package net.minecraft;

public class ald extends alq {

	public ald() {
		this.a(akf.f);
	}

	public amj a(amj var1, World var2, ahd var3) {
		if (!var3.by.instabuild) {
			--var1.b;
		}

		var2.a((Entity) var3, "random.bow", 0.5F, 0.4F / (g.nextFloat() * 0.4F + 0.8F));
		if (!var2.D) {
			var2.d((Entity) (new ahu(var2, var3)));
		}

		var3.b(ty.J[alq.b((alq) this)]);
		return var1;
	}
}
