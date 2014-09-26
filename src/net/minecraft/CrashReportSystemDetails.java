package net.minecraft;

import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

public class CrashReportSystemDetails {

	public static void addBlockStateInfo(CrashReportSystemDetails details, Position position, final Block block, final int blockData) {
		final int blockId = Block.getBlockId(block);
		details.addDetails("Block type", new Callable<String>() {
			@Override
			public String call() throws Exception {
				try {
					return String.format("ID #%d (%s // %s)", blockId, block.getName(), block.getClass().getCanonicalName());
				} catch (Throwable var2) {
					return "ID #" + blockId;
				}
			}
		});
		details.addDetails("Block data value", new Callable<String>() {
			@Override
			public String call() throws Exception {
				if (blockData < 0) {
					return "Unknown? (Got " + blockData + ")";
				} else {
					String var1 = String.format("%4s", Integer.toBinaryString(blockData)).replace(" ", "0");
					return String.format("%1$d / 0x%1$X / 0b%2$s", blockData, var1);
				}
			}
		});
		details.addDetails("Block location", CrashReportSystemDetails.getPositionInfo(position));
	}

	public static void addBlockStateInfo(CrashReportSystemDetails details, Position position, IBlockState blockState) {
		details.addDetails("Block", blockState.toString());
		details.addDetails("Block location", CrashReportSystemDetails.getPositionInfo(position));
	}

	public static String getPositionInfo(double x, double y, double z) {
		return String.format("%.2f,%.2f,%.2f - %s", x, y, z, getPositionInfo(new Position(x, y, z)));
	}

	public static String getPositionInfo(Position position) {
		int x = position.getX();
		int y = position.getY();
		int z = position.getZ();
		StringBuilder stringInfo = new StringBuilder();

		try {
			stringInfo.append(String.format("World: (%d,%d,%d)", x, y, z));
		} catch (Throwable t) {
			stringInfo.append("(Error finding world loc)");
		}

		stringInfo.append(", ");

		try {
			int chunkX = x >> 4;
			int chunkZ = z >> 4;
			int chunkMinBlockX = x & 15;
			int chunkSection = y >> 4;
			int chunkMinBlockZ = z & 15;
			int chunkWorldX = chunkX << 4;
			int chunkWorldZ = chunkZ << 4;
			int chunkMaxBlockX = (chunkX + 1 << 4) - 1;
			int chunkMaxBlockZ = (chunkZ + 1 << 4) - 1;
			stringInfo.append(String.format("Chunk: (at %d,%d,%d in %d,%d; contains blocks %d,0,%d to %d,255,%d)", chunkMinBlockX, chunkSection, chunkMinBlockZ, chunkX, chunkZ, chunkWorldX, chunkWorldZ, chunkMaxBlockX, chunkMaxBlockZ ));
		} catch (Throwable t) {
			stringInfo.append("(Error finding chunk loc)");
		}

		stringInfo.append(", ");

		try {
			int fileX = x >> 9;
			int fileZ = z >> 9;
			int chunkMinX = fileX << 5;
			int chunkMinZ = fileZ << 5;
			int chunkMaxX = (fileX + 1 << 5) - 1;
			int chunkMaxZ = (fileZ + 1 << 5) - 1;
			int blockMinX = fileX << 9;
			int blockMinZ = fileZ << 9;
			int blockMaxX = (fileX + 1 << 9) - 1;
			int blockMaxZ = (fileZ + 1 << 9) - 1;
			stringInfo.append(String.format("Region: (%d,%d; contains chunks %d,%d to %d,%d, blocks %d,0,%d to %d,255,%d)", fileX, fileZ, chunkMinX, chunkMinZ, chunkMaxX, chunkMaxZ, blockMinX, blockMinZ, blockMaxX, blockMaxZ));
		} catch (Throwable t) {
			stringInfo.append("(Error finding world loc)");
		}

		return stringInfo.toString();
	}

	private final String reason;
	private final List<CrashReportSystemDetailsEntry> details = Lists.newArrayList();
	private StackTraceElement[] stackTraceElements = new StackTraceElement[0];

	public CrashReportSystemDetails(CrashReport report, String reason) {
		this.reason = reason;
	}

	public void addDetails(String string, Callable<String> callable) {
		try {
			this.addDetails(string, callable.call());
		} catch (Throwable t) {
			this.addDetails(string, t);
		}

	}

	public void addDetails(String string, Object object) {
		this.details.add(new CrashReportSystemDetailsEntry(string, object));
	}

	public void addDetails(String string, Throwable t) {
		this.addDetails(string, (Object) t);
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

	public boolean replaceStackTraceElement(StackTraceElement element0, StackTraceElement element1) {
		if (this.stackTraceElements.length != 0 && element0 != null) {
			StackTraceElement element = this.stackTraceElements[0];
			if (element.isNativeMethod() == element0.isNativeMethod() && element.getClassName().equals(element0.getClassName()) && element.getFileName().equals(element0.getFileName()) && element.getMethodName().equals(element0.getMethodName())) {
				if (element1 != null != this.stackTraceElements.length > 1) {
					return false;
				} else if (element1 != null && !this.stackTraceElements[1].equals(element1)) {
					return false;
				} else {
					this.stackTraceElements[0] = element0;
					return true;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public void stripStackTrace(int stripSize) {
		StackTraceElement[] newStackTrace = new StackTraceElement[this.stackTraceElements.length - stripSize];
		System.arraycopy(this.stackTraceElements, 0, newStackTrace, 0, newStackTrace.length);
		this.stackTraceElements = newStackTrace;
	}

	public void writeDetails(StringBuilder sb) {
		sb.append("-- ").append(this.reason).append(" --\n");
		sb.append("Details:");
		Iterator<CrashReportSystemDetailsEntry> iterator = this.details.iterator();
		while (iterator.hasNext()) {
			CrashReportSystemDetailsEntry entry = (CrashReportSystemDetailsEntry) iterator.next();
			sb.append("\n\t");
			sb.append(entry.getString());
			sb.append(": ");
			sb.append(entry.getValue());
		}
		if (this.stackTraceElements != null && this.stackTraceElements.length > 0) {
			sb.append("\nStacktrace:");
			StackTraceElement[] elements = this.stackTraceElements;
			int elementsLength = elements.length;
			for (int i = 0; i < elementsLength; ++i) {
				StackTraceElement var5 = elements[i];
				sb.append("\n\tat ");
				sb.append(var5.toString());
			}
		}

	}

	public StackTraceElement[] getStackTrace() {
		return this.stackTraceElements;
	}

}
