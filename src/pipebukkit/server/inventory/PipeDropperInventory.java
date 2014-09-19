package pipebukkit.server.inventory;

import org.bukkit.event.inventory.InventoryType;

import net.minecraft.IInventory;

public class PipeDropperInventory extends PipeInventory {

	public PipeDropperInventory(IInventory nmsInventory) {
		super(nmsInventory);
	}

	@Override
	public InventoryType getType() {
		return InventoryType.DROPPER;
	}

}
