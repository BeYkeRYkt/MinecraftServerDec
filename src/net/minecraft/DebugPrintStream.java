package net.minecraft;

import java.io.OutputStream;
import java.io.PrintStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DebugPrintStream extends PrintStream {

	private static final Logger logger = LogManager.getLogger();
	private final String string;

	public DebugPrintStream(String string, OutputStream stream) {
		super(stream);
		this.string = string;
	}

	public void println(String string) {
		this.debug(string);
	}

	public void println(Object object) {
		this.debug(String.valueOf(object));
	}

	private void debug(String string) {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		StackTraceElement element = stackTraceElements[Math.min(3, stackTraceElements.length)];
		logger.info("[{}]@.({}:{}): {}", new Object[] { this.string, element.getFileName(), Integer.valueOf(element.getLineNumber()), string });
	}

}
