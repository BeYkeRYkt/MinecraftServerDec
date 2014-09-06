package net.minecraft;

public class TileEntityFlowerPot extends TileEntity {

	private Item a;
	private int f;

	public TileEntityFlowerPot() {
	}

	public TileEntityFlowerPot(Item var1, int var2) {
		this.a = var1;
		this.f = var2;
	}

	public void write(NBTCompoundTag var1) {
		super.write(var1);
		BlockNameInfo var2 = (BlockNameInfo) Item.REGISTRY.c(this.a);
		var1.put("Item", var2 == null ? "" : var2.toString());
		var1.put("Data", this.f);
	}

	public void read(NBTCompoundTag var1) {
		super.read(var1);
		if (var1.isTagAssignableFrom("Item", 8)) {
			this.a = Item.d(var1.getString("Item"));
		} else {
			this.a = Item.getById(var1.getInt("Item"));
		}

		this.f = var1.getInt("Data");
	}

	public Packet getUpdatePacket() {
		NBTCompoundTag var1 = new NBTCompoundTag();
		this.write(var1);
		var1.remove("Item");
		var1.put("Item", Item.getId(this.a));
		return new PacketOutUpdateBlockEntity(this.position, 5, var1);
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
