package net.minecraft;

public class TileEntityRecordPlayer extends TileEntity {

	private ItemStack record;

	public void read(NBTCompoundTag tag) {
		super.read(tag);
		if (tag.isTagAssignableFrom("RecordItem", 10)) {
			this.setRecord(ItemStack.fromNBT(tag.getCompound("RecordItem")));
		} else if (tag.getInt("Record") > 0) {
			this.setRecord(new ItemStack(Item.getById(tag.getInt("Record")), 1, 0));
		}

	}

	public void write(NBTCompoundTag tag) {
		super.write(tag);
		if (this.getRecord() != null) {
			tag.put("RecordItem", (NBTTag) this.getRecord().write(new NBTCompoundTag()));
		}

	}

	public ItemStack getRecord() {
		return this.record;
	}

	public void setRecord(ItemStack record) {
		this.record = record;
		this.update();
	}
}
