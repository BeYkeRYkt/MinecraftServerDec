package net.minecraft;

public class mu implements id<ls> {

	private dt a;
	private ho[] b;

	public void a(hd var1) {
		this.a = var1.c();
		this.b = new ho[4];

		for (int var2 = 0; var2 < 4; ++var2) {
			this.b[var2] = var1.d();
		}

	}

	public void b(hd var1) {
		var1.a(this.a);

		for (int var2 = 0; var2 < 4; ++var2) {
			var1.a(this.b[var2]);
		}

	}

	public void a(ls var1) {
		var1.a(this);
	}

	public dt a() {
		return this.a;
	}

	public ho[] b() {
		return this.b;
	}
}
