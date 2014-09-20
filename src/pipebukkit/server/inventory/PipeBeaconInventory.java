package pipebukkit.server.inventory;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.BeaconInventory;
import org.bukkit.inventory.ItemStack;

import net.minecraft.IInventory;

public class PipeBeaconInventory extends PipeInventory implements BeaconInventory {

	public PipeBeaconInventory(IInventory nmsInventory) {
		super(nmsInventory);
	}

	@Override
	public InventoryType getType() {
		return InventoryType.BEACON;
	}

	@Override
	public ItemStack getItem() {
		return getItem(0);
	}

	@Override
	public void setItem(ItemStack component) {
		setItem(0, component);
	}

}
