package net.minecraft;

public class ChunkNibbleArray {

	private final byte[] array;

	public ChunkNibbleArray() {
		this.array = new byte[2048];
	}

	public ChunkNibbleArray(byte[] array) {
		this.array = array;
		if (array.length != 2048) {
			throw new IllegalArgumentException("ChunkNibbleArrays should be 2048 bytes not: " + array.length);
		}
	}

	public int getValue(int x, int y, int z) {
		return this.getValue(this.getIndex(x, y, z));
	}

	public void setValue(int x, int y, int z, int value) {
		this.setValue(this.getIndex(x, y, z), value);
	}

	private int getIndex(int x, int y, int z) {
		return y << 8 | z << 4 | x;
	}

	public int getValue(int index) {
		int shiftedIndex = this.shiftRight(index);
		return this.isEven(index) ? this.array[shiftedIndex] & 15 : this.array[shiftedIndex] >> 4 & 15;
	}

	public void setValue(int index, int value) {
		int shiftedIndex = this.shiftRight(index);
		if (this.isEven(index)) {
			this.array[shiftedIndex] = (byte) (this.array[shiftedIndex] & 240 | value & 15);
		} else {
			this.array[shiftedIndex] = (byte) (this.array[shiftedIndex] & 15 | (value & 15) << 4);
		}
	}

	private boolean isEven(int index) {
		return (index & 1) == 0;
	}

	private int shiftRight(int index) {
		return index >> 1;
	}

	public byte[] getArray() {
		return this.array;
	}

}
