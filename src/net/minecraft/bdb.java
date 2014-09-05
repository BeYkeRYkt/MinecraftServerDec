package net.minecraft;

public class bdb extends bcm {

	private Item a;
	private int f;

	public bdb() {
	}

	public bdb(Item var1, int var2) {
		this.a = var1;
		this.f = var2;
	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		oa var2 = (oa) Item.REGISTRY.c(this.a);
		var1.put("Item", var2 == null ? "" : var2.toString());
		var1.put("Data", this.f);
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		if (var1.isTagAssignableFrom("Item", 8)) {
			this.a = Item.d(var1.getString("Item"));
		} else {
			this.a = Item.getById(var1.getInt("Item"));
		}

		this.f = var1.getInt("Data");
	}

	public Packet x_() {
		NBTCompoundTag var1 = new NBTCompoundTag();
		this.b(var1);
		var1.remove("Item");
		var1.put("Item", Item.getId(this.a));
		return new iu(this.c, 5, var1);
	}

	public void a(Item var1, int var2) {
		this.a = var1;
		this.f = var2;
	}

	public Item b() {
		return this.a;
	}

	public int c() {
		return this.f;
	}
}
