package net.minecraft;

public class NibbleArray {

	private final byte[] array;

	public NibbleArray() {
		this.array = new byte[2048];
	}

	public NibbleArray(byte[] array) {
		this.array = array;
		if (array.length != 2048) {
			throw new IllegalArgumentException("ChunkNibbleArrays should be 2048 bytes not: " + array.length);
		}
	}

	public int a(int var1, int var2, int var3) {
		return this.a(this.b(var1, var2, var3));
	}

	public void a(int var1, int var2, int var3, int var4) {
		this.a(this.b(var1, var2, var3), var4);
	}

	private int b(int var1, int var2, int var3) {
		return var2 << 8 | var3 << 4 | var1;
	}

	public int a(int var1) {
		int var2 = this.shiftRight(var1);
		return this.b(var1) ? this.array[var2] & 15 : this.array[var2] >> 4 & 15;
	}

	public void a(int var1, int var2) {
		int var3 = this.shiftRight(var1);
		if (this.b(var1)) {
			this.array[var3] = (byte) (this.array[var3] & 240 | var2 & 15);
		} else {
			this.array[var3] = (byte) (this.array[var3] & 15 | (var2 & 15) << 4);
		}

	}

	private boolean b(int var1) {
		return (var1 & 1) == 0;
	}

	private int shiftRight(int i) {
		return i >> 1;
	}

	public byte[] getArray() {
		return this.array;
	}

}
