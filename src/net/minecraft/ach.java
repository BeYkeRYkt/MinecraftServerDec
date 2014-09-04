package net.minecraft;

public class ach extends yl {

	private acb c;
	private boolean d;
	// $FF: synthetic field
	final acb b;

	public ach(acb var1, acb var2) {
		super(var2);
		this.b = var1;
		this.d = false;
		this.c = var2;
	}

	public boolean c() {
		return this.a;
	}

	public boolean d() {
		return this.d;
	}

	public void a(boolean var1) {
		this.d = var1;
	}

	public void b() {
		if (this.a) {
			this.c.b(ace.c);
			this.a = false;
		}

	}
}
