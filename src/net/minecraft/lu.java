package net.minecraft;

public class lu implements id<ls> {

	private String a;

	public lu() {
	}

	public lu(String var1) {
		if (var1.length() > 100) {
			var1 = var1.substring(0, 100);
		}

		this.a = var1;
	}

	public void a(hd var1) {
		this.a = var1.c(100);
	}

	public void b(hd var1) {
		var1.a(this.a);
	}

	public void a(ls var1) {
		var1.a(this);
	}

	public String a() {
		return this.a;
	}
}
