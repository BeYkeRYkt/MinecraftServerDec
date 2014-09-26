package net.minecraft;

class CrashReportSystemDetailsEntry {

	private final String string;
	private final String value;

	public CrashReportSystemDetailsEntry(String string, Object value) {
		this.string = string;
		if (value == null) {
			this.value = "~~NULL~~";
		} else if (value instanceof Throwable) {
			Throwable var3 = (Throwable) value;
			this.value = "~~ERROR~~ " + var3.getClass().getSimpleName() + ": " + var3.getMessage();
		} else {
			this.value = value.toString();
		}

	}

	public String getString() {
		return this.string;
	}

	public String getValue() {
		return this.value;
	}

}
