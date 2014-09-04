package net.minecraft;

import com.google.common.collect.Lists;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
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

	private static final Logger a = LogManager.getLogger();
	private final String b;
	private final Throwable c;
	private final j d = new j(this, "System Details");
	private final List e = Lists.newArrayList();
	private File f;
	private boolean g = true;
	private StackTraceElement[] h = new StackTraceElement[0];

	public CrashReport(String var1, Throwable var2) {
		this.b = var1;
		this.c = var2;
		this.h();
	}

	private void h() {
		this.d.a("Minecraft Version", (Callable) (new c(this)));
		this.d.a("Operating System", (Callable) (new d(this)));
		this.d.a("Java Version", (Callable) (new e(this)));
		this.d.a("Java VM Version", (Callable) (new f(this)));
		this.d.a("Memory", (Callable) (new g(this)));
		this.d.a("JVM Flags", (Callable) (new h(this)));
		this.d.a("IntCache", (Callable) (new i(this)));
	}

	public String a() {
		return this.b;
	}

	public Throwable b() {
		return this.c;
	}

	public void a(StringBuilder var1) {
		if ((this.h == null || this.h.length <= 0) && this.e.size() > 0) {
			this.h = (StackTraceElement[]) ArrayUtils.subarray((Object[]) ((j) this.e.get(0)).a(), 0, 1);
		}

		if (this.h != null && this.h.length > 0) {
			var1.append("-- Head --\n");
			var1.append("Stacktrace:\n");
			StackTraceElement[] var2 = this.h;
			int var3 = var2.length;

			for (int var4 = 0; var4 < var3; ++var4) {
				StackTraceElement var5 = var2[var4];
				var1.append("\t").append("at ").append(var5.toString());
				var1.append("\n");
			}

			var1.append("\n");
		}

		Iterator var6 = this.e.iterator();

		while (var6.hasNext()) {
			j var7 = (j) var6.next();
			var7.a(var1);
			var1.append("\n\n");
		}

		this.d.a(var1);
	}

	public String d() {
		StringWriter var1 = null;
		PrintWriter var2 = null;
		Object var3 = this.c;
		if (((Throwable) var3).getMessage() == null) {
			if (var3 instanceof NullPointerException) {
				var3 = new NullPointerException(this.b);
			} else if (var3 instanceof StackOverflowError) {
				var3 = new StackOverflowError(this.b);
			} else if (var3 instanceof OutOfMemoryError) {
				var3 = new OutOfMemoryError(this.b);
			}

			((Throwable) var3).setStackTrace(this.c.getStackTrace());
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

	public String e() {
		StringBuilder var1 = new StringBuilder();
		var1.append("---- Minecraft Crash Report ----\n");
		var1.append("// ");
		var1.append(i());
		var1.append("\n\n");
		var1.append("Time: ");
		var1.append((new SimpleDateFormat()).format(new Date()));
		var1.append("\n");
		var1.append("Description: ");
		var1.append(this.b);
		var1.append("\n\n");
		var1.append(this.d());
		var1.append("\n\nA detailed walkthrough of the error, its code path and all known details is as follows:\n");

		for (int var2 = 0; var2 < 87; ++var2) {
			var1.append("-");
		}

		var1.append("\n\n");
		this.a(var1);
		return var1.toString();
	}

	public boolean a(File var1) {
		if (this.f != null) {
			return false;
		} else {
			if (var1.getParentFile() != null) {
				var1.getParentFile().mkdirs();
			}

			try {
				FileWriter var2 = new FileWriter(var1);
				var2.write(this.e());
				var2.close();
				this.f = var1;
				return true;
			} catch (Throwable var3) {
				a.error("Could not save crash report to " + var1, var3);
				return false;
			}
		}
	}

	public j g() {
		return this.d;
	}

	public j a(String var1) {
		return this.a(var1, 1);
	}

	public j a(String var1, int var2) {
		j var3 = new j(this, var1);
		if (this.g) {
			int var4 = var3.a(var2);
			StackTraceElement[] var5 = this.c.getStackTrace();
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

			this.g = var3.a(var6, var7);
			if (var4 > 0 && !this.e.isEmpty()) {
				j var9 = (j) this.e.get(this.e.size() - 1);
				var9.b(var4);
			} else if (var5 != null && var5.length >= var4 && 0 <= var8 && var8 < var5.length) {
				this.h = new StackTraceElement[var8];
				System.arraycopy(var5, 0, this.h, 0, this.h.length);
			} else {
				this.g = false;
			}
		}

		this.e.add(var3);
		return var3;
	}

	private static String i() {
		String[] var0 = new String[] { "Who set us up the TNT?", "Everything\'s going to plan. No, really, that was supposed to happen.", "Uh... Did I do that?", "Oops.", "Why did you do that?", "I feel sad now :(", "My bad.", "I\'m sorry, Dave.", "I let you down. Sorry :(", "On the bright side, I bought you a teddy bear!", "Daisy, daisy...", "Oh - I know what I did wrong!", "Hey, that tickles! Hehehe!", "I blame Dinnerbone.", "You should try our sister game, Minceraft!",
				"Don\'t be sad. I\'ll do better next time, I promise!", "Don\'t be sad, have a hug! <3", "I just don\'t know what went wrong :(", "Shall we play a game?", "Quite honestly, I wouldn\'t worry myself about that.", "I bet Cylons wouldn\'t have this problem.", "Sorry :(", "Surprise! Haha. Well, this is awkward.", "Would you like a cupcake?", "Hi. I\'m Minecraft, and I\'m a crashaholic.", "Ooh. Shiny.", "This doesn\'t make any sense!", "Why is it breaking :(", "Don\'t do that.",
				"Ouch. That hurt :(", "You\'re mean.", "This is a token for 1 free hug. Redeem at your nearest Mojangsta: [~~HUG~~]", "There are four lights!", "But it works on my machine." };

		try {
			return var0[(int) (System.nanoTime() % (long) var0.length)];
		} catch (Throwable var2) {
			return "Witty comment unavailable :(";
		}
	}

	public static CrashReport a(Throwable var0, String var1) {
		CrashReport var2;
		if (var0 instanceof u) {
			var2 = ((u) var0).a();
		} else {
			var2 = new CrashReport(var1, var0);
		}

		return var2;
	}

}
