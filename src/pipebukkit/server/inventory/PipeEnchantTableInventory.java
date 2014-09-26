package pipebukkit.server.inventory;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.EnchantingInventory;
import org.bukkit.inventory.ItemStack;

import net.minecraft.IInventory;

public class PipeEnchantTableInventory extends PipeInventory implements EnchantingInventory {

	public PipeEnchantTableInventory(IInventory nmsInventory) {
		super(nmsInventory);
	}

	@Override
	public InventoryType getType() {
		return InventoryType.ENCHANTING;
	}

	@Override
	public ItemStack getItem() {
		return getItem(0);
	}

	@Override
	public void setItem(ItemStack itemStack) {
		setItem(0, itemStack);
	}

}
