package pipebukkit.server.inventory;

import java.util.List;

import net.minecraft.EntityHuman;
import net.minecraft.IChatBaseComponent;
import net.minecraft.IInventory;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

public class PipeCraftingInventory extends PipeInventory implements CraftingInventory {

	public PipeCraftingInventory(IInventory ingridientsInventory, IInventory resultInventory) {
		super(new MinecraftCraftngInventory(ingridientsInventory, resultInventory));
	}

	@Override
	public ItemStack[] getMatrix() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Recipe getRecipe() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack getResult() {
		return new PipeItemStack(nmsInventory.getItem(0));
	}

	@Override
	public void setMatrix(ItemStack[] arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setResult(ItemStack itemStack) {
		nmsInventory.setItem(0, new PipeItemStack(itemStack).getHandle());
	}

	@Override
	public InventoryType getType() {
		return getSize() >= 9 ? InventoryType.WORKBENCH : InventoryType.CRAFTING;
	}

	private static class MinecraftCraftngInventory implements IInventory {

		private IInventory ingridientsInventory;
		private IInventory resultinventory;

		public MinecraftCraftngInventory(IInventory ingridientsInventory, IInventory resultinventory) {
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
			return ingridientsInventory.getSize() + 1;
		}

		@Override
		public net.minecraft.ItemStack getItem(int slot) {
			if (slot < resultinventory.getSize()) {
				return resultinventory.getItem(slot);
			} else {
				slot -= resultinventory.getSize();
				return ingridientsInventory.getItem(slot);
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
			if (slot < resultinventory.getSize()) {
				resultinventory.setItem(slot, itemStack);
			} else {
				slot -= resultinventory.getSize();
				ingridientsInventory.setItem(slot, itemStack);
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
			System.arraycopy(resultinventory.getItems(), 0, items, 0, resultinventory.getSize());
			System.arraycopy(ingridientsInventory.getItems(), 0, items, resultinventory.getSize(), ingridientsInventory.getSize());
			return items;
		}

		@Override
		public InventoryHolder getHolder() {
			return ingridientsInventory.getHolder();
		}

	}

}
