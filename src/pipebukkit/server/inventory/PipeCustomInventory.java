package pipebukkit.server.inventory;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.InventoryHolder;

import net.minecraft.ChatComponentText;
import net.minecraft.ChatMessage;
import net.minecraft.EntityHuman;
import net.minecraft.IChatBaseComponent;
import net.minecraft.IInventory;
import net.minecraft.ItemStack;

public class PipeCustomInventory extends PipeInventory {

	private InventoryType type;

	public PipeCustomInventory(InventoryHolder holder, InventoryType type, int slots, String title) {
		super(new MinecraftCustomInventory(holder, type, slots, title));
		this.type = type;
	}

	@Override
	public InventoryType getType() {
		return type;
	}

	protected static class MinecraftCustomInventory implements IInventory {

		private InventoryType type;
		private ItemStack[] items;
		private String title;
		private int maxStackSize = 64;
		private List<EntityHuman> viewers = new ArrayList<EntityHuman>();
		private InventoryHolder holder;

		public MinecraftCustomInventory(InventoryHolder holder, InventoryType type, int slots, String title) {
			this.holder = holder;
			this.type = type;
			this.items = new ItemStack[slots];
			this.title = title;
		}

		@Override
		public String getName() {
			return title;
		}

		@Override
		public boolean hasCustomName() {
			return type.getDefaultTitle().equals(title);
		}

		@Override
		public IChatBaseComponent getComponentName() {
			return hasCustomName() ? new ChatComponentText(this.getName()) : new ChatMessage(this.getName());
		}

		@Override
		public int getSize() {
			return items.length;
		}

		@Override
		public ItemStack getItem(int slot) {
			return items[slot];
		}

		@Override
		public void setItem(int slot, ItemStack itemStack) {
			items[slot] = itemStack;
		}

		@Override
		public ItemStack splitStack(int slot, int splitSize) {
			ItemStack stack = getItem(slot);
			if (stack == null) {
				return null;
			}
			if (stack.getAmount() <= splitSize) {
				setItem(slot, null);
				return stack;
			} else {
				stack.setAmount(stack.getAmount() - splitSize);
				ItemStack result = stack.getCopy();
				result.setAmount(splitSize);
				return result;
			}
		}

		@Override
		public ItemStack splitWithoutUpdate(int slot) {
			return splitStack(slot, 1);
		}

		@Override
		public int getMaxStackSize() {
			return maxStackSize;
		}

		@Override
		public void update() {
		}

		@Override
		public boolean canInteract(EntityHuman who) {
			return true;
		}

		@Override
		public void onContainerOpen(EntityHuman who) {
			viewers.add(who);
		}

		@Override
		public void onContainerClose(EntityHuman who) {
			viewers.remove(who);
		}

		@Override
		public boolean canSuckItemFromInventory(int slot, ItemStack itemStack) {
			return false;
		}

		@Override
		public int getProperty(int property) {
			return 0;
		}

		@Override
		public void selectBeaconPower(int powerSlot, int powerType) {
		}

		@Override
		public int getPropertiesCount() {
			return 0;
		}

		@Override
		public void clearInventory() {
			for (int i = 0; i < items.length; i++) {
				setItem(i, null);
			}
		}

		@Override
		public List<EntityHuman> getViewers() {
			return viewers;
		}

		@Override
		public ItemStack[] getItems() {
			return items;
		}

		@Override
		public InventoryHolder getHolder() {
			return holder;
		}

	}

}
