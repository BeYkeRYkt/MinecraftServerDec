package net.minecraft;

public class NextTickListEntry implements Comparable<NextTickListEntry> {

	private static long d;

	private final Block block;
	public final Position position;
	public long b;
	public int c;
	private long f;

	public NextTickListEntry(Position var1, Block var2) {
		this.f = (long) (d++);
		this.position = var1;
		this.block = var2;
	}

	public boolean equals(Object var1) {
		if (!(var1 instanceof NextTickListEntry)) {
			return false;
		} else {
			NextTickListEntry var2 = (NextTickListEntry) var1;
			return this.position.equals(var2.position) && Block.a(this.block, var2.block);
		}
	}

	public int hashCode() {
		return this.position.hashCode();
	}

	public NextTickListEntry a(long var1) {
		this.b = var1;
		return this;
	}

	public void a(int var1) {
		this.c = var1;
	}

	public int compareTo(NextTickListEntry otherEntry) {
		return this.b < otherEntry.b ? -1 : (this.b > otherEntry.b ? 1 : (this.c != otherEntry.c ? this.c - otherEntry.c : (this.f < otherEntry.f ? -1 : (this.f > otherEntry.f ? 1 : 0))));
	}

	public String toString() {
		return Block.getBlockId(this.block) + ": " + this.position + ", " + this.b + ", " + this.c + ", " + this.f;
	}

	public Block getBlock() {
		return this.block;
	}

}
