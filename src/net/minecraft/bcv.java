package net.minecraft;

public class bcv extends bcm {

	private int a;

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.put("OutputSignal", this.a);
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		this.a = var1.getInt("OutputSignal");
	}

	public int b() {
		return this.a;
	}

	public void a(int var1) {
		this.a = var1;
	}
}
