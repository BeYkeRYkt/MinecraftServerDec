package net.minecraft;

public class vx {

	public static final vx a = new vx("");
	private final String b;

	public vx(String var1) {
		this.b = var1;
	}

	public boolean a() {
		return this.b == null || this.b.isEmpty();
	}

	public String b() {
		return this.b;
	}

	public void a(NBTCompoundTag var1) {
		var1.a("Lock", this.b);
	}

	public static vx b(NBTCompoundTag var0) {
		if (var0.b("Lock", 8)) {
			String var1 = var0.j("Lock");
			return new vx(var1);
		} else {
			return a;
		}
	}

}
