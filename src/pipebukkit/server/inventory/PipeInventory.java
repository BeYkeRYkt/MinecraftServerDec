package pipebukkit.server.inventory;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

import net.minecraft.EntityHuman;
import net.minecraft.IInventory;
import net.minecraft.Item;

import org.apache.commons.lang.Validate;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

public abstract class PipeInventory implements Inventory {

	private IInventory nmsInventory;
	public PipeInventory(IInventory minecraftInventory) {
		this.nmsInventory = minecraftInventory;
	}

	@Override
	public abstract InventoryType getType();

	@Override
	public HashMap<Integer, ItemStack> addItem(ItemStack... items) throws IllegalArgumentException {
		Validate.notNull(items, "Items cannot be null");
		HashMap<Integer, ItemStack> left = new HashMap<Integer, ItemStack>();
		ItemStack[] contents = getContents();
		for (int i = 0; i < contents.length; i++) {
			ItemStack inventoryItemStack = contents[i];
			if (inventoryItemStack != null) {
				for (ItemStack inputItemStack : items) {
					if (inputItemStack == null || inputItemStack.getAmount() <= 0) {
						continue;
					}
					if (inputItemStack.isSimilar(inventoryItemStack)) {
						int addAmount = inputItemStack.getAmount();
						int hasAmount = inventoryItemStack.getAmount();
						if (hasAmount + addAmount <= inventoryItemStack.getMaxStackSize()) {
							inventoryItemStack.setAmount(hasAmount + addAmount);
							inputItemStack.setAmount(0);
						} else {
							inventoryItemStack.setAmount(inventoryItemStack.getMaxStackSize());
							inputItemStack.setAmount(addAmount - (inventoryItemStack.getMaxStackSize() - hasAmount));
						}
					}
				}
			}
		}
		for (int i = 0; i < contents.length; i++) {
			if (contents[i] != null) {
				continue;
			}
			for (ItemStack inputItemStack : items) {
				if (inputItemStack == null || inputItemStack.getAmount() <= 0) {
					continue;
				}
				ItemStack newStack = new PipeItemStack(inputItemStack);
				if (inputItemStack.getAmount() < getMaxStackSize()) {
					setItem(i, newStack);
					inputItemStack.setAmount(0);
				} else {
					newStack.setAmount(getMaxStackSize());
					setItem(i, newStack);
					inputItemStack.setAmount(inputItemStack.getAmount() - getMaxStackSize());
				}
				break;
			}
		}
		for (int i = 0; i < items.length; i++) {
			if (items[i] != null && items[i].getAmount() > 0) {
				left.put(i, items[i]);
			}
		}
		return left;
	}

	@SuppressWarnings("deprecation")
	@Override
	public HashMap<Integer, ? extends ItemStack> all(int id) {
		HashMap<Integer, ItemStack> all = new HashMap<Integer, ItemStack>();
		ItemStack[] contents = getContents();
		for (int i = 0; i < contents.length; i++) {
			if (contents[i] != null && contents[i].getTypeId() == id) {
				all.put(i, contents[i]);
			}
		}
		return all;
	}

	@SuppressWarnings("deprecation")
	@Override
	public HashMap<Integer, ? extends ItemStack> all(Material  material) throws IllegalArgumentException {
		return all(material.getId());
	}

	@Override
	public HashMap<Integer, ? extends ItemStack> all(ItemStack itemStack) {
		HashMap<Integer, ItemStack> all = new HashMap<Integer, ItemStack>();
		ItemStack[] contents = getContents();
		for (int i = 0; i < contents.length; i++) {
			if (contents[i] != null && contents[i].equals(itemStack)) {
				all.put(i, contents[i]);
			}
		}
		return all;
	}

	@Override
	public void clear() {
		nmsInventory.clearInventory();
	}

	@Override
	public void clear(int slot) {
		nmsInventory.setItem(slot, null);
	}

