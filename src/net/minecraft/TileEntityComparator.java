package net.minecraft;

public class TileEntityComparator extends TileEntity {

	private int a;

	public void write(NBTCompoundTag var1) {
		super.write(var1);
		var1.put("OutputSignal", this.a);
	}

	public void read(NBTCompoundTag var1) {
		super.read(var1);
		this.a = var1.getInt("OutputSignal");
	}

	public int b() {
		return this.a;
	}

	public void a(int var1) {
		this.a = var1;
	}
}
