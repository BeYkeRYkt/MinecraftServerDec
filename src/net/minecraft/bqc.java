package net.minecraft;

public abstract class bqc {

	public final String a;
	private boolean b;

	public bqc(String var1) {
		this.a = var1;
	}

	public abstract void a(NBTCompoundTag var1);

	public abstract void b(NBTCompoundTag var1);

	public void c() {
		this.a(true);
	}

	public void a(boolean var1) {
		this.b = var1;
	}

	public boolean d() {
		return this.b;
	}
}
