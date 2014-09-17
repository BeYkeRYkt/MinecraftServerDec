package pipebukkit.server.inventory;

import java.util.Map;

import net.minecraft.Item;
import net.minecraft.NBTCompoundTag;

import org.apache.commons.lang.Validate;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PipeItemStack extends ItemStack {

	private net.minecraft.ItemStack handle;

	public PipeItemStack(net.minecraft.ItemStack handle) {
		this.handle = handle;
	}

	@Override
	public int getTypeId() {
		return handle != null ? Item.getId(handle.getItem()) : 0;
	}

	@Override
	public void setTypeId(int type) {
		if (getTypeId() == type) {
			return;
		} else if (type == 0 || Item.getById(type) == null) {
			handle = null;
		} else if (handle == null) {
			handle = new net.minecraft.ItemStack(Item.getById(type), 1, 0);
		} else {
			handle.setItem(Item.getById(type));
		}
		handle.setWearout(0);
	}

	@Override
	public int getAmount() {
		return handle != null ? handle.getAmount() : 0;
	}

	@Override
	public void setAmount(int amount) {
		if (handle == null) {
			return;
		}
		if (amount <= 0) {
			handle = null;
		} else {
			handle.setAmount(amount);
		}
	}

	@Override
	public void setDurability(short durability) {
		if (handle != null) {
			handle.setWearout(durability);
		}
	}

	@Override
	public short getDurability() {
		if (handle != null) {
			return (short) handle.getWearout();
		} else {
			return -1;
		}
	}

	@Override
	public int getMaxStackSize() {
		return (handle == null) ? Material.AIR.getMaxStackSize() : handle.getItem().getMaxStackSize();
	}

	@Override
	public void addUnsafeEnchantment(Enchantment ench, int level) {
		Validate.notNull(ench, "Cannot add null enchantment");
		if (!makeTag(handle)) {
			return;
		}
		//TODO
	}

	private boolean makeTag(net.minecraft.ItemStack itemStack) {
		if (itemStack == null) {
			return false;
		}
		if (itemStack.getTag() == null) {
			itemStack.setTag(new NBTCompoundTag());
		}
		return true;
	}

	@Override
	public boolean containsEnchantment(Enchantment ench) {
		return getEnchantmentLevel(ench) > 0;
	}

	@Override
	public int getEnchantmentLevel(Enchantment ench) {
		Validate.notNull(ench, "Cannot find null enchantment");
		if (handle == null) {
			return 0;
		}
		//TODO
		return 0;
	}

	@Override
	public int removeEnchantment(Enchantment ench) {
		Validate.notNull(ench, "Cannot remove null enchantment");
		//TODO
		return 0;
	}

	@Override
	public Map<Enchantment, Integer> getEnchantments() {
		//TODO
		return null;
	}

	@Override
	public PipeItemStack clone() {
		PipeItemStack itemStack = (PipeItemStack) super.clone();
		if (this.handle != null) {
			itemStack.handle = this.handle.getCopy();
		}
		return itemStack;
	}

	@Override
	public ItemMeta getItemMeta() {
		//TODO
		return null;
	}

	@Override
	public boolean setItemMeta(ItemMeta itemMeta) {
		//TODO
		return false;
	}

	@Override
	public boolean isSimilar(ItemStack stack) {
		if (stack == null) {
			return false;
		}
		if (stack == this) {
			return true;
		}
		if (!(stack instanceof PipeItemStack)) {
			return stack.getClass() == ItemStack.class && stack.isSimilar(this);
		}
		PipeItemStack that = (PipeItemStack) stack;
		if (handle == that.handle) {
			return true;
		}
		if (handle == null || that.handle == null) {
			return false;
		}
		if (!(that.getTypeId() == getTypeId() && getDurability() == that.getDurability())) {
			return false;
		}
		return hasItemMeta() ? that.hasItemMeta() && handle.getTag().equals(that.handle.getTag()) : !that.hasItemMeta();
	}

	@Override
	public boolean hasItemMeta() {
		//TODO
		return false;
	}

}
