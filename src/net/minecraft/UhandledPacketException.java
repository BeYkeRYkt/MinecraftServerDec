package net.minecraft;

@SuppressWarnings("serial")
public final class UhandledPacketException extends RuntimeException {

	public static final UhandledPacketException instance = new UhandledPacketException();

	private UhandledPacketException() {
		this.setStackTrace(new StackTraceElement[0]);
	}

	public synchronized Throwable fillInStackTrace() {
		this.setStackTrace(new StackTraceElement[0]);
		return this;
	}

}
