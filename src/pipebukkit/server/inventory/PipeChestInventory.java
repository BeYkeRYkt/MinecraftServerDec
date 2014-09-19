package pipebukkit.server.inventory;

import net.minecraft.IInventory;

import org.bukkit.event.inventory.InventoryType;

public class PipeChestInventory extends PipeInventory {

	public PipeChestInventory(IInventory nmsInventory) {
		super(nmsInventory);
	}

	@Override
	public InventoryType getType() {
		return InventoryType.CHEST;
	}

}
