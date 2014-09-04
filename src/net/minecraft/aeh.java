package net.minecraft;

public class aeh extends adx {

	private final aqi a = new aei(this);

	public aeh(World var1) {
		super(var1);
	}

	public aeh(World var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
	}

	public adz s() {
		return adz.e;
	}

	public bec u() {
		return aty.ac.P();
	}

	protected void a(NBTCompoundTag var1) {
		super.a(var1);
		this.a.a(var1);
	}

	protected void b(NBTCompoundTag var1) {
		super.b(var1);
		this.a.b(var1);
	}

	public void s_() {
		super.s_();
		this.a.c();
	}
}
