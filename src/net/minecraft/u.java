package net.minecraft;

public class u extends RuntimeException {

	private final CrashReport a;

	public u(CrashReport var1) {
		this.a = var1;
	}

	public CrashReport a() {
		return this.a;
	}

	public Throwable getCause() {
		return this.a.b();
	}

	public String getMessage() {
		return this.a.a();
	}
}
