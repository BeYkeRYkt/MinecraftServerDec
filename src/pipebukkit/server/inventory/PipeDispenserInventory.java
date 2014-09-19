package pipebukkit.server.inventory;

import org.bukkit.event.inventory.InventoryType;

import net.minecraft.IInventory;

public class PipeDispenserInventory extends PipeInventory {

	public PipeDispenserInventory(IInventory nmsInventory) {
		super(nmsInventory);
	}

	@Override
	public InventoryType getType() {
		return InventoryType.DISPENSER;
	}

}
