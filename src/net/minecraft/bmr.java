package net.minecraft;

public class bmr extends bqc {

	private NBTCompoundTag b = new NBTCompoundTag();

	public bmr(String var1) {
		super(var1);
	}

	public void a(NBTCompoundTag var1) {
		this.b = var1.getCompound("Features");
	}

	public void b(NBTCompoundTag var1) {
		var1.put("Features", (NBTTag) this.b);
	}

	public void a(NBTCompoundTag var1, int var2, int var3) {
		this.b.put(b(var2, var3), (NBTTag) var1);
	}

	public static String b(int var0, int var1) {
		return "[" + var0 + "," + var1 + "]";
	}

	public NBTCompoundTag a() {
		return this.b;
	}
}
