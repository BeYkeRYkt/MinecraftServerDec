package net.minecraft;

public class ReportedException extends RuntimeException {

	private final CrashReport crashReport;

	public ReportedException(CrashReport crashReport) {
		this.crashReport = crashReport;
	}

	public CrashReport getCrashReport() {
		return this.crashReport;
	}

	public Throwable getCause() {
		return this.crashReport.getThrowable();
	}

	public String getMessage() {
		return this.crashReport.getMessage();
	}
}
