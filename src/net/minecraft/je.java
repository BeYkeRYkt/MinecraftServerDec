package net.minecraft;

public class je implements id<ik> {

	private int a;
	private String b;
	private ho c;
	private int d;
	private int e;

	public je() {
	}

	public je(int var1, String var2, ho var3) {
		this(var1, var2, var3, 0);
	}

	public je(int var1, String var2, ho var3, int var4) {
		this.a = var1;
		this.b = var2;
		this.c = var3;
		this.d = var4;
	}

	public je(int var1, String var2, ho var3, int var4, int var5) {
		this(var1, var2, var3, var4);
		this.e = var5;
	}

	public void a(ik var1) {
		var1.a(this);
	}

	public void a(hd var1) {
		this.a = var1.readUnsignedByte();
		this.b = var1.c(32);
		this.c = var1.d();
		this.d = var1.readUnsignedByte();
		if (this.b.equals("EntityHorse")) {
			this.e = var1.readInt();
		}

	}

	public void b(hd var1) {
		var1.writeByte(this.a);
		var1.a(this.b);
		var1.a(this.c);
		var1.writeByte(this.d);
		if (this.b.equals("EntityHorse")) {
			var1.writeInt(this.e);
		}

	}
}
