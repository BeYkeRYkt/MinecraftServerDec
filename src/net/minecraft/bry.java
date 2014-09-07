package net.minecraft;

public class bry {

	private final bsd a;
	private final String b;
	private final IScoreboardCriteria c;
	private bsl d;
	private String e;

	public bry(bsd var1, String var2, IScoreboardCriteria var3) {
		this.a = var1;
		this.b = var2;
		this.c = var3;
		this.e = var2;
		this.d = var3.c();
	}

	public String b() {
		return this.b;
	}

	public IScoreboardCriteria c() {
		return this.c;
	}

	public String d() {
		return this.e;
	}

	public void a(String var1) {
		this.e = var1;
		this.a.b(this);
	}

	public bsl e() {
		return this.d;
	}

	public void a(bsl var1) {
		this.d = var1;
		this.a.b(this);
	}
}
