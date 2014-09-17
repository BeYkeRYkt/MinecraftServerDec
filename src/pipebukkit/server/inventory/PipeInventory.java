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

	private IInventory minecraftInventory;
	public PipeInventory(IInventory minecraftInventory) {
		this.minecraftInventory = minecraftInventory;
	}

	@Override
	public abstract InventoryType getType();

	@Override
	public HashMap<Integer, ItemStack> addItem(ItemStack... items) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<Integer, ? extends ItemStack> all(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<Integer, ? extends ItemStack> all(Material arg0) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<Integer, ? extends ItemStack> all(ItemStack arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		minecraftInventory.clearInventory();
	}

	@Override
	public void clear(int slot) {
		minecraftInventory.setItem(slot, null);
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
		net.minecraft.ItemStack[] nmsItems = minecraftInventory.getItems();
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
		net.minecraft.ItemStack[] nmsItems = minecraftInventory.getItems();
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int first(int id) {
		net.minecraft.ItemStack[] nmsItems = minecraftInventory.getItems();
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
		net.minecraft.ItemStack[] nmsItems = minecraftInventory.getItems();
		for (int i = 0; i < nmsItems.length; i++) {
			if (nmsItems[i] == null) {
				return i;
			}
		}
		return -1; 
	}

	@Override
	public ItemStack[] getContents() {
		net.minecraft.ItemStack[] nmsItems = minecraftInventory.getItems();
		ItemStack[] contents = new ItemStack[nmsItems.length];
		for (int i = 0; i < nmsItems.length; i++) {
			contents[i] = new PipeItemStack(nmsItems[i]);
		}
		return contents;
	}

	@Override
	public InventoryHolder getHolder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack getItem(int slot) {
		return new PipeItemStack(minecraftInventory.getItem(slot));
	}

	@Override
	public int getMaxStackSize() {
		return minecraftInventory.getMaxStackSize();
	}

	@Override
	public String getName() {
		return minecraftInventory.getName();
	}

	@Override
	public int getSize() {
		return minecraftInventory.getSize();
	}

	@Override
	public String getTitle() {
		return minecraftInventory.getName();
	}

	@Override
	public List<HumanEntity> getViewers() {
		return Collections.unmodifiableList(Lists.transform(minecraftInventory.getViewers(), new Function<EntityHuman, HumanEntity>() {
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
		net.minecraft.ItemStack[] nmsItems = minecraftInventory.getItems();
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
	public HashMap<Integer, ItemStack> removeItem(ItemStack... arg0) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setContents(ItemStack[] arg0) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setItem(int slot, ItemStack itemStack) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMaxStackSize(int arg0) {
		// TODO Auto-generated method stub

	}

}
