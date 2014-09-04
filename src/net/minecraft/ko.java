package net.minecraft;

public class ko implements id<ik> {

	private String a;
	private String b;

	public ko() {
	}

	public ko(String var1, String var2) {
		this.a = var1;
		this.b = var2;
		if (var2.length() > 40) {
			throw new IllegalArgumentException("Hash is too long (max 40, was " + var2.length() + ")");
		}
	}

	public void a(hd var1) {
		this.a = var1.c(32767);
		this.b = var1.c(40);
	}

	public void b(hd var1) {
		var1.a(this.a);
		var1.a(this.b);
	}

	public void a(ik var1) {
		var1.a(this);
	}
}
