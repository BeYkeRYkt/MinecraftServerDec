package net.minecraft;

import com.google.common.collect.Lists;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CrashReport {

	private static final Logger logger = LogManager.getLogger();
	private final String message;
	private final Throwable throwable;
	private final CrashReportSystemDetails systemDetails = new CrashReportSystemDetails(this, "System Details");
	private final List<CrashReportSystemDetails> details = Lists.newArrayList();
	private File file;
	private boolean g = true;
	private StackTraceElement[] h = new StackTraceElement[0];

	public CrashReport(String var1, Throwable var2) {
		this.message = var1;
		this.throwable = var2;
		this.h();
	}

	private void h() {
		this.systemDetails.addDetails("Minecraft Version", "1.8");
		this.systemDetails.addDetails("Operating System", System.getProperty("os.name") + " (" + System.getProperty("os.arch") + ") version " + System.getProperty("os.version"));
		this.systemDetails.addDetails("Java Version", System.getProperty("java.version") + ", " + System.getProperty("java.vendor"));
		this.systemDetails.addDetails("Java VM Version", System.getProperty("java.vm.name") + " (" + System.getProperty("java.vm.info") + "), " + System.getProperty("java.vm.vendor"));
		this.systemDetails.addDetails("Memory", new Callable<String>(){
			@Override
			public String call() throws Exception {
				Runtime runtime = Runtime.getRuntime();
				long maxMemory = runtime.maxMemory();
				long totalMemory = runtime.totalMemory();
				long freeMemory = runtime.freeMemory();
				long maxMemoryMB = maxMemory / 1024L / 1024L;
				long totalMemotyMB = totalMemory / 1024L / 1024L;
				long freeMemoryMB = freeMemory / 1024L / 1024L;
				return freeMemory + " bytes (" + freeMemoryMB + " MB) / " + totalMemory + " bytes (" + totalMemotyMB + " MB) up to " + maxMemory + " bytes (" + maxMemoryMB + " MB)";
			}
		});
		this.systemDetails.addDetails("JVM Flags", new Callable<String>() {
			@Override
			public String call() throws Exception {
				RuntimeMXBean mxBean = ManagementFactory.getRuntimeMXBean();
				List<String> inputArguments = mxBean.getInputArguments();
				int count = 0;
				StringBuilder sb = new StringBuilder();
				for (String inputArgument : inputArguments) {
					if (inputArgument.startsWith("-X")) {
						if (count++ > 0) {
							sb.append(" ");
						}
						sb.append(inputArgument);
					}
				}
				return String.format("%d total; %s", count, sb.toString());
			}
		});
		this.systemDetails.addDetails("IntCache", IntCache.getInfo());
	}

	public String getMessage() {
		return this.message;
	}

	public Throwable getThrowable() {
		return this.throwable;
	}

	public void addDetails(StringBuilder sb) {
		if ((this.h == null || this.h.length <= 0) && this.details.size() > 0) {
			this.h = (StackTraceElement[]) ArrayUtils.subarray((Object[]) ((CrashReportSystemDetails) this.details.get(0)).getStackTrace(), 0, 1);
		}

		if (this.h != null && this.h.length > 0) {
			sb.append("-- Head --\n");
			sb.append("Stacktrace:\n");
			StackTraceElement[] var2 = this.h;
			int var3 = var2.length;

			for (int var4 = 0; var4 < var3; ++var4) {
				StackTraceElement var5 = var2[var4];
				sb.append("\t").append("at ").append(var5.toString());
				sb.append("\n");
			}

			sb.append("\n");
		}

		Iterator<CrashReportSystemDetails> var6 = this.details.iterator();

		while (var6.hasNext()) {
			CrashReportSystemDetails var7 = (CrashReportSystemDetails) var6.next();
			var7.writeDetails(sb);
			sb.append("\n\n");
		}

		this.systemDetails.writeDetails(sb);
	}

	public String d() {
		StringWriter var1 = null;
		PrintWriter var2 = null;
		Object var3 = this.throwable;
		if (((Throwable) var3).getMessage() == null) {
			if (var3 instanceof NullPointerException) {
				var3 = new NullPointerException(this.message);
			} else if (var3 instanceof StackOverflowError) {
				var3 = new StackOverflowError(this.message);
			} else if (var3 instanceof OutOfMemoryError) {
				var3 = new OutOfMemoryError(this.message);
			}

			((Throwable) var3).setStackTrace(this.throwable.getStackTrace());
		}

		String var4 = ((Throwable) var3).toString();

		try {
			var1 = new StringWriter();
			var2 = new PrintWriter(var1);
			((Throwable) var3).printStackTrace(var2);
			var4 = var1.toString();
		} finally {
			IOUtils.closeQuietly((Writer) var1);
			IOUtils.closeQuietly((Writer) var2);
		}

		return var4;
	}

	public String generateReportString() {
		StringBuilder sb = new StringBuilder();
		sb.append("---- Minecraft Crash Report ----\n");
		sb.append("// ");
		sb.append(getCommentThatNobodyWillReadAnyway());
		sb.append("\n\n");
		sb.append("Time: ");
		sb.append((new SimpleDateFormat()).format(new Date()));
		sb.append("\n");
		sb.append("Description: ");
		sb.append(this.message);
		sb.append("\n\n");
		sb.append(this.d());
		sb.append("\n\nA detailed walkthrough of the error, its code path and all known details is as follows:\n");

		for (int i = 0; i < 87; ++i) {
			sb.append("-");
		}

		sb.append("\n\n");
		this.addDetails(sb);
		return sb.toString();
	}

	public boolean write(File var1) {
		if (this.file != null) {
			return false;
		} else {
			if (var1.getParentFile() != null) {
				var1.getParentFile().mkdirs();
			}

			try {
				FileWriter var2 = new FileWriter(var1);
				var2.write(this.generateReportString());
				var2.close();
				this.file = var1;
				return true;
			} catch (Throwable var3) {
				logger.error("Could not save crash report to " + var1, var3);
				return false;
			}
		}
	}

	public CrashReportSystemDetails g() {
		return this.systemDetails;
	}

	public CrashReportSystemDetails generateSystemDetails(String moreinfo) {
		return this.generateSystemDetails(moreinfo, 1);
	}

	public CrashReportSystemDetails generateSystemDetails(String moreinfo, int startIndex) {
		CrashReportSystemDetails details = new CrashReportSystemDetails(this, moreinfo);
		if (this.g) {
			int var4 = details.getStackTraceLength(startIndex);
			StackTraceElement[] var5 = this.throwable.getStackTrace();
			StackTraceElement var6 = null;
			StackTraceElement var7 = null;
			int var8 = var5.length - var4;
			if (var8 < 0) {
				System.out.println("Negative index in crash report handler (" + var5.length + "/" + var4 + ")");
			}

			if (var5 != null && 0 <= var8 && var8 < var5.length) {
				var6 = var5[var8];
				if (var5.length + 1 - var4 < var5.length) {
					var7 = var5[var5.length + 1 - var4];
				}
			}

			this.g = details.replaceStackTraceElement(var6, var7);
			if (var4 > 0 && !this.details.isEmpty()) {
				CrashReportSystemDetails var9 = (CrashReportSystemDetails) this.details.get(this.details.size() - 1);
				var9.stripStackTrace(var4);
			} else if (var5 != null && var5.length >= var4 && 0 <= var8 && var8 < var5.length) {
				this.h = new StackTraceElement[var8];
				System.arraycopy(var5, 0, this.h, 0, this.h.length);
			} else {
				this.g = false;
			}
		}

		this.details.add(details);
		return details;
	}

	private static String getCommentThatNobodyWillReadAnyway() {
		String[] comments = new String[] { "Who set us up the TNT?", "Everything\'s going to plan. No, really, that was supposed to happen.", "Uh... Did I do that?", "Oops.", "Why did you do that?", "I feel sad now :(", "My bad.", "I\'m sorry, Dave.", "I let you down. Sorry :(", "On the bright side, I bought you a teddy bear!", "Daisy, daisy...", "Oh - I know what I did wrong!", "Hey, that tickles! Hehehe!", "I blame Dinnerbone.", "You should try our sister game, Minceraft!",
				"Don\'t be sad. I\'ll do better next time, I promise!", "Don\'t be sad, have a hug! <3", "I just don\'t know what went wrong :(", "Shall we play a game?", "Quite honestly, I wouldn\'t worry myself about that.", "I bet Cylons wouldn\'t have this problem.", "Sorry :(", "Surprise! Haha. Well, this is awkward.", "Would you like a cupcake?", "Hi. I\'m Minecraft, and I\'m a crashaholic.", "Ooh. Shiny.", "This doesn\'t make any sense!", "Why is it breaking :(", "Don\'t do that.",
				"Ouch. That hurt :(", "You\'re mean.", "This is a token for 1 free hug. Redeem at your nearest Mojangsta: [~~HUG~~]", "There are four lights!", "But it works on my machine." };

		try {
			return comments[(int) (System.nanoTime() % comments.length)];
		} catch (Throwable t) {
			return "Witty comment unavailable :(";
		}
	}

	public static CrashReport generateCrashReport(Throwable t, String message) {
		CrashReport report;
		if (t instanceof ReportedException) {
			report = ((ReportedException) t).getCrashReport();
		} else {
			report = new CrashReport(message, t);
		}

		return report;
	}

}
