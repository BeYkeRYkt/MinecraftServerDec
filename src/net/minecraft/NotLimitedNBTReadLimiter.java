package net.minecraft;

final class NotLimitedNBTReadLimiter extends NBTReadLimiter {

	NotLimitedNBTReadLimiter(long limit) {
		super(limit);
	}

	public void onBytesRead(long bitsRead) {
	}

}
