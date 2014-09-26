package pipebukkit.server.inventory;

import java.util.ListIterator;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryIterator implements ListIterator<ItemStack> {

	private Inventory inventory;
	private int index;
	private byte direction = 1;

	public InventoryIterator(Inventory inventory) {
		this(inventory, 0);
	}

	public InventoryIterator(Inventory inventory, int index) {
		this.inventory = inventory;
		this.index = index;
	}

	@Override
	public boolean hasNext() {
		return index < inventory.getSize() - 1;
	}
	@Override
	public ItemStack next() {
		direction = -1;
		return inventory.getItem(index++);
	}
	@Override
	public boolean hasPrevious() {
		return index > 0;
	}

	@Override
	public ItemStack previous() {
		direction = 0;
		return inventory.getItem(--index);
	}

	@Override
	public int nextIndex() {
		return index;
	}
	@Override
	public int previousIndex() {
		return index - 1;
	}

	@Override
	public void set(ItemStack itemStack) {
		if (direction == 1) {
			throw new IllegalStateException("No current item!");
		}
		inventory.setItem(index + direction, itemStack);
	}

	@Override
	public void add(ItemStack e) {
		throw new UnsupportedOperationException("Can't change the size of an inventory!");
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("Can't change the size of an inventory!");
	}

}
