package net.minecraft;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

public class CrashReportSystemDetails {

	private final String reason;
	private final List<r> c = Lists.newArrayList();
	private StackTraceElement[] stackTraceElements = new StackTraceElement[0];

	public CrashReportSystemDetails(CrashReport var1, String var2) {
		this.reason = var2;
	}

	public static String a(double var0, double var2, double var4) {
		return String.format("%.2f,%.2f,%.2f - %s", new Object[] { Double.valueOf(var0), Double.valueOf(var2), Double.valueOf(var4), a(new Position(var0, var2, var4)) });
	}

	public static String a(Position var0) {
		int var1 = var0.getX();
		int var2 = var0.getY();
		int var3 = var0.getZ();
		StringBuilder var4 = new StringBuilder();

		try {
			var4.append(String.format("World: (%d,%d,%d)", new Object[] { Integer.valueOf(var1), Integer.valueOf(var2), Integer.valueOf(var3) }));
		} catch (Throwable var17) {
			var4.append("(Error finding world loc)");
		}

		var4.append(", ");

		int var5;
		int var6;
		int var7;
		int var8;
		int var9;
		int var10;
		int var11;
		int var12;
		int var13;
		try {
			var5 = var1 >> 4;
			var6 = var3 >> 4;
			var7 = var1 & 15;
			var8 = var2 >> 4;
			var9 = var3 & 15;
			var10 = var5 << 4;
			var11 = var6 << 4;
			var12 = (var5 + 1 << 4) - 1;
			var13 = (var6 + 1 << 4) - 1;
			var4.append(String.format("Chunk: (at %d,%d,%d in %d,%d; contains blocks %d,0,%d to %d,255,%d)", new Object[] { Integer.valueOf(var7), Integer.valueOf(var8), Integer.valueOf(var9), Integer.valueOf(var5), Integer.valueOf(var6), Integer.valueOf(var10), Integer.valueOf(var11), Integer.valueOf(var12), Integer.valueOf(var13) }));
		} catch (Throwable var16) {
			var4.append("(Error finding chunk loc)");
		}

		var4.append(", ");

		try {
			var5 = var1 >> 9;
			var6 = var3 >> 9;
			var7 = var5 << 5;
			var8 = var6 << 5;
			var9 = (var5 + 1 << 5) - 1;
			var10 = (var6 + 1 << 5) - 1;
			var11 = var5 << 9;
			var12 = var6 << 9;
			var13 = (var5 + 1 << 9) - 1;
			int var14 = (var6 + 1 << 9) - 1;
			var4.append(String.format("Region: (%d,%d; contains chunks %d,%d to %d,%d, blocks %d,0,%d to %d,255,%d)", new Object[] { Integer.valueOf(var5), Integer.valueOf(var6), Integer.valueOf(var7), Integer.valueOf(var8), Integer.valueOf(var9), Integer.valueOf(var10), Integer.valueOf(var11), Integer.valueOf(var12), Integer.valueOf(var13), Integer.valueOf(var14) }));
		} catch (Throwable var15) {
			var4.append("(Error finding world loc)");
		}

		return var4.toString();
	}

	public void addDetails(String var1, Callable var2) {
		try {
			this.addDetails(var1, var2.call());
		} catch (Throwable var4) {
			this.a(var1, var4);
		}

	}

	public void addDetails(String var1, Object var2) {
		this.c.add(new r(var1, var2));
	}

	public void a(String var1, Throwable var2) {
		this.addDetails(var1, (Object) var2);
	}

	public int getStackTraceLength(int startIndex) {
		StackTraceElement[] elements = Thread.currentThread().getStackTrace();
		if (elements.length <= 0) {
			return 0;
		} else {
			this.stackTraceElements = new StackTraceElement[elements.length - 3 - startIndex];
			System.arraycopy(elements, 3 + startIndex, this.stackTraceElements, 0, this.stackTraceElements.length);
			return this.stackTraceElements.length;
		}
	}

	public boolean a(StackTraceElement var1, StackTraceElement var2) {
		if (this.stackTraceElements.length != 0 && var1 != null) {
			StackTraceElement var3 = this.stackTraceElements[0];
			if (var3.isNativeMethod() == var1.isNativeMethod() && var3.getClassName().equals(var1.getClassName()) && var3.getFileName().equals(var1.getFileName()) && var3.getMethodName().equals(var1.getMethodName())) {
				if (var2 != null != this.stackTraceElements.length > 1) {
					return false;
				} else if (var2 != null && !this.stackTraceElements[1].equals(var2)) {
					return false;
				} else {
					this.stackTraceElements[0] = var1;
					return true;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public void b(int var1) {
		StackTraceElement[] var2 = new StackTraceElement[this.stackTraceElements.length - var1];
		System.arraycopy(this.stackTraceElements, 0, var2, 0, var2.length);
		this.stackTraceElements = var2;
	}

	public void a(StringBuilder var1) {
		var1.append("-- ").append(this.reason).append(" --\n");
		var1.append("Details:");
		Iterator var2 = this.c.iterator();

		while (var2.hasNext()) {
			r var3 = (r) var2.next();
			var1.append("\n\t");
			var1.append(var3.a());
			var1.append(": ");
			var1.append(var3.b());
		}

		if (this.stackTraceElements != null && this.stackTraceElements.length > 0) {
			var1.append("\nStacktrace:");
			StackTraceElement[] var6 = this.stackTraceElements;
			int var7 = var6.length;

			for (int var4 = 0; var4 < var7; ++var4) {
				StackTraceElement var5 = var6[var4];
				var1.append("\n\tat ");
				var1.append(var5.toString());
			}
		}

	}

	public StackTraceElement[] a() {
		return this.stackTraceElements;
	}

	public static void a(CrashReportSystemDetails var0, Position var1, Block var2, int var3) {
		int var4 = Block.getBlockId(var2);
		var0.addDetails("Block type", (Callable) (new k(var4, var2)));
		var0.addDetails("Block data value", (Callable) (new l(var3)));
		var0.addDetails("Block location", (Callable) (new m(var1)));
	}

	public static void a(CrashReportSystemDetails var0, Position var1, bec var2) {
		var0.addDetails("Block", (Callable) (new p(var2)));
		var0.addDetails("Block location", (Callable) (new q(var1)));
	}
}
