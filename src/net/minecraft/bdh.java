package net.minecraft;

class bdh extends aqi {

	// $FF: synthetic field
	final bdg a;

	bdh(bdg var1) {
		this.a = var1;
	}

	public void a(int var1) {
		this.a.b.c(this.a.c, aty.ac, var1, 0);
	}

	public World a() {
		return this.a.b;
	}

	public Position b() {
		return this.a.c;
	}

	public void a(aqj var1) {
		super.a(var1);
		if (this.a() != null) {
			this.a().h(this.a.c);
		}

	}
}
