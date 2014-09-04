package net.minecraft;

public class aeb extends adx {

	private final aqf a = new aec(this);
	private int b = 0;

	public aeb(World var1) {
		super(var1);
	}

	public aeb(World var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
	}

	protected void h() {
		super.h();
		this.H().a(23, "");
		this.H().a(24, "");
	}

	protected void a(NBTCompoundTag var1) {
		super.a(var1);
		this.a.b(var1);
		this.H().b(23, this.j().l());
		this.H().b(24, hp.a(this.j().k()));
	}

	protected void b(NBTCompoundTag var1) {
		super.b(var1);
		this.a.a(var1);
	}

	public adz s() {
		return adz.g;
	}

	public bec u() {
		return aty.bX.P();
	}

	public aqf j() {
		return this.a;
	}

	public void a(int var1, int var2, int var3, boolean var4) {
		if (var4 && this.W - this.b >= 4) {
			this.j().a(this.o);
			this.b = this.W;
		}

	}

	public boolean e(ahd var1) {
		this.a.a(var1);
		return false;
	}

	public void i(int var1) {
		super.i(var1);
		if (var1 == 24) {
			try {
				this.a.b(hp.a(this.H().e(24)));
			} catch (Throwable var3) {
				;
			}
		} else if (var1 == 23) {
			this.a.a(this.H().e(23));
		}

	}
}
