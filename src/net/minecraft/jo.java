package net.minecraft;

public class jo implements id<ik> {

	public static final String[] a = new String[] { "tile.bed.notValid" };
	private int b;
	private float c;

	public jo() {
	}

	public jo(int var1, float var2) {
		this.b = var1;
		this.c = var2;
	}

	public void a(hd var1) {
		this.b = var1.readUnsignedByte();
		this.c = var1.readFloat();
	}

	public void b(hd var1) {
		var1.writeByte(this.b);
		var1.writeFloat(this.c);
	}

	public void a(ik var1) {
		var1.a(this);
	}

}
