package net.minecraft;

public class bdb extends bcm {

	private alq a;
	private int f;

	public bdb() {
	}

	public bdb(alq var1, int var2) {
		this.a = var1;
		this.f = var2;
	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		oa var2 = (oa) alq.e.c(this.a);
		var1.put("Item", var2 == null ? "" : var2.toString());
		var1.put("Data", this.f);
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		if (var1.isTagAssignableFrom("Item", 8)) {
			this.a = alq.d(var1.getString("Item"));
		} else {
			this.a = alq.b(var1.getInt("Item"));
		}

		this.f = var1.getInt("Data");
	}

	public id x_() {
		NBTCompoundTag var1 = new NBTCompoundTag();
		this.b(var1);
		var1.remove("Item");
		var1.put("Item", alq.b(this.a));
		return new iu(this.c, 5, var1);
	}

	public void a(alq var1, int var2) {
		this.a = var1;
		this.f = var2;
	}

	public alq b() {
		return this.a;
	}

	public int c() {
		return this.f;
	}
}
