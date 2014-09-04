package net.minecraft;

public class km implements id<ik> {

	private int[] a;

	public km() {
	}

	public km(int... var1) {
		this.a = var1;
	}

	public void a(hd var1) {
		this.a = new int[var1.e()];

		for (int var2 = 0; var2 < this.a.length; ++var2) {
			this.a[var2] = var1.e();
		}

	}

	public void b(hd var1) {
		var1.b(this.a.length);

		for (int var2 = 0; var2 < this.a.length; ++var2) {
			var1.b(this.a[var2]);
		}

	}

	public void a(ik var1) {
		var1.a(this);
	}
}
