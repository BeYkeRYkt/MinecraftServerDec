package pipebukkit.server.inventory;

import org.bukkit.event.inventory.InventoryType;

import net.minecraft.IInventory;

public class PipeHopperInventory extends PipeInventory {

	public PipeHopperInventory(IInventory nmsInventory) {
		super(nmsInventory);
	}

	@Override
	public InventoryType getType() {
		return InventoryType.HOPPER;
	}

}