	@Override
	public boolean contains(ItemStack itemStack) {
		ItemStack[] contents = getContents();
		for (int i = 0; i < contents.length; i++) {
			if (contents[i] != null && contents[i].equals(itemStack)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean contains(int id) {
		net.minecraft.ItemStack[] nmsItems = nmsInventory.getItems();
		for (int i = 0; i < nmsItems.length; i++) {
			if (nmsItems[i] != null && Item.getId(nmsItems[i].getItem()) == id) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean contains(Material material) throws IllegalArgumentException {
		return contains(material.getId());
	}

	@Override
	public boolean contains(int id, int amount) {
		net.minecraft.ItemStack[] nmsItems = nmsInventory.getItems();
		for (int i = 0; i < nmsItems.length; i++) {
			if (nmsItems[i] != null && Item.getId(nmsItems[i].getItem()) == id && nmsItems[i].getAmount() >= amount) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean contains(Material material, int amount) throws IllegalArgumentException {
		return contains(material.getId(), amount);
	}

	@Override
	public boolean contains(ItemStack itemStack, int amount) {
		ItemStack[] contents = getContents();
		for (int i = 0; i < contents.length; i++) {
			if (contents[i] != null && contents[i].equals(itemStack) && contents[i].getAmount() >= amount) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsAtLeast(ItemStack itemStack, int amount) {
		ItemStack[] contents = getContents();
		for (int i = 0; i < contents.length; i++) {
			if (contents[i] != null && contents[i].isSimilar(itemStack)) {
				amount -= contents[i].getAmount();
				if (amount <= 0) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public int first(int id) {
		net.minecraft.ItemStack[] nmsItems = nmsInventory.getItems();
		for (int i = 0; i < nmsItems.length; i++) {
			if (nmsItems[i] != null && Item.getId(nmsItems[i].getItem()) == id) {
				return i;
			}
		}
		return -1;
	}

	@SuppressWarnings("deprecation")
	@Override
	public int first(Material material) throws IllegalArgumentException {
		return first(material.getId());
	}

	@Override
	public int first(ItemStack itemStack) {
		ItemStack[] contents = getContents();
		for (int i = 0; i < contents.length; i++) {
			if (contents[i] != null && contents[i].equals(itemStack)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public int firstEmpty() {
		net.minecraft.ItemStack[] nmsItems = nmsInventory.getItems();
		for (int i = 0; i < nmsItems.length; i++) {
			if (nmsItems[i] == null) {
				return i;
			}
		}
		return -1; 
	}

	@Override
	public ItemStack[] getContents() {
		net.minecraft.ItemStack[] nmsItems = nmsInventory.getItems();
		ItemStack[] contents = new ItemStack[nmsItems.length];
		for (int i = 0; i < nmsItems.length; i++) {
			contents[i] = new PipeItemStack(nmsItems[i]);
		}
		return contents;
	}

	@Override
	public InventoryHolder getHolder() {
		return nmsInventory.getHolder();
	}

	@Override
	public ItemStack getItem(int slot) {
		return new PipeItemStack(nmsInventory.getItem(slot));
	}

	@Override
	public int getMaxStackSize() {
		return nmsInventory.getMaxStackSize();
	}

	@Override
	public String getName() {
		return nmsInventory.getName();
	}

	@Override
	public int getSize() {
		return nmsInventory.getSize();
	}

	@Override
	public String getTitle() {
		return nmsInventory.getName();
	}

	@Override
	public List<HumanEntity> getViewers() {
		return Collections.unmodifiableList(Lists.transform(nmsInventory.getViewers(), new Function<EntityHuman, HumanEntity>() {
			@Override
			public HumanEntity apply(EntityHuman human) {
				return human.getBukkitEntity(HumanEntity.class);
			}	
		}));
	}

	@Override
	public ListIterator<ItemStack> iterator() {
		return new InventoryIterator(this);
	}

	@Override
	public ListIterator<ItemStack> iterator(int index) {
		if (index < 0) {
			index += getSize() + 1;
		}
		return new InventoryIterator(this, index);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void remove(Material material) throws IllegalArgumentException {
		Validate.notNull(material, "Material cannot be null");
		remove(material.getId());
	}

	@Override
	public void remove(int id) {
		net.minecraft.ItemStack[] nmsItems = nmsInventory.getItems();
		for (int i = 0; i < nmsItems.length; i++) {
			if (nmsItems[i] != null && Item.getId(nmsItems[i].getItem()) == id) {
				clear(i);
			}
		}
	}

	@Override
	public void remove(ItemStack itemStack) {
		ItemStack[] contents = getContents();
		for (int i = 0; i < contents.length; i++) {
			if (contents[i] != null && contents[i].equals(itemStack)) {
				clear(i);
			}
		}
	}

	@Override
	public HashMap<Integer, ItemStack> removeItem(ItemStack... items) throws IllegalArgumentException {
		Validate.notNull(items, "Items cannot be null");
		HashMap<Integer, ItemStack> left = new HashMap<Integer, ItemStack>();
		ItemStack[] contents = getContents();
		for (int i = 0; i < contents.length; i++) {
			ItemStack inventoryItemStack = contents[i];
			if (inventoryItemStack != null) {
				for (ItemStack inputItemStack : items) {
					if (inputItemStack == null || inputItemStack.getAmount() <= 0) {
						continue;
					}
					if (inputItemStack.isSimilar(inventoryItemStack)) {
						int deleteAmount = inputItemStack.getAmount();
						int hasAmount = inventoryItemStack.getAmount();
						if (hasAmount <= deleteAmount) {
							inputItemStack.setAmount(deleteAmount - hasAmount);
							clear(i);
						} else {
							inputItemStack.setAmount(0);
							inventoryItemStack.setAmount(hasAmount - deleteAmount);
						}
					}
				}
			}
		}
		for (int i = 0; i < items.length; i++) {
			if (items[i] != null && items[i].getAmount() > 0) {
				left.put(i, items[i]);
			}
		}
		return left;
	}

	@Override
	public void setContents(ItemStack[] items) throws IllegalArgumentException {
		for (int i = 0; i < getSize() && i < items.length; i++) {
			nmsInventory.setItem(i, new PipeItemStack(items[i]).getHandle());
		}
	}

	@Override
	public void setItem(int slot, ItemStack itemStack) {
		nmsInventory.setItem(slot, new PipeItemStack(itemStack).getHandle());
	}

	@Override
	public void setMaxStackSize(int maxStackSize) {
	}

	@Override
	public int hashCode() {
		return nmsInventory.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof PipeInventory)) {
			return false;
		}
		return ((PipeInventory) obj).nmsInventory.equals(nmsInventory);
	}

}
