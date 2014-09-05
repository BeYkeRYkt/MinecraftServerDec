package net.minecraft;

public class axd extends bcm {

	private ItemStack a;

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		if (var1.isTagAssignableFrom("RecordItem", 10)) {
			this.a(ItemStack.a(var1.getCompound("RecordItem")));
		} else if (var1.getInt("Record") > 0) {
			this.a(new ItemStack(Item.getById(var1.getInt("Record")), 1, 0));
		}

	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		if (this.a() != null) {
			var1.put("RecordItem", (NBTTag) this.a().b(new NBTCompoundTag()));
		}

	}

	public ItemStack a() {
		return this.a;
	}

	public void a(ItemStack var1) {
		this.a = var1;
		this.o_();
	}
}
