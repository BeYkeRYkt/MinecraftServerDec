package net.minecraft;

public class kp implements id<ik> {

	private int a;
	private Difficulty b;
	private GameMode c;
	private are d;

	public kp() {
	}

	public kp(int var1, Difficulty var2, are var3, GameMode var4) {
		this.a = var1;
		this.b = var2;
		this.c = var4;
		this.d = var3;
	}

	public void a(ik var1) {
		var1.a(this);
	}

	public void a(hd var1) {
		this.a = var1.readInt();
		this.b = Difficulty.clampAndGetById(var1.readUnsignedByte());
		this.c = GameMode.byId(var1.readUnsignedByte());
		this.d = are.a(var1.c(16));
		if (this.d == null) {
			this.d = are.b;
		}

	}

	public void b(hd var1) {
		var1.writeInt(this.a);
		var1.writeByte(this.b.getId());
		var1.writeByte(this.c.getId());
		var1.a(this.d.a());
	}
}