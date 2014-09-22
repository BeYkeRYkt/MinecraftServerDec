package pipebukkit.server.inventory;

import org.bukkit.event.inventory.InventoryType;

import net.minecraft.IInventory;

public class PipeEnderChestInventory extends PipeInventory {

	public PipeEnderChestInventory(IInventory nmsInventory) {
		super(nmsInventory);
	}

	@Override
	public InventoryType getType() {
		return InventoryType.ENDER_CHEST;
	}

}
