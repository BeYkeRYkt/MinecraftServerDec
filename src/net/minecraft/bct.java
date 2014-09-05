package net.minecraft;

public class bct extends bcm {

	private final aqf a = new bcu(this);

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		this.a.a(var1);
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		this.a.b(var1);
	}

	public Packet x_() {
		NBTCompoundTag var1 = new NBTCompoundTag();
		this.b(var1);
		return new iu(this.c, 2, var1);
	}

	public aqf b() {
		return this.a;
	}

	public af c() {
		return this.a.n();
	}
}
