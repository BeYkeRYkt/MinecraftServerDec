package net.minecraft;

public final class pi extends RuntimeException {

	public static final pi a = new pi();

	private pi() {
		this.setStackTrace(new StackTraceElement[0]);
	}

	public synchronized Throwable fillInStackTrace() {
		this.setStackTrace(new StackTraceElement[0]);
		return this;
	}

}
