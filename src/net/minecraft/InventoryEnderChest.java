package net.minecraft;

import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.InventoryHolder;

public class InventoryEnderChest extends InventorySubcontainer {

	private TileEntityEnderChest a;
	private EntityHuman owner;

	public InventoryEnderChest(EntityHuman owner) {
		super("container.enderchest", false, 27);
		this.owner = owner;
	}

	public void a(TileEntityEnderChest var1) {
		this.a = var1;
	}

	public void a(NBTListTag var1) {
		int var2;
		for (var2 = 0; var2 < this.getSize(); ++var2) {
			this.setItem(var2, (ItemStack) null);
		}

		for (var2 = 0; var2 < var1.getSize(); ++var2) {
			NBTCompoundTag var3 = var1.getCompound(var2);
			int var4 = var3.getByte("Slot") & 255;
			if (var4 >= 0 && var4 < this.getSize()) {
				this.setItem(var4, ItemStack.fromNBT(var3));
			}
		}

	}

	public NBTListTag h() {
		NBTListTag var1 = new NBTListTag();

		for (int var2 = 0; var2 < this.getSize(); ++var2) {
			ItemStack var3 = this.getItem(var2);
			if (var3 != null) {
				NBTCompoundTag var4 = new NBTCompoundTag();
				var4.put("Slot", (byte) var2);
				var3.write(var4);
				var1.addTag((NBTTag) var4);
			}
		}

		return var1;
	}

	public boolean canInteract(EntityHuman var1) {
		return this.a != null && !this.a.a(var1) ? false : super.canInteract(var1);
	}

	public void onContainerOpen(EntityHuman var1) {
		if (this.a != null) {
			this.a.b();
		}

		super.onContainerOpen(var1);
	}

	public void onContainerClose(EntityHuman var1) {
		if (this.a != null) {
			this.a.d();
		}

		super.onContainerClose(var1);
		this.a = null;
	}

	@Override
	public InventoryHolder getHolder() {
		return owner.getBukkitEntity(HumanEntity.class);
	}

}
