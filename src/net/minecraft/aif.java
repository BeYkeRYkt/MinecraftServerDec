package net.minecraft;

class aif extends ajk {

	// $FF: synthetic field
	final World a;
	// $FF: synthetic field
	final dt b;
	// $FF: synthetic field
	final aid c;

	aif(aid var1, vq var2, int var3, int var4, int var5, World var6, dt var7) {
		super(var2, var3, var4, var5);
		this.c = var1;
		this.a = var6;
		this.b = var7;
	}

	public boolean a(amj var1) {
		return false;
	}

	public boolean a(ahd var1) {
		return (var1.by.d || var1.bz >= this.c.a) && this.c.a > 0 && this.e();
	}

	public void a(ahd var1, amj var2) {
		if (!var1.by.d) {
			var1.a(-this.c.a);
		}

		aid.a(this.c).a(0, (amj) null);
		if (aid.b(this.c) > 0) {
			amj var3 = aid.a(this.c).a(1);
			if (var3 != null && var3.b > aid.b(this.c)) {
				var3.b -= aid.b(this.c);
				aid.a(this.c).a(1, var3);
			} else {
				aid.a(this.c).a(1, (amj) null);
			}
		} else {
			aid.a(this.c).a(1, (amj) null);
		}

		this.c.a = 0;
		bec var5 = this.a.p(this.b);
		if (!var1.by.d && !this.a.D && var5.c() == aty.cf && var1.bb().nextFloat() < 0.12F) {
			int var4 = ((Integer) var5.b(asz.b)).intValue();
			++var4;
			if (var4 > 2) {
				this.a.g(this.b);
				this.a.b(1020, this.b, 0);
			} else {
				this.a.a(this.b, var5.a(asz.b, Integer.valueOf(var4)), 2);
				this.a.b(1021, this.b, 0);
			}
		} else if (!this.a.D) {
			this.a.b(1021, this.b, 0);
		}

	}
}
