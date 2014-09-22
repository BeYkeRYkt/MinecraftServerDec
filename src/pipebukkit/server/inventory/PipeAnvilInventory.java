package pipebukkit.server.inventory;

import java.util.List;

import net.minecraft.EntityHuman;
import net.minecraft.IChatBaseComponent;
import net.minecraft.IInventory;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.InventoryHolder;

public class PipeAnvilInventory extends PipeInventory implements AnvilInventory {

	public PipeAnvilInventory(IInventory ingridientsInventory, IInventory resultInventory) {
		super(new MinecraftAnvilInventory(ingridientsInventory, resultInventory));
	}

	@Override
	public InventoryType getType() {
		return InventoryType.ANVIL;
	}

	private static class MinecraftAnvilInventory implements IInventory {

		private IInventory ingridientsInventory;
		private IInventory resultinventory;

		public MinecraftAnvilInventory(IInventory ingridientsInventory, IInventory resultinventory) {
			this.ingridientsInventory = ingridientsInventory;
			this.resultinventory = resultinventory;
		}

		@Override
		public String getName() {
			return ingridientsInventory.getName();
		}

		@Override
		public boolean hasCustomName() {
			return ingridientsInventory.hasCustomName();
		}

		@Override
		public IChatBaseComponent getComponentName() {
			return ingridientsInventory.getComponentName();
		}

		@Override
		public int getSize() {
			return ingridientsInventory.getSize() + resultinventory.getSize();
		}

		@Override
		public net.minecraft.ItemStack getItem(int slot) {
			if (slot < ingridientsInventory.getSize()) {
				return ingridientsInventory.getItem(slot);
			} else {
				slot -= ingridientsInventory.getSize();
				return resultinventory.getItem(slot);
			}
		}

		@Override
		public net.minecraft.ItemStack splitStack(int slot, int splitSize) {
			return ingridientsInventory.splitStack(slot, splitSize);
		}

		@Override
		public net.minecraft.ItemStack splitWithoutUpdate(int slot) {
			return ingridientsInventory.splitWithoutUpdate(slot);
		}

		@Override
		public void setItem(int slot, net.minecraft.ItemStack itemStack) {
			if (slot < ingridientsInventory.getSize()) {
				ingridientsInventory.setItem(slot, itemStack);
			} else {
				slot -= ingridientsInventory.getSize();
				resultinventory.setItem(slot, itemStack);
			}
		}

		@Override
		public int getMaxStackSize() {
			return ingridientsInventory.getMaxStackSize();
		}

		@Override
		public void update() {
			ingridientsInventory.update();
		}

		@Override
		public boolean canInteract(EntityHuman who) {
			return ingridientsInventory.canInteract(who);
		}

		@Override
		public void onContainerOpen(EntityHuman who) {
			ingridientsInventory.onContainerOpen(who);
		}

		@Override
		public void onContainerClose(EntityHuman who) {
			ingridientsInventory.onContainerClose(who);
		}

		@Override
		public boolean canSuckItemFromInventory(int slot, net.minecraft.ItemStack itemStack) {
			return ingridientsInventory.canSuckItemFromInventory(slot, itemStack);
		}

		@Override
		public int getProperty(int propertyNumber) {
			return ingridientsInventory.getProperty(propertyNumber);
		}

		@Override
		public void readClientCustomInput(int powerSlot, int powerType) {
			ingridientsInventory.readClientCustomInput(powerSlot, powerType);
		}

		@Override
		public int getPropertiesCount() {
			return ingridientsInventory.getPropertiesCount();
		}

		@Override
		public void clearInventory() {
			ingridientsInventory.clearInventory();
			resultinventory.clearInventory();
		}

		@Override
		public List<EntityHuman> getViewers() {
			return ingridientsInventory.getViewers();
		}

		@Override
		public net.minecraft.ItemStack[] getItems() {
			net.minecraft.ItemStack[] items = new net.minecraft.ItemStack[getSize()];
			System.arraycopy(ingridientsInventory.getItems(), 0, items, 0, ingridientsInventory.getSize());
			System.arraycopy(resultinventory.getItems(), 0, items, ingridientsInventory.getSize(), resultinventory.getSize());
			return items;
		}

		@Override
		public InventoryHolder getHolder() {
			return ingridientsInventory.getHolder();
		}

	}

}
