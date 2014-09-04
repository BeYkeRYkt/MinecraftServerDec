package net.minecraft;

final class NotLimitedNBTReadLimiter extends NBTReadLimiter {

	NotLimitedNBTReadLimiter(long limit) {
		super(limit);
	}

	public void a(long bitsRead) {
	}

}
