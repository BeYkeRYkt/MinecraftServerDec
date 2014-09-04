package net.minecraft;

public class NBTReadLimiter {

	public static final NBTReadLimiter notlimited = new NotLimitedNBTReadLimiter(0L);
	private final long limit;
	private long totalBytesRead;

	public NBTReadLimiter(long var1) {
		this.limit = var1;
	}

	public void a(long bitsRead) {
		this.totalBytesRead += bitsRead / 8L;
		if (this.totalBytesRead > this.limit) {
			throw new RuntimeException("Tried to read NBT tag that was too big; tried to allocate: " + this.totalBytesRead + "bytes where max allowed: " + this.limit);
		}
	}

}
